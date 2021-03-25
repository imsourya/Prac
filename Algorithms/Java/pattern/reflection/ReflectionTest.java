package duega.pattern.reflection;

class ReflectionClass {
	 
    /**
     * constructor
     */
    public ReflectionClass() {
           System.out.println("in constructor of ReflectionClass");
    }
 
    /**
     * Method with no parameter
     */
    public void methodNoPara() {
           System.out.println("in methodNoPara() of ReflectionClass ");
    }
    
    /**
     * Method with String parameter
     */
    public void methodString(String str) {
           System.out.println("in methodString()   > " + str);
    }
 
    /**
     * Method with Integer parameter
     */
    public void methodInteger(Integer integer) {
           System.out.println("in methodInteger()  > " + integer);
    }
 
}

public class ReflectionTest {
	
	public static void main(String[] args) {

		try {
			
			Class cls = Class.forName("duega.pattern.reflection.ReflectionClass");
			Object newObj = cls.newInstance();
			
			ReflectionClass rc = (ReflectionClass)newObj;
			
			rc.methodNoPara();
			//Method method = cls.getMethod("methodNoPara", null);
            //method.invoke(newObj, null);
			
			//method = cls.getMethod("methodString", stringPara);
            //method.invoke(object, "ankit");

            // step 3c, calling methodInteger()
            //method = cls.getMethod("methodInteger", integerPara);
            //method.invoke(object, 911);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalAccessException | InstantiationException e) {
			e.printStackTrace();
		} 
		//catch(NoSuchMethodException | InvocationTargetException e) {
		//e.printStackTrace();
		//}
		
		/* Using class Loader
		 * ClassLoader classLoader = ClassLoader.getSystemClassLoader();
         * Class cls = classLoader.loadClass("ReflectionClass");
		 */
	}
}
