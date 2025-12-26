package androidx.emoji2.text;

import android.text.TextPaint;
import androidx.core.graphics.PaintCompat;
import androidx.emoji2.text.EmojiCompat;

/* renamed from: androidx.emoji2.text.a */
/* loaded from: classes.dex */
public final class C0234a implements EmojiCompat.GlyphChecker {

    /* renamed from: b */
    public static final ThreadLocal f4230b = new ThreadLocal();

    /* renamed from: a */
    public final TextPaint f4231a;

    public C0234a() {
        TextPaint textPaint = new TextPaint();
        this.f4231a = textPaint;
        textPaint.setTextSize(10.0f);
    }

    @Override // androidx.emoji2.text.EmojiCompat.GlyphChecker
    public final boolean hasGlyph(CharSequence charSequence, int i, int i2, int i3) {
        ThreadLocal threadLocal = f4230b;
        if (threadLocal.get() == null) {
            threadLocal.set(new StringBuilder());
        }
        StringBuilder sb = (StringBuilder) threadLocal.get();
        sb.setLength(0);
        while (i < i2) {
            sb.append(charSequence.charAt(i));
            i++;
        }
        return PaintCompat.hasGlyph(this.f4231a, sb.toString());
    }
}
