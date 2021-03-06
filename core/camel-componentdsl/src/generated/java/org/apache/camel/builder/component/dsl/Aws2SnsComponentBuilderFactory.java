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
package org.apache.camel.builder.component.dsl;

import javax.annotation.Generated;
import org.apache.camel.Component;
import org.apache.camel.builder.component.AbstractComponentBuilder;
import org.apache.camel.builder.component.ComponentBuilder;
import org.apache.camel.component.aws2.sns.Sns2Component;

/**
 * Send messages to an AWS Simple Notification Topic using AWS SDK version 2.x.
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@Generated("org.apache.camel.maven.packaging.ComponentDslMojo")
public interface Aws2SnsComponentBuilderFactory {

    /**
     * AWS 2 Simple Notification System (SNS) (camel-aws2-sns)
     * Send messages to an AWS Simple Notification Topic using AWS SDK version
     * 2.x.
     * 
     * Category: cloud,messaging,mobile
     * Since: 3.1
     * Maven coordinates: org.apache.camel:camel-aws2-sns
     */
    static Aws2SnsComponentBuilder aws2Sns() {
        return new Aws2SnsComponentBuilderImpl();
    }

    /**
     * Builder for the AWS 2 Simple Notification System (SNS) component.
     */
    interface Aws2SnsComponentBuilder extends ComponentBuilder<Sns2Component> {
        /**
         * To use the AmazonSNS as the client.
         * 
         * The option is a:
         * <code>software.amazon.awssdk.services.sns.SnsClient</code> type.
         * 
         * Group: producer
         */
        default Aws2SnsComponentBuilder amazonSNSClient(
                software.amazon.awssdk.services.sns.SnsClient amazonSNSClient) {
            doSetProperty("amazonSNSClient", amazonSNSClient);
            return this;
        }
        /**
         * Setting the autocreation of the topic.
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Default: true
         * Group: producer
         */
        default Aws2SnsComponentBuilder autoCreateTopic(boolean autoCreateTopic) {
            doSetProperty("autoCreateTopic", autoCreateTopic);
            return this;
        }
        /**
         * Setting the autoDiscoverClient mechanism, if true, the component will
         * look for a client instance in the registry automatically otherwise it
         * will skip that checking.
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Default: true
         * Group: common
         */
        default Aws2SnsComponentBuilder autoDiscoverClient(
                boolean autoDiscoverClient) {
            doSetProperty("autoDiscoverClient", autoDiscoverClient);
            return this;
        }
        /**
         * Component configuration.
         * 
         * The option is a:
         * <code>org.apache.camel.component.aws2.sns.Sns2Configuration</code>
         * type.
         * 
         * Group: producer
         */
        default Aws2SnsComponentBuilder configuration(
                org.apache.camel.component.aws2.sns.Sns2Configuration configuration) {
            doSetProperty("configuration", configuration);
            return this;
        }
        /**
         * The ID of an AWS-managed customer master key (CMK) for Amazon SNS or
         * a custom CMK.
         * 
         * The option is a: <code>java.lang.String</code> type.
         * 
         * Group: producer
         */
        default Aws2SnsComponentBuilder kmsMasterKeyId(
                java.lang.String kmsMasterKeyId) {
            doSetProperty("kmsMasterKeyId", kmsMasterKeyId);
            return this;
        }
        /**
         * Whether the producer should be started lazy (on the first message).
         * By starting lazy you can use this to allow CamelContext and routes to
         * startup in situations where a producer may otherwise fail during
         * starting and cause the route to fail being started. By deferring this
         * startup to be lazy then the startup failure can be handled during
         * routing messages via Camel's routing error handlers. Beware that when
         * the first message is processed then creating and starting the
         * producer may take a little time and prolong the total processing time
         * of the processing.
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Default: false
         * Group: producer
         */
        default Aws2SnsComponentBuilder lazyStartProducer(
                boolean lazyStartProducer) {
            doSetProperty("lazyStartProducer", lazyStartProducer);
            return this;
        }
        /**
         * The message structure to use such as json.
         * 
         * The option is a: <code>java.lang.String</code> type.
         * 
         * Group: producer
         */
        default Aws2SnsComponentBuilder messageStructure(
                java.lang.String messageStructure) {
            doSetProperty("messageStructure", messageStructure);
            return this;
        }
        /**
         * The policy for this queue.
         * 
         * The option is a: <code>java.lang.String</code> type.
         * 
         * Group: producer
         */
        default Aws2SnsComponentBuilder policy(java.lang.String policy) {
            doSetProperty("policy", policy);
            return this;
        }
        /**
         * To define a proxy host when instantiating the SNS client.
         * 
         * The option is a: <code>java.lang.String</code> type.
         * 
         * Group: producer
         */
        default Aws2SnsComponentBuilder proxyHost(java.lang.String proxyHost) {
            doSetProperty("proxyHost", proxyHost);
            return this;
        }
        /**
         * To define a proxy port when instantiating the SNS client.
         * 
         * The option is a: <code>java.lang.Integer</code> type.
         * 
         * Group: producer
         */
        default Aws2SnsComponentBuilder proxyPort(java.lang.Integer proxyPort) {
            doSetProperty("proxyPort", proxyPort);
            return this;
        }
        /**
         * To define a proxy protocol when instantiating the SNS client.
         * 
         * The option is a: <code>software.amazon.awssdk.core.Protocol</code>
         * type.
         * 
         * Default: HTTPS
         * Group: producer
         */
        default Aws2SnsComponentBuilder proxyProtocol(
                software.amazon.awssdk.core.Protocol proxyProtocol) {
            doSetProperty("proxyProtocol", proxyProtocol);
            return this;
        }
        /**
         * The queueUrl to subscribe to.
         * 
         * The option is a: <code>java.lang.String</code> type.
         * 
         * Group: producer
         */
        default Aws2SnsComponentBuilder queueUrl(java.lang.String queueUrl) {
            doSetProperty("queueUrl", queueUrl);
            return this;
        }
        /**
         * The region in which SNS client needs to work. When using this
         * parameter, the configuration will expect the lowercase name of the
         * region (for example ap-east-1) You'll need to use the name
         * Region.EU_WEST_1.id().
         * 
         * The option is a: <code>java.lang.String</code> type.
         * 
         * Group: producer
         */
        default Aws2SnsComponentBuilder region(java.lang.String region) {
            doSetProperty("region", region);
            return this;
        }
        /**
         * Define if Server Side Encryption is enabled or not on the topic.
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Default: false
         * Group: producer
         */
        default Aws2SnsComponentBuilder serverSideEncryptionEnabled(
                boolean serverSideEncryptionEnabled) {
            doSetProperty("serverSideEncryptionEnabled", serverSideEncryptionEnabled);
            return this;
        }
        /**
         * The subject which is used if the message header 'CamelAwsSnsSubject'
         * is not present.
         * 
         * The option is a: <code>java.lang.String</code> type.
         * 
         * Group: producer
         */
        default Aws2SnsComponentBuilder subject(java.lang.String subject) {
            doSetProperty("subject", subject);
            return this;
        }
        /**
         * Define if the subscription between SNS Topic and SQS must be done or
         * not.
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Default: false
         * Group: producer
         */
        default Aws2SnsComponentBuilder subscribeSNStoSQS(
                boolean subscribeSNStoSQS) {
            doSetProperty("subscribeSNStoSQS", subscribeSNStoSQS);
            return this;
        }
        /**
         * If we want to trust all certificates in case of overriding the
         * endpoint.
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Default: false
         * Group: producer
         */
        default Aws2SnsComponentBuilder trustAllCertificates(
                boolean trustAllCertificates) {
            doSetProperty("trustAllCertificates", trustAllCertificates);
            return this;
        }
        /**
         * Set whether the SQS client should expect to load credentials on an
         * AWS infra instance or to expect static credentials to be passed in.
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Default: false
         * Group: producer
         */
        default Aws2SnsComponentBuilder useIAMCredentials(
                boolean useIAMCredentials) {
            doSetProperty("useIAMCredentials", useIAMCredentials);
            return this;
        }
        /**
         * Whether the component should use basic property binding (Camel 2.x)
         * or the newer property binding with additional capabilities.
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Default: false
         * Group: advanced
         */
        @Deprecated
        default Aws2SnsComponentBuilder basicPropertyBinding(
                boolean basicPropertyBinding) {
            doSetProperty("basicPropertyBinding", basicPropertyBinding);
            return this;
        }
        /**
         * Amazon AWS Access Key.
         * 
         * The option is a: <code>java.lang.String</code> type.
         * 
         * Group: security
         */
        default Aws2SnsComponentBuilder accessKey(java.lang.String accessKey) {
            doSetProperty("accessKey", accessKey);
            return this;
        }
        /**
         * Amazon AWS Secret Key.
         * 
         * The option is a: <code>java.lang.String</code> type.
         * 
         * Group: security
         */
        default Aws2SnsComponentBuilder secretKey(java.lang.String secretKey) {
            doSetProperty("secretKey", secretKey);
            return this;
        }
    }

    class Aws2SnsComponentBuilderImpl
            extends
                AbstractComponentBuilder<Sns2Component>
            implements
                Aws2SnsComponentBuilder {
        @Override
        protected Sns2Component buildConcreteComponent() {
            return new Sns2Component();
        }
        private org.apache.camel.component.aws2.sns.Sns2Configuration getOrCreateConfiguration(
                org.apache.camel.component.aws2.sns.Sns2Component component) {
            if (component.getConfiguration() == null) {
                component.setConfiguration(new org.apache.camel.component.aws2.sns.Sns2Configuration());
            }
            return component.getConfiguration();
        }
        @Override
        protected boolean setPropertyOnComponent(
                Component component,
                String name,
                Object value) {
            switch (name) {
            case "amazonSNSClient": getOrCreateConfiguration((Sns2Component) component).setAmazonSNSClient((software.amazon.awssdk.services.sns.SnsClient) value); return true;
            case "autoCreateTopic": getOrCreateConfiguration((Sns2Component) component).setAutoCreateTopic((boolean) value); return true;
            case "autoDiscoverClient": getOrCreateConfiguration((Sns2Component) component).setAutoDiscoverClient((boolean) value); return true;
            case "configuration": ((Sns2Component) component).setConfiguration((org.apache.camel.component.aws2.sns.Sns2Configuration) value); return true;
            case "kmsMasterKeyId": getOrCreateConfiguration((Sns2Component) component).setKmsMasterKeyId((java.lang.String) value); return true;
            case "lazyStartProducer": ((Sns2Component) component).setLazyStartProducer((boolean) value); return true;
            case "messageStructure": getOrCreateConfiguration((Sns2Component) component).setMessageStructure((java.lang.String) value); return true;
            case "policy": getOrCreateConfiguration((Sns2Component) component).setPolicy((java.lang.String) value); return true;
            case "proxyHost": getOrCreateConfiguration((Sns2Component) component).setProxyHost((java.lang.String) value); return true;
            case "proxyPort": getOrCreateConfiguration((Sns2Component) component).setProxyPort((java.lang.Integer) value); return true;
            case "proxyProtocol": getOrCreateConfiguration((Sns2Component) component).setProxyProtocol((software.amazon.awssdk.core.Protocol) value); return true;
            case "queueUrl": getOrCreateConfiguration((Sns2Component) component).setQueueUrl((java.lang.String) value); return true;
            case "region": getOrCreateConfiguration((Sns2Component) component).setRegion((java.lang.String) value); return true;
            case "serverSideEncryptionEnabled": getOrCreateConfiguration((Sns2Component) component).setServerSideEncryptionEnabled((boolean) value); return true;
            case "subject": getOrCreateConfiguration((Sns2Component) component).setSubject((java.lang.String) value); return true;
            case "subscribeSNStoSQS": getOrCreateConfiguration((Sns2Component) component).setSubscribeSNStoSQS((boolean) value); return true;
            case "trustAllCertificates": getOrCreateConfiguration((Sns2Component) component).setTrustAllCertificates((boolean) value); return true;
            case "useIAMCredentials": getOrCreateConfiguration((Sns2Component) component).setUseIAMCredentials((boolean) value); return true;
            case "basicPropertyBinding": ((Sns2Component) component).setBasicPropertyBinding((boolean) value); return true;
            case "accessKey": getOrCreateConfiguration((Sns2Component) component).setAccessKey((java.lang.String) value); return true;
            case "secretKey": getOrCreateConfiguration((Sns2Component) component).setSecretKey((java.lang.String) value); return true;
            default: return false;
            }
        }
    }
}