import util.ConnectionUtil;

import javax.jms.*;

public class TopicSubscriber {
    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.createConnection();
        connection.start();
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("SANDBOX/PLAY");
        MessageConsumer messageConsumer = session.createConsumer(topic);

        MessageListener messageListener = message -> {
            if(message instanceof TextMessage){
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("Received Message " + textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        };

        messageConsumer.setMessageListener(messageListener);
        try{
            Thread.sleep(60000);
        }finally {
            messageConsumer.close();
            session.close();
            connection.close();
        }


    }
}
