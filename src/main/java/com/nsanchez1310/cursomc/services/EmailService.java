package com.nsanchez1310.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.nsanchez1310.cursomc.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);

}
