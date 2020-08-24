public class Email {
    private String loginName, domain;
    public Email(String loginName, String domain){
        this.loginName = loginName;
        this.domain = domain;
    }
    public String getLoginName(){
        return this.loginName;
    }
    public String getDomain(){
        return this.domain;
    }
}
