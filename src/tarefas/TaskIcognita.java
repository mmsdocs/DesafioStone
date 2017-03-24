package tarefas;

import java.math.BigInteger;

public class TaskIcognita implements Runnable{
    
    private final String threadName;
    
    public TaskIcognita(String name)
    {
        threadName = name;
    }
    
    private int a_icognita(BigInteger x)
    {
//        System.out.println("O valor de 'x' eh: " + x);
        return x.multiply(x.multiply(x)).add(new BigInteger("3").multiply(x.multiply(x))).add(new BigInteger("3").multiply(x)).add(new BigInteger("7")).equals(new BigInteger("2395346478")) ? 1 : 0;
    }
    
    @Override
    public void run() 
    {
        System.out.println("Disparando Thread " + threadName);
        
        BigInteger valorAserTestado = new BigInteger("0");
        BigInteger valorDeControle = new BigInteger("1");
        int resultadoTeste;
        while(true)
        {
            resultadoTeste = a_icognita(valorAserTestado);
            if(resultadoTeste == 1)
            {
                System.out.println("O valor de x para a icognita eh: " + valorAserTestado);
                break;
            }
            valorAserTestado = valorAserTestado.add(valorDeControle);
        }
    }
    
}
