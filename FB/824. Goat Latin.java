class Solution {
    public String toGoatLatin(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }
        
        char[] vowels = new char[] {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        Set<Character> vowel = new HashSet<>();
        for (char c : vowels) {
            vowel.add(c);
        }
        String[] sentence = S.split(" ");
        StringBuilder sb = new StringBuilder();
        
        for (int i= 0; i < sentence.length; i++) {
            String word = sentence[i];
            if (vowel.contains(word.charAt(0))) {
                sb.append(word);
            } else {
                sb.append(word.substring(1));
                sb.append(word.charAt(0));
            }
            sb.append("ma");
            int count = i;
            while (count-- >= 0) {
                sb.append("a");
            }
            sb.append(" ");
        }
        
        return sb.toString().substring(0, sb.toString().length() - 1);
    }
}
