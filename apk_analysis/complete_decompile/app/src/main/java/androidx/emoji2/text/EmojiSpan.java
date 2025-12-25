package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;

@RequiresApi(19)
/* loaded from: classes.dex */
public abstract class EmojiSpan extends ReplacementSpan {

    /* renamed from: b */
    public final TypefaceEmojiRasterizer f4211b;

    /* renamed from: a */
    public final Paint.FontMetricsInt f4210a = new Paint.FontMetricsInt();

    /* renamed from: c */
    public short f4212c = -1;

    /* renamed from: d */
    public short f4213d = -1;

    /* renamed from: e */
    public float f4214e = 1.0f;

    public EmojiSpan(TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        Preconditions.checkNotNull(typefaceEmojiRasterizer, "rasterizer cannot be null");
        this.f4211b = typefaceEmojiRasterizer;
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public final int getHeight() {
        return this.f4213d;
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public final int getId() {
        return getTypefaceRasterizer().getId();
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        Paint.FontMetricsInt fontMetricsInt2 = this.f4210a;
        paint.getFontMetricsInt(fontMetricsInt2);
        TypefaceEmojiRasterizer typefaceEmojiRasterizer = this.f4211b;
        this.f4214e = (Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f) / typefaceEmojiRasterizer.getHeight();
        this.f4213d = (short) (typefaceEmojiRasterizer.getHeight() * this.f4214e);
        short width = (short) (typefaceEmojiRasterizer.getWidth() * this.f4214e);
        this.f4212c = width;
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return width;
    }

    @NonNull
    public final TypefaceEmojiRasterizer getTypefaceRasterizer() {
        return this.f4211b;
    }
}
