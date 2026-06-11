class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while(i < s.length()){
            char ch = s.charAt(i);
            switch(ch){
                case '[': {
                    stack.push(ch);
                    break;
                }
                case '{': {
                    stack.push(ch);
                    break;
                }
                case '(': {
                    stack.push(ch);
                    break;
                }
                case ']': {
                    if(stack.isEmpty() || stack.pop()!='[') return false;
                    break;
                }
                case '}': {
                    if(stack.isEmpty() || stack.pop()!='{') return false;
                    break;
                }
                case ')': {
                    if(stack.isEmpty() || stack.pop()!='(') return false;
                    break;
                }
                default: return false;
            }
            i++;
        }
        return stack.isEmpty();
    }
}
