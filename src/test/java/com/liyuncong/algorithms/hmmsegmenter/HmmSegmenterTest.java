package com.liyuncong.algorithms.hmmsegmenter;

import static org.junit.Assert.*;

import org.junit.Test;

public class HmmSegmenterTest {

	@Test
	public void testSegmentString() {
		String sentence = "李云聪在深圳工作";
		System.out.println(HmmSegmenter.segment(sentence));
	}

}
