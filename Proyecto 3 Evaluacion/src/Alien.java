import javax.swing.*;
import java.awt.*;


public class Alien {
    int saltos=0;
    Juego Juego;
    int x_inicial=1920;
    int y_inicial=520;
    int anchoAlien =100;
    int altoAlien=60;

    /**
     * Este metodo es un constructor
     * @param Juego: recibe un objeto juego
     */
    public Alien(Juego Juego)
    {
        this.Juego= Juego;
    }

    /**
     * Metodo para dibujar imagenes en pantalla
     * @param g: es parametro de la clase Graphics2D
     */
    public void dibujar(Graphics2D g)
    {
        ImageIcon avatar=new ImageIcon("src/Recursos/alien.gif");//Carga la imagen de la ruta en el objeto fondo
        g.drawImage(avatar.getImage(),x_inicial,y_inicial, anchoAlien, altoAlien,null);//Dibuja la imagen con dichas caracteristicas
    }

    /**
     * Este metodo se encarga de mover al objeto alien
     */
    public void movimiento()
    {
        //si esta fuera de la imagen añade salto y reinicia posicion
        if(x_inicial<-100)
        {
            saltos=saltos+1;
            x_inicial=1920;
        }
        //si el no hay golpe aumentara la velocidad
        if(!Juego.golpe) {
            int velocidad=5+(saltos/2);
            x_inicial = x_inicial - velocidad;
        }
        //si hay golpe reinicia posicion
        if(Juego.golpe)
        {
            x_inicial=1920;
        }

    }

    /**
     * Devuelve la posicion en el eje x del objeto alien
     * @return: devuelve un numero
     *
     */
    public int getPosicion()
    {
        return x_inicial;
    }
    /**
     * Devuelve los saltos del alien
     * @return: devuelve un numero
     *
     */
    public int getSaltos()
    {
        return saltos;
    }

}
