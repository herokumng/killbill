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

package org.killbill.billing.invoice.usage;

import java.math.BigDecimal;

import org.killbill.billing.usage.api.RolledUpUnit;

public class DefaultRolledUpUnit implements RolledUpUnit {

    private final String unitType;
    private final BigDecimal amount;

    public DefaultRolledUpUnit(final String unitType, final BigDecimal amount) {
        this.unitType = unitType;
        this.amount = amount;
    }

    @Override
    public String getUnitType() {
        return unitType;
    }

    @Override
    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "DefaultRolledUpUnit{" +
               "unitType='" + unitType + '\'' +
               ", amount=" + amount +
               '}';
    }
}
