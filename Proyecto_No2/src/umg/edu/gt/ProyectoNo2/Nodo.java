package umg.edu.gt.ProyectoNo2;

public class Nodo {
    private double DblValor;
    public Nodo izquierdo;
    public Nodo derecho;

    public Nodo(double DblResultado) {
        this.DblValor = DblResultado;
        this.izquierdo = this.derecho = null;
    }

    public char GetValor() {
        return (char) DblValor;
    }

    public void SetValor(char valor) {
        this.DblValor = valor;
    }
}
/*        char[] caracteres = StrOperacion.toCharArray();
        Stack<Nodo> pila = new Stack<>();
        Nodo raiz = null;
        Nodo nodoActual = null;
        
        for (char c : caracteres) {
            if (c == '(') {
                // Comenzar una nueva expresión, crear un nuevo nodo
                Nodo nuevoNodo = new Nodo(c);
                if (nodoActual != null) {
                    if (nodoActual.izquierdo == null) {
                        nodoActual.izquierdo = nuevoNodo;
                    } else {
                        nodoActual.derecho = nuevoNodo;
                    }
                }
                pila.push(nodoActual);
                nodoActual = nuevoNodo;
            } else if (c == ')') {
                // Terminar la expresión, ir al padre del nodo actual
                if (pila.isEmpty()) {
                    throw new IllegalArgumentException("Expresión matemática mal formada: paréntesis de cierre sin correspondiente paréntesis de apertura.");
                } else {
                    nodoActual = pila.pop();
                }
            } else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
                // Operador, crear un nuevo nodo para el operador y asignarlo al nodo actual
                Nodo nuevoNodo = new Nodo(c);
                if (nodoActual == null) {
                    throw new IllegalArgumentException("Expresión matemática mal formada: operador sin operandos.");
                }
                nuevoNodo.izquierdo = nodoActual;
                nodoActual = nuevoNodo;
            } else {
                // Operando, asignarlo al nodo actual
                Nodo nuevoNodo = new Nodo(c);
                if (nodoActual != null) {
                    if (nodoActual.izquierdo == null) {
                        nodoActual.izquierdo = nuevoNodo;
                    } else {
                        nodoActual.derecho = nuevoNodo;
                    }
                } else {
                    nodoActual = nuevoNodo;
                }
            }
        }*/
