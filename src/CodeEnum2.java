import javax.lang.model.type.ArrayType;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface CodeEnum2<E extends Enum<E>> {

    String getCode();

    String getName();

    default int getOrder() {
        return Integer.parseInt(getCode());
    }

    @SuppressWarnings("unchekced")
    default E toEnum(){
        return (E) this;
    }

    default  boolean equalsByCode(String code){
        return getCode().equals(code);
    }

    static <E extends Enum<E>> List<E> getOrderedList(Class<? extends CodeEnum2<E>> clazz){
        return Arrays.stream(clazz.getEnumConstants())
                .sorted(Comparator.comparing(CodeEnum2::getOrder))
                .map(CodeEnum2::toEnum)
                .collect(Collectors.toList());
    }

    static <E extends Enum<E>> E getEnum(Class<? extends CodeEnum2<E>> clazz, String code) {
        return Arrays.stream(clazz.getEnumConstants())
                .filter(e -> e.equalsByCode(code))
                .map(CodeEnum2::toEnum)
                .findFirst()
                .orElse(null);
    }

    static <E extends Enum<E>> Map<String, E> getMap(Class<? extends CodeEnum2<E>> clazz) {
        return Arrays.stream(clazz.getEnumConstants())
                .collect(Collectors.toMap(CodeEnum2::getCode, CodeEnum2::toEnum));
    }

    static <E extends Enum<E>> boolean hasCode(Class<? extends CodeEnum2<E>> clazz, String code) {
        return Arrays.stream(clazz.getEnumConstants())
                .anyMatch(e -> e.equalsByCode(code));
    }


}
