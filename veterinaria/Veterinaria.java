package veterinaria;

import java.util.ArrayList; // Importar la clase ArrayList para manejar listas dinámicas
import java.util.Scanner; // Importar la clase Scanner para leer datos del teclado

public class Veterinaria {

   // Atributo para almacenar los animales en una lista
   private ArrayList<Animal> listaAnimales;

   // Constructor
   public Veterinaria() {
       listaAnimales = new ArrayList<>(); // Inicializar la lista vacía
   }

   // Método para agregar un animal a la lista
   public void agregarAnimal(Animal animal) {
       listaAnimales.add(animal); // Añadir el animal al final de la lista
       System.out.println("Animal agregado con éxito.");
   }
    // Método para agregar una mascota
    public void agregarMascota() {
        Scanner sc = new Scanner(System.in); // Crear un objeto Scanner para leer la entrada del usuario
        System.out.println("Ingrese el nombre de la mascota:");
        String nombre = sc.nextLine(); // Leer el nombre de la mascota
        System.out.println("Ingrese el tipo de animal (perro o gato):");
        String tipo = sc.nextLine(); // Leer el tipo de animal
        System.out.println("Ingrese el país de origen:");
        String pais = sc.nextLine(); // Leer el país de origen
        System.out.println("Ingrese el costo de la mascota:");
        double costo = sc.nextDouble(); // Leer el costo de la mascota
        System.out.println("Ingrese si tiene la vacuna malota (S/N):");
        char vacuna = sc.next().charAt(0); // Leer si tiene la vacuna malota
        boolean tieneVacuna = vacuna == 'S' || vacuna == 's'; // Convertir el caracter a un valor booleano
        Animal animal; // Declarar una variable de tipo Animal
        if (tipo.equalsIgnoreCase("perro")) { // Si el tipo es perro
            System.out.println("Ingrese la raza del perro:");
            String raza = sc.next(); // Leer la raza del perro
            animal = new Perro(nombre, tieneVacuna,costo, pais,  raza); // Crear un objeto Perro con los datos ingresados
            //animal = new Perro(nombre, vacunas, costo, pais, raza); // Crear un objeto Perro con los datos ingresados


        } else if (tipo.equalsIgnoreCase("gato")) { // Si el tipo es gato
            System.out.println("Ingrese el color del gato:");
            String color = sc.next(); // Leer el color del gato
            animal = new Gato(nombre, tieneVacuna,costo, pais, color); // Crear un objeto Gato con los datos ingresados
            //animal = new Gato(nombre, vacunas, costo, pais, color); // Crear un objeto Gato con los datos ingresados
        } else { // Si el tipo no es válido
            System.out.println("Tipo de animal inválido");
            return; // Terminar la función sin agregar nada a la lista
        }
        agregarAnimal(animal); // Llamar al método de la clase Veterinaria para agregar el animal a la lista
    }
    
   // Método para buscar un animal por su nombre en la lista
   public Animal buscarAnimal(String nombre) {
       for (Animal animal : listaAnimales) { // Recorrer la lista usando un bucle for-each
           if (animal.getNombre().equals(nombre)) { // Comparar el nombre del animal con el buscado
               return animal;
            }
        }
        return null; // Si no se encuentra el animal, devolver null
    }
 
    // Método para actualizar un animal de la lista
    public void actualizarAnimal(String nombre) {
        Animal animal = buscarAnimal(nombre); // Buscar el animal por su nombre
        if (animal != null) { // Si se encontró el animal
            Scanner sc = new Scanner(System.in); // Crear un objeto Scanner para leer datos del teclado
            System.out.println("Ingrese el nuevo nombre: ");
            String nuevoNombre = sc.nextLine(); // Leer el nuevo nombre
            System.out.println("Ingrese si tiene la vacuna malota (S/N):");
            char vacuna = sc.next().charAt(0); // Leer si tiene la vacuna malota
            boolean tieneVacuna = vacuna == 'S' || vacuna == 's'; // Convertir el caracter a un valor booleano
            System.out.println("Ingrese el nuevo costo: ");
            double nuevoCosto = sc.nextDouble(); // Leer el nuevo costo
            System.out.println("Ingrese el nuevo país: ");
            sc.nextLine(); // Limpiar el búfer de entrada
            String nuevoPais = sc.nextLine(); // Leer el nuevo país
            animal.setNombre(nuevoNombre); // Actualizar el nombre del animal
            animal.setVacunasMalota(tieneVacuna); // Actualizar las vacunas del animal
            animal.setCosto(nuevoCosto); // Actualizar el costo del animal
            animal.setPais(nuevoPais); // Actualizar el país del animal
            if (animal instanceof Perro) { // Si el animal es un perro
                Perro perro = (Perro) animal; // Hacer un casting a Perro
                System.out.println("Ingrese la nueva raza: ");
                String nuevaRaza = sc.nextLine(); // Leer la nueva raza
                perro.setRaza(nuevaRaza); // Actualizar la raza del perro
            } else if (animal instanceof Gato) { // Si el animal es un gato
                Gato gato = (Gato) animal; // Hacer un casting a Gato
                System.out.println("Ingrese el nuevo color: ");
                String nuevoColor = sc.nextLine(); // Leer el nuevo color
                gato.setColor(nuevoColor); // Actualizar el color del gato
            }
            System.out.println("Animal actualizado con éxito.");
        } else { // Si no se encontró el animal
            System.out.println("No se encontró ningún animal con ese nombre.");
        }
    }
 
    // Método para eliminar un animal de la lista
    public void eliminarAnimal(String nombre) {
        Animal animal = buscarAnimal(nombre); // Buscar el animal por su nombre
        if (animal != null) { // Si se encontró el animal
            listaAnimales.remove(animal); // Eliminar el animal de la lista
            System.out.println("Animal eliminado con éxito.");
        } else { // Si no se encontró el animal
            System.out.println("No se encontró ningún animal con ese nombre.");
        }
    }
 
    // Método para listar todos los animales de la lista
    public void listarAnimales() {
        if (listaAnimales.isEmpty()) { // Si la lista está vacía
            System.out.println("No hay animales registrados.");
        } else { // Si la lista no está vacía
            for (Animal animal : listaAnimales) { // Recorrer la lista usando un bucle for-each
                System.out.println(animal.mostrarInfo()); // Mostrar la información de cada animal usando el método polimórfico mostrarInfo()
            }
        }
    }
    // Método para mostrar el menú principal
    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 6) {
            System.out.println("Bienvenido a la veterinaria");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar mascota");
            System.out.println("2. Actualizar mascota");
            System.out.println("3. Eliminar mascota");
            System.out.println("4. Buscar mascota por nombre");
            System.out.println("5. Listar todas las mascotas");
            System.out.println("6. Salir");
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
                    Animal animal_aBuscar= buscarAnimal(nombreBuscar);
                    System.out.println(animal_aBuscar.mostrarInfo());
                    break;
                case 5:
                    listarAnimales();
                    break;
                case 6:
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
/*
import java.util.ArrayList;
import java.util.Scanner;


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
*/