
package javaapplication3;

public class ContainerWithMostWater {

public int maxArea(int[] height){
    int left=0;
    int right=height.length-1;
    int maxWater=0;

while(left<right){
    int width = right-left;
    int minHeight = Math.min(height[left], height[right]);
    int water = width*minHeight;

    maxWater = Math.max(maxWater, water);

    if(height[left]<height[right]){
    left++;
}
else{
    right--;
}
}
return maxWater;
}


    public static void main(String[] args){
    ContainerWithMostWater max_obj = new ContainerWithMostWater();
    int[] height = {1,8,6,2,5,4,8,3,7};
    
    System.out.println(max_obj.maxArea(height));
}
}
