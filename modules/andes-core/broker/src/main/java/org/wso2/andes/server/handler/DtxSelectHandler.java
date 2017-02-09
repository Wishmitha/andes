/*
 * Copyright (c) 2016, WSO2 Inc. (http://wso2.com) All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
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
package org.wso2.andes.server.handler;

import org.wso2.andes.AMQException;
import org.wso2.andes.framing.DtxSelectBody;
import org.wso2.andes.kernel.AndesException;
import org.wso2.andes.protocol.AMQConstant;
import org.wso2.andes.server.AMQChannel;
import org.wso2.andes.server.protocol.AMQProtocolSession;
import org.wso2.andes.server.state.AMQStateManager;
import org.wso2.andes.server.state.StateAwareMethodListener;

public class DtxSelectHandler implements StateAwareMethodListener<DtxSelectBody> {
    private static DtxSelectHandler _instance = new DtxSelectHandler();

    public static DtxSelectHandler getInstance() {
        return _instance;
    }

    private DtxSelectHandler() {
    }

    @Override
    public void methodReceived(AMQStateManager stateManager, DtxSelectBody body, int channelId) throws AMQException {
        AMQProtocolSession session = stateManager.getProtocolSession();

        AMQChannel channel = session.getChannel(channelId);

        if (channel == null) {
            throw body.getChannelNotFoundException(channelId);
        }

        try {
            channel.setDtxTransactional();
        } catch (AndesException e) {
            throw body.getChannelException(AMQConstant.INTERNAL_ERROR, "Maximum number of parallel transactions limit"
                                                   + " reached", e);
        }
    }
}
