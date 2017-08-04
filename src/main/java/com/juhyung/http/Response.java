package com.juhyung.http;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class Response {
	
	private String httpVersion;

	private Map<String, String> headers;
	private String statusLine;
	private OutputStream outputStream;
	private String headerString;
	private String statusCode;
	private String reasonPhrase;
		
	public Response() {
		httpVersion = "HTTP/1.1";
		headers = new HashMap<String, String>();
	}
	
	public void addHeader(String key, String value){
		headers.put(key, value);
	}
	
	public String getStatusLine() {
		return statusLine;
	}
	public void setStatusLine(String statusLine) {
		this.statusLine = statusLine;
	}
	public OutputStream getOutputStream() {
		return outputStream;
	}
	public void setOutputStream(OutputStream outputStream) {
		this.outputStream = outputStream;
	}
	public String getHeaderString() {
		return headerString;
	}
	public void setHeaderString(String headerString) {
		this.headerString = headerString;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getReasonPhrase() {
		return reasonPhrase;
	}
	public void setReasonPhrase(String reasonPhrase) {
		this.reasonPhrase = reasonPhrase;
	}

	@Override
	public String toString() {
		return "Response [httpVersion:" + httpVersion + ", headers:" + headers + ", statusLine:" + statusLine
				+ ", outputStream:" + outputStream + ", headerString:" + headerString + ", statusCode:" + statusCode
				+ ", reasonPhrase:" + reasonPhrase + "]";
	}
}
