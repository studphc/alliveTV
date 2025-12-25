package androidx.constraintlayout.core.dsl;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import p000.AbstractC1726qj;

/* loaded from: classes.dex */
public class KeyPosition extends Keys {

    /* renamed from: a */
    public String f1991a;

    /* renamed from: c */
    public int f1993c;

    /* renamed from: b */
    public String f1992b = null;

    /* renamed from: d */
    public float f1994d = Float.NaN;

    /* renamed from: e */
    public float f1995e = Float.NaN;

    /* renamed from: f */
    public float f1996f = Float.NaN;

    /* renamed from: g */
    public float f1997g = Float.NaN;

    /* renamed from: h */
    public Type f1998h = Type.CARTESIAN;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static final class Type {
        public static final Type CARTESIAN;
        public static final Type PATH;
        public static final Type SCREEN;

        /* renamed from: a */
        public static final /* synthetic */ Type[] f1999a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.KeyPosition$Type] */
        /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.KeyPosition$Type] */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.KeyPosition$Type] */
        static {
            ?? r3 = new Enum("CARTESIAN", 0);
            CARTESIAN = r3;
            ?? r4 = new Enum("SCREEN", 1);
            SCREEN = r4;
            ?? r5 = new Enum("PATH", 2);
            PATH = r5;
            f1999a = new Type[]{r3, r4, r5};
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) f1999a.clone();
        }
    }

    public KeyPosition(String str, int i) {
        this.f1991a = null;
        this.f1993c = 0;
        this.f1991a = str;
        this.f1993c = i;
    }

    public int getFrames() {
        return this.f1993c;
    }

    public float getPercentHeight() {
        return this.f1995e;
    }

    public float getPercentWidth() {
        return this.f1994d;
    }

    public float getPercentX() {
        return this.f1996f;
    }

    public float getPercentY() {
        return this.f1997g;
    }

    public Type getPositionType() {
        return this.f1998h;
    }

    public String getTarget() {
        return this.f1991a;
    }

    public String getTransitionEasing() {
        return this.f1992b;
    }

    public void setFrames(int i) {
        this.f1993c = i;
    }

    public void setPercentHeight(float f) {
        this.f1995e = f;
    }

    public void setPercentWidth(float f) {
        this.f1994d = f;
    }

    public void setPercentX(float f) {
        this.f1996f = f;
    }

    public void setPercentY(float f) {
        this.f1997g = f;
    }

    public void setPositionType(Type type) {
        this.f1998h = type;
    }

    public void setTarget(String str) {
        this.f1991a = str;
    }

    public void setTransitionEasing(String str) {
        this.f1992b = str;
    }

    public String toString() {
        StringBuilder m7064t = AbstractC1726qj.m7064t("KeyPositions:{\n");
        append(m7064t, TypedValues.AttributesType.S_TARGET, this.f1991a);
        m7064t.append("frame:");
        m7064t.append(this.f1993c);
        m7064t.append(",\n");
        if (this.f1998h != null) {
            m7064t.append("type:'");
            m7064t.append(this.f1998h);
            m7064t.append("',\n");
        }
        append(m7064t, "easing", this.f1992b);
        append(m7064t, "percentX", this.f1996f);
        append(m7064t, "percentY", this.f1997g);
        append(m7064t, "percentWidth", this.f1994d);
        append(m7064t, "percentHeight", this.f1995e);
        m7064t.append("},\n");
        return m7064t.toString();
    }
}
