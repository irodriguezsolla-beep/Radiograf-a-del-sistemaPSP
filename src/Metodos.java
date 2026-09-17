import java.io.File;
import java.lang.Runtime;
import java.util.Properties;
import java.util.Scanner;
import java.util.TreeSet;


public class Metodos {

    public static void procesador(){
        Runtime runtime = Runtime.getRuntime();
        int procesadores = runtime.availableProcessors();
        System.out.println("PROCESADORES");
        System.out.println("=".repeat(50));
        System.out.println("\tDisponibles JVM:       " + procesadores);
        System.out.println(" ");
    }

    public static void memoria(){
        Runtime runtime = Runtime.getRuntime();

        long mib = 1024 * 1024;

        long reservadaAnterior = runtime.totalMemory() / mib;
        long libreAnterior = runtime.freeMemory() / mib;
        long maxAnterior = runtime.maxMemory() / mib;
        long usoAnterior = reservadaAnterior - libreAnterior;
        double porcentajeUsoAnterior = (usoAnterior * 100L) / reservadaAnterior;

        System.out.println("MEMORIA · ANTES");
        System.out.println("=".repeat(50));
        System.out.println("\tTotal reservada:       " + reservadaAnterior + " MiB");
        System.out.println("\tLibre:                 " + libreAnterior + " MiB");
        System.out.println("\tEn uso:                " + usoAnterior + " MiB ( "+ porcentajeUsoAnterior + " % de la total)");
        System.out.println("\tMáxima (-Xmx):         " + maxAnterior + " MiB");
        System.out.println(" ");

        // Reserva de 64 MiB
        long[] reservado = new long[8 * 1024 * 1024];

        long reservada = runtime.totalMemory() / mib;
        long libre = runtime.freeMemory() / mib;
        long max = runtime.maxMemory() / mib;
        long uso = reservada - libre;
        double porcentajeUso = (uso * 100L) / reservada;

        if (reservado.length > 0) {
            reservado[0] = 1L;
        }

        System.out.println("MEMORIA · DESPUÉS DE RESERVAR 64 MiB");
        System.out.println("=".repeat(50));
        System.out.println("\tTotal reservada:       " + reservada + " MiB");
        System.out.println("\tLibre:                 " + libre + " MiB");
        System.out.println("\tEn uso:                " + uso + " MiB( "+ porcentajeUso + " % de la total)");
        System.out.println("\tMáxima (-Xmx):         " + max + " MiB");
        System.out.println(" ");
    }

    public static void sistema(){
        String osName = System.getProperty("os.name");
        String fileSeparator = File.separator;
        String userHome = System.getProperty("user.home");
        String rutaFichero = userHome + fileSeparator + "psp" + fileSeparator + "informe.txt";

        System.out.println("SISTEMA");
        System.out.println("=".repeat(50));
        System.out.println("\tSistema Operativo:     " + osName);
        System.out.println("\tSeparador de archivos: " + fileSeparator);
        System.out.println("\tRuta construida con las propiedades:");
        System.out.println("\t\t"+ rutaFichero);
        System.out.println(" ");
    }

    public static void propiedadesSistema(String[] args) {
        String[] prefijos = args;
        if (args == null || args.length == 0) {
            prefijos = new String[]{"os.", "user.", "java.version"};
        }

        System.out.println("PROPIEDADES DEL SISTEMA");
        System.out.println("=".repeat(50));

        Properties props = System.getProperties();

        TreeSet<String> clavesOrdenadas = new TreeSet<>(props.stringPropertyNames());

        for (String clave : clavesOrdenadas) {
            for (String prefijo : prefijos) {
                if (clave.startsWith(prefijo)) {
                    System.out.println("\t" + clave + " = " + props.getProperty(clave));
                    break;
                }
            }
        }
        System.out.println(" ");
    }

    public static void pausar() {
        System.out.print("Pulsa INTRO para terminar...");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }
}

