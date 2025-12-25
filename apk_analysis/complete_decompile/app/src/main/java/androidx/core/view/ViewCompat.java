package androidx.core.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.animation.PathInterpolator;
import android.view.contentcapture.ContentCaptureSession;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.core.R;
import androidx.core.util.Preconditions;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.autofill.AutofillIdCompat;
import androidx.core.view.contentcapture.ContentCaptureSessionCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import p000.C1292i3;
import p000.b33;
import p000.c33;
import p000.d33;
import p000.go2;
import p000.r23;
import p000.s23;
import p000.t23;
import p000.u23;
import p000.w23;
import p000.x23;
import p000.y23;
import p000.z23;

@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: classes.dex */
public class ViewCompat {
    public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
    public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
    public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;

    @Deprecated
    public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;

    @Deprecated
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;

    @Deprecated
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;

    @Deprecated
    public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_AUTO = 0;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_NO = 2;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_NO_EXCLUDE_DESCENDANTS = 8;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_YES = 1;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_YES_EXCLUDE_DESCENDANTS = 4;

    @Deprecated
    public static final int LAYER_TYPE_HARDWARE = 2;

    @Deprecated
    public static final int LAYER_TYPE_NONE = 0;

    @Deprecated
    public static final int LAYER_TYPE_SOFTWARE = 1;

    @Deprecated
    public static final int LAYOUT_DIRECTION_INHERIT = 2;

    @Deprecated
    public static final int LAYOUT_DIRECTION_LOCALE = 3;

    @Deprecated
    public static final int LAYOUT_DIRECTION_LTR = 0;

    @Deprecated
    public static final int LAYOUT_DIRECTION_RTL = 1;

    @Deprecated
    public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;

    @Deprecated
    public static final int MEASURED_SIZE_MASK = 16777215;

    @Deprecated
    public static final int MEASURED_STATE_MASK = -16777216;

    @Deprecated
    public static final int MEASURED_STATE_TOO_SMALL = 16777216;

    @Deprecated
    public static final int OVER_SCROLL_ALWAYS = 0;

    @Deprecated
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;

    @Deprecated
    public static final int OVER_SCROLL_NEVER = 2;
    public static final int SCROLL_AXIS_HORIZONTAL = 1;
    public static final int SCROLL_AXIS_NONE = 0;
    public static final int SCROLL_AXIS_VERTICAL = 2;
    public static final int SCROLL_INDICATOR_BOTTOM = 2;
    public static final int SCROLL_INDICATOR_END = 32;
    public static final int SCROLL_INDICATOR_LEFT = 4;
    public static final int SCROLL_INDICATOR_RIGHT = 8;
    public static final int SCROLL_INDICATOR_START = 16;
    public static final int SCROLL_INDICATOR_TOP = 1;
    public static final int TYPE_NON_TOUCH = 1;
    public static final int TYPE_TOUCH = 0;

    /* renamed from: a */
    public static Method f3908a = null;

    /* renamed from: b */
    public static Method f3909b = null;

    /* renamed from: c */
    public static boolean f3910c = false;

    /* renamed from: d */
    public static WeakHashMap f3911d = null;

    /* renamed from: e */
    public static Method f3912e = null;

    /* renamed from: f */
    public static Field f3913f = null;

    /* renamed from: g */
    public static boolean f3914g = false;

    /* renamed from: h */
    public static final int[] f3915h = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};

    /* renamed from: i */
    public static final r23 f3916i = new Object();

    /* renamed from: j */
    public static final t23 f3917j = new t23();

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface FocusDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface FocusRealDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface FocusRelativeDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface NestedScrollType {
    }

    /* loaded from: classes.dex */
    public interface OnUnhandledKeyEventListenerCompat {
        boolean onUnhandledKeyEvent(@NonNull View view, @NonNull KeyEvent keyEvent);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface ScrollAxis {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface ScrollIndicators {
    }

    @Deprecated
    public ViewCompat() {
    }

    /* renamed from: a */
    public static void m908a() {
        try {
            f3908a = View.class.getDeclaredMethod("dispatchStartTemporaryDetach", null);
            f3909b = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", null);
        } catch (NoSuchMethodException e) {
            Log.e("ViewCompat", "Couldn't find method", e);
        }
        f3910c = true;
    }

    public static int addAccessibilityAction(@NonNull View view, @NonNull CharSequence charSequence, @NonNull AccessibilityViewCommand accessibilityViewCommand) {
        int i;
        boolean z;
        ArrayList m911d = m911d(view);
        int i2 = 0;
        while (true) {
            if (i2 < m911d.size()) {
                if (TextUtils.equals(charSequence, ((AccessibilityNodeInfoCompat.AccessibilityActionCompat) m911d.get(i2)).getLabel())) {
                    i = ((AccessibilityNodeInfoCompat.AccessibilityActionCompat) m911d.get(i2)).getId();
                    break;
                }
                i2++;
            } else {
                int i3 = -1;
                for (int i4 = 0; i4 < 32 && i3 == -1; i4++) {
                    int i5 = f3915h[i4];
                    boolean z2 = true;
                    for (int i6 = 0; i6 < m911d.size(); i6++) {
                        if (((AccessibilityNodeInfoCompat.AccessibilityActionCompat) m911d.get(i6)).getId() != i5) {
                            z = true;
                        } else {
                            z = false;
                        }
                        z2 &= z;
                    }
                    if (z2) {
                        i3 = i5;
                    }
                }
                i = i3;
            }
        }
        if (i != -1) {
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i, charSequence, accessibilityViewCommand);
            AccessibilityDelegateCompat accessibilityDelegate = getAccessibilityDelegate(view);
            if (accessibilityDelegate == null) {
                accessibilityDelegate = new AccessibilityDelegateCompat();
            }
            setAccessibilityDelegate(view, accessibilityDelegate);
            m913f(accessibilityActionCompat.getId(), view);
            m911d(view).add(accessibilityActionCompat);
            m912e(0, view);
        }
        return i;
    }

    public static void addKeyboardNavigationClusters(@NonNull View view, @NonNull Collection<View> collection, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            z23.m8374a(view, collection, i);
        }
    }

    public static void addOnUnhandledKeyEventListener(@NonNull View view, @NonNull OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        if (Build.VERSION.SDK_INT >= 28) {
            AbstractC0207e.m939a(view, onUnhandledKeyEventListenerCompat);
            return;
        }
        int i = R.id.tag_unhandled_key_listeners;
        ArrayList arrayList = (ArrayList) view.getTag(i);
        if (arrayList == null) {
            arrayList = new ArrayList();
            view.setTag(i, arrayList);
        }
        arrayList.add(onUnhandledKeyEventListenerCompat);
        if (arrayList.size() == 1) {
            ArrayList arrayList2 = C0208f.f3977d;
            synchronized (arrayList2) {
                try {
                    Iterator it = arrayList2.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (((WeakReference) it.next()).get() == view) {
                            }
                        } else {
                            C0208f.f3977d.add(new WeakReference(view));
                            break;
                        }
                    }
                } finally {
                }
            }
        }
    }

    @NonNull
    @Deprecated
    public static ViewPropertyAnimatorCompat animate(@NonNull View view) {
        if (f3911d == null) {
            f3911d = new WeakHashMap();
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = (ViewPropertyAnimatorCompat) f3911d.get(view);
        if (viewPropertyAnimatorCompat == null) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = new ViewPropertyAnimatorCompat(view);
            f3911d.put(view, viewPropertyAnimatorCompat2);
            return viewPropertyAnimatorCompat2;
        }
        return viewPropertyAnimatorCompat;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Object, androidx.core.view.f] */
    /* renamed from: b */
    public static boolean m909b(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList arrayList = C0208f.f3977d;
        int i = R.id.tag_unhandled_key_event_manager;
        C0208f c0208f = (C0208f) view.getTag(i);
        C0208f c0208f2 = c0208f;
        if (c0208f == null) {
            ?? obj = new Object();
            obj.f3978a = null;
            obj.f3979b = null;
            obj.f3980c = null;
            view.setTag(i, obj);
            c0208f2 = obj;
        }
        if (keyEvent.getAction() == 0) {
            WeakHashMap weakHashMap = c0208f2.f3978a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList arrayList2 = C0208f.f3977d;
            if (!arrayList2.isEmpty()) {
                synchronized (arrayList2) {
                    try {
                        if (c0208f2.f3978a == null) {
                            c0208f2.f3978a = new WeakHashMap();
                        }
                        for (int size = arrayList2.size() - 1; size >= 0; size--) {
                            ArrayList arrayList3 = C0208f.f3977d;
                            View view2 = (View) ((WeakReference) arrayList3.get(size)).get();
                            if (view2 == null) {
                                arrayList3.remove(size);
                            } else {
                                c0208f2.f3978a.put(view2, Boolean.TRUE);
                                for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                    c0208f2.f3978a.put((View) parent, Boolean.TRUE);
                                }
                            }
                        }
                    } finally {
                    }
                }
            }
        }
        View m950a = c0208f2.m950a(view, keyEvent);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (m950a != null && !KeyEvent.isModifierKey(keyCode)) {
                if (c0208f2.f3979b == null) {
                    c0208f2.f3979b = new SparseArray();
                }
                c0208f2.f3979b.put(keyCode, new WeakReference(m950a));
            }
        }
        if (m950a == null) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public static View.AccessibilityDelegate m910c(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return b33.m2008a(view);
        }
        if (f3914g) {
            return null;
        }
        if (f3913f == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f3913f = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f3914g = true;
                return null;
            }
        }
        try {
            Object obj = f3913f.get(view);
            if (!(obj instanceof View.AccessibilityDelegate)) {
                return null;
            }
            return (View.AccessibilityDelegate) obj;
        } catch (Throwable unused2) {
            f3914g = true;
            return null;
        }
    }

    @Deprecated
    public static boolean canScrollHorizontally(View view, int i) {
        return view.canScrollHorizontally(i);
    }

    @Deprecated
    public static boolean canScrollVertically(View view, int i) {
        return view.canScrollVertically(i);
    }

    public static void cancelDragAndDrop(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            y23.m8209a(view);
        }
    }

    @Deprecated
    public static int combineMeasuredStates(int i, int i2) {
        return View.combineMeasuredStates(i, i2);
    }

    @NonNull
    public static WindowInsetsCompat computeSystemWindowInsets(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Rect rect) {
        return w23.m7968b(view, windowInsetsCompat, rect);
    }

    /* renamed from: d */
    public static ArrayList m911d(View view) {
        int i = R.id.tag_accessibility_actions;
        ArrayList arrayList = (ArrayList) view.getTag(i);
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList();
            view.setTag(i, arrayList2);
            return arrayList2;
        }
        return arrayList;
    }

    @NonNull
    public static WindowInsetsCompat dispatchApplyWindowInsets(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
        WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
        if (windowInsets != null) {
            WindowInsets m7525a = u23.m7525a(view, windowInsets);
            if (!m7525a.equals(windowInsets)) {
                return WindowInsetsCompat.toWindowInsetsCompat(m7525a, view);
            }
        }
        return windowInsetsCompat;
    }

    public static void dispatchFinishTemporaryDetach(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            y23.m8210b(view);
            return;
        }
        if (!f3910c) {
            m908a();
        }
        Method method = f3909b;
        if (method != null) {
            try {
                method.invoke(view, null);
                return;
            } catch (Exception e) {
                Log.d("ViewCompat", "Error calling dispatchFinishTemporaryDetach", e);
                return;
            }
        }
        view.onFinishTemporaryDetach();
    }

    public static boolean dispatchNestedFling(@NonNull View view, float f, float f2, boolean z) {
        return w23.m7969c(view, f, f2, z);
    }

    public static boolean dispatchNestedPreFling(@NonNull View view, float f, float f2) {
        return w23.m7970d(view, f, f2);
    }

    public static boolean dispatchNestedPreScroll(@NonNull View view, int i, int i2, @Nullable int[] iArr, @Nullable int[] iArr2) {
        return w23.m7971e(view, i, i2, iArr, iArr2);
    }

    public static boolean dispatchNestedScroll(@NonNull View view, int i, int i2, int i3, int i4, @Nullable int[] iArr) {
        return w23.m7972f(view, i, i2, i3, i4, iArr);
    }

    public static void dispatchStartTemporaryDetach(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            y23.m8211c(view);
            return;
        }
        if (!f3910c) {
            m908a();
        }
        Method method = f3908a;
        if (method != null) {
            try {
                method.invoke(view, null);
                return;
            } catch (Exception e) {
                Log.d("ViewCompat", "Error calling dispatchStartTemporaryDetach", e);
                return;
            }
        }
        view.onStartTemporaryDetach();
    }

    /* renamed from: e */
    public static void m912e(int i, View view) {
        boolean z;
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (!accessibilityManager.isEnabled()) {
            return;
        }
        if (getAccessibilityPaneTitle(view) != null && view.isShown() && view.getWindowVisibility() == 0) {
            z = true;
        } else {
            z = false;
        }
        int i2 = 32;
        if (view.getAccessibilityLiveRegion() == 0 && !z) {
            if (i == 32) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain);
                obtain.setEventType(32);
                obtain.setContentChangeTypes(i);
                obtain.setSource(view);
                view.onPopulateAccessibilityEvent(obtain);
                obtain.getText().add(getAccessibilityPaneTitle(view));
                accessibilityManager.sendAccessibilityEvent(obtain);
                return;
            }
            if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i);
                    return;
                } catch (AbstractMethodError e) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName().concat(" does not fully implement ViewParent"), e);
                    return;
                }
            }
            return;
        }
        AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
        if (!z) {
            i2 = 2048;
        }
        obtain2.setEventType(i2);
        obtain2.setContentChangeTypes(i);
        if (z) {
            obtain2.getText().add(getAccessibilityPaneTitle(view));
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
        }
        view.sendAccessibilityEventUnchecked(obtain2);
    }

    public static void enableAccessibleClickableSpanSupport(@NonNull View view) {
        AccessibilityDelegateCompat accessibilityDelegate = getAccessibilityDelegate(view);
        if (accessibilityDelegate == null) {
            accessibilityDelegate = new AccessibilityDelegateCompat();
        }
        setAccessibilityDelegate(view, accessibilityDelegate);
    }

    /* renamed from: f */
    public static void m913f(int i, View view) {
        ArrayList m911d = m911d(view);
        for (int i2 = 0; i2 < m911d.size(); i2++) {
            if (((AccessibilityNodeInfoCompat.AccessibilityActionCompat) m911d.get(i2)).getId() == i) {
                m911d.remove(i2);
                return;
            }
        }
    }

    @Deprecated
    public static int generateViewId() {
        return View.generateViewId();
    }

    @Nullable
    public static AccessibilityDelegateCompat getAccessibilityDelegate(@NonNull View view) {
        View.AccessibilityDelegate m910c = m910c(view);
        if (m910c == null) {
            return null;
        }
        if (m910c instanceof C1292i3) {
            return ((C1292i3) m910c).f18278a;
        }
        return new AccessibilityDelegateCompat(m910c);
    }

    @Deprecated
    public static int getAccessibilityLiveRegion(@NonNull View view) {
        return view.getAccessibilityLiveRegion();
    }

    @Nullable
    public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(@NonNull View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = view.getAccessibilityNodeProvider();
        if (accessibilityNodeProvider != null) {
            return new AccessibilityNodeProviderCompat(accessibilityNodeProvider);
        }
        return null;
    }

    @Nullable
    @UiThread
    public static CharSequence getAccessibilityPaneTitle(@NonNull View view) {
        Object tag;
        int i = R.id.tag_accessibility_pane_title;
        if (Build.VERSION.SDK_INT >= 28) {
            tag = AbstractC0207e.m940b(view);
        } else {
            tag = view.getTag(i);
            if (!CharSequence.class.isInstance(tag)) {
                tag = null;
            }
        }
        return (CharSequence) tag;
    }

    @Deprecated
    public static float getAlpha(View view) {
        return view.getAlpha();
    }

    @Nullable
    public static AutofillIdCompat getAutofillId(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return AutofillIdCompat.toAutofillIdCompat(z23.m8375b(view));
        }
        return null;
    }

    @Nullable
    public static ColorStateList getBackgroundTintList(@NonNull View view) {
        return w23.m7973g(view);
    }

    @Nullable
    public static PorterDuff.Mode getBackgroundTintMode(@NonNull View view) {
        return w23.m7974h(view);
    }

    @Nullable
    @Deprecated
    public static Rect getClipBounds(@NonNull View view) {
        return view.getClipBounds();
    }

    @Nullable
    public static ContentCaptureSessionCompat getContentCaptureSession(@NonNull View view) {
        ContentCaptureSession m2009b;
        if (Build.VERSION.SDK_INT < 29 || (m2009b = b33.m2009b(view)) == null) {
            return null;
        }
        return ContentCaptureSessionCompat.toContentCaptureSessionCompat(m2009b, view);
    }

    @Nullable
    @Deprecated
    public static Display getDisplay(@NonNull View view) {
        return view.getDisplay();
    }

    public static float getElevation(@NonNull View view) {
        return w23.m7975i(view);
    }

    @Deprecated
    public static boolean getFitsSystemWindows(@NonNull View view) {
        return view.getFitsSystemWindows();
    }

    @Deprecated
    public static int getImportantForAccessibility(@NonNull View view) {
        return view.getImportantForAccessibility();
    }

    @SuppressLint({"InlinedApi"})
    public static int getImportantForAutofill(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return z23.m8376c(view);
        }
        return 0;
    }

    public static int getImportantForContentCapture(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return c33.m2190a(view);
        }
        return 0;
    }

    @Deprecated
    public static int getLabelFor(@NonNull View view) {
        return view.getLabelFor();
    }

    @Deprecated
    public static int getLayerType(View view) {
        return view.getLayerType();
    }

    @Deprecated
    public static int getLayoutDirection(@NonNull View view) {
        return view.getLayoutDirection();
    }

    @Nullable
    @Deprecated
    public static Matrix getMatrix(View view) {
        return view.getMatrix();
    }

    @Deprecated
    public static int getMeasuredHeightAndState(View view) {
        return view.getMeasuredHeightAndState();
    }

    @Deprecated
    public static int getMeasuredState(View view) {
        return view.getMeasuredState();
    }

    @Deprecated
    public static int getMeasuredWidthAndState(View view) {
        return view.getMeasuredWidthAndState();
    }

    @Deprecated
    public static int getMinimumHeight(@NonNull View view) {
        return view.getMinimumHeight();
    }

    @Deprecated
    public static int getMinimumWidth(@NonNull View view) {
        return view.getMinimumWidth();
    }

    public static int getNextClusterForwardId(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return z23.m8377d(view);
        }
        return -1;
    }

    @Nullable
    public static String[] getOnReceiveContentMimeTypes(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 31) {
            return d33.m4519a(view);
        }
        return (String[]) view.getTag(R.id.tag_on_receive_content_mime_types);
    }

    @Deprecated
    public static int getOverScrollMode(View view) {
        return view.getOverScrollMode();
    }

    @Px
    @Deprecated
    public static int getPaddingEnd(@NonNull View view) {
        return view.getPaddingEnd();
    }

    @Px
    @Deprecated
    public static int getPaddingStart(@NonNull View view) {
        return view.getPaddingStart();
    }

    @Nullable
    @Deprecated
    public static ViewParent getParentForAccessibility(@NonNull View view) {
        return view.getParentForAccessibility();
    }

    @Deprecated
    public static float getPivotX(View view) {
        return view.getPivotX();
    }

    @Deprecated
    public static float getPivotY(View view) {
        return view.getPivotY();
    }

    @Nullable
    public static WindowInsetsCompat getRootWindowInsets(@NonNull View view) {
        return x23.m8088a(view);
    }

    @Deprecated
    public static float getRotation(View view) {
        return view.getRotation();
    }

    @Deprecated
    public static float getRotationX(View view) {
        return view.getRotationX();
    }

    @Deprecated
    public static float getRotationY(View view) {
        return view.getRotationY();
    }

    @Deprecated
    public static float getScaleX(View view) {
        return view.getScaleX();
    }

    @Deprecated
    public static float getScaleY(View view) {
        return view.getScaleY();
    }

    public static int getScrollIndicators(@NonNull View view) {
        return x23.m8089b(view);
    }

    @Nullable
    @UiThread
    public static CharSequence getStateDescription(@NonNull View view) {
        Object tag;
        int i = R.id.tag_state_description;
        if (Build.VERSION.SDK_INT >= 30) {
            tag = c33.m2191b(view);
        } else {
            tag = view.getTag(i);
            if (!CharSequence.class.isInstance(tag)) {
                tag = null;
            }
        }
        return (CharSequence) tag;
    }

    @NonNull
    public static List<Rect> getSystemGestureExclusionRects(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return b33.m2010c(view);
        }
        return Collections.emptyList();
    }

    @Nullable
    public static String getTransitionName(@NonNull View view) {
        return w23.m7977k(view);
    }

    @Deprecated
    public static float getTranslationX(View view) {
        return view.getTranslationX();
    }

    @Deprecated
    public static float getTranslationY(View view) {
        return view.getTranslationY();
    }

    public static float getTranslationZ(@NonNull View view) {
        return w23.m7978l(view);
    }

    @Nullable
    @Deprecated
    public static WindowInsetsControllerCompat getWindowInsetsController(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return c33.m2192c(view);
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                Window window = ((Activity) context).getWindow();
                if (window == null) {
                    return null;
                }
                return WindowCompat.getInsetsController(window, view);
            }
        }
        return null;
    }

    @Deprecated
    public static int getWindowSystemUiVisibility(@NonNull View view) {
        return view.getWindowSystemUiVisibility();
    }

    @Deprecated
    public static float getX(View view) {
        return view.getX();
    }

    @Deprecated
    public static float getY(View view) {
        return view.getY();
    }

    public static float getZ(@NonNull View view) {
        return w23.m7979m(view);
    }

    public static boolean hasAccessibilityDelegate(@NonNull View view) {
        if (m910c(view) != null) {
            return true;
        }
        return false;
    }

    public static boolean hasExplicitFocusable(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return z23.m8378e(view);
        }
        return view.hasFocusable();
    }

    public static boolean hasNestedScrollingParent(@NonNull View view) {
        return w23.m7980n(view);
    }

    @Deprecated
    public static boolean hasOnClickListeners(@NonNull View view) {
        return view.hasOnClickListeners();
    }

    @Deprecated
    public static boolean hasOverlappingRendering(@NonNull View view) {
        return view.hasOverlappingRendering();
    }

    @Deprecated
    public static boolean hasTransientState(@NonNull View view) {
        return view.hasTransientState();
    }

    @UiThread
    public static boolean isAccessibilityHeading(@NonNull View view) {
        Object tag;
        int i = R.id.tag_accessibility_heading;
        if (Build.VERSION.SDK_INT >= 28) {
            tag = Boolean.valueOf(AbstractC0207e.m941c(view));
        } else {
            tag = view.getTag(i);
            if (!Boolean.class.isInstance(tag)) {
                tag = null;
            }
        }
        Boolean bool = (Boolean) tag;
        if (bool != null && bool.booleanValue()) {
            return true;
        }
        return false;
    }

    @Deprecated
    public static boolean isAttachedToWindow(@NonNull View view) {
        return view.isAttachedToWindow();
    }

    public static boolean isFocusedByDefault(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return z23.m8379f(view);
        }
        return false;
    }

    public static boolean isImportantForAccessibility(@NonNull View view) {
        return w23.m7981o(view);
    }

    public static boolean isImportantForAutofill(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return z23.m8380g(view);
        }
        return true;
    }

    public static boolean isImportantForContentCapture(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return c33.m2193d(view);
        }
        return false;
    }

    @Deprecated
    public static boolean isInLayout(@NonNull View view) {
        return view.isInLayout();
    }

    public static boolean isKeyboardNavigationCluster(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return z23.m8381h(view);
        }
        return false;
    }

    @Deprecated
    public static boolean isLaidOut(@NonNull View view) {
        return view.isLaidOut();
    }

    @Deprecated
    public static boolean isLayoutDirectionResolved(@NonNull View view) {
        return view.isLayoutDirectionResolved();
    }

    public static boolean isNestedScrollingEnabled(@NonNull View view) {
        return w23.m7982p(view);
    }

    @Deprecated
    public static boolean isOpaque(View view) {
        return view.isOpaque();
    }

    @Deprecated
    public static boolean isPaddingRelative(@NonNull View view) {
        return view.isPaddingRelative();
    }

    @UiThread
    public static boolean isScreenReaderFocusable(@NonNull View view) {
        Object tag;
        int i = R.id.tag_screen_reader_focusable;
        if (Build.VERSION.SDK_INT >= 28) {
            tag = Boolean.valueOf(AbstractC0207e.m942d(view));
        } else {
            tag = view.getTag(i);
            if (!Boolean.class.isInstance(tag)) {
                tag = null;
            }
        }
        Boolean bool = (Boolean) tag;
        if (bool != null && bool.booleanValue()) {
            return true;
        }
        return false;
    }

    @Deprecated
    public static void jumpDrawablesToCurrentState(View view) {
        view.jumpDrawablesToCurrentState();
    }

    @Nullable
    public static View keyboardNavigationClusterSearch(@NonNull View view, @Nullable View view2, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            return z23.m8382i(view, view2, i);
        }
        return null;
    }

    public static void offsetLeftAndRight(@NonNull View view, int i) {
        view.offsetLeftAndRight(i);
    }

    public static void offsetTopAndBottom(@NonNull View view, int i) {
        view.offsetTopAndBottom(i);
    }

    @NonNull
    public static WindowInsetsCompat onApplyWindowInsets(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
        WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
        if (windowInsets != null) {
            WindowInsets m7526b = u23.m7526b(view, windowInsets);
            if (!m7526b.equals(windowInsets)) {
                return WindowInsetsCompat.toWindowInsetsCompat(m7526b, view);
            }
        }
        return windowInsetsCompat;
    }

    @Deprecated
    public static void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        view.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    @Deprecated
    public static void onInitializeAccessibilityNodeInfo(@NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat.unwrap());
    }

    @Deprecated
    public static void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        view.onPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Deprecated
    public static boolean performAccessibilityAction(@NonNull View view, int i, @Nullable Bundle bundle) {
        return view.performAccessibilityAction(i, bundle);
    }

    public static boolean performHapticFeedback(@NonNull View view, int i) {
        int m905a = HapticFeedbackConstantsCompat.m905a(i);
        if (m905a == -1) {
            return false;
        }
        return view.performHapticFeedback(m905a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static ContentInfoCompat performReceiveContent(@NonNull View view, @NonNull ContentInfoCompat contentInfoCompat) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + contentInfoCompat + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return d33.m4520b(view, contentInfoCompat);
        }
        OnReceiveContentListener onReceiveContentListener = (OnReceiveContentListener) view.getTag(R.id.tag_on_receive_content_listener);
        OnReceiveContentViewBehavior onReceiveContentViewBehavior = f3916i;
        if (onReceiveContentListener != null) {
            ContentInfoCompat onReceiveContent = onReceiveContentListener.onReceiveContent(view, contentInfoCompat);
            if (onReceiveContent == null) {
                return null;
            }
            if (view instanceof OnReceiveContentViewBehavior) {
                onReceiveContentViewBehavior = (OnReceiveContentViewBehavior) view;
            }
            return onReceiveContentViewBehavior.onReceiveContent(onReceiveContent);
        }
        if (view instanceof OnReceiveContentViewBehavior) {
            onReceiveContentViewBehavior = (OnReceiveContentViewBehavior) view;
        }
        return onReceiveContentViewBehavior.onReceiveContent(contentInfoCompat);
    }

    @Deprecated
    public static void postInvalidateOnAnimation(@NonNull View view) {
        view.postInvalidateOnAnimation();
    }

    @Deprecated
    public static void postOnAnimation(@NonNull View view, @NonNull Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    @SuppressLint({"LambdaLast"})
    @Deprecated
    public static void postOnAnimationDelayed(@NonNull View view, @NonNull Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    public static void removeAccessibilityAction(@NonNull View view, int i) {
        m913f(i, view);
        m912e(0, view);
    }

    public static void removeOnUnhandledKeyEventListener(@NonNull View view, @NonNull OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        if (Build.VERSION.SDK_INT >= 28) {
            AbstractC0207e.m943e(view, onUnhandledKeyEventListenerCompat);
            return;
        }
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
        if (arrayList != null) {
            arrayList.remove(onUnhandledKeyEventListenerCompat);
            if (arrayList.size() == 0) {
                synchronized (C0208f.f3977d) {
                    int i = 0;
                    while (true) {
                        try {
                            ArrayList arrayList2 = C0208f.f3977d;
                            if (i < arrayList2.size()) {
                                if (((WeakReference) arrayList2.get(i)).get() == view) {
                                    arrayList2.remove(i);
                                    return;
                                }
                                i++;
                            } else {
                                return;
                            }
                        } finally {
                        }
                    }
                }
            }
        }
    }

    public static void replaceAccessibilityAction(@NonNull View view, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, @Nullable CharSequence charSequence, @Nullable AccessibilityViewCommand accessibilityViewCommand) {
        if (accessibilityViewCommand == null && charSequence == null) {
            removeAccessibilityAction(view, accessibilityActionCompat.getId());
            return;
        }
        AccessibilityNodeInfoCompat.AccessibilityActionCompat createReplacementAction = accessibilityActionCompat.createReplacementAction(charSequence, accessibilityViewCommand);
        AccessibilityDelegateCompat accessibilityDelegate = getAccessibilityDelegate(view);
        if (accessibilityDelegate == null) {
            accessibilityDelegate = new AccessibilityDelegateCompat();
        }
        setAccessibilityDelegate(view, accessibilityDelegate);
        m913f(createReplacementAction.getId(), view);
        m911d(view).add(createReplacementAction);
        m912e(0, view);
    }

    public static void requestApplyInsets(@NonNull View view) {
        u23.m7527c(view);
    }

    @NonNull
    public static <T extends View> T requireViewById(@NonNull View view, @IdRes int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (T) AbstractC0207e.m944f(view, i);
        }
        T t = (T) view.findViewById(i);
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this View");
    }

    @Deprecated
    public static int resolveSizeAndState(int i, int i2, int i3) {
        return View.resolveSizeAndState(i, i2, i3);
    }

    public static boolean restoreDefaultFocus(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return z23.m8383j(view);
        }
        return view.requestFocus();
    }

    public static void saveAttributeDataForStyleable(@NonNull View view, @NonNull @SuppressLint({"ContextFirst"}) Context context, @NonNull int[] iArr, @Nullable AttributeSet attributeSet, @NonNull TypedArray typedArray, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 29) {
            b33.m2011d(view, context, iArr, attributeSet, typedArray, i, i2);
        }
    }

    public static void setAccessibilityDelegate(@NonNull View view, @Nullable AccessibilityDelegateCompat accessibilityDelegateCompat) {
        C1292i3 c1292i3;
        if (accessibilityDelegateCompat == null && (m910c(view) instanceof C1292i3)) {
            accessibilityDelegateCompat = new AccessibilityDelegateCompat();
        }
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
        if (accessibilityDelegateCompat == null) {
            c1292i3 = null;
        } else {
            c1292i3 = accessibilityDelegateCompat.f3853b;
        }
        view.setAccessibilityDelegate(c1292i3);
    }

    @UiThread
    public static void setAccessibilityHeading(@NonNull View view, boolean z) {
        new s23(R.id.tag_accessibility_heading, Boolean.class, 0, 28, 3).m7318a(view, Boolean.valueOf(z));
    }

    @Deprecated
    public static void setAccessibilityLiveRegion(@NonNull View view, int i) {
        view.setAccessibilityLiveRegion(i);
    }

    @UiThread
    public static void setAccessibilityPaneTitle(@NonNull View view, @Nullable CharSequence charSequence) {
        boolean z;
        new s23(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28, 1).m7318a(view, charSequence);
        t23 t23Var = f3917j;
        if (charSequence != null) {
            WeakHashMap weakHashMap = t23Var.f26676a;
            if (view.isShown() && view.getWindowVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            weakHashMap.put(view, Boolean.valueOf(z));
            view.addOnAttachStateChangeListener(t23Var);
            if (view.isAttachedToWindow()) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(t23Var);
                return;
            }
            return;
        }
        t23Var.f26676a.remove(view);
        view.removeOnAttachStateChangeListener(t23Var);
        view.getViewTreeObserver().removeOnGlobalLayoutListener(t23Var);
    }

    @Deprecated
    public static void setActivated(View view, boolean z) {
        view.setActivated(z);
    }

    @Deprecated
    public static void setAlpha(View view, @FloatRange(from = 0.0d, m152to = 1.0d) float f) {
        view.setAlpha(f);
    }

    public static void setAutofillHints(@NonNull View view, @Nullable String... strArr) {
        if (Build.VERSION.SDK_INT >= 26) {
            z23.m8384k(view, strArr);
        }
    }

    public static void setAutofillId(@NonNull View view, @Nullable AutofillIdCompat autofillIdCompat) {
        if (Build.VERSION.SDK_INT >= 28) {
            AbstractC0207e.m947i(view, autofillIdCompat);
        }
    }

    @Deprecated
    public static void setBackground(@NonNull View view, @Nullable Drawable drawable) {
        view.setBackground(drawable);
    }

    public static void setBackgroundTintList(@NonNull View view, @Nullable ColorStateList colorStateList) {
        w23.m7983q(view, colorStateList);
    }

    public static void setBackgroundTintMode(@NonNull View view, @Nullable PorterDuff.Mode mode) {
        w23.m7984r(view, mode);
    }

    @SuppressLint({"BanUncheckedReflection"})
    @Deprecated
    public static void setChildrenDrawingOrderEnabled(ViewGroup viewGroup, boolean z) {
        if (f3912e == null) {
            try {
                f3912e = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException e) {
                Log.e("ViewCompat", "Unable to find childrenDrawingOrderEnabled", e);
            }
            f3912e.setAccessible(true);
        }
        try {
            f3912e.invoke(viewGroup, Boolean.valueOf(z));
        } catch (IllegalAccessException e2) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e2);
        } catch (IllegalArgumentException e3) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e3);
        } catch (InvocationTargetException e4) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e4);
        }
    }

    @Deprecated
    public static void setClipBounds(@NonNull View view, @Nullable Rect rect) {
        view.setClipBounds(rect);
    }

    public static void setContentCaptureSession(@NonNull View view, @Nullable ContentCaptureSessionCompat contentCaptureSessionCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            b33.m2012e(view, contentCaptureSessionCompat);
        }
    }

    public static void setElevation(@NonNull View view, float f) {
        w23.m7985s(view, f);
    }

    @Deprecated
    public static void setFitsSystemWindows(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static void setFocusedByDefault(@NonNull View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            z23.m8385l(view, z);
        }
    }

    @Deprecated
    public static void setHasTransientState(@NonNull View view, boolean z) {
        view.setHasTransientState(z);
    }

    @UiThread
    @Deprecated
    public static void setImportantForAccessibility(@NonNull View view, int i) {
        view.setImportantForAccessibility(i);
    }

    public static void setImportantForAutofill(@NonNull View view, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            z23.m8386m(view, i);
        }
    }

    public static void setImportantForContentCapture(@NonNull View view, int i) {
        if (Build.VERSION.SDK_INT >= 30) {
            c33.m2194e(view, i);
        }
    }

    public static void setKeyboardNavigationCluster(@NonNull View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            z23.m8387n(view, z);
        }
    }

    @Deprecated
    public static void setLabelFor(@NonNull View view, @IdRes int i) {
        view.setLabelFor(i);
    }

    @Deprecated
    public static void setLayerPaint(@NonNull View view, @Nullable Paint paint) {
        view.setLayerPaint(paint);
    }

    @Deprecated
    public static void setLayerType(View view, int i, Paint paint) {
        view.setLayerType(i, paint);
    }

    @Deprecated
    public static void setLayoutDirection(@NonNull View view, int i) {
        view.setLayoutDirection(i);
    }

    public static void setNestedScrollingEnabled(@NonNull View view, boolean z) {
        w23.m7986t(view, z);
    }

    public static void setNextClusterForwardId(@NonNull View view, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            z23.m8388o(view, i);
        }
    }

    public static void setOnApplyWindowInsetsListener(@NonNull View view, @Nullable OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        w23.m7987u(view, onApplyWindowInsetsListener);
    }

    public static void setOnReceiveContentListener(@NonNull View view, @Nullable String[] strArr, @Nullable OnReceiveContentListener onReceiveContentListener) {
        boolean z;
        if (Build.VERSION.SDK_INT >= 31) {
            d33.m4521c(view, strArr, onReceiveContentListener);
            return;
        }
        if (strArr == null || strArr.length == 0) {
            strArr = null;
        }
        boolean z2 = false;
        if (onReceiveContentListener != null) {
            if (strArr != null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "When the listener is set, MIME types must also be set");
        }
        if (strArr != null) {
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (strArr[i].startsWith("*")) {
                    z2 = true;
                    break;
                }
                i++;
            }
            Preconditions.checkArgument(!z2, "A MIME type set here must not start with *: " + Arrays.toString(strArr));
        }
        view.setTag(R.id.tag_on_receive_content_mime_types, strArr);
        view.setTag(R.id.tag_on_receive_content_listener, onReceiveContentListener);
    }

    @Deprecated
    public static void setOverScrollMode(View view, int i) {
        view.setOverScrollMode(i);
    }

    @Deprecated
    public static void setPaddingRelative(@NonNull View view, @Px int i, @Px int i2, @Px int i3, @Px int i4) {
        view.setPaddingRelative(i, i2, i3, i4);
    }

    @Deprecated
    public static void setPivotX(View view, float f) {
        view.setPivotX(f);
    }

    @Deprecated
    public static void setPivotY(View view, float f) {
        view.setPivotY(f);
    }

    public static void setPointerIcon(@NonNull View view, @Nullable PointerIconCompat pointerIconCompat) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 24) {
            if (pointerIconCompat != null) {
                obj = pointerIconCompat.getPointerIcon();
            } else {
                obj = null;
            }
            y23.m8212d(view, go2.m4961b(obj));
        }
    }

    @Deprecated
    public static void setRotation(View view, float f) {
        view.setRotation(f);
    }

    @Deprecated
    public static void setRotationX(View view, float f) {
        view.setRotationX(f);
    }

    @Deprecated
    public static void setRotationY(View view, float f) {
        view.setRotationY(f);
    }

    @Deprecated
    public static void setSaveFromParentEnabled(View view, boolean z) {
        view.setSaveFromParentEnabled(z);
    }

    @Deprecated
    public static void setScaleX(View view, float f) {
        view.setScaleX(f);
    }

    @Deprecated
    public static void setScaleY(View view, float f) {
        view.setScaleY(f);
    }

    @UiThread
    public static void setScreenReaderFocusable(@NonNull View view, boolean z) {
        new s23(R.id.tag_screen_reader_focusable, Boolean.class, 0, 28, 0).m7318a(view, Boolean.valueOf(z));
    }

    public static void setScrollIndicators(@NonNull View view, int i) {
        x23.m8090c(view, i);
    }

    @UiThread
    public static void setStateDescription(@NonNull View view, @Nullable CharSequence charSequence) {
        new s23(R.id.tag_state_description, CharSequence.class, 64, 30, 2).m7318a(view, charSequence);
    }

    public static void setSystemGestureExclusionRects(@NonNull View view, @NonNull List<Rect> list) {
        if (Build.VERSION.SDK_INT >= 29) {
            b33.m2013f(view, list);
        }
    }

    public static void setTooltipText(@NonNull View view, @Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            z23.m8389p(view, charSequence);
        }
    }

    public static void setTransitionName(@NonNull View view, @Nullable String str) {
        w23.m7988v(view, str);
    }

    @Deprecated
    public static void setTranslationX(View view, float f) {
        view.setTranslationX(f);
    }

    @Deprecated
    public static void setTranslationY(View view, float f) {
        view.setTranslationY(f);
    }

    public static void setTranslationZ(@NonNull View view, float f) {
        w23.m7989w(view, f);
    }

    public static void setWindowInsetsAnimationCallback(@NonNull View view, @Nullable WindowInsetsAnimationCompat.Callback callback) {
        C0214j c0214j = null;
        if (Build.VERSION.SDK_INT >= 30) {
            if (callback != null) {
                c0214j = new C0214j(callback);
            }
            view.setWindowInsetsAnimationCallback(c0214j);
            return;
        }
        PathInterpolator pathInterpolator = C0211i.f3987f;
        Object tag = view.getTag(R.id.tag_on_apply_window_listener);
        if (callback == null) {
            view.setTag(R.id.tag_window_insets_animation_callback, null);
            if (tag == null) {
                view.setOnApplyWindowInsetsListener(null);
                return;
            }
            return;
        }
        View.OnApplyWindowInsetsListener viewOnApplyWindowInsetsListenerC0210h = new ViewOnApplyWindowInsetsListenerC0210h(view, callback);
        view.setTag(R.id.tag_window_insets_animation_callback, viewOnApplyWindowInsetsListenerC0210h);
        if (tag == null) {
            view.setOnApplyWindowInsetsListener(viewOnApplyWindowInsetsListenerC0210h);
        }
    }

    @Deprecated
    public static void setX(View view, float f) {
        view.setX(f);
    }

    @Deprecated
    public static void setY(View view, float f) {
        view.setY(f);
    }

    public static void setZ(@NonNull View view, float f) {
        w23.m7990x(view, f);
    }

    public static boolean startDragAndDrop(@NonNull View view, @Nullable ClipData clipData, @NonNull View.DragShadowBuilder dragShadowBuilder, @Nullable Object obj, int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            return y23.m8213e(view, clipData, dragShadowBuilder, obj, i);
        }
        return view.startDrag(clipData, dragShadowBuilder, obj, i);
    }

    public static boolean startNestedScroll(@NonNull View view, int i) {
        return w23.m7991y(view, i);
    }

    public static void stopNestedScroll(@NonNull View view) {
        w23.m7992z(view);
    }

    public static void updateDragShadow(@NonNull View view, @NonNull View.DragShadowBuilder dragShadowBuilder) {
        if (Build.VERSION.SDK_INT >= 24) {
            y23.m8214f(view, dragShadowBuilder);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean dispatchNestedPreScroll(@NonNull View view, int i, int i2, @Nullable int[] iArr, @Nullable int[] iArr2, int i3) {
        if (view instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2) view).dispatchNestedPreScroll(i, i2, iArr, iArr2, i3);
        }
        if (i3 == 0) {
            return dispatchNestedPreScroll(view, i, i2, iArr, iArr2);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void dispatchNestedScroll(@NonNull View view, int i, int i2, int i3, int i4, @Nullable int[] iArr, int i5, @NonNull int[] iArr2) {
        if (view instanceof NestedScrollingChild3) {
            ((NestedScrollingChild3) view).dispatchNestedScroll(i, i2, i3, i4, iArr, i5, iArr2);
        } else {
            dispatchNestedScroll(view, i, i2, i3, i4, iArr, i5);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean hasNestedScrollingParent(@NonNull View view, int i) {
        if (view instanceof NestedScrollingChild2) {
            ((NestedScrollingChild2) view).hasNestedScrollingParent(i);
            return false;
        }
        if (i == 0) {
            return hasNestedScrollingParent(view);
        }
        return false;
    }

    @Deprecated
    public static void postInvalidateOnAnimation(@NonNull View view, int i, int i2, int i3, int i4) {
        view.postInvalidateOnAnimation(i, i2, i3, i4);
    }

    public static void setScrollIndicators(@NonNull View view, int i, int i2) {
        x23.m8091d(view, i, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean startNestedScroll(@NonNull View view, int i, int i2) {
        if (view instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2) view).startNestedScroll(i, i2);
        }
        if (i2 == 0) {
            return startNestedScroll(view, i);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void stopNestedScroll(@NonNull View view, int i) {
        if (view instanceof NestedScrollingChild2) {
            ((NestedScrollingChild2) view).stopNestedScroll(i);
        } else if (i == 0) {
            stopNestedScroll(view);
        }
    }

    public static boolean performHapticFeedback(@NonNull View view, int i, int i2) {
        int m905a = HapticFeedbackConstantsCompat.m905a(i);
        if (m905a == -1) {
            return false;
        }
        return view.performHapticFeedback(m905a, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean dispatchNestedScroll(@NonNull View view, int i, int i2, int i3, int i4, @Nullable int[] iArr, int i5) {
        if (view instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2) view).dispatchNestedScroll(i, i2, i3, i4, iArr, i5);
        }
        if (i5 == 0) {
            return dispatchNestedScroll(view, i, i2, i3, i4, iArr);
        }
        return false;
    }
}
