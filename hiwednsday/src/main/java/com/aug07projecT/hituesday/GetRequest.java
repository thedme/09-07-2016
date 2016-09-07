package com.aug07projecT.hituesday;

import java.io.*;
import java.net.*;

/**
 * @author Dovid Eskenazi
 * @since 2016-09-06
 *
 */

public class GetRequest {
	/**
	 * The URL for lifted sails
	 * 
	 */

	protected static String endpoint = "http://localhost:1337/employee/";

	/*
	 * the character set to use when encoding URL parameters
	 * 
	 */

	protected static String charset = "UTF-8";

	public static void main(String[] args) {

		try {

			String id = "3";

			String queryString = String.format(endpoint + id);

			// creates a new URL out of the endpoint, terurnType and queryString
			URL postRequest = new URL(queryString);
			HttpURLConnection connection = (HttpURLConnection) postRequest.openConnection();
			connection.setRequestMethod("GET");

			if (connection.getResponseCode() != 200) {
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
