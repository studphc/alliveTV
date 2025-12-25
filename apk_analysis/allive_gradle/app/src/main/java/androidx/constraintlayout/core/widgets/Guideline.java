package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.HashMap;

/* loaded from: classes.dex */
public class Guideline extends ConstraintWidget {
    public static final int HORIZONTAL = 0;
    public static final int RELATIVE_BEGIN = 1;
    public static final int RELATIVE_END = 2;
    public static final int RELATIVE_PERCENT = 0;
    public static final int RELATIVE_UNKNOWN = -1;
    public static final int VERTICAL = 1;

    /* renamed from: M */
    public boolean f2546M;
    protected float mRelativePercent = -1.0f;
    protected int mRelativeBegin = -1;
    protected int mRelativeEnd = -1;
    protected boolean mGuidelineUseRtl = true;

    /* renamed from: J */
    public ConstraintAnchor f2543J = this.mTop;

    /* renamed from: K */
    public int f2544K = 0;

    /* renamed from: L */
    public int f2545L = 0;

    public Guideline() {
        this.mAnchors.clear();
        this.mAnchors.add(this.f2543J);
        int length = this.mListAnchors.length;
        for (int i = 0; i < length; i++) {
            this.mListAnchors[i] = this.f2543J;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem, boolean z) {
        boolean z2;
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) getParent();
        if (constraintWidgetContainer == null) {
            return;
        }
        ConstraintAnchor anchor = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor anchor2 = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.RIGHT);
        ConstraintWidget constraintWidget = this.mParent;
        boolean z3 = true;
        if (constraintWidget != null && constraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.f2544K == 0) {
            anchor = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.TOP);
            anchor2 = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.BOTTOM);
            ConstraintWidget constraintWidget2 = this.mParent;
            if (constraintWidget2 == null || constraintWidget2.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                z3 = false;
            }
            z2 = z3;
        }
        if (this.f2546M && this.f2543J.hasFinalValue()) {
            SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.f2543J);
            linearSystem.addEquality(createObjectVariable, this.f2543J.getFinalValue());
            if (this.mRelativeBegin != -1) {
                if (z2) {
                    linearSystem.addGreaterThan(linearSystem.createObjectVariable(anchor2), createObjectVariable, 0, 5);
                }
            } else if (this.mRelativeEnd != -1 && z2) {
                SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(anchor2);
                linearSystem.addGreaterThan(createObjectVariable, linearSystem.createObjectVariable(anchor), 0, 5);
                linearSystem.addGreaterThan(createObjectVariable2, createObjectVariable, 0, 5);
            }
            this.f2546M = false;
            return;
        }
        if (this.mRelativeBegin != -1) {
            SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(this.f2543J);
            linearSystem.addEquality(createObjectVariable3, linearSystem.createObjectVariable(anchor), this.mRelativeBegin, 8);
            if (z2) {
                linearSystem.addGreaterThan(linearSystem.createObjectVariable(anchor2), createObjectVariable3, 0, 5);
                return;
            }
            return;
        }
        if (this.mRelativeEnd != -1) {
            SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(this.f2543J);
            SolverVariable createObjectVariable5 = linearSystem.createObjectVariable(anchor2);
            linearSystem.addEquality(createObjectVariable4, createObjectVariable5, -this.mRelativeEnd, 8);
            if (z2) {
                linearSystem.addGreaterThan(createObjectVariable4, linearSystem.createObjectVariable(anchor), 0, 5);
                linearSystem.addGreaterThan(createObjectVariable5, createObjectVariable4, 0, 5);
                return;
            }
            return;
        }
        if (this.mRelativePercent != -1.0f) {
            linearSystem.addConstraint(LinearSystem.createRowDimensionPercent(linearSystem, linearSystem.createObjectVariable(this.f2543J), linearSystem.createObjectVariable(anchor2), this.mRelativePercent));
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean allowedInBarrier() {
        return true;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        Guideline guideline = (Guideline) constraintWidget;
        this.mRelativePercent = guideline.mRelativePercent;
        this.mRelativeBegin = guideline.mRelativeBegin;
        this.mRelativeEnd = guideline.mRelativeEnd;
        this.mGuidelineUseRtl = guideline.mGuidelineUseRtl;
        setOrientation(guideline.f2544K);
    }

    public void cyclePosition() {
        if (this.mRelativeBegin != -1) {
            float x = getX() / getParent().getWidth();
            if (this.f2544K == 0) {
                x = getY() / getParent().getHeight();
            }
            setGuidePercent(x);
            return;
        }
        if (this.mRelativePercent != -1.0f) {
            int width = getParent().getWidth() - getX();
            if (this.f2544K == 0) {
                width = getParent().getHeight() - getY();
            }
            setGuideEnd(width);
            return;
        }
        if (this.mRelativeEnd != -1) {
            int x2 = getX();
            if (this.f2544K == 0) {
                x2 = getY();
            }
            setGuideBegin(x2);
        }
    }

    public ConstraintAnchor getAnchor() {
        return this.f2543J;
    }

    public int getMinimumPosition() {
        return this.f2545L;
    }

    public int getOrientation() {
        return this.f2544K;
    }

    public int getRelativeBegin() {
        return this.mRelativeBegin;
    }

    public int getRelativeBehaviour() {
        if (this.mRelativePercent != -1.0f) {
            return 0;
        }
        if (this.mRelativeBegin != -1) {
            return 1;
        }
        if (this.mRelativeEnd == -1) {
            return -1;
        }
        return 2;
    }

    public int getRelativeEnd() {
        return this.mRelativeEnd;
    }

    public float getRelativePercent() {
        return this.mRelativePercent;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public String getType() {
        return "Guideline";
    }

    public boolean isPercent() {
        if (this.mRelativePercent != -1.0f && this.mRelativeBegin == -1 && this.mRelativeEnd == -1) {
            return true;
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean isResolvedHorizontally() {
        return this.f2546M;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean isResolvedVertically() {
        return this.f2546M;
    }

    public void setFinalValue(int i) {
        this.f2543J.setFinalValue(i);
        this.f2546M = true;
    }

    public void setGuideBegin(int i) {
        if (i > -1) {
            this.mRelativePercent = -1.0f;
            this.mRelativeBegin = i;
            this.mRelativeEnd = -1;
        }
    }

    public void setGuideEnd(int i) {
        if (i > -1) {
            this.mRelativePercent = -1.0f;
            this.mRelativeBegin = -1;
            this.mRelativeEnd = i;
        }
    }

    public void setGuidePercent(int i) {
        setGuidePercent(i / 100.0f);
    }

    public void setMinimumPosition(int i) {
        this.f2545L = i;
    }

    public void setOrientation(int i) {
        if (this.f2544K == i) {
            return;
        }
        this.f2544K = i;
        this.mAnchors.clear();
        if (this.f2544K == 1) {
            this.f2543J = this.mLeft;
        } else {
            this.f2543J = this.mTop;
        }
        this.mAnchors.add(this.f2543J);
        int length = this.mListAnchors.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.mListAnchors[i2] = this.f2543J;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void updateFromSolver(LinearSystem linearSystem, boolean z) {
        if (getParent() == null) {
            return;
        }
        int objectVariableValue = linearSystem.getObjectVariableValue(this.f2543J);
        if (this.f2544K == 1) {
            setX(objectVariableValue);
            setY(0);
            setHeight(getParent().getHeight());
            setWidth(0);
            return;
        }
        setX(0);
        setY(objectVariableValue);
        setWidth(getParent().getWidth());
        setHeight(0);
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        int i = AbstractC0124c.f2613a[type.ordinal()];
        if (i != 1 && i != 2) {
            if ((i == 3 || i == 4) && this.f2544K == 0) {
                return this.f2543J;
            }
            return null;
        }
        if (this.f2544K == 1) {
            return this.f2543J;
        }
        return null;
    }

    public void setGuidePercent(float f) {
        if (f > -1.0f) {
            this.mRelativePercent = f;
            this.mRelativeBegin = -1;
            this.mRelativeEnd = -1;
        }
    }
}
