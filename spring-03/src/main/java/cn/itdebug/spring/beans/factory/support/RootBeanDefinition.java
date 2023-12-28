package cn.itdebug.spring.beans.factory.support;

import cn.itdebug.spring.beans.factory.config.BeanDefinition;

/**
 * @创建人 Eric.Lu
 * @创建时间 2023/12/24
 * @描述
 */
public class RootBeanDefinition extends AbstractBeanDefinition {


	public RootBeanDefinition() {
		super();
	}

	public RootBeanDefinition(Class beanClass) {
		super();
		setBeanClass(beanClass);
	}
}
