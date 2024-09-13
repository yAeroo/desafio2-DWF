package sv.edu.udb.dao;

import sv.edu.udb.model.Estudiante;
import java.util.List;

public interface EstudianteDAO {
    void crear(Estudiante estudiante);
    Estudiante leer(Long id);
    void actualizar(Estudiante estudiante);
    void eliminar(Estudiante estudiante);
    List<Estudiante> listarTodos();
}