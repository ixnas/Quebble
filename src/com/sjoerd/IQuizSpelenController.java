package com.sjoerd;

import java.util.ArrayList;

public interface IQuizSpelenController {

	public abstract void startNieuweQuiz();

	public abstract void startWillekeurigeQuiz();

	public abstract void hervatOpenstaandeQuiz();

	public abstract String haalUitlegOp();

	public abstract String haalQuizVraagOp();

	public abstract ArrayList<String> haalMogelijkeAntwoordenOp();

	public abstract void geefAntwoord(String antwoord);

	public abstract ArrayList<Character> haalBehaaldeLettersOp();

	public abstract void legWoord(String woord);

	public abstract int haalScoreOp();

	public abstract boolean alleVragenZijnBeantwoord();

}
