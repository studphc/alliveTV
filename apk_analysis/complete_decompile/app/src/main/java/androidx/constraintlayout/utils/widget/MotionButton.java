package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.R;
import androidx.recyclerview.widget.RecyclerView;
import p000.bp1;

/* loaded from: classes.dex */
public class MotionButton extends AppCompatButton {

    /* renamed from: d */
    public float f3067d;

    /* renamed from: e */
    public float f3068e;

    /* renamed from: f */
    public Path f3069f;

    /* renamed from: g */
    public ViewOutlineProvider f3070g;

    /* renamed from: h */
    public RectF f3071h;

    public MotionButton(Context context) {
        super(context);
        this.f3067d = RecyclerView.f7068F0;
        this.f3068e = Float.NaN;
        setPadding(0, 0, 0, 0);
    }

    /* renamed from: a */
    public final void m620a(Context context, AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ImageFilterView_round) {
                    setRound(obtainStyledAttributes.getDimension(index, RecyclerView.f7068F0));
                } else if (index == R.styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, RecyclerView.f7068F0));
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
    }

    public float getRound() {
        return this.f3068e;
    }

    public float getRoundPercent() {
        return this.f3067d;
    }

    @RequiresApi(21)
    public void setRound(float f) {
        boolean z;
        if (Float.isNaN(f)) {
            this.f3068e = f;
            float f2 = this.f3067d;
            this.f3067d = -1.0f;
            setRoundPercent(f2);
            return;
        }
        if (this.f3068e != f) {
            z = true;
        } else {
            z = false;
        }
        this.f3068e = f;
        if (f != RecyclerView.f7068F0) {
            if (this.f3069f == null) {
                this.f3069f = new Path();
            }
            if (this.f3071h == null) {
                this.f3071h = new RectF();
            }
            if (this.f3070g == null) {
                bp1 bp1Var = new bp1(this, 1);
                this.f3070g = bp1Var;
                setOutlineProvider(bp1Var);
            }
            setClipToOutline(true);
            this.f3071h.set(RecyclerView.f7068F0, RecyclerView.f7068F0, getWidth(), getHeight());
            this.f3069f.reset();
            Path path = this.f3069f;
            RectF rectF = this.f3071h;
            float f3 = this.f3068e;
            path.addRoundRect(rectF, f3, f3, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    @RequiresApi(21)
    public void setRoundPercent(float f) {
        boolean z;
        if (this.f3067d != f) {
            z = true;
        } else {
            z = false;
        }
        this.f3067d = f;
        if (f != RecyclerView.f7068F0) {
            if (this.f3069f == null) {
                this.f3069f = new Path();
            }
            if (this.f3071h == null) {
                this.f3071h = new RectF();
            }
            if (this.f3070g == null) {
                bp1 bp1Var = new bp1(this, 0);
                this.f3070g = bp1Var;
                setOutlineProvider(bp1Var);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.f3067d) / 2.0f;
            this.f3071h.set(RecyclerView.f7068F0, RecyclerView.f7068F0, width, height);
            this.f3069f.reset();
            this.f3069f.addRoundRect(this.f3071h, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public MotionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3067d = RecyclerView.f7068F0;
        this.f3068e = Float.NaN;
        m620a(context, attributeSet);
    }

    public MotionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3067d = RecyclerView.f7068F0;
        this.f3068e = Float.NaN;
        m620a(context, attributeSet);
    }
}
