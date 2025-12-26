package androidx.leanback.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import java.util.Random;

/* renamed from: androidx.leanback.widget.v2 */
/* loaded from: classes.dex */
public final class C0398v2 extends ReplacementSpan {

    /* renamed from: a */
    public final int f6427a;

    /* renamed from: b */
    public final int f6428b;

    /* renamed from: c */
    public final /* synthetic */ SearchEditText f6429c;

    public C0398v2(SearchEditText searchEditText, int i, int i2) {
        this.f6429c = searchEditText;
        this.f6427a = i;
        this.f6428b = i2;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        float f2;
        int measureText = (int) paint.measureText(charSequence, i, i2);
        SearchEditText searchEditText = this.f6429c;
        int width = searchEditText.f6224b.getWidth();
        int i6 = width * 2;
        int i7 = measureText / i6;
        int i8 = (measureText % i6) / 2;
        boolean isLayoutRtl = StreamingTextView.isLayoutRtl(searchEditText);
        Random random = searchEditText.f6223a;
        random.setSeed(this.f6427a);
        int alpha = paint.getAlpha();
        for (int i9 = 0; i9 < i7 && this.f6428b + i9 < searchEditText.f6226d; i9++) {
            float f3 = (width / 2) + (i9 * i6) + i8;
            if (isLayoutRtl) {
                f2 = ((f + measureText) - f3) - width;
            } else {
                f2 = f + f3;
            }
            paint.setAlpha((random.nextInt(4) + 1) * 63);
            if (random.nextBoolean()) {
                canvas.drawBitmap(searchEditText.f6225c, f2, i4 - r13.getHeight(), paint);
            } else {
                canvas.drawBitmap(searchEditText.f6224b, f2, i4 - r13.getHeight(), paint);
            }
        }
        paint.setAlpha(alpha);
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return (int) paint.measureText(charSequence, i, i2);
    }
}
