package p000;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import java.util.ArrayList;
import java.util.List;

/* renamed from: u3 */
/* loaded from: classes.dex */
public class C1858u3 extends AccessibilityNodeProvider {

    /* renamed from: a */
    public final AccessibilityNodeProviderCompat f27078a;

    public C1858u3(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
        this.f27078a = accessibilityNodeProviderCompat;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        AccessibilityNodeInfoCompat createAccessibilityNodeInfo = this.f27078a.createAccessibilityNodeInfo(i);
        if (createAccessibilityNodeInfo == null) {
            return null;
        }
        return createAccessibilityNodeInfo.unwrap();
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final List findAccessibilityNodeInfosByText(String str, int i) {
        List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText = this.f27078a.findAccessibilityNodeInfosByText(str, i);
        if (findAccessibilityNodeInfosByText == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = findAccessibilityNodeInfosByText.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(findAccessibilityNodeInfosByText.get(i2).unwrap());
        }
        return arrayList;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo findFocus(int i) {
        AccessibilityNodeInfoCompat findFocus = this.f27078a.findFocus(i);
        if (findFocus == null) {
            return null;
        }
        return findFocus.unwrap();
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final boolean performAction(int i, int i2, Bundle bundle) {
        return this.f27078a.performAction(i, i2, bundle);
    }
}
