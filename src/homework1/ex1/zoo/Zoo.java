package homework1.ex1.zoo;

import homework1.ex1.animal.Animal;

public class Zoo<T extends Animal> {
    T entity;

    public Zoo(T entity) {
        this.entity = entity;
    }

    public T getEntity() {
        return entity;
    }
}
