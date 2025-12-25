package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.view.accessibility.AccessibilityWindowInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.os.LocaleListCompat;
import p000.AbstractC0005a4;
import p000.AbstractC0544b4;
import p000.AbstractC1932w3;
import p000.AbstractC1969x3;
import p000.AbstractC2006y3;
import p000.AbstractC2043z3;

/* loaded from: classes.dex */
public class AccessibilityWindowInfoCompat {
    public static final int TYPE_ACCESSIBILITY_OVERLAY = 4;
    public static final int TYPE_APPLICATION = 1;
    public static final int TYPE_INPUT_METHOD = 2;
    public static final int TYPE_MAGNIFICATION_OVERLAY = 6;
    public static final int TYPE_SPLIT_SCREEN_DIVIDER = 5;
    public static final int TYPE_SYSTEM = 3;

    /* renamed from: a */
    public final AccessibilityWindowInfo f3968a;

    public AccessibilityWindowInfoCompat() {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f3968a = AbstractC2043z3.m8390a();
        } else {
            this.f3968a = null;
        }
    }

    @Nullable
    public static AccessibilityWindowInfoCompat obtain() {
        AccessibilityWindowInfo m8004l = AbstractC1932w3.m8004l();
        if (m8004l != null) {
            return new AccessibilityWindowInfoCompat(m8004l);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AccessibilityWindowInfoCompat)) {
            return false;
        }
        AccessibilityWindowInfo accessibilityWindowInfo = ((AccessibilityWindowInfoCompat) obj).f3968a;
        AccessibilityWindowInfo accessibilityWindowInfo2 = this.f3968a;
        if (accessibilityWindowInfo2 == null) {
            if (accessibilityWindowInfo == null) {
                return true;
            }
            return false;
        }
        return accessibilityWindowInfo2.equals(accessibilityWindowInfo);
    }

    @Nullable
    public AccessibilityNodeInfoCompat getAnchor() {
        if (Build.VERSION.SDK_INT >= 24) {
            return AccessibilityNodeInfoCompat.m922e(AbstractC1969x3.m8092a(this.f3968a));
        }
        return null;
    }

    public void getBoundsInScreen(@NonNull Rect rect) {
        AbstractC1932w3.m7993a(this.f3968a, rect);
    }

    @Nullable
    public AccessibilityWindowInfoCompat getChild(int i) {
        AccessibilityWindowInfo m7994b = AbstractC1932w3.m7994b(this.f3968a, i);
        if (m7994b != null) {
            return new AccessibilityWindowInfoCompat(m7994b);
        }
        return null;
    }

    public int getChildCount() {
        return AbstractC1932w3.m7995c(this.f3968a);
    }

    public int getDisplayId() {
        if (Build.VERSION.SDK_INT >= 33) {
            return AbstractC0005a4.m10a(this.f3968a);
        }
        return 0;
    }

    public int getId() {
        return AbstractC1932w3.m7996d(this.f3968a);
    }

    public int getLayer() {
        return AbstractC1932w3.m7997e(this.f3968a);
    }

    @NonNull
    public LocaleListCompat getLocales() {
        if (Build.VERSION.SDK_INT >= 34) {
            return LocaleListCompat.wrap(AbstractC0544b4.m2014a(this.f3968a));
        }
        return LocaleListCompat.getEmptyLocaleList();
    }

    @Nullable
    public AccessibilityWindowInfoCompat getParent() {
        AccessibilityWindowInfo m7998f = AbstractC1932w3.m7998f(this.f3968a);
        if (m7998f != null) {
            return new AccessibilityWindowInfoCompat(m7998f);
        }
        return null;
    }

    public void getRegionInScreen(@NonNull Region region) {
        int i = Build.VERSION.SDK_INT;
        AccessibilityWindowInfo accessibilityWindowInfo = this.f3968a;
        if (i >= 33) {
            AbstractC0005a4.m11b(accessibilityWindowInfo, region);
            return;
        }
        Rect rect = new Rect();
        AbstractC1932w3.m7993a(accessibilityWindowInfo, rect);
        region.set(rect);
    }

    @Nullable
    public AccessibilityNodeInfoCompat getRoot() {
        return AccessibilityNodeInfoCompat.m922e(AbstractC1932w3.m7999g(this.f3968a));
    }

    @Nullable
    public CharSequence getTitle() {
        if (Build.VERSION.SDK_INT >= 24) {
            return AbstractC1969x3.m8093b(this.f3968a);
        }
        return null;
    }

    public long getTransitionTimeMillis() {
        if (Build.VERSION.SDK_INT >= 34) {
            return AbstractC0544b4.m2015b(this.f3968a);
        }
        return 0L;
    }

    public int getType() {
        return AbstractC1932w3.m8000h(this.f3968a);
    }

    public int hashCode() {
        AccessibilityWindowInfo accessibilityWindowInfo = this.f3968a;
        if (accessibilityWindowInfo == null) {
            return 0;
        }
        return accessibilityWindowInfo.hashCode();
    }

    public boolean isAccessibilityFocused() {
        return AbstractC1932w3.m8001i(this.f3968a);
    }

    public boolean isActive() {
        return AbstractC1932w3.m8002j(this.f3968a);
    }

    public boolean isFocused() {
        return AbstractC1932w3.m8003k(this.f3968a);
    }

    public boolean isInPictureInPictureMode() {
        if (Build.VERSION.SDK_INT >= 26) {
            return AbstractC2006y3.m8215a(this.f3968a);
        }
        return false;
    }

    @Deprecated
    public void recycle() {
    }

    @NonNull
    public String toString() {
        String str;
        boolean z;
        StringBuilder sb = new StringBuilder("AccessibilityWindowInfo[id=");
        Rect rect = new Rect();
        getBoundsInScreen(rect);
        sb.append(getId());
        sb.append(", type=");
        int type = getType();
        boolean z2 = true;
        if (type != 1) {
            if (type != 2) {
                if (type != 3) {
                    if (type != 4) {
                        str = "<UNKNOWN>";
                    } else {
                        str = "TYPE_ACCESSIBILITY_OVERLAY";
                    }
                } else {
                    str = "TYPE_SYSTEM";
                }
            } else {
                str = "TYPE_INPUT_METHOD";
            }
        } else {
            str = "TYPE_APPLICATION";
        }
        sb.append(str);
        sb.append(", layer=");
        sb.append(getLayer());
        sb.append(", bounds=");
        sb.append(rect);
        sb.append(", focused=");
        sb.append(isFocused());
        sb.append(", active=");
        sb.append(isActive());
        sb.append(", hasParent=");
        if (getParent() != null) {
            z = true;
        } else {
            z = false;
        }
        sb.append(z);
        sb.append(", hasChildren=");
        if (getChildCount() <= 0) {
            z2 = false;
        }
        sb.append(z2);
        sb.append(", transitionTime=");
        sb.append(getTransitionTimeMillis());
        sb.append(", locales=");
        sb.append(getLocales());
        sb.append(']');
        return sb.toString();
    }

    @Nullable
    public AccessibilityWindowInfo unwrap() {
        return this.f3968a;
    }

    @Nullable
    public static AccessibilityWindowInfoCompat obtain(@Nullable AccessibilityWindowInfoCompat accessibilityWindowInfoCompat) {
        AccessibilityWindowInfo m8005m;
        if (accessibilityWindowInfoCompat == null || (m8005m = AbstractC1932w3.m8005m(accessibilityWindowInfoCompat.f3968a)) == null) {
            return null;
        }
        return new AccessibilityWindowInfoCompat(m8005m);
    }

    @Nullable
    public AccessibilityNodeInfoCompat getRoot(int i) {
        if (Build.VERSION.SDK_INT >= 33) {
            return AbstractC0005a4.m12c(this.f3968a, i);
        }
        return getRoot();
    }

    public AccessibilityWindowInfoCompat(AccessibilityWindowInfo accessibilityWindowInfo) {
        this.f3968a = accessibilityWindowInfo;
    }
}
