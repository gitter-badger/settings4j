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
package org.settings4j;

/**
 * a ContentResolver is a Helper for read/write byte[] content for a given key.
 *
 * <pre>
 * Example configuration in settings4j.xml:
 * --------------------------------------
 * &lt;contentResolver name="ClasspathContentResolver"
 *      class="org.settings4j.contentresolver.ClasspathContentResolver"&gt;
 * &lt;/contentResolver&gt;
 * --------------------------------------
 * </pre>
 * <p>
 * This is usefull for {@link org.settings4j.connector.SystemPropertyConnector} or {@link org.settings4j.connector.PropertyFileConnector}. If you define a
 * ContentResolver in this Connectors, you can rever to a File of the FileSystem or Classpath.
 * </p>
 *
 * <pre>
 * Example Connector usage in settings4j.xml:
 * --------------------------------------
 * &lt;connector name="SystemPropertyConnector" class="org.settings4j.connector.SystemPropertyConnector" &gt;
 *     &lt;contentResolver-ref ref="ClasspathContentResolver" /&gt;
 * &lt;/connector&gt;
 * --------------------------------------
 *
 * Example usage in java-code:
 *
 * --------------------------------------
 * // alternativ start myapp with -Dxyz=com/mycompany/myapp/xyz-config.xml
 * System.setProperty("xyz", "com/mycompany/myapp/xyz-config.xml"); //refer to the ClasspathContentResolver
 *
 * // somewhere in myapp:
 * byte[] xyzConfig = Settings4j.getContent("xyz"); // get Classpath-URL from the SystemPropertyConnector
 * --------------------------------------
 * </pre>
 *
 * @author Harald.Brabenetz
 */
public interface ContentResolver {

    /**
     * Reads the Content for the given Key or null if nothing where found.
     *
     * @param key The key
     * @return The byte[] Content or null if nothing where found.
     */
    byte[] getContent(String key);

    /**
     * Some Implementations of a {@link ContentResolver} are delegating the functionality to other ContentResolvers.
     * <p>
     * Examples are: {@link org.settings4j.contentresolver.UnionContentResolver}
     * </p>
     *
     * <pre>
     * --------------------------------------
     * &lt;contentResolver name="DefaultContentResolver" class="org.settings4j.contentresolver.UnionContentResolver"&gt;
     *     &lt;contentResolver-ref ref="FSContentResolver" /&gt;
     *     &lt;contentResolver-ref ref="ClasspathContentResolver" /&gt;
     * &lt;/contentResolver&gt;
     * --------------------------------------
     * </pre>
     *
     * @param contentResolver
     *        the original contentResolver to delegate.
     */
    void addContentResolver(ContentResolver contentResolver);
}
