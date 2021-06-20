package com.sjoerd;

import java.util.ArrayList;

public interface ISpeler {

	public abstract boolean controleerWachtwoord(String wachtwoord);

	public abstract boolean heeftOnafgemaakteQuiz();

	public abstract void stelHuidigeQuizIn(IQuiz quiz);

	public abstract void voegGespeeldeQuizToe(IQuiz quiz);

	public abstract void rondHuidigeQuizAf();

	public abstract ArrayList<IQuiz> haalAlGespeeldeQuizzesOp();

	public abstract IQuiz haalOnafgemaakteQuizOp();

	public abstract void waardeerSaldoOp(int creditbedrag);

	public abstract void schrijfVanSaldoAf(int creditbedrag);

	public abstract String haalGebruikersnaamOp();
}
