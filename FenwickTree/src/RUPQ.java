public class RUPQ {
    public int[] createTree(int input[]){
        int[] binaryIndexedTree = new int[input.length+1];
        for(int i = 0; i < input.length; i++){
            update(binaryIndexedTree, i+1, i+1, input[i]);
        }
        return binaryIndexedTree;
    }

    private void update(int[] binaryIndexedTree, int l, int r, int val){
        updateBinaryIndexedTree(binaryIndexedTree, val, l);
        updateBinaryIndexedTree(binaryIndexedTree, -val, r+1);
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
        RUPQ rupq = new RUPQ();


        int input[] = {1, 2, 3, 4, 5};;

        int binaryIndexedTree[] = rupq.createTree(input);

        System.out.println(rupq.getSum(binaryIndexedTree,4));

        rupq.update(binaryIndexedTree, 2,4,2);

        System.out.println(rupq.getSum(binaryIndexedTree,4));

        rupq.update(binaryIndexedTree, 1,3,4);

        System.out.println(rupq.getSum(binaryIndexedTree,3));

    }
    }
