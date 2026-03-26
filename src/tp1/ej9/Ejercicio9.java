package tp1.ej9;
import java.util.List;
import java.util.Stack;
public class Ejercicio9 {
	
	public static boolean Balanceo(String s) {
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == '(' || c== '[' || c== '{') {
				stack.push(c);
			}
			else 
			if(stack.isEmpty()) 
				return false;
			else {
				char tope = stack.pop();
				if(c == ')' && tope != '(')
					return false;
				if(c == ']' && tope != '[')
					return false;
				if(c == '}' && tope != '{')
					return false;
		}
		
	}
		return stack.isEmpty();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("esta balandeado?: " + Balanceo("([])}"));
	}

}
