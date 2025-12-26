package androidx.constraintlayout.core.dsl;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* loaded from: classes.dex */
public class KeyCycles extends KeyAttributes {

    /* renamed from: q */
    public Wave f1985q;

    /* renamed from: r */
    public float[] f1986r;

    /* renamed from: s */
    public float[] f1987s;

    /* renamed from: t */
    public float[] f1988t;

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
        public static final /* synthetic */ Wave[] f1989a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.KeyCycles$Wave] */
        /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.KeyCycles$Wave] */
        /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.KeyCycles$Wave] */
        /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.KeyCycles$Wave] */
        /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.KeyCycles$Wave] */
        /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.KeyCycles$Wave] */
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
            f1989a = new Wave[]{r6, r7, r8, r9, r10, r11};
        }

        public static Wave valueOf(String str) {
            return (Wave) Enum.valueOf(Wave.class, str);
        }

        public static Wave[] values() {
            return (Wave[]) f1989a.clone();
        }
    }

    @Override // androidx.constraintlayout.core.dsl.KeyAttributes
    public void attributesToString(StringBuilder sb) {
        super.attributesToString(sb);
        if (this.f1985q != null) {
            sb.append("shape:'");
            sb.append(this.f1985q);
            sb.append("',\n");
        }
        append(sb, TypedValues.CycleType.S_WAVE_PERIOD, this.f1986r);
        append(sb, TypedValues.CycleType.S_WAVE_OFFSET, this.f1987s);
        append(sb, TypedValues.CycleType.S_WAVE_PHASE, this.f1988t);
    }

    public float[] getWaveOffset() {
        return this.f1987s;
    }

    public float[] getWavePeriod() {
        return this.f1986r;
    }

    public float[] getWavePhase() {
        return this.f1988t;
    }

    public Wave getWaveShape() {
        return this.f1985q;
    }

    public void setWaveOffset(float... fArr) {
        this.f1987s = fArr;
    }

    public void setWavePeriod(float... fArr) {
        this.f1986r = fArr;
    }

    public void setWavePhase(float... fArr) {
        this.f1988t = fArr;
    }

    public void setWaveShape(Wave wave) {
        this.f1985q = wave;
    }
}
