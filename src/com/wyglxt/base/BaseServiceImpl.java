package com.wyglxt.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.wyglxt.AppConstants;

/**
 * 模块说明： service基类
 * 
 */
public abstract class BaseServiceImpl implements IBaseService {
	protected List<BaseDAO> daoList = null;

	public BaseServiceImpl() {
		daoList = new ArrayList<BaseDAO>();
	}

	public void init() {
		buildAbilityDao();
	}

	protected abstract void buildAbilityDao();

	// find DAO from dao list
	public BaseDAO findAbilityDAO(Class<?> clazz) {
		BaseDAO dao = null;
		if (daoList == null || daoList.size() == 0) {
			return dao;
		}

		for (BaseDAO item : daoList) {
			if (item.getModelClass() == clazz) {
				dao = item;
				break;
			}
		}

		return dao;
	}

	// query records
	public List<?> readRecord(Class<?> clazz, Map<String, Object> condition) {
		List<?> list = null;
		BaseDAO dao = findAbilityDAO(clazz);
		String queryType = (String) condition.get(AppConstants.QUERYTYPE);

		if (dao == null || queryType == null) {
			return list;
		}
		try {
			list = dao.find(queryType, condition);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	// create record
	public Object createRecord(Object record) {
		BaseDAO dao = findAbilityDAO(record.getClass());
		Object result = null;

		if (dao != null) {
			try {
				result = dao.create(record);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			return result;
		}

		return result;
	}

	// get record by id
	public Object getRecord(Class<?> clazz, int id) {
		Object result = null;
		BaseDAO dao = findAbilityDAO(clazz);

		if (dao != null) {
			try {
				result = dao.get(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			return result;
		}

		return result;
	}

	// load record by id
	public Object loadRecord(Class<?> clazz, int id) {
		Object result = null;
		BaseDAO dao = findAbilityDAO(clazz);

		if (dao != null) {
			try {
				result = dao.load(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			return result;
		}

		return result;
	}

	// select record by id
	public Object selectRecord(Class<?> clazz, int id) {
		Object result = null;
		BaseDAO dao = findAbilityDAO(clazz);

		if (dao != null) {
			try {
				result = dao.select(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			return result;
		}

		return result;
	}

	// update record
	public Object updateRecord(Object record) {
		Object result = null;
		BaseDAO dao = findAbilityDAO(record.getClass());

		if (dao != null) {
			try {
				result = dao.update(record);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			return result;
		}

		return result;
	}

	// evict record from cache
	public void evictRecord(Object record) {
		BaseDAO dao = findAbilityDAO(record.getClass());

		if (dao != null) {
			try {
				dao.evict(record);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// merge record (insert or update)
	public Object mergeRecord(Object record) {
		Object result = null;
		BaseDAO dao = findAbilityDAO(record.getClass());

		if (dao != null) {
			try {
				result = dao.merge(record);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			return result;
		}

		return result;
	}

	// delete record by id
	public boolean deleteRecord(Class<?> clazz, int id) {
		Boolean result = false;
		BaseDAO dao = findAbilityDAO(clazz);

		if (dao != null) {
			try {
				result = dao.delete(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			return result;
		}

		return result;
	}

	// get count
	public int getTotal(Class<?> clazz) {
		int result = 0;
		BaseDAO dao = findAbilityDAO(clazz);

		if (dao != null) {
			try {
				result = dao.getTotal();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			return result;
		}

		return result;
	}

	// query all records
	public List<?> getAllRecords(Class<?> clazz) {
		List<?> list = null;
		BaseDAO dao = findAbilityDAO(clazz);

		if (dao != null) {
			try {
				list = dao.getALL();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			return list;
		}

		return list;
	}
}
