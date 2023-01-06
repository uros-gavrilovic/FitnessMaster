package lib;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

 public class CustomConsoleStream {
      @Deprecated
     public CustomConsoleStream(JTextArea area) {
          // DEPRECATED. Sets print stream to a JTextArea.
          OutputStream out = new OutputStream() {
               @Override
               public void write(int b) throws IOException {
               }
          };

          JTextAreaPrintStream print = new JTextAreaPrintStream(out, area);
          System.setOut(print);
 }
     public CustomConsoleStream() throws IOException{
          File consoleFile = new File("config/console.txt");
          if (!consoleFile.exists()) consoleFile.createNewFile();
          
          PrintStream stream = new PrintStream(consoleFile);
          
          //System.out.println("CONSOLE: Printing console logs to file:  " + consoleFile.getAbsolutePath());
          System.setOut(stream);
     }
     
     static public void clearConsoleFile(){
          File consoleFile = new File("config/console.txt");
          if (consoleFile.exists()) {
               PrintWriter pw = null;
               try {
                    pw = new PrintWriter("filepath.txt");
                    pw.close();
               } catch (FileNotFoundException ex) {
                    Logger.getLogger(CustomConsoleStream.class.getName()).log(Level.SEVERE, null, ex);
               } finally {
                    pw.close();
               }
          }
     }
     static public String readConsoleFile(){
           try {
                File consoleFile = new File("config/console.txt");
                String text = "";
                text = new String(Files.readAllBytes(Paths.get(consoleFile.toString())));
                return text;
           } catch (IOException ex) {
                Logger.getLogger(CustomConsoleStream.class.getName()).log(Level.SEVERE, null, ex);
           }
           
           return "";
     }
 }
