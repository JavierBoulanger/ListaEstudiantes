import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        ListaEstudiantes lista = new ListaEstudiantes();
        lista.agregarEstudiante(new Estudiante("Javier Boulanger",19,"jav.05@gmail.com"));
        lista.agregarEstudiante(new Estudiante("Aaron",17,"ar44.24@gmail.com"));
        lista.agregarEstudiante(new Estudiante("Zevallos",46,"dasdllsa@gmail.com"));

        while (true) {
            System.out.print("""
                    
                    [1] Agregar Estudiante
                    [2] Eliminar Estudiante
                    [3] Ver lista de Estudiantes
                    [4] Salir
                    Ingresar una opción: """);
            int opcionPrincipal = lector.nextInt();
            lector.nextLine();

            if (opcionPrincipal == 4) {
                System.out.println("Salida exitosa");
                break;
            }

            switch (opcionPrincipal) {
                case 1 -> {
                    System.out.print("\nIngresar nombre: ");
                    String nombre = lector.nextLine();
                    System.out.print("Ingresar edad: ");
                    int edad = lector.nextInt();
                    lector.nextLine();
                    System.out.print("Ingresar email: ");
                    String email = lector.nextLine();
                    lista.agregarEstudiante(new Estudiante(nombre, edad, email));
                    System.out.println("Se ha agregado con exito al estudiante.");
                }
                case 2 -> {
                    System.out.print("""
                            
                            Eliminar estudiante por:
                            [1] Nombre
                            [2] Edad
                            [3] Email
                            Ingresar una opción: """);
                    int opcionEliminar = lector.nextInt();
                    lector.nextLine();

                    switch (opcionEliminar) {
                        case 1 -> {
                            System.out.print("Ingresar el nombre: ");
                            String nombreEliminar = lector.nextLine();
                            lista.eliminarPorNombre(nombreEliminar);
                        }
                        case 2 -> {
                            System.out.print("Ingresar la edad: ");
                            int edadEliminar = lector.nextInt();
                            lector.nextLine();
                            lista.eliminarPorEdad(edadEliminar);
                        }
                        case 3 -> {
                            System.out.print("Ingresar el email: ");
                            String emailEliminar = lector.nextLine();
                            lista.eliminarPorEmail(emailEliminar);
                        }
                        default -> System.out.println("Opción no válida");
                    }

                    System.out.printf("\nQuedan %d Estudiantes:\n", lista.getEstudiantes().size());
                    int i = 0;
                    for (Estudiante e : lista.getEstudiantes()) {
                        i++;
                        System.out.printf("Estudiante %d: ", i);
                        System.out.println(e);
                    }
                }
                case 3 -> {
                    System.out.print("""
                            
                            Ver lista ordenada por:
                            [1] Usando Collections.sort
                            [2] Usando Comparador Natural
                            [3] Usando Criterio Personalizado
                            Ingresar una opción: """);
                    int opcionOrdenar = lector.nextInt();
                    lector.nextLine();

                    switch (opcionOrdenar) {
                        case 1 -> {
                            List<Estudiante> copia1 = new ArrayList<>(lista.getEstudiantes());
                            Collections.sort(copia1);
                            System.out.printf("\nHay %d estudiantes en la lista: \n", copia1.size());
                            copia1.forEach(System.out::println);
                        }
                        case 2 -> {
                            List<Estudiante> copia2 = new ArrayList<>(lista.getEstudiantes());
                            copia2.sort(Comparator.naturalOrder());
                            System.out.printf("\nHay %d estudiantes en la lista: \n", copia2.size());
                            copia2.forEach(System.out::println);
                        }
                        case 3 -> {
                            System.out.print("""
                                    
                                    Ordenar por:
                                    [1] Nombre
                                    [2] Edad
                                    [3] Email
                                    Ingresar una opción: """);
                            int criterio = lector.nextInt();
                            lector.nextLine();

                            List<Estudiante> copia3 = new ArrayList<>(lista.getEstudiantes());
                            switch (criterio) {
                                case 1 -> copia3.sort(Comparator.comparing(Estudiante::getNombre,String.CASE_INSENSITIVE_ORDER));
                                case 2 -> copia3.sort(Comparator.comparing(Estudiante::getEdad));
                                case 3 -> copia3.sort(Comparator.comparing(Estudiante::getEmail,String.CASE_INSENSITIVE_ORDER));
                                default -> System.out.println("Opción no válida");
                            }
                            System.out.printf("\nHay %d estudiantes en la lista: \n", copia3.size());
                            copia3.forEach(System.out::println);
                        }
                        default -> System.out.println("Opción no válida");
                    }
                }
                default -> System.out.println("Opción no válida");
            }
        }
    }
}