/* Copyright MacroSAN Technologies Co., Ltd. All rights reserved. */
package org.guanmu.core;

import static org.guanmu.config.Config.*;

/**
 * <p>
 * ������:ְ��ö��
 * <p>
 * 
 * �������:org.guanmu.core
 * @author wangquan 2018-4-11
 * 
 */
public enum JobClass {
	
	Saber {
		public double attackCoefficient(JobClass beJob) {
			switch(beJob) {
			case Saber: 
			case Lancer:
				return GOOD_ACT;
			case Archer:
				return BAD_ACT;
			case Rider:
			case Caster:
			case Assassin:
			case Berserker:
				return GOOD_ACT;
			case Avenger:
				return NORMAL_ACT;
			case Ruler:	
				return BAD_ACT;
			default:
				return NORMAL_ACT;
			}
		}		
	},
	Lancer {
		public double attackCoefficient(JobClass beJob) {
			switch(beJob) {
			case Saber: 
				return BAD_ACT;
			case Lancer:
			case Archer:
				return GOOD_ACT;
			case Rider:
			case Caster:
			case Assassin:
			case Berserker:
				return GOOD_ACT;
			case Avenger:
				return NORMAL_ACT;
			case Ruler:	
				return BAD_ACT;
			default:
				return NORMAL_ACT;
			}
		}		
	},
	Archer {
		public double attackCoefficient(JobClass beJob) {
			switch(beJob) {
			case Saber: 
				return GOOD_ACT;
			case Lancer:
				return BAD_ACT;
			case Archer:
			case Rider:
			case Caster:
			case Assassin:
			case Berserker:
				return GOOD_ACT;
			case Avenger:
				return NORMAL_ACT;
			case Ruler:	
				return BAD_ACT;
			default:
				return NORMAL_ACT;
			}
		}		
	},
	
	Rider {
		public double attackCoefficient(JobClass beJob) {
			switch(beJob) {
			case Saber: 
			case Lancer:
			case Archer:
			case Rider:
			case Caster:
				return GOOD_ACT;
			case Assassin:
				return BAD_ACT;
			case Berserker:
				return GOOD_ACT;
			case Avenger:
				return NORMAL_ACT;
			case Ruler:	
				return BAD_ACT;
			default:
				return NORMAL_ACT;
			}
		}		
	},
	Caster {
		public double attackCoefficient(JobClass beJob) {
			switch(beJob) {
			case Saber: 
			case Lancer:
			case Archer:
			case Rider:
				return BAD_ACT;
			case Caster:
			case Assassin:
				return GOOD_ACT;
			case Berserker:
				return GOOD_ACT;
			case Avenger:
				return NORMAL_ACT;
			case Ruler:	
				return BAD_ACT;
			default:
				return NORMAL_ACT;
			}
		}		
	},
	Assassin {
		public double attackCoefficient(JobClass beJob) {
			switch(beJob) {
			case Saber: 
			case Lancer:
			case Archer:
			case Rider:
				return GOOD_ACT;
			case Caster:
				return BAD_ACT;
			case Assassin:
			case Berserker:
				return GOOD_ACT;
			case Avenger:
				return NORMAL_ACT;
			case Ruler:	
				return BAD_ACT;
			default:
				return NORMAL_ACT;
			}
		}		
	},
	
	Berserker {
		public double attackCoefficient(JobClass beJob) {
			switch(beJob) {
			case Saber: 
			case Lancer:
			case Archer:
			case Rider:
			case Caster:
			case Assassin:
			case Berserker:
			case Avenger:
			case Ruler:				
			default:
				return BREAK_ACT;
			}
		}		
	},
	
	Avenger {
		public double attackCoefficient(JobClass beJob) {
			switch(beJob) {
			case Saber: 
			case Lancer:
			case Archer:
			case Rider:
			case Caster:
			case Assassin:
			case Berserker:
				return GOOD_ACT;
			case Avenger:
			case Ruler:
				return GOOD_ACT;
			default:
				return NORMAL_ACT;
			}
		}		
	},
	Ruler {
		public double attackCoefficient(JobClass beJob) {
			switch(beJob) {
			case Saber: 
			case Lancer:
			case Archer:
			case Rider:
			case Caster:
			case Assassin:
			case Berserker:
				return GOOD_ACT;
			case Avenger:
				return BAD_ACT;
			case Ruler:
			default:
				return NORMAL_ACT;
			}
		}		
	},
	
	Shielder {
		public double attackCoefficient(JobClass beJob) {
			switch(beJob) {
			default:
				return NORMAL_ACT;
			}
		}		
	},
	MAX;
	
	
	/**
	 * ������
	 * @return
	 */
	public boolean isUpThreeClass() {
		int index = this.ordinal();
		return index <= 2;
	}	
	
	/**
	 * ������
	 * @return
	 */
	public boolean isDownFourClass() {
		int index = this.ordinal();
		return index > 2 && index <= 7;
	}
	
	/**
	 * ְ�����ϵ��
	 * @param beJob
	 * @return
	 */
	public double attackCoefficient(JobClass beJob) {
		return NORMAL_ACT;
	}
}
