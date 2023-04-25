
package Veterinaria;
// Clase madre animales
public abstract class Animal {
    // Atributos comunes
    private String nombre;
    private String[] vacunas;
    private double costo;
    private String pais;

    // Constructor
    public Animal(String nombre, string[] vacunas, double costo, String pais) {
        this.nombre = nombre;
        this.vacunas = vacunas; // Declarar un arreglo de strings para las vacunas
        this.costo = costo;
        this.pais = pais;
    }

    // Métodos getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    public String[] getVacunas() {
        // Retornar el arreglo de vacunas
        return vacunas;
    }
    
    public void setVacunas(String[] vacunas) {
        // Asignar el arreglo de vacunas
        this.vacunas = vacunas;
    }
    
    public void agregarVacuna(String vacuna) {
        // Crear un nuevo arreglo con un elemento más que el original
        String[] nuevoArreglo = new String[vacunas.length + 1];
    
        // Copiar los elementos del arreglo original al nuevo arreglo
        for (int i = 0; i < vacunas.length; i++) {
            nuevoArreglo[i] = vacunas[i];
        }
    
        // Agregar la nueva vacuna al final del nuevo arreglo
        nuevoArreglo[vacunas.length] = vacuna;
    
        // Asignar el nuevo arreglo al atributo vacunas
        vacunas = nuevoArreglo;
    }
    
    public void eliminarVacuna(String vacuna) {
        // Buscar el índice de la vacuna a eliminar
        int indice = -1;
        for (int i = 0; i < vacunas.length; i++) {
            if (vacunas[i].equals(vacuna)) {
                indice = i;
                break;
            }
        }
    
        // Si se encontró la vacuna a eliminar
        if (indice != -1) {
            // Crear un nuevo arreglo con un elemento menos que el original
            String[] nuevoArreglo = new String[vacunas.length - 1];
    
            // Copiar los elementos del arreglo original al nuevo arreglo, saltando el elemento a eliminar
            for (int i = 0; i < indice; i++) {
                nuevoArreglo[i] = vacunas[i];
            }
            for (int i = indice + 1; i < vacunas.length; i++) {
                nuevoArreglo[i - 1] = vacunas[i];
            }
    
            // Asignar el nuevo arreglo al atributo vacunas
            vacunas = nuevoArreglo;
        }
    }
    // Método abstracto para mostrar la información del animal
    public abstract void mostrarInfo();
} 
