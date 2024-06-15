
import org.ininfleProject.BusinessRuler.MapCreation;
import org.ininfleProject.BusinessRuler.OperacoesComSalario;
import org.ininfleProject.BusinessRuler.OperacaoLista;
import org.ininfleProject.entities.Funcionario;
import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public static void main(String[] args) throws Exception {
    // read in string
    String data = new String(Files.readAllBytes(Paths.get("C:\\Users\\Leonardo\\IdeaProjects\\Iniflex\\src\\main\\resources\\demo.json")));
    //format the date
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    //read as json array
    JSONArray jsonArray = new JSONArray(data);
    List<Funcionario> listaDeFuncionario = new ArrayList<>();
    for(int i = 0; i < jsonArray.length(); i++){

        String str = jsonArray.get(i).toString();
        JSONObject object1 = new JSONObject(str);

        listaDeFuncionario.add(new Funcionario(object1.getString("nome"),
                LocalDate.parse(object1.getString("dataNascimento"),formatter),
                object1.getBigDecimal("salario"),
                object1.getString("funcao")));
    }
    List<Funcionario> listaDeFuncionarioOrd = new ArrayList<>(listaDeFuncionario);
    List<Funcionario> listaDeFuncionarioDel = new ArrayList<>(listaDeFuncionario);
    Map<String, ArrayList<String>> mapDeFuncionarios = new HashMap<String, ArrayList<String>>();
    Scanner sc = new Scanner(System.in);
    String sair = "n";

    do{
    System.out.println("Escolha uma das opçoes:\n1- para listar todos os funcionarios" +
            "\n2- para deletar um funcionario em especifico.\n3- para reajustar o salario em 10% e imprimir Funcionarios " +
            "com salario ajustado\n4- para imprimir funcionarios que fazem aniversario nos meses 10 e 12\n5- " +
            "para ver o funcionario com maior idade\n6- para ver numero de salarios minimos de cada funcionario" +
            "\n7- para ver o somatorio dos salarios dos funcionarios\n8- para ver a lista ordenada" +
            "\n9- para imprimir o agrupamento de funcionarios\n-sair");
    String opcao = sc.nextLine();
    switch(opcao){
        case "1":
            if(listaDeFuncionario.size() == listaDeFuncionarioDel.size()){
                System.out.println("\n\nImprimir a Lista");
                OperacaoLista.imiprimir(listaDeFuncionario);
                break;
            }else{
                System.out.println("\n\ndeseja imprimir a lista sem funcinarios excluisdos?sim ou não");{
                    String resposta = sc.nextLine();
                    if(resposta.equals("sim")){
                        System.out.println("\n\nImprimir a Lista com Funcionario deletados");
                        OperacaoLista.imiprimir(listaDeFuncionarioDel);
                        break;
                    }
                    else{
                        System.out.println("\n\nImprimir a Lista");
                        OperacaoLista.imiprimir(listaDeFuncionario);
                        break;
                    }
                }
            }
        case "2":
            System.out.println("\n\nQual Funcionario deseja deletar?");
            String nome = sc.nextLine();
            OperacaoLista.apagarFuncionario(listaDeFuncionarioDel, nome);
            break;
        case "3":
            OperacoesComSalario.AumentoDeSalario(listaDeFuncionario, 10);
            System.out.println("\n\nImprimir a Lista com aumento de " + 10 + "%");
            OperacaoLista.imiprimir(listaDeFuncionario);
            break;
        case "4":
            System.out.println("\n\nimprimir os funcionarios que fazem aniversario mês 10 e 12");
            OperacaoLista.imiprimirOutDezAniversario(listaDeFuncionario);
            break;
        case "5":
            System.out.println("\n\nimprimir funcionario com maior idade");
            OperacaoLista.imprimirFuncionariomaiorIdade(listaDeFuncionario);
            break;
        case "6":
            System.out.println("\n\nquantidade de salario minimo de cada funcionario é:");
            OperacoesComSalario.quantidadeDesalariosMinimos(listaDeFuncionario);
            System.out.println("\n\n");
            break;
        case "7":
            System.out.println("\n\nsomatorio dos salarios é:");
            OperacoesComSalario.somarSalario(listaDeFuncionario);
            System.out.println("\n\n");
            break;
        case "8":
            if(listaDeFuncionario.size() == listaDeFuncionarioDel.size()){
                System.out.println("\n\nordenado por ordem alfabetica");
                OperacaoLista.odenar(listaDeFuncionarioOrd);
                OperacaoLista.imiprimir(listaDeFuncionarioOrd);
                break;
            }else{
                System.out.println("\n\ndeseja imprimir a lista sem funcinarios excluisdos?sim ou não");{
                    String resposta = sc.nextLine();
                    if(resposta.equals("sim")){
                        System.out.println("\n\nordenar por ordem alfetica");
                        OperacaoLista.odenar(listaDeFuncionarioDel);
                        OperacaoLista.imiprimir(listaDeFuncionarioDel);
                        break;
                    }
                    else{
                        System.out.println("\n\nordenar por ordem alfetica");
                        OperacaoLista.odenar(listaDeFuncionarioOrd);
                        OperacaoLista.imiprimir(listaDeFuncionarioOrd);
                        break;
                    }
                }
            }
        case "9":
            System.out.println("\n\n");
            MapCreation.criacaoDeMap(listaDeFuncionario,mapDeFuncionarios);
            MapCreation.imprimirMap(mapDeFuncionarios);
            System.out.println("\n\n");
            break;
        case "sair":
            sair ="s";
            break;
        default:
            System.out.println("valor invalido!");
    }
}while (sair.equals("n"));
}
