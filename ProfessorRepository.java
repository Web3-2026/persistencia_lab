public class ProfessorRepository {

    private Connection conexao;

    public ProfessorRepository() {
        ConexaoFactory conexaoFactory = new ConexaoFactory();
        conexao = conexaoFactory.getConnection();
    }

    public void getProfessores() {

        Statement consulta = null;
        ResultSet resultados = null;

        try {
            consulta = conexao.createStatement();
            resultados = consulta.executeQuery("SELECT * FROM professores");

            while (resultados.next()) {
                System.out.println(resultados.getString("nome"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
