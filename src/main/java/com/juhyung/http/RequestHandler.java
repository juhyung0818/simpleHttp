package com.juhyung.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestHandler {

	private static Logger logger = LoggerFactory.getLogger(RequestHandler.class);

	public Request handle(Socket clientSocket) throws IOException {
		logger.info("request handler....");

		Request request = new Request();
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		request.parseRequestLine(in.readLine(), in.readLine());
		// headers
		String line = null;
		while ((line = in.readLine()) != null && !"".equals(line)) {
			System.out.println(line.split(":")[0]+" "+ line.split(":")[1]);
			request.addHeader(line.split(":")[0], line.split(":")[1]);
		}

		return request;
	}
}
// RequestHandler클래스는 Client Socket을 파라미터로 받아 Request객체를 반환하는 handle메소드를 가지고 있다.
// handle메소드는 socket의 inputStream을 이용하여 정보를 읽어들여 httpVersion, headers, method,
// requestTarget의 값을 초기화 한다.
