/*
 * Copyright (c) 2011 Alex Tunyk <alex at tunyk.com>.
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
 *
 * See the NOTICE file distributed with this work for additional information
 * regarding copyright ownership.
 */
package com.tunyk.mvn.plugins.htmlcompressor;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Alex Tunyk <alex at tunyk.com>
 */
public class HtmlCompressorTest {

    // logger
    private static final Logger LOG = LoggerFactory.getLogger(HtmlCompressorTest.class);

    @BeforeAll
    public static void setUpClass() {
        LOG.info("Setting up class...");
    }

    @AfterAll
    public static void tearDownClass() {
        LOG.info("Test finished.");
    }

    @BeforeEach
    public void setUp() {
        LOG.info("Setting up data for testing...");
    }

    @Test
    public void testCompress() throws Exception {
        LOG.info("Testing compress method...");

        HtmlCompressor htmlCompressor = new HtmlCompressor("src/test/resources/html", "target/test/htmlcompressor/0");
        htmlCompressor.compress();
        // TODO: test files where created and every one has the right contents

        htmlCompressor = new HtmlCompressor("src/test/resources/html", "target/test/htmlcompressor/1",
                true, "target/test/htmlcompressor/1/integration.js", "src/test/resources/html/integration.js");
        htmlCompressor.compress();
        // TODO: test json file was created and it has right contents

        htmlCompressor = new HtmlCompressor("src/test/resources/html", "target/test/htmlcompressor/2");
        com.googlecode.htmlcompressor.compressor.HtmlCompressor htmlCompressorHandler = new com.googlecode.htmlcompressor.compressor.HtmlCompressor();
        htmlCompressorHandler.setEnabled(false);
        htmlCompressor.setHtmlCompressor(htmlCompressorHandler);
        htmlCompressor.compress();
        // TODO: verify if provided compression params are picked up

        LOG.info("Passed");
    }
}
