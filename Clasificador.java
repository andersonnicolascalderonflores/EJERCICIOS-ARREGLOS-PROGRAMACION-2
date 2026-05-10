import java.util.Scanner;

public class Clasificador {
    private double valorEntrada;
    private double umbral;
    private String resultado;

    public Clasificador(double valorEntrada, double umbral) {
        this.valorEntrada = valorEntrada;
        this.umbral = umbral;
        this.resultado = "";
    }

    public double getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(double valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public double getUmbral() {
        return umbral;
    }

    public void setUmbral(double umbral) {
        this.umbral = umbral;
    }

    public String getResultado() {
        return resultado;
    }

    public void evaluar() {
        if (valorEntrada >= umbral) {
            resultado = "POSITIVO";
        } else {
            resultado = "NEGATIVO";
        }
    }

    public void mostrarResultado() {
        System.out.println("Valor de entrada: " + valorEntrada);
        System.out.println("Umbral: " + umbral);
        System.out.println("Resultado: " + resultado);
        System.out.println("-----------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int MAX = 4;
        Clasificador clasificadores[] = new Clasificador[MAX];

        int cantidad;
        double valor;
        double umbral;

        do {
            System.out.print("¿Cuántos valores desea clasificar? Máximo " + MAX + ": ");
            cantidad = leerEntero(sc);

            if (cantidad <= 0 || cantidad > clasificadores.length) {
                System.out.println("Cantidad inválida.");
            }

        } while (cantidad <= 0 || cantidad > clasificadores.length);

        for (int i = 0; i < cantidad; i++) {
            System.out.println("Clasificación " + (i + 1));

            System.out.print("Valor de entrada: ");
            valor = leerDouble(sc);

            System.out.print("Umbral: ");
            umbral = leerDouble(sc);

            clasificadores[i] = new Clasificador(valor, umbral);
            clasificadores[i].evaluar();

            System.out.println();
        }

        System.out.println("RESULTADOS");
        System.out.println("-----------------------------------");

        for (int i = 0; i < cantidad; i++) {
            clasificadores[i].mostrarResultado();
        }

        sc.close();
    }

    public static int leerEntero(Scanner sc) {
        int numero = 0;
        boolean valido = false;

        while (!valido) {
            try {
                numero = Integer.parseInt(sc.nextLine());
                valido = true;
            } catch (Exception e) {
                System.out.print("Ingrese un número válido: ");
            }
        }

        return numero;
    }

    public static double leerDouble(Scanner sc) {
        double numero = 0;
        boolean valido = false;

        while (!valido) {
            try {
                numero = Double.parseDouble(sc.nextLine());
                valido = true;
            } catch (Exception e) {
                System.out.print("Ingrese un número válido: ");
            }
        }

        return numero;
    }
}