
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        try{
        int w = Integer.parseInt(br.readLine());
        
        if(w>2 && w%2 == 0){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
        }

        catch(IOException e){
            System.out.println("Error triggered : "+e);
        }
    }
}
