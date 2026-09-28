class OrdemDeServico {
private String codigo;
private String nomeCliente;
private String modeloVeiculo;
private String placaVeiculo;
private String data;
private String status; // "aberta", "em execução", "finalizada"
private double valorEstimado;
private Servico servico;
private Box box; // Nulo se aberta

public OrdemDeServico(String codigo, String nomeCliente, String modeloVeiculo, String placaVeiculo,
String data, double valorEstimado, Servico servico) {
this.codigo = codigo;
this.nomeCliente = nomeCliente;
this.modeloVeiculo = modeloVeiculo;
this.placaVeiculo = placaVeiculo;
this.data = data;
this.status = "aberta"; // Regra: Inicializa como aberta e sem box
this.valorEstimado = valorEstimado;
this.servico = servico;
this.box = null;
}

public String getCodigo() { return codigo; }
public void setCodigo(String codigo) { this.codigo = codigo; }

public String getNomeCliente() { return nomeCliente; }
public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }

public String getModeloVeiculo() { return modeloVeiculo; }
public void setModeloVeiculo(String modeloVeiculo) { this.modeloVeiculo = modeloVeiculo; }

public String getPlacaVeiculo() { return placaVeiculo; }
public void setPlacaVeiculo(String placaVeiculo) { this.placaVeiculo = placaVeiculo; }

public String getData() { return data; }
public void setData(String data) { this.data = data; }

public String getStatus() { return status; }
public void setStatus(String status) { this.status = status; }

public double getValorEstimado() { return valorEstimado; }
public void setValorEstimado(double valorEstimado) { this.valorEstimado = valorEstimado; }

public Servico getServico() { return servico; }
public void setServico(Servico servico) { this.servico = servico; }

public Box getBox() { return box; }
public void setBox(Box box) { this.box = box; }

@Override
public String toString() {
String boxNum = (box != null) ? String.valueOf(box.getNumero()) : "Nenhum (Aberta)";
String mecNome = (box != null && box.getMecanicoResponsavel() != null) ? box.getMecanicoResponsavel().getNome() : "Nenhum";
return "OS [Código: " + codigo + ", Cliente: " + nomeCliente + ", Veículo: " + modeloVeiculo +
" (" + placaVeiculo + "), Data: " + data + ", Status: " + status +
", Valor: R$ " + valorEstimado + ", Box: " + boxNum + ", Mecânico: " + mecNome + "]";
}
}
