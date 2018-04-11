/* Copyright MacroSAN Technologies Co., Ltd. All rights reserved. */
package org.guanmu.list;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.guanmu.core.IServant;
import org.guanmu.core.JobClass;
import org.guanmu.model.Servant;

/**
 * <p>
 * ������:
 * <p>
 * 
 * �������:org.guanmu.list
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
		
	}
	
	public static TotalServants getInstance() {
		return instance;
	}
	
	public void loadTotalServants() {
		totalServants.add(new Servant(1, "���ޡ���������", JobClass.Shielder, 8730, 12877, 300, 4, 80));
		totalServants.add(new Servant(60, "������", JobClass.Archer, 11107, 14553, 100, 4, 90));
		totalServants.add(new Servant(109, "������Assassion��", JobClass.Assassin, 8958, 11168, 200, 4, 80));
		totalServants.add(new Servant(113, "������", JobClass.Caster, 11658, 12965, 100, 4, 90));
		totalServants.add(new Servant(118, "��˹����˹", JobClass.Rider, 11971, 12830, 100, 4, 90));
		totalServants.add(new Servant(121, "��˹����", JobClass.Saber, 9949, 11589, 200, 4, 80));
		totalServants.add(new Servant(150, "÷��", JobClass.Caster, 10546, 14259, 300, 4, 90));
		totalServants.add(new Servant(153, "�����������ԭ����", JobClass.Saber, 12037, 13635, 100, 4, 90));		
	}
	
}
