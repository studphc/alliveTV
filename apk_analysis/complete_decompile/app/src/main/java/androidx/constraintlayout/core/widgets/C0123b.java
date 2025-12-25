package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* renamed from: androidx.constraintlayout.core.widgets.b */
/* loaded from: classes.dex */
public final class C0123b {

    /* renamed from: a */
    public int f2595a;

    /* renamed from: d */
    public ConstraintAnchor f2598d;

    /* renamed from: e */
    public ConstraintAnchor f2599e;

    /* renamed from: f */
    public ConstraintAnchor f2600f;

    /* renamed from: g */
    public ConstraintAnchor f2601g;

    /* renamed from: h */
    public int f2602h;

    /* renamed from: i */
    public int f2603i;

    /* renamed from: j */
    public int f2604j;

    /* renamed from: k */
    public int f2605k;

    /* renamed from: q */
    public int f2611q;

    /* renamed from: r */
    public final /* synthetic */ Flow f2612r;

    /* renamed from: b */
    public ConstraintWidget f2596b = null;

    /* renamed from: c */
    public int f2597c = 0;

    /* renamed from: l */
    public int f2606l = 0;

    /* renamed from: m */
    public int f2607m = 0;

    /* renamed from: n */
    public int f2608n = 0;

    /* renamed from: o */
    public int f2609o = 0;

    /* renamed from: p */
    public int f2610p = 0;

    public C0123b(Flow flow, int i, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i2) {
        this.f2612r = flow;
        this.f2602h = 0;
        this.f2603i = 0;
        this.f2604j = 0;
        this.f2605k = 0;
        this.f2611q = 0;
        this.f2595a = i;
        this.f2598d = constraintAnchor;
        this.f2599e = constraintAnchor2;
        this.f2600f = constraintAnchor3;
        this.f2601g = constraintAnchor4;
        this.f2602h = flow.getPaddingLeft();
        this.f2603i = flow.getPaddingTop();
        this.f2604j = flow.getPaddingRight();
        this.f2605k = flow.getPaddingBottom();
        this.f2611q = i2;
    }

    /* renamed from: a */
    public final void m525a(ConstraintWidget constraintWidget) {
        int i = this.f2595a;
        int i2 = 0;
        Flow flow = this.f2612r;
        if (i == 0) {
            int m500l = flow.m500l(constraintWidget, this.f2611q);
            if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                this.f2610p++;
                m500l = 0;
            }
            int i3 = flow.f2530f0;
            if (constraintWidget.getVisibility() != 8) {
                i2 = i3;
            }
            this.f2606l = m500l + i2 + this.f2606l;
            int m499k = flow.m499k(constraintWidget, this.f2611q);
            if (this.f2596b == null || this.f2597c < m499k) {
                this.f2596b = constraintWidget;
                this.f2597c = m499k;
                this.f2607m = m499k;
            }
        } else {
            int m500l2 = flow.m500l(constraintWidget, this.f2611q);
            int m499k2 = flow.m499k(constraintWidget, this.f2611q);
            if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                this.f2610p++;
                m499k2 = 0;
            }
            int i4 = flow.f2531g0;
            if (constraintWidget.getVisibility() != 8) {
                i2 = i4;
            }
            this.f2607m = m499k2 + i2 + this.f2607m;
            if (this.f2596b == null || this.f2597c < m500l2) {
                this.f2596b = constraintWidget;
                this.f2597c = m500l2;
                this.f2606l = m500l2;
            }
        }
        this.f2609o++;
    }

    /* renamed from: b */
    public final void m526b(boolean z, int i, boolean z2) {
        Flow flow;
        boolean z3;
        int i2;
        ConstraintWidget constraintWidget;
        int i3;
        char c;
        float f;
        int i4;
        float f2;
        float f3;
        int i5;
        int i6;
        int i7 = this.f2609o;
        int i8 = 0;
        while (true) {
            flow = this.f2612r;
            if (i8 >= i7) {
                break;
            }
            int i9 = this.f2608n;
            if (i9 + i8 >= flow.f2542r0) {
                break;
            }
            ConstraintWidget constraintWidget2 = flow.f2541q0[i9 + i8];
            if (constraintWidget2 != null) {
                constraintWidget2.resetAnchors();
            }
            i8++;
        }
        if (i7 != 0 && this.f2596b != null) {
            if (z2 && i == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            int i10 = -1;
            int i11 = -1;
            for (int i12 = 0; i12 < i7; i12++) {
                if (z) {
                    i6 = (i7 - 1) - i12;
                } else {
                    i6 = i12;
                }
                int i13 = this.f2608n;
                if (i13 + i6 >= flow.f2542r0) {
                    break;
                }
                ConstraintWidget constraintWidget3 = flow.f2541q0[i13 + i6];
                if (constraintWidget3 != null && constraintWidget3.getVisibility() == 0) {
                    if (i10 == -1) {
                        i10 = i12;
                    }
                    i11 = i12;
                }
            }
            if (this.f2595a == 0) {
                ConstraintWidget constraintWidget4 = this.f2596b;
                constraintWidget4.setVerticalChainStyle(flow.f2519U);
                int i14 = this.f2603i;
                if (i > 0) {
                    i14 += flow.f2531g0;
                }
                constraintWidget4.mTop.connect(this.f2599e, i14);
                if (z2) {
                    constraintWidget4.mBottom.connect(this.f2601g, this.f2605k);
                }
                if (i > 0) {
                    this.f2599e.mOwner.mBottom.connect(constraintWidget4.mTop, 0);
                }
                if (flow.f2533i0 == 3 && !constraintWidget4.hasBaseline()) {
                    for (int i15 = 0; i15 < i7; i15++) {
                        if (z) {
                            i5 = (i7 - 1) - i15;
                        } else {
                            i5 = i15;
                        }
                        int i16 = this.f2608n;
                        if (i16 + i5 >= flow.f2542r0) {
                            break;
                        }
                        constraintWidget = flow.f2541q0[i16 + i5];
                        if (constraintWidget.hasBaseline()) {
                            break;
                        }
                    }
                }
                constraintWidget = constraintWidget4;
                int i17 = 0;
                ConstraintWidget constraintWidget5 = null;
                while (i17 < i7) {
                    if (z) {
                        i3 = (i7 - 1) - i17;
                    } else {
                        i3 = i17;
                    }
                    int i18 = this.f2608n;
                    if (i18 + i3 < flow.f2542r0) {
                        ConstraintWidget constraintWidget6 = flow.f2541q0[i18 + i3];
                        if (constraintWidget6 == null) {
                            constraintWidget6 = constraintWidget5;
                        } else {
                            if (i17 == 0) {
                                constraintWidget6.connect(constraintWidget6.mLeft, this.f2598d, this.f2602h);
                            }
                            if (i3 == 0) {
                                int i19 = flow.f2518T;
                                if (z) {
                                    f = 1.0f - flow.f2524Z;
                                } else {
                                    f = flow.f2524Z;
                                }
                                if (this.f2608n == 0 && (i4 = flow.f2520V) != -1) {
                                    if (z) {
                                        f3 = flow.f2526b0;
                                        f = 1.0f - f3;
                                    } else {
                                        f2 = flow.f2526b0;
                                        f = f2;
                                    }
                                } else {
                                    if (z2 && (i4 = flow.f2522X) != -1) {
                                        if (z) {
                                            f3 = flow.f2528d0;
                                            f = 1.0f - f3;
                                        } else {
                                            f2 = flow.f2528d0;
                                            f = f2;
                                        }
                                    }
                                    constraintWidget6.setHorizontalChainStyle(i19);
                                    constraintWidget6.setHorizontalBiasPercent(f);
                                }
                                i19 = i4;
                                constraintWidget6.setHorizontalChainStyle(i19);
                                constraintWidget6.setHorizontalBiasPercent(f);
                            }
                            if (i17 == i7 - 1) {
                                constraintWidget6.connect(constraintWidget6.mRight, this.f2600f, this.f2604j);
                            }
                            if (constraintWidget5 != null) {
                                constraintWidget6.mLeft.connect(constraintWidget5.mRight, flow.f2530f0);
                                if (i17 == i10) {
                                    constraintWidget6.mLeft.setGoneMargin(this.f2602h);
                                }
                                constraintWidget5.mRight.connect(constraintWidget6.mLeft, 0);
                                if (i17 == i11 + 1) {
                                    constraintWidget5.mRight.setGoneMargin(this.f2604j);
                                }
                            }
                            if (constraintWidget6 != constraintWidget4) {
                                c = 3;
                                if (flow.f2533i0 == 3 && constraintWidget.hasBaseline() && constraintWidget6 != constraintWidget && constraintWidget6.hasBaseline()) {
                                    constraintWidget6.mBaseline.connect(constraintWidget.mBaseline, 0);
                                } else {
                                    int i20 = flow.f2533i0;
                                    if (i20 != 0) {
                                        if (i20 != 1) {
                                            if (z3) {
                                                constraintWidget6.mTop.connect(this.f2599e, this.f2603i);
                                                constraintWidget6.mBottom.connect(this.f2601g, this.f2605k);
                                            } else {
                                                constraintWidget6.mTop.connect(constraintWidget4.mTop, 0);
                                                constraintWidget6.mBottom.connect(constraintWidget4.mBottom, 0);
                                            }
                                        } else {
                                            constraintWidget6.mBottom.connect(constraintWidget4.mBottom, 0);
                                        }
                                    } else {
                                        constraintWidget6.mTop.connect(constraintWidget4.mTop, 0);
                                    }
                                }
                                i17++;
                                constraintWidget5 = constraintWidget6;
                            }
                        }
                        c = 3;
                        i17++;
                        constraintWidget5 = constraintWidget6;
                    } else {
                        return;
                    }
                }
                return;
            }
            ConstraintWidget constraintWidget7 = this.f2596b;
            constraintWidget7.setHorizontalChainStyle(flow.f2518T);
            int i21 = this.f2602h;
            if (i > 0) {
                i21 += flow.f2530f0;
            }
            if (z) {
                constraintWidget7.mRight.connect(this.f2600f, i21);
                if (z2) {
                    constraintWidget7.mLeft.connect(this.f2598d, this.f2604j);
                }
                if (i > 0) {
                    this.f2600f.mOwner.mLeft.connect(constraintWidget7.mRight, 0);
                }
            } else {
                constraintWidget7.mLeft.connect(this.f2598d, i21);
                if (z2) {
                    constraintWidget7.mRight.connect(this.f2600f, this.f2604j);
                }
                if (i > 0) {
                    this.f2598d.mOwner.mRight.connect(constraintWidget7.mLeft, 0);
                }
            }
            ConstraintWidget constraintWidget8 = null;
            for (int i22 = 0; i22 < i7; i22++) {
                int i23 = this.f2608n;
                if (i23 + i22 < flow.f2542r0) {
                    ConstraintWidget constraintWidget9 = flow.f2541q0[i23 + i22];
                    if (constraintWidget9 != null) {
                        if (i22 == 0) {
                            constraintWidget9.connect(constraintWidget9.mTop, this.f2599e, this.f2603i);
                            int i24 = flow.f2519U;
                            float f4 = flow.f2525a0;
                            if (this.f2608n == 0 && (i2 = flow.f2521W) != -1) {
                                f4 = flow.f2527c0;
                            } else {
                                if (z2 && (i2 = flow.f2523Y) != -1) {
                                    f4 = flow.f2529e0;
                                }
                                constraintWidget9.setVerticalChainStyle(i24);
                                constraintWidget9.setVerticalBiasPercent(f4);
                            }
                            i24 = i2;
                            constraintWidget9.setVerticalChainStyle(i24);
                            constraintWidget9.setVerticalBiasPercent(f4);
                        }
                        if (i22 == i7 - 1) {
                            constraintWidget9.connect(constraintWidget9.mBottom, this.f2601g, this.f2605k);
                        }
                        if (constraintWidget8 != null) {
                            constraintWidget9.mTop.connect(constraintWidget8.mBottom, flow.f2531g0);
                            if (i22 == i10) {
                                constraintWidget9.mTop.setGoneMargin(this.f2603i);
                            }
                            constraintWidget8.mBottom.connect(constraintWidget9.mTop, 0);
                            if (i22 == i11 + 1) {
                                constraintWidget8.mBottom.setGoneMargin(this.f2605k);
                            }
                        }
                        if (constraintWidget9 != constraintWidget7) {
                            if (z) {
                                int i25 = flow.f2532h0;
                                if (i25 != 0) {
                                    if (i25 != 1) {
                                        if (i25 == 2) {
                                            constraintWidget9.mLeft.connect(constraintWidget7.mLeft, 0);
                                            constraintWidget9.mRight.connect(constraintWidget7.mRight, 0);
                                        }
                                    } else {
                                        constraintWidget9.mLeft.connect(constraintWidget7.mLeft, 0);
                                    }
                                } else {
                                    constraintWidget9.mRight.connect(constraintWidget7.mRight, 0);
                                }
                            } else {
                                int i26 = flow.f2532h0;
                                if (i26 != 0) {
                                    if (i26 != 1) {
                                        if (i26 == 2) {
                                            if (z3) {
                                                constraintWidget9.mLeft.connect(this.f2598d, this.f2602h);
                                                constraintWidget9.mRight.connect(this.f2600f, this.f2604j);
                                            } else {
                                                constraintWidget9.mLeft.connect(constraintWidget7.mLeft, 0);
                                                constraintWidget9.mRight.connect(constraintWidget7.mRight, 0);
                                            }
                                        }
                                    } else {
                                        constraintWidget9.mRight.connect(constraintWidget7.mRight, 0);
                                    }
                                } else {
                                    constraintWidget9.mLeft.connect(constraintWidget7.mLeft, 0);
                                }
                                constraintWidget8 = constraintWidget9;
                            }
                        }
                        constraintWidget8 = constraintWidget9;
                    }
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: c */
    public final int m527c() {
        if (this.f2595a == 1) {
            return this.f2607m - this.f2612r.f2531g0;
        }
        return this.f2607m;
    }

    /* renamed from: d */
    public final int m528d() {
        if (this.f2595a == 0) {
            return this.f2606l - this.f2612r.f2530f0;
        }
        return this.f2606l;
    }

    /* renamed from: e */
    public final void m529e(int i) {
        Flow flow;
        int i2 = this.f2610p;
        if (i2 == 0) {
            return;
        }
        int i3 = this.f2609o;
        int i4 = i / i2;
        int i5 = 0;
        while (true) {
            flow = this.f2612r;
            if (i5 >= i3) {
                break;
            }
            int i6 = this.f2608n;
            if (i6 + i5 >= flow.f2542r0) {
                break;
            }
            ConstraintWidget constraintWidget = flow.f2541q0[i6 + i5];
            if (this.f2595a == 0) {
                if (constraintWidget != null && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultWidth == 0) {
                    this.f2612r.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i4, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                }
            } else if (constraintWidget != null && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                this.f2612r.measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i4);
            }
            i5++;
        }
        this.f2606l = 0;
        this.f2607m = 0;
        this.f2596b = null;
        this.f2597c = 0;
        int i7 = this.f2609o;
        for (int i8 = 0; i8 < i7; i8++) {
            int i9 = this.f2608n + i8;
            if (i9 < flow.f2542r0) {
                ConstraintWidget constraintWidget2 = flow.f2541q0[i9];
                if (this.f2595a == 0) {
                    int width = constraintWidget2.getWidth();
                    int i10 = flow.f2530f0;
                    if (constraintWidget2.getVisibility() == 8) {
                        i10 = 0;
                    }
                    this.f2606l = width + i10 + this.f2606l;
                    int m499k = flow.m499k(constraintWidget2, this.f2611q);
                    if (this.f2596b == null || this.f2597c < m499k) {
                        this.f2596b = constraintWidget2;
                        this.f2597c = m499k;
                        this.f2607m = m499k;
                    }
                } else {
                    int m500l = flow.m500l(constraintWidget2, this.f2611q);
                    int m499k2 = flow.m499k(constraintWidget2, this.f2611q);
                    int i11 = flow.f2531g0;
                    if (constraintWidget2.getVisibility() == 8) {
                        i11 = 0;
                    }
                    this.f2607m = m499k2 + i11 + this.f2607m;
                    if (this.f2596b == null || this.f2597c < m500l) {
                        this.f2596b = constraintWidget2;
                        this.f2597c = m500l;
                        this.f2606l = m500l;
                    }
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: f */
    public final void m530f(int i, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i2, int i3, int i4, int i5, int i6) {
        this.f2595a = i;
        this.f2598d = constraintAnchor;
        this.f2599e = constraintAnchor2;
        this.f2600f = constraintAnchor3;
        this.f2601g = constraintAnchor4;
        this.f2602h = i2;
        this.f2603i = i3;
        this.f2604j = i4;
        this.f2605k = i5;
        this.f2611q = i6;
    }
}
