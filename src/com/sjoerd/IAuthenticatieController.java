package com.sjoerd;

public interface IAuthenticatieController {

	public abstract void registreer(String gebruikersnaam, String wachtwoord);

	public abstract void logIn(String gebruikersnaam, String wachtwoord);

	public abstract void logUit();

	public abstract boolean isIngelogd();

}
