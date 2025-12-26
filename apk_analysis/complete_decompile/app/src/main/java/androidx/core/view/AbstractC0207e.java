package androidx.core.view;

import android.view.KeyEvent;
import android.view.View;
import android.view.autofill.AutofillId;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.collection.SimpleArrayMap;
import androidx.core.R;
import androidx.core.view.ViewCompat;
import androidx.core.view.autofill.AutofillIdCompat;
import java.util.Objects;

/* renamed from: androidx.core.view.e */
/* loaded from: classes.dex */
public abstract class AbstractC0207e {
    @DoNotInline
    /* renamed from: a */
    public static void m939a(@NonNull View view, @NonNull final ViewCompat.OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        int i = R.id.tag_unhandled_key_listeners;
        SimpleArrayMap simpleArrayMap = (SimpleArrayMap) view.getTag(i);
        if (simpleArrayMap == null) {
            simpleArrayMap = new SimpleArrayMap();
            view.setTag(i, simpleArrayMap);
        }
        Objects.requireNonNull(onUnhandledKeyEventListenerCompat);
        View.OnUnhandledKeyEventListener onUnhandledKeyEventListener = new View.OnUnhandledKeyEventListener() { // from class: a33
            @Override // android.view.View.OnUnhandledKeyEventListener
            public final boolean onUnhandledKeyEvent(View view2, KeyEvent keyEvent) {
                return ViewCompat.OnUnhandledKeyEventListenerCompat.this.onUnhandledKeyEvent(view2, keyEvent);
            }
        };
        simpleArrayMap.put(onUnhandledKeyEventListenerCompat, onUnhandledKeyEventListener);
        view.addOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
    }

    @DoNotInline
    /* renamed from: b */
    public static CharSequence m940b(View view) {
        return view.getAccessibilityPaneTitle();
    }

    @DoNotInline
    /* renamed from: c */
    public static boolean m941c(View view) {
        return view.isAccessibilityHeading();
    }

    @DoNotInline
    /* renamed from: d */
    public static boolean m942d(View view) {
        return view.isScreenReaderFocusable();
    }

    @DoNotInline
    /* renamed from: e */
    public static void m943e(@NonNull View view, @NonNull ViewCompat.OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
        SimpleArrayMap simpleArrayMap = (SimpleArrayMap) view.getTag(R.id.tag_unhandled_key_listeners);
        if (simpleArrayMap != null && (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) simpleArrayMap.get(onUnhandledKeyEventListenerCompat)) != null) {
            view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }
    }

    @DoNotInline
    /* renamed from: f */
    public static <T> T m944f(View view, int i) {
        return (T) view.requireViewById(i);
    }

    @DoNotInline
    /* renamed from: g */
    public static void m945g(View view, boolean z) {
        view.setAccessibilityHeading(z);
    }

    @DoNotInline
    /* renamed from: h */
    public static void m946h(View view, CharSequence charSequence) {
        view.setAccessibilityPaneTitle(charSequence);
    }

    @DoNotInline
    /* renamed from: i */
    public static void m947i(View view, AutofillIdCompat autofillIdCompat) {
        AutofillId autofillId;
        if (autofillIdCompat == null) {
            autofillId = null;
        } else {
            autofillId = autofillIdCompat.toAutofillId();
        }
        view.setAutofillId(autofillId);
    }

    @DoNotInline
    /* renamed from: j */
    public static void m948j(View view, boolean z) {
        view.setScreenReaderFocusable(z);
    }
}
