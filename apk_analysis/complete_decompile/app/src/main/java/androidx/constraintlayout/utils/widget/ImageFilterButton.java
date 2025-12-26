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
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.R;
import androidx.recyclerview.widget.RecyclerView;
import p000.b21;
import p000.z11;

/* loaded from: classes.dex */
public class ImageFilterButton extends AppCompatImageButton {

    /* renamed from: d */
    public final b21 f3025d;

    /* renamed from: e */
    public float f3026e;

    /* renamed from: f */
    public float f3027f;

    /* renamed from: g */
    public float f3028g;

    /* renamed from: h */
    public Path f3029h;

    /* renamed from: i */
    public ViewOutlineProvider f3030i;

    /* renamed from: j */
    public RectF f3031j;

    /* renamed from: k */
    public final Drawable[] f3032k;

    /* renamed from: l */
    public LayerDrawable f3033l;

    /* renamed from: m */
    public boolean f3034m;

    /* renamed from: n */
    public Drawable f3035n;

    /* renamed from: o */
    public Drawable f3036o;

    /* renamed from: p */
    public float f3037p;

    /* renamed from: q */
    public float f3038q;

    /* renamed from: r */
    public float f3039r;

    /* renamed from: s */
    public float f3040s;

    public ImageFilterButton(Context context) {
        super(context);
        this.f3025d = new b21();
        this.f3026e = RecyclerView.f7068F0;
        this.f3027f = RecyclerView.f7068F0;
        this.f3028g = Float.NaN;
        this.f3032k = new Drawable[2];
        this.f3034m = true;
        this.f3035n = null;
        this.f3036o = null;
        this.f3037p = Float.NaN;
        this.f3038q = Float.NaN;
        this.f3039r = Float.NaN;
        this.f3040s = Float.NaN;
        setPadding(0, 0, 0, 0);
    }

    private void setOverlay(boolean z) {
        this.f3034m = z;
    }

    /* renamed from: a */
    public final void m613a(Context context, AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            this.f3035n = obtainStyledAttributes.getDrawable(R.styleable.ImageFilterView_altSrc);
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ImageFilterView_crossfade) {
                    this.f3026e = obtainStyledAttributes.getFloat(index, RecyclerView.f7068F0);
                } else if (index == R.styleable.ImageFilterView_warmth) {
                    setWarmth(obtainStyledAttributes.getFloat(index, RecyclerView.f7068F0));
                } else if (index == R.styleable.ImageFilterView_saturation) {
                    setSaturation(obtainStyledAttributes.getFloat(index, RecyclerView.f7068F0));
                } else if (index == R.styleable.ImageFilterView_contrast) {
                    setContrast(obtainStyledAttributes.getFloat(index, RecyclerView.f7068F0));
                } else if (index == R.styleable.ImageFilterView_round) {
                    setRound(obtainStyledAttributes.getDimension(index, RecyclerView.f7068F0));
                } else if (index == R.styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, RecyclerView.f7068F0));
                } else if (index == R.styleable.ImageFilterView_overlay) {
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.f3034m));
                } else if (index == R.styleable.ImageFilterView_imagePanX) {
                    setImagePanX(obtainStyledAttributes.getFloat(index, this.f3037p));
                } else if (index == R.styleable.ImageFilterView_imagePanY) {
                    setImagePanY(obtainStyledAttributes.getFloat(index, this.f3038q));
                } else if (index == R.styleable.ImageFilterView_imageRotate) {
                    setImageRotate(obtainStyledAttributes.getFloat(index, this.f3040s));
                } else if (index == R.styleable.ImageFilterView_imageZoom) {
                    setImageZoom(obtainStyledAttributes.getFloat(index, this.f3039r));
                }
            }
            obtainStyledAttributes.recycle();
            Drawable drawable = getDrawable();
            this.f3036o = drawable;
            Drawable drawable2 = this.f3035n;
            Drawable[] drawableArr = this.f3032k;
            if (drawable2 != null && drawable != null) {
                Drawable mutate = getDrawable().mutate();
                this.f3036o = mutate;
                drawableArr[0] = mutate;
                drawableArr[1] = this.f3035n.mutate();
                LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
                this.f3033l = layerDrawable;
                layerDrawable.getDrawable(1).setAlpha((int) (this.f3026e * 255.0f));
                if (!this.f3034m) {
                    this.f3033l.getDrawable(0).setAlpha((int) ((1.0f - this.f3026e) * 255.0f));
                }
                super.setImageDrawable(this.f3033l);
                return;
            }
            Drawable drawable3 = getDrawable();
            this.f3036o = drawable3;
            if (drawable3 != null) {
                Drawable mutate2 = drawable3.mutate();
                this.f3036o = mutate2;
                drawableArr[0] = mutate2;
            }
        }
    }

    /* renamed from: b */
    public final void m614b() {
        float f;
        float f2;
        float f3;
        float f4;
        if (Float.isNaN(this.f3037p) && Float.isNaN(this.f3038q) && Float.isNaN(this.f3039r) && Float.isNaN(this.f3040s)) {
            return;
        }
        boolean isNaN = Float.isNaN(this.f3037p);
        float f5 = RecyclerView.f7068F0;
        if (isNaN) {
            f = 0.0f;
        } else {
            f = this.f3037p;
        }
        if (Float.isNaN(this.f3038q)) {
            f2 = 0.0f;
        } else {
            f2 = this.f3038q;
        }
        if (Float.isNaN(this.f3039r)) {
            f3 = 1.0f;
        } else {
            f3 = this.f3039r;
        }
        if (!Float.isNaN(this.f3040s)) {
            f5 = this.f3040s;
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
    public final void m615c() {
        if (Float.isNaN(this.f3037p) && Float.isNaN(this.f3038q) && Float.isNaN(this.f3039r) && Float.isNaN(this.f3040s)) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            m614b();
        }
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
    }

    public float getContrast() {
        return this.f3025d.f7868f;
    }

    public float getCrossfade() {
        return this.f3026e;
    }

    public float getImagePanX() {
        return this.f3037p;
    }

    public float getImagePanY() {
        return this.f3038q;
    }

    public float getImageRotate() {
        return this.f3040s;
    }

    public float getImageZoom() {
        return this.f3039r;
    }

    public float getRound() {
        return this.f3028g;
    }

    public float getRoundPercent() {
        return this.f3027f;
    }

    public float getSaturation() {
        return this.f3025d.f7867e;
    }

    public float getWarmth() {
        return this.f3025d.f7869g;
    }

    @Override // android.view.View
    public void layout(int i, int i2, int i3, int i4) {
        super.layout(i, i2, i3, i4);
        m614b();
    }

    public void setAltImageResource(int i) {
        Drawable mutate = AppCompatResources.getDrawable(getContext(), i).mutate();
        this.f3035n = mutate;
        Drawable drawable = this.f3036o;
        Drawable[] drawableArr = this.f3032k;
        drawableArr[0] = drawable;
        drawableArr[1] = mutate;
        LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
        this.f3033l = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f3026e);
    }

    public void setBrightness(float f) {
        b21 b21Var = this.f3025d;
        b21Var.f7866d = f;
        b21Var.m2005a(this);
    }

    public void setContrast(float f) {
        b21 b21Var = this.f3025d;
        b21Var.f7868f = f;
        b21Var.m2005a(this);
    }

    public void setCrossfade(float f) {
        this.f3026e = f;
        if (this.f3032k != null) {
            if (!this.f3034m) {
                this.f3033l.getDrawable(0).setAlpha((int) ((1.0f - this.f3026e) * 255.0f));
            }
            this.f3033l.getDrawable(1).setAlpha((int) (this.f3026e * 255.0f));
            super.setImageDrawable(this.f3033l);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.f3035n != null && drawable != null) {
            Drawable mutate = drawable.mutate();
            this.f3036o = mutate;
            Drawable[] drawableArr = this.f3032k;
            drawableArr[0] = mutate;
            drawableArr[1] = this.f3035n;
            LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
            this.f3033l = layerDrawable;
            super.setImageDrawable(layerDrawable);
            setCrossfade(this.f3026e);
            return;
        }
        super.setImageDrawable(drawable);
    }

    public void setImagePanX(float f) {
        this.f3037p = f;
        m615c();
    }

    public void setImagePanY(float f) {
        this.f3038q = f;
        m615c();
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageResource(int i) {
        if (this.f3035n != null) {
            Drawable mutate = AppCompatResources.getDrawable(getContext(), i).mutate();
            this.f3036o = mutate;
            Drawable[] drawableArr = this.f3032k;
            drawableArr[0] = mutate;
            drawableArr[1] = this.f3035n;
            LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
            this.f3033l = layerDrawable;
            super.setImageDrawable(layerDrawable);
            setCrossfade(this.f3026e);
            return;
        }
        super.setImageResource(i);
    }

    public void setImageRotate(float f) {
        this.f3040s = f;
        m615c();
    }

    public void setImageZoom(float f) {
        this.f3039r = f;
        m615c();
    }

    @RequiresApi(21)
    public void setRound(float f) {
        boolean z;
        if (Float.isNaN(f)) {
            this.f3028g = f;
            float f2 = this.f3027f;
            this.f3027f = -1.0f;
            setRoundPercent(f2);
            return;
        }
        if (this.f3028g != f) {
            z = true;
        } else {
            z = false;
        }
        this.f3028g = f;
        if (f != RecyclerView.f7068F0) {
            if (this.f3029h == null) {
                this.f3029h = new Path();
            }
            if (this.f3031j == null) {
                this.f3031j = new RectF();
            }
            if (this.f3030i == null) {
                z11 z11Var = new z11(this, 1);
                this.f3030i = z11Var;
                setOutlineProvider(z11Var);
            }
            setClipToOutline(true);
            this.f3031j.set(RecyclerView.f7068F0, RecyclerView.f7068F0, getWidth(), getHeight());
            this.f3029h.reset();
            Path path = this.f3029h;
            RectF rectF = this.f3031j;
            float f3 = this.f3028g;
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
        if (this.f3027f != f) {
            z = true;
        } else {
            z = false;
        }
        this.f3027f = f;
        if (f != RecyclerView.f7068F0) {
            if (this.f3029h == null) {
                this.f3029h = new Path();
            }
            if (this.f3031j == null) {
                this.f3031j = new RectF();
            }
            if (this.f3030i == null) {
                z11 z11Var = new z11(this, 0);
                this.f3030i = z11Var;
                setOutlineProvider(z11Var);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.f3027f) / 2.0f;
            this.f3031j.set(RecyclerView.f7068F0, RecyclerView.f7068F0, width, height);
            this.f3029h.reset();
            this.f3029h.addRoundRect(this.f3031j, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f) {
        b21 b21Var = this.f3025d;
        b21Var.f7867e = f;
        b21Var.m2005a(this);
    }

    public void setWarmth(float f) {
        b21 b21Var = this.f3025d;
        b21Var.f7869g = f;
        b21Var.m2005a(this);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3025d = new b21();
        this.f3026e = RecyclerView.f7068F0;
        this.f3027f = RecyclerView.f7068F0;
        this.f3028g = Float.NaN;
        this.f3032k = new Drawable[2];
        this.f3034m = true;
        this.f3035n = null;
        this.f3036o = null;
        this.f3037p = Float.NaN;
        this.f3038q = Float.NaN;
        this.f3039r = Float.NaN;
        this.f3040s = Float.NaN;
        m613a(context, attributeSet);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3025d = new b21();
        this.f3026e = RecyclerView.f7068F0;
        this.f3027f = RecyclerView.f7068F0;
        this.f3028g = Float.NaN;
        this.f3032k = new Drawable[2];
        this.f3034m = true;
        this.f3035n = null;
        this.f3036o = null;
        this.f3037p = Float.NaN;
        this.f3038q = Float.NaN;
        this.f3039r = Float.NaN;
        this.f3040s = Float.NaN;
        m613a(context, attributeSet);
    }
}
