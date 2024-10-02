package homework5;

import java.lang.reflect.Field;
import java.math.BigDecimal;

/**
 * Вор.
 */
public class Thief {
    private BigDecimal money;

    private Thief() {
        this.money = BigDecimal.ZERO;
    }

    private void stealMoney(Bank bank) throws NoSuchFieldException, IllegalAccessException {
        Class<Bank> bankClass = Bank.class;
        Field field = bankClass.getDeclaredField("money");
        field.setAccessible(true);
        Object bankMoney = field.get(bank);
        this.money = (BigDecimal) bankMoney;
        field.set(bank, BigDecimal.ZERO);
    }

    @Override
    public String toString() {
        return "Thief{" +
                "money=" + money +
                '}';
    }
}
