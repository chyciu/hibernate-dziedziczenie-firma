package entity;

import javax.persistence.*;

    @Entity
    @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
    @DiscriminatorColumn(name="typ_danych",discriminatorType= DiscriminatorType.STRING)
    @Table(name = "firma")
    public class Firma {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column
        private String nazwa_firmy;
        @Column
        private String imie;
        @Column
        private String nazwisko;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNazwa_firmy() {
            return nazwa_firmy;
        }

        public void setNazwa_firmy(String nazwa_firmy) {
            this.nazwa_firmy = nazwa_firmy;
        }

        public String getImie() {
            return imie;
        }

        public void setImie(String imie) {
            this.imie = imie;
        }

        public String getNazwisko() {
            return nazwisko;
        }

        public void setNazwisko(String nazwisko) {
            this.nazwisko = nazwisko;
        }
    }

