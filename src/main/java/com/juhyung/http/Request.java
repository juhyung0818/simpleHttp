package com.juhyung.http;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Request {

	private String httpVersion;
	private String method;
	private Map<String, String> headers;
	private String requestTarget;
	private InputStream bodyInput;
	private InputStream inputStream;

	public Request() {
		httpVersion = "HTTP/1.1";
		headers = new HashMap<String, String>();
	}
	
	public void parseRequestLine(String methodLine, String targetLine) {
		method = methodLine;
		requestTarget = targetLine;
	}
	
	public void addHeader(String key, String value){
		headers.put(key, value);
	}
	
	public String getHeader(String key){
		return headers.get(key);
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getRequestTarget() {
		return requestTarget;
	}

	public void setRequestTarget(String requestTarget) {
		this.requestTarget = requestTarget;
	}

	public InputStream getBodyInput() {
		return bodyInput;
	}

	public void setBodyInput(InputStream bodyInput) {
		this.bodyInput = bodyInput;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	@Override
	public String toString() {
		return "Request [httpVersion:" + httpVersion + ", method:" + method + ", headers:" + headers
				+ ", requestTarget:" + requestTarget + ", bodyInput:" + bodyInput + "]";
	}
	
}

// Request객체는 필드로 httpVersion, headers, method, requestTarget, bodyInput 등을 가지고
// 있다.
