package com.java.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Main {

	private static final String AUTH_TOKEN = "";
	private static final String BASE_URL = "http://rapidpro.ona.io/";
	
	private static String testString = "{ \"form_data_definition_version\": \"8\", \"form\": { \"default_bind_path\": \"/model/instance/FWNewHH\", \"bind_type\": \"household\", \"fields\": [ { \"name\": \"id\", \"shouldLoadValue\": true }, { \"name\": \"location_name\", \"bind\": \"/model/instance/FWNewHH/location_name\" }, { \"name\": \"existing_location\", \"bind\": \"/model/instance/FWNewHH/existing_location\" }, { \"name\": \"today\", \"bind\": \"/model/instance/FWNewHH/today\" }, { \"name\": \"start\", \"bind\": \"/model/instance/FWNewHH/start\" }, { \"name\": \"end\", \"bind\": \"/model/instance/FWNewHH/end\" }, { \"name\": \"FWNHREGDATE\", \"bind\": \"/model/instance/FWNewHH/FWNHREGDATE\" }, { \"name\": \"FWGOBHHID\", \"bind\": \"/model/instance/FWNewHH/FWGOBHHID\" }, { \"name\": \"FWJIVHHID\", \"bind\": \"/model/instance/FWNewHH/FWJIVHHID\" }, { \"name\": \"FWNHNEARTO\", \"bind\": \"/model/instance/FWNewHH/FWNHNEARTO\" }, { \"name\": \"FWNHHHGPS\", \"bind\": \"/model/instance/FWNewHH/FWNHHHGPS\" }, { \"name\": \"FWHOHFNAME\", \"bind\": \"/model/instance/FWNewHH/FWHOHFNAME\" }, { \"name\": \"FWHOHLNAME\", \"bind\": \"/model/instance/FWNewHH/FWHOHLNAME\" }, { \"name\": \"FWHOHBIRTHDATE\", \"bind\": \"/model/instance/FWNewHH/FWHOHBIRTHDATE\" }, { \"name\": \"FWHOHGENDER\", \"bind\": \"/model/instance/FWNewHH/FWHOHGENDER\" }, { \"name\": \"FWNHHMBRNUM\", \"bind\": \"/model/instance/FWNewHH/FWNHHMBRNUM\" }, { \"name\": \"FWNHHMWRA\", \"bind\": \"/model/instance/FWNewHH/FWNHHMWRA\" }, { \"name\": \"join_names\", \"bind\": \"/model/instance/FWNewHH/join_names\" }, { \"name\": \"MWRA\", \"bind\": \"/model/instance/FWNewHH/MWRA\" } ], \"sub_forms\": [ { \"name\": \"elco_registration\", \"bind_type\": \"elco\", \"default_bind_path\": \"/model/instance/FWNewHH/woman\", \"fields\": [ { \"name\": \"id\", \"shouldLoadValue\": true }, { \"name\": \"relationalid\", \"shouldLoadValue\": true }, { \"name\": \"WomanREGDATE\", \"bind\": \"/model/instance/FWNewHH/woman/REGDATE\" }, { \"name\": \"GOBHHID\", \"bind\": \"/model/instance/FWNewHH/woman/GOBHHID\" }, { \"name\": \"JiVitAHHID\", \"bind\": \"/model/instance/FWNewHH/woman/JiVitAHHID\" }, { \"name\": \"FWWOMFNAME\", \"bind\": \"/model/instance/FWNewHH/woman/FWWOMFNAME\" }, { \"name\": \"FWWOMLNAME\", \"bind\": \"/model/instance/FWNewHH/woman/FWWOMLNAME\" }, { \"name\": \"FWWOMNID\", \"bind\": \"/model/instance/FWNewHH/woman/FWWOMNID\" }, { \"name\": \"FWWOMBID\", \"bind\": \"/model/instance/FWNewHH/woman/FWWOMBID\" }, { \"name\": \"FWHUSNAME\", \"bind\": \"/model/instance/FWNewHH/woman/FWHUSNAME\" }, { \"name\": \"FWBIRTHDATE\", \"bind\": \"/model/instance/FWNewHH/woman/FWBIRTHDATE\" }, { \"name\": \"FWGENDER\", \"bind\": \"/model/instance/FWNewHH/woman/FWGENDER\" }, { \"name\": \"FWWOMAGE\", \"bind\": \"/model/instance/FWNewHH/woman/FWWOMAGE\" }, { \"name\": \"display_age\", \"bind\": \"/model/instance/FWNewHH/woman/display_age\" }, { \"name\": \"FWNHWOMSTRMEN\", \"bind\": \"/model/instance/FWNewHH/woman/FWNHWOMSTRMEN\" }, { \"name\": \"FWNHWOMHUSALV\", \"bind\": \"/model/instance/FWNewHH/woman/FWNHWOMHUSALV\" }, { \"name\": \"FWNHWOMHUSLIV\", \"bind\": \"/model/instance/FWNewHH/woman/FWNHWOMHUSLIV\" }, { \"name\": \"FWNHWOMHUSSTR\", \"bind\": \"/model/instance/FWNewHH/woman/FWNHWOMHUSSTR\" }, { \"name\": \"FWELIGIBLE\", \"bind\": \"/model/instance/FWNewHH/woman/FWELIGIBLE\" } ] } ] } }";
	
	public static void main(String[] args) {

		try {
			
			RapidproService r = new RapidproService();
			String flow_uuid = "8adbace9-1824-4a17-880c-a97629d2b2ae";
			List<String> contacts = new ArrayList<String>();
			contacts.add("jl4ed6bfe0-1a85-4710-91a2-f5eac84d27d6");
			r.startRunFlowForContact(flow_uuid, contacts , null, null, true);
			
			//addContact();
//			JSONObject formDefinition = new JSONObject(testString);
//			String samplePath = "/instance/model/form/default_bind_path";
//			//samplePath = samplePath.startsWith("/") ? samplePath.substring(1) : samplePath;
//			String[] path = samplePath.split("/");
//			
//			String value = getValueForPath(path, formDefinition);
//			System.out.println(value);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getValueForPath(String[] path, JSONObject jsonObject) throws Exception{
        JSONObject object = jsonObject;
        int i = 0;
        while (i < path.length - 1) {
            if (object.has(path[i])) {
                Object o = object.get(path[i]);
                if (o instanceof JSONObject){
                    object = object.getJSONObject(path[i]);
                }
                else if (o instanceof JSONArray){
                    object = object.getJSONArray(path[i]).getJSONObject(0);
                }
            }
            i++;
        }
        return object.get(path[i]).toString();
    }
	
	private static void addContact(){
		String sampleContact = "{ \"name\": \"Lokodo Vapnik\", \"language\": \"eng\", \"urns\": [\"tel:+254726279353\", \"twitter:ben\"], \"group_uuids\": [\"6685e933-26e1-4363-a468-8f7268ab63a9\", \"1281f10a-d5b3-4580-a0fe-92adb97c2d1a\"], \"fields\": { \"nickname\": \"Nickname\", \"side_kick\": \"Side kick\" } }";
		
		String contactsEndPoint = "api/v1/contacts.json";
		sendHttpRequest(contactsEndPoint, sampleContact, "POST");
	}

	private static String sendHttpRequest(String endPoint, String payload){
		try {
			String webPage = BASE_URL + endPoint;
			
			URL url = new URL(webPage);
			
			System.out.println("About to send request to url: " + url.toString());
			
			URLConnection urlConnection = url.openConnection();
			urlConnection.setRequestProperty("Authorization", "Token " + AUTH_TOKEN);
			urlConnection.setRequestProperty("Content-Type", "application/json");
			
			if (payload != null ) {
				urlConnection.setDoOutput(true);
				OutputStream ous = urlConnection.getOutputStream();
				ous.write(payload.getBytes());
			}
			
			InputStream is = urlConnection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			
			int numCharsRead;
			char[] charArray = new char[1024];
			StringBuffer sb = new StringBuffer();
			while ((numCharsRead = isr.read(charArray)) > 0) {
				sb.append(charArray, 0, numCharsRead);
			}
			String result = sb.toString();
			
			System.out.println("*** BEGIN ***\n");
			System.out.println(result);
			System.out.println("\n*** END ***");
			
			return result;
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private static String sendHttpRequest(String endPoint, String payload, String method){
		try {
			String webPage = BASE_URL + endPoint;
			
			URL url = new URL(webPage);
			
			System.out.println("About to send request to url: " + url.toString());
			
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			con.setRequestProperty("Authorization", "Token " + AUTH_TOKEN);
			con.setRequestProperty("Accept", "application/json");
			con.setRequestMethod(method);
			
			OutputStream os = con.getOutputStream();
			os.write(payload.toString().getBytes("UTF-8"));
			os.close();

			//display what returns the POST request
			StringBuilder sb = new StringBuilder();  
			int HttpResult = con.getResponseCode(); 
			if(HttpResult == HttpURLConnection.HTTP_OK){
			    BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),"utf-8"));  
			    String line = null;  
			    while ((line = br.readLine()) != null) {  
			        sb.append(line + "\n");  
			    }  

			    br.close();  

			    System.out.println(""+sb.toString());  

			}else{
			    System.out.println(con.getResponseMessage());  
			}  
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void testRegexExpression(){
		String pattern = "(<model>)(.*)(<instance>)(.*)(<)(.*)(id=\")([a-zA-Z0-9_]*)(\")(.*)(version=\")(\\d*)(\")(.*)(>)(.*)";
	    // Create a Pattern object
	    Pattern r = Pattern.compile(pattern);
	    CharSequence formString = "<model><instance><identitas_ibu_reviewed.xls encounter_type=\"Identitas Ibu\" id=\"Kartu_ibu_1\" version=\"201510220841\">";
		// Now create matcher object.
	    Matcher m = r.matcher(formString );
	    if (m.find( )) {
	    	System.out.println("Found value 0: " + m.group(0) );
	    	System.out.println("Found value 1: " + m.group(1) );
	    	System.out.println("Found value 2: " + m.group(2) );
	    	System.out.println("Found value 3: " + m.group(3) );
	    	System.out.println("Found value 4: " + m.group(4) );
	    	System.out.println("Found value 5: " + m.group(5) );
	    	System.out.println("Found value 6: " + m.group(6) );
	    	System.out.println("Found value 7: " + m.group(7) );
	    	System.out.println("Found value 8: " + m.group(8) );
	    	System.out.println("Found value 9: " + m.group(9) );
	    	System.out.println("Found value 10: " + m.group(10) );
	    	System.out.println("Found value 11: " + m.group(11) );
	    	System.out.println("Found value 12: " + m.group(12) );
	    	System.out.println("Found value 13: " + m.group(13) );
	    	String id = m.group(8);
	    	String version = m.group(12);
	    	System.out.println("Version : " + version);
	    	System.out.println("id : " + id);
	    } else {
	    	System.out.println("NO MATCH");
	    }
	    
	    
	    String test = "identitas_ibu_reviewed.xls".replaceAll("[^A-Za-z0-9_]", "_");
	    System.out.println(test);
	}
}
