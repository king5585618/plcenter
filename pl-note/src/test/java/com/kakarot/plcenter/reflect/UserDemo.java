package com.kakarot.plcenter.reflect;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author jinzj
 * @since v1.0.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDemo {

    private Long id;
    private String userName;
    private String password;
    private String realName;
}
