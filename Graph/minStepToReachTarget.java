//practice.geeksforgeeks.org/problems/steps-by-knight5927/1#

//Approach : Simple BFS
class Solution
{
    int[][] dir={{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2}};
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        
        Queue<int[]> q=new LinkedList<>();
        int[][] matrix=new int[N][N];
       
        matrix[KnightPos[0]-1][KnightPos[1]-1]=1;
        matrix[TargetPos[0]-1][TargetPos[1]-1]=2;
        
        if(KnightPos[0]==TargetPos[0]&&KnightPos[1]==TargetPos[1]){
            return 0;
        }
        KnightPos[0]--;
        KnightPos[1]--;
        
        q.add(KnightPos);
        int ans=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size--!=0){
                int[] curr=q.poll();
                int i=curr[0];
                int j=curr[1];
               
                if(matrix[i][j]==2){
                    return ans;
                }
                
                for(int t=0;t<8;t++){
                    int r=i+dir[t][0],c=j+dir[t][1];
                    if(isValid(matrix,r,c)){
                      q.add(new int[]{r,c});
                      matrix[r][c]=1+(matrix[r][c]/2);
                    }
                    
                }  
            }
            
            ans+=1;
        }
        return -1;
        
    }
    boolean isValid(int[][] matrix,int r,int c){
        return r>=0&&c>=0&&r<matrix.length&&c<matrix[0].length&&matrix[r][c]!=1;
    }
}
