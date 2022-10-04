package bancodedados;

import ch.vorburger.mariadb4j.DB;
import ch.vorburger.mariadb4j.DBConfigurationBuilder;

public class IniciaDB {
    
    public static void main(String[] args) throws Exception {
        
        DBConfigurationBuilder configBuilder = DBConfigurationBuilder.newBuilder();
        configBuilder.setPort(3306); // OR, default: setPort(0); => autom. detect free port
        configBuilder.setDataDir("data"); // just an example
        DB db = DB.newEmbeddedDB(configBuilder.build());

        db.start();

        System.out.println("Creating DB");
        db.createDB("app");

        System.out.println("Loading SQLs");
        
        db.source("bancodedados/init.sql");

        System.out.println("Ready...");

    }


}
