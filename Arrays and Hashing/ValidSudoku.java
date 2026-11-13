class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        HashSet<Character>[] rowSet = new HashSet[9];
        HashSet<Character>[] colSet = new HashSet[9];
        HashSet<Character>[] boxSet = new HashSet[9];

        for(int i=0;i<9;i++) {
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
            boxSet[i] = new HashSet<>();
        }

        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                char ch = board[i][j];
                if(ch == '.') continue;

                int boxIndex = (i/3) * 3 + (j/3);

                if(rowSet[i].contains(ch) || colSet[j].contains(ch) || boxSet[boxIndex].contains(ch)) {
                    return false;
                }

                rowSet[i].add(ch);
                colSet[j].add(ch);
                boxSet[boxIndex].add(ch);
            }
        }
        return true;
    }
}
