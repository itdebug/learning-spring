package cn.itdebug.spring.beans.factory.config;

/**
 * @创建人 Eric.Lu
 * @创建时间 2023/12/24
 * @描述
 */
public interface BeanDefinition {

	String getBeanClassName();

	void setBeanClassName(String beanClassName);

}
