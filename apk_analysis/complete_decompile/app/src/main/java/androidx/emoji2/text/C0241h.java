package androidx.emoji2.text;

import android.text.Spannable;
import android.text.SpannableString;
import androidx.emoji2.text.EmojiCompat;
import p000.h80;
import p000.i03;

/* renamed from: androidx.emoji2.text.h */
/* loaded from: classes.dex */
public final class C0241h implements h80 {

    /* renamed from: a */
    public i03 f4290a;

    /* renamed from: b */
    public final EmojiCompat.SpanFactory f4291b;

    public C0241h(i03 i03Var, EmojiCompat.SpanFactory spanFactory) {
        this.f4290a = i03Var;
        this.f4291b = spanFactory;
    }

    @Override // p000.h80
    /* renamed from: b */
    public final boolean mo1081b(CharSequence charSequence, int i, int i2, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        Spannable spannableString;
        if (typefaceEmojiRasterizer.isPreferredSystemRender()) {
            return true;
        }
        if (this.f4290a == null) {
            if (charSequence instanceof Spannable) {
                spannableString = (Spannable) charSequence;
            } else {
                spannableString = new SpannableString(charSequence);
            }
            this.f4290a = new i03(spannableString);
        }
        this.f4290a.setSpan(this.f4291b.createSpan(typefaceEmojiRasterizer), i, i2, 33);
        return true;
    }

    @Override // p000.h80
    public final Object getResult() {
        return this.f4290a;
    }
}
