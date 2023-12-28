package cn.itdebug.spring.beans.factory;

import cn.itdebug.spring.beans.BeansException;

import java.util.HashMap;
import java.util.Map;

/**
 * The root interface for accessing a Spring bean container.
 * This is the basic client view of a bean container;
 * further interfaces such as {@link ListableBeanFactory} and
 * {@link org.springframework.beans.factory.config.ConfigurableBeanFactory}
 * are available for specific purposes.
 *
 * <p>This interface is implemented by objects that hold a number of bean definitions,
 * each uniquely identified by a String name. Depending on the bean definition,
 * the factory will return either an independent instance of a contained object
 * (the Prototype design pattern), or a single shared instance (a superior
 * alternative to the Singleton design pattern, in which the instance is a
 * singleton in the scope of the factory). Which type of instance will be returned
 * depends on the bean factory configuration: the API is the same. Since Spring
 * 2.0, further scopes are available depending on the concrete application
 * context (e.g. "request" and "session" scopes in a web environment).
 *
 * <p>The point of this approach is that the BeanFactory is a central registry
 * of application components, and centralizes configuration of application
 * components (no more do individual objects need to read properties files,
 * for example). See chapters 4 and 11 of "Expert One-on-One J2EE Design and
 * Development" for a discussion of the benefits of this approach.
 *
 * <p>Note that it is generally better to rely on Dependency Injection
 * ("push" configuration) to configure application objects through setters
 * or constructors, rather than use any form of "pull" configuration like a
 * BeanFactory lookup. Spring's Dependency Injection functionality is
 * implemented using this BeanFactory interface and its subinterfaces.
 *
 * <p>Normally a BeanFactory will load bean definitions stored in a configuration
 * source (such as an XML document), and use the <code>org.springframework.beans</code>
 * package to configure the beans. However, an implementation could simply return
 * Java objects it creates as necessary directly in Java code. There are no
 * constraints on how the definitions could be stored: LDAP, RDBMS, XML,
 * properties file, etc. Implementations are encouraged to support references
 * amongst beans (Dependency Injection).
 *
 * 用于访问 Spring Bean 容器的根接口。
 * 这是 Bean 容器的基本客户端视图;{@link ListableBeanFactory} 和
 * {@link org.springframework.beans.factory.config.ConfigurableBeanFactory} 等其他接口可用于特定目的。
 *
 * <p>此接口由包含多个 Bean 定义的对象实现，每个定义都由 String 名称唯一标识。
 * 根据 Bean 定义，工厂将返回包含对象的独立实例（原型设计模式）或单个共享实例（单例设计模式的更好替代方案，其中实例是工厂范围内的单例）。
 * 返回哪种类型的实例取决于 Bean 工厂配置：API 是相同的。
 * 从 Spring 2.0 开始，根据具体的应用程序上下文（例如，Web 环境中的“请求”和“会话”范围），可以使用更多范围。
 *
 * <p>这种方法的要点是 BeanFactory 是应用程序组件的中央注册表，它集中了应用程序组件的配置（例如，单个对象不再需要读取属性文件）。
 * 请参阅“Expert One-on-One J2EE Design and Development”的第 4 章和第 11 章，了解这种方法的好处。
 *
 * <p>请注意，通常最好依靠依赖注入（“推送”配置）通过 setter 或构造函数来配置应用程序对象，而不是使用任何形式的“拉取”配置，
 * 例如 BeanFactory 查找。Spring 的依赖注入功能是使用此 BeanFactory 接口及其子接口实现的。
 *
 * <p>通常，BeanFactory将加载存储在配置源（例如XML文档）中的bean定义，并使用<code>org.springframework.beans<code>包来配置bean。
 * 但是，实现可以简单地直接在 Java 代码中返回它根据需要创建的 Java 对象。
 * 对定义的存储方式没有限制：LDAP、RDBMS、XML、属性文件等。鼓励实现支持在 Bean 之间引用（依赖注入）。
 *
 * @创建人 Eric.Lu
 * @创建时间 2023/12/21
 * @描述
 */
public interface BeanFactory {

	/**
	 * Return an instance, which may be shared or independent, of the specified bean.
	 * <p>This method allows a Spring BeanFactory to be used as a replacement for the
	 * Singleton or Prototype design pattern. Callers may retain references to
	 * returned objects in the case of Singleton beans.
	 * <p>Translates aliases back to the corresponding canonical bean name.
	 * Will ask the parent factory if the bean cannot be found in this factory instance.
	 *
	 * 返回指定 Bean 的实例，该实例可以是共享的，也可以是独立的。
	 * <p>此方法允许将 Spring BeanFactory 用作 Singleton 或 Prototype 设计模式的替代品。
	 * 对于 Singleton bean，调用方可以保留对返回对象的引用。
	 * <p>将别名转换回相应的规范 Bean 名称。将询问父工厂是否在此工厂实例中找不到 bean。
	 *
	 * @param name the name of the bean to retrieve
	 * @return an instance of the bean
	 * @throws NoSuchBeanDefinitionException if there is no bean definition
	 * with the specified name
	 * @throws BeansException if the bean could not be obtained
	 */
	Object getBean(String name) throws BeansException;
}
