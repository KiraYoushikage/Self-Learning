package jdkProxy;

public class ServiceFactory {
	
	public static Object getService(Object service){
		//这里返回的是代理类对象
		return new TransactionInvocationHandler(service).getProxy();	
	}
}
