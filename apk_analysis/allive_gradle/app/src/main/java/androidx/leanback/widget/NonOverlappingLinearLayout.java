package androidx.leanback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class NonOverlappingLinearLayout extends LinearLayout {

    /* renamed from: a */
    public boolean f5924a;

    /* renamed from: b */
    public boolean f5925b;

    /* renamed from: c */
    public final ArrayList f5926c;

    public NonOverlappingLinearLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void focusableViewAvailable(View view) {
        int i;
        if (this.f5925b) {
            for (View view2 = view; view2 != this && view2 != null; view2 = (View) view2.getParent()) {
                if (view2.getParent() == this) {
                    i = indexOfChild(view2);
                    break;
                }
            }
            i = -1;
            if (i != -1) {
                ((ArrayList) this.f5926c.get(i)).add(view);
                return;
            }
            return;
        }
        super.focusableViewAvailable(view);
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        ArrayList arrayList = this.f5926c;
        int i5 = 0;
        try {
            if (this.f5924a && getOrientation() == 0 && getLayoutDirection() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f5925b = z2;
            if (z2) {
                while (arrayList.size() > getChildCount()) {
                    arrayList.remove(arrayList.size() - 1);
                }
                while (arrayList.size() < getChildCount()) {
                    arrayList.add(new ArrayList());
                }
            }
            super.onLayout(z, i, i2, i3, i4);
            if (this.f5925b) {
                for (int i6 = 0; i6 < arrayList.size(); i6++) {
                    for (int i7 = 0; i7 < ((ArrayList) arrayList.get(i6)).size(); i7++) {
                        super.focusableViewAvailable((View) ((ArrayList) arrayList.get(i6)).get(i7));
                    }
                }
            }
            if (this.f5925b) {
                this.f5925b = false;
                while (i5 < arrayList.size()) {
                    ((ArrayList) arrayList.get(i5)).clear();
                    i5++;
                }
            }
        } catch (Throwable th) {
            if (this.f5925b) {
                this.f5925b = false;
                while (i5 < arrayList.size()) {
                    ((ArrayList) arrayList.get(i5)).clear();
                    i5++;
                }
            }
            throw th;
        }
    }

    public void setFocusableViewAvailableFixEnabled(boolean z) {
        this.f5924a = z;
    }

    public NonOverlappingLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NonOverlappingLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5924a = false;
        this.f5926c = new ArrayList();
    }
}
