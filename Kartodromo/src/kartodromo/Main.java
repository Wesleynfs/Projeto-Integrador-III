/* UNIVERSIDADE UNIFACEAR
 * Cidade : Araucária - PR
 * Alunos : Wesley de Araujo , Felipe Fillus
 * Turma : Análise e Desenvolvimento de Sistemas III
 */
package kartodromo;

import Connections.ConnectionFactory;
import Dao.ConfiguracaoDAO;
import Email.EmailJava;
import Model.Configuracao;
import Model.Kartodromo;
import Model.Piloto;
import View.*;
import View.LoginFrame;

import javax.persistence.EntityManager;

public class Main {

    private static void inicializarBancoDeDados() {
        new Thread(() -> {
            // Para inicializar a conexão com o banco junto com a inicialização do aplicativo //
            new ConnectionFactory().getConnection();
        }).start();
    }

    public static void main(String[] args) {

        // Executar sempre por essa tela e inserir as outras telas no programa //
        inicializarBancoDeDados();

        new LoginFrame();

        //new MenuPrincipal(new Piloto());

    }

}
