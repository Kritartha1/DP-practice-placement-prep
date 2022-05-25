//leetcode.com/problems/generate-parentheses/
//Approach 1: recursive+slower
class Solution {
    List<String> list;
    public List<String> generateParenthesis(int n) {
        list=new ArrayList<>();
        
        solve(0,0,"",n);
        return list;
    }
    
    public void solve(int n1,int n2,String s,int n){
        if(n1==n){
            String s1="";
            for(int i=0;i<n-n2;i++){
                s1+=")";
            }
            list.add(s+s1);
            return ;
        }
        
         
         solve(n1+1,n2,s+"(",n);
         if(n1!=n2){
             solve(n1,n2+1,s+")",n);
         }
            
        
    }
}

//Approach 2: recursive +faster
class Solution {
    List<String> list;
    public List<String> generateParenthesis(int n) {
        list=new ArrayList<>();
        char[] s=new char[2*n];
        
        solve(0,0,s,n,0);
        return list;
    }
    
    public void solve(int n1,int n2,char[] s,int n,int i){
        if(n1==n){
            // String s1="";
            for(int j=0;j<n-n2;j++){
                s[i+j]=')';
            }
            list.add(String.valueOf(s));
            return ;
        }
        
         s[i]='(';
         solve(n1+1,n2,s,n,i+1);
         s[i]=')';
         if(n1!=n2){
             solve(n1,n2+1,s,n,i+1);
         }
            
        
    }
}
