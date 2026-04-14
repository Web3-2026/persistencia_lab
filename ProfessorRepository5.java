public class ProfessorRepository {

    private Connection conexao;

    public ProfessorRepositoryKeys() {

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

    public void inserir(Professor professor) {
        PreparedStatement consultaPreparada = null;

        try {
            consultaPreparada = conexao.prepareStatement(
                    "INSERT INTO professores (nome, email, data_nascimento, salario_base, curso_id) VALUES (?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            consultaPreparada.setString(1, professor.getNome());
            consultaPreparada.setString(2, professor.getEmail());
            consultaPreparada.setDate(3, java.sql.Date.valueOf(professor.getDataNascimento()));
            consultaPreparada.setDouble(4, professor.getSalarioBase());
            consultaPreparada.setInt(5, professor.getCurso().getId());

            int rowsAffected = consultaPreparada.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet resultados = consultaPreparada.getGeneratedKeys();
                while (resultados.next()) {
                    int id = resultados.getInt(1);
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

        PreparedStatement consultaPreparada = null;

        try {

            consultaPreparada = conexao.prepareStatement(
                    "UPDATE professores SET salario_base = salario_base + ? WHERE curso_id = ?");

            consultaPreparada.setDouble(1, 200.0);
            consultaPreparada.setInt(2, 2);

            int rowsAffected = consulta.executeUpdate();

            System.out.println("Pronto! " + rowsAffected + " linha(s) afetada(s).");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remover() {

        PreparedStatement consultaPreparada = null;

        try {
            consultaPreparada = conexao.prepareStatement(
                    "DELETE FROM professores "
                            + "WHERE "
                            + "Id = ?");

            consultaPreparada.setInt(1, 2);

            int rowsAffected = consultaPreparada.executeUpdate();

            System.out.println("Pronto! " + rowsAffected + " linha(s) afetada(s).");
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
