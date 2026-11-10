import java.util.*;
import java.io.*;

public class Anton_and_Letters {
    
    public static void main(String[] args) {
//    String letters = "";
    Scanner scan = new Scanner(System.in);
    HashSet<Character> set = new HashSet<>();
    
    String letters = scan.nextLine();
    
    for(char ch : letters.toCharArray()) {
        if(ch >= 'a' && ch <= 'z' && !set.contains(ch)) {
            set.add(ch);
        }
    }
    System.out.println(set.size());
    
   }
}
