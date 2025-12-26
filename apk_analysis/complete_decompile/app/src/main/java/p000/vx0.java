package p000;

import android.graphics.Rect;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import androidx.collection.LruCache;
import androidx.leanback.widget.BaseGridView;
import androidx.leanback.widget.C0377q0;
import androidx.leanback.widget.GridLayoutManager;
import androidx.leanback.widget.OnChildLaidOutListener;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class vx0 {

    /* renamed from: a */
    public final /* synthetic */ GridLayoutManager f27986a;

    public vx0(GridLayoutManager gridLayoutManager) {
        this.f27986a = gridLayoutManager;
    }

    /* renamed from: a */
    public final void m7946a(Object obj, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        long itemId;
        zx0 zx0Var;
        int i7;
        View view = (View) obj;
        GridLayoutManager gridLayoutManager = this.f27986a;
        if (i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE) {
            if (!gridLayoutManager.f5701b0.f27514c) {
                i4 = ((m53) gridLayoutManager.f5703d0.f23109d).f22815j;
            } else {
                m53 m53Var = (m53) gridLayoutManager.f5703d0.f23109d;
                i4 = m53Var.f22814i - m53Var.f22816k;
            }
        }
        if (!gridLayoutManager.f5701b0.f27514c) {
            i6 = i2 + i4;
            i5 = i4;
        } else {
            i5 = i4 - i2;
            i6 = i4;
        }
        int m1430u = (gridLayoutManager.m1430u(i3) + ((m53) gridLayoutManager.f5703d0.f23110e).f22815j) - gridLayoutManager.f5689P;
        C1617oc c1617oc = gridLayoutManager.f5708i0;
        if (((LruCache) c1617oc.f23761c) != null) {
            SparseArray<Parcelable> sparseArray = (SparseArray) ((LruCache) c1617oc.f23761c).remove(Integer.toString(i));
            if (sparseArray != null) {
                view.restoreHierarchyState(sparseArray);
            }
        }
        this.f27986a.m1400E(view, i3, i5, i6, m1430u);
        if (!gridLayoutManager.f5718w.isPreLayout()) {
            gridLayoutManager.m1421Z();
        }
        if ((gridLayoutManager.f5677D & 3) != 1 && (zx0Var = gridLayoutManager.f5685L) != null) {
            boolean z = zx0Var.f29554n;
            GridLayoutManager gridLayoutManager2 = zx0Var.f29556p;
            if (z && (i7 = zx0Var.f29555o) != 0) {
                zx0Var.f29555o = gridLayoutManager2.m1406K(i7, true);
            }
            int i8 = zx0Var.f29555o;
            if (i8 == 0 || ((i8 > 0 && gridLayoutManager2.m1398C()) || (zx0Var.f29555o < 0 && gridLayoutManager2.m1397B()))) {
                zx0Var.setTargetPosition(gridLayoutManager2.f5682I);
                zx0Var.stop();
            }
        }
        if (gridLayoutManager.f5681H != null) {
            RecyclerView.ViewHolder childViewHolder = gridLayoutManager.f5714s.getChildViewHolder(view);
            OnChildLaidOutListener onChildLaidOutListener = gridLayoutManager.f5681H;
            BaseGridView baseGridView = gridLayoutManager.f5714s;
            if (childViewHolder == null) {
                itemId = -1;
            } else {
                itemId = childViewHolder.getItemId();
            }
            onChildLaidOutListener.onChildLaidOut(baseGridView, view, i, itemId);
        }
    }

    /* renamed from: b */
    public final int m7947b(int i, boolean z, Object[] objArr, boolean z2) {
        int i2;
        int i3;
        View findViewByPosition;
        GridLayoutManager gridLayoutManager = this.f27986a;
        View m1396A = gridLayoutManager.m1396A(i - gridLayoutManager.f5719x);
        if (!((C0377q0) m1396A.getLayoutParams()).isItemRemoved()) {
            if (z2) {
                if (z) {
                    gridLayoutManager.addDisappearingView(m1396A);
                } else {
                    gridLayoutManager.addDisappearingView(m1396A, 0);
                }
            } else if (z) {
                gridLayoutManager.addView(m1396A);
            } else {
                gridLayoutManager.addView(m1396A, 0);
            }
            int i4 = gridLayoutManager.f5688O;
            if (i4 != -1) {
                m1396A.setVisibility(i4);
            }
            zx0 zx0Var = gridLayoutManager.f5685L;
            if (zx0Var != null && !zx0Var.f29554n && (i2 = zx0Var.f29555o) != 0) {
                GridLayoutManager gridLayoutManager2 = zx0Var.f29556p;
                if (i2 > 0) {
                    i3 = gridLayoutManager2.f5682I + gridLayoutManager2.f5699Z;
                } else {
                    i3 = gridLayoutManager2.f5682I - gridLayoutManager2.f5699Z;
                }
                View view = null;
                while (zx0Var.f29555o != 0 && (findViewByPosition = zx0Var.findViewByPosition(i3)) != null) {
                    gridLayoutManager2.getClass();
                    if (findViewByPosition.getVisibility() == 0 && (!gridLayoutManager2.hasFocus() || findViewByPosition.hasFocusable())) {
                        gridLayoutManager2.f5682I = i3;
                        gridLayoutManager2.f5683J = 0;
                        int i5 = zx0Var.f29555o;
                        if (i5 > 0) {
                            zx0Var.f29555o = i5 - 1;
                        } else {
                            zx0Var.f29555o = i5 + 1;
                        }
                        view = findViewByPosition;
                    }
                    if (zx0Var.f29555o > 0) {
                        i3 += gridLayoutManager2.f5699Z;
                    } else {
                        i3 -= gridLayoutManager2.f5699Z;
                    }
                }
                if (view != null && gridLayoutManager2.hasFocus()) {
                    gridLayoutManager2.f5677D |= 32;
                    view.requestFocus();
                    gridLayoutManager2.f5677D &= -33;
                }
            }
            int m1395z = GridLayoutManager.m1395z(m1396A, m1396A.findFocus());
            int i6 = gridLayoutManager.f5677D;
            if ((i6 & 3) != 1) {
                if (i == gridLayoutManager.f5682I && m1395z == gridLayoutManager.f5683J && gridLayoutManager.f5685L == null) {
                    gridLayoutManager.m1424n();
                }
            } else if ((i6 & 4) == 0) {
                int i7 = i6 & 16;
                if (i7 == 0 && i == gridLayoutManager.f5682I && m1395z == gridLayoutManager.f5683J) {
                    gridLayoutManager.m1424n();
                } else if (i7 != 0 && i >= gridLayoutManager.f5682I && m1396A.hasFocusable()) {
                    gridLayoutManager.f5682I = i;
                    gridLayoutManager.f5683J = m1395z;
                    gridLayoutManager.f5677D &= -17;
                    gridLayoutManager.m1424n();
                }
            }
            gridLayoutManager.m1402G(m1396A);
        }
        objArr[0] = m1396A;
        if (gridLayoutManager.f5715t == 0) {
            return gridLayoutManager.m1427r(m1396A);
        }
        return gridLayoutManager.m1426q(m1396A);
    }

    /* renamed from: c */
    public final int m7948c() {
        GridLayoutManager gridLayoutManager = this.f27986a;
        return gridLayoutManager.f5718w.getItemCount() + gridLayoutManager.f5719x;
    }

    /* renamed from: d */
    public final int m7949d(int i) {
        GridLayoutManager gridLayoutManager = this.f27986a;
        View findViewByPosition = gridLayoutManager.findViewByPosition(i - gridLayoutManager.f5719x);
        if ((gridLayoutManager.f5677D & 262144) != 0) {
            return gridLayoutManager.f5716u.getDecoratedEnd(findViewByPosition);
        }
        return gridLayoutManager.f5716u.getDecoratedStart(findViewByPosition);
    }

    /* renamed from: e */
    public final int m7950e(int i) {
        GridLayoutManager gridLayoutManager = this.f27986a;
        View findViewByPosition = gridLayoutManager.findViewByPosition(i - gridLayoutManager.f5719x);
        Rect rect = GridLayoutManager.f5672m0;
        gridLayoutManager.getDecoratedBoundsWithMargins(findViewByPosition, rect);
        if (gridLayoutManager.f5715t == 0) {
            return rect.width();
        }
        return rect.height();
    }

    /* renamed from: f */
    public final void m7951f(int i) {
        GridLayoutManager gridLayoutManager = this.f27986a;
        View findViewByPosition = gridLayoutManager.findViewByPosition(i - gridLayoutManager.f5719x);
        if ((gridLayoutManager.f5677D & 3) == 1) {
            gridLayoutManager.detachAndScrapView(findViewByPosition, gridLayoutManager.f5676C);
        } else {
            gridLayoutManager.removeAndRecycleView(findViewByPosition, gridLayoutManager.f5676C);
        }
    }
}
