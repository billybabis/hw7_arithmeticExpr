import java.util.*;


public class Variable implements ArithmeticExpression {
	private String var;
	
	public Variable(String x) {var = x;}
	
	public String toString() {
		return var;
	}
	@Override
	public Integer evaluate() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void add(ArithmeticExpression num1) {
		return;
	}
	
	public Integer eval(Map<String, Integer> map) {
		return map.get(var);
	}

	@Override
	public Iterator<ArithmeticExpression> iterator() {
		return new ArrayList<ArithmeticExpression>().iterator();
	}

}
