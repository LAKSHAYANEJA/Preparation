
package dsa;


import java.io.*;
import java.util.*;
public class ThreeSum {
    public List<List<Integer>> threeSum_BF(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++) {
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                        set.add(temp);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
    
    public List<List<Integer>> threeSum_Hashmap(int[] nums) {
        Arrays.sort(nums);
        
        Map<Integer, Integer> count = new HashMap<>();
        
        for(int num : nums) {
            count.put(num, count.getOrDefault(num, 0)+1);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++) {
            count.put(nums[i], count.get(nums[i])-1);
            
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            
            for(int j=i+1;j<nums.length;j++){
                count.put(nums[j], count.get(nums[j])-1);
                
                if(j>i+1 && nums[j] == nums[j-1]) {continue;}
                
                int target = -(nums[i] + nums[j]);
                
                if(count.getOrDefault(target, 0) > 0) {
                    res.add(Arrays.asList(nums[i], nums[j], target));
            }
            }
            
            for(int j=i+1;j<nums.length;j++){
                count.put(nums[j], count.get(nums[j])+1);
            }
        }
        
        return res;
    }
    
    public List<List<Integer>> threeSum_OA(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0 ) {break;}
            if(i>0 && nums[i] == nums[i-1]) {continue;}
            
            int l=i+1, r=nums.length-1;
            
            while(l<r) {
                int sum = nums[i] + nums[l] + nums[r];
                
                if(sum > 0) {r--;}
                
                else if(sum < 0) {l++;}
                
                else{
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while(l<r && nums[l] == nums[l-1]) {
                        l++;
                    }
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        try{
            System.out.println("\n\t\t --- 3 SUM --- \n");
            System.out.print("\tEnter the array size : ");
            int size = Integer.parseInt(br.readLine());
            
            int[] nums = new int[size];
            
            System.out.print("\t Enter the array elements : ");
            for(int i=0;i<size;i++){
                nums[i] = Integer.parseInt(br.readLine());
            }
            
            List<List<Integer>> result_BF = ts.threeSum_BF(nums);
            List<List<Integer>> result_Hashmap = ts.threeSum_Hashmap(nums);
            List<List<Integer>> result_OA = ts.threeSum_OA(nums);
            
            System.out.print("\n\t ----- BRUTE FORCE ----- \n\t");
            System.out.print(result_BF);
            System.out.print("\n\t Time Complexity : O(n*n*n) \n\t Space Complexity : O(m) \n\t where m = number of triplets, n = length of givven array");
            
            System.out.print("\n\n\t ----- WITH HASHMAP ----- \n\t");
            System.out.print(result_Hashmap);
            System.out.print("\n\t Time Complexity : O(n*n) \n\t Space Complexity : O(n) \n\t where n = length of givven array");
            
            System.out.print("\n\n\t ----- OPTIMAL APPROACH ----- \n\t");
            System.out.print(result_OA);
            System.out.print("\n\t Time Complexity : O(n*n) \n\t Space Complexity : O(1) or O(n) extra space depending on the sorting algorithm \n\t O(m) space for the output list \n\t where m = number of triplets, n = length of givven array");
            
            
        }
        catch(IOException e){
            System.out.print("\n\t Error trigerred : "+e);
        }
    }
    
}
