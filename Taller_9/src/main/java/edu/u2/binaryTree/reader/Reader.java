package edu.u2.binaryTree.reader;

import edu.u2.binaryTree.model.BinaryTree;
import edu.u2.binaryTree.model.Node;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Reader {

    private final String RESOURCES_PATH = "src/main/resources";

    public File selectFile() {
        File folder = new File(RESOURCES_PATH);
        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Error crítico: Carpeta resources no encontrada.");
            return null;
        }

        File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));

        if (files == null || files.length == 0) {
            System.out.println("No hay archivos .txt disponibles para cargar.");
            return null;
        }

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Seleccione un archivo de datos ---");
            for (int i = 0; i < files.length; i++) {
                System.out.println((i + 1) + ". " + files[i].getName());
            }
            System.out.println("0. Salir del programa");
            System.out.print("Opción: ");

            try {
                String input = sc.nextLine();
                int choice = Integer.parseInt(input);

                if (choice == 0) {
                    return null;
                }

                if (choice > 0 && choice <= files.length) {
                    return files[choice - 1];
                } else {
                    System.out.println("Opcion fuera de rango. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Entrada no válida. Por favor ingrese un número.");
            }
        }
    }

    public BinaryTree readTree(File file) {
        BinaryTree tree = new BinaryTree();
        Map<Integer, Node> nodeMap = new HashMap<>();
        Map<Integer, int[]> relationsMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                if (isFirstLine && !line.contains(";")) {
                    isFirstLine = false;
                    continue;
                }

                String[] parts = line.split(";");
                if (parts.length < 4) continue;

                int id = Integer.parseInt(parts[0]);
                int value = Integer.parseInt(parts[1]);
                int leftId = Integer.parseInt(parts[2]);
                int rightId = Integer.parseInt(parts[3]);

                Node node = new Node(id, value);
                nodeMap.put(id, node);
                relationsMap.put(id, new int[]{leftId, rightId});
            }

            for (Map.Entry<Integer, Node> entry : nodeMap.entrySet()) {
                int nodeId = entry.getKey();
                Node currentNode = entry.getValue();
                int[] childrenIds = relationsMap.get(nodeId);

                for (int i = 0; i < childrenIds.length; i++) {
                    int childId = childrenIds[i];

                    if (childId != -1 && nodeMap.containsKey(childId)) {
                        Node childNode = nodeMap.get(childId);

                        switch (i) {
                            case 0:
                                currentNode.setLeft(childNode);
                                break;
                            case 1:
                                currentNode.setRight(childNode);
                                break;
                            default:
                                break;
                        }
                    }
                }
            }

            if (nodeMap.containsKey(0)) {
                tree.setRoot(nodeMap.get(0));
            } else if (!nodeMap.isEmpty()) {
                tree.setRoot(nodeMap.values().iterator().next());
            }

        } catch (IOException e) {
            System.err.println("Error de I/O: " + e.getMessage());
        }

        return tree;
    }
}