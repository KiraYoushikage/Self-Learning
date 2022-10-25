package mybatis.binding;

import mybatis.dao.IUserDao;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

public class MapperProxy<T> implements InvocationHandler, Serializable {
    private static final long serialVersionUID = -6424540398559729838L;
    private Map<String,String> sqlSession;
    private Class<T> mapperInterface;

    private Object proxyObject;//这是jdk给我们实现的实现target接口的代理对象

    public MapperProxy(Map<String, String> sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (proxy.getClass().equals(method.getDeclaringClass())){
            System.out.println("来了？");
            return method.invoke(this,args);
        }
        return "你的被代理了！" + sqlSession.get(mapperInterface.getName() + "." + method.getName());
    }

}
