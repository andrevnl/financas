package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

//Busca uma conta do banco para que fique no estado managed e então deleta ela do banco
public class TesteDeletaConta {
	
	public static void main(String[] args) {
		Conta conta = new Conta();

		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		conta = em.find(Conta.class, 1);
		em.remove(conta);
		em.getTransaction().commit();
		em.close();
	}
}
