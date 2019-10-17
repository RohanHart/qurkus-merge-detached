package org.dreab8.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Andrea Boriero
 */
@Entity
@Table(name = "`User`")
public class User extends AbstractModel {

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "idOffice")
    private Office office;

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
}
