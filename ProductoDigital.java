import java.util.Scanner;

public class ProductoDigital {
    private String nombre;
    private double precio;
    private int stock;

    public ProductoDigital(String nombre, double precio, int stock) {
        this.nombre = nombre;
        setPrecio(precio);
        setStock(stock);
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio > 0) {
            this.precio = precio;
        } else {
            System.out.println("El precio debe ser positivo.");
            this.precio = 0;
        }
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock > 0) {
            this.stock = stock;
        } else {
            System.out.println("El stock debe ser positivo.");
            this.stock = 0;
        }
    }

    public void mostrarInfo() {
        System.out.println("Producto: " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Stock: " + stock);
        System.out.println("-----------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int MAX = 3;
        ProductoDigital productos[] = new ProductoDigital[MAX];

        int indice = 0;
        int opcion;
        int posicion;
        String nombre;
        double precio;
        int stock;

        do {
            System.out.println("PRODUCTOS DIGITALES");
            System.out.println("1. Registrar producto");
            System.out.println("2. Cambiar precio de un producto");
            System.out.println("3. Cambiar stock de un producto");
            System.out.println("4. Mostrar producto específico");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = leerEntero(sc);

            switch (opcion) {
                case 1:
                    if (indice < productos.length) {
                        System.out.print("Nombre del producto: ");
                        nombre = sc.nextLine();

                        do {
                            System.out.print("Precio: ");
                            precio = leerDouble(sc);
                        } while (precio <= 0);

                        do {
                            System.out.print("Stock: ");
                            stock = leerEntero(sc);
                        } while (stock <= 0);

                        productos[indice] = new ProductoDigital(nombre, precio, stock);

                        System.out.println("Producto guardado en el índice: " + indice);
                        indice++;
                    } else {
                        System.out.println("No hay espacio");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el índice del producto: ");
                    posicion = leerEntero(sc);

                    if (indiceValido(posicion, indice)) {
                        System.out.print("Nuevo precio: ");
                        precio = leerDouble(sc);
                        productos[posicion].setPrecio(precio);
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el índice del producto: ");
                    posicion = leerEntero(sc);

                    if (indiceValido(posicion, indice)) {
                        System.out.print("Nuevo stock: ");
                        stock = leerEntero(sc);
                        productos[posicion].setStock(stock);
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el índice del producto: ");
                    posicion = leerEntero(sc);

                    if (indiceValido(posicion, indice)) {
                        productos[posicion].mostrarInfo();
                    }
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }

            System.out.println();

        } while (opcion != 5);

        sc.close();
    }

    public static boolean indiceValido(int posicion, int cantidad) {
        if (cantidad == 0) {
            System.out.println("No hay productos registrados.");
            return false;
        }

        if (posicion >= 0 && posicion < cantidad) {
            return true;
        }

        System.out.println("Índice inválido.");
        return false;
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