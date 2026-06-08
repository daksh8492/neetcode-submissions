class Solution {
    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();
        for (String cur : strs) {
            str.append(cur.length());
            str.append("#");
            str.append(cur);
        }
        System.out.println(str);
        return str.toString();
    }

    public List<String> decode(String str) {
        if (str.equals("#"))
            return new ArrayList<>();
        System.out.println(str);
        List<String> strs = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            String num = "";
            while (str.charAt(i) != '#') {
                num = num + str.charAt(i);
                i++;
            }
            int size = Integer.parseInt(num);
            StringBuilder add = new StringBuilder();
            for (int j = i + 1; j < i + 1 + size; j++) {
                add.append(str.charAt(j));
            }
            i+=size+1;
            strs.add(add.toString());
        }
        return strs;
    }
}
