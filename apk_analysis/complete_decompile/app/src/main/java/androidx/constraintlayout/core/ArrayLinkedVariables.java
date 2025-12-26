package androidx.constraintlayout.core;

import androidx.constraintlayout.core.ArrayRow;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import p000.AbstractC1726qj;

/* loaded from: classes.dex */
public class ArrayLinkedVariables implements ArrayRow.ArrayRowVariables {

    /* renamed from: b */
    public final ArrayRow f1820b;
    protected final Cache mCache;

    /* renamed from: a */
    public int f1819a = 0;

    /* renamed from: c */
    public int f1821c = 8;

    /* renamed from: d */
    public int[] f1822d = new int[8];

    /* renamed from: e */
    public int[] f1823e = new int[8];

    /* renamed from: f */
    public float[] f1824f = new float[8];

    /* renamed from: g */
    public int f1825g = -1;

    /* renamed from: h */
    public int f1826h = -1;

    /* renamed from: i */
    public boolean f1827i = false;

    public ArrayLinkedVariables(ArrayRow arrayRow, Cache cache) {
        this.f1820b = arrayRow;
        this.mCache = cache;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void add(SolverVariable solverVariable, float f, boolean z) {
        if (f > -0.001f && f < 0.001f) {
            return;
        }
        int i = this.f1825g;
        ArrayRow arrayRow = this.f1820b;
        if (i == -1) {
            this.f1825g = 0;
            this.f1824f[0] = f;
            this.f1822d[0] = solverVariable.f1863id;
            this.f1823e[0] = -1;
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(arrayRow);
            this.f1819a++;
            if (!this.f1827i) {
                int i2 = this.f1826h + 1;
                this.f1826h = i2;
                int[] iArr = this.f1822d;
                if (i2 >= iArr.length) {
                    this.f1827i = true;
                    this.f1826h = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i3 = -1;
        for (int i4 = 0; i != -1 && i4 < this.f1819a; i4++) {
            int i5 = this.f1822d[i];
            int i6 = solverVariable.f1863id;
            if (i5 == i6) {
                float[] fArr = this.f1824f;
                float f2 = fArr[i] + f;
                if (f2 > -0.001f && f2 < 0.001f) {
                    f2 = 0.0f;
                }
                fArr[i] = f2;
                if (f2 == RecyclerView.f7068F0) {
                    if (i == this.f1825g) {
                        this.f1825g = this.f1823e[i];
                    } else {
                        int[] iArr2 = this.f1823e;
                        iArr2[i3] = iArr2[i];
                    }
                    if (z) {
                        solverVariable.removeFromRow(arrayRow);
                    }
                    if (this.f1827i) {
                        this.f1826h = i;
                    }
                    solverVariable.usageInRowCount--;
                    this.f1819a--;
                    return;
                }
                return;
            }
            if (i5 < i6) {
                i3 = i;
            }
            i = this.f1823e[i];
        }
        int i7 = this.f1826h;
        int i8 = i7 + 1;
        if (this.f1827i) {
            int[] iArr3 = this.f1822d;
            if (iArr3[i7] != -1) {
                i7 = iArr3.length;
            }
        } else {
            i7 = i8;
        }
        int[] iArr4 = this.f1822d;
        if (i7 >= iArr4.length && this.f1819a < iArr4.length) {
            int i9 = 0;
            while (true) {
                int[] iArr5 = this.f1822d;
                if (i9 >= iArr5.length) {
                    break;
                }
                if (iArr5[i9] == -1) {
                    i7 = i9;
                    break;
                }
                i9++;
            }
        }
        int[] iArr6 = this.f1822d;
        if (i7 >= iArr6.length) {
            i7 = iArr6.length;
            int i10 = this.f1821c * 2;
            this.f1821c = i10;
            this.f1827i = false;
            this.f1826h = i7 - 1;
            this.f1824f = Arrays.copyOf(this.f1824f, i10);
            this.f1822d = Arrays.copyOf(this.f1822d, this.f1821c);
            this.f1823e = Arrays.copyOf(this.f1823e, this.f1821c);
        }
        this.f1822d[i7] = solverVariable.f1863id;
        this.f1824f[i7] = f;
        if (i3 != -1) {
            int[] iArr7 = this.f1823e;
            iArr7[i7] = iArr7[i3];
            iArr7[i3] = i7;
        } else {
            this.f1823e[i7] = this.f1825g;
            this.f1825g = i7;
        }
        solverVariable.usageInRowCount++;
        solverVariable.addToRow(arrayRow);
        this.f1819a++;
        if (!this.f1827i) {
            this.f1826h++;
        }
        int i11 = this.f1826h;
        int[] iArr8 = this.f1822d;
        if (i11 >= iArr8.length) {
            this.f1827i = true;
            this.f1826h = iArr8.length - 1;
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void clear() {
        int i = this.f1825g;
        for (int i2 = 0; i != -1 && i2 < this.f1819a; i2++) {
            SolverVariable solverVariable = this.mCache.f1835d[this.f1822d[i]];
            if (solverVariable != null) {
                solverVariable.removeFromRow(this.f1820b);
            }
            i = this.f1823e[i];
        }
        this.f1825g = -1;
        this.f1826h = -1;
        this.f1827i = false;
        this.f1819a = 0;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public boolean contains(SolverVariable solverVariable) {
        int i = this.f1825g;
        if (i == -1) {
            return false;
        }
        for (int i2 = 0; i != -1 && i2 < this.f1819a; i2++) {
            if (this.f1822d[i] == solverVariable.f1863id) {
                return true;
            }
            i = this.f1823e[i];
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void display() {
        int i = this.f1819a;
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
        int i = this.f1825g;
        for (int i2 = 0; i != -1 && i2 < this.f1819a; i2++) {
            float[] fArr = this.f1824f;
            fArr[i] = fArr[i] / f;
            i = this.f1823e[i];
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final float get(SolverVariable solverVariable) {
        int i = this.f1825g;
        for (int i2 = 0; i != -1 && i2 < this.f1819a; i2++) {
            if (this.f1822d[i] == solverVariable.f1863id) {
                return this.f1824f[i];
            }
            i = this.f1823e[i];
        }
        return RecyclerView.f7068F0;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int getCurrentSize() {
        return this.f1819a;
    }

    public int getHead() {
        return this.f1825g;
    }

    public final int getId(int i) {
        return this.f1822d[i];
    }

    public final int getNextIndice(int i) {
        return this.f1823e[i];
    }

    public final float getValue(int i) {
        return this.f1824f[i];
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public SolverVariable getVariable(int i) {
        int i2 = this.f1825g;
        for (int i3 = 0; i2 != -1 && i3 < this.f1819a; i3++) {
            if (i3 == i) {
                return this.mCache.f1835d[this.f1822d[i2]];
            }
            i2 = this.f1823e[i2];
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float getVariableValue(int i) {
        int i2 = this.f1825g;
        for (int i3 = 0; i2 != -1 && i3 < this.f1819a; i3++) {
            if (i3 == i) {
                return this.f1824f[i2];
            }
            i2 = this.f1823e[i2];
        }
        return RecyclerView.f7068F0;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int indexOf(SolverVariable solverVariable) {
        int i = this.f1825g;
        if (i == -1) {
            return -1;
        }
        for (int i2 = 0; i != -1 && i2 < this.f1819a; i2++) {
            if (this.f1822d[i] == solverVariable.f1863id) {
                return i;
            }
            i = this.f1823e[i];
        }
        return -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void invert() {
        int i = this.f1825g;
        for (int i2 = 0; i != -1 && i2 < this.f1819a; i2++) {
            float[] fArr = this.f1824f;
            fArr[i] = fArr[i] * (-1.0f);
            i = this.f1823e[i];
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void put(SolverVariable solverVariable, float f) {
        if (f == RecyclerView.f7068F0) {
            remove(solverVariable, true);
            return;
        }
        int i = this.f1825g;
        ArrayRow arrayRow = this.f1820b;
        if (i == -1) {
            this.f1825g = 0;
            this.f1824f[0] = f;
            this.f1822d[0] = solverVariable.f1863id;
            this.f1823e[0] = -1;
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(arrayRow);
            this.f1819a++;
            if (!this.f1827i) {
                int i2 = this.f1826h + 1;
                this.f1826h = i2;
                int[] iArr = this.f1822d;
                if (i2 >= iArr.length) {
                    this.f1827i = true;
                    this.f1826h = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i3 = -1;
        for (int i4 = 0; i != -1 && i4 < this.f1819a; i4++) {
            int i5 = this.f1822d[i];
            int i6 = solverVariable.f1863id;
            if (i5 == i6) {
                this.f1824f[i] = f;
                return;
            }
            if (i5 < i6) {
                i3 = i;
            }
            i = this.f1823e[i];
        }
        int i7 = this.f1826h;
        int i8 = i7 + 1;
        if (this.f1827i) {
            int[] iArr2 = this.f1822d;
            if (iArr2[i7] != -1) {
                i7 = iArr2.length;
            }
        } else {
            i7 = i8;
        }
        int[] iArr3 = this.f1822d;
        if (i7 >= iArr3.length && this.f1819a < iArr3.length) {
            int i9 = 0;
            while (true) {
                int[] iArr4 = this.f1822d;
                if (i9 >= iArr4.length) {
                    break;
                }
                if (iArr4[i9] == -1) {
                    i7 = i9;
                    break;
                }
                i9++;
            }
        }
        int[] iArr5 = this.f1822d;
        if (i7 >= iArr5.length) {
            i7 = iArr5.length;
            int i10 = this.f1821c * 2;
            this.f1821c = i10;
            this.f1827i = false;
            this.f1826h = i7 - 1;
            this.f1824f = Arrays.copyOf(this.f1824f, i10);
            this.f1822d = Arrays.copyOf(this.f1822d, this.f1821c);
            this.f1823e = Arrays.copyOf(this.f1823e, this.f1821c);
        }
        this.f1822d[i7] = solverVariable.f1863id;
        this.f1824f[i7] = f;
        if (i3 != -1) {
            int[] iArr6 = this.f1823e;
            iArr6[i7] = iArr6[i3];
            iArr6[i3] = i7;
        } else {
            this.f1823e[i7] = this.f1825g;
            this.f1825g = i7;
        }
        solverVariable.usageInRowCount++;
        solverVariable.addToRow(arrayRow);
        int i11 = this.f1819a + 1;
        this.f1819a = i11;
        if (!this.f1827i) {
            this.f1826h++;
        }
        int[] iArr7 = this.f1822d;
        if (i11 >= iArr7.length) {
            this.f1827i = true;
        }
        if (this.f1826h >= iArr7.length) {
            this.f1827i = true;
            this.f1826h = iArr7.length - 1;
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final float remove(SolverVariable solverVariable, boolean z) {
        int i = this.f1825g;
        if (i == -1) {
            return RecyclerView.f7068F0;
        }
        int i2 = 0;
        int i3 = -1;
        while (i != -1 && i2 < this.f1819a) {
            if (this.f1822d[i] == solverVariable.f1863id) {
                if (i == this.f1825g) {
                    this.f1825g = this.f1823e[i];
                } else {
                    int[] iArr = this.f1823e;
                    iArr[i3] = iArr[i];
                }
                if (z) {
                    solverVariable.removeFromRow(this.f1820b);
                }
                solverVariable.usageInRowCount--;
                this.f1819a--;
                this.f1822d[i] = -1;
                if (this.f1827i) {
                    this.f1826h = i;
                }
                return this.f1824f[i];
            }
            i2++;
            i3 = i;
            i = this.f1823e[i];
        }
        return RecyclerView.f7068F0;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int sizeInBytes() {
        return (this.f1822d.length * 12) + 36;
    }

    public String toString() {
        int i = this.f1825g;
        String str = "";
        for (int i2 = 0; i != -1 && i2 < this.f1819a; i2++) {
            StringBuilder m7064t = AbstractC1726qj.m7064t(AbstractC1726qj.m7057m(str, " -> "));
            m7064t.append(this.f1824f[i]);
            m7064t.append(" : ");
            StringBuilder m7064t2 = AbstractC1726qj.m7064t(m7064t.toString());
            m7064t2.append(this.mCache.f1835d[this.f1822d[i]]);
            str = m7064t2.toString();
            i = this.f1823e[i];
        }
        return str;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float use(ArrayRow arrayRow, boolean z) {
        float f = get(arrayRow.f1828a);
        remove(arrayRow.f1828a, z);
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.variables;
        int currentSize = arrayRowVariables.getCurrentSize();
        for (int i = 0; i < currentSize; i++) {
            SolverVariable variable = arrayRowVariables.getVariable(i);
            add(variable, arrayRowVariables.get(variable) * f, z);
        }
        return f;
    }
}
