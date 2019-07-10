import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
public static ArrayList<Items> mainlist = new ArrayList<>();

    public static void main(String[] args) {
        Collections.addAll(mainlist, new Items("Windows 10 coa", 1500), new Items( "Windows 7 coa", 1300),
                new Items("Win10 key", 1100), new Items("Win7key", 1000), new Items("Office16", 1500));
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, -3, -2, -1, 0, 1 , 2, 3, 4);

        list.stream()                                                                                                  // отфильтровали значения по > 0
                .filter(value -> value > 0)
                .forEach(System.out::println);

        windowsSells(mainlist);
        minAndMaxprice(mainlist);
    }

    public static void windowsSells(List<Items> win){
        win.stream().flatMap(wins -> Stream.of(
                String.format("\nItem: %s, price Руб %d", wins.getName(), wins.getPrice()),
                String.format("With discount 25%%! \nItem: %s, price Руб %d", wins.getName(), (int)(wins.getPrice() * 0.75))))
                .forEach(System.out::println);                                                                       //сделали из каждого объекта, два объекта в выводе
        List<Integer> prices = win.stream().map(Items::getPrice).collect(Collectors.toList());                       //собрали цены из одного листа в другой лист
        System.out.println();
        for (Integer price : prices) {
            System.out.println(price);
        }
    }

    public static void minAndMaxprice(List<Items> win){                                 //Нашли минимальную и максимальную цену в объектах Items, в классе Items написали простой компаратор
        Items maxprice = win.stream().max(Items::compare).get();
        System.out.println(String.format("\nMaximum price has %s. It is %d рублей!", maxprice.getName(), maxprice.getPrice()));

        Items minprice = win.stream().min(Items::compare).get();
        System.out.println(String.format("\nMinimal price has %s. It is %d рублей!", minprice.getName(), minprice.getPrice()));

        int allsumm = win.stream().map(Items::getPrice).reduce(0, Integer::sum); //Получили общую сумму всех стоимостей объектов в листе!
        System.out.println(String.format("\nСтоимость всех объектов в листе %d рублей!", allsumm));

        int win10summ = win.stream().filter(value -> value.getName().contains("10") && value.getName().contains("Win")).map(Items::getPrice).reduce(0, Integer::sum);
        System.out.println(String.format("\nСтоимость всех объектов Win10 в листе %d рублей!", win10summ)); //Отфильтровали, чтобы имя содержало "10" и "Win", выбрали цены этих объектов, сложили их с дефолтным значением 0
    }
}
