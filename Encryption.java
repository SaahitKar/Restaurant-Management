//SSK190013
//Saahit Karumuri
//CS 4348.003 - OS

import java.util.*;

public class Encryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // JAVA Args Usage
        //   System.out.println ("Number of Command Line Argument = " + args.length);
        //     for(int i = 0; i< args.length; i++) {
        //                      System.out.println(String.format("Command Line Argument %d is %s", i, args[i]));
        //              }
        String inputString = "";
        char key[] = {};
        String keyStringVer = "";
        String MessageStringVer = "";

        MessageStringVer = MessageStringVer.toUpperCase();
        char msg[] = MessageStringVer.toCharArray();
        int msgLen = msg.length, i, j;
        char newKey[] = new char[msgLen];
        char encryptedMsg[] = new char[msgLen];
        char decryptedMsg[] = new char[msgLen];
        // inputString = scanner.next();
        while (!(inputString.equals("QUIT"))) {
            // System.out.println("Input: ");
            inputString = scanner.nextLine();
            inputString = inputString.toUpperCase();
            String[] parts = inputString.split(" ");
            if (parts[0].equals("PASSKEY")) {
                // System.out.println();
                keyStringVer = parts[1];
                // System.out.println("Key: ");
                // keyStringVer = scanner.nextLine();
                // keyStringVer = keyStringVer.toUpperCase();
                key = keyStringVer.toCharArray();
                for (i = 0, j = 0; i < msgLen; ++i, ++j) {
                    if (j == key.length)
                        j = 0;
                    newKey[i] = key[j];
                }
                System.out.println("RESULT \n");
            } else if (parts[0].equals("ENCRYPT")) {
                if (keyStringVer.isEmpty()) {
                    System.out.println("ERROR Password not set\n");
                } else {
                    MessageStringVer = parts[1];
                    msg = MessageStringVer.toCharArray();
                    msgLen = msg.length;
                    newKey = new char[msgLen];
                    for (i = 0, j = 0; i < msgLen; ++i, ++j) {
                        if (j == key.length)
                            j = 0;
                        newKey[i] = key[j];
                    }
                    encryptedMsg = new char[msgLen];
                    for (i = 0; i < msgLen; ++i)
                        encryptedMsg[i] =
                        (char)(((msg[i] + newKey[i]) % 26) + 'A');

                    System.out.println("RESULT " +
                        String.valueOf(encryptedMsg) + "\n");
                }
            } else if (parts[0].equals("DECRYPT")) {
                if (keyStringVer.isEmpty()) {
                    System.out.println("ERROR Password not set");
                } else {
                    MessageStringVer = parts[1];
                    msg = MessageStringVer.toCharArray();
                    msgLen = msg.length;
                    newKey = new char[msgLen];
                    for (i = 0, j = 0; i < msgLen; ++i, ++j) {
                        if (j == key.length)
                            j = 0;
                        newKey[i] = key[j];
                    }
                    decryptedMsg = new char[msgLen];
                    for (i = 0; i < msgLen; ++i)
                        decryptedMsg[i] =
                        (char)((((msg[i] - newKey[i]) + 26) % 26) + 'A');
    
                    System.out.println("RESULT " +
                        String.valueOf(decryptedMsg) + "\n");
                }
            }
            if (parts[0].equals("QUIT")) {
                break;
            }
        }
    }
}