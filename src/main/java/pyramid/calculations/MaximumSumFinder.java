package pyramid.calculations;

import utils.Utility;

import java.io.BufferedReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

import static pyramid.calculations.NodeElementInPyramid.EvenOrOdd;

public class MaximumSumFinder {

    public long calculateMaximumSumDiagnally(Path inputFilePath) throws IOException {
        int numbersInRow = 1;
        List<NodeElementInPyramid> nodeElementInPyramidList = new LinkedList<>();
        try (BufferedReader bufferedReader = new BufferedReader(Files.newBufferedReader(inputFilePath))) {
            String line = bufferedReader.readLine();
            if (line == null) {
                throw new MaximumSumFinderException("Input file is empty");
            }
            NodeElementInPyramid firstNode = new NodeElementInPyramid(Integer.parseInt(line));
            nodeElementInPyramidList.add(firstNode);
            numbersInRow++;
            while ((line = bufferedReader.readLine()) != null) {
                String[] nextRowNumbers = line.split(" ");
                if(nextRowNumbers.length != numbersInRow){
                    throw new MaximumSumFinderException("Input file is not correct: Count of numbers is not equal to Row number");
                }
                 firstNode = getSiblingsForCurrentNode(firstNode, nextRowNumbers);
                numbersInRow++;
            }
            return firstNode.getSum();


        } catch (IOException | NumberFormatException e) {
            throw new MaximumSumFinderException("Exception occured while parsing the file " + inputFilePath.getFileName().toString(), e);
        }

    }

    private NodeElementInPyramid getSiblingsForCurrentNode(NodeElementInPyramid node, String[] nextRowNumbers) {
        List<NodeElementInPyramid> nodeElementInPyramidList = new LinkedList<>();
        for (int index = node.getLastIndexInPyramid(); index < node.getLastIndexInPyramid()+2; index++) {
            EvenOrOdd evenOrOdd = EvenOrOdd.getEvenOrOdd(Integer.parseInt(nextRowNumbers[index]));
            if (!node.getIsEvenOrOdd().equals(evenOrOdd)) {
                nodeElementInPyramidList.add(new NodeElementInPyramid(Integer.parseInt(nextRowNumbers[index]), index, evenOrOdd));
            }
        }

        if(nodeElementInPyramidList.size() >1){
            nodeElementInPyramidList.sort((node1,node2) -> {
                long differenceValue = (node2.getSum() - node1.getSum());
                return differenceValue == 0 ? 0 : (differenceValue < 0 ? -1 : 1);
            });
        }
        NodeElementInPyramid nodeElementInPyramid = nodeElementInPyramidList.stream().findFirst().get();
        return new NodeElementInPyramid(node.getSum()+nodeElementInPyramid.getSum(),nodeElementInPyramid.getLastIndexInPyramid(),nodeElementInPyramid.getIsEvenOrOdd());
        //return nodeElementInPyramidList.stream().findFirst().get();
    }
}
