package server;

import io.grpc.ServerBuilder;

import java.io.IOException;

import io.grpc.Server;
import user.UserService;
import account.AccountService;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.net.InetAddress;


public class GRPCServer {

	public static void main(String[] args) throws Exception {
			//Main server file that starts the gRPC
		try {
            // Create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            int port = 5001;
            //Create a server
            Server server = ServerBuilder.forPort(port).addService(new UserService()).addService(new AccountService()).build();
            
            // Register a service
            ServiceInfo serviceInfo = ServiceInfo.create("_http._tcp.local.", "example", port, "path=index.html");
            jmdns.registerService(serviceInfo);
            
    		try {
    			server.start();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		
    		System.out.println("jmDNS Service Started!");
    		
    		try {
    			server.awaitTermination();
    		} catch (InterruptedException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
		
		
		
		
	}
}
