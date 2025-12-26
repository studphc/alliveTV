package p000;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.contentcapture.ContentCaptureSession;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.contentcapture.ContentCaptureSessionCompat;
import java.util.List;

/* loaded from: classes.dex */
public abstract class b33 {
    @DoNotInline
    /* renamed from: a */
    public static View.AccessibilityDelegate m2008a(View view) {
        return view.getAccessibilityDelegate();
    }

    @DoNotInline
    /* renamed from: b */
    public static ContentCaptureSession m2009b(View view) {
        return view.getContentCaptureSession();
    }

    @DoNotInline
    /* renamed from: c */
    public static List<Rect> m2010c(View view) {
        return view.getSystemGestureExclusionRects();
    }

    @DoNotInline
    /* renamed from: d */
    public static void m2011d(@NonNull View view, @NonNull Context context, @NonNull int[] iArr, @Nullable AttributeSet attributeSet, @NonNull TypedArray typedArray, int i, int i2) {
        view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i, i2);
    }

    @DoNotInline
    /* renamed from: e */
    public static void m2012e(View view, ContentCaptureSessionCompat contentCaptureSessionCompat) {
        ContentCaptureSession contentCaptureSession;
        if (contentCaptureSessionCompat == null) {
            contentCaptureSession = null;
        } else {
            contentCaptureSession = contentCaptureSessionCompat.toContentCaptureSession();
        }
        view.setContentCaptureSession(contentCaptureSession);
    }

    @DoNotInline
    /* renamed from: f */
    public static void m2013f(View view, List<Rect> list) {
        view.setSystemGestureExclusionRects(list);
    }
}
