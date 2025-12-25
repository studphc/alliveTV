package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: androidx.constraintlayout.widget.i */
/* loaded from: classes.dex */
public final class C0137i {

    /* renamed from: a */
    public final float f3256a;

    /* renamed from: b */
    public final float f3257b;

    /* renamed from: c */
    public final float f3258c;

    /* renamed from: d */
    public final float f3259d;

    /* renamed from: e */
    public final int f3260e;

    public C0137i(Context context, XmlPullParser xmlPullParser) {
        this.f3256a = Float.NaN;
        this.f3257b = Float.NaN;
        this.f3258c = Float.NaN;
        this.f3259d = Float.NaN;
        this.f3260e = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Variant);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R.styleable.Variant_constraints) {
                int resourceId = obtainStyledAttributes.getResourceId(index, this.f3260e);
                this.f3260e = resourceId;
                String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                context.getResources().getResourceName(resourceId);
                "layout".equals(resourceTypeName);
            } else if (index == R.styleable.Variant_region_heightLessThan) {
                this.f3259d = obtainStyledAttributes.getDimension(index, this.f3259d);
            } else if (index == R.styleable.Variant_region_heightMoreThan) {
                this.f3257b = obtainStyledAttributes.getDimension(index, this.f3257b);
            } else if (index == R.styleable.Variant_region_widthLessThan) {
                this.f3258c = obtainStyledAttributes.getDimension(index, this.f3258c);
            } else if (index == R.styleable.Variant_region_widthMoreThan) {
                this.f3256a = obtainStyledAttributes.getDimension(index, this.f3256a);
            } else {
                Log.v("ConstraintLayoutStates", "Unknown tag");
            }
        }
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    public final boolean m687a(float f, float f2) {
        float f3 = this.f3256a;
        if (!Float.isNaN(f3) && f < f3) {
            return false;
        }
        float f4 = this.f3257b;
        if (!Float.isNaN(f4) && f2 < f4) {
            return false;
        }
        float f5 = this.f3258c;
        if (!Float.isNaN(f5) && f > f5) {
            return false;
        }
        float f6 = this.f3259d;
        if (!Float.isNaN(f6) && f2 > f6) {
            return false;
        }
        return true;
    }
}
