package com.group.mugspot.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GooglePlaces {
	//change to a try catch exception eventually that redirects users to an error page
	public static ArrayList<String> getAPI(String placeID) throws ClientProtocolException, IOException, ParseException {

			String url = "https://maps.googleapis.com/maps/api/place/details/json?placeid=" + placeID
					 //"&key=AIzaSyDM0lmlS-ptLTR9KnDZSGUyijPQ5H1fsZs";
				+ "&key=AIzaSyDf7pUxPphWt00e3PxLVBJjYsChNjrJ91Y";

			HttpClient client = HttpClientBuilder.create().build();
			
			HttpGet request = new HttpGet(url);
			
			HttpResponse response = client.execute(request);
   
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line.trim());

			}

			request.releaseConnection();

			JsonElement jelement = new JsonParser().parse(result.toString());
		
			JsonObject jobject = jelement.getAsJsonObject();
			
			jobject = jobject.getAsJsonObject("result");
			
			ArrayList<String> info = new ArrayList<String>();

			JsonElement name = jobject.get("name");
			JsonElement address = jobject.get("formatted_address");
			JsonElement phoneNumber = jobject.get("formatted_phone_number");
		//	JsonElement icon = jobject.get("icon");
			
			String shop_name = name.toString().replaceAll("\"", "");
			String phone = phoneNumber.toString().replaceAll("\"", "");
			String shop_address = address.toString().replaceAll("\"", "");
		//	String iconurl = (icon.toString().replaceAll("\"", ""));
			
			info.add(shop_name);
			info.add(phone);
			info.add(shop_address);
			
			
			JsonArray photos = jobject.getAsJsonArray("photos");
			 for (int i = 0; i<=photos.size() -1; i++) {
			
			JsonObject PL =  photos.get(i).getAsJsonObject();
			
			int height = PL.get("height").getAsInt();
			int width = PL.get("width").getAsInt();
			String photoRef = PL.get("photo_reference").getAsString();
			//only getting first attrib for now, iterate through array if more than one
			String attribution = PL.get("html_attributions").getAsJsonArray().get(0).getAsString();
			
			String maxwidth = ("maxwidth=400" );
			String maxheight = ("maxheight=" + height);
			String ref = ("&photoreference=" + photoRef);
			String key = ("&key=AIzaSyDf7pUxPphWt00e3PxLVBJjYsChNjrJ91Y");
			//String key = ("&key=AIzaSyDM0lmlS-ptLTR9KnDZSGUyijPQ5H1fsZs");
				
			String purl = "https://maps.googleapis.com/maps/api/place/photo?" + maxwidth + ref + key;	
			info.add(purl);
			}
			
		
			 
		return info;	
		}
	
	
//	public static void main(String[] args) throws ClientProtocolException, IOException, ParseException {
//		System.out.println(getAPI("ChIJtzwfLTItO4gRxwpKgcgFomE"));
//		}

}   