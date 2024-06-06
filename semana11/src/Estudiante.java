
public class Estudiante implements Comparable<Estudiante>{
    private String nombre,email;
    private int edad;

    public Estudiante(String nombre, int edad, String email) {
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getEmail() {
        return email;
    }

    public int compareTo(Estudiante otro) {
        return this.nombre.compareToIgnoreCase(otro.nombre);
    }

    @Override
    public String toString() {
        return String.format("%s/%d/%s ", nombre, edad, email);
    }
}
