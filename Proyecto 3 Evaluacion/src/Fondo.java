import javax.swing.*;
import java.awt.*;


public class Fondo {

    int anchoFondo=1920;
    int altoFondo=696;
    int x_primer_fondo =0;
    int y_primer_fondo =0;
    int x_segundo_fondo =1920;
    int y_segundo_fondo =0;

    /**
     * Es un constructor
     */
    public Fondo()
    {

    }
    /**
     * Metodo para dibujar imagenes en pantalla
     * @param g: es parametro de la clase Graphics2D
     */
    public void dibujar(Graphics2D g)
    {
        ImageIcon fondo= new ImageIcon("src/Recursos/fondo.jpg");//Carga la imagen de la ruta en el objeto fondo
        g.drawImage(fondo.getImage(), x_primer_fondo, y_primer_fondo,anchoFondo,altoFondo,null);//Dibuja la imagen con dichas caracteristicas
        g.drawImage(fondo.getImage(), x_segundo_fondo, y_segundo_fondo,anchoFondo,altoFondo,null);//Dibuja la imagen con dichas caracteristicas
    }
    /**
     * Este metodo se encarga de mover al objeto fondo
     */
    public void movimiento()
    {
        x_primer_fondo = x_primer_fondo -2;//Le quita dos al posicion del primer fondo
        x_segundo_fondo = x_segundo_fondo -2;//Le quita dos al posicion del primer fondo
        //Esto hace que la imagen se vea continua y sin espacios


        if(x_primer_fondo ==-1920 && x_segundo_fondo ==0)//si el primer fondo sale del recuadro y el segundo ocupa el puesto del primero se reinician sus posiciones
        {
            x_primer_fondo=0;
            x_segundo_fondo =1920;
        }
    }




}