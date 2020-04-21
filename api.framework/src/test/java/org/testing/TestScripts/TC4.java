package org.testing.TestScripts;

import java.io.IOException;
import java.util.Properties;

import org.json.JSONObject;
import org.testing.ResponseValidation.ResponseValidation;
import org.testing.TestSteps.HTTPMethods;
import org.testing.utilities.PropertiesFileData;
import org.testing.utilities.ResponseDataParsingUsingJsonPath;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class TC4 {

	static String idValue;
	
	@Test
	public void testCase4() throws IOException {
				
		JSONObject data = new JSONObject();
		data.put("firstName", "Shubham");
		data.put("lastName", "Verma");
		data.put("age","30");
		data.put("adr", "Gurgaon, Haryana");
		data.put("desig", "Senior QA");
		
		Properties prop = PropertiesFileData.propertiesData("../api.framework/env.properties");
		HTTPMethods http = new HTTPMethods(prop);
		Response res = http.putRequest("QA_URI", "4321", data.toString());
		
		ResponseValidation.responseStatusCodeValidate(200, res);
		idValue = ResponseDataParsingUsingJsonPath.response_parsing(res, "id");
		System.out.println("Id value is: "+idValue);
		System.out.println(res.asString());
	}
}
