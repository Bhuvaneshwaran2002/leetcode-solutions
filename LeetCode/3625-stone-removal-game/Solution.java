class Solution {
    public boolean canAliceWin(int n) {
        int a=0;
        int b=10;
        while(n>=0){
            n=n-b;
            if(n<0 && a%2==0){
                return false;
            }
            a++;
            b--;
        }
        return true;
    }
}