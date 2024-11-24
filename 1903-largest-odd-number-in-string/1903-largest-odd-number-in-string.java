class Solution {
    public String largestOddNumber(String num) {
        
        
        for(int i=num.length()-1;i>=0;i--){
          
           if(num.charAt(i)%2==1){
                return num.substring(0,i+1);
            }
        }
       // if the above loop ran for the whole length 
       //and yet nothing is returned ->this means that
       //there are no odd bnumbers in the string so just
       //return "";
       
        return "";
    }
}
     