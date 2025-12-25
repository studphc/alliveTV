package androidx.constraintlayout.core;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;

/* loaded from: classes.dex */
public class SolverVariable implements Comparable<SolverVariable> {
    public static final int STRENGTH_BARRIER = 6;
    public static final int STRENGTH_CENTERING = 7;
    public static final int STRENGTH_EQUALITY = 5;
    public static final int STRENGTH_FIXED = 8;
    public static final int STRENGTH_HIGH = 3;
    public static final int STRENGTH_HIGHEST = 4;
    public static final int STRENGTH_LOW = 1;
    public static final int STRENGTH_MEDIUM = 2;
    public static final int STRENGTH_NONE = 0;

    /* renamed from: a */
    public String f1854a;

    /* renamed from: b */
    public int f1855b;

    /* renamed from: c */
    public final float[] f1856c;
    public float computedValue;

    /* renamed from: d */
    public final float[] f1857d;

    /* renamed from: e */
    public Type f1858e;

    /* renamed from: f */
    public ArrayRow[] f1859f;

    /* renamed from: g */
    public int f1860g;

    /* renamed from: h */
    public boolean f1861h;

    /* renamed from: i */
    public int f1862i;

    /* renamed from: id */
    public int f1863id;
    public boolean inGoal;
    public boolean isFinalValue;

    /* renamed from: j */
    public float f1864j;
    public int strength;
    public int usageInRowCount;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static final class Type {
        public static final Type CONSTANT;
        public static final Type ERROR;
        public static final Type SLACK;
        public static final Type UNKNOWN;
        public static final Type UNRESTRICTED;

        /* renamed from: a */
        public static final /* synthetic */ Type[] f1865a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0, types: [androidx.constraintlayout.core.SolverVariable$Type, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r6v1, types: [androidx.constraintlayout.core.SolverVariable$Type, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r7v1, types: [androidx.constraintlayout.core.SolverVariable$Type, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r8v1, types: [androidx.constraintlayout.core.SolverVariable$Type, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r9v1, types: [androidx.constraintlayout.core.SolverVariable$Type, java.lang.Enum] */
        static {
            ?? r5 = new Enum("UNRESTRICTED", 0);
            UNRESTRICTED = r5;
            ?? r6 = new Enum("CONSTANT", 1);
            CONSTANT = r6;
            ?? r7 = new Enum("SLACK", 2);
            SLACK = r7;
            ?? r8 = new Enum("ERROR", 3);
            ERROR = r8;
            ?? r9 = new Enum("UNKNOWN", 4);
            UNKNOWN = r9;
            f1865a = new Type[]{r5, r6, r7, r8, r9};
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) f1865a.clone();
        }
    }

    public SolverVariable(String str, Type type) {
        this.f1863id = -1;
        this.f1855b = -1;
        this.strength = 0;
        this.isFinalValue = false;
        this.f1856c = new float[9];
        this.f1857d = new float[9];
        this.f1859f = new ArrayRow[16];
        this.f1860g = 0;
        this.usageInRowCount = 0;
        this.f1861h = false;
        this.f1862i = -1;
        this.f1864j = RecyclerView.f7068F0;
        this.f1854a = str;
        this.f1858e = type;
    }

    public final void addToRow(ArrayRow arrayRow) {
        int i = 0;
        while (true) {
            int i2 = this.f1860g;
            if (i < i2) {
                if (this.f1859f[i] == arrayRow) {
                    return;
                } else {
                    i++;
                }
            } else {
                ArrayRow[] arrayRowArr = this.f1859f;
                if (i2 >= arrayRowArr.length) {
                    this.f1859f = (ArrayRow[]) Arrays.copyOf(arrayRowArr, arrayRowArr.length * 2);
                }
                ArrayRow[] arrayRowArr2 = this.f1859f;
                int i3 = this.f1860g;
                arrayRowArr2[i3] = arrayRow;
                this.f1860g = i3 + 1;
                return;
            }
        }
    }

    public String getName() {
        return this.f1854a;
    }

    public final void removeFromRow(ArrayRow arrayRow) {
        int i = this.f1860g;
        int i2 = 0;
        while (i2 < i) {
            if (this.f1859f[i2] == arrayRow) {
                while (i2 < i - 1) {
                    ArrayRow[] arrayRowArr = this.f1859f;
                    int i3 = i2 + 1;
                    arrayRowArr[i2] = arrayRowArr[i3];
                    i2 = i3;
                }
                this.f1860g--;
                return;
            }
            i2++;
        }
    }

    public void reset() {
        this.f1854a = null;
        this.f1858e = Type.UNKNOWN;
        this.strength = 0;
        this.f1863id = -1;
        this.f1855b = -1;
        this.computedValue = RecyclerView.f7068F0;
        this.isFinalValue = false;
        this.f1861h = false;
        this.f1862i = -1;
        this.f1864j = RecyclerView.f7068F0;
        int i = this.f1860g;
        for (int i2 = 0; i2 < i; i2++) {
            this.f1859f[i2] = null;
        }
        this.f1860g = 0;
        this.usageInRowCount = 0;
        this.inGoal = false;
        Arrays.fill(this.f1857d, RecyclerView.f7068F0);
    }

    public void setFinalValue(LinearSystem linearSystem, float f) {
        this.computedValue = f;
        this.isFinalValue = true;
        this.f1861h = false;
        this.f1862i = -1;
        this.f1864j = RecyclerView.f7068F0;
        int i = this.f1860g;
        this.f1855b = -1;
        for (int i2 = 0; i2 < i; i2++) {
            this.f1859f[i2].updateFromFinalVariable(linearSystem, this, false);
        }
        this.f1860g = 0;
    }

    public void setName(String str) {
        this.f1854a = str;
    }

    public void setSynonym(LinearSystem linearSystem, SolverVariable solverVariable, float f) {
        this.f1861h = true;
        this.f1862i = solverVariable.f1863id;
        this.f1864j = f;
        int i = this.f1860g;
        this.f1855b = -1;
        for (int i2 = 0; i2 < i; i2++) {
            this.f1859f[i2].updateFromSynonymVariable(linearSystem, this, false);
        }
        this.f1860g = 0;
        linearSystem.displayReadableRows();
    }

    public void setType(Type type, String str) {
        this.f1858e = type;
    }

    public String toString() {
        if (this.f1854a != null) {
            return "" + this.f1854a;
        }
        return "" + this.f1863id;
    }

    public final void updateReferencesWithNewDefinition(LinearSystem linearSystem, ArrayRow arrayRow) {
        int i = this.f1860g;
        for (int i2 = 0; i2 < i; i2++) {
            this.f1859f[i2].updateFromRow(linearSystem, arrayRow, false);
        }
        this.f1860g = 0;
    }

    @Override // java.lang.Comparable
    public int compareTo(SolverVariable solverVariable) {
        return this.f1863id - solverVariable.f1863id;
    }

    public SolverVariable(Type type, String str) {
        this.f1863id = -1;
        this.f1855b = -1;
        this.strength = 0;
        this.isFinalValue = false;
        this.f1856c = new float[9];
        this.f1857d = new float[9];
        this.f1859f = new ArrayRow[16];
        this.f1860g = 0;
        this.usageInRowCount = 0;
        this.f1861h = false;
        this.f1862i = -1;
        this.f1864j = RecyclerView.f7068F0;
        this.f1858e = type;
    }
}
