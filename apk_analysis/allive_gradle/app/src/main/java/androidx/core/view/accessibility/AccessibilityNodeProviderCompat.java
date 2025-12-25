package androidx.core.view.accessibility;

import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import p000.C1858u3;

/* loaded from: classes.dex */
public class AccessibilityNodeProviderCompat {
    public static final int HOST_VIEW_ID = -1;

    /* renamed from: a */
    public final Object f3965a;

    public AccessibilityNodeProviderCompat() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f3965a = new C1858u3(this);
        } else {
            this.f3965a = new C1858u3(this);
        }
    }

    public void addExtraDataToAccessibilityNodeInfo(int i, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, @NonNull String str, @Nullable Bundle bundle) {
    }

    @Nullable
    public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i) {
        return null;
    }

    @Nullable
    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(@NonNull String str, int i) {
        return null;
    }

    @Nullable
    public AccessibilityNodeInfoCompat findFocus(int i) {
        return null;
    }

    @Nullable
    public Object getProvider() {
        return this.f3965a;
    }

    public boolean performAction(int i, int i2, @Nullable Bundle bundle) {
        return false;
    }

    public AccessibilityNodeProviderCompat(@Nullable Object obj) {
        this.f3965a = obj;
    }
}
