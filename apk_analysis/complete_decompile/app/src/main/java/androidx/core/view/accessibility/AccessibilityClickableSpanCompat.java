package androidx.core.view.accessibility;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* loaded from: classes.dex */
public final class AccessibilityClickableSpanCompat extends ClickableSpan {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final String SPAN_ID = "ACCESSIBILITY_CLICKABLE_SPAN_ID";

    /* renamed from: a */
    public final int f3944a;

    /* renamed from: b */
    public final AccessibilityNodeInfoCompat f3945b;

    /* renamed from: c */
    public final int f3946c;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public AccessibilityClickableSpanCompat(int i, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, int i2) {
        this.f3944a = i;
        this.f3945b = accessibilityNodeInfoCompat;
        this.f3946c = i2;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(@NonNull View view) {
        Bundle bundle = new Bundle();
        bundle.putInt(SPAN_ID, this.f3944a);
        this.f3945b.performAction(this.f3946c, bundle);
    }
}
