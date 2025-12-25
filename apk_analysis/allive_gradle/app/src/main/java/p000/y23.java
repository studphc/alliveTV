package p000;

import android.content.ClipData;
import android.view.PointerIcon;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class y23 {
    @DoNotInline
    /* renamed from: a */
    public static void m8209a(@NonNull View view) {
        view.cancelDragAndDrop();
    }

    @DoNotInline
    /* renamed from: b */
    public static void m8210b(View view) {
        view.dispatchFinishTemporaryDetach();
    }

    @DoNotInline
    /* renamed from: c */
    public static void m8211c(View view) {
        view.dispatchStartTemporaryDetach();
    }

    @DoNotInline
    /* renamed from: d */
    public static void m8212d(@NonNull View view, PointerIcon pointerIcon) {
        view.setPointerIcon(pointerIcon);
    }

    @DoNotInline
    /* renamed from: e */
    public static boolean m8213e(@NonNull View view, @Nullable ClipData clipData, @NonNull View.DragShadowBuilder dragShadowBuilder, @Nullable Object obj, int i) {
        return view.startDragAndDrop(clipData, dragShadowBuilder, obj, i);
    }

    @DoNotInline
    /* renamed from: f */
    public static void m8214f(@NonNull View view, @NonNull View.DragShadowBuilder dragShadowBuilder) {
        view.updateDragShadow(dragShadowBuilder);
    }
}
