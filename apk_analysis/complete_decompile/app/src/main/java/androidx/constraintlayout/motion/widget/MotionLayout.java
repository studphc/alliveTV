package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.VelocityMatrix;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.motion.utils.StopLogic;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.motion.utils.ViewState;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayoutStates;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.StateSet;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import p000.AbstractC1726qj;
import p000.b43;
import p000.cp1;
import p000.gp1;
import p000.hp1;
import p000.ip1;
import p000.jp1;
import p000.kp1;
import p000.lp1;
import p000.sn1;
import p000.ye0;

/* loaded from: classes.dex */
public class MotionLayout extends ConstraintLayout implements NestedScrollingParent3 {
    public static final int DEBUG_SHOW_NONE = 0;
    public static final int DEBUG_SHOW_PATH = 2;
    public static final int DEBUG_SHOW_PROGRESS = 1;
    public static boolean IS_IN_EDIT_MODE = false;
    public static final int TOUCH_UP_COMPLETE = 0;
    public static final int TOUCH_UP_COMPLETE_TO_END = 2;
    public static final int TOUCH_UP_COMPLETE_TO_START = 1;
    public static final int TOUCH_UP_DECELERATE = 4;
    public static final int TOUCH_UP_DECELERATE_AND_COMPLETE = 5;
    public static final int TOUCH_UP_NEVER_TO_END = 7;
    public static final int TOUCH_UP_NEVER_TO_START = 6;
    public static final int TOUCH_UP_STOP = 3;
    public static final int VELOCITY_LAYOUT = 1;
    public static final int VELOCITY_POST_LAYOUT = 0;
    public static final int VELOCITY_STATIC_LAYOUT = 3;
    public static final int VELOCITY_STATIC_POST_LAYOUT = 2;

    /* renamed from: A */
    public boolean f2825A;

    /* renamed from: A0 */
    public final HashMap f2826A0;

    /* renamed from: B */
    public final HashMap f2827B;

    /* renamed from: B0 */
    public int f2828B0;

    /* renamed from: C */
    public long f2829C;

    /* renamed from: C0 */
    public int f2830C0;

    /* renamed from: D */
    public float f2831D;

    /* renamed from: D0 */
    public int f2832D0;

    /* renamed from: E */
    public float f2833E;

    /* renamed from: E0 */
    public final Rect f2834E0;

    /* renamed from: F */
    public float f2835F;

    /* renamed from: F0 */
    public boolean f2836F0;

    /* renamed from: G */
    public long f2837G;

    /* renamed from: G0 */
    public kp1 f2838G0;

    /* renamed from: H */
    public float f2839H;

    /* renamed from: H0 */
    public final C0126a f2840H0;

    /* renamed from: I */
    public boolean f2841I;

    /* renamed from: I0 */
    public boolean f2842I0;

    /* renamed from: J */
    public boolean f2843J;

    /* renamed from: J0 */
    public final RectF f2844J0;

    /* renamed from: K */
    public TransitionListener f2845K;

    /* renamed from: K0 */
    public View f2846K0;

    /* renamed from: L */
    public int f2847L;

    /* renamed from: L0 */
    public Matrix f2848L0;

    /* renamed from: M */
    public ip1 f2849M;

    /* renamed from: M0 */
    public final ArrayList f2850M0;

    /* renamed from: N */
    public boolean f2851N;

    /* renamed from: O */
    public final StopLogic f2852O;

    /* renamed from: P */
    public final hp1 f2853P;

    /* renamed from: Q */
    public DesignTool f2854Q;

    /* renamed from: R */
    public int f2855R;

    /* renamed from: S */
    public int f2856S;

    /* renamed from: T */
    public boolean f2857T;

    /* renamed from: U */
    public float f2858U;

    /* renamed from: V */
    public float f2859V;

    /* renamed from: W */
    public long f2860W;

    /* renamed from: a0 */
    public float f2861a0;

    /* renamed from: b0 */
    public boolean f2862b0;

    /* renamed from: c0 */
    public ArrayList f2863c0;

    /* renamed from: d0 */
    public ArrayList f2864d0;

    /* renamed from: e0 */
    public ArrayList f2865e0;

    /* renamed from: f0 */
    public CopyOnWriteArrayList f2866f0;

    /* renamed from: g0 */
    public int f2867g0;

    /* renamed from: h0 */
    public long f2868h0;

    /* renamed from: i0 */
    public float f2869i0;

    /* renamed from: j0 */
    public int f2870j0;

    /* renamed from: k0 */
    public float f2871k0;

    /* renamed from: l0 */
    public int f2872l0;

    /* renamed from: m0 */
    public int f2873m0;
    protected boolean mMeasureDuringTransition;

    /* renamed from: n0 */
    public int f2874n0;

    /* renamed from: o0 */
    public int f2875o0;

    /* renamed from: p0 */
    public int f2876p0;

    /* renamed from: q0 */
    public int f2877q0;

    /* renamed from: r */
    public MotionScene f2878r;

    /* renamed from: r0 */
    public float f2879r0;

    /* renamed from: s */
    public MotionInterpolator f2880s;

    /* renamed from: s0 */
    public final KeyCache f2881s0;

    /* renamed from: t */
    public Interpolator f2882t;

    /* renamed from: t0 */
    public boolean f2883t0;

    /* renamed from: u */
    public float f2884u;

    /* renamed from: u0 */
    public jp1 f2885u0;

    /* renamed from: v */
    public int f2886v;

    /* renamed from: v0 */
    public Runnable f2887v0;

    /* renamed from: w */
    public int f2888w;

    /* renamed from: w0 */
    public int[] f2889w0;

    /* renamed from: x */
    public int f2890x;

    /* renamed from: x0 */
    public int f2891x0;

    /* renamed from: y */
    public int f2892y;

    /* renamed from: y0 */
    public boolean f2893y0;

    /* renamed from: z */
    public int f2894z;

    /* renamed from: z0 */
    public int f2895z0;

    /* loaded from: classes.dex */
    public interface MotionTracker {
        void addMovement(MotionEvent motionEvent);

        void clear();

        void computeCurrentVelocity(int i);

        void computeCurrentVelocity(int i, float f);

        float getXVelocity();

        float getXVelocity(int i);

        float getYVelocity();

        float getYVelocity(int i);

        void recycle();
    }

    /* loaded from: classes.dex */
    public interface TransitionListener {
        void onTransitionChange(MotionLayout motionLayout, int i, int i2, float f);

        void onTransitionCompleted(MotionLayout motionLayout, int i);

        void onTransitionStarted(MotionLayout motionLayout, int i, int i2);

        void onTransitionTrigger(MotionLayout motionLayout, int i, boolean z, float f);
    }

    public MotionLayout(@NonNull Context context) {
        super(context);
        this.f2882t = null;
        this.f2884u = RecyclerView.f7068F0;
        this.f2886v = -1;
        this.f2888w = -1;
        this.f2890x = -1;
        this.f2892y = 0;
        this.f2894z = 0;
        this.f2825A = true;
        this.f2827B = new HashMap();
        this.f2829C = 0L;
        this.f2831D = 1.0f;
        this.f2833E = RecyclerView.f7068F0;
        this.f2835F = RecyclerView.f7068F0;
        this.f2839H = RecyclerView.f7068F0;
        this.f2843J = false;
        this.f2847L = 0;
        this.f2851N = false;
        this.f2852O = new StopLogic();
        this.f2853P = new hp1(this);
        this.f2857T = false;
        this.f2862b0 = false;
        this.f2863c0 = null;
        this.f2864d0 = null;
        this.f2865e0 = null;
        this.f2866f0 = null;
        this.f2867g0 = 0;
        this.f2868h0 = -1L;
        this.f2869i0 = RecyclerView.f7068F0;
        this.f2870j0 = 0;
        this.f2871k0 = RecyclerView.f7068F0;
        this.mMeasureDuringTransition = false;
        this.f2881s0 = new KeyCache();
        this.f2883t0 = false;
        this.f2887v0 = null;
        this.f2889w0 = null;
        this.f2891x0 = 0;
        this.f2893y0 = false;
        this.f2895z0 = 0;
        this.f2826A0 = new HashMap();
        this.f2834E0 = new Rect();
        this.f2836F0 = false;
        this.f2838G0 = kp1.f22135a;
        this.f2840H0 = new C0126a(this);
        this.f2842I0 = false;
        this.f2844J0 = new RectF();
        this.f2846K0 = null;
        this.f2848L0 = null;
        this.f2850M0 = new ArrayList();
        m581n(null);
    }

    /* renamed from: c */
    public static Rect m570c(MotionLayout motionLayout, ConstraintWidget constraintWidget) {
        motionLayout.getClass();
        int y = constraintWidget.getY();
        Rect rect = motionLayout.f2834E0;
        rect.top = y;
        rect.left = constraintWidget.getX();
        rect.right = constraintWidget.getWidth() + rect.left;
        rect.bottom = constraintWidget.getHeight() + rect.top;
        return rect;
    }

    public void addTransitionListener(TransitionListener transitionListener) {
        if (this.f2866f0 == null) {
            this.f2866f0 = new CopyOnWriteArrayList();
        }
        this.f2866f0.add(transitionListener);
    }

    public boolean applyViewTransition(int i, MotionController motionController) {
        MotionScene motionScene = this.f2878r;
        if (motionScene != null) {
            return motionScene.applyViewTransition(i, motionController);
        }
        return false;
    }

    public ConstraintSet cloneConstraintSet(int i) {
        MotionScene motionScene = this.f2878r;
        if (motionScene == null) {
            return null;
        }
        ConstraintSet m586b = motionScene.m586b(i);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(m586b);
        return constraintSet;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        boolean z;
        int i;
        String state;
        ViewTransitionController viewTransitionController;
        ArrayList arrayList;
        ArrayList arrayList2 = this.f2865e0;
        if (arrayList2 != null) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                ((MotionHelper) it.next()).onPreDraw(canvas);
            }
        }
        boolean z2 = false;
        m577j(false);
        MotionScene motionScene = this.f2878r;
        float[] fArr = null;
        if (motionScene != null && (viewTransitionController = motionScene.f2913r) != null && (arrayList = viewTransitionController.f2982e) != null) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((b43) it2.next()).m2017a();
            }
            ArrayList arrayList3 = viewTransitionController.f2982e;
            ArrayList arrayList4 = viewTransitionController.f2983f;
            arrayList3.removeAll(arrayList4);
            arrayList4.clear();
            if (viewTransitionController.f2982e.isEmpty()) {
                viewTransitionController.f2982e = null;
            }
        }
        super.dispatchDraw(canvas);
        if (this.f2878r == null) {
            return;
        }
        int i2 = 1;
        if ((this.f2847L & 1) == 1 && !isInEditMode()) {
            this.f2867g0++;
            long nanoTime = getNanoTime();
            long j = this.f2868h0;
            if (j != -1) {
                if (nanoTime - j > 200000000) {
                    this.f2869i0 = ((int) ((this.f2867g0 / (((float) r10) * 1.0E-9f)) * 100.0f)) / 100.0f;
                    this.f2867g0 = 0;
                    this.f2868h0 = nanoTime;
                }
            } else {
                this.f2868h0 = nanoTime;
            }
            Paint paint = new Paint();
            paint.setTextSize(42.0f);
            StringBuilder m7064t = AbstractC1726qj.m7064t(this.f2869i0 + " fps " + Debug.getState(this, this.f2886v) + " -> ");
            m7064t.append(Debug.getState(this, this.f2890x));
            m7064t.append(" (progress: ");
            m7064t.append(((int) (getProgress() * 1000.0f)) / 10.0f);
            m7064t.append(" ) state=");
            int i3 = this.f2888w;
            if (i3 == -1) {
                state = "undefined";
            } else {
                state = Debug.getState(this, i3);
            }
            m7064t.append(state);
            String sb = m7064t.toString();
            paint.setColor(ViewCompat.MEASURED_STATE_MASK);
            canvas.drawText(sb, 11.0f, getHeight() - 29, paint);
            paint.setColor(-7864184);
            canvas.drawText(sb, 10.0f, getHeight() - 30, paint);
        }
        if (this.f2847L > 1) {
            if (this.f2849M == null) {
                this.f2849M = new ip1(this);
            }
            ip1 ip1Var = this.f2849M;
            int duration = this.f2878r.getDuration();
            int i4 = this.f2847L;
            ip1Var.getClass();
            HashMap hashMap = this.f2827B;
            if (hashMap != null && hashMap.size() != 0) {
                canvas.save();
                MotionLayout motionLayout = ip1Var.f20183n;
                boolean isInEditMode = motionLayout.isInEditMode();
                Paint paint2 = ip1Var.f20174e;
                if (!isInEditMode && (i4 & 1) == 2) {
                    String str = motionLayout.getContext().getResources().getResourceName(motionLayout.f2890x) + ":" + motionLayout.getProgress();
                    canvas.drawText(str, 10.0f, motionLayout.getHeight() - 30, ip1Var.f20177h);
                    canvas.drawText(str, 11.0f, motionLayout.getHeight() - 29, paint2);
                }
                for (MotionController motionController : hashMap.values()) {
                    int drawPath = motionController.getDrawPath();
                    if (i4 > 0 && drawPath == 0) {
                        drawPath = i2;
                    }
                    if (drawPath != 0) {
                        ip1Var.f20180k = motionController.m563a(ip1Var.f20171b, ip1Var.f20172c);
                        if (drawPath >= i2) {
                            int i5 = duration / 16;
                            float[] fArr2 = ip1Var.f20170a;
                            if (fArr2 == null || fArr2.length != i5 * 2) {
                                ip1Var.f20170a = new float[i5 * 2];
                                ip1Var.f20173d = new Path();
                            }
                            int i6 = ip1Var.f20182m;
                            float f = i6;
                            canvas.translate(f, f);
                            paint2.setColor(1996488704);
                            Paint paint3 = ip1Var.f20178i;
                            paint3.setColor(1996488704);
                            Paint paint4 = ip1Var.f20175f;
                            paint4.setColor(1996488704);
                            Paint paint5 = ip1Var.f20176g;
                            paint5.setColor(1996488704);
                            motionController.m564b(ip1Var.f20170a, i5);
                            ip1Var.m5331a(canvas, drawPath, ip1Var.f20180k, motionController);
                            paint2.setColor(-21965);
                            paint4.setColor(-2067046);
                            paint3.setColor(-2067046);
                            paint5.setColor(-13391360);
                            float f2 = -i6;
                            canvas.translate(f2, f2);
                            ip1Var.m5331a(canvas, drawPath, ip1Var.f20180k, motionController);
                            if (drawPath == 5) {
                                ip1Var.f20173d.reset();
                                int i7 = 0;
                                while (i7 <= 50) {
                                    motionController.f2805j[0].getPos(motionController.m565c(i7 / 50, fArr), motionController.f2811p);
                                    int[] iArr = motionController.f2810o;
                                    double[] dArr = motionController.f2811p;
                                    lp1 lp1Var = motionController.f2801f;
                                    float[] fArr3 = ip1Var.f20179j;
                                    lp1Var.m5967d(iArr, dArr, fArr3, 0);
                                    ip1Var.f20173d.moveTo(fArr3[0], fArr3[1]);
                                    ip1Var.f20173d.lineTo(fArr3[2], fArr3[3]);
                                    ip1Var.f20173d.lineTo(fArr3[4], fArr3[5]);
                                    ip1Var.f20173d.lineTo(fArr3[6], fArr3[7]);
                                    ip1Var.f20173d.close();
                                    i7++;
                                    fArr = null;
                                }
                                z = false;
                                i = 1;
                                paint2.setColor(1140850688);
                                canvas.translate(2.0f, 2.0f);
                                canvas.drawPath(ip1Var.f20173d, paint2);
                                canvas.translate(-2.0f, -2.0f);
                                paint2.setColor(SupportMenu.CATEGORY_MASK);
                                canvas.drawPath(ip1Var.f20173d, paint2);
                            } else {
                                z = false;
                                i = 1;
                            }
                        } else {
                            z = z2;
                            i = i2;
                        }
                        z2 = z;
                        i2 = i;
                        fArr = null;
                    }
                }
                canvas.restore();
            }
        }
        ArrayList arrayList5 = this.f2865e0;
        if (arrayList5 != null) {
            Iterator it3 = arrayList5.iterator();
            while (it3.hasNext()) {
                ((MotionHelper) it3.next()).onPostDraw(canvas);
            }
        }
    }

    public void enableTransition(int i, boolean z) {
        MotionScene.Transition transition = getTransition(i);
        if (z) {
            transition.setEnabled(true);
            return;
        }
        MotionScene motionScene = this.f2878r;
        if (transition == motionScene.f2898c) {
            Iterator<MotionScene.Transition> it = motionScene.getTransitionsWithState(this.f2888w).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MotionScene.Transition next = it.next();
                if (next.isEnabled()) {
                    this.f2878r.f2898c = next;
                    break;
                }
            }
        }
        transition.setEnabled(false);
    }

    public void enableViewTransition(int i, boolean z) {
        MotionScene motionScene = this.f2878r;
        if (motionScene != null) {
            motionScene.enableViewTransition(i, z);
        }
    }

    public void fireTransitionCompleted() {
        int i;
        CopyOnWriteArrayList copyOnWriteArrayList;
        if ((this.f2845K != null || ((copyOnWriteArrayList = this.f2866f0) != null && !copyOnWriteArrayList.isEmpty())) && this.f2870j0 == -1) {
            this.f2870j0 = this.f2888w;
            ArrayList arrayList = this.f2850M0;
            if (!arrayList.isEmpty()) {
                i = ((Integer) AbstractC1726qj.m7053i(arrayList, 1)).intValue();
            } else {
                i = -1;
            }
            int i2 = this.f2888w;
            if (i != i2 && i2 != -1) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        m583p();
        Runnable runnable = this.f2887v0;
        if (runnable != null) {
            runnable.run();
            this.f2887v0 = null;
        }
        int[] iArr = this.f2889w0;
        if (iArr != null && this.f2891x0 > 0) {
            transitionToState(iArr[0]);
            int[] iArr2 = this.f2889w0;
            System.arraycopy(iArr2, 1, iArr2, 0, iArr2.length - 1);
            this.f2891x0--;
        }
    }

    public void fireTrigger(int i, boolean z, float f) {
        TransitionListener transitionListener = this.f2845K;
        if (transitionListener != null) {
            transitionListener.onTransitionTrigger(this, i, z, f);
        }
        CopyOnWriteArrayList copyOnWriteArrayList = this.f2866f0;
        if (copyOnWriteArrayList != null) {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                ((TransitionListener) it.next()).onTransitionTrigger(this, i, z, f);
            }
        }
    }

    public ConstraintSet getConstraintSet(int i) {
        MotionScene motionScene = this.f2878r;
        if (motionScene == null) {
            return null;
        }
        return motionScene.m586b(i);
    }

    @IdRes
    public int[] getConstraintSetIds() {
        MotionScene motionScene = this.f2878r;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getConstraintSetIds();
    }

    public int getCurrentState() {
        return this.f2888w;
    }

    public ArrayList<MotionScene.Transition> getDefinedTransitions() {
        MotionScene motionScene = this.f2878r;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getDefinedTransitions();
    }

    public DesignTool getDesignTool() {
        if (this.f2854Q == null) {
            this.f2854Q = new DesignTool(this);
        }
        return this.f2854Q;
    }

    public int getEndState() {
        return this.f2890x;
    }

    public int[] getMatchingConstraintSetIds(String... strArr) {
        MotionScene motionScene = this.f2878r;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getMatchingStateLabels(strArr);
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.f2835F;
    }

    public MotionScene getScene() {
        return this.f2878r;
    }

    public int getStartState() {
        return this.f2886v;
    }

    public float getTargetPosition() {
        return this.f2839H;
    }

    public MotionScene.Transition getTransition(int i) {
        return this.f2878r.getTransitionById(i);
    }

    public Bundle getTransitionState() {
        if (this.f2885u0 == null) {
            this.f2885u0 = new jp1(this);
        }
        jp1 jp1Var = this.f2885u0;
        MotionLayout motionLayout = jp1Var.f20579e;
        jp1Var.f20578d = motionLayout.f2890x;
        jp1Var.f20577c = motionLayout.f2886v;
        jp1Var.f20576b = motionLayout.getVelocity();
        jp1Var.f20575a = motionLayout.getProgress();
        jp1 jp1Var2 = this.f2885u0;
        jp1Var2.getClass();
        Bundle bundle = new Bundle();
        bundle.putFloat("motion.progress", jp1Var2.f20575a);
        bundle.putFloat("motion.velocity", jp1Var2.f20576b);
        bundle.putInt("motion.StartState", jp1Var2.f20577c);
        bundle.putInt("motion.EndState", jp1Var2.f20578d);
        return bundle;
    }

    public long getTransitionTimeMs() {
        if (this.f2878r != null) {
            this.f2831D = r0.getDuration() / 1000.0f;
        }
        return this.f2831D * 1000.0f;
    }

    public float getVelocity() {
        return this.f2884u;
    }

    public void getViewVelocity(View view, float f, float f2, float[] fArr, int i) {
        float f3;
        SplineSet splineSet;
        SplineSet splineSet2;
        SplineSet splineSet3;
        SplineSet splineSet4;
        SplineSet splineSet5;
        ViewOscillator viewOscillator;
        ViewOscillator viewOscillator2;
        ViewOscillator viewOscillator3;
        ViewOscillator viewOscillator4;
        ViewOscillator viewOscillator5;
        double[] dArr;
        float[] fArr2 = fArr;
        float f4 = this.f2884u;
        float f5 = this.f2835F;
        if (this.f2880s != null) {
            float signum = Math.signum(this.f2839H - f5);
            float interpolation = this.f2880s.getInterpolation(this.f2835F + 1.0E-5f);
            float interpolation2 = this.f2880s.getInterpolation(this.f2835F);
            f4 = (((interpolation - interpolation2) / 1.0E-5f) * signum) / this.f2831D;
            f5 = interpolation2;
        }
        MotionInterpolator motionInterpolator = this.f2880s;
        if (motionInterpolator instanceof MotionInterpolator) {
            f4 = motionInterpolator.getVelocity();
        }
        float f6 = f4;
        MotionController motionController = (MotionController) this.f2827B.get(view);
        if ((i & 1) == 0) {
            int width = view.getWidth();
            int height = view.getHeight();
            float[] fArr3 = motionController.f2817v;
            float m565c = motionController.m565c(f5, fArr3);
            HashMap hashMap = motionController.f2820y;
            if (hashMap == null) {
                splineSet = null;
            } else {
                splineSet = (SplineSet) hashMap.get("translationX");
            }
            HashMap hashMap2 = motionController.f2820y;
            if (hashMap2 == null) {
                splineSet2 = null;
            } else {
                splineSet2 = (SplineSet) hashMap2.get("translationY");
            }
            HashMap hashMap3 = motionController.f2820y;
            if (hashMap3 == null) {
                f3 = f6;
                splineSet3 = null;
            } else {
                splineSet3 = (SplineSet) hashMap3.get(Key.ROTATION);
                f3 = f6;
            }
            HashMap hashMap4 = motionController.f2820y;
            if (hashMap4 == null) {
                splineSet4 = null;
            } else {
                splineSet4 = (SplineSet) hashMap4.get("scaleX");
            }
            HashMap hashMap5 = motionController.f2820y;
            if (hashMap5 == null) {
                splineSet5 = null;
            } else {
                splineSet5 = (SplineSet) hashMap5.get("scaleY");
            }
            HashMap hashMap6 = motionController.f2821z;
            if (hashMap6 == null) {
                viewOscillator = null;
            } else {
                viewOscillator = (ViewOscillator) hashMap6.get("translationX");
            }
            HashMap hashMap7 = motionController.f2821z;
            if (hashMap7 == null) {
                viewOscillator2 = null;
            } else {
                viewOscillator2 = (ViewOscillator) hashMap7.get("translationY");
            }
            HashMap hashMap8 = motionController.f2821z;
            if (hashMap8 == null) {
                viewOscillator3 = null;
            } else {
                viewOscillator3 = (ViewOscillator) hashMap8.get(Key.ROTATION);
            }
            HashMap hashMap9 = motionController.f2821z;
            if (hashMap9 == null) {
                viewOscillator4 = null;
            } else {
                viewOscillator4 = (ViewOscillator) hashMap9.get("scaleX");
            }
            HashMap hashMap10 = motionController.f2821z;
            if (hashMap10 == null) {
                viewOscillator5 = null;
            } else {
                viewOscillator5 = (ViewOscillator) hashMap10.get("scaleY");
            }
            VelocityMatrix velocityMatrix = new VelocityMatrix();
            velocityMatrix.clear();
            velocityMatrix.setRotationVelocity(splineSet3, m565c);
            velocityMatrix.setTranslationVelocity(splineSet, splineSet2, m565c);
            velocityMatrix.setScaleVelocity(splineSet4, splineSet5, m565c);
            velocityMatrix.setRotationVelocity(viewOscillator3, m565c);
            velocityMatrix.setTranslationVelocity(viewOscillator, viewOscillator2, m565c);
            velocityMatrix.setScaleVelocity(viewOscillator4, viewOscillator5, m565c);
            ViewOscillator viewOscillator6 = viewOscillator5;
            CurveFit curveFit = motionController.f2806k;
            if (curveFit != null) {
                double[] dArr2 = motionController.f2811p;
                if (dArr2.length > 0) {
                    double d = m565c;
                    curveFit.getPos(d, dArr2);
                    motionController.f2806k.getSlope(d, motionController.f2812q);
                    int[] iArr = motionController.f2810o;
                    double[] dArr3 = motionController.f2812q;
                    double[] dArr4 = motionController.f2811p;
                    motionController.f2801f.getClass();
                    lp1.m5964f(f, f2, fArr, iArr, dArr3, dArr4);
                }
                velocityMatrix.applyTransform(f, f2, width, height, fArr);
            } else if (motionController.f2805j != null) {
                double m565c2 = motionController.m565c(m565c, fArr3);
                motionController.f2805j[0].getSlope(m565c2, motionController.f2812q);
                motionController.f2805j[0].getPos(m565c2, motionController.f2811p);
                float f7 = fArr3[0];
                int i2 = 0;
                while (true) {
                    dArr = motionController.f2812q;
                    if (i2 >= dArr.length) {
                        break;
                    }
                    dArr[i2] = dArr[i2] * f7;
                    i2++;
                }
                int[] iArr2 = motionController.f2810o;
                double[] dArr5 = motionController.f2811p;
                motionController.f2801f.getClass();
                lp1.m5964f(f, f2, fArr, iArr2, dArr, dArr5);
                velocityMatrix.applyTransform(f, f2, width, height, fArr);
            } else {
                lp1 lp1Var = motionController.f2802g;
                float f8 = lp1Var.f22612e;
                lp1 lp1Var2 = motionController.f2801f;
                float f9 = f8 - lp1Var2.f22612e;
                float f10 = lp1Var.f22613f - lp1Var2.f22613f;
                float f11 = lp1Var.f22614g - lp1Var2.f22614g;
                float f12 = (lp1Var.f22615h - lp1Var2.f22615h) + f10;
                float f13 = ((f11 + f9) * f) + ((1.0f - f) * f9);
                fArr2 = fArr;
                fArr2[0] = f13;
                fArr2[1] = (f12 * f2) + ((1.0f - f2) * f10);
                velocityMatrix.clear();
                velocityMatrix.setRotationVelocity(splineSet3, m565c);
                velocityMatrix.setTranslationVelocity(splineSet, splineSet2, m565c);
                velocityMatrix.setScaleVelocity(splineSet4, splineSet5, m565c);
                velocityMatrix.setRotationVelocity(viewOscillator3, m565c);
                velocityMatrix.setTranslationVelocity(viewOscillator, viewOscillator2, m565c);
                velocityMatrix.setScaleVelocity(viewOscillator4, viewOscillator6, m565c);
                velocityMatrix.applyTransform(f, f2, width, height, fArr);
            }
            fArr2 = fArr;
        } else {
            f3 = f6;
            motionController.m566d(f5, f, f2, fArr2);
        }
        if (i < 2) {
            fArr2[0] = fArr2[0] * f3;
            fArr2[1] = fArr2[1] * f3;
        }
    }

    /* renamed from: h */
    public final void m575h(float f) {
        if (this.f2878r == null) {
            return;
        }
        float f2 = this.f2835F;
        float f3 = this.f2833E;
        if (f2 != f3 && this.f2841I) {
            this.f2835F = f3;
        }
        float f4 = this.f2835F;
        if (f4 == f) {
            return;
        }
        this.f2851N = false;
        this.f2839H = f;
        this.f2831D = r0.getDuration() / 1000.0f;
        setProgress(this.f2839H);
        this.f2880s = null;
        this.f2882t = this.f2878r.getInterpolator();
        this.f2841I = false;
        this.f2829C = getNanoTime();
        this.f2843J = true;
        this.f2833E = f4;
        this.f2835F = f4;
        invalidate();
    }

    /* renamed from: i */
    public final void m576i(boolean z) {
        float f;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            MotionController motionController = (MotionController) this.f2827B.get(getChildAt(i));
            if (motionController != null && "button".equals(Debug.getName(motionController.f2797b)) && motionController.f2788A != null) {
                int i2 = 0;
                while (true) {
                    KeyTrigger[] keyTriggerArr = motionController.f2788A;
                    if (i2 < keyTriggerArr.length) {
                        KeyTrigger keyTrigger = keyTriggerArr[i2];
                        if (z) {
                            f = -100.0f;
                        } else {
                            f = 100.0f;
                        }
                        keyTrigger.conditionallyFire(f, motionController.f2797b);
                        i2++;
                    }
                }
            }
        }
    }

    public boolean isDelayedApplicationOfInitialState() {
        return this.f2836F0;
    }

    public boolean isInRotation() {
        return this.f2893y0;
    }

    public boolean isInteractionEnabled() {
        return this.f2825A;
    }

    public boolean isViewTransitionEnabled(int i) {
        MotionScene motionScene = this.f2878r;
        if (motionScene != null) {
            return motionScene.isViewTransitionEnabled(i);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0155  */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m577j(boolean z) {
        float f;
        boolean z2;
        char c;
        kp1 kp1Var;
        int childCount;
        Interpolator interpolator;
        float interpolation;
        Interpolator interpolator2;
        int i;
        boolean z3;
        int i2;
        if (this.f2837G == -1) {
            this.f2837G = getNanoTime();
        }
        float f2 = this.f2835F;
        if (f2 > RecyclerView.f7068F0 && f2 < 1.0f) {
            this.f2888w = -1;
        }
        boolean z4 = true;
        boolean z5 = false;
        if (this.f2862b0 || (this.f2843J && (z || this.f2839H != f2))) {
            float signum = Math.signum(this.f2839H - f2);
            long nanoTime = getNanoTime();
            MotionInterpolator motionInterpolator = this.f2880s;
            if (!(motionInterpolator instanceof MotionInterpolator)) {
                f = ((((float) (nanoTime - this.f2837G)) * signum) * 1.0E-9f) / this.f2831D;
            } else {
                f = 0.0f;
            }
            float f3 = this.f2835F + f;
            if (this.f2841I) {
                f3 = this.f2839H;
            }
            if ((signum > RecyclerView.f7068F0 && f3 >= this.f2839H) || (signum <= RecyclerView.f7068F0 && f3 <= this.f2839H)) {
                f3 = this.f2839H;
                this.f2843J = false;
                z2 = true;
            } else {
                z2 = false;
            }
            this.f2835F = f3;
            this.f2833E = f3;
            this.f2837G = nanoTime;
            if (motionInterpolator != null && !z2) {
                if (this.f2851N) {
                    float interpolation2 = motionInterpolator.getInterpolation(((float) (nanoTime - this.f2829C)) * 1.0E-9f);
                    MotionInterpolator motionInterpolator2 = this.f2880s;
                    StopLogic stopLogic = this.f2852O;
                    if (motionInterpolator2 == stopLogic) {
                        if (stopLogic.isStopped()) {
                            c = 2;
                        } else {
                            c = 1;
                        }
                    } else {
                        c = 0;
                    }
                    this.f2835F = interpolation2;
                    this.f2837G = nanoTime;
                    MotionInterpolator motionInterpolator3 = this.f2880s;
                    if (motionInterpolator3 instanceof MotionInterpolator) {
                        float velocity = motionInterpolator3.getVelocity();
                        this.f2884u = velocity;
                        if (Math.abs(velocity) * this.f2831D <= 1.0E-5f && c == 2) {
                            this.f2843J = false;
                        }
                        if (velocity > RecyclerView.f7068F0 && interpolation2 >= 1.0f) {
                            this.f2835F = 1.0f;
                            this.f2843J = false;
                            interpolation2 = 1.0f;
                        }
                        if (velocity < RecyclerView.f7068F0 && interpolation2 <= RecyclerView.f7068F0) {
                            this.f2835F = RecyclerView.f7068F0;
                            this.f2843J = false;
                            f3 = 0.0f;
                            if (Math.abs(this.f2884u) > 1.0E-5f) {
                                setState(kp1.f22137c);
                            }
                            kp1Var = kp1.f22138d;
                            if (c != 1) {
                                if ((signum > RecyclerView.f7068F0 && f3 >= this.f2839H) || (signum <= RecyclerView.f7068F0 && f3 <= this.f2839H)) {
                                    f3 = this.f2839H;
                                    this.f2843J = false;
                                }
                                if (f3 >= 1.0f || f3 <= RecyclerView.f7068F0) {
                                    this.f2843J = false;
                                    setState(kp1Var);
                                }
                            }
                            childCount = getChildCount();
                            this.f2862b0 = false;
                            long nanoTime2 = getNanoTime();
                            this.f2879r0 = f3;
                            interpolator = this.f2882t;
                            if (interpolator == null) {
                                interpolation = f3;
                            } else {
                                interpolation = interpolator.getInterpolation(f3);
                            }
                            interpolator2 = this.f2882t;
                            if (interpolator2 != null) {
                                float interpolation3 = interpolator2.getInterpolation((signum / this.f2831D) + f3);
                                this.f2884u = interpolation3;
                                this.f2884u = interpolation3 - this.f2882t.getInterpolation(f3);
                            }
                            for (i = 0; i < childCount; i++) {
                                View childAt = getChildAt(i);
                                MotionController motionController = (MotionController) this.f2827B.get(childAt);
                                if (motionController != null) {
                                    this.f2862b0 = motionController.m568f(childAt, interpolation, nanoTime2, this.f2881s0) | this.f2862b0;
                                }
                            }
                            if ((signum <= RecyclerView.f7068F0 && f3 >= this.f2839H) || (signum <= RecyclerView.f7068F0 && f3 <= this.f2839H)) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (!this.f2862b0 && !this.f2843J && z3) {
                                setState(kp1Var);
                            }
                            if (this.mMeasureDuringTransition) {
                                requestLayout();
                            }
                            this.f2862b0 = (!z3) | this.f2862b0;
                            if (f3 > RecyclerView.f7068F0 && (i2 = this.f2886v) != -1 && this.f2888w != i2) {
                                this.f2888w = i2;
                                this.f2878r.m586b(i2).applyCustomAttributes(this);
                                setState(kp1Var);
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            if (f3 >= 1.0d) {
                                int i3 = this.f2888w;
                                int i4 = this.f2890x;
                                if (i3 != i4) {
                                    this.f2888w = i4;
                                    this.f2878r.m586b(i4).applyCustomAttributes(this);
                                    setState(kp1Var);
                                    z5 = true;
                                }
                            }
                            if (this.f2862b0 && !this.f2843J) {
                                if ((signum > RecyclerView.f7068F0 && f3 == 1.0f) || (signum < RecyclerView.f7068F0 && f3 == RecyclerView.f7068F0)) {
                                    setState(kp1Var);
                                }
                            } else {
                                invalidate();
                            }
                            if (!this.f2862b0 && !this.f2843J && ((signum > RecyclerView.f7068F0 && f3 == 1.0f) || (signum < RecyclerView.f7068F0 && f3 == RecyclerView.f7068F0))) {
                                m582o();
                            }
                        }
                    }
                    f3 = interpolation2;
                    if (Math.abs(this.f2884u) > 1.0E-5f) {
                    }
                    kp1Var = kp1.f22138d;
                    if (c != 1) {
                    }
                    childCount = getChildCount();
                    this.f2862b0 = false;
                    long nanoTime22 = getNanoTime();
                    this.f2879r0 = f3;
                    interpolator = this.f2882t;
                    if (interpolator == null) {
                    }
                    interpolator2 = this.f2882t;
                    if (interpolator2 != null) {
                    }
                    while (i < childCount) {
                    }
                    if (signum <= RecyclerView.f7068F0) {
                    }
                    z3 = false;
                    if (!this.f2862b0) {
                        setState(kp1Var);
                    }
                    if (this.mMeasureDuringTransition) {
                    }
                    this.f2862b0 = (!z3) | this.f2862b0;
                    if (f3 > RecyclerView.f7068F0) {
                    }
                    z5 = false;
                    if (f3 >= 1.0d) {
                    }
                    if (this.f2862b0) {
                    }
                    invalidate();
                    if (!this.f2862b0) {
                        m582o();
                    }
                } else {
                    float interpolation4 = motionInterpolator.getInterpolation(f3);
                    MotionInterpolator motionInterpolator4 = this.f2880s;
                    if (motionInterpolator4 instanceof MotionInterpolator) {
                        this.f2884u = motionInterpolator4.getVelocity();
                    } else {
                        this.f2884u = ((motionInterpolator4.getInterpolation(f3 + f) - interpolation4) * signum) / f;
                    }
                    f3 = interpolation4;
                }
            } else {
                this.f2884u = f;
            }
            c = 0;
            if (Math.abs(this.f2884u) > 1.0E-5f) {
            }
            kp1Var = kp1.f22138d;
            if (c != 1) {
            }
            childCount = getChildCount();
            this.f2862b0 = false;
            long nanoTime222 = getNanoTime();
            this.f2879r0 = f3;
            interpolator = this.f2882t;
            if (interpolator == null) {
            }
            interpolator2 = this.f2882t;
            if (interpolator2 != null) {
            }
            while (i < childCount) {
            }
            if (signum <= RecyclerView.f7068F0) {
            }
            z3 = false;
            if (!this.f2862b0) {
            }
            if (this.mMeasureDuringTransition) {
            }
            this.f2862b0 = (!z3) | this.f2862b0;
            if (f3 > RecyclerView.f7068F0) {
            }
            z5 = false;
            if (f3 >= 1.0d) {
            }
            if (this.f2862b0) {
            }
            invalidate();
            if (!this.f2862b0) {
            }
        }
        float f4 = this.f2835F;
        if (f4 >= 1.0f) {
            int i5 = this.f2888w;
            int i6 = this.f2890x;
            if (i5 == i6) {
                z4 = z5;
            }
            this.f2888w = i6;
        } else {
            if (f4 <= RecyclerView.f7068F0) {
                int i7 = this.f2888w;
                int i8 = this.f2886v;
                if (i7 == i8) {
                    z4 = z5;
                }
                this.f2888w = i8;
            }
            this.f2842I0 |= z5;
            if (z5 && !this.f2883t0) {
                requestLayout();
            }
            this.f2833E = this.f2835F;
        }
        z5 = z4;
        this.f2842I0 |= z5;
        if (z5) {
            requestLayout();
        }
        this.f2833E = this.f2835F;
    }

    public void jumpToState(int i) {
        if (!isAttachedToWindow()) {
            this.f2888w = i;
        }
        if (this.f2886v == i) {
            setProgress(RecyclerView.f7068F0);
        } else if (this.f2890x == i) {
            setProgress(1.0f);
        } else {
            setTransition(i, i);
        }
    }

    /* renamed from: k */
    public final void m578k() {
        CopyOnWriteArrayList copyOnWriteArrayList;
        if ((this.f2845K != null || ((copyOnWriteArrayList = this.f2866f0) != null && !copyOnWriteArrayList.isEmpty())) && this.f2871k0 != this.f2833E) {
            if (this.f2870j0 != -1) {
                TransitionListener transitionListener = this.f2845K;
                if (transitionListener != null) {
                    transitionListener.onTransitionStarted(this, this.f2886v, this.f2890x);
                }
                CopyOnWriteArrayList copyOnWriteArrayList2 = this.f2866f0;
                if (copyOnWriteArrayList2 != null) {
                    Iterator it = copyOnWriteArrayList2.iterator();
                    while (it.hasNext()) {
                        ((TransitionListener) it.next()).onTransitionStarted(this, this.f2886v, this.f2890x);
                    }
                }
            }
            this.f2870j0 = -1;
            float f = this.f2833E;
            this.f2871k0 = f;
            TransitionListener transitionListener2 = this.f2845K;
            if (transitionListener2 != null) {
                transitionListener2.onTransitionChange(this, this.f2886v, this.f2890x, f);
            }
            CopyOnWriteArrayList copyOnWriteArrayList3 = this.f2866f0;
            if (copyOnWriteArrayList3 != null) {
                Iterator it2 = copyOnWriteArrayList3.iterator();
                while (it2.hasNext()) {
                    ((TransitionListener) it2.next()).onTransitionChange(this, this.f2886v, this.f2890x, this.f2833E);
                }
            }
        }
    }

    /* renamed from: l */
    public final void m579l(int i, float f, float f2, float f3, float[] fArr) {
        String resourceName;
        View viewById = getViewById(i);
        MotionController motionController = (MotionController) this.f2827B.get(viewById);
        if (motionController != null) {
            motionController.m566d(f, f2, f3, fArr);
            viewById.getY();
            return;
        }
        if (viewById == null) {
            resourceName = ye0.m8291k(i, "");
        } else {
            resourceName = viewById.getContext().getResources().getResourceName(i);
        }
        Log.w("MotionLayout", "WARNING could not find view id " + resourceName);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void loadLayoutDescription(int i) {
        int rotation;
        MotionScene.Transition transition;
        if (i != 0) {
            try {
                MotionScene motionScene = new MotionScene(getContext(), this, i);
                this.f2878r = motionScene;
                int i2 = -1;
                if (this.f2888w == -1) {
                    this.f2888w = motionScene.m590g();
                    this.f2886v = this.f2878r.m590g();
                    MotionScene.Transition transition2 = this.f2878r.f2898c;
                    if (transition2 != null) {
                        i2 = transition2.f2918c;
                    }
                    this.f2890x = i2;
                }
                if (isAttachedToWindow()) {
                    try {
                        Display display = getDisplay();
                        if (display == null) {
                            rotation = 0;
                        } else {
                            rotation = display.getRotation();
                        }
                        this.f2832D0 = rotation;
                        MotionScene motionScene2 = this.f2878r;
                        if (motionScene2 != null) {
                            ConstraintSet m586b = motionScene2.m586b(this.f2888w);
                            this.f2878r.m596m(this);
                            ArrayList arrayList = this.f2865e0;
                            if (arrayList != null) {
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    ((MotionHelper) it.next()).onFinishedMotionScene(this);
                                }
                            }
                            if (m586b != null) {
                                m586b.applyTo(this);
                            }
                            this.f2886v = this.f2888w;
                        }
                        m582o();
                        jp1 jp1Var = this.f2885u0;
                        if (jp1Var != null) {
                            if (this.f2836F0) {
                                post(new gp1(this, 0));
                                return;
                            } else {
                                jp1Var.m5448a();
                                return;
                            }
                        }
                        MotionScene motionScene3 = this.f2878r;
                        if (motionScene3 != null && (transition = motionScene3.f2898c) != null && transition.getAutoTransition() == 4) {
                            transitionToEnd();
                            setState(kp1.f22136b);
                            setState(kp1.f22137c);
                            return;
                        }
                        return;
                    } catch (Exception e) {
                        throw new IllegalArgumentException("unable to parse MotionScene file", e);
                    }
                }
                this.f2878r = null;
                return;
            } catch (Exception e2) {
                throw new IllegalArgumentException("unable to parse MotionScene file", e2);
            }
        }
        this.f2878r = null;
    }

    /* renamed from: m */
    public final boolean m580m(float f, float f2, View view, MotionEvent motionEvent) {
        boolean z;
        boolean onTouchEvent;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                if (m580m((r3.getLeft() + f) - view.getScrollX(), (r3.getTop() + f2) - view.getScrollY(), viewGroup.getChildAt(childCount), motionEvent)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (!z) {
            RectF rectF = this.f2844J0;
            rectF.set(f, f2, (view.getRight() + f) - view.getLeft(), (view.getBottom() + f2) - view.getTop());
            if (motionEvent.getAction() != 0 || rectF.contains(motionEvent.getX(), motionEvent.getY())) {
                float f3 = -f;
                float f4 = -f2;
                Matrix matrix = view.getMatrix();
                if (matrix.isIdentity()) {
                    motionEvent.offsetLocation(f3, f4);
                    onTouchEvent = view.onTouchEvent(motionEvent);
                    motionEvent.offsetLocation(-f3, -f4);
                } else {
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.offsetLocation(f3, f4);
                    if (this.f2848L0 == null) {
                        this.f2848L0 = new Matrix();
                    }
                    matrix.invert(this.f2848L0);
                    obtain.transform(this.f2848L0);
                    onTouchEvent = view.onTouchEvent(obtain);
                    obtain.recycle();
                }
                if (onTouchEvent) {
                    return true;
                }
            }
        }
        return z;
    }

    /* renamed from: n */
    public final void m581n(AttributeSet attributeSet) {
        MotionScene motionScene;
        int i;
        IS_IN_EDIT_MODE = isInEditMode();
        int i2 = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MotionLayout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            boolean z = true;
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == R.styleable.MotionLayout_layoutDescription) {
                    this.f2878r = new MotionScene(getContext(), this, obtainStyledAttributes.getResourceId(index, -1));
                } else if (index == R.styleable.MotionLayout_currentState) {
                    this.f2888w = obtainStyledAttributes.getResourceId(index, -1);
                } else if (index == R.styleable.MotionLayout_motionProgress) {
                    this.f2839H = obtainStyledAttributes.getFloat(index, RecyclerView.f7068F0);
                    this.f2843J = true;
                } else if (index == R.styleable.MotionLayout_applyMotionScene) {
                    z = obtainStyledAttributes.getBoolean(index, z);
                } else if (index == R.styleable.MotionLayout_showPaths) {
                    if (this.f2847L == 0) {
                        if (obtainStyledAttributes.getBoolean(index, false)) {
                            i = 2;
                        } else {
                            i = 0;
                        }
                        this.f2847L = i;
                    }
                } else if (index == R.styleable.MotionLayout_motionDebug) {
                    this.f2847L = obtainStyledAttributes.getInt(index, 0);
                }
            }
            obtainStyledAttributes.recycle();
            if (this.f2878r == null) {
                Log.e("MotionLayout", "WARNING NO app:layoutDescription tag");
            }
            if (!z) {
                this.f2878r = null;
            }
        }
        if (this.f2847L != 0) {
            MotionScene motionScene2 = this.f2878r;
            if (motionScene2 == null) {
                Log.e("MotionLayout", "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
            } else {
                int m590g = motionScene2.m590g();
                MotionScene motionScene3 = this.f2878r;
                ConstraintSet m586b = motionScene3.m586b(motionScene3.m590g());
                String name = Debug.getName(getContext(), m590g);
                int childCount = getChildCount();
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt = getChildAt(i4);
                    int id = childAt.getId();
                    if (id == -1) {
                        StringBuilder m7065u = AbstractC1726qj.m7065u("CHECK: ", name, " ALL VIEWS SHOULD HAVE ID's ");
                        m7065u.append(childAt.getClass().getName());
                        m7065u.append(" does not!");
                        Log.w("MotionLayout", m7065u.toString());
                    }
                    if (m586b.getConstraint(id) == null) {
                        StringBuilder m7065u2 = AbstractC1726qj.m7065u("CHECK: ", name, " NO CONSTRAINTS for ");
                        m7065u2.append(Debug.getName(childAt));
                        Log.w("MotionLayout", m7065u2.toString());
                    }
                }
                int[] knownIds = m586b.getKnownIds();
                for (int i5 = 0; i5 < knownIds.length; i5++) {
                    int i6 = knownIds[i5];
                    String name2 = Debug.getName(getContext(), i6);
                    if (findViewById(knownIds[i5]) == null) {
                        Log.w("MotionLayout", "CHECK: " + name + " NO View matches id " + name2);
                    }
                    if (m586b.getHeight(i6) == -1) {
                        Log.w("MotionLayout", "CHECK: " + name + "(" + name2 + ") no LAYOUT_HEIGHT");
                    }
                    if (m586b.getWidth(i6) == -1) {
                        Log.w("MotionLayout", "CHECK: " + name + "(" + name2 + ") no LAYOUT_HEIGHT");
                    }
                }
                SparseIntArray sparseIntArray = new SparseIntArray();
                SparseIntArray sparseIntArray2 = new SparseIntArray();
                Iterator<MotionScene.Transition> it = this.f2878r.getDefinedTransitions().iterator();
                while (it.hasNext()) {
                    MotionScene.Transition next = it.next();
                    if (next == this.f2878r.f2898c) {
                        Log.v("MotionLayout", "CHECK: CURRENT");
                    }
                    if (next.getStartConstraintSetId() == next.getEndConstraintSetId()) {
                        Log.e("MotionLayout", "CHECK: start and end constraint set should not be the same!");
                    }
                    int startConstraintSetId = next.getStartConstraintSetId();
                    int endConstraintSetId = next.getEndConstraintSetId();
                    String name3 = Debug.getName(getContext(), startConstraintSetId);
                    String name4 = Debug.getName(getContext(), endConstraintSetId);
                    if (sparseIntArray.get(startConstraintSetId) == endConstraintSetId) {
                        Log.e("MotionLayout", "CHECK: two transitions with the same start and end " + name3 + "->" + name4);
                    }
                    if (sparseIntArray2.get(endConstraintSetId) == startConstraintSetId) {
                        Log.e("MotionLayout", "CHECK: you can't have reverse transitions" + name3 + "->" + name4);
                    }
                    sparseIntArray.put(startConstraintSetId, endConstraintSetId);
                    sparseIntArray2.put(endConstraintSetId, startConstraintSetId);
                    if (this.f2878r.m586b(startConstraintSetId) == null) {
                        Log.e("MotionLayout", " no such constraintSetStart " + name3);
                    }
                    if (this.f2878r.m586b(endConstraintSetId) == null) {
                        Log.e("MotionLayout", " no such constraintSetEnd " + name3);
                    }
                }
            }
        }
        if (this.f2888w == -1 && (motionScene = this.f2878r) != null) {
            this.f2888w = motionScene.m590g();
            this.f2886v = this.f2878r.m590g();
            MotionScene.Transition transition = this.f2878r.f2898c;
            if (transition != null) {
                i2 = transition.f2918c;
            }
            this.f2890x = i2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.Object, androidx.core.widget.NestedScrollView$OnScrollChangeListener] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.lang.Object, android.view.View$OnTouchListener] */
    /* renamed from: o */
    public final void m582o() {
        MotionScene.Transition transition;
        C0128c c0128c;
        View view;
        MotionScene motionScene = this.f2878r;
        if (motionScene == null) {
            return;
        }
        if (motionScene.m585a(this, this.f2888w)) {
            requestLayout();
            return;
        }
        int i = this.f2888w;
        if (i != -1) {
            this.f2878r.addOnClickListeners(this, i);
        }
        if (this.f2878r.m598o() && (transition = this.f2878r.f2898c) != null && (c0128c = transition.f2927l) != null) {
            int i2 = c0128c.f3002d;
            if (i2 != -1) {
                MotionLayout motionLayout = c0128c.f3016r;
                view = motionLayout.findViewById(i2);
                if (view == null) {
                    Log.e("TouchResponse", "cannot find TouchAnchorId @id/" + Debug.getName(motionLayout.getContext(), c0128c.f3002d));
                }
            } else {
                view = null;
            }
            if (view instanceof NestedScrollView) {
                NestedScrollView nestedScrollView = (NestedScrollView) view;
                nestedScrollView.setOnTouchListener(new Object());
                nestedScrollView.setOnScrollChangeListener((NestedScrollView.OnScrollChangeListener) new Object());
            }
        }
    }

    public MotionTracker obtainVelocityTracker() {
        C0127b c0127b = C0127b.f2991b;
        c0127b.f2992a = VelocityTracker.obtain();
        return c0127b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        MotionScene.Transition transition;
        int i;
        super.onAttachedToWindow();
        Display display = getDisplay();
        if (display != null) {
            this.f2832D0 = display.getRotation();
        }
        MotionScene motionScene = this.f2878r;
        if (motionScene != null && (i = this.f2888w) != -1) {
            ConstraintSet m586b = motionScene.m586b(i);
            this.f2878r.m596m(this);
            ArrayList arrayList = this.f2865e0;
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((MotionHelper) it.next()).onFinishedMotionScene(this);
                }
            }
            if (m586b != null) {
                m586b.applyTo(this);
            }
            this.f2886v = this.f2888w;
        }
        m582o();
        jp1 jp1Var = this.f2885u0;
        if (jp1Var != null) {
            if (this.f2836F0) {
                post(new gp1(this, 2));
                return;
            } else {
                jp1Var.m5448a();
                return;
            }
        }
        MotionScene motionScene2 = this.f2878r;
        if (motionScene2 != null && (transition = motionScene2.f2898c) != null && transition.getAutoTransition() == 4) {
            transitionToEnd();
            setState(kp1.f22136b);
            setState(kp1.f22137c);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00e7  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        C0128c touchResponse;
        int i;
        RectF m611b;
        MotionLayout motionLayout;
        int currentState;
        Iterator it;
        ViewTransition viewTransition;
        int i2;
        MotionScene motionScene = this.f2878r;
        if (motionScene == null || !this.f2825A) {
            return false;
        }
        ViewTransitionController viewTransitionController = motionScene.f2913r;
        if (viewTransitionController != null && (currentState = (motionLayout = viewTransitionController.f2978a).getCurrentState()) != -1) {
            HashSet hashSet = viewTransitionController.f2980c;
            ArrayList arrayList = viewTransitionController.f2979b;
            if (hashSet == null) {
                viewTransitionController.f2980c = new HashSet();
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ViewTransition viewTransition2 = (ViewTransition) it2.next();
                    int childCount = motionLayout.getChildCount();
                    for (int i3 = 0; i3 < childCount; i3++) {
                        View childAt = motionLayout.getChildAt(i3);
                        if (viewTransition2.m601c(childAt)) {
                            childAt.getId();
                            viewTransitionController.f2980c.add(childAt);
                        }
                    }
                }
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            Rect rect = new Rect();
            int action = motionEvent.getAction();
            ArrayList arrayList2 = viewTransitionController.f2982e;
            int i4 = 2;
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                Iterator it3 = viewTransitionController.f2982e.iterator();
                while (it3.hasNext()) {
                    b43 b43Var = (b43) it3.next();
                    if (action != 1) {
                        if (action != 2) {
                            b43Var.getClass();
                        } else {
                            View view = b43Var.f7890c.getView();
                            Rect rect2 = b43Var.f7899l;
                            view.getHitRect(rect2);
                            if (!rect2.contains((int) x, (int) y) && !b43Var.f7895h) {
                                b43Var.m2018b();
                            }
                        }
                    } else if (!b43Var.f7895h) {
                        b43Var.m2018b();
                    }
                }
            }
            if (action == 0 || action == 1) {
                ConstraintSet constraintSet = motionLayout.getConstraintSet(currentState);
                Iterator it4 = arrayList.iterator();
                while (it4.hasNext()) {
                    ViewTransition viewTransition3 = (ViewTransition) it4.next();
                    int i5 = viewTransition3.f2957b;
                    if (i5 == 1) {
                        if (action != 0) {
                            i4 = i4;
                        }
                        it = viewTransitionController.f2980c.iterator();
                        while (it.hasNext()) {
                            View view2 = (View) it.next();
                            if (viewTransition3.m601c(view2)) {
                                view2.getHitRect(rect);
                                if (rect.contains((int) x, (int) y)) {
                                    viewTransition = viewTransition3;
                                    i2 = i4;
                                    viewTransition3.m599a(viewTransitionController, viewTransitionController.f2978a, currentState, constraintSet, view2);
                                } else {
                                    viewTransition = viewTransition3;
                                    i2 = i4;
                                }
                                viewTransition3 = viewTransition;
                                i4 = i2;
                            }
                        }
                        i4 = i4;
                    } else if (i5 == i4) {
                        if (action != 1) {
                            i4 = i4;
                        }
                        it = viewTransitionController.f2980c.iterator();
                        while (it.hasNext()) {
                        }
                        i4 = i4;
                    } else {
                        if (i5 == 3) {
                            if (action != 0) {
                            }
                            it = viewTransitionController.f2980c.iterator();
                            while (it.hasNext()) {
                            }
                        }
                        i4 = i4;
                    }
                }
            }
        }
        MotionScene.Transition transition = this.f2878r.f2898c;
        if (transition != null && transition.isEnabled() && (touchResponse = transition.getTouchResponse()) != null && ((motionEvent.getAction() != 0 || (m611b = touchResponse.m611b(this, new RectF())) == null || m611b.contains(motionEvent.getX(), motionEvent.getY())) && (i = touchResponse.f3003e) != -1)) {
            View view3 = this.f2846K0;
            if (view3 == null || view3.getId() != i) {
                this.f2846K0 = findViewById(i);
            }
            if (this.f2846K0 != null) {
                RectF rectF = this.f2844J0;
                rectF.set(r1.getLeft(), this.f2846K0.getTop(), this.f2846K0.getRight(), this.f2846K0.getBottom());
                if (rectF.contains(motionEvent.getX(), motionEvent.getY()) && !m580m(this.f2846K0.getLeft(), this.f2846K0.getTop(), this.f2846K0, motionEvent)) {
                    return onTouchEvent(motionEvent);
                }
            }
        }
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f2883t0 = true;
        try {
            if (this.f2878r == null) {
                super.onLayout(z, i, i2, i3, i4);
                return;
            }
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (this.f2855R != i5 || this.f2856S != i6) {
                rebuildScene();
                m577j(true);
            }
            this.f2855R = i5;
            this.f2856S = i6;
        } finally {
            this.f2883t0 = false;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i, int i2) {
        boolean z;
        int i3;
        boolean z2;
        float f;
        if (this.f2878r == null) {
            super.onMeasure(i, i2);
            return;
        }
        boolean z3 = true;
        if (this.f2892y == i && this.f2894z == i2) {
            z = false;
        } else {
            z = true;
        }
        if (this.f2842I0) {
            this.f2842I0 = false;
            m582o();
            m583p();
            z = true;
        }
        if (this.mDirtyHierarchy) {
            z = true;
        }
        this.f2892y = i;
        this.f2894z = i2;
        int m590g = this.f2878r.m590g();
        MotionScene.Transition transition = this.f2878r.f2898c;
        if (transition == null) {
            i3 = -1;
        } else {
            i3 = transition.f2918c;
        }
        C0126a c0126a = this.f2840H0;
        if ((z || m590g != c0126a.f2988e || i3 != c0126a.f2989f) && this.f2886v != -1) {
            super.onMeasure(i, i2);
            c0126a.m607e(this.f2878r.m586b(m590g), this.f2878r.m586b(i3));
            c0126a.m608f();
            c0126a.f2988e = m590g;
            c0126a.f2989f = i3;
            z2 = false;
        } else {
            if (z) {
                super.onMeasure(i, i2);
            }
            z2 = true;
        }
        if (this.mMeasureDuringTransition || z2) {
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            int width = this.mLayoutWidget.getWidth() + getPaddingRight() + getPaddingLeft();
            int height = this.mLayoutWidget.getHeight() + paddingBottom;
            int i4 = this.f2876p0;
            if (i4 == Integer.MIN_VALUE || i4 == 0) {
                width = (int) ((this.f2879r0 * (this.f2874n0 - r1)) + this.f2872l0);
                requestLayout();
            }
            int i5 = this.f2877q0;
            if (i5 == Integer.MIN_VALUE || i5 == 0) {
                height = (int) ((this.f2879r0 * (this.f2875o0 - r2)) + this.f2873m0);
                requestLayout();
            }
            setMeasuredDimension(width, height);
        }
        float signum = Math.signum(this.f2839H - this.f2835F);
        long nanoTime = getNanoTime();
        MotionInterpolator motionInterpolator = this.f2880s;
        if (!(motionInterpolator instanceof StopLogic)) {
            f = ((((float) (nanoTime - this.f2837G)) * signum) * 1.0E-9f) / this.f2831D;
        } else {
            f = 0.0f;
        }
        float f2 = this.f2835F + f;
        if (this.f2841I) {
            f2 = this.f2839H;
        }
        if ((signum > RecyclerView.f7068F0 && f2 >= this.f2839H) || (signum <= RecyclerView.f7068F0 && f2 <= this.f2839H)) {
            f2 = this.f2839H;
        } else {
            z3 = false;
        }
        if (motionInterpolator != null && !z3) {
            if (this.f2851N) {
                f2 = motionInterpolator.getInterpolation(((float) (nanoTime - this.f2829C)) * 1.0E-9f);
            } else {
                f2 = motionInterpolator.getInterpolation(f2);
            }
        }
        if ((signum > RecyclerView.f7068F0 && f2 >= this.f2839H) || (signum <= RecyclerView.f7068F0 && f2 <= this.f2839H)) {
            f2 = this.f2839H;
        }
        this.f2879r0 = f2;
        int childCount = getChildCount();
        long nanoTime2 = getNanoTime();
        Interpolator interpolator = this.f2882t;
        if (interpolator != null) {
            f2 = interpolator.getInterpolation(f2);
        }
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            MotionController motionController = (MotionController) this.f2827B.get(childAt);
            if (motionController != null) {
                motionController.m568f(childAt, f2, nanoTime2, this.f2881s0);
            }
        }
        if (this.mMeasureDuringTransition) {
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View view, float f, float f2, boolean z) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View view, float f, float f2) {
        return false;
    }

    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v5 */
    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(@NonNull View view, int i, int i2, @NonNull int[] iArr, int i3) {
        MotionScene.Transition transition;
        boolean z;
        ?? r1;
        C0128c c0128c;
        float f;
        float f2;
        C0128c c0128c2;
        C0128c c0128c3;
        C0128c touchResponse;
        int i4;
        MotionScene motionScene = this.f2878r;
        if (motionScene != null && (transition = motionScene.f2898c) != null && transition.isEnabled()) {
            int i5 = -1;
            if (transition.isEnabled() && (touchResponse = transition.getTouchResponse()) != null && (i4 = touchResponse.f3003e) != -1 && view.getId() != i4) {
                return;
            }
            MotionScene.Transition transition2 = motionScene.f2898c;
            if (transition2 != null && (c0128c3 = transition2.f2927l) != null) {
                z = c0128c3.f3019u;
            } else {
                z = false;
            }
            if (z) {
                C0128c touchResponse2 = transition.getTouchResponse();
                if (touchResponse2 != null && (touchResponse2.f3021w & 4) != 0) {
                    i5 = i2;
                }
                float f3 = this.f2833E;
                if ((f3 == 1.0f || f3 == RecyclerView.f7068F0) && view.canScrollVertically(i5)) {
                    return;
                }
            }
            if (transition.getTouchResponse() != null && (transition.getTouchResponse().f3021w & 1) != 0) {
                float f4 = i;
                float f5 = i2;
                MotionScene.Transition transition3 = motionScene.f2898c;
                if (transition3 != null && (c0128c2 = transition3.f2927l) != null) {
                    c0128c2.f3016r.m579l(c0128c2.f3002d, c0128c2.f3016r.getProgress(), c0128c2.f3006h, c0128c2.f3005g, c0128c2.f3012n);
                    float f6 = c0128c2.f3009k;
                    float[] fArr = c0128c2.f3012n;
                    if (f6 != RecyclerView.f7068F0) {
                        if (fArr[0] == RecyclerView.f7068F0) {
                            fArr[0] = 1.0E-7f;
                        }
                        f2 = (f4 * f6) / fArr[0];
                    } else {
                        if (fArr[1] == RecyclerView.f7068F0) {
                            fArr[1] = 1.0E-7f;
                        }
                        f2 = (f5 * c0128c2.f3010l) / fArr[1];
                    }
                } else {
                    f2 = 0.0f;
                }
                float f7 = this.f2835F;
                if ((f7 <= RecyclerView.f7068F0 && f2 < RecyclerView.f7068F0) || (f7 >= 1.0f && f2 > RecyclerView.f7068F0)) {
                    view.setNestedScrollingEnabled(false);
                    view.post(new sn1(1, view));
                    return;
                }
            }
            float f8 = this.f2833E;
            long nanoTime = getNanoTime();
            float f9 = i;
            this.f2858U = f9;
            float f10 = i2;
            this.f2859V = f10;
            this.f2861a0 = (float) ((nanoTime - this.f2860W) * 1.0E-9d);
            this.f2860W = nanoTime;
            MotionScene.Transition transition4 = motionScene.f2898c;
            if (transition4 != null && (c0128c = transition4.f2927l) != null) {
                MotionLayout motionLayout = c0128c.f3016r;
                float progress = motionLayout.getProgress();
                if (!c0128c.f3011m) {
                    c0128c.f3011m = true;
                    motionLayout.setProgress(progress);
                }
                c0128c.f3016r.m579l(c0128c.f3002d, progress, c0128c.f3006h, c0128c.f3005g, c0128c.f3012n);
                float f11 = c0128c.f3009k;
                float[] fArr2 = c0128c.f3012n;
                if (Math.abs((c0128c.f3010l * fArr2[1]) + (f11 * fArr2[0])) < 0.01d) {
                    fArr2[0] = 0.01f;
                    fArr2[1] = 0.01f;
                }
                float f12 = c0128c.f3009k;
                if (f12 != RecyclerView.f7068F0) {
                    f = (f9 * f12) / fArr2[0];
                } else {
                    f = (f10 * c0128c.f3010l) / fArr2[1];
                }
                float max = Math.max(Math.min(progress + f, 1.0f), RecyclerView.f7068F0);
                if (max != motionLayout.getProgress()) {
                    motionLayout.setProgress(max);
                }
            }
            if (f8 != this.f2833E) {
                iArr[0] = i;
                r1 = 1;
                iArr[1] = i2;
            } else {
                r1 = 1;
            }
            m577j(false);
            if (iArr[0] != 0 || iArr[r1] != 0) {
                this.f2857T = r1;
            }
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(@NonNull View view, int i, int i2, int i3, int i4, int i5) {
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i, int i2) {
        this.f2860W = getNanoTime();
        this.f2861a0 = RecyclerView.f7068F0;
        this.f2858U = RecyclerView.f7068F0;
        this.f2859V = RecyclerView.f7068F0;
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        MotionScene motionScene = this.f2878r;
        if (motionScene != null) {
            motionScene.setRtl(isRtl());
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i, int i2) {
        MotionScene.Transition transition;
        MotionScene motionScene = this.f2878r;
        if (motionScene != null && (transition = motionScene.f2898c) != null && transition.getTouchResponse() != null && (this.f2878r.f2898c.getTouchResponse().f3021w & 2) == 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(@NonNull View view, int i) {
        C0128c c0128c;
        float f;
        int i2;
        MotionScene motionScene = this.f2878r;
        if (motionScene != null) {
            float f2 = this.f2861a0;
            float f3 = RecyclerView.f7068F0;
            if (f2 != RecyclerView.f7068F0) {
                float f4 = this.f2858U / f2;
                float f5 = this.f2859V / f2;
                MotionScene.Transition transition = motionScene.f2898c;
                if (transition != null && (c0128c = transition.f2927l) != null) {
                    c0128c.f3011m = false;
                    MotionLayout motionLayout = c0128c.f3016r;
                    float progress = motionLayout.getProgress();
                    c0128c.f3016r.m579l(c0128c.f3002d, progress, c0128c.f3006h, c0128c.f3005g, c0128c.f3012n);
                    float f6 = c0128c.f3009k;
                    float[] fArr = c0128c.f3012n;
                    float f7 = fArr[0];
                    float f8 = c0128c.f3010l;
                    float f9 = fArr[1];
                    if (f6 != RecyclerView.f7068F0) {
                        f = (f4 * f6) / f7;
                    } else {
                        f = (f5 * f8) / f9;
                    }
                    if (!Float.isNaN(f)) {
                        progress += f / 3.0f;
                    }
                    if (progress != RecyclerView.f7068F0 && progress != 1.0f && (i2 = c0128c.f3001c) != 3) {
                        if (progress >= 0.5d) {
                            f3 = 1.0f;
                        }
                        motionLayout.touchAnimateTo(i2, f3, f);
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:129:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0667  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0672 A[RETURN] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionScene motionScene;
        MotionLayout motionLayout;
        MotionTracker motionTracker;
        C0128c c0128c;
        char c;
        char c2;
        float f;
        float f2;
        int i;
        float f3;
        char c3;
        char c4;
        char c5;
        float f4;
        boolean z;
        float f5;
        float right;
        float f6;
        int top;
        int bottom;
        int i2;
        float degrees;
        float f7;
        int i3;
        float f8;
        char c6;
        boolean z2;
        MotionEvent motionEvent2;
        boolean z3;
        MotionScene motionScene2 = this.f2878r;
        if (motionScene2 != null && this.f2825A && motionScene2.m598o()) {
            MotionScene.Transition transition = this.f2878r.f2898c;
            if (transition != null && !transition.isEnabled()) {
                return super.onTouchEvent(motionEvent);
            }
            MotionScene motionScene3 = this.f2878r;
            int currentState = getCurrentState();
            motionScene3.getClass();
            RectF rectF = new RectF();
            MotionTracker motionTracker2 = motionScene3.f2911p;
            MotionLayout motionLayout2 = motionScene3.f2896a;
            if (motionTracker2 == null) {
                motionScene3.f2911p = motionLayout2.obtainVelocityTracker();
            }
            motionScene3.f2911p.addMovement(motionEvent);
            if (currentState != -1) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 2 && !motionScene3.f2909n) {
                        float rawY = motionEvent.getRawY() - motionScene3.f2915t;
                        float rawX = motionEvent.getRawX() - motionScene3.f2914s;
                        if ((rawX != 0.0d || rawY != 0.0d) && (motionEvent2 = motionScene3.f2908m) != null) {
                            MotionScene.Transition bestTransitionFor = motionScene3.bestTransitionFor(currentState, rawX, rawY, motionEvent2);
                            if (bestTransitionFor != null) {
                                setTransition(bestTransitionFor);
                                RectF m611b = motionScene3.f2898c.f2927l.m611b(motionLayout2, rectF);
                                if (m611b != null && !m611b.contains(motionScene3.f2908m.getX(), motionScene3.f2908m.getY())) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                motionScene3.f2910o = z3;
                                C0128c c0128c2 = motionScene3.f2898c.f2927l;
                                float f9 = motionScene3.f2914s;
                                float f10 = motionScene3.f2915t;
                                c0128c2.f3014p = f9;
                                c0128c2.f3015q = f10;
                                c0128c2.f3011m = false;
                            }
                        }
                    }
                } else {
                    motionScene3.f2914s = motionEvent.getRawX();
                    motionScene3.f2915t = motionEvent.getRawY();
                    motionScene3.f2908m = motionEvent;
                    motionScene3.f2909n = false;
                    C0128c c0128c3 = motionScene3.f2898c.f2927l;
                    if (c0128c3 != null) {
                        RectF m610a = c0128c3.m610a(motionLayout2, rectF);
                        if (m610a != null && !m610a.contains(motionScene3.f2908m.getX(), motionScene3.f2908m.getY())) {
                            motionScene3.f2908m = null;
                            motionScene3.f2909n = true;
                        } else {
                            RectF m611b2 = motionScene3.f2898c.f2927l.m611b(motionLayout2, rectF);
                            if (m611b2 != null && !m611b2.contains(motionScene3.f2908m.getX(), motionScene3.f2908m.getY())) {
                                motionScene3.f2910o = true;
                            } else {
                                motionScene3.f2910o = false;
                            }
                            C0128c c0128c4 = motionScene3.f2898c.f2927l;
                            float f11 = motionScene3.f2914s;
                            float f12 = motionScene3.f2915t;
                            c0128c4.f3014p = f11;
                            c0128c4.f3015q = f12;
                        }
                    }
                }
                motionLayout = this;
                if (motionLayout.f2878r.f2898c.isTransitionFlag(4)) {
                    return motionLayout.f2878r.f2898c.getTouchResponse().f3011m;
                }
                return true;
            }
            if (!motionScene3.f2909n) {
                MotionScene.Transition transition2 = motionScene3.f2898c;
                if (transition2 != null && (c0128c = transition2.f2927l) != null && !motionScene3.f2910o) {
                    MotionTracker motionTracker3 = motionScene3.f2911p;
                    boolean z4 = c0128c.f3008j;
                    kp1 kp1Var = kp1.f22138d;
                    float[] fArr = c0128c.f3012n;
                    MotionLayout motionLayout3 = c0128c.f3016r;
                    if (z4) {
                        motionTracker3.addMovement(motionEvent);
                        int action2 = motionEvent.getAction();
                        if (action2 != 0) {
                            int[] iArr = c0128c.f3013o;
                            if (action2 != 1) {
                                if (action2 == 2) {
                                    motionEvent.getRawY();
                                    motionEvent.getRawX();
                                    float width = motionLayout3.getWidth() / 2.0f;
                                    float height = motionLayout3.getHeight() / 2.0f;
                                    int i4 = c0128c.f3007i;
                                    if (i4 != -1) {
                                        View findViewById = motionLayout3.findViewById(i4);
                                        motionLayout3.getLocationOnScreen(iArr);
                                        height = ((findViewById.getBottom() + findViewById.getTop()) / 2.0f) + iArr[1];
                                        width = iArr[0] + ((findViewById.getRight() + findViewById.getLeft()) / 2.0f);
                                    } else {
                                        int i5 = c0128c.f3002d;
                                        if (i5 != -1) {
                                            if (motionLayout3.findViewById(((MotionController) motionLayout3.f2827B.get(motionLayout3.findViewById(i5))).getAnimateRelativeTo()) == null) {
                                                Log.e("TouchResponse", "could not find view to animate to");
                                            } else {
                                                motionLayout3.getLocationOnScreen(iArr);
                                                width = iArr[0] + ((r11.getRight() + r11.getLeft()) / 2.0f);
                                                height = ((r11.getBottom() + r11.getTop()) / 2.0f) + iArr[1];
                                            }
                                        }
                                    }
                                    float rawX2 = motionEvent.getRawX() - width;
                                    float rawY2 = motionEvent.getRawY() - height;
                                    float atan2 = (float) (((Math.atan2(motionEvent.getRawY() - height, motionEvent.getRawX() - width) - Math.atan2(c0128c.f3015q - height, c0128c.f3014p - width)) * 180.0d) / 3.141592653589793d);
                                    if (atan2 > 330.0f) {
                                        atan2 -= 360.0f;
                                    } else if (atan2 < -330.0f) {
                                        atan2 += 360.0f;
                                    }
                                    if (Math.abs(atan2) > 0.01d || c0128c.f3011m) {
                                        float progress = motionLayout3.getProgress();
                                        if (!c0128c.f3011m) {
                                            c0128c.f3011m = true;
                                            motionLayout3.setProgress(progress);
                                        }
                                        int i6 = c0128c.f3002d;
                                        if (i6 != -1) {
                                            c0128c.f3016r.m579l(i6, progress, c0128c.f3006h, c0128c.f3005g, c0128c.f3012n);
                                            c6 = 1;
                                            fArr[1] = (float) Math.toDegrees(fArr[1]);
                                        } else {
                                            c6 = 1;
                                            fArr[1] = 360.0f;
                                        }
                                        float max = Math.max(Math.min(((atan2 * c0128c.f3020v) / fArr[c6]) + progress, 1.0f), RecyclerView.f7068F0);
                                        float progress2 = motionLayout3.getProgress();
                                        if (max != progress2) {
                                            if (progress2 == RecyclerView.f7068F0 || progress2 == 1.0f) {
                                                if (progress2 == RecyclerView.f7068F0) {
                                                    z2 = true;
                                                } else {
                                                    z2 = false;
                                                }
                                                motionLayout3.m576i(z2);
                                            }
                                            motionLayout3.setProgress(max);
                                            motionTracker3.computeCurrentVelocity(1000);
                                            float xVelocity = motionTracker3.getXVelocity();
                                            double yVelocity = motionTracker3.getYVelocity();
                                            double d = xVelocity;
                                            motionLayout3.f2884u = (float) Math.toDegrees((float) ((Math.sin(Math.atan2(yVelocity, d) - r10) * Math.hypot(yVelocity, d)) / Math.hypot(rawX2, rawY2)));
                                        } else {
                                            motionLayout3.f2884u = RecyclerView.f7068F0;
                                        }
                                        c0128c.f3014p = motionEvent.getRawX();
                                        c0128c.f3015q = motionEvent.getRawY();
                                    }
                                }
                                motionScene = motionScene3;
                            } else {
                                c0128c.f3011m = false;
                                motionTracker3.computeCurrentVelocity(16);
                                float xVelocity2 = motionTracker3.getXVelocity();
                                float yVelocity2 = motionTracker3.getYVelocity();
                                float progress3 = motionLayout3.getProgress();
                                float width2 = motionLayout3.getWidth() / 2.0f;
                                float height2 = motionLayout3.getHeight() / 2.0f;
                                int i7 = c0128c.f3007i;
                                if (i7 != -1) {
                                    View findViewById2 = motionLayout3.findViewById(i7);
                                    motionLayout3.getLocationOnScreen(iArr);
                                    right = iArr[0] + ((findViewById2.getRight() + findViewById2.getLeft()) / 2.0f);
                                    f6 = iArr[1];
                                    top = findViewById2.getTop();
                                    bottom = findViewById2.getBottom();
                                } else {
                                    int i8 = c0128c.f3002d;
                                    if (i8 != -1) {
                                        View findViewById3 = motionLayout3.findViewById(((MotionController) motionLayout3.f2827B.get(motionLayout3.findViewById(i8))).getAnimateRelativeTo());
                                        motionLayout3.getLocationOnScreen(iArr);
                                        right = iArr[0] + ((findViewById3.getRight() + findViewById3.getLeft()) / 2.0f);
                                        f6 = iArr[1];
                                        top = findViewById3.getTop();
                                        bottom = findViewById3.getBottom();
                                    }
                                    float rawX3 = motionEvent.getRawX() - width2;
                                    double degrees2 = Math.toDegrees(Math.atan2(motionEvent.getRawY() - height2, rawX3));
                                    i2 = c0128c.f3002d;
                                    if (i2 == -1) {
                                        motionScene = motionScene3;
                                        c0128c.f3016r.m579l(i2, progress3, c0128c.f3006h, c0128c.f3005g, c0128c.f3012n);
                                        fArr[1] = (float) Math.toDegrees(fArr[1]);
                                    } else {
                                        motionScene = motionScene3;
                                        fArr[1] = 360.0f;
                                    }
                                    degrees = ((float) (Math.toDegrees(Math.atan2(yVelocity2 + r6, xVelocity2 + rawX3)) - degrees2)) * 62.5f;
                                    if (Float.isNaN(degrees)) {
                                        f7 = (((degrees * 3.0f) * c0128c.f3020v) / fArr[1]) + progress3;
                                    } else {
                                        f7 = progress3;
                                    }
                                    if (f7 == RecyclerView.f7068F0 && f7 != 1.0f && (i3 = c0128c.f3001c) != 3) {
                                        float f13 = (degrees * c0128c.f3020v) / fArr[1];
                                        if (f7 < 0.5d) {
                                            f8 = RecyclerView.f7068F0;
                                        } else {
                                            f8 = 1.0f;
                                        }
                                        if (i3 == 6) {
                                            if (progress3 + f13 < RecyclerView.f7068F0) {
                                                f13 = Math.abs(f13);
                                            }
                                            f8 = 1.0f;
                                        }
                                        if (c0128c.f3001c == 7) {
                                            if (progress3 + f13 > 1.0f) {
                                                f13 = -Math.abs(f13);
                                            }
                                            f8 = RecyclerView.f7068F0;
                                        }
                                        motionLayout3.touchAnimateTo(c0128c.f3001c, f8, f13 * 3.0f);
                                        if (RecyclerView.f7068F0 >= progress3 || 1.0f <= progress3) {
                                            motionLayout3.setState(kp1Var);
                                        }
                                    } else if (RecyclerView.f7068F0 < f7 || 1.0f <= f7) {
                                        motionLayout3.setState(kp1Var);
                                    }
                                }
                                float f14 = right;
                                height2 = ((bottom + top) / 2.0f) + f6;
                                width2 = f14;
                                float rawX32 = motionEvent.getRawX() - width2;
                                double degrees22 = Math.toDegrees(Math.atan2(motionEvent.getRawY() - height2, rawX32));
                                i2 = c0128c.f3002d;
                                if (i2 == -1) {
                                }
                                degrees = ((float) (Math.toDegrees(Math.atan2(yVelocity2 + r6, xVelocity2 + rawX32)) - degrees22)) * 62.5f;
                                if (Float.isNaN(degrees)) {
                                }
                                if (f7 == RecyclerView.f7068F0) {
                                }
                                if (RecyclerView.f7068F0 < f7) {
                                }
                                motionLayout3.setState(kp1Var);
                            }
                        } else {
                            motionScene = motionScene3;
                            c0128c.f3014p = motionEvent.getRawX();
                            c0128c.f3015q = motionEvent.getRawY();
                            c0128c.f3011m = false;
                        }
                    } else {
                        motionScene = motionScene3;
                        motionTracker3.addMovement(motionEvent);
                        int action3 = motionEvent.getAction();
                        if (action3 != 0) {
                            if (action3 != 1) {
                                if (action3 == 2) {
                                    float rawY3 = motionEvent.getRawY() - c0128c.f3015q;
                                    float rawX4 = motionEvent.getRawX() - c0128c.f3014p;
                                    if (Math.abs((c0128c.f3010l * rawY3) + (c0128c.f3009k * rawX4)) > c0128c.f3022x || c0128c.f3011m) {
                                        float progress4 = motionLayout3.getProgress();
                                        if (!c0128c.f3011m) {
                                            c0128c.f3011m = true;
                                            motionLayout3.setProgress(progress4);
                                        }
                                        int i9 = c0128c.f3002d;
                                        if (i9 != -1) {
                                            c0128c.f3016r.m579l(i9, progress4, c0128c.f3006h, c0128c.f3005g, c0128c.f3012n);
                                            c4 = 0;
                                            c3 = 1;
                                        } else {
                                            float min = Math.min(motionLayout3.getWidth(), motionLayout3.getHeight());
                                            c3 = 1;
                                            fArr[1] = c0128c.f3010l * min;
                                            c4 = 0;
                                            fArr[0] = min * c0128c.f3009k;
                                        }
                                        if (Math.abs(((c0128c.f3010l * fArr[c3]) + (c0128c.f3009k * fArr[c4])) * c0128c.f3020v) < 0.01d) {
                                            c5 = 0;
                                            fArr[0] = 0.01f;
                                            fArr[c3] = 0.01f;
                                        } else {
                                            c5 = 0;
                                        }
                                        if (c0128c.f3009k != RecyclerView.f7068F0) {
                                            f4 = rawX4 / fArr[c5];
                                        } else {
                                            f4 = rawY3 / fArr[c3];
                                        }
                                        float max2 = Math.max(Math.min(progress4 + f4, 1.0f), RecyclerView.f7068F0);
                                        if (c0128c.f3001c == 6) {
                                            max2 = Math.max(max2, 0.01f);
                                        }
                                        if (c0128c.f3001c == 7) {
                                            max2 = Math.min(max2, 0.99f);
                                        }
                                        float progress5 = motionLayout3.getProgress();
                                        if (max2 != progress5) {
                                            if (progress5 == RecyclerView.f7068F0 || progress5 == 1.0f) {
                                                if (progress5 == RecyclerView.f7068F0) {
                                                    z = true;
                                                } else {
                                                    z = false;
                                                }
                                                motionLayout3.m576i(z);
                                            }
                                            motionLayout3.setProgress(max2);
                                            motionTracker3.computeCurrentVelocity(1000);
                                            float xVelocity3 = motionTracker3.getXVelocity();
                                            float yVelocity3 = motionTracker3.getYVelocity();
                                            if (c0128c.f3009k != RecyclerView.f7068F0) {
                                                f5 = xVelocity3 / fArr[0];
                                            } else {
                                                f5 = yVelocity3 / fArr[1];
                                            }
                                            motionLayout3.f2884u = f5;
                                        } else {
                                            motionLayout3.f2884u = RecyclerView.f7068F0;
                                        }
                                        c0128c.f3014p = motionEvent.getRawX();
                                        c0128c.f3015q = motionEvent.getRawY();
                                    }
                                }
                            } else {
                                c0128c.f3011m = false;
                                motionTracker3.computeCurrentVelocity(1000);
                                float xVelocity4 = motionTracker3.getXVelocity();
                                float yVelocity4 = motionTracker3.getYVelocity();
                                float progress6 = motionLayout3.getProgress();
                                int i10 = c0128c.f3002d;
                                if (i10 != -1) {
                                    c0128c.f3016r.m579l(i10, progress6, c0128c.f3006h, c0128c.f3005g, c0128c.f3012n);
                                    c2 = 0;
                                    c = 1;
                                } else {
                                    float min2 = Math.min(motionLayout3.getWidth(), motionLayout3.getHeight());
                                    c = 1;
                                    fArr[1] = c0128c.f3010l * min2;
                                    c2 = 0;
                                    fArr[0] = min2 * c0128c.f3009k;
                                }
                                float f15 = c0128c.f3009k;
                                float f16 = fArr[c2];
                                float f17 = fArr[c];
                                if (f15 != RecyclerView.f7068F0) {
                                    f = xVelocity4 / f16;
                                } else {
                                    f = yVelocity4 / f17;
                                }
                                if (!Float.isNaN(f)) {
                                    f2 = (f / 3.0f) + progress6;
                                } else {
                                    f2 = progress6;
                                }
                                if (f2 != RecyclerView.f7068F0 && f2 != 1.0f && (i = c0128c.f3001c) != 3) {
                                    if (f2 < 0.5d) {
                                        f3 = RecyclerView.f7068F0;
                                    } else {
                                        f3 = 1.0f;
                                    }
                                    if (i == 6) {
                                        if (progress6 + f < RecyclerView.f7068F0) {
                                            f = Math.abs(f);
                                        }
                                        f3 = 1.0f;
                                    }
                                    if (c0128c.f3001c == 7) {
                                        if (progress6 + f > 1.0f) {
                                            f = -Math.abs(f);
                                        }
                                        f3 = RecyclerView.f7068F0;
                                    }
                                    motionLayout3.touchAnimateTo(c0128c.f3001c, f3, f);
                                    if (RecyclerView.f7068F0 >= progress6 || 1.0f <= progress6) {
                                        motionLayout3.setState(kp1Var);
                                    }
                                } else if (RecyclerView.f7068F0 >= f2 || 1.0f <= f2) {
                                    motionLayout3.setState(kp1Var);
                                }
                            }
                        } else {
                            c0128c.f3014p = motionEvent.getRawX();
                            c0128c.f3015q = motionEvent.getRawY();
                            c0128c.f3011m = false;
                        }
                    }
                } else {
                    motionScene = motionScene3;
                }
                MotionScene motionScene4 = motionScene;
                motionScene4.f2914s = motionEvent.getRawX();
                motionScene4.f2915t = motionEvent.getRawY();
                if (motionEvent.getAction() == 1 && (motionTracker = motionScene4.f2911p) != null) {
                    motionTracker.recycle();
                    motionScene4.f2911p = null;
                    motionLayout = this;
                    int i11 = motionLayout.f2888w;
                    if (i11 != -1) {
                        motionScene4.m585a(motionLayout, i11);
                    }
                } else {
                    motionLayout = this;
                }
                if (motionLayout.f2878r.f2898c.isTransitionFlag(4)) {
                }
            }
            motionLayout = this;
            if (motionLayout.f2878r.f2898c.isTransitionFlag(4)) {
            }
        } else {
            return super.onTouchEvent(motionEvent);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof MotionHelper) {
            MotionHelper motionHelper = (MotionHelper) view;
            if (this.f2866f0 == null) {
                this.f2866f0 = new CopyOnWriteArrayList();
            }
            this.f2866f0.add(motionHelper);
            if (motionHelper.isUsedOnShow()) {
                if (this.f2863c0 == null) {
                    this.f2863c0 = new ArrayList();
                }
                this.f2863c0.add(motionHelper);
            }
            if (motionHelper.isUseOnHide()) {
                if (this.f2864d0 == null) {
                    this.f2864d0 = new ArrayList();
                }
                this.f2864d0.add(motionHelper);
            }
            if (motionHelper.isDecorator()) {
                if (this.f2865e0 == null) {
                    this.f2865e0 = new ArrayList();
                }
                this.f2865e0.add(motionHelper);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList arrayList = this.f2863c0;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList arrayList2 = this.f2864d0;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    /* renamed from: p */
    public final void m583p() {
        CopyOnWriteArrayList copyOnWriteArrayList;
        if (this.f2845K == null && ((copyOnWriteArrayList = this.f2866f0) == null || copyOnWriteArrayList.isEmpty())) {
            return;
        }
        ArrayList arrayList = this.f2850M0;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            TransitionListener transitionListener = this.f2845K;
            if (transitionListener != null) {
                transitionListener.onTransitionCompleted(this, num.intValue());
            }
            CopyOnWriteArrayList copyOnWriteArrayList2 = this.f2866f0;
            if (copyOnWriteArrayList2 != null) {
                Iterator it2 = copyOnWriteArrayList2.iterator();
                while (it2.hasNext()) {
                    ((TransitionListener) it2.next()).onTransitionCompleted(this, num.intValue());
                }
            }
        }
        arrayList.clear();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void parseLayoutDescription(int i) {
        this.mConstraintLayoutSpec = null;
    }

    @Deprecated
    public void rebuildMotion() {
        Log.e("MotionLayout", "This method is deprecated. Please call rebuildScene() instead.");
        rebuildScene();
    }

    public void rebuildScene() {
        this.f2840H0.m608f();
        invalidate();
    }

    public boolean removeTransitionListener(TransitionListener transitionListener) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f2866f0;
        if (copyOnWriteArrayList == null) {
            return false;
        }
        return copyOnWriteArrayList.remove(transitionListener);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        MotionScene motionScene;
        MotionScene.Transition transition;
        if (!this.mMeasureDuringTransition && this.f2888w == -1 && (motionScene = this.f2878r) != null && (transition = motionScene.f2898c) != null) {
            int layoutDuringTransition = transition.getLayoutDuringTransition();
            if (layoutDuringTransition == 0) {
                return;
            }
            if (layoutDuringTransition == 2) {
                int childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    ((MotionController) this.f2827B.get(getChildAt(i))).remeasure();
                }
                return;
            }
        }
        super.requestLayout();
    }

    public void rotateTo(int i, int i2) {
        int i3 = 1;
        this.f2893y0 = true;
        this.f2828B0 = getWidth();
        this.f2830C0 = getHeight();
        int rotation = getDisplay().getRotation();
        if ((rotation + 1) % 4 <= (this.f2832D0 + 1) % 4) {
            i3 = 2;
        }
        this.f2895z0 = i3;
        this.f2832D0 = rotation;
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            HashMap hashMap = this.f2826A0;
            ViewState viewState = (ViewState) hashMap.get(childAt);
            if (viewState == null) {
                viewState = new ViewState();
                hashMap.put(childAt, viewState);
            }
            viewState.getState(childAt);
        }
        this.f2886v = -1;
        this.f2890x = i;
        this.f2878r.m597n(-1, i);
        this.f2840H0.m607e(null, this.f2878r.m586b(this.f2890x));
        this.f2833E = RecyclerView.f7068F0;
        this.f2835F = RecyclerView.f7068F0;
        invalidate();
        transitionToEnd(new gp1(this, 1));
        if (i2 > 0) {
            this.f2831D = i2 / 1000.0f;
        }
    }

    public void scheduleTransitionTo(int i) {
        if (getCurrentState() == -1) {
            transitionToState(i);
            return;
        }
        int[] iArr = this.f2889w0;
        if (iArr == null) {
            this.f2889w0 = new int[4];
        } else if (iArr.length <= this.f2891x0) {
            this.f2889w0 = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f2889w0;
        int i2 = this.f2891x0;
        this.f2891x0 = i2 + 1;
        iArr2[i2] = i;
    }

    public void setDebugMode(int i) {
        this.f2847L = i;
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean z) {
        this.f2836F0 = z;
    }

    public void setInteractionEnabled(boolean z) {
        this.f2825A = z;
    }

    public void setInterpolatedProgress(float f) {
        if (this.f2878r != null) {
            setState(kp1.f22137c);
            Interpolator interpolator = this.f2878r.getInterpolator();
            if (interpolator != null) {
                setProgress(interpolator.getInterpolation(f));
                return;
            }
        }
        setProgress(f);
    }

    public void setOnHide(float f) {
        ArrayList arrayList = this.f2864d0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((MotionHelper) this.f2864d0.get(i)).setProgress(f);
            }
        }
    }

    public void setOnShow(float f) {
        ArrayList arrayList = this.f2863c0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((MotionHelper) this.f2863c0.get(i)).setProgress(f);
            }
        }
    }

    public void setProgress(float f, float f2) {
        if (!isAttachedToWindow()) {
            if (this.f2885u0 == null) {
                this.f2885u0 = new jp1(this);
            }
            jp1 jp1Var = this.f2885u0;
            jp1Var.f20575a = f;
            jp1Var.f20576b = f2;
            return;
        }
        setProgress(f);
        setState(kp1.f22137c);
        this.f2884u = f2;
        float f3 = RecyclerView.f7068F0;
        if (f2 != RecyclerView.f7068F0) {
            if (f2 > RecyclerView.f7068F0) {
                f3 = 1.0f;
            }
            m575h(f3);
        } else {
            if (f == RecyclerView.f7068F0 || f == 1.0f) {
                return;
            }
            if (f > 0.5f) {
                f3 = 1.0f;
            }
            m575h(f3);
        }
    }

    public void setScene(MotionScene motionScene) {
        this.f2878r = motionScene;
        motionScene.setRtl(isRtl());
        rebuildScene();
    }

    public void setStartState(int i) {
        if (!isAttachedToWindow()) {
            if (this.f2885u0 == null) {
                this.f2885u0 = new jp1(this);
            }
            jp1 jp1Var = this.f2885u0;
            jp1Var.f20577c = i;
            jp1Var.f20578d = i;
            return;
        }
        this.f2888w = i;
    }

    public void setState(kp1 kp1Var) {
        kp1 kp1Var2 = kp1.f22138d;
        if (kp1Var == kp1Var2 && this.f2888w == -1) {
            return;
        }
        kp1 kp1Var3 = this.f2838G0;
        this.f2838G0 = kp1Var;
        kp1 kp1Var4 = kp1.f22137c;
        if (kp1Var3 == kp1Var4 && kp1Var == kp1Var4) {
            m578k();
        }
        int ordinal = kp1Var3.ordinal();
        if (ordinal != 0 && ordinal != 1) {
            if (ordinal == 2 && kp1Var == kp1Var2) {
                fireTransitionCompleted();
                return;
            }
            return;
        }
        if (kp1Var == kp1Var4) {
            m578k();
        }
        if (kp1Var == kp1Var2) {
            fireTransitionCompleted();
        }
    }

    public void setTransition(int i, int i2) {
        if (!isAttachedToWindow()) {
            if (this.f2885u0 == null) {
                this.f2885u0 = new jp1(this);
            }
            jp1 jp1Var = this.f2885u0;
            jp1Var.f20577c = i;
            jp1Var.f20578d = i2;
            return;
        }
        MotionScene motionScene = this.f2878r;
        if (motionScene != null) {
            this.f2886v = i;
            this.f2890x = i2;
            motionScene.m597n(i, i2);
            this.f2840H0.m607e(this.f2878r.m586b(i), this.f2878r.m586b(i2));
            rebuildScene();
            this.f2835F = RecyclerView.f7068F0;
            transitionToStart();
        }
    }

    public void setTransitionDuration(int i) {
        MotionScene motionScene = this.f2878r;
        if (motionScene == null) {
            Log.e("MotionLayout", "MotionScene not defined");
        } else {
            motionScene.setDuration(i);
        }
    }

    public void setTransitionListener(TransitionListener transitionListener) {
        this.f2845K = transitionListener;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.f2885u0 == null) {
            this.f2885u0 = new jp1(this);
        }
        jp1 jp1Var = this.f2885u0;
        jp1Var.getClass();
        jp1Var.f20575a = bundle.getFloat("motion.progress");
        jp1Var.f20576b = bundle.getFloat("motion.velocity");
        jp1Var.f20577c = bundle.getInt("motion.StartState");
        jp1Var.f20578d = bundle.getInt("motion.EndState");
        if (isAttachedToWindow()) {
            this.f2885u0.m5448a();
        }
    }

    @Override // android.view.View
    public String toString() {
        Context context = getContext();
        return Debug.getName(context, this.f2886v) + "->" + Debug.getName(context, this.f2890x) + " (pos:" + this.f2835F + " Dpos/Dt:" + this.f2884u;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0046, code lost:
    
        if (r16 != 7) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0063, code lost:
    
        if ((((r18 * r5) - (((r2 * r5) * r5) / 2.0f)) + r1) > 1.0f) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0085, code lost:
    
        r2 = r15.f2835F;
        r5 = r15.f2831D;
        r6 = r15.f2878r.m589f();
        r1 = r15.f2878r.f2898c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0093, code lost:
    
        if (r1 == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0095, code lost:
    
        r1 = r1.f2927l;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0097, code lost:
    
        if (r1 == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0099, code lost:
    
        r7 = r1.f3017s;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x009e, code lost:
    
        r15.f2852O.config(r2, r17, r18, r5, r6, r7);
        r15.f2884u = androidx.recyclerview.widget.RecyclerView.f7068F0;
        r1 = r15.f2888w;
        r15.f2839H = r17;
        r15.f2888w = r1;
        r15.f2880s = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x009d, code lost:
    
        r7 = 0.0f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0073, code lost:
    
        r1 = r15.f2835F;
        r2 = r15.f2878r.m589f();
        r13.f18125a = r18;
        r13.f18126b = r1;
        r13.f18127c = r2;
        r15.f2880s = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0071, code lost:
    
        if ((((((r2 * r3) * r3) / 2.0f) + (r18 * r3)) + r1) < androidx.recyclerview.widget.RecyclerView.f7068F0) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void touchAnimateTo(int i, float f, float f2) {
        float f3;
        int i2;
        float f4;
        float f5;
        float f6;
        float f7;
        int i3;
        C0128c c0128c;
        C0128c c0128c2;
        C0128c c0128c3;
        C0128c c0128c4;
        C0128c c0128c5;
        float f8;
        C0128c c0128c6;
        C0128c c0128c7;
        if (this.f2878r == null || this.f2835F == f) {
            return;
        }
        this.f2851N = true;
        this.f2829C = getNanoTime();
        float duration = this.f2878r.getDuration() / 1000.0f;
        this.f2831D = duration;
        this.f2839H = f;
        this.f2843J = true;
        StopLogic stopLogic = this.f2852O;
        if (i != 0 && i != 1 && i != 2) {
            hp1 hp1Var = this.f2853P;
            if (i != 4) {
                if (i != 5) {
                    if (i != 6) {
                    }
                } else {
                    float f9 = this.f2835F;
                    float m589f = this.f2878r.m589f();
                    if (f2 > RecyclerView.f7068F0) {
                        float f10 = f2 / m589f;
                    } else {
                        float f11 = (-f2) / m589f;
                    }
                }
            } else {
                float f12 = this.f2835F;
                float m589f2 = this.f2878r.m589f();
                hp1Var.f18125a = f2;
                hp1Var.f18126b = f12;
                hp1Var.f18127c = m589f2;
                this.f2880s = hp1Var;
            }
            this.f2841I = false;
            this.f2829C = getNanoTime();
            invalidate();
        }
        if (i != 1 && i != 7) {
            if (i != 2 && i != 6) {
                f3 = f;
            } else {
                f3 = 1.0f;
            }
        } else {
            f3 = 0.0f;
        }
        MotionScene motionScene = this.f2878r;
        MotionScene.Transition transition = motionScene.f2898c;
        if (transition != null && (c0128c7 = transition.f2927l) != null) {
            i2 = c0128c7.f2998D;
        } else {
            i2 = 0;
        }
        if (i2 == 0) {
            float f13 = this.f2835F;
            float m589f3 = motionScene.m589f();
            MotionScene.Transition transition2 = this.f2878r.f2898c;
            if (transition2 != null && (c0128c6 = transition2.f2927l) != null) {
                f8 = c0128c6.f3017s;
            } else {
                f8 = 0.0f;
            }
            this.f2852O.config(f13, f3, f2, duration, m589f3, f8);
        } else {
            float f14 = this.f2835F;
            if (transition != null && (c0128c5 = transition.f2927l) != null) {
                f4 = c0128c5.f3024z;
            } else {
                f4 = 0.0f;
            }
            if (transition != null && (c0128c4 = transition.f2927l) != null) {
                f5 = c0128c4.f2995A;
            } else {
                f5 = 0.0f;
            }
            if (transition != null && (c0128c3 = transition.f2927l) != null) {
                f6 = c0128c3.f3023y;
            } else {
                f6 = 0.0f;
            }
            if (transition != null && (c0128c2 = transition.f2927l) != null) {
                f7 = c0128c2.f2996B;
            } else {
                f7 = 0.0f;
            }
            if (transition != null && (c0128c = transition.f2927l) != null) {
                i3 = c0128c.f2997C;
            } else {
                i3 = 0;
            }
            stopLogic.springConfig(f14, f3, f2, f4, f5, f6, f7, i3);
        }
        int i4 = this.f2888w;
        this.f2839H = f3;
        this.f2888w = i4;
        this.f2880s = stopLogic;
        this.f2841I = false;
        this.f2829C = getNanoTime();
        invalidate();
    }

    public void touchSpringTo(float f, float f2) {
        float f3;
        float f4;
        float f5;
        int i;
        C0128c c0128c;
        C0128c c0128c2;
        C0128c c0128c3;
        C0128c c0128c4;
        C0128c c0128c5;
        if (this.f2878r == null || this.f2835F == f) {
            return;
        }
        this.f2851N = true;
        this.f2829C = getNanoTime();
        this.f2831D = this.f2878r.getDuration() / 1000.0f;
        this.f2839H = f;
        this.f2843J = true;
        float f6 = this.f2835F;
        MotionScene.Transition transition = this.f2878r.f2898c;
        float f7 = RecyclerView.f7068F0;
        if (transition != null && (c0128c5 = transition.f2927l) != null) {
            f3 = c0128c5.f3024z;
        } else {
            f3 = 0.0f;
        }
        if (transition != null && (c0128c4 = transition.f2927l) != null) {
            f4 = c0128c4.f2995A;
        } else {
            f4 = 0.0f;
        }
        if (transition != null && (c0128c3 = transition.f2927l) != null) {
            f5 = c0128c3.f3023y;
        } else {
            f5 = 0.0f;
        }
        if (transition != null && (c0128c2 = transition.f2927l) != null) {
            f7 = c0128c2.f2996B;
        }
        float f8 = f7;
        if (transition != null && (c0128c = transition.f2927l) != null) {
            i = c0128c.f2997C;
        } else {
            i = 0;
        }
        this.f2852O.springConfig(f6, f, f2, f3, f4, f5, f8, i);
        int i2 = this.f2888w;
        this.f2839H = f;
        this.f2888w = i2;
        this.f2880s = this.f2852O;
        this.f2841I = false;
        this.f2829C = getNanoTime();
        invalidate();
    }

    public void transitionToEnd() {
        m575h(1.0f);
        this.f2887v0 = null;
    }

    public void transitionToStart() {
        m575h(RecyclerView.f7068F0);
    }

    public void transitionToState(int i) {
        if (!isAttachedToWindow()) {
            if (this.f2885u0 == null) {
                this.f2885u0 = new jp1(this);
            }
            this.f2885u0.f20578d = i;
            return;
        }
        transitionToState(i, -1, -1);
    }

    public void updateState(int i, ConstraintSet constraintSet) {
        MotionScene motionScene = this.f2878r;
        if (motionScene != null) {
            motionScene.setConstraintSet(i, constraintSet);
        }
        updateState();
        if (this.f2888w == i) {
            constraintSet.applyTo(this);
        }
    }

    public void updateStateAnimate(int i, ConstraintSet constraintSet, int i2) {
        if (this.f2878r != null && this.f2888w == i) {
            int i3 = R.id.view_transition;
            updateState(i3, getConstraintSet(i));
            setState(i3, -1, -1);
            updateState(i, constraintSet);
            MotionScene.Transition transition = new MotionScene.Transition(-1, this.f2878r, i3, i);
            transition.setDuration(i2);
            setTransition(transition);
            transitionToEnd();
        }
    }

    public void viewTransition(int i, View... viewArr) {
        MotionScene motionScene = this.f2878r;
        if (motionScene != null) {
            motionScene.viewTransition(i, viewArr);
        } else {
            Log.e("MotionLayout", " no motionScene");
        }
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(@NonNull View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        if (this.f2857T || i != 0 || i2 != 0) {
            iArr[0] = iArr[0] + i3;
            iArr[1] = iArr[1] + i4;
        }
        this.f2857T = false;
    }

    public void transitionToStart(Runnable runnable) {
        m575h(RecyclerView.f7068F0);
        this.f2887v0 = runnable;
    }

    public void transitionToEnd(Runnable runnable) {
        m575h(1.0f);
        this.f2887v0 = runnable;
    }

    public void updateState() {
        this.f2840H0.m607e(this.f2878r.m586b(this.f2886v), this.f2878r.m586b(this.f2890x));
        rebuildScene();
    }

    public void transitionToState(int i, int i2) {
        if (!isAttachedToWindow()) {
            if (this.f2885u0 == null) {
                this.f2885u0 = new jp1(this);
            }
            this.f2885u0.f20578d = i;
            return;
        }
        transitionToState(i, -1, -1, i2);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setState(int i, int i2, int i3) {
        setState(kp1.f22136b);
        this.f2888w = i;
        this.f2886v = -1;
        this.f2890x = -1;
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.updateConstraints(i, i2, i3);
            return;
        }
        MotionScene motionScene = this.f2878r;
        if (motionScene != null) {
            motionScene.m586b(i).applyTo(this);
        }
    }

    public void setProgress(float f) {
        if (f < RecyclerView.f7068F0 || f > 1.0f) {
            Log.w("MotionLayout", "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
        }
        if (!isAttachedToWindow()) {
            if (this.f2885u0 == null) {
                this.f2885u0 = new jp1(this);
            }
            this.f2885u0.f20575a = f;
            return;
        }
        kp1 kp1Var = kp1.f22138d;
        kp1 kp1Var2 = kp1.f22137c;
        if (f <= RecyclerView.f7068F0) {
            if (this.f2835F == 1.0f && this.f2888w == this.f2890x) {
                setState(kp1Var2);
            }
            this.f2888w = this.f2886v;
            if (this.f2835F == RecyclerView.f7068F0) {
                setState(kp1Var);
            }
        } else if (f >= 1.0f) {
            if (this.f2835F == RecyclerView.f7068F0 && this.f2888w == this.f2886v) {
                setState(kp1Var2);
            }
            this.f2888w = this.f2890x;
            if (this.f2835F == 1.0f) {
                setState(kp1Var);
            }
        } else {
            this.f2888w = -1;
            setState(kp1Var2);
        }
        if (this.f2878r == null) {
            return;
        }
        this.f2841I = true;
        this.f2839H = f;
        this.f2833E = f;
        this.f2837G = -1L;
        this.f2829C = -1L;
        this.f2880s = null;
        this.f2843J = true;
        invalidate();
    }

    public void transitionToState(int i, int i2, int i3) {
        transitionToState(i, i2, i3, -1);
    }

    public void transitionToState(int i, int i2, int i3, int i4) {
        StateSet stateSet;
        int convertToConstraintSet;
        MotionScene motionScene = this.f2878r;
        if (motionScene != null && (stateSet = motionScene.f2897b) != null && (convertToConstraintSet = stateSet.convertToConstraintSet(this.f2888w, i, i2, i3)) != -1) {
            i = convertToConstraintSet;
        }
        int i5 = this.f2888w;
        if (i5 == i) {
            return;
        }
        if (this.f2886v == i) {
            m575h(RecyclerView.f7068F0);
            if (i4 > 0) {
                this.f2831D = i4 / 1000.0f;
                return;
            }
            return;
        }
        if (this.f2890x == i) {
            m575h(1.0f);
            if (i4 > 0) {
                this.f2831D = i4 / 1000.0f;
                return;
            }
            return;
        }
        this.f2890x = i;
        if (i5 != -1) {
            setTransition(i5, i);
            m575h(1.0f);
            this.f2835F = RecyclerView.f7068F0;
            transitionToEnd();
            if (i4 > 0) {
                this.f2831D = i4 / 1000.0f;
                return;
            }
            return;
        }
        this.f2851N = false;
        this.f2839H = 1.0f;
        this.f2833E = RecyclerView.f7068F0;
        this.f2835F = RecyclerView.f7068F0;
        this.f2837G = getNanoTime();
        this.f2829C = getNanoTime();
        this.f2841I = false;
        this.f2880s = null;
        if (i4 == -1) {
            this.f2831D = this.f2878r.getDuration() / 1000.0f;
        }
        this.f2886v = -1;
        this.f2878r.m597n(-1, this.f2890x);
        SparseArray sparseArray = new SparseArray();
        if (i4 == 0) {
            this.f2831D = this.f2878r.getDuration() / 1000.0f;
        } else if (i4 > 0) {
            this.f2831D = i4 / 1000.0f;
        }
        int childCount = getChildCount();
        HashMap<View, MotionController> hashMap = this.f2827B;
        hashMap.clear();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            hashMap.put(childAt, new MotionController(childAt));
            sparseArray.put(childAt.getId(), hashMap.get(childAt));
        }
        this.f2843J = true;
        ConstraintSet m586b = this.f2878r.m586b(i);
        C0126a c0126a = this.f2840H0;
        c0126a.m607e(null, m586b);
        rebuildScene();
        c0126a.m605a();
        int childCount2 = getChildCount();
        for (int i7 = 0; i7 < childCount2; i7++) {
            View childAt2 = getChildAt(i7);
            MotionController motionController = hashMap.get(childAt2);
            if (motionController != null) {
                lp1 lp1Var = motionController.f2801f;
                lp1Var.f22610c = RecyclerView.f7068F0;
                lp1Var.f22611d = RecyclerView.f7068F0;
                lp1Var.m5968e(childAt2.getX(), childAt2.getY(), childAt2.getWidth(), childAt2.getHeight());
                cp1 cp1Var = motionController.f2803h;
                cp1Var.getClass();
                childAt2.getX();
                childAt2.getY();
                childAt2.getWidth();
                childAt2.getHeight();
                cp1Var.m4484b(childAt2);
            }
        }
        int width = getWidth();
        int height = getHeight();
        if (this.f2865e0 != null) {
            for (int i8 = 0; i8 < childCount; i8++) {
                MotionController motionController2 = hashMap.get(getChildAt(i8));
                if (motionController2 != null) {
                    this.f2878r.getKeyFrames(motionController2);
                }
            }
            Iterator it = this.f2865e0.iterator();
            while (it.hasNext()) {
                ((MotionHelper) it.next()).onPreSetup(this, hashMap);
            }
            for (int i9 = 0; i9 < childCount; i9++) {
                MotionController motionController3 = hashMap.get(getChildAt(i9));
                if (motionController3 != null) {
                    motionController3.setup(width, height, this.f2831D, getNanoTime());
                }
            }
        } else {
            for (int i10 = 0; i10 < childCount; i10++) {
                MotionController motionController4 = hashMap.get(getChildAt(i10));
                if (motionController4 != null) {
                    this.f2878r.getKeyFrames(motionController4);
                    motionController4.setup(width, height, this.f2831D, getNanoTime());
                }
            }
        }
        float staggered = this.f2878r.getStaggered();
        if (staggered != RecyclerView.f7068F0) {
            float f = Float.MAX_VALUE;
            float f2 = -3.4028235E38f;
            for (int i11 = 0; i11 < childCount; i11++) {
                MotionController motionController5 = hashMap.get(getChildAt(i11));
                float finalY = motionController5.getFinalY() + motionController5.getFinalX();
                f = Math.min(f, finalY);
                f2 = Math.max(f2, finalY);
            }
            for (int i12 = 0; i12 < childCount; i12++) {
                MotionController motionController6 = hashMap.get(getChildAt(i12));
                float finalX = motionController6.getFinalX();
                float finalY2 = motionController6.getFinalY();
                motionController6.f2809n = 1.0f / (1.0f - staggered);
                motionController6.f2808m = staggered - ((((finalX + finalY2) - f) * staggered) / (f2 - f));
            }
        }
        this.f2833E = RecyclerView.f7068F0;
        this.f2835F = RecyclerView.f7068F0;
        this.f2843J = true;
        invalidate();
    }

    public void setTransition(int i) {
        float f;
        if (this.f2878r != null) {
            MotionScene.Transition transition = getTransition(i);
            this.f2886v = transition.getStartConstraintSetId();
            this.f2890x = transition.getEndConstraintSetId();
            if (!isAttachedToWindow()) {
                if (this.f2885u0 == null) {
                    this.f2885u0 = new jp1(this);
                }
                jp1 jp1Var = this.f2885u0;
                jp1Var.f20577c = this.f2886v;
                jp1Var.f20578d = this.f2890x;
                return;
            }
            int i2 = this.f2888w;
            int i3 = this.f2886v;
            float f2 = RecyclerView.f7068F0;
            if (i2 == i3) {
                f = 0.0f;
            } else {
                f = i2 == this.f2890x ? 1.0f : Float.NaN;
            }
            this.f2878r.setTransition(transition);
            this.f2840H0.m607e(this.f2878r.m586b(this.f2886v), this.f2878r.m586b(this.f2890x));
            rebuildScene();
            if (this.f2835F != f) {
                if (f == RecyclerView.f7068F0) {
                    m576i(true);
                    this.f2878r.m586b(this.f2886v).applyTo(this);
                } else if (f == 1.0f) {
                    m576i(false);
                    this.f2878r.m586b(this.f2890x).applyTo(this);
                }
            }
            if (!Float.isNaN(f)) {
                f2 = f;
            }
            this.f2835F = f2;
            if (Float.isNaN(f)) {
                Log.v("MotionLayout", Debug.getLocation() + " transitionToStart ");
                transitionToStart();
                return;
            }
            setProgress(f);
        }
    }

    public void setTransition(MotionScene.Transition transition) {
        this.f2878r.setTransition(transition);
        setState(kp1.f22136b);
        int i = this.f2888w;
        MotionScene.Transition transition2 = this.f2878r.f2898c;
        if (i == (transition2 == null ? -1 : transition2.f2918c)) {
            this.f2835F = 1.0f;
            this.f2833E = 1.0f;
            this.f2839H = 1.0f;
        } else {
            this.f2835F = RecyclerView.f7068F0;
            this.f2833E = RecyclerView.f7068F0;
            this.f2839H = RecyclerView.f7068F0;
        }
        this.f2837G = transition.isTransitionFlag(1) ? -1L : getNanoTime();
        int m590g = this.f2878r.m590g();
        MotionScene motionScene = this.f2878r;
        MotionScene.Transition transition3 = motionScene.f2898c;
        int i2 = transition3 != null ? transition3.f2918c : -1;
        if (m590g == this.f2886v && i2 == this.f2890x) {
            return;
        }
        this.f2886v = m590g;
        this.f2890x = i2;
        motionScene.m597n(m590g, i2);
        ConstraintSet m586b = this.f2878r.m586b(this.f2886v);
        ConstraintSet m586b2 = this.f2878r.m586b(this.f2890x);
        C0126a c0126a = this.f2840H0;
        c0126a.m607e(m586b, m586b2);
        int i3 = this.f2886v;
        int i4 = this.f2890x;
        c0126a.f2988e = i3;
        c0126a.f2989f = i4;
        c0126a.m608f();
        rebuildScene();
    }

    public MotionLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2882t = null;
        this.f2884u = RecyclerView.f7068F0;
        this.f2886v = -1;
        this.f2888w = -1;
        this.f2890x = -1;
        this.f2892y = 0;
        this.f2894z = 0;
        this.f2825A = true;
        this.f2827B = new HashMap();
        this.f2829C = 0L;
        this.f2831D = 1.0f;
        this.f2833E = RecyclerView.f7068F0;
        this.f2835F = RecyclerView.f7068F0;
        this.f2839H = RecyclerView.f7068F0;
        this.f2843J = false;
        this.f2847L = 0;
        this.f2851N = false;
        this.f2852O = new StopLogic();
        this.f2853P = new hp1(this);
        this.f2857T = false;
        this.f2862b0 = false;
        this.f2863c0 = null;
        this.f2864d0 = null;
        this.f2865e0 = null;
        this.f2866f0 = null;
        this.f2867g0 = 0;
        this.f2868h0 = -1L;
        this.f2869i0 = RecyclerView.f7068F0;
        this.f2870j0 = 0;
        this.f2871k0 = RecyclerView.f7068F0;
        this.mMeasureDuringTransition = false;
        this.f2881s0 = new KeyCache();
        this.f2883t0 = false;
        this.f2887v0 = null;
        this.f2889w0 = null;
        this.f2891x0 = 0;
        this.f2893y0 = false;
        this.f2895z0 = 0;
        this.f2826A0 = new HashMap();
        this.f2834E0 = new Rect();
        this.f2836F0 = false;
        this.f2838G0 = kp1.f22135a;
        this.f2840H0 = new C0126a(this);
        this.f2842I0 = false;
        this.f2844J0 = new RectF();
        this.f2846K0 = null;
        this.f2848L0 = null;
        this.f2850M0 = new ArrayList();
        m581n(attributeSet);
    }

    public MotionLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2882t = null;
        this.f2884u = RecyclerView.f7068F0;
        this.f2886v = -1;
        this.f2888w = -1;
        this.f2890x = -1;
        this.f2892y = 0;
        this.f2894z = 0;
        this.f2825A = true;
        this.f2827B = new HashMap();
        this.f2829C = 0L;
        this.f2831D = 1.0f;
        this.f2833E = RecyclerView.f7068F0;
        this.f2835F = RecyclerView.f7068F0;
        this.f2839H = RecyclerView.f7068F0;
        this.f2843J = false;
        this.f2847L = 0;
        this.f2851N = false;
        this.f2852O = new StopLogic();
        this.f2853P = new hp1(this);
        this.f2857T = false;
        this.f2862b0 = false;
        this.f2863c0 = null;
        this.f2864d0 = null;
        this.f2865e0 = null;
        this.f2866f0 = null;
        this.f2867g0 = 0;
        this.f2868h0 = -1L;
        this.f2869i0 = RecyclerView.f7068F0;
        this.f2870j0 = 0;
        this.f2871k0 = RecyclerView.f7068F0;
        this.mMeasureDuringTransition = false;
        this.f2881s0 = new KeyCache();
        this.f2883t0 = false;
        this.f2887v0 = null;
        this.f2889w0 = null;
        this.f2891x0 = 0;
        this.f2893y0 = false;
        this.f2895z0 = 0;
        this.f2826A0 = new HashMap();
        this.f2834E0 = new Rect();
        this.f2836F0 = false;
        this.f2838G0 = kp1.f22135a;
        this.f2840H0 = new C0126a(this);
        this.f2842I0 = false;
        this.f2844J0 = new RectF();
        this.f2846K0 = null;
        this.f2848L0 = null;
        this.f2850M0 = new ArrayList();
        m581n(attributeSet);
    }
}
