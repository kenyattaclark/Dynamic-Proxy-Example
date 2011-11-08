package org.okcjug.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
	
	@SuppressWarnings("unchecked")
	public static<T> T build(Class<T> type, final T obj) {
        return (T) Proxy.newProxyInstance(obj.getClass().getClassLoader(), 
        		new Class[] { type }, new InformationalInvocationHandler<T>(obj));
    }
	
	private static final class InformationalInvocationHandler<T> implements InvocationHandler {
      
		private T delegate;
		
		public InformationalInvocationHandler(T delegate) {
            this.delegate = delegate;
        }

		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			System.out.println("Do something before method call.");
			Object ret = method.invoke(delegate, args);
			System.out.println("Do something after method call.");
			return ret;
		}
	}
}