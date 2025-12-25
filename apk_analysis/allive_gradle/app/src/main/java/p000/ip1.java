package p000;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionController;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class ip1 {

    /* renamed from: a */
    public float[] f20170a;

    /* renamed from: b */
    public final int[] f20171b;

    /* renamed from: c */
    public final float[] f20172c;

    /* renamed from: d */
    public Path f20173d;

    /* renamed from: e */
    public final Paint f20174e;

    /* renamed from: f */
    public final Paint f20175f;

    /* renamed from: g */
    public final Paint f20176g;

    /* renamed from: h */
    public final Paint f20177h;

    /* renamed from: i */
    public final Paint f20178i;

    /* renamed from: j */
    public final float[] f20179j;

    /* renamed from: k */
    public int f20180k;

    /* renamed from: l */
    public final Rect f20181l = new Rect();

    /* renamed from: m */
    public final int f20182m = 1;

    /* renamed from: n */
    public final /* synthetic */ MotionLayout f20183n;

    public ip1(MotionLayout motionLayout) {
        this.f20183n = motionLayout;
        Paint paint = new Paint();
        this.f20174e = paint;
        paint.setAntiAlias(true);
        paint.setColor(-21965);
        paint.setStrokeWidth(2.0f);
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        Paint paint2 = new Paint();
        this.f20175f = paint2;
        paint2.setAntiAlias(true);
        paint2.setColor(-2067046);
        paint2.setStrokeWidth(2.0f);
        paint2.setStyle(style);
        Paint paint3 = new Paint();
        this.f20176g = paint3;
        paint3.setAntiAlias(true);
        paint3.setColor(-13391360);
        paint3.setStrokeWidth(2.0f);
        paint3.setStyle(style);
        Paint paint4 = new Paint();
        this.f20177h = paint4;
        paint4.setAntiAlias(true);
        paint4.setColor(-13391360);
        paint4.setTextSize(motionLayout.getContext().getResources().getDisplayMetrics().density * 12.0f);
        this.f20179j = new float[8];
        Paint paint5 = new Paint();
        this.f20178i = paint5;
        paint5.setAntiAlias(true);
        paint3.setPathEffect(new DashPathEffect(new float[]{4.0f, 8.0f}, RecyclerView.f7068F0));
        this.f20172c = new float[100];
        this.f20171b = new int[50];
    }

    /* renamed from: a */
    public final void m5331a(Canvas canvas, int i, int i2, MotionController motionController) {
        int i3;
        int i4;
        Paint paint;
        float f;
        float f2;
        int i5;
        int[] iArr = this.f20171b;
        int i6 = 4;
        if (i == 4) {
            boolean z = false;
            boolean z2 = false;
            for (int i7 = 0; i7 < this.f20180k; i7++) {
                int i8 = iArr[i7];
                if (i8 == 1) {
                    z = true;
                }
                if (i8 == 0) {
                    z2 = true;
                }
            }
            if (z) {
                float[] fArr = this.f20170a;
                canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.f20176g);
            }
            if (z2) {
                m5332b(canvas);
            }
        }
        if (i == 2) {
            float[] fArr2 = this.f20170a;
            canvas.drawLine(fArr2[0], fArr2[1], fArr2[fArr2.length - 2], fArr2[fArr2.length - 1], this.f20176g);
        }
        if (i == 3) {
            m5332b(canvas);
        }
        canvas.drawLines(this.f20170a, this.f20174e);
        View view = motionController.f2797b;
        if (view != null) {
            i3 = view.getWidth();
            i4 = motionController.f2797b.getHeight();
        } else {
            i3 = 0;
            i4 = 0;
        }
        int i9 = 1;
        while (i9 < i2 - 1) {
            if (i == i6 && iArr[i9 - 1] == 0) {
                i5 = i9;
            } else {
                int i10 = i9 * 2;
                float[] fArr3 = this.f20172c;
                float f3 = fArr3[i10];
                float f4 = fArr3[i10 + 1];
                this.f20173d.reset();
                this.f20173d.moveTo(f3, f4 + 10.0f);
                this.f20173d.lineTo(f3 + 10.0f, f4);
                this.f20173d.lineTo(f3, f4 - 10.0f);
                this.f20173d.lineTo(f3 - 10.0f, f4);
                this.f20173d.close();
                int i11 = i9 - 1;
                Paint paint2 = this.f20178i;
                if (i == i6) {
                    int i12 = iArr[i11];
                    if (i12 == 1) {
                        m5334d(canvas, f3 - RecyclerView.f7068F0, f4 - RecyclerView.f7068F0);
                    } else if (i12 == 0) {
                        m5333c(canvas, f3 - RecyclerView.f7068F0, f4 - RecyclerView.f7068F0);
                    } else if (i12 == 2) {
                        paint = paint2;
                        f = f4;
                        f2 = f3;
                        i5 = i9;
                        m5335e(canvas, f3 - RecyclerView.f7068F0, f4 - RecyclerView.f7068F0, i3, i4);
                        canvas.drawPath(this.f20173d, paint);
                    }
                    paint = paint2;
                    f = f4;
                    f2 = f3;
                    i5 = i9;
                    canvas.drawPath(this.f20173d, paint);
                } else {
                    paint = paint2;
                    f = f4;
                    f2 = f3;
                    i5 = i9;
                }
                if (i == 2) {
                    m5334d(canvas, f2 - RecyclerView.f7068F0, f - RecyclerView.f7068F0);
                }
                if (i == 3) {
                    m5333c(canvas, f2 - RecyclerView.f7068F0, f - RecyclerView.f7068F0);
                }
                if (i == 6) {
                    m5335e(canvas, f2 - RecyclerView.f7068F0, f - RecyclerView.f7068F0, i3, i4);
                }
                canvas.drawPath(this.f20173d, paint);
            }
            i9 = i5 + 1;
            i6 = 4;
        }
        float[] fArr4 = this.f20170a;
        if (fArr4.length > 1) {
            float f5 = fArr4[0];
            float f6 = fArr4[1];
            Paint paint3 = this.f20175f;
            canvas.drawCircle(f5, f6, 8.0f, paint3);
            float[] fArr5 = this.f20170a;
            canvas.drawCircle(fArr5[fArr5.length - 2], fArr5[fArr5.length - 1], 8.0f, paint3);
        }
    }

    /* renamed from: b */
    public final void m5332b(Canvas canvas) {
        float[] fArr = this.f20170a;
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[fArr.length - 2];
        float f4 = fArr[fArr.length - 1];
        float min = Math.min(f, f3);
        float max = Math.max(f2, f4);
        float max2 = Math.max(f, f3);
        float max3 = Math.max(f2, f4);
        Paint paint = this.f20176g;
        canvas.drawLine(min, max, max2, max3, paint);
        canvas.drawLine(Math.min(f, f3), Math.min(f2, f4), Math.min(f, f3), Math.max(f2, f4), paint);
    }

    /* renamed from: c */
    public final void m5333c(Canvas canvas, float f, float f2) {
        float[] fArr = this.f20170a;
        float f3 = fArr[0];
        float f4 = fArr[1];
        float f5 = fArr[fArr.length - 2];
        float f6 = fArr[fArr.length - 1];
        float min = Math.min(f3, f5);
        float max = Math.max(f4, f6);
        float min2 = f - Math.min(f3, f5);
        float max2 = Math.max(f4, f6) - f2;
        String str = "" + (((int) (((min2 * 100.0f) / Math.abs(f5 - f3)) + 0.5d)) / 100.0f);
        Paint paint = this.f20177h;
        paint.getTextBounds(str, 0, str.length(), this.f20181l);
        Rect rect = this.f20181l;
        canvas.drawText(str, ((min2 / 2.0f) - (rect.width() / 2)) + min, f2 - 20.0f, paint);
        float min3 = Math.min(f3, f5);
        Paint paint2 = this.f20176g;
        canvas.drawLine(f, f2, min3, f2, paint2);
        String str2 = "" + (((int) (((max2 * 100.0f) / Math.abs(f6 - f4)) + 0.5d)) / 100.0f);
        paint.getTextBounds(str2, 0, str2.length(), this.f20181l);
        canvas.drawText(str2, f + 5.0f, max - ((max2 / 2.0f) - (rect.height() / 2)), paint);
        canvas.drawLine(f, f2, f, Math.max(f4, f6), paint2);
    }

    /* renamed from: d */
    public final void m5334d(Canvas canvas, float f, float f2) {
        float[] fArr = this.f20170a;
        float f3 = fArr[0];
        float f4 = fArr[1];
        float f5 = fArr[fArr.length - 2];
        float f6 = fArr[fArr.length - 1];
        float hypot = (float) Math.hypot(f3 - f5, f4 - f6);
        float f7 = f5 - f3;
        float f8 = f6 - f4;
        float f9 = (((f2 - f4) * f8) + ((f - f3) * f7)) / (hypot * hypot);
        float f10 = f3 + (f7 * f9);
        float f11 = f4 + (f9 * f8);
        Path path = new Path();
        path.moveTo(f, f2);
        path.lineTo(f10, f11);
        float hypot2 = (float) Math.hypot(f10 - f, f11 - f2);
        String str = "" + (((int) ((hypot2 * 100.0f) / hypot)) / 100.0f);
        Paint paint = this.f20177h;
        paint.getTextBounds(str, 0, str.length(), this.f20181l);
        canvas.drawTextOnPath(str, path, (hypot2 / 2.0f) - (this.f20181l.width() / 2), -20.0f, paint);
        canvas.drawLine(f, f2, f10, f11, this.f20176g);
    }

    /* renamed from: e */
    public final void m5335e(Canvas canvas, float f, float f2, int i, int i2) {
        StringBuilder sb = new StringBuilder("");
        MotionLayout motionLayout = this.f20183n;
        sb.append(((int) ((((f - (i / 2)) * 100.0f) / (motionLayout.getWidth() - i)) + 0.5d)) / 100.0f);
        String sb2 = sb.toString();
        Paint paint = this.f20177h;
        paint.getTextBounds(sb2, 0, sb2.length(), this.f20181l);
        Rect rect = this.f20181l;
        canvas.drawText(sb2, ((f / 2.0f) - (rect.width() / 2)) + RecyclerView.f7068F0, f2 - 20.0f, paint);
        float min = Math.min(RecyclerView.f7068F0, 1.0f);
        Paint paint2 = this.f20176g;
        canvas.drawLine(f, f2, min, f2, paint2);
        String str = "" + (((int) ((((f2 - (i2 / 2)) * 100.0f) / (motionLayout.getHeight() - i2)) + 0.5d)) / 100.0f);
        paint.getTextBounds(str, 0, str.length(), this.f20181l);
        canvas.drawText(str, f + 5.0f, RecyclerView.f7068F0 - ((f2 / 2.0f) - (rect.height() / 2)), paint);
        canvas.drawLine(f, f2, f, Math.max(RecyclerView.f7068F0, 1.0f), paint2);
    }
}
