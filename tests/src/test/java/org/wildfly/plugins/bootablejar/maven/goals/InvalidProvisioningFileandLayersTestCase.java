/*
 * Copyright 2020 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wildfly.plugins.bootablejar.maven.goals;

import org.junit.Test;

/**
 * @author jdenise
 */
public class InvalidProvisioningFileandLayersTestCase extends AbstractBootableJarMojoTestCase {
    public InvalidProvisioningFileandLayersTestCase() {
        super("invalid3-pom.xml", true, "provisioning1.xml");
    }

    @Test
    public void test()
            throws Exception {
        BuildBootableJarMojo mojo = lookupMojo("package");
        assertNotNull(mojo);
        boolean failed = false;
        try {
            mojo.execute();
            failed = true;
        } catch(Exception ex) {
            // OK expected
            System.err.println("EXPECTED exception");
            ex.printStackTrace();
        }
        if (failed) {
           throw new Exception("Should have failed");
        }
    }
}
