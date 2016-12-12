/**
 * 
 */
package com.ilja.cache;

/**
 * @author Nithya
 *
 */
public interface ICache {

	public void put(Object key, Object value);
	
	public void put(Object key, Object value, int expiresIn);
	
	public Object get(Object key);

    public void remove(Object key);

    public boolean containsKey(Object key);
}
