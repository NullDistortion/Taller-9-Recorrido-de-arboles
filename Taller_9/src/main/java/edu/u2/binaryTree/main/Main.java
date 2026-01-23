package edu.u2.binaryTree.main;

import edu.u2.binaryTree.model.BinaryTree;
import edu.u2.binaryTree.reader.Reader;
import edu.u2.binaryTree.route.Inorden;
import edu.u2.binaryTree.route.PorNiveles;
import edu.u2.binaryTree.route.Posorden;
import edu.u2.binaryTree.route.Preorden;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Reader reader = new Reader();
        Scanner sc = new Scanner(System.in);
        BinaryTree tree = null;

        System.out.println("=== SISTEMA DE RECORRIDO DE ÁRBOLES ===");

        boolean exitProgram = false;
        while (!exitProgram) {

            if (tree == null) {
                File selectedFile = reader.selectFile();

                if (selectedFile == null) {
                    System.out.println("Saliendo del programa");
                    exitProgram = true;
                    continue;
                }

                tree = reader.readTree(selectedFile);
                System.out.println(">> Árbol cargado desde: " + selectedFile.getName());
            }

            System.out.println("\n--- Menú de Operaciones ---");
            System.out.println("1. Recorrido Preorden");
            System.out.println("2. Recorrido Inorden");
            System.out.println("3. Recorrido Posorden");
            System.out.println("4. Recorrido Por Niveles");
            System.out.println("5. Cargar otro archivo");
            System.out.println("0. Salir");
            System.out.print("Seleccione opción: ");

            String option = sc.nextLine();

            switch (option) {
                case "1":
                    System.out.print("Resultado Preorden: ");
                    new Preorden().traverse(tree.getRoot());
                    System.out.println();
                    break;
                case "2":
                    System.out.print("Resultado Inorden: ");
                    new Inorden().traverse(tree.getRoot());
                    System.out.println();
                    break;
                case "3":
                    System.out.print("Resultado Posorden: ");
                    new Posorden().traverse(tree.getRoot());
                    System.out.println();
                    break;
                case "4":
                    System.out.print("Resultado Por Niveles: ");
                    new PorNiveles().traverse(tree.getRoot());
                    System.out.println();
                    break;
                case "5":
                    tree = null;
                    break;
                case "0":
                    exitProgram = true;
                    System.out.println("Fin del programa.");
                    break;
                default:
                    System.out.println("Opción no reconocida.");
            }
        }
    }
}