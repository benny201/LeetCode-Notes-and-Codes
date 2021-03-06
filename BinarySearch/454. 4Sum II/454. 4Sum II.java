public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A == null || B == null || C == null || D == null) {
            return 0;
        }
        
        if( A.length == 0 || B.length == 0 || C.length == 0 || D.length == 0) {
            return 0;
        }
        
        // save the result of A+B
        Map<Integer,Integer> mapAB = new HashMap<Integer,Integer>();
        // result
        int result = 0;
        
        // put A+B to the map
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                mapAB.put(sum, mapAB.getOrDefault(sum,0) + 1);
            }
        }
        
        // find C+D which equal to -(A+B) to make A+B+C+D = 0
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                result += mapAB.getOrDefault(-sum,0);
            }
        }
        
        return result;
    }
}
