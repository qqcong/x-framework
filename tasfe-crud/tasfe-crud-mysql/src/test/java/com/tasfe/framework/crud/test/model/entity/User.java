package com.tasfe.framework.crud.test.model.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.tasfe.framework.crud.api.annotation.Sharding;
import com.tasfe.framework.crud.api.enums.StoragerType;
import com.tasfe.framework.crud.api.annotation.Storager;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import com.tasfe.framework.crud.mysql.type.DataState;

/**
 * Created by Lait on 2017/4/15
 * 用户信息
 */
@Alias("User")
@Table(name = "t_user")
@Storager(storage={StoragerType.MYSQL})
@Sharding(key="id")
@Data
public class User{

   /* @Transient
    public static final String ID = "id";
    @Transient
    public static final String USER_ID = "userId";*/


    @Id
    private Long id;

    private Long userId;
    private Long deptId;
    private Long orderId;

    private String userName;

    //private String loginName;

    private String password;

    private String mobilePhone;

    private String officePhone;

    private String email;

    private String job;



    private DataState status;

    public User() {
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (userId == null) {
            if (other.userId != null)
                return false;
        } else if (!userId.equals(other.userId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", deptId=" + deptId + ", userName=" + userName + ", id=" + id
                + ", password=" + password + ", mobilePhone=" + mobilePhone + ", officePhone=" + officePhone
                + ", email=" + email + ", job=" + job + ", orderId=" + orderId + ", status=" + status + "]";
    }

}
