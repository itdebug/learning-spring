package cn.itdebug.spring.beans.factory;

import cn.itdebug.spring.beans.factory.config.BeanDefinition;
import cn.itdebug.spring.beans.factory.model.Baozi;
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
		 * 2、改造BeanDefinition,由固定对象变为Class对象
		 * 3、在获取对象时，通过对象名称到beanDefinition中查找对象定义，并最终通过CGLIB代理创建对象
		 * 4、实例化对象后，将对象注册到单例注册表中
		 * 5、验证再次获取同一名称bean，获取的对象是否从单例注册表中进行获取
		 *
		 */
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		BeanDefinition rootBeanDefinition = new RootBeanDefinition(Baozi.class);
		beanFactory.registerBeanDefinition("baozi", rootBeanDefinition);
		Assert.assertEquals(beanFactory.getBean("baozi"), beanFactory.getBean("baozi"));
		System.out.println(beanFactory.getBean("baozi").getClass());
	}

}