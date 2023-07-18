/*High level Understanding

For understanding this we need to recall few basics of java:

dot (.) operator in java: In java . (dot operator) is used only to call methods or variables. So we can say out is either method or variable.
Methods in java : we know methods always have parenthesis ‘( )’ after method name, So out cannot be a method in java. So out its a variable and println() is a method.
Class name in java: Class name should start with Capital letter ideally in java, So System is a class.
Now with basic knowledge of java we know :

System is a Class
out is a Variable
println() is a method
Lets get more in details:

out variable: static or instance?

called using class name, so we know its static variable of System class.

but its calling a method println() method so ‘out’ is an object of the reference type PrintStream.

the System class belongs to java.lang package
 * 
 * */

package CoreJavaTopics;
import static CoreJavaTopics.SampleStaticImport.show;
// Static Import
import static java.lang.System.out;

public class StaticImport {

	public static void main(String[] args) {
		out.println("Hello1");
		show(); //Calling without ClassName.methodName()
	}
}
