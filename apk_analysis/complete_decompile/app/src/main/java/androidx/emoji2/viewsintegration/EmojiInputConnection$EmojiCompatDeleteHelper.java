package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.emoji2.text.EmojiCompat;

/* loaded from: classes.dex */
public class EmojiInputConnection$EmojiCompatDeleteHelper {
    public boolean handleDeleteSurroundingText(@NonNull InputConnection inputConnection, @NonNull Editable editable, @IntRange(from = 0) int i, @IntRange(from = 0) int i2, boolean z) {
        return EmojiCompat.handleDeleteSurroundingText(inputConnection, editable, i, i2, z);
    }

    public void updateEditorInfoAttrs(@NonNull EditorInfo editorInfo) {
        if (EmojiCompat.isConfigured()) {
            EmojiCompat.get().updateEditorInfo(editorInfo);
        }
    }
}
