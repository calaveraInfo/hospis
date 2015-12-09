package cz.cestadomu.hospis.rest.lib;

import java.io.Serializable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.support.converter.MarshallingMessageConverter;
import org.springframework.jms.support.converter.MessageConversionException;

public class MyMarshallingMessageConverter extends MarshallingMessageConverter {
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(MyMarshallingMessageConverter.class);

	@Override
	public Message toMessage(final Object object, final Session session) throws JMSException, MessageConversionException {
		try {
			return super.toMessage(object, session);
		} catch (final Exception e) {
			e.printStackTrace();
			// log.warn("Neni mozne serializovat.", e);
			return session.createObjectMessage((Serializable) object);
		}
	}

	@Override
	public Object fromMessage(final Message message) throws JMSException, MessageConversionException {
		try {
			return super.fromMessage(message);
		} catch (final IllegalArgumentException e) {
			e.printStackTrace();
			return ((ObjectMessage) message).getObject();
		} catch (final MessageConversionException e) {
			e.printStackTrace();
			return ((TextMessage) message).getText();
		}
	}
}
