import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

// This is a simple demonstration of Object-Oriented Design practices in forming a coherent Arithmetic expression
// The ArithmeticExpression interface is what will be evaluated, and it can either be an Integer, operator, or variable.
// Thus if we wanted to create the expression "4 + 3" we would need to create a new Plus-ArithmeticExpression object which includes
// the Integer-ArithmeticExpression objects 4 and 3. 

public class HW7Test {
	private static int maxInt=0;
	private static int numInts=0;
	public static ArrayList<Integer> traverse_ext(ArithmeticExpression topExp){
		for (ArithmeticExpression exp : topExp) {
			if (exp instanceof IntegerExp){
				if (exp.evaluate()>maxInt){maxInt=exp.evaluate();}
				numInts++;
			} else {
				traverse_ext(exp);
			}
		}
		ArrayList<Integer> output = new ArrayList<Integer>();
		output.add(maxInt);
		output.add(numInts);
		return output;
	}


	public static void main(String[] args) {
		//Part 2 - Simply use our AirthmeticExpression interface to form an expression and print it out
		System.out.println("Part 2");
		ArithmeticExpression opPlus1 = new Plus();
		ArithmeticExpression num1 = new IntegerExp(new Integer(2));
		ArithmeticExpression num2 = new IntegerExp(new Integer(3));
		opPlus1.add(num1); opPlus1.add(num2);
		ArithmeticExpression opTimes1 = new Product();
		opTimes1.add(opPlus1); opTimes1.add(num1);
		System.out.println(opTimes1.toString());
		System.out.println(opTimes1.evaluate());
		
		
		//Part 3 - includes variables in our expression to compute a value
		System.out.println("");
		System.out.println("Part 3");
		ArithmeticExpression var1 = new Variable("x");
		ArithmeticExpression var2 = new Variable("y");
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("x",new Integer(4));
		map.put("y",new Integer(5));
		ArithmeticExpression opTimes2 = new Product();
		opTimes2.add(var1);
		opTimes2.add(opPlus1);
		opTimes2.add(var2);
		System.out.println("toString(): " + opTimes2.toString());
		System.out.println("EVAL: " + opTimes2.eval(map));
		
		//Part 4a - simply count the number of integers and the maximum integer
		System.out.println("");
		System.out.println("Part 4a");
		System.out.println("toString() :" + opTimes1);
		System.out.println("[Max Int, Number Of Ints] : " + traverse_ext(opTimes1));
		
		//Part 4b - silly, just print the variables.
		System.out.println("");
		System.out.println("Part 4b");
		System.out.println("Print all variables");
		System.out.println("toString(): " + opTimes2.toString());
		Consumer<ArithmeticExpression> f = (ArithmeticExpression exp) -> {
			if (exp instanceof Variable) {System.out.println(exp.toString());}
		};
		opTimes2.traverse(f);
	}

}
