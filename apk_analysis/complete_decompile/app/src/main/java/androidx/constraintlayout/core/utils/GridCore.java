package androidx.constraintlayout.core.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import p000.C0556bg;

/* loaded from: classes.dex */
public class GridCore extends VirtualLayout {
    public static final int HORIZONTAL = 0;
    public static final int SPANS_RESPECT_WIDGET_ORDER = 2;
    public static final int SUB_GRID_BY_COL_ROW = 1;
    public static final int VERTICAL = 1;

    /* renamed from: T */
    public ConstraintWidgetContainer f2420T;

    /* renamed from: U */
    public ConstraintWidget[] f2421U;

    /* renamed from: W */
    public int f2423W;

    /* renamed from: X */
    public int f2424X;

    /* renamed from: Y */
    public int f2425Y;

    /* renamed from: Z */
    public int f2426Z;

    /* renamed from: a0 */
    public float f2427a0;

    /* renamed from: b0 */
    public float f2428b0;

    /* renamed from: c0 */
    public String f2429c0;

    /* renamed from: d0 */
    public String f2430d0;

    /* renamed from: e0 */
    public String f2431e0;

    /* renamed from: f0 */
    public String f2432f0;

    /* renamed from: g0 */
    public int f2433g0;

    /* renamed from: i0 */
    public boolean[][] f2435i0;

    /* renamed from: k0 */
    public int[][] f2437k0;

    /* renamed from: l0 */
    public int f2438l0;

    /* renamed from: m0 */
    public int[][] f2439m0;

    /* renamed from: V */
    public boolean f2422V = false;

    /* renamed from: h0 */
    public int f2434h0 = 0;

    /* renamed from: j0 */
    public final HashSet f2436j0 = new HashSet();

    /* renamed from: n0 */
    public int f2440n0 = 0;

    public GridCore() {
        m479v();
        m475q();
    }

    /* renamed from: k */
    public static void m468k(ConstraintWidget constraintWidget) {
        constraintWidget.setVerticalWeight(-1.0f);
        constraintWidget.mTop.reset();
        constraintWidget.mBottom.reset();
        constraintWidget.mBaseline.reset();
    }

    /* renamed from: u */
    public static float[] m469u(int i, String str) {
        if (str != null && !str.trim().isEmpty()) {
            String[] split = str.split(",");
            float[] fArr = new float[i];
            for (int i2 = 0; i2 < i; i2++) {
                if (i2 < split.length) {
                    try {
                        fArr[i2] = Float.parseFloat(split[i2]);
                    } catch (Exception e) {
                        System.err.println("Error parsing `" + split[i2] + "`: " + e.getMessage());
                        fArr[i2] = 1.0f;
                    }
                } else {
                    fArr[i2] = 1.0f;
                }
            }
            return fArr;
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(@Nullable LinearSystem linearSystem, boolean z) {
        int i;
        int i2;
        int[][] iArr;
        int i3;
        super.addToSolver(linearSystem, z);
        int max = Math.max(this.f2423W, this.f2425Y);
        ConstraintWidget constraintWidget = this.f2421U[0];
        float[] m469u = m469u(this.f2423W, this.f2429c0);
        if (this.f2423W == 1) {
            m468k(constraintWidget);
            constraintWidget.mTop.connect(this.mTop, 0);
            constraintWidget.mBottom.connect(this.mBottom, 0);
        } else {
            int i4 = 0;
            while (true) {
                i = this.f2423W;
                if (i4 >= i) {
                    break;
                }
                ConstraintWidget constraintWidget2 = this.f2421U[i4];
                m468k(constraintWidget2);
                if (m469u != null) {
                    constraintWidget2.setVerticalWeight(m469u[i4]);
                }
                if (i4 > 0) {
                    constraintWidget2.mTop.connect(this.f2421U[i4 - 1].mBottom, 0);
                } else {
                    constraintWidget2.mTop.connect(this.mTop, 0);
                }
                if (i4 < this.f2423W - 1) {
                    constraintWidget2.mBottom.connect(this.f2421U[i4 + 1].mTop, 0);
                } else {
                    constraintWidget2.mBottom.connect(this.mBottom, 0);
                }
                if (i4 > 0) {
                    constraintWidget2.mTop.mMargin = (int) this.f2428b0;
                }
                i4++;
            }
            while (i < max) {
                ConstraintWidget constraintWidget3 = this.f2421U[i];
                m468k(constraintWidget3);
                constraintWidget3.mTop.connect(this.mTop, 0);
                constraintWidget3.mBottom.connect(this.mBottom, 0);
                i++;
            }
        }
        int max2 = Math.max(this.f2423W, this.f2425Y);
        ConstraintWidget constraintWidget4 = this.f2421U[0];
        float[] m469u2 = m469u(this.f2425Y, this.f2430d0);
        if (this.f2425Y == 1) {
            constraintWidget4.setHorizontalWeight(-1.0f);
            constraintWidget4.mLeft.reset();
            constraintWidget4.mRight.reset();
            constraintWidget4.mLeft.connect(this.mLeft, 0);
            constraintWidget4.mRight.connect(this.mRight, 0);
        } else {
            int i5 = 0;
            while (true) {
                i2 = this.f2425Y;
                if (i5 >= i2) {
                    break;
                }
                ConstraintWidget constraintWidget5 = this.f2421U[i5];
                constraintWidget5.setHorizontalWeight(-1.0f);
                constraintWidget5.mLeft.reset();
                constraintWidget5.mRight.reset();
                if (m469u2 != null) {
                    constraintWidget5.setHorizontalWeight(m469u2[i5]);
                }
                if (i5 > 0) {
                    constraintWidget5.mLeft.connect(this.f2421U[i5 - 1].mRight, 0);
                } else {
                    constraintWidget5.mLeft.connect(this.mLeft, 0);
                }
                if (i5 < this.f2425Y - 1) {
                    constraintWidget5.mRight.connect(this.f2421U[i5 + 1].mLeft, 0);
                } else {
                    constraintWidget5.mRight.connect(this.mRight, 0);
                }
                if (i5 > 0) {
                    constraintWidget5.mLeft.mMargin = (int) this.f2427a0;
                }
                i5++;
            }
            while (i2 < max2) {
                ConstraintWidget constraintWidget6 = this.f2421U[i2];
                constraintWidget6.setHorizontalWeight(-1.0f);
                constraintWidget6.mLeft.reset();
                constraintWidget6.mRight.reset();
                constraintWidget6.mLeft.connect(this.mLeft, 0);
                constraintWidget6.mRight.connect(this.mRight, 0);
                i2++;
            }
        }
        for (int i6 = 0; i6 < this.mWidgetsCount; i6++) {
            if (!this.f2436j0.contains(this.mWidgets[i6].stringId)) {
                boolean z2 = false;
                int i7 = 0;
                while (true) {
                    if (z2) {
                        break;
                    }
                    i7 = this.f2434h0;
                    if (i7 >= this.f2423W * this.f2425Y) {
                        i7 = -1;
                        break;
                    }
                    int m472n = m472n(i7);
                    int m471m = m471m(this.f2434h0);
                    boolean[] zArr = this.f2435i0[m472n];
                    if (zArr[m471m]) {
                        zArr[m471m] = false;
                        z2 = true;
                    }
                    this.f2434h0++;
                }
                int m472n2 = m472n(i7);
                int m471m2 = m471m(i7);
                if (i7 != -1) {
                    if ((this.f2438l0 & 2) > 0 && (iArr = this.f2439m0) != null && (i3 = this.f2440n0) < iArr.length) {
                        int[] iArr2 = iArr[i3];
                        if (iArr2[0] == i7) {
                            this.f2435i0[m472n2][m471m2] = true;
                            if (m477s(m472n2, m471m2, iArr2[1], iArr2[2])) {
                                ConstraintWidget constraintWidget7 = this.mWidgets[i6];
                                int[] iArr3 = this.f2439m0[this.f2440n0];
                                m470l(constraintWidget7, m472n2, m471m2, iArr3[1], iArr3[2]);
                                this.f2440n0++;
                            }
                        }
                    }
                    m470l(this.mWidgets[i6], m472n2, m471m2, 1, 1);
                } else {
                    return;
                }
            }
        }
    }

    @Nullable
    public String getColumnWeights() {
        return this.f2430d0;
    }

    @Nullable
    public ConstraintWidgetContainer getContainer() {
        return this.f2420T;
    }

    public int getFlags() {
        return this.f2438l0;
    }

    public float getHorizontalGaps() {
        return this.f2427a0;
    }

    public int getOrientation() {
        return this.f2433g0;
    }

    @Nullable
    public String getRowWeights() {
        return this.f2429c0;
    }

    public float getVerticalGaps() {
        return this.f2428b0;
    }

    /* renamed from: l */
    public final void m470l(ConstraintWidget constraintWidget, int i, int i2, int i3, int i4) {
        constraintWidget.mLeft.connect(this.f2421U[i2].mLeft, 0);
        constraintWidget.mTop.connect(this.f2421U[i].mTop, 0);
        constraintWidget.mRight.connect(this.f2421U[(i2 + i4) - 1].mRight, 0);
        constraintWidget.mBottom.connect(this.f2421U[(i + i3) - 1].mBottom, 0);
    }

    /* renamed from: m */
    public final int m471m(int i) {
        if (this.f2433g0 == 1) {
            return i / this.f2423W;
        }
        return i % this.f2425Y;
    }

    @Override // androidx.constraintlayout.core.widgets.VirtualLayout
    public void measure(int i, int i2, int i3, int i4) {
        int[][] m478t;
        super.measure(i, i2, i3, i4);
        this.f2420T = (ConstraintWidgetContainer) getParent();
        if (this.f2423W >= 1 && this.f2425Y >= 1) {
            this.f2434h0 = 0;
            String str = this.f2432f0;
            if (str != null && !str.trim().isEmpty() && (m478t = m478t(this.f2432f0, false)) != null) {
                m473o(m478t);
            }
            String str2 = this.f2431e0;
            if (str2 != null && !str2.trim().isEmpty()) {
                this.f2439m0 = m478t(this.f2431e0, true);
            }
            int max = Math.max(this.f2423W, this.f2425Y);
            ConstraintWidget[] constraintWidgetArr = this.f2421U;
            if (constraintWidgetArr == null) {
                this.f2421U = new ConstraintWidget[max];
                int i5 = 0;
                while (true) {
                    ConstraintWidget[] constraintWidgetArr2 = this.f2421U;
                    if (i5 >= constraintWidgetArr2.length) {
                        break;
                    }
                    ConstraintWidget constraintWidget = new ConstraintWidget();
                    ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.mListDimensionBehaviors;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    dimensionBehaviourArr[0] = dimensionBehaviour;
                    dimensionBehaviourArr[1] = dimensionBehaviour;
                    constraintWidget.stringId = String.valueOf(constraintWidget.hashCode());
                    constraintWidgetArr2[i5] = constraintWidget;
                    i5++;
                }
            } else if (max != constraintWidgetArr.length) {
                ConstraintWidget[] constraintWidgetArr3 = new ConstraintWidget[max];
                for (int i6 = 0; i6 < max; i6++) {
                    ConstraintWidget[] constraintWidgetArr4 = this.f2421U;
                    if (i6 < constraintWidgetArr4.length) {
                        constraintWidgetArr3[i6] = constraintWidgetArr4[i6];
                    } else {
                        ConstraintWidget constraintWidget2 = new ConstraintWidget();
                        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = constraintWidget2.mListDimensionBehaviors;
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        dimensionBehaviourArr2[0] = dimensionBehaviour2;
                        dimensionBehaviourArr2[1] = dimensionBehaviour2;
                        constraintWidget2.stringId = String.valueOf(constraintWidget2.hashCode());
                        constraintWidgetArr3[i6] = constraintWidget2;
                    }
                }
                while (true) {
                    ConstraintWidget[] constraintWidgetArr5 = this.f2421U;
                    if (max >= constraintWidgetArr5.length) {
                        break;
                    }
                    this.f2420T.remove(constraintWidgetArr5[max]);
                    max++;
                }
                this.f2421U = constraintWidgetArr3;
            }
            int[][] iArr = this.f2439m0;
            if (iArr != null) {
                m474p(iArr);
            }
        }
        this.f2420T.add(this.f2421U);
    }

    /* renamed from: n */
    public final int m472n(int i) {
        if (this.f2433g0 == 1) {
            return i % this.f2423W;
        }
        return i / this.f2425Y;
    }

    /* renamed from: o */
    public final void m473o(int[][] iArr) {
        for (int[] iArr2 : iArr) {
            if (!m477s(m472n(iArr2[0]), m471m(iArr2[0]), iArr2[1], iArr2[2])) {
                return;
            }
        }
    }

    /* renamed from: p */
    public final void m474p(int[][] iArr) {
        if ((this.f2438l0 & 2) > 0) {
            return;
        }
        for (int i = 0; i < iArr.length; i++) {
            int m472n = m472n(iArr[i][0]);
            int m471m = m471m(iArr[i][0]);
            int[] iArr2 = iArr[i];
            if (!m477s(m472n, m471m, iArr2[1], iArr2[2])) {
                return;
            }
            ConstraintWidget constraintWidget = this.mWidgets[i];
            int[] iArr3 = iArr[i];
            m470l(constraintWidget, m472n, m471m, iArr3[1], iArr3[2]);
            this.f2436j0.add(this.mWidgets[i].stringId);
        }
    }

    /* renamed from: q */
    public final void m475q() {
        boolean z;
        int[][] m478t;
        int[][] m478t2;
        boolean[][] zArr;
        int[][] iArr = this.f2437k0;
        if (iArr != null && iArr.length == this.mWidgetsCount && (zArr = this.f2435i0) != null && zArr.length == this.f2423W && zArr[0].length == this.f2425Y) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            m476r();
        }
        if (z) {
            for (int i = 0; i < this.f2435i0.length; i++) {
                int i2 = 0;
                while (true) {
                    boolean[][] zArr2 = this.f2435i0;
                    if (i2 < zArr2[0].length) {
                        zArr2[i][i2] = true;
                        i2++;
                    }
                }
            }
            for (int i3 = 0; i3 < this.f2437k0.length; i3++) {
                int i4 = 0;
                while (true) {
                    int[][] iArr2 = this.f2437k0;
                    if (i4 < iArr2[0].length) {
                        iArr2[i3][i4] = -1;
                        i4++;
                    }
                }
            }
        }
        this.f2434h0 = 0;
        String str = this.f2432f0;
        if (str != null && !str.trim().isEmpty() && (m478t2 = m478t(this.f2432f0, false)) != null) {
            m473o(m478t2);
        }
        String str2 = this.f2431e0;
        if (str2 != null && !str2.trim().isEmpty() && (m478t = m478t(this.f2431e0, true)) != null) {
            m474p(m478t);
        }
    }

    /* renamed from: r */
    public final void m476r() {
        boolean[][] zArr = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, this.f2423W, this.f2425Y);
        this.f2435i0 = zArr;
        for (boolean[] zArr2 : zArr) {
            Arrays.fill(zArr2, true);
        }
        int i = this.mWidgetsCount;
        if (i > 0) {
            int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i, 4);
            this.f2437k0 = iArr;
            for (int[] iArr2 : iArr) {
                Arrays.fill(iArr2, -1);
            }
        }
    }

    /* renamed from: s */
    public final boolean m477s(int i, int i2, int i3, int i4) {
        for (int i5 = i; i5 < i + i3; i5++) {
            for (int i6 = i2; i6 < i2 + i4; i6++) {
                boolean[][] zArr = this.f2435i0;
                if (i5 < zArr.length && i6 < zArr[0].length) {
                    boolean[] zArr2 = zArr[i5];
                    if (zArr2[i6]) {
                        zArr2[i6] = false;
                    }
                }
                return false;
            }
        }
        return true;
    }

    public void setColumnWeights(@NonNull String str) {
        String str2 = this.f2430d0;
        if (str2 != null && str2.equals(str)) {
            return;
        }
        this.f2430d0 = str;
    }

    public void setColumns(int i) {
        if (i > 50 || this.f2426Z == i) {
            return;
        }
        this.f2426Z = i;
        m479v();
        m476r();
    }

    public void setContainer(@NonNull ConstraintWidgetContainer constraintWidgetContainer) {
        this.f2420T = constraintWidgetContainer;
    }

    public void setFlags(int i) {
        this.f2438l0 = i;
    }

    public void setHorizontalGaps(float f) {
        if (f < RecyclerView.f7068F0 || this.f2427a0 == f) {
            return;
        }
        this.f2427a0 = f;
    }

    public void setOrientation(int i) {
        if ((i != 0 && i != 1) || this.f2433g0 == i) {
            return;
        }
        this.f2433g0 = i;
    }

    public void setRowWeights(@NonNull String str) {
        String str2 = this.f2429c0;
        if (str2 != null && str2.equals(str)) {
            return;
        }
        this.f2429c0 = str;
    }

    public void setRows(int i) {
        if (i > 50 || this.f2424X == i) {
            return;
        }
        this.f2424X = i;
        m479v();
        m476r();
    }

    public void setSkips(@NonNull String str) {
        String str2 = this.f2432f0;
        if (str2 != null && str2.equals(str)) {
            return;
        }
        this.f2422V = false;
        this.f2432f0 = str;
    }

    public void setSpans(@NonNull CharSequence charSequence) {
        String str = this.f2431e0;
        if (str != null && str.equals(charSequence.toString())) {
            return;
        }
        this.f2422V = false;
        this.f2431e0 = charSequence.toString();
    }

    public void setVerticalGaps(float f) {
        if (f < RecyclerView.f7068F0 || this.f2428b0 == f) {
            return;
        }
        this.f2428b0 = f;
    }

    /* renamed from: t */
    public final int[][] m478t(String str, boolean z) {
        try {
            String[] split = str.split(",");
            Arrays.sort(split, new C0556bg(12));
            int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, split.length, 3);
            if (this.f2423W != 1 && this.f2425Y != 1) {
                for (int i = 0; i < split.length; i++) {
                    String[] split2 = split[i].trim().split(":");
                    String[] split3 = split2[1].split("x");
                    iArr[i][0] = Integer.parseInt(split2[0]);
                    if ((this.f2438l0 & 1) > 0) {
                        iArr[i][1] = Integer.parseInt(split3[1]);
                        iArr[i][2] = Integer.parseInt(split3[0]);
                    } else {
                        iArr[i][1] = Integer.parseInt(split3[0]);
                        iArr[i][2] = Integer.parseInt(split3[1]);
                    }
                }
                return iArr;
            }
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < split.length; i4++) {
                String[] split4 = split[i4].trim().split(":");
                iArr[i4][0] = Integer.parseInt(split4[0]);
                int[] iArr2 = iArr[i4];
                iArr2[1] = 1;
                iArr2[2] = 1;
                if (this.f2425Y == 1) {
                    iArr2[1] = Integer.parseInt(split4[1]);
                    i2 += iArr[i4][1];
                    if (z) {
                        i2--;
                    }
                }
                if (this.f2423W == 1) {
                    iArr[i4][2] = Integer.parseInt(split4[1]);
                    i3 += iArr[i4][2];
                    if (z) {
                        i3--;
                    }
                }
            }
            if (i2 != 0 && !this.f2422V) {
                setRows(this.f2423W + i2);
            }
            if (i3 != 0 && !this.f2422V) {
                setColumns(this.f2425Y + i3);
            }
            this.f2422V = true;
            return iArr;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: v */
    public final void m479v() {
        int i;
        int i2 = this.f2424X;
        if (i2 != 0 && (i = this.f2426Z) != 0) {
            this.f2423W = i2;
            this.f2425Y = i;
            return;
        }
        int i3 = this.f2426Z;
        if (i3 > 0) {
            this.f2425Y = i3;
            this.f2423W = ((this.mWidgetsCount + i3) - 1) / i3;
        } else if (i2 > 0) {
            this.f2423W = i2;
            this.f2425Y = ((this.mWidgetsCount + i2) - 1) / i2;
        } else {
            int sqrt = (int) (Math.sqrt(this.mWidgetsCount) + 1.5d);
            this.f2423W = sqrt;
            this.f2425Y = ((this.mWidgetsCount + sqrt) - 1) / sqrt;
        }
    }

    public GridCore(int i, int i2) {
        this.f2424X = i;
        this.f2426Z = i2;
        if (i > 50) {
            this.f2424X = 3;
        }
        if (i2 > 50) {
            this.f2426Z = 3;
        }
        m479v();
        m475q();
    }
}
