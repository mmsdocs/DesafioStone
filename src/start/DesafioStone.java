package start;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import tarefas.TaskIcognita;
import tarefas.TaskLabirinto;
import tarefas.TaskMinerador;
import tarefas.TaskNovoProblema;
import tarefas.TaskPalavra;

public class DesafioStone {

    public static void main(String[] args) 
    {
        
//        TaskNovoProblema novoProblema = new TaskNovoProblema("Novo Problema - Força Bruta");
//        TaskIcognita aIcognita = new TaskIcognita("A Icognita - Força Bruta");
//        TaskPalavra aPalavra = new TaskPalavra("A Palavra - Força Bruta");
        TaskLabirinto oLabirinto = new TaskLabirinto("O Labirinto - Força Bruta");
//        TaskMinerador oMinerador = new TaskMinerador("O Minerador - Força Bruta");
        
        System.out.println("Iniciando Threads");
//        
        ExecutorService threadExecutor = Executors.newFixedThreadPool(3);
//              
//        threadExecutor.execute(aPalavra);
//        threadExecutor.execute(aIcognita);
//        threadExecutor.execute(novoProblema); 
        threadExecutor.execute(oLabirinto); 
//        threadExecutor.execute(oMinerador);
        
        threadExecutor.shutdown();
    }
    
}
