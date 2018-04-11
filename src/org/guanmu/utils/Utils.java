package org.guanmu.utils;

/**
 * 通用工具类
 * @author wangquan
 *
 */
public class Utils {

	public static final String OS_NAME = System.getProperty("os.name").toLowerCase();
	
	/**
	 * @return
	 */
	public static boolean isLinux() {
		return OS_NAME.indexOf("linux") >= 0;
	}

	/**
	 * @return
	 */
	public static boolean isWindows() {
		return OS_NAME.indexOf("windows") >= 0;
	}
	
}
