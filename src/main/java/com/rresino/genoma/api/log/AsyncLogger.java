package com.rresino.genoma.api.log;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncLogger {

	@Async
	public void logItem(String textToLog) {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Log item: "+textToLog);
				
	}
	
}
