package fr.dauphine.tprestjersey.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class MainTodo {

	public static void main(String[] args) {
		DefaultHttpClient client = new DefaultHttpClient();
		try {
			HttpPost post;
			post = new HttpPost("http://localhost:8080/TPRestJersey/todo");
			
			
			List<NameValuePair> params = new ArrayList<NameValuePair>(2);
			params.add(new BasicNameValuePair("id", "1000"));
			params.add(new BasicNameValuePair("titre", "titre"));
			post.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
			
			
			/*
			StringEntity entity = new StringEntity("<todo><id>800</id></todo>");
			entity.setContentType(MediaType.APPLICATION_XML);
			post.setEntity(entity);
			*/
			


			HttpClientParams.setRedirecting(post.getParams(), false);
			HttpResponse response = client.execute(post);
			
			if(response.getStatusLine().getStatusCode() != 201)
				throw new RuntimeException("Operation failed: " + response.getStatusLine().getStatusCode());
			
			System.out.println(response.getStatusLine().getStatusCode());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
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
