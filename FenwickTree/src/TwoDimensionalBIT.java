public class TwoDimensionalBIT {

    private static int[][] construct2DBIT(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int[][] BIT = new int[rows+1][cols+1];
        for(int i = 1; i <= rows; i++){
            for(int j = 1; j <= cols; j++){
                updateTree(BIT, mat[i-1][j-1], i,j);
            }
        }
        return BIT;
    }

    private static void updateTree(int[][] BIT, int val, int row, int col) {
        int j;
        while(row < BIT.length){
            j = col;
            while(j < BIT.length){
                BIT[row][j] += val;
                j = getNext(j);
            }
            row = getNext(row);
        }
    }

    private static int getNext(int index) {
        return index + (index & -index);
    }

    private int getSum(int[][] BIT, int x1, int y1, int x2, int y2){
        return getSumUtil(BIT, x2, y2) -
                getSumUtil(BIT, x1-1, y2) -
                getSumUtil(BIT, x2, y1-1) +
                getSumUtil(BIT, x1-1, y1-1);
    }

    private int getSumUtil(int[][] BIT, int row, int col){
        int sum = 0;
        int j;
        row = row + 1;
        while(row > 0){
            j = col + 1;
            while(j > 0){
                sum += BIT[row][j];
                j = getParent(j);
            }
            row = getParent(row);
        }
        return sum;
    }

    private int getParent(int index) {
        return index - (index & -index);
    }

    public static void main(String[] args) {

        int mat[][] = {
                {1, 1, 2, 2},
                {3, 3, 4, 4},
                {5, 5, 6, 6},
                {7, 7, 8, 8}
        };
        TwoDimensionalBIT twoDimensionalBIT = new TwoDimensionalBIT();
        int [][] BIT = construct2DBIT(mat);
        System.out.println(twoDimensionalBIT.getSum(BIT, 1,1,3,3));

    }

}
