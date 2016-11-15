package com.hengtian.utils;

import java.util.UUID;

public class IDGenerater {
	
	/**
	 * 使用uuid生成商品的id号
	 * @return String uuid号
	 */
	public synchronized static String generatProId(){
		return UUID.randomUUID().toString();
	}

}
