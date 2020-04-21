package org.testing.TestScripts;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;
import org.testing.ResponseValidation.ResponseValidation;
import org.testing.TestSteps.HTTPMethods;
import org.testing.utilities.PropertiesFileData;
import org.testing.utilities.ResponseDataParsingUsingJsonPath;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class TC6 {

	static int idValue;
	
	@Test
	public void testCase6() throws IOException {

		String name = RandomStringUtils.randomAlphabetic(10);
		JSONObject data = new JSONObject();
		data.put("name", name);
		data.put("salary", "30000");
		data.put("age","30");

		Properties prop = PropertiesFileData.propertiesData("../api.framework/env.properties");
		HTTPMethods http = new HTTPMethods(prop);
		Response res = http.postDummyRequest("dummy_uri","create",data.toString());

		ResponseValidation.responseStatusCodeValidate(200, res);
		idValue = ResponseDataParsingUsingJsonPath.response_dummyParsing(res, "data.id");
		System.out.println("Id value is: "+idValue);
		System.out.println(res.asString());
	} 
}
