package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R;

/* loaded from: classes.dex */
public class MotionTelltales extends MockView {

    /* renamed from: k */
    public final Paint f3118k;

    /* renamed from: l */
    public MotionLayout f3119l;

    /* renamed from: m */
    public final float[] f3120m;

    /* renamed from: n */
    public final Matrix f3121n;

    /* renamed from: o */
    public int f3122o;

    /* renamed from: p */
    public int f3123p;

    /* renamed from: q */
    public float f3124q;

    public MotionTelltales(Context context) {
        super(context);
        this.f3118k = new Paint();
        this.f3120m = new float[2];
        this.f3121n = new Matrix();
        this.f3122o = 0;
        this.f3123p = -65281;
        this.f3124q = 0.25f;
        m624b(context, null);
    }

    /* renamed from: b */
    public final void m624b(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MotionTelltales);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.MotionTelltales_telltales_tailColor) {
                    this.f3123p = obtainStyledAttributes.getColor(index, this.f3123p);
                } else if (index == R.styleable.MotionTelltales_telltales_velocityMode) {
                    this.f3122o = obtainStyledAttributes.getInt(index, this.f3122o);
                } else if (index == R.styleable.MotionTelltales_telltales_tailScale) {
                    this.f3124q = obtainStyledAttributes.getFloat(index, this.f3124q);
                }
            }
            obtainStyledAttributes.recycle();
        }
        int i2 = this.f3123p;
        Paint paint = this.f3118k;
        paint.setColor(i2);
        paint.setStrokeWidth(5.0f);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // androidx.constraintlayout.utils.widget.MockView, android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        Matrix matrix = getMatrix();
        Matrix matrix2 = this.f3121n;
        matrix.invert(matrix2);
        if (this.f3119l == null) {
            ViewParent parent = getParent();
            if (parent instanceof MotionLayout) {
                this.f3119l = (MotionLayout) parent;
                return;
            }
            return;
        }
        int width = getWidth();
        int height = getHeight();
        float[] fArr = {0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
        for (int i = 0; i < 5; i++) {
            float f = fArr[i];
            for (int i2 = 0; i2 < 5; i2++) {
                float f2 = fArr[i2];
                this.f3119l.getViewVelocity(this, f2, f, this.f3120m, this.f3122o);
                float[] fArr2 = this.f3120m;
                matrix2.mapVectors(fArr2);
                float f3 = width * f2;
                float f4 = height * f;
                float f5 = fArr2[0];
                float f6 = this.f3124q;
                float f7 = f4 - (fArr2[1] * f6);
                matrix2.mapVectors(fArr2);
                canvas.drawLine(f3, f4, f3 - (f5 * f6), f7, this.f3118k);
            }
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        postInvalidate();
    }

    public void setText(CharSequence charSequence) {
        this.mText = charSequence.toString();
        requestLayout();
    }

    public MotionTelltales(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3118k = new Paint();
        this.f3120m = new float[2];
        this.f3121n = new Matrix();
        this.f3122o = 0;
        this.f3123p = -65281;
        this.f3124q = 0.25f;
        m624b(context, attributeSet);
    }

    public MotionTelltales(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3118k = new Paint();
        this.f3120m = new float[2];
        this.f3121n = new Matrix();
        this.f3122o = 0;
        this.f3123p = -65281;
        this.f3124q = 0.25f;
        m624b(context, attributeSet);
    }
}
