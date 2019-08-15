import javax.swing.*;
import java.awt.*;
/**
 * Write a description of class Library here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Library
{
    private String web, id, pw;
    private JTextField box1, box2, box3;
    private JComboBox<String> menu;
    //final String[] choices = { "<Type in>", "Google","Yahoo", "Facebook","Naver", "Daum"};
    
    /**
     * Constructor for objects of class Library
     */
    public Library(JTextField w, JTextField d, JTextField p, JComboBox<String> m)
    {
        box1 = w;
        box2 = d;
        box3 = p;
        menu = m;
    }
    
    public String getText1()
    {
        return box1.getText();
    }
    
    public String getText2()
    {
        return box2.getText();
    }
    
    public String getText3()
    {
        return box3.getText();
    }
    
    public JComboBox<String> getMenu()
    {
        return menu;
    }
}
