
package javaapplication3;
import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        int slow=0, i;
        int[] numbers = new int[5];
        
        System.out.println("Enter the elements you want in your array : ");
        
        for(i=0;i<5;i++){
            numbers[i] = scan.nextInt();
        }
        
        System.out.println("Elements in your array are : ");
        
        for(int fast=1;fast<numbers.length;fast++){
            if(numbers[fast]!=numbers[slow]){
                slow+=1;
                numbers[slow] = numbers[fast];                
            }
        }
        System.out.println("Array after removal of duplicates : ");
        for(i=0;i<=slow;i++){
            System.out.print(numbers[i]+" ");
        }
    }
}
