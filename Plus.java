import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class Plus implements ArithmeticExpression {

	private ArrayList<ArithmeticExpression> exps;
	
	public Plus() {
		exps = new ArrayList<ArithmeticExpression>();
	}
	
	public void add(ArithmeticExpression exp) {
		exps.add(exp);
	}
	
	public String toString() {
		String output = "(" + exps.get(0).toString();
		for (int i=1; i < exps.size(); i++) {
			output = output + " + " +  exps.get(i).toString();
		}
		output = output + ")";
		return output;
	}
	public Integer evaluate() {
		Integer total = 0;
		for (ArithmeticExpression exp: exps) {
			total = total + exp.evaluate();
		}
		return total;
	}
	
	public Integer eval(Map<String, Integer> map){
		Integer total = 0;
		for (ArithmeticExpression exp: exps) {
			total = total + exp.eval(map);
		}
		return total;
	}

	@Override
	public Iterator<ArithmeticExpression> iterator() {
		return exps.iterator();
	}
	
}
