package com.mp.collegefaction.collegefaction.utilities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.mp.collegefaction.collegefaction.MainActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by pranjul on 19/4/18.
 */

public class NetworkUtils {

    public static final int GET_LOGIN_URL = 0;

    private static final String base_url_string="http://192.168.43.171/college_fact/public/api";
    private static final String login_url="/login";
   // private static final String login_url="";
   // private static final String login_url="";

    public static URL getUrl(int id) throws MalformedURLException {
        URL url ;
        switch (id){
            case GET_LOGIN_URL:
                url = new URL(base_url_string+login_url);
                break;
                default:
                    throw new IllegalArgumentException("invalid value of id "+id);
        }
        return url;
    }

    public static String getResponseFromHttpUrl(URL url, HashMap<String,String> values) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setDoOutput(true);
        //urlConnection.setRequestMethod("POST");
        urlConnection.setRequestProperty("Content-Type","multipart/form-data; charset=utf-8; boundary=" + Double.toString(Math.random()).substring(2));

        try {

            OutputStream out = urlConnection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(getDataString(values));
            writer.flush();
            writer.close();

            int responsecode = urlConnection.getResponseCode();
            Log.v("LOGIN RESPONSE CODE","Code "+responsecode);
            InputStream input;
            if (responsecode < 400)
                input = urlConnection.getInputStream();
            else
                input = urlConnection.getErrorStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            //InputStream in = urlConnection.getInputStream();

            //Scanner scanner = new Scanner(in);
            //scanner.useDelimiter("\\A");

            //boolean hasInput = scanner.hasNext();
            String response = null;
            StringBuilder builder = new StringBuilder();
            while ((response=reader.readLine())!=null){
                builder.append(response).append("\n");
            }
            //if (hasInput) {
           //     response = scanner.next();
            //}
            //scanner.close();
            return builder.toString();
        } finally {
            urlConnection.disconnect();
        }
    }

    private static String getDataString(HashMap<String,String> values) throws UnsupportedEncodingException {
        boolean first=true;
        StringBuilder builder = new StringBuilder();
        for (String key : values.keySet()){
            if (first){
                builder.append(URLEncoder.encode(key,"utf-8")).append("=").append(URLEncoder.encode(values.get(key),"utf-8"));
                first = false;
            } else {
                builder.append("&").append(URLEncoder.encode(key,"utf-8")).append("=").append(URLEncoder.encode(values.get(key),"utf-8"));
            }
        }
        Log.v("LOGIN STRING MESSAGE",builder.toString());
        return builder.toString();

    }

}
