import java.util.Scanner;

public class Pilha {

    public int[] pilha;
    public int posicaoPilha;

    public Pilha(){
        this.posicaoPilha = -1;
        this.pilha = new int[1000];
    }

    public boolean pilhaVazia(){
        return this.posicaoPilha == -1;
    }

    public int desempilhar(){
        if(pilhaVazia()){
            return 0;
        }

        return this.pilha[this.posicaoPilha--];
    }

    public void empilhar(int valor) {
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
            switch (a){
                case("+"):
                    pilha.empilhar((pilha.desempilhar() + pilha.desempilhar()));
                    break;
                case("-"):
                    pilha.empilhar((pilha.desempilhar() - pilha.desempilhar()));
                    break;
                case("*"):
                    pilha.empilhar((pilha.desempilhar() * pilha.desempilhar()));
                    break;
                case("/"):
                    pilha.empilhar((pilha.desempilhar() / pilha.desempilhar()));
                    break;
                default:
                    pilha.empilhar(Integer.parseInt(a));
            }
        }

        System.out.print(pilha.desempilhar());

    }

}

