package account;

import com.bank.grpc.Account.TransactionRequest;

import com.bank.grpc.Account.APIResponse;
import com.bank.grpc.Account.Empty;
import com.bank.grpc.accountGrpc.accountImplBase;

import io.grpc.stub.StreamObserver;

public class AccountService extends accountImplBase{

	//Check balance function, Server Stream
	@Override
	public void checkBalance(com.bank.grpc.Account.Empty request,
			StreamObserver<com.bank.grpc.Account.APIResponse> responseObserver) {
		
		//to print when here
		System.out.println("Checking Balance...");
		
		//response variable
		APIResponse.Builder response = APIResponse.newBuilder();
		//Setting response code and message
		response.setResponsecode(0).setResponsemessage("Your current balance is €1000");	
		//Sending response back
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
		
	}

	//Display Transaction function, biderctional stream
	@Override
	public StreamObserver<TransactionRequest> displayTransactions(
			StreamObserver<com.bank.grpc.Account.APIResponse> responseObserver) {
			
		//Making stream object and returning it as response stream
		return new StreamObserver<TransactionRequest>() {
			//overriding on next function for stream
			@Override
			public void onNext(TransactionRequest value) {
				//displaying transaction
				int transactionCount = value.getNumberoftransaction();
			
				String transaction = "This is Transaction " + transactionCount + "\n";
				//Setting up response code and message
				responseObserver.onNext(APIResponse.newBuilder().setResponsecode(0).setResponsemessage(transaction).build());	
			
				
			}
			
			@Override
			public void onError(Throwable t) {
				System.out.println("Encountered error");				
			}

			@Override
			public void onCompleted() {
				responseObserver.onCompleted();
			}
						
		};
	}
	
	//Client stream
	@Override
	public StreamObserver<com.bank.grpc.Account.Empty> directDebit(
			StreamObserver<com.bank.grpc.Account.APIResponse> responseObserver) {
		//Making stream object and returning it as response stream
		return new StreamObserver<Empty>() {
			@Override
			public void onNext(Empty value) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				System.out.println("Encountered error");				
			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				//Setting up response code and message
				responseObserver.onNext(APIResponse.newBuilder().setResponsecode(0).setResponsemessage("Direct Debit Account is now setup!").build());
				responseObserver.onCompleted();
				
			}

			
						
		};
	}
	

}



