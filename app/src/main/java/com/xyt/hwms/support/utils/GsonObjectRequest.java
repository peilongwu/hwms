package com.xyt.hwms.support.utils;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GsonObjectRequest<T> extends JsonRequest<T> {

    private final Gson mGson = new Gson();
    private final Class<T> mClazz;
    private int statusCode;

    public GsonObjectRequest(int method, String url, Class<T> clazz, String jsonRequest, Listener<T> listener, ErrorListener errorListener) {
        super(method, url, (jsonRequest == null) ? null : jsonRequest, listener, errorListener);
        this.mClazz = clazz;
    }

    public GsonObjectRequest(String url, Class<T> clazz, Map mapRequest, Listener<T> listener, ErrorListener errorListener) {
        this(Method.GET, url + transferParams(mapRequest), clazz, null, listener, errorListener);
    }

    private static String transferParams(Map mapRequest) {
        StringBuilder sb = new StringBuilder();
        if (mapRequest != null) {
            Iterator<Map.Entry> entries = mapRequest.entrySet().iterator();
            sb.append("?");
            while (entries.hasNext()) {
                Map.Entry entry = entries.next();
                sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
        }
        return sb.toString();
    }

    public GsonObjectRequest(String url, Class<T> clazz, String jsonRequest, Listener<T> listener, ErrorListener errorListener) {
        this(jsonRequest == null ? Method.GET : Method.POST, url, clazz, jsonRequest, listener, errorListener);
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        setStatusCode(response.statusCode);
        try {
            String jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            Log.d("Gson_log", jsonString);
            return Response.success(mGson.fromJson(jsonString, mClazz), HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            Log.d("eee", "UnsupportedEncodingException");
            return Response.error(new ParseError(e));
        } catch (JsonSyntaxException e) {
            Log.d("eeeeee", "JsonSyntaxException");
            return Response.error(new ParseError(e));
        }
    }

//    @Override
//    public Map<String, String> getHeaders() throws AuthFailureError {
//        Map<String, String> headers = new HashMap<String, String>();
//        headers.put("Charset", "UTF-8");
//        headers.put("Content-Type", "application/x-javascript");
//        headers.put("Accept-Encoding", "gzip,deflate");
//        return super.getHeaders();
//    }
}
