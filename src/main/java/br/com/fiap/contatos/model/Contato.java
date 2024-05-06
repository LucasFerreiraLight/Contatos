package br.com.fiap.contatos.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_contatos")
public class Contato {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "TBL_CONTATOS_SEQ")
    @SequenceGenerator(
            name = "TBL_CONTATOS_SEQ",
            sequenceName = "TBL_CONTATOS_SEQ",
            allocationSize = 1)
    private Long id;
    private String nome;
    private String email;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    // RELACIONAMENTO(Conectado pelo mapped by)
    @ManyToOne
    @JoinColumn(name = "tipoContato_id")
    private TipoContato tipoContato;

    // GETTERS E SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public TipoContato getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(TipoContato tipoContato) {
        this.tipoContato = tipoContato;
    }
    //----------------------------------------------------


    @Override
    public String toString() {
        return "Contato" +
                "{" +
                "id =       " + id + "\n" +
                "Nome =     " + nome + "\n"  +
                "Email =    " + email + "\n"  +
                "Data de Nascimento = " + dataNascimento + "\n" +
                "Tipo Contato = " + tipoContato + "\n" +
                '}';
    }
}
