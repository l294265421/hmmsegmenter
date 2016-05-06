package com.liyuncong.algorithms.hmmsegmenter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;

/**
 * 训练语料
 * @author yuncong
 *
 */
public class Training {
	private List<String> sentences;
	
	private Training() {
		String fileName = "icwb2-data/training/"
				+ "pku_training.utf8";
		try(InputStream input = new FileInputStream(fileName);) {
			String fileContent = IOUtils.toString(input, "utf-8");
			sentences = CommonTools.findAllChineseSentence(fileContent);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	private static class SingletonHolder {
		private static Training training = new Training();
	}
	
	public static Training getInstance() {
		return SingletonHolder.training;
	}

	public List<String> getSentences() {
		return sentences;
	}
	
}
