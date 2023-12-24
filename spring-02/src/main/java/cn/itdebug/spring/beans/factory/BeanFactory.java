package cn.itdebug.spring.beans.factory;

import cn.itdebug.spring.beans.BeansException;

import java.util.HashMap;
import java.util.Map;

/**
 * @创建人 Eric.Lu
 * @创建时间 2023/12/21
 * @描述
 */
public interface BeanFactory {

	Object getBean(String name) throws BeansException;
}
