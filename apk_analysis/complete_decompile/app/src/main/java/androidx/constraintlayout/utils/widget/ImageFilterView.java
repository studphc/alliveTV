package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.R;
import androidx.recyclerview.widget.RecyclerView;
import p000.a21;
import p000.b21;

/* loaded from: classes.dex */
public class ImageFilterView extends AppCompatImageView {

    /* renamed from: d */
    public final b21 f3041d;

    /* renamed from: e */
    public boolean f3042e;

    /* renamed from: f */
    public Drawable f3043f;

    /* renamed from: g */
    public Drawable f3044g;

    /* renamed from: h */
    public float f3045h;

    /* renamed from: i */
    public float f3046i;

    /* renamed from: j */
    public float f3047j;

    /* renamed from: k */
    public Path f3048k;

    /* renamed from: l */
    public ViewOutlineProvider f3049l;

    /* renamed from: m */
    public RectF f3050m;

    /* renamed from: n */
    public final Drawable[] f3051n;

    /* renamed from: o */
    public LayerDrawable f3052o;

    /* renamed from: p */
    public float f3053p;

    /* renamed from: q */
    public float f3054q;

    /* renamed from: r */
    public float f3055r;

    /* renamed from: s */
    public float f3056s;

    public ImageFilterView(Context context) {
        super(context);
        this.f3041d = new b21();
        this.f3042e = true;
        this.f3043f = null;
        this.f3044g = null;
        this.f3045h = RecyclerView.f7068F0;
        this.f3046i = RecyclerView.f7068F0;
        this.f3047j = Float.NaN;
        this.f3051n = new Drawable[2];
        this.f3053p = Float.NaN;
        this.f3054q = Float.NaN;
        this.f3055r = Float.NaN;
        this.f3056s = Float.NaN;
    }

    private void setOverlay(boolean z) {
        this.f3042e = z;
    }

    /* renamed from: a */
    public final void m616a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            this.f3043f = obtainStyledAttributes.getDrawable(R.styleable.ImageFilterView_altSrc);
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ImageFilterView_crossfade) {
                    this.f3045h = obtainStyledAttributes.getFloat(index, RecyclerView.f7068F0);
                } else if (index == R.styleable.ImageFilterView_warmth) {
                    setWarmth(obtainStyledAttributes.getFloat(index, RecyclerView.f7068F0));
                } else if (index == R.styleable.ImageFilterView_saturation) {
                    setSaturation(obtainStyledAttributes.getFloat(index, RecyclerView.f7068F0));
                } else if (index == R.styleable.ImageFilterView_contrast) {
                    setContrast(obtainStyledAttributes.getFloat(index, RecyclerView.f7068F0));
                } else if (index == R.styleable.ImageFilterView_brightness) {
                    setBrightness(obtainStyledAttributes.getFloat(index, RecyclerView.f7068F0));
                } else if (index == R.styleable.ImageFilterView_round) {
                    setRound(obtainStyledAttributes.getDimension(index, RecyclerView.f7068F0));
                } else if (index == R.styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, RecyclerView.f7068F0));
                } else if (index == R.styleable.ImageFilterView_overlay) {
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.f3042e));
                } else if (index == R.styleable.ImageFilterView_imagePanX) {
                    setImagePanX(obtainStyledAttributes.getFloat(index, this.f3053p));
                } else if (index == R.styleable.ImageFilterView_imagePanY) {
                    setImagePanY(obtainStyledAttributes.getFloat(index, this.f3054q));
                } else if (index == R.styleable.ImageFilterView_imageRotate) {
                    setImageRotate(obtainStyledAttributes.getFloat(index, this.f3056s));
                } else if (index == R.styleable.ImageFilterView_imageZoom) {
                    setImageZoom(obtainStyledAttributes.getFloat(index, this.f3055r));
                }
            }
            obtainStyledAttributes.recycle();
            Drawable drawable = getDrawable();
            this.f3044g = drawable;
            Drawable drawable2 = this.f3043f;
            Drawable[] drawableArr = this.f3051n;
            if (drawable2 != null && drawable != null) {
                Drawable mutate = getDrawable().mutate();
                this.f3044g = mutate;
                drawableArr[0] = mutate;
                drawableArr[1] = this.f3043f.mutate();
                LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
                this.f3052o = layerDrawable;
                layerDrawable.getDrawable(1).setAlpha((int) (this.f3045h * 255.0f));
                if (!this.f3042e) {
                    this.f3052o.getDrawable(0).setAlpha((int) ((1.0f - this.f3045h) * 255.0f));
                }
                super.setImageDrawable(this.f3052o);
                return;
            }
            Drawable drawable3 = getDrawable();
            this.f3044g = drawable3;
            if (drawable3 != null) {
                Drawable mutate2 = drawable3.mutate();
                this.f3044g = mutate2;
                drawableArr[0] = mutate2;
            }
        }
    }

    /* renamed from: b */
    public final void m617b() {
        float f;
        float f2;
        float f3;
        float f4;
        if (Float.isNaN(this.f3053p) && Float.isNaN(this.f3054q) && Float.isNaN(this.f3055r) && Float.isNaN(this.f3056s)) {
            return;
        }
        boolean isNaN = Float.isNaN(this.f3053p);
        float f5 = RecyclerView.f7068F0;
        if (isNaN) {
            f = 0.0f;
        } else {
            f = this.f3053p;
        }
        if (Float.isNaN(this.f3054q)) {
            f2 = 0.0f;
        } else {
            f2 = this.f3054q;
        }
        if (Float.isNaN(this.f3055r)) {
            f3 = 1.0f;
        } else {
            f3 = this.f3055r;
        }
        if (!Float.isNaN(this.f3056s)) {
            f5 = this.f3056s;
        }
        Matrix matrix = new Matrix();
        matrix.reset();
        float intrinsicWidth = getDrawable().getIntrinsicWidth();
        float intrinsicHeight = getDrawable().getIntrinsicHeight();
        float width = getWidth();
        float height = getHeight();
        if (intrinsicWidth * height < intrinsicHeight * width) {
            f4 = width / intrinsicWidth;
        } else {
            f4 = height / intrinsicHeight;
        }
        float f6 = f3 * f4;
        matrix.postScale(f6, f6);
        float f7 = intrinsicWidth * f6;
        float f8 = f6 * intrinsicHeight;
        matrix.postTranslate(((((width - f7) * f) + width) - f7) * 0.5f, ((((height - f8) * f2) + height) - f8) * 0.5f);
        matrix.postRotate(f5, width / 2.0f, height / 2.0f);
        setImageMatrix(matrix);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    /* renamed from: c */
    public final void m618c() {
        if (Float.isNaN(this.f3053p) && Float.isNaN(this.f3054q) && Float.isNaN(this.f3055r) && Float.isNaN(this.f3056s)) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            m617b();
        }
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
    }

    public float getBrightness() {
        return this.f3041d.f7866d;
    }

    public float getContrast() {
        return this.f3041d.f7868f;
    }

    public float getCrossfade() {
        return this.f3045h;
    }

    public float getImagePanX() {
        return this.f3053p;
    }

    public float getImagePanY() {
        return this.f3054q;
    }

    public float getImageRotate() {
        return this.f3056s;
    }

    public float getImageZoom() {
        return this.f3055r;
    }

    public float getRound() {
        return this.f3047j;
    }

    public float getRoundPercent() {
        return this.f3046i;
    }

    public float getSaturation() {
        return this.f3041d.f7867e;
    }

    public float getWarmth() {
        return this.f3041d.f7869g;
    }

    @Override // android.view.View
    public void layout(int i, int i2, int i3, int i4) {
        super.layout(i, i2, i3, i4);
        m617b();
    }

    public void setAltImageDrawable(Drawable drawable) {
        Drawable mutate = drawable.mutate();
        this.f3043f = mutate;
        Drawable drawable2 = this.f3044g;
        Drawable[] drawableArr = this.f3051n;
        drawableArr[0] = drawable2;
        drawableArr[1] = mutate;
        LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
        this.f3052o = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f3045h);
    }

    public void setAltImageResource(int i) {
        Drawable drawable = AppCompatResources.getDrawable(getContext(), i);
        this.f3043f = drawable;
        setAltImageDrawable(drawable);
    }

    public void setBrightness(float f) {
        b21 b21Var = this.f3041d;
        b21Var.f7866d = f;
        b21Var.m2005a(this);
    }

    public void setContrast(float f) {
        b21 b21Var = this.f3041d;
        b21Var.f7868f = f;
        b21Var.m2005a(this);
    }

    public void setCrossfade(float f) {
        this.f3045h = f;
        if (this.f3051n != null) {
            if (!this.f3042e) {
                this.f3052o.getDrawable(0).setAlpha((int) ((1.0f - this.f3045h) * 255.0f));
            }
            this.f3052o.getDrawable(1).setAlpha((int) (this.f3045h * 255.0f));
            super.setImageDrawable(this.f3052o);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.f3043f != null && drawable != null) {
            Drawable mutate = drawable.mutate();
            this.f3044g = mutate;
            Drawable[] drawableArr = this.f3051n;
            drawableArr[0] = mutate;
            drawableArr[1] = this.f3043f;
            LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
            this.f3052o = layerDrawable;
            super.setImageDrawable(layerDrawable);
            setCrossfade(this.f3045h);
            return;
        }
        super.setImageDrawable(drawable);
    }

    public void setImagePanX(float f) {
        this.f3053p = f;
        m618c();
    }

    public void setImagePanY(float f) {
        this.f3054q = f;
        m618c();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        if (this.f3043f != null) {
            Drawable mutate = AppCompatResources.getDrawable(getContext(), i).mutate();
            this.f3044g = mutate;
            Drawable[] drawableArr = this.f3051n;
            drawableArr[0] = mutate;
            drawableArr[1] = this.f3043f;
            LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
            this.f3052o = layerDrawable;
            super.setImageDrawable(layerDrawable);
            setCrossfade(this.f3045h);
            return;
        }
        super.setImageResource(i);
    }

    public void setImageRotate(float f) {
        this.f3056s = f;
        m618c();
    }

    public void setImageZoom(float f) {
        this.f3055r = f;
        m618c();
    }

    @RequiresApi(21)
    public void setRound(float f) {
        boolean z;
        if (Float.isNaN(f)) {
            this.f3047j = f;
            float f2 = this.f3046i;
            this.f3046i = -1.0f;
            setRoundPercent(f2);
            return;
        }
        if (this.f3047j != f) {
            z = true;
        } else {
            z = false;
        }
        this.f3047j = f;
        if (f != RecyclerView.f7068F0) {
            if (this.f3048k == null) {
                this.f3048k = new Path();
            }
            if (this.f3050m == null) {
                this.f3050m = new RectF();
            }
            if (this.f3049l == null) {
                a21 a21Var = new a21(this, 1);
                this.f3049l = a21Var;
                setOutlineProvider(a21Var);
            }
            setClipToOutline(true);
            this.f3050m.set(RecyclerView.f7068F0, RecyclerView.f7068F0, getWidth(), getHeight());
            this.f3048k.reset();
            Path path = this.f3048k;
            RectF rectF = this.f3050m;
            float f3 = this.f3047j;
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
        if (this.f3046i != f) {
            z = true;
        } else {
            z = false;
        }
        this.f3046i = f;
        if (f != RecyclerView.f7068F0) {
            if (this.f3048k == null) {
                this.f3048k = new Path();
            }
            if (this.f3050m == null) {
                this.f3050m = new RectF();
            }
            if (this.f3049l == null) {
                a21 a21Var = new a21(this, 0);
                this.f3049l = a21Var;
                setOutlineProvider(a21Var);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.f3046i) / 2.0f;
            this.f3050m.set(RecyclerView.f7068F0, RecyclerView.f7068F0, width, height);
            this.f3048k.reset();
            this.f3048k.addRoundRect(this.f3050m, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f) {
        b21 b21Var = this.f3041d;
        b21Var.f7867e = f;
        b21Var.m2005a(this);
    }

    public void setWarmth(float f) {
        b21 b21Var = this.f3041d;
        b21Var.f7869g = f;
        b21Var.m2005a(this);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3041d = new b21();
        this.f3042e = true;
        this.f3043f = null;
        this.f3044g = null;
        this.f3045h = RecyclerView.f7068F0;
        this.f3046i = RecyclerView.f7068F0;
        this.f3047j = Float.NaN;
        this.f3051n = new Drawable[2];
        this.f3053p = Float.NaN;
        this.f3054q = Float.NaN;
        this.f3055r = Float.NaN;
        this.f3056s = Float.NaN;
        m616a(context, attributeSet);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3041d = new b21();
        this.f3042e = true;
        this.f3043f = null;
        this.f3044g = null;
        this.f3045h = RecyclerView.f7068F0;
        this.f3046i = RecyclerView.f7068F0;
        this.f3047j = Float.NaN;
        this.f3051n = new Drawable[2];
        this.f3053p = Float.NaN;
        this.f3054q = Float.NaN;
        this.f3055r = Float.NaN;
        this.f3056s = Float.NaN;
        m616a(context, attributeSet);
    }
}
