class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;
        boolean b=true;
        int m = arr1.length, n = arr2.length;
        for(int i = 0;i<m;i++){
            b=true;
            for(int j=0;j<n;j++){
                if(arr2[j]>= arr1[i]-d && arr2[j]<= d+arr1[i]){
                    b=false;
                    break;
                }
            }
            if(b)ans++;
        }
        return ans;
    }
}