package org.testing.TestScripts;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.testing.ResponseValidation.ResponseValidation;
import org.testing.TestSteps.HTTPMethods;
import org.testing.utilities.PropertiesFileData;
import org.testing.utilities.ResponseDataParsingUsingJsonPath;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class TC10 {
	
	static String idValue;
	
	@Test
	public void testCase10() throws IOException {
		
		Properties prop = PropertiesFileData.propertiesData("../api.framework/env.properties");
		HTTPMethods http = new HTTPMethods(prop);
		Response res = http.deleteDummyRequest("dummy_securi", "delete", "3");
		
		ResponseValidation.responseStatusCodeValidate(204, res);		
		System.out.println(res.asString());
	}
}
