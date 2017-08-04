package com.juhyung.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResponseHandler {

	private static Logger logger = LoggerFactory.getLogger(RequestHandler.class);
	
	public Response handle(String requestTarget, Socket clientSocket) throws Exception{
		logger.info("response handle....");
		
		Response response = new Response();
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		response.setStatusCode("200");
		response.setReasonPhrase("OK");
		
		in.readLine();
		if(in.readLine().equals("localhost:8080")){
			response.addHeader("Server", "127.0.0.1");
			response.addHeader("Content-Length", "119");
			response.addHeader("Content-Type", "text/html");
		}else{
			response.addHeader("Server", "127.0.0.1");
			response.addHeader("Content-Length", "47476");
			response.addHeader("Content-Type", "image/png");
		}
		
		return response;
	}
}
