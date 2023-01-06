package lib;

import java.io.OutputStream;
import java.io.PrintStream;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JTextArea;

@Deprecated
public class JTextAreaPrintStream extends PrintStream {
     JTextArea area;
     
     public JTextAreaPrintStream(OutputStream out, JTextArea area) {
          super(out);
          this.area = area;
     }

     @Override
     public void println(String x) {
          String oldText = area.getText();
          DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
          String currentTime = LocalTime.now().format(dtf);
          if(oldText.isBlank()){
               area.setText("[" + currentTime  + "] "+ x);
          } else {
               area.setText(oldText + "\n"+ "[" + currentTime + "] " + x);
          }
     }
}
