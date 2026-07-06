import java.io.*;

import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        try{
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            
            int maxDominoes = (m*n)/2;
            System.out.println(maxDominoes);
        }
        catch(IOException e){
            System.out.println("Error triggered : "+e);
        }
    }
}
