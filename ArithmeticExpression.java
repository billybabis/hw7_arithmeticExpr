import java.util.Map;
import java.util.function.Consumer;

public interface ArithmeticExpression extends Iterable<ArithmeticExpression> {
	public String toString();
	public Integer evaluate();
	public Integer eval(Map<String, Integer> map);
	public void add(ArithmeticExpression num1);
	public default void traverse(Consumer<ArithmeticExpression> f) {
		f.accept(this);	
		forEach(ae->ae.traverse(f));
	}
}
