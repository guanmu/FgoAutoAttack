/* Copyright MacroSAN Technologies Co., Ltd. All rights reserved. */
package org.guanmu.model;

import org.guanmu.core.IServant;
import org.guanmu.core.JobClass;

/**
 * <p>
 * ¿‡√Ë ˆ:
 * <p>
 * 
 * À˘ Ù≤Âº˛:org.guanmu.model
 * @author wangquan 2018-4-11
 * 
 */
public class Servant implements IServant {
	
	private int id;
	
	private String name;
	
	private JobClass jobClass = JobClass.MAX;
	
	private int atk;
	private int hp;
	
	private int maxNp;

	/**
	 * 
	 */
	public Servant() {
	
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
	 * 
	 */
	public void printInfo() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
