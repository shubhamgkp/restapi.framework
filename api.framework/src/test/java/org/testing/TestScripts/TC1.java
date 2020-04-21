package org.testing.TestScripts;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.json.JSONObject;
import org.testing.ResponseValidation.ResponseValidation;
import org.testing.TestSteps.HTTPMethods;
import org.testing.utilities.PropertiesFileData;
import org.testing.utilities.ResponseDataParsingUsingJsonPath;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class TC1 {

	static String idValue;

	@Test
	public void testCase1() throws IOException {

		Random randomNumber = new Random();
		Integer num = (int) randomNumber.nextLong();

		JSONObject data = new JSONObject();
		data.put("id", num.toString());
		data.put("empId","16565");
		data.put("empName", "Shubham Verma");
		data.put("designation","Senior QA");
		data.put("address", "Gurgaon, Haryana");

		Properties prop = PropertiesFileData.propertiesData("../api.framework/env.properties");
		HTTPMethods http = new HTTPMethods(prop);
		Response res = http.postRequest("QA_URI",data.toString());

		ResponseValidation.responseStatusCodeValidate(201, res); 
		idValue = ResponseDataParsingUsingJsonPath.response_parsing(res, "id");
		System.out.println("Id value is: "+idValue);
		System.out.println(res.asString());		 
	}
}
