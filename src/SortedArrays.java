public class SortedArrays {

    public static int mostFrequentElementSorted(int[] A) {

        if (A.length == 0)
            return -1;
        int maxFreq = 1;
        int maxInd = 0;
        int i = 0, j = 1;

        while (i + j < A.length){
            if (A[i] == A[i+j]){
                j++;
            } else {
                if (j > maxFreq){
                    maxFreq = j;
                    maxInd = i;
                }
                i += j;
                j = 1;
            }
        }

        if (j > maxFreq)
            maxInd = i;

        return A[maxInd];
    }

    public static int firstPosCeil(int x, int[] A) {

        if (A.length == 0 || A[A.length - 1] < x)
            return -1;

        for(int i = 0; i < A.length; i++) {
            if (A[i] >= x)
                return i;
        }

        return -1;
    }

    public static int[] firstAndLastPos(int x, int[] A) {
        int[] flp = {-1, -1};

        if (A.length == 0) {
            return flp;
        }

        int i = 0;

        while (i < A.length) {
            if(A[i] == x){
                flp[0] = i;
                int j = i;
                while (j < A.length && A[j] == x){
                    j++;
                }
                flp[1] = j - 1;
                break;
            }
            i++;
        }

        return flp;
    }

    public static int leastNonnegMissing(int[] A) {

        if(A.length == 0) {
            return -1;
        }

        int k = 0;

        for(int i : A) {
            if(i == k) k++;
            else break;
        }

        return k;
    }

}