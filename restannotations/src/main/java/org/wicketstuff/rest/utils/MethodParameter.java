/**
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.wicketstuff.rest.utils;

import java.lang.reflect.Method;

public class MethodParameter {
	final private Class<?> type;
	final private Method ownerMethod;
	final private int paramIndex;
	
	public MethodParameter(Class<?> type, Method ownerMethod, int paramIndex) {
		this.type = type;
		this.ownerMethod = ownerMethod;
		this.paramIndex = paramIndex;
	}

	public Class<?> getType() {
		return type;
	}

	public Method getOwnerMethod() {
		return ownerMethod;
	}

	public int getParamIndex() {
		return paramIndex;
	}
	
	
}
