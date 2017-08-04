package com.juhyung.http;

import java.util.HashMap;
import java.util.Map;

public class Request {

	private String httpVersion;
	private String method;
	private Map<String, String> headers;
	private String requestTarget;
	private String bodyInput;

	public Request() {
		httpVersion = "HTTP/1.1";
		headers = new HashMap<String, String>();
	}
	
	public void parseRequestLine(String methodLine, String targetLine) {
		method = methodLine.split("/")[0];
		requestTarget = targetLine;
	}
	
	public void addHeader(String key, String value){
		headers.put(key, value);
	}
	
	public String getHeader(String key){
		return headers.get(key);
	}

	@Override
	public String toString() {
		return "Request [httpVersion:" + httpVersion + ", method:" + method + ", headers:" + headers
				+ ", requestTarget:" + requestTarget + ", bodyInput:" + bodyInput + "]";
	}
	
}

// Request객체는 필드로 httpVersion, headers, method, requestTarget, bodyInput 등을 가지고
// 있다.
