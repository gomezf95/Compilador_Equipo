/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author Edaniel
 */
public class interfaz extends javax.swing.JFrame {

    
    a_lexico al= new a_lexico();
    tabla_simbolos ts= new tabla_simbolos();
    n_tabla inicio;
    String codigo;
    
    public interfaz() {
        codigo="";
        initComponents();
        jTextArea1.getLineCount();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Compilador");
        setMaximumSize(new java.awt.Dimension(900, 700));
        setMinimumSize(new java.awt.Dimension(900, 700));
        setPreferredSize(new java.awt.Dimension(900, 700));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        getContentPane().setLayout(null);

        jButton1.setText("Guardar y Analizar");
        jButton1.setActionCommand("");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(284, 11, 101, 25);

        jButton2.setText("Guardar");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(391, 11, 93, 25);

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(763, 11, 85, 25);

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setText("Tabla de Simbolos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(616, 11, 141, 25);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(49, 45, 828, 383);

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 478, 867, 141);

        jLabel1.setText("Output - Codigo (run)");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 446, 144, 14);

        jButton5.setText("Mostrar");
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(486, 11, 99, 25);

        jTextArea3.setColumns(20);
        jTextArea3.setLineWrap(true);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(0, 46, 40, 380);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jTextArea2.setVisible(false);
        jLabel1.setVisible(false);
        
    }//GEN-LAST:event_formWindowOpened

    public String get_codigo(){
        return codigo;
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    if(jTextArea1.getText().equals(""))//condicional para cargar codigo guardado en caso de que este vacia el area de trabajo
        {
            cargar();
        }
        else//si tiene algo entonces guarda lo que tiene el area de trabajo
        {
            guardar();
        }
        
        jLabel1.setVisible(true);
        jTextArea2.setVisible(true);
        try {
            String linea, terminal="", codigo="", sep, str="", line_pc="";
            boolean flag=false;
            int line=0;
            
            //codigo para cargar el codigo guardado en el archivo en el buffer 
            BufferedReader br = null;
            br = new BufferedReader (new FileReader ("Codigo.txt"));
            while((linea= br.readLine()) != null)
            {
                codigo+=linea+"\n";
            }
            //codigo para separar el codigo en saltos de linea
            StringTokenizer sl=new StringTokenizer(codigo, "\n");
            while(sl.hasMoreElements())
            {
                line++;
                //codigo para separar las lineas de codigo del ;
                StringTokenizer pc=new StringTokenizer (sl.nextToken(), ";");
                while(pc.hasMoreElements())
                {
                    //llamada al metodo que separa los signos de las lineas de codigo
                    sep=separar(pc.nextToken());
//                    System.out.println(sep);
                    //codigo para separar el codigo en espacios y mandarlos al analizador lexico
                    StringTokenizer esp=new StringTokenizer(sep);
                    while(esp.hasMoreElements())
                    {
                        if(flag)
                        {
                            str+=esp.nextToken();
                            if(str.charAt(str.length()-1)=='"')
                            {
                                terminal+=al.a_token(str, line)+"\n";
                                flag=false;
                            }
                            else
                            {
                                if(!esp.hasMoreElements())
                                {
                                    terminal+=al.a_token(str, line)+"\n";
                                    flag=false;
                                }
                            }
                        }
                        else
                        {
                            str=esp.nextToken();
                            if(str.charAt(0)=='"')
                            {
                                if(str.charAt(str.length()-1)=='"')
                                {
                                    terminal+=al.a_token(str, line)+"\n";
                                }
                                else
                                {
                                    flag=true;
                                }
                            }
                            else
                            {
                                terminal+=al.a_token(str, line)+"\n";
                            }
                        }
                    }
                }
            System.out.println();
            al.comentario_dd=true;
            }
            //Codigo para quitarle los saltos de linea que tiene la cadena terminal
                StringTokenizer ter= new StringTokenizer(terminal, "\n");
                terminal="";
                while(ter.hasMoreElements())
                {
                    terminal+=ter.nextToken()+"\n";
                }
            this.inicio=al.inicio;
            //codigo para imprimir la salida en la terminal
            if(terminal.equals(""))
            {
                jTextArea2.setForeground(Color.GREEN);
                jTextArea2.setText("Ejecucion exitosa");
            }
            else
            {
                jTextArea2.setForeground(Color.RED);
                jTextArea2.setText(terminal);
            }
            
        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    //metodo para separar con espacios los signos igual, aritmeticos,  parentesis 
    public String separar(String token)
    {
        String resultado="";
        
        for(int x=0; x<token.length();x++)
        {
            if(token.charAt(x)=='=' || token.charAt(x)=='(' || token.charAt(x)==')' || 
               token.charAt(x)=='+' || token.charAt(x)=='-' || token.charAt(x)=='*' || 
               token.charAt(x)=='/' || token.charAt(x)=='<' || token.charAt(x)== '>'||
               token.charAt(x)=='{' || token.charAt(x)=='}')
            {
                if(token.length()-x >= 2)
                {
                    if(token.charAt(x)=='/' && token.charAt(x+1)=='/')
                    {
                        resultado+=" "+token.charAt(x)+token.charAt(x+1)+" ";
                        x++;
                    }
                    else
                    {
                        if(token.charAt(x)=='/' && token.charAt(x+1)=='*')
                        {
                            resultado+=" "+token.charAt(x)+token.charAt(x+1)+" ";
                            x++;   
                        }
                        else
                        {
                            if(token.charAt(x)=='*' && token.charAt(x+1)=='/')
                            {
                                resultado+=" "+token.charAt(x)+token.charAt(x+1)+" ";
                                x++;
                            }
                            else
                            {
                                if(token.charAt(x)=='>' && token.charAt(x+1)=='=')
                                {
                                     resultado+=" "+token.charAt(x)+token.charAt(x+1)+" ";
                                    x++;
                                }
                                else
                                {
                                    if(token.charAt(x)=='<' && token.charAt(x+1)=='=')
                                    {
                                        resultado+=" "+token.charAt(x)+token.charAt(x+1)+" ";
                                        x++;
                                    }
                                    else
                                    {
                                        if(token.charAt(x)=='>' && token.charAt(x+1)=='<')
                                        {
                                            resultado+=" "+token.charAt(x)+token.charAt(x+1)+" ";
                                            x++;
                                        }
                                        else
                                        {
                                            if(token.charAt(x)=='=' && token.charAt(x+1)=='=')
                                            {
                                                resultado+=" "+token.charAt(x)+token.charAt(x+1)+" ";
                                                x++;
                                            }
                                            else
                                            {     
                                                resultado+=" "+token.charAt(x)+" ";  
                                            }
                                        }
                                    }
                                }                               
                            }
                        }
                    }
                }
                else
                {
                    resultado+=" "+token.charAt(x)+" ";
                }

            }
            else
            {
                resultado+=token.charAt(x)+""; 
            }
        }
        
        return resultado;
    }
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        cargar();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        guardar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ts.g_inicio(inicio);
        ts.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        String lines="";
        for(int i=1; i<=jTextArea1.getLineCount();i++)
        {
            lines+=i+"\n";
        }
        jTextArea3.setText(lines);
    }//GEN-LAST:event_formMouseMoved

        public void cargar()
    {
        jTextArea1.setText("");
        try {
            String linea, codigo="";
            BufferedReader br = null;
            br = new BufferedReader (new FileReader ("Codigo.txt"));
            while((linea= br.readLine()) != null)
            {
                codigo+=linea+"\n";
            }
            jTextArea1.setText(codigo);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void guardar()
    {
                FileWriter fw;
            try
            {
                fw= new FileWriter("Codigo.txt");
                fw.write(jTextArea1.getText());
                fw.close();
            }
            catch(IOException io)
            {
                  System.out.println(io.getMessage());
            }
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    // End of variables declaration//GEN-END:variables
}
