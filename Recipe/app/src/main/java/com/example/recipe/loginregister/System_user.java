package com.example.recipe.loginregister;

public class System_user {
    private Integer _id;
    private String user_code;
    private String user_pass;
    private String user_pass_again;

    public Integer get_Id() {
        return _id;
    }

    public void setId(Integer _id) {
        this._id = _id;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public String getUser_pass_again() {
        return user_pass_again;
    }

    public void setUser_pass_again(String user_pass_again) {
        this.user_pass_again = user_pass_again;
    }


    @Override
    public String toString() {
        return "Values{" +
                "id=" + _id +
                ", user_code='" + user_code + '\'' +
                ", user_pass='" + user_pass + '\'' +
                ", user_pass_again='" + user_pass_again + '\'' +
                '}';
    }
}
