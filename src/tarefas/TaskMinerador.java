package tarefas;

import com.theromus.sha.Keccak;
import java.math.BigInteger;
import static start.test.getByteArray;
import static start.test.getHexStringByByteArray;

public class TaskMinerador implements Runnable{
    
    private final String threadName;
    
    public TaskMinerador(String name)
    {
        threadName = name;
    }
    
    private int o_minerador(BigInteger a)
    {
        byte[] b = getByteArray(a.toString());
//        
        String numero = getHexStringByByteArray(b);
        
        Keccak keccak = new Keccak(1600);
        String hash = keccak.getHash(numero, 1088, 32);
        int i;
        
        for (i = 0; i < 32; ++i)
        {
            if(i == 7) System.out.println("3");
            if(i == 10) System.out.println("10");
            if(i == 15) System.out.println("15");
            if (hash.charAt(i) != '0')
            {
                break;
            }
        }
        
        return i;
    }
    
    @Override
    public void run() {
        System.out.println("Disparando Thread " + threadName);
        
        BigInteger numero = new BigInteger("0");
        int resultado;
        
        while(true)
        {
            resultado = o_minerador(numero);
            
            if(resultado > 7)
            {
                System.out.println("O numero que pode ser convertido em hash eh: "  + numero);
                break;
            }
            
            numero = numero.add(new BigInteger("1"));
        }
    }
    
}
