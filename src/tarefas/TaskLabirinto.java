package tarefas;

import java.math.BigInteger;

public class TaskLabirinto implements Runnable{
    
    private final String threadName;
    
    public TaskLabirinto(String name)
    {
        threadName = name;
    }
    
    private void mostraMapa()
    {
        String a = String.valueOf("1111111111111000100000000000100010000010001010001000000000001000110000000100100011111101111110001110000000111000111010000011100011100001001110001111110111111000111110011111100011111011111110001111111111111000000000000000000000000000000000000000000000000000");
        
        for(int i = 0; i < a.length(); i++)
        {
            if(i % 16 == 0)
            {
                System.out.println();
            }
            System.out.print(a.charAt(i));

        }
        System.out.println();
    }
    
    private int o_labirinto(BigInteger acoes)
    {
        BigInteger map = new BigInteger("fff8800882288008c048fdf8e038e838e138fdf8f9f8fbf8fff8000000000000", 16);
        BigInteger acao;
        BigInteger index;
        BigInteger x = BigInteger.valueOf(6);
        BigInteger y = BigInteger.valueOf(11);
        int i;
        
        for(i = 0; i < 64; ++i)
        {
//            acao = acoes / (2 ** (256 - (i+1)*4)) % 0x10;
            
            acao = acoes.divide(new BigInteger("2", 16).pow(256 - (i + 1) * 4)).mod(new BigInteger("10",16));
            if (acao.compareTo(BigInteger.valueOf(0)) == 0)
            {
                y = y.subtract(BigInteger.valueOf(1));
//                System.out.println(y);
            }
            if (acao.compareTo(BigInteger.valueOf(1)) == 0)
            {
                x = x.add(BigInteger.valueOf(1));
//                System.out.println(x);
            }
            if (acao.compareTo(BigInteger.valueOf(2)) == 0)
            {
                y = y.add(BigInteger.valueOf((1)));
//                System.out.println(y);
            }
            if (acao.compareTo(BigInteger.valueOf(3)) == 0)
            {
                x = x.subtract(BigInteger.valueOf(1));
//                System.out.println(x);
            }
            
            index = BigInteger.valueOf(2).pow(255-(y.intValue() * 16 + x.intValue()));  

            if(map.divide(index).mod(BigInteger.valueOf(2)).compareTo(BigInteger.valueOf(0)) == 1)
            { 
//                System.out.println("Sai do Loop Aqui no IF");
                break;
            }
            
            map = map.add(index);
        }
        return i/8;
    }

    @Override
    public void run() {
        System.out.println("Disparando Thread " + threadName);
        
        BigInteger numeroDeAcoes = new BigInteger("0");
        int resultado;
        
//        System.out.println(new BigInteger("20").toString(16));
        mostraMapa();
        
//        while(true)
//        {
//            resultado = o_labirinto(numeroDeAcoes);
////            System.out.println(numeroDeAcoes);
//            if(resultado == 8)
//            {
//                System.out.println("O numero de acoes sao: " + numeroDeAcoes);
//                break;
//            }
//            
//            numeroDeAcoes = numeroDeAcoes.add(BigInteger.valueOf(1));
//        }
    }
}
