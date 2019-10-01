class Solution {
    public String getHint(String secret, String guess) {
        int numA = 0;
        int numB = 0;
        Map<Character, Integer> mapA = new HashMap<>();
        Map<Character, Integer> mapB = new HashMap<>();
        
        for (int i = 0; i < secret.length(); i++) {
            char a = secret.charAt(i);
            char b = guess.charAt(i);
            
            if (a == b) {
                numA++;
            } else {
                if (mapA.containsKey(a)) {
                    mapA.put(a, mapA.get(a) + 1);
                } else {
                    mapA.put(a, 1);
                }
                if (mapB.containsKey(b)) {
                    mapB.put(b, mapB.get(b) + 1);
                } else {
                    mapB.put(b, 1);
                }
            }
        }
        
        for (char key : mapA.keySet()) {
            if (mapB.containsKey(key)) {
                numB += Math.min(mapA.get(key), mapB.get(key));
            }
        }
        
        return String.valueOf(numA) + "A" + String.valueOf(numB) + "B";
    }
}
