package com.wyglxt.entity;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

/**
 * 模块说明：数据库建表
 * 
 */
public class CreateDatabase {

	@Test
	public void test() {
		new SchemaExport(new Configuration().configure()).create(true, true);
	}

	@Test
	public void save() {

	}

}
