package cn.itdebug.spring.beans.factory.support;

import cn.itdebug.spring.beans.BeansException;
import cn.itdebug.spring.beans.factory.BeanFactory;
import cn.itdebug.spring.beans.factory.config.BeanDefinition;
import cn.itdebug.spring.beans.factory.config.ConfigurableBeanFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @创建人 Eric.Lu
 * @创建时间 2023/12/24
 * @描述
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {

	/** Map from bean name to merged RootBeanDefinition */
	private final Map<String, RootBeanDefinition> mergedBeanDefinitions =
			new ConcurrentHashMap<String, RootBeanDefinition>();

	@Override
	public Object getBean(String name) throws BeansException {
		return doGetBean(name, null, null, false);
	}

	protected <T> T doGetBean(
			final String name, final Class<T> requiredType, final Object[] args, boolean typeCheckOnly)
			throws BeansException {

		// 提前检查对象是否已存在，如果存在，直接返回
		Object sharedInstance = getSingleton(name);
		if(sharedInstance != null && args == null) {
			logger.info("Returning cached instance of singleton bean '" + name + "'");
		} else {
			final RootBeanDefinition mbd = getMergedLocalBeanDefinition(name);
			sharedInstance = createBean(name, mbd, args);
			addSingleton(name, sharedInstance);
		}
		return (T) sharedInstance;
	}


	protected RootBeanDefinition getMergedLocalBeanDefinition(String beanName) throws BeansException {
		// Quick check on the concurrent map first, with minimal locking.
		RootBeanDefinition mbd = this.mergedBeanDefinitions.get(beanName);
		if (mbd != null) {
			return mbd;
		}
		return (RootBeanDefinition) getBeanDefinition(beanName);
	}

	protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

	protected abstract Object createBean(String beanName, RootBeanDefinition mbd, Object[] args)
			throws BeansException;
}
