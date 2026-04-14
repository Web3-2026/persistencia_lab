public class ProfessorRepository {

    private Connection conexao;

    public ProfessorRepository() {

        ConexaoFactory conexaoFactory = new ConexaoFactory();
        conexao = conexaoFactory.getConnection();
    }

    public List<Professor> getProfessors() {

        List<Professor> professors = new ArrayList<>();

        Statement instrucao = null;
        ResultSet resultados = null;

        try {
            instrucao = conexao.createStatement();
            resultados = instrucao.executeQuery("SELECT * FROM professores");

            while (resultados.next()) {
                Professor professor = new Professor();

                professor.setId(resultados.getInt("professor_id"));
                professor.setNome(resultados.getString("nome"));
                professor.setSalarioBase(resultados.getDouble("salario_base"));
                professor.setDataNascimento(resultados.getDate("data_nascimento").toLocalDate());

                professors.add(professor);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            // ConexaoFactory.resultSetClose(resultados);
            // ConexaoFactory.statementClose(instrucao);
        }

        return professors;

    }

}
