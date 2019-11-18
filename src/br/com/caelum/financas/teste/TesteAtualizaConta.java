package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

//Inserir e logo depois alterar uma informação fazendo merge no final

public class TesteAtualizaConta {

	public static void main(String[] args) {

		Conta conta = new Conta();
		conta.setTitular("Danilo");
		conta.setBanco("Banco do Brasil");
		conta.setAgencia("123");
		conta.setNumero("456");

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		em.close();

		EntityManager em2 = new JPAUtil().getEntityManager();
		em2.getTransaction().begin();
		conta.setTitular("Leonardo");
		em2.merge(conta);
		em2.getTransaction().commit();
		em2.close();
	}
}