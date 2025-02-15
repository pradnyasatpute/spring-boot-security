package com.ps.spring_boot_call_enabled_app;

import java.net.URI;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;

@SpringBootApplication
public class VoiceCall1Application implements ApplicationRunner {
	private final static String SID_ACCOUNT = "AC84b49e31ecaea985a3509a9414da8b0c";
	private final static String AUTH_ID = "9bbc815e15714582a9172a4ab0c1d701";
	private final static String FROM_NUMBER = "+12184963763";
	private final static String TO_NUMBER = "+918411832558";
	
	static {
		Twilio.init(SID_ACCOUNT,AUTH_ID);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(VoiceCall1Application.class, args);
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Call.creator(new PhoneNumber(TO_NUMBER), new PhoneNumber(FROM_NUMBER),
				   new URI("http://demo.twilio.com/docs/voice.xml")).create();
		
	}

}
