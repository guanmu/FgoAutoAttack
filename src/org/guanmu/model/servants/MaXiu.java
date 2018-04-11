/* Copyright MacroSAN Technologies Co., Ltd. All rights reserved. */
package org.guanmu.model.servants;

import org.guanmu.model.ArtsrCard;
import org.guanmu.model.BusterCard;
import org.guanmu.model.QuickCard;
import org.guanmu.model.Servant;

/**
 * <p>
 * ������:
 * <p>
 * 
 * �������:org.guanmu.model.servants
 * @author wangquan 2018-4-11
 * 
 */
public class MaXiu extends Servant {
	
	private static MaXiu instance = new MaXiu(); 
	
	static {
		instance.name = "���ޡ���������";
		
		instance.cards.add(new QuickCard(0));
		instance.cards.add(new ArtsrCard(1));
		instance.cards.add(new ArtsrCard(2));
		instance.cards.add(new BusterCard(3));
		instance.cards.add(new BusterCard(4));
		
	}
	
	/**
	 * 
	 */
	private MaXiu() {
		
	}
	
	public static MaXiu getInstance() {
		return instance;
	}
}
