final class Storage<T> {
    private final T value;
    private final T defaultValue;

    public Storage(T value, T defaultValue) {
        this.value = value;
        this.defaultValue = defaultValue;
    }

    public Storage() {
        this.value = null;
        this.defaultValue = null;
    }

    public T getValue() {
        return value != null ? value : defaultValue;
    }

    public String toString() {
        return ("Содержимое хранилища: " + value);
    }
}