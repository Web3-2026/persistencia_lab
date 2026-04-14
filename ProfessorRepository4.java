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
        PreparedStatement statement = null;

        try {
            statement = conexao.prepareStatement(
                    "INSERT INTO professores (nome, email, data_nascimento, salario_base, curso_id) VALUES (?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, professor.getNome());
            statement.setString(2, professor.getEmail());
            statement.setDate(3, java.sql.Date.valueOf(professor.getDataNascimento()));
            statement.setDouble(4, professor.getSalarioBase());
            statement.setInt(5, professor.getCurso().getId());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = statement.getGeneratedKeys();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    System.out.println("Pronto! Id: " + id);
                }
            } else {
                System.out.println("Nenhuma linha afetada!");
            }

            System.out.println("Pronto! " + rowsAffected + " linha(s) afetada(s).");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void atualizar() {

        PreparedStatement instrucao = null;

        try {

            instrucao = conexao.prepareStatement(
                    "UPDATE professores SET salario_base = salario_base + ? WHERE curso_id = ?");

            instrucao.setDouble(1, 200.0);
            instrucao.setInt(2, 2);

            int rowsAffected = instrucao.executeUpdate();

            System.out.println("Pronto! " + rowsAffected + " linha(s) afetada(s).");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
