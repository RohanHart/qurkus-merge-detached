/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or http://www.gnu.org/licenses/lgpl-2.1.html
 */
package org.dreab8.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * @author Andrea Boriero
 */
@Lock
@Interceptor
public class LockInterceptor {
	private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock( true);

	@AroundInvoke
	public Object concurrencyControl(InvocationContext ctx) throws Exception {
//		Lock lockAnnotation = ctx.getMethod().getAnnotation(Lock.class);
//
//		if (lockAnnotation == null) {
//			lockAnnotation = ctx.getTarget().getClass().getAnnotation(Lock.class);
//		}
//System.out.println( ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
//		Object returnValue = null;
//		switch (lockAnnotation.value()) {
//			case WRITE:
//				ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
//				try {
//					writeLock.lock();
//					returnValue = ctx.proceed();
//				} finally {
//					writeLock.unlock();
//				}
//				break;
//			case READ:
//				ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
//				try {
//					readLock.lock();
//					returnValue = ctx.proceed();
//				} finally {
//					readLock.unlock();
//				}
//				break;
//		}
//		return returnValue;
		throw new RuntimeException( "%%%%%%%%%%%%%%%%%%%%%%%%%%%%" );
	}
}
