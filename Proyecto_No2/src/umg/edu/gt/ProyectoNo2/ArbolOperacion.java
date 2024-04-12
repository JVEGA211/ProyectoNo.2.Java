package umg.edu.gt.ProyectoNo2;

public class ArbolOperacion {
    public Nodo raiz;

    public void CrearArbol(String expresion) {
        construirArbol(expresion);
    }

    private Nodo construirArbol(String expresion) {
        Nodo nodoPadre = null;
        Nodo nodoActual = null;

        for (int i = 0; i < expresion.length(); i++) {
            char caracter = expresion.charAt(i);

            if (caracter == '(') {
                if (nodoActual != null) {
                    nodoPadre = nodoActual;
                }
                nodoActual = null;
            } else if (caracter == ')') {
                nodoActual = nodoPadre;
                nodoPadre = (nodoPadre != null) ? nodoPadre.izquierdo : null;
            } else if (Character.isDigit(caracter)) {
                StringBuilder numero = new StringBuilder();
                while (i < expresion.length() && (Character.isDigit(expresion.charAt(i)) || expresion.charAt(i) == '.')) {
                    numero.append(expresion.charAt(i++));
                }
                i--;

                Nodo nuevo = new Nodo(Double.parseDouble(numero.toString()));

                if (nodoPadre == null) {
                    nodoActual = nuevo;
                } else if (nodoPadre.izquierdo == null) {
                    nodoPadre.izquierdo = nuevo;
                } else {
                    nodoPadre.derecho = nuevo;
                }
            } else if (esOperador(caracter)) {
                Nodo nuevo = new Nodo(caracter);

                if (nodoPadre == null) {
                    this.raiz = nuevo;
                } else {
                    nodoPadre.SetValor(caracter);
                }
            }

            // Imprimir el árbol después de cada inserción de nodo
            System.out.println("Árbol actual:");
            imprimirArbol(this.raiz);
        }

        return this.raiz;
    }

    private void imprimirArbol(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.GetValor() + " ");
            imprimirArbol(nodo.izquierdo);
            imprimirArbol(nodo.derecho);
        }
    }

    private boolean esOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

        public int evaluar() {
            return Evaluar(this.raiz);
        }

        private int Evaluar(Nodo t) {
            if (t == null) {
                return 0;
            }

            if (Character.isDigit(t.GetValor())) {
                return Character.getNumericValue(t.GetValor());
            }

            int A = Evaluar(t.izquierdo);
            int B = Evaluar(t.derecho);

            return Calcular(A, B, t.GetValor());
        }

        private int Calcular(int num1, int num2, char operador) {
            switch (operador) {
                case '*':
                    return num1 * num2;
                case '/':
                    return num1 / num2;
                case '+':
                    return num1 + num2;
                case '-':
                    return num1 - num2;
                case '^':
                    return (int) Math.pow(num1, num2);
                default:
                    return 0;
            }
        }
    }