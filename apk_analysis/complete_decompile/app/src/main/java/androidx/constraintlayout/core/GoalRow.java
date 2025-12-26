package androidx.constraintlayout.core;

/* loaded from: classes.dex */
public class GoalRow extends ArrayRow {
    public GoalRow(Cache cache) {
        super(cache);
    }

    @Override // androidx.constraintlayout.core.ArrayRow, p000.j81
    public void addError(SolverVariable solverVariable) {
        super.addError(solverVariable);
        solverVariable.usageInRowCount--;
    }
}
