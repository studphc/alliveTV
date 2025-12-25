package p000;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.AbstractC0207e;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
public final class s23 {

    /* renamed from: a */
    public final int f26219a;

    /* renamed from: b */
    public final Class f26220b;

    /* renamed from: c */
    public final int f26221c;

    /* renamed from: d */
    public final int f26222d;

    /* renamed from: e */
    public final /* synthetic */ int f26223e;

    public s23(int i, Class cls, int i2, int i3, int i4) {
        this.f26223e = i4;
        this.f26219a = i;
        this.f26220b = cls;
        this.f26222d = i2;
        this.f26221c = i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0088, code lost:
    
        if (r0 == r1) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008a, code lost:
    
        r3 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008b, code lost:
    
        r0 = !r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00c1, code lost:
    
        if (r0 == r1) goto L36;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:20:0x0068. Please report as an issue. */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m7318a(View view, Object obj) {
        Object tag;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean equals;
        boolean z5;
        boolean z6;
        boolean z7;
        if (Build.VERSION.SDK_INT >= this.f26221c) {
            switch (this.f26223e) {
                case 0:
                    AbstractC0207e.m948j(view, ((Boolean) obj).booleanValue());
                    return;
                case 1:
                    AbstractC0207e.m946h(view, (CharSequence) obj);
                    return;
                case 2:
                    c33.m2195f(view, (CharSequence) obj);
                    return;
                default:
                    AbstractC0207e.m945g(view, ((Boolean) obj).booleanValue());
                    return;
            }
        }
        if (Build.VERSION.SDK_INT >= this.f26221c) {
            switch (this.f26223e) {
                case 0:
                    tag = Boolean.valueOf(AbstractC0207e.m942d(view));
                    break;
                case 1:
                    tag = AbstractC0207e.m940b(view);
                    break;
                case 2:
                    tag = c33.m2191b(view);
                    break;
                default:
                    tag = Boolean.valueOf(AbstractC0207e.m941c(view));
                    break;
            }
        } else {
            tag = view.getTag(this.f26219a);
            if (!this.f26220b.isInstance(tag)) {
                tag = null;
            }
        }
        switch (this.f26223e) {
            case 0:
                Boolean bool = (Boolean) tag;
                Boolean bool2 = (Boolean) obj;
                z = true;
                z2 = false;
                if (bool != null && bool.booleanValue()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (bool2 != null && bool2.booleanValue()) {
                    z4 = true;
                    break;
                } else {
                    z4 = false;
                    break;
                }
                break;
            case 1:
                equals = TextUtils.equals((CharSequence) tag, (CharSequence) obj);
                z5 = !equals;
                break;
            case 2:
                equals = TextUtils.equals((CharSequence) tag, (CharSequence) obj);
                z5 = !equals;
                break;
            default:
                Boolean bool3 = (Boolean) tag;
                Boolean bool4 = (Boolean) obj;
                z = true;
                z2 = false;
                if (bool3 != null && bool3.booleanValue()) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (bool4 != null && bool4.booleanValue()) {
                    z7 = true;
                    break;
                } else {
                    z7 = false;
                    break;
                }
                break;
        }
        if (z5) {
            AccessibilityDelegateCompat accessibilityDelegate = ViewCompat.getAccessibilityDelegate(view);
            if (accessibilityDelegate == null) {
                accessibilityDelegate = new AccessibilityDelegateCompat();
            }
            ViewCompat.setAccessibilityDelegate(view, accessibilityDelegate);
            view.setTag(this.f26219a, obj);
            ViewCompat.m912e(this.f26222d, view);
        }
    }
}
