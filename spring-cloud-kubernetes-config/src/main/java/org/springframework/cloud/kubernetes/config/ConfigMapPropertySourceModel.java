/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.cloud.kubernetes.config;

import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Haytham Mohamed
 **/

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConfigMapPropertySourceModel implements Serializable {

	private String name;

	private String profile;

	private String label;

	private Map<String, String> data;

	private String namespace;

	public ConfigMapPropertySourceModel() {
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public ConfigMapPropertySourceModel(String name, String namespace, String profile,
			String label, Map<String, String> data) {
		this.name = name;
		this.data = data;
		this.profile = profile;
		this.label = label;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public Map<String, String> getData() {
		return data;
	}

	public void setData(Map<String, String> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer("[");
		buffer.append("name: " + name).append(", namespace: " + namespace)
				.append(", profile: " + profile).append(", label: " + label);
		if (data != null && !data.isEmpty()) {
			buffer.append(", data: [");
			data.entrySet().stream()
					.forEach(e -> buffer.append(e.getKey() + ": " + e.getValue() + " ,"));
			buffer.deleteCharAt(buffer.lastIndexOf(","));
			buffer.append("]");
		}
		return buffer.toString();
	}

}
