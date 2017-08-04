package com.juhyung.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpServer {

	private static String HOST = "127.0.0.1"; //localhost 
	private static int PORT = 8080;
	private static Logger logger = LoggerFactory.getLogger(HttpServer.class);
	
	public void run() throws Exception{
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

		ServerSocket serverSocket = new ServerSocket(PORT);
		logger.info("server start");
		Socket clientSocket = serverSocket.accept();
		logger.info(dayTime.format(new Date(System.currentTimeMillis())) + "client connection");
		
		RequestHandler requestHandler = new RequestHandler();
		Request request = requestHandler.handle(clientSocket);
		logger.info(request.toString());
		
		
		clientSocket.close();
		serverSocket.close();
	}
}
