import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class ListaTarefas {
    private Stack<Tarefa> lista_tarefas = new Stack<>();

    public Stack<Tarefa> getLista_tarefas() {
        return lista_tarefas;
    }

    public boolean verificarNome(String nome) {
        for (Tarefa tarefa : lista_tarefas) {
            if (tarefa.equals(nome)) {
                return false;
            }
        }
        return true;
    }

    public boolean verificarNome(String nome, Tarefa t) {
        for (Tarefa tarefa : lista_tarefas) {
            if (tarefa.getNome().toUpperCase().equals(nome.toUpperCase())) {
                t = tarefa;
                return false;
            }
        }
        return true;
    }

    public boolean buscarNome(Tarefa t) {
        return !verificarNome(t.getNome(), t);
    }


    public void adicionarTarefa(Scanner sc) {
        System.out.print("Informe o nome da tarefa: ");
        String nome = sc.nextLine();

        if (verificarNome(nome)) {
            lista_tarefas.push(new Tarefa(nome, false));
            System.out.println("Tarefa adicionada!");
        } else {
            System.out.println("Já existe uma tarefa com esse nome!");
        }
    }

    public void listarTarefas() {
        if(lista_tarefas.size() != 0){
            System.out.println("Lista de tarefas: ");
            for (Tarefa tarefa : lista_tarefas) {
                System.out.println("- " + tarefa.getNome());
            }
        } else System.out.println("Ainda não há nenhuma tarefa adicionada.");

    }

    public void atualizarTarefa(Scanner sc) {
        System.out.println("=====//=====");
        listarTarefas();
        System.out.print("Digite o nome da tarefa que deseja atualizar: ");
        Tarefa tarefa = new Tarefa(sc.nextLine(), false);
        if (buscarNome(tarefa)) {
            escolherAtualizar(sc, tarefa);
        } else {
            System.out.println("\nNão foi encontrada nenhuma tarefa adicionada com esse nome.");
        }
    }

    public void escolherAtualizar(Scanner sc, Tarefa t) {
        int opc = 0;
        do {
            try {
                System.out.println("-----//-----");
                System.out.println("1 - Renomear tarefa");
                System.out.println("2 - Completar tarefa");
                System.out.print("Informe o que deseja fazer: ");
                opc = sc.nextInt();
                sc.nextLine();

                System.out.println();
                switch (opc) {
                    case 1:
                        System.out.print("Informe o novo nome da tarefa: ");
                        String nome = sc.nextLine();
                        t.setNome(nome);
                        System.out.println("\nNome da tarefa atualizado!");
                        break;
                    case 2:
                        if (t.isConcluida()) {
                            System.out.println("Essa tarefa já está marcada como concluída");
                        } else {
                            t.setConcluida(true);
                            System.out.println("Tarefa concluída com sucesso!");
                        }
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
        } while (opc < 1 || opc > 2);
    }


    public void removerTarefa(Scanner sc){
        int opc = 0;
        do{
            try{
                System.out.println("Tarefa do topo da lista: " + lista_tarefas.peek().getNome());
                System.out.println("1 - Remover");
                System.out.println("2 - Sair");
                System.out.print("Informe o que deseja fazer: ");
                opc = sc.nextInt();

                switch (opc){
                    case 1:
                        if(verificaConcluida(lista_tarefas.peek())){
                            lista_tarefas.pop();
                            System.out.println("\nTarefa removida!");
                        }
                        break;
                    case 2:
                        break;
                    default:
                        System.out.println("\nValor inválido. Por favor, tente novamente.");
                        break;
                }

            } catch (InputMismatchException e){
                System.out.println("\nValor inválido.");
                sc.nextLine();
                opc = 0;
            }

        } while(opc != 2);


        Tarefa tarefa = new Tarefa(sc.nextLine(), false);
        if (buscarNome(tarefa)) {

        } else {
            System.out.println("\nNão foi encontrada nenhuma tarefa adicionada com esse nome.");
        }
    }

    public boolean verificaConcluida(Tarefa tarefa){
        if(!tarefa.isConcluida()){
            System.out.println("Você só pode remover uma tarefa se ela for concluída!");
            return false;
        } else {
            return true;
        }
    }


}
