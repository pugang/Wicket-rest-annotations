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

public enum RestMimeTypes {
	JSON("json", "application/json", "charset=utf-8"), 
	XML("xml", "application/xml","charset=utf-8"), 
	HTML("html", "text/html", "charset=utf-8"), 
	PLAIN_TEXT("text", "text/plain", "charset=utf-8"), 
	CSV("csv", "text/csv", "charset=utf-8"), 
	CSS("css", "text/css", "charset=utf-8"), 
	RSS("rss", "application/rss+xml", "charset=utf-8"),
	IMAGE_GIF("gif", "image/gif"), 
	IMAGE_JPEG("jpeg", "image/jpeg"), 
	IMAGE_PNG("png", "image/png"), 
	OCTET_STREAM("octet-stream", "application/octet-stream")
	;

	private final String name;
	private final String requrstContent;
	private final String charsetEncoding;
	
	private RestMimeTypes(String name, String requrstContent){
		this(name, requrstContent, "");
	}
			
			
	private RestMimeTypes(String name, String requrstContent, String charsetEncoding) {
		this.name = name;
		this.requrstContent = requrstContent;
		this.charsetEncoding = charsetEncoding;
	}

	public String getName() {
		return name;
	}

	public String getRequestContentType() {
		String charEncoding = "";
		
		if (!charsetEncoding.isEmpty())
			charEncoding = ";" + charsetEncoding;
		
		return requrstContent + charEncoding;
	}
}
