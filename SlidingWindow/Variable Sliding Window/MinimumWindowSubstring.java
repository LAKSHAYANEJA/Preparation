import java.io.*;
public class MinimumWindowSubstring {
    
    public String minWindow_BF(String s, String t){
        int minlen = Integer.MAX_VALUE;
        int sIndex = -1;
        
        for(int i=0;i<s.length();i++){
            int[] hash = new int[256];
            int count = 0;
            
            for(int j=0;j<t.length();j++){
                hash[t.charAt(j)]++;
            }
                for(int j=i;j<s.length();j++){
                    if(hash[s.charAt(j)]>0){
                        count++;
                    }
                        hash[s.charAt(j)]--;
                        
                        if(count == t.length()){
                            if(j-i+1<minlen){
                                minlen = j-i+1;
                                sIndex = i;
                            }
                                break;
                            
                        } 
            }
        }
        if(sIndex == -1){
            return "";
        }
        return s.substring(sIndex, sIndex+minlen);
    }
    
    public String minWindow_OA(String s, String t){
        int l = 0, r=0 , minlen = Integer.MAX_VALUE, sIndex=-1,count=0;
        int[] hash = new int[256];
        
        for(int i=0;i<t.length();i++){
            hash[t.charAt(i)]++;
        }
        while(r<s.length()){
            if(hash[s.charAt(r)]>0){count++;}
            hash[s.charAt(r)]--;
            
            while(count == t.length()) {
                if(r-l+1 < minlen){
                    minlen = r-l+1;
                    sIndex = l;
                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)]>0){count--;}
                l++;
            }
            r++;
        }
        return sIndex == 1 ? "" : s.substring(sIndex,sIndex+minlen);
    }
    
    public static void main(String[] args){
         MinimumWindowSubstring mws = new MinimumWindowSubstring();
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
         try{
             System.out.println("MINIMUM WINDOW SUBSTRING");
             System.out.print("\n\n\t Enter the first string : ");
             String s = br.readLine();
             System.out.print("\n\t Enter the second string : ");
             String t = br.readLine();
             
             String result_BF = mws.minWindow_BF(s,t);
             
             System.out.println("\n\n\t ---BRUTE FORCE---\n");
            System.out.println("\t The substring possible is : "+result_BF);
            System.out.println("\t Time Complexity : O(n*n) \n\t Space Complexity : O(256) \n ");
            
             String result_OA = mws.minWindow_OA(s,t);
             
             System.out.println("\n\t ---OPTIMAL APPROACH---\n");
            System.out.println("\t The substring possible is : "+result_OA);
            System.out.println("\t Time Complexity : O(2n) + O(m) \n\t Space Complexity : O(256) \n ");
             
         }
         catch(Exception e){
             System.out.println("Error Triggered : "+e);
         }
    }
}
