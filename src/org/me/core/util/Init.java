package org.me.core.util;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 启动时初始化配置
 * @author cheng_bo
 * @date 2015年5月26日 11:26:45
 */
public class Init implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		/**
		 * 加载log4j配置信息
		 */
		/*Properties properties = new Properties();
		String path=this.getClass().getClassLoader().getResource("/").getPath();
		try {
			properties.load(new FileInputStream(path+"org/me/config/log4j.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		PropertyConfigurator.configure(properties);*/
	}
}
