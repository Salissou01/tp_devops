package com.ums.dao;
import java.util.List;

import com.ums.db.*;

public interface IDao<T> {

	/**
	 * @param entity
	 * @throws UMSDBException
	 */
	public void create (T entity) throws UMSDBException;

	/**
	 * @param id
	 * @return
	 * @throws UMSDBException
	 */
	public T read (int id) throws UMSDBException;

	/**
	 * @return
	 * @throws UMSDBException
	 */
	public List<T> list () throws UMSDBException;

	/**
	 * @param entity
	 * @throws UMSDBException
	 */
	public void update (T entity) throws UMSDBException;

	/**
	 * @param id
	 * @throws UMSDBException
	 */
	public void delete (int id) throws UMSDBException;
}