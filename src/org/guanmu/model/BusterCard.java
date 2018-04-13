/* Copyright MacroSAN Technologies Co., Ltd. All rights reserved. */
package org.guanmu.model;

import org.guanmu.core.IServant;


/**
 * <p>
 * ������:
 * <p>
 * 
 * �������:org.guanmu.model
 * @author wangquan 2018-4-11
 * 
 */
public class BusterCard  extends Card {

	/**
	 * @param cardId
	 */
	public BusterCard(int cardId) {
		super(cardId);
	}

	/**
	 * @param cardId
	 */
	public BusterCard(int cardId,IServant servant) {
		super(cardId);
		this.servant = servant;
	}

	/* (non-Javadoc)
	 * @see org.guanmu.model.Card#getCardRate()
	 */
	@Override
	public double getCardRate() {
		return 1.5;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BusterCard [cardId=" + cardId + ", servant=" + servant + "]";
	}	
	
	
}
