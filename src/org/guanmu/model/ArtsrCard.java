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
public class ArtsrCard extends Card {

	
	/**
	 * @param cardId
	 */
	public ArtsrCard(int cardId) {
		super(cardId);
	}

	/**
	 * @param cardId
	 */
	public ArtsrCard(int cardId,IServant servant) {
		super(cardId);
		this.servant = servant;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ArtsrCard [cardId=" + cardId + ", servant=" + servant + "]";
	}

}
