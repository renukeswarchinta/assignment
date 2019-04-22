package solution3;

import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaximumPathFinder {

    private FileReader fileReader = new FileReader();

    Element element = new Element.ElemnetBuilder(-1).index(0).build();

    public long findMaximumPath(Path inputFilePath) {
        Map<Integer, List<String>> inputData = fileReader.readInputFile(inputFilePath);
        //  map has line number with string values
        List<Element> finalResult = new LinkedList<>();

        for (Map.Entry<Integer, List<String>> keyValues : inputData.entrySet()) {
            List<String> values = keyValues.getValue();
            if (element.getNumber() < 0) {
                int index = element.getIndex();
                element = createElementInstance(Integer.parseInt(values.get(index)), index);
                finalResult.add(element);
            } else {

                element = getLastElementIndex((LinkedList<Element>) finalResult);
                List<Element> siblinElements = getSiblingElements(values, element);
                if (checkParityForElementInSubList2(siblinElements)) {
                    finalResult.add(Collections.max(siblinElements));
                } else {
                    if (element.getParity().name().equalsIgnoreCase("odd"))
                        finalResult.add(siblinElements.stream().filter(a -> a.getNumber() % 2 == 0).findFirst().get());
                     else
                        finalResult.add(siblinElements.stream().filter(a -> a.getNumber() % 2 != 0).findFirst().get());
                }
            }
        }
        return finalResult.stream().collect(Collectors.summingLong(Element::getNumber));
    }

    private boolean checkParityForElementInSubList2(List<Element> siblinElements) {
        int sum = siblinElements.stream().collect(Collectors.summingInt(Element::getNumber));
        return sum % 2 == 0;
    }

    private List<Element> getSiblingElements(List<String> list, Element element) {
        int index = element.getIndex();
        List<Element> siblingList = new LinkedList<>();
        for (int i = index; i < index + 2; i++) {

            siblingList.add(createElementInstance(Integer.parseInt(list.get(i)), i));

        }
        return siblingList;
    }


    private Element createElementInstance(Integer number, int index) {
        return new Element.ElemnetBuilder(number)
                .index(index)
                .parity(Parity.getParity(number))
                .build();
    }


    private Element getLastElementIndex(LinkedList<Element> elements) {
        return elements.getLast();
    }
}
