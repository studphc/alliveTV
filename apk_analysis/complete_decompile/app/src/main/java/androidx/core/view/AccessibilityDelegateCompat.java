package androidx.core.view;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.view.accessibility.AccessibilityClickableSpanCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import p000.C1292i3;

/* loaded from: classes.dex */
public class AccessibilityDelegateCompat {

    /* renamed from: c */
    public static final View.AccessibilityDelegate f3851c = new View.AccessibilityDelegate();

    /* renamed from: a */
    public final View.AccessibilityDelegate f3852a;

    /* renamed from: b */
    public final C1292i3 f3853b;

    public AccessibilityDelegateCompat() {
        this(f3851c);
    }

    public boolean dispatchPopulateAccessibilityEvent(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
        return this.f3852a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    @Nullable
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(@NonNull View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = this.f3852a.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new AccessibilityNodeProviderCompat(accessibilityNodeProvider);
        }
        return null;
    }

    public void onInitializeAccessibilityEvent(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
        this.f3852a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        this.f3852a.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.unwrap());
    }

    public void onPopulateAccessibilityEvent(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
        this.f3852a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean onRequestSendAccessibilityEvent(@NonNull ViewGroup viewGroup, @NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
        return this.f3852a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean performAccessibilityAction(@NonNull View view, int i, @Nullable Bundle bundle) {
        boolean z;
        WeakReference weakReference;
        ClickableSpan clickableSpan;
        List list = (List) view.getTag(R.id.tag_accessibility_actions);
        if (list == null) {
            list = Collections.emptyList();
        }
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 < list.size()) {
                AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat = (AccessibilityNodeInfoCompat.AccessibilityActionCompat) list.get(i2);
                if (accessibilityActionCompat.getId() == i) {
                    z = accessibilityActionCompat.perform(view, bundle);
                    break;
                }
                i2++;
            } else {
                z = false;
                break;
            }
        }
        if (!z) {
            z = this.f3852a.performAccessibilityAction(view, i, bundle);
        }
        if (!z && i == R.id.accessibility_action_clickable_span && bundle != null) {
            int i3 = bundle.getInt(AccessibilityClickableSpanCompat.SPAN_ID, -1);
            SparseArray sparseArray = (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
            if (sparseArray != null && (weakReference = (WeakReference) sparseArray.get(i3)) != null && (clickableSpan = (ClickableSpan) weakReference.get()) != null) {
                ClickableSpan[] clickableSpans = AccessibilityNodeInfoCompat.getClickableSpans(view.createAccessibilityNodeInfo().getText());
                int i4 = 0;
                while (true) {
                    if (clickableSpans == null || i4 >= clickableSpans.length) {
                        break;
                    }
                    if (clickableSpan.equals(clickableSpans[i4])) {
                        clickableSpan.onClick(view);
                        z2 = true;
                        break;
                    }
                    i4++;
                }
            }
            return z2;
        }
        return z;
    }

    public void sendAccessibilityEvent(@NonNull View view, int i) {
        this.f3852a.sendAccessibilityEvent(view, i);
    }

    public void sendAccessibilityEventUnchecked(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
        this.f3852a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public AccessibilityDelegateCompat(@NonNull View.AccessibilityDelegate accessibilityDelegate) {
        this.f3852a = accessibilityDelegate;
        this.f3853b = new C1292i3(this);
    }
}
