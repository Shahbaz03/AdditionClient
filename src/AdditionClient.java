import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class AdditionClient {

	public static void main(String[] args) {
		System.out.println("---------Client--------");
		String host = "localhost";
		int port = 8080;
		Socket clientSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		InputStreamReader ir = null;
		BufferedReader stdIn = null;
		
		try {
			clientSocket = new Socket(host, port);
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			ir = new InputStreamReader(clientSocket.getInputStream());
			in = new BufferedReader(ir);
			stdIn = new BufferedReader(new InputStreamReader(System.in));
			
			out.println("Add");
			System.out.println("Enter the 1st Numnber:");
			out.println(stdIn.readLine());
			System.out.println("Enter the 2nd Numnber:");
			out.println(stdIn.readLine());
			
			System.out.println("The Result from the server is--"+in.readLine());
		} catch (UnknownHostException e) {
			System.exit(1);
		} catch(IOException e){
			System.exit(1);
		}
		

	}

}
