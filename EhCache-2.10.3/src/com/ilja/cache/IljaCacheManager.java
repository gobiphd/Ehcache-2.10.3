/**
 * 
 */
package com.ilja.cache;

import net.sf.ehcache.CacheManager;



/**
 * @author Nithya
 *
 */
public final class IljaCacheManager {
	
	static IljaCacheManager cacheManager;
	
	private static CacheManager ehCacheManager = null;
	
	static {
        cacheManager = new IljaCacheManager();
    }
	
	private IljaCacheManager() {
		parseEhConfiguration();
    }
	
	private void parseEhConfiguration() {
		try {
			ehCacheManager = CacheManager.create(IljaCacheManager.class.getResource("/resources/ehcache.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public static ICache getCache(String cacheName) {
        if (ehCacheManager != null) {
        	return new EhCache(ehCacheManager.getCache(cacheName));
        }
		return null;
    }
	
	public static void close() {
		ehCacheManager.shutdown();
	}
}
