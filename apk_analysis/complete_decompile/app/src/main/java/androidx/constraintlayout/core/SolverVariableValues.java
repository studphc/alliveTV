package androidx.constraintlayout.core;

import androidx.constraintlayout.core.ArrayRow;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import java.util.Arrays;
import p000.AbstractC1726qj;

/* loaded from: classes.dex */
public class SolverVariableValues implements ArrayRow.ArrayRowVariables {

    /* renamed from: a */
    public int f1866a = 16;

    /* renamed from: b */
    public final int[] f1867b = new int[16];

    /* renamed from: c */
    public int[] f1868c = new int[16];

    /* renamed from: d */
    public int[] f1869d = new int[16];

    /* renamed from: e */
    public float[] f1870e = new float[16];

    /* renamed from: f */
    public int[] f1871f = new int[16];

    /* renamed from: g */
    public int[] f1872g = new int[16];

    /* renamed from: h */
    public int f1873h = 0;

    /* renamed from: i */
    public int f1874i = -1;

    /* renamed from: j */
    public final C0119a f1875j;
    protected final Cache mCache;

    public SolverVariableValues(C0119a c0119a, Cache cache) {
        this.f1875j = c0119a;
        this.mCache = cache;
        clear();
    }

    /* renamed from: a */
    public final void m436a(SolverVariable solverVariable, int i) {
        int[] iArr;
        int i2 = solverVariable.f1863id % 16;
        int[] iArr2 = this.f1867b;
        int i3 = iArr2[i2];
        if (i3 == -1) {
            iArr2[i2] = i;
        } else {
            while (true) {
                iArr = this.f1868c;
                int i4 = iArr[i3];
                if (i4 == -1) {
                    break;
                } else {
                    i3 = i4;
                }
            }
            iArr[i3] = i;
        }
        this.f1868c[i] = -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void add(SolverVariable solverVariable, float f, boolean z) {
        if (f > -0.001f && f < 0.001f) {
            return;
        }
        int indexOf = indexOf(solverVariable);
        if (indexOf == -1) {
            put(solverVariable, f);
            return;
        }
        float[] fArr = this.f1870e;
        float f2 = fArr[indexOf] + f;
        fArr[indexOf] = f2;
        if (f2 > -0.001f && f2 < 0.001f) {
            fArr[indexOf] = 0.0f;
            remove(solverVariable, z);
        }
    }

    /* renamed from: b */
    public final void m437b(int i, SolverVariable solverVariable, float f) {
        this.f1869d[i] = solverVariable.f1863id;
        this.f1870e[i] = f;
        this.f1871f[i] = -1;
        this.f1872g[i] = -1;
        solverVariable.addToRow(this.f1875j);
        solverVariable.usageInRowCount++;
        this.f1873h++;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void clear() {
        int i = this.f1873h;
        for (int i2 = 0; i2 < i; i2++) {
            SolverVariable variable = getVariable(i2);
            if (variable != null) {
                variable.removeFromRow(this.f1875j);
            }
        }
        for (int i3 = 0; i3 < this.f1866a; i3++) {
            this.f1869d[i3] = -1;
            this.f1868c[i3] = -1;
        }
        for (int i4 = 0; i4 < 16; i4++) {
            this.f1867b[i4] = -1;
        }
        this.f1873h = 0;
        this.f1874i = -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public boolean contains(SolverVariable solverVariable) {
        if (indexOf(solverVariable) != -1) {
            return true;
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void display() {
        int i = this.f1873h;
        System.out.print("{ ");
        for (int i2 = 0; i2 < i; i2++) {
            SolverVariable variable = getVariable(i2);
            if (variable != null) {
                System.out.print(variable + " = " + getVariableValue(i2) + " ");
            }
        }
        System.out.println(" }");
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void divideByAmount(float f) {
        int i = this.f1873h;
        int i2 = this.f1874i;
        for (int i3 = 0; i3 < i; i3++) {
            float[] fArr = this.f1870e;
            fArr[i2] = fArr[i2] / f;
            i2 = this.f1872g[i2];
            if (i2 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float get(SolverVariable solverVariable) {
        int indexOf = indexOf(solverVariable);
        if (indexOf != -1) {
            return this.f1870e[indexOf];
        }
        return RecyclerView.f7068F0;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int getCurrentSize() {
        return this.f1873h;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public SolverVariable getVariable(int i) {
        int i2 = this.f1873h;
        if (i2 == 0) {
            return null;
        }
        int i3 = this.f1874i;
        for (int i4 = 0; i4 < i2; i4++) {
            if (i4 == i && i3 != -1) {
                return this.mCache.f1835d[this.f1869d[i3]];
            }
            i3 = this.f1872g[i3];
            if (i3 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float getVariableValue(int i) {
        int i2 = this.f1873h;
        int i3 = this.f1874i;
        for (int i4 = 0; i4 < i2; i4++) {
            if (i4 == i) {
                return this.f1870e[i3];
            }
            i3 = this.f1872g[i3];
            if (i3 == -1) {
                return RecyclerView.f7068F0;
            }
        }
        return RecyclerView.f7068F0;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int indexOf(SolverVariable solverVariable) {
        if (this.f1873h != 0 && solverVariable != null) {
            int i = solverVariable.f1863id;
            int i2 = this.f1867b[i % 16];
            if (i2 == -1) {
                return -1;
            }
            if (this.f1869d[i2] == i) {
                return i2;
            }
            do {
                i2 = this.f1868c[i2];
                if (i2 == -1) {
                    break;
                }
            } while (this.f1869d[i2] != i);
            if (i2 != -1 && this.f1869d[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void invert() {
        int i = this.f1873h;
        int i2 = this.f1874i;
        for (int i3 = 0; i3 < i; i3++) {
            float[] fArr = this.f1870e;
            fArr[i2] = fArr[i2] * (-1.0f);
            i2 = this.f1872g[i2];
            if (i2 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void put(SolverVariable solverVariable, float f) {
        if (f > -0.001f && f < 0.001f) {
            remove(solverVariable, true);
            return;
        }
        int i = 0;
        if (this.f1873h == 0) {
            m437b(0, solverVariable, f);
            m436a(solverVariable, 0);
            this.f1874i = 0;
            return;
        }
        int indexOf = indexOf(solverVariable);
        if (indexOf != -1) {
            this.f1870e[indexOf] = f;
            return;
        }
        int i2 = this.f1873h + 1;
        int i3 = this.f1866a;
        if (i2 >= i3) {
            int i4 = i3 * 2;
            this.f1869d = Arrays.copyOf(this.f1869d, i4);
            this.f1870e = Arrays.copyOf(this.f1870e, i4);
            this.f1871f = Arrays.copyOf(this.f1871f, i4);
            this.f1872g = Arrays.copyOf(this.f1872g, i4);
            this.f1868c = Arrays.copyOf(this.f1868c, i4);
            for (int i5 = this.f1866a; i5 < i4; i5++) {
                this.f1869d[i5] = -1;
                this.f1868c[i5] = -1;
            }
            this.f1866a = i4;
        }
        int i6 = this.f1873h;
        int i7 = this.f1874i;
        int i8 = -1;
        for (int i9 = 0; i9 < i6; i9++) {
            int i10 = this.f1869d[i7];
            int i11 = solverVariable.f1863id;
            if (i10 == i11) {
                this.f1870e[i7] = f;
                return;
            }
            if (i10 < i11) {
                i8 = i7;
            }
            i7 = this.f1872g[i7];
            if (i7 == -1) {
                break;
            }
        }
        while (true) {
            if (i < this.f1866a) {
                if (this.f1869d[i] == -1) {
                    break;
                } else {
                    i++;
                }
            } else {
                i = -1;
                break;
            }
        }
        m437b(i, solverVariable, f);
        if (i8 != -1) {
            this.f1871f[i] = i8;
            int[] iArr = this.f1872g;
            iArr[i] = iArr[i8];
            iArr[i8] = i;
        } else {
            this.f1871f[i] = -1;
            if (this.f1873h > 0) {
                this.f1872g[i] = this.f1874i;
                this.f1874i = i;
            } else {
                this.f1872g[i] = -1;
            }
        }
        int i12 = this.f1872g[i];
        if (i12 != -1) {
            this.f1871f[i12] = i;
        }
        m436a(solverVariable, i);
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float remove(SolverVariable solverVariable, boolean z) {
        int[] iArr;
        int i;
        int indexOf = indexOf(solverVariable);
        if (indexOf == -1) {
            return RecyclerView.f7068F0;
        }
        int i2 = solverVariable.f1863id;
        int i3 = i2 % 16;
        int[] iArr2 = this.f1867b;
        int i4 = iArr2[i3];
        if (i4 != -1) {
            if (this.f1869d[i4] == i2) {
                int[] iArr3 = this.f1868c;
                iArr2[i3] = iArr3[i4];
                iArr3[i4] = -1;
            } else {
                while (true) {
                    iArr = this.f1868c;
                    i = iArr[i4];
                    if (i == -1 || this.f1869d[i] == i2) {
                        break;
                    }
                    i4 = i;
                }
                if (i != -1 && this.f1869d[i] == i2) {
                    iArr[i4] = iArr[i];
                    iArr[i] = -1;
                }
            }
        }
        float f = this.f1870e[indexOf];
        if (this.f1874i == indexOf) {
            this.f1874i = this.f1872g[indexOf];
        }
        this.f1869d[indexOf] = -1;
        int[] iArr4 = this.f1871f;
        int i5 = iArr4[indexOf];
        if (i5 != -1) {
            int[] iArr5 = this.f1872g;
            iArr5[i5] = iArr5[indexOf];
        }
        int i6 = this.f1872g[indexOf];
        if (i6 != -1) {
            iArr4[i6] = iArr4[indexOf];
        }
        this.f1873h--;
        solverVariable.usageInRowCount--;
        if (z) {
            solverVariable.removeFromRow(this.f1875j);
        }
        return f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int sizeInBytes() {
        return 0;
    }

    public String toString() {
        String m7057m;
        String m7057m2;
        String str = hashCode() + " { ";
        int i = this.f1873h;
        for (int i2 = 0; i2 < i; i2++) {
            SolverVariable variable = getVariable(i2);
            if (variable != null) {
                String str2 = str + variable + " = " + getVariableValue(i2) + " ";
                int indexOf = indexOf(variable);
                String m7057m3 = AbstractC1726qj.m7057m(str2, "[p: ");
                if (this.f1871f[indexOf] != -1) {
                    StringBuilder m7064t = AbstractC1726qj.m7064t(m7057m3);
                    m7064t.append(this.mCache.f1835d[this.f1869d[this.f1871f[indexOf]]]);
                    m7057m = m7064t.toString();
                } else {
                    m7057m = AbstractC1726qj.m7057m(m7057m3, SchedulerSupport.NONE);
                }
                String m7057m4 = AbstractC1726qj.m7057m(m7057m, ", n: ");
                if (this.f1872g[indexOf] != -1) {
                    StringBuilder m7064t2 = AbstractC1726qj.m7064t(m7057m4);
                    m7064t2.append(this.mCache.f1835d[this.f1869d[this.f1872g[indexOf]]]);
                    m7057m2 = m7064t2.toString();
                } else {
                    m7057m2 = AbstractC1726qj.m7057m(m7057m4, SchedulerSupport.NONE);
                }
                str = AbstractC1726qj.m7057m(m7057m2, "]");
            }
        }
        return AbstractC1726qj.m7057m(str, " }");
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float use(ArrayRow arrayRow, boolean z) {
        float f = get(arrayRow.f1828a);
        remove(arrayRow.f1828a, z);
        SolverVariableValues solverVariableValues = (SolverVariableValues) arrayRow.variables;
        int currentSize = solverVariableValues.getCurrentSize();
        int i = 0;
        int i2 = 0;
        while (i < currentSize) {
            int i3 = solverVariableValues.f1869d[i2];
            if (i3 != -1) {
                add(this.mCache.f1835d[i3], solverVariableValues.f1870e[i2] * f, z);
                i++;
            }
            i2++;
        }
        return f;
    }
}
