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
package org.wso2.andes.management.ui.actions;

import static org.wso2.andes.management.ui.Constants.ACTION_CLOSE;
import org.wso2.andes.management.ui.exceptions.InfoRequiredException;
import org.wso2.andes.management.ui.views.NavigationView;
import org.wso2.andes.management.ui.views.ViewUtility;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

public class CloseConnection extends AbstractAction implements IWorkbenchWindowActionDelegate
{	
	public CloseConnection()
	{
        
	}
	
    public void run(IAction action)
    {
        if(_window != null)
        {   
            NavigationView view = (NavigationView)_window.getActivePage().findView(NavigationView.ID);
            try
            {
                view.disconnect();
            }
            catch(InfoRequiredException ex)
            {
                ViewUtility.popupInfoMessage(ACTION_CLOSE, ex.getMessage());
            }
            catch(Exception ex)
            {
                handleException(ex, null, null);
            }
        }
    }   
}
