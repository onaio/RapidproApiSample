package com.java.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
 
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
import org.json.JSONObject;
 
public class HttpPostReq
{
	private static final String AUTH_TOKEN = "2b45b38823ada463efe0871796befa0f7ce565a8";
	
    public static void main(String args[]) throws JSONException, UnsupportedEncodingException, IOException
    {
        String restUrl="http://rapidpro.ona.io/api/v1/contacts.json";
        
        String username="myusername";
        String password="mypassword";
        JSONObject user=new JSONObject();
        user.put("name", "davy jones");
        user.put("email", "davy@gmail.com");
        
        String jsonData=user.toString();
        jsonData = "{ \"name\": \"Lokodo Vapnik\", \"language\": \"eng\", \"urns\": [\"tel:+254726279352\", \"twitter:ben\"] }";
        
        HttpPostReq httpPostReq = new HttpPostReq();
        HttpGet httpPost = httpPostReq.createHttpGetConnection(restUrl , username, password);
        httpPostReq.executeHttpGetRequest(httpPost);
    }
    
    HttpPost createConnectivity(String restUrl, String username, String password)
    {
        HttpPost post = new HttpPost(restUrl);
        String auth=new StringBuffer(username).append(":").append(password).toString();
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String(encodedAuth);
        post.setHeader("AUTHORIZATION", "Token " + AUTH_TOKEN);
        post.setHeader("Content-Type", "application/json");
        post.setHeader("Accept", "application/json");
        post.setHeader("X-Stream" , "true");
        return post;
    }
     
    HttpGet createHttpGetConnection(String restUrl, String username, String password)
    {
        HttpGet get = new HttpGet(restUrl);
        String auth=new StringBuffer(username).append(":").append(password).toString();
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String(encodedAuth);
        get.setHeader("AUTHORIZATION", "Token " + AUTH_TOKEN);
        get.setHeader("Content-Type", "application/json");
        get.setHeader("Accept", "application/json");
        get.setHeader("X-Stream" , "true");
        return get;
    }
    
    void executeReq(String jsonData, HttpPost httpPost)
    {
        try{
            executeHttpRequest(jsonData, httpPost);
        }
        catch (UnsupportedEncodingException e){
            System.out.println("error while encoding api url : "+e);
        }
        catch (IOException e){
            System.out.println("ioException occured while sending http request : "+e);
        }
        catch(Exception e){
            System.out.println("exception occured while sending http request : "+e);
        }
        finally{
            httpPost.releaseConnection();
        }
    }
     
    void executeHttpRequest(String jsonData,  HttpPost httpPost)  throws UnsupportedEncodingException, IOException
    {
        HttpResponse response=null;
        String line = "";
        StringBuffer result = new StringBuffer();
        httpPost.setEntity(new StringEntity(jsonData));
        HttpClient client = HttpClientBuilder.create().build();
        response = client.execute(httpPost);
        System.out.println("Post parameters : " + jsonData );
        System.out.println("Response Code : " +response.getStatusLine().getStatusCode());
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        while ((line = reader.readLine()) != null){ result.append(line); }
        System.out.println(result.toString());
    }
    
    void executeHttpGetRequest(HttpGet httpPost)  throws UnsupportedEncodingException, IOException
    {
        HttpResponse response=null;
        String line = "";
        StringBuffer result = new StringBuffer();
        HttpClient client = HttpClientBuilder.create().build();
        response = client.execute(httpPost);
        System.out.println("Response Code : " +response.getStatusLine().getStatusCode());
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        while ((line = reader.readLine()) != null){ result.append(line); }
        System.out.println(result.toString());
    }
}
