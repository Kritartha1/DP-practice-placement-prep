//leetcode.com/problems/spiral-matrix/
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
