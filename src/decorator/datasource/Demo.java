package decorator.datasource;

public class Demo {
    public static void main(String[] args) {
        // exemple de données à sauvegarder encrypter et compressé
        /*

        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";

        DataSource dataSource = new FileDataSource("OutputDemo.txt");
        Encryptor encryptor = new Encryptor();
        Compressor compressor = new Compressor();

        String encoded = encryptor.encode(salaryRecords);
        String encodedAndCompressed = compressor.compress(encoded);
        dataSource.writeData(encodedAndCompressed);

        String valeurLue = dataSource.readData();
        String uncompressed = compressor.decompress(valeurLue);
        String uncompressedAndDecrypted = encryptor.decode(uncompressed);
        System.out.println(uncompressedAndDecrypted);
    */
    }

    /**
     * Nudiste => FileDataSource
     * Personne => DataSource
     * DataSourceDecorator
     * EncryptorDecorator (utilise Encryptor)
     * CompressorDecorator (utilise Compressor)
     */
}