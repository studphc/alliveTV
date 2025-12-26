package androidx.constraintlayout.core.state;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.Motion;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.key.MotionKeyAttributes;
import androidx.constraintlayout.core.motion.key.MotionKeyCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.SpringStopEngine;
import androidx.constraintlayout.core.motion.utils.StopEngine;
import androidx.constraintlayout.core.motion.utils.StopLogicEngine;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import okhttp3.internal.http.HttpStatusCodesKt;
import p000.C1294i5;
import p000.sv2;
import p000.t82;
import p000.tv2;

/* loaded from: classes.dex */
public class Transition implements TypedValues {
    public static final int END = 1;
    public static final int INTERPOLATED = 2;
    public static final int START = 0;

    /* renamed from: a */
    public final HashMap f2362a = new HashMap();

    /* renamed from: b */
    public final HashMap f2363b = new HashMap();

    /* renamed from: c */
    public final TypedBundle f2364c = new TypedBundle();

    /* renamed from: d */
    public String f2365d = null;

    /* renamed from: e */
    public Easing f2366e = null;

    /* renamed from: f */
    public final int f2367f = HttpStatusCodesKt.HTTP_BAD_REQUEST;

    /* renamed from: g */
    public float f2368g = RecyclerView.f7068F0;

    /* renamed from: h */
    public tv2 f2369h = null;

    /* renamed from: i */
    public final CorePixelDp f2370i;

    /* renamed from: j */
    public int f2371j;

    /* renamed from: k */
    public int f2372k;

    /* renamed from: l */
    public int f2373l;

    /* renamed from: m */
    public int f2374m;

    /* renamed from: n */
    public int f2375n;

    /* renamed from: o */
    public int f2376o;

    /* renamed from: p */
    public boolean f2377p;

    public Transition(@NonNull CorePixelDp corePixelDp) {
        this.f2370i = corePixelDp;
    }

    public static Interpolator getInterpolator(int i, String str) {
        switch (i) {
            case -1:
                return new C1294i5(21, str);
            case 0:
                return new t82(13);
            case 1:
                return new t82(14);
            case 2:
                return new t82(15);
            case 3:
                return new t82(16);
            case 4:
                return new t82(19);
            case 5:
                return new t82(18);
            case 6:
                return new t82(17);
            default:
                return null;
        }
    }

    public void addCustomColor(int i, String str, String str2, int i2) {
        getWidgetState(str, null, i).getFrame(i).addCustomColor(str2, i2);
    }

    public void addCustomFloat(int i, String str, String str2, float f) {
        getWidgetState(str, null, i).getFrame(i).addCustomFloat(str2, f);
    }

    public void addKeyAttribute(String str, TypedBundle typedBundle) {
        getWidgetState(str, null, 0).setKeyAttribute(typedBundle);
    }

    public void addKeyCycle(String str, TypedBundle typedBundle) {
        getWidgetState(str, null, 0).setKeyCycle(typedBundle);
    }

    public void addKeyPosition(String str, TypedBundle typedBundle) {
        getWidgetState(str, null, 0).setKeyPosition(typedBundle);
    }

    public void calcStagger() {
        boolean z;
        float f;
        float f2;
        float f3 = this.f2368g;
        if (f3 == RecyclerView.f7068F0) {
            return;
        }
        if (f3 < 0.0d) {
            z = true;
        } else {
            z = false;
        }
        float abs = Math.abs(f3);
        HashMap hashMap = this.f2363b;
        Iterator it = hashMap.keySet().iterator();
        do {
            f = Float.MAX_VALUE;
            f2 = -3.4028235E38f;
            if (!it.hasNext()) {
                Iterator it2 = hashMap.keySet().iterator();
                while (it2.hasNext()) {
                    Motion motion = ((WidgetState) hashMap.get((String) it2.next())).f2381d;
                    float finalY = motion.getFinalY() + motion.getFinalX();
                    f = Math.min(f, finalY);
                    f2 = Math.max(f2, finalY);
                }
                Iterator it3 = hashMap.keySet().iterator();
                while (it3.hasNext()) {
                    Motion motion2 = ((WidgetState) hashMap.get((String) it3.next())).f2381d;
                    float finalY2 = motion2.getFinalY() + motion2.getFinalX();
                    float f4 = f2 - f;
                    float f5 = abs - (((finalY2 - f) * abs) / f4);
                    if (z) {
                        f5 = abs - (((f2 - finalY2) / f4) * abs);
                    }
                    motion2.setStaggerScale(1.0f / (1.0f - abs));
                    motion2.setStaggerOffset(f5);
                }
                return;
            }
        } while (Float.isNaN(((WidgetState) hashMap.get((String) it.next())).f2381d.getMotionStagger()));
        Iterator it4 = hashMap.keySet().iterator();
        while (it4.hasNext()) {
            float motionStagger = ((WidgetState) hashMap.get((String) it4.next())).f2381d.getMotionStagger();
            if (!Float.isNaN(motionStagger)) {
                f = Math.min(f, motionStagger);
                f2 = Math.max(f2, motionStagger);
            }
        }
        Iterator it5 = hashMap.keySet().iterator();
        while (it5.hasNext()) {
            Motion motion3 = ((WidgetState) hashMap.get((String) it5.next())).f2381d;
            float motionStagger2 = motion3.getMotionStagger();
            if (!Float.isNaN(motionStagger2)) {
                float f6 = 1.0f / (1.0f - abs);
                float f7 = f2 - f;
                float f8 = abs - (((motionStagger2 - f) * abs) / f7);
                if (z) {
                    f8 = abs - (((f2 - motionStagger2) / f7) * abs);
                }
                motion3.setStaggerScale(f6);
                motion3.setStaggerOffset(f8);
            }
        }
    }

    public void clear() {
        this.f2363b.clear();
    }

    public boolean contains(String str) {
        return this.f2363b.containsKey(str);
    }

    public float dragToProgress(float f, int i, int i2, float f2, float f3) {
        WidgetState widgetState;
        float abs;
        float f4;
        float abs2;
        HashMap hashMap = this.f2363b;
        Iterator it = hashMap.values().iterator();
        if (it.hasNext()) {
            widgetState = (WidgetState) it.next();
        } else {
            widgetState = null;
        }
        tv2 tv2Var = this.f2369h;
        if (tv2Var != null && widgetState != null) {
            String str = tv2Var.f26985a;
            float[][] fArr = tv2.f26984x;
            if (str == null) {
                float[] fArr2 = fArr[tv2Var.f26989e];
                float f5 = widgetState.f2387j;
                float f6 = fArr2[0];
                if (f6 != RecyclerView.f7068F0) {
                    abs2 = Math.abs(f6) * f2;
                } else {
                    abs2 = Math.abs(fArr2[1]) * f3;
                }
                return (abs2 / f5) * this.f2369h.f26990f;
            }
            WidgetState widgetState2 = (WidgetState) hashMap.get(str);
            tv2 tv2Var2 = this.f2369h;
            float[] fArr3 = fArr[tv2Var2.f26989e];
            float[] fArr4 = tv2.f26979s[tv2Var2.f26986b];
            float[] fArr5 = new float[2];
            widgetState2.interpolate(i, i2, f, this);
            widgetState2.f2381d.getDpDt(f, fArr4[0], fArr4[1], fArr5);
            float f7 = fArr3[0];
            if (f7 != RecyclerView.f7068F0) {
                abs = Math.abs(f7) * f2;
                f4 = fArr5[0];
            } else {
                abs = Math.abs(fArr3[1]) * f3;
                f4 = fArr5[1];
            }
            return (abs / f4) * this.f2369h.f26990f;
        }
        if (widgetState != null) {
            return (-f3) / widgetState.f2387j;
        }
        return 1.0f;
    }

    public void fillKeyPositions(WidgetFrame widgetFrame, float[] fArr, float[] fArr2, float[] fArr3) {
        sv2 sv2Var;
        int i = 0;
        for (int i2 = 0; i2 <= 100; i2++) {
            HashMap hashMap = (HashMap) this.f2362a.get(Integer.valueOf(i2));
            if (hashMap != null && (sv2Var = (sv2) hashMap.get(widgetFrame.widget.stringId)) != null) {
                fArr[i] = sv2Var.f26589b;
                fArr2[i] = sv2Var.f26590c;
                fArr3[i] = sv2Var.f26588a;
                i++;
            }
        }
    }

    public sv2 findNextPosition(String str, int i) {
        sv2 sv2Var;
        while (i <= 100) {
            HashMap hashMap = (HashMap) this.f2362a.get(Integer.valueOf(i));
            if (hashMap != null && (sv2Var = (sv2) hashMap.get(str)) != null) {
                return sv2Var;
            }
            i++;
        }
        return null;
    }

    public sv2 findPreviousPosition(String str, int i) {
        sv2 sv2Var;
        while (i >= 0) {
            HashMap hashMap = (HashMap) this.f2362a.get(Integer.valueOf(i));
            if (hashMap != null && (sv2Var = (sv2) hashMap.get(str)) != null) {
                return sv2Var;
            }
            i--;
        }
        return null;
    }

    public int getAutoTransition() {
        return 0;
    }

    public WidgetFrame getEnd(String str) {
        WidgetState widgetState = (WidgetState) this.f2363b.get(str);
        if (widgetState == null) {
            return null;
        }
        return widgetState.f2379b;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String str) {
        return 0;
    }

    public WidgetFrame getInterpolated(String str) {
        WidgetState widgetState = (WidgetState) this.f2363b.get(str);
        if (widgetState == null) {
            return null;
        }
        return widgetState.f2380c;
    }

    public int getInterpolatedHeight() {
        return this.f2376o;
    }

    public int getInterpolatedWidth() {
        return this.f2375n;
    }

    public int getKeyFrames(String str, float[] fArr, int[] iArr, int[] iArr2) {
        return ((WidgetState) this.f2363b.get(str)).f2381d.buildKeyFrames(fArr, iArr, iArr2);
    }

    public Motion getMotion(String str) {
        return getWidgetState(str, null, 0).f2381d;
    }

    public int getNumberKeyPositions(WidgetFrame widgetFrame) {
        int i = 0;
        for (int i2 = 0; i2 <= 100; i2++) {
            HashMap hashMap = (HashMap) this.f2362a.get(Integer.valueOf(i2));
            if (hashMap != null && ((sv2) hashMap.get(widgetFrame.widget.stringId)) != null) {
                i++;
            }
        }
        return i;
    }

    public float[] getPath(String str) {
        float[] fArr = new float[124];
        ((WidgetState) this.f2363b.get(str)).f2381d.buildPath(fArr, 62);
        return fArr;
    }

    public WidgetFrame getStart(String str) {
        WidgetState widgetState = (WidgetState) this.f2363b.get(str);
        if (widgetState == null) {
            return null;
        }
        return widgetState.f2378a;
    }

    public float getTouchUpProgress(long j) {
        tv2 tv2Var = this.f2369h;
        if (tv2Var != null) {
            float interpolation = tv2Var.f26987c.getInterpolation(((float) (j - tv2Var.f27001q)) * 1.0E-9f);
            if (tv2Var.f26987c.isStopped()) {
                return tv2Var.f26999o;
            }
            return interpolation;
        }
        return RecyclerView.f7068F0;
    }

    public WidgetState getWidgetState(String str, ConstraintWidget constraintWidget, int i) {
        HashMap hashMap = this.f2363b;
        WidgetState widgetState = (WidgetState) hashMap.get(str);
        if (widgetState == null) {
            widgetState = new WidgetState();
            this.f2364c.applyDelta(widgetState.f2381d);
            widgetState.f2383f.updateMotion(widgetState.f2381d);
            hashMap.put(str, widgetState);
            if (constraintWidget != null) {
                widgetState.update(constraintWidget, i);
            }
        }
        return widgetState;
    }

    public boolean hasOnSwipe() {
        if (this.f2369h != null) {
            return true;
        }
        return false;
    }

    public boolean hasPositionKeyframes() {
        if (this.f2362a.size() > 0) {
            return true;
        }
        return false;
    }

    public void interpolate(int i, int i2, float f) {
        if (this.f2377p) {
            this.f2375n = (int) (((this.f2373l - r0) * f) + this.f2371j + 0.5f);
            this.f2376o = (int) (((this.f2374m - r0) * f) + this.f2372k + 0.5f);
        }
        Easing easing = this.f2366e;
        if (easing != null) {
            f = (float) easing.get(f);
        }
        HashMap hashMap = this.f2363b;
        Iterator it = hashMap.keySet().iterator();
        while (it.hasNext()) {
            ((WidgetState) hashMap.get((String) it.next())).interpolate(i, i2, f, this);
        }
    }

    public boolean isEmpty() {
        return this.f2363b.isEmpty();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isFirstDownAccepted(float f, float f2) {
        tv2 tv2Var = this.f2369h;
        if (tv2Var == null) {
            return false;
        }
        String str = tv2Var.f26988d;
        if (str == null) {
            return true;
        }
        WidgetState widgetState = (WidgetState) this.f2363b.get(str);
        if (widgetState == null) {
            System.err.println("mLimitBoundsTo target is null");
            return false;
        }
        WidgetFrame frame = widgetState.getFrame(2);
        if (f < frame.left || f >= frame.right || f2 < frame.top || f2 >= frame.bottom) {
            return false;
        }
        return true;
    }

    public boolean isTouchNotDone(float f) {
        StopEngine stopEngine;
        tv2 tv2Var = this.f2369h;
        if (tv2Var.f26994j == 3 || (stopEngine = tv2Var.f26987c) == null || stopEngine.isStopped()) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0093, code lost:
    
        if (r1 > 0.5d) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a9, code lost:
    
        if (r1 > 0.5f) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ba, code lost:
    
        if (r14 <= androidx.recyclerview.widget.RecyclerView.f7068F0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00bf, code lost:
    
        if (r14 >= 1.0f) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setTouchUp(float f, long j, float f2, float f3) {
        float f4;
        SpringStopEngine springStopEngine;
        StopLogicEngine stopLogicEngine;
        StopLogicEngine.Decelerate decelerate;
        tv2 tv2Var = this.f2369h;
        if (tv2Var != null) {
            WidgetState widgetState = (WidgetState) this.f2363b.get(tv2Var.f26985a);
            float[] fArr = new float[2];
            tv2 tv2Var2 = this.f2369h;
            float[] fArr2 = tv2.f26984x[tv2Var2.f26989e];
            float[] fArr3 = tv2.f26979s[tv2Var2.f26986b];
            widgetState.f2381d.getDpDt(f, fArr3[0], fArr3[1], fArr);
            if (Math.abs((fArr2[1] * fArr[1]) + (fArr2[0] * fArr[0])) < 0.01d) {
                fArr[0] = 0.01f;
                fArr[1] = 0.01f;
            }
            float f5 = fArr2[0];
            float f6 = RecyclerView.f7068F0;
            if (f5 != RecyclerView.f7068F0) {
                f4 = f2 / fArr[0];
            } else {
                f4 = f3 / fArr[1];
            }
            tv2 tv2Var3 = this.f2369h;
            float f7 = f4 * tv2Var3.f26990f;
            float f8 = this.f2367f * 0.001f;
            tv2Var3.f27001q = j;
            float abs = Math.abs(f7);
            float f9 = tv2Var3.f26992h;
            if (abs > f9) {
                f7 = Math.signum(f7) * f9;
            }
            float f10 = f7;
            float abs2 = (((Math.abs(f10) * 0.5f) * f10) / tv2Var3.f26993i) + f;
            switch (tv2Var3.f26994j) {
                case 3:
                    f6 = Float.NaN;
                    break;
                case 4:
                    f6 = Math.max(RecyclerView.f7068F0, Math.min(1.0f, abs2));
                    break;
                case 5:
                    if (abs2 > 0.2f && abs2 < 0.8f) {
                        f6 = abs2;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    f6 = 1.0f;
                    break;
            }
            tv2Var3.f26999o = f6;
            if (f6 == f) {
                tv2Var3.f26987c = null;
                return;
            }
            if (tv2Var3.f26994j == 4 && tv2Var3.f26991g == 0) {
                StopEngine stopEngine = tv2Var3.f26987c;
                if (stopEngine instanceof StopLogicEngine.Decelerate) {
                    decelerate = (StopLogicEngine.Decelerate) stopEngine;
                } else {
                    decelerate = new StopLogicEngine.Decelerate();
                    tv2Var3.f26987c = decelerate;
                }
                decelerate.config(f, tv2Var3.f26999o, f10);
                return;
            }
            if (tv2Var3.f26991g == 0) {
                StopEngine stopEngine2 = tv2Var3.f26987c;
                if (stopEngine2 instanceof StopLogicEngine) {
                    stopLogicEngine = (StopLogicEngine) stopEngine2;
                } else {
                    stopLogicEngine = new StopLogicEngine();
                    tv2Var3.f26987c = stopLogicEngine;
                }
                stopLogicEngine.config(f, tv2Var3.f26999o, f10, f8, tv2Var3.f26993i, tv2Var3.f26992h);
                return;
            }
            StopEngine stopEngine3 = tv2Var3.f26987c;
            if (stopEngine3 instanceof SpringStopEngine) {
                springStopEngine = (SpringStopEngine) stopEngine3;
            } else {
                springStopEngine = new SpringStopEngine();
                tv2Var3.f26987c = springStopEngine;
            }
            springStopEngine.springConfig(f, tv2Var3.f26999o, f10, tv2Var3.f26995k, tv2Var3.f26996l, tv2Var3.f26997m, tv2Var3.f26998n, tv2Var3.f27000p);
        }
    }

    public void setTransitionProperties(TypedBundle typedBundle) {
        typedBundle.applyDelta(this.f2364c);
        typedBundle.applyDelta(this);
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, int i2) {
        return false;
    }

    public void updateFrom(ConstraintWidgetContainer constraintWidgetContainer, int i) {
        boolean z;
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidgetContainer.mListDimensionBehaviors;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z2 = true;
        if (dimensionBehaviour == dimensionBehaviour2) {
            z = true;
        } else {
            z = false;
        }
        this.f2377p = z;
        if (dimensionBehaviourArr[1] != dimensionBehaviour2) {
            z2 = false;
        }
        this.f2377p = z | z2;
        if (i == 0) {
            int width = constraintWidgetContainer.getWidth();
            this.f2371j = width;
            this.f2375n = width;
            int height = constraintWidgetContainer.getHeight();
            this.f2372k = height;
            this.f2376o = height;
        } else {
            this.f2373l = constraintWidgetContainer.getWidth();
            this.f2374m = constraintWidgetContainer.getHeight();
        }
        ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
        int size = children.size();
        WidgetState[] widgetStateArr = new WidgetState[size];
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = children.get(i2);
            WidgetState widgetState = getWidgetState(constraintWidget.stringId, null, i);
            widgetStateArr[i2] = widgetState;
            widgetState.update(constraintWidget, i);
            String animateRelativeTo = widgetState.f2381d.getAnimateRelativeTo();
            if (animateRelativeTo != null) {
                widgetState.setPathRelative(getWidgetState(animateRelativeTo, null, i));
            }
        }
        calcStagger();
    }

    public void addKeyAttribute(String str, TypedBundle typedBundle, CustomVariable[] customVariableArr) {
        getWidgetState(str, null, 0).setKeyAttribute(typedBundle, customVariableArr);
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object, sv2] */
    public void addKeyPosition(String str, int i, int i2, float f, float f2) {
        TypedBundle typedBundle = new TypedBundle();
        typedBundle.add(510, 2);
        typedBundle.add(100, i);
        typedBundle.add(506, f);
        typedBundle.add(507, f2);
        getWidgetState(str, null, 0).setKeyPosition(typedBundle);
        ?? obj = new Object();
        obj.f26588a = i;
        obj.f26589b = f;
        obj.f26590c = f2;
        HashMap hashMap = this.f2362a;
        HashMap hashMap2 = (HashMap) hashMap.get(Integer.valueOf(i));
        if (hashMap2 == null) {
            hashMap2 = new HashMap();
            hashMap.put(Integer.valueOf(i), hashMap2);
        }
        hashMap2.put(str, obj);
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, boolean z) {
        return false;
    }

    /* loaded from: classes.dex */
    public static class WidgetState {

        /* renamed from: a */
        public final WidgetFrame f2378a;

        /* renamed from: b */
        public final WidgetFrame f2379b;

        /* renamed from: c */
        public final WidgetFrame f2380c;

        /* renamed from: d */
        public final Motion f2381d;

        /* renamed from: f */
        public final MotionWidget f2383f;

        /* renamed from: g */
        public final MotionWidget f2384g;

        /* renamed from: h */
        public final MotionWidget f2385h;

        /* renamed from: e */
        public boolean f2382e = true;

        /* renamed from: i */
        public final KeyCache f2386i = new KeyCache();

        /* renamed from: j */
        public int f2387j = -1;

        public WidgetState() {
            WidgetFrame widgetFrame = new WidgetFrame();
            this.f2378a = widgetFrame;
            WidgetFrame widgetFrame2 = new WidgetFrame();
            this.f2379b = widgetFrame2;
            WidgetFrame widgetFrame3 = new WidgetFrame();
            this.f2380c = widgetFrame3;
            MotionWidget motionWidget = new MotionWidget(widgetFrame);
            this.f2383f = motionWidget;
            MotionWidget motionWidget2 = new MotionWidget(widgetFrame2);
            this.f2384g = motionWidget2;
            this.f2385h = new MotionWidget(widgetFrame3);
            Motion motion = new Motion(motionWidget);
            this.f2381d = motion;
            motion.setStart(motionWidget);
            motion.setEnd(motionWidget2);
        }

        public WidgetFrame getFrame(int i) {
            if (i == 0) {
                return this.f2378a;
            }
            if (i == 1) {
                return this.f2379b;
            }
            return this.f2380c;
        }

        public void interpolate(int i, int i2, float f, Transition transition) {
            this.f2387j = i2;
            if (this.f2382e) {
                this.f2381d.setup(i, i2, 1.0f, System.nanoTime());
                this.f2382e = false;
            }
            WidgetFrame.interpolate(i, i2, this.f2380c, this.f2378a, this.f2379b, transition, f);
            this.f2380c.interpolatedPos = f;
            this.f2381d.interpolate(this.f2385h, f, System.nanoTime(), this.f2386i);
        }

        public void setKeyAttribute(TypedBundle typedBundle) {
            MotionKeyAttributes motionKeyAttributes = new MotionKeyAttributes();
            typedBundle.applyDelta(motionKeyAttributes);
            this.f2381d.addKey(motionKeyAttributes);
        }

        public void setKeyCycle(TypedBundle typedBundle) {
            MotionKeyCycle motionKeyCycle = new MotionKeyCycle();
            typedBundle.applyDelta(motionKeyCycle);
            this.f2381d.addKey(motionKeyCycle);
        }

        public void setKeyPosition(TypedBundle typedBundle) {
            MotionKeyPosition motionKeyPosition = new MotionKeyPosition();
            typedBundle.applyDelta(motionKeyPosition);
            this.f2381d.addKey(motionKeyPosition);
        }

        public void setPathRelative(WidgetState widgetState) {
            this.f2381d.setupRelative(widgetState.f2381d);
        }

        public void update(ConstraintWidget constraintWidget, int i) {
            Motion motion = this.f2381d;
            if (i == 0) {
                this.f2378a.update(constraintWidget);
                MotionWidget motionWidget = this.f2383f;
                motionWidget.updateMotion(motionWidget);
                motion.setStart(motionWidget);
                this.f2382e = true;
                return;
            }
            if (i == 1) {
                this.f2379b.update(constraintWidget);
                motion.setEnd(this.f2384g);
                this.f2382e = true;
            }
        }

        public void setKeyAttribute(TypedBundle typedBundle, CustomVariable[] customVariableArr) {
            MotionKeyAttributes motionKeyAttributes = new MotionKeyAttributes();
            typedBundle.applyDelta(motionKeyAttributes);
            if (customVariableArr != null) {
                for (int i = 0; i < customVariableArr.length; i++) {
                    motionKeyAttributes.mCustom.put(customVariableArr[i].getName(), customVariableArr[i]);
                }
            }
            this.f2381d.addKey(motionKeyAttributes);
        }
    }

    public WidgetFrame getEnd(ConstraintWidget constraintWidget) {
        return getWidgetState(constraintWidget.stringId, null, 1).f2379b;
    }

    public WidgetFrame getInterpolated(ConstraintWidget constraintWidget) {
        return getWidgetState(constraintWidget.stringId, null, 2).f2380c;
    }

    public WidgetFrame getStart(ConstraintWidget constraintWidget) {
        return getWidgetState(constraintWidget.stringId, null, 0).f2378a;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, float f) {
        if (i != 706) {
            return false;
        }
        this.f2368g = f;
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, String str) {
        if (i != 705) {
            return false;
        }
        this.f2365d = str;
        this.f2366e = Easing.getInterpolator(str);
        return false;
    }

    public Interpolator getInterpolator() {
        return getInterpolator(0, this.f2365d);
    }
}
