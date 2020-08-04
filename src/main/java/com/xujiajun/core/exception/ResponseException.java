package com.xujiajun.core.exception;

import com.xujiajun.core.api.BaseEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author xujiajun
 * @since 2020/7/27
 */
@Setter
@Getter
@ToString
public class ResponseException extends RuntimeException {

	private static final long serialVersionUID = 6222113216368170304L;

	private Integer code;

	private String message;

	public ResponseException(Integer code, String message) {
		super(message);
		this.code = code;
	}

	public ResponseException(BaseEnum baseEnum) {
		this(baseEnum.getBaseEnumData().getCode(), baseEnum.getBaseEnumData().getMessage());
	}
}
