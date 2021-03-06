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

package com.openresearch.spi;

import com.openresearch.spi.feature.ExchangeRate;
import com.openresearch.spi.feature.ExchangeRateProvider;
import com.openresearch.spi.feature.QuoteManager;
import com.openresearch.spi.util.CollectionsSizeComparator;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.ZoneOffset;

@Slf4j
public class Starter implements Runnable {

    @Override
    public void run() {
        log.info("starting");
        getQuoteManager().getQuotes("EUR", LocalDate.now(ZoneOffset.UTC));
        log.info("done");
    }

    private QuoteManager getQuoteManager() {
        final var providers = ExchangeRate.providers(false);
        CollectionsSizeComparator.compareSize(ExchangeRateProvider.class, providers, 1);
        return providers
                .stream()
                .map(ExchangeRateProvider::create)
                .toList()
                .get(0);
    }

    public static void main(final String... args) {
        new Starter().run();
    }
}
