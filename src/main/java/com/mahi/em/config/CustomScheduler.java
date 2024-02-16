package com.mahi.em.config;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CustomScheduler {
	
	@Primary
	//@Scheduled(cron = "15 * * * * *")
	@Scheduled(fixedDelay = 15000)
	public void scheduleTask()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
            "dd-MM-yyyy HH:mm:ss.SSS");
 
        String strDate = dateFormat.format(new Date());
 
        System.out.println(
            "Cron job Scheduler: Job running at - "
            + strDate);
    }
 
}
