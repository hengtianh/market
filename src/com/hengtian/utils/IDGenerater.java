package com.hengtian.utils;

import java.util.UUID;

public class IDGenerater {
	
	/**
	 * ʹ��uuid������Ʒ��id��
	 * @return String uuid��
	 */
	public synchronized static String generatProId(){
		return UUID.randomUUID().toString();
	}

}
