import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;


public class Soldado {
    Juego Juego;
    boolean saltando=false;
    int anchosSoldado=100;
    int altoSoldado =60;
    int x_inicial =0;
    int y_inicial=520;
    boolean  baja=false;

    /**
     * Es un contructor del objeto soldado
     * @param Juego: es un objeto de la clase Juego
     */
    public Soldado(Juego Juego)
    {
        this.Juego=Juego;
    }
    /**
     * Metodo para dibujar imagenes en pantalla
     * @param g: es parametro de la clase Graphics2D
     */
    public void dibujar(Graphics2D g)
    {
        ImageIcon soldado=new ImageIcon("src/Recursos/soldado.gif");//Crea la imagen
        g.drawImage(soldado.getImage(), x_inicial,y_inicial,anchosSoldado, altoSoldado,null);//dibuja la imagen
    }

    /**
     *Se en encarga de alzar la bandera
     * @param e: variable tipo KeyEvent
     */
    public void KeyPressed(KeyEvent e)//Activa la bandera
    {
        saltando=true;
    }

    /**
     * Este metodo se encarga del movimiento del objeto soldado
     */
    public void movimiento()
    {
        if(saltando)//Comprueba si esta saltando
        {
            y_inicial=y_inicial-5;//Va subiendo
            if(y_inicial==140)
            {
                saltando=false;
                baja=true;
            }
        }
        if(!saltando)
        {
            if (baja) {
                y_inicial = y_inicial + 5;
                if (y_inicial == 520) {
                    baja = false;
                }
            }
        }
    }

    /**
     * Este metodo se encarga de devolver la posicion del soldado en le eje y
     * @return devuelve un numero
     */
    public int getPosicionY()
    {
        return y_inicial;
    }


}

