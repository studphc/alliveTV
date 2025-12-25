package androidx.constraintlayout.core;

import androidx.constraintlayout.core.SolverVariable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import p000.AbstractC1726qj;
import p000.j81;

/* loaded from: classes.dex */
public class ArrayRow implements j81 {

    /* renamed from: a */
    public SolverVariable f1828a = null;

    /* renamed from: b */
    public float f1829b = RecyclerView.f7068F0;

    /* renamed from: c */
    public final ArrayList f1830c = new ArrayList();

    /* renamed from: d */
    public boolean f1831d = false;
    public ArrayRowVariables variables;

    /* loaded from: classes.dex */
    public interface ArrayRowVariables {
        void add(SolverVariable solverVariable, float f, boolean z);

        void clear();

        boolean contains(SolverVariable solverVariable);

        void display();

        void divideByAmount(float f);

        float get(SolverVariable solverVariable);

        int getCurrentSize();

        SolverVariable getVariable(int i);

        float getVariableValue(int i);

        int indexOf(SolverVariable solverVariable);

        void invert();

        void put(SolverVariable solverVariable, float f);

        float remove(SolverVariable solverVariable, boolean z);

        int sizeInBytes();

        float use(ArrayRow arrayRow, boolean z);
    }

    public ArrayRow() {
    }

    /* renamed from: a */
    public final SolverVariable m423a(boolean[] zArr, SolverVariable solverVariable) {
        SolverVariable.Type type;
        int currentSize = this.variables.getCurrentSize();
        SolverVariable solverVariable2 = null;
        float f = 0.0f;
        for (int i = 0; i < currentSize; i++) {
            float variableValue = this.variables.getVariableValue(i);
            if (variableValue < RecyclerView.f7068F0) {
                SolverVariable variable = this.variables.getVariable(i);
                if ((zArr == null || !zArr[variable.f1863id]) && variable != solverVariable && (((type = variable.f1858e) == SolverVariable.Type.SLACK || type == SolverVariable.Type.ERROR) && variableValue < f)) {
                    f = variableValue;
                    solverVariable2 = variable;
                }
            }
        }
        return solverVariable2;
    }

    public ArrayRow addError(LinearSystem linearSystem, int i) {
        this.variables.put(linearSystem.createErrorVariable(i, "ep"), 1.0f);
        this.variables.put(linearSystem.createErrorVariable(i, "em"), -1.0f);
        return this;
    }

    /* renamed from: b */
    public final void m424b(SolverVariable solverVariable) {
        SolverVariable solverVariable2 = this.f1828a;
        if (solverVariable2 != null) {
            this.variables.put(solverVariable2, -1.0f);
            this.f1828a.f1855b = -1;
            this.f1828a = null;
        }
        float remove = this.variables.remove(solverVariable, true) * (-1.0f);
        this.f1828a = solverVariable;
        if (remove == 1.0f) {
            return;
        }
        this.f1829b /= remove;
        this.variables.divideByAmount(remove);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0081  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String m425c() {
        String str;
        boolean z;
        if (this.f1828a == null) {
            str = "0";
        } else {
            str = "" + this.f1828a;
        }
        String m7057m = AbstractC1726qj.m7057m(str, " = ");
        if (this.f1829b != RecyclerView.f7068F0) {
            StringBuilder m7064t = AbstractC1726qj.m7064t(m7057m);
            m7064t.append(this.f1829b);
            m7057m = m7064t.toString();
            z = true;
        } else {
            z = false;
        }
        int currentSize = this.variables.getCurrentSize();
        for (int i = 0; i < currentSize; i++) {
            SolverVariable variable = this.variables.getVariable(i);
            if (variable != null) {
                float variableValue = this.variables.getVariableValue(i);
                if (variableValue != RecyclerView.f7068F0) {
                    String solverVariable = variable.toString();
                    if (!z) {
                        if (variableValue < RecyclerView.f7068F0) {
                            m7057m = AbstractC1726qj.m7057m(m7057m, "- ");
                            variableValue *= -1.0f;
                        }
                        if (variableValue == 1.0f) {
                            m7057m = AbstractC1726qj.m7057m(m7057m, solverVariable);
                        } else {
                            m7057m = m7057m + variableValue + " " + solverVariable;
                        }
                        z = true;
                    } else if (variableValue > RecyclerView.f7068F0) {
                        m7057m = AbstractC1726qj.m7057m(m7057m, " + ");
                        if (variableValue == 1.0f) {
                        }
                        z = true;
                    } else {
                        m7057m = AbstractC1726qj.m7057m(m7057m, " - ");
                        variableValue *= -1.0f;
                        if (variableValue == 1.0f) {
                        }
                        z = true;
                    }
                }
            }
        }
        if (!z) {
            return AbstractC1726qj.m7057m(m7057m, "0.0");
        }
        return m7057m;
    }

    @Override // p000.j81
    public void clear() {
        this.variables.clear();
        this.f1828a = null;
        this.f1829b = RecyclerView.f7068F0;
    }

    public ArrayRow createRowDimensionRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f) {
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, 1.0f);
        this.variables.put(solverVariable3, f);
        this.variables.put(solverVariable4, -f);
        return this;
    }

    public ArrayRow createRowEqualDimension(float f, float f2, float f3, SolverVariable solverVariable, int i, SolverVariable solverVariable2, int i2, SolverVariable solverVariable3, int i3, SolverVariable solverVariable4, int i4) {
        if (f2 != RecyclerView.f7068F0 && f != f3) {
            float f4 = (f / f2) / (f3 / f2);
            this.f1829b = (i4 * f4) + (i3 * f4) + ((-i) - i2);
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, f4);
            this.variables.put(solverVariable3, -f4);
        } else {
            this.f1829b = ((-i) - i2) + i3 + i4;
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
        }
        return this;
    }

    public ArrayRow createRowEqualMatchDimensions(float f, float f2, float f3, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4) {
        this.f1829b = RecyclerView.f7068F0;
        if (f2 != RecyclerView.f7068F0 && f != f3) {
            if (f == RecyclerView.f7068F0) {
                this.variables.put(solverVariable, 1.0f);
                this.variables.put(solverVariable2, -1.0f);
            } else if (f3 == RecyclerView.f7068F0) {
                this.variables.put(solverVariable3, 1.0f);
                this.variables.put(solverVariable4, -1.0f);
            } else {
                float f4 = (f / f2) / (f3 / f2);
                this.variables.put(solverVariable, 1.0f);
                this.variables.put(solverVariable2, -1.0f);
                this.variables.put(solverVariable4, f4);
                this.variables.put(solverVariable3, -f4);
            }
        } else {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
        }
        return this;
    }

    public ArrayRow createRowEquals(SolverVariable solverVariable, int i) {
        if (i < 0) {
            this.f1829b = i * (-1);
            this.variables.put(solverVariable, 1.0f);
        } else {
            this.f1829b = i;
            this.variables.put(solverVariable, -1.0f);
        }
        return this;
    }

    public ArrayRow createRowGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f1829b = i;
        }
        if (!z) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.variables.put(solverVariable3, 1.0f);
        } else {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, -1.0f);
        }
        return this;
    }

    public ArrayRow createRowLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f1829b = i;
        }
        if (!z) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
        } else {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, 1.0f);
        }
        return this;
    }

    public ArrayRow createRowWithAngle(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f) {
        this.variables.put(solverVariable3, 0.5f);
        this.variables.put(solverVariable4, 0.5f);
        this.variables.put(solverVariable, -0.5f);
        this.variables.put(solverVariable2, -0.5f);
        this.f1829b = -f;
        return this;
    }

    @Override // p000.j81
    public SolverVariable getKey() {
        return this.f1828a;
    }

    @Override // p000.j81
    public SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr) {
        return m423a(zArr, null);
    }

    @Override // p000.j81
    public void initFromRow(j81 j81Var) {
        if (j81Var instanceof ArrayRow) {
            ArrayRow arrayRow = (ArrayRow) j81Var;
            this.f1828a = null;
            this.variables.clear();
            for (int i = 0; i < arrayRow.variables.getCurrentSize(); i++) {
                this.variables.add(arrayRow.variables.getVariable(i), arrayRow.variables.getVariableValue(i), true);
            }
        }
    }

    @Override // p000.j81
    public boolean isEmpty() {
        if (this.f1828a == null && this.f1829b == RecyclerView.f7068F0 && this.variables.getCurrentSize() == 0) {
            return true;
        }
        return false;
    }

    public SolverVariable pickPivot(SolverVariable solverVariable) {
        return m423a(null, solverVariable);
    }

    public void reset() {
        this.f1828a = null;
        this.variables.clear();
        this.f1829b = RecyclerView.f7068F0;
        this.f1831d = false;
    }

    public String toString() {
        return m425c();
    }

    public void updateFromFinalVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean z) {
        if (solverVariable != null && solverVariable.isFinalValue) {
            float f = this.variables.get(solverVariable);
            this.f1829b = (solverVariable.computedValue * f) + this.f1829b;
            this.variables.remove(solverVariable, z);
            if (z) {
                solverVariable.removeFromRow(this);
            }
            if (LinearSystem.SIMPLIFY_SYNONYMS && this.variables.getCurrentSize() == 0) {
                this.f1831d = true;
                linearSystem.hasSimpleDefinition = true;
            }
        }
    }

    public void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z) {
        float use = this.variables.use(arrayRow, z);
        this.f1829b = (arrayRow.f1829b * use) + this.f1829b;
        if (z) {
            arrayRow.f1828a.removeFromRow(this);
        }
        if (LinearSystem.SIMPLIFY_SYNONYMS && this.f1828a != null && this.variables.getCurrentSize() == 0) {
            this.f1831d = true;
            linearSystem.hasSimpleDefinition = true;
        }
    }

    public void updateFromSynonymVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean z) {
        if (solverVariable != null && solverVariable.f1861h) {
            float f = this.variables.get(solverVariable);
            this.f1829b = (solverVariable.f1864j * f) + this.f1829b;
            this.variables.remove(solverVariable, z);
            if (z) {
                solverVariable.removeFromRow(this);
            }
            this.variables.add(linearSystem.f1846k.f1835d[solverVariable.f1862i], f, z);
            if (LinearSystem.SIMPLIFY_SYNONYMS && this.variables.getCurrentSize() == 0) {
                this.f1831d = true;
                linearSystem.hasSimpleDefinition = true;
            }
        }
    }

    public void updateFromSystem(LinearSystem linearSystem) {
        ArrayList arrayList;
        if (linearSystem.f1841f.length == 0) {
            return;
        }
        boolean z = false;
        while (!z) {
            int currentSize = this.variables.getCurrentSize();
            int i = 0;
            while (true) {
                arrayList = this.f1830c;
                if (i >= currentSize) {
                    break;
                }
                SolverVariable variable = this.variables.getVariable(i);
                if (variable.f1855b != -1 || variable.isFinalValue || variable.f1861h) {
                    arrayList.add(variable);
                }
                i++;
            }
            int size = arrayList.size();
            if (size > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    SolverVariable solverVariable = (SolverVariable) arrayList.get(i2);
                    if (solverVariable.isFinalValue) {
                        updateFromFinalVariable(linearSystem, solverVariable, true);
                    } else if (solverVariable.f1861h) {
                        updateFromSynonymVariable(linearSystem, solverVariable, true);
                    } else {
                        updateFromRow(linearSystem, linearSystem.f1841f[solverVariable.f1855b], true);
                    }
                }
                arrayList.clear();
            } else {
                z = true;
            }
        }
        if (LinearSystem.SIMPLIFY_SYNONYMS && this.f1828a != null && this.variables.getCurrentSize() == 0) {
            this.f1831d = true;
            linearSystem.hasSimpleDefinition = true;
        }
    }

    @Override // p000.j81
    public void addError(SolverVariable solverVariable) {
        int i = solverVariable.strength;
        float f = 1.0f;
        if (i != 1) {
            if (i == 2) {
                f = 1000.0f;
            } else if (i == 3) {
                f = 1000000.0f;
            } else if (i == 4) {
                f = 1.0E9f;
            } else if (i == 5) {
                f = 1.0E12f;
            }
        }
        this.variables.put(solverVariable, f);
    }

    public ArrayRow createRowEquals(SolverVariable solverVariable, SolverVariable solverVariable2, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f1829b = i;
        }
        if (!z) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
        } else {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
        }
        return this;
    }

    public ArrayRow(Cache cache) {
        this.variables = new ArrayLinkedVariables(this, cache);
    }

    public ArrayRow createRowGreaterThan(SolverVariable solverVariable, int i, SolverVariable solverVariable2) {
        this.f1829b = i;
        this.variables.put(solverVariable, -1.0f);
        return this;
    }
}
