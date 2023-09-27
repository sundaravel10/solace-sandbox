import com.solacesystems.jms.SolConnectionFactory;
import com.solacesystems.jms.SolJmsUtility;
import util.ConnectionUtil;

import javax.jms.*;
import java.util.Scanner;

public class TopicPublisher {

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.createSession();
        connection.start();
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("SANDBOX/PLAY");
        MessageProducer messageProducer = session.createProducer(topic);
        Scanner inputScanner = new Scanner(System.in);

        try{
            while(true){
                System.out.print("Enter a message (type 'close' to exit): ");
                String input = inputScanner.nextLine();

                if("close".equalsIgnoreCase(input)){
                    break;
                }

                TextMessage textMessage = session.createTextMessage(input);
                messageProducer.send(textMessage);
                System.out.println("Published message: " + textMessage.getText());
            }
        }finally {
            messageProducer.close();
            session.close();
            connection.close();
        }


    }
}
