import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class ParseCSV
{

    public static Country[] Parser(File file) throws IOException {
        ArrayList<Country> arr = new ArrayList<>();
        Reader in = new FileReader(file);
        CSVParser parser = new CSVParser(in, CSVFormat.DEFAULT);
        List<CSVRecord> list = parser.getRecords();
        for(CSVRecord row : list)
            for(String entry : row) {
                String[] data = entry.split(";");
                try {
                    arr.add(new Country(data[0], data[1], Integer.parseInt(data[2])));
                } catch (Throwable t) {}
            }
        return arr.toArray(new Country[0]);
    }
}