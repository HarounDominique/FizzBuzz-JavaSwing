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

    boolean active = true;
    int westFizzCounter = 0;
    int westBuzzCounter = 0;
    int westFizzBuzzCounter = 0;
    int westNoneCounter = 0;
    ArrayList<Integer> centerFizzArray = new ArrayList<>();
    JList<Integer> centerFizzList;
    JScrollPane fizzScrollPane;
    JList<Integer> centerBuzzList;
    JScrollPane buzzScrollPane;
    JList<Integer> centerFizzBuzzList;
    JScrollPane fizzBuzzScrollPane;
    JList<Integer> centerNoneList;
    JScrollPane noneScrollPane;

    JLabel westFizzLabel;
    JLabel westBuzzLabel;
    JLabel westFizzBuzzLabel;
    JLabel westNoneLabel;

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
        c.gridheight = 2; //dos filas de alto
        c.weightx = 1.0; // expandir en dirección x
        c.weighty = 1.0; // expandir en dirección y

        // Configuración de tamaño preferido
        Dimension buttonSize = new Dimension(100, 100); // Ancho y alto en píxeles
        goButton.setPreferredSize(buttonSize);
        if(active){goButton.isEnabled();}

        northPanel.add(goButton, c);

        JLabel titleLabel = new JLabel("FIZZBUZZ!");
        c.gridx = 2; //columna 2
        c.gridy = 0; //fila 0
        c.gridwidth = 6; //dos columnas de ancho
        c.gridheight = 2; //dos filas de alto
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

        westFizzLabel = new JLabel("Fizz: " + westFizzCounter + " numbers");
        westBuzzLabel = new JLabel("Buzz: " + westBuzzCounter + " numbers");
        westFizzBuzzLabel = new JLabel("FizzBuzz: " + westFizzBuzzCounter + " numbers");
        westNoneLabel = new JLabel("None: " + westNoneCounter + " numbers");

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(0, 30, 0, 10);

        westPanel.add(westFizzLabel, c);

        c.gridx = 0;
        c.gridy = 1;

        westPanel.add(westBuzzLabel, c);

        c.gridx = 0;
        c.gridy = 2;

        westPanel.add(westFizzBuzzLabel, c);

        c.gridx = 0;
        c.gridy = 3;

        westPanel.add(westNoneLabel, c);

        Font font = new Font("Arial", Font.BOLD, 20);
        westFizzLabel.setFont(font);
        westBuzzLabel.setFont(font);
        westFizzBuzzLabel.setFont(font);
        westNoneLabel.setFont(font);

        /**CENTER PANEL**/
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        this.add(centerPanel, BorderLayout.CENTER);

        // Etiquetas para indicar el nombre de cada columna
        JLabel fizzLabel = new JLabel("Fizz");
        JLabel buzzLabel = new JLabel("Buzz");
        JLabel fizzBuzzLabel = new JLabel("FizzBuzz");
        JLabel noneLabel = new JLabel("None");

        fizzLabel.setFont(font);
        buzzLabel.setFont(font);
        fizzBuzzLabel.setFont(font);
        noneLabel.setFont(font);

        fizzScrollPane = new JScrollPane();
        fizzScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        fizzScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        fizzScrollPane.setPreferredSize(new Dimension(100, 200));

        buzzScrollPane = new JScrollPane();
        buzzScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        buzzScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        buzzScrollPane.setPreferredSize(new Dimension(100, 200));

        fizzBuzzScrollPane = new JScrollPane();
        fizzBuzzScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        fizzBuzzScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        fizzBuzzScrollPane.setPreferredSize(new Dimension(100, 200));

        noneScrollPane = new JScrollPane();
        noneScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        noneScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        noneScrollPane.setPreferredSize(new Dimension(100, 200));

        centerFizzList = new JList<>();
        centerFizzList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        centerFizzList.setLayoutOrientation(JList.VERTICAL);
        centerFizzList.setVisibleRowCount(-1);
        centerFizzList.setFixedCellWidth(100);
        centerFizzList.setFixedCellHeight(20);

        centerBuzzList = new JList<>();
        centerBuzzList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        centerBuzzList.setLayoutOrientation(JList.VERTICAL);
        centerBuzzList.setVisibleRowCount(-1);
        centerBuzzList.setFixedCellWidth(100);
        centerBuzzList.setFixedCellHeight(20);

        centerFizzBuzzList = new JList<>();
        centerFizzBuzzList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        centerFizzBuzzList.setLayoutOrientation(JList.VERTICAL);
        centerFizzBuzzList.setVisibleRowCount(-1);
        centerFizzBuzzList.setFixedCellWidth(100);
        centerFizzBuzzList.setFixedCellHeight(20);

        centerNoneList = new JList<>();
        centerNoneList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        centerNoneList.setLayoutOrientation(JList.VERTICAL);
        centerNoneList.setVisibleRowCount(-1);
        centerNoneList.setFixedCellWidth(100);
        centerNoneList.setFixedCellHeight(20);

        fizzScrollPane.setViewportView(centerFizzList);
        buzzScrollPane.setViewportView(centerBuzzList);
        fizzBuzzScrollPane.setViewportView(centerFizzBuzzList);
        noneScrollPane.setViewportView(centerNoneList);

        GridBagConstraints cs = new GridBagConstraints();
        cs.insets = new Insets(0, 60, 0, 60);
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        cs.gridheight = 1;
        cs.weightx = 1.0;
        cs.weighty = 0.33;
        cs.fill = GridBagConstraints.BOTH;

        centerPanel.add(fizzLabel, cs);

        cs.gridx = 1;
        centerPanel.add(buzzLabel, cs);

        cs.gridx = 2;
        centerPanel.add(fizzBuzzLabel, cs);

        cs.gridx = 3;
        centerPanel.add(noneLabel, cs);

        cs.gridx = 0;
        cs.gridy = 1;
        cs.weighty = 0.67;
        cs.gridwidth = 1;
        cs.insets = new Insets(0, 30, 30, 30);

        centerPanel.add(fizzScrollPane, cs);

        cs.gridx = 1;
        cs.gridy = 1;
        centerPanel.add(buzzScrollPane, cs);

        cs.gridx = 2;
        cs.gridy = 1;
        centerPanel.add(fizzBuzzScrollPane, cs);

        cs.gridx = 3;
        cs.gridy = 1;
        centerPanel.add(noneScrollPane, cs);

        /**ACTION LISTENER**/

        goButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(active){
                    processNumbers();
                    active = false;
                }
            }
        });

        /**FRAME CONFIG**/
        this.setTitle("FizzBuzz");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 800);
        //this.setResizable(false);
        this.setVisible(true);
    }

    private void processNumbers() {
        DefaultListModel<Integer> fizzBuzzListModel = new DefaultListModel<>();
        DefaultListModel<Integer> fizzListModel = new DefaultListModel<>();
        DefaultListModel<Integer> buzzListModel = new DefaultListModel<>();
        DefaultListModel<Integer> noneListModel = new DefaultListModel<>();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("fizzBuzz.obj"))){
            FizzBuzz fb = (FizzBuzz)ois.readObject();
            ArrayList<Integer> auxFizzBuzz = fb.getFizzBuzzList();
            for(int i = 0; i< auxFizzBuzz.size(); i++){
                fizzBuzzListModel.addElement(auxFizzBuzz.get(i));
                westFizzBuzzCounter++;
            }

            ArrayList<Integer> auxFizz = fb.getFizzList();
            for(int i = 0; i< auxFizz.size(); i++){
                fizzListModel.addElement(auxFizz.get(i));
                westFizzCounter++;
            }

            ArrayList<Integer> auxBuzz = fb.getBuzzList();
            for(int i = 0; i< auxBuzz.size(); i++){
                buzzListModel.addElement(auxBuzz.get(i));
                westBuzzCounter++;
            }

            ArrayList<Integer> auxNone = fb.getNoneList();
            for(int i = 0; i< auxNone.size(); i++){
                noneListModel.addElement(auxNone.get(i));
                westNoneCounter++;
            }

        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        centerFizzBuzzList.setModel(fizzBuzzListModel);
        centerFizzList.setModel(fizzListModel);
        centerBuzzList.setModel(buzzListModel);
        centerNoneList.setModel(noneListModel);

        updateCounters();
    }

    private void updateCounters() {
        westFizzLabel.setText("Fizz: " + westFizzCounter + " numbers");
        westBuzzLabel.setText("Buzz: " + westBuzzCounter + " numbers");
        westFizzBuzzLabel.setText("FizzBuzz: " + westFizzBuzzCounter + " numbers");
        westNoneLabel.setText("None: " + westNoneCounter + " numbers");
    }
}
