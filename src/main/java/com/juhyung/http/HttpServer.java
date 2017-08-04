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
	
	public void run() throws Exception{
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

		Logger logger = LoggerFactory.getLogger(HttpServer.class);
		
		ServerSocket serverSocket = new ServerSocket(PORT);
		logger.info("server start");
		Socket clientSocket = serverSocket.accept();
		logger.info(dayTime.format(new Date(System.currentTimeMillis())) + "client connection");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
		
		String line = null;
		
		while((line = in.readLine()) != null){
			logger.info(line);
			if("".equals(line)){
				break;
			}
		}
		
		clientSocket.close();
		serverSocket.close();
	}
}
