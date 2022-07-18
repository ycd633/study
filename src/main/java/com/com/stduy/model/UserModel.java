package com.com.stduy.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserModel {

    @Override
    public String toString() {
        return "UserModel{" +
                "user_id='" + user_id + '\'' +
                ", login_id='" + login_id + '\'' +
                ", name='" + name + '\'' +
                ", email_addr='" + email_addr + '\'' +
                ", role='" + role + '\'' +
                ", create_dt='" + create_dt + '\'' +
                ", is_disabled='" + is_disabled + '\'' +
                ", user_auth='" + user_auth + '\'' +
                '}';
    }

    String user_id;

    String login_id;

    String name;

    String email_addr;

    String role;

    String create_dt;

    String is_disabled;

    String user_auth;
}
