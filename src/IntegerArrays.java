public class IntegerArrays {

    public static void swap(int[] A, int i, int j) {
        if (i < 0 || j < 0 || i >= A.length || j >= A.length)
            return;
        int k = A[i];
        A[i] = A[j];
        A[j] = k;
    }

    public static boolean sorted(int[] A) {
        if (A.length == 0)
            return true;
        int before = A[0];
        for (int i = 1; i < A.length; i++){
            if (A[i] < before)
                return false;
            before = A[i];
        }
        return true;
    }

    public static int[] reversedCopy(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++){
            B[i] = A[A.length - i - 1];
        }
        return B;
    }

    public static void reverse(int[] A) {
        for (int i = 0; i < A.length / 2; i++){
            swap(A, i, A.length - i - 1);
        }
    }

    public static int maxPos(int[] A, int l, int r) {
        if (l < 0 || r < 0 || l >= A.length || r >= A.length)
            return -1;
        int max = l;
        for(int i = l + 1; i <= r; i++) {
            if (A[i] > A[max])
                max = i;
        }
        return max;
    }

    private static int minPos(int[] A, int l, int r) {
        if (l < 0 || r < 0 || l >= A.length || r >= A.length)
            return -1;
        int min = l;
        for(int i = l + 1; i <= r; i++) {
            if (A[i] < A[min])
                min = i;
        }
        return min;
    }

    public static void selectionSortMax(int[] A) {
        for (int i = 0; i < A.length; i++) {
            int p = minPos(A, i, A.length - 1);
            swap(A, i, p);
        }
    }

    public static int mostFrequentElement(int[] A) {
        if (A.length == 0)
            return -1;
        int maxFreq = 0;
        int mostFreq = A[0];
        selectionSortMax(A);
        int i = 0;
        while (i < A.length){
            int freq = 1;
            int j = i + 1;
            while (j < A.length && A[i] == A[j]){
                freq++;
                j++;
            }
            if (freq > maxFreq){
                maxFreq = freq;
                mostFreq = A[i];
            }
            i = j;
        }
        return mostFreq;
    }
}
