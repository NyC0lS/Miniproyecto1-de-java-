
package Veterinaria;
// Clase hija gatos
public class Gato extends Animal {
    // Atributo específico
    private String color;

    // Constructor
    public Gato(String nombre, int vacunas, double costo, String pais, String color) {
        super(nombre, vacunas, costo, pais); // Llamada al constructor de la clase madre
        this.color = color;
    }

    // Método getter y setter
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

     // Método para mostrar la información del gato
     @Override
     public void mostrarInfo() {
         System.out.println("Nombre: " + getNombre());
         System.out.println("Vacunas: " + getVacunas());
         System.out.println("Costo: " + getCosto());
         System.out.println("País: " + getPais());
         System.out.println("Color: " + getColor());
         System.out.println();
     }
}

    
}
