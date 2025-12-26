package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.R;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.constraintlayout.motion.widget.c */
/* loaded from: classes.dex */
public final class C0128c {

    /* renamed from: E */
    public static final float[][] f2993E = {new float[]{0.5f, RecyclerView.f7068F0}, new float[]{RecyclerView.f7068F0, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{RecyclerView.f7068F0, 0.5f}, new float[]{1.0f, 0.5f}};

    /* renamed from: F */
    public static final float[][] f2994F = {new float[]{RecyclerView.f7068F0, -1.0f}, new float[]{RecyclerView.f7068F0, 1.0f}, new float[]{-1.0f, RecyclerView.f7068F0}, new float[]{1.0f, RecyclerView.f7068F0}, new float[]{-1.0f, RecyclerView.f7068F0}, new float[]{1.0f, RecyclerView.f7068F0}};

    /* renamed from: A */
    public final float f2995A;

    /* renamed from: B */
    public final float f2996B;

    /* renamed from: C */
    public final int f2997C;

    /* renamed from: D */
    public final int f2998D;

    /* renamed from: a */
    public final int f2999a;

    /* renamed from: b */
    public final int f3000b;

    /* renamed from: c */
    public int f3001c;

    /* renamed from: d */
    public final int f3002d;

    /* renamed from: e */
    public final int f3003e;

    /* renamed from: f */
    public final int f3004f;

    /* renamed from: g */
    public float f3005g;

    /* renamed from: h */
    public float f3006h;

    /* renamed from: i */
    public final int f3007i;

    /* renamed from: j */
    public final boolean f3008j;

    /* renamed from: k */
    public float f3009k;

    /* renamed from: l */
    public float f3010l;

    /* renamed from: m */
    public boolean f3011m;

    /* renamed from: n */
    public final float[] f3012n;

    /* renamed from: o */
    public final int[] f3013o;

    /* renamed from: p */
    public float f3014p;

    /* renamed from: q */
    public float f3015q;

    /* renamed from: r */
    public final MotionLayout f3016r;

    /* renamed from: s */
    public final float f3017s;

    /* renamed from: t */
    public final float f3018t;

    /* renamed from: u */
    public final boolean f3019u;

    /* renamed from: v */
    public final float f3020v;

    /* renamed from: w */
    public final int f3021w;

    /* renamed from: x */
    public final float f3022x;

    /* renamed from: y */
    public final float f3023y;

    /* renamed from: z */
    public final float f3024z;

    public C0128c(Context context, MotionLayout motionLayout, XmlResourceParser xmlResourceParser) {
        this.f2999a = 0;
        this.f3000b = 0;
        this.f3001c = 0;
        this.f3002d = -1;
        this.f3003e = -1;
        this.f3004f = -1;
        this.f3005g = 0.5f;
        this.f3006h = 0.5f;
        this.f3007i = -1;
        this.f3008j = false;
        this.f3009k = RecyclerView.f7068F0;
        this.f3010l = 1.0f;
        this.f3011m = false;
        this.f3012n = new float[2];
        this.f3013o = new int[2];
        this.f3017s = 4.0f;
        this.f3018t = 1.2f;
        this.f3019u = true;
        this.f3020v = 1.0f;
        this.f3021w = 0;
        this.f3022x = 10.0f;
        this.f3023y = 10.0f;
        this.f3024z = 1.0f;
        this.f2995A = Float.NaN;
        this.f2996B = Float.NaN;
        this.f2997C = 0;
        this.f2998D = 0;
        this.f3016r = motionLayout;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), R.styleable.OnSwipe);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R.styleable.OnSwipe_touchAnchorId) {
                this.f3002d = obtainStyledAttributes.getResourceId(index, this.f3002d);
            } else if (index == R.styleable.OnSwipe_touchAnchorSide) {
                int i2 = obtainStyledAttributes.getInt(index, this.f2999a);
                this.f2999a = i2;
                float[] fArr = f2993E[i2];
                this.f3006h = fArr[0];
                this.f3005g = fArr[1];
            } else if (index == R.styleable.OnSwipe_dragDirection) {
                int i3 = obtainStyledAttributes.getInt(index, this.f3000b);
                this.f3000b = i3;
                if (i3 < 6) {
                    float[] fArr2 = f2994F[i3];
                    this.f3009k = fArr2[0];
                    this.f3010l = fArr2[1];
                } else {
                    this.f3010l = Float.NaN;
                    this.f3009k = Float.NaN;
                    this.f3008j = true;
                }
            } else if (index == R.styleable.OnSwipe_maxVelocity) {
                this.f3017s = obtainStyledAttributes.getFloat(index, this.f3017s);
            } else if (index == R.styleable.OnSwipe_maxAcceleration) {
                this.f3018t = obtainStyledAttributes.getFloat(index, this.f3018t);
            } else if (index == R.styleable.OnSwipe_moveWhenScrollAtTop) {
                this.f3019u = obtainStyledAttributes.getBoolean(index, this.f3019u);
            } else if (index == R.styleable.OnSwipe_dragScale) {
                this.f3020v = obtainStyledAttributes.getFloat(index, this.f3020v);
            } else if (index == R.styleable.OnSwipe_dragThreshold) {
                this.f3022x = obtainStyledAttributes.getFloat(index, this.f3022x);
            } else if (index == R.styleable.OnSwipe_touchRegionId) {
                this.f3003e = obtainStyledAttributes.getResourceId(index, this.f3003e);
            } else if (index == R.styleable.OnSwipe_onTouchUp) {
                this.f3001c = obtainStyledAttributes.getInt(index, this.f3001c);
            } else if (index == R.styleable.OnSwipe_nestedScrollFlags) {
                this.f3021w = obtainStyledAttributes.getInteger(index, 0);
            } else if (index == R.styleable.OnSwipe_limitBoundsTo) {
                this.f3004f = obtainStyledAttributes.getResourceId(index, 0);
            } else if (index == R.styleable.OnSwipe_rotationCenterId) {
                this.f3007i = obtainStyledAttributes.getResourceId(index, this.f3007i);
            } else if (index == R.styleable.OnSwipe_springDamping) {
                this.f3023y = obtainStyledAttributes.getFloat(index, this.f3023y);
            } else if (index == R.styleable.OnSwipe_springMass) {
                this.f3024z = obtainStyledAttributes.getFloat(index, this.f3024z);
            } else if (index == R.styleable.OnSwipe_springStiffness) {
                this.f2995A = obtainStyledAttributes.getFloat(index, this.f2995A);
            } else if (index == R.styleable.OnSwipe_springStopThreshold) {
                this.f2996B = obtainStyledAttributes.getFloat(index, this.f2996B);
            } else if (index == R.styleable.OnSwipe_springBoundary) {
                this.f2997C = obtainStyledAttributes.getInt(index, this.f2997C);
            } else if (index == R.styleable.OnSwipe_autoCompleteMode) {
                this.f2998D = obtainStyledAttributes.getInt(index, this.f2998D);
            }
        }
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    public final RectF m610a(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i = this.f3004f;
        if (i == -1 || (findViewById = viewGroup.findViewById(i)) == null) {
            return null;
        }
        rectF.set(findViewById.getLeft(), findViewById.getTop(), findViewById.getRight(), findViewById.getBottom());
        return rectF;
    }

    /* renamed from: b */
    public final RectF m611b(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i = this.f3003e;
        if (i == -1 || (findViewById = viewGroup.findViewById(i)) == null) {
            return null;
        }
        rectF.set(findViewById.getLeft(), findViewById.getTop(), findViewById.getRight(), findViewById.getBottom());
        return rectF;
    }

    /* renamed from: c */
    public final void m612c(boolean z) {
        float[][] fArr = f2993E;
        float[][] fArr2 = f2994F;
        if (z) {
            fArr2[4] = fArr2[3];
            fArr2[5] = fArr2[2];
            fArr[5] = fArr[2];
            fArr[6] = fArr[1];
        } else {
            fArr2[4] = fArr2[2];
            fArr2[5] = fArr2[3];
            fArr[5] = fArr[1];
            fArr[6] = fArr[2];
        }
        float[] fArr3 = fArr[this.f2999a];
        this.f3006h = fArr3[0];
        this.f3005g = fArr3[1];
        int i = this.f3000b;
        if (i >= 6) {
            return;
        }
        float[] fArr4 = fArr2[i];
        this.f3009k = fArr4[0];
        this.f3010l = fArr4[1];
    }

    public final String toString() {
        if (Float.isNaN(this.f3009k)) {
            return Key.ROTATION;
        }
        return this.f3009k + " , " + this.f3010l;
    }

    public C0128c(MotionLayout motionLayout, OnSwipe onSwipe) {
        this.f2999a = 0;
        this.f3000b = 0;
        this.f3001c = 0;
        this.f3002d = -1;
        this.f3003e = -1;
        this.f3004f = -1;
        this.f3005g = 0.5f;
        this.f3006h = 0.5f;
        this.f3007i = -1;
        this.f3008j = false;
        this.f3009k = RecyclerView.f7068F0;
        this.f3010l = 1.0f;
        this.f3011m = false;
        this.f3012n = new float[2];
        this.f3013o = new int[2];
        this.f3017s = 4.0f;
        this.f3018t = 1.2f;
        this.f3019u = true;
        this.f3020v = 1.0f;
        this.f3021w = 0;
        this.f3022x = 10.0f;
        this.f3023y = 10.0f;
        this.f3024z = 1.0f;
        this.f2995A = Float.NaN;
        this.f2996B = Float.NaN;
        this.f2997C = 0;
        this.f2998D = 0;
        this.f3016r = motionLayout;
        this.f3002d = onSwipe.getTouchAnchorId();
        int touchAnchorSide = onSwipe.getTouchAnchorSide();
        this.f2999a = touchAnchorSide;
        if (touchAnchorSide != -1) {
            float[] fArr = f2993E[touchAnchorSide];
            this.f3006h = fArr[0];
            this.f3005g = fArr[1];
        }
        int dragDirection = onSwipe.getDragDirection();
        this.f3000b = dragDirection;
        if (dragDirection < 6) {
            float[] fArr2 = f2994F[dragDirection];
            this.f3009k = fArr2[0];
            this.f3010l = fArr2[1];
        } else {
            this.f3010l = Float.NaN;
            this.f3009k = Float.NaN;
            this.f3008j = true;
        }
        this.f3017s = onSwipe.getMaxVelocity();
        this.f3018t = onSwipe.getMaxAcceleration();
        this.f3019u = onSwipe.getMoveWhenScrollAtTop();
        this.f3020v = onSwipe.getDragScale();
        this.f3022x = onSwipe.getDragThreshold();
        this.f3003e = onSwipe.getTouchRegionId();
        this.f3001c = onSwipe.getOnTouchUp();
        this.f3021w = onSwipe.getNestedScrollFlags();
        this.f3004f = onSwipe.getLimitBoundsTo();
        this.f3007i = onSwipe.getRotationCenterId();
        this.f2997C = onSwipe.getSpringBoundary();
        this.f3023y = onSwipe.getSpringDamping();
        this.f3024z = onSwipe.getSpringMass();
        this.f2995A = onSwipe.getSpringStiffness();
        this.f2996B = onSwipe.getSpringStopThreshold();
        this.f2998D = onSwipe.getAutoCompleteMode();
    }
}
