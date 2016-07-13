package com.oocl.mnlbc.daoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 
 * @author CUNTAAL
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
		System.out.println("The start of something");
		// Implementation method of making
		result = method.invoke(target, args);
		System.out.println("End of things");
		return result;
	}

}