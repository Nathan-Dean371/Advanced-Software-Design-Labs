package ie.atu.sw;

public sealed interface Advisory<T> permits Advisory.Present, Advisory.Absent 
{
	record Present<T>(T value) implements Advisory<T> {}
    record Absent<T>() implements Advisory<T> {}
    
    default boolean isPresent()
    {
    	return this instanceof  Present<T>;
    }
    
    default T orElse(T defaultValue) {
        return switch(this) {
            case Present<T>(T value) -> value;
            case Absent<T> absent -> defaultValue;
        };
    }
}
