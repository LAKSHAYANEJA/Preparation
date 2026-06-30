
package dsa;

import java.io.*;
import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams_Sorting(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for(String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedS = new String(charArray);
            res.putIfAbsent(sortedS, new ArrayList<>());
            res.get(sortedS).add(s);
        }
        
        return new ArrayList<>(res.values());
    }
    
    public List<List<String>> groupAnagrams_HashTable(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for(String s : strs ){
            int[] count = new int[26];
            for(char c : s.toCharArray()){
                count[c-'a']++;
            }
            String key = Arrays.toString(count);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(s);
        }
        return new ArrayList<>(res.values());
    }
    
    public static void main(String[] args) {
        
        GroupAnagrams ga = new GroupAnagrams();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        try{
            System.out.println("GROUP ANAGRAMS\n\n");
            System.out.print("\tEnter the String array size : ");
            int size = Integer.parseInt(br.readLine());
          
            String[] strs = new String[size];
            
            for(int i=0;i<size;i++){
            System.out.print("\n\tEnter the string "+(i+1)+" : ");
            strs[i] = br.readLine();
            }
            
            List<List<String>> result_Sorting = ga.groupAnagrams_Sorting(strs);
            List<List<String>> result_HashTable = ga.groupAnagrams_HashTable(strs);
            
            System.out.print("\n\n\t ----- SORTING ----- \n\t");
            for(List<String> sort : result_Sorting){System.out.print(sort+" ");}
            System.out.print("\n\t Time Complexity : O(m*nlogn) \n\t Space Complexity : O(m*n)");
            
            System.out.print("\n\n\t ----- HASH TABLE ----- \n\t");
            for(List<String> ht : result_HashTable){System.out.print(ht+" ");}
            System.out.print("\n\t Time Complexity : O(m*n) \n\t Space Complexity : O(m) auxiliary space, excluding the returned output. \n\t O(m*n) total space if the output groups are counted. \n\t where m = number of strings and n = length of the longest string.");

            
          
        }
        catch(IOException e){
            System.out.println("Error Triggered : "+e);
        }
    }
    
}
