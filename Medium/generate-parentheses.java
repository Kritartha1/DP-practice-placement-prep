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

//Approach 3:
class Solution {
    //closure number
    //slowest
    //Time =space=O({4^n}/sqrt(n));
    
//     Approach 3: Closure Number
// Intuition

// To enumerate something, generally we would like to express it as a sum of disjoint subsets that are easier to count.

// Consider the closure number of a valid parentheses sequence S: the least index >= 0 so that S[0], S[1], ..., S[2*index+1] is valid. Clearly, every parentheses sequence has a unique closure number. We can try to enumerate them individually.

// Algorithm

// For each closure number c, we know the starting and ending brackets must be at index 0 and 2*c + 1. Then, the 2*c elements between must be a valid sequence, plus the rest of the elements must be a valid sequence.
    
    public List<String> generateParenthesis(int n) {
        List<String> l=new ArrayList<>();
        if(n==0){
            l.add("");
        }
        else{
            for(int c=0;c<n;++c){
                for(String left:generateParenthesis(c))//length 2c
                {
                    for(String right:generateParenthesis(n-c-1))//length 2n-(2c+2)
                    {
                        l.add("("+left+")"+right);
                    }
                }
            }
        }
        return l;
    }
}
