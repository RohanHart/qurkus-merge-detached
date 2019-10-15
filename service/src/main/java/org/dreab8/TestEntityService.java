/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or http://www.gnu.org/licenses/lgpl-2.1.html
 */
package org.dreab8;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.dreab8.lock.Lock;
import org.dreab8.lock.LockType;

/**
 * @author Andrea Boriero
 */
@ApplicationScoped
@Transactional
@Lock(LockType.READ)
public class TestEntityService extends AbstractRepository {


	public void merge(TestEntity testEntity) {
		em.merge( testEntity );
	}

	public TestEntity find(Long id) {
		return em.find( TestEntity.class, id );
	}


	public TestEntity persist( String name) {
		TestEntity entity = new TestEntity();
		entity.setName( name );
		entity.surname = name;
		em.persist( entity );
		em.flush();
		return entity;
	}
}
