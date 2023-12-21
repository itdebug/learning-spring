package cn.itdebug.spring.beans.factory;

import cn.itdebug.spring.beans.factory.model.User;
import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * @创建人 Eric.Lu
 * @创建时间 2023/12/21
 * @描述
 */
public class BeanFactoryTest extends TestCase {

	public void testBeanFactory() {

		/*
		 * 模拟Spring容器初始化
		 */
		BeanFactory beanFactory = new BeanFactory();
		User bean = new User("Eric", "上海市");
		beanFactory.registerSingleton("user", bean);
		Assert.assertEquals("Eric", ((User)beanFactory.getBean("user")).getName());
	}

}