/*
 * Copyright 2014-2015 Groupon, Inc
 * Copyright 2014-2015 The Billing Project, LLC
 *
 * The Billing Project licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.killbill.billing.server.log.obfuscators;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.regex.Pattern;

import ch.qos.logback.classic.spi.ILoggingEvent;

// See ConfigurationObjectFactory
public class ConfigMagicObfuscator extends Obfuscator {

    private static final String[] DEFAULT_SENSITIVE_KEYS = {
            "key",
            "pass",
            "password"
    };

    private final Collection<Pattern> patterns = new LinkedList<>();

    public ConfigMagicObfuscator() {
        this(Collections.emptyList());
    }

    public ConfigMagicObfuscator(final Collection<Pattern> extraPatterns) {
        super();

        for (final String sensitiveKey : DEFAULT_SENSITIVE_KEYS) {
            this.patterns.add(buildPattern(sensitiveKey));
        }
        this.patterns.addAll(extraPatterns);
    }

    @Override
    public String obfuscate(final String originalString, final ILoggingEvent event) {
        return obfuscate(originalString, patterns, event);
    }

    private Pattern buildPattern(final String key) {
        return Pattern.compile("^Assigning value \\[([^\\]]*)\\] for \\[[^\\]]*" + key + "\\] on \\[[^\\]]*\\]$", DEFAULT_PATTERN_FLAGS);
    }
}
