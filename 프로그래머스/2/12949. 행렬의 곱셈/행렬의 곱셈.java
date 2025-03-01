class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int arr1RowCount = arr1.length;
        int arr2RowCount = arr2.length;
        int arr2ColumnCount = arr2[0].length;
        
        int[][] answer = new int[arr1RowCount][arr2ColumnCount];
        
        for (int i = 0; i < arr1RowCount; i++) {
            for (int j = 0; j < arr2ColumnCount; j++) {
                for (int k = 0; k < arr2RowCount; k++) { // arr1 열의 크기 = arr2 행의 크기
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        
        return answer;
    }
}