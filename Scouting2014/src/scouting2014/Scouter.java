package scouting2014;

import au.com.bytecode.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.UnsupportedLookAndFeelException;

public class Scouter 
{
    public static AboutGUI aboutScouter;
    
    public static void saveScouter(String path,int[] data, String n, String t1, 
            String t2, String t3, boolean m1, boolean m2, boolean m3,
            String s1, String s2, String s3, boolean h1, boolean h2,
            boolean h3) {
        
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        
        String move1 = "Did not move";
        if(m1){
            move1 = "Moved";
            sum1+=5;}
        String move2 = "Did not move";
        if(m2){move2 = "Moved";
        sum2+=5;}
        String move3 = "Did not move";
        if(m3){move3 = "Moved";
        sum3+=5;}
        
        String hot1 = "No hot goal";
        if(h1){hot1 = "Hot goal";}
        String hot2 = "No hot goal";
        if(h2){hot2 = "Hot goal";}
        String hot3 = "No hot goal";
        if(h3){hot3 = "Hot goal";}
        
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
        String[] info1 = new String[17];
        info1[0]=n;
        info1[1] = t1;
        info1[2] = move1;
        info1[3] = s1;
        info1[4]=hot1;
        
        String[] info2 = new String[17];
        info2[0]=n;
        info2[1] = t2;
        info2[2] = move2;
        info2[3] = s2;
        info2[4]=hot2;
        
        String[] info3 = new String[17];
        info3[0]=n;
        info3[1] = t3;
        info3[2] = move3;
        info3[3] = s3;
        info3[4]=hot3;

        for(int i=0;i<data.length;i++){
            if(i%3==0){info1[i/3+5]=String.valueOf(data[i]);}
            if(i%3==1){info2[(i-1)/3+5]=String.valueOf(data[i]);}
            if(i%3==2){info3[(i-2)/3+5]=String.valueOf(data[i]);}
        }
        writer.writeNext(info3);
        writer.writeNext(info2);
        writer.writeNext(info1);
        try
        {
          writer.close();
        }
        catch (IOException e) {
          e.printStackTrace();
        }
    }
    
    public static void saveZones(String path, String m, String t1, String t2, String t3,
            String t4, String n4, String t5, String n5, String t6, String n6)
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
        
        String[] info1 = new String[3];
        String[] info2 = new String[3];
        String[] info3 = new String[3];

        info1[0]=t4;
        info1[1]=n4;
        info2[0]=t5;
        info2[1]=n5;
        info3[0]=t6;
        info3[1]=n6;
        
        if(t1.equals(t4)){info1[2]="Near (defensive) team";}
        if(t1.equals(t5)){info2[2]="Near (defensive) team";}
        if(t1.equals(t6)){info3[2]="Near (defensive) team";}
        if(t2.equals(t4)){info1[2]="Middle team";}
        if(t2.equals(t5)){info2[2]="Middle team";}
        if(t2.equals(t6)){info3[2]="Middle team";}
        if(t3.equals(t4)){info1[2]="Far (offensive) team";}
        if(t3.equals(t5)){info2[2]="Far (offensive) team";}
        if(t3.equals(t6)){info3[2]="Far (offensive) team";}
        
        writer.writeNext(info3);
        writer.writeNext(info2);
        writer.writeNext(info1);
        writer.close();
    }
    
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, IOException
    {
      ScoutingGUI GUI = new ScoutingGUI();
      ZonesGUI gui = new ZonesGUI();
      aboutScouter = new AboutGUI();
    }
}