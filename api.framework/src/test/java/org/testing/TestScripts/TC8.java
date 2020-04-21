package org.testing.TestScripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.TestSteps.HTTPMethods;
import org.testing.utilities.PropertiesFileData;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class TC8 {

	@Test
	public void testCase8() throws IOException {

		Properties prop = PropertiesFileData.propertiesData("../api.framework/env.properties");
		HTTPMethods http = new HTTPMethods(prop);
		Response res = http.getDummyRequest("dummy_securi", "users","2");

		System.out.println("Status code is: "+res.getStatusCode());
		System.out.println("Response is: "); System.out.println(res.asString());

	}
}
