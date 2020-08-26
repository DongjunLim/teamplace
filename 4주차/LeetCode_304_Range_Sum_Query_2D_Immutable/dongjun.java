/**
 *  @��������
 *  �������� ����� Ǯ�����ϴ�.
 *  �� �ε��������� �������� �̸� ����� ���� ����,
 *  sumRegion �Լ��� ȣ��ɶ� �̸� ����� ���� �������� �̿���
 *  ����ȿ���� �������ϴ�.
 *
 *  @����
 *  Runtime: 10 ms
 *  Memory Usage: 45.4 MB
 *
 */
class NumMatrix {

    private int[][] matrix;
    private int[][] rowSum;
    private int[][] matSum;

    private int rowLength;
    private int colLength;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        rowLength = matrix.length;

        if(matrix.length != 0){
            colLength = matrix[0].length;
            this.setSumArr();
        }
    }

    public void setSumArr(){
        rowSum = new int[rowLength][colLength];
        matSum = new int[rowLength][colLength];

        rowSum[0][0] = matrix[0][0];
        matSum[0][0] = matrix[0][0];

        for(int c = 1; c < colLength; c++){
            rowSum[0][c] = rowSum[0][c-1] + matrix[0][c];
            matSum[0][c] = rowSum[0][c];
        }

        for(int i = 1; i < rowLength; i++){
            rowSum[i][0] = matrix[i][0];
            matSum[i][0] = matSum[i-1][0] + rowSum[i][0];
            for(int j = 1; j < colLength; j++){
                rowSum[i][j] = rowSum[i][j-1] + matrix[i][j];
                matSum[i][j] = matSum[i-1][j] + rowSum[i][j];
            }

        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        int ret = matSum[row2][col2];

        if(row1 != 0)
            ret -= matSum[row1-1][col2];

        if(col1 != 0){
            ret -= matSum[row2][col1-1];
            if(row1 != 0)
                ret += matSum[row1-1][col1-1];
        }

        return ret;
    }
}
