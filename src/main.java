import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
private static List<Mecanico> mecanicos = new ArrayList<>();
private static List<Box> boxes = new ArrayList<>();
private static List<OrdemDeServico> ordens = new ArrayList<>();
private static Scanner scanner = new Scanner(System.in);

public static void Main(String[] args)  {
inicializarDados();

int opcao;
do {
exibirMenu();
opcao = scanner.nextInt();
scanner.nextLine(); // limpar buffer

switch (opcao) {
case 1:
cadastrarOrdemServico();
break;
case 2:
associarMecanicoBox();
break;
case 3:
atribuirOrdemBox();
break;
case 4:
exibirOrdensPorBox();
break;
case 5:
exibirTotalOrdensFinalizadasPorBox();
break;
case 6:
buscarOrdensPorStatus();
break;
case 7:
exibirDetalhesOrdemEspecifica();
break;
case 0:
System.out.println("Encerrando o sistema da oficina. Bom trabalho!");
break;
default:
System.out.println("Opção inválida! Tente novamente.");
}
if (opcao != 0) {
System.out.println("\nPressione ENTER para continuar...");
scanner.nextLine();
}
} while (opcao != 0);
}

private static void inicializarDados() {
// Criando 3 mecânicos obrigatórios
mecanicos.add(new Mecanico("Carlos Silva", "111.222.333-44", "Motor", "(31) 98888-1111"));
mecanicos.add(new Mecanico("Ana Souza", "222.333.444-55", "Suspensão", "(31) 97777-2222"));
mecanicos.add(new Mecanico("Marcos Oliveira", "333.444.555-66", "Elétrica", "(31) 96666-3333"));

// Criando 3 boxes obrigatórios
boxes.add(new Box(1, "Motor", 2, "Galpão A - Setor Norte"));
boxes.add(new Box(2, "Suspensão", 1, "Galpão A - Setor Sul"));
boxes.add(new Box(3, "Elétrica", 2, "Galpão B - Setor Leste"));

System.out.println(">>> 3 Mecânicos e 3 Boxes inicializados automaticamente com sucesso! <<<\n");
}

private static void exibirMenu() {
System.out.println("========================================");
System.out.println(" SISTEMA DE GERENCIAMENTO - OFICINA ");
System.out.println("========================================");
System.out.println("1. Cadastrar Ordem de Serviço");
System.out.println("2. Associar um Mecânico a um Box");
System.out.println("3. Atribuir Ordem de Serviço a um Box");
System.out.println("4. Exibir Ordens Atribuídas a um Box");
System.out.println("5. Quantidade de Ordens Finalizadas por Box");
System.out.println("6. Buscar Ordens por Status");
System.out.println("7. Exibir Detalhes de uma Ordem Específica");
System.out.println("0. Sair");
System.out.print("Escolha uma opção: ");
}

private static void cadastrarOrdemServico() {
System.out.println("\n--- CADASTRAR ORDEM DE SERVIÇO ---");
System.out.print("Código da OS: ");
String codigo = scanner.nextLine();
System.out.print("Nome do Cliente: ");
String cliente = scanner.nextLine();
System.out.print("Modelo do Veículo: ");
String modelo = scanner.nextLine();
System.out.print("Placa do Veículo: ");
String placa = scanner.nextLine();
System.out.print("Data (DD/MM/AAAA): ");
String data = scanner.nextLine();

System.out.println("\n--- DADOS DO SERVIÇO ASSOCIADO ---");
System.out.print("Nome do Serviço: ");
String nomeServico = scanner.nextLine();
System.out.print("Categoria (ex: Motor, Suspensão, Elétrica): ");
String categoria = scanner.nextLine();
System.out.print("Tempo Estimado (horas): ");
double tempo = scanner.nextDouble();
System.out.print("Valor do Serviço (R$): ");
double valor = scanner.nextDouble();
scanner.nextLine(); // limpar buffer

Servico servico = new Servico(nomeServico, tempo, valor, categoria);
OrdemDeServico os = new OrdemDeServico(codigo, cliente, modelo, placa, data, valor, servico);

ordens.add(os);
System.out.println("Sucesso! Ordem de serviço cadastrada com status 'aberta'.");
}

private static void associarMecanicoBox() {
System.out.println("\n--- ASSOCIAR MECÂNICO A UM BOX ---");
if (mecanicos.isEmpty() || boxes.isEmpty()) {
System.out.println("Não há mecânicos ou boxes cadastrados.");
return;
}

System.out.println("\nLista de Mecânicos:");
for (int i = 0; i < mecanicos.size(); i++) {
System.out.println((i + 1) + ". " + mecanicos.get(i));
}
System.out.print("Escolha o número do mecânico: ");
int mIdx = scanner.nextInt() - 1;

System.out.println("\nLista de Boxes:");
for (int i = 0; i < boxes.size(); i++) {
System.out.println((i + 1) + ". " + boxes.get(i));
}
System.out.print("Escolha o número do box: ");
int bIdx = scanner.nextInt() - 1;
scanner.nextLine();

if (mIdx >= 0 && mIdx < mecanicos.size() && bIdx >= 0 && bIdx < boxes.size()) {
Mecanico mecanico = mecanicos.get(mIdx);
Box box = boxes.get(bIdx);

if (mecanico.getBoxResponsavel() != null) {
System.out.println("Erro: O mecânico " + mecanico.getNome() + " já é responsável pelo Box " + mecanico.getBoxResponsavel().getNumero() + ".");
return;
}

if (box.getMecanicoResponsavel() != null) {
box.getMecanicoResponsavel().setBoxResponsavel(null);
}

mecanico.setBoxResponsavel(box);
box.setMecanicoResponsavel(mecanico);
System.out.println("Mecânico " + mecanico.getNome() + " associado com sucesso ao Box " + box.getNumero() + "!");
} else {
System.out.println("Seleção inválida.");
}
}

private static void atribuirOrdemBox() {
System.out.println("\n--- ATRIBUIR ORDEM DE SERVIÇO A UM BOX ---");
List<OrdemDeServico> ordensDisponiveis = new ArrayList<>();
for (OrdemDeServico os : ordens) {
if (!os.getStatus().equals("finalizada")) {
ordensDisponiveis.add(os);
}
}

if (ordensDisponiveis.isEmpty()) {
System.out.println("Não há ordens disponíveis (abertas ou em execução).");
return;
}

System.out.println("\nOrdens Disponíveis:");
for (int i = 0; i < ordensDisponiveis.size(); i++) {
System.out.println((i + 1) + ". " + ordensDisponiveis.get(i));
}
System.out.print("Escolha o número da ordem de serviço: ");
int osIdx = scanner.nextInt() - 1;

System.out.println("\nBoxes Disponíveis:");
for (int i = 0; i < boxes.size(); i++) {
System.out.println((i + 1) + ". " + boxes.get(i));
}
System.out.print("Escolha o número do box: ");
int bIdx = scanner.nextInt() - 1;
scanner.nextLine();

if (osIdx >= 0 && osIdx < ordensDisponiveis.size() && bIdx >= 0 && bIdx < boxes.size()) {
OrdemDeServico os = ordensDisponiveis.get(osIdx);
Box box = boxes.get(bIdx);

if (!box.getTipoServicoPermitido().equalsIgnoreCase(os.getServico().getCategoria())) {
System.out.println("Erro: O tipo de serviço (" + os.getServico().getCategoria() +
") é incompatível com o tipo permitido pelo Box (" + box.getTipoServicoPermitido() + ").");
return;
}

os.setBox(box);

System.out.println("Defina o novo status da ordem:");
System.out.println("1. Em Execução");
System.out.println("2. Finalizada");
System.out.print("Escolha (1 ou 2): ");
int opcaoStatus = scanner.nextInt();
scanner.nextLine();

if (opcaoStatus == 2) {
os.setStatus("finalizada");
System.out.println("Ordem atribuída ao Box " + box.getNumero() + " e marcada como FINALIZADA.");
} else {
os.setStatus("em execução");
System.out.println("Ordem atribuída ao Box " + box.getNumero() + " e com status EM EXECUÇÃO.");
}
} else {
System.out.println("Seleção inválida.");
}
}

private static void exibirOrdensPorBox() {
System.out.println("\n--- EXIBIR ORDENS ATRIBUÍDAS A UM BOX ---");
System.out.print("Digite o número do box desejado: ");
int numBox = scanner.nextInt();
scanner.nextLine();

int total = 0;
System.out.println("\nOrdens associadas ao Box " + numBox + ":");
for (OrdemDeServico os : ordens) {
if (os.getBox() != null && os.getBox().getNumero() == numBox) {
System.out.println("- " + os);
total++;
}
}
System.out.println("\nTotal de ordens atribuídas a este box: " + total);
}

private static void exibirTotalOrdensFinalizadasPorBox() {
System.out.println("\n--- QUANTIDADE DE ORDENS FINALIZADAS POR BOX ---");
for (Box b : boxes) {
int count = 0;
for (OrdemDeServico os : ordens) {
if (os.getStatus().equalsIgnoreCase("finalizada") && os.getBox() != null && os.getBox().getNumero() == b.getNumero()) {
count++;
}
}
System.out.println("Box " + b.getNumero() + " (" + b.getTipoServicoPermitido() + "): " + count + " ordem(ns) finalizada(s).");
}
}

private static void buscarOrdensPorStatus() {
System.out.println("\n--- BUSCAR ORDENS POR STATUS ---");
System.out.print("Digite o status (aberta, em execução, finalizada): ");
String statusBusca = scanner.nextLine().trim();

boolean encontrou = false;
for (OrdemDeServico os : ordens) {
if (os.getStatus().equalsIgnoreCase(statusBusca)) {
System.out.println(os);
encontrou = true;
}
}

if (!encontrou) {
System.out.println("Nenhuma ordem encontrada com o status informado.");
}
}

private static void exibirDetalhesOrdemEspecifica() {
System.out.println("\n--- EXIBIR DETALHES DE UMA ORDEM ESPECÍFICA ---");
System.out.print("Digite o código da ordem de serviço: ");
String codigo = scanner.nextLine();

OrdemDeServico osEncontrada = null;
for (OrdemDeServico os : ordens) {
if (os.getCodigo().equalsIgnoreCase(codigo)) {
osEncontrada = os;
break;
}
}

if (osEncontrada != null) {
System.out.println("\n========================================");
System.out.println(" DETALHES COMPLETOS DA OS ");
System.out.println("========================================");
System.out.println("Código: " + osEncontrada.getCodigo());
System.out.println("Cliente: " + osEncontrada.getNomeCliente());
System.out.println("Veículo: " + osEncontrada.getModeloVeiculo() + " | Placa: " + osEncontrada.getPlacaVeiculo());
System.out.println("Data: " + osEncontrada.getData());
System.out.println("Status: " + osEncontrada.getStatus());
System.out.println("Valor Estimado: R$ " + osEncontrada.getValorEstimado());
System.out.println("\n-> Serviço Associado:");
System.out.println(" " + osEncontrada.getServico());
System.out.println("\n-> Box e Mecânico Responsável:");
if (osEncontrada.getBox() != null) {
System.out.println(" Box nº: " + osEncontrada.getBox().getNumero() + " (" + osEncontrada.getBox().getLocalizacao() + ")");
if (osEncontrada.getBox().getMecanicoResponsavel() != null) {
System.out.println(" Mecânico: " + osEncontrada.getBox().getMecanicoResponsavel().getNome());
} else {
System.out.println(" Mecânico: Nenhum associado.");
}
} else {
System.out.println(" Box: Nenhum (Ordem sem box atribuído).");
}
System.out.println("========================================");
} else {
System.out.println("Ordem de serviço não encontrada.");
}
}
}