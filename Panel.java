import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;

/**
 * Write a description of class Panel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Panel extends JPanel
{
    static JFrame frame;
    private JLabel label;
    private JTextField box1, box2, box3;
    private Library lib;
    private Text text;
    private JComboBox<String> menu;
    final String[] choices = { "<Type in>", "Google","Yahoo", "Facebook","Naver", "Daum", "Nate", "KakaoTalk"};

    public static void main(String[] args)
    {
        frame = new JFrame("Dossier");
        frame.setSize(500, 200);
        frame.setLocation(250, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Panel());
        frame.setVisible(true);
    }

    public Panel()
    {
        setLayout(new BorderLayout());

        JPanel subPanel = new JPanel();
        subPanel.setLayout(new GridLayout(3,2));

        menu = new JComboBox<String>(choices);
        menu.setVisible(true);
        subPanel.add(menu);

        box1 = new JTextField("", 5);
        box1.setHorizontalAlignment(SwingConstants.LEFT);
        subPanel.add(box1);

        subPanel.add(new JLabel("ID:", SwingConstants.RIGHT));
        box2 = new JTextField("", 5);
        box2.setHorizontalAlignment(SwingConstants.LEFT);
        subPanel.add(box2);

        subPanel.add(new JLabel("Password:", SwingConstants.RIGHT));
        box3 = new JTextField("", 5);
        box3.setHorizontalAlignment(SwingConstants.LEFT);
        subPanel.add(box3);

        add(subPanel, BorderLayout.CENTER);

        JPanel subPanel1 = new JPanel();
        subPanel1.setLayout(new GridLayout(1,3));

        JButton plus = new JButton("Next");
        plus.addActionListener(new Listener(frame, box1, box2, box3));
        subPanel1.add(plus);

        JButton print = new JButton("Finish");
        print.addActionListener(new Listener1(frame, box1, box2, box3));
        print.setHorizontalAlignment(SwingConstants.LEFT);
        subPanel1.add(print);

        add(subPanel1, BorderLayout.SOUTH);

    }

    static ArrayList<Library> list = new ArrayList<Library>();

    private class Listener implements ActionListener
    {
        private JFrame frame;
        private JTextField boxs1, boxs2, boxs3;
        public Listener(JFrame fra, JTextField b1, JTextField b2, JTextField b3)
        {
            frame = fra;
            boxs1 = b1;
            boxs2 = b2;
            boxs3 = b3;
        }

        /**
         * It should save the current inputs in a Library object and store it inside arraylist
         * Then it should delete the current frame and open the next one for another inputs
         */
        public void actionPerformed(ActionEvent e)
        {
            lib = new Library(boxs1, boxs2, boxs3, menu);
            if(boxs2.getText().length()>0 && boxs3.getText().length()>0)
            {
                list.add(lib);
            }
            createFrame();
        }
    }

    private class Listener1 implements ActionListener
    {
        private JFrame frame;
        private JTextField boxs1, boxs2, boxs3;
        public Listener1(JFrame fra, JTextField b1, JTextField b2, JTextField b3)
        {
            frame = fra;
            boxs1 = b1;
            boxs2 = b2;
            boxs3 = b3;
        }
        
        /**
         * The third button. May not be necessary
         */
        public void actionPerformed(ActionEvent e)
        {
            lib = new Library(boxs1, boxs2, boxs3, menu);
            if(boxs2.getText().length()>0 && boxs3.getText().length()>0)
            {
                list.add(lib);
            }
            text = new Text(list);
            text.printText();
            frame.dispose();
        }
    }

    /**
     * Create a new frame
     */
    public static void createFrame()
    {
        frame.dispose();
        frame = new JFrame("Dossier");
        frame.setSize(500, 200);
        frame.setLocation(250, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Panel());
        frame.setVisible(true);
    }

}
