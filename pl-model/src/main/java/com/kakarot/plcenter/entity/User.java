package com.kakarot.plcenter.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by jinzj on 2017/1/20.
 */
@Entity
@Table(name = "PL_User")
@Getter
@Setter
@Cacheable(value = false)
public class User {

    private Long id;

    private String username;

    private String password;

    private String state;

    private Date createTime;

//    @CollectionTable(name = "SSO_User_AuthorityList")
//    @ElementCollection
//    @Column(length = 50)
//    private Set<String> authorityList;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (state != null ? !state.equals(user.state) : user.state != null) return false;
        return createTime != null ? createTime.equals(user.createTime) : user.createTime == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
