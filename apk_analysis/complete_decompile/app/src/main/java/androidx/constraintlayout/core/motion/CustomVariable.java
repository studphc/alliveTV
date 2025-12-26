package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import p000.AbstractC1726qj;

/* loaded from: classes.dex */
public class CustomVariable {

    /* renamed from: a */
    public final String f2054a;

    /* renamed from: b */
    public final int f2055b;

    /* renamed from: c */
    public int f2056c;

    /* renamed from: d */
    public float f2057d;

    /* renamed from: e */
    public String f2058e;

    /* renamed from: f */
    public boolean f2059f;

    public CustomVariable(CustomVariable customVariable) {
        this.f2056c = Integer.MIN_VALUE;
        this.f2057d = Float.NaN;
        this.f2058e = null;
        this.f2054a = customVariable.f2054a;
        this.f2055b = customVariable.f2055b;
        this.f2056c = customVariable.f2056c;
        this.f2057d = customVariable.f2057d;
        this.f2058e = customVariable.f2058e;
        this.f2059f = customVariable.f2059f;
    }

    /* renamed from: a */
    public static int m438a(int i) {
        int i2 = (i & (~(i >> 31))) - 255;
        return (i2 & (i2 >> 31)) + 255;
    }

    public static String colorString(int i) {
        return "#" + ("00000000" + Integer.toHexString(i)).substring(r2.length() - 8);
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

    public static int rgbaTocColor(float f, float f2, float f3, float f4) {
        int m438a = m438a((int) (f * 255.0f));
        int m438a2 = m438a((int) (f2 * 255.0f));
        return (m438a << 16) | (m438a((int) (f4 * 255.0f)) << 24) | (m438a2 << 8) | m438a((int) (f3 * 255.0f));
    }

    public void applyToWidget(MotionWidget motionWidget) {
        String str = this.f2054a;
        int i = this.f2055b;
        switch (i) {
            case TypedValues.Custom.TYPE_INT /* 900 */:
            case TypedValues.Custom.TYPE_COLOR /* 902 */:
            case TypedValues.Custom.TYPE_REFERENCE /* 906 */:
                motionWidget.setCustomAttribute(str, i, this.f2056c);
                return;
            case TypedValues.Custom.TYPE_FLOAT /* 901 */:
            case TypedValues.Custom.TYPE_DIMENSION /* 905 */:
                motionWidget.setCustomAttribute(str, i, this.f2057d);
                return;
            case TypedValues.Custom.TYPE_STRING /* 903 */:
                motionWidget.setCustomAttribute(str, i, this.f2058e);
                return;
            case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                motionWidget.setCustomAttribute(str, i, this.f2059f);
                return;
            default:
                return;
        }
    }

    public CustomVariable copy() {
        return new CustomVariable(this);
    }

    public boolean diff(CustomVariable customVariable) {
        if (customVariable == null) {
            return false;
        }
        int i = customVariable.f2055b;
        int i2 = this.f2055b;
        if (i2 != i) {
            return false;
        }
        switch (i2) {
            case TypedValues.Custom.TYPE_INT /* 900 */:
            case TypedValues.Custom.TYPE_REFERENCE /* 906 */:
                if (this.f2056c != customVariable.f2056c) {
                    return false;
                }
                return true;
            case TypedValues.Custom.TYPE_FLOAT /* 901 */:
                if (this.f2057d != customVariable.f2057d) {
                    return false;
                }
                return true;
            case TypedValues.Custom.TYPE_COLOR /* 902 */:
                if (this.f2056c != customVariable.f2056c) {
                    return false;
                }
                return true;
            case TypedValues.Custom.TYPE_STRING /* 903 */:
                if (this.f2056c != customVariable.f2056c) {
                    return false;
                }
                return true;
            case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                if (this.f2059f != customVariable.f2059f) {
                    return false;
                }
                return true;
            case TypedValues.Custom.TYPE_DIMENSION /* 905 */:
                if (this.f2057d != customVariable.f2057d) {
                    return false;
                }
                return true;
            default:
                return false;
        }
    }

    public boolean getBooleanValue() {
        return this.f2059f;
    }

    public int getColorValue() {
        return this.f2056c;
    }

    public float getFloatValue() {
        return this.f2057d;
    }

    public int getIntegerValue() {
        return this.f2056c;
    }

    public int getInterpolatedColor(float[] fArr) {
        return (m438a((int) (fArr[3] * 255.0f)) << 24) | (m438a((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (m438a((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | m438a((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f));
    }

    public String getName() {
        return this.f2054a;
    }

    public String getStringValue() {
        return this.f2058e;
    }

    public int getType() {
        return this.f2055b;
    }

    public float getValueToInterpolate() {
        switch (this.f2055b) {
            case TypedValues.Custom.TYPE_INT /* 900 */:
                return this.f2056c;
            case TypedValues.Custom.TYPE_FLOAT /* 901 */:
                return this.f2057d;
            case TypedValues.Custom.TYPE_COLOR /* 902 */:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case TypedValues.Custom.TYPE_STRING /* 903 */:
                throw new RuntimeException("Cannot interpolate String");
            case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                if (this.f2059f) {
                    return 1.0f;
                }
                return RecyclerView.f7068F0;
            case TypedValues.Custom.TYPE_DIMENSION /* 905 */:
                return this.f2057d;
            default:
                return Float.NaN;
        }
    }

    public void getValuesToInterpolate(float[] fArr) {
        float f;
        switch (this.f2055b) {
            case TypedValues.Custom.TYPE_INT /* 900 */:
                fArr[0] = this.f2056c;
                return;
            case TypedValues.Custom.TYPE_FLOAT /* 901 */:
                fArr[0] = this.f2057d;
                return;
            case TypedValues.Custom.TYPE_COLOR /* 902 */:
                int i = (this.f2056c >> 24) & 255;
                float pow = (float) Math.pow(((r0 >> 16) & 255) / 255.0f, 2.2d);
                float pow2 = (float) Math.pow(((r0 >> 8) & 255) / 255.0f, 2.2d);
                float pow3 = (float) Math.pow((r0 & 255) / 255.0f, 2.2d);
                fArr[0] = pow;
                fArr[1] = pow2;
                fArr[2] = pow3;
                fArr[3] = i / 255.0f;
                return;
            case TypedValues.Custom.TYPE_STRING /* 903 */:
                throw new RuntimeException("Cannot interpolate String");
            case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                if (this.f2059f) {
                    f = 1.0f;
                } else {
                    f = RecyclerView.f7068F0;
                }
                fArr[0] = f;
                return;
            case TypedValues.Custom.TYPE_DIMENSION /* 905 */:
                fArr[0] = this.f2057d;
                return;
            default:
                return;
        }
    }

    public boolean isContinuous() {
        int i = this.f2055b;
        if (i != 903 && i != 904 && i != 906) {
            return true;
        }
        return false;
    }

    public int numberOfInterpolatedValues() {
        if (this.f2055b != 902) {
            return 1;
        }
        return 4;
    }

    public void setBooleanValue(boolean z) {
        this.f2059f = z;
    }

    public void setFloatValue(float f) {
        this.f2057d = f;
    }

    public void setIntValue(int i) {
        this.f2056c = i;
    }

    public void setInterpolatedValue(MotionWidget motionWidget, float[] fArr) {
        boolean z = true;
        String str = this.f2054a;
        int i = this.f2055b;
        switch (i) {
            case TypedValues.Custom.TYPE_INT /* 900 */:
                motionWidget.setCustomAttribute(str, i, (int) fArr[0]);
                return;
            case TypedValues.Custom.TYPE_FLOAT /* 901 */:
            case TypedValues.Custom.TYPE_DIMENSION /* 905 */:
                motionWidget.setCustomAttribute(str, i, fArr[0]);
                return;
            case TypedValues.Custom.TYPE_COLOR /* 902 */:
                motionWidget.setCustomAttribute(str, i, (m438a((int) (fArr[3] * 255.0f)) << 24) | (m438a((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (m438a((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | m438a((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f)));
                return;
            case TypedValues.Custom.TYPE_STRING /* 903 */:
            case TypedValues.Custom.TYPE_REFERENCE /* 906 */:
                throw new RuntimeException("unable to interpolate " + str);
            case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                if (fArr[0] <= 0.5f) {
                    z = false;
                }
                motionWidget.setCustomAttribute(str, i, z);
                return;
            default:
                return;
        }
    }

    public void setStringValue(String str) {
        this.f2058e = str;
    }

    public void setValue(float[] fArr) {
        switch (this.f2055b) {
            case TypedValues.Custom.TYPE_INT /* 900 */:
            case TypedValues.Custom.TYPE_REFERENCE /* 906 */:
                this.f2056c = (int) fArr[0];
                return;
            case TypedValues.Custom.TYPE_FLOAT /* 901 */:
            case TypedValues.Custom.TYPE_DIMENSION /* 905 */:
                this.f2057d = fArr[0];
                return;
            case TypedValues.Custom.TYPE_COLOR /* 902 */:
                this.f2056c = ((Math.round(fArr[3] * 255.0f) & 255) << 24) | ((Math.round(((float) Math.pow(fArr[0], 0.5d)) * 255.0f) & 255) << 16) | ((Math.round(((float) Math.pow(fArr[1], 0.5d)) * 255.0f) & 255) << 8) | (Math.round(((float) Math.pow(fArr[2], 0.5d)) * 255.0f) & 255);
                return;
            case TypedValues.Custom.TYPE_STRING /* 903 */:
                throw new RuntimeException("Cannot interpolate String");
            case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                this.f2059f = ((double) fArr[0]) > 0.5d;
                return;
            default:
                return;
        }
    }

    public String toString() {
        String str = this.f2054a + ':';
        switch (this.f2055b) {
            case TypedValues.Custom.TYPE_INT /* 900 */:
                StringBuilder m7064t = AbstractC1726qj.m7064t(str);
                m7064t.append(this.f2056c);
                return m7064t.toString();
            case TypedValues.Custom.TYPE_FLOAT /* 901 */:
                StringBuilder m7064t2 = AbstractC1726qj.m7064t(str);
                m7064t2.append(this.f2057d);
                return m7064t2.toString();
            case TypedValues.Custom.TYPE_COLOR /* 902 */:
                StringBuilder m7064t3 = AbstractC1726qj.m7064t(str);
                m7064t3.append(colorString(this.f2056c));
                return m7064t3.toString();
            case TypedValues.Custom.TYPE_STRING /* 903 */:
                StringBuilder m7064t4 = AbstractC1726qj.m7064t(str);
                m7064t4.append(this.f2058e);
                return m7064t4.toString();
            case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                StringBuilder m7064t5 = AbstractC1726qj.m7064t(str);
                m7064t5.append(Boolean.valueOf(this.f2059f));
                return m7064t5.toString();
            case TypedValues.Custom.TYPE_DIMENSION /* 905 */:
                StringBuilder m7064t6 = AbstractC1726qj.m7064t(str);
                m7064t6.append(this.f2057d);
                return m7064t6.toString();
            default:
                return AbstractC1726qj.m7057m(str, "????");
        }
    }

    public CustomVariable(String str, int i, String str2) {
        this.f2056c = Integer.MIN_VALUE;
        this.f2057d = Float.NaN;
        this.f2054a = str;
        this.f2055b = i;
        this.f2058e = str2;
    }

    public void setValue(Object obj) {
        switch (this.f2055b) {
            case TypedValues.Custom.TYPE_INT /* 900 */:
            case TypedValues.Custom.TYPE_REFERENCE /* 906 */:
                this.f2056c = ((Integer) obj).intValue();
                return;
            case TypedValues.Custom.TYPE_FLOAT /* 901 */:
                this.f2057d = ((Float) obj).floatValue();
                return;
            case TypedValues.Custom.TYPE_COLOR /* 902 */:
                this.f2056c = ((Integer) obj).intValue();
                return;
            case TypedValues.Custom.TYPE_STRING /* 903 */:
                this.f2058e = (String) obj;
                return;
            case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                this.f2059f = ((Boolean) obj).booleanValue();
                return;
            case TypedValues.Custom.TYPE_DIMENSION /* 905 */:
                this.f2057d = ((Float) obj).floatValue();
                return;
            default:
                return;
        }
    }

    public CustomVariable(String str, int i, int i2) {
        this.f2056c = Integer.MIN_VALUE;
        this.f2057d = Float.NaN;
        this.f2058e = null;
        this.f2054a = str;
        this.f2055b = i;
        if (i == 901) {
            this.f2057d = i2;
        } else {
            this.f2056c = i2;
        }
    }

    public CustomVariable(String str, int i, float f) {
        this.f2056c = Integer.MIN_VALUE;
        this.f2058e = null;
        this.f2054a = str;
        this.f2055b = i;
        this.f2057d = f;
    }

    public CustomVariable(String str, int i, boolean z) {
        this.f2056c = Integer.MIN_VALUE;
        this.f2057d = Float.NaN;
        this.f2058e = null;
        this.f2054a = str;
        this.f2055b = i;
        this.f2059f = z;
    }

    public CustomVariable(String str, int i) {
        this.f2056c = Integer.MIN_VALUE;
        this.f2057d = Float.NaN;
        this.f2058e = null;
        this.f2054a = str;
        this.f2055b = i;
    }

    public CustomVariable(String str, int i, Object obj) {
        this.f2056c = Integer.MIN_VALUE;
        this.f2057d = Float.NaN;
        this.f2058e = null;
        this.f2054a = str;
        this.f2055b = i;
        setValue(obj);
    }

    public CustomVariable(CustomVariable customVariable, Object obj) {
        this.f2056c = Integer.MIN_VALUE;
        this.f2057d = Float.NaN;
        this.f2058e = null;
        this.f2054a = customVariable.f2054a;
        this.f2055b = customVariable.f2055b;
        setValue(obj);
    }
}
