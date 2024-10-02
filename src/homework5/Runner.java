package homework5;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

public class Runner {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        BigDecimal bankMoney = new BigDecimal(1500);
        Bank bank = createBank(bankMoney);
        Thief thief = createThief();

        Method stealMoney = Thief.class.getDeclaredMethod("stealMoney", Bank.class);
        stealMoney.setAccessible(true);
        stealMoney.invoke(thief, bank);

        System.out.println(bank);
        System.out.println(thief);
    }


    public static Bank createBank(BigDecimal bankMoney) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Bank> bankClass = Bank.class;
        Constructor<Bank> bankConstructor = bankClass.getDeclaredConstructor(BigDecimal.class);
        bankConstructor.setAccessible(true);
        return bankConstructor.newInstance(bankMoney);
    }

    public static Thief createThief() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Thief> thiefClass = Thief.class;
        Constructor<Thief> thiefConstructor = thiefClass.getDeclaredConstructor();
        thiefConstructor.setAccessible(true);
        return thiefConstructor.newInstance();
    }
}
