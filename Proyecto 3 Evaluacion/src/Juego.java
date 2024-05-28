import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDateTime;


public class Juego extends JPanel {
    Fondo fondo=new Fondo();
    Soldado soldado =new Soldado(this);
    Alien alien=new Alien(this);
    Alien1 alien1=new Alien1(this);
    Alien2 alien2=new Alien2(this);
    boolean golpe =false;
    boolean golpe1 =false;
    boolean golpe2 =false;
    int puntosTotales;
    int vidas=20;

    public Juego()
    {
        /**
         * Se encarga de comprobar si se presiona o no la tecla de espacio
         */
        addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent e) {


            }
            //SALTO CON EL ESPACIO
            @Override
            public void keyPressed(KeyEvent e)//Se activa cuando estas presionando el teclado
            {
                if(e.getKeyCode()==KeyEvent.VK_SPACE)//Comprueba lo que se presiona el espacio
                {
                    soldado.KeyPressed(e);//Ejecuta el metodo y esta alza la bandera saltando
                }
            }


            @Override
            public void keyReleased(KeyEvent e) {


            }
        });
        setFocusable(true);//se encarga de recoger lo que ocurre
    }

    /**
     *Se encarga de actualizar los metodos que tiene dentro
     * @param g the <code>Graphics</code> object to protect
     */
    public void paintComponent(Graphics g)
    {
         Graphics2D g2=(Graphics2D)g;//Variable que exige los metodos lo convierte en una variable de graphics 2D
        //Metodos para dibujar
        fondo.dibujar(g2);//Ejecuta el metodo dibujar de fondo
        soldado.dibujar(g2);//Ejecuta el metodo dibujar de fondo
        alien.dibujar(g2);//Ejecuta el metodo dibujar de alien
        alien1.dibujar(g2);
        alien2.dibujar(g2);
        //Metodos para mover y comperueba si te golpeas
        if((alien.getPosicion()<=60) && soldado.getPosicionY()>460 ) //Cuando estan los dos en dichas posiciones se marcara como choque
        {
            golpe =true;
            vidas--;//Quitara una vida
        }
        else if ((alien1.getPosicion()<=60 )&&(soldado.getPosicionY()>300 && soldado.getPosicionY()<360)) {
            golpe1=true;
            vidas--;//Quitara una vida
        }
        else if ((alien2.getPosicion()<=60 )  && (soldado.getPosicionY()>140 && soldado.getPosicionY()<200))
        {
            golpe2=true;
            vidas--;//Quitara una vida
        }
        else
        {
            fondo.movimiento();//Mueve el fondo
            soldado.movimiento();//Mueve al soldado
            golpe=false;//Reinicia la bandera
            golpe1=false;
            golpe2=false;
        }
        alien.movimiento();//Mueve al alien
        alien1.movimiento();
        alien2.movimiento();
        //Mostrar puntaje
        int puntos=alien.getSaltos();
        int puntos1=alien1.getSaltos();
        int puntos2=alien2.getSaltos();
        puntosTotales=puntos+puntos1+puntos2;
        Font Puntos=new Font("Arial",Font.BOLD,30);//Estilo del texto y tamano de la letra
        g.setFont(Puntos);//Le da estilo al texto
        g.setColor(Color.white);//Color del texto
        g.drawString("Puntaje: "+puntosTotales,250,30);//Posicion y puntos
        g.drawString("Vidas: "+vidas,50,30);//Posicion y vidas
        g.drawString("Nivel: "+ puntosTotales/2,450,30);//Posicion y nivel
    }
    /**
     * Devuelve las vidas que tienes
     * @return devuelve un numero
     */
    public int getVidas()
    {
        return vidas;
    }

    /**
     * Devueleve los puntos obtenidos
     * @return devuelve un numero
     */
    public int getPuntos()
    {
        return puntosTotales;
    }

    /**
     * Devuelve el nivel conseguido
     * @return devuelve un numero
     */
    public int getNivel()
    {
        return puntosTotales/2;
    }

}
