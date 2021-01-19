package hello;

import org.springframework.beans.factory.annotation.Autowired;

import hello.service.BonjourService;

public class ApplicationSpring {

	@Autowired
	private BonjourService service;

	public void run(String[] args) {
		System.out.println(service.direBonjour());
		System.out.println(service.direBonjour("anglais"));
	}
}
