/* Copyright MacroSAN Technologies Co., Ltd. All rights reserved. */
package org.guanmu.core;

/**
 * <p>
 * ¿‡√Ë ˆ:
 * <p>
 * 
 * À˘ Ù≤Âº˛:org.guanmu.core
 * @author wangquan 2018-4-12
 * 
 */
public enum StarLevel {

	N(65),
	R(60),
	R2(65),
	R3(70),
	SR(80),
	SSR(90),
	MAX(0);
	
	private int maxLevel;
	
	/**
	 * 
	 */
	private StarLevel(int maxLevel) {
		this.maxLevel = maxLevel;
	}
	
	public int getMaxLevel() {
		return maxLevel;
	}

	/**
	 * @param po
	 * @return
	 */
	public int getLevel(int po) {
		// TODO
		return maxLevel;
	}
}
