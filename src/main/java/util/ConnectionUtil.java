package util;

import com.solacesystems.jms.SolConnectionFactory;
import com.solacesystems.jms.SolJmsUtility;

import javax.jms.Connection;
import javax.jms.Session;

public class ConnectionUtil {
    public static Connection createConnection() throws Exception {
        SolConnectionFactory connectionFactory = SolJmsUtility.createConnectionFactory();
        connectionFactory.setHost("tcps://mr-connection-hpj6fgyitqd.messaging.solace.cloud:55443");
        connectionFactory.setUsername("solace-cloud-client");
        connectionFactory.setPassword("2k8nlspc3hhstr4cshdt3c39sh");
        connectionFactory.setVPN("MY_SANDBOX_VPN");

        return connectionFactory.createConnection();
    }

}
