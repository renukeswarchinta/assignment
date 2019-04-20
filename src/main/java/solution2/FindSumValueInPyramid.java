package solution2;

import pyramid.calculations.EvenOrOdd;
import pyramid.calculations.MaximumSumFinderException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class FindSumValueInPyramid {

    public long calculateMaximumSumDiagnally(Path inputFilePath) throws IOException {
        int numbersInRow = 1;
        try (BufferedReader bufferedReader = new BufferedReader(Files.newBufferedReader(inputFilePath))) {
            String line = bufferedReader.readLine();
            if (line == null) {
                throw new MaximumSumFinderException("Input file is empty");
            }
            BinaryTree binaryTree = new BinaryTree();
            Node rootNode = new Node(Integer.parseInt(line), EvenOrOdd.getEvenOrOdd(Integer.parseInt(line)), 0, "main");
            // node = binaryTree.add(Integer.parseInt(line));
            Node currentNode = rootNode;
            currentNode.setUpdatedSum(Integer.parseInt(line));
            numbersInRow++;
            while ((line = bufferedReader.readLine()) != null) {
                String[] nextRowNumbers = line.split(" ");
                if (nextRowNumbers.length != numbersInRow) {
                    throw new MaximumSumFinderException("Input file is not correct: Count of numbers is not equal to Row number");
                }
                while (currentNode != null) {
                    if (currentNode.getDirection().equalsIgnoreCase("main") && currentNode.getLeft() == null && currentNode.getRight() == null) {
                        currentNode = rootNode;
                        break;
                    } else if (currentNode.getLeft() == null) {
                        currentNode = currentNode.getRight();
                        break;
                    } else {
                        currentNode = currentNode.getLeft();
                        break;
                    }
                }
                currentNode = binaryTree.add(nextRowNumbers, currentNode, rootNode);
                numbersInRow++;
            }
            return rootNode.getUpdatedSum();
        } catch (IOException | NumberFormatException e) {
            throw new MaximumSumFinderException("Exception occured while parsing the file " + inputFilePath.getFileName().toString(), e);
        }
    }
}


