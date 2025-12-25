package p000;

import android.graphics.Rect;
import java.util.Comparator;

/* loaded from: classes.dex */
public final class us0 implements Comparator {

    /* renamed from: a */
    public final Rect f27426a = new Rect();

    /* renamed from: b */
    public final Rect f27427b = new Rect();

    /* renamed from: c */
    public final boolean f27428c;

    /* renamed from: d */
    public final wd0 f27429d;

    public us0(boolean z, wd0 wd0Var) {
        this.f27428c = z;
        this.f27429d = wd0Var;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        wd0 wd0Var = this.f27429d;
        Rect rect = this.f27426a;
        wd0Var.obtainBounds(obj, rect);
        Rect rect2 = this.f27427b;
        wd0Var.obtainBounds(obj2, rect2);
        int i = rect.top;
        int i2 = rect2.top;
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        int i3 = rect.left;
        int i4 = rect2.left;
        boolean z = this.f27428c;
        if (i3 < i4) {
            if (!z) {
                return -1;
            }
            return 1;
        }
        if (i3 > i4) {
            if (z) {
                return -1;
            }
            return 1;
        }
        int i5 = rect.bottom;
        int i6 = rect2.bottom;
        if (i5 < i6) {
            return -1;
        }
        if (i5 > i6) {
            return 1;
        }
        int i7 = rect.right;
        int i8 = rect2.right;
        if (i7 < i8) {
            if (!z) {
                return -1;
            }
            return 1;
        }
        if (i7 > i8) {
            if (z) {
                return -1;
            }
            return 1;
        }
        return 0;
    }
}
