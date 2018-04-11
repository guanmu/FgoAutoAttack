package org.guanmu.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 扑克系统日志工厂类
 * @author wangquan
 *
 */
public class CardLoggers {

	public static Logger getLogEx() {
		 return LoggerFactory.getLogger(new
		 Throwable().getStackTrace()[1].getClassName());
	}

	public static Logger getLog(String className) {
		return LoggerFactory.getLogger(className);
	}

}
