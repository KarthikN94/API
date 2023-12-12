package Com.apipracticeJava.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;



public class HttpUrlConnectionExamp {
	private void getMethod() throws IOException {

		// 1.create object class for url class
		URL url = new URL("https://dummy.restapiexample.com/api/v1/employees");

		// 2.open url connection and store in parent class
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		// 3.set the request type
		connection.setRequestMethod("GET");

		// 4.connect
		connection.connect();

		// 5.get statuscode from connection object and print
		int statuscode = connection.getResponseCode();
		System.out.println("Statuscode is " + statuscode);

		// 6.get response message and print
		String message = connection.getResponseMessage();
		System.out.println("Status message " + message);

		// 7.create inputstream for reading the response body
		InputStream inputStream = connection.getInputStream();

		// 8. create an inputstream reader
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

		// 9.create buffer reader and pass the inputstream reader
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		// 10.read the lines using readline
		String line;
		StringBuffer buffer = new StringBuffer();

		while ((line = bufferedReader.readLine()) != null) {
			buffer.append(line);

		}
		System.out.println("Response body" + buffer);
	}

	// POST

	private void postMethod() throws IOException {
		URL url = new URL("	https://dummy.restapiexample.com/api/v1/create");
		URLConnection openConnection = url.openConnection();
		HttpURLConnection connection = (HttpURLConnection) openConnection;

		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-type", "application/json");

		String string = "{\"name\":\"karthi\",\"salary\":\"60000\",\"age\":\"29\"}";
		byte[] bytes = string.getBytes();
		connection.setDoOutput(true);

		OutputStream outputStream = connection.getOutputStream();
		outputStream.write(bytes);

		int responseCode = connection.getResponseCode();
		System.out.println("Response code" + responseCode);

		String responseMessage = connection.getResponseMessage();
		System.out.println("Response message" + responseMessage);

		InputStream inputStream = connection.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		String line;
		StringBuffer s = new StringBuffer();

		while ((line = bufferedReader.readLine()) != null) {
			s.append(line);

		}
		System.out.println(s);

	}

	// PUT

	private void putMethod() throws IOException {
		URL url = new URL("https://dummy.restapiexample.com/api/v1/update/2616");
		URLConnection openConnection = url.openConnection();
		
		HttpURLConnection connection = (HttpURLConnection) openConnection;
		connection.setRequestMethod("PUT");
		connection.setRequestProperty("content-type", "application/json");
		connection.setDoOutput(true);
		
		String jsonBody = "{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}";
		byte[] bytes = jsonBody.getBytes();

		OutputStream outputStream = connection.getOutputStream();
		outputStream.write(bytes);
		
		InputStream stream = connection.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(stream);
		
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		String line;
		StringBuffer buffer = new StringBuffer();

		while ((line = bufferedReader.readLine()) != null) {
			buffer.append(line);

		}
		System.out.println(buffer);

		System.out.println(connection.getResponseCode());
		System.out.println(connection.getResponseMessage());

	}

	// DELETE

	private void deleteMethod() throws IOException {
		URL url = new URL("https://dummy.restapiexample.com/api/v1/delete/2616");
		URLConnection connection = url.openConnection();
		HttpURLConnection connection2 = (HttpURLConnection)connection;
		connection2.setRequestMethod("DELETE");
		System.out.println(connection2.getResponseCode());
		System.out.println(connection2.getResponseMessage());
		InputStream inputStream = connection2.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		
		String line;
		StringBuffer buffer = new StringBuffer();
		
		while ((line=bufferedReader.readLine())!=null) {
			buffer.append(line);
			
			
			
			
		}
		
		System.out.println(buffer);		

	}

	public static void main(String[] args) throws IOException {
		HttpUrlConnectionExamp c = new HttpUrlConnectionExamp();
		c.getMethod();
		c.postMethod();
		c.putMethod();
		c.deleteMethod();

	}

}


