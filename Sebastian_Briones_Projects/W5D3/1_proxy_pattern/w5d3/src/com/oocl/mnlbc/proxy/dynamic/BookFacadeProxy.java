package com.oocl.mnlbc.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK Dynamic Proxy Class
 * @author BRIONSE
 *
 */
public class BookFacadeProxy implements InvocationHandler {

	private Object target;

	public Object bind(Object target) {

		this.target = target;

		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);

	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;

		System.out.println("Start of invocation.");
		result = method.invoke(target, args);
		System.out.println("End of invocation");
		return result;
	}

}
