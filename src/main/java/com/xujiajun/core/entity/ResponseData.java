package com.xujiajun.core.entity;

import com.xujiajun.core.api.BaseEnum;
import com.xujiajun.core.constant.BaseResponseCode;
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
public class ResponseData implements Serializable {

	private static final long serialVersionUID = -9111035083111536006L;

	private Integer code;

	private String message;

	private Object data;

	public ResponseData() {
		this(BaseResponseCode.SUCCESS);
	}

	public ResponseData(Integer code, String message) {
		this(code, message, null);
	}

	public ResponseData(Integer code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public ResponseData(Object data) {
		this();
		this.data = data;
	}

	public ResponseData(BaseEnum baseEnum) {
		this(baseEnum.getBaseEnumData().getCode(), baseEnum.getBaseEnumData().getMessage());
	}
}
