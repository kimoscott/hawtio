/**
 * Copyright (C) 2013 the original author or authors.
 * See the notice.md file distributed with this work for additional
 * information regarding copyright ownership.
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
package io.hawt.web;

import org.apache.commons.httpclient.protocol.DefaultProtocolSocketFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * A custom implementation which works on PaaS environments like OpenShift
 */
public class OpenShiftProtocolSocketFactory extends DefaultProtocolSocketFactory {
    private static final transient Logger LOG = LoggerFactory.getLogger(OpenShiftProtocolSocketFactory.class);

    /**
     * The factory singleton.
     */
    private static final OpenShiftProtocolSocketFactory factory = new OpenShiftProtocolSocketFactory();

    /**
     * Gets an singleton instance of the OpenShiftProtocolSocketFactory.
     *
     * @return a OpenShiftProtocolSocketFactory
     */
    public static OpenShiftProtocolSocketFactory getSocketFactory() {
        return factory;
    }

    @Override
    public Socket createSocket(String host, int port, InetAddress localAddress, int localPort) throws IOException, UnknownHostException {
        LOG.info("Creating OpenShift socket on " + host + ":" + port);
        return new Socket(host, port);
    }

}
