package androidx.print;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import androidx.print.PrintHelper;

/* renamed from: androidx.print.a */
/* loaded from: classes.dex */
public final class C0444a extends PrintDocumentAdapter {

    /* renamed from: a */
    public final String f6740a;

    /* renamed from: b */
    public final int f6741b;

    /* renamed from: c */
    public final Bitmap f6742c;

    /* renamed from: d */
    public final PrintHelper.OnPrintFinishCallback f6743d;

    /* renamed from: e */
    public PrintAttributes f6744e;

    /* renamed from: f */
    public final /* synthetic */ PrintHelper f6745f;

    public C0444a(PrintHelper printHelper, String str, int i, Bitmap bitmap, PrintHelper.OnPrintFinishCallback onPrintFinishCallback) {
        this.f6745f = printHelper;
        this.f6740a = str;
        this.f6741b = i;
        this.f6742c = bitmap;
        this.f6743d = onPrintFinishCallback;
    }

    @Override // android.print.PrintDocumentAdapter
    public final void onFinish() {
        PrintHelper.OnPrintFinishCallback onPrintFinishCallback = this.f6743d;
        if (onPrintFinishCallback != null) {
            onPrintFinishCallback.onFinish();
        }
    }

    @Override // android.print.PrintDocumentAdapter
    public final void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
        this.f6744e = printAttributes2;
        layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.f6740a).setContentType(1).setPageCount(1).build(), !printAttributes2.equals(printAttributes));
    }

    @Override // android.print.PrintDocumentAdapter
    public final void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
        this.f6745f.m1568d(this.f6744e, this.f6741b, this.f6742c, parcelFileDescriptor, cancellationSignal, writeResultCallback);
    }
}
