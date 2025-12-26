package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public class Flow extends VirtualLayout {
    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_CHAIN_NEW = 3;
    public static final int WRAP_NONE = 0;

    /* renamed from: q0 */
    public ConstraintWidget[] f2541q0;

    /* renamed from: T */
    public int f2518T = -1;

    /* renamed from: U */
    public int f2519U = -1;

    /* renamed from: V */
    public int f2520V = -1;

    /* renamed from: W */
    public int f2521W = -1;

    /* renamed from: X */
    public int f2522X = -1;

    /* renamed from: Y */
    public int f2523Y = -1;

    /* renamed from: Z */
    public float f2524Z = 0.5f;

    /* renamed from: a0 */
    public float f2525a0 = 0.5f;

    /* renamed from: b0 */
    public float f2526b0 = 0.5f;

    /* renamed from: c0 */
    public float f2527c0 = 0.5f;

    /* renamed from: d0 */
    public float f2528d0 = 0.5f;

    /* renamed from: e0 */
    public float f2529e0 = 0.5f;

    /* renamed from: f0 */
    public int f2530f0 = 0;

    /* renamed from: g0 */
    public int f2531g0 = 0;

    /* renamed from: h0 */
    public int f2532h0 = 2;

    /* renamed from: i0 */
    public int f2533i0 = 2;

    /* renamed from: j0 */
    public int f2534j0 = 0;

    /* renamed from: k0 */
    public int f2535k0 = -1;

    /* renamed from: l0 */
    public int f2536l0 = 0;

    /* renamed from: m0 */
    public final ArrayList f2537m0 = new ArrayList();

    /* renamed from: n0 */
    public ConstraintWidget[] f2538n0 = null;

    /* renamed from: o0 */
    public ConstraintWidget[] f2539o0 = null;

    /* renamed from: p0 */
    public int[] f2540p0 = null;

    /* renamed from: r0 */
    public int f2542r0 = 0;

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem, boolean z) {
        boolean z2;
        boolean z3;
        ConstraintWidget constraintWidget;
        float f;
        int i;
        boolean z4;
        super.addToSolver(linearSystem, z);
        if (getParent() != null && ((ConstraintWidgetContainer) getParent()).isRtl()) {
            z2 = true;
        } else {
            z2 = false;
        }
        int i2 = this.f2534j0;
        ArrayList arrayList = this.f2537m0;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        int size = arrayList.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            C0123b c0123b = (C0123b) arrayList.get(i3);
                            if (i3 == size - 1) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            c0123b.m526b(z2, i3, z4);
                        }
                    }
                } else if (this.f2540p0 != null && this.f2539o0 != null && this.f2538n0 != null) {
                    for (int i4 = 0; i4 < this.f2542r0; i4++) {
                        this.f2541q0[i4].resetAnchors();
                    }
                    int[] iArr = this.f2540p0;
                    int i5 = iArr[0];
                    int i6 = iArr[1];
                    float f2 = this.f2524Z;
                    ConstraintWidget constraintWidget2 = null;
                    int i7 = 0;
                    while (i7 < i5) {
                        if (z2) {
                            i = (i5 - i7) - 1;
                            f = 1.0f - this.f2524Z;
                        } else {
                            f = f2;
                            i = i7;
                        }
                        ConstraintWidget constraintWidget3 = this.f2539o0[i];
                        if (constraintWidget3 != null && constraintWidget3.getVisibility() != 8) {
                            if (i7 == 0) {
                                constraintWidget3.connect(constraintWidget3.mLeft, this.mLeft, getPaddingLeft());
                                constraintWidget3.setHorizontalChainStyle(this.f2518T);
                                constraintWidget3.setHorizontalBiasPercent(f);
                            }
                            if (i7 == i5 - 1) {
                                constraintWidget3.connect(constraintWidget3.mRight, this.mRight, getPaddingRight());
                            }
                            if (i7 > 0 && constraintWidget2 != null) {
                                constraintWidget3.connect(constraintWidget3.mLeft, constraintWidget2.mRight, this.f2530f0);
                                constraintWidget2.connect(constraintWidget2.mRight, constraintWidget3.mLeft, 0);
                            }
                            constraintWidget2 = constraintWidget3;
                        }
                        i7++;
                        f2 = f;
                    }
                    for (int i8 = 0; i8 < i6; i8++) {
                        ConstraintWidget constraintWidget4 = this.f2538n0[i8];
                        if (constraintWidget4 != null && constraintWidget4.getVisibility() != 8) {
                            if (i8 == 0) {
                                constraintWidget4.connect(constraintWidget4.mTop, this.mTop, getPaddingTop());
                                constraintWidget4.setVerticalChainStyle(this.f2519U);
                                constraintWidget4.setVerticalBiasPercent(this.f2525a0);
                            }
                            if (i8 == i6 - 1) {
                                constraintWidget4.connect(constraintWidget4.mBottom, this.mBottom, getPaddingBottom());
                            }
                            if (i8 > 0 && constraintWidget2 != null) {
                                constraintWidget4.connect(constraintWidget4.mTop, constraintWidget2.mBottom, this.f2531g0);
                                constraintWidget2.connect(constraintWidget2.mBottom, constraintWidget4.mTop, 0);
                            }
                            constraintWidget2 = constraintWidget4;
                        }
                    }
                    for (int i9 = 0; i9 < i5; i9++) {
                        for (int i10 = 0; i10 < i6; i10++) {
                            int i11 = (i10 * i5) + i9;
                            if (this.f2536l0 == 1) {
                                i11 = (i9 * i6) + i10;
                            }
                            ConstraintWidget[] constraintWidgetArr = this.f2541q0;
                            if (i11 < constraintWidgetArr.length && (constraintWidget = constraintWidgetArr[i11]) != null && constraintWidget.getVisibility() != 8) {
                                ConstraintWidget constraintWidget5 = this.f2539o0[i9];
                                ConstraintWidget constraintWidget6 = this.f2538n0[i10];
                                if (constraintWidget != constraintWidget5) {
                                    constraintWidget.connect(constraintWidget.mLeft, constraintWidget5.mLeft, 0);
                                    constraintWidget.connect(constraintWidget.mRight, constraintWidget5.mRight, 0);
                                }
                                if (constraintWidget != constraintWidget6) {
                                    constraintWidget.connect(constraintWidget.mTop, constraintWidget6.mTop, 0);
                                    constraintWidget.connect(constraintWidget.mBottom, constraintWidget6.mBottom, 0);
                                }
                            }
                        }
                    }
                }
            } else {
                int size2 = arrayList.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    C0123b c0123b2 = (C0123b) arrayList.get(i12);
                    if (i12 == size2 - 1) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    c0123b2.m526b(z2, i12, z3);
                }
            }
        } else if (arrayList.size() > 0) {
            ((C0123b) arrayList.get(0)).m526b(z2, 0, true);
        }
        needsCallbackFromSolver(false);
    }

    @Override // androidx.constraintlayout.core.widgets.HelperWidget, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        Flow flow = (Flow) constraintWidget;
        this.f2518T = flow.f2518T;
        this.f2519U = flow.f2519U;
        this.f2520V = flow.f2520V;
        this.f2521W = flow.f2521W;
        this.f2522X = flow.f2522X;
        this.f2523Y = flow.f2523Y;
        this.f2524Z = flow.f2524Z;
        this.f2525a0 = flow.f2525a0;
        this.f2526b0 = flow.f2526b0;
        this.f2527c0 = flow.f2527c0;
        this.f2528d0 = flow.f2528d0;
        this.f2529e0 = flow.f2529e0;
        this.f2530f0 = flow.f2530f0;
        this.f2531g0 = flow.f2531g0;
        this.f2532h0 = flow.f2532h0;
        this.f2533i0 = flow.f2533i0;
        this.f2534j0 = flow.f2534j0;
        this.f2535k0 = flow.f2535k0;
        this.f2536l0 = flow.f2536l0;
    }

    public float getMaxElementsWrap() {
        return this.f2535k0;
    }

    /* renamed from: k */
    public final int m499k(ConstraintWidget constraintWidget, int i) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i2 = constraintWidget.mMatchConstraintDefaultHeight;
            if (i2 == 0) {
                return 0;
            }
            if (i2 == 2) {
                int i3 = (int) (constraintWidget.mMatchConstraintPercentHeight * i);
                if (i3 != constraintWidget.getHeight()) {
                    constraintWidget.setMeasureRequested(true);
                    measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i3);
                }
                return i3;
            }
            if (i2 == 1) {
                return constraintWidget.getHeight();
            }
            if (i2 == 3) {
                return (int) ((constraintWidget.getWidth() * constraintWidget.mDimensionRatio) + 0.5f);
            }
        }
        return constraintWidget.getHeight();
    }

    /* renamed from: l */
    public final int m500l(ConstraintWidget constraintWidget, int i) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i2 = constraintWidget.mMatchConstraintDefaultWidth;
            if (i2 == 0) {
                return 0;
            }
            if (i2 == 2) {
                int i3 = (int) (constraintWidget.mMatchConstraintPercentWidth * i);
                if (i3 != constraintWidget.getWidth()) {
                    constraintWidget.setMeasureRequested(true);
                    measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i3, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                }
                return i3;
            }
            if (i2 == 1) {
                return constraintWidget.getWidth();
            }
            if (i2 == 3) {
                return (int) ((constraintWidget.getHeight() * constraintWidget.mDimensionRatio) + 0.5f);
            }
        }
        return constraintWidget.getWidth();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0702  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0720  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0722  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0705  */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v76 */
    /* JADX WARN: Type inference failed for: r2v8 */
    @Override // androidx.constraintlayout.core.widgets.VirtualLayout
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void measure(int i, int i2, int i3, int i4) {
        int i5;
        int[] iArr;
        int i6;
        int i7;
        C0123b c0123b;
        int i8;
        ?? r2;
        int i9;
        int i10;
        boolean z;
        int i11;
        int i12;
        boolean z2;
        int i13;
        boolean z3;
        int i14;
        ArrayList arrayList;
        boolean z4;
        int i15;
        ConstraintWidget constraintWidget;
        int i16;
        int i17;
        int i18;
        boolean z5;
        ConstraintWidget constraintWidget2;
        int i19;
        boolean z6;
        int i20;
        int i21;
        boolean z7;
        ArrayList arrayList2;
        int paddingRight;
        int i22;
        ArrayList arrayList3;
        boolean z8;
        int i23;
        ConstraintWidget constraintWidget3;
        int i24;
        if (this.mWidgetsCount > 0 && !measureChildren()) {
            setMeasure(0, 0);
            needsCallbackFromSolver(false);
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingRight2 = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int[] iArr2 = new int[2];
        int i25 = (i2 - paddingLeft) - paddingRight2;
        int i26 = this.f2536l0;
        if (i26 == 1) {
            i25 = (i4 - paddingTop) - paddingBottom;
        }
        int i27 = i25;
        if (i26 == 0) {
            if (this.f2518T == -1) {
                this.f2518T = 0;
            }
            if (this.f2519U == -1) {
                this.f2519U = 0;
            }
        } else {
            if (this.f2518T == -1) {
                this.f2518T = 0;
            }
            if (this.f2519U == -1) {
                this.f2519U = 0;
            }
        }
        ConstraintWidget[] constraintWidgetArr = this.mWidgets;
        int i28 = 0;
        int i29 = 0;
        while (true) {
            i5 = this.mWidgetsCount;
            if (i28 >= i5) {
                break;
            }
            if (this.mWidgets[i28].getVisibility() == 8) {
                i29++;
            }
            i28++;
        }
        if (i29 > 0) {
            constraintWidgetArr = new ConstraintWidget[i5 - i29];
            i5 = 0;
            for (int i30 = 0; i30 < this.mWidgetsCount; i30++) {
                ConstraintWidget constraintWidget4 = this.mWidgets[i30];
                if (constraintWidget4.getVisibility() != 8) {
                    constraintWidgetArr[i5] = constraintWidget4;
                    i5++;
                }
            }
        }
        ConstraintWidget[] constraintWidgetArr2 = constraintWidgetArr;
        this.f2541q0 = constraintWidgetArr2;
        this.f2542r0 = i5;
        int i31 = this.f2534j0;
        ArrayList arrayList4 = this.f2537m0;
        if (i31 != 0) {
            if (i31 != 1) {
                if (i31 != 2) {
                    if (i31 != 3) {
                        r2 = 1;
                        iArr = iArr2;
                        i6 = paddingLeft;
                        i7 = paddingRight2;
                        i8 = 0;
                    } else {
                        int i32 = this.f2536l0;
                        if (i5 == 0) {
                            iArr = iArr2;
                            i6 = paddingLeft;
                            i7 = paddingRight2;
                        } else {
                            arrayList4.clear();
                            ArrayList arrayList5 = arrayList4;
                            int i33 = i5;
                            int i34 = i27;
                            boolean z9 = true;
                            iArr = iArr2;
                            C0123b c0123b2 = new C0123b(this, i32, this.mLeft, this.mTop, this.mRight, this.mBottom, i34);
                            arrayList5.add(c0123b2);
                            if (i32 == 0) {
                                C0123b c0123b3 = c0123b2;
                                int i35 = 0;
                                i19 = 0;
                                int i36 = 0;
                                int i37 = 0;
                                while (i37 < i33) {
                                    int i38 = i35 + 1;
                                    ConstraintWidget constraintWidget5 = constraintWidgetArr2[i37];
                                    int i39 = i34;
                                    int m500l = m500l(constraintWidget5, i39);
                                    if (constraintWidget5.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                                        i19++;
                                    }
                                    int i40 = i19;
                                    if ((i36 == i39 || this.f2530f0 + i36 + m500l > i39) && c0123b3.f2596b != null) {
                                        z8 = z9;
                                    } else {
                                        z8 = false;
                                    }
                                    if (!z8 && i37 > 0 && (i24 = this.f2535k0) > 0 && i38 > i24) {
                                        z8 = z9;
                                    }
                                    if (z8) {
                                        i34 = i39;
                                        i23 = paddingRight2;
                                        constraintWidget3 = constraintWidget5;
                                        C0123b c0123b4 = new C0123b(this, i32, this.mLeft, this.mTop, this.mRight, this.mBottom, i34);
                                        c0123b4.f2608n = i37;
                                        arrayList5.add(c0123b4);
                                        c0123b3 = c0123b4;
                                        i36 = m500l;
                                        i35 = 1;
                                    } else {
                                        i34 = i39;
                                        i23 = paddingRight2;
                                        constraintWidget3 = constraintWidget5;
                                        if (i37 > 0) {
                                            i36 = this.f2530f0 + m500l + i36;
                                            i35 = i38;
                                        } else {
                                            i35 = i38;
                                            i36 = m500l;
                                        }
                                    }
                                    c0123b3.m525a(constraintWidget3);
                                    i37++;
                                    i19 = i40;
                                    paddingRight2 = i23;
                                    z9 = true;
                                }
                                i7 = paddingRight2;
                            } else {
                                i7 = paddingRight2;
                                C0123b c0123b5 = c0123b2;
                                int i41 = 0;
                                i19 = 0;
                                int i42 = 0;
                                int i43 = 0;
                                while (i43 < i33) {
                                    int i44 = i41 + 1;
                                    ConstraintWidget constraintWidget6 = constraintWidgetArr2[i43];
                                    int i45 = i34;
                                    int m499k = m499k(constraintWidget6, i45);
                                    if (constraintWidget6.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                                        i19++;
                                    }
                                    int i46 = i19;
                                    if ((i42 == i45 || this.f2531g0 + i42 + m499k > i45) && c0123b5.f2596b != null) {
                                        z6 = true;
                                    } else {
                                        z6 = false;
                                    }
                                    if (!z6 && i43 > 0 && (i21 = this.f2535k0) > 0 && i44 > i21) {
                                        z6 = true;
                                    }
                                    if (z6) {
                                        i20 = paddingLeft;
                                        C0123b c0123b6 = new C0123b(this, i32, this.mLeft, this.mTop, this.mRight, this.mBottom, i45);
                                        c0123b6.f2608n = i43;
                                        arrayList5.add(c0123b6);
                                        c0123b5 = c0123b6;
                                        i42 = m499k;
                                        i41 = 1;
                                    } else {
                                        i20 = paddingLeft;
                                        if (i43 > 0) {
                                            i42 = this.f2531g0 + m499k + i42;
                                            i41 = i44;
                                        } else {
                                            i41 = i44;
                                            i42 = m499k;
                                        }
                                    }
                                    c0123b5.m525a(constraintWidget6);
                                    i43++;
                                    i19 = i46;
                                    paddingLeft = i20;
                                    i34 = i45;
                                }
                            }
                            int i47 = i34;
                            i6 = paddingLeft;
                            int size = arrayList5.size();
                            ConstraintAnchor constraintAnchor = this.mLeft;
                            ConstraintAnchor constraintAnchor2 = this.mTop;
                            ConstraintAnchor constraintAnchor3 = this.mRight;
                            ConstraintAnchor constraintAnchor4 = this.mBottom;
                            int paddingLeft2 = getPaddingLeft();
                            int paddingTop2 = getPaddingTop();
                            int paddingRight3 = getPaddingRight();
                            int paddingBottom2 = getPaddingBottom();
                            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = getHorizontalDimensionBehaviour();
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                            if (horizontalDimensionBehaviour != dimensionBehaviour && getVerticalDimensionBehaviour() != dimensionBehaviour) {
                                z7 = false;
                            } else {
                                z7 = true;
                            }
                            if (i19 > 0 && z7) {
                                for (int i48 = 0; i48 < size; i48++) {
                                    C0123b c0123b7 = (C0123b) arrayList5.get(i48);
                                    if (i32 == 0) {
                                        c0123b7.m529e(i47 - c0123b7.m528d());
                                    } else {
                                        c0123b7.m529e(i47 - c0123b7.m527c());
                                    }
                                }
                            }
                            int i49 = 0;
                            int i50 = 0;
                            int i51 = 0;
                            while (i49 < size) {
                                C0123b c0123b8 = (C0123b) arrayList5.get(i49);
                                if (i32 == 0) {
                                    if (i49 < size - 1) {
                                        constraintAnchor4 = ((C0123b) arrayList5.get(i49 + 1)).f2596b.mTop;
                                        arrayList3 = arrayList5;
                                        paddingBottom2 = 0;
                                    } else {
                                        constraintAnchor4 = this.mBottom;
                                        paddingBottom2 = getPaddingBottom();
                                        arrayList3 = arrayList5;
                                    }
                                    ConstraintAnchor constraintAnchor5 = c0123b8.f2596b.mBottom;
                                    c0123b8.m530f(i32, constraintAnchor, constraintAnchor2, constraintAnchor3, constraintAnchor4, paddingLeft2, paddingTop2, paddingRight3, paddingBottom2, i47);
                                    int max = Math.max(i50, c0123b8.m528d());
                                    int m527c = c0123b8.m527c() + i51;
                                    if (i49 > 0) {
                                        m527c += this.f2531g0;
                                    }
                                    i50 = max;
                                    i51 = m527c;
                                    constraintAnchor2 = constraintAnchor5;
                                    paddingTop2 = 0;
                                    paddingRight = paddingRight3;
                                    arrayList2 = arrayList3;
                                    i22 = size;
                                } else {
                                    ArrayList arrayList6 = arrayList5;
                                    if (i49 < size - 1) {
                                        arrayList2 = arrayList6;
                                        constraintAnchor3 = ((C0123b) arrayList2.get(i49 + 1)).f2596b.mLeft;
                                        i22 = size;
                                        paddingRight = 0;
                                    } else {
                                        arrayList2 = arrayList6;
                                        constraintAnchor3 = this.mRight;
                                        paddingRight = getPaddingRight();
                                        i22 = size;
                                    }
                                    ConstraintAnchor constraintAnchor6 = c0123b8.f2596b.mRight;
                                    c0123b8.m530f(i32, constraintAnchor, constraintAnchor2, constraintAnchor3, constraintAnchor4, paddingLeft2, paddingTop2, paddingRight, paddingBottom2, i47);
                                    int m528d = c0123b8.m528d() + i50;
                                    int max2 = Math.max(i51, c0123b8.m527c());
                                    if (i49 > 0) {
                                        m528d += this.f2530f0;
                                    }
                                    i50 = m528d;
                                    i51 = max2;
                                    paddingLeft2 = 0;
                                    constraintAnchor = constraintAnchor6;
                                }
                                i49++;
                                size = i22;
                                int i52 = paddingRight;
                                arrayList5 = arrayList2;
                                paddingRight3 = i52;
                            }
                            iArr[0] = i50;
                            iArr[1] = i51;
                        }
                    }
                } else {
                    int i53 = i5;
                    iArr = iArr2;
                    i6 = paddingLeft;
                    i7 = paddingRight2;
                    int i54 = this.f2536l0;
                    if (i54 == 0) {
                        int i55 = this.f2535k0;
                        if (i55 <= 0) {
                            int i56 = 0;
                            i18 = 0;
                            for (int i57 = 0; i57 < i53; i57++) {
                                if (i57 > 0) {
                                    i56 += this.f2530f0;
                                }
                                ConstraintWidget constraintWidget7 = constraintWidgetArr2[i57];
                                if (constraintWidget7 != null) {
                                    int m500l2 = m500l(constraintWidget7, i27) + i56;
                                    if (m500l2 > i27) {
                                        break;
                                    }
                                    i18++;
                                    i56 = m500l2;
                                }
                            }
                        } else {
                            i18 = i55;
                        }
                        i17 = 0;
                    } else {
                        i17 = this.f2535k0;
                        if (i17 <= 0) {
                            int i58 = 0;
                            int i59 = 0;
                            for (int i60 = 0; i60 < i53; i60++) {
                                if (i60 > 0) {
                                    i58 += this.f2531g0;
                                }
                                ConstraintWidget constraintWidget8 = constraintWidgetArr2[i60];
                                if (constraintWidget8 != null) {
                                    int m499k2 = m499k(constraintWidget8, i27) + i58;
                                    if (m499k2 > i27) {
                                        break;
                                    }
                                    i59++;
                                    i58 = m499k2;
                                }
                            }
                            i17 = i59;
                        }
                        i18 = 0;
                    }
                    if (this.f2540p0 == null) {
                        this.f2540p0 = new int[2];
                    }
                    if ((i17 == 0 && i54 == 1) || (i18 == 0 && i54 == 0)) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    while (!z5) {
                        if (i54 == 0) {
                            i17 = (int) Math.ceil(i53 / i18);
                        } else {
                            i18 = (int) Math.ceil(i53 / i17);
                        }
                        ConstraintWidget[] constraintWidgetArr3 = this.f2539o0;
                        if (constraintWidgetArr3 != null && constraintWidgetArr3.length >= i18) {
                            Arrays.fill(constraintWidgetArr3, (Object) null);
                        } else {
                            this.f2539o0 = new ConstraintWidget[i18];
                        }
                        ConstraintWidget[] constraintWidgetArr4 = this.f2538n0;
                        if (constraintWidgetArr4 != null && constraintWidgetArr4.length >= i17) {
                            Arrays.fill(constraintWidgetArr4, (Object) null);
                        } else {
                            this.f2538n0 = new ConstraintWidget[i17];
                        }
                        for (int i61 = 0; i61 < i18; i61++) {
                            for (int i62 = 0; i62 < i17; i62++) {
                                int i63 = (i62 * i18) + i61;
                                if (i54 == 1) {
                                    i63 = (i61 * i17) + i62;
                                }
                                if (i63 < constraintWidgetArr2.length && (constraintWidget2 = constraintWidgetArr2[i63]) != null) {
                                    int m500l3 = m500l(constraintWidget2, i27);
                                    ConstraintWidget constraintWidget9 = this.f2539o0[i61];
                                    if (constraintWidget9 == null || constraintWidget9.getWidth() < m500l3) {
                                        this.f2539o0[i61] = constraintWidget2;
                                    }
                                    int m499k3 = m499k(constraintWidget2, i27);
                                    ConstraintWidget constraintWidget10 = this.f2538n0[i62];
                                    if (constraintWidget10 == null || constraintWidget10.getHeight() < m499k3) {
                                        this.f2538n0[i62] = constraintWidget2;
                                    }
                                }
                            }
                        }
                        int i64 = 0;
                        for (int i65 = 0; i65 < i18; i65++) {
                            ConstraintWidget constraintWidget11 = this.f2539o0[i65];
                            if (constraintWidget11 != null) {
                                if (i65 > 0) {
                                    i64 += this.f2530f0;
                                }
                                i64 = m500l(constraintWidget11, i27) + i64;
                            }
                        }
                        int i66 = 0;
                        for (int i67 = 0; i67 < i17; i67++) {
                            ConstraintWidget constraintWidget12 = this.f2538n0[i67];
                            if (constraintWidget12 != null) {
                                if (i67 > 0) {
                                    i66 += this.f2531g0;
                                }
                                i66 = m499k(constraintWidget12, i27) + i66;
                            }
                        }
                        iArr[0] = i64;
                        iArr[1] = i66;
                        if (i54 == 0) {
                            if (i64 > i27 && i18 > 1) {
                                i18--;
                            }
                            z5 = true;
                        } else {
                            if (i66 > i27 && i17 > 1) {
                                i17--;
                            }
                            z5 = true;
                        }
                    }
                    int[] iArr3 = this.f2540p0;
                    iArr3[0] = i18;
                    iArr3[1] = i17;
                }
            } else {
                ArrayList arrayList7 = arrayList4;
                int i68 = i5;
                iArr = iArr2;
                i6 = paddingLeft;
                i7 = paddingRight2;
                int i69 = this.f2536l0;
                if (i68 != 0) {
                    arrayList7.clear();
                    C0123b c0123b9 = new C0123b(this, i69, this.mLeft, this.mTop, this.mRight, this.mBottom, i27);
                    arrayList7.add(c0123b9);
                    if (i69 == 0) {
                        i12 = 0;
                        int i70 = 0;
                        int i71 = 0;
                        while (i71 < i68) {
                            ConstraintWidget constraintWidget13 = constraintWidgetArr2[i71];
                            int m500l4 = m500l(constraintWidget13, i27);
                            if (constraintWidget13.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                                i12++;
                            }
                            int i72 = i12;
                            if ((i70 == i27 || this.f2530f0 + i70 + m500l4 > i27) && c0123b9.f2596b != null) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (!z4 && i71 > 0 && (i16 = this.f2535k0) > 0 && i71 % i16 == 0) {
                                z4 = true;
                            }
                            if (z4) {
                                int i73 = i69;
                                i15 = i69;
                                constraintWidget = constraintWidget13;
                                c0123b9 = new C0123b(this, i73, this.mLeft, this.mTop, this.mRight, this.mBottom, i27);
                                c0123b9.f2608n = i71;
                                arrayList7.add(c0123b9);
                            } else {
                                i15 = i69;
                                constraintWidget = constraintWidget13;
                                if (i71 > 0) {
                                    i70 = this.f2530f0 + m500l4 + i70;
                                    c0123b9.m525a(constraintWidget);
                                    i71++;
                                    i12 = i72;
                                    i69 = i15;
                                }
                            }
                            i70 = m500l4;
                            c0123b9.m525a(constraintWidget);
                            i71++;
                            i12 = i72;
                            i69 = i15;
                        }
                        i11 = i69;
                    } else {
                        i11 = i69;
                        i12 = 0;
                        int i74 = 0;
                        int i75 = 0;
                        while (i75 < i68) {
                            ConstraintWidget constraintWidget14 = constraintWidgetArr2[i75];
                            int m499k4 = m499k(constraintWidget14, i27);
                            if (constraintWidget14.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                                i12++;
                            }
                            int i76 = i12;
                            if ((i74 == i27 || this.f2531g0 + i74 + m499k4 > i27) && c0123b9.f2596b != null) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (!z2 && i75 > 0 && (i13 = this.f2535k0) > 0 && i75 % i13 == 0) {
                                z2 = true;
                            }
                            if (z2) {
                                c0123b9 = new C0123b(this, i11, this.mLeft, this.mTop, this.mRight, this.mBottom, i27);
                                c0123b9.f2608n = i75;
                                arrayList7.add(c0123b9);
                            } else if (i75 > 0) {
                                i74 = this.f2531g0 + m499k4 + i74;
                                c0123b9.m525a(constraintWidget14);
                                i75++;
                                i12 = i76;
                            }
                            i74 = m499k4;
                            c0123b9.m525a(constraintWidget14);
                            i75++;
                            i12 = i76;
                        }
                    }
                    int size2 = arrayList7.size();
                    ConstraintAnchor constraintAnchor7 = this.mLeft;
                    ConstraintAnchor constraintAnchor8 = this.mTop;
                    ConstraintAnchor constraintAnchor9 = this.mRight;
                    ConstraintAnchor constraintAnchor10 = this.mBottom;
                    int paddingLeft3 = getPaddingLeft();
                    int paddingTop3 = getPaddingTop();
                    int paddingRight4 = getPaddingRight();
                    int paddingBottom3 = getPaddingBottom();
                    ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour2 = getHorizontalDimensionBehaviour();
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    if (horizontalDimensionBehaviour2 != dimensionBehaviour2 && getVerticalDimensionBehaviour() != dimensionBehaviour2) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (i12 > 0 && z3) {
                        for (int i77 = 0; i77 < size2; i77++) {
                            C0123b c0123b10 = (C0123b) arrayList7.get(i77);
                            if (i11 == 0) {
                                c0123b10.m529e(i27 - c0123b10.m528d());
                            } else {
                                c0123b10.m529e(i27 - c0123b10.m527c());
                            }
                        }
                    }
                    int i78 = 0;
                    int i79 = 0;
                    int i80 = 0;
                    while (i78 < size2) {
                        C0123b c0123b11 = (C0123b) arrayList7.get(i78);
                        if (i11 == 0) {
                            if (i78 < size2 - 1) {
                                constraintAnchor10 = ((C0123b) arrayList7.get(i78 + 1)).f2596b.mTop;
                                arrayList = arrayList7;
                                paddingBottom3 = 0;
                            } else {
                                constraintAnchor10 = this.mBottom;
                                paddingBottom3 = getPaddingBottom();
                                arrayList = arrayList7;
                            }
                            ConstraintAnchor constraintAnchor11 = c0123b11.f2596b.mBottom;
                            c0123b11.m530f(i11, constraintAnchor7, constraintAnchor8, constraintAnchor9, constraintAnchor10, paddingLeft3, paddingTop3, paddingRight4, paddingBottom3, i27);
                            int max3 = Math.max(i79, c0123b11.m528d());
                            int m527c2 = c0123b11.m527c() + i80;
                            if (i78 > 0) {
                                m527c2 += this.f2531g0;
                            }
                            i79 = max3;
                            i80 = m527c2;
                            constraintAnchor8 = constraintAnchor11;
                            arrayList7 = arrayList;
                            paddingTop3 = 0;
                            i14 = size2;
                        } else {
                            ArrayList arrayList8 = arrayList7;
                            if (i78 < size2 - 1) {
                                arrayList7 = arrayList8;
                                constraintAnchor9 = ((C0123b) arrayList7.get(i78 + 1)).f2596b.mLeft;
                                i14 = size2;
                                paddingRight4 = 0;
                            } else {
                                arrayList7 = arrayList8;
                                constraintAnchor9 = this.mRight;
                                paddingRight4 = getPaddingRight();
                                i14 = size2;
                            }
                            ConstraintAnchor constraintAnchor12 = c0123b11.f2596b.mRight;
                            c0123b11.m530f(i11, constraintAnchor7, constraintAnchor8, constraintAnchor9, constraintAnchor10, paddingLeft3, paddingTop3, paddingRight4, paddingBottom3, i27);
                            int m528d2 = c0123b11.m528d() + i79;
                            int max4 = Math.max(i80, c0123b11.m527c());
                            if (i78 > 0) {
                                m528d2 += this.f2530f0;
                            }
                            i79 = m528d2;
                            i80 = max4;
                            paddingLeft3 = 0;
                            constraintAnchor7 = constraintAnchor12;
                        }
                        i78++;
                        size2 = i14;
                    }
                    iArr[0] = i79;
                    iArr[1] = i80;
                }
            }
            i8 = 0;
            r2 = 1;
        } else {
            int i81 = i5;
            iArr = iArr2;
            i6 = paddingLeft;
            i7 = paddingRight2;
            int i82 = this.f2536l0;
            if (i81 != 0) {
                if (arrayList4.size() == 0) {
                    c0123b = new C0123b(this, i82, this.mLeft, this.mTop, this.mRight, this.mBottom, i27);
                    arrayList4.add(c0123b);
                } else {
                    c0123b = (C0123b) arrayList4.get(0);
                    c0123b.f2597c = 0;
                    c0123b.f2596b = null;
                    c0123b.f2606l = 0;
                    c0123b.f2607m = 0;
                    c0123b.f2608n = 0;
                    c0123b.f2609o = 0;
                    c0123b.f2610p = 0;
                    c0123b.m530f(i82, this.mLeft, this.mTop, this.mRight, this.mBottom, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom(), i27);
                }
                for (int i83 = 0; i83 < i81; i83++) {
                    c0123b.m525a(constraintWidgetArr2[i83]);
                }
                i8 = 0;
                iArr[0] = c0123b.m528d();
                r2 = 1;
                iArr[1] = c0123b.m527c();
            }
            i8 = 0;
            r2 = 1;
        }
        int i84 = iArr[i8] + i6 + i7;
        int i85 = iArr[r2] + paddingTop + paddingBottom;
        boolean z10 = r2;
        if (i == 1073741824) {
            i84 = i2;
        } else if (i == Integer.MIN_VALUE) {
            i84 = Math.min(i84, i2);
        } else if (i != 0) {
            i9 = i3;
            i84 = i8;
            if (i9 != 1073741824) {
                i10 = i4;
            } else if (i9 == Integer.MIN_VALUE) {
                i10 = Math.min(i85, i4);
            } else if (i9 == 0) {
                i10 = i85;
            } else {
                i10 = i8;
            }
            setMeasure(i84, i10);
            setWidth(i84);
            setHeight(i10);
            if (this.mWidgetsCount <= 0) {
                z = z10;
            } else {
                z = i8;
            }
            needsCallbackFromSolver(z);
        }
        i9 = i3;
        if (i9 != 1073741824) {
        }
        setMeasure(i84, i10);
        setWidth(i84);
        setHeight(i10);
        if (this.mWidgetsCount <= 0) {
        }
        needsCallbackFromSolver(z);
    }

    public void setFirstHorizontalBias(float f) {
        this.f2526b0 = f;
    }

    public void setFirstHorizontalStyle(int i) {
        this.f2520V = i;
    }

    public void setFirstVerticalBias(float f) {
        this.f2527c0 = f;
    }

    public void setFirstVerticalStyle(int i) {
        this.f2521W = i;
    }

    public void setHorizontalAlign(int i) {
        this.f2532h0 = i;
    }

    public void setHorizontalBias(float f) {
        this.f2524Z = f;
    }

    public void setHorizontalGap(int i) {
        this.f2530f0 = i;
    }

    public void setHorizontalStyle(int i) {
        this.f2518T = i;
    }

    public void setLastHorizontalBias(float f) {
        this.f2528d0 = f;
    }

    public void setLastHorizontalStyle(int i) {
        this.f2522X = i;
    }

    public void setLastVerticalBias(float f) {
        this.f2529e0 = f;
    }

    public void setLastVerticalStyle(int i) {
        this.f2523Y = i;
    }

    public void setMaxElementsWrap(int i) {
        this.f2535k0 = i;
    }

    public void setOrientation(int i) {
        this.f2536l0 = i;
    }

    public void setVerticalAlign(int i) {
        this.f2533i0 = i;
    }

    public void setVerticalBias(float f) {
        this.f2525a0 = f;
    }

    public void setVerticalGap(int i) {
        this.f2531g0 = i;
    }

    public void setVerticalStyle(int i) {
        this.f2519U = i;
    }

    public void setWrapMode(int i) {
        this.f2534j0 = i;
    }
}
