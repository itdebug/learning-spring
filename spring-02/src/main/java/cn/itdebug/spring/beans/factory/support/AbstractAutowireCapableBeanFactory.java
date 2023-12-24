package cn.itdebug.spring.beans.factory.support;

import cn.itdebug.spring.beans.BeansException;

/**
 * @创建人 Eric.Lu
 * @创建时间 2023/12/24
 * @描述
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

	@Override
	protected Object createBean(String beanName, RootBeanDefinition mbd, Object[] args) throws BeansException {
		return mbd.getBean();
	}
}
