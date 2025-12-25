package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* loaded from: classes.dex */
public class Dimension {

    /* renamed from: a */
    public int f2338a;

    /* renamed from: b */
    public int f2339b;

    /* renamed from: c */
    public float f2340c;

    /* renamed from: d */
    public int f2341d;

    /* renamed from: e */
    public String f2342e;

    /* renamed from: f */
    public Object f2343f;

    /* renamed from: g */
    public boolean f2344g;
    public static final Object FIXED_DIMENSION = new String("FIXED_DIMENSION");
    public static final Object WRAP_DIMENSION = new String("WRAP_DIMENSION");
    public static final Object SPREAD_DIMENSION = new String("SPREAD_DIMENSION");
    public static final Object PARENT_DIMENSION = new String("PARENT_DIMENSION");
    public static final Object PERCENT_DIMENSION = new String("PERCENT_DIMENSION");
    public static final Object RATIO_DIMENSION = new String("RATIO_DIMENSION");

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static final class Type {
        public static final Type FIXED;
        public static final Type MATCH_CONSTRAINT;
        public static final Type MATCH_PARENT;
        public static final Type WRAP;

        /* renamed from: a */
        public static final /* synthetic */ Type[] f2345a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [androidx.constraintlayout.core.state.Dimension$Type, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r5v1, types: [androidx.constraintlayout.core.state.Dimension$Type, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r6v1, types: [androidx.constraintlayout.core.state.Dimension$Type, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r7v1, types: [androidx.constraintlayout.core.state.Dimension$Type, java.lang.Enum] */
        static {
            ?? r4 = new Enum("FIXED", 0);
            FIXED = r4;
            ?? r5 = new Enum("WRAP", 1);
            WRAP = r5;
            ?? r6 = new Enum("MATCH_PARENT", 2);
            MATCH_PARENT = r6;
            ?? r7 = new Enum("MATCH_CONSTRAINT", 3);
            MATCH_CONSTRAINT = r7;
            f2345a = new Type[]{r4, r5, r6, r7};
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) f2345a.clone();
        }
    }

    public Dimension() {
        this.f2338a = 0;
        this.f2339b = Integer.MAX_VALUE;
        this.f2340c = 1.0f;
        this.f2341d = 0;
        this.f2342e = null;
        this.f2343f = WRAP_DIMENSION;
        this.f2344g = false;
    }

    public static Dimension createFixed(int i) {
        Dimension dimension = new Dimension(FIXED_DIMENSION);
        dimension.fixed(i);
        return dimension;
    }

    public static Dimension createParent() {
        return new Dimension(PARENT_DIMENSION);
    }

    public static Dimension createPercent(Object obj, float f) {
        Dimension dimension = new Dimension(PERCENT_DIMENSION);
        dimension.percent(obj, f);
        return dimension;
    }

    public static Dimension createRatio(String str) {
        Dimension dimension = new Dimension(RATIO_DIMENSION);
        dimension.ratio(str);
        return dimension;
    }

    public static Dimension createSpread() {
        return new Dimension(SPREAD_DIMENSION);
    }

    public static Dimension createSuggested(int i) {
        Dimension dimension = new Dimension();
        dimension.suggested(i);
        return dimension;
    }

    public static Dimension createWrap() {
        return new Dimension(WRAP_DIMENSION);
    }

    public void apply(State state, ConstraintWidget constraintWidget, int i) {
        String str = this.f2342e;
        if (str != null) {
            constraintWidget.setDimensionRatio(str);
        }
        int i2 = 2;
        if (i == 0) {
            if (this.f2344g) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                Object obj = this.f2343f;
                if (obj == WRAP_DIMENSION) {
                    i2 = 1;
                } else if (obj != PERCENT_DIMENSION) {
                    i2 = 0;
                }
                constraintWidget.setHorizontalMatchStyle(i2, this.f2338a, this.f2339b, this.f2340c);
                return;
            }
            int i3 = this.f2338a;
            if (i3 > 0) {
                constraintWidget.setMinWidth(i3);
            }
            int i4 = this.f2339b;
            if (i4 < Integer.MAX_VALUE) {
                constraintWidget.setMaxWidth(i4);
            }
            Object obj2 = this.f2343f;
            if (obj2 == WRAP_DIMENSION) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                return;
            }
            if (obj2 == PARENT_DIMENSION) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                return;
            } else {
                if (obj2 == null) {
                    constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                    constraintWidget.setWidth(this.f2341d);
                    return;
                }
                return;
            }
        }
        if (this.f2344g) {
            constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
            Object obj3 = this.f2343f;
            if (obj3 == WRAP_DIMENSION) {
                i2 = 1;
            } else if (obj3 != PERCENT_DIMENSION) {
                i2 = 0;
            }
            constraintWidget.setVerticalMatchStyle(i2, this.f2338a, this.f2339b, this.f2340c);
            return;
        }
        int i5 = this.f2338a;
        if (i5 > 0) {
            constraintWidget.setMinHeight(i5);
        }
        int i6 = this.f2339b;
        if (i6 < Integer.MAX_VALUE) {
            constraintWidget.setMaxHeight(i6);
        }
        Object obj4 = this.f2343f;
        if (obj4 == WRAP_DIMENSION) {
            constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            return;
        }
        if (obj4 == PARENT_DIMENSION) {
            constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
        } else if (obj4 == null) {
            constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
            constraintWidget.setHeight(this.f2341d);
        }
    }

    public boolean equalsFixedValue(int i) {
        if (this.f2343f == null && this.f2341d == i) {
            return true;
        }
        return false;
    }

    public Dimension fixed(Object obj) {
        this.f2343f = obj;
        if (obj instanceof Integer) {
            this.f2341d = ((Integer) obj).intValue();
            this.f2343f = null;
        }
        return this;
    }

    public Dimension max(int i) {
        if (this.f2339b >= 0) {
            this.f2339b = i;
        }
        return this;
    }

    public Dimension min(int i) {
        if (i >= 0) {
            this.f2338a = i;
        }
        return this;
    }

    public Dimension percent(Object obj, float f) {
        this.f2340c = f;
        return this;
    }

    public Dimension ratio(String str) {
        this.f2342e = str;
        return this;
    }

    public Dimension suggested(int i) {
        this.f2344g = true;
        if (i >= 0) {
            this.f2339b = i;
        }
        return this;
    }

    public Dimension min(Object obj) {
        if (obj == WRAP_DIMENSION) {
            this.f2338a = -2;
        }
        return this;
    }

    public static Dimension createFixed(Object obj) {
        Dimension dimension = new Dimension(FIXED_DIMENSION);
        dimension.fixed(obj);
        return dimension;
    }

    public static Dimension createSuggested(Object obj) {
        Dimension dimension = new Dimension();
        dimension.suggested(obj);
        return dimension;
    }

    public Dimension max(Object obj) {
        Object obj2 = WRAP_DIMENSION;
        if (obj == obj2 && this.f2344g) {
            this.f2343f = obj2;
            this.f2339b = Integer.MAX_VALUE;
        }
        return this;
    }

    public Dimension suggested(Object obj) {
        this.f2343f = obj;
        this.f2344g = true;
        return this;
    }

    public Dimension fixed(int i) {
        this.f2343f = null;
        this.f2341d = i;
        return this;
    }

    public Dimension(Object obj) {
        this.f2338a = 0;
        this.f2339b = Integer.MAX_VALUE;
        this.f2340c = 1.0f;
        this.f2341d = 0;
        this.f2342e = null;
        this.f2344g = false;
        this.f2343f = obj;
    }
}
