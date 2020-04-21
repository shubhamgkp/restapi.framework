package org.testing.TestScripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.ResponseValidation.ResponseValidation;
import org.testing.TestSteps.HTTPMethods;
import org.testing.utilities.PropertiesFileData;
import org.testing.utilities.ResponseDataParsingUsingJsonPath;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class TC5 {
	
	static String idValue;
	
	@Test
	public void testCase5() throws IOException {
		
		Properties prop = PropertiesFileData.propertiesData("../api.framework/env.properties");
		HTTPMethods http = new HTTPMethods(prop);
		Response res = http.deleteRequest("QA_URI", "zXs0KWI");
		
		ResponseValidation.responseStatusCodeValidate(200, res);
		idValue = ResponseDataParsingUsingJsonPath.response_parsing(res, "id");
		System.out.println("Id value is: "+idValue);
		System.out.println(res.asString());
	}
}
