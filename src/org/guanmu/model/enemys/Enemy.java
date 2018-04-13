/* Copyright MacroSAN Technologies Co., Ltd. All rights reserved. */
package org.guanmu.model.enemys;

import java.util.ArrayList;
import java.util.List;

import org.guanmu.core.IServant;
import org.guanmu.core.JobClass;
import org.guanmu.log.Loggers;
import org.guanmu.model.Card;
import org.slf4j.Logger;

/**
 * <p>
 * 类描述:
 * <p>
 * 
 * 所属插件:org.guanmu.model
 * @author wangquan 2018-4-12
 * 
 */
public class Enemy implements IServant,Cloneable {
	private static Logger logger = Loggers.getLog(Enemy.class.getName());
	
	protected int id;
	
	protected String name;
	
	protected JobClass jobClass = JobClass.MAX;
	
	protected int atk;
	protected int hp;
	
	protected int po;
	
	protected int level;
	
	protected List<Card> cards = new ArrayList<>();
	
	protected int maxNpCollectNum;

	protected int npCollectNum;	
	
	/**
	 * @param id
	 * @param name
	 * @param jobClass
	 * @param atk
	 * @param hp
	 * @param level
	 * @param cards
	 */
	public Enemy(int id, String name, JobClass jobClass, int atk, int hp, int level) {
		super();
		this.id = id;
		this.name = name;
		this.jobClass = jobClass;
		this.atk = atk;
		this.hp = hp;
		this.level = level;
		this.maxNpCollectNum = jobClass.getEnemyNpCollect();
	}



	/**
	 * @return the npCollectNum
	 */
	public int getNpCollectNum() {
		return npCollectNum;
	}

	/**
	 * @param npCollectNum the npCollectNum to set
	 */
	public void setNpCollectNum(int npCollectNum) {
		this.npCollectNum = npCollectNum;
	}



	/**
	 * @return the maxNpCollectNum
	 */
	public int getMaxNpCollectNum() {
		return maxNpCollectNum;
	}



	/**
	 * @param maxNpCollectNum the maxNpCollectNum to set
	 */
	public void setMaxNpCollectNum(int maxNpCollectNum) {
		this.maxNpCollectNum = maxNpCollectNum;
	}



	/**
	 * @return the id
	 */
	@Override
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the atk
	 */
	@Override
	public int getAtk() {
		return atk;
	}

	/**
	 * @param atk the atk to set
	 */
	public void setAtk(int atk) {
		this.atk = atk;
	}

	/**
	 * @return the hp
	 */
	@Override
	public int getHp() {
		return hp;
	}

	/**
	 * @param hp the hp to set
	 */
	public void setHp(int hp) {
		this.hp = hp;
	}

	/**
	 * @return the jobClass
	 */
	@Override
	public JobClass getJobClass() {
		return jobClass;
	}

	/**
	 * @param jobClass the jobClass to set
	 */
	public void setJobClass(JobClass jobClass) {
		this.jobClass = jobClass;
	}

	
	
	/**
	 * @return the po
	 */
	@Override
	public int getPo() {
		return po;
	}

	/**
	 * @param po the po to set
	 */
	public void setPo(int po) {
		this.po = po;
	}

	/**
	 * @return the level
	 */
	@Override
	public int getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	
	/**
	 * @return the cards
	 */
	@Override
	public List<Card> getCards() {
		return cards;
	}
	
	/**
	 * 
	 */
	@Override
	public void printInfo() {
		System.out.println();
		logger.info("  地方英灵信息	");
		logger.info("姓名：	" + getName());
		logger.info("职阶：	" + getJobClass().name());
		logger.info("ATK：	" + getAtk());
		logger.info("HP ：	" + getHp());
		
	}
	
	@Override
	public boolean isActive() {
		return hp > 0;
	}

	/* (non-Javadoc)
	 * @see org.guanmu.core.IServant#getAtkBuff()
	 */
	@Override
	public double getAtkBuff() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.guanmu.core.IServant#getDefenseDebuff()
	 */
	@Override
	public double getDefenseBuff() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.guanmu.core.IServant#getSpecialBuff()
	 */
	@Override
	public double getSpecialBuff() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.guanmu.core.IServant#getSpecialDefenseBuff()
	 */
	@Override
	public double getSpecialDefenseBuff() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.guanmu.core.IServant#getCriticalBuff()
	 */
	@Override
	public double getCriticalBuff() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.guanmu.core.IServant#getConstantDamage()
	 */
	@Override
	public double getConstantDamage() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.guanmu.core.IServant#getConstantDeDamage()
	 */
	@Override
	public double getConstantDeDamage() {
		// TODO Auto-generated method stub
		return 0;
	}


	/* (non-Javadoc)
	 * @see org.guanmu.core.IServant#beAtk(int)
	 */
	@Override
	public void beAtk(int damage) {
		if (damage >= hp) {
			hp = 0;
			return;
		}
		
		hp = hp - damage;
	}

	public void npCollectAdd() {
		if (npCollectNum < maxNpCollectNum) {
			npCollectNum++;
		}
	}	
	
	@Override
	public IServant newServant() throws CloneNotSupportedException {
		return (Enemy)this.clone();
	}



	/* (non-Javadoc)
	 * @see org.guanmu.core.IServant#initLoadCard(org.guanmu.model.Card)
	 */
	@Override
	public void initLoadCard(Card card) {
		cards.add(card);
		card.setServant(this);
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Enemy [name=" + name + "]";
	}
	
	
}
