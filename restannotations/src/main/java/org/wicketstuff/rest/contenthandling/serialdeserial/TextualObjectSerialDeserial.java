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
package org.wicketstuff.rest.contenthandling.serialdeserial;

import org.apache.wicket.request.http.WebRequest;
import org.apache.wicket.request.http.WebResponse;
import org.wicketstuff.rest.contenthandling.IObjectSerialDeserial;
import org.wicketstuff.rest.contenthandling.RestMimeTypes;
import org.wicketstuff.rest.utils.http.HttpUtils;

public abstract class TextualObjectSerialDeserial implements IObjectSerialDeserial {

	@Override
	public void objectToResponse(Object targetObject, WebResponse response, String mimeType)
			throws Exception {
		response.write(objectToString(targetObject, mimeType));
	}

	@Override
	public <T> T requestToObject(WebRequest request, Class<T> targetClass, String mimeType)
			throws Exception {
		return stringToObject(HttpUtils.readStringFromRequest(request), targetClass, mimeType);
	}

	public abstract String objectToString(Object targetObject, String mimeType);

	public abstract <T> T stringToObject(String source, Class<T> targetClass, String mimeType);
}
