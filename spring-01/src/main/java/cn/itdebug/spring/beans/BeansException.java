package cn.itdebug.spring.beans;

/**
 * @创建人 Eric.Lu
 * @创建时间 2023/12/21
 * @描述
 */
public class BeansException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BeansException() {
		super();
	}

	public BeansException(String message) {
		super(message);
	}
}
