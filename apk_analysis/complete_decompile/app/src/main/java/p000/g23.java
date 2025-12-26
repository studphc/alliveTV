package p000;

import android.view.Surface;
import androidx.annotation.DoNotInline;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.util.Log;

/* loaded from: classes.dex */
public abstract class g23 {
    @DoNotInline
    /* renamed from: a */
    public static void m4901a(Surface surface, float f) {
        int i;
        if (f == RecyclerView.f7068F0) {
            i = 0;
        } else {
            i = 1;
        }
        try {
            surface.setFrameRate(f, i);
        } catch (IllegalStateException e) {
            Log.m3024e("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e);
        }
    }
}
