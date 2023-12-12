package Com.apipracticeJava.net;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Unirestpractice {
	//GET
	private void getmethodexample() throws UnirestException {
		HttpResponse<JsonNode> asJson = Unirest.get("https://dummy.restapiexample.com/api/v1/employees").asJson();
		System.out.println("Response code" + asJson.getStatus());
		System.out.println("Response message" + asJson.getStatusText());
		System.out.println("Response body" + asJson.getBody());

	}
	//POST
	private void postmethodexample() throws UnirestException {
		HttpResponse<JsonNode> asJson = Unirest.post("https://dummy.restapiexample.com/api/v1/create").body("{\"name\":\"joe\",\"salary\":\"167\",\"age\":\"28\"}").asJson();
		System.out.println("Response code" + asJson.getStatus());
		System.out.println("Response message" + asJson.getStatusText());
		System.out.println("Response body" + asJson.getBody());

	}
	//PUT
	private void putmethodexample() throws UnirestException {
		HttpResponse<JsonNode> asJson = Unirest.put("https://dummy.restapiexample.com/api/v1/update/9882").body("{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}").asJson();
		System.out.println("Response code" + asJson.getStatus());
		System.out.println("Response message" + asJson.getStatusText());
		System.out.println("Response body" + asJson.getBody());
	}
	//DELETE
	private void deletemethodexample() throws UnirestException {
		HttpResponse<JsonNode> asJson = Unirest.delete("https://dummy.restapiexample.com/api/v1/delete/9882").asJson();
		System.out.println("Response code" + asJson.getStatus());
		System.out.println("Response message" + asJson.getStatusText());
		System.out.println("Response body" + asJson.getBody());

	}
	
	

	public static void main(String[] args) throws UnirestException {
		Unirestpractice u = new Unirestpractice();
//		u.getmethodexample();
//		u.postmethodexample();
//		u.putmethodexample();
		u.deletemethodexample();
		
		
	}
}
