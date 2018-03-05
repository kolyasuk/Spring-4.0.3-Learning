package interfaces;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public interface Robot extends InitializingBean, DisposableBean {

	public void action();

	public void dance();
}
