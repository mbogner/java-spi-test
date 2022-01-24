/*
 * Copyright 2022 openresearch.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.openresearch.spi.feature;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Slf4j
public class YahooQuoteManagerImpl implements QuoteManager {

    @Override
    public List<Quote> getQuotes(String baseCurrency, LocalDate date) {
        log.debug("getQuotes(baseCurrency={}, date={})", baseCurrency, date);
        return Collections.emptyList();
    }
}