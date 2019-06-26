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

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;

public final class CamelCdiJUnit5ExtensionStore {

    private static final String TEST_CLASS_WELD_BUILDER_STORE_KEY = "TEST_CLASS_WELD_BUILDER_STORE_KEY";
    private static final String TEST_INSTANCE_WELD_CONTAINER_STORE_KEY = "TEST_INSTANCE_WELD_CONTAINER_STORE_KEY";

    private CamelCdiJUnit5ExtensionStore() {
    }

    static void putWeldBuilderInStore(ExtensionContext eCtx, Weld weld) {
        Namespace ns = Namespace.create(CamelCdiJUnit5ExtensionStore.class, eCtx.getRequiredTestClass());
        eCtx.getStore(ns).put(TEST_CLASS_WELD_BUILDER_STORE_KEY, weld);
    }

    static Weld getWeldBuilderFromStore(ExtensionContext eCtx) {
        Namespace ns = Namespace.create(CamelCdiJUnit5ExtensionStore.class, eCtx.getRequiredTestClass());
        return eCtx.getStore(ns).get(TEST_CLASS_WELD_BUILDER_STORE_KEY, Weld.class);
    }

    static void putWeldContainerInStore(ExtensionContext eCtx, Object testInstance, WeldContainer container) {
        Namespace ns = Namespace.create(CamelCdiJUnit5ExtensionStore.class, testInstance);
        eCtx.getStore(ns).put(TEST_INSTANCE_WELD_CONTAINER_STORE_KEY, container);
    }

    static WeldContainer getWeldContainerFromStore(ExtensionContext eCtx, Object testInstance) {
        Namespace ns = Namespace.create(CamelCdiJUnit5ExtensionStore.class, testInstance);
        return eCtx.getStore(ns).get(TEST_INSTANCE_WELD_CONTAINER_STORE_KEY, WeldContainer.class);
    }

}
