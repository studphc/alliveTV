package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Flow;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.core.widgets.Placeholder;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import androidx.constraintlayout.motion.utils.ViewState;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import p000.ep1;
import p000.lp1;

/* renamed from: androidx.constraintlayout.motion.widget.a */
/* loaded from: classes.dex */
public final class C0126a {

    /* renamed from: a */
    public ConstraintWidgetContainer f2984a = new ConstraintWidgetContainer();

    /* renamed from: b */
    public ConstraintWidgetContainer f2985b = new ConstraintWidgetContainer();

    /* renamed from: c */
    public ConstraintSet f2986c = null;

    /* renamed from: d */
    public ConstraintSet f2987d = null;

    /* renamed from: e */
    public int f2988e;

    /* renamed from: f */
    public int f2989f;

    /* renamed from: g */
    public final /* synthetic */ MotionLayout f2990g;

    public C0126a(MotionLayout motionLayout) {
        this.f2990g = motionLayout;
    }

    /* renamed from: c */
    public static void m603c(ConstraintWidgetContainer constraintWidgetContainer, ConstraintWidgetContainer constraintWidgetContainer2) {
        ConstraintWidget constraintWidget;
        ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
        HashMap<ConstraintWidget, ConstraintWidget> hashMap = new HashMap<>();
        hashMap.put(constraintWidgetContainer, constraintWidgetContainer2);
        constraintWidgetContainer2.getChildren().clear();
        constraintWidgetContainer2.copy(constraintWidgetContainer, hashMap);
        Iterator<ConstraintWidget> it = children.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            if (next instanceof Barrier) {
                constraintWidget = new Barrier();
            } else if (next instanceof Guideline) {
                constraintWidget = new Guideline();
            } else if (next instanceof Flow) {
                constraintWidget = new Flow();
            } else if (next instanceof Placeholder) {
                constraintWidget = new Placeholder();
            } else if (next instanceof Helper) {
                constraintWidget = new HelperWidget();
            } else {
                constraintWidget = new ConstraintWidget();
            }
            constraintWidgetContainer2.add(constraintWidget);
            hashMap.put(next, constraintWidget);
        }
        Iterator<ConstraintWidget> it2 = children.iterator();
        while (it2.hasNext()) {
            ConstraintWidget next2 = it2.next();
            hashMap.get(next2).copy(next2, hashMap);
        }
    }

    /* renamed from: d */
    public static ConstraintWidget m604d(ConstraintWidgetContainer constraintWidgetContainer, View view) {
        if (constraintWidgetContainer.getCompanionWidget() == view) {
            return constraintWidgetContainer;
        }
        ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
        int size = children.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = children.get(i);
            if (constraintWidget.getCompanionWidget() == view) {
                return constraintWidget;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0204 A[SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m605a() {
        int i;
        SparseArray sparseArray;
        int[] iArr;
        int i2;
        String str;
        String str2;
        String str3;
        String str4;
        Interpolator loadInterpolator;
        MotionLayout motionLayout = this.f2990g;
        int childCount = motionLayout.getChildCount();
        motionLayout.f2827B.clear();
        SparseArray sparseArray2 = new SparseArray();
        int[] iArr2 = new int[childCount];
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = motionLayout.getChildAt(i3);
            MotionController motionController = new MotionController(childAt);
            int id = childAt.getId();
            iArr2[i3] = id;
            sparseArray2.put(id, motionController);
            motionLayout.f2827B.put(childAt, motionController);
        }
        int i4 = 0;
        while (i4 < childCount) {
            View childAt2 = motionLayout.getChildAt(i4);
            MotionController motionController2 = (MotionController) motionLayout.f2827B.get(childAt2);
            if (motionController2 == null) {
                i = childCount;
                sparseArray = sparseArray2;
                iArr = iArr2;
                i2 = i4;
            } else {
                if (this.f2986c != null) {
                    ConstraintWidget m604d = m604d(this.f2984a, childAt2);
                    if (m604d != null) {
                        Rect m570c = MotionLayout.m570c(motionLayout, m604d);
                        ConstraintSet constraintSet = this.f2986c;
                        int width = motionLayout.getWidth();
                        int height = motionLayout.getHeight();
                        sparseArray = sparseArray2;
                        int i5 = constraintSet.mRotate;
                        iArr = iArr2;
                        if (i5 != 0) {
                            MotionController.m562h(i5, width, height, m570c, motionController2.f2796a);
                        }
                        lp1 lp1Var = motionController2.f2801f;
                        lp1Var.f22610c = RecyclerView.f7068F0;
                        lp1Var.f22611d = RecyclerView.f7068F0;
                        motionController2.m569g(lp1Var);
                        i = childCount;
                        i2 = i4;
                        lp1Var.m5968e(m570c.left, m570c.top, m570c.width(), m570c.height());
                        ConstraintSet.Constraint parameters = constraintSet.getParameters(motionController2.f2798c);
                        lp1Var.m5965a(parameters);
                        motionController2.f2807l = parameters.motion.mMotionStagger;
                        motionController2.f2803h.m4485d(m570c, constraintSet, i5, motionController2.f2798c);
                        motionController2.f2790C = parameters.transform.transformPivotTarget;
                        ConstraintSet.Motion motion = parameters.motion;
                        motionController2.f2792E = motion.mQuantizeMotionSteps;
                        motionController2.f2793F = motion.mQuantizeMotionPhase;
                        Context context = motionController2.f2797b.getContext();
                        ConstraintSet.Motion motion2 = parameters.motion;
                        int i6 = motion2.mQuantizeInterpolatorType;
                        String str5 = motion2.mQuantizeInterpolatorString;
                        int i7 = motion2.mQuantizeInterpolatorID;
                        if (i6 != -2) {
                            if (i6 != -1) {
                                if (i6 != 0) {
                                    if (i6 != 1) {
                                        if (i6 != 2) {
                                            if (i6 != 4) {
                                                if (i6 != 5) {
                                                    loadInterpolator = null;
                                                } else {
                                                    loadInterpolator = new OvershootInterpolator();
                                                }
                                            } else {
                                                loadInterpolator = new BounceInterpolator();
                                            }
                                        } else {
                                            loadInterpolator = new DecelerateInterpolator();
                                        }
                                    } else {
                                        loadInterpolator = new AccelerateInterpolator();
                                    }
                                } else {
                                    loadInterpolator = new AccelerateDecelerateInterpolator();
                                }
                            } else {
                                loadInterpolator = new ep1(Easing.getInterpolator(str5), 0);
                            }
                        } else {
                            loadInterpolator = AnimationUtils.loadInterpolator(context, i7);
                        }
                        motionController2.f2794G = loadInterpolator;
                    } else {
                        i = childCount;
                        sparseArray = sparseArray2;
                        iArr = iArr2;
                        i2 = i4;
                        if (motionLayout.f2847L != 0) {
                            Log.e("MotionLayout", Debug.getLocation() + "no widget for  " + Debug.getName(childAt2) + " (" + childAt2.getClass().getName() + ")");
                        }
                    }
                } else {
                    i = childCount;
                    sparseArray = sparseArray2;
                    iArr = iArr2;
                    i2 = i4;
                    if (motionLayout.f2893y0) {
                        str = "MotionLayout";
                        str2 = "no widget for  ";
                        str3 = " (";
                        str4 = ")";
                        motionController2.setStartState((ViewState) motionLayout.f2826A0.get(childAt2), childAt2, motionLayout.f2895z0, motionLayout.f2828B0, motionLayout.f2830C0);
                        if (this.f2987d != null) {
                            ConstraintWidget m604d2 = m604d(this.f2985b, childAt2);
                            if (m604d2 != null) {
                                Rect m570c2 = MotionLayout.m570c(motionLayout, m604d2);
                                ConstraintSet constraintSet2 = this.f2987d;
                                int width2 = motionLayout.getWidth();
                                int height2 = motionLayout.getHeight();
                                int i8 = constraintSet2.mRotate;
                                if (i8 != 0) {
                                    MotionController.m562h(i8, width2, height2, m570c2, motionController2.f2796a);
                                    m570c2 = motionController2.f2796a;
                                }
                                lp1 lp1Var2 = motionController2.f2802g;
                                lp1Var2.f22610c = 1.0f;
                                lp1Var2.f22611d = 1.0f;
                                motionController2.m569g(lp1Var2);
                                lp1Var2.m5968e(m570c2.left, m570c2.top, m570c2.width(), m570c2.height());
                                lp1Var2.m5965a(constraintSet2.getParameters(motionController2.f2798c));
                                motionController2.f2804i.m4485d(m570c2, constraintSet2, i8, motionController2.f2798c);
                            } else if (motionLayout.f2847L != 0) {
                                Log.e(str, Debug.getLocation() + str2 + Debug.getName(childAt2) + str3 + childAt2.getClass().getName() + str4);
                            }
                        }
                    }
                }
                str = "MotionLayout";
                str2 = "no widget for  ";
                str3 = " (";
                str4 = ")";
                if (this.f2987d != null) {
                }
            }
            i4 = i2 + 1;
            sparseArray2 = sparseArray;
            iArr2 = iArr;
            childCount = i;
        }
        SparseArray sparseArray3 = sparseArray2;
        int[] iArr3 = iArr2;
        int i9 = childCount;
        int i10 = 0;
        while (i10 < i9) {
            SparseArray sparseArray4 = sparseArray3;
            MotionController motionController3 = (MotionController) sparseArray4.get(iArr3[i10]);
            int animateRelativeTo = motionController3.getAnimateRelativeTo();
            if (animateRelativeTo != -1) {
                motionController3.setupRelative((MotionController) sparseArray4.get(animateRelativeTo));
            }
            i10++;
            sparseArray3 = sparseArray4;
        }
    }

    /* renamed from: b */
    public final void m606b(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        MotionLayout motionLayout = this.f2990g;
        int optimizationLevel = motionLayout.getOptimizationLevel();
        if (motionLayout.f2888w == motionLayout.getStartState()) {
            ConstraintWidgetContainer constraintWidgetContainer = this.f2985b;
            ConstraintSet constraintSet = this.f2987d;
            if (constraintSet != null && constraintSet.mRotate != 0) {
                i6 = i2;
            } else {
                i6 = i;
            }
            if (constraintSet != null && constraintSet.mRotate != 0) {
                i7 = i;
            } else {
                i7 = i2;
            }
            motionLayout.resolveSystem(constraintWidgetContainer, optimizationLevel, i6, i7);
            ConstraintSet constraintSet2 = this.f2986c;
            if (constraintSet2 != null) {
                ConstraintWidgetContainer constraintWidgetContainer2 = this.f2984a;
                int i9 = constraintSet2.mRotate;
                if (i9 == 0) {
                    i8 = i;
                } else {
                    i8 = i2;
                }
                if (i9 == 0) {
                    i = i2;
                }
                motionLayout.resolveSystem(constraintWidgetContainer2, optimizationLevel, i8, i);
                return;
            }
            return;
        }
        ConstraintSet constraintSet3 = this.f2986c;
        if (constraintSet3 != null) {
            ConstraintWidgetContainer constraintWidgetContainer3 = this.f2984a;
            int i10 = constraintSet3.mRotate;
            if (i10 == 0) {
                i4 = i;
            } else {
                i4 = i2;
            }
            if (i10 == 0) {
                i5 = i2;
            } else {
                i5 = i;
            }
            motionLayout.resolveSystem(constraintWidgetContainer3, optimizationLevel, i4, i5);
        }
        ConstraintWidgetContainer constraintWidgetContainer4 = this.f2985b;
        ConstraintSet constraintSet4 = this.f2987d;
        if (constraintSet4 != null && constraintSet4.mRotate != 0) {
            i3 = i2;
        } else {
            i3 = i;
        }
        if (constraintSet4 == null || constraintSet4.mRotate == 0) {
            i = i2;
        }
        motionLayout.resolveSystem(constraintWidgetContainer4, optimizationLevel, i3, i);
    }

    /* renamed from: e */
    public final void m607e(ConstraintSet constraintSet, ConstraintSet constraintSet2) {
        ConstraintWidgetContainer constraintWidgetContainer;
        ConstraintWidgetContainer constraintWidgetContainer2;
        ConstraintWidgetContainer constraintWidgetContainer3;
        ConstraintWidgetContainer constraintWidgetContainer4;
        this.f2986c = constraintSet;
        this.f2987d = constraintSet2;
        this.f2984a = new ConstraintWidgetContainer();
        this.f2985b = new ConstraintWidgetContainer();
        ConstraintWidgetContainer constraintWidgetContainer5 = this.f2984a;
        MotionLayout motionLayout = this.f2990g;
        constraintWidgetContainer = ((ConstraintLayout) motionLayout).mLayoutWidget;
        constraintWidgetContainer5.setMeasurer(constraintWidgetContainer.getMeasurer());
        ConstraintWidgetContainer constraintWidgetContainer6 = this.f2985b;
        constraintWidgetContainer2 = ((ConstraintLayout) motionLayout).mLayoutWidget;
        constraintWidgetContainer6.setMeasurer(constraintWidgetContainer2.getMeasurer());
        this.f2984a.removeAllChildren();
        this.f2985b.removeAllChildren();
        constraintWidgetContainer3 = ((ConstraintLayout) motionLayout).mLayoutWidget;
        m603c(constraintWidgetContainer3, this.f2984a);
        constraintWidgetContainer4 = ((ConstraintLayout) motionLayout).mLayoutWidget;
        m603c(constraintWidgetContainer4, this.f2985b);
        if (motionLayout.f2835F > 0.5d) {
            if (constraintSet != null) {
                m609g(this.f2984a, constraintSet);
            }
            m609g(this.f2985b, constraintSet2);
        } else {
            m609g(this.f2985b, constraintSet2);
            if (constraintSet != null) {
                m609g(this.f2984a, constraintSet);
            }
        }
        this.f2984a.setRtl(motionLayout.isRtl());
        this.f2984a.updateHierarchy();
        this.f2985b.setRtl(motionLayout.isRtl());
        this.f2985b.updateHierarchy();
        ViewGroup.LayoutParams layoutParams = motionLayout.getLayoutParams();
        if (layoutParams != null) {
            if (layoutParams.width == -2) {
                ConstraintWidgetContainer constraintWidgetContainer7 = this.f2984a;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                constraintWidgetContainer7.setHorizontalDimensionBehaviour(dimensionBehaviour);
                this.f2985b.setHorizontalDimensionBehaviour(dimensionBehaviour);
            }
            if (layoutParams.height == -2) {
                ConstraintWidgetContainer constraintWidgetContainer8 = this.f2984a;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                constraintWidgetContainer8.setVerticalDimensionBehaviour(dimensionBehaviour2);
                this.f2985b.setVerticalDimensionBehaviour(dimensionBehaviour2);
            }
        }
    }

    /* renamed from: f */
    public final void m608f() {
        boolean z;
        int i;
        boolean z2;
        boolean z3;
        HashMap<View, MotionController> hashMap;
        boolean z4;
        float f;
        float f2;
        int i2;
        MotionLayout motionLayout = this.f2990g;
        int i3 = motionLayout.f2892y;
        int i4 = motionLayout.f2894z;
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i4);
        motionLayout.f2876p0 = mode;
        motionLayout.f2877q0 = mode2;
        m606b(i3, i4);
        int i5 = 0;
        if (!(motionLayout.getParent() instanceof MotionLayout) || mode != 1073741824 || mode2 != 1073741824) {
            m606b(i3, i4);
            motionLayout.f2872l0 = this.f2984a.getWidth();
            motionLayout.f2873m0 = this.f2984a.getHeight();
            motionLayout.f2874n0 = this.f2985b.getWidth();
            int height = this.f2985b.getHeight();
            motionLayout.f2875o0 = height;
            if (motionLayout.f2872l0 == motionLayout.f2874n0 && motionLayout.f2873m0 == height) {
                z = false;
            } else {
                z = true;
            }
            motionLayout.mMeasureDuringTransition = z;
        }
        int i6 = motionLayout.f2872l0;
        int i7 = motionLayout.f2873m0;
        int i8 = motionLayout.f2876p0;
        if (i8 == Integer.MIN_VALUE || i8 == 0) {
            i6 = (int) ((motionLayout.f2879r0 * (motionLayout.f2874n0 - i6)) + i6);
        }
        int i9 = i6;
        int i10 = motionLayout.f2877q0;
        if (i10 != Integer.MIN_VALUE && i10 != 0) {
            i = i7;
        } else {
            i = (int) ((motionLayout.f2879r0 * (motionLayout.f2875o0 - i7)) + i7);
        }
        if (!this.f2984a.isWidthMeasuredTooSmall() && !this.f2985b.isWidthMeasuredTooSmall()) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!this.f2984a.isHeightMeasuredTooSmall() && !this.f2985b.isHeightMeasuredTooSmall()) {
            z3 = false;
        } else {
            z3 = true;
        }
        this.f2990g.resolveMeasuredDimension(i3, i4, i9, i, z2, z3);
        int childCount = motionLayout.getChildCount();
        motionLayout.f2840H0.m605a();
        motionLayout.f2843J = true;
        SparseArray sparseArray = new SparseArray();
        int i11 = 0;
        while (true) {
            hashMap = motionLayout.f2827B;
            if (i11 >= childCount) {
                break;
            }
            View childAt = motionLayout.getChildAt(i11);
            sparseArray.put(childAt.getId(), hashMap.get(childAt));
            i11++;
        }
        int width = motionLayout.getWidth();
        int height2 = motionLayout.getHeight();
        int gatPathMotionArc = motionLayout.f2878r.gatPathMotionArc();
        if (gatPathMotionArc != -1) {
            for (int i12 = 0; i12 < childCount; i12++) {
                MotionController motionController = hashMap.get(motionLayout.getChildAt(i12));
                if (motionController != null) {
                    motionController.setPathMotionArc(gatPathMotionArc);
                }
            }
        }
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        int[] iArr = new int[hashMap.size()];
        int i13 = 0;
        for (int i14 = 0; i14 < childCount; i14++) {
            MotionController motionController2 = hashMap.get(motionLayout.getChildAt(i14));
            if (motionController2.getAnimateRelativeTo() != -1) {
                sparseBooleanArray.put(motionController2.getAnimateRelativeTo(), true);
                iArr[i13] = motionController2.getAnimateRelativeTo();
                i13++;
            }
        }
        if (motionLayout.f2865e0 != null) {
            for (int i15 = 0; i15 < i13; i15++) {
                MotionController motionController3 = hashMap.get(motionLayout.findViewById(iArr[i15]));
                if (motionController3 != null) {
                    motionLayout.f2878r.getKeyFrames(motionController3);
                }
            }
            Iterator it = motionLayout.f2865e0.iterator();
            while (it.hasNext()) {
                ((MotionHelper) it.next()).onPreSetup(motionLayout, hashMap);
            }
            int i16 = 0;
            while (i16 < i13) {
                MotionController motionController4 = hashMap.get(motionLayout.findViewById(iArr[i16]));
                if (motionController4 == null) {
                    i2 = i13;
                } else {
                    i2 = i13;
                    motionController4.setup(width, height2, motionLayout.f2831D, motionLayout.getNanoTime());
                }
                i16++;
                i13 = i2;
            }
        } else {
            int i17 = i13;
            for (int i18 = 0; i18 < i17; i18++) {
                MotionController motionController5 = hashMap.get(motionLayout.findViewById(iArr[i18]));
                if (motionController5 != null) {
                    motionLayout.f2878r.getKeyFrames(motionController5);
                    motionController5.setup(width, height2, motionLayout.f2831D, motionLayout.getNanoTime());
                }
            }
        }
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt2 = motionLayout.getChildAt(i19);
            MotionController motionController6 = hashMap.get(childAt2);
            if (!sparseBooleanArray.get(childAt2.getId()) && motionController6 != null) {
                motionLayout.f2878r.getKeyFrames(motionController6);
                motionController6.setup(width, height2, motionLayout.f2831D, motionLayout.getNanoTime());
            }
        }
        float staggered = motionLayout.f2878r.getStaggered();
        if (staggered != RecyclerView.f7068F0) {
            if (staggered < 0.0d) {
                z4 = true;
            } else {
                z4 = false;
            }
            float abs = Math.abs(staggered);
            float f3 = -3.4028235E38f;
            float f4 = Float.MAX_VALUE;
            float f5 = -3.4028235E38f;
            float f6 = Float.MAX_VALUE;
            for (int i20 = 0; i20 < childCount; i20++) {
                MotionController motionController7 = hashMap.get(motionLayout.getChildAt(i20));
                if (!Float.isNaN(motionController7.f2807l)) {
                    for (int i21 = 0; i21 < childCount; i21++) {
                        MotionController motionController8 = hashMap.get(motionLayout.getChildAt(i21));
                        if (!Float.isNaN(motionController8.f2807l)) {
                            f4 = Math.min(f4, motionController8.f2807l);
                            f3 = Math.max(f3, motionController8.f2807l);
                        }
                    }
                    while (i5 < childCount) {
                        MotionController motionController9 = hashMap.get(motionLayout.getChildAt(i5));
                        if (!Float.isNaN(motionController9.f2807l)) {
                            motionController9.f2809n = 1.0f / (1.0f - abs);
                            if (z4) {
                                motionController9.f2808m = abs - (((f3 - motionController9.f2807l) / (f3 - f4)) * abs);
                            } else {
                                motionController9.f2808m = abs - (((motionController9.f2807l - f4) * abs) / (f3 - f4));
                            }
                        }
                        i5++;
                    }
                    return;
                }
                float finalX = motionController7.getFinalX();
                float finalY = motionController7.getFinalY();
                if (z4) {
                    f2 = finalY - finalX;
                } else {
                    f2 = finalY + finalX;
                }
                f6 = Math.min(f6, f2);
                f5 = Math.max(f5, f2);
            }
            while (i5 < childCount) {
                MotionController motionController10 = hashMap.get(motionLayout.getChildAt(i5));
                float finalX2 = motionController10.getFinalX();
                float finalY2 = motionController10.getFinalY();
                if (z4) {
                    f = finalY2 - finalX2;
                } else {
                    f = finalY2 + finalX2;
                }
                motionController10.f2809n = 1.0f / (1.0f - abs);
                motionController10.f2808m = abs - (((f - f6) * abs) / (f5 - f6));
                i5++;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: g */
    public final void m609g(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet constraintSet) {
        SparseArray<ConstraintWidget> sparseArray = new SparseArray<>();
        Constraints.LayoutParams layoutParams = new Constraints.LayoutParams(-2, -2);
        sparseArray.clear();
        sparseArray.put(0, constraintWidgetContainer);
        MotionLayout motionLayout = this.f2990g;
        sparseArray.put(motionLayout.getId(), constraintWidgetContainer);
        if (constraintSet != null && constraintSet.mRotate != 0) {
            ConstraintWidgetContainer constraintWidgetContainer2 = this.f2985b;
            int optimizationLevel = motionLayout.getOptimizationLevel();
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(motionLayout.getHeight(), 1073741824);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(motionLayout.getWidth(), 1073741824);
            int i = MotionLayout.TOUCH_UP_COMPLETE;
            motionLayout.resolveSystem(constraintWidgetContainer2, optimizationLevel, makeMeasureSpec, makeMeasureSpec2);
        }
        Iterator<ConstraintWidget> it = constraintWidgetContainer.getChildren().iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            next.setAnimated(true);
            sparseArray.put(((View) next.getCompanionWidget()).getId(), next);
        }
        Iterator<ConstraintWidget> it2 = constraintWidgetContainer.getChildren().iterator();
        while (it2.hasNext()) {
            ConstraintWidget next2 = it2.next();
            View view = (View) next2.getCompanionWidget();
            constraintSet.applyToLayoutParams(view.getId(), layoutParams);
            next2.setWidth(constraintSet.getWidth(view.getId()));
            next2.setHeight(constraintSet.getHeight(view.getId()));
            if (view instanceof ConstraintHelper) {
                constraintSet.applyToHelper((ConstraintHelper) view, next2, layoutParams, sparseArray);
                if (view instanceof androidx.constraintlayout.widget.Barrier) {
                    ((androidx.constraintlayout.widget.Barrier) view).validateParams();
                }
            }
            layoutParams.resolveLayoutDirection(motionLayout.getLayoutDirection());
            int i2 = MotionLayout.TOUCH_UP_COMPLETE;
            this.f2990g.applyConstraintsFromLayoutParams(false, view, next2, layoutParams, sparseArray);
            if (constraintSet.getVisibilityMode(view.getId()) == 1) {
                next2.setVisibility(view.getVisibility());
            } else {
                next2.setVisibility(constraintSet.getVisibility(view.getId()));
            }
        }
        Iterator<ConstraintWidget> it3 = constraintWidgetContainer.getChildren().iterator();
        while (it3.hasNext()) {
            ConstraintWidget next3 = it3.next();
            if (next3 instanceof VirtualLayout) {
                ConstraintHelper constraintHelper = (ConstraintHelper) next3.getCompanionWidget();
                Helper helper = (Helper) next3;
                constraintHelper.updatePreLayout(constraintWidgetContainer, helper, sparseArray);
                ((VirtualLayout) helper).captureWidgets();
            }
        }
    }
}
