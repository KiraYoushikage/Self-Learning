package jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TransactionInvocationHandler<T> implements InvocationHandler {
	
	private T target;
	
	public TransactionInvocationHandler(T target){
		
		this.target = target;
		
	}
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object obj;
		try{
			
			obj = method.invoke(target, args);
		}catch(Exception e){
			e.printStackTrace();
			//处理的是什么异常，继续往上抛什么异常
			throw e.getCause();

		}finally{
		}
		return obj;
	}
	
	public T getProxy(){
		return (T)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
	}
	
}