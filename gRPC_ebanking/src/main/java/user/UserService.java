package user;

import com.bank.grpc.User.APIResponse;
import com.bank.grpc.User.Empty;
import com.bank.grpc.User.LoginRequest;
import com.bank.grpc.userGrpc.userImplBase;

import io.grpc.stub.StreamObserver;

public class UserService extends userImplBase{

	@Override
	public void login(LoginRequest request, StreamObserver<APIResponse> responseObserver) {
		
		System.out.println("Logged in");
		
		String username = request.getUsername();
		String password = request.getPassword();
		//get user and password and send response
		APIResponse.Builder response = APIResponse.newBuilder();
		if (username.equals(password)) {
			response.setResponsecode(0).setResponsemessage("Succesful");	
		}
		else {
			response.setResponsecode(100).setResponsemessage("Incorrect!");
		}
		
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

	@Override
	public void logout(Empty request, StreamObserver<APIResponse> responseObserver) {
		APIResponse.Builder response = APIResponse.newBuilder();
		response.setResponsecode(0).setResponsemessage("Loggged out");	
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

	
}
