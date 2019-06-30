class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] word = s.toCharArray();
        String vowels = "aeiouAEIOU";
        Set<Character> set = new HashSet<>();
        for (char c : vowels.toCharArray()) {
            set.add(c);
        }
        
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !set.contains(word[left])) {
                left++;
            }
            while (left < right && !set.contains(word[right])) {
                right--;
            }
            char temp = word[right];
            word[right] = word[left];
            word[left] = temp;
            
            right--;
            left++;            
        }
        
        return String.valueOf(word);
    }
}
