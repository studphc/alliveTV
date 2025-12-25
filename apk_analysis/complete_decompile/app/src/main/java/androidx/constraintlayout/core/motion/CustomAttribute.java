package androidx.constraintlayout.core.motion;

import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import p000.AbstractC1726qj;

/* loaded from: classes.dex */
public class CustomAttribute {

    /* renamed from: a */
    public final String f2047a;

    /* renamed from: b */
    public final AttributeType f2048b;

    /* renamed from: c */
    public int f2049c;

    /* renamed from: d */
    public float f2050d;

    /* renamed from: e */
    public boolean f2051e;

    /* renamed from: f */
    public int f2052f;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static final class AttributeType {
        public static final AttributeType BOOLEAN_TYPE;
        public static final AttributeType COLOR_DRAWABLE_TYPE;
        public static final AttributeType COLOR_TYPE;
        public static final AttributeType DIMENSION_TYPE;
        public static final AttributeType FLOAT_TYPE;
        public static final AttributeType INT_TYPE;
        public static final AttributeType REFERENCE_TYPE;
        public static final AttributeType STRING_TYPE;

        /* renamed from: a */
        public static final /* synthetic */ AttributeType[] f2053a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Enum, androidx.constraintlayout.core.motion.CustomAttribute$AttributeType] */
        /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Enum, androidx.constraintlayout.core.motion.CustomAttribute$AttributeType] */
        /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.Enum, androidx.constraintlayout.core.motion.CustomAttribute$AttributeType] */
        /* JADX WARN: Type inference failed for: r13v1, types: [java.lang.Enum, androidx.constraintlayout.core.motion.CustomAttribute$AttributeType] */
        /* JADX WARN: Type inference failed for: r14v1, types: [java.lang.Enum, androidx.constraintlayout.core.motion.CustomAttribute$AttributeType] */
        /* JADX WARN: Type inference failed for: r15v1, types: [java.lang.Enum, androidx.constraintlayout.core.motion.CustomAttribute$AttributeType] */
        /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.Enum, androidx.constraintlayout.core.motion.CustomAttribute$AttributeType] */
        /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Enum, androidx.constraintlayout.core.motion.CustomAttribute$AttributeType] */
        static {
            ?? r8 = new Enum("INT_TYPE", 0);
            INT_TYPE = r8;
            ?? r9 = new Enum("FLOAT_TYPE", 1);
            FLOAT_TYPE = r9;
            ?? r10 = new Enum("COLOR_TYPE", 2);
            COLOR_TYPE = r10;
            ?? r11 = new Enum("COLOR_DRAWABLE_TYPE", 3);
            COLOR_DRAWABLE_TYPE = r11;
            ?? r12 = new Enum("STRING_TYPE", 4);
            STRING_TYPE = r12;
            ?? r13 = new Enum("BOOLEAN_TYPE", 5);
            BOOLEAN_TYPE = r13;
            ?? r14 = new Enum("DIMENSION_TYPE", 6);
            DIMENSION_TYPE = r14;
            ?? r15 = new Enum("REFERENCE_TYPE", 7);
            REFERENCE_TYPE = r15;
            f2053a = new AttributeType[]{r8, r9, r10, r11, r12, r13, r14, r15};
        }

        public static AttributeType valueOf(String str) {
            return (AttributeType) Enum.valueOf(AttributeType.class, str);
        }

        public static AttributeType[] values() {
            return (AttributeType[]) f2053a.clone();
        }
    }

    public CustomAttribute(String str, AttributeType attributeType) {
        this.f2047a = str;
        this.f2048b = attributeType;
    }

    public static int hsvToRgb(float f, float f2, float f3) {
        float f4 = f * 6.0f;
        int i = (int) f4;
        float f5 = f4 - i;
        float f6 = f3 * 255.0f;
        int m7051g = (int) AbstractC1726qj.m7051g(1.0f, f2, f6, 0.5f);
        int i2 = (int) (((1.0f - (f5 * f2)) * f6) + 0.5f);
        int i3 = (int) (((1.0f - ((1.0f - f5) * f2)) * f6) + 0.5f);
        int i4 = (int) (f6 + 0.5f);
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return 0;
                            }
                            return ((i4 << 16) + (m7051g << 8) + i2) | ViewCompat.MEASURED_STATE_MASK;
                        }
                        return ((i3 << 16) + (m7051g << 8) + i4) | ViewCompat.MEASURED_STATE_MASK;
                    }
                    return ((m7051g << 16) + (i2 << 8) + i4) | ViewCompat.MEASURED_STATE_MASK;
                }
                return ((m7051g << 16) + (i4 << 8) + i3) | ViewCompat.MEASURED_STATE_MASK;
            }
            return ((i2 << 16) + (i4 << 8) + m7051g) | ViewCompat.MEASURED_STATE_MASK;
        }
        return ((i4 << 16) + (i3 << 8) + m7051g) | ViewCompat.MEASURED_STATE_MASK;
    }

    public boolean diff(CustomAttribute customAttribute) {
        if (customAttribute == null) {
            return false;
        }
        AttributeType attributeType = customAttribute.f2048b;
        AttributeType attributeType2 = this.f2048b;
        if (attributeType2 != attributeType) {
            return false;
        }
        switch (attributeType2.ordinal()) {
            case 0:
            case 7:
                if (this.f2049c != customAttribute.f2049c) {
                    return false;
                }
                return true;
            case 1:
                if (this.f2050d != customAttribute.f2050d) {
                    return false;
                }
                return true;
            case 2:
            case 3:
                if (this.f2052f != customAttribute.f2052f) {
                    return false;
                }
                return true;
            case 4:
                if (this.f2049c != customAttribute.f2049c) {
                    return false;
                }
                return true;
            case 5:
                if (this.f2051e != customAttribute.f2051e) {
                    return false;
                }
                return true;
            case 6:
                if (this.f2050d != customAttribute.f2050d) {
                    return false;
                }
                return true;
            default:
                return false;
        }
    }

    public AttributeType getType() {
        return this.f2048b;
    }

    public float getValueToInterpolate() {
        switch (this.f2048b.ordinal()) {
            case 0:
                return this.f2049c;
            case 1:
                return this.f2050d;
            case 2:
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
                throw new RuntimeException("Cannot interpolate String");
            case 5:
                if (this.f2051e) {
                    return 1.0f;
                }
                return RecyclerView.f7068F0;
            case 6:
                return this.f2050d;
            default:
                return Float.NaN;
        }
    }

    public void getValuesToInterpolate(float[] fArr) {
        float f;
        switch (this.f2048b.ordinal()) {
            case 0:
                fArr[0] = this.f2049c;
                return;
            case 1:
                fArr[0] = this.f2050d;
                return;
            case 2:
            case 3:
                int i = (this.f2052f >> 24) & 255;
                float pow = (float) Math.pow(((r0 >> 16) & 255) / 255.0f, 2.2d);
                float pow2 = (float) Math.pow(((r0 >> 8) & 255) / 255.0f, 2.2d);
                float pow3 = (float) Math.pow((r0 & 255) / 255.0f, 2.2d);
                fArr[0] = pow;
                fArr[1] = pow2;
                fArr[2] = pow3;
                fArr[3] = i / 255.0f;
                return;
            case 4:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 5:
                if (this.f2051e) {
                    f = 1.0f;
                } else {
                    f = RecyclerView.f7068F0;
                }
                fArr[0] = f;
                return;
            case 6:
                fArr[0] = this.f2050d;
                return;
            default:
                return;
        }
    }

    public boolean isContinuous() {
        int ordinal = this.f2048b.ordinal();
        if (ordinal != 4 && ordinal != 5 && ordinal != 7) {
            return true;
        }
        return false;
    }

    public int numberOfInterpolatedValues() {
        int ordinal = this.f2048b.ordinal();
        if (ordinal != 2 && ordinal != 3) {
            return 1;
        }
        return 4;
    }

    public void setColorValue(int i) {
        this.f2052f = i;
    }

    public void setFloatValue(float f) {
        this.f2050d = f;
    }

    public void setIntValue(int i) {
        this.f2049c = i;
    }

    public void setStringValue(String str) {
    }

    public void setValue(float[] fArr) {
        switch (this.f2048b.ordinal()) {
            case 0:
            case 7:
                this.f2049c = (int) fArr[0];
                return;
            case 1:
                this.f2050d = fArr[0];
                return;
            case 2:
            case 3:
                int hsvToRgb = hsvToRgb(fArr[0], fArr[1], fArr[2]);
                this.f2052f = hsvToRgb;
                int i = hsvToRgb & ViewCompat.MEASURED_SIZE_MASK;
                int i2 = (int) (fArr[3] * 255.0f);
                int i3 = (i2 & (~(i2 >> 31))) - 255;
                this.f2052f = (((i3 & (i3 >> 31)) + 255) << 24) | i;
                return;
            case 4:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 5:
                this.f2051e = ((double) fArr[0]) > 0.5d;
                return;
            case 6:
                this.f2050d = fArr[0];
                return;
            default:
                return;
        }
    }

    public CustomAttribute(String str, AttributeType attributeType, Object obj, boolean z) {
        this.f2047a = str;
        this.f2048b = attributeType;
        setValue(obj);
    }

    public CustomAttribute(CustomAttribute customAttribute, Object obj) {
        this.f2047a = customAttribute.f2047a;
        this.f2048b = customAttribute.f2048b;
        setValue(obj);
    }

    public void setValue(Object obj) {
        switch (this.f2048b.ordinal()) {
            case 0:
            case 7:
                this.f2049c = ((Integer) obj).intValue();
                return;
            case 1:
                this.f2050d = ((Float) obj).floatValue();
                return;
            case 2:
            case 3:
                this.f2052f = ((Integer) obj).intValue();
                return;
            case 4:
                return;
            case 5:
                this.f2051e = ((Boolean) obj).booleanValue();
                return;
            case 6:
                this.f2050d = ((Float) obj).floatValue();
                return;
            default:
                return;
        }
    }
}
