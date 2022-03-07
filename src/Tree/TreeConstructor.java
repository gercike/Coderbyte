package Tree;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;

public class TreeConstructor {

    public static void main(String[] args) {
        System.out.println(treeConstructor(new String[]{"(1,2)", "(2,4)", "(7,4)"}));
    }

    public static String treeConstructor(String[] strArr) {
        TreeMap<Integer, List<Integer>> treeOfParentNodesAndTheirChildren = new TreeMap<>();
        HashSet<Integer> children = new HashSet<>();
        for (String s : strArr) {
            int child = Integer.parseInt(s.substring(s.indexOf("(") + 1, s.indexOf(",")));
            int parent = Integer.parseInt(s.substring(s.indexOf(",") + 1, s.indexOf(")")));
            if (children.contains(child)) {
                return "false";
            } else {
                children.add(child);
            }
            if (treeOfParentNodesAndTheirChildren.containsKey(parent) && treeOfParentNodesAndTheirChildren.get(parent).size() == 2) {
                return "false";
            }
            if (treeOfParentNodesAndTheirChildren.containsKey(parent)) {
                if (treeOfParentNodesAndTheirChildren.get(parent).get(0) < parent && child < parent) {
                    return "false";
                }
                if (treeOfParentNodesAndTheirChildren.get(parent).get(0) > parent && child > parent) {
                    return "false";
                }
            }
            treeOfParentNodesAndTheirChildren.putIfAbsent(parent, new ArrayList<>());
            treeOfParentNodesAndTheirChildren.get(parent).add(child);
        }
        return "true";
    }
}
