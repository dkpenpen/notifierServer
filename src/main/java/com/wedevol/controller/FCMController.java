package com.wedevol.controller;

import java.util.HashMap;
import java.util.Map;

import org.jivesoftware.smack.XMPPException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wedevol.bean.StateResponse;
import com.wedevol.service.FCMService;
import com.wedevol.util.Util;
import com.wedevol.xmpp.CcsClient;
import com.wedevol.bean.CcsOutMessage;

/*
 * FCMController: main fcm rest api
 */

@Controller
@RequestMapping("/fcm")
public class FCMController {

	private static final Logger logger = LoggerFactory.getLogger(FCMController.class);

	@Autowired
	private FCMService fcmService;

	public FCMController() {
		CcsClient ccsClient = CcsClient.prepareClient("431269160141", "AIzaSyAOq45Ai7LNsuhxWDWn521jraGKkwwWNtE", true);
		try {
			ccsClient.connect();
		} catch (XMPPException e) {
			e.printStackTrace();
		}
	}

	/* Send a message to a device. HTTP Method: GET */
	/*
	 * http://localhost:8080/notifierServer/fcm/send?token=&message=
	 */
	@RequestMapping(value = "/send", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody StateResponse sendMessage(
			@RequestParam(value = "token", defaultValue = "", required = true) String token,
			@RequestParam(value = "message", defaultValue = "", required = true) String message) {

		StateResponse response = new StateResponse();

		try {
			String messageId = Util.getUniqueMessageId();
			Map<String, String> dataPayload = new HashMap<String, String>();
			dataPayload.put(Util.PAYLOAD_ATTRIBUTE_MESSAGE, message);
			CcsOutMessage out = new CcsOutMessage(token, messageId, dataPayload);

			fcmService.sendMessage(out);

			response.setCode(Util.OK_CODE);
			response.setMessage(Util.OK_MESSAGE);
			logger.debug(Util.OK_LABEL + message);
		} catch (Exception e) {
			response.setCode(Util.SERVER_ERROR_CODE);
			response.setMessage(e.getMessage());
			logger.error(Util.ERROR_LABEL + e.getMessage());
		}
		return response;
	}
}
