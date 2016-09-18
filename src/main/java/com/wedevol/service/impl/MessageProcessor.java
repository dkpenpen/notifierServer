package com.wedevol.service.impl;

import com.wedevol.xmpp.CcsClient;
import com.wedevol.xmpp.MessageHelper;
import com.wedevol.bean.CcsInMessage;
import com.wedevol.bean.CcsOutMessage;
import com.wedevol.service.PayloadProcessor;
import com.wedevol.util.Util;

/**
 * Handles an upstream message request
 */
public class MessageProcessor implements PayloadProcessor {

	@Override
	public void handleMessage(CcsInMessage inMessage) {
		CcsClient client = CcsClient.getInstance();
		String messageId = Util.getUniqueMessageId();
		String to = inMessage.getDataPayload().get(Util.PAYLOAD_ATTRIBUTE_RECIPIENT);

		// TODO: handle the data payload sent to the client device. Here, I just
		// resend the incoming message.
		CcsOutMessage outMessage = new CcsOutMessage(to, messageId, inMessage.getDataPayload());
		String jsonRequest = MessageHelper.createJsonOutMessage(outMessage);
		client.send(jsonRequest);
	}

}