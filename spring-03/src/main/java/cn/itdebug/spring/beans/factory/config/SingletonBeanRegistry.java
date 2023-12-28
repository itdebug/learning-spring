package cn.itdebug.spring.beans.factory.config;

import cn.itdebug.spring.beans.factory.BeanFactory;

/**
 * Interface that defines a registry for shared bean instances.
 * Can be implemented by {@link BeanFactory}
 * implementations in order to expose their singleton management facility
 * in a uniform manner.
 *
 * 定义共享 Bean 实例的注册表的接口。可以通过 {@link BeanFactory} 实现来实现，以便以统一的方式公开其单例管理工具。
 * @创建人 Eric.Lu
 * @创建时间 2023/12/26
 * @描述
 */
public interface SingletonBeanRegistry {

	/**
	 * Register the given existing object as singleton in the bean registry,
	 * under the given bean name.
	 * <p>The given instance is supposed to be fully initialized; the registry
	 * will not perform any initialization callbacks (in particular, it won't
	 * call InitializingBean's <code>afterPropertiesSet</code> method).
	 * The given instance will not receive any destruction callbacks
	 * (like DisposableBean's <code>destroy</code> method) either.
	 * <p>When running within a full BeanFactory: <b>Register a bean definition
	 * instead of an existing instance if your bean is supposed to receive
	 * initialization and/or destruction callbacks.</b>
	 * <p>Typically invoked during registry configuration, but can also be used
	 * for runtime registration of singletons. As a consequence, a registry
	 * implementation should synchronize singleton access; it will have to do
	 * this anyway if it supports a BeanFactory's lazy initialization of singletons.
	 *
	 * 在 Bean 注册表中，在给定的 Bean 名称下，将给定的现有对象注册为单例。
	 * <p>给定的实例应该被完全初始化;注册表不会执行任何初始化回调（特别是，它不会调用
	 * InitializingBean 的 <code>afterPropertiesSet<code> 方法）。
	 * 给定的实例也不会收到任何销毁回调（如 DisposableBean 的 <code>destroy<code> 方法）。
	 * <p>在完整的 BeanFactory 中运行时：如果您的 Bean <b>应该接收初始化和/或销毁回调，
	 * 请注册一个 Bean 定义而不是现有实例。<b>
	 * <p>通常在注册表配置期间调用，但也可用于单例的运行时注册。
	 * 因此，注册表实现应同步单例访问;
	 * 如果它支持 BeanFactory 的单例延迟初始化，它无论如何都必须这样做。
	 *
	 * @param beanName the name of the bean
	 * @param singletonObject the existing singleton object
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet
	 * @see org.springframework.beans.factory.DisposableBean#destroy
	 * @see org.springframework.beans.factory.support.BeanDefinitionRegistry#registerBeanDefinition
	 */
	void registerSingleton(String beanName, Object singletonObject);

	/**
	 * Return the (raw) singleton object registered under the given name.
	 * <p>Only checks already instantiated singletons; does not return an Object
	 * for singleton bean definitions which have not been instantiated yet.
	 * <p>The main purpose of this method is to access manually registered singletons
	 * (see {@link #registerSingleton}). Can also be used to access a singleton
	 * defined by a bean definition that already been created, in a raw fashion.
	 * <p><b>NOTE:</b> This lookup method is not aware of FactoryBean prefixes or aliases.
	 * You need to resolve the canonical bean name first before obtaining the singleton instance.
	 *
	 * 返回在给定名称下注册的（原始）单例对象。仅检查已实例化的单例;
	 * <p>不返回尚未实例化的单例 Bean 定义的 Object。
	 * <p>此方法的主要用途是访问手动注册的单例
	 * （请参阅 {@link registerSingleton}）。还可用于以原始方式访问由已创建的 Bean 定义定义的单例。
	 * <p><b>注意：<b>此查找方法无法识别 FactoryBean 前缀或别名。
	 * 在获取单例实例之前，您需要先解析规范 Bean 名称。
	 *
	 * @param beanName the name of the bean to look for
	 * @return the registered singleton object, or <code>null</code> if none found
	 * @see ConfigurableListableBeanFactory#getBeanDefinition
	 */
	Object getSingleton(String beanName);
}
