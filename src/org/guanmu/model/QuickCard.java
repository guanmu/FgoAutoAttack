/* Copyright MacroSAN Technologies Co., Ltd. All rights reserved. */
package org.guanmu.model;

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
public class QuickCard  extends Card {

	/**
	 * @param cardId
	 */
	public QuickCard(int cardId) {
		super(cardId);
	}


	/**
	 * @param cardId
	 */
	public QuickCard(int cardId,IServant servant) {
		super(cardId);
		this.servant = servant;
	}		
	
	@Override
	public double getCardRate() {
		return 0.8;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "QuickCard [cardId=" + cardId + ", servant=" + servant + "]";
	}
	
	
}
