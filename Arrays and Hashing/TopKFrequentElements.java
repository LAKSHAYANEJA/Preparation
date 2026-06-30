
package dsa;

import java.util.*;
import java.io.*;

public class TopKFrequentElements {
    
    public int[] topKfrequentelements_Sorting(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        
        for(int num : nums) {
            count.put(num, count.getOrDefault(num, 0)+1);
        }
        
        List<int[]> arr = new ArrayList<>();
        
        for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
            arr.add(new int[] {entry.getValue(), entry.getKey()});
        }
        
        arr.sort((a, b) -> b[0] - a[0]);
        
        int[] res = new int[k];
        
        for(int i=0;i<k;i++){
            res[i] = arr.get(i)[1];
        }
        
        return res;
    }
    
    public int[] topKfrequentelements_MinHeap(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        
        for(int num : nums) {
            count.put(num, count.getOrDefault(num, 0)+1);
        }
        
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        
        for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
            heap.offer(new int[]{entry.getValue(), entry.getKey()});
            
            if(heap.size() > k) heap.poll();
        }
        
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = heap.poll()[1];
        }
        return res;
    }
    
    int[] topKfrequentelements_BucketSort(int[] nums, int k){
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[nums.length-1];
        
        for(int i=0;i<freq.length;i++) {
            freq[i] = new ArrayList<>();
        }
        
        for(int n : nums) {
            count.put(n, count.getOrDefault(n, 0)+1);
        }
        for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }
        
        int[] res = new int[k];
        int index = 0;
        for(int i=freq.length-1;i>0 && index<k; i--){
            for(int n:freq[i]) {
                res[index++] = n;
                if(index == k) return res;
            }
        }
        return res;
    }
    
    public static void main(String[] args){
        TopKFrequentElements obj = new TopKFrequentElements();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        try{
            System.out.println("Top K Frequent Elements \n\n");
            System.out.print("\t Enter the array size : ");
            int size = Integer.parseInt(br.readLine());
            
            int[] nums = new int[size];
            
            System.out.print("\n\t Enter the array elements : ");
            for(int i=0;i<size;i++){
                nums[i] = Integer.parseInt(br.readLine());
            }
            System.out.print("\n\t Enter the number, k : ");
            int k = Integer.parseInt(br.readLine());
            
            
            
            int[] result_Sorting = obj.topKfrequentelements_Sorting(nums, k);
            int[] result_MinHeap = obj.topKfrequentelements_MinHeap(nums, k);
            int[] result_BucketSort = obj.topKfrequentelements_BucketSort(nums, k);
            
            
            System.out.print("\n\n\t ----- SORTING ----- \n\t");
            for(int sort : result_Sorting){System.out.print(sort+" ");}
            System.out.print("\n\t Time Complexity : O(nlogn) \n\t Space Complexity : O(n)");
            
            
            
            System.out.print("\n\n\t ----- MINIMUM HEAP ----- \n\t");
           for(int minHeap : result_MinHeap) { System.out.print(minHeap+" ");}
            System.out.print("\n\t Time Complexity : O(nlogk) \n\t Space Complexity : O(n+k), \n\t where n = length of the array and k = the number of top frequent elements");
            
            
            
            System.out.print("\n\n\t ----- BUCKET SORT ----- \n\t");
            for(int buckS : result_BucketSort){System.out.print(buckS+" ");}
            System.out.print("\n\t Time Complexity : O(n) \n\t Space Complexity : O(n)");
           
            
        }
        catch(IOException e){
            System.out.print("Error triggered : "+e);
        }
    }
}
