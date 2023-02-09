/**
你是一位系统管理员，手里有一份文件夹列表 folder，你的任务是要删除该列表中的所有 子文件夹，并以 任意顺序 返回剩下的文件夹。 

 如果文件夹 folder[i] 位于另一个文件夹 folder[j] 下，那么 folder[i] 就是 folder[j] 的 子文件夹 。 

 文件夹的「路径」是由一个或多个按以下格式串联形成的字符串：'/' 后跟一个或者多个小写英文字母。 

 
 例如，"/leetcode" 和 "/leetcode/problems" 都是有效的路径，而空字符串和 "/" 不是。 
 

 

 示例 1： 

 
输入：folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
输出：["/a","/c/d","/c/f"]
解释："/a/b" 是 "/a" 的子文件夹，而 "/c/d/e" 是 "/c/d" 的子文件夹。
 

 示例 2： 

 
输入：folder = ["/a","/a/b/c","/a/b/d"]
输出：["/a"]
解释：文件夹 "/a/b/c" 和 "/a/b/d" 都会被删除，因为它们都是 "/a" 的子文件夹。
 

 示例 3： 

 
输入: folder = ["/a/b/c","/a/b/ca","/a/b/d"]
输出: ["/a/b/c","/a/b/ca","/a/b/d"] 

 

 提示： 

 
 1 <= folder.length <= 4 * 10⁴ 
 2 <= folder[i].length <= 100 
 folder[i] 只包含小写字母和 '/' 
 folder[i] 总是以字符 '/' 起始 
 每个文件夹名都是 唯一 的 
 

 Related Topics 字典树 数组 字符串 👍 142 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
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
}
//leetcode submit region end(Prohibit modification and deletion)
