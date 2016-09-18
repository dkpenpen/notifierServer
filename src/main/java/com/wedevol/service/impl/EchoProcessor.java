package com.wedevol.service.impl;

import com.wedevol.bean.CcsInMessage;
import com.wedevol.bean.CcsOutMessage;
import com.wedevol.service.PayloadProcessor;
import com.wedevol.util.Util;
import com.wedevol.xmpp.CcsClient;
import com.wedevol.xmpp.MessageHelper;

/**
 * Handles an echo request
 */
public class EchoProcessor implements PayloadProcessor {

	@Override
	public void handleMessage(CcsInMessage inMessage) {
		CcsClient client = CcsClient.getInstance();
		String messageId = Util.getUniqueMessageId();
		String to = inMessage.getFrom();

		// Send the incoming message to the the device that made the request
		CcsOutMessage outMessage = new CcsOutMessage(to, messageId, inMessage.getDataPayload());
		String jsonRequest = MessageHelper.createJsonOutMessage(outMessage);
		client.send(jsonRequest);
	}

}