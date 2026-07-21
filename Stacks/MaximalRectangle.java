class Solution {
    public static int largestRectangle(int[] heights){
        Deque<Integer> stack = new ArrayDeque<>();
        int[] pse = new int[heights.length];
        int[] nse = new int[heights.length];
        int area = 0;
        int maximum = 0;

        for(int i=0;i<heights.length;i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                pse[i] = -1;
            }
            else{
                pse[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();

        for(int i=heights.length-1;i>=0;i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nse[i] = heights.length;
            }
            else{
                nse[i] = stack.peek();
            }
            stack.push(i);
        }

        for(int i=0;i<heights.length;i++){
            int height = heights[i];
            int width = nse[i] - pse[i] - 1;

            area = height * width;
            maximum = Math.max(maximum, area);
        }

        return maximum;
    }
    public int maximalRectangle(char[][] matrix) {
        
        if(matrix == null || matrix.length ==0){
            return 0;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int maximum = 0;
        int[] heights = new int[columns];
        int totalArea = 0;

        


        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(matrix[i][j] == '1'){
                    heights[j]++;
                }
                else{
                    heights[j] = 0;
                }
            }
                totalArea = largestRectangle(heights);
                maximum = Math.max(maximum, totalArea);   
        }
        

        return maximum;
    }
}
