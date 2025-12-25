package p000;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* loaded from: classes.dex */
public abstract /* synthetic */ class my2 {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: a */
    public static int m6262a(String str) {
        char c;
        str.getClass();
        switch (str.hashCode()) {
            case -1095013018:
                if (str.equals(TypedValues.Custom.S_DIMENSION)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -925155509:
                if (str.equals(TypedValues.Custom.S_REFERENCE)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -891985903:
                if (str.equals(TypedValues.Custom.S_STRING)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 64711720:
                if (str.equals(TypedValues.Custom.S_BOOLEAN)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 94842723:
                if (str.equals(TypedValues.Custom.S_COLOR)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 97526364:
                if (str.equals(TypedValues.Custom.S_FLOAT)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 1958052158:
                if (str.equals(TypedValues.Custom.S_INT)) {
                    c = 6;
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
                return TypedValues.Custom.TYPE_DIMENSION;
            case 1:
                return TypedValues.Custom.TYPE_REFERENCE;
            case 2:
                return TypedValues.Custom.TYPE_STRING;
            case 3:
                return TypedValues.Custom.TYPE_BOOLEAN;
            case 4:
                return TypedValues.Custom.TYPE_COLOR;
            case 5:
                return TypedValues.Custom.TYPE_FLOAT;
            case 6:
                return TypedValues.Custom.TYPE_INT;
            default:
                return -1;
        }
    }
}
