package pl.bnsit.java.foundations.beancontainer.containerimpl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class AnnotationProcessor {

	public <T> void process( T t ) {
		Class<? extends Object> clazz = t.getClass();

		Set<Method> methods = getMethodsAnnotatedWith( clazz, Init.class );
		for (Method method : methods) {
			try {
				
				method.invoke(t, null);
			
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				
				throw new AnnotationProcessorExeption(
						"Cannot invok @Init method. " +
						"One is expected not to have parameters and to be void.", e);
			}
		}
	}

	private Set<Method> getMethodsAnnotatedWith(Class<? extends Object> clazz,
			Class<?> annotationType) {
		
		Method[] allMethods = clazz.getMethods();
		Set<Method> selectedMethods = new HashSet<>();
		
		for (Method m : allMethods) {
			Annotation[] annotations = m.getAnnotations();
			for ( Annotation annotation : annotations) {
				if ( annotation.annotationType().equals(annotationType) ) {
					selectedMethods.add(m);
				}
			}
		}
		
		return selectedMethods;
	}
}
