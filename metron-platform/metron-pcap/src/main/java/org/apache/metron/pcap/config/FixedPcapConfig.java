/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.metron.pcap.config;

import java.util.LinkedHashMap;
import java.util.Map;

public class FixedPcapConfig extends PcapConfig {

  public FixedPcapConfig(PrefixStrategy prefixStrategy) {
    super(prefixStrategy);
    setFixedFields(new LinkedHashMap<>());
  }

  public Map<String, String> getFixedFields() {
    return PcapOptions.FIELDS.get(this, Map.class);
  }

  public void setFixedFields(Map<String, String> fixedFields) {
    PcapOptions.FIELDS.put(this, fixedFields);
  }

  public void putFixedField(String key, String value) {
    Map<String, String> fixedFields = PcapOptions.FIELDS.get(this, Map.class);
    String trimmedVal = value != null ? value.trim() : null;
    if (!isNullOrEmpty(trimmedVal)) {
      fixedFields.put(key, value);
    }
  }

}
