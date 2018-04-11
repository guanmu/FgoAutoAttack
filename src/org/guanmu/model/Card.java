/* Copyright MacroSAN Technologies Co., Ltd. All rights reserved. */
package org.guanmu.model;

import org.guanmu.core.ICard;

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

	/**
	 * @param cardId
	 */
	public Card(int cardId) {
		super();
		this.cardId = cardId;
	}
	

	
}
