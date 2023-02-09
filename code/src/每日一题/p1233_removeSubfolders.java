package 每日一题;

import java.util.*;


public class p1233_removeSubfolders {
    class prefixTree {
        String val;
        Map<String, prefixTree> childs = new HashMap<>();
        boolean isFolder;

        prefixTree() {
        }

        prefixTree(String v) {
            val = v;
        }
    }

    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        prefixTree root = new prefixTree();
        List<String> ans = new ArrayList<>();
        for (String fold : folder) {
            //若fold不是子文件夹，则flag为true
            boolean flag = true;
            String[] split = fold.split("/");
            prefixTree cur = root;
            //检查fold是否为子文件夹
            for (int i = 1; i < split.length; i++) {
                String f = split[i];
                //若前缀树中不存在此文件夹，则创建，并改变cur指针
                if (!cur.childs.containsKey(f)) {
                    prefixTree newNode = new prefixTree(f);
                    cur.childs.put(f, newNode);
                    cur = newNode;
                    //若前缀树存在此文件夹 且 当前文件夹不是完整路径，则只改变cur指针
                } else {
                    cur = cur.childs.get(f);
                    //否则为子文件夹，不添加到ans结果中，直接跳出，检查下一个文件夹路径
                    if (cur.isFolder == true) {
                        flag = false;
                        break;
                    }
                }
                //遍历到当前路径的最后一个文件夹，则令isFolder为true
                if (i == split.length - 1) {
                    cur.isFolder = true;
                }
            }
            if (flag) {
                ans.add(fold);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] folder = {"/ah/al/am","/ah/al"};
        List<String> list = new p1233_removeSubfolders().removeSubfolders(folder);
        for (String s : list) {
            System.out.print(s + " ");
        }
    }
}
