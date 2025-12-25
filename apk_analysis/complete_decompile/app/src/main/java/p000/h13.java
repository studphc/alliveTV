package p000;

import android.graphics.Paint;
import androidx.annotation.ColorInt;
import androidx.core.content.res.ComplexColorCompat;

/* loaded from: classes.dex */
public final class h13 extends k13 {

    /* renamed from: d */
    public ComplexColorCompat f17921d;

    /* renamed from: e */
    public float f17922e;

    /* renamed from: f */
    public ComplexColorCompat f17923f;

    /* renamed from: g */
    public float f17924g;

    /* renamed from: h */
    public float f17925h;

    /* renamed from: i */
    public float f17926i;

    /* renamed from: j */
    public float f17927j;

    /* renamed from: k */
    public float f17928k;

    /* renamed from: l */
    public Paint.Cap f17929l;

    /* renamed from: m */
    public Paint.Join f17930m;

    /* renamed from: n */
    public float f17931n;

    @Override // p000.j13
    /* renamed from: a */
    public final boolean mo5030a() {
        if (!this.f17923f.isStateful() && !this.f17921d.isStateful()) {
            return false;
        }
        return true;
    }

    @Override // p000.j13
    /* renamed from: b */
    public final boolean mo5031b(int[] iArr) {
        return this.f17921d.onStateChanged(iArr) | this.f17923f.onStateChanged(iArr);
    }

    public float getFillAlpha() {
        return this.f17925h;
    }

    @ColorInt
    public int getFillColor() {
        return this.f17923f.getColor();
    }

    public float getStrokeAlpha() {
        return this.f17924g;
    }

    @ColorInt
    public int getStrokeColor() {
        return this.f17921d.getColor();
    }

    public float getStrokeWidth() {
        return this.f17922e;
    }

    public float getTrimPathEnd() {
        return this.f17927j;
    }

    public float getTrimPathOffset() {
        return this.f17928k;
    }

    public float getTrimPathStart() {
        return this.f17926i;
    }

    public void setFillAlpha(float f) {
        this.f17925h = f;
    }

    public void setFillColor(int i) {
        this.f17923f.setColor(i);
    }

    public void setStrokeAlpha(float f) {
        this.f17924g = f;
    }

    public void setStrokeColor(int i) {
        this.f17921d.setColor(i);
    }

    public void setStrokeWidth(float f) {
        this.f17922e = f;
    }

    public void setTrimPathEnd(float f) {
        this.f17927j = f;
    }

    public void setTrimPathOffset(float f) {
        this.f17928k = f;
    }

    public void setTrimPathStart(float f) {
        this.f17926i = f;
    }
}
