/* Copyright MacroSAN Technologies Co., Ltd. All rights reserved. */
package org.guanmu.model.servants;

import org.guanmu.core.JobClass;
import org.guanmu.core.StarLevel;
import org.guanmu.model.ArtsrCard;
import org.guanmu.model.BusterCard;
import org.guanmu.model.QuickCard;

/**
 * <p>
 * ¿‡√Ë ˆ:
 * <p>
 * 
 * À˘ Ù≤Âº˛:org.guanmu.model.servants
 * @author wangquan 2018-4-11
 * 
 */
public class WeiGongAssassion extends Servant {
	
	private static WeiGongAssassion instance = new WeiGongAssassion(); 
	
	static {
		
		instance.id = 109;
		
		instance.name = "Œ¿π¨£®Assassion£©";
		
		instance.jobClass = JobClass.Assassin;
		
		instance.atk = 8958;
		instance.hp = 11168;
		instance.maxNp = 200;
		instance.po = 4;
		instance.starLevel = StarLevel.SR;
		instance.level = instance.starLevel.getLevel(instance.po);
		
		instance.initLoadCard(new QuickCard(0));
		instance.initLoadCard(new QuickCard(1));
		instance.initLoadCard(new ArtsrCard(2));
		instance.initLoadCard(new ArtsrCard(3));
		instance.initLoadCard(new BusterCard(4));		
	}
	
	/**
	 * 
	 */
	private WeiGongAssassion() {
		
	}
	
	public static WeiGongAssassion getInstance() {
		return instance;
	}
}
