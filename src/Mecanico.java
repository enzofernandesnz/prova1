class Mecanico {
private String nome;
private String cpf;
private String especialidade;
private String telefone;
private Box boxResponsavel;

public Mecanico(String nome, String cpf, String especialidade, String telefone) {
this.nome = nome;
this.cpf = cpf;
this.especialidade = especialidade;
this.telefone = telefone;
this.boxResponsavel = null;
}

public String getNome() { return nome; }
public void setNome(String nome) { this.nome = nome; }

public String getCpf() { return cpf; }
public void setCpf(String cpf) { this.cpf = cpf; }

public String getEspecialidade() { return especialidade; }
public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }

public String getTelefone() { return telefone; }
public void setTelefone(String telefone) { this.telefone = telefone; }

public Box getBoxResponsavel() { return boxResponsavel; }
public void setBoxResponsavel(Box boxResponsavel) { this.boxResponsavel = boxResponsavel; }

@Override
public String toString() {
String boxInfo = (boxResponsavel != null) ? "Box " + boxResponsavel.getNumero() : "Nenhum";
return "Mecânico [Nome: " + nome + ", CPF: " + cpf + ", Especialidade: " + especialidade +
", Telefone: " + telefone + ", Box Responsável: " + boxInfo + "]";
}
}