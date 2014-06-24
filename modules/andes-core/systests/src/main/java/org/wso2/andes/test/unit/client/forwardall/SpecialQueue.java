/*
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */
package org.wso2.andes.test.unit.client.forwardall;

import org.wso2.andes.client.AMQQueue;
import org.wso2.andes.client.AMQConnection;
import org.wso2.andes.framing.AMQShortString;

/**
 * Queue that allows several private queues to be registered and bound
 * to an exchange with the same routing key.
 *
 */
class SpecialQueue extends AMQQueue
{
    private final AMQShortString name;

    SpecialQueue(AMQConnection con, String name)
    {
        super(con, name, true);
        this.name = new AMQShortString(name);
    }

    public AMQShortString getRoutingKey()
    {
        return name;
    }
}
