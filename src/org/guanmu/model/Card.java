/* Copyright MacroSAN Technologies Co., Ltd. All rights reserved. */
package org.guanmu.model;

import org.guanmu.core.ICard;
import org.guanmu.core.IServant;

/**
 * <p>
 * ÀàÃèÊö:
 * <p>
 * 
 * ËùÊô²å¼ş:org.guanmu.model
 * @author wangquan 2018-4-11
 * 
 */
public abstract class Card implements ICard {
	
	protected int cardId;
	
	protected IServant servant;
	
	/**
	 * @param cardId
	 */
	public Card(int cardId) {
		super();
		this.cardId = cardId;
	}

	/**
	 * @return the cardId
	 */
	public int getCardId() {
		return cardId;
	}

	/**
	 * @param cardId the cardId to set
	 */
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	/**
	 * @return the servant
	 */
	public IServant getServant() {
		return servant;
	}

	/**
	 * @param servant the servant to set
	 */
	public void setServant(IServant servant) {
		this.servant = servant;
	}

	/**
	 * @return
	 */
	public double getCardRate() {
		return 1.0;
	}

	/**
	 * @return
	 */
	public double getBuff() {
		return 0;
	}
	

	
}
