//leetcode.com/problems/count-square-submatrices-with-all-ones/
class Solution {
    public int countSquares(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        
        //matrix[i][j] will act as bottom corner of a square...
        //if matrix[i][j]=2 means...matrix[i-1][j],matrix[i][j-1] and matrix[i-1][j-1]must be 1...that means coordinate(i,j) will act as a bottom corner of a 2 unit size matrix whose top left coordinate id (i-1,j-1).
        int ans=0;
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]==1){
                    matrix[i][j]=1+Math.min(matrix[i-1][j],Math.min(matrix[i][j-1],matrix[i-1][j-1]));
                    ans+=matrix[i][j];
                }
            }
        }
        for(int i=1;i<m;i++){
            ans+=matrix[i][0];
        }
        for(int j=0;j<n;j++){
            ans+=matrix[0][j];
        }
        return ans;
        
    }
}
