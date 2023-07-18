package Generics.BridgeMethod4;

import java.util.Date;


/**
 * @author Tousif
 */

/**
 * @5.
 * In summary, you need to remember these facts about translation of Java generics:
 * • There are no generics in the virtual machine, only ordinary classes and methods.
 * • All type parameters are replaced by their bounds.
 * • Bridge methods are synthesized to preserve polymorphism.
 * • Casts are inserted as necessary to preserve type safety. 
 */
public class PairTest1 {

	public static void main(String[] args) {

		DateInterval interval = new DateInterval();
		Pair<Date> pair = interval; // OK--assignment to superclass
		pair.setFirst(new Date());
		pair.setSecond(new Date());
		/**
		 * @2.
		 * Our expectation is that the call to setSecond is polymorphic and that the appropriate method is
		 * called. Since pair refers to a DateInterval object, that should be DateInterval.setSecond . The
		 * problem is that the type erasure interferes with polymorphism.
		 * 
		 * To fix this problem, the compiler
		 * generates a <b>bridge method</b> in the DateInterval class:
		 * 
		 * <b>public void setSecond(Object second) { setSecond((Date) second); }</b>
		 * 
		 * 
		 * @3.
		 * To see why this works, let us carefully follow the execution of the statement
		 * pair.setSecond(aDate)
		 * The variable pair has declared type Pair<Date> , and that type only has a single method called
		 * setSecond , namely setSecond(Object) . The virtual machine calls that method on the object to
		 * which pair refers. That object is of type DateInterval . Therefore, the method
		 * DateInterval.setSecond(Object) is called. That method is the synthesized bridge method. It calls
		 * DateInterval.setSecond(Date) , which is what we want.
		 * 
		 **/	
		
	}

}



