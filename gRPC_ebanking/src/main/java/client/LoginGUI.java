package client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.*;

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

public class LoginGUI  implements ActionListener {
	static JFrame frame = new JFrame();
	static JButton button = new JButton("Login");
	static JPanel panel = new JPanel();
	static JLabel userLabel;
	static JTextField userText = new JTextField();
	static JLabel passLabel;
	static JPasswordField passText= new JPasswordField();
	
	static JLabel success;
	static userBlockingStub userStub;
	static ManagedChannel channel;
	
	
	LoginGUI(userBlockingStub user, ManagedChannel chan){
		userStub = user;
		channel = chan;
	
		frame.setSize(350, 250);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setLayout(null);
		
		frame.add(panel);
		
		panel.setLayout(null);
		
		JLabel welcomeLabel = new JLabel("Welcome to the Bank");
		welcomeLabel.setBounds(100, 10, 150, 40);
		panel.add(welcomeLabel);
		
		
		userLabel = new JLabel("User");
		userLabel.setBounds(10, 50, 80, 25);
		panel.add(userLabel);
		
		userText.setBounds(100, 50, 165, 25);
		panel.add(userText);
		
		passLabel = new JLabel("Password");
		passLabel.setBounds(10, 90, 80, 25);
		panel.add(passLabel);
		
		passText.setBounds(100, 90, 165, 25);
		panel.add(passText);

		button.setBounds(100, 140, 80, 25);
		button.addActionListener(this);
		panel.add(button);
		
		
		success = new JLabel("");
		success.setBounds(100, 170, 300, 25);
		panel.add(success);
		
		frame.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String user = userText.getText();
		String pass = passText.getText();
		if (user.equals("") || pass.equals(""))
		{
			success.setText("Not successful!");
			return;
		}
		//send user and password to client gRPC and get response
		LoginRequest loginrequest = LoginRequest.newBuilder().setUsername(user).setPassword(pass).build();
		
		APIResponse response = userStub.login(loginrequest);
		
		System.out.println(response.getResponsemessage());
		if (response.getResponsecode() == 0) {
			success.setText("Login Successful!");
			
			
			success.setText("");
			userText.setText("");
			passText.setText("");
			
			BankGUI bank = new BankGUI(userStub, user, channel);
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		}
		else {
			success.setText("Not successful!");
		}
	}

}
