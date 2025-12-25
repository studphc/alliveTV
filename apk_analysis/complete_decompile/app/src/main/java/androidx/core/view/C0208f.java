package androidx.core.view;

import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.R;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* renamed from: androidx.core.view.f */
/* loaded from: classes.dex */
public final class C0208f {

    /* renamed from: d */
    public static final ArrayList f3977d = new ArrayList();

    /* renamed from: a */
    public WeakHashMap f3978a;

    /* renamed from: b */
    public SparseArray f3979b;

    /* renamed from: c */
    public WeakReference f3980c;

    /* renamed from: b */
    public static boolean m949b(View view, KeyEvent keyEvent) {
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((ViewCompat.OnUnhandledKeyEventListenerCompat) arrayList.get(size)).onUnhandledKeyEvent(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* renamed from: a */
    public final View m950a(View view, KeyEvent keyEvent) {
        WeakHashMap weakHashMap = this.f3978a;
        if (weakHashMap != null && weakHashMap.containsKey(view)) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View m950a = m950a(viewGroup.getChildAt(childCount), keyEvent);
                    if (m950a != null) {
                        return m950a;
                    }
                }
            }
            if (m949b(view, keyEvent)) {
                return view;
            }
        }
        return null;
    }
}
