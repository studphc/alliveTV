package androidx.core.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

@Deprecated
/* loaded from: classes.dex */
public final class ScrollerCompat {

    /* renamed from: a */
    public OverScroller f4081a;

    @Deprecated
    public static ScrollerCompat create(Context context) {
        return create(context, null);
    }

    @Deprecated
    public void abortAnimation() {
        this.f4081a.abortAnimation();
    }

    @Deprecated
    public boolean computeScrollOffset() {
        return this.f4081a.computeScrollOffset();
    }

    @Deprecated
    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f4081a.fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    @Deprecated
    public float getCurrVelocity() {
        return this.f4081a.getCurrVelocity();
    }

    @Deprecated
    public int getCurrX() {
        return this.f4081a.getCurrX();
    }

    @Deprecated
    public int getCurrY() {
        return this.f4081a.getCurrY();
    }

    @Deprecated
    public int getFinalX() {
        return this.f4081a.getFinalX();
    }

    @Deprecated
    public int getFinalY() {
        return this.f4081a.getFinalY();
    }

    @Deprecated
    public boolean isFinished() {
        return this.f4081a.isFinished();
    }

    @Deprecated
    public boolean isOverScrolled() {
        return this.f4081a.isOverScrolled();
    }

    @Deprecated
    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.f4081a.notifyHorizontalEdgeReached(i, i2, i3);
    }

    @Deprecated
    public void notifyVerticalEdgeReached(int i, int i2, int i3) {
        this.f4081a.notifyVerticalEdgeReached(i, i2, i3);
    }

    @Deprecated
    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        return this.f4081a.springBack(i, i2, i3, i4, i5, i6);
    }

    @Deprecated
    public void startScroll(int i, int i2, int i3, int i4) {
        this.f4081a.startScroll(i, i2, i3, i4);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.core.widget.ScrollerCompat, java.lang.Object] */
    @Deprecated
    public static ScrollerCompat create(Context context, Interpolator interpolator) {
        ?? obj = new Object();
        obj.f4081a = interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
        return obj;
    }

    @Deprecated
    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.f4081a.fling(i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    @Deprecated
    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.f4081a.startScroll(i, i2, i3, i4, i5);
    }
}
