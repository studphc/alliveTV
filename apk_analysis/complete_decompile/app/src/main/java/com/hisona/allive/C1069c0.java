package com.hisona.allive;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.hisona.allive.BackgroundTask;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.observers.DisposableObserver;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import p000.t30;

/* renamed from: com.hisona.allive.c0 */
/* loaded from: classes2.dex */
public final class C1069c0 extends BackgroundTask {

    /* renamed from: a */
    public ProgressDialog f15978a;

    /* renamed from: b */
    public File f15979b;

    /* renamed from: c */
    public final String f15980c;

    public C1069c0(Activity activity, String str) {
        super(activity);
        this.f15980c = str;
    }

    @Override // com.hisona.allive.BackgroundTask
    public final void cancel() {
        DisposableObserver<BackgroundTask.ProgressOrResult> disposableObserver;
        Activity activity = this.mWeakReference.get();
        if (activity != null && !activity.isFinishing() && (disposableObserver = this.mObserver) != null && !disposableObserver.isDisposed()) {
            this.mObserver.dispose();
            Toast.makeText(activity, R.string.download_cancelled, 0).show();
        }
    }

    @Override // com.hisona.allive.BackgroundTask
    public final void doInBackground(ObservableEmitter observableEmitter) {
        File file;
        Activity activity = this.mWeakReference.get();
        String str = "v" + this.f15980c;
        String str2 = "https://github.com/HISONA/allive/releases/download/" + str + "/allive-" + str + "-release.apk";
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                file = activity.getCacheDir();
            } else {
                file = new File(Utils.getExternalStorageDirectory(activity));
            }
            File file2 = new File(file, "download.apk");
            if (file2.isFile()) {
                file2.delete();
            }
            HttpURLConnection connection = HttpRequest.get((CharSequence) str2, false, new Object[0]).trustAllHosts().trustAllCerts().connectTimeout(10000).userAgent(VersionChecker.getStringById(activity, R.string.USERAGENT)).getConnection();
            connection.connect();
            if (isCancelled(observableEmitter)) {
                return;
            }
            int contentLength = connection.getContentLength();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(connection.getInputStream(), 8192);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[1024];
            int i = -1;
            long j = 0;
            int i2 = -1;
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == i || isCancelled(observableEmitter)) {
                    break;
                }
                long j2 = j + read;
                int i3 = (int) ((100 * j2) / contentLength);
                if (i3 != i2) {
                    observableEmitter.onNext(new BackgroundTask.ProgressOrResult(i3, 3));
                    i2 = i3;
                }
                fileOutputStream.write(bArr, 0, read);
                j = j2;
                i = -1;
            }
            observableEmitter.onNext(new BackgroundTask.ProgressOrResult(100, 3));
            fileOutputStream.flush();
            fileOutputStream.close();
            bufferedInputStream.close();
            this.f15979b = file2;
            observableEmitter.onNext(new BackgroundTask.ProgressOrResult(-1, 1));
            observableEmitter.onComplete();
        } catch (Exception e) {
            if (isCancelled(observableEmitter)) {
                Log.e("VersionChecker", "DownloadPackage Error: RESULT_CANCEL");
                return;
            }
            Log.e("VersionChecker", "DownloadPackage err: " + e.getMessage());
            observableEmitter.onError(new Throwable());
        }
    }

    @Override // com.hisona.allive.BackgroundTask
    public final void onPostExecute(BackgroundTask.ProgressOrResult progressOrResult) {
        Uri fromFile;
        Activity activity = this.mWeakReference.get();
        if (activity != null && !activity.isFinishing()) {
            this.f15978a.dismiss();
            File file = this.f15979b;
            if (file == null) {
                Utils.showToast(activity, getString(R.string.download_failed));
                return;
            }
            try {
                int i = Build.VERSION.SDK_INT;
                if (i >= 24) {
                    fromFile = FileProvider.getUriForFile(activity, "com.hisona.allive.provider", file);
                    if (i >= 28) {
                        activity.grantUriPermission("com.google.android.packageinstaller", fromFile, 1);
                    }
                } else {
                    fromFile = Uri.fromFile(file);
                }
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.putExtra("android.intent.extra.NOT_UNKNOWN_SOURCE", true);
                intent.setFlags(1);
                intent.setDataAndType(fromFile, "application/vnd.android.package-archive");
                activity.startActivity(intent);
                System.exit(0);
            } catch (Exception e) {
                Log.e("VersionChecker", "DownloadPackage: " + e.toString());
            }
        }
    }

    @Override // com.hisona.allive.BackgroundTask
    public final void onPreExecute() {
        Activity activity = this.mWeakReference.get();
        ProgressDialog progressDialog = new ProgressDialog(activity);
        this.f15978a = progressDialog;
        progressDialog.setMessage(activity.getResources().getString(R.string.download_package));
        this.f15978a.setOnCancelListener(new t30(4, this));
        this.f15978a.show();
    }

    @Override // com.hisona.allive.BackgroundTask
    public final void onProgressUpdate(Integer num) {
        if (num.intValue() >= 0) {
            this.f15978a.setProgress(num.intValue());
        }
    }
}
