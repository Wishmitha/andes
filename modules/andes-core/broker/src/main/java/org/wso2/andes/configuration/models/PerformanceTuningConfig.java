/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License, 
 * Version 2.0 (the "License"); you may not use this file except 
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.andes.configuration.models;

import org.wso2.carbon.config.annotation.Configuration;

/**
 * Configuration model for performance tuning parameters.
 */
@Configuration(description = "This section allows you to tweak memory and processor allocations used by WSO2 MB.\n"
        + "Broken down by critical processes so you have a clear view of which parameters to change in\n"
        + "different scenarios.")
public class PerformanceTuningConfig {
    private SlotsConfig slots = new SlotsConfig();

    private DeliveryConfig delivery = new DeliveryConfig();

    private AckHandlingConfig ackHandling = new AckHandlingConfig();

    private ContentHandlingConfig contentHandling = new ContentHandlingConfig();

    private InboundEventsConfig inboundEvents = new InboundEventsConfig();

    private MessageExpirationConfig messageExpiration = new MessageExpirationConfig();

    public SlotsConfig getSlots() {
        return slots;
    }

    public DeliveryConfig getDelivery() {
        return delivery;
    }

    public AckHandlingConfig getAckHandling() {
        return ackHandling;
    }

    public ContentHandlingConfig getContentHandling() {
        return contentHandling;
    }

    public InboundEventsConfig getInboundEvents() {
        return inboundEvents;
    }

    public MessageExpirationConfig getMessageExpiration() {
        return messageExpiration;
    }
}