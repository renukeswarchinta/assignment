package solution2;

import pyramid.calculations.EvenOrOdd;
import pyramid.calculations.MaximumSumFinderException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class FindSumValueInPyramid {

    public long calculateMaximumSumDiagnally(Path inputFilePath) throws IOException {
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
            while ((line = bufferedReader.readLine()) != null) {
                String[] nextRowNumbers = line.split(" ");
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
                currentNode = binaryTree.add(nextRowNumbers, currentNode);
                System.out.println(currentNode.getUpdatedSum());


            }
            //traversePostOrder(rootNode);
            return currentNode.getUpdatedSum();
        }
    }


    public long traversePostOrder(Node node) {
        long sum = 0;
        if (node != null) {
            if(node.getDirection().equalsIgnoreCase("main")) {

                sum += node.getValue();
                traversePostOrder(node.getLeft());
            }else if(node.getDirection().equalsIgnoreCase("left")){
                sum += node.getValue();
                traversePostOrder(node.getLeft());

            }else {
                sum += node.getValue();
                traversePostOrder(node.getRight());

            }
            System.out.println(sum);
        }
        return sum;
    }
}
