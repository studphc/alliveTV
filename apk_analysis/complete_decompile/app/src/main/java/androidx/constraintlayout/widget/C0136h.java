package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Xml;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: androidx.constraintlayout.widget.h */
/* loaded from: classes.dex */
public final class C0136h {

    /* renamed from: a */
    public final int f3253a;

    /* renamed from: b */
    public final ArrayList f3254b = new ArrayList();

    /* renamed from: c */
    public final int f3255c;

    public C0136h(Context context, XmlPullParser xmlPullParser) {
        this.f3255c = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.State);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R.styleable.State_android_id) {
                this.f3253a = obtainStyledAttributes.getResourceId(index, this.f3253a);
            } else if (index == R.styleable.State_constraints) {
                int resourceId = obtainStyledAttributes.getResourceId(index, this.f3255c);
                this.f3255c = resourceId;
                String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                context.getResources().getResourceName(resourceId);
                "layout".equals(resourceTypeName);
            }
        }
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    public final int m686a(float f, float f2) {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f3254b;
            if (i < arrayList.size()) {
                if (((C0137i) arrayList.get(i)).m687a(f, f2)) {
                    return i;
                }
                i++;
            } else {
                return -1;
            }
        }
    }
}
