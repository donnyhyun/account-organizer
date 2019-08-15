import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
/**
 * Write a description of class Text here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Text
{
    private ArrayList<Library> list;
    private Library lib;
    private String a, b, c;
    private JComboBox<String> menu;

    public Text(ArrayList<Library> libra)
    {
        list = libra;
    }

    public void printText()
    {
        for(int i =0;i<list.size();i++)
        {
            lib = list.get(i);
            menu = lib.getMenu();
            if(menu.getSelectedItem().equals("<Type in>"))
            {
                a = lib.getText1();
            }
            else
            {
                a = (String)menu.getSelectedItem();
            }
            b = lib.getText2();
            c = lib.getText3();
            try {
                FileWriter writer = new FileWriter("Accounts.txt", true);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                bufferedWriter.write("WEBSITE: " + a);
                bufferedWriter.newLine();
                bufferedWriter.write("ID: " + b);
                bufferedWriter.newLine();
                bufferedWriter.write("Password: " + c);
                bufferedWriter.newLine();
                bufferedWriter.newLine();

                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
