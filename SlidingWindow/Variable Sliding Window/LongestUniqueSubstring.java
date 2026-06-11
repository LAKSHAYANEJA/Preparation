
package variableslidingwindow;

import java.util.*;
import java.io.*;

public class LongestUniqueSubstring {
    public static int longestUniqueSubstring(String s){
        if(s==null || s.length()==0){return 0;}
        
        HashMap<Character, Integer> charMap = new HashMap<>();
        
        int left = 0;
        int maxLength = 0;
        
        for(int right=0;right<s.length();right++){
            char currentChar = s.charAt(right);
            // If character exists and is within current window            
            if(charMap.containsKey(currentChar) && charMap.get(currentChar)>= left){
                // Move left pointer to position after the duplicate
                left = charMap.get(currentChar)+1;
            }
            // Update character's latest position
            charMap.put(currentChar, right);
            
            // Update Maximum length
            
            maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the string : ");
        try{
        String s = br.readLine();
        System.out.println("Longest unique substring length : "+longestUniqueSubstring(s));
        }
        catch(Exception IO) {
        System.out.println("Error");
    }
    }
}
