class Box {
private int numero;
private String tipoServicoPermitido;
private int capacidadeMaximaVeiculos;
private String localizacao;
private Mecanico mecanicoResponsavel;

public Box(int numero, String tipoServicoPermitido, int capacidadeMaximaVeiculos, String localizacao) {
this.numero = numero;
this.tipoServicoPermitido = tipoServicoPermitido;
this.capacidadeMaximaVeiculos = capacidadeMaximaVeiculos;
this.localizacao = localizacao;
this.mecanicoResponsavel = null;
}

public int getNumero() { return numero; }
public void setNumero(int numero) { this.numero = numero; }

public String getTipoServicoPermitido() { return tipoServicoPermitido; }
public void setTipoServicoPermitido(String tipoServicoPermitido) { this.tipoServicoPermitido = tipoServicoPermitido; }

public int getCapacidadeMaximaVeiculos() { return capacidadeMaximaVeiculos; }
public void setCapacidadeMaximaVeiculos(int capacidadeMaximaVeiculos) { this.capacidadeMaximaVeiculos = capacidadeMaximaVeiculos; }

public String getLocalizacao() { return localizacao; }
public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }

public Mecanico getMecanicoResponsavel() { return mecanicoResponsavel; }
public void setMecanicoResponsavel(Mecanico mecanicoResponsavel) { this.mecanicoResponsavel = mecanicoResponsavel; }

@Override
public String toString() {
String mecInfo = (mecanicoResponsavel != null) ? mecanicoResponsavel.getNome() : "Nenhum";
return "Box [Número: " + numero + ", Tipo Permitido: " + tipoServicoPermitido +
", Capacidade: " + capacidadeMaximaVeiculos + ", Localização: " + localizacao +
", Mecânico Responsável: " + mecInfo + "]";
}
}
