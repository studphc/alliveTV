package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class TypefaceEmojiSpan extends EmojiSpan {

    /* renamed from: g */
    public static TextPaint f4228g;

    /* renamed from: f */
    public TextPaint f4229f;

    public TypefaceEmojiSpan(@NonNull TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        super(typefaceEmojiRasterizer);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, @IntRange(from = 0) int i, @IntRange(from = 0) int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        Paint paint2 = paint;
        TextPaint textPaint = null;
        if (charSequence instanceof Spanned) {
            CharacterStyle[] characterStyleArr = (CharacterStyle[]) ((Spanned) charSequence).getSpans(i, i2, CharacterStyle.class);
            if (characterStyleArr.length != 0) {
                if (characterStyleArr.length != 1 || characterStyleArr[0] != this) {
                    TextPaint textPaint2 = this.f4229f;
                    if (textPaint2 == null) {
                        textPaint2 = new TextPaint();
                        this.f4229f = textPaint2;
                    }
                    textPaint = textPaint2;
                    textPaint.set(paint2);
                    for (CharacterStyle characterStyle : characterStyleArr) {
                        characterStyle.updateDrawState(textPaint);
                    }
                }
            }
            if (paint2 instanceof TextPaint) {
                textPaint = (TextPaint) paint2;
            }
        } else if (paint2 instanceof TextPaint) {
            textPaint = (TextPaint) paint2;
        }
        TextPaint textPaint3 = textPaint;
        if (textPaint3 != null && textPaint3.bgColor != 0) {
            int color = textPaint3.getColor();
            Paint.Style style = textPaint3.getStyle();
            textPaint3.setColor(textPaint3.bgColor);
            textPaint3.setStyle(Paint.Style.FILL);
            canvas.drawRect(f, i3, f + this.f4212c, i5, textPaint3);
            textPaint3.setStyle(style);
            textPaint3.setColor(color);
        }
        if (EmojiCompat.get().isEmojiSpanIndicatorEnabled()) {
            float f2 = i3;
            float f3 = f + this.f4212c;
            float f4 = i5;
            if (f4228g == null) {
                TextPaint textPaint4 = new TextPaint();
                f4228g = textPaint4;
                textPaint4.setColor(EmojiCompat.get().getEmojiSpanIndicatorColor());
                f4228g.setStyle(Paint.Style.FILL);
            }
            canvas.drawRect(f, f2, f3, f4, f4228g);
        }
        TypefaceEmojiRasterizer typefaceRasterizer = getTypefaceRasterizer();
        float f5 = i4;
        if (textPaint3 != null) {
            paint2 = textPaint3;
        }
        typefaceRasterizer.draw(canvas, f, f5, paint2);
    }
}
