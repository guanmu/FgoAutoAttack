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
public class SanZang extends Servant {
	
	private static SanZang instance = new SanZang(); 
	
	static {
		
		instance.id = 113;
		
		instance.name = "西行者";
		
		instance.jobClass = JobClass.Caster;
		
		instance.atk = 11658;
		instance.hp = 12965;
		instance.maxNp = 100;
		instance.po = 4;
		instance.starLevel = StarLevel.SSR;
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
	private SanZang() {
		
	}
	
	public static SanZang getInstance() {
		return instance;
	}
}
