package tarefas;

import auxilio.Dicionario;
import com.theromus.sha.Keccak;
import static start.test.getByteArray;
import static start.test.getHexStringByByteArray;

public class TaskPalavra implements Runnable{
    
    private final String threadName;
    
    public TaskPalavra(String name)
    {
        threadName = name;
    }
    
    private int a_palavra(String palavra)
    {
        byte[] b = getByteArray(palavra);
        
        String palavraConvertida = getHexStringByByteArray(b);
        
        Keccak keccak = new Keccak(1600);
        
        return "2e4588766bcfa3508dfb56a344fd7b1c3eca4954b2b8b795ab02209396528367".equals(keccak.getHash(palavraConvertida, 1088, 32)) ? 2 : 0;
    }    
    
    @Override
    public void run() 
    {
        System.out.println("Disparando Thread " + threadName);
        
        final int tamanhoPalavra = 5;
        Dicionario dicionario = new Dicionario("./src/recursos");
        
        dicionario.listaDePalavras(tamanhoPalavra);
        
        System.out.println("Tamanho Lista de Palavras : " + dicionario.palavras.size());
        
        for (String palavra : dicionario.palavras) {
            if(a_palavra(palavra) == 2)
            {
                System.out.println("A palavra eh : " + palavra);
                break;
            }
        }
    }
    
}
