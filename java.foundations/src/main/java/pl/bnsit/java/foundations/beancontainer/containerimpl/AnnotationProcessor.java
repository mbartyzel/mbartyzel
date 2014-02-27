package pl.bnsit.java.foundations.beancontainer.containerimpl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationProcessor {

	public <T> void process(T t) {

		for (Method method : t.getClass().getMethods()) {
			try {
				
				if (method.isAnnotationPresent(Init.class)) {
					method.invoke(t, null);
				}

			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {

				throw new AnnotationProcessorExeption(
						"Cannot invoke @Init method. "
								+ "One is expected not to have parameters and to be void.",
						e);
			}
		}
	}

}
