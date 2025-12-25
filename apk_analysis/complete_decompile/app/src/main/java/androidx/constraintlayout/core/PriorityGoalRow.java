package androidx.constraintlayout.core;

import androidx.constraintlayout.core.ArrayRow;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import p000.C1540m9;
import p000.x30;

/* loaded from: classes.dex */
public class PriorityGoalRow extends ArrayRow {

    /* renamed from: e */
    public SolverVariable[] f1850e;

    /* renamed from: f */
    public SolverVariable[] f1851f;

    /* renamed from: g */
    public int f1852g;

    /* renamed from: h */
    public final C1540m9 f1853h;

    public PriorityGoalRow(Cache cache) {
        super(cache);
        this.f1850e = new SolverVariable[128];
        this.f1851f = new SolverVariable[128];
        this.f1852g = 0;
        this.f1853h = new C1540m9((Object) this, 19, false);
    }

    @Override // androidx.constraintlayout.core.ArrayRow, p000.j81
    public void addError(SolverVariable solverVariable) {
        this.f1853h.f22854b = solverVariable;
        Arrays.fill(solverVariable.f1857d, RecyclerView.f7068F0);
        solverVariable.f1857d[solverVariable.strength] = 1.0f;
        m434d(solverVariable);
    }

    @Override // androidx.constraintlayout.core.ArrayRow, p000.j81
    public void clear() {
        this.f1852g = 0;
        this.f1829b = RecyclerView.f7068F0;
    }

    /* renamed from: d */
    public final void m434d(SolverVariable solverVariable) {
        int i;
        int i2 = this.f1852g + 1;
        SolverVariable[] solverVariableArr = this.f1850e;
        if (i2 > solverVariableArr.length) {
            SolverVariable[] solverVariableArr2 = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
            this.f1850e = solverVariableArr2;
            this.f1851f = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
        }
        SolverVariable[] solverVariableArr3 = this.f1850e;
        int i3 = this.f1852g;
        solverVariableArr3[i3] = solverVariable;
        int i4 = i3 + 1;
        this.f1852g = i4;
        if (i4 > 1 && solverVariableArr3[i3].f1863id > solverVariable.f1863id) {
            int i5 = 0;
            while (true) {
                i = this.f1852g;
                if (i5 >= i) {
                    break;
                }
                this.f1851f[i5] = this.f1850e[i5];
                i5++;
            }
            Arrays.sort(this.f1851f, 0, i, new x30(4));
            for (int i6 = 0; i6 < this.f1852g; i6++) {
                this.f1850e[i6] = this.f1851f[i6];
            }
        }
        solverVariable.inGoal = true;
        solverVariable.addToRow(this);
    }

    /* renamed from: e */
    public final void m435e(SolverVariable solverVariable) {
        int i = 0;
        while (i < this.f1852g) {
            if (this.f1850e[i] == solverVariable) {
                while (true) {
                    int i2 = this.f1852g;
                    if (i < i2 - 1) {
                        SolverVariable[] solverVariableArr = this.f1850e;
                        int i3 = i + 1;
                        solverVariableArr[i] = solverVariableArr[i3];
                        i = i3;
                    } else {
                        this.f1852g = i2 - 1;
                        solverVariable.inGoal = false;
                        return;
                    }
                }
            } else {
                i++;
            }
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow, p000.j81
    public SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr) {
        int i = -1;
        for (int i2 = 0; i2 < this.f1852g; i2++) {
            SolverVariable[] solverVariableArr = this.f1850e;
            SolverVariable solverVariable = solverVariableArr[i2];
            if (!zArr[solverVariable.f1863id]) {
                C1540m9 c1540m9 = this.f1853h;
                c1540m9.f22854b = solverVariable;
                int i3 = 8;
                if (i != -1) {
                    SolverVariable solverVariable2 = solverVariableArr[i];
                    c1540m9.getClass();
                    while (true) {
                        if (i3 >= 0) {
                            float f = solverVariable2.f1857d[i3];
                            float f2 = ((SolverVariable) c1540m9.f22854b).f1857d[i3];
                            if (f2 == f) {
                                i3--;
                            } else if (f2 >= f) {
                            }
                        }
                    }
                } else {
                    while (true) {
                        if (i3 >= 0) {
                            float f3 = ((SolverVariable) c1540m9.f22854b).f1857d[i3];
                            if (f3 <= RecyclerView.f7068F0) {
                                if (f3 < RecyclerView.f7068F0) {
                                    break;
                                }
                                i3--;
                            }
                        } else {
                            c1540m9.getClass();
                            break;
                        }
                    }
                    i = i2;
                }
            }
        }
        if (i == -1) {
            return null;
        }
        return this.f1850e[i];
    }

    @Override // androidx.constraintlayout.core.ArrayRow, p000.j81
    public boolean isEmpty() {
        if (this.f1852g == 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.ArrayRow
    public String toString() {
        String str = " goal -> (" + this.f1829b + ") : ";
        for (int i = 0; i < this.f1852g; i++) {
            SolverVariable solverVariable = this.f1850e[i];
            C1540m9 c1540m9 = this.f1853h;
            c1540m9.f22854b = solverVariable;
            str = str + c1540m9 + " ";
        }
        return str;
    }

    @Override // androidx.constraintlayout.core.ArrayRow
    public void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z) {
        SolverVariable solverVariable = arrayRow.f1828a;
        if (solverVariable == null) {
            return;
        }
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.variables;
        int currentSize = arrayRowVariables.getCurrentSize();
        for (int i = 0; i < currentSize; i++) {
            SolverVariable variable = arrayRowVariables.getVariable(i);
            float variableValue = arrayRowVariables.getVariableValue(i);
            C1540m9 c1540m9 = this.f1853h;
            c1540m9.f22854b = variable;
            boolean z2 = variable.inGoal;
            float[] fArr = solverVariable.f1857d;
            if (z2) {
                boolean z3 = true;
                for (int i2 = 0; i2 < 9; i2++) {
                    float[] fArr2 = ((SolverVariable) c1540m9.f22854b).f1857d;
                    float f = (fArr[i2] * variableValue) + fArr2[i2];
                    fArr2[i2] = f;
                    if (Math.abs(f) < 1.0E-4f) {
                        ((SolverVariable) c1540m9.f22854b).f1857d[i2] = 0.0f;
                    } else {
                        z3 = false;
                    }
                }
                if (z3) {
                    ((PriorityGoalRow) c1540m9.f22855c).m435e((SolverVariable) c1540m9.f22854b);
                }
            } else {
                for (int i3 = 0; i3 < 9; i3++) {
                    float f2 = fArr[i3];
                    if (f2 != RecyclerView.f7068F0) {
                        float f3 = f2 * variableValue;
                        if (Math.abs(f3) < 1.0E-4f) {
                            f3 = 0.0f;
                        }
                        ((SolverVariable) c1540m9.f22854b).f1857d[i3] = f3;
                    } else {
                        ((SolverVariable) c1540m9.f22854b).f1857d[i3] = 0.0f;
                    }
                }
                m434d(variable);
            }
            this.f1829b = (arrayRow.f1829b * variableValue) + this.f1829b;
        }
        m435e(solverVariable);
    }
}
