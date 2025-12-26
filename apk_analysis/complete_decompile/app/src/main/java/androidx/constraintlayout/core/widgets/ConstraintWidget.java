package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.Cache;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.analyzer.ChainRun;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import p000.AbstractC1726qj;
import p000.ye0;

/* loaded from: classes.dex */
public class ConstraintWidget {
    public static final int ANCHOR_BASELINE = 4;
    public static final int ANCHOR_BOTTOM = 3;
    public static final int ANCHOR_LEFT = 0;
    public static final int ANCHOR_RIGHT = 1;
    public static final int ANCHOR_TOP = 2;
    public static final int BOTH = 2;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static float DEFAULT_BIAS = 0.5f;
    protected static final int DIRECT = 2;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int INVISIBLE = 4;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_RATIO = 3;
    public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    protected static final int SOLVER = 1;
    public static final int UNKNOWN = -1;
    public static final int VERTICAL = 1;
    public static final int VISIBLE = 0;
    public static final int WRAP_BEHAVIOR_HORIZONTAL_ONLY = 1;
    public static final int WRAP_BEHAVIOR_INCLUDED = 0;
    public static final int WRAP_BEHAVIOR_SKIPPED = 3;
    public static final int WRAP_BEHAVIOR_VERTICAL_ONLY = 2;

    /* renamed from: A */
    public int f2465A;

    /* renamed from: B */
    public int f2466B;

    /* renamed from: C */
    public boolean f2467C;

    /* renamed from: D */
    public String f2468D;

    /* renamed from: E */
    public String f2469E;

    /* renamed from: F */
    public int f2470F;

    /* renamed from: G */
    public int f2471G;

    /* renamed from: H */
    public ConstraintWidget f2472H;

    /* renamed from: I */
    public ConstraintWidget f2473I;

    /* renamed from: a */
    public boolean f2474a;

    /* renamed from: b */
    public final boolean f2475b;

    /* renamed from: c */
    public int f2476c;

    /* renamed from: d */
    public int f2477d;

    /* renamed from: e */
    public boolean f2478e;

    /* renamed from: f */
    public boolean f2479f;
    public WidgetFrame frame;

    /* renamed from: g */
    public boolean f2480g;

    /* renamed from: h */
    public boolean f2481h;
    public ChainRun horizontalChainRun;
    public int horizontalGroup;

    /* renamed from: i */
    public int f2482i;
    public boolean[] isTerminalWidget;

    /* renamed from: j */
    public int f2483j;

    /* renamed from: k */
    public float f2484k;

    /* renamed from: l */
    public int[] f2485l;

    /* renamed from: m */
    public boolean f2486m;
    protected ArrayList<ConstraintAnchor> mAnchors;
    public ConstraintAnchor mBaseline;
    public ConstraintAnchor mBottom;
    public ConstraintAnchor mCenter;
    public float mCircleConstraintAngle;
    public float mDimensionRatio;
    protected int mDimensionRatioSide;
    public int mHorizontalResolution;
    public HorizontalWidgetRun mHorizontalRun;
    public boolean mIsHeightWrapContent;
    public boolean mIsWidthWrapContent;
    public ConstraintAnchor mLeft;
    public ConstraintAnchor[] mListAnchors;
    public DimensionBehaviour[] mListDimensionBehaviors;
    protected ConstraintWidget[] mListNextMatchConstraintsWidget;
    public int mMatchConstraintDefaultHeight;
    public int mMatchConstraintDefaultWidth;
    public int mMatchConstraintMaxHeight;
    public int mMatchConstraintMaxWidth;
    public int mMatchConstraintMinHeight;
    public int mMatchConstraintMinWidth;
    public float mMatchConstraintPercentHeight;
    public float mMatchConstraintPercentWidth;
    protected int mMinHeight;
    protected int mMinWidth;
    protected ConstraintWidget[] mNextChainWidget;
    protected int mOffsetX;
    protected int mOffsetY;
    public ConstraintWidget mParent;
    public int[] mResolvedMatchConstraintDefault;
    public ConstraintAnchor mRight;
    public ConstraintAnchor mTop;
    public int mVerticalResolution;
    public VerticalWidgetRun mVerticalRun;
    public float[] mWeight;

    /* renamed from: mX */
    protected int f2487mX;

    /* renamed from: mY */
    protected int f2488mY;
    public boolean measured;

    /* renamed from: n */
    public boolean f2489n;

    /* renamed from: o */
    public boolean f2490o;

    /* renamed from: p */
    public int f2491p;

    /* renamed from: q */
    public int f2492q;

    /* renamed from: r */
    public final ConstraintAnchor f2493r;
    public WidgetRun[] run;

    /* renamed from: s */
    public final ConstraintAnchor f2494s;
    public String stringId;

    /* renamed from: t */
    public final boolean[] f2495t;

    /* renamed from: u */
    public int f2496u;

    /* renamed from: v */
    public int f2497v;
    public ChainRun verticalChainRun;
    public int verticalGroup;

    /* renamed from: w */
    public int f2498w;

    /* renamed from: x */
    public float f2499x;

    /* renamed from: y */
    public float f2500y;

    /* renamed from: z */
    public Object f2501z;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static final class DimensionBehaviour {
        public static final DimensionBehaviour FIXED;
        public static final DimensionBehaviour MATCH_CONSTRAINT;
        public static final DimensionBehaviour MATCH_PARENT;
        public static final DimensionBehaviour WRAP_CONTENT;

        /* renamed from: a */
        public static final /* synthetic */ DimensionBehaviour[] f2502a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Enum, androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour] */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour] */
        /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Enum, androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour] */
        /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Enum, androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour] */
        static {
            ?? r4 = new Enum("FIXED", 0);
            FIXED = r4;
            ?? r5 = new Enum("WRAP_CONTENT", 1);
            WRAP_CONTENT = r5;
            ?? r6 = new Enum("MATCH_CONSTRAINT", 2);
            MATCH_CONSTRAINT = r6;
            ?? r7 = new Enum("MATCH_PARENT", 3);
            MATCH_PARENT = r7;
            f2502a = new DimensionBehaviour[]{r4, r5, r6, r7};
        }

        public static DimensionBehaviour valueOf(String str) {
            return (DimensionBehaviour) Enum.valueOf(DimensionBehaviour.class, str);
        }

        public static DimensionBehaviour[] values() {
            return (DimensionBehaviour[]) f2502a.clone();
        }
    }

    public ConstraintWidget() {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.mHorizontalRun = null;
        this.mVerticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.f2474a = true;
        this.f2475b = true;
        this.f2476c = -1;
        this.f2477d = -1;
        this.frame = new WidgetFrame(this);
        this.f2478e = false;
        this.f2479f = false;
        this.f2480g = false;
        this.f2481h = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.f2482i = 0;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.f2483j = -1;
        this.f2484k = 1.0f;
        this.f2485l = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = Float.NaN;
        this.f2486m = false;
        this.f2490o = false;
        this.f2491p = 0;
        this.f2492q = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.f2493r = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.f2494s = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.f2495t = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.f2496u = 0;
        this.f2497v = 0;
        this.mDimensionRatio = RecyclerView.f7068F0;
        this.mDimensionRatioSide = -1;
        this.f2487mX = 0;
        this.f2488mY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.f2498w = 0;
        float f = DEFAULT_BIAS;
        this.f2499x = f;
        this.f2500y = f;
        this.f2465A = 0;
        this.f2466B = 0;
        this.f2467C = false;
        this.f2468D = null;
        this.f2469E = null;
        this.f2470F = 0;
        this.f2471G = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.f2472H = null;
        this.f2473I = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        m495a();
    }

    /* renamed from: c */
    public static void m488c(StringBuilder sb, String str, int i, int i2, int i3, int i4, int i5, float f, DimensionBehaviour dimensionBehaviour) {
        sb.append(str);
        sb.append(" :  {\n");
        String obj = dimensionBehaviour.toString();
        if (!DimensionBehaviour.FIXED.toString().equals(obj)) {
            sb.append("      behavior");
            sb.append(" :   ");
            sb.append(obj);
            sb.append(",\n");
        }
        m491g(i, 0, "      size", sb);
        m491g(i2, 0, "      min", sb);
        m491g(i3, Integer.MAX_VALUE, "      max", sb);
        m491g(i4, 0, "      matchMin", sb);
        m491g(i5, 0, "      matchDef", sb);
        m492h(sb, "      matchPercent", f, 1.0f);
        sb.append("    },\n");
    }

    /* renamed from: d */
    public static void m489d(StringBuilder sb, String str, ConstraintAnchor constraintAnchor) {
        if (constraintAnchor.mTarget == null) {
            return;
        }
        sb.append("    ");
        sb.append(str);
        sb.append(" : [ '");
        sb.append(constraintAnchor.mTarget);
        sb.append("'");
        if (constraintAnchor.f2462d != Integer.MIN_VALUE || constraintAnchor.mMargin != 0) {
            sb.append(",");
            sb.append(constraintAnchor.mMargin);
            if (constraintAnchor.f2462d != Integer.MIN_VALUE) {
                sb.append(",");
                sb.append(constraintAnchor.f2462d);
                sb.append(",");
            }
        }
        sb.append(" ] ,\n");
    }

    /* renamed from: f */
    public static void m490f(StringBuilder sb, String str, ConstraintAnchor constraintAnchor) {
        if (constraintAnchor.mTarget == null) {
            return;
        }
        sb.append(str);
        sb.append(" : [ '");
        sb.append(constraintAnchor.mTarget);
        sb.append("',");
        sb.append(constraintAnchor.mMargin);
        sb.append(",");
        sb.append(constraintAnchor.f2462d);
        sb.append(",");
        sb.append(" ] ,\n");
    }

    /* renamed from: g */
    public static void m491g(int i, int i2, String str, StringBuilder sb) {
        if (i == i2) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(i);
        sb.append(",\n");
    }

    /* renamed from: h */
    public static void m492h(StringBuilder sb, String str, float f, float f2) {
        if (f == f2) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(f);
        sb.append(",\n");
    }

    /* renamed from: i */
    public static void m493i(StringBuilder sb, String str, float f, int i) {
        if (f == RecyclerView.f7068F0) {
            return;
        }
        sb.append(str);
        sb.append(" :  [");
        sb.append(f);
        sb.append(",");
        sb.append(i);
        sb.append("");
        sb.append("],\n");
    }

    /* renamed from: j */
    public static void m494j(StringBuilder sb, String str, int i, int i2, int i3, int i4, int i5, int i6, float f, float f2) {
        sb.append(str);
        sb.append(" :  {\n");
        m491g(i, Integer.MIN_VALUE, "size", sb);
        m491g(i2, 0, "min", sb);
        m491g(i3, Integer.MAX_VALUE, "max", sb);
        m491g(i5, 0, "matchMin", sb);
        m491g(i6, 0, "matchDef", sb);
        m491g(i6, 1, "matchPercent", sb);
        m492h(sb, "matchConstraintPercent", f, 1.0f);
        m492h(sb, "weight", f2, 1.0f);
        m491g(i4, 1, "override", sb);
        sb.append("},\n");
    }

    /* renamed from: a */
    public final void m495a() {
        this.mAnchors.add(this.mLeft);
        this.mAnchors.add(this.mTop);
        this.mAnchors.add(this.mRight);
        this.mAnchors.add(this.mBottom);
        this.mAnchors.add(this.f2493r);
        this.mAnchors.add(this.f2494s);
        this.mAnchors.add(this.mCenter);
        this.mAnchors.add(this.mBaseline);
    }

    public void addChildrenToSolverByDependency(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, HashSet<ConstraintWidget> hashSet, int i, boolean z) {
        if (z) {
            if (!hashSet.contains(this)) {
                return;
            }
            Optimizer.m501a(constraintWidgetContainer, linearSystem, this);
            hashSet.remove(this);
            addToSolver(linearSystem, constraintWidgetContainer.optimizeFor(64));
        }
        if (i == 0) {
            HashSet<ConstraintAnchor> dependents = this.mLeft.getDependents();
            if (dependents != null) {
                Iterator<ConstraintAnchor> it = dependents.iterator();
                while (it.hasNext()) {
                    it.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
                }
            }
            HashSet<ConstraintAnchor> dependents2 = this.mRight.getDependents();
            if (dependents2 != null) {
                Iterator<ConstraintAnchor> it2 = dependents2.iterator();
                while (it2.hasNext()) {
                    it2.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
                }
                return;
            }
            return;
        }
        HashSet<ConstraintAnchor> dependents3 = this.mTop.getDependents();
        if (dependents3 != null) {
            Iterator<ConstraintAnchor> it3 = dependents3.iterator();
            while (it3.hasNext()) {
                it3.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
            }
        }
        HashSet<ConstraintAnchor> dependents4 = this.mBottom.getDependents();
        if (dependents4 != null) {
            Iterator<ConstraintAnchor> it4 = dependents4.iterator();
            while (it4.hasNext()) {
                it4.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
            }
        }
        HashSet<ConstraintAnchor> dependents5 = this.mBaseline.getDependents();
        if (dependents5 != null) {
            Iterator<ConstraintAnchor> it5 = dependents5.iterator();
            while (it5.hasNext()) {
                it5.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0487  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x04ee  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x04f3  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x058e  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x05da  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0608  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0635  */
    /* JADX WARN: Removed duplicated region for block: B:226:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:227:0x062a  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0591  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x04f0  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x03f0  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x042b  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x042e  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0260  */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addToSolver(LinearSystem linearSystem, boolean z) {
        boolean z2;
        boolean z3;
        int i;
        boolean z4;
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        Metrics metrics;
        boolean z5;
        boolean z6;
        int i2;
        int i3;
        int i4;
        int i5;
        DimensionBehaviour dimensionBehaviour;
        DimensionBehaviour dimensionBehaviour2;
        boolean z7;
        DimensionBehaviour dimensionBehaviour3;
        boolean z8;
        float f;
        boolean[] zArr;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z9;
        int i10;
        boolean z10;
        boolean z11;
        DimensionBehaviour dimensionBehaviour4;
        DimensionBehaviour dimensionBehaviour5;
        boolean z12;
        int i11;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        DimensionBehaviour dimensionBehaviour6;
        DimensionBehaviour dimensionBehaviour7;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        SolverVariable solverVariable5;
        LinearSystem linearSystem2;
        SolverVariable solverVariable6;
        SolverVariable solverVariable7;
        SolverVariable solverVariable8;
        int i12;
        int i13;
        ?? r11;
        int i14;
        int i15;
        SolverVariable solverVariable9;
        SolverVariable solverVariable10;
        Metrics metrics2;
        boolean z17;
        SolverVariable solverVariable11;
        SolverVariable solverVariable12;
        boolean z18;
        DimensionBehaviour[] dimensionBehaviourArr;
        boolean z19;
        VerticalWidgetRun verticalWidgetRun;
        DependencyNode dependencyNode;
        ConstraintWidget constraintWidget3;
        boolean z20;
        ConstraintWidget constraintWidget4;
        SolverVariable solverVariable13;
        ConstraintWidget constraintWidget5;
        SolverVariable solverVariable14;
        DimensionBehaviour[] dimensionBehaviourArr2;
        boolean z21;
        HorizontalWidgetRun horizontalWidgetRun;
        DependencyNode dependencyNode2;
        int i16;
        int i17;
        boolean isInHorizontalChain;
        boolean isInVerticalChain;
        HorizontalWidgetRun horizontalWidgetRun2;
        VerticalWidgetRun verticalWidgetRun2;
        DependencyNode dependencyNode3;
        boolean z22;
        boolean z23;
        boolean z24;
        SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.mLeft);
        SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(this.mRight);
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(this.mTop);
        SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(this.mBottom);
        SolverVariable createObjectVariable5 = linearSystem.createObjectVariable(this.mBaseline);
        ConstraintWidget constraintWidget6 = this.mParent;
        if (constraintWidget6 != null) {
            DimensionBehaviour[] dimensionBehaviourArr3 = constraintWidget6.mListDimensionBehaviors;
            DimensionBehaviour dimensionBehaviour8 = dimensionBehaviourArr3[0];
            DimensionBehaviour dimensionBehaviour9 = DimensionBehaviour.WRAP_CONTENT;
            if (dimensionBehaviour8 == dimensionBehaviour9) {
                z23 = true;
            } else {
                z23 = false;
            }
            if (dimensionBehaviourArr3[1] == dimensionBehaviour9) {
                z24 = true;
            } else {
                z24 = false;
            }
            int i18 = this.f2482i;
            if (i18 != 1) {
                if (i18 != 2) {
                    if (i18 != 3) {
                        z3 = z24;
                        z2 = z23;
                    }
                } else {
                    z3 = z24;
                    z2 = false;
                }
            } else {
                z2 = z23;
                z3 = false;
            }
            i = this.f2466B;
            boolean[] zArr2 = this.f2495t;
            if (i != 8 && !this.f2467C && !hasDependencies() && !zArr2[0] && !zArr2[1]) {
                return;
            }
            z4 = this.f2478e;
            if (!z4 || this.f2479f) {
                boolean z25 = this.f2475b;
                if (z4) {
                    linearSystem.addEquality(createObjectVariable, this.f2487mX);
                    linearSystem.addEquality(createObjectVariable2, this.f2487mX + this.f2496u);
                    if (z2 && (constraintWidget2 = this.mParent) != null) {
                        if (z25) {
                            ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget2;
                            constraintWidgetContainer.addHorizontalWrapMinVariable(this.mLeft);
                            constraintWidgetContainer.addHorizontalWrapMaxVariable(this.mRight);
                        } else {
                            linearSystem.addGreaterThan(linearSystem.createObjectVariable(constraintWidget2.mRight), createObjectVariable2, 0, 5);
                        }
                    }
                }
                if (this.f2479f) {
                    linearSystem.addEquality(createObjectVariable3, this.f2488mY);
                    linearSystem.addEquality(createObjectVariable4, this.f2488mY + this.f2497v);
                    if (this.mBaseline.hasDependents()) {
                        linearSystem.addEquality(createObjectVariable5, this.f2488mY + this.f2498w);
                    }
                    if (z3 && (constraintWidget = this.mParent) != null) {
                        if (z25) {
                            ConstraintWidgetContainer constraintWidgetContainer2 = (ConstraintWidgetContainer) constraintWidget;
                            ConstraintAnchor constraintAnchor = this.mTop;
                            WeakReference weakReference = constraintWidgetContainer2.f2513T;
                            if (weakReference == null || weakReference.get() == null || constraintAnchor.getFinalValue() > ((ConstraintAnchor) constraintWidgetContainer2.f2513T.get()).getFinalValue()) {
                                constraintWidgetContainer2.f2513T = new WeakReference(constraintAnchor);
                            }
                            ConstraintAnchor constraintAnchor2 = this.mBottom;
                            WeakReference weakReference2 = constraintWidgetContainer2.f2515V;
                            if (weakReference2 == null || weakReference2.get() == null || constraintAnchor2.getFinalValue() > ((ConstraintAnchor) constraintWidgetContainer2.f2515V.get()).getFinalValue()) {
                                constraintWidgetContainer2.f2515V = new WeakReference(constraintAnchor2);
                            }
                        } else {
                            linearSystem.addGreaterThan(linearSystem.createObjectVariable(constraintWidget.mBottom), createObjectVariable4, 0, 5);
                        }
                    }
                }
                if (this.f2478e && this.f2479f) {
                    this.f2478e = false;
                    this.f2479f = false;
                    return;
                }
            }
            metrics = LinearSystem.sMetrics;
            if (metrics != null) {
                metrics.widgets++;
            }
            if (z && (horizontalWidgetRun2 = this.mHorizontalRun) != null && (verticalWidgetRun2 = this.mVerticalRun) != null) {
                dependencyNode3 = horizontalWidgetRun2.start;
                if (dependencyNode3.resolved && horizontalWidgetRun2.end.resolved && verticalWidgetRun2.start.resolved && verticalWidgetRun2.end.resolved) {
                    if (metrics != null) {
                        metrics.graphSolved++;
                    }
                    linearSystem.addEquality(createObjectVariable, dependencyNode3.value);
                    linearSystem.addEquality(createObjectVariable2, this.mHorizontalRun.end.value);
                    linearSystem.addEquality(createObjectVariable3, this.mVerticalRun.start.value);
                    linearSystem.addEquality(createObjectVariable4, this.mVerticalRun.end.value);
                    linearSystem.addEquality(createObjectVariable5, this.mVerticalRun.baseline.value);
                    if (this.mParent != null) {
                        if (z2 && this.isTerminalWidget[0] && !isInHorizontalChain()) {
                            linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mRight), createObjectVariable2, 0, 8);
                        }
                        if (z3 && this.isTerminalWidget[1] && !isInVerticalChain()) {
                            z22 = false;
                            linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mBottom), createObjectVariable4, 0, 8);
                            this.f2478e = z22;
                            this.f2479f = z22;
                            return;
                        }
                    }
                    z22 = false;
                    this.f2478e = z22;
                    this.f2479f = z22;
                    return;
                }
            }
            if (metrics != null) {
                metrics.linearSolved++;
            }
            if (this.mParent == null) {
                if (m497e(0)) {
                    ((ConstraintWidgetContainer) this.mParent).m498k(this, 0);
                    isInHorizontalChain = true;
                } else {
                    isInHorizontalChain = isInHorizontalChain();
                }
                if (m497e(1)) {
                    ((ConstraintWidgetContainer) this.mParent).m498k(this, 1);
                    isInVerticalChain = true;
                } else {
                    isInVerticalChain = isInVerticalChain();
                }
                if (!isInHorizontalChain && z2 && this.f2466B != 8 && this.mLeft.mTarget == null && this.mRight.mTarget == null) {
                    linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mRight), createObjectVariable2, 0, 1);
                }
                if (!isInVerticalChain && z3 && this.f2466B != 8 && this.mTop.mTarget == null && this.mBottom.mTarget == null && this.mBaseline == null) {
                    linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mBottom), createObjectVariable4, 0, 1);
                }
                z6 = isInHorizontalChain;
                z5 = isInVerticalChain;
            } else {
                z5 = false;
                z6 = false;
            }
            i2 = this.f2496u;
            i3 = this.mMinWidth;
            if (i2 >= i3) {
                i3 = i2;
            }
            i4 = this.f2497v;
            i5 = this.mMinHeight;
            if (i4 >= i5) {
                i5 = i4;
            }
            DimensionBehaviour[] dimensionBehaviourArr4 = this.mListDimensionBehaviors;
            dimensionBehaviour = dimensionBehaviourArr4[0];
            dimensionBehaviour2 = DimensionBehaviour.MATCH_CONSTRAINT;
            int i19 = i3;
            if (dimensionBehaviour == dimensionBehaviour2) {
                z7 = true;
            } else {
                z7 = false;
            }
            dimensionBehaviour3 = dimensionBehaviourArr4[1];
            int i20 = i5;
            if (dimensionBehaviour3 == dimensionBehaviour2) {
                z8 = true;
            } else {
                z8 = false;
            }
            int i21 = this.mDimensionRatioSide;
            this.f2483j = i21;
            f = this.mDimensionRatio;
            this.f2484k = f;
            int i22 = this.mMatchConstraintDefaultWidth;
            int i23 = this.mMatchConstraintDefaultHeight;
            if (f <= RecyclerView.f7068F0) {
                zArr = zArr2;
                if (this.f2466B != 8) {
                    if (dimensionBehaviour == dimensionBehaviour2 && i22 == 0) {
                        i22 = 3;
                    }
                    if (dimensionBehaviour3 == dimensionBehaviour2 && i23 == 0) {
                        i23 = 3;
                    }
                    if (dimensionBehaviour == dimensionBehaviour2 && dimensionBehaviour3 == dimensionBehaviour2) {
                        i17 = 3;
                        if (i22 == 3 && i23 == 3) {
                            setupDimensionRatio(z2, z3, z7, z8);
                            i6 = i22;
                            i7 = i23;
                            i8 = i19;
                            i9 = i20;
                            z9 = true;
                            int[] iArr = this.mResolvedMatchConstraintDefault;
                            iArr[0] = i6;
                            iArr[1] = i7;
                            if (!z9) {
                                int i24 = this.f2483j;
                                i10 = -1;
                                if (i24 == 0 || i24 == -1) {
                                    z10 = true;
                                    if (!z9 && ((i16 = this.f2483j) == 1 || i16 == i10)) {
                                        z11 = true;
                                    } else {
                                        z11 = false;
                                    }
                                    dimensionBehaviour4 = this.mListDimensionBehaviors[0];
                                    dimensionBehaviour5 = DimensionBehaviour.WRAP_CONTENT;
                                    if (dimensionBehaviour4 != dimensionBehaviour5 && (this instanceof ConstraintWidgetContainer)) {
                                        z12 = true;
                                    } else {
                                        z12 = false;
                                    }
                                    if (z12) {
                                        i11 = 0;
                                    } else {
                                        i11 = i8;
                                    }
                                    z13 = !this.mCenter.isConnected();
                                    z14 = zArr[0];
                                    boolean z26 = zArr[1];
                                    if (this.mHorizontalResolution != 2 && !this.f2478e) {
                                        if (z && (horizontalWidgetRun = this.mHorizontalRun) != null) {
                                            dependencyNode2 = horizontalWidgetRun.start;
                                            if (dependencyNode2.resolved && horizontalWidgetRun.end.resolved) {
                                                if (!z) {
                                                    linearSystem.addEquality(createObjectVariable, dependencyNode2.value);
                                                    linearSystem.addEquality(createObjectVariable2, this.mHorizontalRun.end.value);
                                                    if (this.mParent != null && z2 && this.isTerminalWidget[0] && !isInHorizontalChain()) {
                                                        linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mRight), createObjectVariable2, 0, 8);
                                                    }
                                                    z15 = z2;
                                                    z16 = z3;
                                                    solverVariable5 = createObjectVariable;
                                                    dimensionBehaviour6 = dimensionBehaviour2;
                                                    dimensionBehaviour7 = dimensionBehaviour5;
                                                    solverVariable = createObjectVariable3;
                                                    solverVariable2 = createObjectVariable5;
                                                    solverVariable3 = createObjectVariable4;
                                                    solverVariable4 = createObjectVariable2;
                                                    if (z && (verticalWidgetRun = this.mVerticalRun) != null) {
                                                        dependencyNode = verticalWidgetRun.start;
                                                        if (dependencyNode.resolved && verticalWidgetRun.end.resolved) {
                                                            linearSystem2 = linearSystem;
                                                            solverVariable8 = solverVariable;
                                                            linearSystem2.addEquality(solverVariable8, dependencyNode.value);
                                                            solverVariable7 = solverVariable3;
                                                            linearSystem2.addEquality(solverVariable7, this.mVerticalRun.end.value);
                                                            solverVariable6 = solverVariable2;
                                                            linearSystem2.addEquality(solverVariable6, this.mVerticalRun.baseline.value);
                                                            constraintWidget3 = this.mParent;
                                                            if (constraintWidget3 == null && !z5 && z16) {
                                                                z20 = true;
                                                                z20 = true;
                                                                if (this.isTerminalWidget[1]) {
                                                                    i12 = 8;
                                                                    i13 = 0;
                                                                    linearSystem2.addGreaterThan(linearSystem2.createObjectVariable(constraintWidget3.mBottom), solverVariable7, 0, 8);
                                                                } else {
                                                                    i12 = 8;
                                                                    i13 = 0;
                                                                }
                                                            } else {
                                                                i12 = 8;
                                                                i13 = 0;
                                                                z20 = true;
                                                            }
                                                            i14 = i13;
                                                            r11 = z20;
                                                            if (this.mVerticalResolution != 2) {
                                                                i15 = i13;
                                                            } else {
                                                                i15 = i14;
                                                            }
                                                            if (i15 == 0 && !this.f2479f) {
                                                                if (this.mListDimensionBehaviors[r11] == dimensionBehaviour7 && (this instanceof ConstraintWidgetContainer)) {
                                                                    z17 = r11;
                                                                } else {
                                                                    z17 = i13;
                                                                }
                                                                if (z17) {
                                                                    i9 = i13;
                                                                }
                                                                ConstraintWidget constraintWidget7 = this.mParent;
                                                                if (constraintWidget7 != null) {
                                                                    solverVariable11 = linearSystem2.createObjectVariable(constraintWidget7.mBottom);
                                                                } else {
                                                                    solverVariable11 = null;
                                                                }
                                                                ConstraintWidget constraintWidget8 = this.mParent;
                                                                if (constraintWidget8 != null) {
                                                                    solverVariable12 = linearSystem2.createObjectVariable(constraintWidget8.mTop);
                                                                } else {
                                                                    solverVariable12 = null;
                                                                }
                                                                if (this.f2498w > 0 || this.f2466B == i12) {
                                                                    ConstraintAnchor constraintAnchor3 = this.mBaseline;
                                                                    if (constraintAnchor3.mTarget != null) {
                                                                        linearSystem2.addEquality(solverVariable6, solverVariable8, getBaselineDistance(), i12);
                                                                        linearSystem2.addEquality(solverVariable6, linearSystem2.createObjectVariable(this.mBaseline.mTarget), this.mBaseline.getMargin(), i12);
                                                                        if (z16) {
                                                                            linearSystem2.addGreaterThan(solverVariable11, linearSystem2.createObjectVariable(this.mBottom), i13, 5);
                                                                        }
                                                                        z18 = i13;
                                                                        boolean z27 = this.isTerminalWidget[r11];
                                                                        dimensionBehaviourArr = this.mListDimensionBehaviors;
                                                                        DimensionBehaviour dimensionBehaviour10 = dimensionBehaviourArr[r11];
                                                                        ConstraintAnchor constraintAnchor4 = this.mTop;
                                                                        ConstraintAnchor constraintAnchor5 = this.mBottom;
                                                                        int i25 = this.f2488mY;
                                                                        int i26 = this.mMinHeight;
                                                                        int i27 = this.f2485l[r11];
                                                                        float f2 = this.f2500y;
                                                                        if (dimensionBehaviourArr[0] != dimensionBehaviour6) {
                                                                            z19 = true;
                                                                        } else {
                                                                            z19 = false;
                                                                        }
                                                                        solverVariable9 = solverVariable7;
                                                                        solverVariable10 = solverVariable8;
                                                                        m496b(linearSystem, false, z16, z15, z27, solverVariable12, solverVariable11, dimensionBehaviour10, z17, constraintAnchor4, constraintAnchor5, i25, i9, i26, i27, f2, z11, z19, z5, z6, z26, i7, i6, this.mMatchConstraintMinHeight, this.mMatchConstraintMaxHeight, this.mMatchConstraintPercentHeight, z18);
                                                                    } else if (this.f2466B == i12) {
                                                                        linearSystem2.addEquality(solverVariable6, solverVariable8, constraintAnchor3.getMargin(), i12);
                                                                    } else {
                                                                        linearSystem2.addEquality(solverVariable6, solverVariable8, getBaselineDistance(), i12);
                                                                    }
                                                                }
                                                                z18 = z13;
                                                                boolean z272 = this.isTerminalWidget[r11];
                                                                dimensionBehaviourArr = this.mListDimensionBehaviors;
                                                                DimensionBehaviour dimensionBehaviour102 = dimensionBehaviourArr[r11];
                                                                ConstraintAnchor constraintAnchor42 = this.mTop;
                                                                ConstraintAnchor constraintAnchor52 = this.mBottom;
                                                                int i252 = this.f2488mY;
                                                                int i262 = this.mMinHeight;
                                                                int i272 = this.f2485l[r11];
                                                                float f22 = this.f2500y;
                                                                if (dimensionBehaviourArr[0] != dimensionBehaviour6) {
                                                                }
                                                                solverVariable9 = solverVariable7;
                                                                solverVariable10 = solverVariable8;
                                                                m496b(linearSystem, false, z16, z15, z272, solverVariable12, solverVariable11, dimensionBehaviour102, z17, constraintAnchor42, constraintAnchor52, i252, i9, i262, i272, f22, z11, z19, z5, z6, z26, i7, i6, this.mMatchConstraintMinHeight, this.mMatchConstraintMaxHeight, this.mMatchConstraintPercentHeight, z18);
                                                            } else {
                                                                solverVariable9 = solverVariable7;
                                                                solverVariable10 = solverVariable8;
                                                            }
                                                            if (z9) {
                                                                if (this.f2483j == 1) {
                                                                    linearSystem.addRatio(solverVariable9, solverVariable10, solverVariable4, solverVariable5, this.f2484k, 8);
                                                                } else {
                                                                    linearSystem.addRatio(solverVariable4, solverVariable5, solverVariable9, solverVariable10, this.f2484k, 8);
                                                                }
                                                            }
                                                            if (!this.mCenter.isConnected()) {
                                                                linearSystem.addCenterPoint(this, this.mCenter.getTarget().getOwner(), (float) Math.toRadians(this.mCircleConstraintAngle + 90.0f), this.mCenter.getMargin());
                                                            }
                                                            this.f2478e = false;
                                                            this.f2479f = false;
                                                            metrics2 = LinearSystem.sMetrics;
                                                            if (metrics2 == null) {
                                                                metrics2.mEquations = linearSystem.getNumEquations();
                                                                LinearSystem.sMetrics.mVariables = linearSystem.getNumVariables();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                    }
                                                    linearSystem2 = linearSystem;
                                                    solverVariable6 = solverVariable2;
                                                    solverVariable7 = solverVariable3;
                                                    solverVariable8 = solverVariable;
                                                    i12 = 8;
                                                    i13 = 0;
                                                    r11 = 1;
                                                    i14 = 1;
                                                    if (this.mVerticalResolution != 2) {
                                                    }
                                                    if (i15 == 0) {
                                                    }
                                                    solverVariable9 = solverVariable7;
                                                    solverVariable10 = solverVariable8;
                                                    if (z9) {
                                                    }
                                                    if (!this.mCenter.isConnected()) {
                                                    }
                                                    this.f2478e = false;
                                                    this.f2479f = false;
                                                    metrics2 = LinearSystem.sMetrics;
                                                    if (metrics2 == null) {
                                                    }
                                                }
                                            }
                                        }
                                        constraintWidget4 = this.mParent;
                                        if (constraintWidget4 == null) {
                                            solverVariable13 = linearSystem.createObjectVariable(constraintWidget4.mRight);
                                        } else {
                                            solverVariable13 = null;
                                        }
                                        constraintWidget5 = this.mParent;
                                        if (constraintWidget5 == null) {
                                            solverVariable14 = linearSystem.createObjectVariable(constraintWidget5.mLeft);
                                        } else {
                                            solverVariable14 = null;
                                        }
                                        boolean z28 = this.isTerminalWidget[0];
                                        dimensionBehaviourArr2 = this.mListDimensionBehaviors;
                                        DimensionBehaviour dimensionBehaviour11 = dimensionBehaviourArr2[0];
                                        ConstraintAnchor constraintAnchor6 = this.mLeft;
                                        ConstraintAnchor constraintAnchor7 = this.mRight;
                                        int i28 = this.f2487mX;
                                        int i29 = this.mMinWidth;
                                        int i30 = this.f2485l[0];
                                        float f3 = this.f2499x;
                                        if (dimensionBehaviourArr2[1] != dimensionBehaviour2) {
                                            z21 = true;
                                        } else {
                                            z21 = false;
                                        }
                                        z15 = z2;
                                        z16 = z3;
                                        solverVariable2 = createObjectVariable5;
                                        solverVariable3 = createObjectVariable4;
                                        dimensionBehaviour6 = dimensionBehaviour2;
                                        solverVariable = createObjectVariable3;
                                        solverVariable4 = createObjectVariable2;
                                        solverVariable5 = createObjectVariable;
                                        dimensionBehaviour7 = dimensionBehaviour5;
                                        m496b(linearSystem, true, z2, z3, z28, solverVariable14, solverVariable13, dimensionBehaviour11, z12, constraintAnchor6, constraintAnchor7, i28, i11, i29, i30, f3, z10, z21, z6, z5, z14, i6, i7, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z13);
                                        if (z) {
                                            dependencyNode = verticalWidgetRun.start;
                                            if (dependencyNode.resolved) {
                                                linearSystem2 = linearSystem;
                                                solverVariable8 = solverVariable;
                                                linearSystem2.addEquality(solverVariable8, dependencyNode.value);
                                                solverVariable7 = solverVariable3;
                                                linearSystem2.addEquality(solverVariable7, this.mVerticalRun.end.value);
                                                solverVariable6 = solverVariable2;
                                                linearSystem2.addEquality(solverVariable6, this.mVerticalRun.baseline.value);
                                                constraintWidget3 = this.mParent;
                                                if (constraintWidget3 == null) {
                                                }
                                                i12 = 8;
                                                i13 = 0;
                                                z20 = true;
                                                i14 = i13;
                                                r11 = z20;
                                                if (this.mVerticalResolution != 2) {
                                                }
                                                if (i15 == 0) {
                                                }
                                                solverVariable9 = solverVariable7;
                                                solverVariable10 = solverVariable8;
                                                if (z9) {
                                                }
                                                if (!this.mCenter.isConnected()) {
                                                }
                                                this.f2478e = false;
                                                this.f2479f = false;
                                                metrics2 = LinearSystem.sMetrics;
                                                if (metrics2 == null) {
                                                }
                                            }
                                        }
                                        linearSystem2 = linearSystem;
                                        solverVariable6 = solverVariable2;
                                        solverVariable7 = solverVariable3;
                                        solverVariable8 = solverVariable;
                                        i12 = 8;
                                        i13 = 0;
                                        r11 = 1;
                                        i14 = 1;
                                        if (this.mVerticalResolution != 2) {
                                        }
                                        if (i15 == 0) {
                                        }
                                        solverVariable9 = solverVariable7;
                                        solverVariable10 = solverVariable8;
                                        if (z9) {
                                        }
                                        if (!this.mCenter.isConnected()) {
                                        }
                                        this.f2478e = false;
                                        this.f2479f = false;
                                        metrics2 = LinearSystem.sMetrics;
                                        if (metrics2 == null) {
                                        }
                                    }
                                    z15 = z2;
                                    z16 = z3;
                                    dimensionBehaviour6 = dimensionBehaviour2;
                                    dimensionBehaviour7 = dimensionBehaviour5;
                                    solverVariable = createObjectVariable3;
                                    solverVariable2 = createObjectVariable5;
                                    solverVariable3 = createObjectVariable4;
                                    solverVariable4 = createObjectVariable2;
                                    solverVariable5 = createObjectVariable;
                                    if (z) {
                                    }
                                    linearSystem2 = linearSystem;
                                    solverVariable6 = solverVariable2;
                                    solverVariable7 = solverVariable3;
                                    solverVariable8 = solverVariable;
                                    i12 = 8;
                                    i13 = 0;
                                    r11 = 1;
                                    i14 = 1;
                                    if (this.mVerticalResolution != 2) {
                                    }
                                    if (i15 == 0) {
                                    }
                                    solverVariable9 = solverVariable7;
                                    solverVariable10 = solverVariable8;
                                    if (z9) {
                                    }
                                    if (!this.mCenter.isConnected()) {
                                    }
                                    this.f2478e = false;
                                    this.f2479f = false;
                                    metrics2 = LinearSystem.sMetrics;
                                    if (metrics2 == null) {
                                    }
                                }
                            } else {
                                i10 = -1;
                            }
                            z10 = false;
                            if (!z9) {
                            }
                            z11 = false;
                            dimensionBehaviour4 = this.mListDimensionBehaviors[0];
                            dimensionBehaviour5 = DimensionBehaviour.WRAP_CONTENT;
                            if (dimensionBehaviour4 != dimensionBehaviour5) {
                            }
                            z12 = false;
                            if (z12) {
                            }
                            z13 = !this.mCenter.isConnected();
                            z14 = zArr[0];
                            boolean z262 = zArr[1];
                            if (this.mHorizontalResolution != 2) {
                                if (z) {
                                    dependencyNode2 = horizontalWidgetRun.start;
                                    if (dependencyNode2.resolved) {
                                        if (!z) {
                                        }
                                    }
                                }
                                constraintWidget4 = this.mParent;
                                if (constraintWidget4 == null) {
                                }
                                constraintWidget5 = this.mParent;
                                if (constraintWidget5 == null) {
                                }
                                boolean z282 = this.isTerminalWidget[0];
                                dimensionBehaviourArr2 = this.mListDimensionBehaviors;
                                DimensionBehaviour dimensionBehaviour112 = dimensionBehaviourArr2[0];
                                ConstraintAnchor constraintAnchor62 = this.mLeft;
                                ConstraintAnchor constraintAnchor72 = this.mRight;
                                int i282 = this.f2487mX;
                                int i292 = this.mMinWidth;
                                int i302 = this.f2485l[0];
                                float f32 = this.f2499x;
                                if (dimensionBehaviourArr2[1] != dimensionBehaviour2) {
                                }
                                z15 = z2;
                                z16 = z3;
                                solverVariable2 = createObjectVariable5;
                                solverVariable3 = createObjectVariable4;
                                dimensionBehaviour6 = dimensionBehaviour2;
                                solverVariable = createObjectVariable3;
                                solverVariable4 = createObjectVariable2;
                                solverVariable5 = createObjectVariable;
                                dimensionBehaviour7 = dimensionBehaviour5;
                                m496b(linearSystem, true, z2, z3, z282, solverVariable14, solverVariable13, dimensionBehaviour112, z12, constraintAnchor62, constraintAnchor72, i282, i11, i292, i302, f32, z10, z21, z6, z5, z14, i6, i7, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z13);
                                if (z) {
                                }
                                linearSystem2 = linearSystem;
                                solverVariable6 = solverVariable2;
                                solverVariable7 = solverVariable3;
                                solverVariable8 = solverVariable;
                                i12 = 8;
                                i13 = 0;
                                r11 = 1;
                                i14 = 1;
                                if (this.mVerticalResolution != 2) {
                                }
                                if (i15 == 0) {
                                }
                                solverVariable9 = solverVariable7;
                                solverVariable10 = solverVariable8;
                                if (z9) {
                                }
                                if (!this.mCenter.isConnected()) {
                                }
                                this.f2478e = false;
                                this.f2479f = false;
                                metrics2 = LinearSystem.sMetrics;
                                if (metrics2 == null) {
                                }
                            }
                            z15 = z2;
                            z16 = z3;
                            dimensionBehaviour6 = dimensionBehaviour2;
                            dimensionBehaviour7 = dimensionBehaviour5;
                            solverVariable = createObjectVariable3;
                            solverVariable2 = createObjectVariable5;
                            solverVariable3 = createObjectVariable4;
                            solverVariable4 = createObjectVariable2;
                            solverVariable5 = createObjectVariable;
                            if (z) {
                            }
                            linearSystem2 = linearSystem;
                            solverVariable6 = solverVariable2;
                            solverVariable7 = solverVariable3;
                            solverVariable8 = solverVariable;
                            i12 = 8;
                            i13 = 0;
                            r11 = 1;
                            i14 = 1;
                            if (this.mVerticalResolution != 2) {
                            }
                            if (i15 == 0) {
                            }
                            solverVariable9 = solverVariable7;
                            solverVariable10 = solverVariable8;
                            if (z9) {
                            }
                            if (!this.mCenter.isConnected()) {
                            }
                            this.f2478e = false;
                            this.f2479f = false;
                            metrics2 = LinearSystem.sMetrics;
                            if (metrics2 == null) {
                            }
                        }
                    } else {
                        i17 = 3;
                    }
                    if (dimensionBehaviour == dimensionBehaviour2 && i22 == i17) {
                        this.f2483j = 0;
                        int i31 = (int) (f * i4);
                        if (dimensionBehaviour3 != dimensionBehaviour2) {
                            i6 = 4;
                            i7 = i23;
                            i9 = i20;
                            z9 = false;
                            i8 = i31;
                            int[] iArr2 = this.mResolvedMatchConstraintDefault;
                            iArr2[0] = i6;
                            iArr2[1] = i7;
                            if (!z9) {
                            }
                            z10 = false;
                            if (!z9) {
                            }
                            z11 = false;
                            dimensionBehaviour4 = this.mListDimensionBehaviors[0];
                            dimensionBehaviour5 = DimensionBehaviour.WRAP_CONTENT;
                            if (dimensionBehaviour4 != dimensionBehaviour5) {
                            }
                            z12 = false;
                            if (z12) {
                            }
                            z13 = !this.mCenter.isConnected();
                            z14 = zArr[0];
                            boolean z2622 = zArr[1];
                            if (this.mHorizontalResolution != 2) {
                            }
                            z15 = z2;
                            z16 = z3;
                            dimensionBehaviour6 = dimensionBehaviour2;
                            dimensionBehaviour7 = dimensionBehaviour5;
                            solverVariable = createObjectVariable3;
                            solverVariable2 = createObjectVariable5;
                            solverVariable3 = createObjectVariable4;
                            solverVariable4 = createObjectVariable2;
                            solverVariable5 = createObjectVariable;
                            if (z) {
                            }
                            linearSystem2 = linearSystem;
                            solverVariable6 = solverVariable2;
                            solverVariable7 = solverVariable3;
                            solverVariable8 = solverVariable;
                            i12 = 8;
                            i13 = 0;
                            r11 = 1;
                            i14 = 1;
                            if (this.mVerticalResolution != 2) {
                            }
                            if (i15 == 0) {
                            }
                            solverVariable9 = solverVariable7;
                            solverVariable10 = solverVariable8;
                            if (z9) {
                            }
                            if (!this.mCenter.isConnected()) {
                            }
                            this.f2478e = false;
                            this.f2479f = false;
                            metrics2 = LinearSystem.sMetrics;
                            if (metrics2 == null) {
                            }
                        } else {
                            i8 = i31;
                            i6 = i22;
                            i7 = i23;
                            i9 = i20;
                            z9 = true;
                            int[] iArr22 = this.mResolvedMatchConstraintDefault;
                            iArr22[0] = i6;
                            iArr22[1] = i7;
                            if (!z9) {
                            }
                            z10 = false;
                            if (!z9) {
                            }
                            z11 = false;
                            dimensionBehaviour4 = this.mListDimensionBehaviors[0];
                            dimensionBehaviour5 = DimensionBehaviour.WRAP_CONTENT;
                            if (dimensionBehaviour4 != dimensionBehaviour5) {
                            }
                            z12 = false;
                            if (z12) {
                            }
                            z13 = !this.mCenter.isConnected();
                            z14 = zArr[0];
                            boolean z26222 = zArr[1];
                            if (this.mHorizontalResolution != 2) {
                            }
                            z15 = z2;
                            z16 = z3;
                            dimensionBehaviour6 = dimensionBehaviour2;
                            dimensionBehaviour7 = dimensionBehaviour5;
                            solverVariable = createObjectVariable3;
                            solverVariable2 = createObjectVariable5;
                            solverVariable3 = createObjectVariable4;
                            solverVariable4 = createObjectVariable2;
                            solverVariable5 = createObjectVariable;
                            if (z) {
                            }
                            linearSystem2 = linearSystem;
                            solverVariable6 = solverVariable2;
                            solverVariable7 = solverVariable3;
                            solverVariable8 = solverVariable;
                            i12 = 8;
                            i13 = 0;
                            r11 = 1;
                            i14 = 1;
                            if (this.mVerticalResolution != 2) {
                            }
                            if (i15 == 0) {
                            }
                            solverVariable9 = solverVariable7;
                            solverVariable10 = solverVariable8;
                            if (z9) {
                            }
                            if (!this.mCenter.isConnected()) {
                            }
                            this.f2478e = false;
                            this.f2479f = false;
                            metrics2 = LinearSystem.sMetrics;
                            if (metrics2 == null) {
                            }
                        }
                    } else {
                        if (dimensionBehaviour3 == dimensionBehaviour2 && i23 == i17) {
                            this.f2483j = 1;
                            if (i21 == -1) {
                                this.f2484k = 1.0f / f;
                            }
                            int i32 = (int) (this.f2484k * i2);
                            if (dimensionBehaviour != dimensionBehaviour2) {
                                i7 = 4;
                                i9 = i32;
                                i6 = i22;
                                i8 = i19;
                                z9 = false;
                                int[] iArr222 = this.mResolvedMatchConstraintDefault;
                                iArr222[0] = i6;
                                iArr222[1] = i7;
                                if (!z9) {
                                }
                                z10 = false;
                                if (!z9) {
                                }
                                z11 = false;
                                dimensionBehaviour4 = this.mListDimensionBehaviors[0];
                                dimensionBehaviour5 = DimensionBehaviour.WRAP_CONTENT;
                                if (dimensionBehaviour4 != dimensionBehaviour5) {
                                }
                                z12 = false;
                                if (z12) {
                                }
                                z13 = !this.mCenter.isConnected();
                                z14 = zArr[0];
                                boolean z262222 = zArr[1];
                                if (this.mHorizontalResolution != 2) {
                                }
                                z15 = z2;
                                z16 = z3;
                                dimensionBehaviour6 = dimensionBehaviour2;
                                dimensionBehaviour7 = dimensionBehaviour5;
                                solverVariable = createObjectVariable3;
                                solverVariable2 = createObjectVariable5;
                                solverVariable3 = createObjectVariable4;
                                solverVariable4 = createObjectVariable2;
                                solverVariable5 = createObjectVariable;
                                if (z) {
                                }
                                linearSystem2 = linearSystem;
                                solverVariable6 = solverVariable2;
                                solverVariable7 = solverVariable3;
                                solverVariable8 = solverVariable;
                                i12 = 8;
                                i13 = 0;
                                r11 = 1;
                                i14 = 1;
                                if (this.mVerticalResolution != 2) {
                                }
                                if (i15 == 0) {
                                }
                                solverVariable9 = solverVariable7;
                                solverVariable10 = solverVariable8;
                                if (z9) {
                                }
                                if (!this.mCenter.isConnected()) {
                                }
                                this.f2478e = false;
                                this.f2479f = false;
                                metrics2 = LinearSystem.sMetrics;
                                if (metrics2 == null) {
                                }
                            } else {
                                i9 = i32;
                                i6 = i22;
                                i7 = i23;
                                i8 = i19;
                                z9 = true;
                                int[] iArr2222 = this.mResolvedMatchConstraintDefault;
                                iArr2222[0] = i6;
                                iArr2222[1] = i7;
                                if (!z9) {
                                }
                                z10 = false;
                                if (!z9) {
                                }
                                z11 = false;
                                dimensionBehaviour4 = this.mListDimensionBehaviors[0];
                                dimensionBehaviour5 = DimensionBehaviour.WRAP_CONTENT;
                                if (dimensionBehaviour4 != dimensionBehaviour5) {
                                }
                                z12 = false;
                                if (z12) {
                                }
                                z13 = !this.mCenter.isConnected();
                                z14 = zArr[0];
                                boolean z2622222 = zArr[1];
                                if (this.mHorizontalResolution != 2) {
                                }
                                z15 = z2;
                                z16 = z3;
                                dimensionBehaviour6 = dimensionBehaviour2;
                                dimensionBehaviour7 = dimensionBehaviour5;
                                solverVariable = createObjectVariable3;
                                solverVariable2 = createObjectVariable5;
                                solverVariable3 = createObjectVariable4;
                                solverVariable4 = createObjectVariable2;
                                solverVariable5 = createObjectVariable;
                                if (z) {
                                }
                                linearSystem2 = linearSystem;
                                solverVariable6 = solverVariable2;
                                solverVariable7 = solverVariable3;
                                solverVariable8 = solverVariable;
                                i12 = 8;
                                i13 = 0;
                                r11 = 1;
                                i14 = 1;
                                if (this.mVerticalResolution != 2) {
                                }
                                if (i15 == 0) {
                                }
                                solverVariable9 = solverVariable7;
                                solverVariable10 = solverVariable8;
                                if (z9) {
                                }
                                if (!this.mCenter.isConnected()) {
                                }
                                this.f2478e = false;
                                this.f2479f = false;
                                metrics2 = LinearSystem.sMetrics;
                                if (metrics2 == null) {
                                }
                            }
                        }
                        i6 = i22;
                        i7 = i23;
                        i8 = i19;
                        i9 = i20;
                        z9 = true;
                        int[] iArr22222 = this.mResolvedMatchConstraintDefault;
                        iArr22222[0] = i6;
                        iArr22222[1] = i7;
                        if (!z9) {
                        }
                        z10 = false;
                        if (!z9) {
                        }
                        z11 = false;
                        dimensionBehaviour4 = this.mListDimensionBehaviors[0];
                        dimensionBehaviour5 = DimensionBehaviour.WRAP_CONTENT;
                        if (dimensionBehaviour4 != dimensionBehaviour5) {
                        }
                        z12 = false;
                        if (z12) {
                        }
                        z13 = !this.mCenter.isConnected();
                        z14 = zArr[0];
                        boolean z26222222 = zArr[1];
                        if (this.mHorizontalResolution != 2) {
                        }
                        z15 = z2;
                        z16 = z3;
                        dimensionBehaviour6 = dimensionBehaviour2;
                        dimensionBehaviour7 = dimensionBehaviour5;
                        solverVariable = createObjectVariable3;
                        solverVariable2 = createObjectVariable5;
                        solverVariable3 = createObjectVariable4;
                        solverVariable4 = createObjectVariable2;
                        solverVariable5 = createObjectVariable;
                        if (z) {
                        }
                        linearSystem2 = linearSystem;
                        solverVariable6 = solverVariable2;
                        solverVariable7 = solverVariable3;
                        solverVariable8 = solverVariable;
                        i12 = 8;
                        i13 = 0;
                        r11 = 1;
                        i14 = 1;
                        if (this.mVerticalResolution != 2) {
                        }
                        if (i15 == 0) {
                        }
                        solverVariable9 = solverVariable7;
                        solverVariable10 = solverVariable8;
                        if (z9) {
                        }
                        if (!this.mCenter.isConnected()) {
                        }
                        this.f2478e = false;
                        this.f2479f = false;
                        metrics2 = LinearSystem.sMetrics;
                        if (metrics2 == null) {
                        }
                    }
                }
            } else {
                zArr = zArr2;
            }
            i6 = i22;
            i7 = i23;
            i8 = i19;
            i9 = i20;
            z9 = false;
            int[] iArr222222 = this.mResolvedMatchConstraintDefault;
            iArr222222[0] = i6;
            iArr222222[1] = i7;
            if (!z9) {
            }
            z10 = false;
            if (!z9) {
            }
            z11 = false;
            dimensionBehaviour4 = this.mListDimensionBehaviors[0];
            dimensionBehaviour5 = DimensionBehaviour.WRAP_CONTENT;
            if (dimensionBehaviour4 != dimensionBehaviour5) {
            }
            z12 = false;
            if (z12) {
            }
            z13 = !this.mCenter.isConnected();
            z14 = zArr[0];
            boolean z262222222 = zArr[1];
            if (this.mHorizontalResolution != 2) {
            }
            z15 = z2;
            z16 = z3;
            dimensionBehaviour6 = dimensionBehaviour2;
            dimensionBehaviour7 = dimensionBehaviour5;
            solverVariable = createObjectVariable3;
            solverVariable2 = createObjectVariable5;
            solverVariable3 = createObjectVariable4;
            solverVariable4 = createObjectVariable2;
            solverVariable5 = createObjectVariable;
            if (z) {
            }
            linearSystem2 = linearSystem;
            solverVariable6 = solverVariable2;
            solverVariable7 = solverVariable3;
            solverVariable8 = solverVariable;
            i12 = 8;
            i13 = 0;
            r11 = 1;
            i14 = 1;
            if (this.mVerticalResolution != 2) {
            }
            if (i15 == 0) {
            }
            solverVariable9 = solverVariable7;
            solverVariable10 = solverVariable8;
            if (z9) {
            }
            if (!this.mCenter.isConnected()) {
            }
            this.f2478e = false;
            this.f2479f = false;
            metrics2 = LinearSystem.sMetrics;
            if (metrics2 == null) {
            }
        }
        z2 = false;
        z3 = false;
        i = this.f2466B;
        boolean[] zArr22 = this.f2495t;
        if (i != 8) {
        }
        z4 = this.f2478e;
        if (!z4) {
        }
        boolean z252 = this.f2475b;
        if (z4) {
        }
        if (this.f2479f) {
        }
        if (this.f2478e) {
            this.f2478e = false;
            this.f2479f = false;
            return;
        }
        metrics = LinearSystem.sMetrics;
        if (metrics != null) {
        }
        if (z) {
            dependencyNode3 = horizontalWidgetRun2.start;
            if (dependencyNode3.resolved) {
                if (metrics != null) {
                }
                linearSystem.addEquality(createObjectVariable, dependencyNode3.value);
                linearSystem.addEquality(createObjectVariable2, this.mHorizontalRun.end.value);
                linearSystem.addEquality(createObjectVariable3, this.mVerticalRun.start.value);
                linearSystem.addEquality(createObjectVariable4, this.mVerticalRun.end.value);
                linearSystem.addEquality(createObjectVariable5, this.mVerticalRun.baseline.value);
                if (this.mParent != null) {
                }
                z22 = false;
                this.f2478e = z22;
                this.f2479f = z22;
                return;
            }
        }
        if (metrics != null) {
        }
        if (this.mParent == null) {
        }
        i2 = this.f2496u;
        i3 = this.mMinWidth;
        if (i2 >= i3) {
        }
        i4 = this.f2497v;
        i5 = this.mMinHeight;
        if (i4 >= i5) {
        }
        DimensionBehaviour[] dimensionBehaviourArr42 = this.mListDimensionBehaviors;
        dimensionBehaviour = dimensionBehaviourArr42[0];
        dimensionBehaviour2 = DimensionBehaviour.MATCH_CONSTRAINT;
        int i192 = i3;
        if (dimensionBehaviour == dimensionBehaviour2) {
        }
        dimensionBehaviour3 = dimensionBehaviourArr42[1];
        int i202 = i5;
        if (dimensionBehaviour3 == dimensionBehaviour2) {
        }
        int i212 = this.mDimensionRatioSide;
        this.f2483j = i212;
        f = this.mDimensionRatio;
        this.f2484k = f;
        int i222 = this.mMatchConstraintDefaultWidth;
        int i232 = this.mMatchConstraintDefaultHeight;
        if (f <= RecyclerView.f7068F0) {
        }
        i6 = i222;
        i7 = i232;
        i8 = i192;
        i9 = i202;
        z9 = false;
        int[] iArr2222222 = this.mResolvedMatchConstraintDefault;
        iArr2222222[0] = i6;
        iArr2222222[1] = i7;
        if (!z9) {
        }
        z10 = false;
        if (!z9) {
        }
        z11 = false;
        dimensionBehaviour4 = this.mListDimensionBehaviors[0];
        dimensionBehaviour5 = DimensionBehaviour.WRAP_CONTENT;
        if (dimensionBehaviour4 != dimensionBehaviour5) {
        }
        z12 = false;
        if (z12) {
        }
        z13 = !this.mCenter.isConnected();
        z14 = zArr[0];
        boolean z2622222222 = zArr[1];
        if (this.mHorizontalResolution != 2) {
        }
        z15 = z2;
        z16 = z3;
        dimensionBehaviour6 = dimensionBehaviour2;
        dimensionBehaviour7 = dimensionBehaviour5;
        solverVariable = createObjectVariable3;
        solverVariable2 = createObjectVariable5;
        solverVariable3 = createObjectVariable4;
        solverVariable4 = createObjectVariable2;
        solverVariable5 = createObjectVariable;
        if (z) {
        }
        linearSystem2 = linearSystem;
        solverVariable6 = solverVariable2;
        solverVariable7 = solverVariable3;
        solverVariable8 = solverVariable;
        i12 = 8;
        i13 = 0;
        r11 = 1;
        i14 = 1;
        if (this.mVerticalResolution != 2) {
        }
        if (i15 == 0) {
        }
        solverVariable9 = solverVariable7;
        solverVariable10 = solverVariable8;
        if (z9) {
        }
        if (!this.mCenter.isConnected()) {
        }
        this.f2478e = false;
        this.f2479f = false;
        metrics2 = LinearSystem.sMetrics;
        if (metrics2 == null) {
        }
    }

    public boolean allowedInBarrier() {
        if (this.f2466B != 8) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:135:0x03be A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x042e  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0454 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x046e  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x04cd A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0450  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0506  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0513 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x04ee A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m496b(LinearSystem linearSystem, boolean z, boolean z2, boolean z3, boolean z4, SolverVariable solverVariable, SolverVariable solverVariable2, DimensionBehaviour dimensionBehaviour, boolean z5, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i, int i2, int i3, int i4, float f, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i5, int i6, int i7, int i8, float f2, boolean z11) {
        int i9;
        SolverVariable solverVariable3;
        boolean z12;
        boolean z13;
        boolean z14;
        int i10;
        boolean z15;
        int i11;
        int i12;
        int i13;
        SolverVariable solverVariable4;
        SolverVariable solverVariable5;
        SolverVariable solverVariable6;
        int i14;
        boolean z16;
        boolean z17;
        SolverVariable createObjectVariable;
        SolverVariable createObjectVariable2;
        SolverVariable solverVariable7;
        SolverVariable solverVariable8;
        SolverVariable solverVariable9;
        char c;
        SolverVariable solverVariable10;
        int i15;
        int i16;
        ConstraintAnchor constraintAnchor3;
        int i17;
        SolverVariable solverVariable11;
        boolean z18;
        boolean z19;
        int i18;
        int i19;
        int i20;
        SolverVariable solverVariable12;
        int i21;
        boolean z20;
        boolean z21;
        boolean z22;
        ConstraintWidget constraintWidget;
        boolean z23;
        SolverVariable solverVariable13;
        int i22;
        ConstraintWidget constraintWidget2;
        SolverVariable solverVariable14;
        int i23;
        boolean z24;
        SolverVariable solverVariable15;
        ConstraintWidget constraintWidget3;
        int i24;
        int i25;
        int i26;
        boolean z25;
        int i27;
        int i28;
        int i29;
        boolean z26;
        int i30;
        boolean z27;
        int i31;
        SolverVariable solverVariable16;
        int i32;
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(constraintAnchor);
        SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(constraintAnchor2);
        SolverVariable createObjectVariable5 = linearSystem.createObjectVariable(constraintAnchor.getTarget());
        SolverVariable createObjectVariable6 = linearSystem.createObjectVariable(constraintAnchor2.getTarget());
        if (LinearSystem.getMetrics() != null) {
            LinearSystem.getMetrics().nonresolvedWidgets++;
        }
        boolean isConnected = constraintAnchor.isConnected();
        boolean isConnected2 = constraintAnchor2.isConnected();
        boolean isConnected3 = this.mCenter.isConnected();
        int i33 = isConnected2 ? (isConnected ? 1 : 0) + 1 : isConnected ? 1 : 0;
        if (isConnected3) {
            i33++;
        }
        if (z6) {
            solverVariable3 = createObjectVariable6;
            i9 = 3;
        } else {
            i9 = i5;
            solverVariable3 = createObjectVariable6;
        }
        int ordinal = dimensionBehaviour.ordinal();
        boolean z28 = (ordinal == 0 || ordinal == 1 || ordinal != 2 || i9 == 4) ? false : true;
        int i34 = this.f2476c;
        if (i34 == -1 || !z) {
            i34 = i2;
            z12 = z28;
        } else {
            this.f2476c = -1;
            z12 = false;
        }
        int i35 = this.f2477d;
        if (i35 == -1 || z) {
            z13 = z12;
        } else {
            this.f2477d = -1;
            i34 = i35;
            z13 = false;
        }
        int i36 = i34;
        if (this.f2466B == 8) {
            i10 = 0;
            z14 = false;
        } else {
            z14 = z13;
            i10 = i36;
        }
        if (z11) {
            if (!isConnected && !isConnected2 && !isConnected3) {
                linearSystem.addEquality(createObjectVariable3, i);
            } else if (isConnected && !isConnected2) {
                z15 = isConnected2;
                i11 = 8;
                linearSystem.addEquality(createObjectVariable3, createObjectVariable5, constraintAnchor.getMargin(), 8);
            }
            z15 = isConnected2;
            i11 = 8;
        } else {
            z15 = isConnected2;
            i11 = 8;
        }
        if (z14) {
            if (i33 == 2 || z6 || !(i9 == 1 || i9 == 0)) {
                int i37 = i7 == -2 ? i10 : i7;
                i12 = i8 == -2 ? i10 : i8;
                if (i10 > 0 && i9 != 1) {
                    i10 = 0;
                }
                if (i37 > 0) {
                    linearSystem.addGreaterThan(createObjectVariable4, createObjectVariable3, i37, 8);
                    i10 = Math.max(i10, i37);
                }
                if (i12 > 0) {
                    if (!z2 || i9 != 1) {
                        linearSystem.addLowerThan(createObjectVariable4, createObjectVariable3, i12, 8);
                    }
                    i10 = Math.min(i10, i12);
                }
                if (i9 == 1) {
                    if (z2) {
                        linearSystem.addEquality(createObjectVariable4, createObjectVariable3, i10, 8);
                    } else if (z8) {
                        linearSystem.addEquality(createObjectVariable4, createObjectVariable3, i10, 5);
                        linearSystem.addLowerThan(createObjectVariable4, createObjectVariable3, i10, 8);
                    } else {
                        linearSystem.addEquality(createObjectVariable4, createObjectVariable3, i10, 5);
                        linearSystem.addLowerThan(createObjectVariable4, createObjectVariable3, i10, 8);
                    }
                    i13 = i33;
                    solverVariable4 = createObjectVariable4;
                    i14 = i37;
                } else {
                    if (i9 != 2) {
                        i13 = i33;
                        solverVariable4 = createObjectVariable4;
                        int i38 = i37;
                        solverVariable5 = solverVariable3;
                        boolean z29 = z14;
                        solverVariable6 = createObjectVariable5;
                        i14 = i38;
                        z16 = z29;
                        z17 = true;
                        if (!z11) {
                            solverVariable7 = solverVariable;
                            solverVariable8 = solverVariable2;
                            solverVariable9 = solverVariable4;
                            c = 1;
                            solverVariable10 = createObjectVariable3;
                            i15 = i13;
                            i16 = 2;
                        } else if (z8) {
                            solverVariable7 = solverVariable;
                            solverVariable8 = solverVariable2;
                            solverVariable9 = solverVariable4;
                            i15 = i13;
                            i16 = 2;
                            c = 1;
                            solverVariable10 = createObjectVariable3;
                        } else {
                            if (isConnected || z15 || isConnected3) {
                                if (isConnected && !z15) {
                                    z24 = z2;
                                    solverVariable15 = solverVariable4;
                                    i31 = (z2 && (constraintAnchor.mTarget.mOwner instanceof Barrier)) ? 8 : 5;
                                    if (z24) {
                                    }
                                } else if (!isConnected && z15) {
                                    linearSystem.addEquality(solverVariable4, solverVariable5, -constraintAnchor2.getMargin(), 8);
                                    if (z2) {
                                        i25 = 5;
                                        linearSystem.addGreaterThan(createObjectVariable3, solverVariable, 0, 5);
                                        solverVariable15 = solverVariable4;
                                        z24 = z2;
                                        i31 = i25;
                                        if (z24) {
                                        }
                                    }
                                } else if (isConnected && z15) {
                                    ConstraintWidget constraintWidget4 = constraintAnchor.mTarget.mOwner;
                                    boolean z30 = true;
                                    ConstraintWidget constraintWidget5 = constraintAnchor2.mTarget.mOwner;
                                    ConstraintWidget parent = getParent();
                                    int i39 = 6;
                                    if (!z16) {
                                        i17 = i9;
                                        if (solverVariable6.isFinalValue && solverVariable5.isFinalValue) {
                                            linearSystem.addCentering(createObjectVariable3, solverVariable6, constraintAnchor.getMargin(), f, solverVariable5, solverVariable4, constraintAnchor2.getMargin(), 8);
                                            if (z2 && z17) {
                                                if (constraintAnchor2.mTarget != null) {
                                                    i21 = constraintAnchor2.getMargin();
                                                    solverVariable12 = solverVariable2;
                                                } else {
                                                    solverVariable12 = solverVariable2;
                                                    i21 = 0;
                                                }
                                                if (solverVariable5 != solverVariable12) {
                                                    linearSystem.addGreaterThan(solverVariable12, solverVariable4, i21, 5);
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        solverVariable11 = solverVariable2;
                                        z18 = true;
                                        z19 = true;
                                        i18 = 6;
                                        i19 = 4;
                                        i20 = 5;
                                    } else {
                                        if (i9 == 0) {
                                            if (i12 != 0 || i14 != 0) {
                                                z26 = true;
                                                z18 = true;
                                                i30 = 5;
                                                i19 = 5;
                                                z27 = false;
                                            } else if (solverVariable6.isFinalValue && solverVariable5.isFinalValue) {
                                                linearSystem.addEquality(createObjectVariable3, solverVariable6, constraintAnchor.getMargin(), 8);
                                                linearSystem.addEquality(solverVariable4, solverVariable5, -constraintAnchor2.getMargin(), 8);
                                                return;
                                            } else {
                                                z27 = true;
                                                i30 = 8;
                                                i19 = 8;
                                                z26 = false;
                                                z18 = false;
                                            }
                                            if ((constraintWidget4 instanceof Barrier) || (constraintWidget5 instanceof Barrier)) {
                                                z19 = z26;
                                                z20 = z27;
                                                z30 = true;
                                                i19 = 4;
                                            } else {
                                                z19 = z26;
                                                z20 = z27;
                                                z30 = true;
                                            }
                                            i20 = i30;
                                            i17 = i9;
                                        } else {
                                            if (i9 == 2) {
                                                if ((constraintWidget4 instanceof Barrier) || (constraintWidget5 instanceof Barrier)) {
                                                    i17 = i9;
                                                    i18 = 6;
                                                    z30 = true;
                                                    i19 = 4;
                                                } else {
                                                    i17 = i9;
                                                    i18 = 6;
                                                    z30 = true;
                                                    i19 = 5;
                                                }
                                                i20 = 5;
                                            } else if (i9 == 1) {
                                                i17 = i9;
                                                i18 = 6;
                                                z30 = true;
                                                i19 = 4;
                                                i20 = 8;
                                            } else if (i9 == 3) {
                                                i17 = i9;
                                                if (this.f2483j == -1) {
                                                    if (z9) {
                                                        solverVariable11 = solverVariable2;
                                                        i18 = z2 ? 5 : 4;
                                                    } else {
                                                        solverVariable11 = solverVariable2;
                                                        i18 = 8;
                                                    }
                                                    z30 = true;
                                                    i19 = 5;
                                                    i20 = 8;
                                                    z18 = true;
                                                    z19 = true;
                                                    z20 = true;
                                                } else if (z6) {
                                                    if (i6 != 2) {
                                                        z30 = true;
                                                        if (i6 != 1) {
                                                            i28 = 8;
                                                            i29 = 5;
                                                            i20 = i28;
                                                            i19 = i29;
                                                            z18 = z30;
                                                            z19 = z18;
                                                            z20 = z19;
                                                        }
                                                    } else {
                                                        z30 = true;
                                                    }
                                                    i28 = 5;
                                                    i29 = 4;
                                                    i20 = i28;
                                                    i19 = i29;
                                                    z18 = z30;
                                                    z19 = z18;
                                                    z20 = z19;
                                                } else {
                                                    z30 = true;
                                                    if (i12 > 0) {
                                                        solverVariable11 = solverVariable2;
                                                        z18 = true;
                                                        z19 = true;
                                                        z20 = true;
                                                        i18 = 6;
                                                        i19 = 5;
                                                    } else if (i12 != 0 || i14 != 0) {
                                                        solverVariable11 = solverVariable2;
                                                        z18 = true;
                                                        z19 = true;
                                                        z20 = true;
                                                        i18 = 6;
                                                        i19 = 4;
                                                    } else if (z9) {
                                                        solverVariable11 = solverVariable2;
                                                        i20 = (constraintWidget4 == parent || constraintWidget5 == parent) ? 5 : 4;
                                                        z18 = true;
                                                        z19 = true;
                                                        z20 = true;
                                                        i18 = 6;
                                                        i19 = 4;
                                                    } else {
                                                        solverVariable11 = solverVariable2;
                                                        z18 = true;
                                                        z19 = true;
                                                        z20 = true;
                                                        i18 = 6;
                                                        i19 = 8;
                                                    }
                                                    i20 = 5;
                                                }
                                                if (z18 || solverVariable6 != solverVariable5 || constraintWidget4 == parent) {
                                                    z21 = z18;
                                                    z22 = z30;
                                                } else {
                                                    z22 = false;
                                                    z21 = false;
                                                }
                                                if (z19) {
                                                    constraintWidget = constraintWidget5;
                                                    z23 = z30;
                                                    solverVariable13 = solverVariable4;
                                                    i22 = i17;
                                                    constraintWidget2 = parent;
                                                    solverVariable14 = createObjectVariable3;
                                                    i23 = i20;
                                                    z24 = z2;
                                                } else {
                                                    if (z16 || z7 || z9 || solverVariable6 != solverVariable || solverVariable5 != solverVariable11) {
                                                        i26 = i18;
                                                        z25 = z22;
                                                        i27 = i20;
                                                        z24 = z2;
                                                    } else {
                                                        z24 = false;
                                                        i27 = 8;
                                                        i26 = 8;
                                                        z25 = false;
                                                    }
                                                    i22 = i17;
                                                    constraintWidget2 = parent;
                                                    constraintWidget = constraintWidget5;
                                                    z23 = z30;
                                                    SolverVariable solverVariable17 = solverVariable4;
                                                    solverVariable13 = solverVariable4;
                                                    solverVariable14 = createObjectVariable3;
                                                    linearSystem.addCentering(createObjectVariable3, solverVariable6, constraintAnchor.getMargin(), f, solverVariable5, solverVariable17, constraintAnchor2.getMargin(), i26);
                                                    i23 = i27;
                                                    z22 = z25;
                                                }
                                                if (this.f2466B != 8 && !constraintAnchor2.hasDependents()) {
                                                    return;
                                                }
                                                if (z21) {
                                                    solverVariable15 = solverVariable13;
                                                } else {
                                                    if (z24 && solverVariable6 != solverVariable5 && !z16 && ((constraintWidget4 instanceof Barrier) || (constraintWidget instanceof Barrier))) {
                                                        i23 = 6;
                                                    }
                                                    linearSystem.addGreaterThan(solverVariable14, solverVariable6, constraintAnchor.getMargin(), i23);
                                                    solverVariable15 = solverVariable13;
                                                    linearSystem.addLowerThan(solverVariable15, solverVariable5, -constraintAnchor2.getMargin(), i23);
                                                }
                                                if (z24 || !z10 || (constraintWidget4 instanceof Barrier) || (constraintWidget instanceof Barrier)) {
                                                    constraintWidget3 = constraintWidget2;
                                                } else {
                                                    constraintWidget3 = constraintWidget2;
                                                    if (constraintWidget != constraintWidget3) {
                                                        i23 = 6;
                                                        i24 = 6;
                                                        z22 = z23;
                                                        if (z22) {
                                                            if (z20 && (!z9 || z3)) {
                                                                if (constraintWidget4 != constraintWidget3 && constraintWidget != constraintWidget3) {
                                                                    i39 = i24;
                                                                }
                                                                if ((constraintWidget4 instanceof Guideline) || (constraintWidget instanceof Guideline)) {
                                                                    i39 = 5;
                                                                }
                                                                if ((constraintWidget4 instanceof Barrier) || (constraintWidget instanceof Barrier)) {
                                                                    i39 = 5;
                                                                }
                                                                i24 = Math.max(z9 ? 5 : i39, i24);
                                                            }
                                                            if (z24) {
                                                                i24 = (z6 && !z9 && (constraintWidget4 == constraintWidget3 || constraintWidget == constraintWidget3)) ? 4 : Math.min(i23, i24);
                                                            }
                                                            linearSystem.addEquality(solverVariable14, solverVariable6, constraintAnchor.getMargin(), i24);
                                                            linearSystem.addEquality(solverVariable15, solverVariable5, -constraintAnchor2.getMargin(), i24);
                                                        }
                                                        if (z24) {
                                                            int margin = solverVariable == solverVariable6 ? constraintAnchor.getMargin() : 0;
                                                            if (solverVariable6 != solverVariable) {
                                                                linearSystem.addGreaterThan(solverVariable14, solverVariable, margin, 5);
                                                            }
                                                        }
                                                        if (z24 && z16 && i3 == 0 && i14 == 0) {
                                                            if (!z16 && i22 == 3) {
                                                                linearSystem.addGreaterThan(solverVariable15, solverVariable14, 0, 8);
                                                            } else {
                                                                i25 = 5;
                                                                linearSystem.addGreaterThan(solverVariable15, solverVariable14, 0, 5);
                                                                i31 = i25;
                                                                if (z24 || !z17) {
                                                                    return;
                                                                }
                                                                if (constraintAnchor2.mTarget != null) {
                                                                    i32 = constraintAnchor2.getMargin();
                                                                    solverVariable16 = solverVariable2;
                                                                } else {
                                                                    solverVariable16 = solverVariable2;
                                                                    i32 = 0;
                                                                }
                                                                if (solverVariable5 != solverVariable16) {
                                                                    linearSystem.addGreaterThan(solverVariable16, solverVariable15, i32, i31);
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                        }
                                                        i25 = 5;
                                                        i31 = i25;
                                                        if (z24) {
                                                            return;
                                                        } else {
                                                            return;
                                                        }
                                                    }
                                                }
                                                i24 = i19;
                                                if (z22) {
                                                }
                                                if (z24) {
                                                }
                                                if (z24) {
                                                    if (!z16) {
                                                    }
                                                    i25 = 5;
                                                    linearSystem.addGreaterThan(solverVariable15, solverVariable14, 0, 5);
                                                    i31 = i25;
                                                    if (z24) {
                                                    }
                                                }
                                                i25 = 5;
                                                i31 = i25;
                                                if (z24) {
                                                }
                                            } else {
                                                i17 = i9;
                                                z30 = true;
                                                solverVariable11 = solverVariable2;
                                                i18 = 6;
                                                i19 = 4;
                                                i20 = 5;
                                                z18 = false;
                                                z19 = false;
                                            }
                                            z18 = true;
                                            z19 = true;
                                            z20 = false;
                                            solverVariable11 = solverVariable2;
                                            if (z18) {
                                            }
                                            z21 = z18;
                                            z22 = z30;
                                            if (z19) {
                                            }
                                            if (this.f2466B != 8) {
                                            }
                                            if (z21) {
                                            }
                                            if (z24) {
                                            }
                                            constraintWidget3 = constraintWidget2;
                                            i24 = i19;
                                            if (z22) {
                                            }
                                            if (z24) {
                                            }
                                            if (z24) {
                                            }
                                            i25 = 5;
                                            i31 = i25;
                                            if (z24) {
                                            }
                                        }
                                        i18 = 6;
                                        solverVariable11 = solverVariable2;
                                        if (z18) {
                                        }
                                        z21 = z18;
                                        z22 = z30;
                                        if (z19) {
                                        }
                                        if (this.f2466B != 8) {
                                        }
                                        if (z21) {
                                        }
                                        if (z24) {
                                        }
                                        constraintWidget3 = constraintWidget2;
                                        i24 = i19;
                                        if (z22) {
                                        }
                                        if (z24) {
                                        }
                                        if (z24) {
                                        }
                                        i25 = 5;
                                        i31 = i25;
                                        if (z24) {
                                        }
                                    }
                                    z20 = false;
                                    if (z18) {
                                    }
                                    z21 = z18;
                                    z22 = z30;
                                    if (z19) {
                                    }
                                    if (this.f2466B != 8) {
                                    }
                                    if (z21) {
                                    }
                                    if (z24) {
                                    }
                                    constraintWidget3 = constraintWidget2;
                                    i24 = i19;
                                    if (z22) {
                                    }
                                    if (z24) {
                                    }
                                    if (z24) {
                                    }
                                    i25 = 5;
                                    i31 = i25;
                                    if (z24) {
                                    }
                                }
                            }
                            solverVariable15 = solverVariable4;
                            i25 = 5;
                            z24 = z2;
                            i31 = i25;
                            if (z24) {
                            }
                        }
                        if (i15 < i16 && z2 && z17) {
                            linearSystem.addGreaterThan(solverVariable10, solverVariable7, 0, 8);
                            char c2 = (z || this.mBaseline.mTarget == null) ? c : (char) 0;
                            if (!z && (constraintAnchor3 = this.mBaseline.mTarget) != null) {
                                ConstraintWidget constraintWidget6 = constraintAnchor3.mOwner;
                                if (constraintWidget6.mDimensionRatio != RecyclerView.f7068F0) {
                                    DimensionBehaviour[] dimensionBehaviourArr = constraintWidget6.mListDimensionBehaviors;
                                    DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[0];
                                    DimensionBehaviour dimensionBehaviour3 = DimensionBehaviour.MATCH_CONSTRAINT;
                                    if (dimensionBehaviour2 == dimensionBehaviour3 && dimensionBehaviourArr[c] == dimensionBehaviour3) {
                                        c2 = c;
                                    }
                                }
                                c2 = 0;
                            }
                            if (c2 != 0) {
                                linearSystem.addGreaterThan(solverVariable8, solverVariable9, 0, 8);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    ConstraintAnchor.Type type = constraintAnchor.getType();
                    ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
                    if (type != type2 && constraintAnchor.getType() != ConstraintAnchor.Type.BOTTOM) {
                        createObjectVariable = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.LEFT));
                        createObjectVariable2 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.RIGHT));
                    } else {
                        createObjectVariable = linearSystem.createObjectVariable(this.mParent.getAnchor(type2));
                        createObjectVariable2 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.BOTTOM));
                    }
                    int i40 = i37;
                    solverVariable5 = solverVariable3;
                    boolean z31 = z14;
                    solverVariable6 = createObjectVariable5;
                    i13 = i33;
                    solverVariable4 = createObjectVariable4;
                    linearSystem.addConstraint(linearSystem.createRow().createRowDimensionRatio(createObjectVariable4, createObjectVariable3, createObjectVariable2, createObjectVariable, f2));
                    if (z2) {
                        z31 = false;
                    }
                    i14 = i40;
                    z16 = z31;
                }
            } else {
                int max = Math.max(i7, i10);
                if (i8 > 0) {
                    max = Math.min(i8, max);
                }
                linearSystem.addEquality(createObjectVariable4, createObjectVariable3, max, 8);
                i14 = i7;
                i12 = i8;
                i13 = i33;
                solverVariable6 = createObjectVariable5;
                solverVariable4 = createObjectVariable4;
                solverVariable5 = solverVariable3;
                z16 = false;
            }
            z17 = z4;
            if (!z11) {
            }
            if (i15 < i16) {
                return;
            } else {
                return;
            }
        }
        if (z5) {
            linearSystem.addEquality(createObjectVariable4, createObjectVariable3, 0, 3);
            if (i3 > 0) {
                linearSystem.addGreaterThan(createObjectVariable4, createObjectVariable3, i3, 8);
            }
            if (i4 < Integer.MAX_VALUE) {
                linearSystem.addLowerThan(createObjectVariable4, createObjectVariable3, i4, 8);
            }
        } else {
            linearSystem.addEquality(createObjectVariable4, createObjectVariable3, i10, i11);
        }
        i14 = i7;
        i12 = i8;
        i13 = i33;
        solverVariable4 = createObjectVariable4;
        z16 = z14;
        solverVariable5 = solverVariable3;
        z17 = z4;
        solverVariable6 = createObjectVariable5;
        if (!z11) {
        }
        if (i15 < i16) {
        }
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i) {
        if (constraintAnchor.getOwner() == this) {
            connect(constraintAnchor.getType(), constraintAnchor2.getOwner(), constraintAnchor2.getType(), i);
        }
    }

    public void connectCircularConstraint(ConstraintWidget constraintWidget, float f, int i) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.CENTER;
        immediateConnect(type, constraintWidget, type, i, 0);
        this.mCircleConstraintAngle = f;
    }

    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        this.mHorizontalResolution = constraintWidget.mHorizontalResolution;
        this.mVerticalResolution = constraintWidget.mVerticalResolution;
        this.mMatchConstraintDefaultWidth = constraintWidget.mMatchConstraintDefaultWidth;
        this.mMatchConstraintDefaultHeight = constraintWidget.mMatchConstraintDefaultHeight;
        int[] iArr = this.mResolvedMatchConstraintDefault;
        int[] iArr2 = constraintWidget.mResolvedMatchConstraintDefault;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        this.mMatchConstraintMinWidth = constraintWidget.mMatchConstraintMinWidth;
        this.mMatchConstraintMaxWidth = constraintWidget.mMatchConstraintMaxWidth;
        this.mMatchConstraintMinHeight = constraintWidget.mMatchConstraintMinHeight;
        this.mMatchConstraintMaxHeight = constraintWidget.mMatchConstraintMaxHeight;
        this.mMatchConstraintPercentHeight = constraintWidget.mMatchConstraintPercentHeight;
        this.mIsWidthWrapContent = constraintWidget.mIsWidthWrapContent;
        this.mIsHeightWrapContent = constraintWidget.mIsHeightWrapContent;
        this.f2483j = constraintWidget.f2483j;
        this.f2484k = constraintWidget.f2484k;
        int[] iArr3 = constraintWidget.f2485l;
        this.f2485l = Arrays.copyOf(iArr3, iArr3.length);
        this.mCircleConstraintAngle = constraintWidget.mCircleConstraintAngle;
        this.f2486m = constraintWidget.f2486m;
        this.f2489n = constraintWidget.f2489n;
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.f2493r.reset();
        this.f2494s.reset();
        this.mCenter.reset();
        this.mListDimensionBehaviors = (DimensionBehaviour[]) Arrays.copyOf(this.mListDimensionBehaviors, 2);
        ConstraintWidget constraintWidget4 = null;
        if (this.mParent == null) {
            constraintWidget2 = null;
        } else {
            constraintWidget2 = hashMap.get(constraintWidget.mParent);
        }
        this.mParent = constraintWidget2;
        this.f2496u = constraintWidget.f2496u;
        this.f2497v = constraintWidget.f2497v;
        this.mDimensionRatio = constraintWidget.mDimensionRatio;
        this.mDimensionRatioSide = constraintWidget.mDimensionRatioSide;
        this.f2487mX = constraintWidget.f2487mX;
        this.f2488mY = constraintWidget.f2488mY;
        this.mOffsetX = constraintWidget.mOffsetX;
        this.mOffsetY = constraintWidget.mOffsetY;
        this.f2498w = constraintWidget.f2498w;
        this.mMinWidth = constraintWidget.mMinWidth;
        this.mMinHeight = constraintWidget.mMinHeight;
        this.f2499x = constraintWidget.f2499x;
        this.f2500y = constraintWidget.f2500y;
        this.f2501z = constraintWidget.f2501z;
        this.f2465A = constraintWidget.f2465A;
        this.f2466B = constraintWidget.f2466B;
        this.f2467C = constraintWidget.f2467C;
        this.f2468D = constraintWidget.f2468D;
        this.f2469E = constraintWidget.f2469E;
        this.f2470F = constraintWidget.f2470F;
        this.f2471G = constraintWidget.f2471G;
        float[] fArr = this.mWeight;
        float[] fArr2 = constraintWidget.mWeight;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        ConstraintWidget[] constraintWidgetArr = this.mListNextMatchConstraintsWidget;
        ConstraintWidget[] constraintWidgetArr2 = constraintWidget.mListNextMatchConstraintsWidget;
        constraintWidgetArr[0] = constraintWidgetArr2[0];
        constraintWidgetArr[1] = constraintWidgetArr2[1];
        ConstraintWidget[] constraintWidgetArr3 = this.mNextChainWidget;
        ConstraintWidget[] constraintWidgetArr4 = constraintWidget.mNextChainWidget;
        constraintWidgetArr3[0] = constraintWidgetArr4[0];
        constraintWidgetArr3[1] = constraintWidgetArr4[1];
        ConstraintWidget constraintWidget5 = constraintWidget.f2472H;
        if (constraintWidget5 == null) {
            constraintWidget3 = null;
        } else {
            constraintWidget3 = hashMap.get(constraintWidget5);
        }
        this.f2472H = constraintWidget3;
        ConstraintWidget constraintWidget6 = constraintWidget.f2473I;
        if (constraintWidget6 != null) {
            constraintWidget4 = hashMap.get(constraintWidget6);
        }
        this.f2473I = constraintWidget4;
    }

    public void createObjectVariables(LinearSystem linearSystem) {
        linearSystem.createObjectVariable(this.mLeft);
        linearSystem.createObjectVariable(this.mTop);
        linearSystem.createObjectVariable(this.mRight);
        linearSystem.createObjectVariable(this.mBottom);
        if (this.f2498w > 0) {
            linearSystem.createObjectVariable(this.mBaseline);
        }
    }

    /* renamed from: e */
    public final boolean m497e(int i) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        int i2 = i * 2;
        ConstraintAnchor[] constraintAnchorArr = this.mListAnchors;
        ConstraintAnchor constraintAnchor3 = constraintAnchorArr[i2];
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        if (constraintAnchor4 != null && constraintAnchor4.mTarget != constraintAnchor3 && (constraintAnchor2 = (constraintAnchor = constraintAnchorArr[i2 + 1]).mTarget) != null && constraintAnchor2.mTarget == constraintAnchor) {
            return true;
        }
        return false;
    }

    public void ensureMeasureRequested() {
        this.f2474a = true;
    }

    public void ensureWidgetRuns() {
        if (this.mHorizontalRun == null) {
            this.mHorizontalRun = new HorizontalWidgetRun(this);
        }
        if (this.mVerticalRun == null) {
            this.mVerticalRun = new VerticalWidgetRun(this);
        }
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        switch (AbstractC0122a.f2560a[type.ordinal()]) {
            case 1:
                return this.mLeft;
            case 2:
                return this.mTop;
            case 3:
                return this.mRight;
            case 4:
                return this.mBottom;
            case 5:
                return this.mBaseline;
            case 6:
                return this.mCenter;
            case 7:
                return this.f2493r;
            case 8:
                return this.f2494s;
            case 9:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.mAnchors;
    }

    public int getBaselineDistance() {
        return this.f2498w;
    }

    public float getBiasPercent(int i) {
        if (i == 0) {
            return this.f2499x;
        }
        if (i == 1) {
            return this.f2500y;
        }
        return -1.0f;
    }

    public int getBottom() {
        return getY() + this.f2497v;
    }

    public Object getCompanionWidget() {
        return this.f2501z;
    }

    public int getContainerItemSkip() {
        return this.f2465A;
    }

    public String getDebugName() {
        return this.f2468D;
    }

    public DimensionBehaviour getDimensionBehaviour(int i) {
        if (i == 0) {
            return getHorizontalDimensionBehaviour();
        }
        if (i == 1) {
            return getVerticalDimensionBehaviour();
        }
        return null;
    }

    public float getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public int getDimensionRatioSide() {
        return this.mDimensionRatioSide;
    }

    public boolean getHasBaseline() {
        return this.f2486m;
    }

    public int getHeight() {
        if (this.f2466B == 8) {
            return 0;
        }
        return this.f2497v;
    }

    public float getHorizontalBiasPercent() {
        return this.f2499x;
    }

    public ConstraintWidget getHorizontalChainControlWidget() {
        ConstraintAnchor target;
        ConstraintWidget owner;
        ConstraintAnchor target2;
        if (!isInHorizontalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget = this;
        ConstraintWidget constraintWidget2 = null;
        while (constraintWidget2 == null && constraintWidget != null) {
            ConstraintAnchor anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT);
            if (anchor == null) {
                target = null;
            } else {
                target = anchor.getTarget();
            }
            if (target == null) {
                owner = null;
            } else {
                owner = target.getOwner();
            }
            if (owner == getParent()) {
                return constraintWidget;
            }
            if (owner == null) {
                target2 = null;
            } else {
                target2 = owner.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
            }
            if (target2 != null && target2.getOwner() != constraintWidget) {
                constraintWidget2 = constraintWidget;
            } else {
                constraintWidget = owner;
            }
        }
        return constraintWidget2;
    }

    public int getHorizontalChainStyle() {
        return this.f2470F;
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public int getHorizontalMargin() {
        int i;
        ConstraintAnchor constraintAnchor = this.mLeft;
        if (constraintAnchor != null) {
            i = constraintAnchor.mMargin;
        } else {
            i = 0;
        }
        ConstraintAnchor constraintAnchor2 = this.mRight;
        if (constraintAnchor2 != null) {
            return i + constraintAnchor2.mMargin;
        }
        return i;
    }

    public int getLastHorizontalMeasureSpec() {
        return this.f2491p;
    }

    public int getLastVerticalMeasureSpec() {
        return this.f2492q;
    }

    public int getLeft() {
        return getX();
    }

    public int getLength(int i) {
        if (i == 0) {
            return getWidth();
        }
        if (i == 1) {
            return getHeight();
        }
        return 0;
    }

    public int getMaxHeight() {
        return this.f2485l[1];
    }

    public int getMaxWidth() {
        return this.f2485l[0];
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public ConstraintWidget getNextChainMember(int i) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i == 0) {
            ConstraintAnchor constraintAnchor3 = this.mRight;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
            if (constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3) {
                return constraintAnchor4.mOwner;
            }
            return null;
        }
        if (i == 1 && (constraintAnchor2 = (constraintAnchor = this.mBottom).mTarget) != null && constraintAnchor2.mTarget == constraintAnchor) {
            return constraintAnchor2.mOwner;
        }
        return null;
    }

    public int getOptimizerWrapHeight() {
        int i;
        int i2 = this.f2497v;
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            if (this.mMatchConstraintDefaultHeight == 1) {
                i = Math.max(this.mMatchConstraintMinHeight, i2);
            } else {
                i = this.mMatchConstraintMinHeight;
                if (i > 0) {
                    this.f2497v = i;
                } else {
                    i = 0;
                }
            }
            int i3 = this.mMatchConstraintMaxHeight;
            if (i3 > 0 && i3 < i) {
                return i3;
            }
            return i;
        }
        return i2;
    }

    public int getOptimizerWrapWidth() {
        int i;
        int i2 = this.f2496u;
        if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
            if (this.mMatchConstraintDefaultWidth == 1) {
                i = Math.max(this.mMatchConstraintMinWidth, i2);
            } else {
                i = this.mMatchConstraintMinWidth;
                if (i > 0) {
                    this.f2496u = i;
                } else {
                    i = 0;
                }
            }
            int i3 = this.mMatchConstraintMaxWidth;
            if (i3 > 0 && i3 < i) {
                return i3;
            }
            return i;
        }
        return i2;
    }

    public ConstraintWidget getParent() {
        return this.mParent;
    }

    public ConstraintWidget getPreviousChainMember(int i) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i == 0) {
            ConstraintAnchor constraintAnchor3 = this.mLeft;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
            if (constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3) {
                return constraintAnchor4.mOwner;
            }
            return null;
        }
        if (i == 1 && (constraintAnchor2 = (constraintAnchor = this.mTop).mTarget) != null && constraintAnchor2.mTarget == constraintAnchor) {
            return constraintAnchor2.mOwner;
        }
        return null;
    }

    public int getRight() {
        return getX() + this.f2496u;
    }

    public int getRootX() {
        return this.f2487mX + this.mOffsetX;
    }

    public int getRootY() {
        return this.f2488mY + this.mOffsetY;
    }

    public WidgetRun getRun(int i) {
        if (i == 0) {
            return this.mHorizontalRun;
        }
        if (i == 1) {
            return this.mVerticalRun;
        }
        return null;
    }

    public void getSceneString(StringBuilder sb) {
        sb.append("  " + this.stringId + ":{\n");
        StringBuilder sb2 = new StringBuilder("    actualWidth:");
        sb2.append(this.f2496u);
        sb.append(sb2.toString());
        sb.append("\n");
        sb.append("    actualHeight:" + this.f2497v);
        sb.append("\n");
        sb.append("    actualLeft:" + this.f2487mX);
        sb.append("\n");
        sb.append("    actualTop:" + this.f2488mY);
        sb.append("\n");
        m489d(sb, "left", this.mLeft);
        m489d(sb, "top", this.mTop);
        m489d(sb, "right", this.mRight);
        m489d(sb, "bottom", this.mBottom);
        m489d(sb, "baseline", this.mBaseline);
        m489d(sb, "centerX", this.f2493r);
        m489d(sb, "centerY", this.f2494s);
        int i = this.f2496u;
        int i2 = this.mMinWidth;
        int i3 = this.f2485l[0];
        int i4 = this.mMatchConstraintMinWidth;
        int i5 = this.mMatchConstraintDefaultWidth;
        float f = this.mMatchConstraintPercentWidth;
        DimensionBehaviour dimensionBehaviour = this.mListDimensionBehaviors[0];
        float f2 = this.mWeight[0];
        m488c(sb, "    width", i, i2, i3, i4, i5, f, dimensionBehaviour);
        int i6 = this.f2497v;
        int i7 = this.mMinHeight;
        int i8 = this.f2485l[1];
        int i9 = this.mMatchConstraintMinHeight;
        int i10 = this.mMatchConstraintDefaultHeight;
        float f3 = this.mMatchConstraintPercentHeight;
        DimensionBehaviour dimensionBehaviour2 = this.mListDimensionBehaviors[1];
        float f4 = this.mWeight[1];
        m488c(sb, "    height", i6, i7, i8, i9, i10, f3, dimensionBehaviour2);
        m493i(sb, "    dimensionRatio", this.mDimensionRatio, this.mDimensionRatioSide);
        m492h(sb, "    horizontalBias", this.f2499x, DEFAULT_BIAS);
        m492h(sb, "    verticalBias", this.f2500y, DEFAULT_BIAS);
        m491g(this.f2470F, 0, "    horizontalChainStyle", sb);
        m491g(this.f2471G, 0, "    verticalChainStyle", sb);
        sb.append("  }");
    }

    public int getTop() {
        return getY();
    }

    public String getType() {
        return this.f2469E;
    }

    public float getVerticalBiasPercent() {
        return this.f2500y;
    }

    public ConstraintWidget getVerticalChainControlWidget() {
        ConstraintAnchor target;
        ConstraintWidget owner;
        ConstraintAnchor target2;
        if (!isInVerticalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget = this;
        ConstraintWidget constraintWidget2 = null;
        while (constraintWidget2 == null && constraintWidget != null) {
            ConstraintAnchor anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.TOP);
            if (anchor == null) {
                target = null;
            } else {
                target = anchor.getTarget();
            }
            if (target == null) {
                owner = null;
            } else {
                owner = target.getOwner();
            }
            if (owner == getParent()) {
                return constraintWidget;
            }
            if (owner == null) {
                target2 = null;
            } else {
                target2 = owner.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
            }
            if (target2 != null && target2.getOwner() != constraintWidget) {
                constraintWidget2 = constraintWidget;
            } else {
                constraintWidget = owner;
            }
        }
        return constraintWidget2;
    }

    public int getVerticalChainStyle() {
        return this.f2471G;
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public int getVerticalMargin() {
        int i;
        if (this.mLeft != null) {
            i = this.mTop.mMargin;
        } else {
            i = 0;
        }
        if (this.mRight != null) {
            return i + this.mBottom.mMargin;
        }
        return i;
    }

    public int getVisibility() {
        return this.f2466B;
    }

    public int getWidth() {
        if (this.f2466B == 8) {
            return 0;
        }
        return this.f2496u;
    }

    public int getWrapBehaviorInParent() {
        return this.f2482i;
    }

    public int getX() {
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget != null && (constraintWidget instanceof ConstraintWidgetContainer)) {
            return ((ConstraintWidgetContainer) constraintWidget).f2506M + this.f2487mX;
        }
        return this.f2487mX;
    }

    public int getY() {
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget != null && (constraintWidget instanceof ConstraintWidgetContainer)) {
            return ((ConstraintWidgetContainer) constraintWidget).f2507N + this.f2488mY;
        }
        return this.f2488mY;
    }

    public boolean hasBaseline() {
        return this.f2486m;
    }

    public boolean hasDanglingDimension(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (i == 0) {
            if (this.mLeft.mTarget != null) {
                i5 = 1;
            } else {
                i5 = 0;
            }
            if (this.mRight.mTarget != null) {
                i6 = 1;
            } else {
                i6 = 0;
            }
            if (i5 + i6 >= 2) {
                return false;
            }
            return true;
        }
        if (this.mTop.mTarget != null) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (this.mBottom.mTarget != null) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        int i7 = i2 + i3;
        if (this.mBaseline.mTarget != null) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        if (i7 + i4 >= 2) {
            return false;
        }
        return true;
    }

    public boolean hasDependencies() {
        int size = this.mAnchors.size();
        for (int i = 0; i < size; i++) {
            if (this.mAnchors.get(i).hasDependents()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasDimensionOverride() {
        if (this.f2476c == -1 && this.f2477d == -1) {
            return false;
        }
        return true;
    }

    public boolean hasResolvedTargets(int i, int i2) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i == 0) {
            ConstraintAnchor constraintAnchor3 = this.mLeft.mTarget;
            if (constraintAnchor3 != null && constraintAnchor3.hasFinalValue() && (constraintAnchor2 = this.mRight.mTarget) != null && constraintAnchor2.hasFinalValue()) {
                if ((this.mRight.mTarget.getFinalValue() - this.mRight.getMargin()) - (this.mLeft.getMargin() + this.mLeft.mTarget.getFinalValue()) >= i2) {
                    return true;
                }
                return false;
            }
        } else {
            ConstraintAnchor constraintAnchor4 = this.mTop.mTarget;
            if (constraintAnchor4 != null && constraintAnchor4.hasFinalValue() && (constraintAnchor = this.mBottom.mTarget) != null && constraintAnchor.hasFinalValue()) {
                if ((this.mBottom.mTarget.getFinalValue() - this.mBottom.getMargin()) - (this.mTop.getMargin() + this.mTop.mTarget.getFinalValue()) >= i2) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public void immediateConnect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, int i2) {
        getAnchor(type).connect(constraintWidget.getAnchor(type2), i, i2, true);
    }

    public boolean isAnimated() {
        return this.f2467C;
    }

    public boolean isHeightWrapContent() {
        return this.mIsHeightWrapContent;
    }

    public boolean isHorizontalSolvingPassDone() {
        return this.f2480g;
    }

    public boolean isInBarrier(int i) {
        return this.f2495t[i];
    }

    public boolean isInHorizontalChain() {
        ConstraintAnchor constraintAnchor = this.mLeft;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null || constraintAnchor2.mTarget != constraintAnchor) {
            ConstraintAnchor constraintAnchor3 = this.mRight;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
            if (constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3) {
                return true;
            }
            return false;
        }
        return true;
    }

    public boolean isInPlaceholder() {
        return this.f2489n;
    }

    public boolean isInVerticalChain() {
        ConstraintAnchor constraintAnchor = this.mTop;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null || constraintAnchor2.mTarget != constraintAnchor) {
            ConstraintAnchor constraintAnchor3 = this.mBottom;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
            if (constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3) {
                return true;
            }
            return false;
        }
        return true;
    }

    public boolean isInVirtualLayout() {
        return this.f2490o;
    }

    public boolean isMeasureRequested() {
        if (this.f2474a && this.f2466B != 8) {
            return true;
        }
        return false;
    }

    public boolean isResolvedHorizontally() {
        if (!this.f2478e && (!this.mLeft.hasFinalValue() || !this.mRight.hasFinalValue())) {
            return false;
        }
        return true;
    }

    public boolean isResolvedVertically() {
        if (!this.f2479f && (!this.mTop.hasFinalValue() || !this.mBottom.hasFinalValue())) {
            return false;
        }
        return true;
    }

    public boolean isRoot() {
        if (this.mParent == null) {
            return true;
        }
        return false;
    }

    public boolean isSpreadHeight() {
        if (this.mMatchConstraintDefaultHeight == 0 && this.mDimensionRatio == RecyclerView.f7068F0 && this.mMatchConstraintMinHeight == 0 && this.mMatchConstraintMaxHeight == 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            return true;
        }
        return false;
    }

    public boolean isSpreadWidth() {
        if (this.mMatchConstraintDefaultWidth != 0 || this.mDimensionRatio != RecyclerView.f7068F0 || this.mMatchConstraintMinWidth != 0 || this.mMatchConstraintMaxWidth != 0 || this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return false;
        }
        return true;
    }

    public boolean isVerticalSolvingPassDone() {
        return this.f2481h;
    }

    public boolean isWidthWrapContent() {
        return this.mIsWidthWrapContent;
    }

    public void markHorizontalSolvingPassDone() {
        this.f2480g = true;
    }

    public void markVerticalSolvingPassDone() {
        this.f2481h = true;
    }

    public boolean oppositeDimensionDependsOn(int i) {
        char c;
        if (i == 0) {
            c = 1;
        } else {
            c = 0;
        }
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[i];
        DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[c];
        DimensionBehaviour dimensionBehaviour3 = DimensionBehaviour.MATCH_CONSTRAINT;
        if (dimensionBehaviour != dimensionBehaviour3 || dimensionBehaviour2 != dimensionBehaviour3) {
            return false;
        }
        return true;
    }

    public boolean oppositeDimensionsTied() {
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.MATCH_CONSTRAINT;
        if (dimensionBehaviour != dimensionBehaviour2 || dimensionBehaviourArr[1] != dimensionBehaviour2) {
            return false;
        }
        return true;
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.f2493r.reset();
        this.f2494s.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = Float.NaN;
        this.f2496u = 0;
        this.f2497v = 0;
        this.mDimensionRatio = RecyclerView.f7068F0;
        this.mDimensionRatioSide = -1;
        this.f2487mX = 0;
        this.f2488mY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.f2498w = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        float f = DEFAULT_BIAS;
        this.f2499x = f;
        this.f2500y = f;
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        this.f2501z = null;
        this.f2465A = 0;
        this.f2466B = 0;
        this.f2469E = null;
        this.f2470F = 0;
        this.f2471G = 0;
        float[] fArr = this.mWeight;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        int[] iArr = this.f2485l;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
        this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.f2483j = -1;
        this.f2484k = 1.0f;
        boolean[] zArr = this.isTerminalWidget;
        zArr[0] = true;
        zArr[1] = true;
        this.f2490o = false;
        boolean[] zArr2 = this.f2495t;
        zArr2[0] = false;
        zArr2[1] = false;
        this.f2474a = true;
        int[] iArr2 = this.mResolvedMatchConstraintDefault;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.f2476c = -1;
        this.f2477d = -1;
    }

    public void resetAllConstraints() {
        resetAnchors();
        setVerticalBiasPercent(DEFAULT_BIAS);
        setHorizontalBiasPercent(DEFAULT_BIAS);
    }

    public void resetAnchor(ConstraintAnchor constraintAnchor) {
        if (getParent() != null && (getParent() instanceof ConstraintWidgetContainer) && ((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            return;
        }
        ConstraintAnchor anchor = getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor anchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
        ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor anchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
        ConstraintAnchor anchor5 = getAnchor(ConstraintAnchor.Type.CENTER);
        ConstraintAnchor anchor6 = getAnchor(ConstraintAnchor.Type.CENTER_X);
        ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
        if (constraintAnchor == anchor5) {
            if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                anchor.reset();
                anchor2.reset();
            }
            if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                anchor3.reset();
                anchor4.reset();
            }
            this.f2499x = 0.5f;
            this.f2500y = 0.5f;
        } else if (constraintAnchor == anchor6) {
            if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget().getOwner() == anchor2.getTarget().getOwner()) {
                anchor.reset();
                anchor2.reset();
            }
            this.f2499x = 0.5f;
        } else if (constraintAnchor == anchor7) {
            if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget().getOwner() == anchor4.getTarget().getOwner()) {
                anchor3.reset();
                anchor4.reset();
            }
            this.f2500y = 0.5f;
        } else if (constraintAnchor != anchor && constraintAnchor != anchor2) {
            if ((constraintAnchor == anchor3 || constraintAnchor == anchor4) && anchor3.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                anchor5.reset();
            }
        } else if (anchor.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
            anchor5.reset();
        }
        constraintAnchor.reset();
    }

    public void resetAnchors() {
        ConstraintWidget parent = getParent();
        if (parent != null && (parent instanceof ConstraintWidgetContainer) && ((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            return;
        }
        int size = this.mAnchors.size();
        for (int i = 0; i < size; i++) {
            this.mAnchors.get(i).reset();
        }
    }

    public void resetFinalResolution() {
        this.f2478e = false;
        this.f2479f = false;
        this.f2480g = false;
        this.f2481h = false;
        int size = this.mAnchors.size();
        for (int i = 0; i < size; i++) {
            this.mAnchors.get(i).resetFinalResolution();
        }
    }

    public void resetSolverVariables(Cache cache) {
        this.mLeft.resetSolverVariable(cache);
        this.mTop.resetSolverVariable(cache);
        this.mRight.resetSolverVariable(cache);
        this.mBottom.resetSolverVariable(cache);
        this.mBaseline.resetSolverVariable(cache);
        this.mCenter.resetSolverVariable(cache);
        this.f2493r.resetSolverVariable(cache);
        this.f2494s.resetSolverVariable(cache);
    }

    public void resetSolvingPassFlag() {
        this.f2480g = false;
        this.f2481h = false;
    }

    public StringBuilder serialize(StringBuilder sb) {
        sb.append("{\n");
        m490f(sb, "left", this.mLeft);
        m490f(sb, "top", this.mTop);
        m490f(sb, "right", this.mRight);
        m490f(sb, "bottom", this.mBottom);
        m490f(sb, "baseline", this.mBaseline);
        m490f(sb, "centerX", this.f2493r);
        m490f(sb, "centerY", this.f2494s);
        ConstraintAnchor constraintAnchor = this.mCenter;
        float f = this.mCircleConstraintAngle;
        if (constraintAnchor.mTarget != null && !Float.isNaN(f)) {
            sb.append("circle : [ '");
            sb.append(constraintAnchor.mTarget);
            sb.append("',");
            sb.append(constraintAnchor.mMargin);
            sb.append(",");
            sb.append(f);
            sb.append(",");
            sb.append(" ] ,\n");
        }
        m494j(sb, "width", this.f2496u, this.mMinWidth, this.f2485l[0], this.f2476c, this.mMatchConstraintMinWidth, this.mMatchConstraintDefaultWidth, this.mMatchConstraintPercentWidth, this.mWeight[0]);
        m494j(sb, "height", this.f2497v, this.mMinHeight, this.f2485l[1], this.f2477d, this.mMatchConstraintMinHeight, this.mMatchConstraintDefaultHeight, this.mMatchConstraintPercentHeight, this.mWeight[1]);
        m493i(sb, "dimensionRatio", this.mDimensionRatio, this.mDimensionRatioSide);
        m492h(sb, "horizontalBias", this.f2499x, DEFAULT_BIAS);
        m492h(sb, "verticalBias", this.f2500y, DEFAULT_BIAS);
        sb.append("}\n");
        return sb;
    }

    public void setAnimated(boolean z) {
        this.f2467C = z;
    }

    public void setBaselineDistance(int i) {
        boolean z;
        this.f2498w = i;
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        this.f2486m = z;
    }

    public void setCompanionWidget(Object obj) {
        this.f2501z = obj;
    }

    public void setContainerItemSkip(int i) {
        if (i >= 0) {
            this.f2465A = i;
        } else {
            this.f2465A = 0;
        }
    }

    public void setDebugName(String str) {
        this.f2468D = str;
    }

    public void setDebugSolverName(LinearSystem linearSystem, String str) {
        this.f2468D = str;
        SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.mLeft);
        SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(this.mTop);
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(this.mRight);
        SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(this.mBottom);
        createObjectVariable.setName(str + ".left");
        createObjectVariable2.setName(str + ".top");
        createObjectVariable3.setName(str + ".right");
        createObjectVariable4.setName(str + ".bottom");
        linearSystem.createObjectVariable(this.mBaseline).setName(str + ".baseline");
    }

    public void setDimension(int i, int i2) {
        this.f2496u = i;
        int i3 = this.mMinWidth;
        if (i < i3) {
            this.f2496u = i3;
        }
        this.f2497v = i2;
        int i4 = this.mMinHeight;
        if (i2 < i4) {
            this.f2497v = i4;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0086 -> B:31:0x0087). Please report as a decompilation issue!!! */
    public void setDimensionRatio(String str) {
        float f;
        int i = 0;
        if (str != null && str.length() != 0) {
            int length = str.length();
            int indexOf = str.indexOf(44);
            int i2 = 0;
            int i3 = -1;
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                if (!substring.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST)) {
                    i2 = substring.equalsIgnoreCase("H") ? 1 : -1;
                }
                i3 = i2;
                i2 = indexOf + 1;
            }
            int indexOf2 = str.indexOf(58);
            if (indexOf2 >= 0 && indexOf2 < length - 1) {
                String substring2 = str.substring(i2, indexOf2);
                String substring3 = str.substring(indexOf2 + 1);
                if (substring2.length() > 0 && substring3.length() > 0) {
                    float parseFloat = Float.parseFloat(substring2);
                    float parseFloat2 = Float.parseFloat(substring3);
                    if (parseFloat > RecyclerView.f7068F0 && parseFloat2 > RecyclerView.f7068F0) {
                        if (i3 == 1) {
                            f = Math.abs(parseFloat2 / parseFloat);
                        } else {
                            f = Math.abs(parseFloat / parseFloat2);
                        }
                    }
                }
                f = i;
            } else {
                String substring4 = str.substring(i2);
                if (substring4.length() > 0) {
                    f = Float.parseFloat(substring4);
                }
                f = i;
            }
            i = (f > i ? 1 : (f == i ? 0 : -1));
            if (i > 0) {
                this.mDimensionRatio = f;
                this.mDimensionRatioSide = i3;
                return;
            }
            return;
        }
        this.mDimensionRatio = RecyclerView.f7068F0;
    }

    public void setFinalBaseline(int i) {
        if (!this.f2486m) {
            return;
        }
        int i2 = i - this.f2498w;
        int i3 = this.f2497v + i2;
        this.f2488mY = i2;
        this.mTop.setFinalValue(i2);
        this.mBottom.setFinalValue(i3);
        this.mBaseline.setFinalValue(i);
        this.f2479f = true;
    }

    public void setFinalFrame(int i, int i2, int i3, int i4, int i5, int i6) {
        setFrame(i, i2, i3, i4);
        setBaselineDistance(i5);
        if (i6 == 0) {
            this.f2478e = true;
            this.f2479f = false;
        } else if (i6 == 1) {
            this.f2478e = false;
            this.f2479f = true;
        } else if (i6 == 2) {
            this.f2478e = true;
            this.f2479f = true;
        } else {
            this.f2478e = false;
            this.f2479f = false;
        }
    }

    public void setFinalHorizontal(int i, int i2) {
        if (this.f2478e) {
            return;
        }
        this.mLeft.setFinalValue(i);
        this.mRight.setFinalValue(i2);
        this.f2487mX = i;
        this.f2496u = i2 - i;
        this.f2478e = true;
    }

    public void setFinalLeft(int i) {
        this.mLeft.setFinalValue(i);
        this.f2487mX = i;
    }

    public void setFinalTop(int i) {
        this.mTop.setFinalValue(i);
        this.f2488mY = i;
    }

    public void setFinalVertical(int i, int i2) {
        if (this.f2479f) {
            return;
        }
        this.mTop.setFinalValue(i);
        this.mBottom.setFinalValue(i2);
        this.f2488mY = i;
        this.f2497v = i2 - i;
        if (this.f2486m) {
            this.mBaseline.setFinalValue(i + this.f2498w);
        }
        this.f2479f = true;
    }

    public void setFrame(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = i3 - i;
        int i8 = i4 - i2;
        this.f2487mX = i;
        this.f2488mY = i2;
        if (this.f2466B == 8) {
            this.f2496u = 0;
            this.f2497v = 0;
            return;
        }
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.FIXED;
        if (dimensionBehaviour == dimensionBehaviour2 && i7 < (i6 = this.f2496u)) {
            i7 = i6;
        }
        if (dimensionBehaviourArr[1] == dimensionBehaviour2 && i8 < (i5 = this.f2497v)) {
            i8 = i5;
        }
        this.f2496u = i7;
        this.f2497v = i8;
        int i9 = this.mMinHeight;
        if (i8 < i9) {
            this.f2497v = i9;
        }
        int i10 = this.mMinWidth;
        if (i7 < i10) {
            this.f2496u = i10;
        }
        int i11 = this.mMatchConstraintMaxWidth;
        if (i11 > 0 && dimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.f2496u = Math.min(this.f2496u, i11);
        }
        int i12 = this.mMatchConstraintMaxHeight;
        if (i12 > 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.f2497v = Math.min(this.f2497v, i12);
        }
        int i13 = this.f2496u;
        if (i7 != i13) {
            this.f2476c = i13;
        }
        int i14 = this.f2497v;
        if (i8 != i14) {
            this.f2477d = i14;
        }
    }

    public void setGoneMargin(ConstraintAnchor.Type type, int i) {
        int i2 = AbstractC0122a.f2560a[type.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 == 5) {
                            this.mBaseline.f2462d = i;
                            return;
                        }
                        return;
                    }
                    this.mBottom.f2462d = i;
                    return;
                }
                this.mRight.f2462d = i;
                return;
            }
            this.mTop.f2462d = i;
            return;
        }
        this.mLeft.f2462d = i;
    }

    public void setHasBaseline(boolean z) {
        this.f2486m = z;
    }

    public void setHeight(int i) {
        this.f2497v = i;
        int i2 = this.mMinHeight;
        if (i < i2) {
            this.f2497v = i2;
        }
    }

    public void setHeightWrapContent(boolean z) {
        this.mIsHeightWrapContent = z;
    }

    public void setHorizontalBiasPercent(float f) {
        this.f2499x = f;
    }

    public void setHorizontalChainStyle(int i) {
        this.f2470F = i;
    }

    public void setHorizontalDimension(int i, int i2) {
        this.f2487mX = i;
        int i3 = i2 - i;
        this.f2496u = i3;
        int i4 = this.mMinWidth;
        if (i3 < i4) {
            this.f2496u = i4;
        }
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[0] = dimensionBehaviour;
    }

    public void setHorizontalMatchStyle(int i, int i2, int i3, float f) {
        this.mMatchConstraintDefaultWidth = i;
        this.mMatchConstraintMinWidth = i2;
        if (i3 == Integer.MAX_VALUE) {
            i3 = 0;
        }
        this.mMatchConstraintMaxWidth = i3;
        this.mMatchConstraintPercentWidth = f;
        if (f > RecyclerView.f7068F0 && f < 1.0f && i == 0) {
            this.mMatchConstraintDefaultWidth = 2;
        }
    }

    public void setHorizontalWeight(float f) {
        this.mWeight[0] = f;
    }

    public void setInBarrier(int i, boolean z) {
        this.f2495t[i] = z;
    }

    public void setInPlaceholder(boolean z) {
        this.f2489n = z;
    }

    public void setInVirtualLayout(boolean z) {
        this.f2490o = z;
    }

    public void setLastMeasureSpec(int i, int i2) {
        this.f2491p = i;
        this.f2492q = i2;
        setMeasureRequested(false);
    }

    public void setLength(int i, int i2) {
        if (i2 == 0) {
            setWidth(i);
        } else if (i2 == 1) {
            setHeight(i);
        }
    }

    public void setMaxHeight(int i) {
        this.f2485l[1] = i;
    }

    public void setMaxWidth(int i) {
        this.f2485l[0] = i;
    }

    public void setMeasureRequested(boolean z) {
        this.f2474a = z;
    }

    public void setMinHeight(int i) {
        if (i < 0) {
            this.mMinHeight = 0;
        } else {
            this.mMinHeight = i;
        }
    }

    public void setMinWidth(int i) {
        if (i < 0) {
            this.mMinWidth = 0;
        } else {
            this.mMinWidth = i;
        }
    }

    public void setOffset(int i, int i2) {
        this.mOffsetX = i;
        this.mOffsetY = i2;
    }

    public void setOrigin(int i, int i2) {
        this.f2487mX = i;
        this.f2488mY = i2;
    }

    public void setParent(ConstraintWidget constraintWidget) {
        this.mParent = constraintWidget;
    }

    public void setType(String str) {
        this.f2469E = str;
    }

    public void setVerticalBiasPercent(float f) {
        this.f2500y = f;
    }

    public void setVerticalChainStyle(int i) {
        this.f2471G = i;
    }

    public void setVerticalDimension(int i, int i2) {
        this.f2488mY = i;
        int i3 = i2 - i;
        this.f2497v = i3;
        int i4 = this.mMinHeight;
        if (i3 < i4) {
            this.f2497v = i4;
        }
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[1] = dimensionBehaviour;
    }

    public void setVerticalMatchStyle(int i, int i2, int i3, float f) {
        this.mMatchConstraintDefaultHeight = i;
        this.mMatchConstraintMinHeight = i2;
        if (i3 == Integer.MAX_VALUE) {
            i3 = 0;
        }
        this.mMatchConstraintMaxHeight = i3;
        this.mMatchConstraintPercentHeight = f;
        if (f > RecyclerView.f7068F0 && f < 1.0f && i == 0) {
            this.mMatchConstraintDefaultHeight = 2;
        }
    }

    public void setVerticalWeight(float f) {
        this.mWeight[1] = f;
    }

    public void setVisibility(int i) {
        this.f2466B = i;
    }

    public void setWidth(int i) {
        this.f2496u = i;
        int i2 = this.mMinWidth;
        if (i < i2) {
            this.f2496u = i2;
        }
    }

    public void setWidthWrapContent(boolean z) {
        this.mIsWidthWrapContent = z;
    }

    public void setWrapBehaviorInParent(int i) {
        if (i >= 0 && i <= 3) {
            this.f2482i = i;
        }
    }

    public void setX(int i) {
        this.f2487mX = i;
    }

    public void setY(int i) {
        this.f2488mY = i;
    }

    public void setupDimensionRatio(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.f2483j == -1) {
            if (z3 && !z4) {
                this.f2483j = 0;
            } else if (!z3 && z4) {
                this.f2483j = 1;
                if (this.mDimensionRatioSide == -1) {
                    this.f2484k = 1.0f / this.f2484k;
                }
            }
        }
        if (this.f2483j == 0 && (!this.mTop.isConnected() || !this.mBottom.isConnected())) {
            this.f2483j = 1;
        } else if (this.f2483j == 1 && (!this.mLeft.isConnected() || !this.mRight.isConnected())) {
            this.f2483j = 0;
        }
        if (this.f2483j == -1 && (!this.mTop.isConnected() || !this.mBottom.isConnected() || !this.mLeft.isConnected() || !this.mRight.isConnected())) {
            if (this.mTop.isConnected() && this.mBottom.isConnected()) {
                this.f2483j = 0;
            } else if (this.mLeft.isConnected() && this.mRight.isConnected()) {
                this.f2484k = 1.0f / this.f2484k;
                this.f2483j = 1;
            }
        }
        if (this.f2483j == -1) {
            int i = this.mMatchConstraintMinWidth;
            if (i > 0 && this.mMatchConstraintMinHeight == 0) {
                this.f2483j = 0;
            } else if (i == 0 && this.mMatchConstraintMinHeight > 0) {
                this.f2484k = 1.0f / this.f2484k;
                this.f2483j = 1;
            }
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.f2469E == null) {
            str = "";
        } else {
            str = AbstractC1726qj.m7061q(new StringBuilder("type: "), this.f2469E, " ");
        }
        sb.append(str);
        if (this.f2468D != null) {
            str2 = AbstractC1726qj.m7061q(new StringBuilder("id: "), this.f2468D, " ");
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.f2487mX);
        sb.append(", ");
        sb.append(this.f2488mY);
        sb.append(") - (");
        sb.append(this.f2496u);
        sb.append(" x ");
        return ye0.m8298r(sb, ")", this.f2497v);
    }

    public void updateFromRuns(boolean z, boolean z2) {
        int i;
        int i2;
        boolean isResolved = z & this.mHorizontalRun.isResolved();
        boolean isResolved2 = z2 & this.mVerticalRun.isResolved();
        HorizontalWidgetRun horizontalWidgetRun = this.mHorizontalRun;
        int i3 = horizontalWidgetRun.start.value;
        VerticalWidgetRun verticalWidgetRun = this.mVerticalRun;
        int i4 = verticalWidgetRun.start.value;
        int i5 = horizontalWidgetRun.end.value;
        int i6 = verticalWidgetRun.end.value;
        int i7 = i6 - i4;
        if (i5 - i3 < 0 || i7 < 0 || i3 == Integer.MIN_VALUE || i3 == Integer.MAX_VALUE || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE) {
            i5 = 0;
            i3 = 0;
            i6 = 0;
            i4 = 0;
        }
        int i8 = i5 - i3;
        int i9 = i6 - i4;
        if (isResolved) {
            this.f2487mX = i3;
        }
        if (isResolved2) {
            this.f2488mY = i4;
        }
        if (this.f2466B == 8) {
            this.f2496u = 0;
            this.f2497v = 0;
            return;
        }
        if (isResolved) {
            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED && i8 < (i2 = this.f2496u)) {
                i8 = i2;
            }
            this.f2496u = i8;
            int i10 = this.mMinWidth;
            if (i8 < i10) {
                this.f2496u = i10;
            }
        }
        if (isResolved2) {
            if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED && i9 < (i = this.f2497v)) {
                i9 = i;
            }
            this.f2497v = i9;
            int i11 = this.mMinHeight;
            if (i9 < i11) {
                this.f2497v = i11;
            }
        }
    }

    public void updateFromSolver(LinearSystem linearSystem, boolean z) {
        VerticalWidgetRun verticalWidgetRun;
        HorizontalWidgetRun horizontalWidgetRun;
        int objectVariableValue = linearSystem.getObjectVariableValue(this.mLeft);
        int objectVariableValue2 = linearSystem.getObjectVariableValue(this.mTop);
        int objectVariableValue3 = linearSystem.getObjectVariableValue(this.mRight);
        int objectVariableValue4 = linearSystem.getObjectVariableValue(this.mBottom);
        if (z && (horizontalWidgetRun = this.mHorizontalRun) != null) {
            DependencyNode dependencyNode = horizontalWidgetRun.start;
            if (dependencyNode.resolved) {
                DependencyNode dependencyNode2 = horizontalWidgetRun.end;
                if (dependencyNode2.resolved) {
                    objectVariableValue = dependencyNode.value;
                    objectVariableValue3 = dependencyNode2.value;
                }
            }
        }
        if (z && (verticalWidgetRun = this.mVerticalRun) != null) {
            DependencyNode dependencyNode3 = verticalWidgetRun.start;
            if (dependencyNode3.resolved) {
                DependencyNode dependencyNode4 = verticalWidgetRun.end;
                if (dependencyNode4.resolved) {
                    objectVariableValue2 = dependencyNode3.value;
                    objectVariableValue4 = dependencyNode4.value;
                }
            }
        }
        int i = objectVariableValue4 - objectVariableValue2;
        if (objectVariableValue3 - objectVariableValue < 0 || i < 0 || objectVariableValue == Integer.MIN_VALUE || objectVariableValue == Integer.MAX_VALUE || objectVariableValue2 == Integer.MIN_VALUE || objectVariableValue2 == Integer.MAX_VALUE || objectVariableValue3 == Integer.MIN_VALUE || objectVariableValue3 == Integer.MAX_VALUE || objectVariableValue4 == Integer.MIN_VALUE || objectVariableValue4 == Integer.MAX_VALUE) {
            objectVariableValue = 0;
            objectVariableValue4 = 0;
            objectVariableValue2 = 0;
            objectVariableValue3 = 0;
        }
        setFrame(objectVariableValue, objectVariableValue2, objectVariableValue3, objectVariableValue4);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2) {
        connect(type, constraintWidget, type2, 0);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i) {
        ConstraintAnchor.Type type3;
        ConstraintAnchor.Type type4;
        boolean z;
        ConstraintAnchor.Type type5 = ConstraintAnchor.Type.CENTER;
        if (type == type5) {
            if (type2 == type5) {
                ConstraintAnchor.Type type6 = ConstraintAnchor.Type.LEFT;
                ConstraintAnchor anchor = getAnchor(type6);
                ConstraintAnchor.Type type7 = ConstraintAnchor.Type.RIGHT;
                ConstraintAnchor anchor2 = getAnchor(type7);
                ConstraintAnchor.Type type8 = ConstraintAnchor.Type.TOP;
                ConstraintAnchor anchor3 = getAnchor(type8);
                ConstraintAnchor.Type type9 = ConstraintAnchor.Type.BOTTOM;
                ConstraintAnchor anchor4 = getAnchor(type9);
                boolean z2 = true;
                if ((anchor == null || !anchor.isConnected()) && (anchor2 == null || !anchor2.isConnected())) {
                    connect(type6, constraintWidget, type6, 0);
                    connect(type7, constraintWidget, type7, 0);
                    z = true;
                } else {
                    z = false;
                }
                if ((anchor3 == null || !anchor3.isConnected()) && (anchor4 == null || !anchor4.isConnected())) {
                    connect(type8, constraintWidget, type8, 0);
                    connect(type9, constraintWidget, type9, 0);
                } else {
                    z2 = false;
                }
                if (z && z2) {
                    getAnchor(type5).connect(constraintWidget.getAnchor(type5), 0);
                    return;
                }
                if (z) {
                    ConstraintAnchor.Type type10 = ConstraintAnchor.Type.CENTER_X;
                    getAnchor(type10).connect(constraintWidget.getAnchor(type10), 0);
                    return;
                } else {
                    if (z2) {
                        ConstraintAnchor.Type type11 = ConstraintAnchor.Type.CENTER_Y;
                        getAnchor(type11).connect(constraintWidget.getAnchor(type11), 0);
                        return;
                    }
                    return;
                }
            }
            ConstraintAnchor.Type type12 = ConstraintAnchor.Type.LEFT;
            if (type2 != type12 && type2 != ConstraintAnchor.Type.RIGHT) {
                ConstraintAnchor.Type type13 = ConstraintAnchor.Type.TOP;
                if (type2 == type13 || type2 == ConstraintAnchor.Type.BOTTOM) {
                    connect(type13, constraintWidget, type2, 0);
                    connect(ConstraintAnchor.Type.BOTTOM, constraintWidget, type2, 0);
                    getAnchor(type5).connect(constraintWidget.getAnchor(type2), 0);
                    return;
                }
                return;
            }
            connect(type12, constraintWidget, type2, 0);
            connect(ConstraintAnchor.Type.RIGHT, constraintWidget, type2, 0);
            getAnchor(type5).connect(constraintWidget.getAnchor(type2), 0);
            return;
        }
        ConstraintAnchor.Type type14 = ConstraintAnchor.Type.CENTER_X;
        if (type == type14 && (type2 == (type4 = ConstraintAnchor.Type.LEFT) || type2 == ConstraintAnchor.Type.RIGHT)) {
            ConstraintAnchor anchor5 = getAnchor(type4);
            ConstraintAnchor anchor6 = constraintWidget.getAnchor(type2);
            ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.RIGHT);
            anchor5.connect(anchor6, 0);
            anchor7.connect(anchor6, 0);
            getAnchor(type14).connect(anchor6, 0);
            return;
        }
        ConstraintAnchor.Type type15 = ConstraintAnchor.Type.CENTER_Y;
        if (type == type15 && (type2 == (type3 = ConstraintAnchor.Type.TOP) || type2 == ConstraintAnchor.Type.BOTTOM)) {
            ConstraintAnchor anchor8 = constraintWidget.getAnchor(type2);
            getAnchor(type3).connect(anchor8, 0);
            getAnchor(ConstraintAnchor.Type.BOTTOM).connect(anchor8, 0);
            getAnchor(type15).connect(anchor8, 0);
            return;
        }
        if (type == type14 && type2 == type14) {
            ConstraintAnchor.Type type16 = ConstraintAnchor.Type.LEFT;
            getAnchor(type16).connect(constraintWidget.getAnchor(type16), 0);
            ConstraintAnchor.Type type17 = ConstraintAnchor.Type.RIGHT;
            getAnchor(type17).connect(constraintWidget.getAnchor(type17), 0);
            getAnchor(type14).connect(constraintWidget.getAnchor(type2), 0);
            return;
        }
        if (type == type15 && type2 == type15) {
            ConstraintAnchor.Type type18 = ConstraintAnchor.Type.TOP;
            getAnchor(type18).connect(constraintWidget.getAnchor(type18), 0);
            ConstraintAnchor.Type type19 = ConstraintAnchor.Type.BOTTOM;
            getAnchor(type19).connect(constraintWidget.getAnchor(type19), 0);
            getAnchor(type15).connect(constraintWidget.getAnchor(type2), 0);
            return;
        }
        ConstraintAnchor anchor9 = getAnchor(type);
        ConstraintAnchor anchor10 = constraintWidget.getAnchor(type2);
        if (anchor9.isValidConnection(anchor10)) {
            ConstraintAnchor.Type type20 = ConstraintAnchor.Type.BASELINE;
            if (type == type20) {
                ConstraintAnchor anchor11 = getAnchor(ConstraintAnchor.Type.TOP);
                ConstraintAnchor anchor12 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                if (anchor11 != null) {
                    anchor11.reset();
                }
                if (anchor12 != null) {
                    anchor12.reset();
                }
            } else if (type != ConstraintAnchor.Type.TOP && type != ConstraintAnchor.Type.BOTTOM) {
                if (type == ConstraintAnchor.Type.LEFT || type == ConstraintAnchor.Type.RIGHT) {
                    ConstraintAnchor anchor13 = getAnchor(type5);
                    if (anchor13.getTarget() != anchor10) {
                        anchor13.reset();
                    }
                    ConstraintAnchor opposite = getAnchor(type).getOpposite();
                    ConstraintAnchor anchor14 = getAnchor(type14);
                    if (anchor14.isConnected()) {
                        opposite.reset();
                        anchor14.reset();
                    }
                }
            } else {
                ConstraintAnchor anchor15 = getAnchor(type20);
                if (anchor15 != null) {
                    anchor15.reset();
                }
                ConstraintAnchor anchor16 = getAnchor(type5);
                if (anchor16.getTarget() != anchor10) {
                    anchor16.reset();
                }
                ConstraintAnchor opposite2 = getAnchor(type).getOpposite();
                ConstraintAnchor anchor17 = getAnchor(type15);
                if (anchor17.isConnected()) {
                    opposite2.reset();
                    anchor17.reset();
                }
            }
            anchor9.connect(anchor10, i);
        }
    }

    public void setDimensionRatio(float f, int i) {
        this.mDimensionRatio = f;
        this.mDimensionRatioSide = i;
    }

    public void setFrame(int i, int i2, int i3) {
        if (i3 == 0) {
            setHorizontalDimension(i, i2);
        } else if (i3 == 1) {
            setVerticalDimension(i, i2);
        }
    }

    public ConstraintWidget(String str) {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.mHorizontalRun = null;
        this.mVerticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.f2474a = true;
        this.f2475b = true;
        this.f2476c = -1;
        this.f2477d = -1;
        this.frame = new WidgetFrame(this);
        this.f2478e = false;
        this.f2479f = false;
        this.f2480g = false;
        this.f2481h = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.f2482i = 0;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.f2483j = -1;
        this.f2484k = 1.0f;
        this.f2485l = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = Float.NaN;
        this.f2486m = false;
        this.f2490o = false;
        this.f2491p = 0;
        this.f2492q = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.f2493r = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.f2494s = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.f2495t = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.f2496u = 0;
        this.f2497v = 0;
        this.mDimensionRatio = RecyclerView.f7068F0;
        this.mDimensionRatioSide = -1;
        this.f2487mX = 0;
        this.f2488mY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.f2498w = 0;
        float f = DEFAULT_BIAS;
        this.f2499x = f;
        this.f2500y = f;
        this.f2465A = 0;
        this.f2466B = 0;
        this.f2467C = false;
        this.f2468D = null;
        this.f2469E = null;
        this.f2470F = 0;
        this.f2471G = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.f2472H = null;
        this.f2473I = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        m495a();
        setDebugName(str);
    }

    public ConstraintWidget(int i, int i2, int i3, int i4) {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.mHorizontalRun = null;
        this.mVerticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.f2474a = true;
        this.f2475b = true;
        this.f2476c = -1;
        this.f2477d = -1;
        this.frame = new WidgetFrame(this);
        this.f2478e = false;
        this.f2479f = false;
        this.f2480g = false;
        this.f2481h = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.f2482i = 0;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.f2483j = -1;
        this.f2484k = 1.0f;
        this.f2485l = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = Float.NaN;
        this.f2486m = false;
        this.f2490o = false;
        this.f2491p = 0;
        this.f2492q = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.f2493r = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.f2494s = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.f2495t = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.mDimensionRatio = RecyclerView.f7068F0;
        this.mDimensionRatioSide = -1;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.f2498w = 0;
        float f = DEFAULT_BIAS;
        this.f2499x = f;
        this.f2500y = f;
        this.f2465A = 0;
        this.f2466B = 0;
        this.f2467C = false;
        this.f2468D = null;
        this.f2469E = null;
        this.f2470F = 0;
        this.f2471G = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.f2472H = null;
        this.f2473I = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        this.f2487mX = i;
        this.f2488mY = i2;
        this.f2496u = i3;
        this.f2497v = i4;
        m495a();
    }

    public ConstraintWidget(String str, int i, int i2, int i3, int i4) {
        this(i, i2, i3, i4);
        setDebugName(str);
    }

    public ConstraintWidget(int i, int i2) {
        this(0, 0, i, i2);
    }

    public ConstraintWidget(String str, int i, int i2) {
        this(i, i2);
        setDebugName(str);
    }
}
