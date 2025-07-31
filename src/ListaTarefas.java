import java.util.*;

public class ListaTarefas {
    private List<Tarefa> lista_tarefas = new LinkedList<>();

    public List<Tarefa> getLista_tarefas() {
        return lista_tarefas;
    }

    public Tarefa buscarPorNome(String nome) {
        for (Tarefa tarefa : lista_tarefas) {
            if (tarefa.getNome().equalsIgnoreCase(nome)) {
                return tarefa;
            }
        }
        return null;
    }


    public void adicionarTarefa(Scanner sc) {
        System.out.print("Informe o nome da tarefa: ");
        String nome = sc.nextLine();

        if (buscarPorNome(nome) == null) {
            lista_tarefas.add(new Tarefa(nome, false));
            System.out.println("Tarefa adicionada!");
        } else {
            System.out.println("Já existe uma tarefa com esse nome!");
        }
    }

    public void listarTarefas() {
        if (lista_tarefas.size() != 0) {
            System.out.println("Lista de tarefas: ");
            for (Tarefa tarefa : lista_tarefas) {
                System.out.println(tarefa);
            }
        } else System.out.println("Ainda não há nenhuma tarefa adicionada.");

    }

    public void atualizarTarefa(Scanner sc) {
        System.out.println("=====//=====");
        listarTarefas();
        System.out.print("Digite o nome da tarefa que deseja atualizar: ");
        String nome = sc.nextLine();
        Tarefa t = buscarPorNome(nome);
        if (t != null) {
            escolherAtualizar(sc, t);
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

                        if (buscarPorNome(nome) == null) {
                            t.setNome(nome);
                            System.out.println("\nNome da tarefa atualizado!");
                        } else {
                            System.out.println("Já existe uma tarefa com esse nome!");
                        }

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

    public void removerTarefa(Scanner sc) {
        int opc = 0;
        do {
            try {
                System.out.println("=====//=====");
                listarTarefas();
                System.out.print("Digite o nome da tarefa que deseja remover: ");
                String nome = sc.nextLine();

                Tarefa t = buscarPorNome(nome);
                if (t != null) {
                    System.out.println("1 - Remover");
                    System.out.println("2 - Sair");
                    System.out.print("Informe o que deseja fazer: ");
                    opc = sc.nextInt();

                    switch (opc) {
                        case 1:
                            if (verificaConcluida(t)) {
                                lista_tarefas.remove(t);
                                System.out.println("\nTarefa removida!");
                            }
                            break;
                        case 2:
                            break;
                        default:
                            System.out.println("\nValor inválido. Por favor, tente novamente.");
                            break;
                    }
                } else {
                    System.out.println("\nNão foi encontrada nenhuma tarefa adicionada com esse nome.");
                }

            } catch (InputMismatchException e) {
                System.out.println("\nValor inválido.");
                sc.nextLine();
                opc = 0;
            }

        } while (opc != 1 && opc != 2);

    }

    public boolean verificaConcluida(Tarefa tarefa) {
        if (!tarefa.isConcluida()) {
            System.out.println("Você só pode remover uma tarefa se ela for concluída!");
            return false;
        } else {
            return true;
        }
    }


}
