package com.kakarot.plcenter.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.rest.core.annotation.Description;

import javax.persistence.*;

/**
 * Created by jinzj on 2017/1/20.
 */
@Entity
@Table(name = "PL_User")
@Getter
@Setter
@Cacheable(value = false)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 20,nullable = false)
    @Description("用户名")
    private String username;

    @Column(length = 50,nullable = false)
    @Description("密码")
    private String password;

    @Column(length = 50)
    @Description("昵称")
    private String nickName;

//    @CollectionTable(name = "SSO_User_AuthorityList")
//    @ElementCollection
//    @Column(length = 50)
//    private Set<String> authorityList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!id.equals(user.id)) return false;
        if (!username.equals(user.username)) return false;
        if (!password.equals(user.password)) return false;
        if (nickName != null ? !nickName.equals(user.nickName) : user.nickName != null) return false;
//        return authorityList != null ? authorityList.equals(user.authorityList) : user.authorityList == null;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + username.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
//        result = 31 * result + (authorityList != null ? authorityList.hashCode() : 0);
        return result;
    }
}
