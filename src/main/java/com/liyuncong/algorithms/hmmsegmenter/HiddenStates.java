package com.liyuncong.algorithms.hmmsegmenter;

/**
 * 所有隐藏状态
 * @author yuncong
 *
 */
public enum HiddenStates {
	// 词首
	BEGIN("B"), 
	// 词中
	MIDDLE("M"), 
	// 词尾
	END("E"), 
	// 单字成词
	SINGLE("S");
	
	private String alias;
	
	private HiddenStates(String alias) {
		this.alias = alias;
	}

	public String getAlias() {
		return alias;
	}

}
