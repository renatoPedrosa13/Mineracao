/**
 * @author selvarpv
 */
public class Contador {
    
    private int numeroAtual = 0;
    private String nome;
    
    public Contador(String nome){
        this.nome = nome;
    }
    public void contar(){
        numeroAtual++;
    }
    public String toString(){
        return nome +" = " + numeroAtual;
    }
            
}
