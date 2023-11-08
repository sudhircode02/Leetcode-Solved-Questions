class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if(sx==fx && sy==fy && t==1) return false;
        return t >= minPath(sx, sy, fx, fy);
    }

    private int minPath(int r1, int c1, int r2, int c2){
        if(r1==r2 && c1==c2){
            return 0;
        }
        else if(r1 == r2){
            if(c2 > c1) return c2-c1;
            else return c1-c2;
        }
        else if(c1 == c2){
            if(r2 > r1) return r2-r1;
            else return r1-r2;
        }
        else{int count = 0;
            if(r1 < r2){
                if(c1 < c2){
                    int min = Math.min(c2-c1, r2-r1);
                    count+=min;
                    r1+=min; c1+=min;
                    if(r1<r2) count+=(r2-r1);
                    if(c1<c2) count+=(c2-c1);                    
                }
                else{                    
                    int min = Math.min(c1-c2, r2-r1);
                    count+=min;
                    r1+=min; 
                    c1-=min;
                    if(r1<r2) count+=(r2-r1);
                    if(c1>c2) count+=(c1-c2);                    
                }
            }
            else{
                if(c1 < c2){                    
                    int min = Math.min(c2-c1, r1-r2);
                    count+=min;
                    r1-=min; c1+=min;                  
                    if(r1>r2) count+=(r1-r2);
                    if(c1<c2) count+=(c2-c1);
                }
                else{                   
                    int min = Math.min(c1-c2, r1-r2);
                    count+=min;
                    r1-=min; c1-=min;
                    if(r1>r2) count+=(r1-r2);
                    if(c1>c2) count+=(c1-c2);                    
                }
            }
             return count;
        }
    }
}