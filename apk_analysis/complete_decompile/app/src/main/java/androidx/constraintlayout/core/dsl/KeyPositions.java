package androidx.constraintlayout.core.dsl;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Arrays;
import p000.AbstractC1726qj;

/* loaded from: classes.dex */
public class KeyPositions extends Keys {

    /* renamed from: a */
    public final String[] f2000a;

    /* renamed from: d */
    public int[] f2003d;

    /* renamed from: b */
    public String f2001b = null;

    /* renamed from: c */
    public Type f2002c = null;

    /* renamed from: e */
    public float[] f2004e = null;

    /* renamed from: f */
    public float[] f2005f = null;

    /* renamed from: g */
    public float[] f2006g = null;

    /* renamed from: h */
    public float[] f2007h = null;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static final class Type {
        public static final Type CARTESIAN;
        public static final Type PATH;
        public static final Type SCREEN;

        /* renamed from: a */
        public static final /* synthetic */ Type[] f2008a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0, types: [androidx.constraintlayout.core.dsl.KeyPositions$Type, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r4v1, types: [androidx.constraintlayout.core.dsl.KeyPositions$Type, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r5v1, types: [androidx.constraintlayout.core.dsl.KeyPositions$Type, java.lang.Enum] */
        static {
            ?? r3 = new Enum("CARTESIAN", 0);
            CARTESIAN = r3;
            ?? r4 = new Enum("SCREEN", 1);
            SCREEN = r4;
            ?? r5 = new Enum("PATH", 2);
            PATH = r5;
            f2008a = new Type[]{r3, r4, r5};
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) f2008a.clone();
        }
    }

    public KeyPositions(int i, String... strArr) {
        this.f2003d = null;
        this.f2000a = strArr;
        this.f2003d = new int[i];
        float length = 100.0f / (r3.length + 1);
        int i2 = 0;
        while (true) {
            int[] iArr = this.f2003d;
            if (i2 < iArr.length) {
                iArr[i2] = (int) ((i2 * length) + length);
                i2++;
            } else {
                return;
            }
        }
    }

    public int[] getFrames() {
        return this.f2003d;
    }

    public float[] getPercentHeight() {
        return this.f2005f;
    }

    public float[] getPercentWidth() {
        return this.f2004e;
    }

    public float[] getPercentX() {
        return this.f2006g;
    }

    public float[] getPercentY() {
        return this.f2007h;
    }

    public Type getPositionType() {
        return this.f2002c;
    }

    public String[] getTarget() {
        return this.f2000a;
    }

    public String getTransitionEasing() {
        return this.f2001b;
    }

    public void setFrames(int... iArr) {
        this.f2003d = iArr;
    }

    public void setPercentHeight(float... fArr) {
        this.f2005f = fArr;
    }

    public void setPercentWidth(float... fArr) {
        this.f2004e = fArr;
    }

    public void setPercentX(float... fArr) {
        this.f2006g = fArr;
    }

    public void setPercentY(float... fArr) {
        this.f2007h = fArr;
    }

    public void setPositionType(Type type) {
        this.f2002c = type;
    }

    public void setTransitionEasing(String str) {
        this.f2001b = str;
    }

    public String toString() {
        StringBuilder m7064t = AbstractC1726qj.m7064t("KeyPositions:{\n");
        append(m7064t, TypedValues.AttributesType.S_TARGET, this.f2000a);
        m7064t.append("frame:");
        m7064t.append(Arrays.toString(this.f2003d));
        m7064t.append(",\n");
        if (this.f2002c != null) {
            m7064t.append("type:'");
            m7064t.append(this.f2002c);
            m7064t.append("',\n");
        }
        append(m7064t, "easing", this.f2001b);
        append(m7064t, "percentX", this.f2006g);
        append(m7064t, "percentX", this.f2007h);
        append(m7064t, "percentWidth", this.f2004e);
        append(m7064t, "percentHeight", this.f2005f);
        m7064t.append("},\n");
        return m7064t.toString();
    }
}
