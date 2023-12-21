package cn.itdebug.spring.beans.factory;

import cn.itdebug.spring.beans.BeansException;

import java.util.HashMap;
import java.util.Map;

/**
 * @创建人 Eric.Lu
 * @创建时间 2023/12/21
 * @描述
 */
public class BeanFactory {

	private final Map<String, Object> signletonObjects = new HashMap<>();

	Object getBean(String name) throws BeansException {
		return signletonObjects.get(name);
	}

	public void registerSingleton(String name, Object bean) {
		signletonObjects.put(name, bean);
	}
}
