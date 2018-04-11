/* Copyright MacroSAN Technologies Co., Ltd. All rights reserved. */
package org.guanmu.model;

import org.guanmu.core.IServant;
import org.guanmu.core.JobClass;
import org.guanmu.log.Loggers;
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
public class Servant implements IServant {
	
	private static Logger logger = Loggers.getLog(Servant.class.getName());
	
	private int id;
	
	private String name;
	
	private JobClass jobClass = JobClass.MAX;
	
	private int atk;
	private int hp;
	
	private int maxNp;
	
	private int po;
	
	private int level;
	
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
	 * 
	 */
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
	private String getPoStr() {
		return getPo() + "破";
	}
	
	
	
	
	
}
