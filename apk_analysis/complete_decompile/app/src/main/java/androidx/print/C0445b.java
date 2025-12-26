package androidx.print;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import androidx.print.PrintHelper;
import p000.l72;

/* renamed from: androidx.print.b */
/* loaded from: classes.dex */
public final class C0445b extends PrintDocumentAdapter {

    /* renamed from: a */
    public final String f6746a;

    /* renamed from: b */
    public final Uri f6747b;

    /* renamed from: c */
    public final PrintHelper.OnPrintFinishCallback f6748c;

    /* renamed from: d */
    public final int f6749d;

    /* renamed from: e */
    public PrintAttributes f6750e;

    /* renamed from: f */
    public AsyncTask f6751f;

    /* renamed from: g */
    public Bitmap f6752g = null;

    /* renamed from: h */
    public final /* synthetic */ PrintHelper f6753h;

    public C0445b(PrintHelper printHelper, String str, Uri uri, PrintHelper.OnPrintFinishCallback onPrintFinishCallback, int i) {
        this.f6753h = printHelper;
        this.f6746a = str;
        this.f6747b = uri;
        this.f6748c = onPrintFinishCallback;
        this.f6749d = i;
    }

    /* renamed from: a */
    public final void m1569a() {
        synchronized (this.f6753h.f6736c) {
            try {
                BitmapFactory.Options options = this.f6753h.f6735b;
                if (options != null) {
                    if (Build.VERSION.SDK_INT < 24) {
                        options.requestCancelDecode();
                    }
                    this.f6753h.f6735b = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.print.PrintDocumentAdapter
    public final void onFinish() {
        super.onFinish();
        m1569a();
        AsyncTask asyncTask = this.f6751f;
        if (asyncTask != null) {
            asyncTask.cancel(true);
        }
        PrintHelper.OnPrintFinishCallback onPrintFinishCallback = this.f6748c;
        if (onPrintFinishCallback != null) {
            onPrintFinishCallback.onFinish();
        }
        Bitmap bitmap = this.f6752g;
        if (bitmap != null) {
            bitmap.recycle();
            this.f6752g = null;
        }
    }

    @Override // android.print.PrintDocumentAdapter
    public final void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
        synchronized (this) {
            this.f6750e = printAttributes2;
        }
        if (cancellationSignal.isCanceled()) {
            layoutResultCallback.onLayoutCancelled();
        } else if (this.f6752g != null) {
            layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.f6746a).setContentType(1).setPageCount(1).build(), !printAttributes2.equals(printAttributes));
        } else {
            this.f6751f = new l72(this, cancellationSignal, printAttributes2, printAttributes, layoutResultCallback).execute(new Uri[0]);
        }
    }

    @Override // android.print.PrintDocumentAdapter
    public final void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
        this.f6753h.m1568d(this.f6750e, this.f6749d, this.f6752g, parcelFileDescriptor, cancellationSignal, writeResultCallback);
    }
}
