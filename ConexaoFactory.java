public class ConexaoFactory {

    public Connection getConnection(){
        
        String database = "";
        String user = "";
        String pass = "";

        try {
            
            return DriverManager.getConnection("jdbc:mysql://localhost/" + database, user, pass);

        } catch (SQLException e) {
            
            throw new RuntimeException(e);
        
        }
    }

}
