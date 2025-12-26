package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.motion.utils.ViewSpline;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes.dex */
public abstract class Key {
    public static final String ALPHA = "alpha";
    public static final String CURVEFIT = "curveFit";
    public static final String CUSTOM = "CUSTOM";
    public static final String ELEVATION = "elevation";
    public static final String MOTIONPROGRESS = "motionProgress";
    public static final String PIVOT_X = "transformPivotX";
    public static final String PIVOT_Y = "transformPivotY";
    public static final String PROGRESS = "progress";
    public static final String ROTATION = "rotation";
    public static final String ROTATION_X = "rotationX";
    public static final String ROTATION_Y = "rotationY";
    public static final String SCALE_X = "scaleX";
    public static final String SCALE_Y = "scaleY";
    public static final String TRANSITIONEASING = "transitionEasing";
    public static final String TRANSITION_PATH_ROTATE = "transitionPathRotate";
    public static final String TRANSLATION_X = "translationX";
    public static final String TRANSLATION_Y = "translationY";
    public static final String TRANSLATION_Z = "translationZ";
    public static int UNSET = -1;
    public static final String VISIBILITY = "visibility";
    public static final String WAVE_OFFSET = "waveOffset";
    public static final String WAVE_PERIOD = "wavePeriod";
    public static final String WAVE_PHASE = "wavePhase";
    public static final String WAVE_VARIES_BY = "waveVariesBy";

    /* renamed from: a */
    public int f2700a;

    /* renamed from: b */
    public int f2701b;

    /* renamed from: c */
    public String f2702c;

    /* renamed from: d */
    public HashMap f2703d;
    protected int mType;

    public Key() {
        int i = UNSET;
        this.f2700a = i;
        this.f2701b = i;
        this.f2702c = null;
    }

    /* renamed from: a */
    public static float m558a(Object obj) {
        if (obj instanceof Float) {
            return ((Float) obj).floatValue();
        }
        return Float.parseFloat(obj.toString());
    }

    /* renamed from: b */
    public static int m559b(Object obj) {
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return Integer.parseInt(obj.toString());
    }

    public abstract void addValues(HashMap<String, ViewSpline> hashMap);

    @Override // 
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public abstract Key mo8476clone();

    public Key copy(Key key) {
        this.f2700a = key.f2700a;
        this.f2701b = key.f2701b;
        this.f2702c = key.f2702c;
        this.mType = key.mType;
        this.f2703d = key.f2703d;
        return this;
    }

    public abstract void getAttributeNames(HashSet hashSet);

    public int getFramePosition() {
        return this.f2700a;
    }

    public abstract void load(Context context, AttributeSet attributeSet);

    public void setFramePosition(int i) {
        this.f2700a = i;
    }

    public void setInterpolation(HashMap<String, Integer> hashMap) {
    }

    public abstract void setValue(String str, Object obj);

    public Key setViewId(int i) {
        this.f2701b = i;
        return this;
    }
}
