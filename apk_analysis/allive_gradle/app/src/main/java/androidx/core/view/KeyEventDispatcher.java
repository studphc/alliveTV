package androidx.core.view;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class KeyEventDispatcher {

    /* renamed from: a */
    public static boolean f3882a = false;

    /* renamed from: b */
    public static Method f3883b = null;

    /* renamed from: c */
    public static boolean f3884c = false;

    /* renamed from: d */
    public static Field f3885d;

    /* loaded from: classes.dex */
    public interface Component {
        boolean superDispatchKeyEvent(@NonNull KeyEvent keyEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Object, androidx.core.view.f] */
    public static boolean dispatchBeforeHierarchy(@NonNull View view, @NonNull KeyEvent keyEvent) {
        int indexOfKey;
        int i = ViewCompat.OVER_SCROLL_ALWAYS;
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList arrayList = C0208f.f3977d;
        int i2 = R.id.tag_unhandled_key_event_manager;
        C0208f c0208f = (C0208f) view.getTag(i2);
        WeakReference weakReference = null;
        C0208f c0208f2 = c0208f;
        if (c0208f == null) {
            ?? obj = new Object();
            obj.f3978a = null;
            obj.f3979b = null;
            obj.f3980c = null;
            view.setTag(i2, obj);
            c0208f2 = obj;
        }
        WeakReference weakReference2 = c0208f2.f3980c;
        if (weakReference2 != null && weakReference2.get() == keyEvent) {
            return false;
        }
        c0208f2.f3980c = new WeakReference(keyEvent);
        if (c0208f2.f3979b == null) {
            c0208f2.f3979b = new SparseArray();
        }
        SparseArray sparseArray = c0208f2.f3979b;
        if (keyEvent.getAction() == 1 && (indexOfKey = sparseArray.indexOfKey(keyEvent.getKeyCode())) >= 0) {
            weakReference = (WeakReference) sparseArray.valueAt(indexOfKey);
            sparseArray.removeAt(indexOfKey);
        }
        if (weakReference == null) {
            weakReference = (WeakReference) sparseArray.get(keyEvent.getKeyCode());
        }
        if (weakReference == null) {
            return false;
        }
        View view2 = (View) weakReference.get();
        if (view2 != null && view2.isAttachedToWindow()) {
            C0208f.m949b(view2, keyEvent);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    @SuppressLint({"LambdaLast"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean dispatchKeyEvent(@NonNull Component component, @Nullable View view, @Nullable Window.Callback callback, @NonNull KeyEvent keyEvent) {
        DialogInterface.OnKeyListener onKeyListener;
        Window window;
        boolean z = false;
        if (component == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return component.superDispatchKeyEvent(keyEvent);
        }
        KeyEvent.DispatcherState dispatcherState = null;
        if (callback instanceof Activity) {
            Activity activity = (Activity) callback;
            activity.onUserInteraction();
            Window window2 = activity.getWindow();
            if (window2.hasFeature(8)) {
                ActionBar actionBar = activity.getActionBar();
                if (keyEvent.getKeyCode() == 82 && actionBar != null) {
                    if (!f3882a) {
                        try {
                            f3883b = actionBar.getClass().getMethod("onMenuKeyEvent", KeyEvent.class);
                        } catch (NoSuchMethodException unused) {
                        }
                        f3882a = true;
                    }
                    Method method = f3883b;
                    if (method != null) {
                        try {
                            Object invoke = method.invoke(actionBar, keyEvent);
                            if (invoke != null) {
                                z = ((Boolean) invoke).booleanValue();
                            }
                        } catch (IllegalAccessException | InvocationTargetException unused2) {
                        }
                    }
                    if (z) {
                        return true;
                    }
                }
            }
            if (window2.superDispatchKeyEvent(keyEvent)) {
                return true;
            }
            View decorView = window2.getDecorView();
            if (ViewCompat.m909b(decorView, keyEvent)) {
                return true;
            }
            if (decorView != null) {
                dispatcherState = decorView.getKeyDispatcherState();
            }
            return keyEvent.dispatch(activity, dispatcherState, activity);
        }
        if (callback instanceof Dialog) {
            Dialog dialog = (Dialog) callback;
            if (!f3884c) {
                try {
                    Field declaredField = Dialog.class.getDeclaredField("mOnKeyListener");
                    f3885d = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException unused3) {
                }
                f3884c = true;
            }
            Field field = f3885d;
            if (field != null) {
                try {
                    onKeyListener = (DialogInterface.OnKeyListener) field.get(dialog);
                } catch (IllegalAccessException unused4) {
                }
                if (onKeyListener == null && onKeyListener.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
                    return true;
                }
                window = dialog.getWindow();
                if (!window.superDispatchKeyEvent(keyEvent)) {
                    return true;
                }
                View decorView2 = window.getDecorView();
                if (ViewCompat.m909b(decorView2, keyEvent)) {
                    return true;
                }
                if (decorView2 != null) {
                    dispatcherState = decorView2.getKeyDispatcherState();
                }
                return keyEvent.dispatch(dialog, dispatcherState, dialog);
            }
            onKeyListener = null;
            if (onKeyListener == null) {
            }
            window = dialog.getWindow();
            if (!window.superDispatchKeyEvent(keyEvent)) {
            }
        } else {
            if ((view != null && ViewCompat.m909b(view, keyEvent)) || component.superDispatchKeyEvent(keyEvent)) {
                return true;
            }
            return false;
        }
    }
}
