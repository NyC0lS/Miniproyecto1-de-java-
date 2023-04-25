package veterinaria;

import veterinaria.Animal; 
import veterinaria.Perro; 
import veterinaria.Gato;

public class Veterinaria {
    private ArrayList<Animal> listaAnimales;

    public Veterinaria() {
        listaAnimales = new ArrayList<>();
    }

    public void agregarMascota() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el tipo de mascota (perro o gato):");
        String tipo = sc.nextLine();
        System.out.println("Ingrese el nombre de la mascota:");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el número de vacunas de la mascota:");
        int numVacunas = sc.nextInt();
        // Crear un arreglo de strings para las vacunas
        String[] vacunas = new String[numVacunas];
        // Pedir al usuario que ingrese cada vacuna
        for (int i = 0; i < numVacunas; i++) {
            System.out.println("Ingrese la vacuna " + (i + 1) + ":");
            sc.nextLine();
            vacunas[i] = sc.nextLine();
        }
        System.out.println("Ingrese el costo de la mascota:");
        double costo = sc.nextDouble();
        System.out.println("Ingrese el país de origen de la mascota:");
        sc.nextLine();
        String pais = sc.nextLine();
        Animal animal;
        if (tipo.equals("perro")) {
            System.out.println("Ingrese la raza del perro:");
            String raza = sc.nextLine();
            animal = new Perro(nombre, vacunas, costo, pais, raza); // Crear un objeto Perro con los datos ingresados
        } else if (tipo.equals("gato")) {
            System.out.println("Ingrese el color del gato:");
            String color = sc.nextLine();
            animal = new Gato(nombre, vacunas, costo, pais, color); // Crear un objeto Gato con los datos ingresados
        } else {
            System.out.println("Tipo de mascota inválido");
            return;
        }
        listaAnimales.add(animal); // Agregar el objeto animal a la lista
        System.out.println("Mascota agregada con éxito");
    }

    public void actualizarAnimal(String nombre) {
        Animal animal = buscarAnimal(nombre);
        if (animal != null) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese el nuevo nombre: ");
            String nuevoNombre = sc.nextLine();
            System.out.println("Ingrese el nuevo número de vacunas: ");
            int numVacunas = sc.nextInt();
            // Crear un arreglo de strings para las vacunas
            String[] nuevasVacunas = new String[numVacunas];
            // Pedir al usuario que ingrese cada vacuna
            for (int i = 0; i < numVacunas; i++) {
                System.out.println("Ingrese la vacuna " + (i + 1) + ":");
                sc.nextLine();
                nuevasVacunas[i] = sc.nextLine();
            }
            System.out.println("Ingrese el nuevo costo: ");
            double nuevoCosto = sc.nextDouble();
            System.out.println("Ingrese el nuevo país: ");
            sc.nextLine();
            String nuevoPais = sc.nextLine();
            animal.setNombre(nuevoNombre);
            animal.setVacunas(nuevasVacunas);
            animal.setCosto(nuevoCosto);
            animal.setPais(nuevoPais);
            if (animal instanceof Perro) {
                Perro perro = (Perro) animal;
                System.out.println("Ingrese la nueva raza: ");
                String nuevaRaza = sc.nextLine();
                perro.setRaza(nuevaRaza);
            } else if (animal instanceof Gato) {
                Gato gato = (Gato) animal;
                System.out.println("Ingrese el nuevo color: ");
                String nuevoColor = sc.nextLine();
                gato.setColor(nuevoColor);
            }
            System.out.println("Animal actualizado con éxito.");
        } else {
            System.out.println("No se encontró ningún animal con ese nombre.");
        }
    }

    public void eliminarAnimal(String nombre) {
        Animal animal = buscarAnimal(nombre);
        if (animal != null) {
            listaAnimales.remove(animal);
            System.out.println("Animal eliminado con éxito.");
        } else {
            System.out.println("No se encontró ningún animal con ese nombre.");
        }
    }

    public Animal buscarAnimal(String nombre) {
        for (Animal animal : listaAnimales) {
            if (animal.getNombre().equals(nombre)) {
                return animal;
            }
        }
        return null;
    }

    public void listarAnimales() {
        if (listaAnimales.isEmpty()) {
            System.out.println("No hay animales registrados.");
        } else {
            for (Animal animal : listaAnimales) {
                animal.mostrarInfo();
            }
        }
    }

    public void verificarVacunaMalota(String nombre) {
        Animal animal = buscarAnimal(nombre);
        if (animal != null) {
            if (animal instanceof Perro) {
                Perro perro = (Perro) animal;
                if (perro.tieneVacunaMalota()) {
                    System.out.println("El perro " + nombre + " tiene la vacuna malota.");
                } else {
                    System.out.println("El perro " + nombre + " no tiene la vacuna malota.");
                }
            } else {
                System.out.println("La vacuna malota solo aplica para los perros.");
            }
        } else {
            System.out.println("No se encontró ningún animal con ese nombre.");
        }
    }

    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 7) {
            System.out.println("Bienvenido a la veterinaria");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar mascota");
            System.out.println("2. Actualizar mascota");
            System.out.println("3. Eliminar mascota");
            System.out.println("4. Buscar mascota por nombre");
            System.out.println("5. Listar todas las mascotas");
            System.out.println("6. Verificar si una mascota tiene la vacuna malota");
            System.out.println("7. Salir");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    agregarMascota();
                    break;
                case 2:
                    // Pide al usuario el nombre del animal a actualizar
                    System.out.println("Ingrese el nombre del animal a actualizar:");
                    sc.nextLine();
                    String nombreActualizar = sc.nextLine();
                    // Llama al método actualizarAnimal() con el nombre como parámetro
                    actualizarAnimal(nombreActualizar);
                    break;
                case 3:
                    // Pide al usuario el nombre del animal a eliminar
                    System.out.println("Ingrese el nombre del animal a eliminar:");
                    sc.nextLine();
                    String nombreEliminar = sc.nextLine();
                    // Llama al método eliminarAnimal() con el nombre como parámetro
                    eliminarAnimal(nombreEliminar);
                    break;
                case 4:
                    // Pide al usuario el nombre del animal a buscar
                    System.out.println("Ingrese el nombre del animal a buscar:");
                    sc.nextLine();
                    String nombreBuscar = sc.nextLine();
                    // Llama al método buscarAnimal() con el nombre como parámetro
                    Animal animal = buscarAnimal(nombreBuscar);
                    // Si se encontró el animal, muestra su información
                    if (animal != null) {
                        animal.mostrarInfo();
                    } else {
                        // Si no se encontró el animal, muestra un mensaje
                        System.out.println("No se encontró ningún animal con ese nombre.");
                    }
                    break;
                case 5:
                    listarAnimales();
                    break;
                case 6:
                    // Pide al usuario el nombre de la mascota a verificar
                    System.out.println("Ingrese el nombre de la mascota a verificar:");
                    sc.nextLine();
                    String nombreVerificar = sc.nextLine();
                    // Llama al método verificarVacunaMalota() con el nombre como parámetro
                    verificarVacunaMalota(nombreVerificar);
                    break;
                case 7:
                    System.out.println("Gracias por usar la veterinaria");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
        // Cierra el objeto Scanner
        sc.close();
    }
}