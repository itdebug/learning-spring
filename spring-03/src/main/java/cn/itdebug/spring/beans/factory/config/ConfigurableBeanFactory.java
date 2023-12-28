package cn.itdebug.spring.beans.factory.config;

import cn.itdebug.spring.beans.factory.HierarchicalBeanFactory;

/**
 * Configuration interface to be implemented by most bean factories. Provides
 * facilities to configure a bean factory, in addition to the bean factory
 * client methods in the {@link org.springframework.beans.factory.BeanFactory}
 * interface.
 *
 * <p>This bean factory interface is not meant to be used in normal application
 * code: Stick to {@link org.springframework.beans.factory.BeanFactory} or
 * {@link org.springframework.beans.factory.ListableBeanFactory} for typical
 * needs. This extended interface is just meant to allow for framework-internal
 * plug'n'play and for special access to bean factory configuration methods.
 *
 * 大多数 Bean 工厂要实现的配置接口。除了 {@link org.springframework.beans.factory.BeanFactory}
 * 接口中的 Bean 工厂客户端方法外，还提供用于配置 Bean 工厂的工具。
 *
 * <p>这个 Bean 工厂接口不适合在普通应用程序代码中使用：对于典型需求，
 * 请坚持使用 {@link org.springframework.beans.factory.BeanFactory}
 * 或 {@link org.springframework.beans.factory.ListableBeanFactory}。
 * 这个扩展接口只是为了允许框架内部即插即用和对 Bean 工厂配置方法的特殊访问。
 *
 * @创建人 Eric.Lu
 * @创建时间 2023/12/26
 * @描述
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory,SingletonBeanRegistry{
}
