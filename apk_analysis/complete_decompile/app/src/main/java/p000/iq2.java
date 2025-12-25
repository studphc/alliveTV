package p000;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.util.Assertions;

/* loaded from: classes.dex */
public final class iq2 {

    /* renamed from: A */
    public int f20190A;

    /* renamed from: B */
    public int f20191B;

    /* renamed from: C */
    public int f20192C;

    /* renamed from: D */
    public int f20193D;

    /* renamed from: E */
    public StaticLayout f20194E;

    /* renamed from: F */
    public StaticLayout f20195F;

    /* renamed from: G */
    public int f20196G;

    /* renamed from: H */
    public int f20197H;

    /* renamed from: I */
    public int f20198I;

    /* renamed from: J */
    public Rect f20199J;

    /* renamed from: a */
    public final float f20200a;

    /* renamed from: b */
    public final float f20201b;

    /* renamed from: c */
    public final float f20202c;

    /* renamed from: d */
    public final float f20203d;

    /* renamed from: e */
    public final float f20204e;

    /* renamed from: f */
    public final TextPaint f20205f;

    /* renamed from: g */
    public final Paint f20206g;

    /* renamed from: h */
    public final Paint f20207h;

    /* renamed from: i */
    public CharSequence f20208i;

    /* renamed from: j */
    public Layout.Alignment f20209j;

    /* renamed from: k */
    public Bitmap f20210k;

    /* renamed from: l */
    public float f20211l;

    /* renamed from: m */
    public int f20212m;

    /* renamed from: n */
    public int f20213n;

    /* renamed from: o */
    public float f20214o;

    /* renamed from: p */
    public int f20215p;

    /* renamed from: q */
    public float f20216q;

    /* renamed from: r */
    public float f20217r;

    /* renamed from: s */
    public int f20218s;

    /* renamed from: t */
    public int f20219t;

    /* renamed from: u */
    public int f20220u;

    /* renamed from: v */
    public int f20221v;

    /* renamed from: w */
    public int f20222w;

    /* renamed from: x */
    public float f20223x;

    /* renamed from: y */
    public float f20224y;

    /* renamed from: z */
    public float f20225z;

    public iq2(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{R.attr.lineSpacingExtra, R.attr.lineSpacingMultiplier}, 0, 0);
        this.f20204e = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f20203d = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        float round = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.f20200a = round;
        this.f20201b = round;
        this.f20202c = round;
        TextPaint textPaint = new TextPaint();
        this.f20205f = textPaint;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        Paint paint = new Paint();
        this.f20206g = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f20207h = paint2;
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
    }

    /* renamed from: a */
    public final void m5339a(Canvas canvas, boolean z) {
        int i;
        if (z) {
            StaticLayout staticLayout = this.f20194E;
            StaticLayout staticLayout2 = this.f20195F;
            if (staticLayout != null && staticLayout2 != null) {
                int save = canvas.save();
                canvas.translate(this.f20196G, this.f20197H);
                if (Color.alpha(this.f20220u) > 0) {
                    Paint paint = this.f20206g;
                    paint.setColor(this.f20220u);
                    canvas.drawRect(-this.f20198I, RecyclerView.f7068F0, staticLayout.getWidth() + this.f20198I, staticLayout.getHeight(), paint);
                }
                int i2 = this.f20222w;
                TextPaint textPaint = this.f20205f;
                boolean z2 = true;
                if (i2 == 1) {
                    textPaint.setStrokeJoin(Paint.Join.ROUND);
                    textPaint.setStrokeWidth(this.f20200a);
                    textPaint.setColor(this.f20221v);
                    textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
                    staticLayout2.draw(canvas);
                } else {
                    float f = this.f20201b;
                    if (i2 == 2) {
                        float f2 = this.f20202c;
                        textPaint.setShadowLayer(f, f2, f2, this.f20221v);
                    } else if (i2 == 3 || i2 == 4) {
                        if (i2 != 3) {
                            z2 = false;
                        }
                        int i3 = -1;
                        if (z2) {
                            i = -1;
                        } else {
                            i = this.f20221v;
                        }
                        if (z2) {
                            i3 = this.f20221v;
                        }
                        float f3 = f / 2.0f;
                        textPaint.setColor(this.f20218s);
                        textPaint.setStyle(Paint.Style.FILL);
                        float f4 = -f3;
                        textPaint.setShadowLayer(f, f4, f4, i);
                        staticLayout2.draw(canvas);
                        textPaint.setShadowLayer(f, f3, f3, i3);
                    }
                }
                textPaint.setColor(this.f20218s);
                textPaint.setStyle(Paint.Style.FILL);
                staticLayout.draw(canvas);
                textPaint.setShadowLayer(RecyclerView.f7068F0, RecyclerView.f7068F0, RecyclerView.f7068F0, 0);
                canvas.restoreToCount(save);
                return;
            }
            return;
        }
        Assertions.checkNotNull(this.f20199J);
        Assertions.checkNotNull(this.f20210k);
        canvas.drawBitmap(this.f20210k, (Rect) null, this.f20199J, this.f20207h);
    }
}
