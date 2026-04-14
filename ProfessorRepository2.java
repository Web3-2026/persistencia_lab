public class ProfessorRepository {

    private Connection conexao;

    public ProfessorRepository() {

        ConexaoFactory conexaoFactory = new ConexaoFactory();
        conexao = conexaoFactory.getConnection();
    }

    public void getProfessores() {

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

    public void inserir(Professor professor) {
        PreparedStatement instrucao = null;

        try {
            instrucao = conexao.prepareStatement(
                    "INSERT INTO professores (nome, email, data_nascimento, salario_base, curso_id) VALUES (?, ?, ?, ?, ?)");

            instrucao.setString(1, professor.getNome());
            instrucao.setString(2, professor.getEmail());
            instrucao.setDate(3, java.sql.Date.valueOf(professor.getDataNascimento()));
            instrucao.setDouble(4, professor.getSalarioBase());
            instrucao.setInt(5, professor.getCurso().getId());

            int rowsAffected = instrucao.executeUpdate();

            System.out.println("Pronto! " + rowsAffected + " linha(s) afetada(s).");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
