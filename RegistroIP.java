import java.util.Scanner;

public class RegistroIP {
    private String direccionIP;
    private String horaAcceso;
    private boolean permitida;

    public RegistroIP(String direccionIP, String horaAcceso, boolean permitida) {
        this.direccionIP = direccionIP;
        this.horaAcceso = horaAcceso;
        this.permitida = permitida;
    }

    public String getDireccionIP() {
        return direccionIP;
    }

    public void setDireccionIP(String direccionIP) {
        this.direccionIP = direccionIP;
    }

    public String getHoraAcceso() {
        return horaAcceso;
    }

    public void setHoraAcceso(String horaAcceso) {
        this.horaAcceso = horaAcceso;
    }

    public boolean getPermitida() {
        return permitida;
    }

    public void setPermitida(boolean permitida) {
        this.permitida = permitida;
    }

    public void mostrarEstado() {
        System.out.println("Dirección IP: " + direccionIP);
        System.out.println("Hora de acceso: " + horaAcceso);

        if (permitida) {
            System.out.println("Acceso permitido");
        } else {
            System.out.println("Acceso denegado");
        }

        System.out.println("-----------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int MAX = 5;
        RegistroIP registros[] = new RegistroIP[MAX];

        int cantidad;
        String ip;
        String hora;
        String respuesta;
        boolean permitida;

        do {
            System.out.print("¿Cuántos registros desea ingresar? Máximo " + MAX + ": ");
            cantidad = leerEntero(sc);

            if (cantidad <= 0 || cantidad > registros.length) {
                System.out.println("Cantidad inválida.");
            }

        } while (cantidad <= 0 || cantidad > registros.length);

        for (int i = 0; i < cantidad; i++) {
            System.out.println("Registro " + (i + 1));

            System.out.print("Dirección IP: ");
            ip = sc.nextLine();

            System.out.print("Hora de acceso: ");
            hora = sc.nextLine();

            System.out.print("¿Acceso permitido? si/no: ");
            respuesta = sc.nextLine();

            permitida = respuesta.equalsIgnoreCase("si");

            registros[i] = new RegistroIP(ip, hora, permitida);

            System.out.println();
        }

        System.out.println("REGISTROS DE IP");
        System.out.println("-----------------------------------");

        for (int i = 0; i < cantidad; i++) {
            registros[i].mostrarEstado();
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
}