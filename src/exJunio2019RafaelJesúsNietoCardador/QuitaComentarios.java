package exJunio2019RafaelJesúsNietoCardador;
/**
* Examen Junio 2019 	
* @author Rafael Nieto
*/

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class QuitaComentarios {

  private JFrame frm;
  private JTextField rutaOriginal;
  private JTextField rutaNuevo;
  
  private File fOrigen;
  private File fDestino;
  
  static String parametro1 = "";
  static String parametro2 = "";
  
  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    /*No se puede acceder al array args debido a que es estático, así que para hacer que
     * que el resto de métodos puedan acceder a los parámetros, usamos otro método.
    */
    if (args.length > 2) {
      JOptionPane.showMessageDialog(null, "ERROR: Número de parámetros incorrecto.");
      System.exit(0);
    }
    try {
      almacenarParametros(args[0], 1);
      almacenarParametros(args[1], 2);
      
    }catch (ArrayIndexOutOfBoundsException e) {
      
    }
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          QuitaComentarios window = new QuitaComentarios();
          window.frm.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
  /**
   * Este método almacena los parámetros introducidos por línea de comandos en
   * unas variables accesibles para todos los métodos.
   * @param argumento1
   * @param num
   */
  public static void almacenarParametros(String argumento1, int num) {
    if (num == 1) {
      parametro1 = argumento1;
    }else {
      parametro2 = argumento1;
    }
  }

  /**
   * Create the application.
   */
  public QuitaComentarios() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frm = new JFrame();
    frm.setTitle("");
    frm.setBounds(100, 100, 743, 418);
    frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frm.getContentPane().setLayout(null);
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(10, 146, 330, 234);
    frm.getContentPane().add(scrollPane);
    
  //En este TextArea aparecerá el contenido del fichero original
    JTextArea programaOriginal = new JTextArea();
    programaOriginal.setEditable(false);
    scrollPane.setViewportView(programaOriginal);
    
    JScrollPane scrollPane_1 = new JScrollPane();
    scrollPane_1.setBounds(408, 146, 317, 234);
    frm.getContentPane().add(scrollPane_1);
    
    
    //En este TextArea aparecerá el contenido del fichero destino
    JTextArea programaNuevo = new JTextArea();
    programaNuevo.setEditable(false);
    scrollPane_1.setViewportView(programaNuevo);
    
    JLabel lblNewLabel = new JLabel("Programa original");
    lblNewLabel.setEnabled(true);
    lblNewLabel.setBounds(105, 11, 123, 14);
    frm.getContentPane().add(lblNewLabel);
    
    //Este botón se encargará de almacenar en un JTextField la ruta del fichero destino
    JButton btnNewButton = new JButton("Selecciona el nuevo fichero");
    if(parametro2 != "") {
      btnNewButton.setEnabled(false);
    }else {
      btnNewButton.setEnabled(true);
    }
    btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int fileC = fileChooser.showOpenDialog(frm);
        if (fileC == JFileChooser.APPROVE_OPTION) {
          fDestino = fileChooser.getSelectedFile();
          rutaNuevo.setText(fDestino.getAbsolutePath());
        }
      }
    });
    btnNewButton.setBounds(475, 36, 197, 54);
    frm.getContentPane().add(btnNewButton);
    
    rutaOriginal = new JTextField();
    rutaOriginal.setEnabled(true);
    rutaOriginal.setFont(new Font("Tahoma", Font.PLAIN, 10));
    rutaOriginal.setEditable(false);
    rutaOriginal.setBounds(10, 102, 293, 20);
    frm.getContentPane().add(rutaOriginal);
    rutaOriginal.setColumns(10);
    rutaOriginal.setText(parametro1);
    if(parametro1 != "") {
      try {
        BufferedReader brp1 = new BufferedReader(new FileReader(rutaOriginal.getText()));
        brp1.close(); 
      }catch (FileNotFoundException e) {
        JOptionPane.showMessageDialog(null, "ERROR: Fichero no encontrado.");
        System.exit(0);
      } catch (IOException e1) {
        JOptionPane.showMessageDialog(null, "Error en la lectura del fichero.");
        System.exit(0);
      }   
    }  
    JLabel lblNewLabel_1 = new JLabel("Nuevo programa");
    lblNewLabel_1.setBounds(529, 11, 123, 14);
    frm.getContentPane().add(lblNewLabel_1);
    
    //Este botón se encargará de introducir en un JTextField la ruta del fichero original
    JButton btnNewButton_1 = new JButton("Selecciona el programa");
    if(parametro1 != "") {
      btnNewButton_1.setEnabled(false);
    }else {
      btnNewButton_1.setEnabled(true);
    }
    btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
    btnNewButton_1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int fileC = fileChooser.showOpenDialog(frm);
        if (fileC == JFileChooser.APPROVE_OPTION) {
          fOrigen = fileChooser.getSelectedFile();
          rutaOriginal.setText(fOrigen.getAbsolutePath());
        }
      }
    });
    btnNewButton_1.setBounds(67, 36, 197, 54);
    frm.getContentPane().add(btnNewButton_1);
    
    rutaNuevo = new JTextField();
    rutaNuevo.setFont(new Font("Tahoma", Font.PLAIN, 10));
    rutaNuevo.setEditable(false);
    rutaNuevo.setBounds(446, 101, 279, 20);
    frm.getContentPane().add(rutaNuevo);
    rutaNuevo.setColumns(10);
    rutaNuevo.setText(parametro2);
    if(parametro2 != "") {
      try {
        BufferedReader brp2 = new BufferedReader(new FileReader(rutaNuevo.getText()));
        brp2.close(); 
      }catch (FileNotFoundException e) {
        JOptionPane.showMessageDialog(null, "ERROR: Fichero no encontrado.");
        System.exit(0);
      } catch (IOException e1) {
        JOptionPane.showMessageDialog(null, "Error en la lectura del fichero.");
        System.exit(0);
      }
      
    }
    
    
    //Este botón se encargará de modificar los JTextArea y el fichero destino
    JButton btnNewButton_2 = new JButton("Ejecutar");
    btnNewButton_2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        try {
		  programaNuevo.setText("");
		  programaOriginal.setText("");
          String contenidoPrograma = "";
          BufferedReader br = new BufferedReader(new FileReader(rutaOriginal.getText()));
          BufferedWriter bw = new BufferedWriter(new FileWriter(rutaNuevo.getText()));
          
          ArrayList<String> arrayPrograma= new ArrayList<String>();

          String linea = "";
          arrayPrograma.add("");
          while (linea != null) {
            linea = br.readLine();
            if (linea != null) {
              contenidoPrograma += linea+"\n";
              arrayPrograma.add(linea);
            }
          }
          br.close();
          
          programaOriginal.append(contenidoPrograma);
          boolean cuentaComentariosBloque = false;
          int recuerdaLinea = 0;
          
          
          for(int i = 0; i <arrayPrograma.size(); i++) {
            for(int j = 0; j < arrayPrograma.get(i).length(); j++) {
              if(arrayPrograma.get(i).charAt(j) == '/') {
                if(j+1 < arrayPrograma.get(i).length()) {
                  if(arrayPrograma.get(i).charAt(j+1) == '/' ) {
                    arrayPrograma.remove(i);
                    i--;
                  }else if(arrayPrograma.get(i).charAt(j+1) == '*') {
                      cuentaComentariosBloque = true;
                      recuerdaLinea = i;
                    }
                }
              }else if(arrayPrograma.get(i).charAt(j) == '*') {
                if(j+1 < arrayPrograma.get(i).length()) {
                  if(arrayPrograma.get(i).charAt(j+1) == '/' &&  cuentaComentariosBloque) {
                    for(int k = 0; k < i-recuerdaLinea+1;  k++) {
                      arrayPrograma.remove(recuerdaLinea);
                    }
                    cuentaComentariosBloque = false;
                    i = recuerdaLinea;
                  }
                }
              }
            }
          }
          
          for(int i = 1; i < arrayPrograma.size(); i++) {
            bw.write(arrayPrograma.get(i));
            bw.newLine();
          }
          
          bw.close();
          
          BufferedReader br2 = new BufferedReader(new FileReader(rutaNuevo.getText()));
          
          linea = "";
          contenidoPrograma = "";
          while (linea != null) {
            linea = br2.readLine();
            if (linea != null) {
              contenidoPrograma += linea + "\n";
            }
          }
          programaNuevo.append(contenidoPrograma);
          
          br2.close();
          
          JOptionPane.showMessageDialog(null, "Comentarios exterminados.");
          
          
        } catch (FileNotFoundException e) {
          JOptionPane.showMessageDialog(null, "ERROR: Fichero no encontrado.");
        } catch (IOException e) {
          JOptionPane.showMessageDialog(null, "Error al leer el fichero.");
        } 
        
      }
    });
    btnNewButton_2.setBounds(313, 22, 123, 50);
    frm.getContentPane().add(btnNewButton_2);
    
    //Este botón se encargará de cerrar el programa
    JButton btnNewButton_3 = new JButton("Terminar");
    btnNewButton_3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        frm.dispose();
      }
    });
    btnNewButton_3.setBounds(313, 71, 123, 50);
    frm.getContentPane().add(btnNewButton_3);
    
    try {
      BufferedReader brautor = new BufferedReader(new FileReader ("autor.txt"));
      frm.setTitle(brautor.readLine());
      brautor.close();
    }catch(FileNotFoundException ex) {
      JOptionPane.showMessageDialog(null, "ERROR: Fichero 'autor.txt' no encontrado.");
      System.exit(0);
    } catch (IOException e1) {
      JOptionPane.showMessageDialog(null, "Error al leer el fichero.");
    }
    
    
  }
}
