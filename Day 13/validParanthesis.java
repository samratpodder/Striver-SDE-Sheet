import java.util.Set;
import java.util.HashSet;
import java.util.Stack;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> mystack = new Stack<>();
        Set<Character> openers = new HashSet<>();
        openers.add('(');
        openers.add('{');
        openers.add('[');
        for (int i = 0; i < s.length(); i++) {
            if (openers.contains(s.charAt(i))) {
                mystack.push(s.charAt(i));
            }
            else{
                if(mystack.isEmpty()){
                    // System.out.println(mystack.isEmpty());
                    return false;
                }
                else{
                    char c = mystack.pop();
                    if(c=='[' && s.charAt(i)!=']'){
                        return false;
                    }
                    if(c=='{' && s.charAt(i)!='}'){
                        return false;
                    }
                    if(c=='(' && s.charAt(i)!=')'){
                        return false;
                    }
                }
            }
        }
        if (!mystack.isEmpty()) {
            return false;
        }
        return mystack.isEmpty();
    }
}