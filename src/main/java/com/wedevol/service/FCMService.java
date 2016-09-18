package com.wedevol.service;

import com.wedevol.bean.CcsOutMessage;

/*
 * FCMService Interface
 */

public interface FCMService {

	public void sendMessage(CcsOutMessage message);

}
