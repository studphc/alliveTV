package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.Cache;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.analyzer.Grouping;
import androidx.constraintlayout.core.widgets.analyzer.WidgetGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ConstraintAnchor {

    /* renamed from: b */
    public int f2460b;

    /* renamed from: c */
    public boolean f2461c;

    /* renamed from: e */
    public SolverVariable f2463e;
    public final ConstraintWidget mOwner;
    public ConstraintAnchor mTarget;
    public final Type mType;

    /* renamed from: a */
    public HashSet f2459a = null;
    public int mMargin = 0;

    /* renamed from: d */
    public int f2462d = Integer.MIN_VALUE;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static final class Type {
        public static final Type BASELINE;
        public static final Type BOTTOM;
        public static final Type CENTER;
        public static final Type CENTER_X;
        public static final Type CENTER_Y;
        public static final Type LEFT;
        public static final Type NONE;
        public static final Type RIGHT;
        public static final Type TOP;

        /* renamed from: a */
        public static final /* synthetic */ Type[] f2464a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Enum, androidx.constraintlayout.core.widgets.ConstraintAnchor$Type] */
        /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Enum, androidx.constraintlayout.core.widgets.ConstraintAnchor$Type] */
        /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.Enum, androidx.constraintlayout.core.widgets.ConstraintAnchor$Type] */
        /* JADX WARN: Type inference failed for: r13v1, types: [java.lang.Enum, androidx.constraintlayout.core.widgets.ConstraintAnchor$Type] */
        /* JADX WARN: Type inference failed for: r14v1, types: [java.lang.Enum, androidx.constraintlayout.core.widgets.ConstraintAnchor$Type] */
        /* JADX WARN: Type inference failed for: r15v1, types: [java.lang.Enum, androidx.constraintlayout.core.widgets.ConstraintAnchor$Type] */
        /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, androidx.constraintlayout.core.widgets.ConstraintAnchor$Type] */
        /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Enum, androidx.constraintlayout.core.widgets.ConstraintAnchor$Type] */
        /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.Enum, androidx.constraintlayout.core.widgets.ConstraintAnchor$Type] */
        static {
            ?? r9 = new Enum("NONE", 0);
            NONE = r9;
            ?? r10 = new Enum("LEFT", 1);
            LEFT = r10;
            ?? r11 = new Enum("TOP", 2);
            TOP = r11;
            ?? r12 = new Enum("RIGHT", 3);
            RIGHT = r12;
            ?? r13 = new Enum("BOTTOM", 4);
            BOTTOM = r13;
            ?? r14 = new Enum("BASELINE", 5);
            BASELINE = r14;
            ?? r15 = new Enum("CENTER", 6);
            CENTER = r15;
            ?? r3 = new Enum("CENTER_X", 7);
            CENTER_X = r3;
            ?? r2 = new Enum("CENTER_Y", 8);
            CENTER_Y = r2;
            f2464a = new Type[]{r9, r10, r11, r12, r13, r14, r15, r3, r2};
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) f2464a.clone();
        }
    }

    public ConstraintAnchor(ConstraintWidget constraintWidget, Type type) {
        this.mOwner = constraintWidget;
        this.mType = type;
    }

    /* renamed from: a */
    public final boolean m487a(ConstraintWidget constraintWidget, HashSet hashSet) {
        if (hashSet.contains(constraintWidget)) {
            return false;
        }
        hashSet.add(constraintWidget);
        if (constraintWidget == getOwner()) {
            return true;
        }
        ArrayList<ConstraintAnchor> anchors = constraintWidget.getAnchors();
        int size = anchors.size();
        for (int i = 0; i < size; i++) {
            ConstraintAnchor constraintAnchor = anchors.get(i);
            if (constraintAnchor.isSimilarDimensionConnection(this) && constraintAnchor.isConnected() && m487a(constraintAnchor.getTarget().getOwner(), hashSet)) {
                return true;
            }
        }
        return false;
    }

    public boolean connect(ConstraintAnchor constraintAnchor, int i, int i2, boolean z) {
        if (constraintAnchor == null) {
            reset();
            return true;
        }
        if (!z && !isValidConnection(constraintAnchor)) {
            return false;
        }
        this.mTarget = constraintAnchor;
        if (constraintAnchor.f2459a == null) {
            constraintAnchor.f2459a = new HashSet();
        }
        HashSet hashSet = this.mTarget.f2459a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        this.mMargin = i;
        this.f2462d = i2;
        return true;
    }

    public void copyFrom(ConstraintAnchor constraintAnchor, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        HashSet hashSet;
        ConstraintAnchor constraintAnchor2 = this.mTarget;
        if (constraintAnchor2 != null && (hashSet = constraintAnchor2.f2459a) != null) {
            hashSet.remove(this);
        }
        ConstraintAnchor constraintAnchor3 = constraintAnchor.mTarget;
        if (constraintAnchor3 != null) {
            this.mTarget = hashMap.get(constraintAnchor.mTarget.mOwner).getAnchor(constraintAnchor3.getType());
        } else {
            this.mTarget = null;
        }
        ConstraintAnchor constraintAnchor4 = this.mTarget;
        if (constraintAnchor4 != null) {
            if (constraintAnchor4.f2459a == null) {
                constraintAnchor4.f2459a = new HashSet();
            }
            this.mTarget.f2459a.add(this);
        }
        this.mMargin = constraintAnchor.mMargin;
        this.f2462d = constraintAnchor.f2462d;
    }

    public void findDependents(int i, ArrayList<WidgetGroup> arrayList, WidgetGroup widgetGroup) {
        HashSet hashSet = this.f2459a;
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                Grouping.findDependents(((ConstraintAnchor) it.next()).mOwner, i, arrayList, widgetGroup);
            }
        }
    }

    public HashSet<ConstraintAnchor> getDependents() {
        return this.f2459a;
    }

    public int getFinalValue() {
        if (!this.f2461c) {
            return 0;
        }
        return this.f2460b;
    }

    public int getMargin() {
        ConstraintAnchor constraintAnchor;
        if (this.mOwner.getVisibility() == 8) {
            return 0;
        }
        if (this.f2462d != Integer.MIN_VALUE && (constraintAnchor = this.mTarget) != null && constraintAnchor.mOwner.getVisibility() == 8) {
            return this.f2462d;
        }
        return this.mMargin;
    }

    public final ConstraintAnchor getOpposite() {
        switch (this.mType.ordinal()) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
                return this.mOwner.mRight;
            case 2:
                return this.mOwner.mBottom;
            case 3:
                return this.mOwner.mLeft;
            case 4:
                return this.mOwner.mTop;
            default:
                throw new AssertionError(this.mType.name());
        }
    }

    public ConstraintWidget getOwner() {
        return this.mOwner;
    }

    public SolverVariable getSolverVariable() {
        return this.f2463e;
    }

    public ConstraintAnchor getTarget() {
        return this.mTarget;
    }

    public Type getType() {
        return this.mType;
    }

    public boolean hasCenteredDependents() {
        HashSet hashSet = this.f2459a;
        if (hashSet == null) {
            return false;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((ConstraintAnchor) it.next()).getOpposite().isConnected()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasDependents() {
        HashSet hashSet = this.f2459a;
        if (hashSet == null || hashSet.size() <= 0) {
            return false;
        }
        return true;
    }

    public boolean hasFinalValue() {
        return this.f2461c;
    }

    public boolean isConnected() {
        if (this.mTarget != null) {
            return true;
        }
        return false;
    }

    public boolean isConnectionAllowed(ConstraintWidget constraintWidget, ConstraintAnchor constraintAnchor) {
        return isConnectionAllowed(constraintWidget);
    }

    public boolean isSideAnchor() {
        switch (this.mType.ordinal()) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
                return false;
            case 1:
            case 2:
            case 3:
            case 4:
                return true;
            default:
                throw new AssertionError(this.mType.name());
        }
    }

    public boolean isSimilarDimensionConnection(ConstraintAnchor constraintAnchor) {
        Type type = constraintAnchor.getType();
        Type type2 = this.mType;
        if (type == type2) {
            return true;
        }
        switch (type2.ordinal()) {
            case 0:
                return false;
            case 1:
            case 3:
            case 7:
                if (type == Type.LEFT || type == Type.RIGHT || type == Type.CENTER_X) {
                    return true;
                }
                return false;
            case 2:
            case 4:
            case 5:
            case 8:
                if (type == Type.TOP || type == Type.BOTTOM || type == Type.CENTER_Y || type == Type.BASELINE) {
                    return true;
                }
                return false;
            case 6:
                if (type != Type.BASELINE) {
                    return true;
                }
                return false;
            default:
                throw new AssertionError(this.mType.name());
        }
    }

    public boolean isValidConnection(ConstraintAnchor constraintAnchor) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        if (constraintAnchor == null) {
            return false;
        }
        Type type = constraintAnchor.getType();
        Type type2 = this.mType;
        if (type != type2) {
            switch (type2.ordinal()) {
                case 0:
                case 7:
                case 8:
                    return false;
                case 1:
                case 3:
                    if (type != Type.LEFT && type != Type.RIGHT) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (constraintAnchor.getOwner() instanceof Guideline) {
                        if (z || type == Type.CENTER_X) {
                            z3 = true;
                        }
                        return z3;
                    }
                    return z;
                case 2:
                case 4:
                    if (type != Type.TOP && type != Type.BOTTOM) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (constraintAnchor.getOwner() instanceof Guideline) {
                        if (z2 || type == Type.CENTER_Y) {
                            z3 = true;
                        }
                        return z3;
                    }
                    return z2;
                case 5:
                    if (type == Type.LEFT || type == Type.RIGHT) {
                        return false;
                    }
                    return true;
                case 6:
                    if (type == Type.BASELINE || type == Type.CENTER_X || type == Type.CENTER_Y) {
                        return false;
                    }
                    return true;
                default:
                    throw new AssertionError(this.mType.name());
            }
        }
        if (type2 == Type.BASELINE && (!constraintAnchor.getOwner().hasBaseline() || !getOwner().hasBaseline())) {
            return false;
        }
        return true;
    }

    public boolean isVerticalAnchor() {
        switch (this.mType.ordinal()) {
            case 0:
            case 2:
            case 4:
            case 5:
            case 8:
                return true;
            case 1:
            case 3:
            case 6:
            case 7:
                return false;
            default:
                throw new AssertionError(this.mType.name());
        }
    }

    public void reset() {
        HashSet hashSet;
        ConstraintAnchor constraintAnchor = this.mTarget;
        if (constraintAnchor != null && (hashSet = constraintAnchor.f2459a) != null) {
            hashSet.remove(this);
            if (this.mTarget.f2459a.size() == 0) {
                this.mTarget.f2459a = null;
            }
        }
        this.f2459a = null;
        this.mTarget = null;
        this.mMargin = 0;
        this.f2462d = Integer.MIN_VALUE;
        this.f2461c = false;
        this.f2460b = 0;
    }

    public void resetFinalResolution() {
        this.f2461c = false;
        this.f2460b = 0;
    }

    public void resetSolverVariable(Cache cache) {
        SolverVariable solverVariable = this.f2463e;
        if (solverVariable == null) {
            this.f2463e = new SolverVariable(SolverVariable.Type.UNRESTRICTED, (String) null);
        } else {
            solverVariable.reset();
        }
    }

    public void setFinalValue(int i) {
        this.f2460b = i;
        this.f2461c = true;
    }

    public void setGoneMargin(int i) {
        if (isConnected()) {
            this.f2462d = i;
        }
    }

    public void setMargin(int i) {
        if (isConnected()) {
            this.mMargin = i;
        }
    }

    public String toString() {
        return this.mOwner.getDebugName() + ":" + this.mType.toString();
    }

    public boolean isConnectionAllowed(ConstraintWidget constraintWidget) {
        if (m487a(constraintWidget, new HashSet())) {
            return false;
        }
        ConstraintWidget parent = getOwner().getParent();
        return parent == constraintWidget || constraintWidget.getParent() == parent;
    }

    public boolean connect(ConstraintAnchor constraintAnchor, int i) {
        return connect(constraintAnchor, i, Integer.MIN_VALUE, false);
    }
}
