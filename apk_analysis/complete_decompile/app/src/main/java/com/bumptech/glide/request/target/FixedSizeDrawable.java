package com.bumptech.glide.request.target;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.util.Preconditions;
import p000.oe0;

/* loaded from: classes.dex */
public class FixedSizeDrawable extends Drawable {

    /* renamed from: a */
    public final Matrix f9109a;

    /* renamed from: b */
    public final RectF f9110b;

    /* renamed from: c */
    public final RectF f9111c;

    /* renamed from: d */
    public Drawable f9112d;

    /* renamed from: e */
    public oe0 f9113e;

    /* renamed from: f */
    public boolean f9114f;

    public FixedSizeDrawable(Drawable drawable, int i, int i2) {
        this(new oe0(drawable.getConstantState(), i, i2), drawable);
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.f9112d.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        canvas.save();
        canvas.concat(this.f9109a);
        this.f9112d.draw(canvas);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(19)
    public int getAlpha() {
        return this.f9112d.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.Callback getCallback() {
        return this.f9112d.getCallback();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.f9112d.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f9113e;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable getCurrent() {
        return this.f9112d.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f9113e.f23788c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f9113e.f23787b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f9112d.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f9112d.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f9112d.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        return this.f9112d.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        this.f9112d.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        if (!this.f9114f && super.mutate() == this) {
            this.f9112d = this.f9112d.mutate();
            oe0 oe0Var = this.f9113e;
            this.f9113e = new oe0(oe0Var.f23786a, oe0Var.f23787b, oe0Var.f23788c);
            this.f9114f = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(@NonNull Runnable runnable, long j) {
        super.scheduleSelf(runnable, j);
        this.f9112d.scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f9112d.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        RectF rectF = this.f9111c;
        rectF.set(i, i2, i3, i4);
        this.f9109a.setRectToRect(this.f9110b, rectF, Matrix.ScaleToFit.CENTER);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i) {
        this.f9112d.setChangingConfigurations(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, @NonNull PorterDuff.Mode mode) {
        this.f9112d.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated
    public void setDither(boolean z) {
        this.f9112d.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f9112d.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return this.f9112d.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(@NonNull Runnable runnable) {
        super.unscheduleSelf(runnable);
        this.f9112d.unscheduleSelf(runnable);
    }

    public FixedSizeDrawable(oe0 oe0Var, Drawable drawable) {
        this.f9113e = (oe0) Preconditions.checkNotNull(oe0Var);
        this.f9112d = (Drawable) Preconditions.checkNotNull(drawable);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.f9109a = new Matrix();
        this.f9110b = new RectF(RecyclerView.f7068F0, RecyclerView.f7068F0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.f9111c = new RectF();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f9112d.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(@NonNull Rect rect) {
        super.setBounds(rect);
        RectF rectF = this.f9111c;
        rectF.set(rect);
        this.f9109a.setRectToRect(this.f9110b, rectF, Matrix.ScaleToFit.CENTER);
    }
}
