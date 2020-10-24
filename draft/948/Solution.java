import java.util.Arrays;

class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        if (tokens.length == 0) return 0;
        if (tokens.length == 1) return P >= tokens[0] ? 1 : 0;

        Arrays.sort(tokens);

        int l = 0;
        int r = tokens.length - 1;
        int score = 0;
        int maxScore = 0;
        while (l <= r) {
            if (P >= tokens[l]) {
                P -= tokens[l];
                score++;
                maxScore = Math.max(maxScore, score);
                l++;
                continue;
            }
            if (score == 0) break;
            P += tokens[r];
            score--;
            r--;
        }
        
        return maxScore;
    }
}