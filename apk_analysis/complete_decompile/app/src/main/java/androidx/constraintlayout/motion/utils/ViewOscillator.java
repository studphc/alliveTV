package androidx.constraintlayout.motion.utils;

import android.view.View;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.motion.widget.Key;
import p000.n33;
import p000.o33;

/* loaded from: classes.dex */
public abstract class ViewOscillator extends KeyCycleOscillator {

    /* loaded from: classes.dex */
    public static class PathRotateSet extends ViewOscillator {
        public void setPathRotate(View view, float f, double d, double d2) {
            view.setRotation(get(f) + ((float) Math.toDegrees(Math.atan2(d2, d))));
        }

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public void setProperty(View view, float f) {
        }
    }

    /* JADX WARN: Type inference failed for: r12v6, types: [p33, androidx.constraintlayout.motion.utils.ViewOscillator] */
    public static ViewOscillator makeSpline(String str) {
        if (str.startsWith("CUSTOM")) {
            return new o33();
        }
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
            case -1225497657:
                if (str.equals("translationX")) {
                    c = 2;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c = 3;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c = 4;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c = 5;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c = 6;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c = 7;
                    break;
                }
                break;
            case -797520672:
                if (str.equals(Key.WAVE_VARIES_BY)) {
                    c = '\b';
                    break;
                }
                break;
            case -40300674:
                if (str.equals(Key.ROTATION)) {
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
            case 37232917:
                if (str.equals("transitionPathRotate")) {
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
            case 156108012:
                if (str.equals("waveOffset")) {
                    c = '\r';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new n33(3);
            case 1:
                return new n33(4);
            case 2:
                return new n33(7);
            case 3:
                return new n33(8);
            case 4:
                return new n33(9);
            case 5:
                ?? viewOscillator = new ViewOscillator();
                viewOscillator.f25024g = false;
                return viewOscillator;
            case 6:
                return new n33(5);
            case 7:
                return new n33(6);
            case '\b':
                return new n33(0);
            case '\t':
                return new n33(2);
            case '\n':
                return new n33(1);
            case 11:
                return new PathRotateSet();
            case '\f':
                return new n33(0);
            case '\r':
                return new n33(0);
            default:
                return null;
        }
    }

    public abstract void setProperty(View view, float f);
}
