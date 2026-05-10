import java.util.Scanner;

public class Usuario {
    private String nombreUsuario;
    private String correo;
    private String contrasena;

    public Usuario() {
        nombreUsuario = "";
        correo = "";
        contrasena = "";
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        if (contrasena.length() >= 8) {
            this.contrasena = contrasena;
        } else {
            System.out.println("La contraseña debe tener al menos 8 caracteres.");
            this.contrasena = "";
        }
    }

    public void mostrarDatos() {
        System.out.println("Usuario: " + nombreUsuario);
        System.out.println("Correo: " + correo);
        System.out.println("Contraseña: No se muestra por seguridad");
        System.out.println("-----------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int MAX = 3;
        Usuario usuarios[] = new Usuario[MAX];

        String nombre;
        String correo;
        String contrasena;

        for (int i = 0; i < usuarios.length; i++) {
            usuarios[i] = new Usuario();

            System.out.println("Ingrese los datos del usuario " + (i + 1));

            System.out.print("Nombre de usuario: ");
            nombre = sc.nextLine();

            System.out.print("Correo: ");
            correo = sc.nextLine();

            do {
                System.out.print("Contraseña mínimo 8 caracteres: ");
                contrasena = sc.nextLine();

                usuarios[i].setContrasena(contrasena);

            } while (contrasena.length() < 8);

            usuarios[i].setNombreUsuario(nombre);
            usuarios[i].setCorreo(correo);

            System.out.println();
        }

        System.out.println("USUARIOS REGISTRADOS");
        System.out.println("-----------------------------------");

        for (int i = 0; i < usuarios.length; i++) {
            usuarios[i].mostrarDatos();
        }

        sc.close();
    }
}