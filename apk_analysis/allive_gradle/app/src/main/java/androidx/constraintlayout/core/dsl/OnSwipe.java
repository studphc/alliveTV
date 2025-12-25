package androidx.constraintlayout.core.dsl;

/* loaded from: classes.dex */
public class OnSwipe {
    public static final int FLAG_DISABLE_POST_SCROLL = 1;
    public static final int FLAG_DISABLE_SCROLL = 2;

    /* renamed from: a */
    public Drag f2011a;

    /* renamed from: b */
    public Side f2012b;

    /* renamed from: c */
    public String f2013c;

    /* renamed from: d */
    public String f2014d;

    /* renamed from: e */
    public TouchUp f2015e;

    /* renamed from: f */
    public String f2016f;

    /* renamed from: g */
    public float f2017g;

    /* renamed from: h */
    public float f2018h;

    /* renamed from: i */
    public float f2019i;

    /* renamed from: j */
    public float f2020j;

    /* renamed from: k */
    public float f2021k;

    /* renamed from: l */
    public float f2022l;

    /* renamed from: m */
    public float f2023m;

    /* renamed from: n */
    public float f2024n;

    /* renamed from: o */
    public Boundary f2025o;

    /* renamed from: p */
    public Mode f2026p;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static final class Boundary {
        public static final Boundary BOUNCE_BOTH;
        public static final Boundary BOUNCE_END;
        public static final Boundary BOUNCE_START;
        public static final Boundary OVERSHOOT;

        /* renamed from: a */
        public static final /* synthetic */ Boundary[] f2027a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.OnSwipe$Boundary] */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.OnSwipe$Boundary] */
        /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.OnSwipe$Boundary] */
        /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.OnSwipe$Boundary] */
        static {
            ?? r4 = new Enum("OVERSHOOT", 0);
            OVERSHOOT = r4;
            ?? r5 = new Enum("BOUNCE_START", 1);
            BOUNCE_START = r5;
            ?? r6 = new Enum("BOUNCE_END", 2);
            BOUNCE_END = r6;
            ?? r7 = new Enum("BOUNCE_BOTH", 3);
            BOUNCE_BOTH = r7;
            f2027a = new Boundary[]{r4, r5, r6, r7};
        }

        public static Boundary valueOf(String str) {
            return (Boundary) Enum.valueOf(Boundary.class, str);
        }

        public static Boundary[] values() {
            return (Boundary[]) f2027a.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static final class Drag {
        public static final Drag ANTICLOCKWISE;
        public static final Drag CLOCKWISE;
        public static final Drag DOWN;
        public static final Drag END;
        public static final Drag LEFT;
        public static final Drag RIGHT;
        public static final Drag START;

        /* renamed from: UP */
        public static final Drag f2028UP;

        /* renamed from: a */
        public static final /* synthetic */ Drag[] f2029a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.OnSwipe$Drag] */
        /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.OnSwipe$Drag] */
        /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.OnSwipe$Drag] */
        /* JADX WARN: Type inference failed for: r13v1, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.OnSwipe$Drag] */
        /* JADX WARN: Type inference failed for: r14v1, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.OnSwipe$Drag] */
        /* JADX WARN: Type inference failed for: r15v1, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.OnSwipe$Drag] */
        /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.OnSwipe$Drag] */
        /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.OnSwipe$Drag] */
        static {
            ?? r8 = new Enum("UP", 0);
            f2028UP = r8;
            ?? r9 = new Enum("DOWN", 1);
            DOWN = r9;
            ?? r10 = new Enum("LEFT", 2);
            LEFT = r10;
            ?? r11 = new Enum("RIGHT", 3);
            RIGHT = r11;
            ?? r12 = new Enum("START", 4);
            START = r12;
            ?? r13 = new Enum("END", 5);
            END = r13;
            ?? r14 = new Enum("CLOCKWISE", 6);
            CLOCKWISE = r14;
            ?? r15 = new Enum("ANTICLOCKWISE", 7);
            ANTICLOCKWISE = r15;
            f2029a = new Drag[]{r8, r9, r10, r11, r12, r13, r14, r15};
        }

        public static Drag valueOf(String str) {
            return (Drag) Enum.valueOf(Drag.class, str);
        }

        public static Drag[] values() {
            return (Drag[]) f2029a.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static final class Mode {
        public static final Mode SPRING;
        public static final Mode VELOCITY;

        /* renamed from: a */
        public static final /* synthetic */ Mode[] f2030a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [androidx.constraintlayout.core.dsl.OnSwipe$Mode, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r3v1, types: [androidx.constraintlayout.core.dsl.OnSwipe$Mode, java.lang.Enum] */
        static {
            ?? r2 = new Enum("VELOCITY", 0);
            VELOCITY = r2;
            ?? r3 = new Enum("SPRING", 1);
            SPRING = r3;
            f2030a = new Mode[]{r2, r3};
        }

        public static Mode valueOf(String str) {
            return (Mode) Enum.valueOf(Mode.class, str);
        }

        public static Mode[] values() {
            return (Mode[]) f2030a.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static final class Side {
        public static final Side BOTTOM;
        public static final Side END;
        public static final Side LEFT;
        public static final Side MIDDLE;
        public static final Side RIGHT;
        public static final Side START;
        public static final Side TOP;

        /* renamed from: a */
        public static final /* synthetic */ Side[] f2031a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v1, types: [androidx.constraintlayout.core.dsl.OnSwipe$Side, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r11v1, types: [androidx.constraintlayout.core.dsl.OnSwipe$Side, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r12v1, types: [androidx.constraintlayout.core.dsl.OnSwipe$Side, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r13v1, types: [androidx.constraintlayout.core.dsl.OnSwipe$Side, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r7v0, types: [androidx.constraintlayout.core.dsl.OnSwipe$Side, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r8v1, types: [androidx.constraintlayout.core.dsl.OnSwipe$Side, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r9v1, types: [androidx.constraintlayout.core.dsl.OnSwipe$Side, java.lang.Enum] */
        static {
            ?? r7 = new Enum("TOP", 0);
            TOP = r7;
            ?? r8 = new Enum("LEFT", 1);
            LEFT = r8;
            ?? r9 = new Enum("RIGHT", 2);
            RIGHT = r9;
            ?? r10 = new Enum("BOTTOM", 3);
            BOTTOM = r10;
            ?? r11 = new Enum("MIDDLE", 4);
            MIDDLE = r11;
            ?? r12 = new Enum("START", 5);
            START = r12;
            ?? r13 = new Enum("END", 6);
            END = r13;
            f2031a = new Side[]{r7, r8, r9, r10, r11, r12, r13};
        }

        public static Side valueOf(String str) {
            return (Side) Enum.valueOf(Side.class, str);
        }

        public static Side[] values() {
            return (Side[]) f2031a.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static final class TouchUp {
        public static final TouchUp AUTOCOMPLETE;
        public static final TouchUp DECELERATE;
        public static final TouchUp DECELERATE_COMPLETE;
        public static final TouchUp NEVER_COMPLETE_END;
        public static final TouchUp NEVER_COMPLETE_START;
        public static final TouchUp STOP;
        public static final TouchUp TO_END;
        public static final TouchUp TO_START;

        /* renamed from: a */
        public static final /* synthetic */ TouchUp[] f2032a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v1, types: [androidx.constraintlayout.core.dsl.OnSwipe$TouchUp, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r11v1, types: [androidx.constraintlayout.core.dsl.OnSwipe$TouchUp, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r12v1, types: [androidx.constraintlayout.core.dsl.OnSwipe$TouchUp, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r13v1, types: [androidx.constraintlayout.core.dsl.OnSwipe$TouchUp, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r14v1, types: [androidx.constraintlayout.core.dsl.OnSwipe$TouchUp, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r15v1, types: [androidx.constraintlayout.core.dsl.OnSwipe$TouchUp, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r8v0, types: [androidx.constraintlayout.core.dsl.OnSwipe$TouchUp, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r9v1, types: [androidx.constraintlayout.core.dsl.OnSwipe$TouchUp, java.lang.Enum] */
        static {
            ?? r8 = new Enum("AUTOCOMPLETE", 0);
            AUTOCOMPLETE = r8;
            ?? r9 = new Enum("TO_START", 1);
            TO_START = r9;
            ?? r10 = new Enum("NEVER_COMPLETE_END", 2);
            NEVER_COMPLETE_END = r10;
            ?? r11 = new Enum("TO_END", 3);
            TO_END = r11;
            ?? r12 = new Enum("STOP", 4);
            STOP = r12;
            ?? r13 = new Enum("DECELERATE", 5);
            DECELERATE = r13;
            ?? r14 = new Enum("DECELERATE_COMPLETE", 6);
            DECELERATE_COMPLETE = r14;
            ?? r15 = new Enum("NEVER_COMPLETE_START", 7);
            NEVER_COMPLETE_START = r15;
            f2032a = new TouchUp[]{r8, r9, r10, r11, r12, r13, r14, r15};
        }

        public static TouchUp valueOf(String str) {
            return (TouchUp) Enum.valueOf(TouchUp.class, str);
        }

        public static TouchUp[] values() {
            return (TouchUp[]) f2032a.clone();
        }
    }

    public OnSwipe() {
        this.f2011a = null;
        this.f2012b = null;
        this.f2013c = null;
        this.f2014d = null;
        this.f2015e = null;
        this.f2016f = null;
        this.f2017g = Float.NaN;
        this.f2018h = Float.NaN;
        this.f2019i = Float.NaN;
        this.f2020j = Float.NaN;
        this.f2021k = Float.NaN;
        this.f2022l = Float.NaN;
        this.f2023m = Float.NaN;
        this.f2024n = Float.NaN;
        this.f2025o = null;
        this.f2026p = null;
    }

    public Mode getAutoCompleteMode() {
        return this.f2026p;
    }

    public Drag getDragDirection() {
        return this.f2011a;
    }

    public float getDragScale() {
        return this.f2019i;
    }

    public float getDragThreshold() {
        return this.f2020j;
    }

    public String getLimitBoundsTo() {
        return this.f2014d;
    }

    public float getMaxAcceleration() {
        return this.f2018h;
    }

    public float getMaxVelocity() {
        return this.f2017g;
    }

    public TouchUp getOnTouchUp() {
        return this.f2015e;
    }

    public String getRotationCenterId() {
        return this.f2016f;
    }

    public Boundary getSpringBoundary() {
        return this.f2025o;
    }

    public float getSpringDamping() {
        return this.f2021k;
    }

    public float getSpringMass() {
        return this.f2022l;
    }

    public float getSpringStiffness() {
        return this.f2023m;
    }

    public float getSpringStopThreshold() {
        return this.f2024n;
    }

    public String getTouchAnchorId() {
        return this.f2013c;
    }

    public Side getTouchAnchorSide() {
        return this.f2012b;
    }

    public void setAutoCompleteMode(Mode mode) {
        this.f2026p = mode;
    }

    public OnSwipe setDragDirection(Drag drag) {
        this.f2011a = drag;
        return this;
    }

    public OnSwipe setDragScale(int i) {
        this.f2019i = i;
        return this;
    }

    public OnSwipe setDragThreshold(int i) {
        this.f2020j = i;
        return this;
    }

    public OnSwipe setLimitBoundsTo(String str) {
        this.f2014d = str;
        return this;
    }

    public OnSwipe setMaxAcceleration(int i) {
        this.f2018h = i;
        return this;
    }

    public OnSwipe setMaxVelocity(int i) {
        this.f2017g = i;
        return this;
    }

    public OnSwipe setOnTouchUp(TouchUp touchUp) {
        this.f2015e = touchUp;
        return this;
    }

    public OnSwipe setRotateCenter(String str) {
        this.f2016f = str;
        return this;
    }

    public OnSwipe setSpringBoundary(Boundary boundary) {
        this.f2025o = boundary;
        return this;
    }

    public OnSwipe setSpringDamping(float f) {
        this.f2021k = f;
        return this;
    }

    public OnSwipe setSpringMass(float f) {
        this.f2022l = f;
        return this;
    }

    public OnSwipe setSpringStiffness(float f) {
        this.f2023m = f;
        return this;
    }

    public OnSwipe setSpringStopThreshold(float f) {
        this.f2024n = f;
        return this;
    }

    public OnSwipe setTouchAnchorId(String str) {
        this.f2013c = str;
        return this;
    }

    public OnSwipe setTouchAnchorSide(Side side) {
        this.f2012b = side;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("OnSwipe:{\n");
        if (this.f2013c != null) {
            sb.append("anchor:'");
            sb.append(this.f2013c);
            sb.append("',\n");
        }
        if (this.f2011a != null) {
            sb.append("direction:'");
            sb.append(this.f2011a.toString().toLowerCase());
            sb.append("',\n");
        }
        if (this.f2012b != null) {
            sb.append("side:'");
            sb.append(this.f2012b.toString().toLowerCase());
            sb.append("',\n");
        }
        if (!Float.isNaN(this.f2019i)) {
            sb.append("scale:'");
            sb.append(this.f2019i);
            sb.append("',\n");
        }
        if (!Float.isNaN(this.f2020j)) {
            sb.append("threshold:'");
            sb.append(this.f2020j);
            sb.append("',\n");
        }
        if (!Float.isNaN(this.f2017g)) {
            sb.append("maxVelocity:'");
            sb.append(this.f2017g);
            sb.append("',\n");
        }
        if (!Float.isNaN(this.f2018h)) {
            sb.append("maxAccel:'");
            sb.append(this.f2018h);
            sb.append("',\n");
        }
        if (this.f2014d != null) {
            sb.append("limitBounds:'");
            sb.append(this.f2014d);
            sb.append("',\n");
        }
        if (this.f2026p != null) {
            sb.append("mode:'");
            sb.append(this.f2026p.toString().toLowerCase());
            sb.append("',\n");
        }
        if (this.f2015e != null) {
            sb.append("touchUp:'");
            sb.append(this.f2015e.toString().toLowerCase());
            sb.append("',\n");
        }
        if (!Float.isNaN(this.f2022l)) {
            sb.append("springMass:'");
            sb.append(this.f2022l);
            sb.append("',\n");
        }
        if (!Float.isNaN(this.f2023m)) {
            sb.append("springStiffness:'");
            sb.append(this.f2023m);
            sb.append("',\n");
        }
        if (!Float.isNaN(this.f2021k)) {
            sb.append("springDamping:'");
            sb.append(this.f2021k);
            sb.append("',\n");
        }
        if (!Float.isNaN(this.f2024n)) {
            sb.append("stopThreshold:'");
            sb.append(this.f2024n);
            sb.append("',\n");
        }
        if (this.f2025o != null) {
            sb.append("springBoundary:'");
            sb.append(this.f2025o);
            sb.append("',\n");
        }
        if (this.f2016f != null) {
            sb.append("around:'");
            sb.append(this.f2016f);
            sb.append("',\n");
        }
        sb.append("},\n");
        return sb.toString();
    }

    public OnSwipe(String str, Side side, Drag drag) {
        this.f2014d = null;
        this.f2015e = null;
        this.f2016f = null;
        this.f2017g = Float.NaN;
        this.f2018h = Float.NaN;
        this.f2019i = Float.NaN;
        this.f2020j = Float.NaN;
        this.f2021k = Float.NaN;
        this.f2022l = Float.NaN;
        this.f2023m = Float.NaN;
        this.f2024n = Float.NaN;
        this.f2025o = null;
        this.f2026p = null;
        this.f2013c = str;
        this.f2012b = side;
        this.f2011a = drag;
    }
}
