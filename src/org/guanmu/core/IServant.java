/* Copyright MacroSAN Technologies Co., Ltd. All rights reserved. */
package org.guanmu.core;

import java.util.List;

import org.guanmu.model.Card;

/**
 * <p>
 * 类描述:英灵抽象接口
 * <p>
 * 
 * 所属插件:org.guanmu.core
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
	 * 
	 */
	void printInfo();

	/**
	 * @return
	 */
	boolean isActive();

	/**
	 * @return
	 */
	List<Card> getCards();

	/**
	 * @return
	 */
	double getAtkBuff();

	/**
	 * @return
	 */
	double getDefenseBuff();

	/**
	 * @return
	 */
	double getSpecialBuff();

	/**
	 * @return
	 */
	double getSpecialDefenseBuff();

	/**
	 * @return
	 */
	double getCriticalBuff();

	/**
	 * @return
	 */
	double getConstantDamage();

	/**
	 * @return
	 */
	double getConstantDeDamage();

	/**
	 * @param damage
	 */
	void beAtk(int damage);

	/**
	 * @return
	 * @throws CloneNotSupportedException
	 */
	IServant newServant() throws CloneNotSupportedException;

	/**
	 * @param card
	 */
	void initLoadCard(Card card);


}
