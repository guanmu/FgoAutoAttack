/* Copyright MacroSAN Technologies Co., Ltd. All rights reserved. */
package org.guanmu.list;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.guanmu.core.IServant;
import org.guanmu.core.JobClass;
import org.guanmu.model.servants.ELiWeng;
import org.guanmu.model.servants.MaXiu;
import org.guanmu.model.servants.SanZang;
import org.guanmu.model.servants.Servant;
import org.guanmu.model.servants.WeiGongAssassion;

/**
 * <p>
 * 类描述:
 * <p>
 * 
 * 所属插件:org.guanmu.list
 * @author wangquan 2018-4-11
 * 
 */
public class TotalServants {
	
	private static TotalServants instance = new TotalServants();
	
	private List<IServant> totalServants = new CopyOnWriteArrayList<>();
	
	/**
	 * 
	 */
	private TotalServants() {
		loadTotalServants();
	}
	
	public static TotalServants getInstance() {
		return instance;
	}
	
	private void loadTotalServants() {
		totalServants.add(MaXiu.getInstance());
		totalServants.add(ELiWeng.getInstance());
		totalServants.add(WeiGongAssassion.getInstance());
		totalServants.add(SanZang.getInstance());
		totalServants.add(new Servant(118, "奥斯曼狄斯", JobClass.Rider, 11971, 12830, 100, 4, 90));
		totalServants.add(new Servant(121, "兰斯洛特", JobClass.Saber, 9949, 11589, 200, 4, 80));
		totalServants.add(new Servant(150, "梅林", JobClass.Caster, 10546, 14259, 300, 4, 90));
		totalServants.add(new Servant(153, "新免武藏守藤原玄信", JobClass.Saber, 12037, 13635, 100, 4, 90));		
	}
	
	public List<IServant> servants() {
		return totalServants;
	}
	
}
