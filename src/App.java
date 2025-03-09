import java.util.Scanner;

@SuppressWarnings({"unused", "switch"})
public class App {
    public static void main(String[] args) throws Exception {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("\nBienvenido a BANCO ÑANGA");
            System.out.println("================================================");
            System.out.println("Por favor registre un funcionario del banco para poder acceder al sistema:");

            System.out.println("Digite el nombre del usuario:");
            String usuario = scan.nextLine();
            System.out.println("Digite la contraseña del usuario:");
            String contraseña = scan.nextLine();

            System.out.println("Procesando...");
            System.out.println("================================================");
            System.out.println("Usuario creado correctamente");
            System.out.println("================================================");
            System.out.println("Ahora por favor inicie sesión para continuar:");

            String usuarioInicio, contraseñaInicio;
            do {

                System.out.println("Digite su nombre de usuario:");
                usuarioInicio = scan.nextLine();
                System.out.println("Digite su contraseña:");
                contraseñaInicio = scan.nextLine();

                if (usuario.equals(usuarioInicio) && contraseña.equals(contraseñaInicio)) {
                    System.out.println("******* INICIO DE SESIÓN CORRECTO *******");
                    System.out.println("Por favor ingrese los siguientes datos del cliente a registrar:");

                    System.out.println("\nIngresa el nombre del cliente:");
                    String nombre = scan.nextLine();
                    System.out.println("\nIngresa el primer apellido del cliente:");
                    String apellido = scan.nextLine();
                    System.out.println("\nIngresa la edad del cliente:");
                    int edad = scan.nextInt();
                    scan.nextLine();

                    if (edad < 18) {
                        System.out.println("Prestamo RECHAZADO, el/la cliente "+  nombre +" debe ser mayor de edad para solicitar prestamos.");
                        break;
                    }

                    System.out.println("\n¿El/la cliente cuenta con deudas? (Sí/No):");
                    String rp = scan.nextLine().trim().toLowerCase();

                    double deudas = 0, salario, mnt_slctd, tasa_interes, prestamo;
                    int puntaje, plazo;

                    if (rp.equals("si")) {
                        System.out.println("Ingrese el monto de deudas del cliente:");
                        deudas = scan.nextDouble();
                    }

                    System.out.println("Digite el salario mensual del cliente:");
                    salario = scan.nextDouble();
                    System.out.println("Digite el puntaje crediticio:");
                    puntaje = scan.nextInt();
                    System.out.println("Digite el monto solicitado por el cliente:");
                    mnt_slctd = scan.nextDouble();

                    double ingr_msnl = salario - deudas;
                    if (ingr_msnl >= 1.3 * mnt_slctd) {
                        System.out.println("******* PRÉSTAMO APROBADO *******");

                        System.out.println("Ingrese el plazo en meses para pagar el préstamo:");
                        plazo = scan.nextInt();

                        double tarifa_procesamiento = mnt_slctd * 0.005;

                        if (puntaje >= 800) {
                            System.out.println("El/la cliente " + nombre + " cuenta con un buen historial crediticio, la tasa de interés será del 1.4%");
                            tasa_interes = 0.014;
                        } else if (puntaje >= 500 && puntaje < 800) {
                            System.out.println("El/la cliente " + nombre + " cuenta con un historial crediticio medio, la tasa de interés será del 1.7%");
                            tasa_interes = 0.017;
                        } else {
                            System.out.println("Préstamo RECHAZADO, el/la cliente " + nombre + " cuenta con un mal historial crediticio.");
                            break;
                        }

                        if (mnt_slctd % 500 == 0) {
                            tarifa_procesamiento *= 0.5;
                            System.out.println("El/la cliente " + nombre + " ha sido aceptado con un descuento de 50% en la tarifa de procesamiento.");
                        } else {
                            System.out.println("El/la cliente " + nombre + " ha sido aceptado con la tarifa de procesamiento original.");
                        }

                        prestamo = mnt_slctd + (mnt_slctd * tasa_interes) - tarifa_procesamiento;
                        double cuota_mensual = prestamo / plazo;

                        System.out.println("\n****** RESUMEN DEL PRÉSTAMO ******");
                        System.out.println("Monto solicitado: " + mnt_slctd);
                        System.out.println("Tasa de interés aplicada: " + (tasa_interes * 100) + "%");
                        System.out.println("Tarifa de procesamiento: " + tarifa_procesamiento);
                        System.out.println("Monto final a pagar: " + prestamo);
                        System.out.println("Plazo en meses: " + plazo);
                        System.out.println("Cuota mensual a pagar: " + cuota_mensual);
                    } else {
                        System.out.println("Préstamo RECHAZADO, los ingresos mensuales de el/la cliente " + nombre + " no logran cubrir el monto solicitado");
                        break;
                    }
                } else {
                    System.out.println("******* INICIO DE SESIÓN FALLIDO *******");
                    System.out.println("--------------------------------Usuario o contraseña incorrectos--------------------------------");
                }
            } while (!usuario.equals(usuarioInicio) || !contraseña.equals(contraseñaInicio));
        }
    }
}
