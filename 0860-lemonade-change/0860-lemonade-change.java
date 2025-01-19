class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n=bills.length;
        int five=0,ten=0,twenty=0;
        for(int i=0;i<n;i++){
            if(bills[i]==5){
                five+=1;
            }
            if(bills[i]==10){
                ten+=1;
                if(five>0){
                    five-=1;
                }else{
                    return false;
                }
            }
            if(bills[i]==20){
                twenty+=1;
                if(five>=1 && ten>=1){
                    five-=1;
                    ten-=1;
                }else if(five>=3){
                    five-=3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}