package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.core.widgets.analyzer.DependencyGraph;
import androidx.constraintlayout.core.widgets.analyzer.Direct;
import androidx.constraintlayout.core.widgets.analyzer.Grouping;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ConstraintWidgetContainer extends WidgetContainer {

    /* renamed from: J */
    public final BasicMeasure f2503J;

    /* renamed from: K */
    public int f2504K;

    /* renamed from: L */
    public boolean f2505L;

    /* renamed from: M */
    public int f2506M;

    /* renamed from: N */
    public int f2507N;

    /* renamed from: O */
    public ChainHead[] f2508O;

    /* renamed from: P */
    public ChainHead[] f2509P;

    /* renamed from: Q */
    public int f2510Q;

    /* renamed from: R */
    public boolean f2511R;

    /* renamed from: S */
    public boolean f2512S;

    /* renamed from: T */
    public WeakReference f2513T;

    /* renamed from: U */
    public WeakReference f2514U;

    /* renamed from: V */
    public WeakReference f2515V;

    /* renamed from: W */
    public WeakReference f2516W;

    /* renamed from: X */
    public final HashSet f2517X;
    public DependencyGraph mDependencyGraph;
    public boolean mGroupsWrapOptimized;
    public int mHorizontalChainsSize;
    public boolean mHorizontalWrapOptimized;
    public BasicMeasure.Measure mMeasure;
    protected BasicMeasure.Measurer mMeasurer;
    public Metrics mMetrics;
    public boolean mSkipSolver;
    protected LinearSystem mSystem;
    public int mVerticalChainsSize;
    public boolean mVerticalWrapOptimized;
    public int mWrapFixedHeight;
    public int mWrapFixedWidth;

    public ConstraintWidgetContainer() {
        this.f2503J = new BasicMeasure(this);
        this.mDependencyGraph = new DependencyGraph(this);
        this.mMeasurer = null;
        this.f2505L = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.f2508O = new ChainHead[4];
        this.f2509P = new ChainHead[4];
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.f2510Q = 257;
        this.mSkipSolver = false;
        this.f2511R = false;
        this.f2512S = false;
        this.f2513T = null;
        this.f2514U = null;
        this.f2515V = null;
        this.f2516W = null;
        this.f2517X = new HashSet();
        this.mMeasure = new BasicMeasure.Measure();
    }

    public boolean addChildrenToSolver(LinearSystem linearSystem) {
        int i;
        boolean optimizeFor = optimizeFor(64);
        addToSolver(linearSystem, optimizeFor);
        int size = this.mChildren.size();
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i2);
            constraintWidget.setInBarrier(0, false);
            constraintWidget.setInBarrier(1, false);
            if (constraintWidget instanceof Barrier) {
                z = true;
            }
        }
        if (z) {
            for (int i3 = 0; i3 < size; i3++) {
                ConstraintWidget constraintWidget2 = this.mChildren.get(i3);
                if (constraintWidget2 instanceof Barrier) {
                    ((Barrier) constraintWidget2).markWidgets();
                }
            }
        }
        HashSet<ConstraintWidget> hashSet = this.f2517X;
        hashSet.clear();
        for (int i4 = 0; i4 < size; i4++) {
            ConstraintWidget constraintWidget3 = this.mChildren.get(i4);
            constraintWidget3.getClass();
            boolean z2 = constraintWidget3 instanceof VirtualLayout;
            if (z2 || (constraintWidget3 instanceof Guideline)) {
                if (z2) {
                    hashSet.add(constraintWidget3);
                } else {
                    constraintWidget3.addToSolver(linearSystem, optimizeFor);
                }
            }
        }
        while (hashSet.size() > 0) {
            int size2 = hashSet.size();
            Iterator<ConstraintWidget> it = hashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                VirtualLayout virtualLayout = (VirtualLayout) it.next();
                if (virtualLayout.contains(hashSet)) {
                    virtualLayout.addToSolver(linearSystem, optimizeFor);
                    hashSet.remove(virtualLayout);
                    break;
                }
            }
            if (size2 == hashSet.size()) {
                Iterator<ConstraintWidget> it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    it2.next().addToSolver(linearSystem, optimizeFor);
                }
                hashSet.clear();
            }
        }
        if (LinearSystem.USE_DEPENDENCY_ORDERING) {
            HashSet<ConstraintWidget> hashSet2 = new HashSet<>();
            for (int i5 = 0; i5 < size; i5++) {
                ConstraintWidget constraintWidget4 = this.mChildren.get(i5);
                constraintWidget4.getClass();
                if (!(constraintWidget4 instanceof VirtualLayout) && !(constraintWidget4 instanceof Guideline)) {
                    hashSet2.add(constraintWidget4);
                }
            }
            if (getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                i = 0;
            } else {
                i = 1;
            }
            addChildrenToSolverByDependency(this, linearSystem, hashSet2, i, false);
            Iterator<ConstraintWidget> it3 = hashSet2.iterator();
            while (it3.hasNext()) {
                ConstraintWidget next = it3.next();
                Optimizer.m501a(this, linearSystem, next);
                next.addToSolver(linearSystem, optimizeFor);
            }
        } else {
            for (int i6 = 0; i6 < size; i6++) {
                ConstraintWidget constraintWidget5 = this.mChildren.get(i6);
                if (constraintWidget5 instanceof ConstraintWidgetContainer) {
                    ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget5.mListDimensionBehaviors;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        constraintWidget5.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        constraintWidget5.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    constraintWidget5.addToSolver(linearSystem, optimizeFor);
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        constraintWidget5.setHorizontalDimensionBehaviour(dimensionBehaviour);
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        constraintWidget5.setVerticalDimensionBehaviour(dimensionBehaviour2);
                    }
                } else {
                    Optimizer.m501a(this, linearSystem, constraintWidget5);
                    if (!(constraintWidget5 instanceof VirtualLayout) && !(constraintWidget5 instanceof Guideline)) {
                        constraintWidget5.addToSolver(linearSystem, optimizeFor);
                    }
                }
            }
        }
        if (this.mHorizontalChainsSize > 0) {
            Chain.applyChainConstraints(this, linearSystem, null, 0);
        }
        if (this.mVerticalChainsSize > 0) {
            Chain.applyChainConstraints(this, linearSystem, null, 1);
        }
        return true;
    }

    public void addHorizontalWrapMaxVariable(ConstraintAnchor constraintAnchor) {
        WeakReference weakReference = this.f2516W;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.getFinalValue() > ((ConstraintAnchor) this.f2516W.get()).getFinalValue()) {
            this.f2516W = new WeakReference(constraintAnchor);
        }
    }

    public void addHorizontalWrapMinVariable(ConstraintAnchor constraintAnchor) {
        WeakReference weakReference = this.f2514U;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.getFinalValue() > ((ConstraintAnchor) this.f2514U.get()).getFinalValue()) {
            this.f2514U = new WeakReference(constraintAnchor);
        }
    }

    public void defineTerminalWidgets() {
        this.mDependencyGraph.defineTerminalWidgets(getHorizontalDimensionBehaviour(), getVerticalDimensionBehaviour());
    }

    public boolean directMeasure(boolean z) {
        return this.mDependencyGraph.directMeasure(z);
    }

    public boolean directMeasureSetup(boolean z) {
        return this.mDependencyGraph.directMeasureSetup(z);
    }

    public boolean directMeasureWithOrientation(boolean z, int i) {
        return this.mDependencyGraph.directMeasureWithOrientation(z, i);
    }

    public void fillMetrics(Metrics metrics) {
        this.mMetrics = metrics;
        this.mSystem.fillMetrics(metrics);
    }

    public ArrayList<Guideline> getHorizontalGuidelines() {
        ArrayList<Guideline> arrayList = new ArrayList<>();
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 0) {
                    arrayList.add(guideline);
                }
            }
        }
        return arrayList;
    }

    public BasicMeasure.Measurer getMeasurer() {
        return this.mMeasurer;
    }

    public int getOptimizationLevel() {
        return this.f2510Q;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void getSceneString(StringBuilder sb) {
        sb.append(this.stringId + ":{\n");
        StringBuilder sb2 = new StringBuilder("  actualWidth:");
        sb2.append(this.f2496u);
        sb.append(sb2.toString());
        sb.append("\n");
        sb.append("  actualHeight:" + this.f2497v);
        sb.append("\n");
        Iterator<ConstraintWidget> it = getChildren().iterator();
        while (it.hasNext()) {
            it.next().getSceneString(sb);
            sb.append(",\n");
        }
        sb.append("}");
    }

    public LinearSystem getSystem() {
        return this.mSystem;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public String getType() {
        return "ConstraintLayout";
    }

    public ArrayList<Guideline> getVerticalGuidelines() {
        ArrayList<Guideline> arrayList = new ArrayList<>();
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 1) {
                    arrayList.add(guideline);
                }
            }
        }
        return arrayList;
    }

    public boolean handlesInternalConstraints() {
        return false;
    }

    public void invalidateGraph() {
        this.mDependencyGraph.invalidateGraph();
    }

    public void invalidateMeasures() {
        this.mDependencyGraph.invalidateMeasures();
    }

    public boolean isHeightMeasuredTooSmall() {
        return this.f2512S;
    }

    public boolean isRtl() {
        return this.f2505L;
    }

    public boolean isWidthMeasuredTooSmall() {
        return this.f2511R;
    }

    /* renamed from: k */
    public final void m498k(ConstraintWidget constraintWidget, int i) {
        if (i == 0) {
            int i2 = this.mHorizontalChainsSize + 1;
            ChainHead[] chainHeadArr = this.f2509P;
            if (i2 >= chainHeadArr.length) {
                this.f2509P = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
            }
            this.f2509P[this.mHorizontalChainsSize] = new ChainHead(constraintWidget, 0, isRtl());
            this.mHorizontalChainsSize++;
            return;
        }
        if (i == 1) {
            int i3 = this.mVerticalChainsSize + 1;
            ChainHead[] chainHeadArr2 = this.f2508O;
            if (i3 >= chainHeadArr2.length) {
                this.f2508O = (ChainHead[]) Arrays.copyOf(chainHeadArr2, chainHeadArr2.length * 2);
            }
            this.f2508O[this.mVerticalChainsSize] = new ChainHead(constraintWidget, 1, isRtl());
            this.mVerticalChainsSize++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x023b  */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v13 */
    @Override // androidx.constraintlayout.core.widgets.WidgetContainer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void layout() {
        int i;
        int i2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int max;
        int max2;
        ?? r6;
        boolean z7;
        boolean z8;
        boolean z9;
        int i3;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        int i4 = 0;
        this.f2487mX = 0;
        this.f2488mY = 0;
        this.f2511R = false;
        this.f2512S = false;
        int size = this.mChildren.size();
        int max3 = Math.max(0, getWidth());
        int max4 = Math.max(0, getHeight());
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = dimensionBehaviourArr[0];
        Metrics metrics = this.mMetrics;
        if (metrics != null) {
            metrics.layouts++;
        }
        if (this.f2504K == 0 && Optimizer.enabled(this.f2510Q, 1)) {
            Direct.solvingPass(this, getMeasurer());
            for (int i5 = 0; i5 < size; i5++) {
                ConstraintWidget constraintWidget = this.mChildren.get(i5);
                if (constraintWidget.isMeasureRequested() && !(constraintWidget instanceof Guideline) && !(constraintWidget instanceof Barrier) && !(constraintWidget instanceof VirtualLayout) && !constraintWidget.isInVirtualLayout()) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = constraintWidget.getDimensionBehaviour(0);
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = constraintWidget.getDimensionBehaviour(1);
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviour4 != dimensionBehaviour6 || constraintWidget.mMatchConstraintDefaultWidth == 1 || dimensionBehaviour5 != dimensionBehaviour6 || constraintWidget.mMatchConstraintDefaultHeight == 1) {
                        measure(0, constraintWidget, this.mMeasurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                    }
                }
            }
        }
        if (size > 2 && ((dimensionBehaviour3 == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour2 == dimensionBehaviour) && Optimizer.enabled(this.f2510Q, 1024) && Grouping.simpleSolvingPass(this, getMeasurer()))) {
            if (dimensionBehaviour3 == dimensionBehaviour) {
                if (max3 < getWidth() && max3 > 0) {
                    setWidth(max3);
                    this.f2511R = true;
                } else {
                    max3 = getWidth();
                }
            }
            if (dimensionBehaviour2 == dimensionBehaviour) {
                if (max4 < getHeight() && max4 > 0) {
                    setHeight(max4);
                    this.f2512S = true;
                } else {
                    max4 = getHeight();
                }
            }
            i = max4;
            i2 = max3;
            z = true;
        } else {
            i = max4;
            i2 = max3;
            z = false;
        }
        if (!optimizeFor(64) && !optimizeFor(128)) {
            z2 = false;
        } else {
            z2 = true;
        }
        LinearSystem linearSystem = this.mSystem;
        linearSystem.graphOptimizer = false;
        linearSystem.newgraphOptimizer = false;
        if (this.f2510Q != 0 && z2) {
            linearSystem.newgraphOptimizer = true;
        }
        ArrayList<ConstraintWidget> arrayList = this.mChildren;
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (horizontalDimensionBehaviour != dimensionBehaviour7 && getVerticalDimensionBehaviour() != dimensionBehaviour7) {
            z3 = false;
        } else {
            z3 = true;
        }
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        for (int i6 = 0; i6 < size; i6++) {
            ConstraintWidget constraintWidget2 = this.mChildren.get(i6);
            if (constraintWidget2 instanceof WidgetContainer) {
                ((WidgetContainer) constraintWidget2).layout();
            }
        }
        boolean optimizeFor = optimizeFor(64);
        boolean z10 = z;
        int i7 = 0;
        boolean z11 = true;
        while (z11) {
            int i8 = i7 + 1;
            try {
                this.mSystem.reset();
                this.mHorizontalChainsSize = i4;
                this.mVerticalChainsSize = i4;
                createObjectVariables(this.mSystem);
                for (int i9 = i4; i9 < size; i9++) {
                    this.mChildren.get(i9).createObjectVariables(this.mSystem);
                }
                z11 = addChildrenToSolver(this.mSystem);
                WeakReference weakReference = this.f2513T;
                if (weakReference != null && weakReference.get() != null) {
                    z4 = z10;
                    try {
                        this.mSystem.addGreaterThan(this.mSystem.createObjectVariable((ConstraintAnchor) this.f2513T.get()), this.mSystem.createObjectVariable(this.mTop), 0, 5);
                        this.f2513T = null;
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        System.out.println("EXCEPTION : " + e);
                        boolean[] zArr = Optimizer.f2547a;
                        if (!z11) {
                        }
                        if (!z3) {
                        }
                        z6 = z4;
                        max = Math.max(this.mMinWidth, getWidth());
                        if (max > getWidth()) {
                        }
                        max2 = Math.max(this.mMinHeight, getHeight());
                        if (max2 <= getHeight()) {
                        }
                        if (!z8) {
                        }
                        z10 = z8;
                        z9 = z7;
                        i3 = 8;
                        if (i8 > i3) {
                        }
                        i7 = i8;
                        i4 = 0;
                    }
                } else {
                    z4 = z10;
                }
                WeakReference weakReference2 = this.f2515V;
                if (weakReference2 != null && weakReference2.get() != null) {
                    this.mSystem.addGreaterThan(this.mSystem.createObjectVariable(this.mBottom), this.mSystem.createObjectVariable((ConstraintAnchor) this.f2515V.get()), 0, 5);
                    this.f2515V = null;
                }
                WeakReference weakReference3 = this.f2514U;
                if (weakReference3 != null && weakReference3.get() != null) {
                    this.mSystem.addGreaterThan(this.mSystem.createObjectVariable((ConstraintAnchor) this.f2514U.get()), this.mSystem.createObjectVariable(this.mLeft), 0, 5);
                    this.f2514U = null;
                }
                WeakReference weakReference4 = this.f2516W;
                if (weakReference4 != null && weakReference4.get() != null) {
                    this.mSystem.addGreaterThan(this.mSystem.createObjectVariable(this.mRight), this.mSystem.createObjectVariable((ConstraintAnchor) this.f2516W.get()), 0, 5);
                    this.f2516W = null;
                }
                if (z11) {
                    this.mSystem.minimize();
                }
            } catch (Exception e2) {
                e = e2;
                z4 = z10;
            }
            boolean[] zArr2 = Optimizer.f2547a;
            if (!z11) {
                z5 = updateChildrenFromSolver(this.mSystem, zArr2);
            } else {
                updateFromSolver(this.mSystem, optimizeFor);
                for (int i10 = 0; i10 < size; i10++) {
                    this.mChildren.get(i10).updateFromSolver(this.mSystem, optimizeFor);
                }
                z5 = false;
            }
            if (!z3 && i8 < 8 && zArr2[2]) {
                int i11 = 0;
                int i12 = 0;
                for (int i13 = 0; i13 < size; i13++) {
                    ConstraintWidget constraintWidget3 = this.mChildren.get(i13);
                    i11 = Math.max(i11, constraintWidget3.getWidth() + constraintWidget3.f2487mX);
                    i12 = Math.max(i12, constraintWidget3.getHeight() + constraintWidget3.f2488mY);
                }
                int max5 = Math.max(this.mMinWidth, i11);
                int max6 = Math.max(this.mMinHeight, i12);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour8 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (dimensionBehaviour3 == dimensionBehaviour8 && getWidth() < max5) {
                    setWidth(max5);
                    this.mListDimensionBehaviors[0] = dimensionBehaviour8;
                    z5 = true;
                    z6 = true;
                } else {
                    z6 = z4;
                }
                if (dimensionBehaviour2 == dimensionBehaviour8 && getHeight() < max6) {
                    setHeight(max6);
                    this.mListDimensionBehaviors[1] = dimensionBehaviour8;
                    z5 = true;
                    z6 = true;
                }
            } else {
                z6 = z4;
            }
            max = Math.max(this.mMinWidth, getWidth());
            if (max > getWidth()) {
                setWidth(max);
                this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                z5 = true;
                z6 = true;
            }
            max2 = Math.max(this.mMinHeight, getHeight());
            if (max2 <= getHeight()) {
                setHeight(max2);
                r6 = 1;
                this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.FIXED;
                z7 = true;
                z8 = true;
            } else {
                r6 = 1;
                z7 = z5;
                z8 = z6;
            }
            if (!z8) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour9 = this.mListDimensionBehaviors[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour10 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (dimensionBehaviour9 == dimensionBehaviour10 && i2 > 0 && getWidth() > i2) {
                    this.f2511R = r6;
                    this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                    setWidth(i2);
                    z7 = r6;
                    z8 = z7;
                }
                if (this.mListDimensionBehaviors[r6] == dimensionBehaviour10 && i > 0 && getHeight() > i) {
                    this.f2512S = r6;
                    this.mListDimensionBehaviors[r6] = ConstraintWidget.DimensionBehaviour.FIXED;
                    setHeight(i);
                    i3 = 8;
                    z9 = true;
                    z10 = true;
                    if (i8 > i3) {
                        z11 = false;
                    } else {
                        z11 = z9;
                    }
                    i7 = i8;
                    i4 = 0;
                }
            }
            z10 = z8;
            z9 = z7;
            i3 = 8;
            if (i8 > i3) {
            }
            i7 = i8;
            i4 = 0;
        }
        boolean z12 = z10;
        this.mChildren = arrayList;
        if (z12) {
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = this.mListDimensionBehaviors;
            dimensionBehaviourArr2[0] = dimensionBehaviour3;
            dimensionBehaviourArr2[1] = dimensionBehaviour2;
        }
        resetSolverVariables(this.mSystem.getCache());
    }

    public long measure(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.f2506M = i8;
        this.f2507N = i9;
        return this.f2503J.solverMeasure(this, i, i8, i9, i2, i3, i4, i5, i6, i7);
    }

    public boolean optimizeFor(int i) {
        if ((this.f2510Q & i) == i) {
            return true;
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.widgets.WidgetContainer, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void reset() {
        this.mSystem.reset();
        this.f2506M = 0;
        this.f2507N = 0;
        this.mSkipSolver = false;
        super.reset();
    }

    public void setMeasurer(BasicMeasure.Measurer measurer) {
        this.mMeasurer = measurer;
        this.mDependencyGraph.setMeasurer(measurer);
    }

    public void setOptimizationLevel(int i) {
        this.f2510Q = i;
        LinearSystem.USE_DEPENDENCY_ORDERING = optimizeFor(512);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.f2506M = i;
        this.f2507N = i2;
    }

    public void setPass(int i) {
        this.f2504K = i;
    }

    public void setRtl(boolean z) {
        this.f2505L = z;
    }

    public boolean updateChildrenFromSolver(LinearSystem linearSystem, boolean[] zArr) {
        zArr[2] = false;
        boolean optimizeFor = optimizeFor(64);
        updateFromSolver(linearSystem, optimizeFor);
        int size = this.mChildren.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i);
            constraintWidget.updateFromSolver(linearSystem, optimizeFor);
            if (constraintWidget.hasDimensionOverride()) {
                z = true;
            }
        }
        return z;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void updateFromRuns(boolean z, boolean z2) {
        super.updateFromRuns(z, z2);
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            this.mChildren.get(i).updateFromRuns(z, z2);
        }
    }

    public void updateHierarchy() {
        this.f2503J.updateHierarchy(this);
    }

    public static boolean measure(int i, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, BasicMeasure.Measure measure, int i2) {
        int i3;
        int i4;
        if (measurer == null) {
            return false;
        }
        if (constraintWidget.getVisibility() != 8 && !(constraintWidget instanceof Guideline) && !(constraintWidget instanceof Barrier)) {
            measure.horizontalBehavior = constraintWidget.getHorizontalDimensionBehaviour();
            measure.verticalBehavior = constraintWidget.getVerticalDimensionBehaviour();
            measure.horizontalDimension = constraintWidget.getWidth();
            measure.verticalDimension = constraintWidget.getHeight();
            measure.measuredNeedsSolverPass = false;
            measure.measureStrategy = i2;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = measure.horizontalBehavior;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            boolean z = dimensionBehaviour == dimensionBehaviour2;
            boolean z2 = measure.verticalBehavior == dimensionBehaviour2;
            boolean z3 = z && constraintWidget.mDimensionRatio > RecyclerView.f7068F0;
            boolean z4 = z2 && constraintWidget.mDimensionRatio > RecyclerView.f7068F0;
            if (z && constraintWidget.hasDanglingDimension(0) && constraintWidget.mMatchConstraintDefaultWidth == 0 && !z3) {
                measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (z2 && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                    measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
                }
                z = false;
            }
            if (z2 && constraintWidget.hasDanglingDimension(1) && constraintWidget.mMatchConstraintDefaultHeight == 0 && !z4) {
                measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (z && constraintWidget.mMatchConstraintDefaultWidth == 0) {
                    measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
                }
                z2 = false;
            }
            if (constraintWidget.isResolvedHorizontally()) {
                measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
                z = false;
            }
            if (constraintWidget.isResolvedVertically()) {
                measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
                z2 = false;
            }
            if (z3) {
                if (constraintWidget.mResolvedMatchConstraintDefault[0] == 4) {
                    measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
                } else if (!z2) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = measure.verticalBehavior;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                    if (dimensionBehaviour3 == dimensionBehaviour4) {
                        i4 = measure.verticalDimension;
                    } else {
                        measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                        measurer.measure(constraintWidget, measure);
                        i4 = measure.measuredHeight;
                    }
                    measure.horizontalBehavior = dimensionBehaviour4;
                    measure.horizontalDimension = (int) (constraintWidget.getDimensionRatio() * i4);
                }
            }
            if (z4) {
                if (constraintWidget.mResolvedMatchConstraintDefault[1] == 4) {
                    measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
                } else if (!z) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = measure.horizontalBehavior;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.FIXED;
                    if (dimensionBehaviour5 == dimensionBehaviour6) {
                        i3 = measure.horizontalDimension;
                    } else {
                        measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                        measurer.measure(constraintWidget, measure);
                        i3 = measure.measuredWidth;
                    }
                    measure.verticalBehavior = dimensionBehaviour6;
                    if (constraintWidget.getDimensionRatioSide() == -1) {
                        measure.verticalDimension = (int) (i3 / constraintWidget.getDimensionRatio());
                    } else {
                        measure.verticalDimension = (int) (constraintWidget.getDimensionRatio() * i3);
                    }
                }
            }
            measurer.measure(constraintWidget, measure);
            constraintWidget.setWidth(measure.measuredWidth);
            constraintWidget.setHeight(measure.measuredHeight);
            constraintWidget.setHasBaseline(measure.measuredHasBaseline);
            constraintWidget.setBaselineDistance(measure.measuredBaseline);
            measure.measureStrategy = BasicMeasure.Measure.SELF_DIMENSIONS;
            return measure.measuredNeedsSolverPass;
        }
        measure.measuredWidth = 0;
        measure.measuredHeight = 0;
        return false;
    }

    public ConstraintWidgetContainer(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
        this.f2503J = new BasicMeasure(this);
        this.mDependencyGraph = new DependencyGraph(this);
        this.mMeasurer = null;
        this.f2505L = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.f2508O = new ChainHead[4];
        this.f2509P = new ChainHead[4];
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.f2510Q = 257;
        this.mSkipSolver = false;
        this.f2511R = false;
        this.f2512S = false;
        this.f2513T = null;
        this.f2514U = null;
        this.f2515V = null;
        this.f2516W = null;
        this.f2517X = new HashSet();
        this.mMeasure = new BasicMeasure.Measure();
    }

    public ConstraintWidgetContainer(int i, int i2) {
        super(i, i2);
        this.f2503J = new BasicMeasure(this);
        this.mDependencyGraph = new DependencyGraph(this);
        this.mMeasurer = null;
        this.f2505L = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.f2508O = new ChainHead[4];
        this.f2509P = new ChainHead[4];
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.f2510Q = 257;
        this.mSkipSolver = false;
        this.f2511R = false;
        this.f2512S = false;
        this.f2513T = null;
        this.f2514U = null;
        this.f2515V = null;
        this.f2516W = null;
        this.f2517X = new HashSet();
        this.mMeasure = new BasicMeasure.Measure();
    }

    public ConstraintWidgetContainer(String str, int i, int i2) {
        super(i, i2);
        this.f2503J = new BasicMeasure(this);
        this.mDependencyGraph = new DependencyGraph(this);
        this.mMeasurer = null;
        this.f2505L = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.f2508O = new ChainHead[4];
        this.f2509P = new ChainHead[4];
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.f2510Q = 257;
        this.mSkipSolver = false;
        this.f2511R = false;
        this.f2512S = false;
        this.f2513T = null;
        this.f2514U = null;
        this.f2515V = null;
        this.f2516W = null;
        this.f2517X = new HashSet();
        this.mMeasure = new BasicMeasure.Measure();
        setDebugName(str);
    }
}
