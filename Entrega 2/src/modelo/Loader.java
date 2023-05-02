package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
        ArrayList<Habitacion> habitaciones = new ArrayList<>();
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
            if (elEmpleado==null){
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
            if (findUsuario==null){
                findUsuario = new Usuario(nombre, IDEmpleado, correo, password, rol, PMS);
                Lusuarios.add(findUsuario);
                System.out.println("usuario creado");}

			linea = lector.readLine();
		}
        PMS.usuarios = Lusuarios;
        PMS.Lempleado = empleados;
        System.out.println("finalizado");
		lector.close();
  		
	}


    public static Consumible buscarServicio(ArrayList<Consumible> Servicios)
    {   
        Consumible servicio=null;

        return servicio;
    }

}
