/*
 * Zed Attack Proxy (ZAP) and its related class files.
 *
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Copyright 2018 The ZAP Development Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.zaproxy.zap.extension.savexmlmessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.parosproxy.paros.extension.ExtensionAdaptor;
import org.parosproxy.paros.view.View;

public class ExtensionSaveXMLHttpMessage extends ExtensionAdaptor {

    private static final String NAME = "ExtensionSaveXMLHttpMessage";
    private static final Logger LOGGER = LogManager.getLogger(ExtensionSaveXMLHttpMessage.class);

    public ExtensionSaveXMLHttpMessage() {
        super(NAME);
        setI18nPrefix("savexml");
    }

    @Override
    public void postInstall() {
        String message =
                "The Save HTTP Message as XML add-on has been retired. This functionality is now provided by the Import/Export add-on.";
        LOGGER.warn(message);
        if (View.isInitialised()) {
            View.getSingleton().showWarningDialog(message);
        }
    }

    @Override
    public boolean canUnload() {
        return true;
    }
}
