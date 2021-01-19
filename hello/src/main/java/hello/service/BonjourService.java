package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.bean.Langue;

@Service
public class BonjourService {
//bean metier

	@Autowired
	private Langue francais;
	@Autowired
	private Langue anglais;

	public String direBonjour() {
		return francais.direBonjour();
	}

	public String direHello() {
		return anglais.direBonjour();
	}

	public String direBonjour(String langue) {
		return langue.equals("francais") ? francais.direBonjour() : anglais.direBonjour();
	}

}
