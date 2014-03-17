package scouting2014;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class ScoutingGUI extends JFrame
  implements ActionListener{
    
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
    }
    
    /**
    * Converts the primitive int parameter into
    * a String
    * 
    * @param num
    * @return String conversion
    */
    private String str(int num){
        return new Integer(num).toString();
    }

    /**
    * Converts the String parameter into
    * a primitive int type
    * 
    * @param str
    * @return Primitive integer
    */
    private int integer(String str){
        Integer number = Integer.parseInt(str);
        return number.intValue();
    }
    
    /**
     * Displays the "About Scouter" dialog
     */
    
    //Declaration of data-holding variables
    
    boolean automoves1 = false;
    //int autoshoots = 0;
    boolean autohot1 = false;
    boolean automoves2 = false;
    //int autoshoots2 = 0;
    boolean autohot2 = false;
    boolean automoves3 = false;
    //int autoshoots3 = 0;
    boolean autohot3 = false;
    
    //Declaration of GUI elements
    
    JMenuBar menuBar = new JMenuBar();
    //JMenu file = new JMenu("File");
    //JMenuItem saveAs = new JMenuItem("Save");
    //JMenuItem exit = new JMenuItem("Exit");
    JMenu help = new JMenu("Help");
    JMenuItem about = new JMenuItem("About Scouter");
    
    JTextField matchNumber = new JTextField(2);
    JLabel matchInfo = new JLabel("Match Number:");
    
    JLabel teamNum1 = new JLabel(" Team Number: ");
    JLabel teamNum2 = new JLabel(" Team Number: ");
    JLabel teamNum3 = new JLabel(" Team Number: ");
    JTextField teamNumber1 = new JTextField(4);
    JTextField teamNumber2 = new JTextField(4);
    JTextField teamNumber3 = new JTextField(4);
    
    JLabel teamNuma = new JLabel(" Team Number: ");
    JLabel teamNumb = new JLabel(" Team Number: ");
    JLabel teamNumc = new JLabel(" Team Number: ");
    JTextField teamNumbera = new JTextField(3);
    JTextField teamNumberb = new JTextField(3);
    JTextField teamNumberc = new JTextField(3);
    
    JLabel auto = new JLabel("Autonomous ");
    JLabel nl = new JLabel("");
    
    JLabel teleop = new JLabel("Teleop ");
    
    JLabel autoMove = new JLabel("Mobility: ");
    ButtonGroup autoMoveGroup1 = new ButtonGroup();
    JToggleButton movey1 = new JToggleButton("Yes");
    JToggleButton moven1 = new JToggleButton("No");
    ButtonGroup autoMoveGroup2 = new ButtonGroup();
    JToggleButton movey2 = new JToggleButton("Yes");
    JToggleButton moven2 = new JToggleButton("No");
    ButtonGroup autoMoveGroup3 = new ButtonGroup();
    JToggleButton movey3 = new JToggleButton("Yes");
    JToggleButton moven3 = new JToggleButton("No");
    
    JLabel autoShoot1 = new JLabel("Shoots: ");
    JTextField autoShot1 = new JTextField(11);
    JTextField autoShot2 = new JTextField(11);
    JTextField autoShot3 = new JTextField(11);

    ButtonGroup autoHotGroup1 = new ButtonGroup();
    JLabel autoHot1 = new JLabel("Hot goal: ");
    JToggleButton hoty1 = new JToggleButton("Yes");
    JToggleButton hotn1 = new JToggleButton("No");
    ButtonGroup autoHotGroup2 = new ButtonGroup();
    JToggleButton hoty2 = new JToggleButton("Yes");
    JToggleButton hotn2 = new JToggleButton("No");
    ButtonGroup autoHotGroup3 = new ButtonGroup();    
    JToggleButton hoty3 = new JToggleButton("Yes");
    JToggleButton hotn3 = new JToggleButton("No");

    //These are the buttons for all the iterable scores and pipes to make a dotted line.
    JButton[] add = new JButton[33];
    JButton[] subtract = new JButton[33];
    JLabel[] label = new JLabel[33];
    JLabel[] line = new JLabel[24];
    JLabel line1 = new JLabel("|");
    JLabel line2 = new JLabel("|");
    
    //any empty cell things are here (working solution: inelegant)
    JLabel[] space = {new JLabel(" "),new JLabel(" "),new JLabel(" "),new JLabel(" "),new JLabel(" "),new JLabel(" "),new JLabel(" ")};     
    JLabel[] lines = {new JLabel("|"),new JLabel("|"),new JLabel("|"),new JLabel("|"),new JLabel("|"),new JLabel("|")};     
    
    JLabel passtry1 = new JLabel("Passes Attempted ");
    JLabel pass1 = new JLabel("Passes Made ");
    JLabel shoottry1 = new JLabel("Shots Attempted ");
    JLabel shooth1 = new JLabel("High Shots Made ");
    JLabel shootl1 = new JLabel("Low Shots Made ");
    JLabel trusstry1 = new JLabel("Truss Passes Attempted");
    JLabel trussmade1 = new JLabel("Truss Passes Made ");
    JLabel catchtry1 = new JLabel("Catches Attempted ");
    JLabel catchmade1 = new JLabel("Catches Made ");
  
    final JFileChooser fc = new JFileChooser();
    JButton save = new JButton("Save Results");

    //JPanel jp = new JPanel(new MigLayout("debug"));
    JPanel jp = new JPanel(new MigLayout());

    
    public ScoutingGUI()throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
            
        //Create the window
        setTitle("Scouter 2014");
        setVisible(true);
        setSize(735, 630);
        setResizable(true);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Initialize uninitialized GUI elements
        for (int i = 0; i<33; i++){
            add[i] = new JButton("+1");
            subtract[i] = new JButton("-1");
            label[i] = new JLabel("0");
            if(i<24){line[i] = new JLabel("  |   ");}
        }
        
        //Create menu bar
        
        menuBar.add(help);
        help.add(about);
        //menuBar.add(file);
        //file.add(saveAs);
        //file.addSeparator();
        //file.add(exit);
        
        //Add menu item action listener(s)
        
        about.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Scouter.aboutScouter.setVisible(true);
            }
        });
        
        //Add GUI elements to JPanel
        this.setJMenuBar(menuBar);
        this.jp.add(matchInfo,"split 3");
        this.jp.add(matchNumber, "wrap");
        this.jp.add(auto,"center, newline, wrap");
        //this.jp.add(nl,"wrap");
        this.jp.add(space[1], "split 9, grow");
        this.jp.add(teamNuma);
        this.jp.add(teamNumbera);
        this.jp.add(this.line[22]);
        this.jp.add(teamNumb);
        this.jp.add(teamNumberb);
        this.jp.add(this.line[23]);
        this.jp.add(teamNumc);
        this.jp.add(teamNumberc, "wrap");
        this.jp.add(autoMove, "grow, split 9");
        this.jp.add(movey1);
        this.jp.add(moven1);
        //this.jp.add(this.space[1],"grow");
        this.jp.add(this.lines[0]);
        this.jp.add(movey2);
        this.jp.add(moven2);
        this.jp.add(this.lines[1]);
        this.jp.add(movey3);
        this.jp.add(moven3,"wrap");
        autoMoveGroup1.add(movey1);
        autoMoveGroup1.add(moven1);
        autoMoveGroup2.add(movey2);
        autoMoveGroup2.add(moven2);
        autoMoveGroup3.add(movey3);
        autoMoveGroup3.add(moven3);
        this.jp.add(autoShoot1, "grow, split 9");
        //this.jp.add(this.space[1]);
        this.jp.add(autoShot1);
        this.jp.add(this.lines[4]);
        this.jp.add(this.space[2]);
        this.jp.add(autoShot2);
        this.jp.add(this.lines[5]);
        this.jp.add(autoShot3);
        this.jp.add(this.space[3], "wrap");
        this.jp.add(autoHot1,"grow, split 9");
        this.jp.add(hoty1);
        this.jp.add(hotn1);
        this.jp.add(this.lines[2]);
        this.jp.add(hoty2);
        this.jp.add(hotn2);
        this.jp.add(this.lines[3]);
        this.jp.add(hoty3);
        this.jp.add(hotn3,"wrap");
        autoHotGroup1.add(hoty1);
        autoHotGroup1.add(hotn1);
        autoHotGroup2.add(hoty2);
        autoHotGroup2.add(hotn2);
        autoHotGroup3.add(hoty3);
        autoHotGroup3.add(hotn3);
        this.jp.add(teleop,"center, newline, wrap");
        this.jp.add(space[0], "split 9, grow");
/*        this.jp.add(teamNum1);
        this.jp.add(teamNumber1);
        this.jp.add(line1);
        this.jp.add(teamNum2);
        this.jp.add(teamNumber2);
        this.jp.add(line2);
        this.jp.add(teamNum3);
        this.jp.add(teamNumber3, "wrap");*/
        
        //Add action listeners to previous GUI elements


        
        //Add identical buttons and their respective labels/action listeners
        int n=0;
        for (int i = 0; i<27; i++){
            if (i == 0){                    
                this.jp.add(passtry1, "newline, grow, split 12");
            }
            else if (i == 3){
                this.jp.add(pass1,"newline, grow, split 12");
            }
            else if (i == 6){
                this.jp.add(shoottry1,"newline, grow, split 12");
            }
            else if (i == 9){
                this.jp.add(shooth1,"newline, grow, split 12");
            }
            else if (i == 12){
                this.jp.add(shootl1,"newline, grow, split 12");
            }
            else if (i == 15){
                this.jp.add(trusstry1,"newline, grow, split 12");
            }
            else if (i == 18){
                this.jp.add(trussmade1,"newline, grow, split 12");
            }
            else if (i==21){
                this.jp.add(catchtry1, "newline, grow, split 12");
            }
            else if (i==24){
                this.jp.add(catchmade1,"newline, grow, split 12");
            }

            this.jp.add(this.subtract[i]);            // -1
            this.jp.add(this.label[i]);                         // 0
            this.jp.add(this.add[i]);                           // +1
            if(i%3!=2){
                this.jp.add(this.line[n]);
                n++;}
            
            final int j = i;                                    //appease the inner class
            
            

            subtract[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(integer(label[j].getText()) - 1 < 0){
                        java.awt.Toolkit.getDefaultToolkit().beep();
                    }
                    else{
                        label[j].setText(str(integer(label[j].getText()) - 1));
                    }
                }
            });

            add[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    label[j].setText(str(integer(label[j].getText()) + 1)); //add 1
                }
            });
        }
        
        

        //this.jp.add(notesLabel,"split 2");
        //this.jp.add(notes,"wrap");
        this.jp.add(this.save, "newline");
        
        //Add action listeners to previous GUI elements
        
        this.movey1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {automoves1 = true;}});  
        this.movey2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {automoves2 = true;}});
        this.movey3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {automoves3 = true;}});
        
        this.hoty1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {autohot1 = true;}});  
        this.hoty2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {autohot2 = true;}});
        this.hoty3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {autohot3 = true;}});
        
        this.save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                int returnVal = fc.showSaveDialog(jp);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    String path = file.getAbsolutePath();
                
                    int[] data = new int[27];
                    for (int i = 0; i<27; i++){
                        data[i] = integer(label[i].getText());
                    }

                    Scouter.saveScouter(path, data, matchNumber.getText(),
                            teamNumbera.getText(), teamNumberb.getText(),
                            teamNumberc.getText(), automoves1, automoves2,
                            automoves3, autoShot1.getText(), autoShot2.getText(),
                            autoShot3.getText(), autohot1, autohot2, autohot3);                }
            }
        });
        
        //Add the JPanel with all of the elements to the window
        add(this.jp);
        jp.updateUI();
        //Set the look and feel of the window to the OS's look and feel
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        
    }
    
}
