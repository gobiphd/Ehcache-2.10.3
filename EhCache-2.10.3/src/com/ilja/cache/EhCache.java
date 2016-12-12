/**
 * 
 */
package com.ilja.cache;

import net.sf.ehcache.Element;

/**
 * @author Nithya
 *
 */
public final class EhCache implements ICache {
	
	private final net.sf.ehcache.Cache ehCache;
	
	public EhCache(net.sf.ehcache.Cache ehCache) {
        this.ehCache = ehCache;
    }

	@Override
	public void put(Object key, Object value) {
		this.ehCache.put(new Element(key, value));		
	}

	@Override
	public void put(Object key, Object value, int expiresIn) {
		this.ehCache.put(new Element(key, value, expiresIn));
	}

	@Override
	public Object get(Object key) {
		Element elem = this.ehCache.get(key);
        if (elem != null)
            return elem.getObjectValue();
        else
            return null;
	}

	@Override
	public void remove(Object key) {
		this.ehCache.remove(key);
	}

	@Override
	public boolean containsKey(Object key) {
		return this.ehCache.isKeyInCache(key);
	}

}
