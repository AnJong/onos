/*
 * Copyright 2015 Open Networking Laboratory
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.onosproject.store.consistent.impl;

import java.util.List;

/**
 * A simple Partitioner that uses the map name hash to
 * pick a partition.
 * <p>
 * This class uses a md5 hash based hashing scheme for hashing the map name to
 * a partition. This partitioner maps all keys for a map to the same database
 * partition.
 */
public class SimpleTableHashPartitioner extends DatabasePartitioner {

    public SimpleTableHashPartitioner(List<Database> partitions) {
        super(partitions);
    }

    @Override
    public Database getPartition(String mapName, String key) {
        return partitions.get(hash(mapName) % partitions.size());
    }
}
