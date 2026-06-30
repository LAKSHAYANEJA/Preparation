
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        try{
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int count = 0;
            
            int[] scores = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                scores[i] = Integer.parseInt(st.nextToken());
                
                int threshold = scores[k-1];
                if(scores[i]>=threshold && scores[i]>0){
                       count++;
                }
            }
            System.out.println(count);
            
            
        }
        catch(IOException e){
            System.out.println("Error triggered : "+e);
        }
    }
}
