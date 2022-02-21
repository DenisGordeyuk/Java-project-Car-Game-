public class GenericCar<T> {
    private T carExemplar;

    public T setup(T car) {
        this.carExemplar = car;
        return carExemplar;
    }
}
