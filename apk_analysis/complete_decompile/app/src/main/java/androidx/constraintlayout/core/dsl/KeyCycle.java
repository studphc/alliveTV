package androidx.constraintlayout.core.dsl;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* loaded from: classes.dex */
public class KeyCycle extends KeyAttribute {

    /* renamed from: r */
    public Wave f1980r;

    /* renamed from: s */
    public float f1981s;

    /* renamed from: t */
    public float f1982t;

    /* renamed from: u */
    public float f1983u;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static final class Wave {
        public static final Wave COS;
        public static final Wave REVERSE_SAW;
        public static final Wave SAW;
        public static final Wave SIN;
        public static final Wave SQUARE;
        public static final Wave TRIANGLE;

        /* renamed from: a */
        public static final /* synthetic */ Wave[] f1984a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.KeyCycle$Wave] */
        /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.KeyCycle$Wave] */
        /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.KeyCycle$Wave] */
        /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.KeyCycle$Wave] */
        /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.KeyCycle$Wave] */
        /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.KeyCycle$Wave] */
        static {
            ?? r6 = new Enum("SIN", 0);
            SIN = r6;
            ?? r7 = new Enum("SQUARE", 1);
            SQUARE = r7;
            ?? r8 = new Enum("TRIANGLE", 2);
            TRIANGLE = r8;
            ?? r9 = new Enum("SAW", 3);
            SAW = r9;
            ?? r10 = new Enum("REVERSE_SAW", 4);
            REVERSE_SAW = r10;
            ?? r11 = new Enum("COS", 5);
            COS = r11;
            f1984a = new Wave[]{r6, r7, r8, r9, r10, r11};
        }

        public static Wave valueOf(String str) {
            return (Wave) Enum.valueOf(Wave.class, str);
        }

        public static Wave[] values() {
            return (Wave[]) f1984a.clone();
        }
    }

    @Override // androidx.constraintlayout.core.dsl.KeyAttribute
    public void attributesToString(StringBuilder sb) {
        super.attributesToString(sb);
        if (this.f1980r != null) {
            sb.append("shape:'");
            sb.append(this.f1980r);
            sb.append("',\n");
        }
        append(sb, TypedValues.CycleType.S_WAVE_PERIOD, this.f1981s);
        append(sb, TypedValues.CycleType.S_WAVE_OFFSET, this.f1982t);
        append(sb, TypedValues.CycleType.S_WAVE_PHASE, this.f1983u);
    }

    public float getOffset() {
        return this.f1982t;
    }

    public float getPeriod() {
        return this.f1981s;
    }

    public float getPhase() {
        return this.f1983u;
    }

    public Wave getShape() {
        return this.f1980r;
    }

    public void setOffset(float f) {
        this.f1982t = f;
    }

    public void setPeriod(float f) {
        this.f1981s = f;
    }

    public void setPhase(float f) {
        this.f1983u = f;
    }

    public void setShape(Wave wave) {
        this.f1980r = wave;
    }
}
