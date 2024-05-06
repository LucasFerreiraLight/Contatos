package br.com.fiap.contatos.dao;

import br.com.fiap.contatos.model.Contato;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ContatoDao {

    private EntityManager em;

    public ContatoDao(EntityManager em){
        this.em = em;
    }

    // SALVAR
    public void salvar(Contato contato){
        em.persist(contato);
    }

    // UPDATE(ATUALIZAR)
    public void atualizar(Contato contato){
        em.merge(contato);
    }

    public void delete(Contato contato){
        Contato contatoDelete = em.find(Contato.class, contato.getId());
        em.remove(contatoDelete);
    }

    public void consultarContatoPorId(Long id){
        Contato contatoConsulta = em.find(Contato.class, id);

        if(contatoConsulta == null){
            System.out.println("Não foi possivel encontrar o contato, pelo Id informado!");
        }else {
            System.out.println("---------------------------------------");
            System.out.println(contatoConsulta.toString());
            System.out.println("---------------------------------------");
        }
    }

    //-------------------------------------------------------------------------------------
    // SELECT * FROM tbl_contatos ORDER BY nome ASC
    public List<Contato> listarTodosOsContatos(){

        // JPQL
        String consulta = "SELECT c FROM Contato c ORDER BY nome DESC";
        return em.createQuery(consulta).getResultList();
    }

    //-------------------------------------------------------------------------------------
    // Busca por email
    public List<Contato> listarContatosPorEmail(String emailProcurado){
        // JPQL
        String consulta = "SELECT c FROM Contato c WHERE email = :email";

        return em.createQuery(consulta, Contato.class)
                .setParameter("email", emailProcurado) //email é o :email na String consulta ---- emailProcurado é o que esta dentro dos parenteses (String emailProcurado)
                .getResultList();
    }

    //-------------------------------------------------------------------------------------
    // Busca por nome
    public List<Contato> listarContatosPorNome(String nomeProcurado){
        // JPQL
        String consulta = "SELECT c FROM Contato c WHERE nome = :nome";

        return em.createQuery(consulta, Contato.class)
                .setParameter("nome", nomeProcurado) //nome é o :nome na String consulta ---- nomeProcurado é o que esta dentro dos parenteses (String nomeProcurado)
                .getResultList();
    }
}
