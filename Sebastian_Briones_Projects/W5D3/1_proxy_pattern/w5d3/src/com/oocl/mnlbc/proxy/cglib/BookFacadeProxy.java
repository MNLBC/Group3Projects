package com.oocl.mnlbc.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class BookFacadeProxy implements MethodInterceptor {

	private Object target;

	public Object getInstance(Object target) {
		this.target = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.target.getClass());
		// Callback method making
		enhancer.setCallback(this);
		// Create a proxy object making
		return enhancer.create();
	}

	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
				throws Throwable {
		
		System.out.println("The start of invocation");
		
		proxy.invokeSuper(obj, args);
		
		System.out.println("End of invocation");
		return null;

	}
}
