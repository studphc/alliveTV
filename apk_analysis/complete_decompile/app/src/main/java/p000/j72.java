package p000;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.pdf.PdfDocument;
import android.os.AsyncTask;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.pdf.PrintedPdfDocument;
import android.util.Log;
import androidx.print.PrintHelper;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public final class j72 extends AsyncTask {

    /* renamed from: a */
    public final /* synthetic */ CancellationSignal f20397a;

    /* renamed from: b */
    public final /* synthetic */ PrintAttributes f20398b;

    /* renamed from: c */
    public final /* synthetic */ Bitmap f20399c;

    /* renamed from: d */
    public final /* synthetic */ PrintAttributes f20400d;

    /* renamed from: e */
    public final /* synthetic */ int f20401e;

    /* renamed from: f */
    public final /* synthetic */ ParcelFileDescriptor f20402f;

    /* renamed from: g */
    public final /* synthetic */ PrintDocumentAdapter.WriteResultCallback f20403g;

    /* renamed from: h */
    public final /* synthetic */ PrintHelper f20404h;

    public j72(PrintHelper printHelper, CancellationSignal cancellationSignal, PrintAttributes printAttributes, Bitmap bitmap, PrintAttributes printAttributes2, int i, ParcelFileDescriptor parcelFileDescriptor, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
        this.f20404h = printHelper;
        this.f20397a = cancellationSignal;
        this.f20398b = printAttributes;
        this.f20399c = bitmap;
        this.f20400d = printAttributes2;
        this.f20401e = i;
        this.f20402f = parcelFileDescriptor;
        this.f20403g = writeResultCallback;
    }

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] objArr) {
        RectF rectF;
        float min;
        PrintAttributes printAttributes = this.f20398b;
        PrintHelper printHelper = this.f20404h;
        CancellationSignal cancellationSignal = this.f20397a;
        ParcelFileDescriptor parcelFileDescriptor = this.f20402f;
        Bitmap bitmap = this.f20399c;
        try {
            if (cancellationSignal.isCanceled()) {
                return null;
            }
            PrintedPdfDocument printedPdfDocument = new PrintedPdfDocument(printHelper.f6734a, printAttributes);
            Bitmap m1565a = PrintHelper.m1565a(bitmap, printAttributes.getColorMode());
            if (cancellationSignal.isCanceled()) {
                return null;
            }
            try {
                PdfDocument.Page startPage = printedPdfDocument.startPage(1);
                boolean z = PrintHelper.f6733h;
                if (z) {
                    rectF = new RectF(startPage.getInfo().getContentRect());
                } else {
                    PrintedPdfDocument printedPdfDocument2 = new PrintedPdfDocument(printHelper.f6734a, this.f20400d);
                    PdfDocument.Page startPage2 = printedPdfDocument2.startPage(1);
                    RectF rectF2 = new RectF(startPage2.getInfo().getContentRect());
                    printedPdfDocument2.finishPage(startPage2);
                    printedPdfDocument2.close();
                    rectF = rectF2;
                }
                int width = m1565a.getWidth();
                int height = m1565a.getHeight();
                int i = this.f20401e;
                Matrix matrix = new Matrix();
                float f = width;
                float width2 = rectF.width() / f;
                if (i == 2) {
                    min = Math.max(width2, rectF.height() / height);
                } else {
                    min = Math.min(width2, rectF.height() / height);
                }
                matrix.postScale(min, min);
                matrix.postTranslate((rectF.width() - (f * min)) / 2.0f, (rectF.height() - (height * min)) / 2.0f);
                if (!z) {
                    matrix.postTranslate(rectF.left, rectF.top);
                    startPage.getCanvas().clipRect(rectF);
                }
                startPage.getCanvas().drawBitmap(m1565a, matrix, null);
                printedPdfDocument.finishPage(startPage);
                if (cancellationSignal.isCanceled()) {
                    printedPdfDocument.close();
                    if (parcelFileDescriptor != null) {
                        try {
                            parcelFileDescriptor.close();
                        } catch (IOException unused) {
                        }
                    }
                    if (m1565a == bitmap) {
                        return null;
                    }
                } else {
                    printedPdfDocument.writeTo(new FileOutputStream(parcelFileDescriptor.getFileDescriptor()));
                    printedPdfDocument.close();
                    try {
                        parcelFileDescriptor.close();
                    } catch (IOException unused2) {
                    }
                    if (m1565a == bitmap) {
                        return null;
                    }
                }
                m1565a.recycle();
                return null;
            } finally {
            }
        } catch (Throwable th) {
            return th;
        }
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        Throwable th = (Throwable) obj;
        boolean isCanceled = this.f20397a.isCanceled();
        PrintDocumentAdapter.WriteResultCallback writeResultCallback = this.f20403g;
        if (isCanceled) {
            writeResultCallback.onWriteCancelled();
        } else if (th == null) {
            writeResultCallback.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
        } else {
            Log.e("PrintHelper", "Error writing printed content", th);
            writeResultCallback.onWriteFailed(null);
        }
    }
}
