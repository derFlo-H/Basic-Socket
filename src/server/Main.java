package server;

import java.net.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		
		try {
			
			ServerSocket ss = new ServerSocket(6666);
			Socket s = ss.accept();
			
			DataInputStream dIn = new DataInputStream(s.getInputStream());
			DataOutputStream dOut = new DataOutputStream(s.getOutputStream());
			
			dOut.close();
			dIn.close();
			s.close();
			ss.close();
			
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
