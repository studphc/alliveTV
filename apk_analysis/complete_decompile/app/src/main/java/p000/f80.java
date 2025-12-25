package p000;

import android.text.InputFilter;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji2.text.EmojiCompat;

/* loaded from: classes.dex */
public final class f80 implements InputFilter {

    /* renamed from: a */
    public final TextView f17165a;

    /* renamed from: b */
    public e80 f17166b;

    public f80(TextView textView) {
        this.f17165a = textView;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        TextView textView = this.f17165a;
        if (textView.isInEditMode()) {
            return charSequence;
        }
        int loadState = EmojiCompat.get().getLoadState();
        if (loadState != 0) {
            if (loadState != 1) {
                if (loadState != 3) {
                    return charSequence;
                }
            } else {
                if ((i4 != 0 || i3 != 0 || spanned.length() != 0 || charSequence != textView.getText()) && charSequence != null) {
                    if (i != 0 || i2 != charSequence.length()) {
                        charSequence = charSequence.subSequence(i, i2);
                    }
                    return EmojiCompat.get().process(charSequence, 0, charSequence.length());
                }
                return charSequence;
            }
        }
        EmojiCompat emojiCompat = EmojiCompat.get();
        if (this.f17166b == null) {
            this.f17166b = new e80(textView, this);
        }
        emojiCompat.registerInitCallback(this.f17166b);
        return charSequence;
    }
}
