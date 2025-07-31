import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opc = 0;

        ListaTarefas lista = new ListaTarefas();

        System.out.println("\nSEJA BEM VINDO A SUA LISTA DE TAREFAS PESSOAL!\n");
        do {
            try {
                System.out.println("==========//==========");
                System.out.println("1 - Adicionar nova tarefa");
                System.out.println("2 - Listar tarefas");
                System.out.println("3 - Atualizar tarefa");
                System.out.println("4 - Remover tarefa");
                System.out.println("5 - Sair");
                System.out.print("Informe o que deseja fazer: ");
                opc = sc.nextInt();
                sc.nextLine();

                System.out.println();
                switch (opc){
                    case 1:
                        lista.adicionarTarefa(sc);
                        break;
                    case 2:

                        lista.listarTarefas();
                        break;
                    case 3:
                        lista.atualizarTarefa(sc);
                        break;
                    case 4:
                        lista.removerTarefa(sc);
                        break;
                    case 5:
                        System.out.println();
                        System.out.println("Obrigado por usar nosso organizador de tarefas. Espero que tenha gostado!!");
                        break;

                    default:
                        System.out.println("\nValor inválido. Por favor, tente novamente.\n");
                        break;
                }
                System.out.println();

            } catch (InputMismatchException e) {
                System.out.println("\nValor inválido. Por favor, tente novamente.\n");
                sc.nextLine();
                opc = 0;
            }
        }while (opc != 5);
    }
}
