/* Copyright MacroSAN Technologies Co., Ltd. All rights reserved. */
package org.guanmu.ui;

import org.guanmu.core.JobClass;
import org.guanmu.list.TotalServants;
import org.guanmu.model.ArtsrCard;
import org.guanmu.model.BusterCard;
import org.guanmu.model.Fight;
import org.guanmu.model.QuickCard;
import org.guanmu.model.enemys.Enemy;
import org.guanmu.model.servants.ELiWeng;
import org.guanmu.model.servants.MaXiu;
import org.guanmu.model.servants.WeiGongAssassion;

/**
 * <p>
 * 类描述:
 * <p>
 * 
 * 所属插件:org.guanmu.config
 * @author wangquan 2018-4-11
 * 
 */
public class MainUI {
	
	
	public static void main(String[] args) throws CloneNotSupportedException {
		TotalServants.getInstance();
		
		Fight fight = new Fight(0, "冬木-测试");
		
		Enemy enemy1 = new Enemy(0, "影从者", JobClass.Berserker, 2000, 10000, 40);
		enemy1.initLoadCard(new QuickCard(1));
		enemy1.initLoadCard(new ArtsrCard(2));
		enemy1.initLoadCard(new BusterCard(3));
		enemy1.initLoadCard(new BusterCard(4));
		enemy1.initLoadCard(new BusterCard(5));
		
		
		Enemy enemy2 = new Enemy(1, "影从者", JobClass.Berserker, 4000, 10000, 40);
		enemy2.initLoadCard(new QuickCard(1));
		enemy2.initLoadCard(new ArtsrCard(2));
		enemy2.initLoadCard(new BusterCard(3));
		enemy2.initLoadCard(new BusterCard(4));
		enemy2.initLoadCard(new BusterCard(5));
		
		Enemy enemy3 = new Enemy(2, "影从者", JobClass.Berserker, 2000, 10000, 40);
		enemy3.initLoadCard(new QuickCard(1));
		enemy3.initLoadCard(new ArtsrCard(2));
		enemy3.initLoadCard(new BusterCard(3));
		enemy3.initLoadCard(new BusterCard(4));
		enemy3.initLoadCard(new BusterCard(5));
		
		fight.getOneEnemys().add(enemy1);
		fight.getOneEnemys().add(enemy2);
		fight.getOneEnemys().add(enemy3);
		
		Enemy enemy21 = new Enemy(3, "影从者", JobClass.Caster, 5000, 30000, 40);
		enemy21.initLoadCard(new QuickCard(1));
		enemy21.initLoadCard(new ArtsrCard(2));
		enemy21.initLoadCard(new BusterCard(3));
		enemy21.initLoadCard(new BusterCard(4));
		enemy21.initLoadCard(new BusterCard(5));
		fight.getTwoEnemys().add(enemy21);
		
		fight.getPlayServants().add(MaXiu.getInstance().newServant());
		fight.getPlayServants().add(ELiWeng.getInstance().newServant());
		fight.getPlayServants().add(WeiGongAssassion.getInstance().newServant());
		
		fight.start();
		
		fight.printRoundHistorys();
	}
	
}
