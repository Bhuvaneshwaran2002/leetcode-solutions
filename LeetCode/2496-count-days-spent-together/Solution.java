class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int [] arr = {0,31,59,90,120,151,181,212,243,273,304,334};
        int aliceArrMonth = Integer.parseInt(arriveAlice.substring(0,2));
        int aliceArrDay =  Integer.parseInt(arriveAlice.substring(3));
        int bobArrMonth = Integer.parseInt(arriveBob.substring(0,2));
        int bobArrDay = Integer.parseInt(arriveBob.substring(3));
        int aliceLevMonth = Integer.parseInt(leaveAlice.substring(0,2));
        int aliceLevDay =  Integer.parseInt(leaveAlice.substring(3));
        int bobLevMonth = Integer.parseInt(leaveBob.substring(0,2));
        int bobLevDay = Integer.parseInt(leaveBob.substring(3));
        int Aa = arr[aliceArrMonth-1] + aliceArrDay;
        int Al = arr[aliceLevMonth-1] + aliceLevDay;
        int Ba = arr[bobArrMonth-1] + bobArrDay;
        int Bl = arr[bobLevMonth-1] + bobLevDay;
        int minDay = Math.min(Aa,Ba);
        int maxDay = Math.max(Al,Bl);
    int count =0;
        for(int i = minDay; i<= maxDay; i++){
            if(i >= Aa && i <= Al && i >= Ba && i <= Bl){
                count++;
            }
        }
        return count;
    }
}