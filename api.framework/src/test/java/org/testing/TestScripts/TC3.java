package org.testing.TestScripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.TestSteps.HTTPMethods;
import org.testing.utilities.PropertiesFileData;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class TC3 {

	@Test
	public void testCase3() throws IOException {
		Properties prop = PropertiesFileData.propertiesData("../api.framework/env.properties");
		HTTPMethods http = new HTTPMethods(prop);
		Response res = http.getRequest("QA_URI","4321");	

		System.out.println("Third Test case is: ");
		System.out.println(res.asString());
		System.out.println(res.getStatusCode());
	}	
}
