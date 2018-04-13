/* Copyright MacroSAN Technologies Co., Ltd. All rights reserved. */
package org.guanmu.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.guanmu.config.Config;
import org.guanmu.core.IServant;
import org.guanmu.log.Loggers;
import org.guanmu.model.enemys.Enemy;
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
public class Fight {
	private static Logger logger = Loggers.getLog(Fight.class.getName());
	
	// system
	private int fightId;
	private String name;
	private int round = 1;
	private int side = 1;
	private List<RoundHistory> roundHistorys = new ArrayList<>();
	
	// enemy
	private List<IServant> oneEnemys = new ArrayList<>();
	private List<IServant> twoEnemys = new ArrayList<>();
	private List<IServant> threeEnemys = new ArrayList<>();
	private List<IServant> currentEnemys = new ArrayList<>();
	
	private Dealer enemyDealer = null;
	
	// player
	private List<IServant> playServants = new ArrayList<>();
	private List<IServant> currentServants = new ArrayList<>();
	private Dealer playDealer = null;
	

	
	/**
	 * 
	 */
	public Fight(int fightId,String name) {
		this.fightId = fightId;
		this.name = name;
	}
	
	/**
	 * @return the fightId
	 */
	public int getFightId() {
		return fightId;
	}

	/**
	 * @param fightId the fightId to set
	 */
	public void setFightId(int fightId) {
		this.fightId = fightId;
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
	 * @return the round
	 */
	public int getRound() {
		return round;
	}
	/**
	 * @param round the round to set
	 */
	public void setRound(int round) {
		this.round = round;
	}
	
	/**
	 * @return the oneEnemys
	 */
	public List<IServant> getOneEnemys() {
		return oneEnemys;
	}
	/**
	 * @return the twoEnemys
	 */
	public List<IServant> getTwoEnemys() {
		return twoEnemys;
	}
	/**
	 * @return the threeEnemys
	 */
	public List<IServant> getThreeEnemys() {
		return threeEnemys;
	}
	
	/**
	 * @return the playServants
	 */
	public List<IServant> getPlayServants() {
		return playServants;
	}

	/**
	 * 
	 */
	public void start() {
		
		initStartValues();
		
		logger.debug("currentEnemys:" + currentEnemys);
		logger.debug("currentServants:" + currentServants);
		while(isPlayerActive() && isEnemyActive()) {
			// player 			
			playerRound();
			
			if (!isEnemyActive()) {
				logger.info("player win.");
				break;
			}
			
			boolean isChangeSide = checkChangeSide();
			if (isChangeSide) {
				side++;
				currentEnemys = takeEnemyServants();
				continue;
			}
			
			// enemy
			enemyRound();
			
			if (!isPlayerActive()) {
				logger.info("enemy win.");
				break;
			}
			
			enemyAddNp();
			
			round++;
		}
	}

	/**
	 * 
	 */
	private void enemyAddNp() {
		for(IServant servant : currentEnemys) {
			((Enemy)servant).npCollectAdd();
		}
	}

	/**
	 * @return
	 */
	private List<IServant> takeEnemyServants() {
		switch (side) {
		case 1:
			return takeServants(oneEnemys);
		case 2:
			return takeServants(twoEnemys);
		case 3:
			return takeServants(threeEnemys);
		}
		
		return null;
	}

	/**
	 * 
	 */
	private void enemyRound() {
		RoundHistory roundHistory = new RoundHistory(round,false);
		
		Dealer tmpPlayDealer = new Dealer(currentEnemys);
		if (!tmpPlayDealer.equals(enemyDealer)) {
			enemyDealer = tmpPlayDealer;
		}
		List<Card> cards = enemyDealer.takeCards();
		roundHistory.setRoundCards(cards);
		
		List<IServant> targets = new ArrayList<>();
		List<Card> selectCards = autoSelectCardsAndTarget(cards,currentServants,targets);
		roundHistory.setSelectCards(selectCards);
		
		roundHistory.autoAttacks(targets);
		
		roundHistorys.add(roundHistory);
		
		currentServants = takeServants(playServants);
	}

	/**
	 * @return
	 */
	private boolean checkChangeSide() {
		if (side == 1) {
			return takeServants(oneEnemys).isEmpty();
		} else if (side == 2) {
			return takeServants(twoEnemys).isEmpty();
		}else if (side == 3) {
			return takeServants(threeEnemys).isEmpty();
		}
		
		return false;
	}

	/**
	 * 
	 */
	private void playerRound() {
		RoundHistory roundHistory = new RoundHistory(round,true);
		
		Dealer tmpPlayDealer = new Dealer(currentServants);
		if (!tmpPlayDealer.equals(playDealer)) {
			playDealer = tmpPlayDealer;
		}
		List<Card> playCards = playDealer.takeCards();
		roundHistory.setRoundCards(playCards);
		
		logger.debug("playCards:" + playCards);
		
		List<IServant> targets = new ArrayList<>();
		List<Card> selectCards = autoSelectCardsAndTarget(playCards,currentEnemys,targets);
		roundHistory.setSelectCards(selectCards);
		logger.debug("selectCards:" + selectCards + ",targets:" + targets);
		
		
		roundHistory.autoAttacks(targets);
		
		roundHistorys.add(roundHistory);
		
		currentEnemys = takeEnemyServants();
	}

	/**
	 * @param cards
	 * @return
	 */
	private List<Card> autoSelectCardsAndTarget(List<Card> cards,List<IServant> attackServants,List<IServant> targets) {
		// TODO 需要优化
		
		List<Card> selects = new ArrayList<>();
		
		List<Card> copy = new ArrayList<>(cards);
		
		while(selects.size() < Config.ROUND_MAX_ATTACK_NUM) {
			Card select = null;
			for(Card card : copy) {			
				if (card instanceof BusterCard) {
					select = card;
					break;
				}
			}			
			if (select != null) {
				selects.add(select);
				copy.remove(select);
				targets.add(attackServants.get(0));
				continue;
			}
			
			for(Card card : copy) {			
				if (card instanceof ArtsrCard) {
					select = card;
					break;
				}
			}	
			if (select != null) {
				selects.add(select);
				copy.remove(select);
				targets.add(attackServants.get(0));
				continue;
			}
			
			selects.add(copy.remove(0));	
			targets.add(attackServants.get(0));
			
		}
		
		Set<IServant> froms = new HashSet<>();
		for(Card card : selects) {
			froms.add(card.getServant());
		}
		
		if (froms.size() == 1) {
			IServant from = (IServant)froms.toArray()[0];
			Card ex = new ExCard(Config.EX_CARD_ID, from);
			selects.add(ex);
			targets.add(attackServants.get(0));
		}
		
		return selects;
	}

	/**
	 * 
	 */
	private void initStartValues() {

		round = 1;
		
		side = 1;
		
		currentEnemys = takeServants(oneEnemys);
		enemyDealer = new Dealer(currentEnemys);
		
		currentServants = takeServants(playServants);
		playDealer = new Dealer(currentServants);
	}

	/**
	 * @param oneEnemys2
	 * @return
	 */
	private List<IServant> takeServants(List<IServant> servants) {
		List<IServant> takeServants = new ArrayList<>();
			
		for(IServant tmp : servants) {
			if (tmp.isActive()) {
				takeServants.add(tmp);
			}
			
			if (takeServants.size() == Config.ROUND_MAX_SERVANT_NUM) {
				break;
			}			
		}
		
		return takeServants;
	}

	/**
	 * @return
	 */
	private boolean isPlayerActive() {
		for(IServant servant : playServants) {
			if (servant.isActive()) {
				return true;
			}
		}
		
		return false;
	}

	/**
	 * @return
	 */
	private boolean isEnemyActive() {
		for(IServant servant : oneEnemys) {
			if (servant.isActive()) {
				return true;
			}			
		}

		for(IServant servant : twoEnemys) {
			if (servant.isActive()) {
				return true;
			}			
		}

		for(IServant servant : threeEnemys) {
			if (servant.isActive()) {
				return true;
			}			
		}
		
		return false;
	}

	/**
	 * 
	 */
	public void printRoundHistorys() {
		for(RoundHistory history : roundHistorys) {
			int historyRound = history.getRound();
			boolean isPlay = history.isPlayer();
			System.out.println("	第" + historyRound + "回合	");
			System.out.println(isPlay ? "玩家回合：" : "电脑回合：");
			
			for (Attack attack : history.getAttacks()) {
				System.out.println(attack);
			}
		}
		
	}
	
	
}
