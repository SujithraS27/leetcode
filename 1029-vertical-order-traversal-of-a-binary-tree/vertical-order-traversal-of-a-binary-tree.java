/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class Tuple {
    TreeNode node;
    int vertical;
    int level;

    Tuple(TreeNode node, int vertical, int level) {
        this.node = node;
        this.vertical = vertical;
        this.level = level;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
        Queue<Tuple> q=new LinkedList<>();
        q.offer(new Tuple(root,0,0));
        while(!q.isEmpty()){
            Tuple tup=q.poll();
            TreeNode node=tup.node;
            int vert=tup.vertical;
            int lev=tup.level;
            if(!map.containsKey(vert)){
                map.put(vert,new TreeMap());
            }
            if(!map.get(vert).containsKey(lev)){
                map.get(vert).put(lev,new PriorityQueue());
            }
            map.get(vert).get(lev).offer(node.val);
            if(node.left!=null){
                q.offer(new Tuple(node.left,vert-1,lev+1));
            }
            if(node.right!=null){
                q.offer(new Tuple(node.right,vert+1,lev+1));
            }
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> levels:map.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes:levels.values()){
                while(!nodes.isEmpty()){
                    ans.get(ans.size() - 1).add(nodes.poll());
                }
            }
        }
        return ans;
    }
}