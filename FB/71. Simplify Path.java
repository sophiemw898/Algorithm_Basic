class Solution {
    public String simplifyPath(String path) {
        String res = "/";
        
        String[] words = path.split("/");
        List<String> paths = new ArrayList<>();
        
        for (String s : words) {
            if (s.equals("..")) {
                //".."前一个被删除 ".."出现几次往前删除几个
                if (paths.size() > 0) {
                    paths.remove(paths.size() - 1);
                }
            } else if (!s.equals(".") && !s.equals("")) {
                paths.add(s);
            }
        }
        
        for (String str : paths) {
            res += str + "/";
        }
        
        //delete / at the last one
        if (res.length() > 1) {
            res = res.substring(0, res.length() - 1);
        }
        return res;
    }
}
