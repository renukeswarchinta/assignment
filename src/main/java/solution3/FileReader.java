package solution3;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class FileReader {

    public Map<Integer,List<String>> readInputFile(Path inputFilePath) {
        int lineNumber =1;
        Map<Integer,List<String>> inputElementsLineByLineMap = new LinkedHashMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(Files.newBufferedReader(inputFilePath))) {
            String line = bufferedReader.readLine();
            List<String> list= new LinkedList<String>();
            list.add(line);
            inputElementsLineByLineMap.put(lineNumber,list);
            while((line = bufferedReader.readLine()) != null){
                lineNumber++;
                List<String> nextLineElements = Arrays.asList(line.split(" "));
                inputElementsLineByLineMap.put(lineNumber,nextLineElements);

            }
        } catch (IOException e) {
            throw new MaximumSumFinderException("Exception occured while reading the file");
        }
        return inputElementsLineByLineMap;
    }
}
