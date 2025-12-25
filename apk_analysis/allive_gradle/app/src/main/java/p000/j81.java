package p000;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;

/* loaded from: classes.dex */
public interface j81 {
    void addError(SolverVariable solverVariable);

    void clear();

    SolverVariable getKey();

    SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr);

    void initFromRow(j81 j81Var);

    boolean isEmpty();
}
