import java.util.Stack;

public class ValidParentheses20 {

	public ValidParentheses20() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String para = "()";
	        System.out.println("Parentheses is valid " +
	        		isValid(para));
	}
	
public static boolean isValid(String s) {
	
	//convert string in array
	char[] pthses = s.toCharArray();
	Stack<Character> pthsesstack=new Stack<Character>();
	
	for(char c:pthses)
	{

			if(c==')')
			{
				if(pthsesstack.isEmpty()||pthsesstack.peek()!='(')
				{
					return false;
				}
				if(!pthsesstack.isEmpty()&&pthsesstack.peek()=='(')
				{
					pthsesstack.pop();
				}
				
			}
			else {
				if(c=='}')
				{
					if(pthsesstack.isEmpty()||pthsesstack.peek()!='{')
					{
						return false;
					}
					if(!pthsesstack.isEmpty()&&pthsesstack.peek()=='{')
					{
						pthsesstack.pop();
					}	
				}
				else {
					if(c==']')
					{
						if(pthsesstack.isEmpty()||pthsesstack.peek()!='[')
						{
							return false;
						}
						if(!pthsesstack.isEmpty()&&pthsesstack.peek()=='[')
						{
							pthsesstack.pop();
						}	
					}
					else {
						pthsesstack.push(c);
					}
				}
			}
			
	}
	
	
	return pthsesstack.isEmpty();
        
    }

}
