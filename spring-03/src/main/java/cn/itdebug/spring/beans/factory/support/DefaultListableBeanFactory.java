package cn.itdebug.spring.beans.factory.support;

import cn.itdebug.spring.beans.BeansException;
import cn.itdebug.spring.beans.factory.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Default implementation of the
 * {@link org.springframework.beans.factory.ListableBeanFactory} and
 * {@link BeanDefinitionRegistry} interfaces: a full-fledged bean factory
 * based on bean definition objects.
 *
 * <p>Typical usage is registering all bean definitions first (possibly read
 * from a bean definition file), before accessing beans. Bean definition lookup
 * is therefore an inexpensive operation in a local bean definition table,
 * operating on pre-built bean definition metadata objects.
 *
 * <p>Can be used as a standalone bean factory, or as a superclass for custom
 * bean factories. Note that readers for specific bean definition formats are
 * typically implemented separately rather than as bean factory subclasses:
 * see for example {@link PropertiesBeanDefinitionReader} and
 * {@link org.springframework.beans.factory.xml.XmlBeanDefinitionReader}.
 *
 * <p>For an alternative implementation of the
 * {@link org.springframework.beans.factory.ListableBeanFactory} interface,
 * have a look at {@link StaticListableBeanFactory}, which manages existing
 * bean instances rather than creating new ones based on bean definitions.
 *
 * {@link org.springframework.beans.factory.ListableBeanFactory} 和 {@link BeanDefinitionRegistry} 接口的默认实现：
 * 基于 Bean 定义对象的成熟 Bean 工厂。
 * <p>典型的用法是先注册所有 Bean 定义（可能从 Bean 定义文件中读取），然后再访问 Bean。
 * 因此，Bean 定义查找是本地 Bean 定义表中的一项低成本操作，它对预构建的 Bean 定义元数据对象进行操作。
 * 可以用作独立的 Bean 工厂<p>，也可以用作自定义 Bean 工厂的超类。
 * 请注意，特定 Bean 定义格式的读取器通常是单独实现的，而不是作为 Bean 工厂子类实现的：
 * 例如，参见 {@link PropertiesBeanDefinitionReader} 和 {@link org.springframework.beans.factory.xml.XmlBeanDefinitionReader}。
 * <p>有关{@link org.springframework.beans.factory.ListableBeanFactory}接口的替代实现，请查看{@link StaticListableBeanFactory}，它管理现有的bean实例，
 * 而不是基于bean定义创建新的bean实例。
 *
 * @创建人 Eric.Lu
 * @创建时间 2023/12/24
 * @描述
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry{


	/** Map of bean definition objects, keyed by bean name */
	private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

	@Override
	public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) throws BeansException {
		beanDefinitionMap.put(beanName, beanDefinition);
	}

	@Override
	public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
		BeanDefinition bd = this.beanDefinitionMap.get(beanName);
		if (bd == null) {
			logger.info("No bean named '" + beanName + "' found in " + this);
			throw new BeansException(beanName);
		}
		return bd;
	}
}
