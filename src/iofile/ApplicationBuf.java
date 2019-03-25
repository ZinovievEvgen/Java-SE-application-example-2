package iofile;/*
ПРИМЕР ИСПОЛЬЗУЕТ МЕТОД ВВОДА ДАННЫХ ИЗ txt файла
ВЫВОД СООТВЕТСТВЕНО ТАКЖЕ
*************************************************
пример №1: D:\task\nailyaTask1_Prod\src\input\input1.txt (D:\task\nailyaTask1_Prod\src\output\output1.txt)
пример №2: D:\task\nailyaTask1_Prod\src\input\input2.txt  (D:\task\nailyaTask1_Prod\src\output\output2.txt)
пример №3: D:\task\nailyaTask1_Prod\src\input\input3.txt  (D:\task\nailyaTask1_Prod\src\output\output3.txt)
пример №2: D:\task\nailyaTask1_Prod\src\input\input4.txt  (D:\task\nailyaTask1_Prod\src\output\output4.txt)
 */

import java.io.*;
import java.util.*;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class ApplicationBuf {

    private static Logger loga;

    static {
        InputStream stream = ApplicationBuf.class.getClassLoader().
                getResourceAsStream("logging.properties");
        try {
            LogManager.getLogManager().readConfiguration(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        loga = Logger.getLogger(ApplicationBuf.class.getName());
    }


    public static void main(String[] args) throws IOException {
        loga.severe("Стартуем");
        loga.severe("*******************************************");
        loga.severe("BY SAiDHazzarD");
        //считываем порядок наследования исключений
        //создаем BufferedReader с существующего FileReader для построчного считывания
        BufferedReader reader = new BufferedReader(new FileReader("D:\\task\\nailyaTask1_Prod\\src\\input\\input4.txt"));
        loga.info("Открываем файл - input4.txt");
        // считаем сначала первую строку
        Map<String, String> exceptionParent = new HashMap<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            int indexInStr = input.indexOf(':');
            if (indexInStr > 0) {
                // разделяем строку на 2 части и записываем ее в МАПУ
                String subInput1 = input.substring(0, indexInStr).trim();
                String subInput2 = input.substring(indexInStr + 2).trim();
                exceptionParent.put(subInput1, subInput2);
            } else {
                // если метод ни от кого не наследуется то пишем в значении у него ноль
                exceptionParent.put(input, "null");
            }
        }
        // выводим МАПУ с порядком наследования
        Iterator<Map.Entry<String, String>> iterator = exceptionParent.entrySet().iterator();
        loga.warning("Создали MAP с наследниками");
        while (iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();
            String key = pair.getKey();
            String value = pair.getValue();
            //System.out.println(key + ":" + value);
            loga.info(key + ":" + value);

        }

        OutputExceptionGoToHellByGilfoil(InputExceptionInCode(reader), exceptionParent);
    }

    // метод по обработке исключений
    public static List<String> InputExceptionInCode(BufferedReader reader) throws IOException {
        int m = Integer.parseInt(reader.readLine());
        ArrayList<String> exceptionInCode = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            exceptionInCode.add(reader.readLine().trim());
        }
        reader.close();
        return exceptionInCode;
    }

    //метод поиска наследников
    public static Set<String> OutputExceptionGoToHellByGilfoil(List<String> inputList, Map<String, String> inputMap) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\task\\nailyaTask1_Prod\\src\\output\\output4.txt"));
        loga.warning("Запись ведется в файл - output4.txt");
        HashSet<String> outputSet = new HashSet<>();
        String index;
        boolean spectr = false;
        for (int i = 0; i < inputList.size(); i++) {
            index = inputMap.get(inputList.get(i));
            while (index != null && !spectr) {
                for (int j = 0; j < i; j++) {
                    if (index.equals(inputList.get(j))) {
                        if (outputSet.contains(inputList.get(i))){
                            loga.warning("OUTSET содержит запись: " + inputList.get(i));
                        }
                        else {
                            outputSet.add(inputList.get(i));
                            spectr = true;
                            String output = inputList.get(i);
                            bw.write(output + "\n");
                            loga.warning("Добавление записи в OUTSET: " + inputList.get(i));
                        }
                    }
                }
                index = inputMap.get(index);
                spectr = false;
            }
        }
        bw.flush();
        bw.close();
        return outputSet;
    }
}