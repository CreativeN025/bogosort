import java.io.*;
import com.opencsv.*;
import java.time.*;

public class bogosort
{
    
    //int[][] arr={new int[11],new int[13]}

    long loops=0;
    final int samplesize=1;
    long startTime=0; 
    long endTime=0;
    long duration=0;
    LocalTime RealStart;
    LocalTime RealStop;
    
    public bogosort()
    {
        int[][] arr ={new int[13]};
        RealStart= LocalTime.now();
        for(int j=0;j<arr.length;j++){
            for(int k=0;k<samplesize;k++){
                arr[j]=assignint(arr[j]);
                startTime = System.nanoTime();
                loops=0;
                while(!IsSorted(arr[j]) )
                {
                    arr[j] = sort(arr[j]);
                    loops++;
                }
                endTime = System.nanoTime();
                duration =endTime - startTime;
                log("filetest.csv",arr[j].length,loops,duration);
            }
        }
        RealStop= LocalTime.now();
        System.out.println("RealStart:"+RealStart);
        System.out.println("RealStop:"+RealStop);
    }
    int[] assignint(int[] sortarray){
        for(int i=0;i<sortarray.length;i++){
                    sortarray[i] = (int)(Math.random()*100);
                }
                return sortarray;
    }
    int[] sort(int[] sortarray){

        for(int i=0;i<sortarray.length-1;i++){
            int j = (int)(Math.random() * sortarray.length);
            int temp = sortarray[i];
            sortarray[i] = sortarray[j];
            sortarray[j] = temp;
        }
        return sortarray;
    }

    boolean IsSorted(int[] sortarray){
        for (int i = 0; i < sortarray.length-1; i++){
            if(sortarray[i]>sortarray[i+1]){
                return false;
            }
        }
        return true;
    }

    void log(String filePath,int length,long loop,long time){

        File file = new File(filePath);
        boolean fileExists = file.exists(); 

        try {
            FileWriter outputfile = new FileWriter(file, true);
            CSVWriter writer = new CSVWriter(outputfile);
            String[] message={String.valueOf(length),String.valueOf(loop),String.valueOf(time)};

            String[] header={"[array length","[loops]","[real time]"};
            if (!fileExists) {
                writer.writeNext(header);
            }
            writer.writeNext(message);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + filePath);
            e.printStackTrace();
        }
    }
}