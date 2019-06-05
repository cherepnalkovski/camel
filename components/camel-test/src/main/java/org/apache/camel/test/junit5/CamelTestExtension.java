/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.test.junit5;

import java.lang.reflect.Method;
import java.util.Optional;

import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.engine.DefaultCamelBeanPostProcessor;
import org.apache.camel.model.ModelCamelContext;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.platform.commons.util.ReflectionUtils;

public class CamelTestExtension implements BeforeEachCallback, AfterEachCallback {

    private ModelCamelContext context;
    private ProducerTemplate producerTemplate;
    private ConsumerTemplate consumerTemplate;

    @Override
    public void afterEach(ExtensionContext eCtx) throws Exception {
        if (producerTemplate != null) {
            producerTemplate.stop();
        }
        if (consumerTemplate != null) {
            consumerTemplate.stop();
        }
        if (context != null) {
            context.stop();
        }
    }

    @Override
    public void beforeEach(ExtensionContext eCtx) throws Exception {
        context = new DefaultCamelContext();

        Optional<Method> method = ReflectionUtils.findMethod(eCtx.getTestClass().get(), "createRouteBuilder");

        Object ret = ReflectionUtils.invokeMethod(method.get(), eCtx.getTestInstance().get());
        if (ret instanceof RoutesBuilder) {
            ((RoutesBuilder)ret).addRoutesToCamelContext(context);
        }
        producerTemplate = context.createProducerTemplate();
        consumerTemplate = context.createConsumerTemplate();

        DefaultCamelBeanPostProcessor processor = new DefaultCamelBeanPostProcessor(context);
        processor.postProcessBeforeInitialization(this, getClass().getName());
        processor.postProcessAfterInitialization(this, getClass().getName());

        context.start();
        producerTemplate.start();
        consumerTemplate.start();

        // @TODO: Do we really use a namespace with key
        // CamelTestParameterResolver.class
        // We may reuse those values in test also
        eCtx.getStore(Namespace.create(CamelTestParameterResolver.class)).put(ModelCamelContext.class, context);
        eCtx.getStore(Namespace.create(CamelTestParameterResolver.class)).put(ProducerTemplate.class, producerTemplate);
        eCtx.getStore(Namespace.create(CamelTestParameterResolver.class)).put(ConsumerTemplate.class, consumerTemplate);
    }

}
