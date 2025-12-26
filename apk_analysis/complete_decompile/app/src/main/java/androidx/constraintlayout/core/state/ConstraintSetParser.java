package androidx.constraintlayout.core.state;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLArray;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParser;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.parser.CLString;
import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.state.helpers.BarrierReference;
import androidx.constraintlayout.core.state.helpers.ChainReference;
import androidx.constraintlayout.core.state.helpers.FlowReference;
import androidx.constraintlayout.core.state.helpers.GridReference;
import androidx.constraintlayout.core.state.helpers.GuidelineReference;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import p000.C1283hv;
import p000.InterfaceC1209fv;
import p000.ye0;

/* loaded from: classes.dex */
public class ConstraintSetParser {

    /* loaded from: classes.dex */
    public static class DesignElement {

        /* renamed from: a */
        public String f2331a;

        /* renamed from: b */
        public String f2332b;

        /* renamed from: c */
        public HashMap f2333c;

        public String getId() {
            return this.f2331a;
        }

        public HashMap<String, String> getParams() {
            return this.f2333c;
        }

        public String getType() {
            return this.f2332b;
        }
    }

    /* loaded from: classes.dex */
    public static class LayoutVariables {

        /* renamed from: a */
        public final HashMap f2334a = new HashMap();

        /* renamed from: b */
        public final HashMap f2335b = new HashMap();

        /* renamed from: c */
        public final HashMap f2336c = new HashMap();

        /* renamed from: a */
        public final float m461a(CLElement cLElement) {
            if (cLElement instanceof CLString) {
                String content = ((CLString) cLElement).content();
                HashMap hashMap = this.f2335b;
                if (hashMap.containsKey(content)) {
                    return ((InterfaceC1209fv) hashMap.get(content)).value();
                }
                HashMap hashMap2 = this.f2334a;
                if (hashMap2.containsKey(content)) {
                    return ((Integer) hashMap2.get(content)).floatValue();
                }
                return RecyclerView.f7068F0;
            }
            if (cLElement instanceof CLNumber) {
                return ((CLNumber) cLElement).getFloat();
            }
            return RecyclerView.f7068F0;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, hv] */
        public void putOverride(String str, float f) {
            ?? obj = new Object();
            obj.f18195a = f;
            this.f2335b.put(str, obj);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static final class MotionLayoutDebugFlags {
        public static final MotionLayoutDebugFlags NONE;
        public static final MotionLayoutDebugFlags SHOW_ALL;
        public static final MotionLayoutDebugFlags UNKNOWN;

        /* renamed from: a */
        public static final /* synthetic */ MotionLayoutDebugFlags[] f2337a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0, types: [androidx.constraintlayout.core.state.ConstraintSetParser$MotionLayoutDebugFlags, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r4v1, types: [androidx.constraintlayout.core.state.ConstraintSetParser$MotionLayoutDebugFlags, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r5v1, types: [androidx.constraintlayout.core.state.ConstraintSetParser$MotionLayoutDebugFlags, java.lang.Enum] */
        static {
            ?? r3 = new Enum("NONE", 0);
            NONE = r3;
            ?? r4 = new Enum("SHOW_ALL", 1);
            SHOW_ALL = r4;
            ?? r5 = new Enum("UNKNOWN", 2);
            UNKNOWN = r5;
            f2337a = new MotionLayoutDebugFlags[]{r3, r4, r5};
        }

        public static MotionLayoutDebugFlags valueOf(String str) {
            return (MotionLayoutDebugFlags) Enum.valueOf(MotionLayoutDebugFlags.class, str);
        }

        public static MotionLayoutDebugFlags[] values() {
            return (MotionLayoutDebugFlags[]) f2337a.clone();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0175, code lost:
    
        if (r0.equals("visible") == false) goto L105;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m452a(CLObject cLObject, ConstraintReference constraintReference, LayoutVariables layoutVariables, State state, String str) {
        char c;
        ConstraintReference constraints;
        ArrayList<String> names;
        boolean z;
        char c2 = 2;
        str.getClass();
        switch (str.hashCode()) {
            case -1448775240:
                if (str.equals("centerVertically")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1364013995:
                if (str.equals("center")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1349088399:
                if (str.equals(SchedulerSupport.CUSTOM)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1249320806:
                if (str.equals("rotationX")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1249320804:
                if (str.equals("rotationZ")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -1221029593:
                if (str.equals("height")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -1068318794:
                if (str.equals("motion")) {
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
            case -247669061:
                if (str.equals("hRtlBias")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case -61505906:
                if (str.equals("vWeight")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case 98116417:
                if (str.equals("hBias")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case 111045711:
                if (str.equals("vBias")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case 113126854:
                if (str.equals("width")) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case 398344448:
                if (str.equals("hWeight")) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case 1404070310:
                if (str.equals("centerHorizontally")) {
                    c = 22;
                    break;
                }
                c = 65535;
                break;
            case 1941332754:
                if (str.equals("visibility")) {
                    c = 23;
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
                String string = cLObject.getString(str);
                boolean equals = string.equals("parent");
                Object obj = string;
                if (equals) {
                    obj = State.PARENT;
                }
                ConstraintReference constraints2 = state.constraints(obj);
                constraintReference.topToTop(constraints2);
                constraintReference.bottomToBottom(constraints2);
                return;
            case 1:
                String string2 = cLObject.getString(str);
                if (string2.equals("parent")) {
                    constraints = state.constraints(State.PARENT);
                } else {
                    constraints = state.constraints(string2);
                }
                constraintReference.startToStart(constraints);
                constraintReference.endToEnd(constraints);
                constraintReference.topToTop(constraints);
                constraintReference.bottomToBottom(constraints);
                return;
            case 2:
                CLObject objectOrNull = cLObject.getObjectOrNull(str);
                if (objectOrNull != null && (names = objectOrNull.names()) != null) {
                    Iterator<String> it = names.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        CLElement cLElement = objectOrNull.get(next);
                        if (cLElement instanceof CLNumber) {
                            constraintReference.addCustomFloat(next, cLElement.getFloat());
                        } else if (cLElement instanceof CLString) {
                            long m454c = m454c(cLElement.content());
                            if (m454c != -1) {
                                constraintReference.addCustomColor(next, (int) m454c);
                            }
                        }
                    }
                    return;
                }
                return;
            case 3:
                constraintReference.rotationX(layoutVariables.m461a(cLObject.get(str)));
                return;
            case 4:
                constraintReference.rotationY(layoutVariables.m461a(cLObject.get(str)));
                return;
            case 5:
                constraintReference.rotationZ(layoutVariables.m461a(cLObject.get(str)));
                return;
            case 6:
                constraintReference.translationX(state.f2350a.toPixels(layoutVariables.m461a(cLObject.get(str))));
                return;
            case 7:
                constraintReference.translationY(state.f2350a.toPixels(layoutVariables.m461a(cLObject.get(str))));
                return;
            case '\b':
                constraintReference.translationZ(state.f2350a.toPixels(layoutVariables.m461a(cLObject.get(str))));
                return;
            case '\t':
                constraintReference.setHeight(m457f(cLObject, str, state, state.f2350a));
                return;
            case '\n':
                CLElement cLElement2 = cLObject.get(str);
                if (cLElement2 instanceof CLObject) {
                    CLObject cLObject2 = (CLObject) cLElement2;
                    TypedBundle typedBundle = new TypedBundle();
                    ArrayList<String> names2 = cLObject2.names();
                    if (names2 != null) {
                        Iterator<String> it2 = names2.iterator();
                        while (it2.hasNext()) {
                            String next2 = it2.next();
                            next2.getClass();
                            switch (next2.hashCode()) {
                                case -1897525331:
                                    if (next2.equals("stagger")) {
                                        z = false;
                                        break;
                                    }
                                    break;
                                case -1310311125:
                                    if (next2.equals("easing")) {
                                        z = true;
                                        break;
                                    }
                                    break;
                                case -1285003983:
                                    if (next2.equals("quantize")) {
                                        z = 2;
                                        break;
                                    }
                                    break;
                                case -791482387:
                                    if (next2.equals("pathArc")) {
                                        z = 3;
                                        break;
                                    }
                                    break;
                                case -236944793:
                                    if (next2.equals("relativeTo")) {
                                        z = 4;
                                        break;
                                    }
                                    break;
                            }
                            z = -1;
                            switch (z) {
                                case false:
                                    typedBundle.add(600, cLObject2.getFloat(next2));
                                    break;
                                case true:
                                    typedBundle.add(TypedValues.MotionType.TYPE_EASING, cLObject2.getString(next2));
                                    break;
                                case true:
                                    CLElement cLElement3 = cLObject2.get(next2);
                                    if (cLElement3 instanceof CLArray) {
                                        CLArray cLArray = (CLArray) cLElement3;
                                        int size = cLArray.size();
                                        if (size <= 0) {
                                            break;
                                        } else {
                                            typedBundle.add(TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, cLArray.getInt(0));
                                            if (size <= 1) {
                                                break;
                                            } else {
                                                typedBundle.add(TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_TYPE, cLArray.getString(1));
                                                if (size <= 2) {
                                                    break;
                                                } else {
                                                    typedBundle.add(TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE, cLArray.getFloat(2));
                                                    break;
                                                }
                                            }
                                        }
                                    } else {
                                        typedBundle.add(TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, cLObject2.getInt(next2));
                                        break;
                                    }
                                case true:
                                    String string3 = cLObject2.getString(next2);
                                    String[] strArr = {SchedulerSupport.NONE, "startVertical", "startHorizontal", "flip", "below", "above"};
                                    int i = 0;
                                    while (true) {
                                        if (i < 6) {
                                            if (!strArr[i].equals(string3)) {
                                                i++;
                                            }
                                        } else {
                                            i = -1;
                                        }
                                    }
                                    if (i == -1) {
                                        System.err.println(cLObject2.getLine() + " pathArc = '" + string3 + "'");
                                        break;
                                    } else {
                                        typedBundle.add(TypedValues.MotionType.TYPE_PATHMOTION_ARC, i);
                                        break;
                                    }
                                case true:
                                    typedBundle.add(TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO, cLObject2.getString(next2));
                                    break;
                            }
                        }
                        constraintReference.f2304L = typedBundle;
                        return;
                    }
                    return;
                }
                return;
            case 11:
                constraintReference.pivotX(layoutVariables.m461a(cLObject.get(str)));
                return;
            case '\f':
                constraintReference.pivotY(layoutVariables.m461a(cLObject.get(str)));
                return;
            case '\r':
                constraintReference.scaleX(layoutVariables.m461a(cLObject.get(str)));
                return;
            case 14:
                constraintReference.scaleY(layoutVariables.m461a(cLObject.get(str)));
                return;
            case 15:
                float m461a = layoutVariables.m461a(cLObject.get(str));
                if (state.isRtl()) {
                    m461a = 1.0f - m461a;
                }
                constraintReference.horizontalBias(m461a);
                return;
            case 16:
                constraintReference.setVerticalChainWeight(layoutVariables.m461a(cLObject.get(str)));
                return;
            case 17:
                constraintReference.alpha(layoutVariables.m461a(cLObject.get(str)));
                return;
            case 18:
                constraintReference.horizontalBias(layoutVariables.m461a(cLObject.get(str)));
                return;
            case 19:
                constraintReference.verticalBias(layoutVariables.m461a(cLObject.get(str)));
                return;
            case 20:
                constraintReference.setWidth(m457f(cLObject, str, state, state.f2350a));
                return;
            case 21:
                constraintReference.setHorizontalChainWeight(layoutVariables.m461a(cLObject.get(str)));
                return;
            case 22:
                String string4 = cLObject.getString(str);
                boolean equals2 = string4.equals("parent");
                Object obj2 = string4;
                if (equals2) {
                    obj2 = State.PARENT;
                }
                ConstraintReference constraints3 = state.constraints(obj2);
                constraintReference.startToStart(constraints3);
                constraintReference.endToEnd(constraints3);
                return;
            case 23:
                String string5 = cLObject.getString(str);
                string5.getClass();
                switch (string5.hashCode()) {
                    case -1901805651:
                        if (string5.equals("invisible")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 3178655:
                        if (string5.equals("gone")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 466743410:
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                switch (c2) {
                    case 0:
                        constraintReference.visibility(4);
                        constraintReference.alpha(RecyclerView.f7068F0);
                        return;
                    case 1:
                        constraintReference.visibility(8);
                        return;
                    case 2:
                        constraintReference.visibility(0);
                        return;
                    default:
                        return;
                }
            default:
                m455d(cLObject, constraintReference, layoutVariables, state, str);
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00a8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0094 A[SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m453b(int i, State state, LayoutVariables layoutVariables, CLArray cLArray) {
        ChainReference verticalChain;
        String content;
        if (i == 0) {
            verticalChain = state.horizontalChain();
        } else {
            verticalChain = state.verticalChain();
        }
        CLElement cLElement = cLArray.get(1);
        if (cLElement instanceof CLArray) {
            CLArray cLArray2 = (CLArray) cLElement;
            if (cLArray2.size() >= 1) {
                for (int i2 = 0; i2 < cLArray2.size(); i2++) {
                    verticalChain.add(cLArray2.getString(i2));
                }
                if (cLArray.size() > 2) {
                    CLElement cLElement2 = cLArray.get(2);
                    if (!(cLElement2 instanceof CLObject)) {
                        return;
                    }
                    CLObject cLObject = (CLObject) cLElement2;
                    Iterator<String> it = cLObject.names().iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        next.getClass();
                        if (!next.equals("style")) {
                            m455d(cLObject, verticalChain, layoutVariables, state, next);
                        } else {
                            CLElement cLElement3 = cLObject.get(next);
                            if (cLElement3 instanceof CLArray) {
                                CLArray cLArray3 = (CLArray) cLElement3;
                                if (cLArray3.size() > 1) {
                                    content = cLArray3.getString(0);
                                    verticalChain.bias(cLArray3.getFloat(1));
                                    content.getClass();
                                    if (content.equals("packed")) {
                                        if (!content.equals("spread_inside")) {
                                            verticalChain.style(State.Chain.SPREAD);
                                        } else {
                                            verticalChain.style(State.Chain.SPREAD_INSIDE);
                                        }
                                    } else {
                                        verticalChain.style(State.Chain.PACKED);
                                    }
                                }
                            }
                            content = cLElement3.content();
                            content.getClass();
                            if (content.equals("packed")) {
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: c */
    public static long m454c(String str) {
        if (str.startsWith("#")) {
            String substring = str.substring(1);
            if (substring.length() == 6) {
                substring = "FF".concat(substring);
            }
            return Long.parseLong(substring, 16);
        }
        return -1L;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x00d0. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* renamed from: d */
    public static void m455d(CLObject cLObject, ConstraintReference constraintReference, LayoutVariables layoutVariables, State state, String str) {
        ConstraintReference constraints;
        char c;
        float f;
        float f2;
        ConstraintReference constraints2;
        char c2;
        char c3;
        boolean z;
        char c4;
        char c5;
        boolean z2;
        char c6;
        boolean z3;
        ?? r13;
        boolean isRtl = state.isRtl();
        boolean z4 = !isRtl;
        CLArray arrayOrNull = cLObject.getArrayOrNull(str);
        if (arrayOrNull != null && arrayOrNull.size() > 1) {
            String string = arrayOrNull.getString(0);
            String stringOrNull = arrayOrNull.getStringOrNull(1);
            int size = arrayOrNull.size();
            float f3 = RecyclerView.f7068F0;
            if (size > 2) {
                f = state.f2350a.toPixels(layoutVariables.m461a(arrayOrNull.getOrNull(2)));
            } else {
                f = 0.0f;
            }
            float f4 = f;
            if (arrayOrNull.size() > 3) {
                f2 = state.f2350a.toPixels(layoutVariables.m461a(arrayOrNull.getOrNull(3)));
            } else {
                f2 = 0.0f;
            }
            if (string.equals("parent")) {
                constraints2 = state.constraints(State.PARENT);
            } else {
                constraints2 = state.constraints(string);
            }
            str.getClass();
            switch (str.hashCode()) {
                case -1720785339:
                    if (str.equals("baseline")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1498085729:
                    if (str.equals("circular")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1383228885:
                    if (str.equals("bottom")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 100571:
                    if (str.equals("end")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 115029:
                    if (str.equals("top")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3317767:
                    if (str.equals("left")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 108511772:
                    if (str.equals("right")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 109757538:
                    if (str.equals("start")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    c3 = 2;
                    z = true;
                    stringOrNull.getClass();
                    switch (stringOrNull.hashCode()) {
                        case -1720785339:
                            if (stringOrNull.equals("baseline")) {
                                c4 = 0;
                                break;
                            }
                            c4 = 65535;
                            break;
                        case -1383228885:
                            if (stringOrNull.equals("bottom")) {
                                c4 = 1;
                                break;
                            }
                            c4 = 65535;
                            break;
                        case 115029:
                            if (stringOrNull.equals("top")) {
                                c4 = 2;
                                break;
                            }
                            c4 = 65535;
                            break;
                        default:
                            c4 = 65535;
                            break;
                    }
                    switch (c4) {
                        case 0:
                            state.baselineNeededFor(constraintReference.getKey());
                            state.baselineNeededFor(constraints2.getKey());
                            constraintReference.baselineToBaseline(constraints2);
                            break;
                        case 1:
                            state.baselineNeededFor(constraintReference.getKey());
                            constraintReference.baselineToBottom(constraints2);
                            break;
                        case 2:
                            state.baselineNeededFor(constraintReference.getKey());
                            constraintReference.baselineToTop(constraints2);
                            break;
                    }
                    z2 = z;
                    z3 = false;
                    break;
                case 1:
                    z = true;
                    float m461a = layoutVariables.m461a(arrayOrNull.get(1));
                    if (arrayOrNull.size() > 2) {
                        f3 = state.f2350a.toPixels(layoutVariables.m461a(arrayOrNull.getOrNull(2)));
                    }
                    constraintReference.circularConstraint(constraints2, m461a, f3);
                    c3 = 2;
                    z2 = z;
                    z3 = false;
                    break;
                case 2:
                    stringOrNull.getClass();
                    switch (stringOrNull.hashCode()) {
                        case -1720785339:
                            if (stringOrNull.equals("baseline")) {
                                c5 = 0;
                                break;
                            }
                            c5 = 65535;
                            break;
                        case -1383228885:
                            if (stringOrNull.equals("bottom")) {
                                c5 = 1;
                                break;
                            }
                            c5 = 65535;
                            break;
                        case 115029:
                            if (stringOrNull.equals("top")) {
                                c5 = 2;
                                break;
                            }
                            c5 = 65535;
                            break;
                        default:
                            c5 = 65535;
                            break;
                    }
                    switch (c5) {
                        case 0:
                            state.baselineNeededFor(constraints2.getKey());
                            constraintReference.f2297E = State.Constraint.BOTTOM_TO_BASELINE;
                            constraintReference.f2328x = constraints2;
                            break;
                        case 1:
                            constraintReference.bottomToBottom(constraints2);
                            break;
                        case 2:
                            constraintReference.bottomToTop(constraints2);
                            break;
                    }
                    c3 = 2;
                    z = true;
                    z2 = z;
                    z3 = false;
                    break;
                case 3:
                    z2 = isRtl;
                    c3 = 2;
                    z = true;
                    z3 = true;
                    break;
                case 4:
                    stringOrNull.getClass();
                    switch (stringOrNull.hashCode()) {
                        case -1720785339:
                            if (stringOrNull.equals("baseline")) {
                                c6 = 0;
                                break;
                            }
                            c6 = 65535;
                            break;
                        case -1383228885:
                            if (stringOrNull.equals("bottom")) {
                                c6 = 1;
                                break;
                            }
                            c6 = 65535;
                            break;
                        case 115029:
                            if (stringOrNull.equals("top")) {
                                c6 = 2;
                                break;
                            }
                            c6 = 65535;
                            break;
                        default:
                            c6 = 65535;
                            break;
                    }
                    switch (c6) {
                        case 0:
                            state.baselineNeededFor(constraints2.getKey());
                            constraintReference.f2297E = State.Constraint.TOP_TO_BASELINE;
                            constraintReference.f2327w = constraints2;
                            break;
                        case 1:
                            constraintReference.topToBottom(constraints2);
                            break;
                        case 2:
                            constraintReference.topToTop(constraints2);
                            break;
                    }
                    c3 = 2;
                    z = true;
                    z2 = z;
                    z3 = false;
                    break;
                case 5:
                    c3 = 2;
                    z2 = true;
                    z = true;
                    z3 = true;
                    break;
                case 6:
                    c3 = 2;
                    z2 = false;
                    z = true;
                    z3 = true;
                    break;
                case 7:
                    z2 = z4;
                    c3 = 2;
                    z = true;
                    z3 = true;
                    break;
                default:
                    c3 = 2;
                    z = true;
                    z2 = z;
                    z3 = false;
                    break;
            }
            if (z3) {
                stringOrNull.getClass();
                switch (stringOrNull.hashCode()) {
                    case 100571:
                        if (stringOrNull.equals("end")) {
                            r13 = 0;
                            break;
                        }
                        r13 = -1;
                        break;
                    case 108511772:
                        if (stringOrNull.equals("right")) {
                            r13 = z;
                            break;
                        }
                        r13 = -1;
                        break;
                    case 109757538:
                        if (stringOrNull.equals("start")) {
                            r13 = c3;
                            break;
                        }
                        r13 = -1;
                        break;
                    default:
                        r13 = -1;
                        break;
                }
                switch (r13) {
                    case 0:
                        z = isRtl;
                        break;
                    case 1:
                        z = false;
                        break;
                    case 2:
                        z = z4;
                        break;
                }
                if (z2) {
                    if (z) {
                        constraintReference.leftToLeft(constraints2);
                    } else {
                        constraintReference.leftToRight(constraints2);
                    }
                } else if (z) {
                    constraintReference.rightToLeft(constraints2);
                } else {
                    constraintReference.rightToRight(constraints2);
                }
            }
            constraintReference.margin(Float.valueOf(f4)).marginGone(Float.valueOf(f2));
            return;
        }
        String stringOrNull2 = cLObject.getStringOrNull(str);
        if (stringOrNull2 != null) {
            if (stringOrNull2.equals("parent")) {
                constraints = state.constraints(State.PARENT);
            } else {
                constraints = state.constraints(stringOrNull2);
            }
            str.getClass();
            switch (str.hashCode()) {
                case -1720785339:
                    if (str.equals("baseline")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -1383228885:
                    if (str.equals("bottom")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 100571:
                    if (str.equals("end")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 115029:
                    if (str.equals("top")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 109757538:
                    if (str.equals("start")) {
                        c = 4;
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
                    state.baselineNeededFor(constraintReference.getKey());
                    state.baselineNeededFor(constraints.getKey());
                    constraintReference.baselineToBaseline(constraints);
                    return;
                case 1:
                    constraintReference.bottomToBottom(constraints);
                    return;
                case 2:
                    if (!isRtl) {
                        constraintReference.rightToRight(constraints);
                        return;
                    } else {
                        constraintReference.leftToLeft(constraints);
                        return;
                    }
                case 3:
                    constraintReference.topToTop(constraints);
                    return;
                case 4:
                    if (!isRtl) {
                        constraintReference.leftToLeft(constraints);
                        return;
                    } else {
                        constraintReference.rightToRight(constraints);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00c8, code lost:
    
        switch(r15) {
            case 0: goto L57;
            case 1: goto L56;
            case 2: goto L55;
            default: goto L54;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00cb, code lost:
    
        r9.remove(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00cf, code lost:
    
        r9.remove("width");
        r9.remove("height");
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00da, code lost:
    
        r9.remove("start");
        r9.remove("end");
        r9.remove("top");
        r9.remove("bottom");
        r9.remove("baseline");
        r9.remove("center");
        r9.remove("centerHorizontally");
        r9.remove("centerVertically");
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0103, code lost:
    
        r9.remove("visibility");
        r9.remove("alpha");
        r9.remove("pivotX");
        r9.remove("pivotY");
        r9.remove("rotationX");
        r9.remove("rotationY");
        r9.remove("rotationZ");
        r9.remove("scaleX");
        r9.remove("scaleY");
        r9.remove("translationX");
        r9.remove("translationY");
     */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m456e(CoreMotionScene coreMotionScene, CLObject cLObject) {
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return;
        }
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            String next = it.next();
            CLObject object = cLObject.getObject(next);
            String stringOrNull = object.getStringOrNull("Extends");
            if (stringOrNull != null && !stringOrNull.isEmpty()) {
                String constraintSet = coreMotionScene.getConstraintSet(stringOrNull);
                if (constraintSet != null) {
                    CLObject parse = CLParser.parse(constraintSet);
                    ArrayList<String> names2 = object.names();
                    if (names2 != null) {
                        Iterator<String> it2 = names2.iterator();
                        while (it2.hasNext()) {
                            String next2 = it2.next();
                            CLElement cLElement = object.get(next2);
                            if (cLElement instanceof CLObject) {
                                CLObject cLObject2 = (CLObject) cLElement;
                                if (!parse.has(next2)) {
                                    parse.put(next2, cLObject2);
                                } else {
                                    CLObject object2 = parse.getObject(next2);
                                    Iterator<String> it3 = cLObject2.names().iterator();
                                    while (it3.hasNext()) {
                                        String next3 = it3.next();
                                        if (!next3.equals("clear")) {
                                            object2.put(next3, cLObject2.get(next3));
                                        } else {
                                            CLArray array = cLObject2.getArray("clear");
                                            for (int i = 0; i < array.size(); i++) {
                                                String stringOrNull2 = array.getStringOrNull(i);
                                                if (stringOrNull2 != null) {
                                                    char c = 65535;
                                                    switch (stringOrNull2.hashCode()) {
                                                        case -1727069561:
                                                            if (stringOrNull2.equals("transforms")) {
                                                                c = 0;
                                                                break;
                                                            }
                                                            break;
                                                        case -1606703562:
                                                            if (stringOrNull2.equals("constraints")) {
                                                                c = 1;
                                                                break;
                                                            }
                                                            break;
                                                        case 414334925:
                                                            if (stringOrNull2.equals("dimensions")) {
                                                                c = 2;
                                                                break;
                                                            }
                                                            break;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        coreMotionScene.setConstraintSetContent(next, parse.toJSON());
                    }
                }
            } else {
                coreMotionScene.setConstraintSetContent(next, object.toJSON());
            }
        }
    }

    /* renamed from: f */
    public static Dimension m457f(CLObject cLObject, String str, State state, CorePixelDp corePixelDp) {
        CLElement cLElement = cLObject.get(str);
        Dimension createFixed = Dimension.createFixed(0);
        if (cLElement instanceof CLString) {
            return m458g(cLElement.content());
        }
        if (cLElement instanceof CLNumber) {
            return Dimension.createFixed(state.convertDimension(Float.valueOf(corePixelDp.toPixels(cLObject.getFloat(str)))));
        }
        if (cLElement instanceof CLObject) {
            CLObject cLObject2 = (CLObject) cLElement;
            String stringOrNull = cLObject2.getStringOrNull("value");
            if (stringOrNull != null) {
                createFixed = m458g(stringOrNull);
            }
            CLElement orNull = cLObject2.getOrNull("min");
            if (orNull != null) {
                if (orNull instanceof CLNumber) {
                    createFixed.min(state.convertDimension(Float.valueOf(corePixelDp.toPixels(((CLNumber) orNull).getFloat()))));
                } else if (orNull instanceof CLString) {
                    createFixed.min(Dimension.WRAP_DIMENSION);
                }
            }
            CLElement orNull2 = cLObject2.getOrNull("max");
            if (orNull2 != null) {
                if (orNull2 instanceof CLNumber) {
                    createFixed.max(state.convertDimension(Float.valueOf(corePixelDp.toPixels(((CLNumber) orNull2).getFloat()))));
                    return createFixed;
                }
                if (orNull2 instanceof CLString) {
                    createFixed.max(Dimension.WRAP_DIMENSION);
                    return createFixed;
                }
                return createFixed;
            }
            return createFixed;
        }
        return createFixed;
    }

    /* renamed from: g */
    public static Dimension m458g(String str) {
        Dimension createFixed = Dimension.createFixed(0);
        str.getClass();
        char c = 65535;
        switch (str.hashCode()) {
            case -1460244870:
                if (str.equals("preferWrap")) {
                    c = 0;
                    break;
                }
                break;
            case -995424086:
                if (str.equals("parent")) {
                    c = 1;
                    break;
                }
                break;
            case -895684237:
                if (str.equals("spread")) {
                    c = 2;
                    break;
                }
                break;
            case 3657802:
                if (str.equals("wrap")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return Dimension.createSuggested(Dimension.WRAP_DIMENSION);
            case 1:
                return Dimension.createParent();
            case 2:
                return Dimension.createSuggested(Dimension.SPREAD_DIMENSION);
            case 3:
                return Dimension.createWrap();
            default:
                if (str.endsWith("%")) {
                    return Dimension.createPercent(0, Float.parseFloat(str.substring(0, str.indexOf(37))) / 100.0f).suggested(0);
                }
                if (str.contains(":")) {
                    return Dimension.createRatio(str).suggested(Dimension.SPREAD_DIMENSION);
                }
                return createFixed;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:19:0x0088. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:41:0x0110. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0043  */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m459h(int i, State state, String str, CLObject cLObject) {
        boolean z;
        String next;
        char c;
        char c2;
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return;
        }
        ConstraintReference constraints = state.constraints(str);
        if (i == 0) {
            state.horizontalGuideline(str);
        } else {
            state.verticalGuideline(str);
        }
        if (state.isRtl() && i != 0) {
            z = false;
        } else {
            z = true;
        }
        GuidelineReference guidelineReference = (GuidelineReference) constraints.getFacade();
        Iterator<String> it = names.iterator();
        float f = RecyclerView.f7068F0;
        boolean z2 = false;
        while (true) {
            boolean z3 = true;
            while (it.hasNext()) {
                next = it.next();
                next.getClass();
                switch (next.hashCode()) {
                    case -678927291:
                        if (next.equals("percent")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 100571:
                        if (next.equals("end")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 3317767:
                        if (next.equals("left")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 108511772:
                        if (next.equals("right")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 109757538:
                        if (next.equals("start")) {
                            c = 4;
                            break;
                        }
                        break;
                }
                c = 65535;
                switch (c) {
                    case 0:
                        CLArray arrayOrNull = cLObject.getArrayOrNull(next);
                        if (arrayOrNull == null) {
                            f = cLObject.getFloat(next);
                        } else {
                            if (arrayOrNull.size() > 1) {
                                String string = arrayOrNull.getString(0);
                                float f2 = arrayOrNull.getFloat(1);
                                string.getClass();
                                switch (string.hashCode()) {
                                    case 100571:
                                        if (string.equals("end")) {
                                            c2 = 0;
                                            break;
                                        }
                                        break;
                                    case 3317767:
                                        if (string.equals("left")) {
                                            c2 = 1;
                                            break;
                                        }
                                        break;
                                    case 108511772:
                                        if (string.equals("right")) {
                                            c2 = 2;
                                            break;
                                        }
                                        break;
                                    case 109757538:
                                        if (string.equals("start")) {
                                            c2 = 3;
                                            break;
                                        }
                                        break;
                                }
                                c2 = 65535;
                                switch (c2) {
                                    case 0:
                                        z3 = !z;
                                        f = f2;
                                        break;
                                    case 1:
                                        f = f2;
                                        break;
                                    case 2:
                                        f = f2;
                                        z3 = false;
                                        break;
                                    case 3:
                                        f = f2;
                                        z2 = true;
                                        z3 = z;
                                        break;
                                    default:
                                        f = f2;
                                        break;
                                }
                            }
                            z2 = true;
                        }
                        z2 = true;
                        z3 = true;
                    case 1:
                        z3 = !z;
                        f = state.f2350a.toPixels(cLObject.getFloat(next));
                    case 3:
                        f = state.f2350a.toPixels(cLObject.getFloat(next));
                        z3 = false;
                    case 4:
                        f = state.f2350a.toPixels(cLObject.getFloat(next));
                        z3 = z;
                }
                while (it.hasNext()) {
                }
            }
            if (z2) {
                if (z3) {
                    guidelineReference.percent(f);
                    return;
                } else {
                    guidelineReference.percent(1.0f - f);
                    return;
                }
            }
            if (z3) {
                guidelineReference.start(Float.valueOf(f));
                return;
            } else {
                guidelineReference.end(Float.valueOf(f));
                return;
            }
            f = state.f2350a.toPixels(cLObject.getFloat(next));
        }
    }

    /* renamed from: i */
    public static void m460i(State state, LayoutVariables layoutVariables, String str, CLObject cLObject) {
        ConstraintReference constraints = state.constraints(str);
        if (constraints.getWidth() == null) {
            constraints.setWidth(Dimension.createWrap());
        }
        if (constraints.getHeight() == null) {
            constraints.setHeight(Dimension.createWrap());
        }
        ArrayList<String> names = cLObject.names();
        if (names != null) {
            Iterator<String> it = names.iterator();
            while (it.hasNext()) {
                m452a(cLObject, constraints, layoutVariables, state, it.next());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [androidx.constraintlayout.core.state.ConstraintSetParser$DesignElement, java.lang.Object] */
    public static void parseDesignElementsJSON(String str, ArrayList<DesignElement> arrayList) {
        CLObject parse = CLParser.parse(str);
        ArrayList<String> names = parse.names();
        if (names != null && names.size() > 0) {
            String str2 = names.get(0);
            CLElement cLElement = parse.get(str2);
            str2.getClass();
            if (!str2.equals("Design") || !(cLElement instanceof CLObject)) {
                return;
            }
            CLObject cLObject = (CLObject) cLElement;
            ArrayList<String> names2 = cLObject.names();
            for (int i = 0; i < names2.size(); i++) {
                String str3 = names2.get(i);
                CLObject cLObject2 = (CLObject) cLObject.get(str3);
                System.out.printf(ye0.m8296p("element found ", str3, ""), new Object[0]);
                String stringOrNull = cLObject2.getStringOrNull("type");
                if (stringOrNull != null) {
                    HashMap hashMap = new HashMap();
                    int size = cLObject2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        CLKey cLKey = (CLKey) cLObject2.get(i);
                        String content = cLKey.content();
                        String content2 = cLKey.getValue().content();
                        if (content2 != null) {
                            hashMap.put(content, content2);
                        }
                    }
                    ?? obj = new Object();
                    obj.f2331a = str2;
                    obj.f2332b = stringOrNull;
                    obj.f2333c = hashMap;
                    arrayList.add(obj);
                }
            }
        }
    }

    public static void parseJSON(String str, Transition transition, int i) {
        CLObject objectOrNull;
        try {
            CLObject parse = CLParser.parse(str);
            ArrayList<String> names = parse.names();
            if (names == null) {
                return;
            }
            Iterator<String> it = names.iterator();
            while (it.hasNext()) {
                String next = it.next();
                CLElement cLElement = parse.get(next);
                if ((cLElement instanceof CLObject) && (objectOrNull = ((CLObject) cLElement).getObjectOrNull(SchedulerSupport.CUSTOM)) != null) {
                    Iterator<String> it2 = objectOrNull.names().iterator();
                    while (it2.hasNext()) {
                        String next2 = it2.next();
                        CLElement cLElement2 = objectOrNull.get(next2);
                        if (cLElement2 instanceof CLNumber) {
                            transition.addCustomFloat(i, next, next2, cLElement2.getFloat());
                        } else if (cLElement2 instanceof CLString) {
                            long m454c = m454c(cLElement2.content());
                            if (m454c != -1) {
                                transition.addCustomColor(i, next, next2, (int) m454c);
                            }
                        }
                    }
                }
            }
        } catch (CLParsingException e) {
            System.err.println("Error parsing JSON " + e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0092 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void parseMotionSceneJSON(CoreMotionScene coreMotionScene, String str) {
        char c;
        String stringOrNull;
        try {
            CLObject parse = CLParser.parse(str);
            ArrayList<String> names = parse.names();
            if (names == null) {
                return;
            }
            Iterator<String> it = names.iterator();
            while (it.hasNext()) {
                String next = it.next();
                CLElement cLElement = parse.get(next);
                if (cLElement instanceof CLObject) {
                    CLObject cLObject = (CLObject) cLElement;
                    int hashCode = next.hashCode();
                    if (hashCode != -2137403731) {
                        if (hashCode != -241441378) {
                            if (hashCode == 1101852654 && next.equals("ConstraintSets")) {
                                c = 0;
                                if (c == 0) {
                                    if (c != 1) {
                                        if (c == 2 && (stringOrNull = cLObject.getStringOrNull("export")) != null) {
                                            coreMotionScene.setDebugName(stringOrNull);
                                        }
                                    } else {
                                        ArrayList<String> names2 = cLObject.names();
                                        if (names2 != null) {
                                            Iterator<String> it2 = names2.iterator();
                                            while (it2.hasNext()) {
                                                String next2 = it2.next();
                                                coreMotionScene.setTransitionContent(next2, cLObject.getObject(next2).toJSON());
                                            }
                                        }
                                    }
                                } else {
                                    m456e(coreMotionScene, cLObject);
                                }
                            }
                            c = 65535;
                            if (c == 0) {
                            }
                        } else {
                            if (next.equals(TypedValues.TransitionType.NAME)) {
                                c = 1;
                                if (c == 0) {
                                }
                            }
                            c = 65535;
                            if (c == 0) {
                            }
                        }
                    } else {
                        if (next.equals("Header")) {
                            c = 2;
                            if (c == 0) {
                            }
                        }
                        c = 65535;
                        if (c == 0) {
                        }
                    }
                }
            }
        } catch (CLParsingException e) {
            System.err.println("Error parsing JSON " + e);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:96|(2:98|(10:100|(1:102)|103|104|(1:106)|107|(1:109)|47|48|49))(1:113)|112|103|104|(0)|107|(0)|47|48|49) */
    /* JADX WARN: Can't wrap try/catch for region: R(12:167|(2:169|(2:171|(9:173|174|175|(1:177)|178|(1:180)|152|153|49)(10:183|184|174|175|(0)|178|(0)|152|153|49)))(1:186)|185|184|174|175|(0)|178|(0)|152|153|49) */
    /* JADX WARN: Failed to find 'out' block for switch in B:148:0x04ef. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:26:0x00b7. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:29:0x013f. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:342:0x082e. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:44:0x0246. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:702:0x0e6d. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:106:0x03e1 A[Catch: NumberFormatException -> 0x0256, TryCatch #0 {NumberFormatException -> 0x0256, blocks: (B:104:0x03d2, B:106:0x03e1, B:107:0x03e8, B:109:0x03f0), top: B:103:0x03d2 }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x03f0 A[Catch: NumberFormatException -> 0x0256, TRY_LEAVE, TryCatch #0 {NumberFormatException -> 0x0256, blocks: (B:104:0x03d2, B:106:0x03e1, B:107:0x03e8, B:109:0x03f0), top: B:103:0x03d2 }] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x04b7  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x04c4  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x04d1  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x05a5 A[Catch: NumberFormatException -> 0x0531, TryCatch #1 {NumberFormatException -> 0x0531, blocks: (B:175:0x0596, B:177:0x05a5, B:178:0x05ac, B:180:0x05b4), top: B:174:0x0596 }] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x05b4 A[Catch: NumberFormatException -> 0x0531, TRY_LEAVE, TryCatch #1 {NumberFormatException -> 0x0531, blocks: (B:175:0x0596, B:177:0x05a5, B:178:0x05ac, B:180:0x05b4), top: B:174:0x0596 }] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x05fe  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x060b  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0618  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x086f  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x0883  */
    /* JADX WARN: Type inference failed for: r14v4, types: [ev, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v37, types: [java.lang.Object, gv] */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void populateState(@NonNull CLObject cLObject, @NonNull State state, @NonNull LayoutVariables layoutVariables) {
        String str;
        char c;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        int i;
        char c2;
        CLObject cLObject2;
        String stringOrNull;
        CLObject cLObject3;
        String stringOrNull2;
        CLObject cLObject4;
        ArrayList<String> names;
        CLObject cLObject5;
        ArrayList<String> names2;
        CLObject cLObject6;
        Iterator<String> it;
        char c3;
        char c4;
        String str13;
        int i2;
        CLElement cLElement;
        float f;
        float f2;
        float f3;
        float f4;
        String str14;
        String str15;
        char c5;
        Iterator<String> it2;
        String str16;
        CLArray cLArray;
        String str17;
        int i3;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        String content;
        char c6;
        Iterator<String> it3;
        char c7;
        char c8;
        String str18;
        String str19;
        String str20;
        String str21;
        String content2;
        String str22;
        String str23;
        Float f10;
        Float f11;
        Float valueOf;
        Float f12;
        Float f13;
        char c9;
        String content3;
        String str24;
        String str25;
        float f14;
        float f15;
        float f16;
        float f17;
        Float f18;
        Float valueOf2;
        String str26;
        CLArray cLArray2;
        int i4;
        float f19;
        float f20;
        float f21;
        String str27 = "hGuideline";
        String str28 = "hFlow";
        String str29 = "hChain";
        String str30 = "vGuideline";
        String str31 = "type";
        String str32 = "start";
        String str33 = "end";
        String str34 = "bottom";
        ArrayList<String> names3 = cLObject.names();
        if (names3 == null) {
            return;
        }
        Iterator<String> it4 = names3.iterator();
        while (it4.hasNext()) {
            String next = it4.next();
            CLElement cLElement2 = cLObject.get(next);
            next.getClass();
            String str35 = null;
            switch (next.hashCode()) {
                case -1824489883:
                    str = str32;
                    if (next.equals("Helpers")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1875016085:
                    str = str32;
                    if (next.equals("Generate")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1921490263:
                    str = str32;
                    if (next.equals("Variables")) {
                        c = 2;
                        break;
                    }
                    break;
                default:
                    str = str32;
                    break;
            }
            c = 65535;
            switch (c) {
                case 0:
                    str2 = str27;
                    str3 = str28;
                    str4 = str29;
                    str5 = str30;
                    str6 = str31;
                    str7 = str33;
                    str8 = str34;
                    str9 = str;
                    if (cLElement2 instanceof CLArray) {
                        CLArray cLArray3 = (CLArray) cLElement2;
                        int i5 = 0;
                        while (i5 < cLArray3.size()) {
                            CLElement cLElement3 = cLArray3.get(i5);
                            if (cLElement3 instanceof CLArray) {
                                CLArray cLArray4 = (CLArray) cLElement3;
                                i = 1;
                                if (cLArray4.size() > 1) {
                                    String string = cLArray4.getString(0);
                                    string.getClass();
                                    switch (string.hashCode()) {
                                        case -1785507558:
                                            str10 = str2;
                                            str11 = str5;
                                            str12 = str4;
                                            if (string.equals(str11)) {
                                                c2 = 0;
                                                break;
                                            } else {
                                                c2 = 65535;
                                                break;
                                            }
                                        case -1252464839:
                                            str10 = str2;
                                            str12 = str4;
                                            if (string.equals(str12)) {
                                                str11 = str5;
                                                c2 = 1;
                                                break;
                                            } else {
                                                c2 = 65535;
                                                str11 = str5;
                                                break;
                                            }
                                        case -851656725:
                                            str10 = str2;
                                            if (string.equals("vChain")) {
                                                str11 = str5;
                                                str12 = str4;
                                                c2 = 2;
                                                break;
                                            }
                                            c2 = 65535;
                                            str11 = str5;
                                            str12 = str4;
                                            break;
                                        case 965681512:
                                            str10 = str2;
                                            if (string.equals(str10)) {
                                                str11 = str5;
                                                str12 = str4;
                                                c2 = 3;
                                                break;
                                            }
                                            c2 = 65535;
                                            str11 = str5;
                                            str12 = str4;
                                            break;
                                        default:
                                            c2 = 65535;
                                            str10 = str2;
                                            str11 = str5;
                                            str12 = str4;
                                            break;
                                    }
                                    switch (c2) {
                                        case 0:
                                            i = 1;
                                            CLElement cLElement4 = cLArray4.get(1);
                                            if ((cLElement4 instanceof CLObject) && (stringOrNull = (cLObject2 = (CLObject) cLElement4).getStringOrNull("id")) != null) {
                                                m459h(1, state, stringOrNull, cLObject2);
                                                break;
                                            }
                                            break;
                                        case 1:
                                            i = 1;
                                            m453b(0, state, layoutVariables, cLArray4);
                                            break;
                                        case 2:
                                            i = 1;
                                            m453b(1, state, layoutVariables, cLArray4);
                                            break;
                                        case 3:
                                            i = 1;
                                            CLElement cLElement5 = cLArray4.get(1);
                                            if ((cLElement5 instanceof CLObject) && (stringOrNull2 = (cLObject3 = (CLObject) cLElement5).getStringOrNull("id")) != null) {
                                                m459h(0, state, stringOrNull2, cLObject3);
                                                break;
                                            }
                                            break;
                                    }
                                } else {
                                    str10 = str2;
                                    str11 = str5;
                                    str12 = str4;
                                }
                                i5 += i;
                                str2 = str10;
                                str4 = str12;
                                str5 = str11;
                            } else {
                                str10 = str2;
                                str11 = str5;
                                str12 = str4;
                            }
                            i = 1;
                            i5 += i;
                            str2 = str10;
                            str4 = str12;
                            str5 = str11;
                        }
                        break;
                    }
                    break;
                case 1:
                    str2 = str27;
                    str3 = str28;
                    str4 = str29;
                    str5 = str30;
                    str6 = str31;
                    str7 = str33;
                    str8 = str34;
                    str9 = str;
                    if ((cLElement2 instanceof CLObject) && (names = (cLObject4 = (CLObject) cLElement2).names()) != null) {
                        Iterator<String> it5 = names.iterator();
                        while (it5.hasNext()) {
                            String next2 = it5.next();
                            CLElement cLElement6 = cLObject4.get(next2);
                            HashMap hashMap = layoutVariables.f2336c;
                            ArrayList arrayList = hashMap.containsKey(next2) ? (ArrayList) hashMap.get(next2) : null;
                            if (arrayList != null && (cLElement6 instanceof CLObject)) {
                                Iterator it6 = arrayList.iterator();
                                while (it6.hasNext()) {
                                    m460i(state, layoutVariables, (String) it6.next(), (CLObject) cLElement6);
                                }
                            }
                        }
                        break;
                    }
                    break;
                case 2:
                    str2 = str27;
                    str3 = str28;
                    str4 = str29;
                    str5 = str30;
                    str6 = str31;
                    str7 = str33;
                    str8 = str34;
                    str9 = str;
                    if ((cLElement2 instanceof CLObject) && (names2 = (cLObject5 = (CLObject) cLElement2).names()) != null) {
                        Iterator<String> it7 = names2.iterator();
                        while (it7.hasNext()) {
                            String next3 = it7.next();
                            CLElement cLElement7 = cLObject5.get(next3);
                            if (cLElement7 instanceof CLNumber) {
                                layoutVariables.f2334a.put(next3, Integer.valueOf(cLElement7.getInt()));
                            } else if (cLElement7 instanceof CLObject) {
                                CLObject cLObject7 = (CLObject) cLElement7;
                                if (cLObject7.has(TypedValues.TransitionType.S_FROM) && cLObject7.has(TypedValues.TransitionType.S_TO)) {
                                    float m461a = layoutVariables.m461a(cLObject7.get(TypedValues.TransitionType.S_FROM));
                                    float m461a2 = layoutVariables.m461a(cLObject7.get(TypedValues.TransitionType.S_TO));
                                    String stringOrNull3 = cLObject7.getStringOrNull("prefix");
                                    String stringOrNull4 = cLObject7.getStringOrNull("postfix");
                                    HashMap hashMap2 = layoutVariables.f2335b;
                                    if (!hashMap2.containsKey(next3) || !(hashMap2.get(next3) instanceof C1283hv)) {
                                        ?? obj = new Object();
                                        it = it7;
                                        obj.f16984a = false;
                                        obj.f16987d = RecyclerView.f7068F0;
                                        if (stringOrNull3 == null) {
                                            stringOrNull3 = "";
                                        }
                                        obj.f16985b = stringOrNull3;
                                        if (stringOrNull4 == null) {
                                            stringOrNull4 = "";
                                        }
                                        obj.f16986c = stringOrNull4;
                                        obj.f16988e = m461a2;
                                        hashMap2.put(next3, obj);
                                        HashMap hashMap3 = layoutVariables.f2336c;
                                        ArrayList arrayList2 = new ArrayList();
                                        int i6 = (int) m461a;
                                        int i7 = (int) m461a2;
                                        int i8 = i6;
                                        while (i6 <= i7) {
                                            arrayList2.add(obj.f16985b + i8 + obj.f16986c);
                                            i8 += (int) 1.0f;
                                            i6++;
                                            cLObject5 = cLObject5;
                                        }
                                        cLObject6 = cLObject5;
                                        hashMap3.put(next3, arrayList2);
                                    }
                                } else {
                                    cLObject6 = cLObject5;
                                    it = it7;
                                    if (cLObject7.has(TypedValues.TransitionType.S_FROM) && cLObject7.has("step")) {
                                        float m461a3 = layoutVariables.m461a(cLObject7.get(TypedValues.TransitionType.S_FROM));
                                        float m461a4 = layoutVariables.m461a(cLObject7.get("step"));
                                        HashMap hashMap4 = layoutVariables.f2335b;
                                        if (!hashMap4.containsKey(next3) || !(hashMap4.get(next3) instanceof C1283hv)) {
                                            ?? obj2 = new Object();
                                            obj2.f17846a = m461a4;
                                            obj2.f17847b = m461a3;
                                            hashMap4.put(next3, obj2);
                                        }
                                    } else if (cLObject7.has("ids")) {
                                        CLArray array = cLObject7.getArray("ids");
                                        ArrayList arrayList3 = new ArrayList();
                                        for (int i9 = 0; i9 < array.size(); i9++) {
                                            arrayList3.add(array.getString(i9));
                                        }
                                        layoutVariables.f2336c.put(next3, arrayList3);
                                    } else if (cLObject7.has("tag")) {
                                        layoutVariables.f2336c.put(next3, state.getIdsForTag(cLObject7.getString("tag")));
                                    }
                                }
                                it7 = it;
                                cLObject5 = cLObject6;
                            }
                            cLObject6 = cLObject5;
                            it = it7;
                            it7 = it;
                            cLObject5 = cLObject6;
                        }
                        break;
                    }
                    break;
                default:
                    if (cLElement2 instanceof CLObject) {
                        CLObject cLObject8 = (CLObject) cLElement2;
                        Iterator<String> it8 = cLObject8.names().iterator();
                        while (true) {
                            if (it8.hasNext()) {
                                Iterator<String> it9 = it8;
                                if (it8.next().equals(str31)) {
                                    str35 = cLObject8.getString(str31);
                                } else {
                                    it8 = it9;
                                }
                            }
                        }
                        String str36 = str35;
                        if (str36 != null) {
                            String str37 = str33;
                            str8 = str34;
                            switch (str36.hashCode()) {
                                case -1785507558:
                                    str2 = str27;
                                    if (str36.equals(str30)) {
                                        c3 = 0;
                                        break;
                                    }
                                    c3 = 65535;
                                    break;
                                case -1354837162:
                                    str2 = str27;
                                    if (str36.equals("column")) {
                                        c3 = 1;
                                        break;
                                    }
                                    c3 = 65535;
                                    break;
                                case -1252464839:
                                    str2 = str27;
                                    if (str36.equals(str29)) {
                                        c3 = 2;
                                        break;
                                    }
                                    c3 = 65535;
                                    break;
                                case -851656725:
                                    str2 = str27;
                                    if (str36.equals("vChain")) {
                                        c3 = 3;
                                        break;
                                    }
                                    c3 = 65535;
                                    break;
                                case -333143113:
                                    str2 = str27;
                                    if (str36.equals("barrier")) {
                                        c3 = 4;
                                        break;
                                    }
                                    c3 = 65535;
                                    break;
                                case 113114:
                                    str2 = str27;
                                    if (str36.equals("row")) {
                                        c3 = 5;
                                        break;
                                    }
                                    c3 = 65535;
                                    break;
                                case 3181382:
                                    str2 = str27;
                                    if (str36.equals("grid")) {
                                        c3 = 6;
                                        break;
                                    }
                                    c3 = 65535;
                                    break;
                                case 98238902:
                                    str2 = str27;
                                    if (str36.equals(str28)) {
                                        c3 = 7;
                                        break;
                                    }
                                    c3 = 65535;
                                    break;
                                case 111168196:
                                    str2 = str27;
                                    if (str36.equals("vFlow")) {
                                        c3 = '\b';
                                        break;
                                    }
                                    c3 = 65535;
                                    break;
                                case 965681512:
                                    if (str36.equals(str27)) {
                                        str2 = str27;
                                        c3 = '\t';
                                        break;
                                    }
                                default:
                                    str2 = str27;
                                    c3 = 65535;
                                    break;
                            }
                            switch (c3) {
                                case 0:
                                    str3 = str28;
                                    str4 = str29;
                                    str5 = str30;
                                    str6 = str31;
                                    str9 = str;
                                    str7 = str37;
                                    m459h(1, state, next, cLObject8);
                                    break;
                                case 1:
                                case 5:
                                case 6:
                                    str3 = str28;
                                    str4 = str29;
                                    str5 = str30;
                                    str6 = str31;
                                    str9 = str;
                                    str7 = str37;
                                    char c10 = 5;
                                    GridReference grid = state.getGrid(next, str36);
                                    Iterator<String> it10 = cLObject8.names().iterator();
                                    while (it10.hasNext()) {
                                        String next4 = it10.next();
                                        next4.getClass();
                                        switch (next4.hashCode()) {
                                            case -1439500848:
                                                if (next4.equals("orientation")) {
                                                    c4 = 0;
                                                    break;
                                                }
                                                break;
                                            case -806339567:
                                                if (next4.equals("padding")) {
                                                    c4 = 1;
                                                    break;
                                                }
                                                break;
                                            case -567445985:
                                                if (next4.equals("contains")) {
                                                    c4 = 2;
                                                    break;
                                                }
                                                break;
                                            case 3169614:
                                                if (next4.equals("hGap")) {
                                                    c4 = 3;
                                                    break;
                                                }
                                                break;
                                            case 3506649:
                                                if (next4.equals("rows")) {
                                                    c4 = 4;
                                                    break;
                                                }
                                                break;
                                            case 3586688:
                                                if (next4.equals("vGap")) {
                                                    c4 = c10;
                                                    break;
                                                }
                                                break;
                                            case 97513095:
                                                if (next4.equals("flags")) {
                                                    c4 = 6;
                                                    break;
                                                }
                                                break;
                                            case 109497044:
                                                if (next4.equals("skips")) {
                                                    c4 = 7;
                                                    break;
                                                }
                                                break;
                                            case 109638249:
                                                if (next4.equals("spans")) {
                                                    c4 = '\b';
                                                    break;
                                                }
                                                break;
                                            case 144441793:
                                                if (next4.equals("rowWeights")) {
                                                    c4 = '\t';
                                                    break;
                                                }
                                                break;
                                            case 949721053:
                                                if (next4.equals("columns")) {
                                                    c4 = '\n';
                                                    break;
                                                }
                                                break;
                                            case 2033353925:
                                                if (next4.equals("columnWeights")) {
                                                    c4 = 11;
                                                    break;
                                                }
                                                break;
                                        }
                                        c4 = 65535;
                                        switch (c4) {
                                            case 0:
                                                grid.setOrientation(cLObject8.get(next4).getInt());
                                                break;
                                            case 1:
                                                CLElement cLElement8 = cLObject8.get(next4);
                                                if (cLElement8 instanceof CLArray) {
                                                    CLArray cLArray5 = (CLArray) cLElement8;
                                                    if (cLArray5.size() > 1) {
                                                        float f22 = cLArray5.getInt(0);
                                                        f4 = cLArray5.getInt(1);
                                                        if (cLArray5.size() > 2) {
                                                            f2 = cLArray5.getInt(2);
                                                            try {
                                                                f3 = ((CLArray) cLElement8).getInt(3);
                                                                f = f22;
                                                            } catch (ArrayIndexOutOfBoundsException unused) {
                                                                f = f22;
                                                                f3 = RecyclerView.f7068F0;
                                                                grid.setPaddingStart(Math.round(state.f2350a.toPixels(f)));
                                                                grid.setPaddingTop(Math.round(state.f2350a.toPixels(f4)));
                                                                grid.setPaddingEnd(Math.round(state.f2350a.toPixels(f2)));
                                                                grid.setPaddingBottom(Math.round(state.f2350a.toPixels(f3)));
                                                                c10 = 5;
                                                            }
                                                        } else {
                                                            f3 = f4;
                                                            f = f22;
                                                            f2 = f;
                                                        }
                                                        grid.setPaddingStart(Math.round(state.f2350a.toPixels(f)));
                                                        grid.setPaddingTop(Math.round(state.f2350a.toPixels(f4)));
                                                        grid.setPaddingEnd(Math.round(state.f2350a.toPixels(f2)));
                                                        grid.setPaddingBottom(Math.round(state.f2350a.toPixels(f3)));
                                                    }
                                                }
                                                f = cLElement8.getInt();
                                                f2 = f;
                                                f3 = f2;
                                                f4 = f3;
                                                grid.setPaddingStart(Math.round(state.f2350a.toPixels(f)));
                                                grid.setPaddingTop(Math.round(state.f2350a.toPixels(f4)));
                                                grid.setPaddingEnd(Math.round(state.f2350a.toPixels(f2)));
                                                grid.setPaddingBottom(Math.round(state.f2350a.toPixels(f3)));
                                            case 2:
                                                CLArray arrayOrNull = cLObject8.getArrayOrNull(next4);
                                                if (arrayOrNull != null) {
                                                    for (int i10 = 0; i10 < arrayOrNull.size(); i10++) {
                                                        grid.add(state.constraints(arrayOrNull.get(i10).content()));
                                                    }
                                                    break;
                                                } else {
                                                    break;
                                                }
                                            case 3:
                                                grid.setHorizontalGaps(state.f2350a.toPixels(cLObject8.get(next4).getFloat()));
                                                break;
                                            case 4:
                                                int i11 = cLObject8.get(next4).getInt();
                                                if (i11 > 0) {
                                                    grid.setRowsSet(i11);
                                                    break;
                                                } else {
                                                    break;
                                                }
                                            case 5:
                                                grid.setVerticalGaps(state.f2350a.toPixels(cLObject8.get(next4).getFloat()));
                                                break;
                                            case 6:
                                                try {
                                                    cLElement = cLObject8.get(next4);
                                                } catch (Exception e) {
                                                    System.err.println("Error parsing grid flags " + e);
                                                    str13 = "";
                                                }
                                                if (cLElement instanceof CLNumber) {
                                                    i2 = cLElement.getInt();
                                                    str13 = "";
                                                    if (str13 == null && !str13.isEmpty()) {
                                                        grid.setFlags(str13);
                                                        break;
                                                    } else {
                                                        grid.setFlags(i2);
                                                        break;
                                                    }
                                                } else {
                                                    str13 = cLElement.content();
                                                    i2 = 0;
                                                    if (str13 == null) {
                                                    }
                                                    grid.setFlags(i2);
                                                }
                                            case 7:
                                                String content4 = cLObject8.get(next4).content();
                                                if (content4 != null && content4.contains(":")) {
                                                    grid.setSkips(content4);
                                                    break;
                                                }
                                                break;
                                            case '\b':
                                                String content5 = cLObject8.get(next4).content();
                                                if (content5 != null && content5.contains(":")) {
                                                    grid.setSpans(content5);
                                                    break;
                                                }
                                                break;
                                            case '\t':
                                                String content6 = cLObject8.get(next4).content();
                                                if (content6 != null && content6.contains(",")) {
                                                    grid.setRowWeights(content6);
                                                    break;
                                                }
                                                break;
                                            case '\n':
                                                int i12 = cLObject8.get(next4).getInt();
                                                if (i12 > 0) {
                                                    grid.setColumnsSet(i12);
                                                    break;
                                                } else {
                                                    break;
                                                }
                                            case 11:
                                                String content7 = cLObject8.get(next4).content();
                                                if (content7 != null && content7.contains(",")) {
                                                    grid.setColumnWeights(content7);
                                                    break;
                                                }
                                                break;
                                            default:
                                                m452a(cLObject8, state.constraints(next), layoutVariables, state, next4);
                                                break;
                                        }
                                        c10 = 5;
                                    }
                                    break;
                                case 2:
                                case 3:
                                    str3 = str28;
                                    str4 = str29;
                                    str5 = str30;
                                    str6 = str31;
                                    str9 = str;
                                    str14 = str37;
                                    str15 = str8;
                                    ChainReference horizontalChain = str36.charAt(0) == 'h' ? state.horizontalChain() : state.verticalChain();
                                    horizontalChain.setKey(next);
                                    Iterator<String> it11 = cLObject8.names().iterator();
                                    while (it11.hasNext()) {
                                        String next5 = it11.next();
                                        next5.getClass();
                                        switch (next5.hashCode()) {
                                            case -1383228885:
                                                if (next5.equals(str15)) {
                                                    c5 = 0;
                                                    break;
                                                }
                                                break;
                                            case -567445985:
                                                if (next5.equals("contains")) {
                                                    c5 = 1;
                                                    break;
                                                }
                                                break;
                                            case 100571:
                                                if (next5.equals(str14)) {
                                                    c5 = 2;
                                                    break;
                                                }
                                                break;
                                            case 115029:
                                                if (next5.equals("top")) {
                                                    c5 = 3;
                                                    break;
                                                }
                                                break;
                                            case 3317767:
                                                if (next5.equals("left")) {
                                                    c5 = 4;
                                                    break;
                                                }
                                                break;
                                            case 108511772:
                                                if (next5.equals("right")) {
                                                    c5 = 5;
                                                    break;
                                                }
                                                break;
                                            case 109757538:
                                                if (next5.equals(str9)) {
                                                    c5 = 6;
                                                    break;
                                                }
                                                break;
                                            case 109780401:
                                                if (next5.equals("style")) {
                                                    c5 = 7;
                                                    break;
                                                }
                                                break;
                                        }
                                        c5 = 65535;
                                        switch (c5) {
                                            case 0:
                                            case 2:
                                            case 3:
                                            case 4:
                                            case 5:
                                            case 6:
                                                it2 = it11;
                                                str8 = str15;
                                                str16 = str14;
                                                m455d(cLObject8, horizontalChain, layoutVariables, state, next5);
                                                str14 = str16;
                                                it11 = it2;
                                                str15 = str8;
                                            case 1:
                                                it2 = it11;
                                                str8 = str15;
                                                CLElement cLElement9 = cLObject8.get(next5);
                                                if (cLElement9 instanceof CLArray) {
                                                    CLArray cLArray6 = (CLArray) cLElement9;
                                                    if (cLArray6.size() >= 1) {
                                                        int i13 = 0;
                                                        while (i13 < cLArray6.size()) {
                                                            CLElement cLElement10 = cLArray6.get(i13);
                                                            if (cLElement10 instanceof CLArray) {
                                                                CLArray cLArray7 = (CLArray) cLElement10;
                                                                if (cLArray7.size() > 0) {
                                                                    String content8 = cLArray7.get(0).content();
                                                                    int size = cLArray7.size();
                                                                    cLArray = cLArray6;
                                                                    if (size == 2) {
                                                                        str17 = str14;
                                                                        f5 = cLArray7.getFloat(1);
                                                                        f6 = Float.NaN;
                                                                    } else {
                                                                        if (size == 3) {
                                                                            str17 = str14;
                                                                            f5 = cLArray7.getFloat(1);
                                                                            f6 = state.f2350a.toPixels(cLArray7.getFloat(2));
                                                                            f9 = f6;
                                                                        } else if (size == 4) {
                                                                            float f23 = cLArray7.getFloat(1);
                                                                            str17 = str14;
                                                                            f6 = state.f2350a.toPixels(cLArray7.getFloat(2));
                                                                            f9 = state.f2350a.toPixels(cLArray7.getFloat(3));
                                                                            f5 = f23;
                                                                        } else if (size != 6) {
                                                                            str17 = str14;
                                                                            f5 = Float.NaN;
                                                                            f6 = Float.NaN;
                                                                        } else {
                                                                            float f24 = cLArray7.getFloat(1);
                                                                            float pixels = state.f2350a.toPixels(cLArray7.getFloat(2));
                                                                            float pixels2 = state.f2350a.toPixels(cLArray7.getFloat(3));
                                                                            f8 = state.f2350a.toPixels(cLArray7.getFloat(4));
                                                                            f7 = state.f2350a.toPixels(cLArray7.getFloat(5));
                                                                            f5 = f24;
                                                                            f9 = pixels2;
                                                                            f6 = pixels;
                                                                            str17 = str14;
                                                                            horizontalChain.addChainElement(content8, f5, f6, f9, f8, f7);
                                                                        }
                                                                        f8 = Float.NaN;
                                                                        f7 = f8;
                                                                        horizontalChain.addChainElement(content8, f5, f6, f9, f8, f7);
                                                                    }
                                                                    f9 = f6;
                                                                    f8 = f9;
                                                                    f7 = f8;
                                                                    horizontalChain.addChainElement(content8, f5, f6, f9, f8, f7);
                                                                } else {
                                                                    cLArray = cLArray6;
                                                                    str17 = str14;
                                                                }
                                                                i3 = 1;
                                                            } else {
                                                                cLArray = cLArray6;
                                                                str17 = str14;
                                                                i3 = 1;
                                                                horizontalChain.add(cLElement10.content());
                                                            }
                                                            i13 += i3;
                                                            str14 = str17;
                                                            cLArray6 = cLArray;
                                                        }
                                                        str16 = str14;
                                                        str14 = str16;
                                                        it11 = it2;
                                                        str15 = str8;
                                                    }
                                                }
                                                str7 = str14;
                                                PrintStream printStream = System.err;
                                                StringBuilder m8303w = ye0.m8303w(next, " contains should be an array \"");
                                                m8303w.append(cLElement9.content());
                                                m8303w.append("\"");
                                                printStream.println(m8303w.toString());
                                                break;
                                            case 7:
                                                CLElement cLElement11 = cLObject8.get(next5);
                                                if (cLElement11 instanceof CLArray) {
                                                    CLArray cLArray8 = (CLArray) cLElement11;
                                                    it2 = it11;
                                                    str8 = str15;
                                                    if (cLArray8.size() > 1) {
                                                        content = cLArray8.getString(0);
                                                        horizontalChain.bias(cLArray8.getFloat(1));
                                                        content.getClass();
                                                        if (!content.equals("packed")) {
                                                            horizontalChain.style(State.Chain.PACKED);
                                                        } else if (!content.equals("spread_inside")) {
                                                            horizontalChain.style(State.Chain.SPREAD);
                                                        } else {
                                                            horizontalChain.style(State.Chain.SPREAD_INSIDE);
                                                        }
                                                        str16 = str14;
                                                        str14 = str16;
                                                        it11 = it2;
                                                        str15 = str8;
                                                    }
                                                } else {
                                                    it2 = it11;
                                                    str8 = str15;
                                                }
                                                content = cLElement11.content();
                                                content.getClass();
                                                if (!content.equals("packed")) {
                                                }
                                                str16 = str14;
                                                str14 = str16;
                                                it11 = it2;
                                                str15 = str8;
                                            default:
                                                it2 = it11;
                                                str8 = str15;
                                                str16 = str14;
                                                str14 = str16;
                                                it11 = it2;
                                                str15 = str8;
                                        }
                                    }
                                    str8 = str15;
                                    str7 = str14;
                                    break;
                                case 4:
                                    str3 = str28;
                                    str4 = str29;
                                    str5 = str30;
                                    str6 = str31;
                                    str9 = str;
                                    str14 = str37;
                                    str15 = str8;
                                    boolean isRtl = state.isRtl();
                                    BarrierReference barrier = state.barrier(next, State.Direction.END);
                                    ArrayList<String> names4 = cLObject8.names();
                                    if (names4 != null) {
                                        Iterator<String> it12 = names4.iterator();
                                        while (it12.hasNext()) {
                                            String next6 = it12.next();
                                            next6.getClass();
                                            switch (next6.hashCode()) {
                                                case -1081309778:
                                                    if (next6.equals("margin")) {
                                                        c6 = 0;
                                                        break;
                                                    }
                                                    break;
                                                case -962590849:
                                                    if (next6.equals("direction")) {
                                                        c6 = 1;
                                                        break;
                                                    }
                                                    break;
                                                case -567445985:
                                                    if (next6.equals("contains")) {
                                                        c6 = 2;
                                                        break;
                                                    }
                                                    break;
                                            }
                                            c6 = 65535;
                                            switch (c6) {
                                                case 0:
                                                    it3 = it12;
                                                    float floatOrNaN = cLObject8.getFloatOrNaN(next6);
                                                    if (Float.isNaN(floatOrNaN)) {
                                                        break;
                                                    } else {
                                                        barrier.margin(Float.valueOf(state.f2350a.toPixels(floatOrNaN)));
                                                        break;
                                                    }
                                                case 1:
                                                    it3 = it12;
                                                    String string2 = cLObject8.getString(next6);
                                                    string2.getClass();
                                                    switch (string2.hashCode()) {
                                                        case -1383228885:
                                                            if (string2.equals(str15)) {
                                                                c7 = 0;
                                                                break;
                                                            }
                                                            break;
                                                        case 100571:
                                                            if (string2.equals(str14)) {
                                                                c7 = 1;
                                                                break;
                                                            }
                                                            break;
                                                        case 115029:
                                                            if (string2.equals("top")) {
                                                                c7 = 2;
                                                                break;
                                                            }
                                                            break;
                                                        case 3317767:
                                                            if (string2.equals("left")) {
                                                                c7 = 3;
                                                                break;
                                                            }
                                                            break;
                                                        case 108511772:
                                                            if (string2.equals("right")) {
                                                                c7 = 4;
                                                                break;
                                                            }
                                                            break;
                                                        case 109757538:
                                                            if (string2.equals(str9)) {
                                                                c7 = 5;
                                                                break;
                                                            }
                                                            break;
                                                    }
                                                    c7 = 65535;
                                                    switch (c7) {
                                                        case 0:
                                                            barrier.setBarrierDirection(State.Direction.BOTTOM);
                                                            break;
                                                        case 1:
                                                            if (!isRtl) {
                                                                barrier.setBarrierDirection(State.Direction.RIGHT);
                                                                break;
                                                            } else {
                                                                barrier.setBarrierDirection(State.Direction.LEFT);
                                                                break;
                                                            }
                                                        case 2:
                                                            barrier.setBarrierDirection(State.Direction.TOP);
                                                            break;
                                                        case 3:
                                                            barrier.setBarrierDirection(State.Direction.LEFT);
                                                            break;
                                                        case 4:
                                                            barrier.setBarrierDirection(State.Direction.RIGHT);
                                                            break;
                                                        case 5:
                                                            if (!isRtl) {
                                                                barrier.setBarrierDirection(State.Direction.LEFT);
                                                                break;
                                                            } else {
                                                                barrier.setBarrierDirection(State.Direction.RIGHT);
                                                                break;
                                                            }
                                                    }
                                                case 2:
                                                    CLArray arrayOrNull2 = cLObject8.getArrayOrNull(next6);
                                                    if (arrayOrNull2 != null) {
                                                        int i14 = 0;
                                                        while (i14 < arrayOrNull2.size()) {
                                                            barrier.add(state.constraints(arrayOrNull2.get(i14).content()));
                                                            i14++;
                                                            it12 = it12;
                                                        }
                                                        break;
                                                    }
                                                    break;
                                            }
                                            it3 = it12;
                                            it12 = it3;
                                        }
                                    }
                                    str8 = str15;
                                    str7 = str14;
                                    break;
                                case 7:
                                case '\b':
                                    FlowReference flow = state.getFlow(next, str36.charAt(0) == 'v');
                                    Iterator<String> it13 = cLObject8.names().iterator();
                                    while (it13.hasNext()) {
                                        Iterator<String> it14 = it13;
                                        String next7 = it13.next();
                                        next7.getClass();
                                        switch (next7.hashCode()) {
                                            case -1254185091:
                                                str5 = str30;
                                                if (next7.equals("hAlign")) {
                                                    c8 = 0;
                                                    break;
                                                }
                                                break;
                                            case -1237307863:
                                                str5 = str30;
                                                if (next7.equals("hStyle")) {
                                                    c8 = 1;
                                                    break;
                                                }
                                                break;
                                            case -1198076529:
                                                str5 = str30;
                                                if (next7.equals("hFlowBias")) {
                                                    c8 = 2;
                                                    break;
                                                }
                                                break;
                                            case -853376977:
                                                str5 = str30;
                                                if (next7.equals("vAlign")) {
                                                    c8 = 3;
                                                    break;
                                                }
                                                break;
                                            case -836499749:
                                                str5 = str30;
                                                if (next7.equals("vStyle")) {
                                                    c8 = 4;
                                                    break;
                                                }
                                                break;
                                            case -806339567:
                                                str5 = str30;
                                                if (next7.equals("padding")) {
                                                    c8 = 5;
                                                    break;
                                                }
                                                break;
                                            case -732635235:
                                                str5 = str30;
                                                if (next7.equals("vFlowBias")) {
                                                    c8 = 6;
                                                    break;
                                                }
                                                break;
                                            case -567445985:
                                                str5 = str30;
                                                if (next7.equals("contains")) {
                                                    c8 = 7;
                                                    break;
                                                }
                                                break;
                                            case -488900360:
                                                str5 = str30;
                                                if (next7.equals("maxElement")) {
                                                    c8 = '\b';
                                                    break;
                                                }
                                                break;
                                            case 3169614:
                                                str5 = str30;
                                                if (next7.equals("hGap")) {
                                                    c8 = '\t';
                                                    break;
                                                }
                                                break;
                                            case 3575610:
                                                str5 = str30;
                                                if (next7.equals(str31)) {
                                                    c8 = '\n';
                                                    break;
                                                }
                                                break;
                                            case 3586688:
                                                str5 = str30;
                                                if (next7.equals("vGap")) {
                                                    c8 = 11;
                                                    break;
                                                }
                                                break;
                                            case 3657802:
                                                str5 = str30;
                                                if (next7.equals("wrap")) {
                                                    c8 = '\f';
                                                    break;
                                                }
                                                break;
                                            default:
                                                str5 = str30;
                                                break;
                                        }
                                        c8 = 65535;
                                        switch (c8) {
                                            case 0:
                                                str3 = str28;
                                                str18 = str29;
                                                str6 = str31;
                                                str19 = str8;
                                                String content9 = cLObject8.get(next7).content();
                                                content9.getClass();
                                                str20 = str37;
                                                if (content9.equals(str20)) {
                                                    str21 = str;
                                                    flow.setHorizontalAlign(1);
                                                } else {
                                                    str21 = str;
                                                    if (!content9.equals(str21)) {
                                                        flow.setHorizontalAlign(2);
                                                    } else {
                                                        flow.setHorizontalAlign(0);
                                                    }
                                                }
                                                str8 = str19;
                                                str37 = str20;
                                                str = str21;
                                                it13 = it14;
                                                str30 = str5;
                                                str28 = str3;
                                                str31 = str6;
                                                str29 = str18;
                                            case 1:
                                                str3 = str28;
                                                str18 = str29;
                                                str6 = str31;
                                                str19 = str8;
                                                CLElement cLElement12 = cLObject8.get(next7);
                                                if (cLElement12 instanceof CLArray) {
                                                    CLArray cLArray9 = (CLArray) cLElement12;
                                                    if (cLArray9.size() > 1) {
                                                        String string3 = cLArray9.getString(0);
                                                        content2 = cLArray9.getString(1);
                                                        str23 = cLArray9.size() > 2 ? cLArray9.getString(2) : "";
                                                        str22 = string3;
                                                        if (!content2.equals("")) {
                                                            flow.setHorizontalStyle(State.Chain.getValueByString(content2));
                                                        }
                                                        if (!str22.equals("")) {
                                                            flow.setFirstHorizontalStyle(State.Chain.getValueByString(str22));
                                                        }
                                                        if (!str23.equals("")) {
                                                            flow.setLastHorizontalStyle(State.Chain.getValueByString(str23));
                                                        }
                                                        str21 = str;
                                                        str20 = str37;
                                                        str8 = str19;
                                                        str37 = str20;
                                                        str = str21;
                                                        it13 = it14;
                                                        str30 = str5;
                                                        str28 = str3;
                                                        str31 = str6;
                                                        str29 = str18;
                                                    }
                                                }
                                                content2 = cLElement12.content();
                                                str22 = "";
                                                str23 = str22;
                                                if (!content2.equals("")) {
                                                }
                                                if (!str22.equals("")) {
                                                }
                                                if (!str23.equals("")) {
                                                }
                                                str21 = str;
                                                str20 = str37;
                                                str8 = str19;
                                                str37 = str20;
                                                str = str21;
                                                it13 = it14;
                                                str30 = str5;
                                                str28 = str3;
                                                str31 = str6;
                                                str29 = str18;
                                            case 2:
                                                str3 = str28;
                                                str18 = str29;
                                                str6 = str31;
                                                str19 = str8;
                                                CLElement cLElement13 = cLObject8.get(next7);
                                                Float valueOf3 = Float.valueOf(0.5f);
                                                Float valueOf4 = Float.valueOf(0.5f);
                                                if (cLElement13 instanceof CLArray) {
                                                    CLArray cLArray10 = (CLArray) cLElement13;
                                                    f10 = valueOf3;
                                                    f11 = valueOf4;
                                                    if (cLArray10.size() > 1) {
                                                        f12 = Float.valueOf(cLArray10.getFloat(0));
                                                        Float valueOf5 = Float.valueOf(cLArray10.getFloat(1));
                                                        if (cLArray10.size() > 2) {
                                                            f13 = Float.valueOf(cLArray10.getFloat(2));
                                                            valueOf = valueOf5;
                                                            flow.horizontalBias(valueOf.floatValue());
                                                            if (f12.floatValue() != 0.5f) {
                                                                flow.setFirstHorizontalBias(f12.floatValue());
                                                            }
                                                            if (f13.floatValue() != 0.5f) {
                                                                flow.setLastHorizontalBias(f13.floatValue());
                                                            }
                                                            str21 = str;
                                                            str20 = str37;
                                                            str8 = str19;
                                                            str37 = str20;
                                                            str = str21;
                                                            it13 = it14;
                                                            str30 = str5;
                                                            str28 = str3;
                                                            str31 = str6;
                                                            str29 = str18;
                                                        } else {
                                                            valueOf = valueOf5;
                                                            f13 = f11;
                                                            flow.horizontalBias(valueOf.floatValue());
                                                            if (f12.floatValue() != 0.5f) {
                                                            }
                                                            if (f13.floatValue() != 0.5f) {
                                                            }
                                                            str21 = str;
                                                            str20 = str37;
                                                            str8 = str19;
                                                            str37 = str20;
                                                            str = str21;
                                                            it13 = it14;
                                                            str30 = str5;
                                                            str28 = str3;
                                                            str31 = str6;
                                                            str29 = str18;
                                                        }
                                                    }
                                                } else {
                                                    f10 = valueOf3;
                                                    f11 = valueOf4;
                                                }
                                                valueOf = Float.valueOf(cLElement13.getFloat());
                                                f12 = f10;
                                                f13 = f11;
                                                flow.horizontalBias(valueOf.floatValue());
                                                if (f12.floatValue() != 0.5f) {
                                                }
                                                if (f13.floatValue() != 0.5f) {
                                                }
                                                str21 = str;
                                                str20 = str37;
                                                str8 = str19;
                                                str37 = str20;
                                                str = str21;
                                                it13 = it14;
                                                str30 = str5;
                                                str28 = str3;
                                                str31 = str6;
                                                str29 = str18;
                                            case 3:
                                                str3 = str28;
                                                str18 = str29;
                                                str6 = str31;
                                                String content10 = cLObject8.get(next7).content();
                                                content10.getClass();
                                                switch (content10.hashCode()) {
                                                    case -1720785339:
                                                        str19 = str8;
                                                        if (content10.equals("baseline")) {
                                                            c9 = 0;
                                                            break;
                                                        }
                                                        c9 = 65535;
                                                        break;
                                                    case -1383228885:
                                                        str19 = str8;
                                                        if (content10.equals(str19)) {
                                                            c9 = 1;
                                                            break;
                                                        }
                                                        c9 = 65535;
                                                        break;
                                                    case 115029:
                                                        if (content10.equals("top")) {
                                                            str19 = str8;
                                                            c9 = 2;
                                                            break;
                                                        }
                                                    default:
                                                        c9 = 65535;
                                                        str19 = str8;
                                                        break;
                                                }
                                                switch (c9) {
                                                    case 0:
                                                        flow.setVerticalAlign(3);
                                                        break;
                                                    case 1:
                                                        flow.setVerticalAlign(1);
                                                        break;
                                                    case 2:
                                                        flow.setVerticalAlign(0);
                                                        break;
                                                    default:
                                                        flow.setVerticalAlign(2);
                                                        break;
                                                }
                                                str21 = str;
                                                str20 = str37;
                                                str8 = str19;
                                                str37 = str20;
                                                str = str21;
                                                it13 = it14;
                                                str30 = str5;
                                                str28 = str3;
                                                str31 = str6;
                                                str29 = str18;
                                            case 4:
                                                str3 = str28;
                                                str18 = str29;
                                                str6 = str31;
                                                CLElement cLElement14 = cLObject8.get(next7);
                                                if (cLElement14 instanceof CLArray) {
                                                    CLArray cLArray11 = (CLArray) cLElement14;
                                                    if (cLArray11.size() > 1) {
                                                        str24 = cLArray11.getString(0);
                                                        content3 = cLArray11.getString(1);
                                                        str25 = cLArray11.size() > 2 ? cLArray11.getString(2) : "";
                                                        if (!content3.equals("")) {
                                                            flow.setVerticalStyle(State.Chain.getValueByString(content3));
                                                        }
                                                        if (!str24.equals("")) {
                                                            flow.setFirstVerticalStyle(State.Chain.getValueByString(str24));
                                                        }
                                                        if (!str25.equals("")) {
                                                            flow.setLastVerticalStyle(State.Chain.getValueByString(str25));
                                                        }
                                                        str21 = str;
                                                        str20 = str37;
                                                        str19 = str8;
                                                        str8 = str19;
                                                        str37 = str20;
                                                        str = str21;
                                                        it13 = it14;
                                                        str30 = str5;
                                                        str28 = str3;
                                                        str31 = str6;
                                                        str29 = str18;
                                                    }
                                                }
                                                content3 = cLElement14.content();
                                                str24 = "";
                                                str25 = str24;
                                                if (!content3.equals("")) {
                                                }
                                                if (!str24.equals("")) {
                                                }
                                                if (!str25.equals("")) {
                                                }
                                                str21 = str;
                                                str20 = str37;
                                                str19 = str8;
                                                str8 = str19;
                                                str37 = str20;
                                                str = str21;
                                                it13 = it14;
                                                str30 = str5;
                                                str28 = str3;
                                                str31 = str6;
                                                str29 = str18;
                                            case 5:
                                                str3 = str28;
                                                str18 = str29;
                                                str6 = str31;
                                                CLElement cLElement15 = cLObject8.get(next7);
                                                if (cLElement15 instanceof CLArray) {
                                                    CLArray cLArray12 = (CLArray) cLElement15;
                                                    if (cLArray12.size() > 1) {
                                                        float f25 = cLArray12.getInt(0);
                                                        f17 = cLArray12.getInt(1);
                                                        if (cLArray12.size() > 2) {
                                                            f16 = cLArray12.getInt(2);
                                                            try {
                                                                f15 = ((CLArray) cLElement15).getInt(3);
                                                                f14 = f25;
                                                            } catch (ArrayIndexOutOfBoundsException unused2) {
                                                                f14 = f25;
                                                                f15 = RecyclerView.f7068F0;
                                                            }
                                                        } else {
                                                            f15 = f17;
                                                            f16 = f25;
                                                            f14 = f16;
                                                        }
                                                        flow.setPaddingLeft(Math.round(state.f2350a.toPixels(f14)));
                                                        flow.setPaddingTop(Math.round(state.f2350a.toPixels(f17)));
                                                        flow.setPaddingRight(Math.round(state.f2350a.toPixels(f16)));
                                                        flow.setPaddingBottom(Math.round(state.f2350a.toPixels(f15)));
                                                        str21 = str;
                                                        str20 = str37;
                                                        str19 = str8;
                                                        str8 = str19;
                                                        str37 = str20;
                                                        str = str21;
                                                        it13 = it14;
                                                        str30 = str5;
                                                        str28 = str3;
                                                        str31 = str6;
                                                        str29 = str18;
                                                    }
                                                }
                                                f14 = cLElement15.getInt();
                                                f15 = f14;
                                                f16 = f15;
                                                f17 = f16;
                                                flow.setPaddingLeft(Math.round(state.f2350a.toPixels(f14)));
                                                flow.setPaddingTop(Math.round(state.f2350a.toPixels(f17)));
                                                flow.setPaddingRight(Math.round(state.f2350a.toPixels(f16)));
                                                flow.setPaddingBottom(Math.round(state.f2350a.toPixels(f15)));
                                                str21 = str;
                                                str20 = str37;
                                                str19 = str8;
                                                str8 = str19;
                                                str37 = str20;
                                                str = str21;
                                                it13 = it14;
                                                str30 = str5;
                                                str28 = str3;
                                                str31 = str6;
                                                str29 = str18;
                                            case 6:
                                                str3 = str28;
                                                str18 = str29;
                                                str6 = str31;
                                                CLElement cLElement16 = cLObject8.get(next7);
                                                Float valueOf6 = Float.valueOf(0.5f);
                                                Float valueOf7 = Float.valueOf(0.5f);
                                                if (cLElement16 instanceof CLArray) {
                                                    CLArray cLArray13 = (CLArray) cLElement16;
                                                    f18 = valueOf6;
                                                    if (cLArray13.size() > 1) {
                                                        Float valueOf8 = Float.valueOf(cLArray13.getFloat(0));
                                                        valueOf2 = Float.valueOf(cLArray13.getFloat(1));
                                                        f18 = valueOf8;
                                                        if (cLArray13.size() > 2) {
                                                            valueOf7 = Float.valueOf(cLArray13.getFloat(2));
                                                        }
                                                        flow.verticalBias(valueOf2.floatValue());
                                                        if (f18.floatValue() != 0.5f) {
                                                            flow.setFirstVerticalBias(f18.floatValue());
                                                        }
                                                        if (valueOf7.floatValue() != 0.5f) {
                                                            flow.setLastVerticalBias(valueOf7.floatValue());
                                                        }
                                                        str21 = str;
                                                        str20 = str37;
                                                        str19 = str8;
                                                        str8 = str19;
                                                        str37 = str20;
                                                        str = str21;
                                                        it13 = it14;
                                                        str30 = str5;
                                                        str28 = str3;
                                                        str31 = str6;
                                                        str29 = str18;
                                                    }
                                                } else {
                                                    f18 = valueOf6;
                                                }
                                                valueOf2 = Float.valueOf(cLElement16.getFloat());
                                                flow.verticalBias(valueOf2.floatValue());
                                                if (f18.floatValue() != 0.5f) {
                                                }
                                                if (valueOf7.floatValue() != 0.5f) {
                                                }
                                                str21 = str;
                                                str20 = str37;
                                                str19 = str8;
                                                str8 = str19;
                                                str37 = str20;
                                                str = str21;
                                                it13 = it14;
                                                str30 = str5;
                                                str28 = str3;
                                                str31 = str6;
                                                str29 = str18;
                                            case 7:
                                                CLElement cLElement17 = cLObject8.get(next7);
                                                if (cLElement17 instanceof CLArray) {
                                                    CLArray cLArray14 = (CLArray) cLElement17;
                                                    str3 = str28;
                                                    str6 = str31;
                                                    if (cLArray14.size() < 1) {
                                                        str4 = str29;
                                                    } else {
                                                        int i15 = 0;
                                                        while (i15 < cLArray14.size()) {
                                                            CLElement cLElement18 = cLArray14.get(i15);
                                                            if (cLElement18 instanceof CLArray) {
                                                                CLArray cLArray15 = (CLArray) cLElement18;
                                                                if (cLArray15.size() > 0) {
                                                                    String content11 = cLArray15.get(0).content();
                                                                    cLArray2 = cLArray14;
                                                                    int size2 = cLArray15.size();
                                                                    str26 = str29;
                                                                    if (size2 == 2) {
                                                                        f19 = cLArray15.getFloat(1);
                                                                        f20 = Float.NaN;
                                                                    } else if (size2 == 3) {
                                                                        float f26 = cLArray15.getFloat(1);
                                                                        f20 = state.f2350a.toPixels(cLArray15.getFloat(2));
                                                                        f19 = f26;
                                                                    } else {
                                                                        if (size2 != 4) {
                                                                            f20 = Float.NaN;
                                                                            f19 = Float.NaN;
                                                                            f21 = Float.NaN;
                                                                        } else {
                                                                            float f27 = cLArray15.getFloat(1);
                                                                            float pixels3 = state.f2350a.toPixels(cLArray15.getFloat(2));
                                                                            f20 = state.f2350a.toPixels(cLArray15.getFloat(3));
                                                                            f21 = pixels3;
                                                                            f19 = f27;
                                                                        }
                                                                        flow.addFlowElement(content11, f19, f21, f20);
                                                                    }
                                                                    f21 = f20;
                                                                    flow.addFlowElement(content11, f19, f21, f20);
                                                                } else {
                                                                    str26 = str29;
                                                                    cLArray2 = cLArray14;
                                                                }
                                                                i4 = 1;
                                                            } else {
                                                                str26 = str29;
                                                                cLArray2 = cLArray14;
                                                                i4 = 1;
                                                                flow.add(cLElement18.content());
                                                            }
                                                            i15 += i4;
                                                            cLArray14 = cLArray2;
                                                            str29 = str26;
                                                        }
                                                        str18 = str29;
                                                        str21 = str;
                                                        str20 = str37;
                                                        str19 = str8;
                                                        str8 = str19;
                                                        str37 = str20;
                                                        str = str21;
                                                        it13 = it14;
                                                        str30 = str5;
                                                        str28 = str3;
                                                        str31 = str6;
                                                        str29 = str18;
                                                    }
                                                } else {
                                                    str3 = str28;
                                                    str4 = str29;
                                                    str6 = str31;
                                                }
                                                PrintStream printStream2 = System.err;
                                                StringBuilder m8303w2 = ye0.m8303w(next, " contains should be an array \"");
                                                m8303w2.append(cLElement17.content());
                                                m8303w2.append("\"");
                                                printStream2.println(m8303w2.toString());
                                                break;
                                            case '\b':
                                                flow.setMaxElementsWrap(cLObject8.get(next7).getInt());
                                                str3 = str28;
                                                str18 = str29;
                                                str6 = str31;
                                                str21 = str;
                                                str20 = str37;
                                                str19 = str8;
                                                str8 = str19;
                                                str37 = str20;
                                                str = str21;
                                                it13 = it14;
                                                str30 = str5;
                                                str28 = str3;
                                                str31 = str6;
                                                str29 = str18;
                                            case '\t':
                                                flow.setHorizontalGap(cLObject8.get(next7).getInt());
                                                str3 = str28;
                                                str18 = str29;
                                                str6 = str31;
                                                str21 = str;
                                                str20 = str37;
                                                str19 = str8;
                                                str8 = str19;
                                                str37 = str20;
                                                str = str21;
                                                it13 = it14;
                                                str30 = str5;
                                                str28 = str3;
                                                str31 = str6;
                                                str29 = str18;
                                            case '\n':
                                                if (cLObject8.get(next7).content().equals(str28)) {
                                                    flow.setOrientation(0);
                                                } else {
                                                    flow.setOrientation(1);
                                                }
                                                str3 = str28;
                                                str18 = str29;
                                                str6 = str31;
                                                str21 = str;
                                                str20 = str37;
                                                str19 = str8;
                                                str8 = str19;
                                                str37 = str20;
                                                str = str21;
                                                it13 = it14;
                                                str30 = str5;
                                                str28 = str3;
                                                str31 = str6;
                                                str29 = str18;
                                            case 11:
                                                flow.setVerticalGap(cLObject8.get(next7).getInt());
                                                str3 = str28;
                                                str18 = str29;
                                                str6 = str31;
                                                str21 = str;
                                                str20 = str37;
                                                str19 = str8;
                                                str8 = str19;
                                                str37 = str20;
                                                str = str21;
                                                it13 = it14;
                                                str30 = str5;
                                                str28 = str3;
                                                str31 = str6;
                                                str29 = str18;
                                            case '\f':
                                                flow.setWrapMode(State.Wrap.getValueByString(cLObject8.get(next7).content()));
                                                str3 = str28;
                                                str18 = str29;
                                                str6 = str31;
                                                str21 = str;
                                                str20 = str37;
                                                str19 = str8;
                                                str8 = str19;
                                                str37 = str20;
                                                str = str21;
                                                it13 = it14;
                                                str30 = str5;
                                                str28 = str3;
                                                str31 = str6;
                                                str29 = str18;
                                            default:
                                                m452a(cLObject8, state.constraints(next), layoutVariables, state, next7);
                                                str3 = str28;
                                                str18 = str29;
                                                str6 = str31;
                                                str21 = str;
                                                str20 = str37;
                                                str19 = str8;
                                                str8 = str19;
                                                str37 = str20;
                                                str = str21;
                                                it13 = it14;
                                                str30 = str5;
                                                str28 = str3;
                                                str31 = str6;
                                                str29 = str18;
                                        }
                                        str9 = str;
                                        str14 = str37;
                                        str15 = str8;
                                        str8 = str15;
                                        str7 = str14;
                                        break;
                                    }
                                    str3 = str28;
                                    str4 = str29;
                                    str5 = str30;
                                    str6 = str31;
                                    str9 = str;
                                    str14 = str37;
                                    str15 = str8;
                                    str8 = str15;
                                    str7 = str14;
                                case '\t':
                                    m459h(0, state, next, cLObject8);
                                default:
                                    str3 = str28;
                                    str4 = str29;
                                    str5 = str30;
                                    str6 = str31;
                                    str9 = str;
                                    str7 = str37;
                                    break;
                            }
                        } else {
                            str2 = str27;
                            str3 = str28;
                            str4 = str29;
                            str5 = str30;
                            str6 = str31;
                            str7 = str33;
                            str8 = str34;
                            str9 = str;
                            m460i(state, layoutVariables, next, cLObject8);
                            break;
                        }
                    } else {
                        str2 = str27;
                        str3 = str28;
                        str4 = str29;
                        str5 = str30;
                        str6 = str31;
                        str7 = str33;
                        str8 = str34;
                        str9 = str;
                        if (cLElement2 instanceof CLNumber) {
                            layoutVariables.f2334a.put(next, Integer.valueOf(cLElement2.getInt()));
                            break;
                        }
                    }
                    break;
            }
            str27 = str2;
            str29 = str4;
            str33 = str7;
            str28 = str3;
            str31 = str6;
            str32 = str9;
            str30 = str5;
            str34 = str8;
        }
    }

    public static void parseJSON(String str, State state, LayoutVariables layoutVariables) {
        try {
            populateState(CLParser.parse(str), state, layoutVariables);
        } catch (CLParsingException e) {
            System.err.println("Error parsing JSON " + e);
        }
    }
}
