package com.aug07projecT.hituesday;

import java.io.*;
import java.net.*;

/**
 * @author Dovid Eskenazi
 * @since 2016-09-06
 *
 */

public class PostRequest {
	/**
	 * The URL for lifted sails
	 * 
	 */

	protected static String endpoint = "http://localhost:1337/employee";

	/*
	 * the character set to use when encoding URL parameters
	 * 
	 */

	protected static String charset = "UTF-8";

	public static void main(String[] args) {

		try {

			String firstName = "Dovid3";
			String lastName = "Eskenazi3";
			String email = "dovideskenazi@theironyard.com";
			String homePhone = "888-777-6666";
			String cellPhone = "111-222-3333";
			String password = "Passw0rd";
			String active = "1";

			String queryString = String.format(
					"firstName=%s&lastName=%s&email=%s&homePhone=%s&cellPhone=%s&password=%s&active=%s",
					URLEncoder.encode(firstName, charset), URLEncoder.encode(lastName, charset),
					URLEncoder.encode(email, charset), URLEncoder.encode(homePhone, charset),
					URLEncoder.encode(cellPhone, charset), URLEncoder.encode(password, charset),
					URLEncoder.encode(active, charset)

			);

			// creates a new URL out of the endpoint, terurnType and queryString
			URL postRequest = new URL(endpoint + "?" + queryString);
			HttpURLConnection connection = (HttpURLConnection) postRequest.openConnection();
			connection.setRequestMethod("POST");

			if (connection.getResponseCode() != 201) {
				throw new RuntimeException("Failed : HTTP error code :" + connection.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));

			while (br.readLine() != null) {
				System.out.println(br.readLine());
			}
			connection.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
			// TODO: handle exception
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
