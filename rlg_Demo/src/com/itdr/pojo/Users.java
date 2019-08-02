package com.itdr.pojo;

/**
 * @author WangCX
 * @date 2019/8/1 12:43
 */
public class Users {
    private Integer u_id;
    private String u_name;
    private String u_pwd;
    private String u_tel;
    private Integer u_type = 0;
    private Integer u_stats = 0;

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_pwd() {
        return u_pwd;
    }

    public void setU_pwd(String u_pwd) {
        this.u_pwd = u_pwd;
    }

    public String getU_tel() {
        return u_tel;
    }

    public void setU_tel(String u_tel) {
        this.u_tel = u_tel;
    }

    public Integer getU_type() {
        return u_type;
    }

    public void setU_type(Integer u_type) {
        this.u_type = u_type;
    }

    public Integer getU_stats() {
        return u_stats;
    }

    public void setU_stats(Integer u_stats) {
        this.u_stats = u_stats;
    }

    @Override
    public String toString() {
        return "Users{" +
                "u_id=" + u_id +
                ", u_name='" + u_name + '\'' +
                ", u_pwd='" + u_pwd + '\'' +
                ", u_tel='" + u_tel + '\'' +
                ", u_type=" + u_type +
                ", u_stats=" + u_stats +
                '}';
    }
}
