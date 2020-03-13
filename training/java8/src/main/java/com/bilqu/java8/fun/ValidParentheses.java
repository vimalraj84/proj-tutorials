package com.bilqu.java8.fun;

import javax.xml.transform.sax.SAXSource;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(match("()"));
        System.out.println(match("()[]{}"));
        System.out.println(match("{[]}"));
        System.out.println(match("([)]"));
        System.out.println(match("(]"));
        System.out.println(match("([)"));
    }

    private static boolean match(String input) {
        char[] ch = input.toCharArray();
        Stack<String> stack = new Stack<>();
        String temp = null;
        for (char c : ch) {
            temp = String.valueOf(c);
            if (!stack.isEmpty()) {
                switch(temp){
                    case ")":
                        if(stack.peek().equalsIgnoreCase("("))
                            stack.pop();
                        break;
                    case "}":
                        if(stack.peek().equalsIgnoreCase("{"))
                            stack.pop();
                        break;
                    case "]":
                        if(stack.peek().equalsIgnoreCase("["))
                            stack.pop();
                        break;
                    case ">":
                        if(stack.peek().equalsIgnoreCase("<"))
                            stack.pop();
                        break;
                    default:
                        stack.push(temp);
                        break;
                }
            } else {
                stack.push(temp);
            }
        }
        if (stack.isEmpty())
            return true;
        else return false;

    }
}
