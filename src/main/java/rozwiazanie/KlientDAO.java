package rozwiazanie;

import entity.Klient;
import org.hibernate.Session;

import java.util.List;

public class KlientDAO {

    public Klient createCustomer (String nazwaFirmy, String imie, String nazwisko, String telefon) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Klient nowyKlient = new Klient();
        nowyKlient.setNazwa_firmy(nazwaFirmy);
        nowyKlient.setImie(imie);
        nowyKlient.setNazwisko(nazwisko);
        nowyKlient.setTelefonKont_(telefon);
        session.persist(nowyKlient);
        session.flush();
        session.close();
        return nowyKlient;
    }

    public Klient findCustomer (Long ID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Klient find = session.find(Klient.class, ID);
        session.close();
        return find;
    }

    public void updateCustomer (String nazwaFirmy, String imie, String nazwisko, String telefon, Long ID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.createQuery("UPDATE Klient k SET k.telefonKon=:telefonKon, "+
                "k.nazwa_firmy=:nazwa_firmy, k.imie=:imie, k.nazwisko=:nazwisko" +
                "WHERE k.id=:id")
                .setParameter("telefonKon", telefon).setParameter("nazwa_firmy", nazwaFirmy)
                .setParameter("imie", imie).setParameter("nazwisko", nazwisko)
                .setParameter("id", ID).executeUpdate();

        session.flush();
        session.close();
    }


    public void delateCustomer (Klient klient) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(klient);
        session.flush();
        session.close();
    }

    public List<Klient> findByNazwisko (String nazwisko) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Klient> klienciLista = session.createNativeQuery("SELECT * FROM firma f " +
                "WHERE f.nazwisko=:nazwisko", Klient.class).setParameter("nazwisko", nazwisko)
                .getResultList();
        session.close();
        return klienciLista;
    }

    public List<Klient> findByNazwaFirmy (String nazwaFirmy) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Klient> klientList = session.createNamedQuery("findByNazwaFirmy", Klient.class)
                .setParameter("nazwa_firmy", nazwaFirmy).getResultList();
        session.close();
        return klientList;
    }

}
