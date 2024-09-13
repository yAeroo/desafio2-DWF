package sv.edu.udb.dao;

import sv.edu.udb.model.Estudiante;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EstudianteDAOImpl implements EstudianteDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public EstudianteDAOImpl() {
        emf = Persistence.createEntityManagerFactory("GestionEstudiantesPU");
        em = emf.createEntityManager();
    }

    @Override
    public void crear(Estudiante estudiante) {
        em.getTransaction().begin();
        em.persist(estudiante);
        em.getTransaction().commit();
    }

    @Override
    public Estudiante leer(Long id) {
        return em.find(Estudiante.class, id);
    }

    @Override
    public void actualizar(Estudiante estudiante) {
        em.getTransaction().begin();
        em.merge(estudiante);
        em.getTransaction().commit();
    }

    @Override
    public void eliminar(Estudiante estudiante) {
        em.getTransaction().begin();
        em.remove(em.merge(estudiante));
        em.getTransaction().commit();
    }

    @Override
    public List<Estudiante> listarTodos() {
        return em.createQuery("SELECT e FROM Estudiante e", Estudiante.class).getResultList();
    }
}