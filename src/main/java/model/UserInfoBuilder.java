package model;

public class UserInfoBuilder {
    private String name;
    private String job;

    public static UserInfoBuilder with(){ return new UserInfoBuilder();}

    public UserInfoBuilder theName(String name){
        this.name = name;
        return this;
    }

    public UserInfoBuilder andTheJob(String job){
        this.job = job;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public UserInfo build(){
        return new UserInfo(this);
    }
}
