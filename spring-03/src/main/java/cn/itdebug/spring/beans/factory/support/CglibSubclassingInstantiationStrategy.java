package cn.itdebug.spring.beans.factory.support;

import cn.itdebug.spring.beans.factory.BeanFactory;
import net.sf.cglib.proxy.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @创建人 Eric.Lu
 * @创建时间 2023/12/25
 * @描述
 */
public class CglibSubclassingInstantiationStrategy extends SimpleInstantiationStrategy {

	@Override
	protected Object instantiateWithMethodInjection(RootBeanDefinition beanDefinition, String beanName, BeanFactory owner) {
		// Must generate CGLIB subclass.
		return new CglibSubclassCreator(beanDefinition, owner).instantiate(null, null);
	}

	/**
	 * An inner class so we don't have a CGLIB dependency in core.
	 */
	private static class CglibSubclassCreator {

		private static final Log logger = LogFactory.getLog(CglibSubclassCreator.class);

		private final RootBeanDefinition beanDefinition;
		private final BeanFactory owner;

		public CglibSubclassCreator(RootBeanDefinition beanDefinition, BeanFactory owner) {
			this.beanDefinition = beanDefinition;
			this.owner = owner;
		}

		/**
		 * Create a new instance of a dynamically generated subclasses implementing the
		 * required lookups.
		 *
		 * @param ctor constructor to use. If this is <code>null</code>, use the
		 *             no-arg constructor (no parameterization, or Setter Injection)
		 * @param args arguments to use for the constructor.
		 *             Ignored if the ctor parameter is <code>null</code>.
		 * @param ctor 构造函数使用。如果此值为 <code>null<code>，
		 *             请使用 no-arg 构造函数（无参数化或 Setter 注入）
		 * @return new instance of the dynamically generated class
		 * <p>
		 * 创建动态生成的子类的新实例，以实现所需的查找。
		 * @param用于构造函数的 args 参数。如果 ctor 参数为 null，则忽略<code><code>。
		 * @return动态生成的类的新实例
		 */
		public Object instantiate(Constructor ctor, Object[] args) {
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(this.beanDefinition.getBeanClass());
			enhancer.setCallback(NoOp.INSTANCE);
//			enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> methodProxy.invokeSuper(o, objects));
			return (ctor == null) ?
					enhancer.create() :
					enhancer.create(ctor.getParameterTypes(), args);
		}
	}
}
