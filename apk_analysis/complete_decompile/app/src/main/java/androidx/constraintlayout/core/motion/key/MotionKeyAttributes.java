package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import p000.AbstractC1726qj;
import p000.ly2;

/* loaded from: classes.dex */
public class MotionKeyAttributes extends MotionKey {
    public static final int KEY_TYPE = 1;

    /* renamed from: a */
    public int f2115a = -1;

    /* renamed from: b */
    public float f2116b = Float.NaN;

    /* renamed from: c */
    public float f2117c = Float.NaN;

    /* renamed from: d */
    public float f2118d = Float.NaN;

    /* renamed from: e */
    public float f2119e = Float.NaN;

    /* renamed from: f */
    public float f2120f = Float.NaN;

    /* renamed from: g */
    public float f2121g = Float.NaN;

    /* renamed from: h */
    public float f2122h = Float.NaN;

    /* renamed from: i */
    public float f2123i = Float.NaN;

    /* renamed from: j */
    public float f2124j = Float.NaN;

    /* renamed from: k */
    public float f2125k = Float.NaN;

    /* renamed from: l */
    public float f2126l = Float.NaN;

    /* renamed from: m */
    public float f2127m = Float.NaN;

    /* renamed from: n */
    public float f2128n = Float.NaN;

    /* renamed from: o */
    public float f2129o = Float.NaN;

    public MotionKeyAttributes() {
        this.mType = 1;
        this.mCustom = new HashMap<>();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0041. Please report as an issue. */
    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void addValues(HashMap<String, SplineSet> hashMap) {
        for (String str : hashMap.keySet()) {
            SplineSet splineSet = hashMap.get(str);
            if (splineSet != null) {
                if (str.startsWith("CUSTOM")) {
                    CustomVariable customVariable = this.mCustom.get(str.substring(7));
                    if (customVariable != null) {
                        ((SplineSet.CustomSpline) splineSet).setPoint(this.mFramePosition, customVariable);
                    }
                } else {
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
                        case -1001078227:
                            if (str.equals("progress")) {
                                c = 6;
                                break;
                            }
                            break;
                        case -987906986:
                            if (str.equals("pivotX")) {
                                c = 7;
                                break;
                            }
                            break;
                        case -987906985:
                            if (str.equals("pivotY")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case -908189618:
                            if (str.equals("scaleX")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case -908189617:
                            if (str.equals("scaleY")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case -4379043:
                            if (str.equals("elevation")) {
                                c = 11;
                                break;
                            }
                            break;
                        case 92909918:
                            if (str.equals("alpha")) {
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
                            if (Float.isNaN(this.f2119e)) {
                                break;
                            } else {
                                splineSet.setPoint(this.mFramePosition, this.f2119e);
                                break;
                            }
                        case 1:
                            if (Float.isNaN(this.f2120f)) {
                                break;
                            } else {
                                splineSet.setPoint(this.mFramePosition, this.f2120f);
                                break;
                            }
                        case 2:
                            if (Float.isNaN(this.f2118d)) {
                                break;
                            } else {
                                splineSet.setPoint(this.mFramePosition, this.f2118d);
                                break;
                            }
                        case 3:
                            if (Float.isNaN(this.f2126l)) {
                                break;
                            } else {
                                splineSet.setPoint(this.mFramePosition, this.f2126l);
                                break;
                            }
                        case 4:
                            if (Float.isNaN(this.f2127m)) {
                                break;
                            } else {
                                splineSet.setPoint(this.mFramePosition, this.f2127m);
                                break;
                            }
                        case 5:
                            if (Float.isNaN(this.f2128n)) {
                                break;
                            } else {
                                splineSet.setPoint(this.mFramePosition, this.f2128n);
                                break;
                            }
                        case 6:
                            if (Float.isNaN(this.f2129o)) {
                                break;
                            } else {
                                splineSet.setPoint(this.mFramePosition, this.f2129o);
                                break;
                            }
                        case 7:
                            if (Float.isNaN(this.f2119e)) {
                                break;
                            } else {
                                splineSet.setPoint(this.mFramePosition, this.f2121g);
                                break;
                            }
                        case '\b':
                            if (Float.isNaN(this.f2120f)) {
                                break;
                            } else {
                                splineSet.setPoint(this.mFramePosition, this.f2122h);
                                break;
                            }
                        case '\t':
                            if (Float.isNaN(this.f2124j)) {
                                break;
                            } else {
                                splineSet.setPoint(this.mFramePosition, this.f2124j);
                                break;
                            }
                        case '\n':
                            if (Float.isNaN(this.f2125k)) {
                                break;
                            } else {
                                splineSet.setPoint(this.mFramePosition, this.f2125k);
                                break;
                            }
                        case 11:
                            if (Float.isNaN(this.f2117c)) {
                                break;
                            } else {
                                splineSet.setPoint(this.mFramePosition, this.f2117c);
                                break;
                            }
                        case '\f':
                            if (Float.isNaN(this.f2116b)) {
                                break;
                            } else {
                                splineSet.setPoint(this.mFramePosition, this.f2116b);
                                break;
                            }
                        case '\r':
                            if (Float.isNaN(this.f2123i)) {
                                break;
                            } else {
                                splineSet.setPoint(this.mFramePosition, this.f2123i);
                                break;
                            }
                        default:
                            System.err.println("not supported by KeyAttributes ".concat(str));
                            break;
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    /* renamed from: clone */
    public MotionKey mo8474clone() {
        return null;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void getAttributeNames(HashSet<String> hashSet) {
        if (!Float.isNaN(this.f2116b)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f2117c)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f2118d)) {
            hashSet.add("rotationZ");
        }
        if (!Float.isNaN(this.f2119e)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f2120f)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f2121g)) {
            hashSet.add("pivotX");
        }
        if (!Float.isNaN(this.f2122h)) {
            hashSet.add("pivotY");
        }
        if (!Float.isNaN(this.f2126l)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f2127m)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.f2128n)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.f2123i)) {
            hashSet.add("pathRotate");
        }
        if (!Float.isNaN(this.f2124j)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.f2125k)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.f2129o)) {
            hashSet.add("progress");
        }
        if (this.mCustom.size() > 0) {
            Iterator<String> it = this.mCustom.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + it.next());
            }
        }
    }

    public int getCurveFit() {
        return this.f2115a;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String str) {
        return ly2.m5999a(str);
    }

    public void printAttributes() {
        float f;
        HashSet<String> hashSet = new HashSet<>();
        getAttributeNames(hashSet);
        System.out.println(" ------------- " + this.mFramePosition + " -------------");
        String[] strArr = (String[]) hashSet.toArray(new String[0]);
        for (int i = 0; i < strArr.length; i++) {
            int m5999a = ly2.m5999a(strArr[i]);
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append(strArr[i]);
            sb.append(":");
            if (m5999a != 100) {
                switch (m5999a) {
                    case 303:
                        f = this.f2116b;
                        break;
                    case 304:
                        f = this.f2126l;
                        break;
                    case 305:
                        f = this.f2127m;
                        break;
                    case 306:
                        f = this.f2128n;
                        break;
                    case 307:
                        f = this.f2117c;
                        break;
                    case 308:
                        f = this.f2119e;
                        break;
                    case 309:
                        f = this.f2120f;
                        break;
                    case 310:
                        f = this.f2118d;
                        break;
                    case 311:
                        f = this.f2124j;
                        break;
                    case 312:
                        f = this.f2125k;
                        break;
                    case 313:
                        f = this.f2121g;
                        break;
                    case 314:
                        f = this.f2122h;
                        break;
                    case 315:
                        f = this.f2129o;
                        break;
                    case TypedValues.AttributesType.TYPE_PATH_ROTATE /* 316 */:
                        f = this.f2123i;
                        break;
                    default:
                        f = Float.NaN;
                        break;
                }
            } else {
                f = this.mFramePosition;
            }
            sb.append(f);
            printStream.println(sb.toString());
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void setInterpolation(HashMap<String, Integer> hashMap) {
        if (!Float.isNaN(this.f2116b)) {
            hashMap.put("alpha", Integer.valueOf(this.f2115a));
        }
        if (!Float.isNaN(this.f2117c)) {
            hashMap.put("elevation", Integer.valueOf(this.f2115a));
        }
        if (!Float.isNaN(this.f2118d)) {
            hashMap.put("rotationZ", Integer.valueOf(this.f2115a));
        }
        if (!Float.isNaN(this.f2119e)) {
            hashMap.put("rotationX", Integer.valueOf(this.f2115a));
        }
        if (!Float.isNaN(this.f2120f)) {
            hashMap.put("rotationY", Integer.valueOf(this.f2115a));
        }
        if (!Float.isNaN(this.f2121g)) {
            hashMap.put("pivotX", Integer.valueOf(this.f2115a));
        }
        if (!Float.isNaN(this.f2122h)) {
            hashMap.put("pivotY", Integer.valueOf(this.f2115a));
        }
        if (!Float.isNaN(this.f2126l)) {
            hashMap.put("translationX", Integer.valueOf(this.f2115a));
        }
        if (!Float.isNaN(this.f2127m)) {
            hashMap.put("translationY", Integer.valueOf(this.f2115a));
        }
        if (!Float.isNaN(this.f2128n)) {
            hashMap.put("translationZ", Integer.valueOf(this.f2115a));
        }
        if (!Float.isNaN(this.f2123i)) {
            hashMap.put("pathRotate", Integer.valueOf(this.f2115a));
        }
        if (!Float.isNaN(this.f2124j)) {
            hashMap.put("scaleX", Integer.valueOf(this.f2115a));
        }
        if (!Float.isNaN(this.f2125k)) {
            hashMap.put("scaleY", Integer.valueOf(this.f2115a));
        }
        if (!Float.isNaN(this.f2129o)) {
            hashMap.put("progress", Integer.valueOf(this.f2115a));
        }
        if (this.mCustom.size() > 0) {
            Iterator<String> it = this.mCustom.keySet().iterator();
            while (it.hasNext()) {
                hashMap.put(AbstractC1726qj.m7038C("CUSTOM,", it.next()), Integer.valueOf(this.f2115a));
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, int i2) {
        if (i == 100) {
            this.mFramePosition = i2;
            return true;
        }
        if (i != 301) {
            if (i == 302 || setValue(i, i2)) {
                return true;
            }
            return super.setValue(i, i2);
        }
        this.f2115a = i2;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, float f) {
        if (i != 100) {
            switch (i) {
                case 303:
                    this.f2116b = f;
                    return true;
                case 304:
                    this.f2126l = f;
                    return true;
                case 305:
                    this.f2127m = f;
                    return true;
                case 306:
                    this.f2128n = f;
                    return true;
                case 307:
                    this.f2117c = f;
                    return true;
                case 308:
                    this.f2119e = f;
                    return true;
                case 309:
                    this.f2120f = f;
                    return true;
                case 310:
                    this.f2118d = f;
                    return true;
                case 311:
                    this.f2124j = f;
                    return true;
                case 312:
                    this.f2125k = f;
                    return true;
                case 313:
                    this.f2121g = f;
                    return true;
                case 314:
                    this.f2122h = f;
                    return true;
                case 315:
                    this.f2129o = f;
                    return true;
                case TypedValues.AttributesType.TYPE_PATH_ROTATE /* 316 */:
                    this.f2123i = f;
                    return true;
                default:
                    return super.setValue(i, f);
            }
        }
        this.f2123i = f;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, String str) {
        if (i == 101 || i == 317) {
            return true;
        }
        return super.setValue(i, str);
    }
}
