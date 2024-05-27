import javax.swing.*;
import java.awt.*;


public class Alien2 {
    int saltos=0;

    Juego Juego;
    int x_inicial=1800;
    int y_inicial=200;
    int anchoAlien =100;
    int altoAlien =60;
    public Alien2(Juego Juego)
    {
        this.Juego= Juego;
    }
    //Metodo para dibujar imagenes en pantalla
    public void dibujar(Graphics2D g)
    {
        ImageIcon avatar=new ImageIcon("src/Recursos/alien.gif");//Carga la imagen de la ruta en el objeto fondo
        g.drawImage(avatar.getImage(),x_inicial,y_inicial, anchoAlien, altoAlien,null);//Dibuja la imagen con dichas caracteristicas
    }
    public void movimiento()
    {
        //si esta fuera de la imagen añade salto y reinicia posicion
        if(x_inicial<-100 )
        {
            saltos=saltos+1;
            x_inicial=1800;
        }
        //si el no hay golpe aumentara la velocidad
        if(!Juego.golpe2) {
            int velocidad = 5 + (saltos/2);//Aumenta la velocidad en una 1 una unidad dependiendo de los saltos

            x_inicial = x_inicial - velocidad;
        }
        //si hay golpe reinicia posicion
        if(Juego.golpe2)
        {
            x_inicial=1800;
        }

    }
    public int getPosicion()
    {
        return x_inicial;
    }
    public int getSaltos()
    {
        return saltos;
    }

}