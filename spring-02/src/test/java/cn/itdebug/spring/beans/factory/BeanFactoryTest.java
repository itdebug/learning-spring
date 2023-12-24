package cn.itdebug.spring.beans.factory;

import cn.itdebug.spring.beans.factory.config.BeanDefinition;
import cn.itdebug.spring.beans.factory.model.User;
import cn.itdebug.spring.beans.factory.support.DefaultListableBeanFactory;
import cn.itdebug.spring.beans.factory.support.RootBeanDefinition;
import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * @创建人 Eric.Lu
 * @创建时间 2023/12/21
 * @描述
 */
public class BeanFactoryTest extends TestCase {

	public void testDefaultListableBeanFactory() {

		/*
		 * 1、创建DefaultListableBeanFactory
		 * 2、创建User
		 * 3、创建BeanDefinition，由RootBeanDefinition加载User对象
		 * 4、注册BeanDefinition到DefaultListableBeanFactory中
		 * 5、验证User对象是否被成功创建，并且从BeanFactory中获取的对象是加载后的对象
		 */
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		User bean = new User("Eric", "上海市");
		BeanDefinition rootBeanDefinition = new RootBeanDefinition(bean);
		beanFactory.registerBeanDefinition("user", rootBeanDefinition);
		Assert.assertEquals("Eric", ((User)beanFactory.getBean("user")).getName());
	}

}