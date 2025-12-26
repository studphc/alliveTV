package p000;

import android.view.ContentInfo;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnReceiveContentListener;

/* loaded from: classes.dex */
public abstract class d33 {
    @Nullable
    @DoNotInline
    /* renamed from: a */
    public static String[] m4519a(@NonNull View view) {
        return view.getReceiveContentMimeTypes();
    }

    @Nullable
    @DoNotInline
    /* renamed from: b */
    public static ContentInfoCompat m4520b(@NonNull View view, @NonNull ContentInfoCompat contentInfoCompat) {
        ContentInfo contentInfo = contentInfoCompat.toContentInfo();
        ContentInfo performReceiveContent = view.performReceiveContent(contentInfo);
        if (performReceiveContent == null) {
            return null;
        }
        if (performReceiveContent == contentInfo) {
            return contentInfoCompat;
        }
        return ContentInfoCompat.toContentInfoCompat(performReceiveContent);
    }

    @DoNotInline
    /* renamed from: c */
    public static void m4521c(@NonNull View view, @Nullable String[] strArr, @Nullable OnReceiveContentListener onReceiveContentListener) {
        if (onReceiveContentListener == null) {
            view.setOnReceiveContentListener(strArr, null);
        } else {
            view.setOnReceiveContentListener(strArr, new e33(onReceiveContentListener));
        }
    }
}
