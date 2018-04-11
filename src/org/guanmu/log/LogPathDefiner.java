package org.guanmu.log;

import org.guanmu.config.Config;
import org.guanmu.config.FgoConfig;
import org.guanmu.utils.Utils;

import ch.qos.logback.core.PropertyDefinerBase;

/**
 * 日志路径自定义类
 * @author wangquan
 *
 */
public class LogPathDefiner extends PropertyDefinerBase {

	@Override
	public String getPropertyValue() {
	
		if (Utils.isWindows()) {
			return Config.WINDOW_LOG_PATH + FgoConfig.LOG_PARENT;
		}
		
		if (Utils.isLinux()) {
			return Config.LINUX_LOG_PATH + FgoConfig.LOG_PARENT;
		}
			
		return FgoConfig.LOG_PARENT;
	}

}
