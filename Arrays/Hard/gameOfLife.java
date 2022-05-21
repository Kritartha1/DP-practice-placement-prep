//Approach 1: Not inplace....check for approach 2 for better solution.
class Solution {
    public boolean isSafe(int r,int c,int[][] board){
        return r>=0&&c>=0&&r<board.length&&c<board[0].length;
    }
    
    public void gameOfLife(int[][] board) {
        int[] row={-1,0,1,1,1,0,-1,-1};
        int[] col={-1,-1,-1,0,1,1,1,0};
        int m=board.length;
        int n=board[0].length;
        int[][] nums=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<8;k++){
                    if(isSafe(i+row[k],j+col[k],board)&&board[i+row[k]][j+col[k]]==1){
             nums[i][j]++;           
                    }
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((nums[i][j]<2||nums[i][j]>3)&&board[i][j]==1){
                    board[i][j]=0;
                }else if(nums[i][j]==3&&board[i][j]==0){
                    board[i][j]=1;
                }
            }
        }
    }
}
//Approach 2: inplace algo.

//leetcode.com/problems/game-of-life/discuss/73223/Easiest-JAVA-solution-with-explanation

            // To solve it in place, we use 2 bits to store 2 states:

            // [2nd bit, 1st bit] = [next state, current state]

            // - 00  dead (next) <- dead (current)
            // - 01  dead (next) <- live (current)  
            // - 10  live (next) <- dead (current)  
            // - 11  live (next) <- live (current) 
            // In the beginning, every cell is either 00 or 01.
            // Notice that 1st state is independent of 2nd state.
            // Imagine all cells are instantly changing from the 1st to the 2nd state, at the same time.
            // Let's count # of neighbors from 1st state and set 2nd state bit.
            // Since every 2nd state is by default dead, no need to consider transition 01 -> 00.
            // In the end, delete every cell's 1st state by doing >> 1.
            // For each cell's 1st bit, check the 8 pixels around itself, and set the cell's 2nd bit.

            // Transition 01 -> 11: when board == 1 and lives >= 2 && lives <= 3.
            // Transition 00 -> 10: when board == 0 and lives == 3.
            // To get the current state, simply do

            // board[i][j] & 1
            // To get the next state, simply do

            // board[i][j] >> 1

class Solution {
    int m;
    int n;
    public void gameOfLife(int[][] board) {
        m=board.length;
        n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int live_count=live(i,j,board);
                if(board[i][j]==1&&live_count<=3&&live_count>=2){
                    board[i][j]=3;// 01-->11
                }else if(board[i][j]==0&&live_count==3){
                    board[i][j]=2;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                board[i][j]>>=1;//getting the second state.
            }
        }
    }
    public int live(int i,int j,int[][]board){
        int c=0;
        for(int x=Math.max(i-1,0);x<=Math.min(i+1,m-1);x++){
            for(int y=Math.max(j-1,0);y<=Math.min(j+1,n-1);y++){
                c+=(board[x][y]&1);
            }
        }
        c-=(board[i][j]&1);
        return c;
    }
}

