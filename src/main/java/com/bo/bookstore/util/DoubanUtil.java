package com.bo.bookstore.util;

/**
 * Author: lebk.lei@gmail.com
 * Date: 2013-3-14
 */

import org.apache.log4j.Logger;
import com.google.gdata.client.douban.DoubanService;

/**
 * @author: Terry_Lei
 * @date 2013-3-12 下午2:06:09
 */

public class DoubanUtil {

	private static final DoubanService ds;
	private static Logger logger = Logger.getLogger(DoubanUtil.class);
	private static String apiKey = "059ef56f6b705e1210dce04e42511a36";
	private static String secret = "006ba4a489916c13";
	static {
		try {
			ds = new DoubanService("subApplication", apiKey, secret);
		} catch (Throwable ex) {
			logger.error("fail to intial the DoubanService" + ex);
			throw new ExceptionInInitializerError(ex);
		}

	}

	public static DoubanService getDoubanService() {

		return ds;

	}

}
