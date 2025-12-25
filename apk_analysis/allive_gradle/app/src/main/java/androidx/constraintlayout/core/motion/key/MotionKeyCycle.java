package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.motion.utils.Utils;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class MotionKeyCycle extends MotionKey {
    public static final int KEY_TYPE = 4;
    public static final int SHAPE_BOUNCE = 6;
    public static final int SHAPE_COS_WAVE = 5;
    public static final int SHAPE_REVERSE_SAW_WAVE = 4;
    public static final int SHAPE_SAW_WAVE = 3;
    public static final int SHAPE_SIN_WAVE = 0;
    public static final int SHAPE_SQUARE_WAVE = 1;
    public static final int SHAPE_TRIANGLE_WAVE = 2;
    public static final String WAVE_OFFSET = "waveOffset";
    public static final String WAVE_PERIOD = "wavePeriod";
    public static final String WAVE_PHASE = "wavePhase";
    public static final String WAVE_SHAPE = "waveShape";

    /* renamed from: a */
    public int f2130a = -1;

    /* renamed from: b */
    public String f2131b = null;

    /* renamed from: c */
    public float f2132c = Float.NaN;

    /* renamed from: d */
    public float f2133d = RecyclerView.f7068F0;

    /* renamed from: e */
    public float f2134e = RecyclerView.f7068F0;

    /* renamed from: f */
    public float f2135f = Float.NaN;

    /* renamed from: g */
    public float f2136g = Float.NaN;

    /* renamed from: h */
    public float f2137h = Float.NaN;

    /* renamed from: i */
    public float f2138i = Float.NaN;

    /* renamed from: j */
    public float f2139j = Float.NaN;

    /* renamed from: k */
    public float f2140k = Float.NaN;

    /* renamed from: l */
    public float f2141l = Float.NaN;

    /* renamed from: m */
    public float f2142m = Float.NaN;

    /* renamed from: n */
    public float f2143n = Float.NaN;

    /* renamed from: o */
    public float f2144o = Float.NaN;

    /* renamed from: p */
    public float f2145p = Float.NaN;

    /* renamed from: q */
    public float f2146q = Float.NaN;

    public MotionKeyCycle() {
        this.mType = 4;
        this.mCustom = new HashMap<>();
    }

    public void addCycleValues(HashMap<String, KeyCycleOscillator> hashMap) {
        KeyCycleOscillator keyCycleOscillator;
        KeyCycleOscillator keyCycleOscillator2;
        for (String str : hashMap.keySet()) {
            if (str.startsWith("CUSTOM")) {
                CustomVariable customVariable = this.mCustom.get(str.substring(7));
                if (customVariable != null && customVariable.getType() == 901 && (keyCycleOscillator = hashMap.get(str)) != null) {
                    keyCycleOscillator.setPoint(this.mFramePosition, this.f2130a, this.f2131b, -1, this.f2132c, this.f2133d, this.f2134e / 360.0f, customVariable.getValueToInterpolate(), customVariable);
                }
            } else {
                float value = getValue(str);
                if (!Float.isNaN(value) && (keyCycleOscillator2 = hashMap.get(str)) != null) {
                    keyCycleOscillator2.setPoint(this.mFramePosition, this.f2130a, this.f2131b, -1, this.f2132c, this.f2133d, this.f2134e / 360.0f, value);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void addValues(HashMap<String, SplineSet> hashMap) {
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    /* renamed from: clone */
    public MotionKey mo8474clone() {
        return null;
    }

    public void dump() {
        System.out.println("MotionKeyCycle{mWaveShape=" + this.f2130a + ", mWavePeriod=" + this.f2132c + ", mWaveOffset=" + this.f2133d + ", mWavePhase=" + this.f2134e + ", mRotation=" + this.f2138i + '}');
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void getAttributeNames(HashSet<String> hashSet) {
        if (!Float.isNaN(this.f2136g)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f2137h)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f2138i)) {
            hashSet.add("rotationZ");
        }
        if (!Float.isNaN(this.f2140k)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f2141l)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f2142m)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.f2143n)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.f2139j)) {
            hashSet.add("pathRotate");
        }
        if (!Float.isNaN(this.f2144o)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f2145p)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.f2146q)) {
            hashSet.add("translationZ");
        }
        if (this.mCustom.size() > 0) {
            Iterator<String> it = this.mCustom.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + it.next());
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String str) {
        char c;
        str.getClass();
        switch (str.hashCode()) {
            case -1581616630:
                if (str.equals(TypedValues.CycleType.S_CUSTOM_WAVE_SHAPE)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1310311125:
                if (str.equals("easing")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1249320806:
                if (str.equals("rotationX")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1249320804:
                if (str.equals("rotationZ")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -1019779949:
                if (str.equals(TypedValues.CycleType.S_WAVE_OFFSET)) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -991726143:
                if (str.equals(TypedValues.CycleType.S_WAVE_PERIOD)) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case -987906986:
                if (str.equals("pivotX")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -987906985:
                if (str.equals("pivotY")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 106629499:
                if (str.equals(TypedValues.CycleType.S_WAVE_PHASE)) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 579057826:
                if (str.equals("curveFit")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case 803192288:
                if (str.equals("pathRotate")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case 1532805160:
                if (str.equals("waveShape")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case 1941332754:
                if (str.equals("visibility")) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return 422;
            case 1:
                return 420;
            case 2:
                return 308;
            case 3:
                return 309;
            case 4:
                return 310;
            case 5:
                return 304;
            case 6:
                return 305;
            case 7:
                return 306;
            case '\b':
                return 424;
            case '\t':
                return 315;
            case '\n':
                return 423;
            case 11:
                return 313;
            case '\f':
                return 314;
            case '\r':
                return 311;
            case 14:
                return 312;
            case 15:
                return 403;
            case 16:
                return 425;
            case 17:
                return 401;
            case 18:
                return 416;
            case 19:
                return 421;
            case 20:
                return 402;
            default:
                return -1;
        }
    }

    public float getValue(String str) {
        str.getClass();
        char c = 65535;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    c = 0;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c = 1;
                    break;
                }
                break;
            case -1249320804:
                if (str.equals("rotationZ")) {
                    c = 2;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c = 3;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c = 4;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c = 5;
                    break;
                }
                break;
            case -1019779949:
                if (str.equals(TypedValues.CycleType.S_WAVE_OFFSET)) {
                    c = 6;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c = 7;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c = '\b';
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c = '\t';
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c = '\n';
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c = 11;
                    break;
                }
                break;
            case 106629499:
                if (str.equals(TypedValues.CycleType.S_WAVE_PHASE)) {
                    c = '\f';
                    break;
                }
                break;
            case 803192288:
                if (str.equals("pathRotate")) {
                    c = '\r';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return this.f2140k;
            case 1:
                return this.f2141l;
            case 2:
                return this.f2138i;
            case 3:
                return this.f2144o;
            case 4:
                return this.f2145p;
            case 5:
                return this.f2146q;
            case 6:
                return this.f2133d;
            case 7:
                return this.f2135f;
            case '\b':
                return this.f2142m;
            case '\t':
                return this.f2143n;
            case '\n':
                return this.f2137h;
            case 11:
                return this.f2136g;
            case '\f':
                return this.f2134e;
            case '\r':
                return this.f2139j;
            default:
                return Float.NaN;
        }
    }

    public void printAttributes() {
        HashSet<String> hashSet = new HashSet<>();
        getAttributeNames(hashSet);
        Utils.log(" ------------- " + this.mFramePosition + " -------------");
        Utils.log("MotionKeyCycle{Shape=" + this.f2130a + ", Period=" + this.f2132c + ", Offset=" + this.f2133d + ", Phase=" + this.f2134e + '}');
        String[] strArr = (String[]) hashSet.toArray(new String[0]);
        for (int i = 0; i < strArr.length; i++) {
            Utils.log(strArr[i] + ":" + getValue(strArr[i]));
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, int i2) {
        if (i != 401) {
            if (i != 421) {
                if (setValue(i, i2)) {
                    return true;
                }
                return super.setValue(i, i2);
            }
            this.f2130a = i2;
        }
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, String str) {
        if (i != 420) {
            if (i != 422) {
                return super.setValue(i, str);
            }
            this.f2131b = str;
        }
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, float f) {
        if (i == 315) {
            this.f2135f = f;
            return true;
        }
        if (i == 403) {
            this.f2136g = f;
            return true;
        }
        if (i != 416) {
            switch (i) {
                case 304:
                    this.f2144o = f;
                    return true;
                case 305:
                    this.f2145p = f;
                    return true;
                case 306:
                    this.f2146q = f;
                    return true;
                case 307:
                    this.f2137h = f;
                    return true;
                case 308:
                    this.f2140k = f;
                    return true;
                case 309:
                    this.f2141l = f;
                    return true;
                case 310:
                    this.f2138i = f;
                    return true;
                case 311:
                    this.f2142m = f;
                    return true;
                case 312:
                    this.f2143n = f;
                    return true;
                default:
                    switch (i) {
                        case 423:
                            this.f2132c = f;
                            return true;
                        case 424:
                            this.f2133d = f;
                            return true;
                        case 425:
                            this.f2134e = f;
                            return true;
                        default:
                            return super.setValue(i, f);
                    }
            }
        }
        this.f2139j = f;
        return true;
    }
}
