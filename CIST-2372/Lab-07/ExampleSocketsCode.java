
import java.io.*;
import java.net.*;

/****************************************************
	Client Sends String to Server
	Server Reads String and Prints String to DOS Window
 ****************************************************/
 
//===================== Server Code =====================
 
		System.out.println("Executing Server");
		try {
			Socket s1;
			ServerSocket ss;
			BufferedReader br;
			
			ss = new ServerSocket(7777);
			s1 = ss.accept();
			br = new BufferedReader(new InputStreamReader(s1.getInputStream()));
			String str1 = null;
			str=br.readLine();
			System.out.println("Client String = "+str);
			}
		catch (Exception e) {
			System.out.println("Error in socketSetup()");
		}
	


//====================== Client Code ====================== 
 
		System.out.println("Executing Client");
		try {
			Socket s1;
			PrintStream pout;
			
			s1 = new Socket("localhost", 7777);
			pout = new PrintStream(s1.getOutputStream());
			pout.println("Go Braves");
			}
		catch (Exception e) {
			System.out.println("Error in socketSetup()");
		}
