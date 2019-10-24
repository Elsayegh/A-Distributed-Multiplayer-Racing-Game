import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class GokartClient {
    private JFrame frame = new JFrame("GO Karte");
    private JLabel messageLabel = new JLabel("...");

    private Socket socket;
    private Scanner in;
    private PrintWriter out;
     
    public GokartClient(String serverAddress) throws Exception {

        socket = new Socket(serverAddress, 58901);
        in = new Scanner(socket.getInputStream());
        out = new PrintWriter(socket.getOutputStream(), true);

        messageLabel.setBackground(Color.lightGray);
        frame.getContentPane().add(messageLabel, BorderLayout.SOUTH);
   }


          
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Pass the server IP as the sole command line argument");
            return;
        }
        GokartClient client = new GokartClient(args[0]);
        client.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        client.frame.setSize(320, 320);
        client.frame.setVisible(true);
        client.frame.setResizable(false);
            }
}