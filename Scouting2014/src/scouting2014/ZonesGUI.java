
package scouting2014;

import javax.swing.*;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emma
 */
public class ZonesGUI extends JFrame implements ActionListener{
    
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
    }
    
    final JFileChooser fc = new JFileChooser();
    JButton save = new JButton("Save Results");
    
    JTextField matchNumber = new JTextField(2);
    JLabel matchInfo = new JLabel("Match Number:");
    
  /*  JLabel zone1 = new JLabel("Near (defensive) team: ");
    JTextField team1 = new JTextField(4);
    JLabel zone2 = new JLabel("Middle team: ");
    JTextField team2 = new JTextField(4);
    JLabel zone3 = new JLabel("Far (offensive) team: ");
    JTextField team3 = new JTextField(4);*/
    
    JMenuBar menuBar = new JMenuBar();
    JMenu help = new JMenu("Help");
    JMenuItem about = new JMenuItem("About Zones");
    
    JLabel red = new JLabel("Red Alliance");
    JLabel blue = new JLabel("Blue Alliance");
    
    JLabel teamNuma = new JLabel(" Team Number: ");
    JLabel teamNumb = new JLabel(" Team Number: ");
    JLabel teamNumc = new JLabel(" Team Number: ");
    JTextField teamNumbera = new JTextField(3);
    JTextField teamNumberb = new JTextField(3);
    JTextField teamNumberc = new JTextField(3);
    
    JLabel teamNum1 = new JLabel(" Team Number: ");
    JLabel teamNum2 = new JLabel(" Team Number: ");
    JLabel teamNum3 = new JLabel(" Team Number: ");
    JTextField teamNumber1 = new JTextField(3);
    JTextField teamNumber2 = new JTextField(3);
    JTextField teamNumber3 = new JTextField(3);
    
    String[] ops = {"Defensive team","Middle team","Offensive team", "No defined zone"};
    JComboBox zones1 = new JComboBox(ops);
    JComboBox zones2 = new JComboBox(ops);
    JComboBox zones3 = new JComboBox(ops);
    JComboBox zones4 = new JComboBox(ops);
    JComboBox zones5 = new JComboBox(ops);
    JComboBox zones6 = new JComboBox(ops);

    /*JLabel zone1b = new JLabel("Near (defensive) team: ");
    JTextField team1b = new JTextField(4);
    JLabel zone2b = new JLabel("Middle team: ");
    JTextField team2b = new JTextField(4);
    JLabel zone3b = new JLabel("Far (offensive) team: ");
    JTextField team3b = new JTextField(4);*/
    
    JButton clear = new JButton("Clear");
    
    JLabel notesLabel1 = new JLabel("notes:");
    JTextField notes1 = new JTextField(10);
    JLabel notesLabel2 = new JLabel("notes:");
    JTextField notes2 = new JTextField(10);
    JLabel notesLabel3 = new JLabel("notes:");
    JTextField notes3 = new JTextField(10);
    
    JLabel notesLabel4 = new JLabel("notes:");
    JTextField notes4 = new JTextField(10);
    JLabel notesLabel5 = new JLabel("notes:");
    JTextField notes5 = new JTextField(10);
    JLabel notesLabel6 = new JLabel("notes:");
    JTextField notes6 = new JTextField(10);
    
    JPanel jp = new JPanel(new MigLayout());
    
    public ZonesGUI() throws ClassNotFoundException, InstantiationException, 
            IllegalAccessException{
                //Create the window
        setTitle("Zones (subjective) app 2014");
        setVisible(true);
        setSize(505, 360);
        setResizable(true);
        
        menuBar.add(help);
        help.add(about);
        
         about.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Scouter.aboutZones.setVisible(true);
            }
        });
        
        this.setJMenuBar(menuBar);
        this.jp.add(matchInfo,"split 2");
        this.jp.add(matchNumber, "wrap");
        this.jp.add(red,"center, newline, wrap");
        
        /*
        this.jp.add(zone1,"split 2");
        this.jp.add(team1,"wrap");
        this.jp.add(zone2,"split 2");
        this.jp.add(team2,"wrap");
        this.jp.add(zone3,"split 2");
        this.jp.add(team3,"wrap");
        this.jp.add(zone1b,"split 2");
        this.jp.add(team1b,"wrap");
        this.jp.add(zone2b,"split 2");
        this.jp.add(team2b,"wrap");
        this.jp.add(zone3b,"split 2");
        this.jp.add(team3b,"wrap");
        */
        this.jp.add(teamNuma, "split 8, grow");
        this.jp.add(teamNumbera);
        this.jp.add(teamNumb);
        this.jp.add(teamNumberb);
        this.jp.add(teamNumc);
        this.jp.add(teamNumberc, "wrap");
        
        this.jp.add(zones1, "split 3");
        this.jp.add(zones2);
        this.jp.add(zones3, "wrap");
        
        
        this.jp.add(notesLabel1,"split 6");
        this.jp.add(notes1);
        this.jp.add(notesLabel2);
        this.jp.add(notes2);
        this.jp.add(notesLabel3);
        this.jp.add(notes3, "wrap");
        
        this.jp.add(blue,"center, newline, wrap");
        
        this.jp.add(teamNum1, "split 8, grow");
        this.jp.add(teamNumber1);
        this.jp.add(teamNum2);
        this.jp.add(teamNumber2);
        this.jp.add(teamNum3);
        this.jp.add(teamNumber3, "wrap");
        
        this.jp.add(zones4,"split 3");
        this.jp.add(zones5);
        this.jp.add(zones6, "wrap");
        
        this.jp.add(notesLabel4,"split 6");
        this.jp.add(notes4);
        this.jp.add(notesLabel5);
        this.jp.add(notes5);
        this.jp.add(notesLabel6);
        this.jp.add(notes6, "wrap");
        
        this.jp.add(save, "split 2");
        this.jp.add(clear);
        
        this.clear.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e) {
                 
                 matchNumber.setText("");
                 teamNumbera.setText(null);
                 teamNumberb.setText(null);
                 teamNumberc.setText(null);
                 notes1.setText(null);
                 notes2.setText(null);
                 notes3.setText(null);
                 notes4.setText(null);
                 notes5.setText(null);
                 notes6.setText(null);
             }
        });
        
       this.save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                int returnVal = fc.showSaveDialog(jp);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    String path = file.getAbsolutePath();
                    try {
                        Scouter.saveZones(path,matchNumber.getText(),
                                teamNumbera.getText(), (String) zones1.getSelectedItem(), notes1.getText(), 
                                teamNumberb.getText(),(String)zones2.getSelectedItem(),notes2.getText(),
                                teamNumberc.getText(),(String)zones3.getSelectedItem(),notes3.getText(), 
                                teamNumber1.getText(), (String) zones4.getSelectedItem(), notes4.getText(),
                                teamNumber2.getText(), (String) zones5.getSelectedItem(), notes5.getText(), 
                                teamNumber3.getText(), (String) zones6.getSelectedItem(), notes6.getText()); 
                                
                    } catch (IOException ex) {
                        Logger.getLogger(ZonesGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                clear.doClick();
            }
        }); 
        
        add(this.jp);
        jp.updateUI();
    }
}
