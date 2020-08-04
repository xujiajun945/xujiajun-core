package com.xujiajun.core.constant;

import com.xujiajun.core.api.BaseEnum;
import com.xujiajun.core.entity.BaseEnumData;
import lombok.Getter;

/**
 * @author xujiajun
 * @since 2020/7/27
 */
@Getter
public enum BaseResponseCode implements BaseEnum {

	/** 成功 */
	SUCCESS(1, "success"),

	/** 请求异常 */
	BAD_REQUEST(400, "Bad Request"),

	NOT_FOUND(404, "Not Found"),

	METHOD_NOT_ALLOWED(405, "不被允许的请求方法"),

	UNSUPPORTED_MEDIA_TYPE(415, "不支持的媒体类型"),

	INTERNAL_SERVER_ERROR(500, "服务器异常"),
	;

	private Integer code;

	private String message;

	BaseResponseCode(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	@Override
	public BaseEnumData getBaseEnumData() {
		BaseEnumData baseEnumData = new BaseEnumData();
		baseEnumData.setCode(this.code);
		baseEnumData.setMessage(this.message);
		return baseEnumData;
	}
}
