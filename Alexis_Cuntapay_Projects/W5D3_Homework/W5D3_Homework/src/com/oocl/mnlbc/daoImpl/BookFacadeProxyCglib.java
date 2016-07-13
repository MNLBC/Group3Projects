package com.oocl.mnlbc.daoImpl;

import java.lang.reflect.Method;  
import net.sf.cglib.proxy.Enhancer;  
import net.sf.cglib.proxy.MethodInterceptor;  
import net.sf.cglib.proxy.MethodProxy;  
/**
 * 
 * @author CUNTAAL
 *
 */
public class BookFacadeProxyCglib implements MethodInterceptor {  
    private Object target;  
  
    /** 
Making making * create a proxy object
     *  
     * @param target 
     * @return 
     */  
    public Object getInstance(Object target) {  
        this.target = target;  
        Enhancer enhancer = new Enhancer();  
        enhancer.setSuperclass(this.target.getClass());  
        //Callback method making
        enhancer.setCallback(this);  
        //Create a proxy object making
        return enhancer.create();  
    }  
  
    @Override  
    //Callback method making
    public Object intercept(Object obj, Method method, Object[] args,  
            MethodProxy proxy) throws Throwable {  
        System.out.println("The start of something");  
        proxy.invokeSuper(obj, args);  
        System.out.println("End of things");  
        return null;  
  
  
    }  
  
}  