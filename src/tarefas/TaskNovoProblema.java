package tarefas;

import java.math.BigInteger;

public class TaskNovoProblema implements Runnable {
    
    private final String threadName;
    
    public TaskNovoProblema(String name)
    {
        threadName = name;
    }
    
    private int o_novo_problema(int x)
    {
        //Foi usado o seguinte site para converter Hexadecimal em Decimal: https://ss64.com/convert.html
        return new BigInteger("3").modPow(BigInteger.valueOf(x), BigInteger.valueOf(2).pow(256)).compareTo(new BigInteger("42433521838168360224194192642435598547821817833025597527132038330417986287139")) == 0 ? 2 : 0;
    }
    
    @Override
    public void run() 
    {
        System.out.println("Disparando Thread " + threadName);
        
        int valorExpoente = 19;
        int resultado = 0; 
        while(true)
        {
            resultado  = o_novo_problema(valorExpoente);
            if(resultado == 2)
            {
                System.out.println("O valor de 'x' eh: " + valorExpoente);
                break;
            }
            valorExpoente++;
        }
    }
    
}
