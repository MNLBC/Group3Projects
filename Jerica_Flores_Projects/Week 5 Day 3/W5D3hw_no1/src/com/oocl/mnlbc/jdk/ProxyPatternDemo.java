package com.oocl.mnlbc.jdk;

public class ProxyPatternDemo {
	
	   public static void main(String[] args) {
		   
		ProxyBook proxy = new ProxyBook();  
        BookFacade bookProxy = (BookFacade) proxy.bind(new RealBook("Breaking Dawn", "Stephanie Meyer"));  
        
        bookProxy.display();
         	
	   }
}