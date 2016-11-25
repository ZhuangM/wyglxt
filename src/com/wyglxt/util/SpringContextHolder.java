package com.wyglxt.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextHolder implements ApplicationContextAware, DisposableBean {

	private static ApplicationContext applicationContext = null;

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextHolder.applicationContext = applicationContext;
	}

	public static ApplicationContext getApplicationContext() {
		checkApplicationContext();
		return applicationContext;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		checkApplicationContext();
		return (T) applicationContext.getBean(name);
	}

	public static <T> T getBean(Class<T> requiredType) {
		checkApplicationContext();
		return (T) applicationContext.getBean(requiredType);
	}

	private static void checkApplicationContext() {
		/*
		 * if(applicationContext == null) { try { throw new
		 * IllegalStateException("applicationContextδע��"); } catch
		 * (IllegalStateException e) { e.printStackTrace(); } }
		 */
	}

	public void destroy() throws Exception {
		SpringContextHolder.clearHolder();
	}

	public static void clearHolder() {
		applicationContext = null;
	}

}
