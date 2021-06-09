package com.sjoerd;

public abstract class ScoreBerekeningStrategy
{

	public static ScoreBerekeningStrategy haalStrategyOp()
	{
		return new SimpeleScoreBerekeningStrategy();
	}

	public abstract int haalScoreOp(SpelStatistieken spelStatistieken);

}
