/* UNIVERSIDADE UNIFACEAR
 * Cidade : Araucária - PR
 * Alunos : Wesley de Araujo , Felipe Fillus
 * Turma : Análise e Desenvolvimento de Sistemas III
 */
package kartodromo;

import Bo.UsuarioBO;
import Email.EmailJava;
import Model.Endereco;
import Model.Usuario;

public class Kartodromo {

    public static void main(String[] args) {

        Endereco endereco = new Endereco();
        endereco.setId_endereco(0);
        endereco.setBairro("Campina da Barra");
        endereco.setCep("83709670");
        endereco.setCidade("Araucária - PR");
        endereco.setRua("Rua Malva");
        endereco.setTelefone("(41) 3345-4406");

        Usuario usuario = new Usuario();

        usuario.setId_usuario(0);
        usuario.setNome("Wesley");
        usuario.setEmail("kako.araujo.24@gmail.com");
        usuario.setSenha("Wes123456#");
        usuario.setEndereco(endereco);
        usuario.setAtivo(true);

        UsuarioBO usuarioBO = new UsuarioBO();

        try {

            if (usuarioBO.usuarioExiste(usuario)) {
                System.out.println("EXISTE");
            } else {
                System.out.println("NOPE!");
            }

            //usuarioBO.criarUsuario(usuario);
            //usuarioBO.deletarUsuario(usuario);

            EmailJava emailJava = new EmailJava();

            StringBuilder lista = new StringBuilder();

            lista.append("kako.araujo.24@gmail.com");
            lista.append(",");

            System.out.println(emailJava.EnviarEmailGmail(lista,"Teste com Arraylist" , "-----"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
