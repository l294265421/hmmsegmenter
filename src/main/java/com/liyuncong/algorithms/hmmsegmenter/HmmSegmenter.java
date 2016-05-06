package com.liyuncong.algorithms.hmmsegmenter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import be.ac.ulg.montefiore.run.jahmm.Hmm;
import be.ac.ulg.montefiore.run.jahmm.ObservationInteger;

public class HmmSegmenter {
	private static Hmm<ObservationInteger> hmm = SegmentationHmmFactory.hmm();
	
	public static void main(String[] args) {
		String sentence = "我叫王芳";
		System.out.println(segment(sentence));
	}
	
	public static String segment(String sentence) {
		if (sentence == null || sentence.length() == 0) {
			return null;
		}
		
		ArrayList<ObservationInteger> observationSequence = SegmentationHmmFactory.
				generateObservationSequence(sentence);
		// use the Viterbi Algorithm
		int[] hiddenStatesSeq = hmm.mostLikelyStateSequence(observationSequence);
		String[] hiddenStates = SegmentationHmmFactory.hiddenStatesSeqToHiddenStates(hiddenStatesSeq);
		String result = segment(sentence, hiddenStates);
		return result;
	}
	
	/**
	 * 
	 * @param sentence 句子
	 * @param hiddenStates 句子对应的隐藏状态
	 * @return 句子中的词用斜线分隔开 如 我/喜欢/你/
	 */
	public static String segment(String sentence, String[] hiddenStates) {
		if (sentence == null || hiddenStates == null) {
			return null;
		}
		int len = sentence.length();
		int len1 = hiddenStates.length;
		if (len == 0 || len1 == 0) {
			return null;
		}
		if (len != len1) {
			throw new IllegalArgumentException("sentence 的长度和hiddenStates的长度不一致");
		}
		StringBuilder stringBuilder = new StringBuilder();
		for(int i = 0; i < len; i++) {
			stringBuilder.append(sentence.charAt(i));
			// 用斜线标识一个词的结束
			if (hiddenStates[i] == HiddenStates.SINGLE.getAlias() || 
					hiddenStates[i] == HiddenStates.END.getAlias()) {
				stringBuilder.append("/");
			}
		}
		return stringBuilder.toString();
	}
}
