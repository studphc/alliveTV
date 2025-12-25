package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Xml;
import java.util.ArrayList;

/* renamed from: androidx.constraintlayout.widget.c */
/* loaded from: classes.dex */
public final class C0131c {

    /* renamed from: a */
    public final int f3223a;

    /* renamed from: b */
    public final ArrayList f3224b = new ArrayList();

    /* renamed from: c */
    public final int f3225c;

    /* renamed from: d */
    public final ConstraintSet f3226d;

    public C0131c(Context context, XmlResourceParser xmlResourceParser) {
        this.f3225c = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), R.styleable.State);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R.styleable.State_android_id) {
                this.f3223a = obtainStyledAttributes.getResourceId(index, this.f3223a);
            } else if (index == R.styleable.State_constraints) {
                int resourceId = obtainStyledAttributes.getResourceId(index, this.f3225c);
                this.f3225c = resourceId;
                String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                context.getResources().getResourceName(resourceId);
                if ("layout".equals(resourceTypeName)) {
                    ConstraintSet constraintSet = new ConstraintSet();
                    this.f3226d = constraintSet;
                    constraintSet.clone(context, resourceId);
                }
            }
        }
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    public final int m663a(float f, float f2) {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f3224b;
            if (i < arrayList.size()) {
                if (((C0132d) arrayList.get(i)).m664a(f, f2)) {
                    return i;
                }
                i++;
            } else {
                return -1;
            }
        }
    }
}
