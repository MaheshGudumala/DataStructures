public class FenwickTree {

    public int[] createTree(int input[]){

        int binaryIndexedTree[] = new int[input.length+1];

        for(int i = 1; i <= input.length; i++){
            updateBinaryIndexedTree(binaryIndexedTree, input[i-1], i);
        }
        return binaryIndexedTree;
    }

    private void updateBinaryIndexedTree(int[] binaryIndexedTree, int val, int index) {

        while(index < binaryIndexedTree.length){
            binaryIndexedTree[index] += val;
            index = getNext(index);
        }

    }

    private int getNext(int index) {
        return index + (index & -index);
    }

    private int getSum(int[] binaryIndexedTree, int index) {
        int sum = 0;
        index = index + 1;
        while(index > 0){
            sum += binaryIndexedTree[index];
            index = getParent(index);
        }
        return sum;
    }

    private int getParent(int index) {
        return index - (index & -index);
    }


    public static void main(String args[]){
        int input[] = {1,2,3,4,5, 6, 7};
        FenwickTree ft = new FenwickTree();
        int binaryIndexedTree[] = ft.createTree(input);
        System.out.println(ft.getSum(binaryIndexedTree, 0)); //1
        System.out.println(ft.getSum(binaryIndexedTree, 1)); //3
        System.out.println(ft.getSum(binaryIndexedTree, 2)); //6
        System.out.println(ft.getSum(binaryIndexedTree, 3)); //10
        System.out.println(ft.getSum(binaryIndexedTree, 4)); //15
        System.out.println("Hello");
    }


}
