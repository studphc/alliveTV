package p000;

import android.view.View;
import android.view.autofill.AutofillId;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import java.util.Collection;

/* loaded from: classes.dex */
public abstract class z23 {
    @DoNotInline
    /* renamed from: a */
    public static void m8374a(@NonNull View view, Collection<View> collection, int i) {
        view.addKeyboardNavigationClusters(collection, i);
    }

    @DoNotInline
    /* renamed from: b */
    public static AutofillId m8375b(View view) {
        return view.getAutofillId();
    }

    @DoNotInline
    /* renamed from: c */
    public static int m8376c(View view) {
        return view.getImportantForAutofill();
    }

    @DoNotInline
    /* renamed from: d */
    public static int m8377d(@NonNull View view) {
        return view.getNextClusterForwardId();
    }

    @DoNotInline
    /* renamed from: e */
    public static boolean m8378e(@NonNull View view) {
        return view.hasExplicitFocusable();
    }

    @DoNotInline
    /* renamed from: f */
    public static boolean m8379f(@NonNull View view) {
        return view.isFocusedByDefault();
    }

    @DoNotInline
    /* renamed from: g */
    public static boolean m8380g(View view) {
        return view.isImportantForAutofill();
    }

    @DoNotInline
    /* renamed from: h */
    public static boolean m8381h(@NonNull View view) {
        return view.isKeyboardNavigationCluster();
    }

    @DoNotInline
    /* renamed from: i */
    public static View m8382i(@NonNull View view, View view2, int i) {
        return view.keyboardNavigationClusterSearch(view2, i);
    }

    @DoNotInline
    /* renamed from: j */
    public static boolean m8383j(@NonNull View view) {
        return view.restoreDefaultFocus();
    }

    @DoNotInline
    /* renamed from: k */
    public static void m8384k(@NonNull View view, String... strArr) {
        view.setAutofillHints(strArr);
    }

    @DoNotInline
    /* renamed from: l */
    public static void m8385l(@NonNull View view, boolean z) {
        view.setFocusedByDefault(z);
    }

    @DoNotInline
    /* renamed from: m */
    public static void m8386m(View view, int i) {
        view.setImportantForAutofill(i);
    }

    @DoNotInline
    /* renamed from: n */
    public static void m8387n(@NonNull View view, boolean z) {
        view.setKeyboardNavigationCluster(z);
    }

    @DoNotInline
    /* renamed from: o */
    public static void m8388o(View view, int i) {
        view.setNextClusterForwardId(i);
    }

    @DoNotInline
    /* renamed from: p */
    public static void m8389p(@NonNull View view, CharSequence charSequence) {
        view.setTooltipText(charSequence);
    }
}
