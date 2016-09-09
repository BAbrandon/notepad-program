import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.*;

import javax.swing.JMenuBar;

public class Main{
    private int x, y;
    private JFrame myFrame;
    private viewer myViewer;
    private JLabel file;
    private JTextArea mainText;
    private JComboBox cbofile;
    private JLabel lblOutput;
  //  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    //public JTextArea textArea;
    private Border textBorder;
    private JScrollPane scroll;
    private JTextArea textArea;
    private Font textFont;
    private JMenuBar menuBar = new JMenuBar();

    public static void main(String[] args) throws IOException  {
    }

    public Main() {
        //textArea = new JTextArea(null,"",55,182);//, 75, 177, TextArea.SCROLLBARS_VERTICAL_ONLY);
        addMenus();
        createTextArea();
       // textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        //add(textArea);



        //setPreferredSize(new Dimension(325, 125));
        //setBackground(Color.lightGray);
    }

    private class cboListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            int selectionR;
            int selectionG = 0;

        }


        // display this label!

    }   // end method actionPerfomed



    public JMenuBar getMenu(){return menuBar;}
    public  void setMyFrame(JFrame f){ myFrame = f;}
    private void addMenus() {
        // Add in a Menu
        // For each menu item we need to add in an ActionListener
        // that tells the computer what to do when the menu item is selected

        //top bar options
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu viewMenu = new JMenu("View");
        JMenu formatMenu = new JMenu("Format");
        JMenu helpMenu   = new JMenu("Help");
        //alt
        fileMenu.setMnemonic('F');
        editMenu.setMnemonic('E');
        viewMenu.setMnemonic('V');
        formatMenu.setMnemonic('o');
        helpMenu.setMnemonic('H');

        //file menu items
        JMenuItem newButton  = new JMenuItem("New", 'N');
        JMenuItem open = new JMenuItem("Open", 'O');
        JMenuItem exit = new JMenuItem("Exit",'E');
        exit.addActionListener(new ActionListener() {
                                   public void actionPerformed(ActionEvent event) {
                                       exit();
                                   }
                               }
        );
        open.addActionListener(new ActionListener() {
                                   public void actionPerformed(ActionEvent event) {

                                       try {
                                           open();
                                       } catch (IOException e) {
                                           e.printStackTrace();
                                       }
                                   }
                               }
        );
        newButton.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent event) {
                                            newButton();
                                        }
                                    }
        );
        //adding


        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);
        menuBar.add(formatMenu);
        menuBar.add(helpMenu);

        fileMenu.add(newButton);
        fileMenu.add(open);
        fileMenu.add(exit);
    }

    private void open() throws IOException {
        JFileChooser open = new JFileChooser();
        int option = open.showOpenDialog(myFrame);
        if (option == JFileChooser.APPROVE_OPTION) {
            newButton();
           File myFile = open.getSelectedFile();

            try {
                BufferedReader inStream = new BufferedReader(new FileReader(myFile));
                String s= inStream.readLine();

                do {
                    textArea.append(s+"\n");

                    s= inStream.readLine();
                }while(s != null);
            } catch (IOException e) {
                e.printStackTrace();
            }


        }







    }
    private void exit(){System.exit(0);}

    private void newButton(){
    textArea.setText("");

    }

    private void createTextArea(){
        //textBorder = BorderFactory.createBevelBorder(0, Color.RED, Color.RED);
        textArea = new JTextArea(50, 30);
        textArea.setEditable(true);
        //textArea.setBorder(BorderFactory.createCompoundBorder(textBorder, BorderFactory.createEmptyBorder(2, 5, 0, 0)));

        textFont = new Font("Verdana", 0, 14);
        textArea.setFont(textFont);
       textArea.setLineWrap(true);

        scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

    }
    public JTextArea getTextArea(){return textArea;}
    public JScrollPane getScrollPane(){return scroll;}
}


