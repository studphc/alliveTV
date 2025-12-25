package p000;

import android.text.Editable;
import androidx.emoji2.text.SpannableBuilder;

/* loaded from: classes.dex */
public final class b80 extends Editable.Factory {

    /* renamed from: a */
    public static final Object f7919a = new Object();

    /* renamed from: b */
    public static volatile b80 f7920b;

    /* renamed from: c */
    public static Class f7921c;

    @Override // android.text.Editable.Factory
    public final Editable newEditable(CharSequence charSequence) {
        Class cls = f7921c;
        if (cls != null) {
            return SpannableBuilder.create(cls, charSequence);
        }
        return super.newEditable(charSequence);
    }
}
