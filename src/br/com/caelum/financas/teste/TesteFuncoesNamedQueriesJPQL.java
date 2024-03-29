package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteFuncoesNamedQueriesJPQL {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		Conta conta = new Conta();
		conta.setId(3);

		TypedQuery<Double> typedQuery = em.createNamedQuery("MediasPorDiaETipo", Double.class);

		typedQuery.setParameter("pConta", conta);
		typedQuery.setParameter("pTipo", TipoMovimentacao.SAIDA);

		List<Double> medias = typedQuery.getResultList();

		for (Double media : medias) {
			System.out.println("A media é: " + media);
		}

		em.getTransaction().commit();
		em.close();
	}
}
