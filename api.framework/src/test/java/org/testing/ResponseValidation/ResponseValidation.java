package org.testing.ResponseValidation;

import com.jayway.restassured.response.Response;

public class ResponseValidation {

	public static void responseStatusCodeValidate(int expectedStatusCode, Response res) {
		
		if(expectedStatusCode==res.getStatusCode()) {
			
			System.out.println("Test case passed with status code: "+res.getStatusCode());
		}
		else {
			
			System.out.println("Test case failed with status code: "+res.getStatusCode());
		}
	}
}
