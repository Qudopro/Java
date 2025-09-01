package com.qudopro.ch25;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;

public class ReadServerFile extends JFrame {
    private JTextField enterField;              //JTextField to enter site name
    private JEditorPane contentsArea;           //To display website

    public ReadServerFile(){
        super("Simply Web Browser");

        //Create enterField and register its listener
        enterField = new JTextField("Enter file URL here");
        enterField.addActionListener(new ActionListener() {
            //Get document specified by user
            @Override
            public void actionPerformed(ActionEvent e) {
                getThePage(e.getActionCommand());               //Get the string from user
            }
        });

        add(enterField, BorderLayout.NORTH);

        contentsArea = new JEditorPane();               //Capaz de soportar texto plano y HTML
        contentsArea.setEditable(false);
        contentsArea.addHyperlinkListener(new HyperlinkListener() {                 //Procesamiento de hipervinculos
            //If user clicked hyperlink, go to specified page
            @Override
            public void hyperlinkUpdate(HyperlinkEvent e) {                         //Ocurre un HyperlinkEvent
                if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED)          //Tipo de evento ocurrido
                    getThePage(e.getURL().toString());                              //Obtiene la URL representada por el hipervínculo
            }
        });

        add(new JScrollPane(contentsArea), BorderLayout.CENTER);
        setSize(400, 400);
        setVisible(true);
    }

    //Load Document
    private void getThePage(String location){
        try{
            //Load Document and display location
            contentsArea.setPage(location);                     //Descarga el documento espeficado
            enterField.setText(location);
        } catch (IOException e) {                               //Error en la descarga del archivo
            JOptionPane.showMessageDialog(this, "Error retrieving specified URL", "Bad URL",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}

/*
EventType contiene tres constantes
    ACTIVATED. Hipervínculo para cambiar a otra página
    ENTERED. El usuario movió el mouse sobre el hipervínculo
    EXITED. El usurio movió el mouse afuera del hipervínculo
 */