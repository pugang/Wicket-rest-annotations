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
package org.wicketstuff.rest.contenthandling;

import org.apache.wicket.request.http.WebRequest;
import org.apache.wicket.request.http.WebResponse;

/**
 * General interface to implement object serializers/deserializers.
 * 
 * @author andrea del bene
 * 
 */
public interface IObjectSerialDeserial {
	/**
	 * Converts the object in input to the corresponding string value.
	 * 
	 * @param targetObject
	 *            the object instance to serialize to string.
	 * @param mimeType
	 *            the text format to use.
	 * @return the textual representation of the object in input.
	 * @throws Exception 
	 */
	public void objectToResponse(Object targetObject, WebResponse response, String mimeType) throws Exception;

	/**
	 * Extract an instance of targetClass form the string in input.
	 * @param argClass
	 * 			the type of the object we want to extract.
	 * @param mimeType 
	 * 			the text format to use.
	 * @param source
	 * 			the source string to convert to object. 
	 * 
	 * @return the object extracted from string value.
	 */
	public <T> T requestToObject(WebRequest request, Class<T> argClass, String mimeType) throws Exception;
}
