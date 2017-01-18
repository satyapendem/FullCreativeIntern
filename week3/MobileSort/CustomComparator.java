import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;


public class CustomComparator {
	
	private static Method targetMethod = null;
	private static int sortOrder = 0;
	
	public static synchronized Comparator<?> getComparator(String className, String fieldName, int order) throws ClassNotFoundException,IllegalArgumentException{
		if(!validateArgs(className, fieldName, order)){
			throw new IllegalArgumentException();
		}
		
		Comparator<?> resultComparator = null;
		Method[] methods = null;
		targetMethod = null;
		sortOrder = order;
		
		Class targetClass = Class.forName(className);
		methods = targetClass.getMethods();
		for(Method method : methods){
			if(method.getName().toLowerCase().matches("get*" + fieldName.toLowerCase())){
				targetMethod = method;
				break;
			}
		}
		if(null == targetMethod){
			throw new NoSuchMethodError();
		}
		
		resultComparator = new Comparator() {
			
			@Override
			public int compare(Object o1, Object o2) {
				int retVal = 0;
				try {
					Object value1 = targetMethod.invoke(o1, null);
					Object value2 = targetMethod.invoke(o2, null);
					if(sortOrder == 0){
						retVal = compareValues(value1, value2);
					}
					else{
						retVal = compareValues(value2, value1);
					}
				} catch (IllegalArgumentException e) {
					throw e;
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} 
				return retVal;
			}
		};
		return resultComparator;
	}
	public static boolean validateArgs(String className, String fieldName, int order){
		boolean result = false;
		if(null != className && 0 != className.length()
				&& null != fieldName && 0 != fieldName.length()
				&& 0 <= order || 1 >= order){
			result = true;
		}
		return result;
	}
	
	public static int compareValues(Object value1, Object value2) throws SecurityException, NoSuchMethodException, 
	IllegalArgumentException, IllegalAccessException, InvocationTargetException{

		int result = 0;
		Method method1 = null;
		if(null == value1 && null == value2){
			return 0;
		}
		else if(null == value1){
			return -1;
		}
		else if(null == value2){
			return 1;
		}
		method1 = value1.getClass().getMethod("compareTo",new Class[]{value2.getClass()});
		result = (Integer)method1.invoke(value1, new Object[]{value2});
		return result;
	}
}
