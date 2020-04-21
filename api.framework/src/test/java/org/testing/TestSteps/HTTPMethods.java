package org.testing.TestSteps;

import java.util.Properties;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;

public class HTTPMethods {

	Properties pr;

	public HTTPMethods(Properties pr) {

		this.pr=pr;
	}

	public Response postRequest(String uriKey, String body) {

		Response res = 
				given()
				.contentType(ContentType.JSON)
				.body(body)

				.when()
				.post(pr.getProperty(uriKey));
		return res;
	}

	public Response postDummyRequest(String baseURI, String resourceName, String body) {

		String uri = pr.getProperty(baseURI)+"/"+resourceName;
		Response res = 
				given()
				.contentType(ContentType.JSON)
				.body(body)

				.when()
				.post(uri);
		return res;
	}

	public Response getRequest(String uriKey, String idVal) {

		String uri = pr.getProperty(uriKey)+"/"+idVal;
		Response res =
				given()
				.contentType(ContentType.JSON)

				.when()
				.get(uri);
		return res;
	}

	public Response getRequest(String uriKey) {

		Response res =
				given()
				.contentType(ContentType.JSON)

				.when()
				.get(pr.getProperty(uriKey));
		return res;
	}

	public Response getDummyRequest(String baseURI, String resourceName) {

		String uri = pr.getProperty(baseURI)+"/"+resourceName;
		Response res =
				given()
				.contentType(ContentType.JSON)

				.when()
				.get(uri);
		return res;
	}

	public Response getDummyRequest(String baseURI, String resourceName,String IdVal) {

		String uri = pr.getProperty(baseURI)+"/"+resourceName+"/"+IdVal;
		System.out.println(uri);
		Response res =
				given()
				.contentType(ContentType.JSON)

				.when()
				.get(uri);
		return res;
	}
	public Response putRequest(String uriKey, String idValue, String body) {

		String uri = pr.getProperty(uriKey)+"/"+idValue;
		Response res = 
				given()
				.contentType(ContentType.JSON)
				.body(body)

				.when()
				.put(uri);
		return res;			
	}
	
	public Response putDummyRequest(String baseURI, String resourceName, String IdVal, String body) {

		String uri = pr.getProperty(baseURI)+"/"+resourceName+"/"+IdVal;
		System.out.println(uri);
		Response res = 
				given()
				.contentType(ContentType.JSON)
				.body(body)

				.when()
				.put(uri);
		return res;			
	}

	public Response deleteRequest(String uriKey, String idValue) {

		String uri = pr.getProperty(uriKey)+"/"+idValue;
		Response res =
				given()
				.contentType(ContentType.JSON)

				.when()
				.delete(uri);

		return res;
	}
	
	public Response deleteDummyRequest(String baseURI,String resourceName,String IdVal) {

		String uri = pr.getProperty(baseURI)+"/"+resourceName+"/"+IdVal;
		System.out.println(uri);
		Response res =
				given()
				.contentType(ContentType.JSON)

				.when()
				.delete(uri);

		return res;
	}
}
