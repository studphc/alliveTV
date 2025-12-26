package p000;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.emoji2.viewsintegration.EmojiTextViewHelper;

/* renamed from: l9 */
/* loaded from: classes.dex */
public final class C1503l9 {

    /* renamed from: a */
    public final TextView f22389a;

    /* renamed from: b */
    public final EmojiTextViewHelper f22390b;

    public C1503l9(TextView textView) {
        this.f22389a = textView;
        this.f22390b = new EmojiTextViewHelper(textView, false);
    }

    /* renamed from: a */
    public final void m5896a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.f22389a.getContext().obtainStyledAttributes(attributeSet, R.styleable.AppCompatTextView, i, 0);
        try {
            int i2 = R.styleable.AppCompatTextView_emojiCompatEnabled;
            boolean z = true;
            if (obtainStyledAttributes.hasValue(i2)) {
                z = obtainStyledAttributes.getBoolean(i2, true);
            }
            obtainStyledAttributes.recycle();
            m5898c(z);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* renamed from: b */
    public final void m5897b(boolean z) {
        this.f22390b.setAllCaps(z);
    }

    /* renamed from: c */
    public final void m5898c(boolean z) {
        this.f22390b.setEnabled(z);
    }
}
