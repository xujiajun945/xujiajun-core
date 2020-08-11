package com.xujiajun.core.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author xujiajun
 * @since 2020/7/27
 */
@Setter
@Getter
@ToString
public class Pager<T> implements Serializable {

	private static final long serialVersionUID = 5310974407150833248L;

	private Integer page;

	private Integer rows;

	private Integer totalPage;

	private Integer totalRows;

	private List<T> list;

	public Pager(Integer page, Integer rows, Integer totalRows) {
		this.page = page > 0 ? page : 1;
		this.rows = rows > 0 ? (rows <= 50 ? rows : 50) : 10;
		this.totalRows = totalRows > 0 ? totalRows : 0;
	}

	public Integer position() {
		return (page - 1) * rows;
	}
}
