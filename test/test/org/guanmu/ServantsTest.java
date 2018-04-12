/* Copyright MacroSAN Technologies Co., Ltd. All rights reserved. */
package test.org.guanmu;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.guanmu.core.JobClass;
import org.guanmu.model.servants.Servant;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * <p>
 * ������:
 * <p>
 * 
 * �������:test.org.guanmu
 * @author wangquan 2018-4-11
 * 
 */
public class ServantsTest extends TestCase {
	
	private List<Servant> servants = new ArrayList<>();
	
	@Before
	public void setUp() throws Exception {
		servants.add(new Servant(1, "���ޡ���������", JobClass.Shielder, 8730, 12877, 300, 4, 80));
		servants.add(new Servant(60, "������", JobClass.Archer, 11107, 14553, 100, 4, 90));
		servants.add(new Servant(109, "������Assassion��", JobClass.Assassin, 8958, 11168, 200, 4, 80));
		servants.add(new Servant(113, "������", JobClass.Caster, 11658, 12965, 100, 4, 90));
		servants.add(new Servant(118, "��˹����˹", JobClass.Rider, 11971, 12830, 100, 4, 90));
		servants.add(new Servant(121, "��˹����", JobClass.Saber, 9949, 11589, 200, 4, 80));
		servants.add(new Servant(150, "÷��", JobClass.Caster, 10546, 14259, 300, 4, 90));
		servants.add(new Servant(153, "�����������ԭ����", JobClass.Saber, 12037, 13635, 100, 4, 90));
	}
	
	@Test
	public void testPrint() throws Exception {

		for(Servant servant : servants) {
			servant.printInfo();
		}
	}	
	
	@After
	public void setAfter() throws Exception {

	}
}
