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
package org.wicketstuff.rest.resource.gson;

import org.apache.wicket.authroles.authorization.strategies.role.IRoleCheckingStrategy;
import org.apache.wicket.protocol.http.servlet.ServletWebResponse;
import org.apache.wicket.request.http.WebResponse;
import org.wicketstuff.rest.resource.AbstractRestResource;

import com.google.gson.Gson;


/**
 * Base class to build a resource that serves REST requests with JSON as exchange format.
 * 
 * @author andrea del bene
 *
 */
public class GsonRestResource extends AbstractRestResource<Gson>{
	
	public GsonRestResource() {
		super(new Gson());
	}

	public GsonRestResource(IRoleCheckingStrategy roleCheckingStrategy) {
		super(new Gson(), roleCheckingStrategy);
	}

	@Override
	protected String serializeObjToString(Object result, Gson jsonSerialDeserial) {
		return jsonSerialDeserial.toJson(result);
	}

	@Override
	protected Object deserializeObjFromString(Class<?> argClass, String json,
			Gson jsonSerialDeserial) {
		return jsonSerialDeserial.fromJson(json, argClass);
	}
	
	@Override
	protected void serializeObjectToResponse(WebResponse response, Object result) {
		response.setContentType("application/json;charset=utf-8");
		super.serializeObjectToResponse(response, result);
	}
}