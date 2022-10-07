import java.util.Scanner;

public class Pilha {

    public String[] pilha;
    public int posicaoPilha;

    public Pilha(){
        this.posicaoPilha = -1;
        this.pilha = new String[1000];
    }

    public boolean pilhaVazia(){
        if(this.posicaoPilha == -1){
            return true;
        }
        return false;
    }

    public String tamanho(){
        if(this.pilhaVazia()){
            return " ";
        }
        return this.pilha[this.posicaoPilha];

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

        System.out.printf("Digite a expressão separada por espaço(1 2 3 + -): ");
        String expressao = sc.nextLine();

        lista = expressao.split(" ");

        for(String a:lista){
            switch (a){
                case("+"):
                    pilha.empilhar(String.valueOf(Integer.parseInt(pilha.desempilhar()) + Integer.parseInt(pilha.desempilhar())));
                    break;
                case("-"):
                    pilha.empilhar(String.valueOf(Integer.parseInt(pilha.desempilhar()) - Integer.parseInt(pilha.desempilhar())));
                    break;
                case("*"):
                    pilha.empilhar(String.valueOf(Integer.parseInt(pilha.desempilhar()) * Integer.parseInt(pilha.desempilhar())));
                    break;
                case("/"):
                    pilha.empilhar(String.valueOf(Integer.parseInt(pilha.desempilhar()) / Integer.parseInt(pilha.desempilhar())));
                    break;
                default:
                    pilha.empilhar(a);
            }
        }

        System.out.print(pilha.desempilhar());

    }

}

