package MBean;

public class User implements UserMBean{
    String name;
    String pwd;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public String getPwd() {
        return this.pwd;
    }

    @Override
    public void setPwd(String pwd) {
        this.pwd=pwd;
    }
}
