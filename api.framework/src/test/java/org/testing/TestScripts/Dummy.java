package org.testing.TestScripts;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class Dummy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RequestSpecification request=	RestAssured.given();
		//For Header
		request.header("Content-Type",  "application/json");

		/*
		 * JSONObject json=new JSONObject(); json.put("name", "Shivam");
		 * json.put("salary", "30000"); json.put("age","30");
		 */

		//request.body(json.toJSONString());
		Response response=request.get("http://dummy.restapiexample.com/api/v1/employee/1");	

		int code=response.getStatusCode();
		System.out.println(code);
		System.out.println(response.asString());
	}

}
