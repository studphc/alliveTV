package androidx.customview.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewParentCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.extractor.p002ts.TsExtractor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p000.dx0;
import p000.p63;
import p000.us0;
import p000.wd0;
import p000.xb0;

/* loaded from: classes.dex */
public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {
    public static final int HOST_ID = -1;
    public static final int INVALID_ID = Integer.MIN_VALUE;

    /* renamed from: n */
    public static final Rect f4099n = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* renamed from: o */
    public static final wd0 f4100o = new wd0(13);

    /* renamed from: p */
    public static final dx0 f4101p = new dx0(13);

    /* renamed from: h */
    public final AccessibilityManager f4106h;

    /* renamed from: i */
    public final View f4107i;

    /* renamed from: j */
    public xb0 f4108j;

    /* renamed from: d */
    public final Rect f4102d = new Rect();

    /* renamed from: e */
    public final Rect f4103e = new Rect();

    /* renamed from: f */
    public final Rect f4104f = new Rect();

    /* renamed from: g */
    public final int[] f4105g = new int[2];

    /* renamed from: k */
    public int f4109k = Integer.MIN_VALUE;

    /* renamed from: l */
    public int f4110l = Integer.MIN_VALUE;

    /* renamed from: m */
    public int f4111m = Integer.MIN_VALUE;

    public ExploreByTouchHelper(@NonNull View view) {
        if (view != null) {
            this.f4107i = view;
            this.f4106h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            if (ViewCompat.getImportantForAccessibility(view) == 0) {
                ViewCompat.setImportantForAccessibility(view, 1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    /* renamed from: a */
    public final AccessibilityEvent m1030a(int i, int i2) {
        View view = this.f4107i;
        if (i != -1) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
            AccessibilityNodeInfoCompat m1033d = m1033d(i);
            obtain.getText().add(m1033d.getText());
            obtain.setContentDescription(m1033d.getContentDescription());
            obtain.setScrollable(m1033d.isScrollable());
            obtain.setPassword(m1033d.isPassword());
            obtain.setEnabled(m1033d.isEnabled());
            obtain.setChecked(m1033d.isChecked());
            onPopulateEventForVirtualView(i, obtain);
            if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
                throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
            }
            obtain.setClassName(m1033d.getClassName());
            AccessibilityRecordCompat.setSource(obtain, view, i);
            obtain.setPackageName(view.getContext().getPackageName());
            return obtain;
        }
        AccessibilityEvent obtain2 = AccessibilityEvent.obtain(i2);
        view.onInitializeAccessibilityEvent(obtain2);
        return obtain2;
    }

    /* renamed from: b */
    public final AccessibilityNodeInfoCompat m1031b(int i) {
        boolean z;
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain();
        obtain.setEnabled(true);
        obtain.setFocusable(true);
        obtain.setClassName("android.view.View");
        Rect rect = f4099n;
        obtain.setBoundsInParent(rect);
        obtain.setBoundsInScreen(rect);
        View view = this.f4107i;
        obtain.setParent(view);
        onPopulateNodeForVirtualView(i, obtain);
        if (obtain.getText() == null && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        Rect rect2 = this.f4103e;
        obtain.getBoundsInParent(rect2);
        if (!rect2.equals(rect)) {
            int actions = obtain.getActions();
            if ((actions & 64) == 0) {
                if ((actions & 128) == 0) {
                    obtain.setPackageName(view.getContext().getPackageName());
                    obtain.setSource(view, i);
                    if (this.f4109k == i) {
                        obtain.setAccessibilityFocused(true);
                        obtain.addAction(128);
                    } else {
                        obtain.setAccessibilityFocused(false);
                        obtain.addAction(64);
                    }
                    if (this.f4110l == i) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        obtain.addAction(2);
                    } else if (obtain.isFocusable()) {
                        obtain.addAction(1);
                    }
                    obtain.setFocused(z);
                    int[] iArr = this.f4105g;
                    view.getLocationOnScreen(iArr);
                    Rect rect3 = this.f4102d;
                    obtain.getBoundsInScreen(rect3);
                    if (rect3.equals(rect)) {
                        obtain.getBoundsInParent(rect3);
                        if (obtain.mParentVirtualDescendantId != -1) {
                            AccessibilityNodeInfoCompat obtain2 = AccessibilityNodeInfoCompat.obtain();
                            for (int i2 = obtain.mParentVirtualDescendantId; i2 != -1; i2 = obtain2.mParentVirtualDescendantId) {
                                obtain2.setParent(view, -1);
                                obtain2.setBoundsInParent(rect);
                                onPopulateNodeForVirtualView(i2, obtain2);
                                obtain2.getBoundsInParent(rect2);
                                rect3.offset(rect2.left, rect2.top);
                            }
                            obtain2.recycle();
                        }
                        rect3.offset(iArr[0] - view.getScrollX(), iArr[1] - view.getScrollY());
                    }
                    Rect rect4 = this.f4104f;
                    if (view.getLocalVisibleRect(rect4)) {
                        rect4.offset(iArr[0] - view.getScrollX(), iArr[1] - view.getScrollY());
                        if (rect3.intersect(rect4)) {
                            obtain.setBoundsInScreen(rect3);
                            if (rect3 != null && !rect3.isEmpty() && view.getWindowVisibility() == 0) {
                                Object parent = view.getParent();
                                while (true) {
                                    if (parent instanceof View) {
                                        View view2 = (View) parent;
                                        if (view2.getAlpha() <= RecyclerView.f7068F0 || view2.getVisibility() != 0) {
                                            break;
                                        }
                                        parent = view2.getParent();
                                    } else if (parent != null) {
                                        obtain.setVisibleToUser(true);
                                    }
                                }
                            }
                        }
                    }
                    return obtain;
                }
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
    }

    /* renamed from: c */
    public final boolean m1032c(int i, Rect rect) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat;
        boolean z;
        Object obj;
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2;
        int lastIndexOf;
        int i2;
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        SparseArrayCompat sparseArrayCompat = new SparseArrayCompat();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            sparseArrayCompat.put(i3, m1031b(i3));
        }
        int i4 = this.f4110l;
        int i5 = Integer.MIN_VALUE;
        if (i4 == Integer.MIN_VALUE) {
            accessibilityNodeInfoCompat = null;
        } else {
            accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) sparseArrayCompat.get(i4);
        }
        wd0 wd0Var = f4100o;
        dx0 dx0Var = f4101p;
        View view = this.f4107i;
        if (i != 1 && i != 2) {
            if (i != 17 && i != 33 && i != 66 && i != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect2 = new Rect();
            int i6 = this.f4110l;
            if (i6 != Integer.MIN_VALUE) {
                m1033d(i6).getBoundsInParent(rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                int width = view.getWidth();
                int height = view.getHeight();
                if (i != 17) {
                    if (i != 33) {
                        if (i != 66) {
                            if (i == 130) {
                                rect2.set(0, -1, width, -1);
                            } else {
                                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                            }
                        } else {
                            rect2.set(-1, 0, -1, height);
                        }
                    } else {
                        rect2.set(0, height, width, height);
                    }
                } else {
                    rect2.set(width, 0, width, height);
                }
            }
            Rect rect3 = new Rect(rect2);
            if (i != 17) {
                if (i != 33) {
                    if (i != 66) {
                        if (i == 130) {
                            i2 = 0;
                            rect3.offset(0, -(rect2.height() + 1));
                        } else {
                            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                        }
                    } else {
                        i2 = 0;
                        rect3.offset(-(rect2.width() + 1), 0);
                    }
                } else {
                    i2 = 0;
                    rect3.offset(0, rect2.height() + 1);
                }
            } else {
                i2 = 0;
                rect3.offset(rect2.width() + 1, 0);
            }
            dx0Var.getClass();
            int size = sparseArrayCompat.size();
            Rect rect4 = new Rect();
            accessibilityNodeInfoCompat2 = null;
            while (i2 < size) {
                AccessibilityNodeInfoCompat accessibilityNodeInfoCompat3 = (AccessibilityNodeInfoCompat) sparseArrayCompat.valueAt(i2);
                if (accessibilityNodeInfoCompat3 != accessibilityNodeInfoCompat) {
                    wd0Var.getClass();
                    accessibilityNodeInfoCompat3.getBoundsInParent(rect4);
                    if (p63.m6843C(i, rect2, rect4)) {
                        if (p63.m6843C(i, rect2, rect3) && !p63.m6859c(i, rect2, rect4, rect3)) {
                            if (!p63.m6859c(i, rect2, rect3, rect4)) {
                                int m6844D = p63.m6844D(i, rect2, rect4);
                                int m6845E = p63.m6845E(i, rect2, rect4);
                                int i7 = (m6845E * m6845E) + (m6844D * 13 * m6844D);
                                int m6844D2 = p63.m6844D(i, rect2, rect3);
                                int m6845E2 = p63.m6845E(i, rect2, rect3);
                                if (i7 >= (m6845E2 * m6845E2) + (m6844D2 * 13 * m6844D2)) {
                                }
                            }
                        }
                        rect3.set(rect4);
                        accessibilityNodeInfoCompat2 = accessibilityNodeInfoCompat3;
                    }
                }
                i2++;
            }
        } else {
            if (ViewCompat.getLayoutDirection(view) == 1) {
                z = true;
            } else {
                z = false;
            }
            dx0Var.getClass();
            int size2 = sparseArrayCompat.size();
            ArrayList arrayList2 = new ArrayList(size2);
            for (int i8 = 0; i8 < size2; i8++) {
                arrayList2.add((AccessibilityNodeInfoCompat) sparseArrayCompat.valueAt(i8));
            }
            Collections.sort(arrayList2, new us0(z, wd0Var));
            if (i != 1) {
                if (i == 2) {
                    int size3 = arrayList2.size();
                    if (accessibilityNodeInfoCompat == null) {
                        lastIndexOf = -1;
                    } else {
                        lastIndexOf = arrayList2.lastIndexOf(accessibilityNodeInfoCompat);
                    }
                    int i9 = lastIndexOf + 1;
                    if (i9 < size3) {
                        obj = arrayList2.get(i9);
                        accessibilityNodeInfoCompat2 = (AccessibilityNodeInfoCompat) obj;
                    }
                    obj = null;
                    accessibilityNodeInfoCompat2 = (AccessibilityNodeInfoCompat) obj;
                } else {
                    throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
                }
            } else {
                int size4 = arrayList2.size();
                if (accessibilityNodeInfoCompat != null) {
                    size4 = arrayList2.indexOf(accessibilityNodeInfoCompat);
                }
                int i10 = size4 - 1;
                if (i10 >= 0) {
                    obj = arrayList2.get(i10);
                    accessibilityNodeInfoCompat2 = (AccessibilityNodeInfoCompat) obj;
                }
                obj = null;
                accessibilityNodeInfoCompat2 = (AccessibilityNodeInfoCompat) obj;
            }
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat4 = accessibilityNodeInfoCompat2;
        if (accessibilityNodeInfoCompat4 != null) {
            i5 = sparseArrayCompat.keyAt(sparseArrayCompat.indexOfValue(accessibilityNodeInfoCompat4));
        }
        return requestKeyboardFocusForVirtualView(i5);
    }

    public final boolean clearKeyboardFocusForVirtualView(int i) {
        if (this.f4110l != i) {
            return false;
        }
        this.f4110l = Integer.MIN_VALUE;
        onVirtualViewKeyboardFocusChanged(i, false);
        sendEventForVirtualView(i, 8);
        return true;
    }

    /* renamed from: d */
    public final AccessibilityNodeInfoCompat m1033d(int i) {
        if (i == -1) {
            View view = this.f4107i;
            AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(view);
            ViewCompat.onInitializeAccessibilityNodeInfo(view, obtain);
            ArrayList arrayList = new ArrayList();
            getVisibleVirtualViews(arrayList);
            if (obtain.getChildCount() > 0 && arrayList.size() > 0) {
                throw new RuntimeException("Views cannot have both real and virtual children");
            }
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                obtain.addChild(view, ((Integer) arrayList.get(i2)).intValue());
            }
            return obtain;
        }
        return m1031b(i);
    }

    public final boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        int i;
        AccessibilityManager accessibilityManager = this.f4106h;
        if (!accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7 && action != 9) {
            if (action != 10 || (i = this.f4111m) == Integer.MIN_VALUE) {
                return false;
            }
            if (i != Integer.MIN_VALUE) {
                this.f4111m = Integer.MIN_VALUE;
                sendEventForVirtualView(Integer.MIN_VALUE, 128);
                sendEventForVirtualView(i, 256);
            }
            return true;
        }
        int virtualViewAt = getVirtualViewAt(motionEvent.getX(), motionEvent.getY());
        int i2 = this.f4111m;
        if (i2 != virtualViewAt) {
            this.f4111m = virtualViewAt;
            sendEventForVirtualView(virtualViewAt, 128);
            sendEventForVirtualView(i2, 256);
        }
        if (virtualViewAt == Integer.MIN_VALUE) {
            return false;
        }
        return true;
    }

    public final boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        int i = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 61) {
            int i2 = 66;
            if (keyCode != 66) {
                switch (keyCode) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                        if (!keyEvent.hasNoModifiers()) {
                            return false;
                        }
                        if (keyCode != 19) {
                            if (keyCode != 21) {
                                if (keyCode != 22) {
                                    i2 = TsExtractor.TS_STREAM_TYPE_HDMV_DTS;
                                }
                            } else {
                                i2 = 17;
                            }
                        } else {
                            i2 = 33;
                        }
                        int repeatCount = keyEvent.getRepeatCount() + 1;
                        boolean z = false;
                        while (i < repeatCount && m1032c(i2, null)) {
                            i++;
                            z = true;
                        }
                        return z;
                    case 23:
                        break;
                    default:
                        return false;
                }
            }
            if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
                return false;
            }
            int i3 = this.f4110l;
            if (i3 != Integer.MIN_VALUE) {
                onPerformActionForVirtualView(i3, 16, null);
            }
            return true;
        }
        if (keyEvent.hasNoModifiers()) {
            return m1032c(2, null);
        }
        if (!keyEvent.hasModifiers(1)) {
            return false;
        }
        return m1032c(1, null);
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.f4109k;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        if (this.f4108j == null) {
            this.f4108j = new xb0(this);
        }
        return this.f4108j;
    }

    @Deprecated
    public int getFocusedVirtualView() {
        return getAccessibilityFocusedVirtualViewId();
    }

    public final int getKeyboardFocusedVirtualViewId() {
        return this.f4110l;
    }

    public abstract int getVirtualViewAt(float f, float f2);

    public abstract void getVisibleVirtualViews(List<Integer> list);

    public final void invalidateRoot() {
        invalidateVirtualView(-1, 1);
    }

    public final void invalidateVirtualView(int i) {
        invalidateVirtualView(i, 0);
    }

    public final void onFocusChanged(boolean z, int i, @Nullable Rect rect) {
        int i2 = this.f4110l;
        if (i2 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i2);
        }
        if (z) {
            m1032c(i, rect);
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        onPopulateEventForHost(accessibilityEvent);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        onPopulateNodeForHost(accessibilityNodeInfoCompat);
    }

    public abstract boolean onPerformActionForVirtualView(int i, int i2, @Nullable Bundle bundle);

    public void onPopulateEventForHost(@NonNull AccessibilityEvent accessibilityEvent) {
    }

    public void onPopulateEventForVirtualView(int i, @NonNull AccessibilityEvent accessibilityEvent) {
    }

    public void onPopulateNodeForHost(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    public abstract void onPopulateNodeForVirtualView(int i, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

    public void onVirtualViewKeyboardFocusChanged(int i, boolean z) {
    }

    public final boolean requestKeyboardFocusForVirtualView(int i) {
        int i2;
        View view = this.f4107i;
        if ((!view.isFocused() && !view.requestFocus()) || (i2 = this.f4110l) == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i2);
        }
        this.f4110l = i;
        onVirtualViewKeyboardFocusChanged(i, true);
        sendEventForVirtualView(i, 8);
        return true;
    }

    public final boolean sendEventForVirtualView(int i, int i2) {
        View view;
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.f4106h.isEnabled() || (parent = (view = this.f4107i).getParent()) == null) {
            return false;
        }
        return ViewParentCompat.requestSendAccessibilityEvent(parent, view, m1030a(i, i2));
    }

    public final void invalidateVirtualView(int i, int i2) {
        View view;
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.f4106h.isEnabled() || (parent = (view = this.f4107i).getParent()) == null) {
            return;
        }
        AccessibilityEvent m1030a = m1030a(i, 2048);
        AccessibilityEventCompat.setContentChangeTypes(m1030a, i2);
        ViewParentCompat.requestSendAccessibilityEvent(parent, view, m1030a);
    }
}
