package cn.itdebug.spring.beans.factory.support;

import cn.itdebug.spring.beans.BeansException;
import cn.itdebug.spring.beans.factory.BeanFactory;

/**
 * @创建人 Eric.Lu
 * @创建时间 2023/12/25
 * @描述
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy{

	@Override
	public Object instantiate(RootBeanDefinition beanDefinition, String beanName, BeanFactory owner) throws BeansException {
		// Must generate CGLIB subclass.
		return instantiateWithMethodInjection(beanDefinition, beanName, owner);
	}

	protected Object instantiateWithMethodInjection(
			RootBeanDefinition beanDefinition, String beanName, BeanFactory owner) {

		throw new UnsupportedOperationException(
				"Method Injection not supported in SimpleInstantiationStrategy");
	}
}
