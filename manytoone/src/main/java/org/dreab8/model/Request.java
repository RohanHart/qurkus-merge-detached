package org.dreab8.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Andrea Boriero
 */
@Entity
public class Request extends AbstractModel {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User userSolicitacao) {
        this.user = userSolicitacao;
    }
}
