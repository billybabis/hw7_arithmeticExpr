import java.util.*;

public class IntegerExp implements ArithmeticExpression {
	private Integer val;
	
	public IntegerExp(Integer i) {val = i;}

	public String toString(){
		return val.toString();
	}
	
	public Integer evaluate() {
		return val;
	}

	@Override
	public void add(ArithmeticExpression num1) {
		return;
	}
	
	public Integer eval(Map<String, Integer> map) {
		return val;
	}

	@Override
	public Iterator<ArithmeticExpression> iterator() {
		return new ArrayList<ArithmeticExpression>().iterator();
	}

}
