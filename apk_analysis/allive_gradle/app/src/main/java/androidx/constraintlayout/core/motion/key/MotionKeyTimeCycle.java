package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.core.motion.utils.Utils;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import p000.ny2;

/* loaded from: classes.dex */
public class MotionKeyTimeCycle extends MotionKey {
    public static final int KEY_TYPE = 3;

    /* renamed from: a */
    public float f2149a = Float.NaN;

    /* renamed from: b */
    public float f2150b = Float.NaN;

    /* renamed from: c */
    public float f2151c = Float.NaN;

    /* renamed from: d */
    public float f2152d = Float.NaN;

    /* renamed from: e */
    public float f2153e = Float.NaN;

    /* renamed from: f */
    public float f2154f = Float.NaN;

    /* renamed from: g */
    public float f2155g = Float.NaN;

    /* renamed from: h */
    public float f2156h = Float.NaN;

    /* renamed from: i */
    public float f2157i = Float.NaN;

    /* renamed from: j */
    public float f2158j = Float.NaN;

    /* renamed from: k */
    public float f2159k = Float.NaN;

    /* renamed from: l */
    public float f2160l = Float.NaN;

    /* renamed from: m */
    public int f2161m = 0;

    /* renamed from: n */
    public float f2162n = Float.NaN;

    /* renamed from: o */
    public float f2163o = RecyclerView.f7068F0;

    public MotionKeyTimeCycle() {
        this.mType = 3;
        this.mCustom = new HashMap<>();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x004a. Please report as an issue. */
    public void addTimeValues(HashMap<String, TimeCycleSplineSet> hashMap) {
        for (String str : hashMap.keySet()) {
            TimeCycleSplineSet timeCycleSplineSet = hashMap.get(str);
            if (timeCycleSplineSet != null) {
                if (str.startsWith("CUSTOM")) {
                    CustomVariable customVariable = this.mCustom.get(str.substring(7));
                    if (customVariable != null) {
                        ((TimeCycleSplineSet.CustomVarSet) timeCycleSplineSet).setPoint(this.mFramePosition, customVariable, this.f2162n, this.f2161m, this.f2163o);
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
                        case -908189618:
                            if (str.equals("scaleX")) {
                                c = 7;
                                break;
                            }
                            break;
                        case -908189617:
                            if (str.equals("scaleY")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case -4379043:
                            if (str.equals("elevation")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case 92909918:
                            if (str.equals("alpha")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case 803192288:
                            if (str.equals("pathRotate")) {
                                c = 11;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            if (Float.isNaN(this.f2152d)) {
                                break;
                            } else {
                                timeCycleSplineSet.setPoint(this.mFramePosition, this.f2152d, this.f2162n, this.f2161m, this.f2163o);
                                break;
                            }
                        case 1:
                            if (Float.isNaN(this.f2153e)) {
                                break;
                            } else {
                                timeCycleSplineSet.setPoint(this.mFramePosition, this.f2153e, this.f2162n, this.f2161m, this.f2163o);
                                break;
                            }
                        case 2:
                            if (Float.isNaN(this.f2151c)) {
                                break;
                            } else {
                                timeCycleSplineSet.setPoint(this.mFramePosition, this.f2151c, this.f2162n, this.f2161m, this.f2163o);
                                break;
                            }
                        case 3:
                            if (Float.isNaN(this.f2157i)) {
                                break;
                            } else {
                                timeCycleSplineSet.setPoint(this.mFramePosition, this.f2157i, this.f2162n, this.f2161m, this.f2163o);
                                break;
                            }
                        case 4:
                            if (Float.isNaN(this.f2158j)) {
                                break;
                            } else {
                                timeCycleSplineSet.setPoint(this.mFramePosition, this.f2158j, this.f2162n, this.f2161m, this.f2163o);
                                break;
                            }
                        case 5:
                            if (Float.isNaN(this.f2159k)) {
                                break;
                            } else {
                                timeCycleSplineSet.setPoint(this.mFramePosition, this.f2159k, this.f2162n, this.f2161m, this.f2163o);
                                break;
                            }
                        case 6:
                            if (Float.isNaN(this.f2160l)) {
                                break;
                            } else {
                                timeCycleSplineSet.setPoint(this.mFramePosition, this.f2160l, this.f2162n, this.f2161m, this.f2163o);
                                break;
                            }
                        case 7:
                            if (Float.isNaN(this.f2155g)) {
                                break;
                            } else {
                                timeCycleSplineSet.setPoint(this.mFramePosition, this.f2155g, this.f2162n, this.f2161m, this.f2163o);
                                break;
                            }
                        case '\b':
                            if (Float.isNaN(this.f2156h)) {
                                break;
                            } else {
                                timeCycleSplineSet.setPoint(this.mFramePosition, this.f2156h, this.f2162n, this.f2161m, this.f2163o);
                                break;
                            }
                        case '\t':
                            if (Float.isNaN(this.f2159k)) {
                                break;
                            } else {
                                timeCycleSplineSet.setPoint(this.mFramePosition, this.f2159k, this.f2162n, this.f2161m, this.f2163o);
                                break;
                            }
                        case '\n':
                            if (Float.isNaN(this.f2149a)) {
                                break;
                            } else {
                                timeCycleSplineSet.setPoint(this.mFramePosition, this.f2149a, this.f2162n, this.f2161m, this.f2163o);
                                break;
                            }
                        case 11:
                            if (Float.isNaN(this.f2154f)) {
                                break;
                            } else {
                                timeCycleSplineSet.setPoint(this.mFramePosition, this.f2154f, this.f2162n, this.f2161m, this.f2163o);
                                break;
                            }
                        default:
                            Utils.loge("KeyTimeCycles", "UNKNOWN addValues \"" + str + "\"");
                            break;
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void addValues(HashMap<String, SplineSet> hashMap) {
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void getAttributeNames(HashSet<String> hashSet) {
        if (!Float.isNaN(this.f2149a)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f2150b)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f2151c)) {
            hashSet.add("rotationZ");
        }
        if (!Float.isNaN(this.f2152d)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f2153e)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f2155g)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.f2156h)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.f2154f)) {
            hashSet.add("pathRotate");
        }
        if (!Float.isNaN(this.f2157i)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f2158j)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.f2159k)) {
            hashSet.add("translationZ");
        }
        if (this.mCustom.size() > 0) {
            Iterator<String> it = this.mCustom.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + it.next());
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String str) {
        return ny2.m6400a(str);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, int i2) {
        if (i == 100) {
            this.mFramePosition = i2;
            return true;
        }
        if (i != 421) {
            return super.setValue(i, i2);
        }
        this.f2161m = i2;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    /* renamed from: clone */
    public MotionKey mo8474clone() {
        return new MotionKeyTimeCycle().copy((MotionKey) this);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public MotionKeyTimeCycle copy(MotionKey motionKey) {
        super.copy(motionKey);
        MotionKeyTimeCycle motionKeyTimeCycle = (MotionKeyTimeCycle) motionKey;
        motionKeyTimeCycle.getClass();
        this.f2161m = motionKeyTimeCycle.f2161m;
        this.f2162n = motionKeyTimeCycle.f2162n;
        this.f2163o = motionKeyTimeCycle.f2163o;
        this.f2160l = motionKeyTimeCycle.f2160l;
        this.f2149a = motionKeyTimeCycle.f2149a;
        this.f2150b = motionKeyTimeCycle.f2150b;
        this.f2151c = motionKeyTimeCycle.f2151c;
        this.f2154f = motionKeyTimeCycle.f2154f;
        this.f2152d = motionKeyTimeCycle.f2152d;
        this.f2153e = motionKeyTimeCycle.f2153e;
        this.f2155g = motionKeyTimeCycle.f2155g;
        this.f2156h = motionKeyTimeCycle.f2156h;
        this.f2157i = motionKeyTimeCycle.f2157i;
        this.f2158j = motionKeyTimeCycle.f2158j;
        this.f2159k = motionKeyTimeCycle.f2159k;
        return this;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, float f) {
        if (i == 315) {
            this.f2160l = Float.valueOf(f).floatValue();
            return true;
        }
        if (i == 401) {
            Integer.parseInt(Float.valueOf(f).toString());
            return true;
        }
        if (i == 403) {
            this.f2149a = f;
            return true;
        }
        if (i == 416) {
            this.f2154f = Float.valueOf(f).floatValue();
            return true;
        }
        if (i == 423) {
            this.f2162n = Float.valueOf(f).floatValue();
            return true;
        }
        if (i != 424) {
            switch (i) {
                case 304:
                    this.f2157i = Float.valueOf(f).floatValue();
                    return true;
                case 305:
                    this.f2158j = Float.valueOf(f).floatValue();
                    return true;
                case 306:
                    this.f2159k = Float.valueOf(f).floatValue();
                    return true;
                case 307:
                    this.f2150b = Float.valueOf(f).floatValue();
                    return true;
                case 308:
                    this.f2152d = Float.valueOf(f).floatValue();
                    return true;
                case 309:
                    this.f2153e = Float.valueOf(f).floatValue();
                    return true;
                case 310:
                    this.f2151c = Float.valueOf(f).floatValue();
                    return true;
                case 311:
                    this.f2155g = Float.valueOf(f).floatValue();
                    return true;
                case 312:
                    this.f2156h = Float.valueOf(f).floatValue();
                    return true;
                default:
                    return super.setValue(i, f);
            }
        }
        this.f2163o = Float.valueOf(f).floatValue();
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, String str) {
        if (i == 420) {
            return true;
        }
        if (i != 421) {
            return super.setValue(i, str);
        }
        this.f2161m = 7;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, boolean z) {
        return super.setValue(i, z);
    }
}
