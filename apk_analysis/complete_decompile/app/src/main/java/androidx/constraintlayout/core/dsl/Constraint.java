package androidx.constraintlayout.core.dsl;

import java.util.HashMap;
import p000.AbstractC1726qj;

/* loaded from: classes.dex */
public class Constraint {

    /* renamed from: I */
    public static final HashMap f1887I;

    /* renamed from: A */
    public int f1888A;

    /* renamed from: B */
    public int f1889B;

    /* renamed from: C */
    public float f1890C;

    /* renamed from: D */
    public float f1891D;

    /* renamed from: E */
    public String[] f1892E;

    /* renamed from: F */
    public boolean f1893F;

    /* renamed from: G */
    public boolean f1894G;

    /* renamed from: a */
    public final String f1895a;

    /* renamed from: b */
    public final HAnchor f1896b = new HAnchor(this, HSide.LEFT);

    /* renamed from: c */
    public final HAnchor f1897c = new HAnchor(this, HSide.RIGHT);

    /* renamed from: d */
    public final VAnchor f1898d = new VAnchor(this, VSide.TOP);

    /* renamed from: e */
    public final VAnchor f1899e = new VAnchor(this, VSide.BOTTOM);

    /* renamed from: f */
    public final HAnchor f1900f = new HAnchor(this, HSide.START);

    /* renamed from: g */
    public final HAnchor f1901g = new HAnchor(this, HSide.END);

    /* renamed from: h */
    public final VAnchor f1902h = new VAnchor(this, VSide.BASELINE);

    /* renamed from: i */
    public int f1903i;

    /* renamed from: j */
    public int f1904j;

    /* renamed from: k */
    public float f1905k;

    /* renamed from: l */
    public float f1906l;

    /* renamed from: m */
    public String f1907m;

    /* renamed from: n */
    public String f1908n;

    /* renamed from: o */
    public int f1909o;

    /* renamed from: p */
    public float f1910p;

    /* renamed from: q */
    public int f1911q;

    /* renamed from: r */
    public int f1912r;

    /* renamed from: s */
    public float f1913s;

    /* renamed from: t */
    public float f1914t;

    /* renamed from: u */
    public ChainMode f1915u;

    /* renamed from: v */
    public ChainMode f1916v;

    /* renamed from: w */
    public Behaviour f1917w;

    /* renamed from: x */
    public Behaviour f1918x;

    /* renamed from: y */
    public int f1919y;

    /* renamed from: z */
    public int f1920z;
    public static final Constraint PARENT = new Constraint("parent");

    /* renamed from: H */
    public static final int f1886H = Integer.MIN_VALUE;

    /* loaded from: classes.dex */
    public class Anchor {

        /* renamed from: a */
        public final Side f1921a;

        /* renamed from: c */
        public int f1923c;

        /* renamed from: b */
        public Anchor f1922b = null;

        /* renamed from: d */
        public int f1924d = Integer.MIN_VALUE;

        public Anchor(Side side) {
            this.f1921a = side;
        }

        public void build(StringBuilder sb) {
            if (this.f1922b != null) {
                sb.append(this.f1921a.toString().toLowerCase());
                sb.append(":");
                sb.append(this);
                sb.append(",\n");
            }
        }

        public String getId() {
            return Constraint.this.f1895a;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            if (this.f1922b != null) {
                sb.append("'");
                sb.append(this.f1922b.getId());
                sb.append("','");
                sb.append(this.f1922b.f1921a.toString().toLowerCase());
                sb.append("'");
            }
            if (this.f1923c != 0) {
                sb.append(",");
                sb.append(this.f1923c);
            }
            if (this.f1924d != Integer.MIN_VALUE) {
                if (this.f1923c == 0) {
                    sb.append(",0,");
                    sb.append(this.f1924d);
                } else {
                    sb.append(",");
                    sb.append(this.f1924d);
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static final class Behaviour {
        public static final Behaviour PERCENT;
        public static final Behaviour RATIO;
        public static final Behaviour RESOLVED;
        public static final Behaviour SPREAD;
        public static final Behaviour WRAP;

        /* renamed from: a */
        public static final /* synthetic */ Behaviour[] f1926a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.Constraint$Behaviour] */
        /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.Constraint$Behaviour] */
        /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.Constraint$Behaviour] */
        /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.Constraint$Behaviour] */
        /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.Constraint$Behaviour] */
        static {
            ?? r5 = new Enum("SPREAD", 0);
            SPREAD = r5;
            ?? r6 = new Enum("WRAP", 1);
            WRAP = r6;
            ?? r7 = new Enum("PERCENT", 2);
            PERCENT = r7;
            ?? r8 = new Enum("RATIO", 3);
            RATIO = r8;
            ?? r9 = new Enum("RESOLVED", 4);
            RESOLVED = r9;
            f1926a = new Behaviour[]{r5, r6, r7, r8, r9};
        }

        public static Behaviour valueOf(String str) {
            return (Behaviour) Enum.valueOf(Behaviour.class, str);
        }

        public static Behaviour[] values() {
            return (Behaviour[]) f1926a.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static final class ChainMode {
        public static final ChainMode PACKED;
        public static final ChainMode SPREAD;
        public static final ChainMode SPREAD_INSIDE;

        /* renamed from: a */
        public static final /* synthetic */ ChainMode[] f1927a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.Constraint$ChainMode] */
        /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.Constraint$ChainMode] */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.Constraint$ChainMode] */
        static {
            ?? r3 = new Enum("SPREAD", 0);
            SPREAD = r3;
            ?? r4 = new Enum("SPREAD_INSIDE", 1);
            SPREAD_INSIDE = r4;
            ?? r5 = new Enum("PACKED", 2);
            PACKED = r5;
            f1927a = new ChainMode[]{r3, r4, r5};
        }

        public static ChainMode valueOf(String str) {
            return (ChainMode) Enum.valueOf(ChainMode.class, str);
        }

        public static ChainMode[] values() {
            return (ChainMode[]) f1927a.clone();
        }
    }

    /* loaded from: classes.dex */
    public class HAnchor extends Anchor {
        public HAnchor(Constraint constraint, HSide hSide) {
            super(Side.valueOf(hSide.name()));
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static final class HSide {
        public static final HSide END;
        public static final HSide LEFT;
        public static final HSide RIGHT;
        public static final HSide START;

        /* renamed from: a */
        public static final /* synthetic */ HSide[] f1928a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.Constraint$HSide] */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.Constraint$HSide] */
        /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.Constraint$HSide] */
        /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.Constraint$HSide] */
        static {
            ?? r4 = new Enum("LEFT", 0);
            LEFT = r4;
            ?? r5 = new Enum("RIGHT", 1);
            RIGHT = r5;
            ?? r6 = new Enum("START", 2);
            START = r6;
            ?? r7 = new Enum("END", 3);
            END = r7;
            f1928a = new HSide[]{r4, r5, r6, r7};
        }

        public static HSide valueOf(String str) {
            return (HSide) Enum.valueOf(HSide.class, str);
        }

        public static HSide[] values() {
            return (HSide[]) f1928a.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static final class Side {
        public static final Side BASELINE;
        public static final Side BOTTOM;
        public static final Side END;
        public static final Side LEFT;
        public static final Side RIGHT;
        public static final Side START;
        public static final Side TOP;

        /* renamed from: a */
        public static final /* synthetic */ Side[] f1929a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.Constraint$Side] */
        /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.Constraint$Side] */
        /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.Constraint$Side] */
        /* JADX WARN: Type inference failed for: r13v1, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.Constraint$Side] */
        /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.Constraint$Side] */
        /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.Constraint$Side] */
        /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.Constraint$Side] */
        static {
            ?? r7 = new Enum("LEFT", 0);
            LEFT = r7;
            ?? r8 = new Enum("RIGHT", 1);
            RIGHT = r8;
            ?? r9 = new Enum("TOP", 2);
            TOP = r9;
            ?? r10 = new Enum("BOTTOM", 3);
            BOTTOM = r10;
            ?? r11 = new Enum("START", 4);
            START = r11;
            ?? r12 = new Enum("END", 5);
            END = r12;
            ?? r13 = new Enum("BASELINE", 6);
            BASELINE = r13;
            f1929a = new Side[]{r7, r8, r9, r10, r11, r12, r13};
        }

        public static Side valueOf(String str) {
            return (Side) Enum.valueOf(Side.class, str);
        }

        public static Side[] values() {
            return (Side[]) f1929a.clone();
        }
    }

    /* loaded from: classes.dex */
    public class VAnchor extends Anchor {
        public VAnchor(Constraint constraint, VSide vSide) {
            super(Side.valueOf(vSide.name()));
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static final class VSide {
        public static final VSide BASELINE;
        public static final VSide BOTTOM;
        public static final VSide TOP;

        /* renamed from: a */
        public static final /* synthetic */ VSide[] f1930a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0, types: [androidx.constraintlayout.core.dsl.Constraint$VSide, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r4v1, types: [androidx.constraintlayout.core.dsl.Constraint$VSide, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r5v1, types: [androidx.constraintlayout.core.dsl.Constraint$VSide, java.lang.Enum] */
        static {
            ?? r3 = new Enum("TOP", 0);
            TOP = r3;
            ?? r4 = new Enum("BOTTOM", 1);
            BOTTOM = r4;
            ?? r5 = new Enum("BASELINE", 2);
            BASELINE = r5;
            f1930a = new VSide[]{r3, r4, r5};
        }

        public static VSide valueOf(String str) {
            return (VSide) Enum.valueOf(VSide.class, str);
        }

        public static VSide[] values() {
            return (VSide[]) f1930a.clone();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f1887I = hashMap;
        hashMap.put(ChainMode.SPREAD, "spread");
        hashMap.put(ChainMode.SPREAD_INSIDE, "spread_inside");
        hashMap.put(ChainMode.PACKED, "packed");
    }

    public Constraint(String str) {
        int i = f1886H;
        this.f1903i = i;
        this.f1904j = i;
        this.f1905k = Float.NaN;
        this.f1906l = Float.NaN;
        this.f1907m = null;
        this.f1908n = null;
        this.f1909o = Integer.MIN_VALUE;
        this.f1910p = Float.NaN;
        this.f1911q = Integer.MIN_VALUE;
        this.f1912r = Integer.MIN_VALUE;
        this.f1913s = Float.NaN;
        this.f1914t = Float.NaN;
        this.f1915u = null;
        this.f1916v = null;
        this.f1917w = null;
        this.f1918x = null;
        this.f1919y = i;
        this.f1920z = i;
        this.f1888A = i;
        this.f1889B = i;
        this.f1890C = Float.NaN;
        this.f1891D = Float.NaN;
        this.f1892E = null;
        this.f1893F = false;
        this.f1894G = false;
        this.f1895a = str;
    }

    public void append(StringBuilder sb, String str, float f) {
        if (Float.isNaN(f)) {
            return;
        }
        sb.append(str);
        sb.append(":");
        sb.append(f);
        sb.append(",\n");
    }

    public String convertStringArrayToString(String[] strArr) {
        String str;
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < strArr.length; i++) {
            if (i == 0) {
                str = "'";
            } else {
                str = ",'";
            }
            sb.append(str);
            sb.append(strArr[i]);
            sb.append("'");
        }
        sb.append("]");
        return sb.toString();
    }

    public VAnchor getBaseline() {
        return this.f1902h;
    }

    public VAnchor getBottom() {
        return this.f1899e;
    }

    public float getCircleAngle() {
        return this.f1910p;
    }

    public String getCircleConstraint() {
        return this.f1908n;
    }

    public int getCircleRadius() {
        return this.f1909o;
    }

    public String getDimensionRatio() {
        return this.f1907m;
    }

    public int getEditorAbsoluteX() {
        return this.f1911q;
    }

    public int getEditorAbsoluteY() {
        return this.f1912r;
    }

    public HAnchor getEnd() {
        return this.f1901g;
    }

    public int getHeight() {
        return this.f1904j;
    }

    public Behaviour getHeightDefault() {
        return this.f1918x;
    }

    public int getHeightMax() {
        return this.f1920z;
    }

    public int getHeightMin() {
        return this.f1889B;
    }

    public float getHeightPercent() {
        return this.f1891D;
    }

    public float getHorizontalBias() {
        return this.f1905k;
    }

    public ChainMode getHorizontalChainStyle() {
        return this.f1915u;
    }

    public float getHorizontalWeight() {
        return this.f1914t;
    }

    public HAnchor getLeft() {
        return this.f1896b;
    }

    public String[] getReferenceIds() {
        return this.f1892E;
    }

    public HAnchor getRight() {
        return this.f1897c;
    }

    public HAnchor getStart() {
        return this.f1900f;
    }

    public VAnchor getTop() {
        return this.f1898d;
    }

    public float getVerticalBias() {
        return this.f1906l;
    }

    public ChainMode getVerticalChainStyle() {
        return this.f1916v;
    }

    public float getVerticalWeight() {
        return this.f1913s;
    }

    public int getWidth() {
        return this.f1903i;
    }

    public Behaviour getWidthDefault() {
        return this.f1917w;
    }

    public int getWidthMax() {
        return this.f1919y;
    }

    public int getWidthMin() {
        return this.f1888A;
    }

    public float getWidthPercent() {
        return this.f1890C;
    }

    public boolean isConstrainedHeight() {
        return this.f1894G;
    }

    public boolean isConstrainedWidth() {
        return this.f1893F;
    }

    public void linkToBaseline(VAnchor vAnchor) {
        linkToBaseline(vAnchor, 0);
    }

    public void linkToBottom(VAnchor vAnchor) {
        linkToBottom(vAnchor, 0);
    }

    public void linkToEnd(HAnchor hAnchor) {
        linkToEnd(hAnchor, 0);
    }

    public void linkToLeft(HAnchor hAnchor) {
        linkToLeft(hAnchor, 0);
    }

    public void linkToRight(HAnchor hAnchor) {
        linkToRight(hAnchor, 0);
    }

    public void linkToStart(HAnchor hAnchor) {
        linkToStart(hAnchor, 0);
    }

    public void linkToTop(VAnchor vAnchor) {
        linkToTop(vAnchor, 0);
    }

    public void setCircleAngle(float f) {
        this.f1910p = f;
    }

    public void setCircleConstraint(String str) {
        this.f1908n = str;
    }

    public void setCircleRadius(int i) {
        this.f1909o = i;
    }

    public void setConstrainedHeight(boolean z) {
        this.f1894G = z;
    }

    public void setConstrainedWidth(boolean z) {
        this.f1893F = z;
    }

    public void setDimensionRatio(String str) {
        this.f1907m = str;
    }

    public void setEditorAbsoluteX(int i) {
        this.f1911q = i;
    }

    public void setEditorAbsoluteY(int i) {
        this.f1912r = i;
    }

    public void setHeight(int i) {
        this.f1904j = i;
    }

    public void setHeightDefault(Behaviour behaviour) {
        this.f1918x = behaviour;
    }

    public void setHeightMax(int i) {
        this.f1920z = i;
    }

    public void setHeightMin(int i) {
        this.f1889B = i;
    }

    public void setHeightPercent(float f) {
        this.f1891D = f;
    }

    public void setHorizontalBias(float f) {
        this.f1905k = f;
    }

    public void setHorizontalChainStyle(ChainMode chainMode) {
        this.f1915u = chainMode;
    }

    public void setHorizontalWeight(float f) {
        this.f1914t = f;
    }

    public void setReferenceIds(String[] strArr) {
        this.f1892E = strArr;
    }

    public void setVerticalBias(float f) {
        this.f1906l = f;
    }

    public void setVerticalChainStyle(ChainMode chainMode) {
        this.f1916v = chainMode;
    }

    public void setVerticalWeight(float f) {
        this.f1913s = f;
    }

    public void setWidth(int i) {
        this.f1903i = i;
    }

    public void setWidthDefault(Behaviour behaviour) {
        this.f1917w = behaviour;
    }

    public void setWidthMax(int i) {
        this.f1919y = i;
    }

    public void setWidthMin(int i) {
        this.f1888A = i;
    }

    public void setWidthPercent(float f) {
        this.f1890C = f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(AbstractC1726qj.m7061q(new StringBuilder(), this.f1895a, ":{\n"));
        this.f1896b.build(sb);
        this.f1897c.build(sb);
        this.f1898d.build(sb);
        this.f1899e.build(sb);
        this.f1900f.build(sb);
        this.f1901g.build(sb);
        this.f1902h.build(sb);
        int i = this.f1903i;
        int i2 = f1886H;
        if (i != i2) {
            sb.append("width:");
            sb.append(this.f1903i);
            sb.append(",\n");
        }
        if (this.f1904j != i2) {
            sb.append("height:");
            sb.append(this.f1904j);
            sb.append(",\n");
        }
        append(sb, "horizontalBias", this.f1905k);
        append(sb, "verticalBias", this.f1906l);
        if (this.f1907m != null) {
            sb.append("dimensionRatio:'");
            sb.append(this.f1907m);
            sb.append("',\n");
        }
        if (this.f1908n != null && (!Float.isNaN(this.f1910p) || this.f1909o != Integer.MIN_VALUE)) {
            sb.append("circular:['");
            sb.append(this.f1908n);
            sb.append("'");
            if (!Float.isNaN(this.f1910p)) {
                sb.append(",");
                sb.append(this.f1910p);
            }
            if (this.f1909o != Integer.MIN_VALUE) {
                if (Float.isNaN(this.f1910p)) {
                    sb.append(",0,");
                    sb.append(this.f1909o);
                } else {
                    sb.append(",");
                    sb.append(this.f1909o);
                }
            }
            sb.append("],\n");
        }
        append(sb, "verticalWeight", this.f1913s);
        append(sb, "horizontalWeight", this.f1914t);
        ChainMode chainMode = this.f1915u;
        HashMap hashMap = f1887I;
        if (chainMode != null) {
            sb.append("horizontalChainStyle:'");
            sb.append((String) hashMap.get(this.f1915u));
            sb.append("',\n");
        }
        if (this.f1916v != null) {
            sb.append("verticalChainStyle:'");
            sb.append((String) hashMap.get(this.f1916v));
            sb.append("',\n");
        }
        if (this.f1917w != null) {
            if (this.f1919y == i2 && this.f1888A == i2) {
                sb.append("width:'");
                sb.append(this.f1917w.toString().toLowerCase());
                sb.append("',\n");
            } else {
                sb.append("width:{value:'");
                sb.append(this.f1917w.toString().toLowerCase());
                sb.append("'");
                if (this.f1919y != i2) {
                    sb.append(",max:");
                    sb.append(this.f1919y);
                }
                if (this.f1888A != i2) {
                    sb.append(",min:");
                    sb.append(this.f1888A);
                }
                sb.append("},\n");
            }
        }
        if (this.f1918x != null) {
            if (this.f1920z == i2 && this.f1889B == i2) {
                sb.append("height:'");
                sb.append(this.f1918x.toString().toLowerCase());
                sb.append("',\n");
            } else {
                sb.append("height:{value:'");
                sb.append(this.f1918x.toString().toLowerCase());
                sb.append("'");
                if (this.f1920z != i2) {
                    sb.append(",max:");
                    sb.append(this.f1920z);
                }
                if (this.f1889B != i2) {
                    sb.append(",min:");
                    sb.append(this.f1889B);
                }
                sb.append("},\n");
            }
        }
        if (!Double.isNaN(this.f1890C)) {
            sb.append("width:'");
            sb.append((int) this.f1890C);
            sb.append("%',\n");
        }
        if (!Double.isNaN(this.f1891D)) {
            sb.append("height:'");
            sb.append((int) this.f1891D);
            sb.append("%',\n");
        }
        if (this.f1892E != null) {
            sb.append("referenceIds:");
            sb.append(convertStringArrayToString(this.f1892E));
            sb.append(",\n");
        }
        if (this.f1893F) {
            sb.append("constrainedWidth:");
            sb.append(this.f1893F);
            sb.append(",\n");
        }
        if (this.f1894G) {
            sb.append("constrainedHeight:");
            sb.append(this.f1894G);
            sb.append(",\n");
        }
        sb.append("},\n");
        return sb.toString();
    }

    public void linkToBaseline(VAnchor vAnchor, int i) {
        linkToBaseline(vAnchor, i, Integer.MIN_VALUE);
    }

    public void linkToBottom(VAnchor vAnchor, int i) {
        linkToBottom(vAnchor, i, Integer.MIN_VALUE);
    }

    public void linkToEnd(HAnchor hAnchor, int i) {
        linkToEnd(hAnchor, i, Integer.MIN_VALUE);
    }

    public void linkToLeft(HAnchor hAnchor, int i) {
        linkToLeft(hAnchor, i, Integer.MIN_VALUE);
    }

    public void linkToRight(HAnchor hAnchor, int i) {
        linkToRight(hAnchor, i, Integer.MIN_VALUE);
    }

    public void linkToStart(HAnchor hAnchor, int i) {
        linkToStart(hAnchor, i, Integer.MIN_VALUE);
    }

    public void linkToTop(VAnchor vAnchor, int i) {
        linkToTop(vAnchor, i, Integer.MIN_VALUE);
    }

    public void linkToBaseline(VAnchor vAnchor, int i, int i2) {
        VAnchor vAnchor2 = this.f1902h;
        vAnchor2.f1922b = vAnchor;
        vAnchor2.f1923c = i;
        vAnchor2.f1924d = i2;
    }

    public void linkToBottom(VAnchor vAnchor, int i, int i2) {
        VAnchor vAnchor2 = this.f1899e;
        vAnchor2.f1922b = vAnchor;
        vAnchor2.f1923c = i;
        vAnchor2.f1924d = i2;
    }

    public void linkToEnd(HAnchor hAnchor, int i, int i2) {
        HAnchor hAnchor2 = this.f1901g;
        hAnchor2.f1922b = hAnchor;
        hAnchor2.f1923c = i;
        hAnchor2.f1924d = i2;
    }

    public void linkToLeft(HAnchor hAnchor, int i, int i2) {
        HAnchor hAnchor2 = this.f1896b;
        hAnchor2.f1922b = hAnchor;
        hAnchor2.f1923c = i;
        hAnchor2.f1924d = i2;
    }

    public void linkToRight(HAnchor hAnchor, int i, int i2) {
        HAnchor hAnchor2 = this.f1897c;
        hAnchor2.f1922b = hAnchor;
        hAnchor2.f1923c = i;
        hAnchor2.f1924d = i2;
    }

    public void linkToStart(HAnchor hAnchor, int i, int i2) {
        HAnchor hAnchor2 = this.f1900f;
        hAnchor2.f1922b = hAnchor;
        hAnchor2.f1923c = i;
        hAnchor2.f1924d = i2;
    }

    public void linkToTop(VAnchor vAnchor, int i, int i2) {
        VAnchor vAnchor2 = this.f1898d;
        vAnchor2.f1922b = vAnchor;
        vAnchor2.f1923c = i;
        vAnchor2.f1924d = i2;
    }
}
