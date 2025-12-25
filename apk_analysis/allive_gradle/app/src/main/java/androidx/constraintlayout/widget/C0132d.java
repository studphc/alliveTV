package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Xml;

/* renamed from: androidx.constraintlayout.widget.d */
/* loaded from: classes.dex */
public final class C0132d {

    /* renamed from: a */
    public final float f3227a;

    /* renamed from: b */
    public final float f3228b;

    /* renamed from: c */
    public final float f3229c;

    /* renamed from: d */
    public final float f3230d;

    /* renamed from: e */
    public final int f3231e;

    /* renamed from: f */
    public final ConstraintSet f3232f;

    public C0132d(Context context, XmlResourceParser xmlResourceParser) {
        this.f3227a = Float.NaN;
        this.f3228b = Float.NaN;
        this.f3229c = Float.NaN;
        this.f3230d = Float.NaN;
        this.f3231e = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), R.styleable.Variant);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R.styleable.Variant_constraints) {
                int resourceId = obtainStyledAttributes.getResourceId(index, this.f3231e);
                this.f3231e = resourceId;
                String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                context.getResources().getResourceName(resourceId);
                if ("layout".equals(resourceTypeName)) {
                    ConstraintSet constraintSet = new ConstraintSet();
                    this.f3232f = constraintSet;
                    constraintSet.clone(context, resourceId);
                }
            } else if (index == R.styleable.Variant_region_heightLessThan) {
                this.f3230d = obtainStyledAttributes.getDimension(index, this.f3230d);
            } else if (index == R.styleable.Variant_region_heightMoreThan) {
                this.f3228b = obtainStyledAttributes.getDimension(index, this.f3228b);
            } else if (index == R.styleable.Variant_region_widthLessThan) {
                this.f3229c = obtainStyledAttributes.getDimension(index, this.f3229c);
            } else if (index == R.styleable.Variant_region_widthMoreThan) {
                this.f3227a = obtainStyledAttributes.getDimension(index, this.f3227a);
            } else {
                Log.v("ConstraintLayoutStates", "Unknown tag");
            }
        }
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    public final boolean m664a(float f, float f2) {
        float f3 = this.f3227a;
        if (!Float.isNaN(f3) && f < f3) {
            return false;
        }
        float f4 = this.f3228b;
        if (!Float.isNaN(f4) && f2 < f4) {
            return false;
        }
        float f5 = this.f3229c;
        if (!Float.isNaN(f5) && f > f5) {
            return false;
        }
        float f6 = this.f3230d;
        if (!Float.isNaN(f6) && f2 > f6) {
            return false;
        }
        return true;
    }
}
