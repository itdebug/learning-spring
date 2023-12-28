package cn.itdebug.spring.beans.factory.support;

import cn.itdebug.spring.beans.BeansException;
import cn.itdebug.spring.beans.factory.config.BeanDefinition;

/**
 * @创建人 Eric.Lu
 * @创建时间 2023/12/24
 * @描述
 */
public interface BeanDefinitionRegistry {

	void registerBeanDefinition(String beanName, BeanDefinition beanDefinition)
			throws BeansException;
}
