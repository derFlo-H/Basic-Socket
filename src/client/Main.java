package client;
import java.net.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		
		try {
			
			Socket s = new Socket("localhost", 6666);
			DataOutputStream dOut = new DataOutputStream(s.getOutputStream());
			DataInputStream dIn = new DataInputStream(s.getInputStream());
			
			dIn.close();
			dOut.close();
			s.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
 
	}
	
	public static String read(DataInputStream dIn) {
		String text = "";
		
		try {
			
			text = (String) dIn.readUTF();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return text;
	}
	
	public static void write(DataOutputStream dOut ,String text) {
		
		try {
			
			dOut.writeUTF(text);
			dOut.flush();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
				
	}

}
