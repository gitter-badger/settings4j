/* ***************************************************************************
 * Copyright (c) 2008 Brabenetz Harald, Austria.
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
 * 
 *****************************************************************************/
package org.settings4j.settings.nop;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.settings4j.Connector;
import org.settings4j.Settings4jRepository;

/**
 * No-operation implementation of Settings used by NOPSettingsRepository.
 */
public class NOPSettings implements org.settings4j.Settings4jInstance {
    Settings4jRepository settingsRepository;
    
    public NOPSettings(Settings4jRepository settingsRepository) {
        super();
        this.settingsRepository = settingsRepository;
    }

    public void addConnector(Connector connector) {
        // do nothing in NOP-Implementation
    }

    public void removeAllConnectors() {
        // do nothing in NOP-Implementation
    }
    
    public List getConnectors() {
        return Collections.EMPTY_LIST;
    }

	public byte[] getContent(String key) {
        return null;
    }

    public Object getObject(String key) {
        return null;
    }

    public String getString(String key) {
        return null;
    }

    public Map getMapping() {
        return Collections.EMPTY_MAP;
    }

    public void setMapping(Map mapping) {
        // do nothing in NOP-Implementation
    }

	public Connector getConnector(String connectorName) {
		return null;
	}
}
