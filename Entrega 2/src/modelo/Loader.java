package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.io.File;
import modelo.Administrador;
import modelo.Consumible;
import modelo.Recepcionista;
import modelo.Empleado;
import modelo.Reserva;
import modelo.Habitacion;
import modelo.Usuario;

public class Loader
{
    /**
     * @param PMS
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void cargarData(PropertyManagamentSystem PMS) throws FileNotFoundException, IOException
	{
        HashMap<String, Empleado> empleados = new HashMap<String, Empleado>();
        ArrayList<Consumible> servicios = new ArrayList<>();
        ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
        ArrayList<Reserva> ConsultaReserva = new ArrayList<>();
        ArrayList<Usuario> Lusuarios = new ArrayList<>();

		String fileEmpleados= System.getProperty("user.dir") + "\\Entrega 2\\data\\Empleados.txt";
		File archivo = new File(fileEmpleados);
		BufferedReader lector = new BufferedReader(new FileReader(archivo));
		String linea = lector.readLine();
		
		while (linea != null) {
            System.out.println(linea);
            String[] partes = linea.split(";");
			String nombre = partes[0];
            String IDEmpleado=partes[1];
            String correo = partes[2];
            String password = partes[3];
            String rol = partes[4];
            Empleado elEmpleado= empleados.get(IDEmpleado);
            if (elEmpleado!=null){
                elEmpleado=new Empleado(nombre, IDEmpleado, correo, password, rol, PMS);
                empleados.put(IDEmpleado, elEmpleado);
            }
            Usuario findUsuario=null;
            for (int i = 0; i < Lusuarios.size() && findUsuario == null; i++)
                {
                    if (Lusuarios.get(i).getId().equals(IDEmpleado)){
                        findUsuario= Lusuarios.get(i);
                        System.out.println("usuario encontrado");
                        }
                }
            if (findUsuario!=null){
                findUsuario = new Usuario(nombre, IDEmpleado, correo, password, rol, PMS);
                Lusuarios.add(findUsuario);
                System.out.println("usuario creado");}

			linea = lector.readLine();
		}
        PMS.usuarios = Lusuarios;
        PMS.Lempleado = empleados;
        System.out.println("finalizado");
		lector.close();
  		
		String fileHabitaciones= System.getProperty("user.dir") + "\\Entrega 2\\data\\habtiaciones.txt";
		File archivoH = new File(fileHabitaciones);
		
        try (BufferedReader br = new BufferedReader(new FileReader(archivoH))) {
            String lineaH;
            while ((lineaH = br.readLine()) != null) {
                String[] campos = lineaH.split(",");
                String idHabi = campos[0];
                String ubicacion = campos[1];
                int capacidad = Integer.parseInt(campos[2]);
                String tipo = campos[3];
                int numcamas = Integer.parseInt(campos[4]);
                ArrayList<Cama> camas = new ArrayList<>();
                String[] camasStr = campos[5].split(";");
                for (String camaStr : camasStr) {
                    String[] camaCampos = camaStr.split("-");
                    String size = camaCampos[0];
                    int capacidadC = Integer.parseInt(camaCampos[1]);
                    String uso = camaCampos[2];
                    Cama cama = new Cama(size, capacidadC, uso);
                    camas.add(cama);
                }
                HashMap<String, Integer> elementosDeCobro = new HashMap<String, Integer>();
                String[] elementos = campos[6].split(";");
                for (String elemento : elementos ) {
                	String[] dictionary = elemento.split(":");
                	String nombre = dictionary[0];
                	int precio = Integer.parseInt(dictionary[1]);
                	elementosDeCobro.put(nombre, precio);
                }
                ArrayList<Tarifa> tarifas = new ArrayList<>();
                String[] tarifasStr = campos[7].split(";");
                for (String tarifaStr : tarifasStr) {
                    String[] tarifaCampos = tarifaStr.split("-");
                    int valor = Integer.parseInt(tarifaCampos[0]);
                    Date fechainicio = new Date(Long.parseLong(tarifaCampos[1]));
                    Date fechafinal = new Date(Long.parseLong(tarifaCampos[2]));
                    String producto = tarifaCampos[3];
                    Tarifa tarifa = new Tarifa(valor, fechainicio,fechafinal, producto);
                    tarifas.add(tarifa);
                }
              
                Habitacion habitacion = new Habitacion(idHabi, ubicacion, capacidad, tipo, numcamas,elementosDeCobro, 
                         tarifas, camas);
                habitaciones.add(habitacion);
            }
            

            
        } catch (IOException e) {
            System.err.format("Error de E/S: %s%n", e);
        }
    }

    public static Consumible buscarServicio(ArrayList<Consumible> Servicios)
    {   
        Consumible servicio=null;

        return servicio;
    }

}
