import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.editor.actionSystem.EditorWriteActionHandler;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * The type Uuid here action handler.
 *
 * @author Miku
 * @version 1.0.0
 */
public class UUIDHereActionHandler extends EditorWriteActionHandler {

    @Override
    public void executeWriteAction(Editor editor, @Nullable Caret caret, DataContext dataContext) {
        SelectionModel selectionModel = editor.getSelectionModel();
        String selectedText = selectionModel.getSelectedText();

        String uuid = generateUUID();

        if (selectedText == null) {

            int position = editor.getCaretModel().getOffset();

            editor.getDocument().insertString(position, uuid);
            editor.getCaretModel().moveToOffset(position + uuid.length());

        } else {
            editor.getDocument().replaceString(selectionModel.getSelectionStart(), selectionModel.getSelectionEnd(), uuid);
        }
    }

    /**
     * Generate uuid string.
     *
     * @return the string
     */
    protected String generateUUID() {
        return UUID.randomUUID().toString();
    }
}
