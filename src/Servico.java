class Servico {
private String nome;
private double tempoEstimado; 
private double valor;
private String categoria;

public Servico(String nome, double tempoEstimado, double valor, String categoria) {
this.nome = nome;
this.tempoEstimado = tempoEstimado;
this.valor = valor;
this.categoria = categoria;
}

public String getNome() { return nome; }
public void setNome(String nome) { this.nome = nome; }

public double getTempoEstimado() { return tempoEstimado; }
public void setTempoEstimado(double tempoEstimado) { this.tempoEstimado = tempoEstimado; }

public double getValor() { return valor; }
public void setValor(double valor) { this.valor = valor; }

public String getCategoria() { return categoria; }
public void setCategoria(String categoria) { this.categoria = categoria; }

@Override
public String toString() {
return "Serviço [Nome: " + nome + ", Categoria: " + categoria +
", Tempo Estimado: " + tempoEstimado + "h, Valor: R$ " + valor + "]";
}
}
