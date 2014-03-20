package scouting2014;

import au.com.bytecode.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.UnsupportedLookAndFeelException;

public class Scouter 
{
    public static AboutGUI aboutScouter;
    public static AboutZones aboutZones;
    
    public static void saveScouter(String path,int[] data, String n, String t1, 
            boolean m1, int s1, boolean h1) {
        
        int sum1 = 0;
        
        int suma = data[3]*10+data[9]*10+data[12]+10*data[18]+10*data[24];
        
        String move1 = "Did not move";
        if(m1){
            move1 = "Moved";
            sum1+=5;}
        
        String hot1 = "No hot goal";
        if(h1){
            hot1 = "Hot goal";
            sum1+=5;
        }
       
        String as1 = "No goal";
        if(s1==1){as1="Low goal";
            sum1+=6;
        }
        else if(s1==2){as1 = "High goal";
            sum1+=15;
        }
        else if(s1==3){as1 = "Two goals";
            sum1+=30;
        }
        
        CSVWriter writer = null;
        if(path.indexOf(".csv")==-1){
        try {
          writer = new CSVWriter(new FileWriter(path+".csv",true));
        }
        catch (IOException e) {e.printStackTrace();}
        }
        
        else{
        try {
          writer = new CSVWriter(new FileWriter(path,true));
        }
        catch (IOException e) {
          e.printStackTrace();
        }
        }
        String[] info1 = new String[30];
        info1[0]=n;
        info1[1] = t1;
        info1[2] = move1;
        info1[3] = as1;
        info1[4]=hot1;
        
        for(int i=0;i<data.length;i++){
            if(i%3==0){info1[i+5]=String.valueOf(data[i]);}
        }
        info1[data.length+5] = String.valueOf(sum1);
        
        
        info1[data.length+6] = String.valueOf(suma);
        
        if(info1[1]!= ""){writer.writeNext(info1);}
        
        try
        {
          writer.close();
        }
        catch (IOException e) {
          e.printStackTrace();
        }
    }
    
    public static void saveZones(String path, String m, String t1, String z1, String n1,
            String t2, String z2, String n2, String t3, String z3, String n3,String t4, String z4, String n4,
            String t5, String z5, String n5, String t6, String z6, String n6)
            throws IOException{
        
        CSVWriter writer = null;
        if(path.indexOf(".csv")==-1){
        try {
          writer = new CSVWriter(new FileWriter(path+".csv",true));
        }
        catch (IOException e) {e.printStackTrace();}
        }
        
        else{
        try {
          writer = new CSVWriter(new FileWriter(path,true));
        }
        catch (IOException e) {
          e.printStackTrace();
        }
        }
        
        String[] info1 = {m,t1,z1,n1};
        String[] info2 = {m,t2,z2,n2};
        String[] info3 = {m,t3,z3,n3};
        String[] info4 = {m,t4,z4,n4};
        String[] info5 = {m,t5,z5,n5};
        String[] info6 = {m,t6,z6,n6};

        
        writer.writeNext(info1);
        writer.writeNext(info2);
        writer.writeNext(info3);
        writer.writeNext(info4);
        writer.writeNext(info5);
        writer.writeNext(info6);

        
        writer.close();
    }
    
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, IOException
    {
      ScoutingGUI GUI = new ScoutingGUI();
      //ZonesGUI gui = new ZonesGUI();
      aboutScouter = new AboutGUI();
      //aboutZones = new AboutZones();
    }
}