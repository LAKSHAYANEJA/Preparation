
package dsa;

import java.io.*;

public class ValidPalindrome {
    public static boolean validPalindrome(String s){
        s = s.toLowerCase();
        int left=0, right=s.length()-1;
        
        while(left < right){
            if(!Character.isLetterOrDigit(s.charAt(left))){
                left++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(right))){
                right--;
                continue;
            }
            
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            else{
                left++;
                right--;
            }
        }
        return true;
    }
    
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        try{
           System.out.println("Valid Palindrome");
           System.out.print("\n\t Enter the string : ");
           String s = br.readLine();
           
           boolean result = validPalindrome(s);
           
           System.out.println("\n\t Your entered String : "+s);
           if(result == true){
           System.out.println("\n\t Is Palindrome ? : YES");
           }
           else{
               System.out.println("\n\t Is Palindrome ? : NO");
           }
           
        }
        catch(IOException e){
            System.out.println("Error triggered : "+e);
        }
    }
}
