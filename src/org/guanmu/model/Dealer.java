/* Copyright MacroSAN Technologies Co., Ltd. All rights reserved. */
package org.guanmu.model;

import java.util.ArrayList;
import java.util.List;

import org.guanmu.core.IServant;

/**
 * <p>
 * ¿‡√Ë ˆ:
 * <p>
 * 
 * À˘ Ù≤Âº˛:org.guanmu.model
 * @author wangquan 2018-4-12
 * 
 */
public class Dealer {
	
	private int time = 0;
	
	private List<IServant> servants = new ArrayList<>();
	
	private List<Card> currentCards = new ArrayList<>();
	
	/**
	 * @param servants
	 */
	public Dealer(List<IServant> servants) {
		super();
		this.servants = servants;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result;
		for(IServant tmp : servants) {
			result += tmp.hashCode();
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (getClass() != obj.getClass())
			return false;
		
		Dealer other = (Dealer) obj;
		if (servants.containsAll(other.servants) && other.servants.containsAll(servants)) {
			return true;
		}
		
		return false;
	}

	public List<Card> takeCards() {
		List<Card> roundCards = new ArrayList<>();
		if (time >= servants.size()) {
			time = 0;
		}
		
		if (time == 0) {
			for(IServant tmp : servants) {
				currentCards.addAll(tmp.getCards());				
			}
		}
		
		time++;
		
		while(roundCards.size() < 5) {
			int index = (int)Math.floor((Math.random() * (currentCards.size() - 1)));
			
			Card card = currentCards.remove(index);
			roundCards.add(card);
		}

		return roundCards;
	}
	
}
