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

import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

@Slf4j
public final class ExchangeRate {

    private static final ServiceLoader<ExchangeRateProvider> loader = ServiceLoader.load(ExchangeRateProvider.class);

    public static List<ExchangeRateProvider> providers(final boolean refresh) {
        if (refresh) {
            loader.reload();
        }
        final var result = loader.stream()
                .map(ServiceLoader.Provider::get)
                .collect(Collectors.toList());
        log.info("loaded providers: {}", result);
        return result;
    }

    private ExchangeRate() {
        throw new IllegalAccessError();
    }

}