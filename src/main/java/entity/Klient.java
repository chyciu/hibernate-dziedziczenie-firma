package entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
    @DiscriminatorValue("klient")
    public class Klient extends Firma {
        @Column
        private String telefonKont_;

        public String getTelefonKont_() {
            return telefonKont_;
        }

        public void setTelefonKont_(String telefonKont_) {
            this.telefonKont_ = telefonKont_;
        }


}
