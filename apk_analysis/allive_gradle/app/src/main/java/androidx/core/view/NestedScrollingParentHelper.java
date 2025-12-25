package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class NestedScrollingParentHelper {

    /* renamed from: a */
    public int f3897a;

    /* renamed from: b */
    public int f3898b;

    public NestedScrollingParentHelper(@NonNull ViewGroup viewGroup) {
    }

    public int getNestedScrollAxes() {
        return this.f3897a | this.f3898b;
    }

    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    public void onStopNestedScroll(@NonNull View view) {
        onStopNestedScroll(view, 0);
    }

    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i, int i2) {
        if (i2 == 1) {
            this.f3898b = i;
        } else {
            this.f3897a = i;
        }
    }

    public void onStopNestedScroll(@NonNull View view, int i) {
        if (i == 1) {
            this.f3898b = 0;
        } else {
            this.f3897a = 0;
        }
    }
}
