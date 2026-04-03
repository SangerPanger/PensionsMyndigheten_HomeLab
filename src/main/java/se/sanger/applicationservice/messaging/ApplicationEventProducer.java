package se.sanger.applicationservice.messaging;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

//Skickar vidare JMS-data till ActiveMQ

@Component
public class ApplicationEventProducer {

    private final JmsTemplate jmsTemplate;
    private final String queueName;

    //Själva "Kö-id"
    public ApplicationEventProducer(JmsTemplate jmsTemplate,
                                    @Value("${queue.application-submitted}") String queueName) {
        this.jmsTemplate = jmsTemplate;
        this.queueName = queueName;
    }

    public void send(ApplicationSubmittedEvent event) {
        jmsTemplate.convertAndSend(queueName, event);
    }
}