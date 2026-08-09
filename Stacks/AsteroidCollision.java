
// package stacks;

import java.io.*;
import java.util.*;

public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int i=0;i<asteroids.length;i++){
            boolean alive = true;
            int curr = asteroids[i];
            
            while(!stack.isEmpty() && stack.peek()>0 && curr<0){
                if(Math.abs(stack.peek()) > Math.abs(curr)){
                    alive = false;
                    break;
                }
                else if(Math.abs(stack.peek()) < Math.abs(curr)){
                    stack.pop();
                    continue;
                }
                else{
                    stack.pop();
                    alive = false;
                    break;
                }
                
            }
            if(alive){
                    stack.push(curr);
                }
        }
        
        int[] aliveAst = new int[stack.size()];
        
        for(int i=aliveAst.length-1;i>=0;i--){
            aliveAst[i] = stack.pop();
        }
        
        return aliveAst;
    
    }
    
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        try{
          System.out.println("--- Asteroid Collision ---");
          System.out.print("\n\t Enter the array size : ");
          int size = Integer.parseInt(br.readLine());
          
          int[] asteroids = new int[size];
          System.out.print("\n\t Enter the array elements : ");
          for(int i=0;i<size;i++){
              asteroids[i] = Integer.parseInt(br.readLine());
          }
          
          int[] answer = asteroidCollision(asteroids);
          
          System.out.print("\n\t The alive asteroids are: ");
          for(int aliveAsteroids : answer){
              System.out.print(aliveAsteroids+" ");
          }
          System.out.print("\n\t It has been solved using Monotonic Stacks under O(n) Time Complexity and Space Complexity.\n\t");
        }
        catch(IOException error){
            System.out.println(error);
        }
        
    }
}
