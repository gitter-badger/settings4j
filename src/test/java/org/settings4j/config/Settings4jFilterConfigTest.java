/*
 * #%L
 * settings4j
 * ===============================================================
 * Copyright (C) 2008 - 2015 Brabenetz Harald, Austria
 * ===============================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package org.settings4j.config;

import org.settings4j.Settings4jInstance;
import org.settings4j.Settings4jRepository;
import org.settings4j.test.TestUtils;

public class Settings4jFilterConfigTest extends AbstractTestSettings4jConfig {

    /** General Logger for this Class. */
    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(Settings4jFilterConfigTest.class);

    public void testMapping() {
        LOG.debug("run TestSettings4jMappingConfig.testMapping");
        final Settings4jRepository settingsRepository = TestUtils
            .getConfiguredSettingsRepository("org/settings4j/config/testConfigFilter.xml");
        final Settings4jInstance settings = settingsRepository.getSettings();

        System.setProperty("org/settings4j/config/testConfigFilter1.txt", "testConfig1 System Property");
        System.setProperty("org/settings4j/config/testConfigFilter2.txt", "testConfig2 System Property");

        final String config1 = settings.getString("org/settings4j/config/testConfigFilter1.txt");
        final String config2 = settings.getString("org/settings4j/config/testConfigFilter2.txt");

        assertEquals("testConfig1 System Property", config1);
        assertEquals("testConfig2 TextFile", config2);

    }
}
