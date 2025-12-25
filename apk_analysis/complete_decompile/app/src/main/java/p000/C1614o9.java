package p000;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: o9 */
/* loaded from: classes.dex */
public final class C1614o9 extends C1540m9 {

    /* renamed from: f */
    public final AppCompatSeekBar f23662f;

    /* renamed from: g */
    public Drawable f23663g;

    /* renamed from: h */
    public ColorStateList f23664h;

    /* renamed from: i */
    public PorterDuff.Mode f23665i;

    /* renamed from: j */
    public boolean f23666j;

    /* renamed from: k */
    public boolean f23667k;

    public C1614o9(AppCompatSeekBar appCompatSeekBar) {
        super(0, appCompatSeekBar);
        this.f23664h = null;
        this.f23665i = null;
        this.f23666j = false;
        this.f23667k = false;
        this.f23662f = appCompatSeekBar;
    }

    @Override // p000.C1540m9
    /* renamed from: i */
    public final void mo6099i(AttributeSet attributeSet, int i) {
        super.mo6099i(attributeSet, i);
        AppCompatSeekBar appCompatSeekBar = this.f23662f;
        Context context = appCompatSeekBar.getContext();
        int[] iArr = R.styleable.AppCompatSeekBar;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i, 0);
        ViewCompat.saveAttributeDataForStyleable(appCompatSeekBar, appCompatSeekBar.getContext(), iArr, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i, 0);
        Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(R.styleable.AppCompatSeekBar_android_thumb);
        if (drawableIfKnown != null) {
            appCompatSeekBar.setThumb(drawableIfKnown);
        }
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.AppCompatSeekBar_tickMark);
        Drawable drawable2 = this.f23663g;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f23663g = drawable;
        if (drawable != null) {
            drawable.setCallback(appCompatSeekBar);
            DrawableCompat.setLayoutDirection(drawable, appCompatSeekBar.getLayoutDirection());
            if (drawable.isStateful()) {
                drawable.setState(appCompatSeekBar.getDrawableState());
            }
            m6522v();
        }
        appCompatSeekBar.invalidate();
        int i2 = R.styleable.AppCompatSeekBar_tickMarkTintMode;
        if (obtainStyledAttributes.hasValue(i2)) {
            this.f23665i = DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(i2, -1), this.f23665i);
            this.f23667k = true;
        }
        int i3 = R.styleable.AppCompatSeekBar_tickMarkTint;
        if (obtainStyledAttributes.hasValue(i3)) {
            this.f23664h = obtainStyledAttributes.getColorStateList(i3);
            this.f23666j = true;
        }
        obtainStyledAttributes.recycle();
        m6522v();
    }

    /* renamed from: v */
    public final void m6522v() {
        Drawable drawable = this.f23663g;
        if (drawable != null) {
            if (this.f23666j || this.f23667k) {
                Drawable wrap = DrawableCompat.wrap(drawable.mutate());
                this.f23663g = wrap;
                if (this.f23666j) {
                    DrawableCompat.setTintList(wrap, this.f23664h);
                }
                if (this.f23667k) {
                    DrawableCompat.setTintMode(this.f23663g, this.f23665i);
                }
                if (this.f23663g.isStateful()) {
                    this.f23663g.setState(this.f23662f.getDrawableState());
                }
            }
        }
    }

    /* renamed from: w */
    public final void m6523w(Canvas canvas) {
        int i;
        if (this.f23663g != null) {
            int max = this.f23662f.getMax();
            int i2 = 1;
            if (max > 1) {
                int intrinsicWidth = this.f23663g.getIntrinsicWidth();
                int intrinsicHeight = this.f23663g.getIntrinsicHeight();
                if (intrinsicWidth >= 0) {
                    i = intrinsicWidth / 2;
                } else {
                    i = 1;
                }
                if (intrinsicHeight >= 0) {
                    i2 = intrinsicHeight / 2;
                }
                this.f23663g.setBounds(-i, -i2, i, i2);
                float width = ((r0.getWidth() - r0.getPaddingLeft()) - r0.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(r0.getPaddingLeft(), r0.getHeight() / 2);
                for (int i3 = 0; i3 <= max; i3++) {
                    this.f23663g.draw(canvas);
                    canvas.translate(width, RecyclerView.f7068F0);
                }
                canvas.restoreToCount(save);
            }
        }
    }
}
