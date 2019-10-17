package org.dreab8.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author Andrea Boriero
 */
@MappedSuperclass
public class AbstractModel {

	@Id
	@GeneratedValue
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if ( this == o ) {
			return true;
		}
		if ( o == null || getClass() != o.getClass() ) {
			return false;
		}
		AbstractModel abs = (AbstractModel) o;
		if ( null == getId() || null == abs.getId() ) {
			return false;
		}
		return Objects.equals( getId(), abs.getId() );
	}

	@Override
	public int hashCode() {
		return Objects.hash( getId() );
	}
}
