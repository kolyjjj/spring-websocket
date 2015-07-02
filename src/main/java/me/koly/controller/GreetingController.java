package me.koly.controller;

import me.koly.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Controller;

import javax.swing.text.DateFormatter;
import java.util.Date;

@Controller
public class GreetingController {
    private static int count = 0;
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private TaskScheduler taskScheduler;


    @MessageMapping("/one")
//    @SendTo("/topic/greetings")
    public void greeting(String message) throws Exception {
//        Thread.sleep(3000); // simulated delay
        taskScheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                String temp = "Hi, Websocket + " + (count++);
                simpMessagingTemplate.convertAndSend("/topic/greetings", temp);
            }
        }, new Date(), 3000);
//        return new Greeting("Hello, " + message + "!");
    }

}
