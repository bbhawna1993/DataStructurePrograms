import java.util.Stack;

public class SampleEvaluatePostfix {

    public static int evaluatePostfix(String  exp)
    {

        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<exp.length();i++)
        {
           char c=exp.charAt(i);
           if(Character.isDigit(c))
               stack.push(c-'0');
           else {
               int val1=stack.pop();
               int val2=stack.pop();

               switch (c)
               {
                   case '+':
                       stack.push(val2+val1);
                       break;

                   case '-':
                       stack.push(val2-val1);
                       break;

                   case '/':
                       stack.push(val2/val1);
                       break;

                   case '*':
                       stack.push(val1*val2);
               }

           }
        }
        return stack.pop();
    }

    public static void main(String[] args)
    {
        String expression="231*+9-";
        int result=evaluatePostfix(expression);
        System.out.println(result);
    }

}
