// https://codeforces.com/contest/231/problem/A


import java.io.*;

import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        try{
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int count = 0;
            
            
            int i=0;
            while(i<n){
                int sum = 0;
                st = new StringTokenizer(br.readLine());
                int first_no = Integer.parseInt(st.nextToken());
                sum+=first_no;
                
                int second_no = Integer.parseInt(st.nextToken());
                sum+=second_no;
                
                int third_no = Integer.parseInt(st.nextToken());
                sum+=third_no;
                
                if(sum>=2){
                    count++;
                }
                
                i++;
            }
            System.out.println(count);
            
            
        }
        catch(IOException e){
            System.out.println("Error triggered : "+e);
        }
    }
}
