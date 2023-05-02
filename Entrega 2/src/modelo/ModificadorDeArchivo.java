package modelo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import modelo.Habitacion;
import modelo.Producto;
import modelo.Cama;
import modelo.Empleado; 
import modelo.PropertyManagamentSystem;


public class ModificadorDeArchivo {
	private String nombreArchivo;
	private String mensaje;
	
	
	public static void modificarCapacidad(Habitacion habitacion) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Capacidad actual: %d%n", habitacion.getCapacidad());
        System.out.print("Ingrese la nueva capacidad: ");
        int nuevaCapacidad = scanner.nextInt();
        habitacion.setCapacidad(nuevaCapacidad);
        System.out.println("Capacidad modificada exitosamente.");
    }

    public static void modificarNumCamas(Habitacion habitacion) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Número de camas actual: %d%n", habitacion.getNumCamas());
        System.out.print("Ingrese el nuevo número de camas: ");
        int nuevoNumCamas = scanner.nextInt();
        habitacion.setNumCamas(nuevoNumCamas);
        System.out.println("Número de camas modificado exitosamente.");
    }
    
    public static void modificarCamas(Habitacion habitacion) {
    	Scanner scanner = new Scanner(System.in);
    	System.out.printf("Camas actual: %d%n", habitacion.getCamas());
    	System.out.print("Camas a poner: ");
        int numcamas = scanner.nextInt();
        scanner.nextLine(); 
        ArrayList<Cama> camas = new ArrayList<>();
        for (int i = 0; i < numcamas; i++) {
            System.out.printf("Cama %d:%n", i + 1);
            System.out.print("Tamaño: ");
            String size = scanner.nextLine();
            System.out.print("capacidad: ");
            int capacidad_1 = scanner.nextInt();
            System.out.print("uso: ");
            String uso = scanner.nextLine();
            scanner.nextLine(); 
            Cama cama = new Cama(size, capacidad_1,uso);
            camas.add(cama);
        }
        habitacion.setCamas(camas);
        System.out.println("Modificación exitosamente.");
    }
    public static void modificarUbicacion(Habitacion habitacion) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Ubicacion actual: ", habitacion.getUbicacion());
        System.out.print("Ingrese la nueva ubicacion: ");
        String nuevodato = scanner.nextLine();
        habitacion.setUbicacion(nuevodato);
        System.out.println("Modificación exitosamente.");
    }
    public static void modificarTipo(Habitacion habitacion) {
    	Scanner scanner = new Scanner(System.in);
        System.out.printf("Ubicacion actual: ", habitacion.getTipo());
        System.out.print("Ingrese el nuevo tipo: ");
        String nuevodato = scanner.nextLine();
        habitacion.setTipo(nuevodato);
        System.out.println("Modificación exitosamente.");
    }
    public static void modificarTarifa(Habitacion habitacion) {
    	Scanner scanner = new Scanner(System.in);
        System.out.printf("Ubicacion actual: ", habitacion.getTarifas());
        System.out.printf("Tarifa ");
        System.out.print("Valor ");
        int valor_ = scanner.nextInt();
        System.out.print("año inicio: ");
        long anoinicio = (long) scanner.nextDouble();
        System.out.print("mes inicio: ");
        long mesinicio = (long) scanner.nextDouble();
        System.out.print("día inicio: ");
        long diainicio = (long) scanner.nextDouble();
        long miliseconds = (long) ((mesinicio* 2629743833.3) + (diainicio*86400000)+(anoinicio*3600000));
        scanner.nextLine(); 
        Date fechainicial = new Date(miliseconds); 
        System.out.print("año final: ");
        long anofinal = (long) scanner.nextDouble();
        System.out.print("mes final: ");
        long mesfinal = (long) scanner.nextDouble();
        System.out.print("día final: ");
        long diafinal = (long) scanner.nextDouble();
        long milisecondsfinal = (long) ((mesfinal* 2629743833.3) + (diafinal*86400000)+(anofinal*3600000));
        scanner.nextLine(); 
        Date fechafinal = new Date(milisecondsfinal);
        System.out.print("Producto : ");
        String producto = scanner.nextLine();
        scanner.nextLine(); 
        Tarifa tarifas = new Tarifa(valor_, fechainicial,fechafinal,producto);
        ArrayList<Tarifa> newvalue=new ArrayList<>();
        newvalue.add(tarifas);
        habitacion.setTarifas(newvalue);
        System.out.println("Modificación exitosamente.");
    }
    public static void modificarElementos(Habitacion habitacion) {
    	Scanner scanner = new Scanner(System.in);
        System.out.printf("Ubicacion actual: ", habitacion.getElementosDeCobro());
        
        HashMap<String, Integer> elementosCobro1 = new HashMap<String, Integer>();
        System.out.print("numero de elementos");
        int valor = scanner.nextInt();
        for (int i = 0; i < valor; i++) {
        	System.out.print("Producto: ");
            String name = scanner.nextLine();
        	System.out.print("Valor: ");
            int price = scanner.nextInt();
            elementosCobro1.put(name, price);
        }
        
        System.out.print("Elementos de cobro: ");
        String elementosDeCobro = scanner.nextLine();
        System.out.print("Elementos adicionales: ");
        String elementosAdicionales = scanner.nextLine();
        String nuevodato = scanner.nextLine();
     
        habitacion.setElementosDeCobro(elementosCobro1);
        System.out.println("Modificación exitosamente.");
    }
    
    
    
    public static void modificarDescripcion(Producto producto) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Capacidad actual: %d%n", producto.getDescripcion());
        System.out.print("Ingrese la nueva versión: ");
        String nuevo = scanner.nextLine();
        producto.setDescripcion(nuevo);
        System.out.println("Capacidad modificada exitosamente.");
    }
    /**
     * @param producto
     */
    public static void modificarDisponibilidad(Producto producto) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Actualmente esta Disponible: ", producto.getDisponibleHabitacion());
        
        System.out.println("¿Desea que este Disponible?");
        System.out.println("1. Verdadero");
        System.out.println("2. Falso");
        int opcion = scanner.nextInt();
        scanner.nextLine(); 
        switch (opcion) {
            case 1:
                producto.setDisponibleHabitacion(true);
                break;
            case 2:
                producto.setDisponibleHabitacion(false);
                break;
            default:
                System.out.println("Opción inválida.");
                break;
        }
        System.out.println("Disponibilidad del producto modificada exitosamente.");
    }
    public static void modificarPrecio(Producto producto) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Capacidad actual: %d%n", producto.getPrecio());
        System.out.print("Ingrese la nueva versión: ");
        int nuevo = scanner.nextInt();
        producto.setPrecio(nuevo);
        System.out.println("Capacidad modificada exitosamente.");
    }
    public static void modificarInicio(Producto producto) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Capacidad actual: %d%n", producto.getInicioDisponible());
        System.out.print("Ingrese la nueva versión: ");
        String in = scanner.nextLine();
        LocalTime inicioDisponible = LocalTime.parse(in);
        producto.setInicioDisponible(inicioDisponible);
        System.out.println("Capacidad modificada exitosamente.");
    }
    public static void modificarFinal(Producto producto) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Capacidad actual: %d%n", producto.getFinDisponible());
        System.out.print("Ingrese la nueva versión: ");
        String in = scanner.nextLine();
        LocalTime inicioDisponible = LocalTime.parse(in);
        producto.setFinDisponible(inicioDisponible);
        System.out.println("Capacidad modificada exitosamente.");
    }
    
    
    

}
