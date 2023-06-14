import fizzBuzz.FizzBuzz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class App extends JFrame {

    int westFizzCounter=0;
    int westBuzzCounter=0;
    int westFizzBuzzCounter=0;
    int westNoneCounter=0;

    public App() throws HeadlessException {

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        /**NORTH PANEL**/
        this.add(northPanel, BorderLayout.NORTH);

        JButton goButton = new JButton("GO!");
        c.gridx = 0; //columna 0
        c.gridy = 0; //fila 0
        c.gridwidth = 2; //dos columnas de ancho
        c.gridheight =2; //dos filas de alto
        c.weightx = 1.0; // expandir en dirección x
        c.weighty = 1.0; // expandir en dirección y

        // Configuración de tamaño preferido
        Dimension buttonSize = new Dimension(100, 100); // Ancho y alto en píxeles
        goButton.setPreferredSize(buttonSize);


        northPanel.add(goButton, c);

        JLabel titleLabel = new JLabel("FIZZBUZZ!");
        c.gridx = 2; //columna 2
        c.gridy = 0; //fila 0
        c.gridwidth = 6; //dos columnas de ancho
        c.gridheight =2; //dos filas de alto
        c.weightx = 1.0; // expandir en dirección x
        c.weighty = 1.0; // expandir en dirección y
        c.fill = GridBagConstraints.BOTH; // expandir en ambas direcciones
        c.anchor = GridBagConstraints.NORTHWEST; // alinear en la esquina superior izquierda

        // Configuración de fuente
        Font titleFont = new Font("Arial", Font.BOLD, 60); // Fuente, estilo y tamaño
        titleLabel.setFont(titleFont);

        // Configuración de color
        Color color = Color.RED;
        titleLabel.setForeground(color);

        // Configuración de tamaño preferido
        Dimension titleSize = new Dimension(200, 100); // Ancho y alto en píxeles
        titleLabel.setPreferredSize(titleSize);


        northPanel.add(titleLabel, c);

        /**WEST PANEL**/
        JPanel westPanel = new JPanel();
        westPanel.setLayout(new GridBagLayout());
        this.add(westPanel, BorderLayout.WEST);



        JLabel westFizzLabel = new JLabel("Fizz: "+westFizzCounter+" numbers");
        JLabel westBuzzLabel = new JLabel("Buzz: "+westBuzzCounter+" numbers");
        JLabel westFizzBuzzLabel = new JLabel("FizzBuzz: "+westFizzBuzzCounter+" numbers");
        JLabel westNoneLabel = new JLabel("None: "+westNoneCounter+" numbers");

        c.gridx =0;
        c.gridy =0;
        c.gridwidth = 1; //dos columnas de ancho
        c.gridheight =1; //dos filas de alto
        c.insets = new Insets(0, 30, 0, 30); // Espacio de 10 píxeles a la izquierda
        westPanel.add(westFizzLabel, c);
        c.gridx =0;
        c.gridy =1;
        c.gridwidth = 1; //dos columnas de ancho
        c.gridheight =1; //dos filas de alto
        c.insets = new Insets(0, 30, 0, 30); // Espacio de 10 píxeles a la izquierda
        westPanel.add(westBuzzLabel, c);
        c.gridx =0;
        c.gridy =2;
        c.gridwidth = 1; //dos columnas de ancho
        c.gridheight =1; //dos filas de alto
        c.insets = new Insets(0, 30, 0, 30); // Espacio de 10 píxeles a la izquierda
        westPanel.add(westFizzBuzzLabel, c);
        c.gridx =0;
        c.gridy =3;
        c.gridwidth = 1; //dos columnas de ancho
        c.gridheight =1; //dos filas de alto
        c.insets = new Insets(0, 30, 0, 30); // Espacio de 10 píxeles a la izquierda
        westPanel.add(westNoneLabel, c);

        // Configuración de fuente
        Font westFont = new Font("Arial", Font.BOLD, 20); // Fuente, estilo y tamaño
        westFizzLabel.setFont(westFont);
        westBuzzLabel.setFont(westFont);
        westFizzBuzzLabel.setFont(westFont);
        westNoneLabel.setFont(westFont);

        /**CENTER PANEL**/
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());

        JLabel centerFizzLabel = new JLabel("Fizz");
        JLabel centerBuzzLabel = new JLabel("Buzz");
        JLabel centerFizzBuzzLabel = new JLabel("FizzBuzz");
        JLabel centerNoneLabel = new JLabel("None");

        JList<Integer> centerFizzList = new JList<>();
        JScrollPane fizzScrollPane = new JScrollPane(centerFizzList);
        JList<Integer> centerBuzzList = new JList<>();
        JScrollPane buzzScrollPane = new JScrollPane(centerBuzzList);
        JList<Integer> centerFizzBuzzList = new JList<>();
        JScrollPane fizzBuzzScrollPane = new JScrollPane(centerFizzBuzzList);
        JList<Integer> centerNoneList = new JList<>();
        JScrollPane noneScrollPane = new JScrollPane(centerNoneList);

        c.gridx = 0;
        c.gridy = 0;
        c.gridheight=1;
        c.gridwidth =1;
        c.weightx = 1.0; // expandir en dirección x
        c.weighty = 1.0; // expandir en dirección y
        c.fill = GridBagConstraints.BOTH; // expandir en ambas direcciones
        centerPanel.add(centerFizzLabel, c);

        c.gridx = 0;
        c.gridy = 2;
        c.gridheight=3;
        c.gridwidth =1;
        c.weightx = 1.0; // expandir en dirección x
        c.weighty = 3.0; // expandir en dirección y
        c.fill = GridBagConstraints.BOTH; // expandir en ambas direcciones
        c.insets = new Insets(0, 0, 30, 30); // Espacio de 10 píxeles a la derecha
        centerPanel.add(fizzScrollPane, c);

        c.gridx = 1;
        c.gridy = 0;
        c.gridheight=1;
        c.gridwidth =1;
        c.weightx = 1.0; // expandir en dirección x
        c.weighty = 1.0; // expandir en dirección y
        c.fill = GridBagConstraints.BOTH; // expandir en ambas direcciones
        centerPanel.add(centerBuzzLabel, c);

        c.gridx = 1;
        c.gridy = 2;
        c.gridheight=3;
        c.gridwidth =1;
        c.weightx = 1.0; // expandir en dirección x
        c.weighty = 3.0; // expandir en dirección y
        c.fill = GridBagConstraints.BOTH; // expandir en ambas direcciones
        c.insets = new Insets(0, 0, 30, 30); // Espacio de 10 píxeles a la derecha
        centerPanel.add(buzzScrollPane, c);

        c.gridx = 2;
        c.gridy = 0;
        c.gridheight=1;
        c.gridwidth =1;
        c.weightx = 1.0; // expandir en dirección x
        c.weighty = 1.0; // expandir en dirección y
        c.fill = GridBagConstraints.BOTH; // expandir en ambas direcciones
        centerPanel.add(centerFizzBuzzLabel, c);

        c.gridx = 2;
        c.gridy = 2;
        c.gridheight=3;
        c.gridwidth =1;
        c.weightx = 1.0; // expandir en dirección x
        c.weighty = 3.0; // expandir en dirección y
        c.fill = GridBagConstraints.BOTH; // expandir en ambas direcciones
        c.insets = new Insets(0, 0, 30, 30); // Espacio de 10 píxeles a la derecha
        centerPanel.add(fizzBuzzScrollPane, c);

        c.gridx = 3;
        c.gridy = 0;
        c.gridheight=1;
        c.gridwidth =1; c.weightx = 1.0; // expandir en dirección x
        c.weighty = 1.0; // expandir en dirección y
        c.fill = GridBagConstraints.BOTH; // expandir en ambas direcciones

        centerPanel.add(centerNoneLabel, c);

        c.gridx = 3;
        c.gridy = 2;
        c.gridheight=3;
        c.gridwidth =1;
        c.weightx = 1.0; // expandir en dirección x
        c.weighty = 3.0; // expandir en dirección y
        c.fill = GridBagConstraints.BOTH; // expandir en ambas direcciones
        c.insets = new Insets(0, 0, 30, 30); // Espacio de 10 píxeles a la derecha
        centerPanel.add(noneScrollPane, c);

        this.add(centerPanel, BorderLayout.CENTER);

        /**ACTION LISTENER**/
        goButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("fizzBuzz.obj"))){

                    FizzBuzz fb = (FizzBuzz) ois.readObject();
                    ArrayList<Integer> fizzList = new ArrayList<>();
                    fizzList = fb.getFizzList();
                    westFizzCounter = fizzList.size();

                    ArrayList<Integer> buzzList = new ArrayList<>();
                    buzzList = fb.getBuzzList();
                    westBuzzCounter = buzzList.size();

                    ArrayList<Integer> fizzBuzzList = new ArrayList<>();
                    fizzBuzzList = fb.getFizzBuzzList();
                    westFizzBuzzCounter = fizzBuzzList.size();

                    ArrayList<Integer> noneList = new ArrayList<>();
                    noneList = fb.getNoneList();
                    westNoneCounter = noneList.size();

                    westFizzLabel.setText("Fizz: "+westFizzCounter+" numbers");
                    westBuzzLabel.setText("Buzz: "+westBuzzCounter+" numbers");
                    westFizzBuzzLabel.setText("FizzBuzz: "+westFizzBuzzCounter+" numbers");
                    westNoneLabel.setText("None: "+westNoneCounter+" numbers");

                }catch (IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });



        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridBagLayout());


        this.setVisible(true);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
