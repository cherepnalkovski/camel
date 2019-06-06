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

import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.model.ModelCamelContext;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

// @TODO: Is it really the same treatment for all types ?
// @TODO: Can't we get more than one object of type ProducerTemplate ? like threadTemplate ?
public class CamelTestParameterResolver implements ParameterResolver {

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        // @TODO: clearer is better
        Class<?> paramClass = parameterContext.getParameter().getType();
        return paramClass == ProducerTemplate.class || paramClass == ConsumerTemplate.class || paramClass == ModelCamelContext.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        final Class<?> paramClass = parameterContext.getParameter().getType();
        if (paramClass == ProducerTemplate.class) {
            // @TODO: Is it safe to use class as store keys
            return extensionContext.getStore(Namespace.create(CamelTestParameterResolver.class)).get(ProducerTemplate.class);
        } else if (paramClass == ConsumerTemplate.class) {
            // @TODO: Is it safe to use class as store keys
            return extensionContext.getStore(Namespace.create(CamelTestParameterResolver.class)).get(ConsumerTemplate.class);
        } else if (paramClass == ModelCamelContext.class) {
            // @TODO: Is it safe to use class as store keys
            return extensionContext.getStore(Namespace.create(CamelTestParameterResolver.class)).get(ModelCamelContext.class);
        }
        final String msgFormat = "Test %s can't receive a parameter of type %s. Expecting Context, ProduderTempate or ConsumerTemplate}";
        throw new ParameterResolutionException(String.format(msgFormat, extensionContext.getDisplayName(), paramClass.getName()));
    }
}
