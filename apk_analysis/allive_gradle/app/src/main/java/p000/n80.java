package p000;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.EmojiCompat;

/* loaded from: classes.dex */
public final class n80 implements TextWatcher {

    /* renamed from: a */
    public final EditText f23278a;

    /* renamed from: b */
    public final boolean f23279b;

    /* renamed from: c */
    public m80 f23280c;

    /* renamed from: d */
    public int f23281d = Integer.MAX_VALUE;

    /* renamed from: e */
    public int f23282e = 0;

    /* renamed from: f */
    public boolean f23283f = true;

    public n80(EditText editText, boolean z) {
        this.f23278a = editText;
        this.f23279b = z;
    }

    /* renamed from: a */
    public static void m6319a(EditText editText, int i) {
        if (i == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            EmojiCompat.get().process(editableText);
            if (selectionStart >= 0 && selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionStart, selectionEnd);
            } else if (selectionStart >= 0) {
                Selection.setSelection(editableText, selectionStart);
            } else if (selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionEnd);
            }
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        EditText editText = this.f23278a;
        if (!editText.isInEditMode() && this.f23283f) {
            if ((this.f23279b || EmojiCompat.isConfigured()) && i2 <= i3 && (charSequence instanceof Spannable)) {
                int loadState = EmojiCompat.get().getLoadState();
                if (loadState != 0) {
                    if (loadState != 1) {
                        if (loadState != 3) {
                            return;
                        }
                    } else {
                        EmojiCompat.get().process((Spannable) charSequence, i, i + i3, this.f23281d, this.f23282e);
                        return;
                    }
                }
                EmojiCompat emojiCompat = EmojiCompat.get();
                if (this.f23280c == null) {
                    this.f23280c = new m80(editText);
                }
                emojiCompat.registerInitCallback(this.f23280c);
            }
        }
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
