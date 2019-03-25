package console;/*
ПРИМЕР ИСПОЛЬЗУЕТ МЕТОД ВВОДА ДАННЫХ ИЗ КОНСОЛИ
ВЫВОД СООТВЕТСТВЕНО ТАКЖЕ В КОНСОЛЬ
 */
import java.util.*;

public class Application {
    public static void main(String[] args) {
        //считываем порядок наследования исключений
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        Map<String, String> exceptionParent = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            int indexInStr = input.indexOf(':');
            if (indexInStr > 0) {
                String subInput1 = input.substring(0, indexInStr).trim();
                String subInput2 = input.substring(indexInStr + 2).trim();
                exceptionParent.put(subInput1, subInput2);
            } else {
                exceptionParent.put(input, "null");
            }
        }
        // выводим МАПУ с порядком наследования
        Iterator<Map.Entry<String, String>> iterator = exceptionParent.entrySet().iterator();
        System.out.println("Смотри мать его МАПУ!!!");
        while (iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();
            String key = pair.getKey();
            String value = pair.getValue();
            System.out.println(key + ":" + value);
        }

        OutputExceptionGoToHellByGilfoil(InputExceptionInCode(scan), exceptionParent);
    }

    // метод по обработке исключений
    public static List<String> InputExceptionInCode(Scanner scan) {
        int m = scan.nextInt();
        ArrayList<String> exceptionInCode = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            exceptionInCode.add(scan.next().trim());
        }
        scan.close();
        return exceptionInCode;
    }

    //метод поиска наследников
    public static List<String> OutputExceptionGoToHellByGilfoil(List<String> inputList, Map<String, String> inputMap) {
        ArrayList<String> outputList = new ArrayList<>();
        String index;
        boolean spectr = false;
        for (int i = 0; i < inputList.size(); i++) {
            index = inputMap.get(inputList.get(i));
            while (index != null && !spectr) {
                for (int j = 0; j < i; j++) {
                    if (index.equals(inputList.get(j))) {
                        outputList.add(inputList.get(i));
                        spectr = true;
                        System.out.println("добавляем в аутЛист: " + inputList.get(i));
                    }
                }
                index = inputMap.get(index);
            }
        }
        return outputList;
    }
}