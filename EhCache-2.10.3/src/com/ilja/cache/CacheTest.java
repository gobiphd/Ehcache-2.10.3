/**
 * 
 */
package com.ilja.cache;



/**
 * @author Nithya
 *
 */
public class CacheTest {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		//Class.forName("com.ilja.cache.IljaCacheManager");
		ICache coreCache = IljaCacheManager.getCache("coreCache");
		coreCache.put(String.valueOf(1), "One1");
		coreCache.put(String.valueOf(2), "One2");
		coreCache.put(String.valueOf(3), "One3");
		coreCache.put(String.valueOf(4), "One4");
		
		System.out.println("First : "+coreCache.get(String.valueOf(1)));
		System.out.println("Second : "+coreCache.get(String.valueOf(2)));
		
		/*while (coreCache.iterator().hasNext()) {
			System.out.println(coreCache.iterator().next());
		}*/
		
		IljaCacheManager.close();

	}

}
