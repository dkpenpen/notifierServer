package com.wedevol.service.impl;

import org.springframework.stereotype.Service;
import com.wedevol.bean.CcsOutMessage;
import com.wedevol.service.FCMService;
import com.wedevol.xmpp.CcsClient;
import com.wedevol.xmpp.MessageHelper;

/*
 * FCMServiceImpl
 */

@Service
public class FCMServiceImpl implements FCMService {

	/*
	 * Sends a message to a device through FCM
	 */
	@Override
	public void sendMessage(final CcsOutMessage message) {
		String jsonRequest = MessageHelper.createJsonOutMessage(message);
		CcsClient.getInstance().send(jsonRequest);
	}

}
