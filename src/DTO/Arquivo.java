package DTO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivo {
	public List<Servico> readFile(String arq){
        List<Servico> lista = new ArrayList<Servico>();
        String[] temp = new String[4];

        try{
            FileReader fr = new FileReader(arq);
            BufferedReader in = new BufferedReader(fr);
            String line = in.readLine();

            while(line != null){
                for(int i = 0; i < 4; i++){
                    if(line == null)
                        System.err.println("Faltam informaÁıes no arquivo");
                    else{
                        temp[i] = line;
                        temp[i] = temp[i].replace("<", "");
                        temp[i] = temp[i].replace(">", "");
                        line = in.readLine();
                    }
                }

                Servico s = new Servico(temp[0], temp[1], temp[2], temp[3]);
                lista.add(s);
                line = in.readLine();

            }
            in.close();
        }catch (IOException e){
            System.err.printf("Erro na abertura do arquivo: %s.\n",
            e.getMessage());
        }
        return lista;
    }
}
