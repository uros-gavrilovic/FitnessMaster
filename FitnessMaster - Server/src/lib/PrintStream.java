package lib;

import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;

 public class PrintStream {
     public PrintStream(JTextArea area) {
          OutputStream out = new OutputStream() {
               @Override
               public void write(int b) throws IOException {
               }
          };

          JTextAreaPrintStream print = new JTextAreaPrintStream(out, area);
          System.setOut(print);
 }
}
