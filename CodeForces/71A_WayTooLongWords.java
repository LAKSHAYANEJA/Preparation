import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        try{
            int t = Integer.parseInt(br.readLine());
            for(int i=0;i<t;i++){
        String s = br.readLine();
        
        if(s.length()>10){
            char l = s.charAt(0);
            char r = s.charAt(s.length()-1);
            
            String res = "";
            int length = s.length()-2;
            String len = String.valueOf(length);
            
//            res.concat(l,len,r);
            
            System.out.println(l+len+r);
        }
        else{
            System.out.println(s);
        }
        }

            
            
        }
        catch(IOException e){
            System.out.println("Error triggered : "+e);
        }
    }
}
