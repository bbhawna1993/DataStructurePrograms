import java.util.Stack;

public class StackExampleInfixToPostfix {

   public static int Prec(Character ch)
   {
       switch(ch)
       {
           case '+':
           case '-':
               return 1;

           case '/':
           case '*':
               return 2;

           case '^':
               return 3;
       }
       return -1;
   }

   public static String convertInfixToPostfix(String exp)
   {
      String result = new String("");
      Stack<Character> stack=new Stack<>();

      for(int i=0;i<exp.length();i++)
      {
          char c=exp.charAt(i);
          if(Character.isLetterOrDigit(c))
              result+=c;
          else if(c== ')') {
              while (!stack.isEmpty() && stack.peek()!='(')
                 result+=stack.pop();
              if(!stack.isEmpty() && stack.peek()!='(')
                  return "invalid expression";
              else
                  stack.pop();
          }
          else if(c=='(')
              stack.push(c);
          else
          {
              while(!stack.isEmpty() && Prec(c)<=Prec(stack.peek()))
                  result+=stack.pop();
              stack.push(c);
          }

      }

      while(!stack.isEmpty()){
          result+=stack.pop();}

      return result;
   }

   public static void main(String[] args)
   {
       String exp="a+b*(c^d-e)^(f+g*h)-i";
       System.out.print(convertInfixToPostfix(exp));
   }

}
