package servidor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.omg.IOP.Encoding;

import DTO.Arquivo;
import DTO.Servico;

public class ServidorUDP{
    public static void main(String[] args) throws Exception{
    	 { 
    		 	int porta = 9876;
    			int numConn = 1;
    			
    			DatagramSocket serverSocket = new DatagramSocket(porta);
    	 
    			byte[] receiveData = new byte[1024];
    			byte[] sendData = new byte[1024];
    	 
    			while (true) {
    	 
    				DatagramPacket receivePacket = new DatagramPacket(receiveData,
    						receiveData.length);
    				System.out.println("Esperando por datagrama UDP na porta " + porta);
    				serverSocket.receive(receivePacket);
    				System.out.print("Datagrama UDP [" + numConn + "] recebido...");
    	 
    				String sentence = new String(receivePacket.getData());
    				System.out.println(sentence);
    				
    				InetAddress IPAddress = receivePacket.getAddress();
    	 
    				int port = receivePacket.getPort();
    	 			    	 			
    				sendData = lerArquivo(sentence.trim());
    	 
    				DatagramPacket sendPacket = new DatagramPacket(sendData,
    						sendData.length, IPAddress, port);
    				
    				System.out.print("Enviando " + sentence + "...");
    	 
    				serverSocket.send(sendPacket);
    				System.out.println("OK\n");
    				
    			}
		}
    	
    }
    
    public static byte[] lerArquivo(String nome) {
		Scanner ler = new Scanner(System.in);
		StringBuilder fileContent = new StringBuilder();
		
		byte[] buffer = new byte[1024];
		
		//nome = "C:/temp/doc.txt";
	 
	    System.out.printf("\nConteúdo do arquivo texto:\n");
	    try {
	      FileReader arq = new FileReader(nome);
	      BufferedReader lerArq = new BufferedReader(arq);
	 
	      String linha = lerArq.readLine();

	      while (linha != null) {
	      	fileContent.append(linha);
	      
	        System.out.printf("%s \n", linha);
	        
	        linha = lerArq.readLine(); 
	        
	        
	      }
	 
	      arq.close();
	    } catch (IOException e) {
	        System.err.printf("Erro na abertura do arquivo: %s.\n",
	          e.getMessage());
	    }
	    
	    return buffer = fileContent.toString().getBytes();
	  }
	  
	  public static String toValidFileName(String input) {
		    return input.replaceAll("[:\\\\/*\"?|<>']", "_");
		}
    
}