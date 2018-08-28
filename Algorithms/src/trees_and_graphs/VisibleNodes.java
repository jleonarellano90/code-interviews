package trees_and_graphs;

/* In a binary tree, if in the path from the root to the node A, there is no
 * node with value greater than A's value, then A is a visible node. We need 
 * to count the number of visible nodes in a binary tree.
 */
class VisibleNodes {
    public int visibleNodes(TreeNode T) {
        return numVisible(T, Integer.MIN_VALUE);
    }

    public int numVisible(TreeNode T, int maxValue) {
        if(T == null) {
            return 0;
        }

        int num = 0;

        if(T.value >= maxValue) {
            num = 1;
            maxValue = T.value;
        }

        return num + numVisible(T.left, maxValue) + numVisible(T.right, maxValue);
    }
}
