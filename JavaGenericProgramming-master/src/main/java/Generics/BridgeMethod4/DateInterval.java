package Generics.BridgeMethod4;

import java.util.Date;

/**
 * @author Tousif
 *
 */
public class DateInterval extends Pair<Date> {
	//After erasure	:	DateInterval extends Pair

	public void setSecond(Date second) {

		if (second.compareTo(getFirst()) >= 0)
			super.setSecond(second);
	}
	/**
	 * @1.
	 * Perhaps surprisingly, there is another setSecond method, inherited from Pair , namely,
	 * 
	 * public void setSecond(Object second)
	 * 
	 * This is clearly a different method because it has a parameter of a different type— Object instead of Date .
	 * But it shouldn’t be different.
	 * 
	 * */
	
	//Suppose the DateInterval method also overrides the getSecond method:
	public Date getSecond() { 
		return (Date) super.getSecond().clone(); 
	}
	/**
	 * @4.
	 * In the DateInterval class, there are two getSecond methods:
	 * 
	 * Date getSecond() // defined in DateInterval
	 * Object getSecond() // overrides the method defined in Pair to call the first method
	 * 
	 * You could not write Java code like that; it would be illegal to have two methods with the same
	 * parameter types—here, with no parameters. However, in the virtual machine, the parameter types and
	 * the return type specify a method. Therefore, the compiler can produce bytecodes for two methods
	 * that differ only in their return type, and the virtual machine will handle this situation correctly.
	 */
}
