package com.wyglxt.base;

import java.util.List;
import java.util.Map;

public interface IBaseService {
	// query records
	public List<?> readRecord(Class<?> clazz, Map<String, Object> condition);

	// create record
	public Object createRecord(Object record);

	// get record by id
	public Object getRecord(Class<?> clazz, int id);

	// load record by id
	public Object loadRecord(Class<?> clazz, int id);

	// select record by id
	public Object selectRecord(Class<?> clazz, int id);

	// update record
	public Object updateRecord(Object record);

	// evict record from cache
	public void evictRecord(Object record);

	// merge record (insert or update)
	public Object mergeRecord(Object record);

	// delete record by id
	public boolean deleteRecord(Class<?> clazz, int id);

	// get count
	public int getTotal(Class<?> clazz);

	// query all records
	public List<?> getAllRecords(Class<?> clazz);
}
