package auxilio;

public class Fatoracao {

    public void fatorar(int numero) {
        int fatoracao;

        fatoracao = 1;// a partir dessa variável será feita a fatoração

        while (numero != 0) {
            fatoracao = numero * fatoracao;
            numero--;
        }
        System.out.println(fatoracao);
    }

}

