//SImple dfs
//leetcode.com/problems/word-search/
class Solution {
    int[] r={-1,0,1,0};
    int[] c={0,1,0,-1};
    boolean[][] vis;
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        boolean ans=false;
        vis=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(word.charAt(0)==board[i][j]){
                    ans=dfs(board,i,j,vis,word,0);
                }
                if(ans){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isValid(char[][] board,int r,int c,boolean[][] vis){
        return r>=0&&r<board.length&&c>=0&&c<board[0].length&&!vis[r][c];
    }
    
    public boolean dfs(char[][] board,int i,int j,boolean[][] vis,String word,int k){
        if(k==word.length()){
            return true;
        }
        if(!isValid(board,i,j,vis)||word.charAt(k)!=board[i][j]){
            return false;
        }
        
        vis[i][j]=true;
        ++k;
       
        for(int t=0;t<4;t++){
            if(dfs(board,i+r[t],j+c[t],vis,word,k)){
                    return true;
            } 
        }
        //backtracking step.
        vis[i][j]=false;
        return false;
    }
}
