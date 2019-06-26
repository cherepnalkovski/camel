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
package org.apache.camel.test.cdi.junit5;

import java.util.Set;

import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;

import org.apache.camel.cdi.CdiCamelExtension;
import org.jboss.weld.config.ConfigurationKey;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstanceFactory;
import org.junit.jupiter.api.extension.TestInstanceFactoryContext;
import org.junit.jupiter.api.extension.TestInstantiationException;

import static org.apache.camel.test.cdi.junit5.CamelCdiJUnit5ExtensionStore.getWeldBuilderFromStore;
import static org.apache.camel.test.cdi.junit5.CamelCdiJUnit5ExtensionStore.getWeldContainerFromStore;
import static org.apache.camel.test.cdi.junit5.CamelCdiJUnit5ExtensionStore.putWeldBuilderInStore;
import static org.apache.camel.test.cdi.junit5.CamelCdiJUnit5ExtensionStore.putWeldContainerInStore;

public class CamelCdiJUnit5Extension implements BeforeAllCallback, AfterEachCallback, TestInstanceFactory {

    @Override
    public void beforeAll(ExtensionContext eCtx) throws Exception {
        Class<?> testClass = eCtx.getRequiredTestClass();
        Weld weld = new Weld()
            // TODO: check parallel execution
            .containerId("camel-context-cdi").property(ConfigurationKey.RELAXED_CONSTRUCTION.get(), true).property(Weld.SHUTDOWN_HOOK_SYSTEM_PROPERTY, false).enableDiscovery()
            .beanClasses(testClass.getDeclaredClasses()).addBeanClass(testClass).addExtension(new CdiCamelExtension());

        putWeldBuilderInStore(eCtx, weld);
    }

    @Override
    public void afterEach(ExtensionContext eCtx) throws Exception {
        WeldContainer container = getWeldContainerFromStore(eCtx, eCtx.getRequiredTestInstance());
        container.shutdown();
    }

    @Override
    public Object createTestInstance(TestInstanceFactoryContext factoryContext, ExtensionContext eCtx) throws TestInstantiationException {
        WeldContainer container = getWeldBuilderFromStore(eCtx).initialize();
        BeanManager manager = container.getBeanManager();
        Set<Bean<?>> beans = manager.getBeans(eCtx.getRequiredTestClass(), AnyLiteral.INSTANCE);
        Bean<?> bean = beans.iterator().next();
        Object testInstance = manager.getReference(bean, bean.getBeanClass(), manager.createCreationalContext(bean));

        putWeldContainerInStore(eCtx, testInstance, container);

        return testInstance;
    }
}
