/* Copyright MacroSAN Technologies Co., Ltd. All rights reserved. */
package org.guanmu.model.servants;

import org.guanmu.core.JobClass;
import org.guanmu.core.StarLevel;
import org.guanmu.model.ArtsrCard;
import org.guanmu.model.BusterCard;
import org.guanmu.model.QuickCard;

/**
 * <p>
 * 类描述:
 * <p>
 * 
 * 所属插件:org.guanmu.model.servants
 * @author wangquan 2018-4-11
 * 
 */
public class MaXiu extends Servant {
	
	private static MaXiu instance = new MaXiu(); 
	
	static {
		
		instance.id = 1;
		
		instance.name = "玛修·基列莱特";
		
		instance.jobClass = JobClass.Shielder;
		
		instance.atk = 8730;
		instance.hp = 12877;
		instance.maxNp = 200;
		instance.po = 4;
		instance.starLevel = StarLevel.SR;
		instance.level = instance.starLevel.getLevel(instance.po);
		
		instance.initLoadCard(new QuickCard(0));
		instance.initLoadCard(new ArtsrCard(1));
		instance.initLoadCard(new ArtsrCard(2));
		instance.initLoadCard(new BusterCard(3));
		instance.initLoadCard(new BusterCard(4));		
	}
	
	/**
	 * 
	 */
	public MaXiu() {
		
	}
	
	public static MaXiu getInstance() {
		return instance;
	}
	

	
}
