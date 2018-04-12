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
public class ExCard extends Card {

	
	/**
	 * @param cardId
	 */
	public ExCard(int cardId) {
		super(cardId);
	}

	/**
	 * @param cardId
	 */
	public ExCard(int cardId,IServant servant) {
		super(cardId);
		this.servant = servant;
	}

}
