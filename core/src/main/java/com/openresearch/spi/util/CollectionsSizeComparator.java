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
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;

@Slf4j
public final class CollectionsSizeComparator {

    /**
     * @param contentClass Class within the collection. Used for creating an error message if collection.size() != expectedSize.
     * @param collection   The collection to check against expectedSize.
     * @param expectedSize Expected number of entries in collection.
     * @param <T>          Type within the collection defined by contentClass.
     */
    public static <T> void compareSize(
            @NonNull final Class<T> contentClass,
            @NonNull final Collection<T> collection,
            final int expectedSize
    ) {
        log.debug("compareSize[found#: {}, expected#: {}, entries: {}]", collection.size(), expectedSize, collection);
        ValidationInt.nonNegative(expectedSize, "expectedSize");
        if (collection.size() != expectedSize) {
            throw new IllegalStateException(
                    String.format(
                            "invalid count of %s entries found [found#: %d, expected#: %d, entries: %s]",
                            contentClass.getName(), collection.size(), expectedSize, collection
                    )
            );
        }
    }

    private CollectionsSizeComparator() {
        throw new IllegalAccessError();
    }
}
