import java.util.Scanner;

public class Pilha {

    public String[] pilha;
    public int posicaoPilha;

    public Pilha(){
        this.posicaoPilha = -1;
        this.pilha = new String[1000];
    }

    public boolean pilhaVazia(){
        return this.posicaoPilha == -1;
    }

    public String desempilhar(){
        if(pilhaVazia()){
            return null;
        }

        return this.pilha[this.posicaoPilha--];
    }

    public void empilhar(String valor) {
        // push
        if (this.posicaoPilha < this.pilha.length - 1) {
            this.pilha[++posicaoPilha] = valor;
        }
    }

    public static void main(String[] args) {
        Pilha pilha = new Pilha();
        Scanner sc = new Scanner(System.in);

        String lista[];

        System.out.print("Digite a expressão separada por espaço(1 2 3 + -): ");
        String expressao = sc.nextLine();

        lista = expressao.split(" ");

        for(String a:lista){
            switch (a) {
                case ("+") ->
                        pilha.empilhar(String.valueOf(Integer.parseInt(pilha.desempilhar()) + Integer.parseInt(pilha.desempilhar())));
                case ("-") ->
                        pilha.empilhar(String.valueOf(Integer.parseInt(pilha.desempilhar()) - Integer.parseInt(pilha.desempilhar())));
                case ("*") ->
                        pilha.empilhar(String.valueOf(Integer.parseInt(pilha.desempilhar()) * Integer.parseInt(pilha.desempilhar())));
                case ("/") ->
                        pilha.empilhar(String.valueOf(Integer.parseInt(pilha.desempilhar()) / Integer.parseInt(pilha.desempilhar())));
                default -> pilha.empilhar(a);
            }
        }

        System.out.print(pilha.desempilhar());

    }

}

