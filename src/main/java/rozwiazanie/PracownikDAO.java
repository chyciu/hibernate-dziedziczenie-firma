package rozwiazanie;

import entity.Pracownik;
import org.hibernate.Session;

import java.util.List;

public class PracownikDAO {

    public Pracownik createEmployee (String nazwaFirmy, String imie, String nazwisko, String stanowisko, int wynagrodzenie) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Pracownik nowyPracownik = new Pracownik();
        nowyPracownik.setNazwa_firmy(nazwaFirmy);
        nowyPracownik.setImie(imie);
        nowyPracownik.setNazwisko(nazwisko);
        nowyPracownik.setStanowisko(stanowisko);
        nowyPracownik.setWynagrodzenie(wynagrodzenie);
        session.persist(nowyPracownik);
        session.flush();
        session.close();
        return nowyPracownik;
    }

    public Pracownik findEmployee (Long ID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Pracownik find = session.find(Pracownik.class, ID);
        session.close();
        return find;
    }

    public void updateEmployee (String nazwaFirmy, String imie, String nazwisko, String stanowisko, int wynagrodzenie, Long ID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.createQuery("UPDATE Pracownik p SET p.wynagrodzenie=:wynagrodzenie, "+
                "p.nazwa_firmy=:nazwa_firmy, p.imie=:imie, p.nazwisko=:nazwisko, p.stanowisko=:stanowisko" +
                "WHERE p.id=:id")
                .setParameter("wynagrodzenie", wynagrodzenie).setParameter("nazwa_firmy", nazwaFirmy)
                .setParameter("imie", imie).setParameter("nazwisko", nazwisko).setParameter("stanowisko", stanowisko)
                .setParameter("id", ID).executeUpdate();
        session.flush();
        session.close();
    }

    public void delateEmployee (Pracownik pracownik) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(pracownik);
        session.flush();
        session.close();
    }

    public List<Pracownik> findByNazwisko (String nazwisko) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Pracownik> pracownikLista = session.createNativeQuery("SELECT * FROM firma f " +
                "WHERE f.nazwisko=:nazwisko", Pracownik.class).setParameter("nazwisko", nazwisko)
                .getResultList();
        session.close();
        return pracownikLista;
    }

    public List<Pracownik> findByNazwaFirmy (String nazwaFirmy) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Pracownik> pracownikList = session.createNamedQuery("findByNazwaFirmy", Pracownik.class)
                .setParameter("nazwa_firmy", nazwaFirmy).getResultList();
        session.close();
        return pracownikList;
    }
}
