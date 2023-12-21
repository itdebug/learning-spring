BeanFactory顾名思义就是一个工厂，用来生产Bean。

Spring的IOC容器是通过BeanFactory来实现的，BeanFactory是Spring框架的核心接口，它负责生产Bean，管理Bean的生命周期，以及对Bean进行依赖注入。

BeanFactory接口定义了两个方法：

- BeanFactory.getBean(String beanName)：根据bean的名字获取bean对象。
- BeanFactory.getBean(Class<T> requiredType)：根据bean的类型获取bean对象。