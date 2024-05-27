import Utilidades.Utilidades;
import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;



public class Pantalla extends JPanel {
    public static void  main(String[] args) throws InterruptedException, IOException {
        Juego Juego=new Juego();//Crea el objeto juego
        JOptionPane.showMessageDialog(null,"El juego va a comenzar");//Muestra el mensaje de inicio
        JFrame ventana = new JFrame("Juego");//Inicia la ventana de inicio
        ventana.add(Juego);//Hace lo que tiene la clase juego den   tro de la ventana creada
        ventana.setSize(1200,629);//tamaño de la pantalla
        ventana.setLocationRelativeTo(null); //aparece centrado
        ventana.setVisible(true);//Es visible
        while (Juego.getVidas()>0)//Comprueba que tengas vidas
        {
            Juego.repaint();
            Thread.sleep(10);//Tiempo que tarda en refrescar
        }
        if(Juego.vidas==0)//Se te acabaron las vidas
        {

            int nivel=Utilidades.leerArchivo("src/archivosTxt/Nivel");//Carga la variable con lo que hay en el archivo
            int puntos=Utilidades.leerArchivo("src/archivosTxt/Puntos");//Carga la variable con lo que hay en el archivo
            String  fecha=Utilidades.leerFechas("src/archivosTxt/Fechas");//Carga la variable con lo que hay en el archivo
            String horaYminutos=Utilidades.leerFechas("src/archivosTxt/HorasYMinutos");
            if(puntos>=Juego.getPuntos())//Comprueba los puntos guardados con los actuales
            {
                //Obtiene el tiempo en el que termina la partida
                LocalDateTime tiempo=LocalDateTime.now();
                int horas=tiempo.getHour();
                int minutos=tiempo.getMinute();
                String tiempo1=horas+":"+minutos;
                //Si obtuviste menor puntucion que antes te dira los puntos,nivel y fecha anteriores
                JOptionPane.showMessageDialog(null,"ESTADISTICAS :\n TU MAYOR PUNTUACION ES: "+puntos+"\n TU NIVEL MÁS ALTO CONSEGUIDO: "+nivel+"  \n ESTOS RESULTADOS SE OBTUVIERON EN LA FECHA: "+fecha+" A LAS "+horaYminutos);
                //Guarda informacion sobre la partida
                String partida="El dia "+LocalDate.now()+" a las "+tiempo1+" se obtuvo "+Juego.getPuntos()+ " y se llego al nivel "+Juego.getNivel();
                Utilidades.escribirPartidas("src/archivosTxt/Partidas",partida);
            }
            if(puntos<=Juego.getPuntos())
            {
                //Obtiene el tiempo en el que termina la partida
                LocalDateTime tiempo=LocalDateTime.now();
                int horas=tiempo.getHour();
                int minutos=tiempo.getMinute();
                String horasYMinutos=horas+":"+minutos;
                //Si obtuviste mayor puntuacion que antes te dira la puntuacion actual, nivel actual y fecha actual
                JOptionPane.showMessageDialog(null,"ESTADISTICAS : \nTU MAYOR PUNTUACION ES: "+Juego.getPuntos()+"\nTU NIVEL MÁS ALTO CONSEGUIDO: "+Juego.getNivel()+"\nESTOS RESULTADOS SE OBTUVIERON EN LA FECHA: "+LocalDate.now()+" A LAS "+horasYMinutos);
                //Actualiza los puntos
                Utilidades.escribir("src/archivosTxt/Puntos", Juego.getPuntos());
                //Actualiza la fecha
                String fecha_actual= String.valueOf(LocalDate.now());
                Utilidades.escribirFechas("src/archivosTxt/Fechas",fecha_actual);
                //Actualiza el nivel
                Utilidades.escribir("src/archivosTxt/Nivel", Juego.getNivel());
                //Actualiza la hora
                Utilidades.escribirFechas("src/archivosTxt/HorasYMinutos",horasYMinutos);
                //Guarda informacion sobre la partida
                String partida="El dia "+LocalDate.now()+" a las "+horasYMinutos+" se obtuvo "+Juego.getPuntos()+ " puntos y se llego al nivel "+Juego.getNivel();
                Utilidades.escribirPartidas("src/archivosTxt/Partidas",partida);
            }
            //Escribe todas la partidas registradas
            JOptionPane.showMessageDialog(null,Utilidades.historialPartidas("src/archivosTxt/Partidas"));
            //Te mostrara que perdiste
            JOptionPane.showMessageDialog(null,"HAS PERDIDO");
            System.exit(0);
        }
    }

}


