/* Copyright MacroSAN Technologies Co., Ltd. All rights reserved. */
package test.org.guanmu;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.guanmu.model.Servant;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * <p>
 * ¿‡√Ë ˆ:
 * <p>
 * 
 * À˘ Ù≤Âº˛:test.org.guanmu
 * @author wangquan 2018-4-11
 * 
 */
public class PrintServantsTest extends TestCase {
	
	private List<Servant> servants = new ArrayList<>();
	
	@Before
	public void setUp() throws Exception {

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
