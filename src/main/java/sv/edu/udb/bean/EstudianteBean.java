package sv.edu.udb.bean;

import sv.edu.udb.dao.EstudianteDAO;
import sv.edu.udb.dao.EstudianteDAOImpl;
import sv.edu.udb.model.Estudiante;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.Arrays;
import java.util.List;

@ManagedBean
@ViewScoped
public class EstudianteBean {

    private EstudianteDAO estudianteDAO;
    private Estudiante estudiante;
    private List<Estudiante> estudiantes;

    @PostConstruct
    public void init() {
        estudianteDAO = new EstudianteDAOImpl();
        estudiante = new Estudiante();
        cargarEstudiantes();
    }

    public void cargarEstudiantes() {
        estudiantes = estudianteDAO.listarTodos();
    }

    public void guardar() {
        if (estudiante.getId() == null) {
            estudianteDAO.crear(estudiante);
        } else {
            estudianteDAO.actualizar(estudiante);
        }
        cargarEstudiantes();
        estudiante = new Estudiante();
    }

    public List<Estudiante.Genero> getGeneros() {
        return Arrays.asList(Estudiante.Genero.values());
    }

    public void editar(Estudiante est) {
        estudiante = est;
    }

    public void eliminar(Estudiante est) {
        estudianteDAO.eliminar(est);
        cargarEstudiantes();
    }

    public EstudianteDAO getEstudianteDAO() {
        return estudianteDAO;
    }

    public void setEstudianteDAO(EstudianteDAO estudianteDAO) {
        this.estudianteDAO = estudianteDAO;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
}
