package com.xujiajun.core.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * jackson工具类
 *
 * @author xujiajun
 * @since 2020/7/8
 */
@Slf4j
public class JsonUtils {

	/**
	 * ObjectMapper线程安全
	 */
	private static final ObjectMapper PARSER;

	static {
		PARSER = new ObjectMapper();
		// 反序列时, 当出现未知属性, 不失败
		PARSER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	private JsonUtils() {
		throw new RuntimeException("util class can not be init!");
	}

	public static Object parseObject(String json) {
		return parseObject(json, Object.class);
	}

	public static <T> T parseObject(String json, Class<T> clazz) {
		T result = null;
		try {
			result = PARSER.readValue(json, clazz);
		} catch (JsonProcessingException e) {
			log.error("反序列化失败", e);
		}
		return result;
	}

	public static <T> List<T> parseArray(String json, Class<T> clazz) {
		List<T> result = null;
		CollectionType collectionType = PARSER.getTypeFactory().constructCollectionType(ArrayList.class, clazz);
		try {
			result = PARSER.readValue(json, collectionType);
		} catch (JsonProcessingException e) {
			log.error("反序列化失败", e);
		}
		return result;
	}

	public static <T> T parse(String json, Class<T> clazz, Class<?>... classes) {
		T result = null;
		JavaType javaType = PARSER.getTypeFactory().constructParametricType(clazz, classes);
		try {
			result = PARSER.readValue(json, javaType);
		} catch (JsonProcessingException e) {
			log.error("反序列化失败", e);
		}
		return result;
	}

	public static <T> T parse(String json, TypeReference<T> typeReference) {
		T result = null;
		try {
			result = PARSER.readValue(json, typeReference);
		} catch (JsonProcessingException e) {
			log.error("反序列化失败", e);
		}
		return result;
	}

	public static String toJson(Object object) {
		String result = null;
		try {
			result = PARSER.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			log.error("序列化失败", e);
		}
		return result;
	}

}
