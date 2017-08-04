package com.juhyung.http;

import java.io.File;

public class DefaultServlet {

	public void Service(Request request, Response response){
		
		File file = new File(request.getRequestTarget() + "html");
		
		
		
	}
}
