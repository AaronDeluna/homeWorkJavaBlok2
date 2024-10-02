package homework5;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

public class Runner {
    private static final String STEAL_MONEY_METHOD_NAME = "stealMoney";
    public static void main(String[] args) throws NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {
        Bank bank = createBank(BigDecimal.valueOf(1500));
        Thief thief = createThief();

        stealMoney(thief, bank);
        printState(thief, bank);
    }

    /**
     * Метод для кражи денег из банка.
     *
     * @param thief Вор.
     * @param bank Банк.
     * @throws InvocationTargetException Если метод вызывает исключение.
     * @throws IllegalAccessException Если доступ к методу запрещён.
     * @throws NoSuchMethodException Если метод не найден.
     */
    public static void stealMoney(Thief thief, Bank bank) throws InvocationTargetException,
            IllegalAccessException, NoSuchMethodException {
        Method stealMoney = Thief.class.getDeclaredMethod(STEAL_MONEY_METHOD_NAME, Bank.class);
        stealMoney.setAccessible(true);
        stealMoney.invoke(thief, bank);
    }

    /**
     * Создаёт экземпляр банка с заданной суммой денег.
     *
     * @param bankMoney Сумма денег для банка.
     * @return Экземпляр класса {@link Bank}.
     * @throws NoSuchMethodException Если конструктор не найден.
     * @throws InvocationTargetException Если конструктор вызывает исключение.
     * @throws InstantiationException Если не удаётся создать экземпляр.
     * @throws IllegalAccessException Если доступ к конструктору запрещён.
     */
    public static Bank createBank(BigDecimal bankMoney) throws NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Bank> bankClass = Bank.class;
        Constructor<Bank> bankConstructor = bankClass.getDeclaredConstructor(BigDecimal.class);
        bankConstructor.setAccessible(true);
        return bankConstructor.newInstance(bankMoney);
    }

    /**
     * Создаёт экземпляр вора.
     *
     * @return Экземпляр класса {@link Thief}.
     * @throws NoSuchMethodException Если конструктор не найден.
     * @throws InvocationTargetException Если конструктор вызывает исключение.
     * @throws InstantiationException Если не удаётся создать экземпляр.
     * @throws IllegalAccessException Если доступ к конструктору запрещён.
     */
    public static Thief createThief() throws NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Thief> thiefClass = Thief.class;
        Constructor<Thief> thiefConstructor = thiefClass.getDeclaredConstructor();
        thiefConstructor.setAccessible(true);
        return thiefConstructor.newInstance();
    }

    /**
     * Выводит состояние вора и банка.
     *
     * @param thief Вор для отображения состояния.
     * @param bank Банк для отображения состояния.
     */
    private static void printState(Thief thief, Bank bank) {
        System.out.println(thief);
        System.out.println(bank);
    }
}
