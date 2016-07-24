package com.oocl.mnlbc.utils;

import java.util.Collection;
/**
 * 
 * @author BRIONSE
 *
 */
public class CollectionUtils {

	public static <E> boolean isEmptyList(Collection<E> list) {
		return list == null || 0 == list.size();
	}

	public static <E> boolean isNotEmptyList(Collection<E> list) {
		return list != null && list.size() > 0;
	}
	
}
