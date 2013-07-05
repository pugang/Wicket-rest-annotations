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
package org.wicketstuff.rest.testJsonRequest;

import org.apache.wicket.authroles.authorization.strategies.role.IRoleCheckingStrategy;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.wicketstuff.rest.Person;
import org.wicketstuff.rest.annotations.AuthorizeInvocation;
import org.wicketstuff.rest.annotations.HttpMethod;
import org.wicketstuff.rest.annotations.JsonBody;
import org.wicketstuff.rest.annotations.MethodMapping;
import org.wicketstuff.rest.resource.AbstractJsonRestResource;


public class TestRestResource extends AbstractJsonRestResource<TestJsonDesSer>{
	public TestRestResource(TestJsonDesSer jsonSerialDeserial, IRoleCheckingStrategy roleCheckingStrategy) {
		super(jsonSerialDeserial, roleCheckingStrategy);
	}
	/**
	 * new Roles()new Roles()new Roles()for GET requests and URLs like '<resource path>/5'
	 * The id parameter is automatically extracted from URL
	 */
	@MethodMapping("/{id}")
	public void testMethodInt(int id){
	}
	
	/**
	 * Method invoked for GET requests and URLs like '<resource path>/5'
	 * The id parameter is automatically extracted from URL
	 * The person parameter is automatically deserialized from request body (which is JSON)
	 * The returned object is automatically serialized to JSON and written in the response
	 */
	@MethodMapping(value = "/{id}",  httpMethod = HttpMethod.POST)
	public Person testMethodPostComplex(int id, @JsonBody Person person){
		return person;
	}
	
	@MethodMapping(value = "/monoseg",  httpMethod = HttpMethod.POST)
	public void testMethodPostSegFixed(){
		System.out.println("monoseg");
	}
	@MethodMapping("/")
	public void testMethod(){
		System.out.println("method with no param:");
	}
	
	@MethodMapping(value = "/",  httpMethod = HttpMethod.POST)
	public Person testMethodPost(){
		Person person = createTestPerson();
		return person;
	}
	
	@MethodMapping(value = "/admin",  httpMethod = HttpMethod.GET)
	@AuthorizeInvocation("ROLE_ADMIN")
	public void testMethodAdminAuth(){
		System.out.println("you are admin!");
	}
	
	public static Person createTestPerson() {
		return new Person("Mary", "Smith", "m.smith@gmail.com");
	}

	@Override
	protected String serializeToJson(Object result, TestJsonDesSer jsonSerialDeserial) {
		return TestJsonDesSer.getJSON();
	}

	@Override
	protected Object deserializeFromJson(Class argClass, String json,
			TestJsonDesSer jsonSerialDeserial) {
		return TestJsonDesSer.getObject();
	}

}