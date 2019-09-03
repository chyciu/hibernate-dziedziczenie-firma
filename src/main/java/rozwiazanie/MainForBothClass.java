package rozwiazanie;

import entity.Klient;
import entity.Pracownik;
import org.hibernate.Session;

public class MainForBothClass {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

//        Klient klient1 = new Klient();
//        klient1.setNazwa_firmy("Rolnik");
//        klient1.setImie("Jan");
//        klient1.setNazwisko("Kowal");
//        klient1.setTelefonKont_("89765657");
//        session.persist(klient1);
//
//
//        Pracownik pracownik1 = new Pracownik();
//        pracownik1.setNazwa_firmy("Kombajn_Co");
//        pracownik1.setImie("Tomasz");
//        pracownik1.setNazwisko("Jablonski");
//        pracownik1.setStanowisko("Kierownik");
//        pracownik1.setWynagrodzenie(7000);
//        session.persist(pracownik1);

        KlientDAO newKlient = new KlientDAO();
        newKlient.createCustomer("Nep", "Jan", "Kowal", "776566987");
        newKlient.createCustomer("KKK", "Ola", "Nowak", "87876566");

    }

}
