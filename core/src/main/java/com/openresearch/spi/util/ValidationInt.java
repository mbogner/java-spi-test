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

package com.openresearch.spi.util;

import lombok.NonNull;

public final class ValidationInt {

    public static void nonNegative(final int val, @NonNull final String name) {
        if (val < 0) {
            throw new IllegalArgumentException(String.format("%s must not be negative", name));
        }
    }


    private ValidationInt() {
        throw new IllegalAccessError();
    }

}
