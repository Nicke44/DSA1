public class SortedArrays {

    public static int mostFrequentElementSorted(int[] A) {

        if (A.length == 0)
            return -1;
        int maxFreq = 1;
        int freq = 1;
        int mostFreq = A[0];

        for (int i = 1; i < A.length; i++){
            if(A[i] == A[i - 1]){
                freq++;
            } else {
                if(freq > maxFreq){
                    maxFreq = freq;
                    mostFreq = A[i - 1];
                }
                freq = 1;
            }
        }

        if (freq > maxFreq){
            mostFreq = A[A.length - 1];
        }

        return mostFreq;
    }

    public static int firstPosCeil(int x, int[] A) {

        if (A.length == 0 || A[A.length - 1] < x)
            return -1;

        int l = 0;
        int r = A.length - 1;

        while (l <= r){
            int m = l + (r - l) / 2;
            if(A[m] >= x)
                r = m - 1;
            else
                l = m + 1;
        }

        if(l < A.length && A[l] >= x){
            return l;
        }

        return -1;
    }

    public static int[] firstAndLastPos(int x, int[] A) {
        int[] flp = {-1, -1};

        if (A.length == 0) {
            return flp;
        }

        int l = 0;
        int r = A.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (A[m] == x) {
                flp[0] = m;
                r = m - 1;
            } else if (A[m] < x) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        l = 0;
        r = A.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (A[m] == x) {
                flp[1] = m;
                l = m + 1;
            } else if (A[m] < x) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return flp;
    }

    public static int leastNonnegMissing(int[] A) {

        if(A.length == 0) {
            return 0;
        }

        int l = 0;
        int r = A.length - 1;

        while (l <= r){
            int m = l + (r - l) / 2;
            if(A[m] == m){
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return l;
    }

}