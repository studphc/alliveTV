package p000;

import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import androidx.emoji2.viewsintegration.EmojiInputConnection$EmojiCompatDeleteHelper;

/* loaded from: classes.dex */
public final class d80 extends InputConnectionWrapper {

    /* renamed from: a */
    public final EditText f16285a;

    /* renamed from: b */
    public final EmojiInputConnection$EmojiCompatDeleteHelper f16286b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d80(EditText editText, InputConnection inputConnection, EditorInfo editorInfo) {
        super(inputConnection, false);
        EmojiInputConnection$EmojiCompatDeleteHelper emojiInputConnection$EmojiCompatDeleteHelper = new EmojiInputConnection$EmojiCompatDeleteHelper();
        this.f16285a = editText;
        this.f16286b = emojiInputConnection$EmojiCompatDeleteHelper;
        emojiInputConnection$EmojiCompatDeleteHelper.updateEditorInfoAttrs(editorInfo);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i, int i2) {
        if (!this.f16286b.handleDeleteSurroundingText(this, this.f16285a.getEditableText(), i, i2, false) && !super.deleteSurroundingText(i, i2)) {
            return false;
        }
        return true;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        if (!this.f16286b.handleDeleteSurroundingText(this, this.f16285a.getEditableText(), i, i2, true) && !super.deleteSurroundingTextInCodePoints(i, i2)) {
            return false;
        }
        return true;
    }
}
