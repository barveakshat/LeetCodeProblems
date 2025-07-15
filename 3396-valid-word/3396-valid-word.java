class Solution {
    public boolean isValid(String word) {
        String vowels = "AEIOUaeiou";
        if(word.length() < 3) return false;

        int vowelCount = 0;
        int consCount = 0;
        for(char c : word.toCharArray()){
            if(Character.isLetter(c)){
                if(vowels.indexOf(c) != -1){
                    vowelCount++;
                } else{
                    consCount++;
                } 

            } else if(!Character.isDigit(c)){
                return false;
            }
        }
        return vowelCount >= 1 && consCount >= 1;
    }
}