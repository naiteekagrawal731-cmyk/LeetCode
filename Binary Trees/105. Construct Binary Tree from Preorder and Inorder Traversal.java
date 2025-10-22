class Solution {
    int i = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < inorder.length;i++){
            map.put(inorder[i],i);
        }
        return tree(preorder,inorder,0,preorder.length-1,map);
    }TreeNode tree(int[] preorder, int[] inorder, int left, int right, HashMap<Integer, Integer> map){
        if(left > right || i >= preorder.length){
            return null;
        }
        TreeNode root = new TreeNode(preorder[i]);
        int j = i;
        i++;
        root.left = tree(preorder,inorder,left,map.get(preorder[j])-1,map);
        root.right = tree(preorder,inorder,map.get(preorder[j])+1,right,map);
        return root;
    }
}
