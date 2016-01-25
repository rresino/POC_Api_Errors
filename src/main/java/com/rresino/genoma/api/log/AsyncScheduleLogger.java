package com.rresino.genoma.api.log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AsyncScheduleLogger {

	final protected int MAX_ITEMS_TO_SEND = 5;
	protected List<String> messagesToLog = Collections.synchronizedList(new ArrayList<String>());
	
	@Async
	public void logItem(String textToLog) {
		
		messagesToLog.add(textToLog);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Log item ("+messagesToLog.size()+"): "+textToLog);
	}
	
	@Scheduled(fixedDelay=5000)
	public void sendMessagesToDG() {
		ArrayList<String> buffer = new ArrayList<String>();
		System.out.println("Send messages to DG ("+messagesToLog.size()+"):");
		
		if (!messagesToLog.isEmpty()) {
			for (int i = 0; i < messagesToLog.size() && i < MAX_ITEMS_TO_SEND; i++) {
				buffer.add(messagesToLog.get(i));
				messagesToLog.remove(i);
			}
			
			for (String text : buffer) {
				System.out.println("Send msg: "+text);				
			}
		}		
	}
}
