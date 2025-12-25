package androidx.constraintlayout.core.state;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLArray;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import java.lang.reflect.Array;
import p000.tv2;
import p000.ye0;

/* loaded from: classes.dex */
public class TransitionParser {
    /* renamed from: a */
    public static int m462a(String str, String... strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals(str)) {
                return i;
            }
        }
        return 0;
    }

    @Deprecated
    public static void parse(CLObject cLObject, Transition transition, CorePixelDp corePixelDp) {
        parse(cLObject, transition);
    }

    public static void parseKeyFrames(CLObject cLObject, Transition transition) {
        String str;
        String str2;
        CLArray cLArray;
        int i;
        String str3;
        TypedBundle[] typedBundleArr;
        int i2;
        int i3;
        int i4;
        CLArray cLArray2;
        CLObject cLObject2;
        int i5;
        Transition transition2;
        String str4;
        CLArray cLArray3;
        CustomVariable[][] customVariableArr;
        Transition transition3;
        CustomVariable[] customVariableArr2;
        int i6;
        CLArray cLArray4;
        Transition transition4;
        String str5;
        int i7;
        CLObject cLObject3;
        CLArray cLArray5;
        String str6;
        String str7;
        String str8;
        String str9;
        Transition transition5 = transition;
        String str10 = "spline";
        CLObject objectOrNull = cLObject.getObjectOrNull("KeyFrames");
        if (objectOrNull == null) {
            return;
        }
        CLArray arrayOrNull = objectOrNull.getArrayOrNull("KeyPositions");
        String str11 = "curveFit";
        String str12 = "transitionEasing";
        String str13 = "frames";
        String str14 = TypedValues.AttributesType.S_TARGET;
        if (arrayOrNull != null) {
            int i8 = 0;
            while (i8 < arrayOrNull.size()) {
                CLElement cLElement = arrayOrNull.get(i8);
                if (cLElement instanceof CLObject) {
                    CLObject cLObject4 = (CLObject) cLElement;
                    TypedBundle typedBundle = new TypedBundle();
                    CLArray array = cLObject4.getArray(str14);
                    CLArray array2 = cLObject4.getArray(str13);
                    CLArray arrayOrNull2 = cLObject4.getArrayOrNull("percentX");
                    CLArray arrayOrNull3 = cLObject4.getArrayOrNull("percentY");
                    cLArray5 = arrayOrNull;
                    CLArray arrayOrNull4 = cLObject4.getArrayOrNull("percentWidth");
                    str8 = str13;
                    CLArray arrayOrNull5 = cLObject4.getArrayOrNull("percentHeight");
                    str5 = str14;
                    String stringOrNull = cLObject4.getStringOrNull(TypedValues.TransitionType.S_PATH_MOTION_ARC);
                    cLObject3 = objectOrNull;
                    String stringOrNull2 = cLObject4.getStringOrNull(str12);
                    str7 = str12;
                    String stringOrNull3 = cLObject4.getStringOrNull(str11);
                    str6 = str11;
                    String stringOrNull4 = cLObject4.getStringOrNull("type");
                    if (stringOrNull4 == null) {
                        stringOrNull4 = "parentRelative";
                    }
                    i7 = i8;
                    if ((arrayOrNull2 == null || array2.size() == arrayOrNull2.size()) && (arrayOrNull3 == null || array2.size() == arrayOrNull3.size())) {
                        int i9 = 0;
                        while (i9 < array.size()) {
                            String string = array.getString(i9);
                            CLArray cLArray6 = array;
                            int i10 = i9;
                            int m462a = m462a(stringOrNull4, "deltaRelative", "pathRelative", "parentRelative");
                            typedBundle.clear();
                            typedBundle.add(510, m462a);
                            if (stringOrNull3 != null) {
                                String[] strArr = {"spline", "linear"};
                                str9 = stringOrNull4;
                                int i11 = 0;
                                for (int i12 = 2; i11 < i12; i12 = 2) {
                                    if (strArr[i11].equals(stringOrNull3)) {
                                        typedBundle.add(508, i11);
                                    }
                                    i11++;
                                }
                            } else {
                                str9 = stringOrNull4;
                            }
                            typedBundle.addIfNotNull(501, stringOrNull2);
                            if (stringOrNull != null) {
                                String[] strArr2 = {SchedulerSupport.NONE, "startVertical", "startHorizontal", "flip", "below", "above"};
                                for (int i13 = 0; i13 < 6; i13++) {
                                    if (strArr2[i13].equals(stringOrNull)) {
                                        typedBundle.add(509, i13);
                                    }
                                }
                            }
                            for (int i14 = 0; i14 < array2.size(); i14++) {
                                typedBundle.add(100, array2.getInt(i14));
                                if (arrayOrNull2 != null) {
                                    typedBundle.add(506, arrayOrNull2.getFloat(i14));
                                }
                                if (arrayOrNull3 != null) {
                                    typedBundle.add(507, arrayOrNull3.getFloat(i14));
                                }
                                if (arrayOrNull4 != null) {
                                    typedBundle.add(503, arrayOrNull4.getFloat(i14));
                                }
                                if (arrayOrNull5 != null) {
                                    typedBundle.add(504, arrayOrNull5.getFloat(i14));
                                }
                                transition.addKeyPosition(string, typedBundle);
                            }
                            i9 = i10 + 1;
                            array = cLArray6;
                            stringOrNull4 = str9;
                        }
                    }
                    transition4 = transition;
                } else {
                    transition4 = transition5;
                    str5 = str14;
                    i7 = i8;
                    cLObject3 = objectOrNull;
                    cLArray5 = arrayOrNull;
                    str6 = str11;
                    str7 = str12;
                    str8 = str13;
                }
                i8 = i7 + 1;
                transition5 = transition4;
                arrayOrNull = cLArray5;
                str13 = str8;
                str14 = str5;
                objectOrNull = cLObject3;
                str12 = str7;
                str11 = str6;
            }
        }
        Transition transition6 = transition5;
        String str15 = str14;
        String str16 = str11;
        String str17 = str12;
        String str18 = str13;
        CLObject cLObject5 = objectOrNull;
        CLArray arrayOrNull6 = cLObject5.getArrayOrNull(TypedValues.AttributesType.NAME);
        if (arrayOrNull6 != null) {
            int i15 = 0;
            while (i15 < arrayOrNull6.size()) {
                CLElement cLElement2 = arrayOrNull6.get(i15);
                if (cLElement2 instanceof CLObject) {
                    CLObject cLObject6 = (CLObject) cLElement2;
                    String str19 = str15;
                    CLArray arrayOrNull7 = cLObject6.getArrayOrNull(str19);
                    if (arrayOrNull7 == null) {
                        cLArray2 = arrayOrNull6;
                        cLObject2 = cLObject5;
                        i5 = i15;
                        transition2 = transition6;
                        str15 = str19;
                    } else {
                        String str20 = str18;
                        CLArray arrayOrNull8 = cLObject6.getArrayOrNull(str20);
                        if (arrayOrNull8 == null) {
                            cLArray2 = arrayOrNull6;
                            cLObject2 = cLObject5;
                            i5 = i15;
                            transition2 = transition6;
                            str15 = str19;
                            str18 = str20;
                        } else {
                            String stringOrNull5 = cLObject6.getStringOrNull(str17);
                            String[] strArr3 = {"scaleX", "scaleY", "translationX", "translationY", "translationZ", "rotationX", "rotationY", "rotationZ", "alpha"};
                            int[] iArr = {311, 312, 304, 305, 306, 308, 309, 310, 303};
                            cLArray2 = arrayOrNull6;
                            boolean[] zArr = {false, false, true, true, true, false, false, false, false};
                            int size = arrayOrNull8.size();
                            TypedBundle[] typedBundleArr2 = new TypedBundle[size];
                            str15 = str19;
                            str18 = str20;
                            for (int i16 = 0; i16 < arrayOrNull8.size(); i16++) {
                                typedBundleArr2[i16] = new TypedBundle();
                            }
                            int i17 = 0;
                            while (i17 < 9) {
                                String str21 = strArr3[i17];
                                String[] strArr4 = strArr3;
                                int i18 = iArr[i17];
                                boolean z = zArr[i17];
                                boolean[] zArr2 = zArr;
                                CLArray arrayOrNull9 = cLObject6.getArrayOrNull(str21);
                                int[] iArr2 = iArr;
                                if (arrayOrNull9 != null && arrayOrNull9.size() != size) {
                                    throw new CLParsingException(ye0.m8296p("incorrect size for ", str21, " array, not matching targets array!"), cLObject6);
                                }
                                if (arrayOrNull9 != null) {
                                    int i19 = 0;
                                    while (i19 < size) {
                                        float f = arrayOrNull9.getFloat(i19);
                                        CLArray cLArray7 = arrayOrNull9;
                                        if (z) {
                                            f = transition6.f2370i.toPixels(f);
                                        }
                                        typedBundleArr2[i19].add(i18, f);
                                        i19++;
                                        arrayOrNull9 = cLArray7;
                                    }
                                } else {
                                    float floatOrNaN = cLObject6.getFloatOrNaN(str21);
                                    if (!Float.isNaN(floatOrNaN)) {
                                        if (z) {
                                            floatOrNaN = transition6.f2370i.toPixels(floatOrNaN);
                                        }
                                        for (int i20 = 0; i20 < size; i20++) {
                                            typedBundleArr2[i20].add(i18, floatOrNaN);
                                        }
                                    }
                                }
                                i17++;
                                strArr3 = strArr4;
                                zArr = zArr2;
                                iArr = iArr2;
                            }
                            CLElement orNull = cLObject6.getOrNull(SchedulerSupport.CUSTOM);
                            if (orNull != null && (orNull instanceof CLObject)) {
                                CLObject cLObject7 = (CLObject) orNull;
                                int size2 = cLObject7.size();
                                customVariableArr = (CustomVariable[][]) Array.newInstance((Class<?>) CustomVariable.class, arrayOrNull8.size(), size2);
                                int i21 = 0;
                                while (i21 < size2) {
                                    CLKey cLKey = (CLKey) cLObject7.get(i21);
                                    CLObject cLObject8 = cLObject7;
                                    String content = cLKey.content();
                                    int i22 = size2;
                                    CLObject cLObject9 = cLObject5;
                                    if (cLKey.getValue() instanceof CLArray) {
                                        CLArray cLArray8 = (CLArray) cLKey.getValue();
                                        int size3 = cLArray8.size();
                                        if (size3 == size && size3 > 0) {
                                            if (cLArray8.get(0) instanceof CLNumber) {
                                                int i23 = 0;
                                                while (i23 < size) {
                                                    customVariableArr[i23][i21] = new CustomVariable(content, TypedValues.Custom.TYPE_FLOAT, cLArray8.get(i23).getFloat());
                                                    i23++;
                                                    i15 = i15;
                                                    arrayOrNull8 = arrayOrNull8;
                                                }
                                            } else {
                                                i6 = i15;
                                                cLArray4 = arrayOrNull8;
                                                for (int i24 = 0; i24 < size; i24++) {
                                                    long m454c = ConstraintSetParser.m454c(cLArray8.get(i24).content());
                                                    if (m454c != -1) {
                                                        customVariableArr[i24][i21] = new CustomVariable(content, TypedValues.Custom.TYPE_COLOR, (int) m454c);
                                                    }
                                                }
                                            }
                                        }
                                        i6 = i15;
                                        cLArray4 = arrayOrNull8;
                                    } else {
                                        i6 = i15;
                                        cLArray4 = arrayOrNull8;
                                        CLElement value = cLKey.getValue();
                                        if (value instanceof CLNumber) {
                                            float f2 = value.getFloat();
                                            for (int i25 = 0; i25 < size; i25++) {
                                                customVariableArr[i25][i21] = new CustomVariable(content, TypedValues.Custom.TYPE_FLOAT, f2);
                                            }
                                        } else {
                                            long m454c2 = ConstraintSetParser.m454c(value.content());
                                            if (m454c2 != -1) {
                                                int i26 = 0;
                                                while (i26 < size) {
                                                    customVariableArr[i26][i21] = new CustomVariable(content, TypedValues.Custom.TYPE_COLOR, (int) m454c2);
                                                    i26++;
                                                    m454c2 = m454c2;
                                                }
                                            }
                                        }
                                    }
                                    i21++;
                                    cLObject7 = cLObject8;
                                    size2 = i22;
                                    cLObject5 = cLObject9;
                                    i15 = i6;
                                    arrayOrNull8 = cLArray4;
                                }
                                cLObject2 = cLObject5;
                                i5 = i15;
                                cLArray3 = arrayOrNull8;
                                str4 = str16;
                            } else {
                                cLObject2 = cLObject5;
                                i5 = i15;
                                cLArray3 = arrayOrNull8;
                                str4 = str16;
                                customVariableArr = null;
                            }
                            String stringOrNull6 = cLObject6.getStringOrNull(str4);
                            for (int i27 = 0; i27 < arrayOrNull7.size(); i27++) {
                                int i28 = 0;
                                while (i28 < size) {
                                    String string2 = arrayOrNull7.getString(i27);
                                    TypedBundle typedBundle2 = typedBundleArr2[i28];
                                    if (stringOrNull6 != null) {
                                        typedBundle2.add(508, m462a(stringOrNull6, "spline", "linear"));
                                    }
                                    typedBundle2.addIfNotNull(501, stringOrNull5);
                                    CLArray cLArray9 = cLArray3;
                                    typedBundle2.add(100, cLArray9.getInt(i28));
                                    if (customVariableArr != null) {
                                        customVariableArr2 = customVariableArr[i28];
                                        transition3 = transition;
                                    } else {
                                        transition3 = transition;
                                        customVariableArr2 = null;
                                    }
                                    transition3.addKeyAttribute(string2, typedBundle2, customVariableArr2);
                                    i28++;
                                    cLArray3 = cLArray9;
                                }
                            }
                            transition2 = transition;
                            i15 = i5 + 1;
                            str16 = str4;
                            transition6 = transition2;
                            arrayOrNull6 = cLArray2;
                            cLObject5 = cLObject2;
                        }
                    }
                } else {
                    cLArray2 = arrayOrNull6;
                    cLObject2 = cLObject5;
                    i5 = i15;
                    transition2 = transition6;
                }
                str4 = str16;
                i15 = i5 + 1;
                str16 = str4;
                transition6 = transition2;
                arrayOrNull6 = cLArray2;
                cLObject5 = cLObject2;
            }
        }
        Transition transition7 = transition6;
        String str22 = str16;
        CLArray arrayOrNull10 = cLObject5.getArrayOrNull("KeyCycles");
        if (arrayOrNull10 != null) {
            int i29 = 0;
            while (i29 < arrayOrNull10.size()) {
                CLElement cLElement3 = arrayOrNull10.get(i29);
                if (cLElement3 instanceof CLObject) {
                    CLObject cLObject10 = (CLObject) cLElement3;
                    String str23 = str15;
                    CLArray array3 = cLObject10.getArray(str23);
                    String str24 = str18;
                    CLArray array4 = cLObject10.getArray(str24);
                    String str25 = str17;
                    String stringOrNull7 = cLObject10.getStringOrNull(str25);
                    String[] strArr5 = {"scaleX", "scaleY", "translationX", "translationY", "translationZ", "rotationX", "rotationY", "rotationZ", "alpha", TypedValues.CycleType.S_WAVE_PERIOD, TypedValues.CycleType.S_WAVE_OFFSET, TypedValues.CycleType.S_WAVE_PHASE};
                    int[] iArr3 = {311, 312, 304, 305, 306, 308, 309, 310, 403, 423, 424, 425};
                    cLArray = arrayOrNull10;
                    int[] iArr4 = {0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 2, 0};
                    int size4 = array4.size();
                    str15 = str23;
                    TypedBundle[] typedBundleArr3 = new TypedBundle[size4];
                    str18 = str24;
                    int i30 = 0;
                    while (i30 < size4) {
                        typedBundleArr3[i30] = new TypedBundle();
                        i30++;
                        str25 = str25;
                    }
                    str17 = str25;
                    int i31 = 0;
                    int i32 = 12;
                    boolean z2 = false;
                    while (i31 < i32) {
                        if (cLObject10.has(strArr5[i31])) {
                            i3 = i29;
                            i4 = 1;
                            if (iArr4[i31] == 1) {
                                z2 = true;
                            }
                        } else {
                            i3 = i29;
                            i4 = 1;
                        }
                        i31 += i4;
                        i29 = i3;
                        i32 = 12;
                    }
                    i = i29;
                    int i33 = 0;
                    for (int i34 = i32; i33 < i34; i34 = 12) {
                        String str26 = strArr5[i33];
                        int i35 = iArr3[i33];
                        String[] strArr6 = strArr5;
                        int i36 = iArr4[i33];
                        int[] iArr5 = iArr4;
                        CLArray arrayOrNull11 = cLObject10.getArrayOrNull(str26);
                        int[] iArr6 = iArr3;
                        if (arrayOrNull11 != null && arrayOrNull11.size() != size4) {
                            throw new CLParsingException("incorrect size for $attrName array, not matching targets array!", cLObject10);
                        }
                        if (arrayOrNull11 != null) {
                            int i37 = 0;
                            while (i37 < size4) {
                                float f3 = arrayOrNull11.getFloat(i37);
                                CLArray cLArray10 = arrayOrNull11;
                                if (i36 == 1) {
                                    f3 = transition7.f2370i.toPixels(f3);
                                } else if (i36 == 2 && z2) {
                                    f3 = transition7.f2370i.toPixels(f3);
                                }
                                typedBundleArr3[i37].add(i35, f3);
                                i37++;
                                arrayOrNull11 = cLArray10;
                            }
                        } else {
                            float floatOrNaN2 = cLObject10.getFloatOrNaN(str26);
                            if (!Float.isNaN(floatOrNaN2)) {
                                if (i36 == 1) {
                                    floatOrNaN2 = transition7.f2370i.toPixels(floatOrNaN2);
                                } else if (i36 == 2 && z2) {
                                    floatOrNaN2 = transition7.f2370i.toPixels(floatOrNaN2);
                                }
                                for (int i38 = 0; i38 < size4; i38++) {
                                    typedBundleArr3[i38].add(i35, floatOrNaN2);
                                }
                            } else {
                                i2 = 1;
                                i33 += i2;
                                strArr5 = strArr6;
                                iArr4 = iArr5;
                                iArr3 = iArr6;
                            }
                        }
                        i2 = 1;
                        i33 += i2;
                        strArr5 = strArr6;
                        iArr4 = iArr5;
                        iArr3 = iArr6;
                    }
                    String stringOrNull8 = cLObject10.getStringOrNull(str22);
                    String stringOrNull9 = cLObject10.getStringOrNull("easing");
                    String stringOrNull10 = cLObject10.getStringOrNull("waveShape");
                    String stringOrNull11 = cLObject10.getStringOrNull(TypedValues.CycleType.S_CUSTOM_WAVE_SHAPE);
                    int i39 = 0;
                    while (i39 < array3.size()) {
                        int i40 = 0;
                        while (i40 < size4) {
                            String string3 = array3.getString(i39);
                            String str27 = str22;
                            TypedBundle typedBundle3 = typedBundleArr3[i40];
                            if (stringOrNull8 != null) {
                                typedBundleArr = typedBundleArr3;
                                if (!stringOrNull8.equals("linear")) {
                                    if (!stringOrNull8.equals(str10)) {
                                        str3 = str10;
                                    } else {
                                        str3 = str10;
                                        typedBundle3.add(401, 0);
                                    }
                                } else {
                                    str3 = str10;
                                    typedBundle3.add(401, 1);
                                }
                            } else {
                                str3 = str10;
                                typedBundleArr = typedBundleArr3;
                            }
                            typedBundle3.addIfNotNull(501, stringOrNull7);
                            if (stringOrNull9 != null) {
                                typedBundle3.add(420, stringOrNull9);
                            }
                            if (stringOrNull10 != null) {
                                typedBundle3.add(421, stringOrNull10);
                            }
                            if (stringOrNull11 != null) {
                                typedBundle3.add(422, stringOrNull11);
                            }
                            typedBundle3.add(100, array4.getInt(i40));
                            transition7.addKeyCycle(string3, typedBundle3);
                            i40++;
                            typedBundleArr3 = typedBundleArr;
                            str10 = str3;
                            str22 = str27;
                        }
                        i39++;
                        str10 = str10;
                        str22 = str22;
                    }
                    str = str22;
                    str2 = str10;
                } else {
                    str = str22;
                    str2 = str10;
                    cLArray = arrayOrNull10;
                    i = i29;
                }
                i29 = i + 1;
                arrayOrNull10 = cLArray;
                str10 = str2;
                str22 = str;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [tv2, java.lang.Object] */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void parse(@NonNull CLObject cLObject, @NonNull Transition transition) {
        boolean z;
        boolean z2 = true;
        transition.f2369h = null;
        transition.f2364c.clear();
        String stringOrNull = cLObject.getStringOrNull(TypedValues.TransitionType.S_PATH_MOTION_ARC);
        TypedBundle typedBundle = new TypedBundle();
        if (stringOrNull != null) {
            char c = 65535;
            switch (stringOrNull.hashCode()) {
                case -1857024520:
                    if (stringOrNull.equals("startVertical")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1007052250:
                    if (stringOrNull.equals("startHorizontal")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3145837:
                    if (stringOrNull.equals("flip")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3387192:
                    if (stringOrNull.equals(SchedulerSupport.NONE)) {
                        c = 3;
                        break;
                    }
                    break;
                case 92611485:
                    if (stringOrNull.equals("above")) {
                        c = 4;
                        break;
                    }
                    break;
                case 93621297:
                    if (stringOrNull.equals("below")) {
                        c = 5;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    typedBundle.add(509, 1);
                    break;
                case 1:
                    typedBundle.add(509, 2);
                    break;
                case 2:
                    typedBundle.add(509, 3);
                    break;
                case 3:
                    typedBundle.add(509, 0);
                    break;
                case 4:
                    typedBundle.add(509, 5);
                    break;
                case 5:
                    typedBundle.add(509, 4);
                    break;
            }
            z = true;
        } else {
            z = false;
        }
        String stringOrNull2 = cLObject.getStringOrNull("interpolator");
        if (stringOrNull2 != null) {
            typedBundle.add(TypedValues.TransitionType.TYPE_INTERPOLATOR, stringOrNull2);
            z = true;
        }
        float floatOrNaN = cLObject.getFloatOrNaN(TypedValues.TransitionType.S_STAGGERED);
        if (Float.isNaN(floatOrNaN)) {
            z2 = z;
        } else {
            typedBundle.add(TypedValues.TransitionType.TYPE_STAGGERED, floatOrNaN);
        }
        if (z2) {
            transition.setTransitionProperties(typedBundle);
        }
        CLObject objectOrNull = cLObject.getObjectOrNull("onSwipe");
        if (objectOrNull != null) {
            String stringOrNull3 = objectOrNull.getStringOrNull("anchor");
            int m462a = m462a(objectOrNull.getStringOrNull("side"), tv2.f26978r);
            int m462a2 = m462a(objectOrNull.getStringOrNull("direction"), tv2.f26980t);
            float floatOrNaN2 = objectOrNull.getFloatOrNaN("scale");
            float floatOrNaN3 = objectOrNull.getFloatOrNaN("threshold");
            float floatOrNaN4 = objectOrNull.getFloatOrNaN("maxVelocity");
            float floatOrNaN5 = objectOrNull.getFloatOrNaN("maxAccel");
            String stringOrNull4 = objectOrNull.getStringOrNull("limitBounds");
            int m462a3 = m462a(objectOrNull.getStringOrNull("mode"), tv2.f26981u);
            int m462a4 = m462a(objectOrNull.getStringOrNull("touchUp"), tv2.f26982v);
            float floatOrNaN6 = objectOrNull.getFloatOrNaN("springMass");
            float floatOrNaN7 = objectOrNull.getFloatOrNaN("springStiffness");
            float floatOrNaN8 = objectOrNull.getFloatOrNaN("springDamping");
            float floatOrNaN9 = objectOrNull.getFloatOrNaN("stopThreshold");
            int m462a5 = m462a(objectOrNull.getStringOrNull("springBoundary"), tv2.f26983w);
            objectOrNull.getStringOrNull("around");
            ?? obj = new Object();
            obj.f26990f = 1.0f;
            obj.f26991g = 0;
            obj.f26992h = 4.0f;
            obj.f26993i = 1.2f;
            obj.f26994j = 0;
            obj.f26995k = 1.0f;
            obj.f26996l = 400.0f;
            obj.f26997m = 10.0f;
            obj.f26998n = 0.01f;
            obj.f26999o = RecyclerView.f7068F0;
            obj.f27000p = 0;
            transition.f2369h = obj;
            obj.f26985a = stringOrNull3;
            obj.f26986b = m462a;
            obj.f26989e = m462a2;
            if (!Float.isNaN(floatOrNaN2)) {
                obj.f26990f = floatOrNaN2;
            }
            Float.isNaN(floatOrNaN3);
            if (!Float.isNaN(floatOrNaN4)) {
                obj.f26992h = floatOrNaN4;
            }
            if (!Float.isNaN(floatOrNaN5)) {
                obj.f26993i = floatOrNaN5;
            }
            obj.f26988d = stringOrNull4;
            obj.f26991g = m462a3;
            obj.f26994j = m462a4;
            if (!Float.isNaN(floatOrNaN6)) {
                obj.f26995k = floatOrNaN6;
            }
            if (!Float.isNaN(floatOrNaN7)) {
                obj.f26996l = floatOrNaN7;
            }
            if (!Float.isNaN(floatOrNaN8)) {
                obj.f26997m = floatOrNaN8;
            }
            if (!Float.isNaN(floatOrNaN9)) {
                obj.f26998n = floatOrNaN9;
            }
            obj.f27000p = m462a5;
        }
        parseKeyFrames(cLObject, transition);
    }
}
