package p000;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* loaded from: classes.dex */
public abstract /* synthetic */ class ry2 {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: a */
    public static int m7311a(String str) {
        char c;
        str.getClass();
        switch (str.hashCode()) {
            case -1996906958:
                if (str.equals(TypedValues.TransitionType.S_TRANSITION_FLAGS)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1992012396:
                if (str.equals(TypedValues.TransitionType.S_DURATION)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1357874275:
                if (str.equals(TypedValues.TransitionType.S_INTERPOLATOR)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1298065308:
                if (str.equals(TypedValues.TransitionType.S_AUTO_TRANSITION)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 3707:
                if (str.equals(TypedValues.TransitionType.S_TO)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 3151786:
                if (str.equals(TypedValues.TransitionType.S_FROM)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 1310733335:
                if (str.equals(TypedValues.TransitionType.S_PATH_MOTION_ARC)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 1839260940:
                if (str.equals(TypedValues.TransitionType.S_STAGGERED)) {
                    c = 7;
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
                return TypedValues.TransitionType.TYPE_TRANSITION_FLAGS;
            case 1:
                return TypedValues.TransitionType.TYPE_DURATION;
            case 2:
                return TypedValues.TransitionType.TYPE_INTERPOLATOR;
            case 3:
                return TypedValues.TransitionType.TYPE_AUTO_TRANSITION;
            case 4:
                return TypedValues.TransitionType.TYPE_TO;
            case 5:
                return TypedValues.TransitionType.TYPE_FROM;
            case 6:
                return 509;
            case 7:
                return TypedValues.TransitionType.TYPE_STAGGERED;
            default:
                return -1;
        }
    }

    /* renamed from: b */
    public static int m7312b(int i) {
        if (i != 509) {
            switch (i) {
                case TypedValues.TransitionType.TYPE_DURATION /* 700 */:
                    return 2;
                case TypedValues.TransitionType.TYPE_FROM /* 701 */:
                case TypedValues.TransitionType.TYPE_TO /* 702 */:
                    return 8;
                default:
                    switch (i) {
                        case TypedValues.TransitionType.TYPE_INTERPOLATOR /* 705 */:
                        case TypedValues.TransitionType.TYPE_TRANSITION_FLAGS /* 707 */:
                            return 8;
                        case TypedValues.TransitionType.TYPE_STAGGERED /* 706 */:
                            return 4;
                        default:
                            return -1;
                    }
            }
        }
        return 2;
    }
}
