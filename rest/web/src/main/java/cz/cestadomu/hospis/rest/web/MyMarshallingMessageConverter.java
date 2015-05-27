package cz.cestadomu.hospis.rest.web;

import java.io.Serializable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.support.converter.MarshallingMessageConverter;
import org.springframework.jms.support.converter.MessageConversionException;

public class MyMarshallingMessageConverter extends MarshallingMessageConverter {

	@Override
	public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
		try {
			return super.toMessage(object, session);
		} catch (Exception e) {
			return session.createObjectMessage((Serializable) object);
		}
	}

	@Override
	public Object fromMessage(Message message) throws JMSException, MessageConversionException {
		try {
			return super.fromMessage(message);
		} catch (IllegalArgumentException e) {
			return ((ObjectMessage) message).getObject();
		} catch (MessageConversionException e) {
			return ((TextMessage) message).getText();
		}
	}
}
