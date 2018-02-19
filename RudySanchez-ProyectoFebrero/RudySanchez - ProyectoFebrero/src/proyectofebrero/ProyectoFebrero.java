package proyectofebrero;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProyectoFebrero {

    public static int dividir(Integer arr[], int bajo, int alto) { //Esta función ayuda al sort, coloca todos los número menor que el pivote a la izquierda y mayores a la derecha
        int pivote = arr[alto];
        int i = (bajo - 1); // posición de elementos menores
        for (int j = bajo; j < alto; j++) {
            if (arr[j] <= pivote) //Si arr[j] es menor o igual al pivote
            {
                i++; //incrementamos i
                int temp = arr[i];  // Swapeamos arr[i] con arr[j]
                arr[i] = arr[j];    // Swapeamos arr[i] con arr[j]
                arr[j] = temp;      // Swapeamos arr[i] con arr[j]
            }
        }
        int temp = arr[i + 1];   // Swapeamos arr[i] con pivote
        arr[i + 1] = arr[alto];  // Swapeamos arr[i] con pivote
        arr[alto] = temp;        // Swapeamos arr[i] con pivote

        return i + 1;
    }

    public static void sort(Integer arr[], int bajo, int alto) { //QuickSort
        if (bajo < alto) {
            int pi = dividir(arr, bajo, alto);  //Pi es el pivote, arr[i] regresa en su posición final
            sort(arr, bajo, pi - 1);            //Recursivamente ordenamos los elementos antes del pivote
            sort(arr, pi + 1, alto);            //Recursivamente ordenamos los elementos despues del pivote
        }
    }

    static void printArray(Integer arr[], PrintWriter writer) { //Esta función imprime el array ordenado en un nuevo archivo
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            writer.println(arr[i]);
        }

    }

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        System.out.println("Rudy Sánchez, 15010016");
        System.out.println("Estructura de Datos y Algoritmos 2018");
        System.out.println("Proyecto #1 - Aplicación de ordenamiento de un array extraido de un archivo externo.");
        System.out.println("Ingrese la ruta del archivo. (Por ejemlo C:\\Users\\usuario\\Documents\\archivo.txt)"); //POedimos ruta
        Scanner scan = new Scanner(System.in);
        String ruta = scan.nextLine();  //Leemos lo que el usuario ingreso como ruta
        File archivo = new File(ruta); //Declaramos nuestro archivo
        ArrayList<Integer> numeros = new ArrayList<Integer>(); //Array donde guardamos numeros
        int cont = -1;                  //Inicializamos el contador en -1 para que en la primera vuelta sea 0
        if (!archivo.exists()) { //Si el archivo no existe le dejamos saber al usuario, de lo contrario continuamos con el programa
            System.out.println("No se ha encontrado el archivo en " + ruta);
        } else {
            Scanner input = new Scanner(archivo); //Usamos la clase Scanner para leer el archivo linea por linea 
            while (input.hasNextLine()) {         //Mientras el archivo tenga una siguiente linea entra al ciclo
                String linea = input.nextLine();  //Guardamos la linea actual en la variable "linea"
                cont++;
                numeros.add(Integer.parseInt(linea)); //Guardamos la linea actual en el array
            }
            Integer[] vnumeros = numeros.toArray(new Integer[numeros.size()]);
            input.close(); //Cerramos el archivo que leimos
            int n = vnumeros.length;  //Guardamos la cantidad de elementos en el array
            sort(vnumeros, 0, n - 1);  // Llamamos a nuestra función
            PrintWriter writer = new PrintWriter("archivoOrdenado.txt", "UTF-8");
            printArray(vnumeros, writer); //Llamamos a la función que escribe el nuevoi archivo
            writer.close(); //Cerramos el archivo que imprimimos
            System.out.println("Se ha guardado un archivo en la carpeta del proyecto que se llama archivoOrdenado.txt");
        }

    }

}
