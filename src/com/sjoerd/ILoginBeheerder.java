package com.sjoerd;

public interface ILoginBeheerder {

	public abstract void login(ISpeler speler);

	public abstract void logUit();

	public abstract boolean isIngelogd();

}
