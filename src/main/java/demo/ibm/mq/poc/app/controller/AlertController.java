package demo.ibm.mq.poc.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlertController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${ibm.mq.queue}")
    private String queueName;


    @PostMapping("/send")
    public void sendAlert(@RequestBody String message) {
        jmsTemplate.convertAndSend(queueName, message);
        System.out.println("Message sent to MQ: " + message);
    }
}

