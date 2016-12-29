import com.intellij.openapi.editor.actionSystem.EditorAction;

/**
 * The type Uuid here without minus.
 *
 * @author Miku
 * @version 1.0.0
 */
public class UUIDHereWithoutMinus extends EditorAction {

    private static String MINUS = "-";
    private static String EMPTY = "";

    /**
     * Instantiates a new Uuid here without minus.
     */
    public UUIDHereWithoutMinus() {

        super(new UUIDHereActionHandler() {
            @Override
            protected String generateUUID() {
                return super.generateUUID().replaceAll(MINUS, EMPTY);
            }
        });
    }
}
