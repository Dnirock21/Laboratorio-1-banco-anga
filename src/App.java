import java.util.Scanner;

@SuppressWarnings({"switch"})
public class App {
    @SuppressWarnings("ConvertToStringSwitch")
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
                    }else if (rp.equals("no")){
                        System.out.println("El/la cliente no cuenta con deudas.");
                    }else{
                        System.out.println("La respuesta ingresada no es válida. Por favor, ingrese 'Sí' o 'No'."); // Manejo de error para cuando el usuario ingrese un valor diferente de SI o NO
                        break;
                    }

                    System.out.println("Digite el salario mensual del cliente:");
                    salario = scan.nextDouble();

                    if(salario<=0){
                        System.out.println("El/la cliente no puede ingresar un salario negativo.");
                        break;
                    }

                    System.out.println("Digite el puntaje crediticio:");
                    puntaje = scan.nextInt();

                    if(puntaje<500){
                        System.out.println("Prestamo RECHAZADO, el/la cliente "+  nombre +" debe tener un puntaje crediticio superior a 500.");
                        break;
                    }

                    System.out.println("Digite el monto solicitado por el cliente:");
                    mnt_slctd = scan.nextDouble();

                    if(mnt_slctd<=0){
                        System.out.println("El/la cliente no puede ingresar un monto solicitado negativo.");
                        break;
                    }

                    double ingr_msnl = salario - deudas;
                    if (ingr_msnl >= 1.3 * mnt_slctd) {
                        System.out.println("******* PRÉSTAMO APROBADO *******");

                        System.out.println("Ingrese el plazo en meses para pagar el préstamo:");
                        plazo = scan.nextInt();

                        if (plazo<=0){
                            System.out.println("El/la cliente no puede ingresar un plazo negativo.");
                            break;
                        }

                        double tarifa_procesamiento = mnt_slctd * 0.005;

                        if (mnt_slctd % 500 == 0) {
                            tarifa_procesamiento *= 0.5;
                            System.out.println("El/la cliente " + nombre + " ha sido aceptado con un descuento de 50% en la tarifa de procesamiento.");
                        }

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

                        // Restar la tarifa de procesamiento al préstamo aprobado
                        prestamo = mnt_slctd - tarifa_procesamiento;

                        // Calcular la cuota mensual
                        double cuota_mensual = (mnt_slctd * tasa_interes) / (1 - Math.pow(1 + tasa_interes, -plazo));

                        // Convertir la tasa de 0.014 a 1.4%
                        double tasa_porcentaje = tasa_interes*100;

                        System.out.println("\n****** RESUMEN DEL PRÉSTAMO ******");
                        System.out.println("El monto aprobado es: " + prestamo);
                        System.out.println("La tasa de interes es de: " + tasa_porcentaje);
                        System.out.println("El plazo solicitado es de: " + plazo);
                        System.out.println("La cuota mensual a pagar es: " + cuota_mensual);
                        System.out.println("------------------------------------------------GRACIAS POR USAR BANCO ÑANGA ----------------------------------------------------------------");
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