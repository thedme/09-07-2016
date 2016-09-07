package com.aug07projecT.hituesday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class UpdateRequest {

	static String id = "3";
	static String cellPhone = "410-484-8080";
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

			String queryString = String.format("cellPhone=%s", URLEncoder.encode(cellPhone, charset)

			);

			// creates a new URL out of the endpoint, terurnType and queryString
			URL postRequest = new URL(endpoint + id + "?" + queryString);
			HttpURLConnection connection = (HttpURLConnection) postRequest.openConnection();
			connection.setRequestMethod("PUT");

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