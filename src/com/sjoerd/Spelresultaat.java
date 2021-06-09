package com.sjoerd;

public class Spelresultaat {

	private ScoreBerekeningStrategy scoreBerekeningStrategy;

	private SpelStatistieken spelStatistieken;

	public int haalScoreOp() {
		return scoreBerekeningStrategy.haalScoreOp(spelStatistieken);
	}

	public Spelresultaat(SpelStatistieken spelStatistieken) {
		this.spelStatistieken = spelStatistieken;
	}

}
