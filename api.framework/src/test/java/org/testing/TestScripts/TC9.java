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

public class TC9 {

	static String updatedAt;

	@Test
	public void testCase9() throws IOException {

		JSONObject data = new JSONObject();
		data.put("name", "Shivam");
		data.put("job", "Software QA");

		Properties prop = PropertiesFileData.propertiesData("../api.framework/env.properties");
		HTTPMethods http = new HTTPMethods(prop);
		Response res = http.putDummyRequest("dummy_securi", "users","2",data.toString());

		ResponseValidation.responseStatusCodeValidate(200, res);

		updatedAt = ResponseDataParsingUsingJsonPath.response_parsing(res, "updatedAt");
		System.out.println("Updated time is: "+updatedAt);
		System.out.println(res.asString());
	}
}
