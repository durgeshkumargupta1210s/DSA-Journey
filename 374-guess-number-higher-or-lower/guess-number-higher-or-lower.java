/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int lo = 1;
        int hi = n;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int result = guess(mid); // Call the guess API
            if (result == 0) {
                return mid; // Correct guess
            } else if (result == -1) {
                hi = mid - 1; // The guessed number is too high
            } else {
                lo = mid + 1; // The guessed number is too low
            }
        }
        
        // This point should never be reached if the input is valid
        return -1;
    }
}