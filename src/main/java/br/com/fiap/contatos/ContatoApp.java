package br.com.fiap.contatos;

import br.com.fiap.contatos.dao.Conexao;
import br.com.fiap.contatos.dao.ContatoDao;
import br.com.fiap.contatos.dao.TipoContatoDao;
import br.com.fiap.contatos.model.Contato;
import br.com.fiap.contatos.model.TipoContato;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;

public class ContatoApp {
    public static void main(String[] args) {

        // Criação do EntityManager
        EntityManager em = Conexao.getEntityManager();

        //cadastrar(em);
        //atualizar(em);
        //delete(em);
        //consultarContatoPorId(em);
        //listarTodosOsContatos(em);
        //listarContatosPorEmail(em);
        //listarContatosPorNome(em);
        consultarTipoContatoPeloId(em);

    }

    private static void consultarTipoContatoPeloId(EntityManager em) {

        TipoContatoDao tipoContatoDao = new TipoContatoDao(em);
        TipoContato tipoContatoBuscado = new TipoContato();
        tipoContatoBuscado.setId(4L);

        TipoContato tipoContatoEncontrado = new TipoContato();

        tipoContatoEncontrado = tipoContatoDao.buscarTipoContatoPeloId(tipoContatoBuscado);

        System.out.println(tipoContatoEncontrado.getTipo());
        System.out.println(tipoContatoEncontrado.getContatos());
    }

    //--------------------------------------------------------
    // SALVAR
    public static void cadastrar(EntityManager em){
            TipoContato tipoContato = new TipoContato();
            // depois de ter criado o ID do tipoContato família que no caso é o id (3)
            tipoContato.setId(4L);
            //tipoContato.setTipo("Família");

            TipoContatoDao tipoContatoDao = new TipoContatoDao(em);

            em.getTransaction().begin();
            // depois de ter criado o ID do tipoContato família que no caso é o id (3)
            //tipoContatoDao.salvar(tipoContato);


            Contato contato = new Contato();
            contato.setNome("Luana Maria Ferreira");
            contato.setEmail("luanamaria50@gmail.com");
            contato.setDataNascimento(LocalDate.of(2004, 03, 11));
            contato.setTipoContato(tipoContato);

            // Criar instancia com Dao
            ContatoDao contatoDao = new ContatoDao(em);


            contatoDao.salvar(contato);
            em.getTransaction().commit();
    }

    //--------------------------------------------------------
    // ATUALIZAR
    public static void atualizar(EntityManager em){
        Contato contato = new Contato();
        contato.setId(5L);
        contato.setNome("Lucas Ferreira");
        contato.setEmail("lucasferreira50@gmail.com");
        contato.setDataNascimento(LocalDate.of(1999, 03, 04));

        // Criar instancia com Dao
        ContatoDao contatoDao = new ContatoDao(em);

        em.getTransaction().begin();
        contatoDao.atualizar(contato);
        em.getTransaction().commit();
    }

    //--------------------------------------------------------
    // DELETE
    public static void delete(EntityManager em){
        Contato contato = new Contato();
        contato.setId(5L);

        // Criar instancia com Dao
        ContatoDao contatoDao = new ContatoDao(em);

        em.getTransaction().begin();
        contatoDao.delete(contato);
        em.getTransaction().commit();
    }

    //--------------------------------------------------------
    // SELECT
    public static void consultarContatoPorId(EntityManager em){
        // Criar instancia com Dao
        ContatoDao contatoDao = new ContatoDao(em);

        em.getTransaction().begin();
        contatoDao.consultarContatoPorId(10L);
        em.getTransaction().commit();
    }

    //--------------------------------------------------------
    // SELECT ALL
    public static void listarTodosOsContatos(EntityManager em){
        // Criar instancia com Dao
        ContatoDao contatoDao = new ContatoDao(em);

        List<Contato> contatos = contatoDao.listarTodosOsContatos();

        for(Contato contato : contatos){
            System.out.println("----------------------------------------");
            System.out.println(contato.toString());
        }
    }

    public static void listarContatosPorEmail(EntityManager em){
        // Criar instancia com Dao
        ContatoDao contatoDao = new ContatoDao(em);

        List<Contato> contatos = contatoDao.listarContatosPorEmail("lucasferreira50@gmail.com");

        for(Contato contato : contatos){
            System.out.println("----------------------------------------");
            System.out.println(contato.toString());
        }
    }

    public static void listarContatosPorNome(EntityManager em){
        // Criar instancia com Dao
        ContatoDao contatoDao = new ContatoDao(em);

        List<Contato> contatos = contatoDao.listarContatosPorNome("Pedro Oliveira");

        for(Contato contato : contatos){
            System.out.println("----------------------------------------");
            System.out.println(contato.toString());
        }
    }




}
