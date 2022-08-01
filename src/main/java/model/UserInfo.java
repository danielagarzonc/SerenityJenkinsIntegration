package model;

public class UserInfo {
    public String name;
    public String job;

    public UserInfo(UserInfoBuilder userInfoBuilder){
        this.name = userInfoBuilder.getName();
        this.job = userInfoBuilder.getJob();
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }
}
