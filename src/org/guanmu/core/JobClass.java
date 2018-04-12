/* Copyright MacroSAN Technologies Co., Ltd. All rights reserved. */
package org.guanmu.core;

import static org.guanmu.config.Config.*;

/**
 * <p>
 * 类描述:职阶枚举
 * <p>
 * 
 * 所属插件:org.guanmu.core
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
		

		/**
		 * @return
		 */
		public double getJobCorrect() {
			return 1.05;
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
		
		@Override
		public int getEnemyNpCollect() {
			return 3;
		}
		

		/**
		 * @return
		 */
		public double getJobCorrect() {
			return 0.95;
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
		

		/**
		 * @return
		 */
		public double getJobCorrect() {
			return 0.9;
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
		
		@Override
		public int getEnemyNpCollect() {
			return 3;
		}	
		
		/**
		 * @return
		 */
		public double getJobCorrect() {
			return 0.9;
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
		
		@Override
		public int getEnemyNpCollect() {
			return 5;
		}	
		
		/**
		 * @return
		 */
		public double getJobCorrect() {
			return 1.1;
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
		
		
		/**
		 * @return
		 */
		public double getJobCorrect() {
			return 1.1;
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
		
		
		/**
		 * @return
		 */
		public double getJobCorrect() {
			return 1.1;
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
	 * 上三骑
	 * @return
	 */
	public boolean isUpThreeClass() {
		int index = this.ordinal();
		return index <= 2;
	}	
	
	/**
	 * 下四骑
	 * @return
	 */
	public boolean isDownFourClass() {
		int index = this.ordinal();
		return index > 2 && index <= 7;
	}
	
	/**
	 * 职介克制系数
	 * @param beJob
	 * @return
	 */
	public double attackCoefficient(JobClass beJob) {
		return NORMAL_ACT;
	}
	
	public int getEnemyNpCollect() {
		return 4;
	}

	/**
	 * @return
	 */
	public double getJobCorrect() {
		return 1.0;
	}
}
