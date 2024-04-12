package umg.edu.gt.ProyectoNo2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArbolOperacion arbol = new ArbolOperacion();

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Ingrese la expresión matemática: ");
            String StrExpresion = scanner.nextLine();

            arbol.CrearArbol(StrExpresion);

            System.out.print("Recorrido PreOrden: ");
            Pre_Orden(arbol.raiz);
            System.out.println();

            System.out.print("Recorrido InOrden: ");
            In_Orden(arbol.raiz);
            System.out.println();

            System.out.print("Recorrido PostOrden: ");
            Post_Orden(arbol.raiz);
            System.out.println();

            int resultado = arbol.evaluar();
            System.out.println("El resultado de la expresión es: " + resultado);
        } finally {
            scanner.close();
        }
    }
    

    private static void Pre_Orden(Nodo nodo) {
        if (nodo != null) {
            if (!EsParentesis(nodo.GetValor())) {
                System.out.print(nodo.GetValor() + " ");
            }
            Pre_Orden(nodo.izquierdo);
            Pre_Orden(nodo.derecho);
        }
    }

    private static void In_Orden(Nodo nodo) {
        if (nodo != null) {
            In_Orden(nodo.izquierdo);
            if (!EsParentesis(nodo.GetValor())) {
                System.out.print(nodo.GetValor() + " ");
            }
            In_Orden(nodo.derecho);
        }
    }

    private static void Post_Orden(Nodo APNodo) {
        if (APNodo != null) {
            Post_Orden(APNodo.izquierdo);
            Post_Orden(APNodo.derecho);
            if (!EsParentesis(APNodo.GetValor())) {
                System.out.print(APNodo.GetValor() + " ");
            }
        }
    }

    private static boolean EsParentesis(char c) {
        return c == '(' || c == ')';
    }
}
