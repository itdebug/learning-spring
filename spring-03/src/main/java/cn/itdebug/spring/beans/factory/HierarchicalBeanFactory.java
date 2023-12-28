package cn.itdebug.spring.beans.factory;

/**
 * Sub-interface implemented by bean factories that can be part
 * of a hierarchy.
 *
 * <p>The corresponding <code>setParentBeanFactory</code> method for bean
 * factories that allow setting the parent in a configurable
 * fashion can be found in the ConfigurableBeanFactory interface.
 *
 * 由 Bean 工厂实现的子接口，可以是层次结构的一部分。
 * <p><code><code> 可以在 ConfigurableBeanFactory 接口中找到允许以可配置方式设置父级的 Bean 工厂的相应 setParentBeanFactory 方法。
 *
 * @创建人 Eric.Lu
 * @创建时间 2023/12/26
 * @描述
 */
public interface HierarchicalBeanFactory extends BeanFactory {
}
