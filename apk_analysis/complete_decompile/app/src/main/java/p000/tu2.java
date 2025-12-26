package p000;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.R;

/* loaded from: classes.dex */
public final class tu2 {

    /* renamed from: a */
    public final Context f26966a;

    /* renamed from: b */
    public final View f26967b;

    /* renamed from: c */
    public final TextView f26968c;

    /* renamed from: d */
    public final WindowManager.LayoutParams f26969d;

    /* renamed from: e */
    public final Rect f26970e;

    /* renamed from: f */
    public final int[] f26971f;

    /* renamed from: g */
    public final int[] f26972g;

    public tu2(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f26969d = layoutParams;
        this.f26970e = new Rect();
        this.f26971f = new int[2];
        this.f26972g = new int[2];
        this.f26966a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.abc_tooltip, (ViewGroup) null);
        this.f26967b = inflate;
        this.f26968c = (TextView) inflate.findViewById(R.id.message);
        layoutParams.setTitle(tu2.class.getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R.style.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }
}
