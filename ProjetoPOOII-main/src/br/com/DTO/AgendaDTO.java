
package br.com.DTO;


public class AgendaDTO {
    // Atributos da agenda
      private int id;  // ID do compromisso
    private String data; // Data do compromisso (formato: "dd/MM/yyyy")
    private String horario; // Horário do compromisso (formato: "HH:mm")
    private String descricao; // Descrição do compromisso
    private int idCliente; // ID do cliente associado ao compromisso
    
// Métodos getters e setters para acessar e modificar os atributos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
}
