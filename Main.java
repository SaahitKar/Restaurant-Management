//SSK190013
//Saahit Karumuri
//CS 4348.003 - OS

import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    public static void main (String[]args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*******Menu*******");
        System.out.println("  #1: PASSKEY");
        System.out.println("  #2: ENCRYPT");
        System.out.println("  #3: DECRYPT");
        System.out.println("  #4: QUIT");
        System.out.println("******************\n");
        //
        try {
            Process mem = Runtime.getRuntime().exec("java EncryptionMemory");
    		InputStream inStream = mem.getInputStream();
    		OutputStream outStream = mem.getOutputStream();
    		Scanner fromMem = new Scanner(inStream);
    		PrintStream toMem = new PrintStream(outStream);
    		for(int i=10; i>=0; i--)
    		{
    			toMem.println("write");
    			toMem.println(i);
    
    			System.out.print("Set to ");
    			toMem.println("read");
    			toMem.flush();
    			System.out.println(fromMem.nextInt());
    		}
    
    		toMem.println("halt");
    		toMem.flush();
    		mem.waitFor();
        } catch(Exception e) {
            
        }
    }
}