package client;

import com.bank.grpc.userGrpc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.bank.grpc.User.APIResponse;
import com.bank.grpc.User.LoginRequest;
import com.bank.grpc.userGrpc.userBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import java.io.IOException;

public class GRPCClient{
	
	static userBlockingStub userStub;
	
	
	
	private static class SampleListener implements ServiceListener {
        @Override
        public void serviceAdded(ServiceEvent event) {
            //System.out.println("Service added: " + event.getInfo());
            
            
            
        }

        @Override
        public void serviceRemoved(ServiceEvent event) {
            //System.out.println("Service removed: " + event.getInfo());
        }

        @Override
        public void serviceResolved(ServiceEvent event) {
            //System.out.println("Service resolved: " + event.getInfo());
            
          //Getting info from jmDNS
            ServiceInfo serviceInfo = event.getInfo();
            int port = serviceInfo.getPort();            
            
            //Main client file that finds and connect with server and starts GUI
    		ManagedChannel channel =  ManagedChannelBuilder.forAddress("localhost", port).usePlaintext().build();
    		
    		userStub = userGrpc.newBlockingStub(channel);
    		
    		LoginGUI gui = new LoginGUI(userStub, channel);
        }
    }
	
	public static void main(String[] args) throws Exception {
		
		try {
            // Create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            // Add a service listener
            jmdns.addServiceListener("_http._tcp.local.", new SampleListener());

            // Wait for 30secs
            Thread.sleep(30000);
        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
		
		
	}

	

}
