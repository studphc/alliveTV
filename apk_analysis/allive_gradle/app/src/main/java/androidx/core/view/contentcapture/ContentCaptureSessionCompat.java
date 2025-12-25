package androidx.core.view.contentcapture;

import android.os.Build;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewStructureCompat;
import androidx.core.view.autofill.AutofillIdCompat;
import java.util.List;
import java.util.Objects;
import p000.AbstractC1502l8;
import p000.AbstractC1664ov;
import p000.AbstractC1701pv;
import p000.AbstractC1738qv;

/* loaded from: classes.dex */
public class ContentCaptureSessionCompat {

    /* renamed from: a */
    public final Object f3973a;

    /* renamed from: b */
    public final View f3974b;

    public ContentCaptureSessionCompat(ContentCaptureSession contentCaptureSession, View view) {
        this.f3973a = contentCaptureSession;
        this.f3974b = view;
    }

    @NonNull
    @RequiresApi(29)
    public static ContentCaptureSessionCompat toContentCaptureSessionCompat(@NonNull ContentCaptureSession contentCaptureSession, @NonNull View view) {
        return new ContentCaptureSessionCompat(contentCaptureSession, view);
    }

    @Nullable
    public AutofillId newAutofillId(long j) {
        if (Build.VERSION.SDK_INT >= 29) {
            ContentCaptureSession m5876g = AbstractC1502l8.m5876g(this.f3973a);
            AutofillIdCompat autofillId = ViewCompat.getAutofillId(this.f3974b);
            Objects.requireNonNull(autofillId);
            return AbstractC1701pv.m6925a(m5876g, autofillId.toAutofillId(), j);
        }
        return null;
    }

    @Nullable
    public ViewStructureCompat newVirtualViewStructure(@NonNull AutofillId autofillId, long j) {
        if (Build.VERSION.SDK_INT >= 29) {
            return ViewStructureCompat.toViewStructureCompat(AbstractC1701pv.m6927c(AbstractC1502l8.m5876g(this.f3973a), autofillId, j));
        }
        return null;
    }

    public void notifyViewTextChanged(@NonNull AutofillId autofillId, @Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 29) {
            AbstractC1701pv.m6929e(AbstractC1502l8.m5876g(this.f3973a), autofillId, charSequence);
        }
    }

    public void notifyViewsAppeared(@NonNull List<ViewStructure> list) {
        int i = Build.VERSION.SDK_INT;
        Object obj = this.f3973a;
        if (i >= 34) {
            AbstractC1738qv.m7149a(AbstractC1502l8.m5876g(obj), list);
            return;
        }
        if (i >= 29) {
            ContentCaptureSession m5876g = AbstractC1502l8.m5876g(obj);
            View view = this.f3974b;
            ViewStructure m6926b = AbstractC1701pv.m6926b(m5876g, view);
            AbstractC1664ov.m6730a(m6926b).putBoolean("TREAT_AS_VIEW_TREE_APPEARING", true);
            AbstractC1701pv.m6928d(AbstractC1502l8.m5876g(obj), m6926b);
            for (int i2 = 0; i2 < list.size(); i2++) {
                AbstractC1701pv.m6928d(AbstractC1502l8.m5876g(obj), list.get(i2));
            }
            ViewStructure m6926b2 = AbstractC1701pv.m6926b(AbstractC1502l8.m5876g(obj), view);
            AbstractC1664ov.m6730a(m6926b2).putBoolean("TREAT_AS_VIEW_TREE_APPEARED", true);
            AbstractC1701pv.m6928d(AbstractC1502l8.m5876g(obj), m6926b2);
        }
    }

    public void notifyViewsDisappeared(@NonNull long[] jArr) {
        int i = Build.VERSION.SDK_INT;
        Object obj = this.f3973a;
        View view = this.f3974b;
        if (i >= 34) {
            ContentCaptureSession m5876g = AbstractC1502l8.m5876g(obj);
            AutofillIdCompat autofillId = ViewCompat.getAutofillId(view);
            Objects.requireNonNull(autofillId);
            AbstractC1701pv.m6930f(m5876g, autofillId.toAutofillId(), jArr);
            return;
        }
        if (i >= 29) {
            ViewStructure m6926b = AbstractC1701pv.m6926b(AbstractC1502l8.m5876g(obj), view);
            AbstractC1664ov.m6730a(m6926b).putBoolean("TREAT_AS_VIEW_TREE_APPEARING", true);
            AbstractC1701pv.m6928d(AbstractC1502l8.m5876g(obj), m6926b);
            ContentCaptureSession m5876g2 = AbstractC1502l8.m5876g(obj);
            AutofillIdCompat autofillId2 = ViewCompat.getAutofillId(view);
            Objects.requireNonNull(autofillId2);
            AbstractC1701pv.m6930f(m5876g2, autofillId2.toAutofillId(), jArr);
            ViewStructure m6926b2 = AbstractC1701pv.m6926b(AbstractC1502l8.m5876g(obj), view);
            AbstractC1664ov.m6730a(m6926b2).putBoolean("TREAT_AS_VIEW_TREE_APPEARED", true);
            AbstractC1701pv.m6928d(AbstractC1502l8.m5876g(obj), m6926b2);
        }
    }

    @NonNull
    @RequiresApi(29)
    public ContentCaptureSession toContentCaptureSession() {
        return AbstractC1502l8.m5876g(this.f3973a);
    }
}
