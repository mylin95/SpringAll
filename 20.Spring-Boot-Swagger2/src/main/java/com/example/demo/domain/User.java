package com.example.demo.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value="user对象", description="用户对象user")
public class User implements Serializable {

	private static final long serialVersionUID = -2731598327208972274L;

	@ApiModelProperty(value="用户id", name="id", example="1", required = false)
	private Long id;
	@ApiModelProperty(value="用户名", name="name", example="linmy", required = false)
	private String name;
	@ApiModelProperty(value="年龄", name="age", example="18", required = false)
	private Integer age;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
