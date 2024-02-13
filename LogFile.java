//SSK190013
//Saahit Karumuri
//CS 4348.003 - OS

import java.util.*;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class LogFile {
    public static void main (String[]args) {
        Scanner scanner = new Scanner(System.in);
        String inputFile = "";
        inputFile = scanner.nextLine();
        try {
            FileWriter fw = new FileWriter(inputFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            //Get Start Time
            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String formattedDate = myDateObj.format(myFormatObj);
            bw.write(formattedDate + " [START] Logging Started.");
            bw.newLine();
            //Input Loop
            String inputString = "";
            while (!(inputString.equals("QUIT"))) {
                inputString = scanner.nextLine();
                inputString = inputString.toUpperCase();
                String[] parts = inputString.split(" ");
                myDateObj = LocalDateTime.now();
                myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                formattedDate = myDateObj.format(myFormatObj);
                if(!(inputString.equals("QUIT"))) {
                    bw.write(formattedDate + " [" + parts[0] + "] ");
                    bw.write(parts[1]);
                    bw.newLine();
                }
            }
            //Get End Time
            myDateObj = LocalDateTime.now();
            myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            formattedDate = myDateObj.format(myFormatObj);
            bw.write(formattedDate + " [STOP] Logging Stopped.");
            bw.newLine();
            bw.newLine();
            bw.close();
        } catch (Exception e) {
            System.out.println("File not Found.");
        }
    }
}