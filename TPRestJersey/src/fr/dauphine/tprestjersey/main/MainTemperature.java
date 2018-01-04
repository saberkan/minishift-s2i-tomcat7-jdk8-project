package fr.dauphine.tprestjersey.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class MainTemperature {
	public static void main(String[] args) {
		lectureClassic();
		lectureJaxRs();
	}
	
	private static void lectureJaxRs() {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource("http://localhost:8080/TPRestJersey");
		
		System.out.println(service.path("/ctofservice").accept("application/xml").get(String.class));
		
		/*
		 * Form form = new Form();
		 * form.add("key", "value");
		 * service.path("/path").accept(MediaType.APPLICATION_FORM_URLENCODER).post(String.class, form)
		 */
	}

	private static void lectureClassic() {
		DefaultHttpClient client = new DefaultHttpClient();
		try {
			HttpGet get = new HttpGet("http://localhost:8080/TPRestJersey/ctofservice");
			get.addHeader("accept", "application/xml");
			HttpResponse response = client.execute(get);
			
			if(response.getStatusLine().getStatusCode() != 200)
				throw new RuntimeException("Operation failed: " + response.getStatusLine().getStatusCode());
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			client.getConnectionManager().shutdown();
		}
	}
}
