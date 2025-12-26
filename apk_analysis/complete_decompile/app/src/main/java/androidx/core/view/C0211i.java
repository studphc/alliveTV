package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import androidx.core.R;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import p000.v53;

/* renamed from: androidx.core.view.i */
/* loaded from: classes.dex */
public final class C0211i extends v53 {

    /* renamed from: f */
    public static final PathInterpolator f3987f = new PathInterpolator(RecyclerView.f7068F0, 1.1f, RecyclerView.f7068F0, 1.0f);

    /* renamed from: g */
    public static final FastOutLinearInInterpolator f3988g = new FastOutLinearInInterpolator();

    /* renamed from: h */
    public static final DecelerateInterpolator f3989h = new DecelerateInterpolator();

    /* renamed from: g */
    public static void m951g(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        WindowInsetsAnimationCompat.Callback m956l = m956l(view);
        if (m956l != null) {
            m956l.onEnd(windowInsetsAnimationCompat);
            if (m956l.getDispatchMode() == 0) {
                return;
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                m951g(viewGroup.getChildAt(i), windowInsetsAnimationCompat);
            }
        }
    }

    /* renamed from: h */
    public static void m952h(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsets windowInsets, boolean z) {
        WindowInsetsAnimationCompat.Callback m956l = m956l(view);
        if (m956l != null) {
            m956l.f3938a = windowInsets;
            if (!z) {
                m956l.onPrepare(windowInsetsAnimationCompat);
                if (m956l.getDispatchMode() == 0) {
                    z = true;
                } else {
                    z = false;
                }
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                m952h(viewGroup.getChildAt(i), windowInsetsAnimationCompat, windowInsets, z);
            }
        }
    }

    /* renamed from: i */
    public static void m953i(View view, WindowInsetsCompat windowInsetsCompat, List list) {
        WindowInsetsAnimationCompat.Callback m956l = m956l(view);
        if (m956l != null) {
            windowInsetsCompat = m956l.onProgress(windowInsetsCompat, list);
            if (m956l.getDispatchMode() == 0) {
                return;
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                m953i(viewGroup.getChildAt(i), windowInsetsCompat, list);
            }
        }
    }

    /* renamed from: j */
    public static void m954j(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsAnimationCompat.BoundsCompat boundsCompat) {
        WindowInsetsAnimationCompat.Callback m956l = m956l(view);
        if (m956l != null) {
            m956l.onStart(windowInsetsAnimationCompat, boundsCompat);
            if (m956l.getDispatchMode() == 0) {
                return;
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                m954j(viewGroup.getChildAt(i), windowInsetsAnimationCompat, boundsCompat);
            }
        }
    }

    /* renamed from: k */
    public static WindowInsets m955k(View view, WindowInsets windowInsets) {
        if (view.getTag(R.id.tag_on_apply_window_listener) != null) {
            return windowInsets;
        }
        return view.onApplyWindowInsets(windowInsets);
    }

    /* renamed from: l */
    public static WindowInsetsAnimationCompat.Callback m956l(View view) {
        Object tag = view.getTag(R.id.tag_window_insets_animation_callback);
        if (tag instanceof ViewOnApplyWindowInsetsListenerC0210h) {
            return ((ViewOnApplyWindowInsetsListenerC0210h) tag).f3985a;
        }
        return null;
    }
}
