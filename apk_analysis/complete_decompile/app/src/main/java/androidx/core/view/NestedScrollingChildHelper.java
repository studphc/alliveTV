package androidx.core.view;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class NestedScrollingChildHelper {

    /* renamed from: a */
    public ViewParent f3892a;

    /* renamed from: b */
    public ViewParent f3893b;

    /* renamed from: c */
    public final View f3894c;

    /* renamed from: d */
    public boolean f3895d;

    /* renamed from: e */
    public int[] f3896e;

    public NestedScrollingChildHelper(@NonNull View view) {
        this.f3894c = view;
    }

    /* renamed from: a */
    public final boolean m906a(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        ViewParent m907b;
        int i6;
        int i7;
        int[] iArr3;
        if (!isNestedScrollingEnabled() || (m907b = m907b(i5)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        View view = this.f3894c;
        if (iArr != null) {
            view.getLocationInWindow(iArr);
            i6 = iArr[0];
            i7 = iArr[1];
        } else {
            i6 = 0;
            i7 = 0;
        }
        if (iArr2 == null) {
            if (this.f3896e == null) {
                this.f3896e = new int[2];
            }
            int[] iArr4 = this.f3896e;
            iArr4[0] = 0;
            iArr4[1] = 0;
            iArr3 = iArr4;
        } else {
            iArr3 = iArr2;
        }
        ViewParentCompat.onNestedScroll(m907b, this.f3894c, i, i2, i3, i4, i5, iArr3);
        if (iArr != null) {
            view.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i6;
            iArr[1] = iArr[1] - i7;
        }
        return true;
    }

    /* renamed from: b */
    public final ViewParent m907b(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return this.f3893b;
        }
        return this.f3892a;
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        ViewParent m907b;
        if (!isNestedScrollingEnabled() || (m907b = m907b(0)) == null) {
            return false;
        }
        return ViewParentCompat.onNestedFling(m907b, this.f3894c, f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        ViewParent m907b;
        if (!isNestedScrollingEnabled() || (m907b = m907b(0)) == null) {
            return false;
        }
        return ViewParentCompat.onNestedPreFling(m907b, this.f3894c, f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, @Nullable int[] iArr, @Nullable int[] iArr2) {
        return dispatchNestedPreScroll(i, i2, iArr, iArr2, 0);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, @Nullable int[] iArr) {
        return m906a(i, i2, i3, i4, iArr, 0, null);
    }

    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    public boolean isNestedScrollingEnabled() {
        return this.f3895d;
    }

    public void onDetachedFromWindow() {
        ViewCompat.stopNestedScroll(this.f3894c);
    }

    public void onStopNestedScroll(@NonNull View view) {
        ViewCompat.stopNestedScroll(this.f3894c);
    }

    public void setNestedScrollingEnabled(boolean z) {
        if (this.f3895d) {
            ViewCompat.stopNestedScroll(this.f3894c);
        }
        this.f3895d = z;
    }

    public boolean startNestedScroll(int i) {
        return startNestedScroll(i, 0);
    }

    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, @Nullable int[] iArr, @Nullable int[] iArr2, int i3) {
        ViewParent m907b;
        int i4;
        int i5;
        int[] iArr3;
        if (!isNestedScrollingEnabled() || (m907b = m907b(i3)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
        View view = this.f3894c;
        if (iArr2 != null) {
            view.getLocationInWindow(iArr2);
            i4 = iArr2[0];
            i5 = iArr2[1];
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (iArr == null) {
            if (this.f3896e == null) {
                this.f3896e = new int[2];
            }
            iArr3 = this.f3896e;
        } else {
            iArr3 = iArr;
        }
        iArr3[0] = 0;
        iArr3[1] = 0;
        ViewParentCompat.onNestedPreScroll(m907b, this.f3894c, i, i2, iArr3, i3);
        if (iArr2 != null) {
            view.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i4;
            iArr2[1] = iArr2[1] - i5;
        }
        return (iArr3[0] == 0 && iArr3[1] == 0) ? false : true;
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, @Nullable int[] iArr, int i5) {
        return m906a(i, i2, i3, i4, iArr, i5, null);
    }

    public boolean hasNestedScrollingParent(int i) {
        return m907b(i) != null;
    }

    public boolean startNestedScroll(int i, int i2) {
        if (hasNestedScrollingParent(i2)) {
            return true;
        }
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        View view = this.f3894c;
        View view2 = view;
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (ViewParentCompat.onStartNestedScroll(parent, view2, view, i, i2)) {
                if (i2 == 0) {
                    this.f3892a = parent;
                } else if (i2 == 1) {
                    this.f3893b = parent;
                }
                ViewParentCompat.onNestedScrollAccepted(parent, view2, view, i, i2);
                return true;
            }
            if (parent instanceof View) {
                view2 = parent;
            }
        }
        return false;
    }

    public void stopNestedScroll(int i) {
        ViewParent m907b = m907b(i);
        if (m907b != null) {
            ViewParentCompat.onStopNestedScroll(m907b, this.f3894c, i);
            if (i == 0) {
                this.f3892a = null;
            } else {
                if (i != 1) {
                    return;
                }
                this.f3893b = null;
            }
        }
    }

    public void dispatchNestedScroll(int i, int i2, int i3, int i4, @Nullable int[] iArr, int i5, @Nullable int[] iArr2) {
        m906a(i, i2, i3, i4, iArr, i5, iArr2);
    }
}
