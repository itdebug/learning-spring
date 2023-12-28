package cn.itdebug.spring.beans.factory.support;

import cn.itdebug.spring.beans.BeansException;
import cn.itdebug.spring.beans.factory.config.BeanDefinition;

/**
 * @创建人 Eric.Lu
 * @创建时间 2023/12/25
 * @描述
 */
public abstract class AbstractBeanDefinition implements BeanDefinition {

	private volatile Object beanClass;

	@Override
	public String getBeanClassName() {
		Object beanClassObject = this.beanClass;
		if (beanClassObject instanceof Class) {
			return ((Class<?>) beanClassObject).getName();
		}
		else {
			return (String) beanClassObject;
		}
	}

	@Override
	public void setBeanClassName(String beanClassName) {
		this.beanClass = beanClassName;
	}

	public Class<?> getBeanClass() throws BeansException {
		Object beanClassObject = this.beanClass;
		if (beanClassObject == null) {
			throw new BeansException("No bean class specified on bean definition");
		}
		if (!(beanClassObject instanceof Class)) {
			throw new BeansException(
					"Bean class name [" + beanClassObject + "] has not been resolved into an actual Class");
		}
		return (Class) beanClassObject;
	}

	public void setBeanClass(Class<?> beanClass) {
		this.beanClass = beanClass;
	}
}
