package com.xujiajun.core.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author xujiajun
 * @since 2020/7/27
 */
@Setter
@Getter
@ToString
public class BaseQuery implements Serializable {

	private static final long serialVersionUID = -5191954064692479750L;

	private Integer page;

	private Integer rows;

	private Integer position;
}
