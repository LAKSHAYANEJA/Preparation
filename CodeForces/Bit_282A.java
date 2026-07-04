
import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        try{
            int x =0;
            int n = Integer.parseInt(br.readLine());
            
            for(int i=0;i<n;i++){
                String input = br.readLine();
               if(input.contains("++")){
                   x++;
               }
               else{
                   x--;
               }
            }
            System.out.println(x);
        }
        catch(IOException e){
            System.out.println("Error triggered : "+e);
        }
    }
}
