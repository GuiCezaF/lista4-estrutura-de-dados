package br.unasp;

/**
 * 
 * Esta classe armazena o inicio da lista ligada (definida pelo 
 * atributo raiz) e as operacoes que poderao ser realizadas nos 
 * elementos. 
 * 
 * Sua resolucao deverah ser feita nesta classe.
 *
 */
public class ListaLigada {

	
	
	/**
	 * 
	 * Ponto de inicio da lista ligada.
	 * 
	 * Atencao ao atualizar esta referencia.
	 * 
	 */
	Elemento raiz;
	
	
	
	/**
	 * 
	 * Recebe um novo objeto do tipo Aluno, cria um novo 
	 * Elemento para armazena-lo e o insere na lista ligada
	 * que eh definida a partir da raiz.
	 * 
	 */
	void inserir(Aluno novoAluno) {
		Elemento novoElemento = new Elemento();
		novoElemento.alu = novoAluno;
		if (raiz == null) {
			raiz = novoElemento;
		} else {
			Elemento atual = raiz;
			while (atual.proximo != null) {
				atual = atual.proximo;
			}
			atual.proximo = novoElemento;
		}
	}



	/**
	 * 
	 * Retorna uma String contendo os nomes dos alunos, separados 
	 * por virgula e entre chaves, no seguinte formato:
	 * 
	 * {NOME1, NOME2}
	 * 
	 * Os nomes devem ser colocados na ordem em que aparecem na lista.
	 * 
	 * Se a lista estiver vazia, retorne {}.
	 * 
	 */
	String imprimir() {
		StringBuilder resultado = new StringBuilder();
		resultado.append("{");
		Elemento atual = raiz;
		while (atual != null) {
			resultado.append(atual.alu.nome);
			if (atual.proximo != null) {
				resultado.append(", ");
			}
			atual = atual.proximo;
		}
		resultado.append("}");
		return resultado.toString();
	}





	/**
	 * 
	 * Dado um aluno, calcula a media das notas dele e retorna 
	 * este valor encontrado.
	 * 
	 */
	double calcularMedia(Aluno alu) {
		double soma = 0;
		for (double nota : alu.notas) {
			soma += nota;
		}
		return soma / alu.notas.length;
	}


	/**
	 * 
	 * Considerando a lista de alunos armazenadas a partir 
	 * da raiz, calcula a media de cada aluno e encontra o 
	 * aluno de maior media geral. Este aluno (INTEIRO) deve 
	 * ser retornado.
	 * 
	 */
	Aluno encontrarMaiorMedia() {
		if (raiz == null) {
			return null;
		}
		Elemento atual = raiz;
		Aluno alunoMaiorMedia = atual.alu;
		double maiorMedia = calcularMedia(alunoMaiorMedia);
		while (atual != null) {
			double mediaAtual = calcularMedia(atual.alu);
			if (mediaAtual > maiorMedia) {
				alunoMaiorMedia = atual.alu;
				maiorMedia = mediaAtual;
			}
			atual = atual.proximo;
		}
		return alunoMaiorMedia;
	}




	/**
	 * 
	 * Verifica se um determinado RA existe na lista a partir 
	 * da raiz. Caso exista, retorna true, senao, retorna false.
	 * 
	 * Se a listaestiver vazio, retorna false.
	 * 
	 */
	boolean existeAlunoRA(int ra) {
		Elemento atual = raiz;
		while (atual != null) {
			if (atual.alu.ra == ra) {
				return true;
			}
			atual = atual.proximo;
		}
		return false;
	}


}
