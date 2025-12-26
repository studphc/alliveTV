package androidx.constraintlayout.core;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import p000.AbstractC1726qj;
import p000.C1582ne;
import p000.ye0;

/* loaded from: classes.dex */
public class LinearSystem {
    public static long ARRAY_ROW_CREATION = 0;
    public static final boolean DEBUG = false;
    public static final boolean FULL_DEBUG = false;
    public static long OPTIMIZED_ARRAY_ROW_CREATION = 0;
    public static boolean OPTIMIZED_ENGINE = false;
    public static boolean SIMPLIFY_SYNONYMS = true;
    public static boolean SKIP_COLUMNS = true;
    public static boolean USE_BASIC_SYNONYMS = true;
    public static boolean USE_DEPENDENCY_ORDERING = false;
    public static boolean USE_SYNONYMS = true;
    public static Metrics sMetrics;

    /* renamed from: c */
    public final PriorityGoalRow f1838c;

    /* renamed from: k */
    public final Cache f1846k;

    /* renamed from: n */
    public ArrayRow f1849n;

    /* renamed from: a */
    public int f1836a = 1000;
    public boolean hasSimpleDefinition = false;

    /* renamed from: b */
    public int f1837b = 0;

    /* renamed from: d */
    public int f1839d = 32;

    /* renamed from: e */
    public int f1840e = 32;
    public boolean graphOptimizer = false;
    public boolean newgraphOptimizer = false;

    /* renamed from: g */
    public boolean[] f1842g = new boolean[32];

    /* renamed from: h */
    public int f1843h = 1;

    /* renamed from: i */
    public int f1844i = 0;

    /* renamed from: j */
    public int f1845j = 32;

    /* renamed from: l */
    public SolverVariable[] f1847l = new SolverVariable[1000];

    /* renamed from: m */
    public int f1848m = 0;

    /* renamed from: f */
    public ArrayRow[] f1841f = new ArrayRow[32];

    public LinearSystem() {
        m433h();
        Cache cache = new Cache();
        this.f1846k = cache;
        this.f1838c = new PriorityGoalRow(cache);
        if (OPTIMIZED_ENGINE) {
            this.f1849n = new C0119a(cache);
        } else {
            this.f1849n = new ArrayRow(cache);
        }
    }

    public static ArrayRow createRowDimensionPercent(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, float f) {
        ArrayRow createRow = linearSystem.createRow();
        createRow.variables.put(solverVariable, -1.0f);
        createRow.variables.put(solverVariable2, f);
        return createRow;
    }

    public static Metrics getMetrics() {
        return sMetrics;
    }

    /* renamed from: a */
    public final SolverVariable m426a(SolverVariable.Type type, String str) {
        SolverVariable solverVariable = (SolverVariable) this.f1846k.f1834c.m6343b();
        if (solverVariable == null) {
            solverVariable = new SolverVariable(type, str);
            solverVariable.setType(type, str);
        } else {
            solverVariable.reset();
            solverVariable.setType(type, str);
        }
        int i = this.f1848m;
        int i2 = this.f1836a;
        if (i >= i2) {
            int i3 = i2 * 2;
            this.f1836a = i3;
            this.f1847l = (SolverVariable[]) Arrays.copyOf(this.f1847l, i3);
        }
        SolverVariable[] solverVariableArr = this.f1847l;
        int i4 = this.f1848m;
        this.f1848m = i4 + 1;
        solverVariableArr[i4] = solverVariable;
        return solverVariable;
    }

    public void addCenterPoint(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f, int i) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
        SolverVariable createObjectVariable = createObjectVariable(constraintWidget.getAnchor(type));
        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
        SolverVariable createObjectVariable2 = createObjectVariable(constraintWidget.getAnchor(type2));
        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.RIGHT;
        SolverVariable createObjectVariable3 = createObjectVariable(constraintWidget.getAnchor(type3));
        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
        SolverVariable createObjectVariable4 = createObjectVariable(constraintWidget.getAnchor(type4));
        SolverVariable createObjectVariable5 = createObjectVariable(constraintWidget2.getAnchor(type));
        SolverVariable createObjectVariable6 = createObjectVariable(constraintWidget2.getAnchor(type2));
        SolverVariable createObjectVariable7 = createObjectVariable(constraintWidget2.getAnchor(type3));
        SolverVariable createObjectVariable8 = createObjectVariable(constraintWidget2.getAnchor(type4));
        ArrayRow createRow = createRow();
        double d = f;
        double d2 = i;
        createRow.createRowWithAngle(createObjectVariable2, createObjectVariable4, createObjectVariable6, createObjectVariable8, (float) (Math.sin(d) * d2));
        addConstraint(createRow);
        ArrayRow createRow2 = createRow();
        createRow2.createRowWithAngle(createObjectVariable, createObjectVariable3, createObjectVariable5, createObjectVariable7, (float) (Math.cos(d) * d2));
        addConstraint(createRow2);
    }

    public void addCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2, int i3) {
        ArrayRow createRow = createRow();
        if (solverVariable2 == solverVariable3) {
            createRow.variables.put(solverVariable, 1.0f);
            createRow.variables.put(solverVariable4, 1.0f);
            createRow.variables.put(solverVariable2, -2.0f);
        } else if (f == 0.5f) {
            createRow.variables.put(solverVariable, 1.0f);
            createRow.variables.put(solverVariable2, -1.0f);
            createRow.variables.put(solverVariable3, -1.0f);
            createRow.variables.put(solverVariable4, 1.0f);
            if (i > 0 || i2 > 0) {
                createRow.f1829b = (-i) + i2;
            }
        } else if (f <= RecyclerView.f7068F0) {
            createRow.variables.put(solverVariable, -1.0f);
            createRow.variables.put(solverVariable2, 1.0f);
            createRow.f1829b = i;
        } else if (f >= 1.0f) {
            createRow.variables.put(solverVariable4, -1.0f);
            createRow.variables.put(solverVariable3, 1.0f);
            createRow.f1829b = -i2;
        } else {
            float f2 = 1.0f - f;
            createRow.variables.put(solverVariable, f2 * 1.0f);
            createRow.variables.put(solverVariable2, f2 * (-1.0f));
            createRow.variables.put(solverVariable3, (-1.0f) * f);
            createRow.variables.put(solverVariable4, 1.0f * f);
            if (i > 0 || i2 > 0) {
                createRow.f1829b = (i2 * f) + ((-i) * f2);
            }
        }
        if (i3 != 8) {
            createRow.addError(this, i3);
        }
        addConstraint(createRow);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0071, code lost:
    
        if (r6.usageInRowCount <= 1) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0074, code lost:
    
        r12 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007e, code lost:
    
        if (r6.usageInRowCount <= 1) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0093, code lost:
    
        if (r6.usageInRowCount <= 1) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0096, code lost:
    
        r14 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a0, code lost:
    
        if (r6.usageInRowCount <= 1) goto L59;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0132 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0124  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addConstraint(ArrayRow arrayRow) {
        boolean z;
        boolean z2;
        SolverVariable solverVariable;
        SolverVariable pickPivot;
        if (arrayRow == null) {
            return;
        }
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.constraints++;
            if (arrayRow.f1831d) {
                metrics.simpleconstraints++;
            }
        }
        boolean z3 = true;
        if (this.f1844i + 1 >= this.f1845j || this.f1843h + 1 >= this.f1840e) {
            m430e();
        }
        if (!arrayRow.f1831d) {
            arrayRow.updateFromSystem(this);
            if (arrayRow.isEmpty()) {
                return;
            }
            float f = arrayRow.f1829b;
            if (f < RecyclerView.f7068F0) {
                arrayRow.f1829b = f * (-1.0f);
                arrayRow.variables.invert();
            }
            int currentSize = arrayRow.variables.getCurrentSize();
            SolverVariable solverVariable2 = null;
            float f2 = 0.0f;
            float f3 = 0.0f;
            SolverVariable solverVariable3 = null;
            boolean z4 = false;
            boolean z5 = false;
            for (int i = 0; i < currentSize; i++) {
                float variableValue = arrayRow.variables.getVariableValue(i);
                SolverVariable variable = arrayRow.variables.getVariable(i);
                if (variable.f1858e == SolverVariable.Type.UNRESTRICTED) {
                    if (solverVariable2 != null) {
                        if (f2 <= variableValue) {
                            if (!z4) {
                                if (variable.usageInRowCount > 1) {
                                }
                            }
                        }
                        z4 = true;
                    }
                    solverVariable2 = variable;
                    f2 = variableValue;
                } else if (solverVariable2 == null && variableValue < RecyclerView.f7068F0) {
                    if (solverVariable3 != null) {
                        if (f3 <= variableValue) {
                            if (!z5) {
                                if (variable.usageInRowCount > 1) {
                                }
                            }
                        }
                        z5 = true;
                    }
                    solverVariable3 = variable;
                    f3 = variableValue;
                }
            }
            if (solverVariable2 == null) {
                solverVariable2 = solverVariable3;
            }
            if (solverVariable2 == null) {
                z2 = true;
            } else {
                arrayRow.m424b(solverVariable2);
                z2 = false;
            }
            if (arrayRow.variables.getCurrentSize() == 0) {
                arrayRow.f1831d = true;
            }
            if (z2) {
                SolverVariable createExtraVariable = createExtraVariable();
                arrayRow.f1828a = createExtraVariable;
                int i2 = this.f1844i;
                m427b(arrayRow);
                if (this.f1844i == i2 + 1) {
                    this.f1849n.initFromRow(arrayRow);
                    m432g(this.f1849n);
                    if (createExtraVariable.f1855b == -1) {
                        if (arrayRow.f1828a == createExtraVariable && (pickPivot = arrayRow.pickPivot(createExtraVariable)) != null) {
                            Metrics metrics2 = sMetrics;
                            if (metrics2 != null) {
                                metrics2.pivots++;
                            }
                            arrayRow.m424b(pickPivot);
                        }
                        if (!arrayRow.f1831d) {
                            arrayRow.f1828a.updateReferencesWithNewDefinition(this, arrayRow);
                        }
                        boolean z6 = OPTIMIZED_ENGINE;
                        Cache cache = this.f1846k;
                        if (z6) {
                            cache.f1832a.m6345d(arrayRow);
                        } else {
                            cache.f1833b.m6345d(arrayRow);
                        }
                        this.f1844i--;
                    }
                    solverVariable = arrayRow.f1828a;
                    if (solverVariable == null) {
                        if (solverVariable.f1858e == SolverVariable.Type.UNRESTRICTED || arrayRow.f1829b >= RecyclerView.f7068F0) {
                            z = z3;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
            z3 = false;
            solverVariable = arrayRow.f1828a;
            if (solverVariable == null) {
            }
        } else {
            z = false;
        }
        if (!z) {
            m427b(arrayRow);
        }
    }

    public ArrayRow addEquality(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.mSimpleEquations++;
        }
        if (USE_BASIC_SYNONYMS && i2 == 8 && solverVariable2.isFinalValue && solverVariable.f1855b == -1) {
            solverVariable.setFinalValue(this, solverVariable2.computedValue + i);
            return null;
        }
        ArrayRow createRow = createRow();
        createRow.createRowEquals(solverVariable, solverVariable2, i);
        if (i2 != 8) {
            createRow.addError(this, i2);
        }
        addConstraint(createRow);
        return createRow;
    }

    public void addGreaterBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int i, boolean z) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i);
        addConstraint(createRow);
    }

    public void addGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i);
        if (i2 != 8) {
            createRow.variables.put(createErrorVariable(i2, null), (int) (createRow.variables.get(createSlackVariable) * (-1.0f)));
        }
        addConstraint(createRow);
    }

    public void addLowerBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int i, boolean z) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i);
        addConstraint(createRow);
    }

    public void addLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i);
        if (i2 != 8) {
            createRow.variables.put(createErrorVariable(i2, null), (int) (createRow.variables.get(createSlackVariable) * (-1.0f)));
        }
        addConstraint(createRow);
    }

    public void addRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f, int i) {
        ArrayRow createRow = createRow();
        createRow.createRowDimensionRatio(solverVariable, solverVariable2, solverVariable3, solverVariable4, f);
        if (i != 8) {
            createRow.addError(this, i);
        }
        addConstraint(createRow);
    }

    public void addSynonym(SolverVariable solverVariable, SolverVariable solverVariable2, int i) {
        if (solverVariable.f1855b == -1 && i == 0) {
            boolean z = solverVariable2.f1861h;
            Cache cache = this.f1846k;
            if (z) {
                solverVariable2 = cache.f1835d[solverVariable2.f1862i];
            }
            if (solverVariable.f1861h) {
                SolverVariable solverVariable3 = cache.f1835d[solverVariable.f1862i];
                return;
            } else {
                solverVariable.setSynonym(this, solverVariable2, RecyclerView.f7068F0);
                return;
            }
        }
        addEquality(solverVariable, solverVariable2, i, 8);
    }

    /* renamed from: b */
    public final void m427b(ArrayRow arrayRow) {
        int i;
        if (SIMPLIFY_SYNONYMS && arrayRow.f1831d) {
            arrayRow.f1828a.setFinalValue(this, arrayRow.f1829b);
        } else {
            ArrayRow[] arrayRowArr = this.f1841f;
            int i2 = this.f1844i;
            arrayRowArr[i2] = arrayRow;
            SolverVariable solverVariable = arrayRow.f1828a;
            solverVariable.f1855b = i2;
            this.f1844i = i2 + 1;
            solverVariable.updateReferencesWithNewDefinition(this, arrayRow);
        }
        if (SIMPLIFY_SYNONYMS && this.hasSimpleDefinition) {
            int i3 = 0;
            while (i3 < this.f1844i) {
                if (this.f1841f[i3] == null) {
                    System.out.println("WTF");
                }
                ArrayRow arrayRow2 = this.f1841f[i3];
                if (arrayRow2 != null && arrayRow2.f1831d) {
                    arrayRow2.f1828a.setFinalValue(this, arrayRow2.f1829b);
                    boolean z = OPTIMIZED_ENGINE;
                    Cache cache = this.f1846k;
                    if (z) {
                        cache.f1832a.m6345d(arrayRow2);
                    } else {
                        cache.f1833b.m6345d(arrayRow2);
                    }
                    this.f1841f[i3] = null;
                    int i4 = i3 + 1;
                    int i5 = i4;
                    while (true) {
                        i = this.f1844i;
                        if (i4 >= i) {
                            break;
                        }
                        ArrayRow[] arrayRowArr2 = this.f1841f;
                        int i6 = i4 - 1;
                        ArrayRow arrayRow3 = arrayRowArr2[i4];
                        arrayRowArr2[i6] = arrayRow3;
                        SolverVariable solverVariable2 = arrayRow3.f1828a;
                        if (solverVariable2.f1855b == i4) {
                            solverVariable2.f1855b = i6;
                        }
                        i5 = i4;
                        i4++;
                    }
                    if (i5 < i) {
                        this.f1841f[i5] = null;
                    }
                    this.f1844i = i - 1;
                    i3--;
                }
                i3++;
            }
            this.hasSimpleDefinition = false;
        }
    }

    /* renamed from: c */
    public final void m428c() {
        for (int i = 0; i < this.f1844i; i++) {
            ArrayRow arrayRow = this.f1841f[i];
            arrayRow.f1828a.computedValue = arrayRow.f1829b;
        }
    }

    public SolverVariable createErrorVariable(int i, String str) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.errors++;
        }
        if (this.f1843h + 1 >= this.f1840e) {
            m430e();
        }
        SolverVariable m426a = m426a(SolverVariable.Type.ERROR, str);
        int i2 = this.f1837b + 1;
        this.f1837b = i2;
        this.f1843h++;
        m426a.f1863id = i2;
        m426a.strength = i;
        this.f1846k.f1835d[i2] = m426a;
        this.f1838c.addError(m426a);
        return m426a;
    }

    public SolverVariable createExtraVariable() {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.extravariables++;
        }
        if (this.f1843h + 1 >= this.f1840e) {
            m430e();
        }
        SolverVariable m426a = m426a(SolverVariable.Type.SLACK, null);
        int i = this.f1837b + 1;
        this.f1837b = i;
        this.f1843h++;
        m426a.f1863id = i;
        this.f1846k.f1835d[i] = m426a;
        return m426a;
    }

    public SolverVariable createObjectVariable(Object obj) {
        SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.f1843h + 1 >= this.f1840e) {
            m430e();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariable = constraintAnchor.getSolverVariable();
            Cache cache = this.f1846k;
            if (solverVariable == null) {
                constraintAnchor.resetSolverVariable(cache);
                solverVariable = constraintAnchor.getSolverVariable();
            }
            int i = solverVariable.f1863id;
            if (i == -1 || i > this.f1837b || cache.f1835d[i] == null) {
                if (i != -1) {
                    solverVariable.reset();
                }
                int i2 = this.f1837b + 1;
                this.f1837b = i2;
                this.f1843h++;
                solverVariable.f1863id = i2;
                solverVariable.f1858e = SolverVariable.Type.UNRESTRICTED;
                cache.f1835d[i2] = solverVariable;
            }
        }
        return solverVariable;
    }

    public ArrayRow createRow() {
        boolean z = OPTIMIZED_ENGINE;
        Cache cache = this.f1846k;
        if (z) {
            ArrayRow arrayRow = (ArrayRow) cache.f1832a.m6343b();
            if (arrayRow == null) {
                C0119a c0119a = new C0119a(cache);
                OPTIMIZED_ARRAY_ROW_CREATION++;
                return c0119a;
            }
            arrayRow.reset();
            return arrayRow;
        }
        ArrayRow arrayRow2 = (ArrayRow) cache.f1833b.m6343b();
        if (arrayRow2 == null) {
            ArrayRow arrayRow3 = new ArrayRow(cache);
            ARRAY_ROW_CREATION++;
            return arrayRow3;
        }
        arrayRow2.reset();
        return arrayRow2;
    }

    public SolverVariable createSlackVariable() {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.slackvariables++;
        }
        if (this.f1843h + 1 >= this.f1840e) {
            m430e();
        }
        SolverVariable m426a = m426a(SolverVariable.Type.SLACK, null);
        int i = this.f1837b + 1;
        this.f1837b = i;
        this.f1843h++;
        m426a.f1863id = i;
        this.f1846k.f1835d[i] = m426a;
        return m426a;
    }

    /* renamed from: d */
    public final void m429d() {
        StringBuilder sb = new StringBuilder("Display Rows (");
        sb.append(this.f1844i);
        sb.append("x");
        System.out.println(ye0.m8298r(sb, ")\n", this.f1843h));
    }

    public void displayReadableRows() {
        Cache cache;
        m429d();
        String m8298r = ye0.m8298r(new StringBuilder(" num vars "), "\n", this.f1837b);
        int i = 0;
        while (true) {
            int i2 = this.f1837b + 1;
            cache = this.f1846k;
            if (i >= i2) {
                break;
            }
            SolverVariable solverVariable = cache.f1835d[i];
            if (solverVariable != null && solverVariable.isFinalValue) {
                m8298r = m8298r + " $[" + i + "] => " + solverVariable + " = " + solverVariable.computedValue + "\n";
            }
            i++;
        }
        String m7057m = AbstractC1726qj.m7057m(m8298r, "\n");
        for (int i3 = 0; i3 < this.f1837b + 1; i3++) {
            SolverVariable[] solverVariableArr = cache.f1835d;
            SolverVariable solverVariable2 = solverVariableArr[i3];
            if (solverVariable2 != null && solverVariable2.f1861h) {
                m7057m = m7057m + " ~[" + i3 + "] => " + solverVariable2 + " = " + solverVariableArr[solverVariable2.f1862i] + " + " + solverVariable2.f1864j + "\n";
            }
        }
        String m7057m2 = AbstractC1726qj.m7057m(m7057m, "\n\n #  ");
        for (int i4 = 0; i4 < this.f1844i; i4++) {
            StringBuilder m7064t = AbstractC1726qj.m7064t(m7057m2);
            m7064t.append(this.f1841f[i4].m425c());
            m7057m2 = AbstractC1726qj.m7057m(m7064t.toString(), "\n #  ");
        }
        PriorityGoalRow priorityGoalRow = this.f1838c;
        if (priorityGoalRow != null) {
            m7057m2 = m7057m2 + "Goal: " + priorityGoalRow + "\n";
        }
        System.out.println(m7057m2);
    }

    public void displayVariablesReadableRows() {
        m429d();
        String str = "";
        for (int i = 0; i < this.f1844i; i++) {
            if (this.f1841f[i].f1828a.f1858e == SolverVariable.Type.UNRESTRICTED) {
                StringBuilder m7064t = AbstractC1726qj.m7064t(str);
                m7064t.append(this.f1841f[i].m425c());
                str = AbstractC1726qj.m7057m(m7064t.toString(), "\n");
            }
        }
        StringBuilder m7064t2 = AbstractC1726qj.m7064t(str);
        m7064t2.append(this.f1838c);
        m7064t2.append("\n");
        System.out.println(m7064t2.toString());
    }

    /* renamed from: e */
    public final void m430e() {
        int i = this.f1839d * 2;
        this.f1839d = i;
        this.f1841f = (ArrayRow[]) Arrays.copyOf(this.f1841f, i);
        Cache cache = this.f1846k;
        cache.f1835d = (SolverVariable[]) Arrays.copyOf(cache.f1835d, this.f1839d);
        int i2 = this.f1839d;
        this.f1842g = new boolean[i2];
        this.f1840e = i2;
        this.f1845j = i2;
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.tableSizeIncrease++;
            metrics.maxTableSize = Math.max(metrics.maxTableSize, i2);
            Metrics metrics2 = sMetrics;
            metrics2.lastTableSize = metrics2.maxTableSize;
        }
    }

    /* renamed from: f */
    public final void m431f(PriorityGoalRow priorityGoalRow) {
        Cache cache;
        long j;
        Metrics metrics = sMetrics;
        long j2 = 1;
        if (metrics != null) {
            metrics.minimizeGoal++;
            metrics.maxVariables = Math.max(metrics.maxVariables, this.f1843h);
            Metrics metrics2 = sMetrics;
            metrics2.maxRows = Math.max(metrics2.maxRows, this.f1844i);
        }
        int i = 0;
        while (true) {
            if (i >= this.f1844i) {
                break;
            }
            ArrayRow arrayRow = this.f1841f[i];
            if (arrayRow.f1828a.f1858e != SolverVariable.Type.UNRESTRICTED) {
                float f = arrayRow.f1829b;
                float f2 = RecyclerView.f7068F0;
                if (f < RecyclerView.f7068F0) {
                    boolean z = false;
                    int i2 = 0;
                    while (!z) {
                        Metrics metrics3 = sMetrics;
                        if (metrics3 != null) {
                            metrics3.bfs += j2;
                        }
                        i2++;
                        float f3 = Float.MAX_VALUE;
                        int i3 = 0;
                        int i4 = -1;
                        int i5 = -1;
                        int i6 = 0;
                        while (true) {
                            int i7 = this.f1844i;
                            cache = this.f1846k;
                            if (i3 >= i7) {
                                break;
                            }
                            ArrayRow arrayRow2 = this.f1841f[i3];
                            if (arrayRow2.f1828a.f1858e != SolverVariable.Type.UNRESTRICTED && !arrayRow2.f1831d && arrayRow2.f1829b < f2) {
                                int i8 = 9;
                                if (SKIP_COLUMNS) {
                                    int currentSize = arrayRow2.variables.getCurrentSize();
                                    int i9 = 0;
                                    while (i9 < currentSize) {
                                        SolverVariable variable = arrayRow2.variables.getVariable(i9);
                                        float f4 = arrayRow2.variables.get(variable);
                                        if (f4 > f2) {
                                            int i10 = 0;
                                            while (i10 < i8) {
                                                float f5 = variable.f1856c[i10] / f4;
                                                if ((f5 < f3 && i10 == i6) || i10 > i6) {
                                                    i6 = i10;
                                                    i5 = variable.f1863id;
                                                    i4 = i3;
                                                    f3 = f5;
                                                }
                                                i10++;
                                                i8 = 9;
                                            }
                                        }
                                        i9++;
                                        i8 = 9;
                                    }
                                } else {
                                    int i11 = 1;
                                    while (i11 < this.f1843h) {
                                        SolverVariable solverVariable = cache.f1835d[i11];
                                        float f6 = arrayRow2.variables.get(solverVariable);
                                        if (f6 > f2) {
                                            for (int i12 = 0; i12 < 9; i12++) {
                                                float f7 = solverVariable.f1856c[i12] / f6;
                                                if ((f7 < f3 && i12 == i6) || i12 > i6) {
                                                    i5 = i11;
                                                    f3 = f7;
                                                    i6 = i12;
                                                    i4 = i3;
                                                }
                                            }
                                        }
                                        i11++;
                                        f2 = RecyclerView.f7068F0;
                                    }
                                }
                            }
                            i3++;
                            f2 = RecyclerView.f7068F0;
                        }
                        if (i4 != -1) {
                            ArrayRow arrayRow3 = this.f1841f[i4];
                            arrayRow3.f1828a.f1855b = -1;
                            Metrics metrics4 = sMetrics;
                            if (metrics4 != null) {
                                j = 1;
                                metrics4.pivots++;
                            } else {
                                j = 1;
                            }
                            arrayRow3.m424b(cache.f1835d[i5]);
                            SolverVariable solverVariable2 = arrayRow3.f1828a;
                            solverVariable2.f1855b = i4;
                            solverVariable2.updateReferencesWithNewDefinition(this, arrayRow3);
                        } else {
                            j = 1;
                            z = true;
                        }
                        if (i2 > this.f1843h / 2) {
                            z = true;
                        }
                        j2 = j;
                        f2 = RecyclerView.f7068F0;
                    }
                }
            }
            i++;
            j2 = j2;
        }
        m432g(priorityGoalRow);
        m428c();
    }

    public void fillMetrics(Metrics metrics) {
        sMetrics = metrics;
    }

    /* renamed from: g */
    public final void m432g(ArrayRow arrayRow) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.optimize++;
        }
        for (int i = 0; i < this.f1843h; i++) {
            this.f1842g[i] = false;
        }
        boolean z = false;
        int i2 = 0;
        while (!z) {
            Metrics metrics2 = sMetrics;
            if (metrics2 != null) {
                metrics2.iterations++;
            }
            i2++;
            if (i2 >= this.f1843h * 2) {
                return;
            }
            if (arrayRow.getKey() != null) {
                this.f1842g[arrayRow.getKey().f1863id] = true;
            }
            SolverVariable pivotCandidate = arrayRow.getPivotCandidate(this, this.f1842g);
            if (pivotCandidate != null) {
                boolean[] zArr = this.f1842g;
                int i3 = pivotCandidate.f1863id;
                if (zArr[i3]) {
                    return;
                } else {
                    zArr[i3] = true;
                }
            }
            if (pivotCandidate != null) {
                float f = Float.MAX_VALUE;
                int i4 = -1;
                for (int i5 = 0; i5 < this.f1844i; i5++) {
                    ArrayRow arrayRow2 = this.f1841f[i5];
                    if (arrayRow2.f1828a.f1858e != SolverVariable.Type.UNRESTRICTED && !arrayRow2.f1831d && arrayRow2.variables.contains(pivotCandidate)) {
                        float f2 = arrayRow2.variables.get(pivotCandidate);
                        if (f2 < RecyclerView.f7068F0) {
                            float f3 = (-arrayRow2.f1829b) / f2;
                            if (f3 < f) {
                                i4 = i5;
                                f = f3;
                            }
                        }
                    }
                }
                if (i4 > -1) {
                    ArrayRow arrayRow3 = this.f1841f[i4];
                    arrayRow3.f1828a.f1855b = -1;
                    Metrics metrics3 = sMetrics;
                    if (metrics3 != null) {
                        metrics3.pivots++;
                    }
                    arrayRow3.m424b(pivotCandidate);
                    SolverVariable solverVariable = arrayRow3.f1828a;
                    solverVariable.f1855b = i4;
                    solverVariable.updateReferencesWithNewDefinition(this, arrayRow3);
                }
            } else {
                z = true;
            }
        }
    }

    public Cache getCache() {
        return this.f1846k;
    }

    public int getMemoryUsed() {
        int i;
        int i2 = 0;
        for (int i3 = 0; i3 < this.f1844i; i3++) {
            ArrayRow arrayRow = this.f1841f[i3];
            if (arrayRow != null) {
                if (arrayRow.f1828a != null) {
                    i = 4;
                } else {
                    i = 0;
                }
                i2 += arrayRow.variables.sizeInBytes() + i + 8;
            }
        }
        return i2;
    }

    public int getNumEquations() {
        return this.f1844i;
    }

    public int getNumVariables() {
        return this.f1837b;
    }

    public int getObjectVariableValue(Object obj) {
        SolverVariable solverVariable = ((ConstraintAnchor) obj).getSolverVariable();
        if (solverVariable != null) {
            return (int) (solverVariable.computedValue + 0.5f);
        }
        return 0;
    }

    /* renamed from: h */
    public final void m433h() {
        boolean z = OPTIMIZED_ENGINE;
        Cache cache = this.f1846k;
        int i = 0;
        if (z) {
            while (i < this.f1844i) {
                ArrayRow arrayRow = this.f1841f[i];
                if (arrayRow != null) {
                    cache.f1832a.m6345d(arrayRow);
                }
                this.f1841f[i] = null;
                i++;
            }
            return;
        }
        while (i < this.f1844i) {
            ArrayRow arrayRow2 = this.f1841f[i];
            if (arrayRow2 != null) {
                cache.f1833b.m6345d(arrayRow2);
            }
            this.f1841f[i] = null;
            i++;
        }
    }

    public void minimize() {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.minimize++;
        }
        PriorityGoalRow priorityGoalRow = this.f1838c;
        if (priorityGoalRow.isEmpty()) {
            m428c();
            return;
        }
        if (!this.graphOptimizer && !this.newgraphOptimizer) {
            m431f(priorityGoalRow);
            return;
        }
        Metrics metrics2 = sMetrics;
        if (metrics2 != null) {
            metrics2.graphOptimizer++;
        }
        for (int i = 0; i < this.f1844i; i++) {
            if (!this.f1841f[i].f1831d) {
                m431f(priorityGoalRow);
                return;
            }
        }
        Metrics metrics3 = sMetrics;
        if (metrics3 != null) {
            metrics3.fullySolved++;
        }
        m428c();
    }

    public void removeRow(ArrayRow arrayRow) {
        SolverVariable solverVariable;
        int i;
        if (arrayRow.f1831d && (solverVariable = arrayRow.f1828a) != null) {
            int i2 = solverVariable.f1855b;
            if (i2 != -1) {
                while (true) {
                    i = this.f1844i - 1;
                    if (i2 >= i) {
                        break;
                    }
                    ArrayRow[] arrayRowArr = this.f1841f;
                    int i3 = i2 + 1;
                    ArrayRow arrayRow2 = arrayRowArr[i3];
                    SolverVariable solverVariable2 = arrayRow2.f1828a;
                    if (solverVariable2.f1855b == i3) {
                        solverVariable2.f1855b = i2;
                    }
                    arrayRowArr[i2] = arrayRow2;
                    i2 = i3;
                }
                this.f1844i = i;
            }
            SolverVariable solverVariable3 = arrayRow.f1828a;
            if (!solverVariable3.isFinalValue) {
                solverVariable3.setFinalValue(this, arrayRow.f1829b);
            }
            boolean z = OPTIMIZED_ENGINE;
            Cache cache = this.f1846k;
            if (z) {
                cache.f1832a.m6345d(arrayRow);
            } else {
                cache.f1833b.m6345d(arrayRow);
            }
        }
    }

    public void reset() {
        Cache cache;
        int i = 0;
        while (true) {
            cache = this.f1846k;
            SolverVariable[] solverVariableArr = cache.f1835d;
            if (i >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[i];
            if (solverVariable != null) {
                solverVariable.reset();
            }
            i++;
        }
        C1582ne c1582ne = cache.f1834c;
        SolverVariable[] solverVariableArr2 = this.f1847l;
        int i2 = this.f1848m;
        c1582ne.getClass();
        if (i2 > solverVariableArr2.length) {
            i2 = solverVariableArr2.length;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            SolverVariable solverVariable2 = solverVariableArr2[i3];
            int i4 = c1582ne.f23336a;
            Object[] objArr = (Object[]) c1582ne.f23337b;
            if (i4 < objArr.length) {
                objArr[i4] = solverVariable2;
                c1582ne.f23336a = i4 + 1;
            }
        }
        this.f1848m = 0;
        Arrays.fill(cache.f1835d, (Object) null);
        this.f1837b = 0;
        this.f1838c.clear();
        this.f1843h = 1;
        for (int i5 = 0; i5 < this.f1844i; i5++) {
            ArrayRow arrayRow = this.f1841f[i5];
        }
        m433h();
        this.f1844i = 0;
        if (OPTIMIZED_ENGINE) {
            this.f1849n = new C0119a(cache);
        } else {
            this.f1849n = new ArrayRow(cache);
        }
    }

    public void addEquality(SolverVariable solverVariable, int i) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.mSimpleEquations++;
        }
        if (USE_BASIC_SYNONYMS && solverVariable.f1855b == -1) {
            float f = i;
            solverVariable.setFinalValue(this, f);
            for (int i2 = 0; i2 < this.f1837b + 1; i2++) {
                SolverVariable solverVariable2 = this.f1846k.f1835d[i2];
                if (solverVariable2 != null && solverVariable2.f1861h && solverVariable2.f1862i == solverVariable.f1863id) {
                    solverVariable2.setFinalValue(this, solverVariable2.f1864j + f);
                }
            }
            return;
        }
        int i3 = solverVariable.f1855b;
        if (i3 != -1) {
            ArrayRow arrayRow = this.f1841f[i3];
            if (arrayRow.f1831d) {
                arrayRow.f1829b = i;
                return;
            }
            if (arrayRow.variables.getCurrentSize() == 0) {
                arrayRow.f1831d = true;
                arrayRow.f1829b = i;
                return;
            } else {
                ArrayRow createRow = createRow();
                createRow.createRowEquals(solverVariable, i);
                addConstraint(createRow);
                return;
            }
        }
        ArrayRow createRow2 = createRow();
        createRow2.f1828a = solverVariable;
        float f2 = i;
        solverVariable.computedValue = f2;
        createRow2.f1829b = f2;
        createRow2.f1831d = true;
        addConstraint(createRow2);
    }
}
