//leetcode.com/problems/knight-dialer/
The power of matrix reveals the number of walks in an undirected graph.
//Approach 3: fastest: Look for  it : 
    //leetcode.com/problems/knight-dialer/discuss/189252/O(logN)
//      def knightDialer(self, N):
//         x1 = x2 = x3 = x4 = x5 = x6 = x7 = x8 = x9 = x0 = 1
//         for i in range(N - 1):
//             x1, x2, x3, x4, x5, x6, x7, x8, x9, x0 = \
//                 x6 + x8, x7 + x9, x4 + x8, \
//                 x3 + x9 + x0, 0, x1 + x7 + x0, \
//                 x2 + x6, x1 + x3, x2 + x4, \
//                 x4 + x6
//         return (x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8 + x9 + x0) % (10**9 + 7)

//Approach 3.1:  
// def knightDialer(self, N):
//         mod = 10**9 + 7
//         if N == 1: return 10
//         M = np.matrix([[0, 0, 0, 0, 1, 0, 1, 0, 0, 0],
//                        [0, 0, 0, 0, 0, 0, 1, 0, 1, 0],
//                        [0, 0, 0, 0, 0, 0, 0, 1, 0, 1],
//                        [0, 0, 0, 0, 1, 0, 0, 0, 1, 0],
//                        [1, 0, 0, 1, 0, 0, 0, 0, 0, 1],
//                        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
//                        [1, 1, 0, 0, 0, 0, 0, 1, 0, 0],
//                        [0, 0, 1, 0, 0, 0, 1, 0, 0, 0],
//                        [0, 1, 0, 1, 0, 0, 0, 0, 0, 0],
//                        [0, 0, 1, 0, 1, 0, 0, 0, 0, 0]])
//         res, N = 1, N - 1
//         while N:
//             if N % 2: res = res * M % mod
//             M = M * M % mod
//             N /= 2
//         return int(np.sum(res)) % mod


//Approach 1: slowest...O(4*3*n)=filling the dp table=O(12*n)=O(n)
class Solution {
    Integer[][][] dp;
    int[][] matrix;
    int[][] dir={{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2}};
    int mod=(int)1e9 + 7;
    
    public int knightDialer(int n) {
        dp=new Integer[n][4][3];
        matrix=new int[4][3];
        matrix[3][0]=1;
        matrix[3][2]=1;
        int ans=0;
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                ans=(ans+knightDailer(n-1,i,j)%mod)%mod;
            }
        }
        return ans%mod;
    }
    public int knightDailer(int n,int i,int j){
        if(i<0||j<0||i>=4||j>=3||matrix[i][j]==1){
            return 0;
        }
        if(n==0){
            return 1;
        }
        
        if(dp[n][i][j]!=null){
            return dp[n][i][j];
        }
        
        int ans=0;
        for(int t=0;t<8;t++){
            int r=i+dir[t][0],c=j+dir[t][1];
            ans=(ans+knightDailer(n-1,r,c)%mod)%mod;
                    
        } 
        return dp[n][i][j]=(ans%mod);
    }
}

//Approach 2: Little faster..same O(n)=O(10*n)=filling the dp table
class Solution {
    Integer[][] dp;
    int mod=(int)1e9 + 7;
    
    public int knightDialer(int n) {
        int[][] neighbour={{4,6},{6,8},{7,9},{4,8},{0,3,9},{},{0,1,7},{2,6},{1,3},{2,4}};
        dp=new Integer[n][10];
        
        int ans=0;
        for(int i=0;i<10;i++){
            ans=(ans+knightDailer(n-1,i,neighbour)%mod)%mod;
            
        }
        return ans%mod;
    }
    public int knightDailer(int n,int i,int[][] neighbour){
        
        if(n==0){
            return 1;
        }
        
        if(dp[n][i]!=null){
            return dp[n][i];
        }
        
        int ans=0;
        for(int neighbours:neighbour[i]){
            ans=(ans+knightDailer(n-1,neighbours,neighbour)%mod)%mod;
        } 
        return dp[n][i]=(ans%mod);
    }
}
