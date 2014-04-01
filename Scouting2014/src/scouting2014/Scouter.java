package scouting2014;

import au.com.bytecode.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.UnsupportedLookAndFeelException;

public class Scouter 
{
    public static AboutGUI aboutScouter;
    public static AboutZones aboutZones;
    
    public static void saveScouter(String path,int[] data, String mn, String t1, 
            String t2, String t3, boolean m1, boolean m2, boolean m3,
            int s1, int s2, int s3, boolean h1, boolean h2,
            boolean h3,String z1, String z2, String z3, String n1, String n2, String n3) {
        
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        
        int suma = data[3]*10+data[9]*10+data[12]+10*data[18]+10*data[24];
        int sumb = data[4]*10+data[10]*10+data[13]+10*data[19]+10*data[25];
        int sumc = data[5]*10+data[11]*10+data[14]+10*data[20]+10*data[26];
        
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
        if(h1){
            hot1 = "Hot goal";
            sum1+=5;
        }
        String hot2 = "No hot goal";
        if(h2){hot2 = "Hot goal";
         sum2+=5;
        }
        String hot3 = "No hot goal";
        if(h3){hot3 = "Hot goal";
            sum3+=5;
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
        
        String as2 = "No goal";
        if(s2==1){as2="Low goal";
            sum2+=6;
        }
        else if(s2==2){as2 = "High goal";
            sum2+=15;
        }
        else if(s2==3){as2 = "Two goals";
            sum2+=30;
        }
        
        String as3 = "No goal";
        if(s3==1){as3="Low goal";
            sum3+=6;
        }
        else if(s3==2){as3 = "High goal";
            sum3+=15;
        }
        else if(s3==3){as3 = "Two goals";
            sum3+=30;
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
        info1[0]=mn;
        info1[1] = t1;
        info1[2] = move1;
        info1[3] = as1;
        info1[4]=hot1;
        
        String[] info2 = new String[30];
        info2[0]=mn;
        info2[1] = t2;
        info2[2] = move2;
        info2[3] = as2;
        info2[4]=hot2;
        
        String[] info3 = new String[30];
        info3[0]=mn;
        info3[1] = t3;
        info3[2] = move3;
        info3[3] = as3;
        info3[4]=hot3;

        for(int i=0;i<data.length;i++){
            if(i%3==0){info1[i/3+5]=String.valueOf(data[i]);}
            if(i%3==1){info2[(i-1)/3+5]=String.valueOf(data[i]);}
            if(i%3==2){info3[(i-2)/3+5]=String.valueOf(data[i]);}
        }
        
        info1[data.length/3+5] = z1;
        info2[data.length/3+5] = z2;
        info3[data.length/3+5] = z3;
        
        info1[data.length/3+6] = String.valueOf(sum1);
        info2[data.length/3+6] = String.valueOf(sum2);
        info3[data.length/3+6] = String.valueOf(sum3);
        
        info1[data.length/3+7] = String.valueOf(suma);
        info2[data.length/3+7] = String.valueOf(sumb);
        info3[data.length/3+7] = String.valueOf(sumc);

        info1[data.length/3+8] = n1;
        info2[data.length/3+8] = n2;
        info3[data.length/3+8] = n3;
        
        if(!info1[1].equals( "")){
            System.out.println(info1[1]);
            writer.writeNext(info1);}
        if(!info2[1].equals( "")){writer.writeNext(info2);}
        if(!info3[1].equals( "")){writer.writeNext(info3);}
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