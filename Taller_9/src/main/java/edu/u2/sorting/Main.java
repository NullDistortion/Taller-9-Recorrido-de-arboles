package main.java.edu.u2.sorting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// OJO: Se eliminó 'import javax.swing.tree.TreeNode;' porque causaba el conflicto.

public class Main {

    // Usará automáticamente tu clase TreeNode del mismo paquete
    static Map<Integer, TreeNode> mapaNodos = new HashMap<>();

    public static void main(String[] args) {
        // Asegúrate de que el archivo esté en la raíz del proyecto (al nivel de la carpeta src)
        String nombreArchivo = "arbol_10_nodos.txt";

        ArbolBinario arbol = new ArbolBinario();

        try {
            // 1. Construir los nodos leyendo el archivo
            TreeNode raizConstruida = construirArbolDesdeTxt(nombreArchivo);

            // 2. Asignar la raíz al árbol (Ya no necesita casteo)
            arbol.setRoot(raizConstruida);

            System.out.println("--- Árbol cargado desde " + nombreArchivo + " ---");

            // 3. Ejecutar TU recorrido
            System.out.println("Recorrido Inorden (Izquierda - Raíz - Derecha):");
            arbol.inOrden();

        } catch (IOException e) {
            System.err.println("Error: No se pudo leer el archivo. Verifica la ruta.");
            System.err.println("Detalles: " + e.getMessage());
        }
    }

    // --- LÓGICA DE LECTURA DE ARCHIVO ---
    public static TreeNode construirArbolDesdeTxt(String ruta) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(ruta));
        String linea;

        // Leer cantidad de nodos (primera línea)
        String primeraLinea = br.readLine();
        if (primeraLinea == null) return null;

        // Leer el resto de líneas
        while ((linea = br.readLine()) != null) {
            // Ejemplo: 0;50;1;2
            String[] partes = linea.split(";");

            int id = Integer.parseInt(partes[0]);
            int valor = Integer.parseInt(partes[1]);
            int idIzq = Integer.parseInt(partes[2]);
            int idDer = Integer.parseInt(partes[3]);

            // Crear o recuperar nodo actual y asignar valor
            TreeNode nodoActual = obtenerNodo(id);
            nodoActual.value = valor;

            // Conectar hijos
            if (idIzq != -1) {
                nodoActual.left = obtenerNodo(idIzq);
            }
            if (idDer != -1) {
                nodoActual.right = obtenerNodo(idDer);
            }
        }
        br.close();

        // Retornamos el nodo con ID 0 como raíz
        return mapaNodos.get(0);
    }

    private static TreeNode obtenerNodo(int id) {
        // Si no existe en el mapa, lo creamos y guardamos
        if (!mapaNodos.containsKey(id)) {
            mapaNodos.put(id, new TreeNode(id, 0)); // Valor provisional 0
        }
        return mapaNodos.get(id);
    }
}