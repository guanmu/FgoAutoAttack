/* Copyright MacroSAN Technologies Co., Ltd. All rights reserved. */
package org.guanmu.model.servants;

import java.util.ArrayList;
import java.util.List;

import org.guanmu.core.IServant;
import org.guanmu.core.JobClass;
import org.guanmu.core.StarLevel;
import org.guanmu.log.Loggers;
import org.guanmu.model.Card;
import org.slf4j.Logger;

/**
 * <p>
 * 类描述:
 * <p>
 * 
 * 所属插件:org.guanmu.model
 * @author wangquan 2018-4-11
 * 
 */
public class Servant implements IServant,Cloneable {
	
	private static Logger logger = Loggers.getLog(Servant.class.getName());
	
	protected int id;
	
	protected String name;
	
	protected JobClass jobClass = JobClass.MAX;
	
	protected int atk;
	protected int hp;
	
	protected int maxNp;
	
	protected int po;
	
	protected int level;
	
	protected List<Card> cards = new ArrayList<>();
	
	protected StarLevel starLevel;
	
	protected int np;
	
	/**
	 * 
	 */
	public Servant() {
	
	}
	
	/**
	 * @param id
	 * @param name
	 * @param jobClass
	 * @param atk
	 * @param hp
	 * @param maxNp
	 * @param po
	 * @param level
	 */
	public Servant(int id, String name, JobClass jobClass, int atk, int hp, int maxNp, int po,
			int level) {
		super();
		this.id = id;
		this.name = name;
		this.jobClass = jobClass;
		this.atk = atk;
		this.hp = hp;
		this.maxNp = maxNp;
		this.po = po;
		this.level = level;
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
	 * @return the maxNp
	 */
	public int getMaxNp() {
		return maxNp;
	}

	/**
	 * @param maxNp the maxNp to set
	 */
	public void setMaxNp(int maxNp) {
		this.maxNp = maxNp;
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
		logger.info("   英灵信息	");
		logger.info("姓名：	" + getName());
		logger.info("职阶：	" + getJobClass().name());
		logger.info("等级 ：	" + getLevel());
		logger.info("ATK：	" + getAtk());
		logger.info("HP ：	" + getHp());
		logger.info("几破 ：	" + getPoStr());
	}

	/**
	 * @return
	 */
	public String getPoStr() {
		return getPo() + "破";
	}
	
	/**
	 * @param card
	 */
	@Override
	public void initLoadCard(Card card) {
		cards.add(card);
		card.setServant(this);
	}
	
	@Override
	public IServant newServant() throws CloneNotSupportedException {
		return (Servant)this.clone();
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

	public void npAdd(int np) {
		if (np + this.np > this.maxNp) {
			this.np = this.maxNp;
			return;
		}
		
		this.np += np;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name;
	}	
	
	
}
