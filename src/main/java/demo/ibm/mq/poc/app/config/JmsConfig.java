package demo.ibm.mq.poc.app.config;

import com.ibm.mq.jms.MQQueueConnectionFactory;
import com.ibm.msg.client.jakarta.wmq.WMQConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

@Configuration
@EnableJms
public class JmsConfig {

    @Bean
    public ConnectionFactory connectionFactory() throws JMSException {
        MQQueueConnectionFactory factory = new MQQueueConnectionFactory();
        factory.setHostName("localhost");
        factory.setPort(1414);
        factory.setQueueManager("QM1");
        factory.setChannel("SYSTEM.DEF.SVRCONN");
        factory.setStringProperty(WMQConstants.WMQ_CONNECTION_NAME_LIST, "localhost(1414)");
        return factory;
    }

    @Bean
    public JmsTemplate jmsTemplate(jakarta.jms.ConnectionFactory connectionFactory) {
        return new JmsTemplate(connectionFactory);
    }

//    @Bean
//    public JmsTemplate jmsTemplate(SingleConnectionFactory singleConnectionFactory) {
//        return new JmsTemplate(singleConnectionFactory);
//    }


}
