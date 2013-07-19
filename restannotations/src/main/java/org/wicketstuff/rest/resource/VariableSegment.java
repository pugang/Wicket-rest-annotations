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
package org.wicketstuff.rest.resource;

import org.apache.wicket.util.string.StringValue;

/**
 * {@link StringValue} subtype that contains a mounted segment containing a
 * parameter's value (for example '/{id}/').
 * 
 * @author andrea del bene
 * 
 */
public class VariableSegment extends GeneralURLSegment {

	VariableSegment(String text) {
		super(text);
	}

	@Override
	protected String loadSegmentVarName() {
		String segValue = toString();
		return segValue.substring(1, segValue.length() - 2);
	}
}