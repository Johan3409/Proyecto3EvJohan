package Utilidades;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Utilidades {
    /**
     * Este metodo se encarga de escribir los puntos en el documento escrito
     * @param ruta: es donde esta el archivo
     * @param puntos: es lo que se quiere escribir
     */
    public static void escribir(String ruta, int puntos)  {
        try
        {
            File archivo = new File(ruta);//Crea el objeto file que representa el documento de la ruta puesta
            FileWriter archivoEscribir= new FileWriter(archivo);//Crea un objeto que puede ser escrito si ya existe el objeto que le das lo sobreescribira
            archivoEscribir.write(puntos);//Escribe los puntos nuevos
            archivoEscribir.close();//Cierra el archivo1
        }
        catch(IOException ioe)
        {
            System.out.println("Error al encontrar el archivo");
        }
    }

    /**
     * Este metodo se encarga de escribir la informacion de la partida en el documento escrito
     * @param ruta: es donde esta el archivo
     * @param partida: son datos de la partida
     */
    public static void escribirPartidas(String ruta, String partida)  {
        try
        {
            File archivo = new File(ruta);//Crea el objeto file que representa el documento de la ruta puesta
            FileWriter archivoEscribir= new FileWriter(archivo,true);
            archivoEscribir.write(partida+"\n");//Escribe informacion sobre las partidas
            archivoEscribir.close();//Cierra el archivo1
        }
        catch(IOException ioe)
        {
            System.out.println("Error al encontrar el archivo");
        }
    }

    /**
     * Este metodo se encarga de devolver lo que existe en el documento escrito
     * @param ruta: lugar del documento que se quiere leer
     * @return devuelve número entero
     */
    public static int leerArchivo(String ruta)  {
        try {
            File archivo=new File(ruta);//Crea el objeto file que representa el documento de la ruta puesta
            FileReader archivoLeer=new FileReader(archivo);//Crea un objeto que es capaz de leerse
            int puntos=archivoLeer.read();//Almacena lo leido en la variable
            archivoLeer.close();//Cierra el archivop estadisticas leer
            return puntos;
        }
        catch (IOException ioe)
        {
            System.out.println("Error al buscar el documento");
            return -1;
        }
    }

    /**
     * Este metodo escribe la fecha que se le entraga en el documento escrito
     * @param ruta: lugar del documento que se quiere leer
     * @param fecha_Juego: recoge la fecha del juego
     */
    public static void escribirFechas(String ruta, String fecha_Juego)
    {
        try {
            File archivo=new File(ruta);//Crea el objeto file que representa el documento de la ruta puesta
            FileWriter archivoEscribir=new FileWriter(archivo);//Crea un objeto que puede ser escrito si ya existe el objeto que le das lo sobreescribira
            archivoEscribir.write(fecha_Juego);//Escribe la fecha nueva
            archivoEscribir.close();//Cierra el fechas
        }
        catch (IOException ioe)
        {
            System.out.println("Error archivo no encontrado");
        }
    }

    /**
     * Este metodo nos devuelve lo almacenado en el documento escrito
     * @param ruta: lugar en el que se encuentra el documento escrito
     * @return devuelve lo que contiene el documento
     */
    public static String leerFechas(String ruta)
    {
        String error="0";
        try
        {
            File archivo=new File(ruta);//Crea el objeto file que representa el documento de la ruta puesta
            Scanner archivoLeer=new Scanner(archivo);
            return archivoLeer.nextLine();//Lee la linea del documento yla devuelve
        }
        catch(IOException ioe)
        {
            System.out.println("ERROR NO SE HA ENCONTRADO ESTE DOCUMENTO");
            return error;
        }
    }

    /**
     * Este metodo sirve pàra obtener lo almacenado en el documento escrito
     * @param ruta: lugar en el que se encuentra el documento
     * @return devuelve la variable partidas
     */
    public static String historialPartidas(String ruta)  {
        String partidasArchivo;
        boolean terminar=true;
        String partidas="Partidas Jugadas:";
        try {
            File archivoPartidas = new File(ruta);//Crea el objeto file que representa el documento de la ruta puesta
            FileReader leerPartidas = new FileReader(archivoPartidas);//Crea un archivo que se pueda leer
            BufferedReader leerPartidasJugadas = new BufferedReader(leerPartidas);
            do {
                partidasArchivo = leerPartidasJugadas.readLine();//Lo carga con la primera linea del archivo
                if (partidasArchivo != null)//Comprueba que hay algo en el archivo
                {

                    partidas = partidas + "\n" + partidasArchivo;//Va guardando la linea leida en la variable partidas
                } else {
                    terminar = false;//No hay nada
                }
            }while (terminar);
        }
        catch (IOException ioe)
        {
            System.out.println("Error el archivo no se ha encontrado");
        }
        return partidas;//Devuelve el string com las partidas jugadas
    }
}
