package p000;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.widget.EditText;
import androidx.appcompat.R;
import androidx.emoji2.viewsintegration.EmojiEditTextHelper;

/* renamed from: k9 */
/* loaded from: classes.dex */
public final class C1383k9 {

    /* renamed from: a */
    public final EditText f20790a;

    /* renamed from: b */
    public final EmojiEditTextHelper f20791b;

    public C1383k9(EditText editText) {
        this.f20790a = editText;
        this.f20791b = new EmojiEditTextHelper(editText, false);
    }

    /* renamed from: a */
    public final KeyListener m5512a(KeyListener keyListener) {
        if (!(keyListener instanceof NumberKeyListener)) {
            return this.f20791b.getKeyListener(keyListener);
        }
        return keyListener;
    }

    /* renamed from: b */
    public final void m5513b(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.f20790a.getContext().obtainStyledAttributes(attributeSet, R.styleable.AppCompatTextView, i, 0);
        try {
            int i2 = R.styleable.AppCompatTextView_emojiCompatEnabled;
            boolean z = true;
            if (obtainStyledAttributes.hasValue(i2)) {
                z = obtainStyledAttributes.getBoolean(i2, true);
            }
            obtainStyledAttributes.recycle();
            this.f20791b.setEnabled(z);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }
}
