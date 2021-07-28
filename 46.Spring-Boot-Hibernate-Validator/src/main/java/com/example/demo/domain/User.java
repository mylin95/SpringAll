package com.example.demo.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author MrBird
 * @description 几个常见注解：
 *  1.@NotNull：不能为null，但可以为空字符串
 *  2.@NotEmpty：不能为null，并且长度必须大于0
 *  3.@NotBlank：只能作用在String上，不能为null，而且调用trim()后，长度必须大于0
 */
public class User implements Serializable {
    private static final long serialVersionUID = -2731598327208972274L;

    // @NotBlank(message = "{required}")
    @NotNull
    private String name;

    @Email(message = "{invalid}")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
