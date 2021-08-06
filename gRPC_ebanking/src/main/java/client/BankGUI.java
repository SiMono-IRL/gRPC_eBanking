package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.bank.grpc.userGrpc;
import com.bank.grpc.Account.TransactionRequest;
import com.bank.grpc.User.APIResponse;
import com.bank.grpc.User.Empty;
import com.bank.grpc.Account;
import com.bank.grpc.User.LoginRequest;
import com.bank.grpc.accountGrpc;
import com.bank.grpc.userGrpc.userBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.stub.StreamObserver;
import com.bank.grpc.accountGrpc.accountStub;
import com.bank.grpc.accountGrpc.accountBlockingStub;


public class BankGUI implements ActionListener {
	
	static JFrame frame = new JFrame();
	
	static JButton logoutButton = new JButton("LogOut!");
	static JButton checkButton = new JButton("Check Balance");
	static JButton displayButton = new JButton("Display Transactions");
	static JButton debitButton = new JButton("Direct Debit");
	
	
	static JTextArea queries = new JTextArea("");
	static String out;
	
	static JPanel panel = new JPanel();
	
	static JLabel transactionLabel;
	static JLabel welcomeLabel;
	
	static JTextField transactionText = new JTextField();
	
	static JFrame prev_login;
	
	static userBlockingStub userStub;

	static accountBlockingStub accountStub;
	static accountStub asynAccountStub;
	
	static ManagedChannel channel;
	
	BankGUI(userBlockingStub user, String name, ManagedChannel chan){
		
		userStub = user;
		channel = chan;
		frame.setSize(600, 600);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.setLayout(null);
		welcomeLabel = new JLabel("Welcome to your account " + name + "!");
		welcomeLabel.setBounds(80, 10, 250, 25);
		panel.add(welcomeLabel);
		frame.setVisible(true);
		
		queries.setBounds(200, 100, 300, 300);
		panel.add(queries);
		
		transactionLabel = new JLabel("Enter Number of Transactions");
		transactionLabel.setBounds(200, 70, 200, 25);
		panel.add(transactionLabel);
		
		transactionText.setBounds(420, 70, 120, 25);
		panel.add(transactionText);
		
		checkButton.setBounds(10, 100, 150, 25);
		checkButton.addActionListener(this);
		panel.add(checkButton);
		
		displayButton.setBounds(10, 130, 170, 25);
		displayButton.addActionListener(this);
		panel.add(displayButton);
		
		debitButton.setBounds(10, 160, 150, 25);
		debitButton.addActionListener(this);
		panel.add(debitButton);
		
		
		logoutButton.setBounds(10, 300, 80, 25);
		logoutButton.addActionListener(this);
		panel.add(logoutButton);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == logoutButton)
		{				
			//Calling the logout function
			Empty request = Empty.newBuilder().build();
			APIResponse response = userStub.logout(request);
			System.out.println(response.getResponsemessage());
			if (response.getResponsecode() == 0) {
				LoginGUI gui = new LoginGUI(userStub, channel);
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
		}
		else if (e.getSource() == checkButton) {
			// check balance
			//Calling the check account balance function
			accountStub = accountGrpc.newBlockingStub(channel);
			Account.Empty request = Account.Empty.newBuilder().build();
			Iterator<com.bank.grpc.Account.APIResponse> response = accountStub.checkBalance(request);
			//Loop due to stream
			out = "";
			while(response.hasNext()) {
				Account.APIResponse respon = response.next();
				out += respon.getResponsemessage() + "\n";
		     }
			queries.setText(out);
			
		}
		else if (e.getSource() == displayButton) {
			// display transactions
			
			out = "";
			int transaction = 0;
			try{
	            transaction = Integer.parseInt(transactionText.getText());
	        }
	        catch (NumberFormatException ex){
	            transactionText.setText("Enter valid number!");
	            return;
	        }			
			
			asynAccountStub = accountGrpc.newStub(channel);
			//Making a stream object to handle biderectional stream
			StreamObserver<TransactionRequest> requestObserver = asynAccountStub.displayTransactions(new StreamObserver<Account.APIResponse>() {

				@Override
				public void onNext(com.bank.grpc.Account.APIResponse value) {
					// TODO Auto-generated method stub
					out += value.getResponsemessage() + "\n";
				}

				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onCompleted() {
					// TODO Auto-generated method stub
					queries.setText(out);
				}
				
			});
			
			//Loop bidirectional stream
			TransactionRequest[] requests = new TransactionRequest[transaction];
			for (int i=1;i<=transaction;i++)
			{
				Account.TransactionRequest request = Account.TransactionRequest.newBuilder().setNumberoftransaction(i).build();
				requests[i-1] = request;
			}
			
			

			//Loop bidirectional stream
		    for (TransactionRequest r : requests) {
		      requestObserver.onNext(r);
		    }

			requestObserver.onCompleted();
			
		}
		else if (e.getSource() == debitButton) {
			// direct debit
			out = "";
			asynAccountStub = accountGrpc.newStub(channel);
			Account.Empty request = Account.Empty.newBuilder().build();

			//Making a stream object to handle client stream
			StreamObserver<Account.APIResponse> responseObserver = new StreamObserver<Account.APIResponse>() {
			    @Override
			    public void onNext(Account.APIResponse value) {
			    	out += value.getResponsemessage() + "\n";
			    	
			    }

			    @Override
			    public void onError(Throwable t) {
			    }

			    @Override
			    public void onCompleted() {
			    	queries.setText(out);
			    }
			  };
			  
			 StreamObserver<Account.Empty> requestObserver = asynAccountStub.directDebit(responseObserver);
			 requestObserver.onNext(request);
			 requestObserver.onCompleted();
			
		}		
		
	}
}
