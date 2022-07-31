package com.com.stduy.users.model.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserVo {

    String userId;

    String loginId;

    String name;

    String emailAddr;

    String disabled;

    String password;

    String createDt;

    String expireDt;

    String locked;

    String participationId;

    @Override
    public String toString() {
        return "UserVo{" +
                "userId='" + userId + '\'' +
                ", loginId='" + loginId + '\'' +
                ", name='" + name + '\'' +
                ", emailAddr='" + emailAddr + '\'' +
                ", disabled='" + disabled + '\'' +
                ", password='" + password + '\'' +
                ", createDt='" + createDt + '\'' +
                ", expireDt='" + expireDt + '\'' +
                ", locked='" + locked + '\'' +
                ", participationId='" + participationId + '\'' +
                '}';
    }
}
