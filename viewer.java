import java.awt.*;
import javax.swing.*;

public class viewer {
    private static JFrame frame = new JFrame("PadNote");
    public static void main(String[] args) {
         JTextArea textArea = new JTextArea(50, 30);;
        int x, y; // used to center a frame

        // instantiate a frame

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // instantiate our 'primary' panel for our frame
        Main primary = new Main();
        frame.setJMenuBar(primary.getMenu());
        frame.add(textArea);
        //frame.add(primary.getTextArea());
        frame.add(primary.getScrollPane());

        // add this panel to the frame
        //frame.getContentPane().add(primary);
        frame.setVisible(true);
        frame.pack();
        //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        Dimension size = frame.getSize();
        //primary.setMyFrame(frame);
       // primary.textArea.setColumns(size.width-1000);
        //primary.textArea.setRows(size.height-500);
    }// end method main

   // public Dimension getFrameSize(){return size;}
}   // end class ring viewer




