/* Copyright MacroSAN Technologies Co., Ltd. All rights reserved. */
package org.guanmu.core;

/**
 * <p>
 * ������:Ӣ�����ӿ�
 * <p>
 * 
 * �������:org.guanmu.core
 * @author wangquan 2018-4-11
 * 
 */
public interface IServant {

	/**
	 * @return
	 */
	int getId();

	/**
	 * @return
	 */
	String getName();

	/**
	 * @return
	 */
	int getAtk();

	/**
	 * @return
	 */
	int getHp();

	/**
	 * @return
	 */
	int getMaxNp();

	/**
	 * @return
	 */
	JobClass getJobClass();

	/**
	 * @return
	 */
	int getPo();

	/**
	 * @return
	 */
	int getLevel();

	/**
	 * @return
	 */
	String getPoStr();

	/**
	 * 
	 */
	void printInfo();

}
