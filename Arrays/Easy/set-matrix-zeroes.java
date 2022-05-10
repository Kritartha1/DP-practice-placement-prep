//leetcode.com/problems/set-matrix-zeroes/
//CHeck approach 2...space efficient.


//Approach 1: Time and space consuming approach.

class Solution {
    boolean[][] vis;
    public void setZeroes(int[][] matrix) {
       
        int m=matrix.length;
        int n=matrix[0].length;
        vis=new boolean[m][n];
        int count=m*n;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==2){
                   vis[i][j]=true;
                }
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    setZ(matrix,i,j);
                }else{
                    count--;//when there are no zeros ,then count will be 0.
                }
            }
        }
        
        if(count>0){
            for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=(matrix[i][j]==2&&!vis[i][j]?0:matrix[i][j]);
            }
        }
        }
        
        
    }
    
    public void setZ(int[][] matrix,int i,int j){
        matrix[i][j]=2;
        for(int k=0;k<matrix[0].length;k++){
            if(matrix[i][k]!=0){
                matrix[i][k]=2;
                vis[i][k]=false;
            }
        }
        for(int k=0;k<matrix.length;k++){
            if(matrix[k][j]!=0){
                matrix[k][j]=2;
                vis[k][j]=false;
            }
        }
    }
}

//Approach 2: Space complexity O(1)
class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        boolean isCol=false;
        
        for(int i=0;i<m;i++){
            if(matrix[i][0]==0){
                isCol=true;
            }
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][0]==0||matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        
        if(matrix[0][0]==0){
            for(int j=0;j<n;j++){
                matrix[0][j]=0;
            }
        }
        if(isCol){
            for(int i=0;i<m;i++){
                matrix[i][0]=0;
            }
        }
    }
}
