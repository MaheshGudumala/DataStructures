public class SegmentTree {

    int[] tree;
    int[] A;

    SegmentTree(int[] input_array){
        A = input_array;
        tree = new int[A.length * 4];
    }

    void build(int node, int start, int end){
        if(start == end){
            tree[node] = A[start];
        }
        else {
            int mid = (start + end) / 2;

            build(2 * node + 1, start, mid);

            build(2 * node + 2, mid + 1, end);

            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    int query(int node, int start, int end, int l, int r){
        if(r < start || end < l) return 0;
        if(l <= start && end <= r){
            return tree[node];
        }
        int mid = (start + end) / 2;
        int p1 = query(2 * node, start, mid, l, r);
        int p2 = query(2*node+1, mid+1, end, l, r);
        return (p1+p2);
    }

    int[] returnSegmentTree(){
        return tree;
    }

    public static void main(String[] args) {

        int[] input_array = new int[] {1,3,5,7,9,11};
        SegmentTree segmentTree = new SegmentTree(input_array);
        segmentTree.build(0,0,input_array.length-1);
        int[] output_tree = segmentTree.returnSegmentTree();
        for(int i = 0; i < output_tree.length; i++){
            System.out.print(output_tree[i]+" ");
        }
        System.out.print("\n");
        System.out.print(segmentTree.query(0, 1,3, 0, input_array.length-1));
    }
}
