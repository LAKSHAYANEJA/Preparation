
//package stacks;

import java.util.*;
import java.io.*;


public class ValidParentheses {
    
    public static boolean isValid(String s){
        Deque<Character> stack = new ArrayDeque<>();
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }
            else{
                if(stack.isEmpty()) {return false;}
                
                if(s.charAt(i) == ')' && stack.peek() == '(') {stack.pop();}
                else if(s.charAt(i) == ']' && stack.peek() == '[') {stack.pop();}
                else if(s.charAt(i) == '}' && stack.peek() == '{') {stack.pop();}
                else{return false;}
            }
        }
        return stack.isEmpty();
    }
    
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        try{
            System.out.println("Valid Parentheses \n\t");
            System.out.print("Enter the string (Only (), {}, []) : ");
            String s = br.readLine();
            
            boolean result = isValid(s);
            
            System.out.println("Entered String : "+s);
            System.out.println("Result : "+result);
        }
        catch(IOException error){
            System.out.println("Error triggered : "+error);
        }
    }
}
