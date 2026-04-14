public class ProfessorRepository {

    private Connection conexao;

    public ProfessorRepository() {
        ConexaoFactory conexaoFactory = new ConexaoFactory();
        conexao = conexaoFactory.getConnection();
    }

    public void getProfessors() {

        Statement instrucao = null;
        ResultSet resultados = null;

        try {
            instrucao = conexao.createStatement();
            resultados = instrucao.executeQuery("SELECT * FROM professores");

            while (resultados.next()) {
                System.out.println(resultados.getString("nome"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
