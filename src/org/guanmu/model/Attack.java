/* Copyright MacroSAN Technologies Co., Ltd. All rights reserved. */
package org.guanmu.model;

import org.guanmu.core.IServant;

/**
 * <p>
 * ������:
 * <p>
 * 
 * �������:org.guanmu.model
 * @author wangquan 2018-4-12
 * 
 */
public class Attack {
	
	private IServant from;
	
	private IServant to;
	
	private Card card;
	
	private int damage;

	/**
	 * @param from
	 * @param to
	 * @param card
	 * @param damage
	 */
	public Attack(IServant from, IServant to, Card card, int damage) {
		super();
		this.from = from;
		this.to = to;
		this.card = card;
		this.damage = damage;
	}

	/**
	 * @return the from
	 */
	public IServant getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(IServant from) {
		this.from = from;
	}

	/**
	 * @return the to
	 */
	public IServant getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(IServant to) {
		this.to = to;
	}

	/**
	 * @return the card
	 */
	public Card getCard() {
		return card;
	}

	/**
	 * @param card the card to set
	 */
	public void setCard(Card card) {
		this.card = card;
	}

	/**
	 * @return the damage
	 */
	public int getDamage() {
		return damage;
	}

	/**
	 * @param damage the damage to set
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	@Override
	public String toString() {
		String atkStr = "[" + from.getName() + "(" + card.getClass().getCanonicalName() + ")" + " ->" + to.getName() + "\n";
		atkStr += "	������״̬��atk=" + from.getAtk() + ",hp=" + from.getHp() + "\n";
		atkStr += "	�ܹ�����״̬��atk=" + to.getAtk() + ",hp=" + to.getHp() + "\n";
		atkStr += "	�˺���" + damage + "]";
		return atkStr;
	}
}
