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
public class BaseEnumData implements Serializable {

	private static final long serialVersionUID = -8172137667686399415L;

	private Integer code;

	private String message;
}
