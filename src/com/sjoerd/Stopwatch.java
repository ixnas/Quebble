package com.sjoerd;

public class Stopwatch
{
	private long startTijdInMilliseconden;
	private int verstrekenTijdInSeconden;

	public Stopwatch()
	{
		startTijdInMilliseconden = 0;
		verstrekenTijdInSeconden = 0;
	}

	public void Start()
	{
		startTijdInMilliseconden = System.currentTimeMillis();
		verstrekenTijdInSeconden = 0;
	}

	public void Stop()
	{
		verstrekenTijdInSeconden = (int) ((System.currentTimeMillis() - startTijdInMilliseconden) / 100);
	}

	public int haalVerstrekenTijdInSecondenOp()
	{
		return verstrekenTijdInSeconden;
	}
}
