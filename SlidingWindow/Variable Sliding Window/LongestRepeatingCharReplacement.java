
import java.io.*;
public class LongestRepeatingCharReplacement {
    public int characterReplacement_BF(String s, int k){
        int maxlen = 0;
//        int[] hash = new int[26];
//        for(int i=0;i<26;i++){
//            hash[i] = 0;
//        }
        for(int i=0;i<s.length();i++){
            int[] hash = new int[26];

            int maxf=0;
            
           for(int j=i;j<s.length();j++){
               hash[s.charAt(j)-'A']++;
               maxf = Math.max(maxf, hash[s.charAt(j)-'A']);
               
               int changes = (j-i+1) - maxf;
               
               if(changes<=k){
                   maxlen = Math.max(maxlen, j-i+1);
               }
               else{break;}
           }            
            
        }
        return maxlen;
    }
    
    
    public int characterReplacement_OA(String s, int k){
        int l=0,r=0,maxlen=0,maxf=0;
        int[] hash = new int[26];
        while(r<s.length()){
            hash[s.charAt(r)-'A']++;
            maxf = Math.max(maxf,hash[s.charAt(r)-'A']);  
            
            if((r-l+1)-maxf > k){
                hash[s.charAt(l)-'A']--;
                l++;
            }
            if((r-l+1)-maxf <= k){
                maxlen = Math.max(maxlen, r-l+1);
                r++;
            }
        }
        return maxlen;
    }
    
    public static void main(String[] args){
        LongestRepeatingCharReplacement lrcr = new LongestRepeatingCharReplacement();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        try{
            System.out.println("Longest Repeating Character Replacement\n\n");
            System.out.println("\n Enter the string : ");
            String s = br.readLine();
            System.out.println("\n Enter the minimum length : ");
            int k = Integer.parseInt(br.readLine());
            
            int result_BF = lrcr.characterReplacement_BF(s, k);
            System.out.println("\n\n\t ----- BRUTE FORCE-----\n\n");
            System.out.println("The maximum length of the longest substring containing the same letter : "+result_BF);
            System.out.println("\t Time Complexity : O(n*n) \n\t Space Complexity : O(1) \n ");
            
            int result_OA = lrcr.characterReplacement_OA(s, k);
            System.out.println("\n\n\t ----- OPTIMAL APPROACH-----\n\n");
            System.out.println("The maximum length of the longest substring containing the same letter : "+result_OA);
            System.out.println("\t Time Complexity : O(n) \n\t Space Complexity : O(1) \n ");
        }
        catch(Exception e){
            System.out.println("Error Triggered : "+e);
        }
    }
}
