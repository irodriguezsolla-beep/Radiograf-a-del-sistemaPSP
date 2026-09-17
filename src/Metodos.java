import java.io.File;
import java.lang.Runtime;
import java.util.Properties;
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
}
