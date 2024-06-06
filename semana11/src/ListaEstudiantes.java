
import java.util.LinkedList;
import java.util.List;

public class ListaEstudiantes {
    private List<Estudiante> estudiantes;

    public ListaEstudiantes() {
        estudiantes = new LinkedList<>();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public Estudiante buscarPorNombre(String nombre) {
        for (Estudiante est : estudiantes) {
            if (est.getNombre().equalsIgnoreCase(nombre)) {
                return est;
            }
        }
        return null;
    }

    public Estudiante buscarPorEdad(int edad) {
        for (Estudiante est : estudiantes) {
            if (est.getEdad() == edad) {
                return est;
            }
        }
        return null;
    }

    public Estudiante buscarPorEmail(String email) {
        for (Estudiante est : estudiantes) {
            if (est.getEmail().equalsIgnoreCase(email)) {
                return est;
            }
        }
        return null;
    }

    public void eliminarPorNombre(String nombre) {
        Estudiante est = buscarPorNombre(nombre);
        if (est != null) {
            estudiantes.remove(est);
            System.out.println("Estudiante eliminado: " + est);
        } else {
            System.out.println("No se encontró elemento a eliminar");
        }
    }

    public void eliminarPorEdad(int edad) {
        Estudiante est = buscarPorEdad(edad);
        if (est != null) {
            estudiantes.remove(est);
            System.out.println("Estudiante eliminado: " + est);
        } else {
            System.out.println("No se encontró elemento a eliminar");
        }
    }

    public void eliminarPorEmail(String email) {
        Estudiante est = buscarPorEmail(email);
        if (est != null) {
            estudiantes.remove(est);
            System.out.println("Estudiante eliminado: " + est);
        } else {
            System.out.println("No se encontró elemento a eliminar");
        }
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }
}
