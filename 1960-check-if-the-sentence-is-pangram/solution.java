class Solution {
    public boolean checkIfPangram(String s) {
        int freq[]=new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        for(int i=0; i<26; i++){
            if(freq[i] < 1){  // check if any letter is missing
                return false;
            }
        }
        return true;
    }
}
