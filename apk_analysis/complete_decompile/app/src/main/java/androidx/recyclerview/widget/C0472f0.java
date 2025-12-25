package androidx.recyclerview.widget;

import android.view.View;

/* renamed from: androidx.recyclerview.widget.f0 */
/* loaded from: classes.dex */
public final class C0472f0 {

    /* renamed from: a */
    public OrientationHelper f7370a;

    /* renamed from: b */
    public int f7371b;

    /* renamed from: c */
    public int f7372c;

    /* renamed from: d */
    public boolean f7373d;

    /* renamed from: e */
    public boolean f7374e;

    public C0472f0() {
        m1830d();
    }

    /* renamed from: a */
    public final void m1827a() {
        int startAfterPadding;
        if (this.f7373d) {
            startAfterPadding = this.f7370a.getEndAfterPadding();
        } else {
            startAfterPadding = this.f7370a.getStartAfterPadding();
        }
        this.f7372c = startAfterPadding;
    }

    /* renamed from: b */
    public final void m1828b(int i, View view) {
        if (this.f7373d) {
            this.f7372c = this.f7370a.getTotalSpaceChange() + this.f7370a.getDecoratedEnd(view);
        } else {
            this.f7372c = this.f7370a.getDecoratedStart(view);
        }
        this.f7371b = i;
    }

    /* renamed from: c */
    public final void m1829c(int i, View view) {
        int totalSpaceChange = this.f7370a.getTotalSpaceChange();
        if (totalSpaceChange >= 0) {
            m1828b(i, view);
            return;
        }
        this.f7371b = i;
        if (this.f7373d) {
            int endAfterPadding = (this.f7370a.getEndAfterPadding() - totalSpaceChange) - this.f7370a.getDecoratedEnd(view);
            this.f7372c = this.f7370a.getEndAfterPadding() - endAfterPadding;
            if (endAfterPadding > 0) {
                int decoratedMeasurement = this.f7372c - this.f7370a.getDecoratedMeasurement(view);
                int startAfterPadding = this.f7370a.getStartAfterPadding();
                int min = decoratedMeasurement - (Math.min(this.f7370a.getDecoratedStart(view) - startAfterPadding, 0) + startAfterPadding);
                if (min < 0) {
                    this.f7372c = Math.min(endAfterPadding, -min) + this.f7372c;
                    return;
                }
                return;
            }
            return;
        }
        int decoratedStart = this.f7370a.getDecoratedStart(view);
        int startAfterPadding2 = decoratedStart - this.f7370a.getStartAfterPadding();
        this.f7372c = decoratedStart;
        if (startAfterPadding2 > 0) {
            int endAfterPadding2 = (this.f7370a.getEndAfterPadding() - Math.min(0, (this.f7370a.getEndAfterPadding() - totalSpaceChange) - this.f7370a.getDecoratedEnd(view))) - (this.f7370a.getDecoratedMeasurement(view) + decoratedStart);
            if (endAfterPadding2 < 0) {
                this.f7372c -= Math.min(startAfterPadding2, -endAfterPadding2);
            }
        }
    }

    /* renamed from: d */
    public final void m1830d() {
        this.f7371b = -1;
        this.f7372c = Integer.MIN_VALUE;
        this.f7373d = false;
        this.f7374e = false;
    }

    public final String toString() {
        return "AnchorInfo{mPosition=" + this.f7371b + ", mCoordinate=" + this.f7372c + ", mLayoutFromEnd=" + this.f7373d + ", mValid=" + this.f7374e + '}';
    }
}
