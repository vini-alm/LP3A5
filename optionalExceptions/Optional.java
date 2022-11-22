public class Optional {
  public static void main(String[] args) {
    Optional<String> empty = Optional.empty();
    System.out.println("empty = " + empty);
    Optional<String> string = Optional.of("Hello");
    System.out.println("string = " + string);
    Optional<String> nullString = Optional.of(null);
    System.out.println("nullString = " + nullString);
    Optional<String> optionalString = Optional.ofNullable(null);
    System.out.println("optionalString = " + optionalString);
    String value = string.get();
    System.out.println("value = " + value);
    String defaultValue = empty.orElse("default value");
    System.out.println("defaultValue = " + defaultValue);
    String defaultNullValue = optionalString.orElse("default null value");
}
