package cn.itdebug.spring.beans.factory.support;

import cn.itdebug.spring.beans.BeansException;
import cn.itdebug.spring.beans.factory.BeanFactory;

/**
 * @创建人 Eric.Lu
 * @创建时间 2023/12/24
 * @描述
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

	private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

	@Override
	protected Object createBean(String beanName, RootBeanDefinition mbd, Object[] args) throws BeansException {
		return instantiateBean(beanName, mbd);
	}

	protected Object instantiateBean(final String beanName, final RootBeanDefinition mbd) {
		final BeanFactory parent = this;
		return getInstantiationStrategy().instantiate(mbd, beanName, parent);
	}

	/**
	 * Set the instantiation strategy to use for creating bean instances.
	 * Default is CglibSubclassingInstantiationStrategy.
	 *
	 * 设置用于创建 Bean 实例的实例化策略。默认值为 CglibSubclassingInstantiationStrategy。
	 * @see CglibSubclassingInstantiationStrategy
	 */
	public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
		this.instantiationStrategy = instantiationStrategy;
	}

	/**
	 * Return the instantiation strategy to use for creating bean instances.
	 *
	 * 返回用于创建 Bean 实例的实例化策略。
	 */
	protected InstantiationStrategy getInstantiationStrategy() {
		return this.instantiationStrategy;
	}
}
