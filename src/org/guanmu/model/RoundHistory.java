/* Copyright MacroSAN Technologies Co., Ltd. All rights reserved. */
package org.guanmu.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.guanmu.config.Config;
import org.guanmu.core.IServant;
import org.guanmu.log.Loggers;
import org.guanmu.model.servants.Servant;
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
public class RoundHistory {
	
	private static Logger logger = Loggers.getLog(RoundHistory.class.getName());
	
	// false为ai
	private boolean isPlayer;
	
	private int round;
	
	private List<Card> roundCards = new ArrayList<>();
	
	private List<Card> selectCards = new ArrayList<>();
	
	private List<Attack> attacks = new ArrayList<>();

	/**
	 * @param isPlayer
	 */
	public RoundHistory(int round, boolean isPlayer) {
		super();
		this.round = round;
		this.isPlayer = isPlayer;
	}

	
	/**
	 * @return the round
	 */
	public int getRound() {
		return round;
	}


	/**
	 * @return the isPlayer
	 */
	public boolean isPlayer() {
		return isPlayer;
	}

	/**
	 * @return the roundCards
	 */
	public List<Card> getRoundCards() {
		return roundCards;
	}

	/**
	 * @return the selectCards
	 */
	public List<Card> getSelectCards() {
		return selectCards;
	}

	/**
	 * @return the attacks
	 */
	public List<Attack> getAttacks() {
		return attacks;
	}

	/**
	 * @param isPlayer the isPlayer to set
	 */
	public void setPlayer(boolean isPlayer) {
		this.isPlayer = isPlayer;
	}

	/**
	 * @param roundCards the roundCards to set
	 */
	public void setRoundCards(List<Card> roundCards) {
		this.roundCards = roundCards;
	}

	/**
	 * @param selectCards the selectCards to set
	 */
	public void setSelectCards(List<Card> selectCards) {
		this.selectCards = selectCards;
	}

	/**
	 * @param attacks the attacks to set
	 */
	public void setAttacks(List<Attack> attacks) {
		this.attacks = attacks;
	}
	
	/**
	 * @param selectCards
	 * @param targets
	 * @return
	 * @throws CloneNotSupportedException 
	 */
	public void autoAttacks(List<IServant> targets) {
		
		try {
			for(int i = 0;i < selectCards.size();i++) {
				Card card = selectCards.get(i);
				IServant from = card.getServant();
				IServant to = targets.get(i);
				
				int atk = from.getAtk();
				double cardRate = card.getCardRate();
				double positionRate = getPositionRate(i);
				double cardBuff = card.getBuff();
				boolean isBusterFirst = isBusterFirst();
				double jobCorrect = from.getJobClass().getJobCorrect();
				double jobCoefficient = from.getJobClass().attackCoefficient(to.getJobClass());
				double campCorrect = 1.0;
				
				double atkBuff = from.getAtkBuff();
				double defenseBuff = to.getDefenseBuff();
				double specialBuff = from.getSpecialBuff();
				double specialDefenseBuff = to.getSpecialDefenseBuff();
				double criticalBuff = from.getCriticalBuff();
				boolean isCritical = false;
				double constantDamage = from.getConstantDamage();
				double constantDeDamage = to.getConstantDeDamage();
				int damage = (int) (
						atk * Config.ATK_CORRECT 
						* (cardRate * positionRate * (1 + cardBuff) + (isBusterFirst ? 0.5 : 0))
						* jobCorrect
						* jobCoefficient
						* campCorrect
						* (0.9 + Math.random()/5)
						* (1 + atkBuff - defenseBuff)
						* (1 + specialBuff - specialDefenseBuff + criticalBuff)
						* (isCritical ? 2.0 : 1.0)
						* ( card instanceof ExCard ? ( isSameColor() ? 3.5 : 2.0 ): 1.0 )
						+ constantDamage - constantDeDamage
						+ atk * (isSameColor() && isBusterFirst ? 0.2 : 0)
						);
				Attack attack = new Attack(from.newServant(), to.newServant(), card, damage);
				
				attacks.add(attack);
				
				int beforeHp = to.getHp();
				to.beAtk(damage);
				
				// TODO
				if (from instanceof Servant) {
					int np = 0;
					((Servant)from).npAdd(np);				
				}
				
				logger.debug(from.getName() + "(" + card + ")" + " ->" + to.getName());
				logger.debug(beforeHp + "-" + damage + "=" + to.getHp());
			}			
		} catch (Exception e) {
			logger.error("auto attack exception.",e);
		}

		
	}

	/**
	 * @return
	 */
	private boolean isSameColor() {
		Set<Class<?>> colors = new HashSet<>();
		for(Card tmp : selectCards) {
			if (tmp instanceof ExCard) {
				continue;
			}
			colors.add(tmp.getClass());
		}
		return colors.size() == 1;
	}

	/**
	 * @return
	 */
	private boolean isBusterFirst() {
		return selectCards.get(0) instanceof BusterCard;
	}

	/**
	 * @param i
	 * @return
	 */
	private double getPositionRate(int i) {
		double rate = 1.0;
		switch(i) {
		case 0:
			rate = 1.0;
			break;
		case 1:
			rate = 1.2;
			break;
		case 2:
			rate = 1.4;
			break;
		}
		
		return rate;
	}	
	
}
