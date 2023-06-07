package decorator.datasource;

public class DemoAvecDecorator {
    public static void main(String[] args) {
        // exemple de données à sauvegarder encrypter et compressé
        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";

        DataSource fileDataSource = new FileDataSource("OutputDemo.txt");
        DataSource fileDataSource2 = fileDataSource;

        // TODO
        System.out.println("-----On chiffre");
        fileDataSource = new Encryptor(fileDataSource);
        fileDataSource.writeData(salaryRecords);
        //1 Encryptor qui lit vs 1 FileDataSource
        System.out.println("-----1 Encryptor qui lit vs 1 FileDataSource");

        System.out.println(fileDataSource2.readData());
        System.out.println(fileDataSource.readData());
        DataSource fileDataSource3 = fileDataSource;
        System.out.println("-----On va maintenant ajouter la compression");
        fileDataSource = new Compressor(fileDataSource);
        fileDataSource.writeData(salaryRecords);
        System.out.println(fileDataSource2.readData());
        System.out.println(fileDataSource.readData());
        System.out.println("------Est ce qu'un encrypteur peut lire ce qu'à fait un encrypteur+compresseur ?");
        System.out.println(fileDataSource3.readData());
        System.out.println(fileDataSource.readData());
        //Non mais le plus habillé de tous fait les deux
    }
}