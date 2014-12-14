package com.pnv.hash;

import java.util.Arrays;
import java.util.Collection;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ConsistentHashRingTest {
	
	ConsistentHashRouter router;
	
	public void init()
	{
		
	}
	
	@Test
	public void NoNodeRing()
	{
		Collection<Node> pNodes = Arrays.asList(new Node(null, null, 0));
		int vnodeCount = 0;
		router = new ConsistentHashRouter(pNodes, vnodeCount);
		
		Assert.assertEquals(router.size(), 0);
	}

}
