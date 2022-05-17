//leetcode.com/problems/spiral-matrix/
//Approach 1:
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int dir=0;//dir=0 means right, 1 means down, 2 means left, 3 means up.
        int i=0,j=0;
        int m=matrix.length;
        int n=matrix[0].length;
        int layer=0;
        int s=m*n;
        List<Integer> ans=new ArrayList<>();
        
        while(s--!=0){
            switch(dir){
                
                case 0://right
                    if(i<m&&j<=n-layer-1){
                       ans.add(matrix[i][j]);
                     }if(j==n-layer-1){
                        i++;
                        dir=1;
                        break;
                    }
                    ++j;
                    break;
                    
                    
                case 1://down
                    if(i<=m-layer-1&&j<n){
                        ans.add(matrix[i][j]);
                     }if(i==m-layer-1){
                        --j;
                        dir=2;
                        break;
                   }
                    ++i;
                     break;
                    
                    
                case 2://left
                    if(i<m&&j>=layer){
                        ans.add(matrix[i][j]);
                        
                    }if(j==layer){
                        --i;
                        dir=3;
                        layer++;
                        break;
                    }
                    --j;
                     break;
                    
                    
                case 3://top
                   if(i>=layer&&j<n){
                         ans.add(matrix[i][j]);
                       
                    }if(i==layer){
                        ++j;
                        dir=0;
                        break;
                    }
                     --i;
                    break;
                    
                default:
                    break;
            }
        }
        return ans;
        
    }
}

//Approach 2: clean solution
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int m=matrix.length;
        int n=matrix[0].length;
       
        int s=m*n;
        List<Integer> ans=new ArrayList<>();
        int l=0;
        int r=n-1;
        int u=0;
        int d=m-1;
        
        while(ans.size()<s){
            for(int j=l;j<=r&&ans.size()<s;j++){
                ans.add(matrix[u][j]);
            }
            ++u;
            for(int i=u;i<=d&&ans.size()<s;i++){
                ans.add(matrix[i][r]);
            }
            --r;
            for(int j=r;j>=l&&ans.size()<s;j--){
                ans.add(matrix[d][j]);
            }
            --d;
            for(int i=d;i>=u&&ans.size()<s;i--){
                ans.add(matrix[i][l]);
            }
            ++l;
            
            
        }
        return ans;
        
    }
}
