import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

   public class GOkarteserver extends JFrame{
    public static void main(String[] args) throws Exception {
        try (var listener = new ServerSocket(58901)) {
            System.out.println("Go karte Server is Running...");
            //var pool = Executors.newFixedThreadPool(200);
            while (true) {
                Game game = new Game();
            }
        }
    }
}

class Game {

    
    private Player[] racers = new Player[2];

    Player currentPlayer;

    public boolean hasWinner() {
        return true; // if there is a winner
               
    }

    
    
    /**
     * For communication with the client the player has a socket and associated
     * Scanner and PrintWriter.
     */
    class Player implements Runnable {
        char mark;
        Player opponent;
        Socket socket;
        Scanner input;
        PrintWriter output;

        public Player(Socket socket, char mark) {
            this.socket = socket;
            this.mark = mark;
        }

        @Override
        public void run() {
            try {
                setup();
                //processCommands();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (opponent != null && opponent.output != null) {
                    opponent.output.println("OTHER_PLAYER_LEFT");
                }
                try {socket.close();} catch (IOException e) {}
            }
        }

        private void setup() throws IOException {
            input = new Scanner(socket.getInputStream());
            output = new PrintWriter(socket.getOutputStream(), true);
            output.println("WELCOME " + mark);
           }

 }
    }
