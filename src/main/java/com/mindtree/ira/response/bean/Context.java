package com.mindtree.ira.response.bean;

/***********************************************************************************************************************
 *
 * API.AI Java SDK - client-side libraries for API.AI
 * =================================================
 *
 * Copyright (C) 2014 by Speaktoit, Inc. (https://www.speaktoit.com)
 * https://www.api.ai
 *
 ***********************************************************************************************************************
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 ***********************************************************************************************************************/

import java.io.Serializable;
import java.util.Map;

public class Context implements Serializable {

	private static final long serialVersionUID = 1L;

    private String name;

    private Map<String, String> parameters;

    private Integer lifespan;

    public Context() {
    }

    public Context(final String name) {
        this.name = name;
    }

    /**
     * Context name
     */
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    /**
     * String parameters map
     */
    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(final Map<String, String> parameters) {
        this.parameters = parameters;
    }

    /**
     * Lifespan of the context measured in requests
     * @return count of requests context will live
     */
    public Integer getLifespan() {
        return lifespan;
    }

    /**
     * Lifespan of the context measured in requests
     * @param lifespan count of requests context will live
     */
    public void setLifespan(final Integer lifespan) {
        this.lifespan = lifespan;
    }
}