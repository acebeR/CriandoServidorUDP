package DTO;

public class Servico {
	
	private String servidor, ip, porta, descricao;

    public Servico(String s, String i, String p, String d){
        this.servidor = s;
        this.ip = i;
        this.porta = p;
        this.descricao = d;
    }

    public String getServidor(){
        return servidor;
    }

    public void setServidor(String servidor){
        this.servidor = servidor;
    }

    public String getIp(){
        return ip;
    }

    public void setIp(String ip){
        this.ip = ip;
    }

    public String getPorta(){
        return porta;
    }

    public void setPorta(String porta){
        this.porta = porta;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

}
