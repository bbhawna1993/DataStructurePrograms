import java.util.Stack;

class Test {
    static int Prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;

        }
        return -1;
    }

    static public String infixToPostfix(String exp) {

        //resulting string
        String result = new String("");
        //stack to store the operands
        Stack<Character> stack = new Stack<>();

        //loop that iterate through the expression and evaluates the result
        for (int i = 0; i < exp.length(); i++) {

            char c = exp.charAt(i);
            //check if letter or digit then add it resulting string
            if (Character.isLetterOrDigit(c))
                result += c;
            //if '(' push it to stack
            else if (c == '(')
                stack.push(c);
            //if ')' pop all the characters from the stack until '(' comes and add them to result
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                    return "invalid expression";
                }
                else stack.pop();
            }
            //if a character comes who has
            // priority less than the character at the peek of the stack then
            //push the character with higher priority,add it to the result and push the character with
            // lower priority in the stack
            else {
                while(!stack.isEmpty() && Prec(c) <= Prec(stack.peek()))
                    result += stack.pop();
                    stack.push(c); }
        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    public static void main(String[] args)
    {
        String exp="a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(exp));
    }

}