package ie.atu.sw;

import java.net.*;
import static java.lang.System.*;
public class ChatServer{
	private static final int SERVER_PORT = 9999;
	private ServerSocket ss = null; //The main socket of the web server
	private volatile boolean blnKeepRunning; //Volatile prevents the JVM caching the value of blnKeepRunning 
	
	public static void main(String args[]){
		new ChatServer();
	}
	
	//Instantiate the chat server and open a server socket.
	public ChatServer(){
		blnKeepRunning = true;
		try{
			ss = new ServerSocket(SERVER_PORT);	
			var t = new Thread(new Listener(), "Chat Server Main Thread"); //Run the service in its own thread
			t.start(); //The Hollywood Principle - "Don't Call Us, We'll Call You.". Threads are based on the Template Pattern
			out.println("[INFO] Server Ready...");
		}catch(Exception e){			
			e.printStackTrace();	
		}
	}
	
	//Listener is a chat service running on port 9999
	private class Listener implements Runnable{
		public void run(){
			var counter = 0; //Keep track of the number of requests,
			while(blnKeepRunning){ //Keep this thread alive. The thread will die after run() returns
				try {
					var s = ss.accept(); //Accept incoming socket request. This is a blocking method
					new Thread(new Invoker(s), "Request-" + counter).start(); //Off-load the socket connection to the threaded invoker ASAP
					counter++;
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
}