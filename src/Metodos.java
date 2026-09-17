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

}
